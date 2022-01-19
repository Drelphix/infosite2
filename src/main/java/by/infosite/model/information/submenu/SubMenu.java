package by.infosite.model.information.submenu;

import by.infosite.model.information.sheet.Sheet;
import by.infosite.model.information.menu.Menu;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
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
    private boolean isDeleted;

    @OneToMany(targetEntity = Sheet.class, mappedBy = "subMenu")
    private List<Sheet> sheetList;

    @ManyToOne(targetEntity = Menu.class, fetch = FetchType.LAZY)
    private Menu menu;
}
