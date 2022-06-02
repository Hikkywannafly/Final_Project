package server.rmi;

import model.AccountDAO;
import model.BookDAO;
import model.OOP.Account;
import model.OOP.Book;
import model.testFun;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class SeverIMP extends UnicastRemoteObject implements IServer{
    private BookDAO bookDAO;
    private AccountDAO accountDAO;
    private testFun tf;

    protected SeverIMP() throws RemoteException {
        super();
        bookDAO = new BookDAO();
        accountDAO = new AccountDAO();
        tf = new testFun();
    }
    private static final long serialVersionUID = 1L;
    @Override
    public boolean checkLogin(Account Account) throws RemoteException {
        return accountDAO.checkLogin(Account);
    }

    @Override
    public boolean checkRegister(Account Account) throws RemoteException {
        return accountDAO.checkRegister(Account);
    }
    @Override
    public List<Book> getAll() throws RemoteException {
        return bookDAO.getAll();
    }

    @Override
    public boolean insert(Book Book) throws RemoteException {
        return bookDAO.insert(Book);
    }

    @Override
    public void update(Book Book) throws RemoteException {
        bookDAO.update(Book);
    }


    @Override
    public void delete(Book Book) throws RemoteException {
        bookDAO.delete(Book);
    }

    @Override
    public String text(String text) throws RemoteException {
        return text + "jello";
    }

    @Override
    public int dataa() throws RemoteException {
        return tf.dataa();
    }
}
