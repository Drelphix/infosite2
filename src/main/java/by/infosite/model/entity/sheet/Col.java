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
    @javax.persistence.Column(nullable = false)
    private long rowId;

    @javax.persistence.Column(nullable = false, length = 30)
    private String name;

    @javax.persistence.Column(nullable = false)
    private short position;

    @javax.persistence.Column
    private boolean deleted;

    @ManyToOne(targetEntity = Sheet.class)
    private Sheet sheet;
}
