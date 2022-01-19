package by.infosite.model.information.cell;

import by.infosite.model.information.column.Col;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Cell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long cellId;

    @Column()
    private String data;

    @Column(nullable = false)
    private short position;

    @Column
    private boolean isDeleted;

    @ManyToOne(targetEntity = Col.class)
    private Col col;
}
