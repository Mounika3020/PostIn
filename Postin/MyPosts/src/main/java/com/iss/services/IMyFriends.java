package com.iss.services;

import java.util.List;

import com.iss.models.MyFriendsModel;

public interface IMyFriends
{
	public void save(MyFriendsModel myfriendsmodel);
	public void update(String userId, String status,String username);
	public void delete();
	public List<MyFriendsModel> getRequestById(String username);
	public List<MyFriendsModel> getAll(String username);
	public List<MyFriendsModel> getFriendsById(String username);	

}