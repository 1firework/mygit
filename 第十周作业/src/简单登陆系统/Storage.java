package 简单登陆系统;

public class Storage {
	private String[] cells=new String[101];
	private int inPos=1,outPos=1;
	private int count;
	public synchronized void put(int num,int sleepSecond) {
		try {
			 while(count==cells.length) {
				 this.wait();
			 }
			 cells[inPos]=String.valueOf(num);
			 System.out.println("第"+inPos+"位用户"+cells[inPos]+"正在登陆!");
			 inPos++;
			 if(inPos==cells.length) {
				 inPos=0;
			 }
			 count++;
			 System.out.println("现在共有"+count+"位用户----正在在线!");
			 Thread.sleep(sleepSecond);
			 this.notify();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public synchronized void get(int sleepSecond) {
		try {
			while(count==0) {
				this.wait();
			}
			String younghu="a";
			System.out.println("第"+outPos+"位用户"+cells[outPos]+"正在注销!");
			cells[outPos]=younghu;
			outPos++;
			if(outPos==cells.length) {
				outPos=0;
			}
			System.out.println("现在共有"+count--+"位用户----正在在线!");
			Thread.sleep(sleepSecond);
			 this.notify();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
