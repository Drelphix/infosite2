package by.infosite.model.computer.operationsystem;

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
public class OperationSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false, length = 40)
    private String caption;

    @Column(nullable = false, length = 30)
    private String version;

    @Column(nullable = false, length = 5)
    private String architecture;

    @OneToOne(targetEntity = Computer.class)
    @JoinColumn(name = "computer_id")
    private Computer computer;

    public static class OSBuilder{
        OperationSystem newOS;

        public OSBuilder(){
            newOS = new OperationSystem();
        }

        public OSBuilder withCaption(String caption){
            newOS.setCaption(caption);
            return this;
        }

        public OSBuilder withVersion(String version){
            newOS.setVersion(version);
            return this;
        }

        public OSBuilder withArchitecture(String architecture){
            newOS.setArchitecture(architecture);
            return this;
        }

        public OperationSystem build(){
            return newOS;
        }
    }

    @Override
    public String toString() {
        return "OperationSystem{" +
                "caption='" + caption + '\'' +
                ", version='" + version + '\'' +
                ", architecture='" + architecture + '\'' +
                '}';
    }
}
