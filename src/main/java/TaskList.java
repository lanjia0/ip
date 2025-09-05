public class TaskList {
    private Task[] tasks;
    private int size;

    // default constructor
    public TaskList() {
        tasks = new Task[100];
        size = 0;
    }

    // constructor
    public TaskList(Task[] loadedTasks, int count) {
        tasks = loadedTasks;
        size = count;
    }

    // method to add Task to task list
    public void add(Task t) {
        tasks[size] = t;
        size++;
    }

    // getter to retrieve tasks in task list
    public Task get(int index) {
        return tasks[index];
    }

    // delete task from task list
    public void delete(int index) {
        for (int i = index; i < size - 1; i++) {
            tasks[i] = tasks[i + 1];
        }
        size--;
    }


    public int size() {
        return size;
    }

    public Task[] getAll() {
        return tasks;
    }
}

