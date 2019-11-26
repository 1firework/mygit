package other;

import user.User;
import utility.XMLUtility;
import factory.*;
import java.text.SimpleDateFormat;

import java.text.SimpleDateFormat;
import java.util.*;

public class TelcomUser {
private String phoneNumber;
private String callTo;
private TreeSet callToNumbersSet;
private ArrayList communicationRecords;

User ZUser;

public TelcomUser(String phoneNumber) {
	this.phoneNumber=phoneNumber;
	this.communicationRecords=new ArrayList();
	this.callToNumbersSet = new TreeSet();
	Factory factory=(Factory)XMLUtility.getBean();
	ZUser=factory.produceRecord();
	
	}
public void generateCommunicateRecords() {
	int recordNum=new Random().nextInt(10);
	for(int i=0;i<=recordNum;i++) {
		this.callTo = getcallToPhoneNumber();
		this.callToNumbersSet.add(this.callTo);
		long timeStart = System.currentTimeMillis() - new Random().nextInt(36000000);
		long timeEnd = timeStart + 60000 + new Random().nextInt(600000);
		//long timeStart=System.currentTimeMillis()-new Random().nextInt(36000000);
		//long timeEnd=timeStart+60000+new Random().nextInt(60000);
		this.communicationRecords.add(this.phoneNumber+","+timeStart+","+timeEnd+","+this.callTo+";");
	}
}
private String getcallToPhoneNumber() {
	return "1380372000"+String.valueOf(new Random().nextInt(10));
}
private String accountFee(long timeStart,long timeEnd) {
	
	double feePerMinute=ZUser.getfeePerMinute();
	
	int minutes = Math.round((timeEnd-timeStart)/60000);
	double feeTotal=feePerMinute * minutes;
	return String.format("%.4f",feeTotal);
}
public void printCallToNumber() {
	System.out.println("--------今天都被这些号码呼叫了---------");
	for(Object callTo:this.callToNumbersSet) {
		System.out.println((String)callTo);
	}
}

public void printDetails() {
	
	int arrayListSize=this.communicationRecords.size(); 

	for(int i=0;i<arrayListSize-1;i++) {

		String [] recordField = ((String)this.communicationRecords .get(i)).split(",");

		System.out.println("主叫："+recordField[0]);

		System.out.println("被叫："+recordField[3]);

		Date timeStart = new Date(Long.parseLong(recordField[1]));
		Date timeEnd = new Date(Long.parseLong(recordField[2]));			
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
		
		//SimpleDateFormat			
		System.out.println("通话开始时间：" + simpleDateFormat.format(timeStart));
		System.out.println("通话结束时间：" + simpleDateFormat.format(timeEnd));
		
		System.out.println("计费："+accountFee(Long.parseLong(recordField[1]),Long.parseLong(recordField[2]))+"元");

	}

		
	}
	
}
