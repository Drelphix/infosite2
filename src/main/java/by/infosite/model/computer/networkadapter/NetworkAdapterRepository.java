package by.infosite.model.computer.networkadapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NetworkAdapterRepository extends JpaRepository<NetworkAdapter, Long> {
}
