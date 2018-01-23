package com.service.impl;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class SocketServer
{
    public static void main(String[] args)
    {
        
        try
        {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(9999));
            System.out.println("服务开启-----");
            while (true)
            {
                SocketChannel socketChannel = serverSocketChannel.accept();
                
                if (socketChannel != null)
                {
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    int bytesRead = socketChannel.read(buf);
                    System.out.println("Read " + bytesRead);
                    buf.flip();
                    
                    while (buf.hasRemaining())
                    {
                        System.out.print((char)buf.get());
                    }
                    buf.clear();
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("over-----------");
    }
}
