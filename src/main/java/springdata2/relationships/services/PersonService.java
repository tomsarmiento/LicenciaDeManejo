package springdata2.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import springdata2.relationships.models.Person;
import springdata2.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository=personRepository;
	}
	
	public void createPerson(Person p) {
		personRepository.save(p);
	}
	
	public List<Person> allPersons(){
		List<Person> optListPerson = personRepository.findAll();
		return optListPerson;
	}
	
	public Person findPersonById(Long id) {
		Optional<Person> optPerson = personRepository.findById(id);
		if(optPerson.isPresent()) {
			return optPerson.get();
		}
		else {
			return null;
		}
	}
	
}
