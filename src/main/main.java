package main;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        System.out.println("Welcome!");

        Scanner sc = new Scanner(System.in);
        TaskService taskSV = new TaskService();

        while(true){
            System.out.println("TO-DO APP \r\n1. Add task \r\n2. Show all tasks \r\n3. Delete task \r\n4. Edit task \r\n5. Exit");

            int num = sc.nextInt();
            sc.nextLine();

            switch(num) {
                case 1:
                    addTaskHandle(sc, taskSV);
                    System.out.println("Task added successfully.");
                    break;  

                case 2:
                    taskSV.printTask();
                    System.out.println("All tasks displayed.");
                    break;

                case 3:
                    try {
                        deleteTaskHandle(sc, taskSV);
                        System.out.println("Task deleted successfully.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        editTaskHandle(sc, taskSV);
                        System.out.println("Task updated successfully.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Exit");
                    //quit the while-loop
                    return;                             
            } 
        }
    }

    public static void addTaskHandle(Scanner sc, TaskService taskSV) {

        //title
        System.out.println("Please enter the title: ");
        String title = sc.nextLine();

        //description
        System.out.println("Please enter the description: ");
        String des = sc.nextLine();

        //priority
        Task.Priority prio = null;

        while (prio == null) {
        System.out.println("Please choose the priority: ");
        System.out.println("1. Must do: "); 
        System.out.println("2. Nice to do: ");

        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1:
                prio = Task.Priority.must_do;
                break;

            case 2:
                prio = Task.Priority.nice_to_do;
                break;

            default:
                System.out.println("Invalid choice. Please choose again!");
        }
        }

        Task newTask = new Task(title, des, prio);
        taskSV.addTask(newTask);
    }

    public static void deleteTaskHandle(Scanner sc, TaskService taskSV) {
       
        System.out.println("Please enter the ID of the task you want to delete: ");
        int chosenId = Integer.parseInt(sc.nextLine());

        taskSV.deleteTask(chosenId);
    }

    public static void editTaskHandle(Scanner sc, TaskService taskSV) {
        System.out.println("Please enter the ID of the task you want to edit: ");
        int editingId = sc.nextInt();
        sc.nextLine();

        System.out.println("What would you like to update?");
        System.out.println("- Title");
        System.out.println("- Description");
        System.out.println("- Priority");
        System.out.println("- Status");

        String chosen = sc.nextLine();

        switch (chosen.toLowerCase()) {
            case "title":
                System.out.println("Please enter the new title: ");
                String newTitle = sc.nextLine();
                taskSV.editTitle(editingId, newTitle);
                break;
            
            case "description":
                System.out.println("Please enter the new description: ");
                String newDescription = sc.nextLine();
                taskSV.editDescription(editingId, newDescription);
                break;

            case "priority":
                taskSV.editPriority(editingId);
            
            case "status":
                taskSV.toggleDone(editingId);
                break;
            
            default:
                System.out.println("Invalid choice. Please choose again!");
        }
    }
}

