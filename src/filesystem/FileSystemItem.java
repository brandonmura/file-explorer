package filesystem;

public abstract class FileSystemItem {
    protected String name;

    public FileSystemItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void list();
}
