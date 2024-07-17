package com.iss.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.*;
import com.iss.models.MyFriendsModel;

public class MyFriends implements IMyFriends
{
	EntityManagerFactory emf;
	EntityManager em;
	public MyFriends() {
		emf= Persistence.createEntityManagerFactory("Post");
		em = emf.createEntityManager( ); 
		
	}
	public void save(MyFriendsModel myfriendsmodel)
	{
		
		em.getTransaction().begin();
		em.persist(myfriendsmodel);
		em.getTransaction().commit();
		em.close();  
	    emf.close();
		  
	}
	/*public void update(String userId, String status) {
		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Query query = (Query) em.createQuery("UPDATE MyFriendsModel m SET m.status = :status WHERE m.FriendID = :userId");
        //Query query = (Query) em.createNativeQuery("UPDATE MyFriendsModel m SET m.status = :status WHERE m.FriendID = :userId");
        query.setParameter("status", status);
        query.setParameter("FriendID", userId);
        
        int rowsUpdated = query.executeUpdate(); // Execute the update query
        
        em.getTransaction().commit();
        em.close();
	}*/
	public void update(String userId, String status, String username) {
	    System.out.println(userId);
	    
	    EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();

	    Query query = em.createQuery("SELECT m FROM MyFriendsModel m WHERE m.userId = :userId AND m.friendId = :username");
	    query.setParameter("userId", userId);
	    query.setParameter("username", username); 
	    
	    List<MyFriendsModel> friendList = query.getResultList();
	    
	    for (MyFriendsModel friend : friendList) {
	        if (friend != null) {
	            friend.setStatus(status);
	            em.merge(friend);
	        } else {
	            
	            System.out.println("Friend with ID " + userId + " and username " + username + " not found.");
	        }
	    }
	    
	    em.getTransaction().commit();
	    em.close();
	}






	

	public void delete()
	{
		
	}
	public List<MyFriendsModel> getFriendsById(String username) {
	    javax.persistence.Query query = em.createQuery("SELECT myfriends FROM MyFriendsModel myfriends where myfriends.userId = :username");
	    query.setParameter("username", username);
	    List<MyFriendsModel> list = query.getResultList();
	    return list;
	}
	public List<MyFriendsModel> getRequestById(String user) {
		Query query = em.createQuery("SELECT m FROM MyFriendsModel m WHERE m.friendId = :user");
		
	    query.setParameter("user", user); // Corrected parameter name to match the query
	    List<MyFriendsModel> list = query.getResultList();
	    
	    // Print retrieved friend objects for debugging
	    for(MyFriendsModel friend : list) {
	        System.out.println(friend);
	    }
	    
	    return list;
	}



	public List<MyFriendsModel> getAll(String username) {
	    EntityManager em = emf.createEntityManager();
	    javax.persistence.Query query = em.createQuery("SELECT m FROM MyFriendsModel m WHERE m.status = 'accept' AND m.userId = :username");
	    query.setParameter("username", username);
	    
	    List<MyFriendsModel> list = query.getResultList();
	    
	    em.close();
	    return list;
	}

	

}