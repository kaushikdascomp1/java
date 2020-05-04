package com.interview.java.designpatterns.meetingscheduler;

import java.time.LocalDateTime;

public class Meeting implements Comparable<Meeting> {

    private Integer startTime;
    private Integer endTime;

    public Meeting(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Meeting o) {
        if (o.getStartTime().compareTo(this.getEndTime()) > 0)
            return 1;
        else if (o.getEndTime().compareTo(this.startTime) < 0)
            return -1;
        else
            return 0;
    }


    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }


    @Override
    public String toString() {
        return "Meeting{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
