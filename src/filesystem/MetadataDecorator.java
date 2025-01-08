package filesystem;

import java.time.LocalDateTime;

public class MetadataDecorator extends FileSystemItem {
    private final FileSystemItem item;
    private final LocalDateTime creationDate;
    private final long size;

    public MetadataDecorator(FileSystemItem item, long size) {
        super(item.getName());
        this.item = item;
        this.creationDate = LocalDateTime.now();
        this.size = size;
    }

    @Override
    public void list() {
        System.out.println(item.getName() + " (Size: " + size + " bytes, Created: " + creationDate + ")");
    }
}
