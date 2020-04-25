import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatClient{

	private String host;
	private int port;

	public static void main(String[] args) throws IOException, UnknownHostException {
		
		//creates server on port 8888 of localhost
		new ChatClient("127.0.0.1", 8888).run();
	}
	

	public ChatClient(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public void run() throws UnknownHostException, IOException {
	  
		//connects user to server
		Socket ChatClient = new Socket(host, port);
		System.out.println("User has connected to the server. Say hi!");

		//get socket output stream
		PrintStream output = new PrintStream(ChatClient.getOutputStream());

		//when user connects, ask for userName
		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter a userName: ");
		String userName = userInput.nextLine();
		output.println(userName);

		//creates new thread when a new user connects
		new Thread(new ReceivedMessagesHandler(ChatClient.getInputStream())).start();

		//Begins chat log, new line for each message
		System.out.println("Messages: \n");
		while (userInput.hasNextLine()) {
			output.println(userInput.nextLine());
		}
    
		//close
		output.close();
		userInput.close();
		ChatClient.close();
	}
}

class ReceivedMessagesHandler implements Runnable {
	
	private InputStream server;

	public ReceivedMessagesHandler(InputStream server) {
		this.server = server;
  }

  public void run() {
	  
    //prints out messages to server
    Scanner userInput = new Scanner(server);
    String placeHolder = "";
    while (userInput.hasNextLine()) {
      placeHolder = userInput.nextLine();
      
      //Prints out the updated userlist when someone joins the server
      if (placeHolder.charAt(0) == '[') {
    	  
        placeHolder = placeHolder.substring(1, placeHolder.length()-1);
        System.out.println("\nConnected Users: " +

            new ArrayList<String>(Arrays.asList(placeHolder.split(","))) + "\n"
            
            );
      }
    }
    userInput.close();
  }

}