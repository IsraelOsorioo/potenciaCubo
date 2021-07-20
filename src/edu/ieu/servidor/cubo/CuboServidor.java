package edu.ieu.servidor.cubo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CuboServidor {
	public void iniciar() 
	{
        ServerSocket servidor;
        boolean fin = false;
        	try {
        		servidor = new ServerSocket(6000);
        		System.out.println("Servidor escuchando en el puerto 6000...");
        
        		Socket socketManejoCliente = servidor.accept();
        		DataInputStream in= new DataInputStream(socketManejoCliente.getInputStream());
        		DataOutputStream out = new DataOutputStream(socketManejoCliente.getOutputStream());
        do 
        {
        Double numero =0d;
        numero = in.readDouble();
        System.out.println("El servidor recibio del cliente: "+ numero);
        
        out.writeDouble(numero*numero*numero);
        System.out.println("Se envio el numero: " + numero*numero*numero);
        
        	if (numero.equals(".")) 
        	{
        		fin= true;
        		System.out.println("Servidor apagado: ");
        	}
        }while(!fin);
        
        in.close();
        out.close();
        socketManejoCliente.close();
        servidor.close();
        
        	}catch (IOException e) {
        	e.printStackTrace();
        	}
		}
	
	public static void main(String args[]) 
	{
		CuboServidor servidor = new CuboServidor();
		servidor.iniciar();
	} 
} 







