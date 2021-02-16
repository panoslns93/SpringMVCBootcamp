package noslia.service;

import noslia.entity.Trainer;
import noslia.repository.TrainerRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TrainerService {

    @Autowired
    TrainerRepo trainerRepo;
    
    private List<Trainer> trainers;

    public List<Trainer> getTrainers() {
        List<Trainer> trainers = trainerRepo.findAll();
        return trainers;
    }

    public void addTrainer(Trainer trainer) {
        trainerRepo.save(trainer);
    }

    public void deleteTrainer(int id) {
        trainerRepo.delete(Trainer.class, id);
    }

    public Trainer getTrainerById(int tid) {
        return trainerRepo.find(tid);
    }

    public Trainer updateTrainer(Trainer trainer) {//trainer argument contains the new data from the form
        return trainerRepo.save(trainer);
    }
}
