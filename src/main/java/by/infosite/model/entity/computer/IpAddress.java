package by.infosite.model.entity.computer;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class IpAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false, length = 16)
    private String ip;

    @ManyToOne(targetEntity = NetworkAdapter.class)
    @JoinColumn(name = "network_adapter_id")
    private NetworkAdapter networkAdapter;

}
