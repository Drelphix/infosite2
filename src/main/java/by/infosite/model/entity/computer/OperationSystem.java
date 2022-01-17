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
    private long id;

    @Column(nullable = false)
    private String caption;

    @Column(nullable = false)
    private String version;

    @Column(nullable = false)
    private String architecture;

    @OneToOne(targetEntity = Computer.class)
    @JoinColumn(name = "computer_id")
    private Computer computer;
}
