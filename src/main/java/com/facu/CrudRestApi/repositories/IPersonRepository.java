package com.facu.CrudRestApi.repositories;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facu.CrudRestApi.entities.Person;

@Repository("personRepository")
public interface IPersonRepository extends JpaRepository<Person,Serializable> {
	
	public abstract Person findById(long id);
	
	public abstract Person findByDni(long dni);

}
