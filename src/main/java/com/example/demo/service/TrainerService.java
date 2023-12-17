package com.example.demo.service;

import com.example.demo.model.Admin;
import com.example.demo.model.Trainer;

import java.util.List;

public interface TrainerService {

    List<Trainer> getAllTrainers();
    Trainer getTrainerByCid(String cid);
    Trainer saveTrainer(Trainer trainer);

    Trainer updateTrainer(String cid, Trainer trainer);

    void removeByCid(String cid);

    Trainer getTrainerById(Long id);
}
