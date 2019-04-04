// Ejercicio Febrero 16-17

#include <iostream>
#include <thread>
#include <atomic>
#include <mutex>
#include <chrono>
#include <ctime>
#include <vector>

class Cont{
public:
  int cont_;
  std::atomic<int> contAtomic_;
  std::mutex mut;

  Cont(int c): cont_(c) { contAtomic_.store(c);}

  void incrementaMutex();
  void incrementaAtomico();
};

void Cont::incrementaMutex() {
  mut.lock();
    cont_++;
  mut.unlock();
}

void Cont::incrementaAtomico() {
  contAtomic_++;
}

int main() {
  Cont contador(0);

  std::chrono::time_point<std::chrono::system_clock> start, end;
  std::chrono::duration<double, std::ratio<1> > tiempoMut, tiempoAto;
  int nThreads = 20;

  std::cout << "Iteraciones --- Mutex --- Atomic" << std::endl;

  for (int i = 5000; i < 20000; i+=1000) {
    std::vector<std::thread> threadsMut;
    std::vector<std::thread> threadsAto;

    // --- MUTEX ---
    start = std::chrono::system_clock::now();
    for (int k = 0; k < nThreads; k++) {
      threadsMut.push_back(std::thread([&contador, i] () {
        for (int m = 0; m < i; m++) {
          contador.incrementaMutex();
        }
      }));
    }
    for (auto& h: threadsMut) h.join();
    end = std::chrono::system_clock::now();

    tiempoMut = end - start;

    // --- ATOMIC ---
    start = std::chrono::system_clock::now();
    for (int k = 0; k < nThreads; k++) {
      threadsAto.push_back(std::thread([&contador, i] () {
        for (int m = 0; m < i; m++) {
          contador.incrementaAtomico();
        }
      }));
    }
    for (auto& h: threadsAto) h.join();
    end = std::chrono::system_clock::now();

    tiempoAto = end - start;

    std::cout << i << " --- " << tiempoMut.count() << "s --- " << tiempoAto.count() << "s "<< std::endl;

  }
}
