package by.infosite.model.information.menu;

import by.infosite.model.information.submenu.SubMenu;
import by.infosite.model.information.instruction.Instruction;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
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
    private boolean isDeleted;

    @OneToMany(targetEntity = SubMenu.class, mappedBy = "menu")
    private List<SubMenu> subMenuList;

    @OneToMany(targetEntity = Instruction.class, mappedBy = "menu")
    private List<Instruction> instructions;
}
