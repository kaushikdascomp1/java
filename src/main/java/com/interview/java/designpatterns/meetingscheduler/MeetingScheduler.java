package com.interview.java.designpatterns.meetingscheduler;

import java.time.LocalDateTime;
import java.util.*;

public class MeetingScheduler {

    Set<Meeting> meetingSchedulerSet = new TreeSet<>();
    Map<String, Meeting> map = new HashMap<>();

    public static void main(String[] args) {
        MeetingScheduler ms = new MeetingScheduler();
        ms.addMeeting(new Meeting(900, 1000));
        ms.addMeeting(new Meeting(1030, 1100));
        ms.addMeeting(new Meeting(1101, 1130));
        ms.addMeeting(new Meeting(1131, 1245));

        ms.addMeeting(new Meeting(1105, 1145));
        ms.addMeeting(new Meeting(1205, 1345));


        Meeting meeting = ms.getMeeting(900, 1000);
        if (meeting != null) {
            System.out.println("Meeting is sheduled at : " + meeting.getStartTime());
        } else {
            System.out.println("Meeting does not exist");
        }

    }

    public void addMeeting(Meeting meeting) {
        if (!meetingSchedulerSet.contains(meeting)) {
            meetingSchedulerSet.add(meeting);
            map.put(String.valueOf(meeting.getStartTime() + meeting.getEndTime()), meeting);
        } else {
            System.out.println("Meeting with start time: " + meeting.getStartTime() + " and end time " + meeting.getEndTime() + " is conflicting with another meeting: ");
        }
    }

    public Meeting getMeeting(int startTime, int endTime) {
        return map.get(String.valueOf(startTime + endTime));
    }


}
