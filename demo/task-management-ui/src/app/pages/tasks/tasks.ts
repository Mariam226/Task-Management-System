import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { TaskService } from '../../services/task';

interface Task {
  id: number;
  desc: string;
  status: string;
  priority: string;
}

@Component({
  selector: 'app-tasks',
  imports: [CommonModule, FormsModule],
  templateUrl: './tasks.html',
  styleUrl: './tasks.css',
})
export class Tasks implements OnInit {
  prioritySorted: { [key: string]: number } = { HIGH: 1, MEDIUM: 2, LOW: 3 };

  toDo: Task[] = [];
  Do: Task[] = [];
  done: Task[] = [];

  newTaskDesc: string = '';
  newTaskPriority: string = 'MEDIUM';
  showAddForm: boolean = false;

  constructor(private router: Router, private taskService: TaskService) {}

  ngOnInit() {
    this.loadTasks();
  }

  loadTasks() {
    this.taskService.getTasks().subscribe((allTasks: any) => {
      this.toDo = allTasks.filter((t: Task) => t.status === 'TODO');
      this.Do = allTasks.filter((t: Task) => t.status === 'IN_PROGRESS');
      this.done = allTasks.filter((t: Task) => t.status === 'DONE');

      this.sortPriority(this.toDo);
      this.sortPriority(this.Do);
      this.sortPriority(this.done);
    });
  }

  sortPriority(list: Task[]) {
    list.sort((a, b) => this.prioritySorted[a.priority] - this.prioritySorted[b.priority]);
  }

  addTask(desc: string, priority: string) {
    const task = { desc: desc, priority: priority, status: 'TODO' };
    this.taskService.addTask(task).subscribe(() => {
      this.loadTasks();
      this.newTaskDesc = '';
      this.newTaskPriority = 'MEDIUM';
    });
  }

  removeTask(task: Task) {
    this.taskService.deleteTask(task).subscribe(() => {
      this.loadTasks();
    });
  }

  updateTask(task: Task) {
    let newStatus = '';
    if (task.status === 'TODO') newStatus = 'IN_PROGRESS';
    else if (task.status === 'IN_PROGRESS') newStatus = 'DONE';
    else return;

    const updatedTask = { ...task, status: newStatus };

    this.taskService.updateTask(updatedTask).subscribe(() => {
      this.loadTasks();
    });
  }
}