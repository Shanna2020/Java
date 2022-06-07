import java.io.*;
import java.io.IOException;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DemoSocket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int port =8100;
		ServerSocket server = null;
		Socket socket = null;
		DataInputStream dIn=null;
		DataOutputStream dOut = null;
		
		try {
			char choice;
			server = new ServerSocket(port);
			System.out.println("Server is running and waiting  for client...");
			socket = server.accept();
			
			InetAddress cAddress = socket.getInetAddress();
			System.out.println("Host Name: "+ cAddress.getHostName());
			System.out.println("Host Name: "+ cAddress.getHostAddress());

			//getting input and output stream
			dIn = new DataInputStream(socket.getInputStream());
			dOut= new DataOutputStream(socket.getOutputStream());
			
			SimpleDateFormat fDate=null;
			Date dNow=null;
			
			//Display information based on choice
			do {
			 choice = dIn.readChar();
			
			switch(choice) {
			
			case 'd':
			case 'D':
				dNow = new Date();
				fDate = new SimpleDateFormat("yyyy.MM.dd");
				dOut.writeUTF("System Date: "+ fDate.format(dNow));	
				break;
			case 't':
			case 'T':
				dNow = new Date();
				fDate = new SimpleDateFormat("hh:mm:ss a");
				dOut.writeUTF("System Time: "+ fDate.format(dNow));	
				break;
			case 'x':
			case 'X':
				dOut.writeUTF("Good Bye");
				break;
				
			default:
				dOut.writeUTF("Invalid Choie--> "+ choice);
				break;
		}
			}while(Character.toUpperCase(choice) !='X');
			socket.close();
			server.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
