package u.pankratova.demo.service;

import org.springframework.stereotype.Service;
import u.pankratova.demo.model.Calculator;
import u.pankratova.demo.model.Ration;
import u.pankratova.demo.repository.RationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RationService {
    private final RationRepository repository;
    private final Calculator calculator;

    public RationService(RationRepository repository, Calculator calculator) {
        this.repository = repository;
        this.calculator = calculator;
    }
/*
    public int getCalories(){
        return repository.getByCalories();
    }

    public int getWeight(){
        return repository.getByWeight();
    }*/

    public Ration numberOfRation() {
        return calculator.numberOfRation(repository);
    }

    public List<Ration> index() {
        return repository.findAll();
    }

    /*public List<Ration> getRation(int index){
        return repository.findAll();
    }*/
}
