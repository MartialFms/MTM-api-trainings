package fr.fms.web;

import fr.fms.entities.Training;
import fr.fms.exceptions.RecordNotFoundException;
import fr.fms.service.ImplTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class TrainingController {
    @Autowired
    private ImplTrainingService implTrainingService;

    @GetMapping("/trainings")
    public List<Training> allTrainings(){return implTrainingService.getTrainings();}

    @PostMapping("/trainings")
    public Training saveTraining(@RequestBody Training t){
        return implTrainingService.saveTraining(t);
    }

    @DeleteMapping("/trainings/{id}")
    public void deleteTraining(@PathVariable("id")Long id){
        implTrainingService.deleteTraining(id);
    }

    @GetMapping("/trainings/{id}")
    public Training getTrainingById(@PathVariable("id") Long id) {
        return implTrainingService.readTraining(id)
                .orElseThrow(() -> new RecordNotFoundException("Id de formation " + id + "  n'existe pas"));
    }
}
