package f.niosecond;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class WatcherSample extends Thread {
    private String dirName;

    public WatcherSample(String dirName) {
        this.dirName = dirName;
    }

    public static void main(String[] args) throws InterruptedException {
        String dirName = "D:" + File.separator + "godOfJava";
        String fileName = "WatcherSample.txt";
        WatcherSample sample = new WatcherSample(dirName);

        sample.setDaemon(true);
        sample.start();

        Thread.sleep(1000);

        for (int i = 0; i < 10; i++) {
            sample.fileWriteDelete(dirName, fileName + i);
        }
    }

    private void fileWriteDelete(String dirName, String fileName) {
        Path path = Paths.get(dirName, fileName);
        String contents = "Watcher Sample";
        StandardOpenOption openOption = StandardOpenOption.CREATE;

        try {
            System.out.printf("Write %s", fileName);
            Files.write(path, contents.getBytes(), openOption);
            Files.delete(path);
            Thread.sleep(1000);
        } catch (IOException | InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("--- [ Watcher thread is start ] ---");
        System.out.format("Dir = %s \n", dirName);
        addWatcher();
    }

    private void addWatcher() {
        try {
            Path dir = Paths.get(dirName);
            WatchService watcher = FileSystems.getDefault().newWatchService();

            // register method 를 이용하여 어떤 작업에 대해서 감시할것인지를 지정한다.
            dir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);

            while (true) {
                WatchKey watchKey = watcher.take();
                List<WatchEvent<?>> eventList = watchKey.pollEvents();

                /*
                * register 를 이용하여 등록한 이벤트중 한가지가 발생하면 watcher 에 해당 이벤트가 등록되고, take 메소드로 전달된다.
                * */
                for (WatchEvent<?> event : eventList) {
                    Path name = (Path) event.context();

                    if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                        System.out.format("%s created\n", name);
                    } else if (event.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
                        System.out.format("%s deleted\n", name);
                    } else if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                        System.out.format("%s modified\n", name);
                    }
                }

                watchKey.reset();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
