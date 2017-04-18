package com.niit.backend.dao.impl;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.transaction.Transactional;
import com.niit.backend.dao.MycartDAO;
import com.niit.backend.model.Mycart;
@Repository("cartDAO")
@EnableTransactionManagement
@Transactional
public class CartDAOImpl  implements MycartDAO
{
	private SessionFactory sessionFactory;
	
	public CartDAOImpl(SessionFactory sessionfactory)
	{
		this.sessionFactory=sessionfactory;
	}
	

	public List<Mycart> getallcartdetails(String id)
	{
			return sessionFactory.getCurrentSession().createQuery("from Mycart where user_id='"+id+"'").list();
			
	
	}

	public boolean save(Mycart mycart) 
	{
	
	 try {
		sessionFactory.getCurrentSession().save(mycart);
		 return true;
	 	} catch (Exception e) {
		e.printStackTrace();
		
		return false;
	}
	
	
}

	public boolean update(Mycart mycart) 
	{
		try {
			sessionFactory.getCurrentSession().update(mycart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}

	public boolean delete(Mycart mycart) 
	{
		try {
			sessionFactory.getCurrentSession().delete(mycart);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	
	}

	

	public Mycart getbyname(String name) 
	{
		
		return (Mycart) sessionFactory.getCurrentSession().createQuery("from MYCART where NAME='"+name+"'").list();
		
	}


	public Mycart getbyid(int id) 
	{
	
		return (Mycart) sessionFactory.getCurrentSession().get(Mycart.class,id)	;
	}

	

}