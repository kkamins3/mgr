package com.mgr.agents.sample.utility;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by a on 19.04.16.
 */
public class Status {
    private Position currentPosition;
    private LinkedList<Task> taskList = new LinkedList<>();

    public Status(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Integer estimate(String task) {
        Task t = new Task(task);
        if (t == null) {
            return -1;
        }
        Integer estimation = new Integer(0);
        Position previousPosition = new Position(currentPosition);
        for (Task element: taskList) {
            estimation += element.estimate(previousPosition);
            previousPosition = element.getDestination();
        }
        estimation += t.estimate(previousPosition);
        return estimation;
    }

    public Boolean addTask(String task) {
        Task t = new Task(task);
        if (t == null) {
            return false;
        }
        taskList.push(t);
        return true;

    }

    public Task getTask() {
        return taskList.pop();
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public boolean update() {
        return true;
    }

    public boolean isAvailable() {
        return true;
    }
}
