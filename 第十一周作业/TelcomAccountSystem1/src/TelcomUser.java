
import java.util.*;
public class TelcomUser {
	public String phonenumber;//主叫
	public String callTo;//被叫
	public StringBuffer communicationRecords;
	public TelcomUser(String phonenumber) {
		this.phonenumber=phonenumber;
		this.callTo = getCallToPhoneNumber();
		this.communicationRecords=new StringBuffer();
		//通话记录存在communicationRecords里，分号相隔，每条记录内部有主叫号码，被叫号码，开始时间，结束时间
	}
	//模拟通话记录的生成
	void createCommunicateRecord() {
		//随机生成通话记录数目
		int recordNum=new Random().nextInt(10);
		for(int i=0;i<=recordNum;i++) {
			//第i条通话记录，随机生成
			//开始时间，当前时间之前的某个随机时间
			long timeStart = System.currentTimeMillis()-new Random().nextInt(36000000);
			//结束时间，开始后的十分钟内随机的一个时间，至少一分钟
			long timeEnd = timeStart+60000+new Random().nextInt(600000);
			//被叫号码，随机生成（后四位随机）并返回
			this.callTo= getCallToPhoneNumber();
			//插入通话记录
			this.communicationRecords.append(this.phonenumber+
					","+timeStart+
					","+timeEnd+
					","+this.callTo+
					";");
		}
	}
	public String getCallToPhoneNumber() {
		return "1346043" + String.valueOf(new Random().nextInt(10))
		+String.valueOf(new Random().nextInt(10))
		+String.valueOf(new Random().nextInt(10))
		+String.valueOf(new Random().nextInt(10));
	}
	//模拟计费方法，以字符串的形式返回保留4位小数的计费结果
	public String accountFee(long timeStart,long timeEnd) {
		//每分钟收费*元
		double feePerMinute=0.2;
		//通话分钟数按四舍五入计算
		int minutes=Math.round((timeEnd-timeStart)/60000);
		double feeTotal=feePerMinute*minutes;
		return String.format("%.4f",feeTotal);
	}
	//打印通话记录
	void printDetails() {
		//获取全部通话记录
		String allRecords=this.communicationRecords.toString();
		//分割通话记录
		String [] recordArray=allRecords.split(";");
		//循环分割记录内的每一项输出
		for(int i=0;i<recordArray.length;i++) {
			String [] recordField=recordArray[i].split(",");
			System.out.println("主叫："+recordField[0]);
			System.out.println("被叫："+recordField[3]);
			System.out.println("通话开始时间："+new Date(Long.parseLong(recordField[1])));
			System.out.println("通话结束时间："+new Date(Long.parseLong(recordField[2])));
			System.out.println("计费："+accountFee(Long.parseLong(recordField[1]),Long.parseLong(recordField[2]))+
					"元");
		}
	}
}