package main;

import java.util.ArrayList;

public class TaskService {
    private ArrayList<Task> tasks = new ArrayList<>();


    //add task
    public void addTask(Task newTask) {
    tasks.add(newTask);
    }

    //print all tasks
    public void printTask() {
        if (tasks.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("List of tasks");
            for (Task temp : tasks) {
                System.out.println(temp);
            }
        }
    }


    //find task by ID
    public Task findById(int id) {
        for (Task check : tasks) {
            if(check.getId() == id) {
                return check;
            }
        }
        return null;    
    } 


    //delete task
    public void deleteTask(int id) {
        Task del = findById(id);
        
        if (del != null) {
            tasks.remove(del);
        } else {
           throw new IllegalArgumentException("Task not found");
        }
    }

    //EDIT TASK by id
    //edit its name 
    public void editTitle(int id, String newTitle) {
        Task edit = findById(id);

        if (edit == null) {
            throw new IllegalArgumentException("Task not found");
        }
        edit.setTitle(newTitle);
    }
    public void editDescription(int id, String newDescription) {
        Task edit = findById(id);

        if (edit == null) {
            throw new IllegalArgumentException("Task not found");
        }
        edit.setDescription(newDescription);
    }
    public void editPriority(int id) {
        Task edit = findById(id);

        if (edit == null) {
            throw new IllegalArgumentException("Task not found");
        }
        if (edit.getPrio() == Task.Priority.must_do) {
            edit.setPrio(Task.Priority.nice_to_do);
        } else {
            edit.setPrio(Task.Priority.must_do);
        }
    }

    public void toggleDone(int id) {
        Task edit = findById(id);

        if (edit == null) {
            throw new IllegalArgumentException("Task not found");
        }
        edit.toggleDone();
    }
}
