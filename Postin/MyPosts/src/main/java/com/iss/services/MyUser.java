package com.iss.services;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.iss.models.MyPostsModel;
import com.iss.models.MyUserModel;

import jakarta.persistence.Query;
public class MyUser implements IMyUser
{
	EntityManagerFactory emf;
	EntityManager em;
	public MyUser() {
		emf= Persistence.createEntityManagerFactory("Post");
		em = emf.createEntityManager( ); 
		
	}
	
	
	public void save(MyUserModel myusermodel)
	{
		
		em.getTransaction().begin();
		em.persist(myusermodel);
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
	public MyUserModel findByEmail(String email) {
        javax.persistence.Query query = em.createQuery("SELECT myuser FROM MyUserModel myuser WHERE myuser.Email = :email");
        query.setParameter("email", email);

        try {
            return (MyUserModel) query.getSingleResult();
        } catch (Exception e) {
            // Handle exception or return null if no result found
            return null;
        }
    }
	public List<MyUserModel> getbyFriendid(String FriendID) {
	    javax.persistence.Query query = em.createQuery("SELECT myuser FROM MyUserModel myuser WHERE myuser.Email = :FriendID");
	    query.setParameter("FriendID", FriendID); // Set the parameter value
	    List<MyUserModel> list = query.getResultList();
	    
	    em.close();
	    emf.close();
	    
	    return list;
	}

		
}