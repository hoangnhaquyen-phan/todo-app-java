package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opentest4j.TestSkippedException;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    TaskService taskService;
    Task task;


    @BeforeEach
    void taskToTest() {
        taskService = new TaskService();
        task = new Task("learn", "learn theory", Task.Priority.must_do);
        taskService.addTask(task);
    }

    @Test
    void findById() {
        Task foundTask = taskService.findById(task.getId());
        assertEquals(task, foundTask);
    }

    @Test
    void findByIdNotFound() {
        Task foundTask = taskService.findById(50);
        assertNull(foundTask);
    }

    @Test
    void deleteTask() {
        taskService.deleteTask(task.getId());
        assertNull(taskService.findById(task.getId()));
    }

    @Test
    void deleteTaskInvalid() {
        assertThrows(IllegalArgumentException.class,
                () -> taskService.deleteTask(50));
    }

    @Test
    void editTitle() {
        taskService.editTitle(task.getId(), "go shopping");
        assertEquals("go shopping", task.getTitle());
    }

    @Test
    void editTitleInvalid() {
        assertThrows(IllegalArgumentException.class,
                () -> taskService.editTitle(50, "play"));
    }

    @Test
    void editDescription() {
        taskService.editDescription(task.getId(), "buy new jacket");
        assertEquals("buy new jacket", task.getDescription());
    }

    @Test
    void editDescriptionInvalid() {
        assertThrows(IllegalArgumentException.class,
                () -> taskService.editDescription(50, "play"));
    }

    @Test
    void editPriority() {
        if (task.getPrio() == Task.Priority.must_do) {
            taskService.editPriority(task.getId());
            assertEquals(Task.Priority.nice_to_do, task.getPrio());
        } else {
            taskService.editPriority(task.getId());
            assertEquals(Task.Priority.nice_to_do, task.getPrio());
        }
    }

    @Test
    void editPriorityInvalid() {
        assertThrows(IllegalArgumentException.class,
                () -> taskService.editPriority(50));
    }
}

