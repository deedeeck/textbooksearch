package textbooksearch;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TextbookSearchServer extends Remote {
//input : course code (int)
//output: boolean (true for success, false for failure)
public boolean search(int courseCode)
throws RemoteException;
//input : course code (int)
//output: Textbook for the course (String)
public String getTextbook(int courseCode)
throws RemoteException;
//input : textbook (String)
//output: Number of Available copies (int)
public int checkCopies(String textbook)
throws RemoteException;
}
