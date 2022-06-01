package by.infosite.model.computer.networkadapter;

import by.infosite.model.computer.Computer;
import by.infosite.model.computer.ipaddress.IpAddress;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class NetworkAdapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(length = 100)
    private String description;

    @OneToMany(targetEntity = IpAddress.class, mappedBy = "networkAdapter", cascade = CascadeType.ALL)
    private List<IpAddress> ipAddressList;

    @Column(nullable = false, length = 20)
    private String macAddress;

    @ManyToOne(targetEntity = Computer.class , cascade = CascadeType.ALL)
    @JoinColumn(name = "computer_id")
    private Computer computer;

    public void addIpAddress(IpAddress ipAddress){
        if(ipAddressList==null){
            ipAddressList = new ArrayList<>();
        }
        ipAddressList.add(ipAddress);
    }

    public static class NetworkAdapterBuilder{
        private NetworkAdapter networkAdapter;

        public NetworkAdapterBuilder(){
            networkAdapter = new NetworkAdapter();
        }

        public NetworkAdapterBuilder withDescription(String description){
            networkAdapter.setDescription(description);
            return this;
        }

        public NetworkAdapterBuilder  withIpAddresses(List<IpAddress> ipAddressList){
            networkAdapter.setIpAddressList(ipAddressList);
            return this;
        }


        public NetworkAdapterBuilder addIpAddress(IpAddress address){
            networkAdapter.addIpAddress(address);
            return this;
        }

        public NetworkAdapterBuilder withMacAddress(String macAddress){
            networkAdapter.setMacAddress(macAddress);
            return this;
        }

        public NetworkAdapter build(){
            return networkAdapter;
        }
    }

    @Override
    public String toString() {
        return "NetworkAdapter{" +
                "description='" + description + '\'' +
                ", ipAddressList=" + ipAddressList +
                ", macAddress='" + macAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof NetworkAdapter)) return false;

        NetworkAdapter that = (NetworkAdapter) object;

        if (getId() == that.getId()) return true;
        if (!getDescription().equals(that.getDescription())) return false;
        if (!getIpAddressList().equals(that.getIpAddressList())) return false;
        return getMacAddress().equals(that.getMacAddress());
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + getIpAddressList().hashCode();
        result = 31 * result + getMacAddress().hashCode();
        result = 31 * result + getComputer().hashCode();
        return result;
    }

    public void changeId(NetworkAdapter networkAdapter){
        this.id = networkAdapter.getId();
        for (int i = 0; i < this.getIpAddressList().size(); i++) {
            IpAddress ipAddress = networkAdapter.getIpAddressList().get(i);
            this.ipAddressList.get(i).changeId(ipAddress);
        }
    }
}
