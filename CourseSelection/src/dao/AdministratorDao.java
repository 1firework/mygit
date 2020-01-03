package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Set;

import entity.Administrator;
import entity.IEntity;

public class AdministratorDao implements IEntity{
	private static AdministratorDao instance;
	private HashMap<String, IEntity> administrators;
	private Administrator administrator;
	private FileInputStream fs;
    private FileOutputStream fos;
	
	private AdministratorDao() {
		administrators = new HashMap<String,IEntity>();
		administrator = new Administrator();
		getUsersFormInputStream("administrator.txt");   
	}
	
	 public void getUsersFormInputStream(String isName){
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
						this.processAdministratorString(new String(content,"GBK").trim());
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
	public void processAdministratorString(String userString) {
		String[] studentFields=userString.split(",");
		Administrator st=new Administrator();
   	 	st.setAdministratorID(studentFields[0]);
   	 	st.setAdministratorName(studentFields[1]);
   	 	st.setAdministratorAge(Integer.parseInt(studentFields[2]));
   	 	st.setAdministratorDepartment(studentFields[3]);
   	 	st.setAdministratorPassword(studentFields[4]);
   	 	st.setAdministratorGender(studentFields[5]);
   	    administrators.put(st.getAdministratorID(), st);
	}
	//懒汉式单例模式，得到StudentDao
	public static AdministratorDao getInstance() {
		if(instance == null) {
			synchronized(StudentDao.class) {
				if(instance == null) {
					instance = new AdministratorDao();
					return instance;
				}
			}
		}
		return instance;
	}
	//把HashMap中存储的学生信息加以处理变为一个字符串，传给putStudentsToFile()，
	public void update(){
   	 Set<String> administratorSet=administrators.keySet();
   	 StringBuffer uStringBuffer=new StringBuffer();
   	 for(String administratorID:administratorSet) {
   		Administrator st=(Administrator)administrators.get(administratorID);
			String uString = st.getAdministratorID()+","
					+st.getAdministratorName()+","+
					st.getAdministratorAge()+","+
					st.getAdministratorDepartment()+","+
					st.getAdministratorPasswprd()+","+
					st.getStudentGender()+"\r\n";
			uStringBuffer.append(uString);
   	 }
   	 putStudentsToFile(uStringBuffer.toString(),"administrator.txt");
    }
	//将得到的学生信息的字符串以GBK的编译模式写进文件student.txt中
	private void putStudentsToFile(String uString,String osName){
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
	public IEntity getEntity(String Id) {
		return administrators.get(Id);
	}
	public HashMap<String, IEntity> getAllEntities(){
		return administrators;
	}
}
