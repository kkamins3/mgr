package com.mgr.agents.sample.behaviours;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

/**
 * Created by a on 19.04.16.
 */
public class ReceiveTaskBehaviour extends CyclicBehaviour {

    public ReceiveTaskBehaviour(Agent a) {
        super(a);
    }

    public void action() {
        MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.ACCEPT_PROPOSAL);
        ACLMessage msg = myAgent.receive(mt);
        if (msg != null) {
            // ACCEPT_PROPOSAL Message received. Process it
            String title = msg.getContent();
            ACLMessage reply = msg.createReply();

//            Integer price = (Integer) catalogue.remove(title);
//            if (price != null) {
                reply.setPerformative(ACLMessage.INFORM);
//                System.out.println(title+" sold to agent "+msg.getSender().getName());
//            }
//            else {
                // The requested book has been sold to another buyer in the meanwhile .
                reply.setPerformative(ACLMessage.FAILURE);
                reply.setContent("not-available");
//            }
            myAgent.send(reply);
        }
        else {
            block();
        }
    }
}
