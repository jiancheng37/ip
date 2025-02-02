package jimmy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void testMark() {
        Task task = new Todo("Read book");
        task.mark();
        assertTrue(task.isCompleted(), "Task should be marked as done.");
    }

    @Test
    void testUnmark() {
        Task task = new Todo("Read book");
        task.mark();
        task.unmark();
        assertFalse(task.isCompleted(), "Task should be marked as not done.");
    }
}