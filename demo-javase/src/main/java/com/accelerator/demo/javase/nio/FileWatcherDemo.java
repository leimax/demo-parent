package com.accelerator.demo.javase.nio;

import java.io.IOException;
import java.nio.file.*;

public class FileWatcherDemo {

    public static void main(String[] args) throws IOException, InterruptedException {
        FileSystem fileSystem = FileSystems.getDefault();
        WatchService watchService = fileSystem.newWatchService();
        Paths.get("C:/").register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);
        while (true) {
            WatchKey key = watchService.take();
            for (WatchEvent<?> event : key.pollEvents()) {
                System.out.println(event.context() + "发生了" + event.kind() + "事件");
            }
            if (!key.reset()) {
                break;
            }
        }
    }

}
