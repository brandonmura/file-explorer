package commands;

import filesystem.Folder;

public class ListCommand implements Command {
    private final Folder currentFolder;

    public ListCommand(Folder currentFolder) {
        this.currentFolder = currentFolder;
    }

    @Override
    public void execute() {
        System.out.println("Contents of folder '" + currentFolder.getName() + "':");
        currentFolder.list();
    }
}
