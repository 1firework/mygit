public class Exercise03{
public static void main(String[] args){
Teacher t = new Teacher();
new Thread(t, "A��ʦ ").start();
new Thread(t, "B��ʦ ").start();
new Thread(t, "C��ʦ ").start();
}
}
class Teacher implements Runnable{
private int notes=80;
public void run(){
while (true){
if(notes>0){
Thread th=Thread.currentThread();
String th_name=th.getName();
System.out.println(th_name+"���ڷ���"+notes--+"���Ծ�");
}
}
}
}
