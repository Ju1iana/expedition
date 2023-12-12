package u.pankratova.demo.model;

import lombok.*;
import org.springframework.stereotype.Component;
import u.pankratova.demo.repository.PersonRepository;
import java.util.List;

@Component
@Data
@NoArgsConstructor
public class Calculator {
    private static double amount;

    public void calcDuration(double duration, PersonRepository repository){
        amount = 0;
        List<Person> people = repository.findAll();

        for (Person person : people) {
            amount += person.getCalories();
        }
        setAmount(amount * duration);
    }

    public static double getAmount() {
        return amount;
    }

    private void setAmount(double v) {
        amount = v;
    }

    public double calc(Person person, PersonGender pGender) {
        final double A = 1.55; // коэффициент умеренного уровня активности
        final double a = 1.2; // коэффициент преобразования повседневной траты калорий
        double answer = 0;

        switch (pGender) {
            case MAN: {
                answer = ((10 * person.getWeight() + 6.25 * person.getH() - 5 * person.getAge() + 5) * A);
                break;
            }
            case WOMAN: {
                answer = ((10 * person.getWeight() + 6.25 * person.getH() - 5 * person.getAge() - 161) * A);
                break;
            }
        }
        return answer;
    }
}

