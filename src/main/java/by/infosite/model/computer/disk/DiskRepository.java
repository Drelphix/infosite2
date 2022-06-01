package by.infosite.model.computer.disk;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiskRepository extends JpaRepository<Disk, Long> {
}
