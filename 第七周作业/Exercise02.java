public class Exercise02{
public static void main(String [] args){
MyThread myThread=new MyThread();
myThread.start();
for(int i=1;i<=100;i++){
System.out.println("main");
}
}
}
class MyThread extends Thread{
private int i=1;
public void run(){
for(int i=1;i<=50;i++){
System.out.println("new");
}
}
}
