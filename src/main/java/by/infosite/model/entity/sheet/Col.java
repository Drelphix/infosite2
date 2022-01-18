package by.infosite.model.entity.sheet;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Col {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long rowId;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false)
    private ColType colType;

    @Column(nullable = false)
    private short position;

    @Column
    private boolean isDeleted;

    @ManyToOne(targetEntity = Sheet.class)
    private Sheet sheet;
}
