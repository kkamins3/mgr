package com.mgr.agents.sample.utility;

import java.util.LinkedList;

/**
 * Created by a on 19.04.16.
 */
public class Status {
    LinkedList<Task> taskList = new LinkedList<>();
    public Integer estimate(String task) {
        return null;
    }

    public Boolean addTask(String task) {
        return true;
    }

    public boolean update() {
        return true;
    }

    public boolean isAvailable() {
        return true;
    }
}
