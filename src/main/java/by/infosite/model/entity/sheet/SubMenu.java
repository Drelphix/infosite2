package by.infosite.model.entity.sheet;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@javax.persistence.Table
@Getter
@Setter
public class SubMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long subMenuId;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false)
    private short position;

    @Column
    private boolean deleted;

    @OneToMany(targetEntity = Sheet.class, mappedBy = "subMenu")
    private List<Sheet> sheetList;

    @ManyToOne(targetEntity = Menu.class, fetch = FetchType.LAZY)
    private Menu menu;
}
