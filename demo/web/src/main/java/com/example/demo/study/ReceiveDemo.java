package com.example.demo.study;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReceiveDemo {
    public static void main(String[] args) throws IOException {
        // 创建接收端Socket服务对象
        // DatagramSocket(int port)
        DatagramSocket ds = new DatagramSocket(12306);

        // 创建数据包(接收容器)
        // public DatagramPacket(byte[] buf,int length)
        byte[] bys = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bys, bys.length);

        // 调用接收方法
        // public void receive(DatagramPacket p)
        ds.receive(dp);

        // 解析数据包,把数据显示在控制台
        // public InetAddress getAddress()
        InetAddress address = dp.getAddress();
        String ip = address.getHostAddress();

        // public byte[] getData()
        byte[] bys2 = dp.getData();
        // public int getLength()
        int length = dp.getLength();

        String s = new String(bys2, 0, length);
        System.out.println(ip + "***" + s);

        // 释放资源
        ds.close();
    }
}
