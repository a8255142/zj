package com.service.impl;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketClient
{
    public static void main(String[] args)
    {
        SocketChannel socketChannel;
        try
        {
            socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 9999));
            String newData = "New String to write to file..." + System.currentTimeMillis();
            
            ByteBuffer buf = ByteBuffer.allocate(48);
            buf.clear();
            buf.put(newData.getBytes());
            
            buf.flip();
            
            while (buf.hasRemaining())
            {
                socketChannel.write(buf);
            }
            
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
