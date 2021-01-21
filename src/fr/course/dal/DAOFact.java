package fr.course.dal;
import fr.course.dal.dao.ParticipantDAOImpl;

public class DAOFact {
	public static ParticipantDAOImpl getInstance() {
		return new ParticipantDAOImpl();
	}
}
