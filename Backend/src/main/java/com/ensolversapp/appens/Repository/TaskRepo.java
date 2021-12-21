package com.ensolversapp.appens.Repository;

import com.ensolversapp.appens.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;

public interface TaskRepo
        extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t WHERE t.to_do =?1")
    Optional<Task>  findTaskByTo_do(String to_do);
}
