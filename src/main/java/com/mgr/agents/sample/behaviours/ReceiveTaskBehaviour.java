package com.mgr.agents.sample.behaviours;

import com.mgr.agents.sample.utility.Status;
import com.mgr.agents.sample.utility.Task;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Created by a on 19.04.16.
 */
public class ReceiveTaskBehaviour extends CyclicBehaviour {
    private static final Logger logger = Logger.getLogger(MonitorBehaviour.class.getName());
    private final Status status;
    public ReceiveTaskBehaviour(Agent a, Status s) {
        super(a);
        logger.info("");
        this.status = s;
    }

    public void action() {
        logger.info("");
        MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.ACCEPT_PROPOSAL);
        ACLMessage msg = myAgent.receive(mt);
        if (msg != null) {
            logger.info("message not null");
            // ACCEPT_PROPOSAL Message received. Process it
            String task = msg.getContent();
            ACLMessage reply = msg.createReply();

            if (status.addTask(task)) {
                logger.info(task.toString()+" Added to the queue");
                reply.setPerformative(ACLMessage.INFORM);
            }
            else {
                // The requested book has been sold to another buyer in the meanwhile .
                logger.info("Could not add task");
                reply.setPerformative(ACLMessage.FAILURE);
                reply.setContent("Failed to receive task");
            }
            myAgent.send(reply);
        }
        else {
            logger.info("Waiting for messages");
            block();
        }
    }
}
