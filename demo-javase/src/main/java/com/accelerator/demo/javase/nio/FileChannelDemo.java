package com.accelerator.demo.javase.nio;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo {

    public static void main(String[] args) throws Exception {
        Resource resource = new ClassPathResource("nio-data.txt");
        String name = resource.getURI().getPath();
        RandomAccessFile aFile = new RandomAccessFile(name, "rw");
        FileChannel inChannel = aFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(48);
        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {
            System.out.println("Read " + bytesRead);
            buf.flip();
            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());
            }
            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }

}
