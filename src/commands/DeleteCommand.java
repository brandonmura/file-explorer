package commands;

import filesystem.Folder;

public class DeleteCommand implements Command {
    private final Folder currentFolder;
    private final String name;

    public DeleteCommand(Folder currentFolder, String name) {
        this.currentFolder = currentFolder;
        this.name = name;
    }

    @Override
    public void execute() {
        boolean success = currentFolder.remove(name);
        if (success) {
            System.out.println("Item '" + name + "' deleted successfully.");
        } else {
            System.out.println("Item '" + name + "' not found.");
        }
    }
}
