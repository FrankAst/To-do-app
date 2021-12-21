package com.ensolversapp.appens;


import com.ensolversapp.appens.Service.TaskService;
import com.ensolversapp.appens.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class taskController {

    private final TaskService taskService;

    @Autowired
    public taskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/all")
    public List<Task> getTasks(){
        return taskService.getTasks();
    }

    @GetMapping("/find/{taskId}")
    public ResponseEntity<Task> getTaskById(
            @PathVariable("taskId") Long taskId){
        Task task = taskService.getTaskById(taskId);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PostMapping("/Add")
    public void createNewTasks(@RequestBody Task task){
        taskService.addTask(task);
    }

    @DeleteMapping(path = "{taskId}")
    public void deleteTask(
            @PathVariable("taskId") Long taskId){
        taskService.deleteTask(taskId);
    }

    @PutMapping(path = "{taskId}")
    public void updateTask(
            @PathVariable("taskId") Long taskId,
            @RequestParam(required = false) String to_do,
            @RequestParam(required = false) boolean is_done,
            @RequestParam(required = false) String folder){
        taskService.updateTask(taskId,to_do,is_done,folder);
    }



}
