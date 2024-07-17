package com.iss.services;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.Persistence;
import com.iss.models.MyMessageModel;
import com.iss.models.MyPostsModel;


public class MyMessage implements IMyMessage
{
	EntityManagerFactory emf;
	EntityManager em;
	public MyMessage() {
		emf= Persistence.createEntityManagerFactory("Post");
		em = emf.createEntityManager( ); 	
	}
	
	
	public void save(MyMessageModel mymsgmodel)
	{
		em.getTransaction().begin();
		em.persist(mymsgmodel);
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
	public List<MyMessageModel> getAll() {
		
		javax.persistence.Query query = em.createQuery("Select messages from MyMessageModel messages");
		List<MyMessageModel> list =(List<MyMessageModel>)query.getResultList();  
		
		em.close();  
        emf.close();
        return list;
	}
	public List<MyMessageModel> getAllMessagesByUserName(String username) {
	    javax.persistence.Query query = em.createQuery("Select messages from MyMessageModel messages WHERE messages.too='"+username+"'");
	    
	    List<MyMessageModel> list = (List<MyMessageModel>) query.getResultList();
	    
	    em.close();
	    emf.close();
	    
	    return list;
	}
	public List<MyMessageModel> getAllSentMessagesByUserName(String username) {
	    javax.persistence.Query query = em.createQuery("Select message from MyMessageModel message WHERE message.frm='"+username+"'");
	    
	    List<MyMessageModel> list = (List<MyMessageModel>) query.getResultList();
	    
	    em.close();
	    emf.close();
	    
	    return list;
	}
	
	  
		
}