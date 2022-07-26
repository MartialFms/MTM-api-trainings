package fr.fms.web;

import fr.fms.entities.TrainingOrder;
import fr.fms.exceptions.RecordNotFoundException;
import fr.fms.service.ImplTrainingOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class TrainingOrderController {
    @Autowired
    private ImplTrainingOrderService implTrainingOrderService;

    @GetMapping("/trainingOrder")
    public List<TrainingOrder> allTrainingOrders(){return implTrainingOrderService.getTrainingOrder();}

    @PostMapping("/trainingOrder")
    public TrainingOrder saveTraining(@RequestBody TrainingOrder t){
        return implTrainingOrderService.saveTrainingOrder(t);
    }

    @DeleteMapping("/trainingOrder/{id}")
    public void deleteTraining(@PathVariable("id")Long id){
        implTrainingOrderService.deleteTrainingOrder(id);
    }

    @GetMapping("/trainingOrder/{id}")
    public TrainingOrder getTrainingOrderById(@PathVariable("id") Long id) {
        return implTrainingOrderService.readTrainingOrder(id)
                .orElseThrow(() -> new RecordNotFoundException(" " + id + "  n'existe pas"));
    }



}
