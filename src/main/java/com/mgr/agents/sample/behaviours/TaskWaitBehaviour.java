package com.mgr.agents.sample.behaviours;
import com.mgr.agents.sample.utility.*;
import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

/**
 * Created by a on 19.04.16.
 */
public class TaskWaitBehaviour extends CyclicBehaviour {
    private final Status status;
    public TaskWaitBehaviour(Agent a, Status s) {
        super(a);
        this.status = s;
    }

    public void action() {
        MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.CFP);
        ACLMessage msg = myAgent.receive(mt);
        if (msg != null) {
            // CFP Message received. Process it
            String task = msg.getContent();
            ACLMessage reply = msg.createReply();

            Integer estimate = status.estimate(task);
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
//            myAgent.send(reply);
        }
        else {
            block();
        }
    }
}
