package by.infosite.model.entity.instruction;

import by.infosite.model.entity.authorization.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
public class Instruction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private LocalDateTime date;

    @ManyToOne(targetEntity = User.class)
    private User user;

    @Column
    private short position;

    @Column
    private boolean isDeleted;

    @Column
    private boolean isChanged;
}
