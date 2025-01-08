package filesystem;

public class File extends FileSystemItem {

    public File(String name) {
        super(name);
    }

    @Override
    public void list() {
        System.out.println("File: " + name);
    }
}
