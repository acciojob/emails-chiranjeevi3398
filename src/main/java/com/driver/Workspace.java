package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar = new ArrayList<>(); // Stores all the meetings

    private LocalTime startTime;
    private LocalTime endTime;

    public Workspace(String emailId, int inboxCapacity, LocalTime startTime, LocalTime endTime) {
        super(emailId, inboxCapacity);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }



    public Workspace(String emailId) {
        super(emailId,Integer.MAX_VALUE);
        // The inboxCapacity is equal to the maximum value an integer can store.
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        calendar.add(meeting);
    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
        int count = 0;

        // Sort the meetings in the calendar in ascending order of end time
        Collections.sort(calendar, (m1, m2) -> m1.getEndTime().compareTo(m2.getEndTime()));

        // Initialize lastEndTime to the start time of the workday
        LocalTime lastEndTime = LocalTime.parse("00:00");

        // Loop through the meetings in the sorted calendar
        for (Meeting meeting : calendar) {
            // Add null check before accessing meeting's startTime and endTime fields
            if (meeting.getStartTime() != null && meeting.getEndTime() != null) {
                // If the start time of the current meeting is after or equal to lastEndTime, increment count
                try {
                    if (meeting.getStartTime().compareTo(lastEndTime) > 0) {
                        count++;
                        // Update lastEndTime to the end time of the current meeting
                        lastEndTime = meeting.getEndTime();
                    }
                }
                catch (Exception e)
                {
                    System.out.println("Error");
                }
            }
        }
        return count;
    }
}
