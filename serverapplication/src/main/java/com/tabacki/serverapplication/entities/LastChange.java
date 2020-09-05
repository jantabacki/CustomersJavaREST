package com.tabacki.serverapplication.entities;

import java.sql.Timestamp;
import java.util.Date;

public class LastChange {
    private Timestamp lastChangeTimestamp;

    public LastChange() {
        lastChangeTimestamp = new Timestamp(new Date().getTime());
    }

    public void update() {
        lastChangeTimestamp = new Timestamp(new Date().getTime());
    }

    public long getLastChangeTimestamp() {
        return lastChangeTimestamp.getTime();
    }
}
