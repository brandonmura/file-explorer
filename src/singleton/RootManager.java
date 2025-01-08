package singleton;

import filesystem.Folder;

public class RootManager {
    private static Folder rootInstance;

    private RootManager() { }

    public static Folder getRootInstance() {
        if (rootInstance == null) {
            rootInstance = new Folder("root");
        }
        return rootInstance;
    }
}
