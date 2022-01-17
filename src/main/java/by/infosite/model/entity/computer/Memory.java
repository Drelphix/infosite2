package by.infosite.model.entity.computer;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Memory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String capacity;

    @Column(nullable = false)
    private short speed;

    @Column(nullable = false)
    private String serialNumber;

    @Column(nullable = false)
    private String manufacturer;

    @Column(nullable = false)
    private String location;

    @ManyToOne(targetEntity = Computer.class)
    @JoinColumn(name = "computer_id", nullable = false)
    private Computer computer;

}
