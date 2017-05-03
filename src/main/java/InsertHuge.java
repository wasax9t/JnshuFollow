

import cn.yxy.dbc_pool.DBPool;
import cn.yxy.dbc_pool.DBPoolThread;

public class InsertHuge {
	public static void main(String[] args){
		DBPool dp=new DBPool(4,20);
		for(int i=0;i<1000;i++){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			new DBPoolThread("T"+i,dp).start();
		}
		
	}
}
