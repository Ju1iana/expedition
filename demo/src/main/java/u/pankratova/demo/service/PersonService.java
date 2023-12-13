package u.pankratova.demo.service;

import org.springframework.stereotype.Service;
import u.pankratova.demo.model.Calculator;
import u.pankratova.demo.model.Person;
import u.pankratova.demo.repository.PersonRepository;
import java.util.List;

@Service
public class PersonService {
    private final PersonRepository repository;
    private final Calculator calculator;

    public PersonService(PersonRepository repository, Calculator calculator) {
        this.repository = repository;
        this.calculator = calculator;
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

    public double personCalories(Person person){
        return calculator.calc(person, person.getPersonGender());
    }

    public void allCalories(double duration){
        calculator.calcDuration(duration, repository);
    }

    public void calcAll(double betta, double gamma){
        calculator.calcAll(betta, gamma);
    }

    public Calculator getCalculator(){
        return new Calculator();
    }

}
