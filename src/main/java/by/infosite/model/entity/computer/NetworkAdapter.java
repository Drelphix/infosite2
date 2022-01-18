package by.infosite.model.entity.computer;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class NetworkAdapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false, length = 50)
    private String description;

    @OneToMany(targetEntity = IpAddress.class, mappedBy = "networkAdapter", cascade = CascadeType.ALL)
    private List<IpAddress> ipAddressList;

    @Column(nullable = false, length = 20)
    private String macAddress;

    @ManyToOne(targetEntity = Computer.class)
    @JoinColumn(name = "computer_id")
    private Computer computer;
}
