package com.facu.CrudRestApi.services;

import java.util.List;


import com.facu.CrudRestApi.entities.Person;
import com.facu.CrudRestApi.models.PersonModel;

public interface IPersonService {
	
	public List<Person> getAll();
	
	public PersonModel insertOrUpdate(PersonModel personModel);
	
	public List<PersonModel> getAlls();
	
	public PersonModel findById(long id);
	
	public PersonModel findByDni(long dni);
	
	public boolean remove(long id);

}
