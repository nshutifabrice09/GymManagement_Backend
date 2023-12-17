package com.example.demo.repository;
import com.example.demo.model.User;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository <User, Long>{
    User findByMembershipId(String membershipId);
    User findUserById(Long id);
    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.membershipId = :membershipId")
    void removeByMembershipId(@Param("membershipId") String membershipId);
}
