package fr.fms.service;

import fr.fms.dao.TrainingOrderRepository;
import fr.fms.entities.TrainingOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImplTrainingOrderService implements ITrainingOrderService{

    @Autowired
    private TrainingOrderRepository trainingOrderRepository;

    @Override
    public List<TrainingOrder> getTrainingOrder() {
        return trainingOrderRepository.findAll();
    }

    @Override
    public TrainingOrder saveTrainingOrder(TrainingOrder t) {
        return trainingOrderRepository.save(t);
    }

    @Override
    public void deleteTrainingOrder(Long id) {
        trainingOrderRepository.deleteById(id);
    }

    @Override
    public Optional<TrainingOrder> readTrainingOrder(Long id) {
        return trainingOrderRepository.findById(id);
    }
}
