public class Exercise04{
public static void main(String[] args){
Taxi t=new Taxi();
new Thread(t,"出租车 1").start();
new Thread(t,"出租车 2").start();
new Thread(t,"出租车 3").start();
new Thread(t,"出租车 4").start();
new Thread(t,"出租车 5").start();
}
}
class Taxi implements Runnable{
private int person=100;
public void run(){
while(true){
if(person>0){
Thread th=Thread.currentThread();
String th_name=th.getName();
System.out.println(th_name+"正在送第"+person--+"人");
}
}
}
}