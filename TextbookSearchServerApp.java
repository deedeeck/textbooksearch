package textbooksearch;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.Naming;

public class TextbookSearchServerApp {

  public static void main(String args[]) {
    try {
      TextbookSearchServerImpl textbookSearchServerImpl;
      textbookSearchServerImpl = new TextbookSearchServerImpl();
      Naming.rebind("TextbookSearchServer", textbookSearchServerImpl);
      System.out.println("TextbookSearchServer Started \n");
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}

