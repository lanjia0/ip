public class Parser {
    public static String[] parse(String command) {
        return command.split(" ");
    }

    public static String[] splitBySlash(String command) {
        return command.split("/");
    }
}

