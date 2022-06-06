package model.OOP;

import java.io.Serializable;

public class Peer implements Serializable  {
    private static final long serialVersionUID = 1L;
    private String namePeer = "";
    private String hostPeer = "";
    private int portPeer = 0;

    public void setPeer(String name, String host, int port) {
        namePeer = name;
        hostPeer = host;
        portPeer = port;
    }

    public Peer(String namePeer, String hostPeer, int portPeer) {
        this.namePeer = namePeer;
        this.hostPeer = hostPeer;
        this.portPeer = portPeer;
    }
    public Peer(String namePeer, int portPeer) {
        this.namePeer = namePeer;
        this.portPeer = portPeer;
    }

    public Peer() {

    }
    public void setName(String name) {
        namePeer = name;
    }

    public void setHost(String host) {
        hostPeer = host;
    }

    public void setPort(int port) {
        portPeer = port;
    }

    public String getName() {
        return namePeer;
    }

    public String getHost() {
        return hostPeer;
    }

    public int getPort() {
        return portPeer;
    }
}

