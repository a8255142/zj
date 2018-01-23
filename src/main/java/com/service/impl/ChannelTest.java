package com.service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelTest
{
    public static void main(String[] args)
        throws FileNotFoundException
    {
        RandomAccessFile aFile;
        try
        {
            aFile = new RandomAccessFile("e:/hello.txt", "rw");
            FileChannel inChannel = aFile.getChannel();
            
            ByteBuffer buf = ByteBuffer.allocate(1024);
            
            int bytesRead = inChannel.read(buf);
            while (bytesRead != -1)
            {
                
                System.out.println("Read " + bytesRead);
                buf.flip();
                
                while (buf.hasRemaining())
                {
                    System.out.print((char)buf.get());
                }
                buf.clear();
                buf.put("速度发个梵蒂冈".getBytes());
                bytesRead = inChannel.read(buf);
            }
            aFile.close();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
