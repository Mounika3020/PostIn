package com.iss.services;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.iss.models.MyFriendsPostModel;
public class MyFriendsPost implements IMyFriendsPost
{
	EntityManagerFactory emf;
	EntityManager em;
	public MyFriendsPost()
	{
		emf= Persistence.createEntityManagerFactory("Post");
		em = emf.createEntityManager( ); 
	}
	
	
	public void save(MyFriendsPostModel myfriendspostmodel)
	{
		em.getTransaction().begin();
		em.persist(myfriendspostmodel);
		em.getTransaction().commit();
		em.close();  
	    emf.close();
		  
	}
	public void update()
	{
		
	}
	public void delete()
	{
		
	}
	public int getMessageById(int id)
	{
		return id;
	}
	public void getAll() {
		// TODO Auto-generated method stub
		
	}	
}