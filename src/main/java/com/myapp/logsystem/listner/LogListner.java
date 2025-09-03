import java.io.*;
import java.nio.file.*;
import java.util.concurrent.*;

public class LogListener {

    private static final String LOG_FOLDER = "logs";

    public static void main(String[] args) throws IOException, InterruptedException {
        Path logDir = Paths.get(LOG_FOLDER);
        if (!Files.exists(logDir)) {
            Files.createDirectories(logDir);
        }

        WatchService watchService = FileSystems.getDefault().newWatchService();
        logDir.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_CREATE);

        System.out.println("Listening for log changes in folder: " + LOG_FOLDER);

        ExecutorService executor = Executors.newSingleThreadExecutor();

        while (true) {
            WatchKey key = watchService.take();

            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();
                Path fileName = (Path) event.context();

                if (kind == StandardWatchEventKinds.ENTRY_MODIFY || kind == StandardWatchEventKinds.ENTRY_CREATE) {
                    Path filePath = logDir.resolve(fileName);
                    executor.submit(() -> readNewLines(filePath.toFile()));
                }
            }

            boolean valid = key.reset();
            if (!valid) break;
        }

        executor.shutdown();
    }

    private static void readNewLines(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            System.out.println("Reading updated log file: " + file.getName());
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("[LOG] " + line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + file.getName());
            e.printStackTrace();
        }
    }
}
