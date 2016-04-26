package com.mgr.agents.sample.behaviours;

import com.mgr.agents.sample.utility.Status;
import com.mgr.agents.sample.utility.Task;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import java.util.ArrayList;

/**
 * Created by a on 19.04.16.
 */
public class ReceiveTaskBehaviour extends CyclicBehaviour {
    private final Status status;
    public ReceiveTaskBehaviour(Agent a, Status s) {
        super(a);
        this.status = s;
    }

    public void action() {
        MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.ACCEPT_PROPOSAL);
        ACLMessage msg = myAgent.receive(mt);
        if (msg != null) {
            // ACCEPT_PROPOSAL Message received. Process it
            String task = msg.getContent();
            ACLMessage reply = msg.createReply();

            if (status.addTask(task)) {
                reply.setPerformative(ACLMessage.INFORM);
                System.out.println(task.toString()+" Added to the queue");
            }
            else {
                // The requested book has been sold to another buyer in the meanwhile .
                reply.setPerformative(ACLMessage.FAILURE);
                reply.setContent("Failed to receive task");
            }
            myAgent.send(reply);
        }
        else {
            block();
        }
    }
}
