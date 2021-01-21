/**
 * 
 */
package fr.course.bll;

import java.util.List;

import fr.course.bo.Participant;

/**
 * @author var_dump
 *
 */
public class CourseManagerImpl implements CourseManager{
	
	//private ParticipantDAOImpl participantDAO = DAOFact.getParticipantDAO();

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
		} catch (ParticipantDAOException e) {
			e.printStackTrace();
			throw new ParticipantManagerException(e.getMessage());
		}
		
		return participant;
	}

	@Override
	public List<Participant> getAllParticipants() {
		// TODO Auto-generated method stub
		
//		try {
//			return participantDAO.getAll();
//		} catch(ParticipantDAOException e) {
//			e.printStackTrace();
//			throw new ParticipantManagerException(e.getMessage());
//		}
		
	}

}
