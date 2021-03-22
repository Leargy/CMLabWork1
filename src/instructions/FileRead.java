package instructions;

import service.TotalCommander;

public class FileRead implements Command{
    private TotalCommander totalCommander;

    public FileRead(TotalCommander totalCommander) {
        this.totalCommander = totalCommander;
    }

    @Override
    public void execute() {
        totalCommander.readFromFile();
    }

    public static String NAME = "read_file";

}
