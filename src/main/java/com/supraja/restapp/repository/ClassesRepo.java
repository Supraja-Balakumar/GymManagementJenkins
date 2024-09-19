package com.supraja.restapp.repository;

import java.util.List;

import com.supraja.restapp.model.Classes;

public interface ClassesRepo 
{
	public List<Integer> getIDList();

	void save(Classes classes);

	List<Classes> findAll();

	void deleteById(int classid);

	Classes findById(int classid);
}
