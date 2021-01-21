/**
 * 
 */
package fr.course.bll;

import java.util.List;
import java.util.stream.Collectors;

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
	
	// 	BL : ajouter la méthode tourValided(Participant) qui incrémente ce nombre de tour
	
	@Override
	public void tourValided(Participant participant) throws ParticipantManagerException {
		// TODO Auto-generated method stub
		
		// 	saisie des passages en entrant un numéro de dossard et en le validant
		
		participant.setNbTours(participant.getNbTours()+1);
		
		try {
			participantDAO.update(participant);
		} catch(DALException e) {
			e.printStackTrace();
			throw new ParticipantManagerException(e.getMessage());
		}
		
	}
	
	public List<Participant> getClassementBySexe(String sexe) throws ParticipantManagerException {
		
		return getAllParticipants().stream().
									filter(x->x.getSexe() == sexe).
									sorted((o1, o2)->Integer.valueOf(o1.getNbTours()).compareTo(o2.getNbTours())).
									collect(Collectors.toList());

	}

}
