package com.facu.CrudRestApi.services.implementation;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.facu.CrudRestApi.converters.PersonConverter;
import com.facu.CrudRestApi.models.PersonModel;
import com.facu.CrudRestApi.entities.Person;
import com.facu.CrudRestApi.repositories.IPersonRepository;
import com.facu.CrudRestApi.services.IPersonService;



@Service("personService")
public class PersonService implements IPersonService {
	
	@Autowired
	@Qualifier("personRepository")
	private IPersonRepository personRepository;
	
	@Autowired
	@Qualifier("personConverter")
	private PersonConverter personConverter;
	
	@Override
	public List<Person> getAll(){
	  return personRepository.findAll();
    }
	
	@Override
	public PersonModel insertOrUpdate(PersonModel personModel) {
		Person person = personRepository.save(personConverter.modelToEntity(personModel));
		return personConverter.entityToModel(person);
	}
	
	@Override
	public List<PersonModel> getAlls(){
		List<PersonModel> models = new ArrayList<PersonModel>();
		for (Person person : personRepository.findAll()) {
			models.add(personConverter.entityToModel(person));
		}
		return models;
	}
	
	@Override
	public PersonModel findById(long id) {
		return personConverter.entityToModel(personRepository.findById(id));
	}
	
	@Override
	public PersonModel findByDni(long dni) {
		return personConverter.entityToModel(personRepository.findByDni(dni));
	}
	
	@Override
	public boolean remove(long id) {
		try {
			personRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	
	
	

}
