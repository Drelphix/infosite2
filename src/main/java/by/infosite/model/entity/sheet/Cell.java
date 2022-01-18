package by.infosite.model.entity.sheet;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
public class Cell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long cellId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private short position;

    @Column
    private boolean deleted;

    @ManyToOne(targetEntity = Col.class)
    private Col col;
}
