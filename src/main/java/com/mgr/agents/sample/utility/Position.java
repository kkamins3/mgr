package com.mgr.agents.sample.utility;

import java.awt.*;

/**
 * Created by a on 29.04.16.
 */
public class Position {
    private Point position;
    private Integer height;

    public Position(Position p) {
        position = new Point(p.position);
        height = new Integer(p.height);
    }

    public Position(Point position, Integer heights) {
        this.position = position;
        this.height = heights;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeights(Integer heights) {
        this.height = heights;
    }
}
