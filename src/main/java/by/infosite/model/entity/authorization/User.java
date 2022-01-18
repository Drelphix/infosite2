package by.infosite.model.entity.authorization;

import by.infosite.model.entity.instruction.Instruction;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false, length = 30)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean active;

    @Column(length = 40)
    private String info;

    @Column
    private boolean isDeleted;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(targetEntity = Instruction.class, fetch = FetchType.LAZY,mappedBy = "user")
    private List<Instruction> instructions;
}
