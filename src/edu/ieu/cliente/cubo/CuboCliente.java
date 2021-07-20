package edu.ieu.cliente.cubo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class CuboCliente {

	private BufferedReader entradaTeclado = new BufferedReader(new InputStreamReader(System.in));
	private Socket socket;
	private DataOutputStream out;
	private DataInputStream in;	
			
	public void conectar() 
	{
		byte[]mensaje_bytes =  new byte[256];
		Double numero = 0d;
		
		try {
			socket = new Socket ("localhost",6000);
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			System.out.println("Cliente iniciado");
			do 
			{
				System.out.println("Escribe un numero para el servidor: ");
				numero =Double.parseDouble(entradaTeclado.readLine()) ;
				
				out.writeDouble(numero);
				System.out.println("Numero enviado: " + numero);
				
				Double respuesta = in.readDouble();
				System.out.println("La potencia al cubo es: "+ respuesta);
				
			}while(!numero.equals(".") );
			
			in.close();
			out.close();
			socket.close();
			System.out.println("Conexion finalizada...");
			
			} catch (IOException e) {
			e.printStackTrace();
		}
	}
				
	public static void main (String args[]) 
	{
		CuboCliente cliente = new CuboCliente();
		cliente.conectar();
	}
}









