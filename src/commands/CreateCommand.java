package commands;

import filesystem.FileSystemFactory;
import filesystem.FileSystemItem;
import filesystem.Folder;

public class CreateCommand implements Command {
    private final Folder currentFolder;
    private final String type;
    private final String name;

    public CreateCommand(Folder currentFolder, String type, String name) {
        this.currentFolder = currentFolder;
        this.type = type;
        this.name = name;
    }

    @Override
    public void execute() {
        FileSystemItem newItem = FileSystemFactory.createItem(type, name);
        if (newItem != null) {
            currentFolder.add(newItem);
            System.out.println(type + " '" + name + "' created successfully.");
        } else {
            System.out.println("Invalid type. Use 'file' or 'folder'.");
        }
    }
}
