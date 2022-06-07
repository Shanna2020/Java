import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RunClass implements Runnable{
	
	DataInputStream dIn=null;
	DataOutputStream dOut = null;
	Socket socket=null;
	int i;
	
	public RunClass(Socket socket, int i) 
	{
		this.socket=socket;
		this.i=i;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		
		try {
		char choice;
		InetAddress cAddress = socket.getInetAddress();
		System.out.println("Host Name: "+i + cAddress.getHostName());
		System.out.println("Host Name: "+i+ cAddress.getHostAddress());

		dIn = new DataInputStream(socket.getInputStream());
		dOut= new DataOutputStream(socket.getOutputStream());
		SimpleDateFormat fDate=null;
		Date dNow=null;
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
			dOut.writeUTF("System Date: "+ fDate.format(dNow));	
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
		
		
	}catch(IOException e) {
		e.printStackTrace();
	}
		
	}
	

}
