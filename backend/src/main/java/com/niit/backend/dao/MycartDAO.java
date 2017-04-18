package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.model.Mycart;
public interface MycartDAO {
	public List<Mycart> getallcartdetails(String id);
	
	public boolean save(Mycart mycart);
	
	public boolean update(Mycart mycart);
	
	public boolean delete(Mycart mycart);
	
	public Mycart getbyname(String name);
	
	public Mycart getbyid(int id);
	
    }