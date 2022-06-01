package by.infosite.model.computer.disk;

import by.infosite.model.computer.Computer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Disk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false, length = 30)
    private String model;

    @Column(nullable = false, length = 30)
    private String serialNumber;

    @Column(nullable = false)
    private String size;

    @Column(length = 8)
    private String status;

    @ManyToOne(targetEntity = Computer.class)
    @JoinColumn(name = "computer_id", nullable = false)
    private Computer computer;


    public static class DiskBuilder{
        private Disk disk;

        public DiskBuilder(){
            disk = new Disk();
        }

        public DiskBuilder withModel(String model){
            disk.setModel(model);
            return this;
        }

        public DiskBuilder withSerialNumber(String serialNumber){
            disk.setSerialNumber(serialNumber);
            return this;
        }

        public DiskBuilder withSize(String size){
            disk.setSize(size);
            return this;
        }

        public DiskBuilder withStatus(String status){
            disk.setStatus(status);
            return this;
        }

        public Disk build(){
            return disk;
        }
    }
    @Override
    public String toString() {
        return "Disk{" +
                "model='" + model + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", size='" + size + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
