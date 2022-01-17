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
    @Column(nullable = false)
    private long id;

    @Column(nullable = false, length = 30)
    private String capacity;

    @Column(nullable = false, length = 10)
    private short speed;

    @Column(nullable = false, length = 30)
    private String serialNumber;

    @Column(nullable = false, length = 30)
    private String manufacturer;

    @Column(nullable = false, length = 25)
    private String location;

    @ManyToOne(targetEntity = Computer.class)
    @JoinColumn(name = "computer_id", nullable = false)
    private Computer computer;

}
