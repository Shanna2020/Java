import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientCall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
int port= 8100;
String host = "localhost";
DataInputStream dIn= null;
DataOutputStream dOut = null;

Socket socket = null;

try {
	 socket =  new Socket(host, port);
	 dIn= new DataInputStream(socket.getInputStream());
	 dOut= new DataOutputStream(socket.getOutputStream());
	
	Scanner scanner = new Scanner(System.in);
	char choice;
	System.out.print("Client Connected..... \n");
	do {
	System.out.print("Enter your choice (d-date) | (t-time) | (x-exit): ");
	choice = scanner.nextLine().charAt(0);
	dOut.writeChar(choice);
	String result = dIn.readUTF();
	System.out.println(result);
	}while(Character.toUpperCase(choice) !='X');
	
	//closing scanner and socket
	scanner.close();
	socket.close();
}catch(IOException e){}

	}

}
