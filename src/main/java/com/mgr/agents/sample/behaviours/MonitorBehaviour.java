package com.mgr.agents.sample.behaviours;

import com.mgr.agents.sample.utility.Status;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

/**
 * Created by a on 19.04.16.
 */
public class MonitorBehaviour extends TickerBehaviour {
    private final Status status;
    public MonitorBehaviour(Agent a, Status s, long period) {
        super(a, period);
        this.status = s;
    }

    @Override
    protected void onTick() {
        status.update();
    }
}
