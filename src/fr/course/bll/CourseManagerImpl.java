/**
 * 
 */
package fr.course.bll;

import java.util.List;

import fr.course.bo.Participant;
import fr.course.dal.DALException;
import fr.course.dal.DAOFact;
import fr.course.dal.dao.ParticipantDAOImpl;

/**
 * @author var_dump
 *
 */
public class CourseManagerImpl implements CourseManager{
	
	private ParticipantDAOImpl participantDAO = DAOFact.getInstance();

	/*
	 *	Les contraintes sont les suivantes :

		les coureurs doivent être majeur

		il ne peut pas y avoir deux coureurs portant le même nom/prenom
	 * 
	 * */
	
	@Override
	public Participant addParticipant(Participant participant) throws ParticipantManagerException{
		// TODO Auto-generated method stub
				
		try {
			participantDAO.insert(participant);
		} catch (DALException e) {
			e.printStackTrace();
			throw new ParticipantManagerException(e.getMessage());
		}
		
		return participant;
	}

	@Override
	public List<Participant> getAllParticipants() throws ParticipantManagerException {
		// TODO Auto-generated method stub
		
		try {
			return participantDAO.getAll();
		} catch(DALException e) {
			e.printStackTrace();
			throw new ParticipantManagerException(e.getMessage());
		}
		
	}

}
