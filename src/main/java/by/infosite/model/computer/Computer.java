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

    @Column(nullable = false,length = 15, unique = true)
    private String name;

    @Column(length = 20)
    private String domain;

    @Column(nullable = false, length = 30)
    private String motherboard;

    @Column(nullable = false, length = 60)
    private String cpu;

    @OneToOne(targetEntity = OperationSystem.class, mappedBy = "computer",cascade = CascadeType.ALL)
    private OperationSystem operationSystem;

    @OneToMany(targetEntity = Disk.class, mappedBy = "computer", cascade = CascadeType.ALL)
    private List<Disk> diskList;

    @OneToMany(targetEntity = Ram.class, mappedBy = "computer", cascade = CascadeType.ALL)
    private List<Ram> RamList;

    @OneToMany(targetEntity = NetworkAdapter.class, mappedBy = "computer", cascade = CascadeType.ALL)
    private List<NetworkAdapter> networkAdapterList;

    public void addDisk(Disk disk){
        if(diskList == null){
            diskList = new ArrayList<>();
        }
        diskList.add(disk);
    }

    public void addRAM(Ram RAM){
        if(RamList == null){
            RamList = new ArrayList<>();
        }
        RamList.add(RAM);
    }

    public void addNetworkAdapter(NetworkAdapter networkAdapter){
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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Computer)) return false;

        Computer computer = (Computer) object;

        if (getId() == computer.getId()) return true;
        if (!getName().equals(computer.getName())) return false;
        if (getDomain() != null ? !getDomain().equals(computer.getDomain()) : computer.getDomain() != null)
            return false;
        if (!getMotherboard().equals(computer.getMotherboard())) return false;
        if (!getCpu().equals(computer.getCpu())) return false;
        if (!getOperationSystem().equals(computer.getOperationSystem())) return false;
        if(!getDiskList().equals(computer.getDiskList())) return false;
        if(!getRamList().equals(computer.getRamList())) return false;
        return getNetworkAdapterList().equals(computer.getNetworkAdapterList());
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (domain != null ? domain.hashCode() : 0);
        result = 31 * result + motherboard.hashCode();
        result = 31 * result + cpu.hashCode();
        result = 31 * result + operationSystem.hashCode();
        result = 31 * result + diskList.hashCode();
        result = 31 * result + RamList.hashCode();
        result = 31 * result + networkAdapterList.hashCode();
        return result;
    }

    public void changeId(Computer computer){
        this.setId(computer.getId());
        this.operationSystem.changeId(computer.operationSystem);
        for (int i = 0; i < this.diskList.size(); i++) {
            Disk disk = computer.diskList.get(i);
            this.diskList.get(i).changeId(disk);
        }
        for (int i = 0; i < this.networkAdapterList.size(); i++) {
            NetworkAdapter networkAdapter = computer.networkAdapterList.get(i);
            this.networkAdapterList.get(i).changeId(networkAdapter);
        }
        for (int i = 0; i < this.RamList.size(); i++) {
            Ram ram = computer.getRamList().get(i);
            this.RamList.get(i).changeId(ram);
        }
    }
}
