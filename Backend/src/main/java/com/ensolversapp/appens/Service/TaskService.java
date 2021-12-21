package com.ensolversapp.appens.Service;

import com.ensolversapp.appens.Repository.TaskRepo;
import com.ensolversapp.appens.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepo taskRepo;

    @Autowired
    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    // Adding new tasks
    public void addTask(Task task){
        Optional<Task> taskOptional = taskRepo.
                findTaskByTo_do(task.getTo_do());
        if (taskOptional.isPresent()){
            throw new IllegalStateException("Task repeated");
        }
        taskRepo.save(task);
    }

    // Getting all tasks
    public List<Task> getTasks(){
        return taskRepo.findAll();
    }
    // Getting a specific task
    public Task getTaskById(Long taskId){
        return taskRepo.getById(taskId);
    }

    // Update tasks
    @Transactional
    public void updateTask(Long taskId, String new_to_do,boolean is_done,String folder){
        Task task = taskRepo.findById(taskId)
                .orElseThrow(() -> new IllegalStateException(
                        "Task with id"+taskId+" doesn't exists"));

        if(new_to_do != null &&
                new_to_do.length() > 0 &&
                !Objects.equals(task.getTo_do(), new_to_do)) {
            task.setTo_do(new_to_do);
        }
        if(folder != null &&
                folder.length() > 0 &&
                !Objects.equals(task.getFolder(), folder)) {
            task.setFolder(folder);
        }
    }

    // Deleting tasks
    public void deleteTask(Long taskId){
        boolean exists = taskRepo.existsById(taskId);
        if(!exists){
            throw new IllegalStateException("Id"+taskId+" Not found");
        }
        taskRepo.deleteById(taskId);
    }
}
