package server.rmi;

import model.OOP.Account;
import model.OOP.Book;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IServer extends Remote {
   public boolean checkLogin(Account Account) throws RemoteException;
   public boolean checkRegister(Account Account) throws RemoteException;
   public  List<Book> getAll() throws RemoteException;
   public  boolean insert(Book Book) throws RemoteException;
   public  boolean update(Book Book) throws RemoteException;
   public  void delete(Book Book) throws RemoteException;
   public String text(String text) throws RemoteException;
   public int dataa() throws RemoteException;
   public  void createXML(List<Book> BL) throws RemoteException, ParserConfigurationException, TransformerException;
   public  List<Book> readXMl(String file) throws RemoteException;
}
