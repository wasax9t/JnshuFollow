

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cn.yxy.dbc_pool.DBPool;
import cn.yxy.dbc_pool.DBPoolThread;

public class InsertHuge {
	private static DBPool dp=new DBPool(10,30);
	private static ExecutorService es = Executors.newFixedThreadPool(11);
	
	public static void main(String[] args){
//		long a=System.currentTimeMillis();
		insert(1000000);
//		long b=System.currentTimeMillis();
//		System.out.println(b-a);
		
	}
	public static void insert(long n){
		for(int i=0;i<n;i++){
			es.execute(new DBPoolThread("T"+i,dp));
		}
		es.shutdown();
	}
}
