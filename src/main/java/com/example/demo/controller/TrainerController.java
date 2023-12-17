package com.example.demo.controller;

import com.example.demo.model.Trainer;
import com.example.demo.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

public class TrainerController {
    private final TrainerService trainerService;

    @Autowired
    public TrainerController(TrainerService trainerService){
        this.trainerService = trainerService;
    }

    @PostMapping("/trainer")
    public Trainer save(@RequestBody Trainer trainer){
        return trainerService.saveTrainer(trainer);
    }

    @GetMapping("/trainers")
    public List<Trainer> trainerList(){
        return trainerService.getAllTrainers();
    }

    @GetMapping("/trainers/{id}")
    public Trainer getTrainerById(@PathVariable("id") Long id){
        return trainerService.getTrainerById(id);
    }

    @GetMapping("/trainer/{cid}")
    public Trainer findTrainerByCid(@PathVariable("cid") String cid){
        return trainerService.getTrainerByCid(cid);
    }

    @DeleteMapping("/trainer/{cid}")
    public void removeByCid(@PathVariable("cid") String cid){
        trainerService.removeByCid(cid);
    }

    @PutMapping("/trainer/{cid}")
    public Trainer updateTrainer(@PathVariable("cid") String cid, @RequestBody Trainer trainer){
        return trainerService.updateTrainer(cid, trainer);
    }
}
