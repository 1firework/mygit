public class Exercise03{
public static void main(String[] args){
Teacher t = new Teacher();
new Thread(t, "A老师 ").start();
new Thread(t, "B老师 ").start();
new Thread(t, "C老师 ").start();
}
}
class Teacher implements Runnable{
private int notes=80;
public void run(){
while (true){
if(notes>0){
Thread th=Thread.currentThread();
String th_name=th.getName();
System.out.println(th_name+"正在发第"+notes--+"张试卷");
}
}
}
}
