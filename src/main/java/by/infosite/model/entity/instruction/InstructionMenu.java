package by.infosite.model.entity.instruction;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Setter
@Getter
public class InstructionMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long menuId;

    @Column(nullable = false, length = 30)
    private String name;

    @Column
    private short position;

    @Column
    private boolean isDeleted;

    @OneToMany(targetEntity = Instruction.class, mappedBy = "instructionMenu")
    private List<Instruction> instructions;
}
