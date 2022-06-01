package by.infosite.model.computer.operationsystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationSystemRepository extends JpaRepository<OperationSystem, Long> {
}
