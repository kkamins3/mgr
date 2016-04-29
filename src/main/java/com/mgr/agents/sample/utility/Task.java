package com.mgr.agents.sample.utility;

/**
 * Created by a on 19.04.16.
 */
public class Task {
    private final Integer riseSpeed = new Integer(2);
    private final Integer fallSpeed = new Integer(1);
    private final Integer horizontalSpeed = new Integer(4);
    private final Integer recordingConstant = new Integer(120);
    private Integer estimation = null;
    private final String task;

    public Integer getEstimation() {
        return estimation;
    }

    private Position destination;
    public Task(String t) {
        task = t;
    }

    public int estimate(Position position) {
        if (estimation == null) {
            estimation = new Integer(0);
            estimation += Math.abs(position.getPosition().x - destination.getPosition().x) * horizontalSpeed;
            estimation += Math.abs(position.getPosition().y - destination.getPosition().y) * horizontalSpeed;
            estimation += Math.abs(position.getHeight() - destination.getHeight()) * riseSpeed;
            estimation += recordingConstant;
        }
        return estimation;
    }

    public Position getDestination() {
        if (destination == null) {
            destination = TaskParser.parseTask(task);
        }
        return destination;
    }
}
