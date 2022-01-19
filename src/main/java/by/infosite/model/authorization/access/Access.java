package by.infosite.model.authorization.access;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

enum AccessType{
    READ, WRITE, DENY
}

enum AccessPart{
    INSTRUCTION, COMPUTER,  MENU, SUBMENU, TABLE
}

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Access {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private AccessType accessType;

    @Column(nullable = false)
    private AccessPart accessPart;

    @Column(nullable = false)
    private long idPart;

    @Column(nullable = false, length = 30)
    private String name;
}
