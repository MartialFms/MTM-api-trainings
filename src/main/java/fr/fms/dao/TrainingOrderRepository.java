package fr.fms.dao;

import fr.fms.entities.TrainingOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingOrderRepository extends JpaRepository<TrainingOrder, Long> {
}
