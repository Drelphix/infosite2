package by.infosite.model.entity.sheet;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long menuId;

    @Column(nullable = false, length = 20, unique = true)
    private String name;

    @Column(nullable = false)
    private short position;

    @Column
    private boolean deleted;

    @OneToMany(targetEntity = SubMenu.class, mappedBy = "menu")
    private List<SubMenu> subMenuList;
}
