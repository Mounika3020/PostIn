package com.iss.services;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.iss.models.MyPostsModel;
public class MyPosts implements IMyPosts
{
	EntityManagerFactory emf;
	EntityManager em;
	public MyPosts() {
		emf= Persistence.createEntityManagerFactory("Post");
		em = emf.createEntityManager( ); 
		
	}
	
	
	public void save(MyPostsModel mypostmodel)
	{
		
		em.getTransaction().begin();
		em.persist(mypostmodel);
		em.getTransaction().commit();
		em.close();  
	    emf.close();
		  
	}
	public void update(int id,String Status)
	{
		em.getTransaction().begin();
        MyPostsModel post = em.find(MyPostsModel.class, id);
        if (post != null) {
            post.setStatus(Status);
            em.merge(post); // Merge the changes to the entity
        }
        em.getTransaction().commit();
        em.close();
        emf.close();

	}
	public void delete()
	{
		
	}
	public MyPostsModel getPostById(int id)
	{
		javax.persistence.Query query = em.createQuery("Select mypost from MyPostsModel mypost where mypost.Id="+id);
		MyPostsModel mypostsModel=(MyPostsModel)query.getSingleResult();
		return mypostsModel;
	}
	public List<MyPostsModel> getAll() {
		
		javax.persistence.Query query = em.createQuery("SELECT mypost FROM MyPostsModel mypost WHERE mypost.Status = :status");
		query.setParameter("status", "Active");
		List<MyPostsModel> list =(List<MyPostsModel>) query.getResultList();    
		
		em.close();  
        emf.close();
        return list;
	}
	
	public List<MyPostsModel> getAllPostsByUserName(String username) {
	    javax.persistence.Query query = em.createQuery("SELECT mypost FROM MyPostsModel mypost WHERE mypost.CreatedBy='"+username+"'");
	    
	    List<MyPostsModel> list = (List<MyPostsModel>) query.getResultList();
	    
	    em.close();
	    emf.close();
	    
	    return list;
	}
	
		
}