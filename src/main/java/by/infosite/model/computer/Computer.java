package by.infosite.model.computer;

import by.infosite.model.computer.disk.Disk;
import by.infosite.model.computer.ram.Ram;
import by.infosite.model.computer.networkadapter.NetworkAdapter;
import by.infosite.model.computer.operationsystem.OperationSystem;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
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

    @OneToMany(targetEntity = Disk.class, mappedBy = "computer", cascade = CascadeType.ALL)
    private List<Disk> diskList;

    @OneToMany(targetEntity = Ram.class, mappedBy = "computer", cascade = CascadeType.ALL)
    private List<Ram> RamList;

    @OneToMany(targetEntity = NetworkAdapter.class, mappedBy = "computer", cascade = CascadeType.ALL)
    private List<NetworkAdapter> networkAdapterList;

    private void addDisk(Disk disk){
        if(diskList == null){
            diskList = new ArrayList<>();
        }
        diskList.add(disk);
    }

    private void addRAM(Ram RAM){
        if(RamList == null){
            RamList = new ArrayList<>();
        }
        RamList.add(RAM);
    }

    private void addNetworkAdapter(NetworkAdapter networkAdapter){
        if(networkAdapterList == null){
            networkAdapterList = new ArrayList<>();
        }
        networkAdapterList.add(networkAdapter);
    }

    public static class ComputerBuilder{
        private Computer newComputer;

        public ComputerBuilder(){
            newComputer = new Computer();
        }

        public ComputerBuilder withName(String name){
            newComputer.setName(name);
            return this;
        }

        public ComputerBuilder withDomain(String domain){
            newComputer.setDomain(domain);
            return this;
        }

        public ComputerBuilder withMotherboard(String motherboard){
            newComputer.setMotherboard(motherboard);
            return this;
        }

        public ComputerBuilder withCpu(String cpu){
            newComputer.setCpu(cpu);
            return this;
        }

        public ComputerBuilder withOperationSystem(OperationSystem operationSystem){
            newComputer.setOperationSystem(operationSystem);
            return this;
        }

        public ComputerBuilder withDisks(List<Disk> diskList){
            newComputer.setDiskList(diskList);
            return this;
        }

        public ComputerBuilder withRAM(List<Ram> RamList){
            newComputer.setRamList(RamList);
            return this;
        }

        public ComputerBuilder withNetworkAdapters(List<NetworkAdapter> networkAdapterList){
            newComputer.setNetworkAdapterList(networkAdapterList);
            return this;
        }

        public ComputerBuilder addDisk(Disk disk){
            newComputer.addDisk(disk);
            return this;
        }

        public ComputerBuilder addRAM(Ram ram){
            newComputer.addRAM(ram);
            return this;
        }

        public ComputerBuilder addNetworkAdapter(NetworkAdapter networkAdapter){
            newComputer.addNetworkAdapter(networkAdapter);
            return this;
        }

        public Computer build(){
            return newComputer;
        }
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", isDeleted=" + isDeleted +
                ", name='" + name + '\'' +
                ", domain='" + domain + '\'' +
                ", motherboard='" + motherboard + '\'' +
                ", cpu='" + cpu + '\'' +
                ", operationSystem=" + operationSystem +
                ", diskList=" + diskList +
                ", memoryList=" + RamList +
                ", networkAdapterList=" + networkAdapterList +
                '}';
    }
}
