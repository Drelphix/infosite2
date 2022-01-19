package by.infosite.model.computer.computer;

import by.infosite.model.computer.disk.Disk;
import by.infosite.model.computer.memory.Memory;
import by.infosite.model.computer.networkadapter.NetworkAdapter;
import by.infosite.model.computer.operationsystem.OperationSystem;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Computer {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column
    private boolean isDeleted;

    @Column(nullable = false,length = 15)
    private String name;

    @Column(nullable = false, length = 20)
    private String domain;

    @Column(nullable = false, length = 30)
    private String motherboard;

    @Column(nullable = false, length = 15)
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
