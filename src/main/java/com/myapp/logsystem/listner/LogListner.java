package com.mycompany.logsystem.listener;

import java.util.concurrent.BlockingQueue;

public class LogListener implements Runnable {

    private final BlockingQueue<String> queue;

    private String latestLog;

    public LogListener(BlockingQueue<String> queue) {

        this.queue = queue;

    }

    public String getLatestLog() {

        return latestLog;

    }

    @Override

    public void run() {

        try {

            while (true) {

                String log = queue.take();

                if ("STOP".equals(log)) break;

                latestLog = log;

                System.out.println("[Listener] Received: " + log);

            }

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

        }

    }

}
 
