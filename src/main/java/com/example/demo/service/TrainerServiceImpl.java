package com.example.demo.service;

import com.example.demo.model.Trainer;
import com.example.demo.repository.TrainerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TrainerServiceImpl implements TrainerService{

    private TrainerRepo trainerRepo;

    public TrainerServiceImpl(TrainerRepo trainerRepo) {
        this.trainerRepo = trainerRepo;
    }

    @Override
    public List<Trainer> getAllTrainers() {
        return trainerRepo.findAll();
    }

    @Override
    public Trainer getTrainerByCid(String cid) {
        return trainerRepo.findByCid(cid);
    }

    @Override
    public Trainer saveTrainer(Trainer trainer) {
        return trainerRepo.save(trainer);
    }

    @Override
    public Trainer updateTrainer(String cid, Trainer trainer) {
        Trainer existTrainer = trainerRepo.findByCid(cid);
        if (existTrainer != null) {
            existTrainer.setCid(trainer.getCid());
            existTrainer.setFirst_name(trainer.getFirst_name());
            existTrainer.setLast_name(trainer.getLast_name());
            existTrainer.setEmail(trainer.getEmail());
            existTrainer.setPhone_number(trainer.getPhone_number());
            existTrainer.setPassword(trainer.getPassword());
            existTrainer.setAddress(trainer.getAddress());
            existTrainer.setProfession(trainer.getProfession());

            }
            return null;
        }

    @Override
    public void removeByCid (String cid) {
        trainerRepo.removeByCid(cid);
    }

    @Override
    public Trainer getTrainerById(Long id) {
        return trainerRepo.findTrainerById(id);
    }
}
