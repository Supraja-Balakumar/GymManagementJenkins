package com.supraja.restapp.service;

import java.util.List;

import com.supraja.restapp.model.Classes;


public interface ClassesService 
{
	public String addClasses(Classes classes);

	public Classes getClasses(int id);

	public List<Classes> getAllClasses();

	public void updateClasses(Classes classes);

	public void deleteClasses(int id);

	public List<Integer> getAllId();
}
