package server.rmi;

import model.AccountDAO;
import model.BookDAO;
import model.OOP.Account;
import model.OOP.Book;
import model.XMLController;
import model.testFun;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class SeverIMP extends UnicastRemoteObject implements IServer{
    private BookDAO bookDAO;
    private AccountDAO accountDAO;
    private testFun tf;
    private XMLController xml;

    protected SeverIMP() throws RemoteException {
        super();
        bookDAO = new BookDAO();
        accountDAO = new AccountDAO();
        xml = new XMLController();
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
    public boolean update(Book Book) throws RemoteException {
        return bookDAO.update(Book);
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

    @Override
    public void createXML(List<Book> BL) throws RemoteException, ParserConfigurationException, TransformerException {
            xml.createXML(BL);

    }

    @Override
    public List<Book> readXMl(String file) throws RemoteException {
        return xml.readXMl(file);
    }

}
