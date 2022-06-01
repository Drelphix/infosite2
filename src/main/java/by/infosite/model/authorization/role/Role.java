package by.infosite.model.authorization.role;

import by.infosite.model.authorization.access.Access;
import by.infosite.model.authorization.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 10)
    private String name;

    @OneToMany(targetEntity = Access.class, mappedBy = "role")
    private List<Access> accessList;

}

