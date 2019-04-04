Monitor monitorimpresion
	var
		i, impresoras: integer;
		estadoimpresora: array [1..3] of Boolean;
		imp: condition;

	procedure pedir_imp (var n: integer)
		begin
			if impresoras==0 then wait(imp);
			n:=1;
			while(!estadoimpresora[n]) do n:=n+1;
			estadoimpresora[n]:=false;
			impresoras--;
			send(imp);
		end

	procedure dejar_imp (var n: integer)
		begin
      if impresoras==3 then wait(imp);
			n:=1;
			while(estadoimpresora[n]) do n:=n+1;
			estadoimpresora[n]:=true;
			impresoras++;
			send(imp);
		end

	begin (*inicialización*)
		for i=1 to 3 do
			estadoimpresora[i]:=true;
		impresoras:=3;
	end
