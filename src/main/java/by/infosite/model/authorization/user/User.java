package by.infosite.model.authorization.user;

import by.infosite.model.authorization.role.Role;
import by.infosite.model.information.instruction.Instruction;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false, length = 30)
    private String username;

    @Column(nullable = false)
    private String mail;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean active;

    @Column(length = 40)
    private String info;

    @Column
    private boolean isDeleted;

    @Column
    private Role role;

    @OneToMany(targetEntity = Instruction.class, fetch = FetchType.LAZY,mappedBy = "user")
    private List<Instruction> instructions;
}
