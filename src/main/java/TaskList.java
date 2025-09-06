import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private ArrayList<Task> tasks;

    // default constructor
    public TaskList() {
        tasks = new ArrayList<>();
    }

    // method to write tasks to storage file
    public void save(Storage storage) {
        try {
            List<String> lines = new ArrayList<>();
            for (Task task : tasks) {   // tasks is your internal ArrayList<Task>
                lines.add(task.toFileFormat());
            }
            storage.save(lines);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    // method to add Task to task list
    public void add(Task t) {
        tasks.add(t);
    }

    // getter to retrieve tasks in task list
    public Task get(int index) {
        return tasks.get(index);
    }

    // delete task from task list
    public void delete(int index) {
        tasks.remove(index);
    }

    // returns size of taskList
    public int size() {
        return tasks.size();
    }
}

