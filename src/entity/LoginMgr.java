package entity;

import java.util.ArrayList;

import dao.AdminDao;

public class LoginMgr {
	private static ArrayList<Admin> adminlist;
	
	public LoginMgr() {
		AdminDao dao= new AdminDao();
		adminlist=(ArrayList<Admin>) dao.getAllAdmin();
		
	}
	
	public int verifyUser(String name, String password,String type){
		int userType = -1;
		if("管理员".equals(type))
		for(int i = 0; i<adminlist.size(); i++){
			if(adminlist.get(i).getName().equals(name)&&
					adminlist.get(i).getPassword().equals(password)&&
					    adminlist.get(i).getStyle().equals("管理员")){
				userType = 0;
				return userType;
			}
		}
		else if(type.equals("学生"))
			for(int i = 0; i<adminlist.size(); i++){
				if(adminlist.get(i).getName().equals(name)&&
						adminlist.get(i).getPassword().equals(password)&&
						   adminlist.get(i).getStyle().equals("学生")){
					userType = 1;
					return userType;
				}
			}
		else if(type.equals("教师"))
			for(int i=0;i<adminlist.size();i++) {
				if(adminlist.get(i).getName().equals(name)&&
						adminlist.get(i).getPassword().equals(password)&&
						   adminlist.get(i).getStyle().equals("教师")) {
					userType=2;
					return userType;
				}
			}
		
		return userType;
	}

}
