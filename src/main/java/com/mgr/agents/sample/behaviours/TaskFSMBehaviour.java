package com.mgr.agents.sample.behaviours;

import com.mgr.agents.sample.utility.Task;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;

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
    private TaskState state;
    private Task task;

    private int estimation;
    public TaskFSMBehaviour(Agent a, Task task) {
        super(a);
        this.state = TaskState.ESTIMATING;
        this.task = task;
    }

    @Override
    public void action() {

    }

    @Override
    public boolean done() {
        return false;
    }
}
