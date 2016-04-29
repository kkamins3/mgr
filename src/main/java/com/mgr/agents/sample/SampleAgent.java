package com.mgr.agents.sample;

import com.mgr.agents.sample.behaviours.IncrementBaseNumber;
import com.mgr.agents.sample.behaviours.MonitorBehaviour;
import com.mgr.agents.sample.behaviours.ReceiveTaskBehaviour;
import com.mgr.agents.sample.behaviours.TaskWaitBehaviour;
import com.mgr.agents.sample.utility.Position;
import com.mgr.agents.sample.utility.Status;
import com.mgr.agents.sample.utility.Task;
import jade.core.Agent;
import jade.util.leap.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

public class SampleAgent extends Agent {
    private final Status status = new Status(new Position(new Point(0, 0), 0));
    private static final Logger logger = LoggerFactory.getLogger(SampleAgent.class);

    @Override
    public void setup() {
        final String otherAgentName = (String) this.getArguments()[0];
        addBehaviour(new TaskWaitBehaviour(this, status));
        addBehaviour(new ReceiveTaskBehaviour(this, status));
        addBehaviour(new MonitorBehaviour(this, status, 20));
    }

    @Override
    public void takeDown() {
    }

    public Integer estimate(Task task) {
        return 0;
    }
}
