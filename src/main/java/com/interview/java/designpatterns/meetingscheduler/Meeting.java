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
        if (this.getEndTime().compareTo(o.getStartTime())<0)
            return -1;
        else if (this.startTime.compareTo(o.getEndTime()) >0)
            return 1;
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
