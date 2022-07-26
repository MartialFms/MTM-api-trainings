package fr.fms.service;

import fr.fms.entities.Training;
import fr.fms.entities.TrainingOrder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ITrainingOrderService {

    List<TrainingOrder> getTrainingOrder();

    TrainingOrder saveTrainingOrder(TrainingOrder t);

    void deleteTrainingOrder(Long id);

    Optional<TrainingOrder> readTrainingOrder(Long id);
}
