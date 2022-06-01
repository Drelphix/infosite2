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

    @Column(nullable = false, length = 80)
    private String caption;

    @Column(nullable = false, length = 30)
    private String version;

    @Column(nullable = false, length = 20)
    private String architecture;

    @OneToOne(targetEntity = Computer.class, cascade = CascadeType.ALL)
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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof OperationSystem)) return false;

        OperationSystem that = (OperationSystem) object;

        if (getId() == that.getId()) return true;
        if (!getCaption().equals(that.getCaption())) return false;
        if (!getVersion().equals(that.getVersion())) return false;
        return getArchitecture().equals(that.getArchitecture());
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getCaption().hashCode();
        result = 31 * result + getVersion().hashCode();
        result = 31 * result + getArchitecture().hashCode();
        result = 31 * result + getComputer().hashCode();
        return result;
    }

    public void changeId(OperationSystem operationSystem){
        this.id = operationSystem.getId();
    }
}
