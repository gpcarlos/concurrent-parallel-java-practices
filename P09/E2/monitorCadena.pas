Monitor monitorCadena
    var 
        i,j,buffer,fila,columna,producto: integer;
        buffer_1: array [1..100][1..10][1..10] of Int;
        buffer_2: array [1..50][1..10][1..10] of Int;
        matriz: array [1..10][1..10] of Int;
        b1,b2,b3,b4: boolean;
        espera: condition;

    procedure extraer(i: integer, buffer: integer)
        begin
            if(buffer==0)
                for fila=1 to 10 do
                    for columna=1 to 10 do
                        matriz[fila][columna]:=buffer_1[i][fila][columna];
            else
                for fila=1 to 10 do
                    for columna=1 to 10 do
                        matriz[fila][columna]:=buffer_2[i][fila][columna];
        end

    procedure insertar(i: integer, buffer: integer)
        begin
            if(buffer==0)
                for fila=1 to 10 do
                    for columna=1 to 10 do
                        buffer_1[i][fila][columna]:=matriz[fila][columna];
            else
                for fila=1 to 10 do
                    for columna=1 to 10 do
                        buffer_2[i][fila][columna]:=matriz[fila][columna];
        end

    procedure procesoA
        begin
            for i=1 to 100 do
                for fila=1 to 10 do
                    for columna=1 to 10 do
                        matriz[fila][columna]:=random();
                insertar(i,0);
            b1:=true;
            send(espera);
        end

    procedure procesoB
        begin
            if b1==false then wait(espera);
            auxiliar: array [1..10][1..10] of Int;
            for i=1 to 50 do
                extraer(i,0);
                for fila=1 to 10 do
                    for columna=1 to 10 do
                        auxiliar[columna][fila]:=matriz[columna][fila];
                for fila=1 to 10 do
                    for columna=1 to 10 do
                        matriz[columna][fila]:=auxiliar[fila][columna];
                insertar(i,1);
            b2:=true;
            send(espera);
            if(b3==false) then wait(espera)
            j:=0;
            for i=50 to 100 do
                extraer(i,0);
                for fila=1 to 10 do
                    for columna=1 to 10 do
                        auxiliar[columna][fila]:=matriz[columna][fila];
                for fila=1 to 10 do
                    for columna=1 to 10 do
                        matriz[columna][fila]:=auxiliar[fila][columna];
                insertar(i,j);
                j:=j+1;        
            b4:=true;
            send(espera);
        end

    procedure procesoC
        begin
            if(b2==false) then wait(espera);
            for i=1 to 50 do
                extraer(i,1);
                producto:=1;
                for fila=1 to 10 do
                    for columna=1 to 10 do
                        if fila==columna then
                            producto:=producto*matriz[fila][columna];
                print(producto);
            
            b3:=true;
            send(espera);

            if(b4==false) then wait(espera);
            for i=1 to 50 do
                extraer(i,1);
                producto:=1;
                for fila=1 to 10 do
                    for columna=1 to 10 do
                        if fila==columna then
                            producto:=producto*matriz[fila][columna];
                print(producto);
        end

    begin (*inicialización*)
        b1:=false;
        b2:=false;
        b3:=false;
        b4:=false;
    end
