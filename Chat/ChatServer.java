import java.io.*;
import java.net.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;



public class ChatServer {

	private int port;
	private List<User> users;
	private ServerSocket ChatServer;

	public static void main(String[] args) throws IOException {
		new ChatServer(8888).run();
	}

	public ChatServer(int port) {
		this.port = port;
		this.users = new ArrayList<User>();
	}

	public void run() throws IOException {
	  
		ChatServer = new ServerSocket(port) {
			protected void finalize() throws IOException {
				this.close();
			}
		};
    
		System.out.println("Port is open!");
		
		//while the port is open
		while (true) {
    	
			//accepts a new user
			Socket client = ChatServer.accept();

			// get username of a new user
			String userName = (new Scanner (client.getInputStream())).nextLine();
			System.out.println(userName + "has joined!");

			// create new User
			User newUser = new User(client, userName);

			// add newUser message to list
			this.users.add(newUser);

			//create a new thread for newUser incoming messages handling
			new Thread(new UserHandler(this, newUser)).start();
    
		}//end while loop
	}//end run

  //Alerts sever of a new user
	public void broadcastMessages(String message, User userSender) {
		for (User client : this.users) {
			client.getOutputStream().println(
					userSender.toString() + message);
		}
	}

	// send list of users to all Users
	public void broadcastToChat(){
		for (User client : this.users) {
			client.getOutputStream().println(this.users);
		}
	}
}

class UserHandler implements Runnable {

	private ChatServer ChatServer;
	private User user;

	public UserHandler(ChatServer ChatServer, User user) {
		this.ChatServer = ChatServer;
		this.user = user;
		this.ChatServer.broadcastToChat();
	}

	public void run() {
	  
		String message;
		// when there is a new message, broadcast to all
		Scanner sc = new Scanner(this.user.getInputStream());
		while (sc.hasNextLine()) {
			message = sc.nextLine();
		}
		// end of Thread
		this.ChatServer.broadcastToChat();
		sc.close();
	}
}

class User {
	
	private String userName;
	private Socket client;
	private PrintStream streamOut;
	private InputStream streamIn;

	public User(Socket client, String name) throws IOException {
		this.streamOut = new PrintStream(client.getOutputStream());
		this.streamIn = client.getInputStream();
		this.client = client;
		this.userName = name;
	}
  
	public PrintStream getOutputStream(){
		return this.streamOut;
	}

	public InputStream getInputStream(){
		return this.streamIn;
	}

	public String getUserName(){
		return this.userName;
	}
	}
