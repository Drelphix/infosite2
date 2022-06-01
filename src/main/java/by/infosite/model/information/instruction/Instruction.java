package by.infosite.model.information.instruction;

import by.infosite.model.authorization.user.User;
import by.infosite.model.information.menu.Menu;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Instruction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(nullable = false, columnDefinition="TEXT")
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

    @ManyToOne(targetEntity = Menu.class)
    private Menu menu;
}
