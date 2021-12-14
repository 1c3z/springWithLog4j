package com.example.task;

import com.example.controller.Index;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task implements Runnable {
    private static final Logger LOGGER = LogManager.getLogger(Index.class);

    private String msg;

    @Override
    public void run() {
        this.sleep();
        Task.LOGGER.info(Thread.currentThread().getName() + "异步日志任务, " + this.msg);
    }

    public void setMsg(String msg){
        if (msg == null){
            msg = "null";
        }
        this.msg = msg;
    }

    private void sleep(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void asyncLog(String msg){
        Task task = new Task();
        task.setMsg(msg);
        new Thread(task).start();
    }
}
