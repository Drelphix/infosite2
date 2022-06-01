package by.infosite.model.computer.ram;

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
public class Ram {

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

    @Column(nullable = false, length = 25)
    private String bankLabel;

    @ManyToOne(targetEntity = Computer.class)
    @JoinColumn(name = "computer_id", nullable = false)
    private Computer computer;

    public static class MemoryBuilder{
        private Ram newRam;

        public MemoryBuilder() {
            newRam = new Ram();
        }

        public MemoryBuilder withCapacity(String capacity){
            newRam.setCapacity(capacity);
            return this;
        }

        public MemoryBuilder withSpeed(short speed){
            newRam.setSpeed(speed);
            return this;
        }

        public MemoryBuilder withSerialNumber(String serialNumber){
            newRam.setSerialNumber(serialNumber);
            return this;
        }

        public MemoryBuilder withManufacturer(String manufacturer){
            newRam.setManufacturer(manufacturer);
            return this;
        }
        public MemoryBuilder withLocation(String location){
            newRam.setLocation(location);
            return this;
        }
        public MemoryBuilder withBankLabel(String bankLabel){
            newRam.setBankLabel(bankLabel);
            return this;
        }

        public Ram build(){
            return newRam;
        }
    }

    @Override
    public String toString() {
        return "Ram{" +
                "capacity='" + capacity + '\'' +
                ", speed=" + speed +
                ", serialNumber='" + serialNumber + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", location='" + location + '\'' +
                ", bankLabel='" + bankLabel + '\'' +
                '}';
    }
}
