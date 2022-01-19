package by.infosite.model.information.sheet;

import by.infosite.model.information.submenu.SubMenu;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Sheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long sheetId;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false)
    private SheetType sheetType;

    @Column(nullable = false)
    private short position;

    @Column
    private boolean isDeleted;

    @ManyToOne(targetEntity = SubMenu.class, fetch = FetchType.LAZY)
    private SubMenu subMenu;
}
