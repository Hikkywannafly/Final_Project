package server.rmi;


import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


public class Server {
    public static void main(String[] args) {
        String serviceName = "rmi://localhost:3308/test";

        try {

            IServer serverIMP = new SeverIMP();
            LocateRegistry.createRegistry(3308);
            Naming.bind(serviceName, serverIMP);
            System.out.println("Service is running");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}



