package myapp.logsystem.generator;

import java.util.Random;

import java.util.concurrent.BlockingQueue;

public class LogGenerator implements Runnable {

    private final BlockingQueue<String> queue;

    private final String[] levels = {"INFO", "WARNING", "DEBUG", "ERROR"};

    private final Random random = new Random();

    public LogGenerator(BlockingQueue<String> queue) {

        this.queue = queue;

    }

    @Override

    public void run() {

        try {

            for (int i = 1; i <= 50; i++) {

                String level = levels[random.nextInt(levels.length)];

                String log = level + ": Log message " + i;

                queue.put(log);

                Thread.sleep(100);

            }

            queue.put("STOP"); // stop signal

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

        }

    }

}
 

