package u.pankratova.demo.service;

import org.springframework.stereotype.Service;
import u.pankratova.demo.model.Person;
import u.pankratova.demo.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> index(){
        return repository.findAll();
    }

    public Person getPersonById(int id){
       return repository.findById(id);
    }

    public void add(Person person){
        repository.save(person);
    }


}
