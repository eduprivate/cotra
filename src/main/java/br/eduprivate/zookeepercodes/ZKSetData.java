package br.eduprivate.zookeepercodes;

import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;

import java.io.IOException;

public class ZKSetData {
	
   private static ZooKeeper zk;
   private static ZooKeeperConnection conn;

   // Method to update the data in a znode. Similar to getData but without watcher.
   public static void update(String path, byte[] data) throws
      KeeperException,InterruptedException {
      zk.setData(path, data, zk.exists(path,true).getVersion());
   }

   public static void main(String[] args) throws InterruptedException,KeeperException {
      String path= "/MyFirstZnode";
      byte[] data = "Success".getBytes(); //Assign data which is to be updated.
		
      try {
         conn = new ZooKeeperConnection();
         zk = conn.connect("localhost");
         update(path, data); // Update znode data to the specified path
      } catch(Exception e) {
         System.out.println(e.getMessage());
      }
   }
}