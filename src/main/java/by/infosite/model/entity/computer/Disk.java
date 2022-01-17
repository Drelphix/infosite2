package by.infosite.model.entity.computer;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Disk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String serialNumber;

    @Column(nullable = false)
    private String size;

    @Column
    private String status;

    @ManyToOne(targetEntity = Computer.class)
    @JoinColumn(name = "computer_id", nullable = false)
    private Computer computer;

}
