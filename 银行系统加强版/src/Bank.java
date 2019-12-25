import java.util.Scanner;

public class Bank {
	
     int account;
     private static User user;
     
     public static void main(String[] args) throws Exception{
    	 Bank bank=new Bank();
    	 System.out.println("欢迎进入网上银行系统！");
    	 while(true) {
    		System.out.println("请输入您的操作：1-登录，2-注册，0-退出");
    	    Scanner is=new Scanner(System.in);
    	    int num=is.nextInt();
    	    switch(num) {
    	    case 1:
    	    	bank.login();
    	    	bank.operate();
    	    case 2:
    	    	bank.register();
    	    	System.out.println("是否保存注册信息？请输入yes或no");
    	    	Scanner ins=new Scanner(System.in);
    	        String str=ins.nextLine();
    	        if(str.equals("yes")) {
    	        	bank.save();
    	        	System.out.println("保存成功！");
    	        }else {
    	        	System.out.println("输入的信息有误！请重新输入");
    	        	continue;
    	        }
    	        break;
    	    case 0:
    	    	return;
    	    default:
    	    	System.out.println("请输入0~2之间的数字选择相关操作！");
    	    	break;
    	    } 
    	 }
    	 
     }
     
     public void login() throws Exception{
    	 DBUtil dbutil = DBUtil.getInstance();
    	 System.out.println("欢迎登录网上银行系统！");
    	 while(true) {
    		 Scanner in = new Scanner(System.in);
    		 System.out.println("请输入银号卡号：");
    		 String cardId = in.nextLine();
    		 System.out.println("请输入银号密码：");
    		 String cardPwd = in.nextLine();
    		 user = dbutil.getUser(cardId);
    		 //登陆---------
    		 if( dbutil.getUsers().containsKey(cardId)&&user.getCardPwd().equals(cardPwd)) {
    			 System.out.println("登陆成功，欢迎"+user.getUserName()+"先生");
    			 break;
    		 }else {
    			 System.out.println("银行卡号或密码错误！");
    			 continue;
    		 }
    	 }
     }
     public void operate() throws Exception{
    	 Bank bank=new Bank();
    	 DBUtil dbutil=DBUtil.getInstance();
    	 while(true){
    		 System.out.println("请输入您要进行的操作类型，按回车键结束！");
    		 System.out.println("存款：1"+"\t"+"取款：2"+"\t"+"余额：3"+"\t"+"退出：0");
    		 Scanner number=new Scanner(System.in);
    		 int num1 = number.nextInt();
    		 if(num1==1||num1==2){
    			 int num=0;
    			 try{
    				 System.out.print("请输入取款金额:");
    				 num = number.nextInt();         // Integer.parseInt(str.nextLine());
    			 }catch(Exception e){
    				 System.out.println("金额输入错误！");
    				 continue;
    			 }
    			 switch(num1) {
    			 case 1:
    				 bank.inCome(num);//存款操作
    				 break;
    			 case 2:
    				 bank.takeOut(num);//取款操作
    				 break;
    			 }
    		 }else if(num1==3) {
    			 bank.show();
    		 }else if(num1==0) {
    			 System.out.println("退出系统！");
    			 dbutil.update();
    			 System.exit(0);
    			 //break;
    		 }else {
    			 System.out.println("请输入0~3之间的数字选择相关操作！");
    		 }
    	 }
     }
     /*
     public void operate(){
    	 Bank bank=new Bank();
    	 while(true){
    		 System.out.println("请输入您要进行的操作类型，按回车键结束！");
    		 System.out.println("存款：1"+"\t"+"取款：2"+"\t"+"余额：3"+"\t"+"退出：0");
    		 Scanner str=new Scanner(System.in);
    		 String s = str.nextLine();
    		 if("1".equals(s)||"2".equals(s)){
    			 int num=0;
    			 try{
    				 System.out.print("请输入取款金额:");
    				 num = Integer.parseInt(str.nextLine());
    			 }catch(Exception e){
    				 System.out.println("金额输入错误！");
    				 continue;
    			 }
    			 switch(s) {
    			 case "1":
    				 bank.inCome(num);//存款操作
    				 break;
    			 case "2":
    				 bank.takeOut(num);//取款操作
    				 break;
    			 }
    		 }else if("3".equals(s)) {
    			 bank.show();
    		 }else if("0".equals(s)) {
    			 System.out.println("退出系统！");
    			 return;
    		 }else {
    			 System.out.println("请输入0~3之间的数字选择相关操作！");
    		 }
    	 }
     }
     */
     public void register() throws Exception {
    	 User u=new User();
    	 Scanner scanner=new Scanner(System.in);
    	 System.out.println("输入卡号：");
    	 u.setCardId(scanner.nextLine());
    	 System.out.println("输入用户名：");
    	 u.setUseName(scanner.nextLine());
    	 System.out.println("输入密码：");
    	 u.setCardPwd(scanner.nextLine());
    	 System.out.println("输入手机号：");
    	 u.setCall(scanner.nextLine());
    	 System.out.println("输入存款金额：");
    	 u.setAmount(scanner.nextInt());
    	 DBUtil dbutil = DBUtil.getInstance();
    	 dbutil.addUser(u);
     }
     public void save() throws Exception {
    	 DBUtil dbutil=DBUtil.getInstance();
    	 dbutil.update();
     }
     public void inCome(int num) {
    	 account=user.getAccount()+num;
    	 user.setAmount(account);
		//System.out.println(account);
     }
     public void takeOut(int num) {
    	 account=user.getAccount()-num;
    	 user.setAmount(account);
    	 //System.out.println(account);
     }
     public void show() {
    	 account=user.getAccount();
    	 user.setAmount(account);
    	 System.out.println(account);
     }
}