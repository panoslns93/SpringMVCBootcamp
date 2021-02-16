package noslia.service;

import java.util.List;
import noslia.entity.Trainer;

public interface ITrainer {

    public List<Trainer> viewAllTrainers();

    public Trainer findById(int id);

    public boolean save(Trainer trainer);

    public boolean delete(int id);

    public boolean update(Trainer trainer);
}

