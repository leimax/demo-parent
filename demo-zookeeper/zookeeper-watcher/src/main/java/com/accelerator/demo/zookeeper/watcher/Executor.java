package com.accelerator.demo.zookeeper.watcher;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;

public class Executor implements Watcher, Runnable, DataMonitor.DataMonitorListener {

	private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(Executor.class);

	DataMonitor dm;

	ZooKeeper zk;

	public Executor(String hostPort, String znode) throws KeeperException, IOException {
		zk = new ZooKeeper(hostPort, 3000, this);
		dm = new DataMonitor(zk, znode, this);
	}

	public static void main(String[] args) {
		String hostPort = "192.168.60.111:2181";
		String znode = "/test";
		try {
			new Executor(hostPort, znode).run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void process(WatchedEvent event) {
		dm.process(event);
	}

	public void run() {
		try {
			synchronized (this) {
				while (!dm.dead) {
					wait();
				}
			}
		} catch (InterruptedException e) {
		}
	}

	public void closing(int rc) {
		synchronized (this) {
			notifyAll();
		}
	}

	public void exists(byte[] data) {
		if (data != null) {
			LOG.info(new String(data));
		}
	}
}