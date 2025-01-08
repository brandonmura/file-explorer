package filesystem;

import observer.FolderObserver;

import java.util.ArrayList;
import java.util.List;

public class Folder extends FileSystemItem {
    private final List<FileSystemItem> items = new ArrayList<>();
    private final List<FolderObserver> observers = new ArrayList<>();

    public Folder(String name) {
        super(name);
    }

    public void add(FileSystemItem item) {
        items.add(item);
        notifyObservers();
    }

    public boolean remove(String name) {
        boolean removed = items.removeIf(item -> item.getName().equals(name));
        if (removed) notifyObservers();
        return removed;
    }

    public void addObserver(FolderObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (FolderObserver observer : observers) {
            observer.onFolderUpdated(this.getName());
        }
    }

    @Override
    public void list() {
        for (FileSystemItem item : items) {
            item.list();
        }
    }
}
