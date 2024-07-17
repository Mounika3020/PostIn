package com.iss.services;

import java.util.List;
import com.iss.models.MyUserModel;

public interface IMyUser
{
	public void save(MyUserModel myusermodel);
	public void update();
	public void delete();
	public List<MyUserModel> getbyFriendid(String FriendID);
	public MyUserModel findByEmail(String email);
	
}