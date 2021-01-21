package fr.course.bll;

import fr.course.bo.Participant;

import java.util.List;

public interface CourseManager {
    public Participant addParticipant(Participant participant);
    public List<Participant> getAllParticipants();
    
}
