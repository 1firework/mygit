package dao;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import biz.CourseBiz;
import biz.SCBiz;
import entity.Course;
import entity.IEntity;
import entity.SC;
import entity.Student;

public class SCDao implements IDao{
	
	private static SCDao instance;
	private HashMap<String, IEntity> scs;
	private SC sc;
	private FileInputStream fs;
    private FileOutputStream fos;
    
    private SCDao() {
    	scs = new HashMap<String,IEntity>();
		sc = new SC();
    	getSCFormInputStream("sc2.txt");
    }
    private void getSCFormInputStream(String isName){
   	 try {
			fs=new FileInputStream(isName);
			byte[] content=new byte[1024];
			int i=0;
			int conInteger=0;
			while(true) {
				try {
					conInteger=fs.read();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if(-1==conInteger) {
					break;
				}else if('\r'==(char)conInteger||'\n'==(char)conInteger) {
					try {
						this.processSCString(new String(content,"GBK").trim());
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					i=0;
				}else {
					content[i]=(byte)conInteger;
					i++;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
    private void processSCString(String scString) {
		String[] scFields=scString.split(";");
   	 	SC sc = new SC();
   	 	sc.setStudentNo(scFields[0]);
   	 	StringBuffer stringBuffer=new StringBuffer();
   	 	stringBuffer.append(scFields[1]);
   	 	sc.setCourseNo(stringBuffer);
   	 	sc.setGrate(Integer.parseInt(scFields[2]));
   	 	scs.put(sc.getStudentNo(), sc);
	}
   	public static SCDao getInstance() {
   		if(instance == null) {
   			synchronized(SCDao.class) {
   				if(instance == null) {
   					instance = new SCDao();
   				}
   			}
   		}
   		return instance;
   	}
	public void update() {
	   	 Set<String> scSet=scs.keySet();
	   	 StringBuffer scStringBuffer=new StringBuffer();
	   	 for(String studentNo:scSet) {
	   		 SC sc=(SC)scs.get(studentNo);
				String uString = sc.getStudentNo()+";"
						+sc.getCourseNo().toString()+";"+
						sc.getGrade()+"\r\n";
				scStringBuffer.append(uString);
	   	 }
	   	 putSCToFile(scStringBuffer.toString(),"sc2.txt");
	}
    private void putSCToFile(String uString,String osName){
   	 	try {
   	 		fos=new FileOutputStream(osName);
   	 	} catch (FileNotFoundException e) {
   	 		e.printStackTrace();
   	 	}
   	 	try {
   	 		fos.write(uString.getBytes("GBK"));
   	 	} catch (UnsupportedEncodingException e) {
   	 		e.printStackTrace();
   	 	} catch (IOException e) {
   	 		e.printStackTrace();
   	 	}
    }
	public void insert(IEntity entity) {
		SC sc= (SC)entity;
   		scs.put(sc.getStudentNo(), sc);
	}
	public void add() {
		SC sc1 = new SC();
    	System.out.println("������Ҫ���ӵ�ѧ���γ���Ϣ!");
    	Scanner scanner = new Scanner(System.in);
		System.out.println("������ѧ�ţ�");
		String studentNo=scanner.nextLine();
		sc1.setStudentNo(studentNo);
		System.out.println("������γ�����");
		String courseNo=scanner.nextLine();
		StringBuffer sf = new StringBuffer();
		sf.append(courseNo);
		sc1.setCourseNo(sf);
		System.out.println("������ѧ�֣�");
		String courseGrade=scanner.nextLine();
		sc1.setGrate(Integer.parseInt(courseGrade));
   		scs.put(sc.getStudentNo(), sc);
   		SCBiz scBiz=new SCBiz();
   		scBiz.save();
    }
	public void delete() {
		System.out.println("������Ҫɾ��ѧ����ѧ��");
		Scanner str=new Scanner(System.in);
		String studentNo=str.nextLine();
		sc = (SC)getEntity(studentNo);
		if(sc == null) {
			System.out.println("�û������ڣ�");
		}else {
			scs.remove(studentNo);
			System.out.println("ɾ���ɹ���");
			SCBiz scBiz=new SCBiz();
	   		scBiz.save();
			return;
		}
	}
	public void modify() {
		System.out.println("������Ҫ�޸ĵĿγ̵ĺ�");
		Scanner str=new Scanner(System.in);
		String studentNo=str.nextLine();
		sc = (SC)getEntity(studentNo);
		if(sc==null) {
			System.out.println("�����ڣ�");
		}else {
			System.out.println("������Ҫ�޸ĺ�Ŀγ���Ϣ!");
	    	Scanner scanner = new Scanner(System.in);
			System.out.println("������ѧ�ţ�");
			String studentNo1=scanner.nextLine();
			sc.setStudentNo(studentNo1);
			System.out.println("������γ�����");
			String courseNo=scanner.nextLine();
			StringBuffer sStringBuffer=new StringBuffer();
			sStringBuffer.append(courseNo);
			sc.setCourseNo(sStringBuffer);
			System.out.println("������ѧ�֣�");
			String courseGrade=scanner.nextLine();
			sc.setGrate(Integer.parseInt(courseGrade));
	   		scs.put(sc.getStudentNo(), sc);
			System.out.println("�޸ĳɹ���");
			CourseBiz courseBiz=new CourseBiz();
			courseBiz.save();
			return;
		}
	}
	public HashMap<String,IEntity> getAllEntities(){
		return scs;
	}
	public IEntity getEntity(String Id) {
		return scs.get(Id);
	}
}
