package com.example.demo.study;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendDemo {
    public static void main(String[] args) throws IOException {
        // 创建发送端Socket服务对象
        DatagramSocket ds = new DatagramSocket();

        // 创建数据，并把数据打包
        String str = "hello,udp,我来了";
        // public DatagramPacket(byte[] buf,int length,InetAddress address,int
        // port)
        byte[] bys = str.getBytes();
        int length = bys.length;
        InetAddress address = InetAddress.getByName("192.168.0.104");
        int port = 12306;
        DatagramPacket dp = new DatagramPacket(bys, length, address, port);

        // 发送数据
        // public void send(DatagramPacket p)
        ds.send(dp);

        // 释放资源
        ds.close();
    }
}
