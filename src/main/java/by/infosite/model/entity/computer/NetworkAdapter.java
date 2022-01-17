package by.infosite.model.entity.computer;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class NetworkAdapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String description;

    @OneToMany(targetEntity = IpAddress.class, mappedBy = "networkAdapter")
    private List<IpAddress> ipAddressList;

    @Column(nullable = false)
    private String macAddress;

    @ManyToOne(targetEntity = Computer.class)
    @JoinColumn(name = "computer_id")
    private Computer computer;
}
