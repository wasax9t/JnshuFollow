package cn.yxy.dbc_pool;

public class DBPoolTest {
	public static void main(String[] args){
		DBPool dp=new DBPool(3,10);
		for(int i=0;i<100;i++){
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
