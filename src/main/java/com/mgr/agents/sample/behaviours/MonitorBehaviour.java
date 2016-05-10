package com.mgr.agents.sample.behaviours;

import com.mgr.agents.sample.utility.Status;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

import java.util.logging.Logger;

/**
 * Created by a on 19.04.16.
 */
public class MonitorBehaviour extends TickerBehaviour {
    private static final Logger logger = Logger.getLogger(MonitorBehaviour.class.getName());
    private final Status status;
    public MonitorBehaviour(Agent a, Status s, long period) {
        super(a, period);
        logger.info("");
        this.status = s;
    }

    @Override
    protected void onTick() {
        logger.info("Updating Status");
        status.update();
    }
}
