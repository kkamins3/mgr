package com.mgr.agents.sample.behaviours;

import com.mgr.agents.sample.utility.Task;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;

import java.util.logging.Logger;

/**
 * Created by a on 19.04.16.
 */
public class TaskFSMBehaviour extends Behaviour {
    enum TaskState {
        ESTIMATING,
        PREPARING,
        ONTHEWAY,
        ACTION,
        DONE
    }
    private static final Logger logger = Logger.getLogger(MonitorBehaviour.class.getName());
    private TaskState state;
    private final Task task;

    private int estimation;
    public TaskFSMBehaviour(Agent a, Task task) {
        super(a);
        logger.info("");
        this.state = TaskState.ESTIMATING;
        this.task = task;
    }

    @Override
    public void action() {
        logger.info("");
    }

    @Override
    public boolean done() {
        logger.info("");
        return false;
    }
}
