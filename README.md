# Text-Based File Explorer

## Program Description
This program is a console-based file explorer written in Java. It allows users to manage files and folders dynamically using various design patterns.

## Self Completed
This project was completed by Tawananyasha Murambinda.

## Design Patterns

### 1. Creational Patterns
- **Factory Method**: Dynamically creates files and folders (`FileSystemFactory`).
- **Singleton**: Manages a single instance of the root folder (`RootManager`).

### 2. Structural Patterns
- **Composite**: Represents hierarchical folder structures (`Folder`, `File`).
- **Decorator**: Adds metadata to files and folders (`MetadataDecorator`).

### 3. Behavioral Patterns
- **Command**: Encapsulates file operations (`CreateCommand`, `DeleteCommand`, `ListCommand`).
- **Observer**: Notifies observers when folder contents change (`Folder` and `FolderObserver`).

## How to Run
1. Clone the repository: `git clone <repo-url>`.
2. Import the project into IntelliJ IDEA.
3. Run `Main.java`.

## Example Commands
- `create file example.txt`
- `create folder myFolder`
- `list`
- `delete example.txt`
- `exit`
