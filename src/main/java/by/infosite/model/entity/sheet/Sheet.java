package by.infosite.model.entity.sheet;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@javax.persistence.Table
@Getter
@Setter
public class Sheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long tableId;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false)
    private short position;

    @Column
    private boolean deleted;

    @ManyToOne(targetEntity = SubMenu.class, fetch = FetchType.LAZY)
    private SubMenu subMenu;
}
