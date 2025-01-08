import commands.*;
import filesystem.*;
import singleton.RootManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Folder root = RootManager.getRootInstance();
        CommandExecutor executor = new CommandExecutor();

        root.addObserver(folderName -> System.out.println("Folder '" + folderName + "' updated."));

        System.out.println("Welcome to the Enhanced File Explorer!");
        while (true) {
            System.out.println("\nCommands: create [file|folder], delete [name], list, exit");
            System.out.print("Enter command: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program...");
                break;
            }

            String[] parts = input.split(" ");
            String commandType = parts[0];

            switch (commandType.toLowerCase()) {
                case "create":
                    if (parts.length < 3) {
                        System.out.println("Usage: create [file|folder] [name]");
                        break;
                    }
                    String itemType = parts[1];
                    String name = parts[2];

                    // Add metadata when creating files or folders
                    FileSystemItem newItem;
                    if (itemType.equalsIgnoreCase("file")) {
                        File file = new File(name);
                        newItem = new MetadataDecorator(file, 1024); // Assigning a default size of 1024 bytes
                    } else if (itemType.equalsIgnoreCase("folder")) {
                        Folder folder = new Folder(name);
                        newItem = new MetadataDecorator(folder, 0); // Assigning size 0 for folders
                    } else {
                        System.out.println("Invalid item type. Use 'file' or 'folder'.");
                        break;
                    }

                    root.add(newItem);
                    System.out.println(itemType + " '" + name + "' created.");
                    break;

                case "delete":
                    if (parts.length < 2) {
                        System.out.println("Usage: delete [name]");
                        break;
                    }
                    String deleteName = parts[1];
                    executor.execute(new DeleteCommand(root, deleteName));
                    break;

                case "list":
                    executor.execute(new ListCommand(root));
                    break;

                default:
                    System.out.println("Invalid command. Try again.");
            }
        }
        scanner.close();
    }
}
