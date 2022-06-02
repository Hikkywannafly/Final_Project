package server.rmi;

import model.OOP.Account;
import view.Login;

import javax.swing.*;
import java.rmi.Naming;

public class test {
    public static void main(String[] args) {
        String serviceName = "rmi://localhost:3307/test";
        IServer serverIMP;
        try {
            serverIMP = (IServer) Naming.lookup(serviceName);
            System.out.println(serverIMP.text("sadsa"));
            System.out.println(serverIMP.dataa());
            Account acc = new Account("asdasd","asdasd", "asdasd" , " asdasd");
            try{
                System.out.println(serverIMP.checkRegister(acc));

            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
