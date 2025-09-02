import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public List<String> load() throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            // If folder doesn't exist, create it
            file.getParentFile().mkdirs();
            file.createNewFile();
            return new ArrayList<>(); // empty task list on first run
        }
        return Files.readAllLines(Paths.get(filePath));
    }

    public void save(List<String> lines) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        for (String line : lines) {
            fw.write(line + System.lineSeparator());
        }
        fw.close();
    }
}
