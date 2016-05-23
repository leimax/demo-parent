package com.accelerator.demo.zookeeper.path;

import com.accelerator.demo.zookeeper.Constants;
import org.apache.zookeeper.*;
import org.apache.zookeeper.ZooDefs.Ids;

import java.io.IOException;

public class MainTest implements Watcher {

	public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
		ZooKeeper zk = new ZooKeeper(Constants.ZK_HOSTS, 3000, new MainTest());
		System.out.println("=========创建节点===========");
		if (zk.exists("/app", false) == null) {
			zk.create("/app", "app".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			zk.create("/app/no1", "app_ano1".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		}
		System.out.println("=============查看节点是否安装成功===============");
		System.out.println(new String(zk.getData("/app/no1", false, null)));

		System.out.println("=========修改节点的数据==========");
		zk.setData("/app/no1", "app_set".getBytes(), -1);
		System.out.println("========查看修改的节点是否成功=========");
		System.out.println(new String(zk.getData("/app", false, null)));

		System.out.println("=======删除节点==========");
		zk.delete("/app", -1);
		System.out.println("==========查看节点是否被删除============");
		System.out.println("节点状态：" + zk.exists("/app", false));
		zk.close();
	}

	@Override
	public void process(WatchedEvent event) {
		System.out.println(event);
	}

}
