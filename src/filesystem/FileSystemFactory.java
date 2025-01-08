package filesystem;

public class FileSystemFactory {
    public static FileSystemItem createItem(String type, String name) {
        return switch (type.toLowerCase()) {
            case "file" -> new File(name);
            case "folder" -> new Folder(name);
            default -> null;
        };
    }
}
