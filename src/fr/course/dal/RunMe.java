package fr.course.dal;


import fr.course.bo.Participant;
import fr.course.dal.dao.ParticipantDAOImpl;

public class RunMe {
    public static void main(String[] args) throws DALException {
        ParticipantDAOImpl test = new ParticipantDAOImpl();

        test.insert(new Participant( "Dupont",  "Jean",  60,  "HOMME", 53));
    }
}
