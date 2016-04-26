package com.mgr.agents.sample;

import com.mgr.agents.sample.behaviours.IncrementBaseNumber;
import com.mgr.agents.sample.utility.Status;
import jade.core.Agent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleAgent extends Agent {
    private final Status status = new Status();
    private static final Logger logger = LoggerFactory.getLogger(SampleAgent.class);

    @Override
    public void setup() {
        final String otherAgentName = (String) this.getArguments()[0];
        addBehaviour(new IncrementBaseNumber(this, otherAgentName));
    }

    @Override
    public void takeDown() {
    }
}