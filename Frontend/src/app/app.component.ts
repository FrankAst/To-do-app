import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Task } from './task';
import { TaskService } from './task.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit{
  // Variables para mostrar los tasks en el ngFor
  public tasks!: Task[];
  public task!: Task;
  
  constructor(private taskService: TaskService){ }

  ngOnInit() {
      this.getTasks() //Al cargar muestra todos los tasks guardados.

  }
  
  public getTasks(): void {
    this.taskService.getTasks().subscribe(
      { next: (response: Task[]) => {
          this.tasks = response;
         console.log(this.tasks)
         },
         error: (err: HttpErrorResponse) => {
          alert(err.message);
          }
      }
    )} 


  public addTasks(): void {
    let newTask!:Task;
     
    newTask.to_do = (<HTMLInputElement>document.querySelector('#addTasksObj')).value.toString();
    
    console.log(newTask.to_do);
    
   /* if(newTask.to_do.length >0){
      this.taskService.addTask(newTask);
      this.tasks.push(newTask);
      (<HTMLInputElement>document.getElementById("addTasksObj")).value = "";
    }*/
  }

  public deleteTasks(id?:any): void {
    
      this.taskService.deleteTask(id);
  }




}
