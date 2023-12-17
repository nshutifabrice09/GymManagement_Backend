package com.example.demo.repository;

import com.example.demo.model.Trainer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepo extends JpaRepository<Trainer, Long> {
    Trainer findByCid(String cid);
    Trainer findTrainerById(Long id);
    @Transactional
    @Modifying
    @Query("DELETE FROM Trainer t WHERE t.cid= :cid")
    void removeByCid(@Param("cid")String cid);

}
