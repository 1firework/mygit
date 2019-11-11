package �򵥵�½ϵͳ;
import java.util.Random;
public class Input implements Runnable{
	private Storage st;
	private Random r=new Random();
	private Random sleepSecond=new Random();
	Input(Storage st){
		this.st=st;
	}
	public void run() {
		while(true) {
			st.put(r.nextInt(100),sleepSecond.nextInt(2000));
		}
	}
}
