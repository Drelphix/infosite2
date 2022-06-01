package by.infosite.model.computer.ipaddress;

import by.infosite.model.computer.networkadapter.NetworkAdapter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class IpAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false, length = 40)
    private String ip;

    @ManyToOne(targetEntity = NetworkAdapter.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "network_adapter_id")
    private NetworkAdapter networkAdapter;

    @Override
    public String toString() {
        return "IpAddress{" +
                "ip='" + ip + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof IpAddress)) return false;

        IpAddress ipAddress = (IpAddress) object;

        if (getId() == ipAddress.getId()) return true;
        return getIp().equals(ipAddress.getIp());
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getIp().hashCode();
        result = 31 * result + getNetworkAdapter().hashCode();
        return result;
    }

    public void changeId(IpAddress ipAddress){
        this.id = ipAddress.getId();
    }
}
