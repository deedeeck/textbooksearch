//write the actual methods here
package textbooksearch;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextbookSearchServerImpl extends UnicastRemoteObject implements TextbookSearchServer 
{

public TextbookSearchServerImpl() throws RemoteException {
  }
//input : course code (int)
//output: boolean (true for success, false for failure)
public boolean search(int courseCode) throws RemoteException
{
	boolean found;
	found = false;
	try {
	BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ACER\\Desktop\\textbooksearch\\course.txt"));
    String line;
	
	while ((line = br.readLine()) != null)
	{
		Integer coursecodetxt = Integer.valueOf(line);
		if(coursecodetxt.equals(courseCode))
		//if(coursecodetxt == courseCode)
			{
			found = true;
			System.out.println("search<> : course code " + courseCode + " ==> " + found);
			return found;
			}
	}
	br.close();
	System.out.println("search<> : course code " + courseCode + " ==> " + found);
	System.out.println();
	return found;
	}
	catch (IOException e)
	{
    e.printStackTrace();   
	}
	
	//Scanner scanner = new Scanner(file);
	/*
	while(scanner.hasNextLine())
	{
		System.out.println("file number = " + scanner.nextInt());
		//Integer coursecodetxt = Integer.valueOf(scanner.nextInt());
		int coursecodetxt = scanner.nextInt();
		System.out.println("number that you are reading : " + coursecodetxt);
		//if(coursecodetxt.equals(courseCode))
		if(coursecodetxt == courseCode)
			{
			found = true;
			System.out.println("search<> : course code " + courseCode + " ==> " + found);
			return found;
			}
	}
	scanner.close();
	System.out.println("search<> : course code " + courseCode + " ==> " + found);
	return found;
	} 
	catch (FileNotFoundException e) 
	{
         e.printStackTrace();
     }
	 */
	/*
	if (found)
	{
	System.out.println("search<> : course code " + courseCode + " ==> " + found);
	return found;
	}
	else
	{
	found = false;
	System.out.println("search<> : course code " + courseCode + " ==> " + found);
	return found;
	}
	*/
	return found;
}
//input : course code (int)
//output: Textbook for the course (String)
public String getTextbook(int courseCode) throws RemoteException
{
	String bookName = null;
	int countentry = 0; //to count textbook's entry in course.txt
	try {
	BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ACER\\Desktop\\textbooksearch\\course.txt"));
    String line;
	
	while ((line = br.readLine()) != null)
	{
		Integer coursecodetxt = Integer.valueOf(line);
		countentry++;
		if(coursecodetxt == courseCode)
		break;
	}
	br.close();
	
	BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\ACER\\Desktop\\textbooksearch\\textbook.txt"));
    String line2;
	while (countentry > 0)
	{
		bookName = br2.readLine();
		countentry--;
	
		if( bookName == null)
		{
		bookName = null;
		break;
		}
	}
	br2.close();
	
	if (bookName == null)
	{
		System.out.println("getTextBook<> : " + courseCode + " is \"Textbook not available\" ");
		System.out.println();
	}
		else
		System.out.println("getTextBook<> : " + courseCode + " is \"" + bookName + "\"");
	
	}
		catch (IOException e)
		{
		e.printStackTrace();   
		}
	return bookName;
}
//input : textbook (String)
//output: Number of Available copies (int)
public int checkCopies(String textbook) throws RemoteException
{
	int num_copies = 0;
	String wordArray[] = textbook.split("\\s+");
	num_copies = wordArray.length;
	System.out.println("checkCopies<> : " + textbook + " --> " + num_copies + " copies");
	System.out.println();
	return num_copies;
}
}
