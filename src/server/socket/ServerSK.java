package server.socket;

import model.OOP.Peer;
import view.ConfigView;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerSK{
    private  ArrayList<Peer> dataPeer = null;
    private ServerSocket server;
    private Socket connection;
    private ObjectOutputStream obOutputClient;
    private ObjectInputStream obInputStream;
    public boolean isStop = false, isExit = false;
    private static int portServer;

    public ArrayList<Peer> getListUser() {
        return dataPeer;
    }

    public ServerSK(int port) throws Exception {
        server = new ServerSocket(port);
        dataPeer = new ArrayList<Peer>();
        portServer = port;
        (new WaitForConnect()).start();
    }

    public ServerSK() {

    }
    public void closeServer() throws Exception {
        isStop = true;
        server.close();
        connection.close();
    }
    private boolean waitForConnection() throws Exception {
        connection = server.accept();
        obInputStream = new ObjectInputStream(connection.getInputStream());
        Peer msg = new Peer();
         msg = (Peer) obInputStream.readObject();
        if (msg != null) {
            saveNewPeer(msg.getName(), connection.getInetAddress().toString(), msg.getPort());
            ConfigView.updateUser();
            }
        else{
            int size = dataPeer.size();
            checkExit(dataPeer, msg);
            if (size != dataPeer.size()) {
                isExit = true;
                ConfigView.decreaseUser();
            }
        }

        return true;
        }
    public ArrayList<Peer> checkExit(ArrayList<Peer> dataPeer,Peer msg) throws Exception {
        for(Peer peer : dataPeer){
            System.out.println(peer);
        }


        return dataPeer;
        }
    private void saveNewPeer(String user, String ip, int port) throws Exception {
        Peer newPeer = new Peer();
        if (dataPeer.size() == 0)
            dataPeer = new ArrayList<Peer>();
        newPeer.setPeer(user, ip, port);
        dataPeer.add(newPeer);
    }



    public class WaitForConnect extends Thread {

        @Override
        public void run() {
            super.run();
            try {
                while (!isStop) {
                    if (waitForConnection()) {
                        if (isExit)
                        {
                            isExit = false;
                        } else
                        {
                            obOutputClient = new ObjectOutputStream(connection.getOutputStream());
                            obOutputClient.flush();
                            obOutputClient.close();
                        }

                    } else
                    {
                        obOutputClient = new ObjectOutputStream(connection.getOutputStream());
                        obOutputClient.flush();
                        obOutputClient.close();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
