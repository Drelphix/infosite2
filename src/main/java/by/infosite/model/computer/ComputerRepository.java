package by.infosite.model.computer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long> {

    Optional<Computer> findComputerByName(String name);
}
