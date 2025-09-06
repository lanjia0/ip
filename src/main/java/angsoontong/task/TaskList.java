package angsoontong.task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import angsoontong.storage.Storage;



public class TaskList {
    private ArrayList<Task> tasks;

    // default constructor
    public TaskList() {
        tasks = new ArrayList<>();
    }

    // constructor
    public TaskList(ArrayList<Task> list) {
        this.tasks = list;
    }

    /**
     * method to write tasks to storage file
     * @param storage Storage object where current task list will be saved to
     * @throws IOException if storage object does not exist/ filePath is invalid
     */
    public void save(Storage storage) {
        try {
            storage.save(this);
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

    /**
     * delete task from task list
     * @param index represents the integer index of the task to be deleted in the ArrayList
     */
    public Task delete(int index) {
        Task deletedTask = this.get(index);
        tasks.remove(index);
        return deletedTask;
    }

    /**
     * returns size of taskList
     * @return number of tasks in the tasklist
     */
    public int size() {
        return tasks.size();
    }

    // returns the internal ArrayList
    public List<Task> getAll() {
        return tasks;
    }
}

