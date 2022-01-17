package by.infosite.model.entity.computer;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Computer")
public class Computer {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column
    private boolean deleted;

    @Column(unique = true,nullable = false)
    private String name;

    @Column(nullable = false)
    private String motherboard;

    @Column(nullable = false)
    private String cpu;

    @OneToOne(targetEntity = OperationSystem.class, mappedBy = "computer",cascade = CascadeType.ALL)
    private OperationSystem operationSystem;

    @OneToMany(targetEntity = Memory.class, mappedBy = "computer", cascade = CascadeType.ALL)
    private List<Memory> memoryList;

    @OneToMany(targetEntity = Disk.class, mappedBy = "computer", cascade = CascadeType.ALL)
    private List<Disk> diskList;

    @OneToMany(targetEntity = NetworkAdapter.class, mappedBy = "computer", cascade = CascadeType.ALL)
    private List<NetworkAdapter> networkAdapterList;

}
