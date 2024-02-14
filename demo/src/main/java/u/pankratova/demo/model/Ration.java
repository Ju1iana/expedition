package u.pankratova.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ration")
@Getter
@Setter
public class Ration {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "calories")
    private int calories;

    @Column(name = "bzhu")
    private String bzhu;

    @Column(name = "weight")
    private int weight;

    @Column(name = "description")
    private String description;
}

