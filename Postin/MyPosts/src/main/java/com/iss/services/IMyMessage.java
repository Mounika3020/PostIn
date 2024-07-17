package com.iss.services;

import java.util.List;

import com.iss.models.MyMessageModel;

public interface IMyMessage
{
	public void save(MyMessageModel mymsgmodel);
	public void update();
	public void delete();
	public List<MyMessageModel> getAll();
	public int getMessageById(int id);
	public List<MyMessageModel> getAllMessagesByUserName(String username);
	public List<MyMessageModel> getAllSentMessagesByUserName(String username);
}