package com.mgr.agents.sample.behaviours;
import com.mgr.agents.sample.utility.*;
import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import java.util.logging.Logger;

/**
 * Created by a on 19.04.16.
 */
public class TaskWaitBehaviour extends CyclicBehaviour {
    private static final Logger logger = Logger.getLogger(MonitorBehaviour.class.getName());
    private final Status status;
    public TaskWaitBehaviour(Agent a, Status s) {
        super(a);
        logger.info("");
        this.status = s;
    }

    public void action() {
        logger.info("");
        MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.CFP);
        ACLMessage msg = myAgent.receive(mt);
        if (msg != null) {
            logger.info("Message received");
            // CFP Message received. Process it
            String task = msg.getContent();
            ACLMessage reply = msg.createReply();

            Integer estimate = status.estimate(task);
            logger.info("Task estimate " + estimate.toString());
            if (estimate != null) {
                // The requested book is available for sale. Reply with the price
                reply.setPerformative(ACLMessage.PROPOSE);
                reply.setContent(String.valueOf(estimate.intValue()));
            }
            else {
                // The requested book is NOT available for sale.
                reply.setPerformative(ACLMessage.REFUSE);
                reply.setContent("not-interested");
            }
            myAgent.send(reply);
        }
        else {
            block();
        }
    }
}
