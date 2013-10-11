package textbooksearch;
import java.util.Scanner;
import java.rmi.*;

// for client
public class Main {

  public static void main(String args[]) {
    try {
      String input = "Dummy";
      String TextbookSearchServerURL;
      TextbookSearchServerURL = "rmi://" + args[0] + "/TextbookSearchServer";
	  // args0 is the ip address
	  // Addserver is the name of the server

      // Obtain a reference to that remote object
	  
      TextbookSearchServer textbookSearchServer ;
      textbookSearchServer  = (TextbookSearchServer) Naming.lookup(TextbookSearchServerURL);
	  
	Scanner mysc = new Scanner(System.in);
	//System.out.println("Enter course code <'Q' or 'q' to exit>: ");
	
	
	while(!((input.equals("q"))|| (input.equals("Q"))))
	{
		System.out.println("Enter course code <'Q' or 'q' to exit>: ");
		input = mysc.next();
		
		if((input.equals("q"))|| (input.equals("Q")))
		break;
		
		Integer coursecode = Integer.valueOf(input);
		boolean search = textbookSearchServer.search(coursecode);
		//System.out.println(search);
		if (search)
		System.out.println("Course code " + input + " found");
		else
		{
		System.out.println("Course code not found");
		System.out.println();
		continue;
		}
	
	
	String textbookname = textbookSearchServer.getTextbook(coursecode);
	if (textbookname == null)
	{
	System.out.println("Textbook for Course Code " + coursecode + " is not available");
	System.out.println();
	continue;
	}
	else
	System.out.println("Textbook for Course Code " + coursecode + " is \"" + textbookname + "\"");
	
	int num_books = textbookSearchServer.checkCopies(textbookname);
	System.out.println("There are " + num_books + " copies of Textbook \"" + textbookname + "\"");
	
	System.out.println();
	}
	System.out.println("Terminated. Exiting...");
	
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
