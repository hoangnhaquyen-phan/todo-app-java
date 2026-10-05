package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void toggleDone() {
        Task task = new Task("Learn", "do exercises", Task.Priority.must_do);
        assertFalse(task.isDone());
        task.toggleDone();
        assertTrue(task.isDone());
    }
}