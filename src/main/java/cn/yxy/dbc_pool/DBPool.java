package cn.yxy.dbc_pool;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class DBPool {
	private List<Connection> connPool;
	private int initSize;
	private int maxSize;
	private int currentSize;

	public DBPool(int initSize, int maxSize) {
		this.initSize = initSize;
		this.maxSize = maxSize;
		this.currentSize = this.initSize;
		connPool = new ArrayList<Connection>();
		addConn(initSize);
	}

	public synchronized Connection getConn() {
		Connection conn = null;
		if (connPool.isEmpty()) {
			handle();
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		conn = connPool.remove(0);
		return conn;
	}

	public synchronized void givebackConn(Connection conn) {
		connPool.add(conn);
		this.notify();
	}

	private void handle() {
		int gap = maxSize - currentSize;
		if (gap == 0) return;
		int step = maxSize / 10;
		if (gap >= step) {
			addConn(5);
			currentSize+=5;
		}
		if (gap<step && gap>0) {
			addConn(1);
			currentSize++;
		}
	}
	private void addConn(int n) {
		try {
			for (int i = 0; i < n; i++) {
				connPool.add(MySQLUnit.getConn());
			}
//			System.out.println("add DBPool over");
		} catch (Exception e) {
			System.out.println("When DBconnection getting:");
			e.printStackTrace();
		}
	}
}
