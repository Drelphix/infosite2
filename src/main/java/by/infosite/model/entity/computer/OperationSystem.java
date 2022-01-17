package by.infosite.model.entity.computer;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class OperationSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false, length = 40)
    private String caption;

    @Column(nullable = false, length = 30)
    private String version;

    @Column(nullable = false, length = 5)
    private String architecture;

    @OneToOne(targetEntity = Computer.class)
    @JoinColumn(name = "computer_id")
    private Computer computer;
}
