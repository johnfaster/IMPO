package com.example.demo.study;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddrssdDemo {
    public static void main(String[] args) throws UnknownHostException {
        // InetAddress address = InetAddress.getByName("liuyi");
        // InetAddress address = InetAddress.getByName("192.168.3.100");
        InetAddress address = InetAddress.getByName("192.168.0.104");

        // public String getHostAddress()
        String ip = address.getHostAddress();
        // public String getHostName()
        String name = address.getHostName();
        System.out.println(ip + "***" + name);
    }
}
