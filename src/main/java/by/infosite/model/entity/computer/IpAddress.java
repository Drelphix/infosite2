package by.infosite.model.entity.computer;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class IpAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String ip;

    @ManyToOne(targetEntity = NetworkAdapter.class)
    @JoinColumn(name = "network_adapter_id")
    private NetworkAdapter networkAdapter;

}
