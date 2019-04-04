import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;

public class sVector extends UnicastRemoteObject implements iVector {

  public sVector() throws RemoteException {
    super();
  }

  public float prodEscalar(float[] u, float[] v) throws RemoteException {
    float res=0;
    for (int i=0; i<u.length; ++i) {
      res+=u[i]*v[i];
    }
    return res;
  }

	public float[] prodporescalar(float[] u, float k) throws RemoteException {
    float[] res = new float[u.length];
    for (int i=0; i<u.length; ++i) {
      res[i]=u[i]*k;
    }
    return res;
  }

	public float [] vecSuma(float[] u, float[] v) throws RemoteException {
    float[] res = new float[u.length];
    for (int i=0; i<u.length; ++i) {
      res[i]=u[i]*v[i];
    }
    return res;
  }

	public float vectModulo(float[] u) throws RemoteException {
    float res=0;
    for (int i=0; i<u.length; ++i) {
      res+=u[i];
    }
    return (float)Math.sqrt(res);
  }


  public static void main(String[] args) throws Exception{
    iVector obj = new sVector();
    // Naming.rebind("//localhost:2010/Vector", obj);
    Naming.rebind("Vector", obj);
    System.out.println("Servidor listo");
  }
}
