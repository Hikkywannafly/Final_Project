package server.rmi;

import model.OOP.Account;
import model.OOP.Book;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IServer extends Remote {
   public boolean checkLogin(Account Account) throws RemoteException;
   public boolean checkRegister(Account Account) throws RemoteException;
   public  List<Book> getAll() throws RemoteException;
   public  boolean insert(Book Book) throws RemoteException;
   public  void update(Book Book) throws RemoteException;
   public  void delete(Book Book) throws RemoteException;
   public String text(String text) throws RemoteException;
   public int dataa() throws RemoteException;
}
