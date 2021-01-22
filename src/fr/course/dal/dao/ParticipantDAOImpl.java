package fr.course.dal.dao;

import fr.course.bo.Participant;
import fr.course.dal.DAOCRUDImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ParticipantDAOImpl extends DAOCRUDImpl<Participant, Integer> {

	public ParticipantDAOImpl() {
		INSERT = "INSERT INTO Course.Participant (NOM, PRENOM, AGE, SEXE, NUMDOSSARD, EQUIPE) VALUES (?,?,?,?,?,?)";
		SELECT = "SELECT ID, NOM, PRENOM, AGE, SEXE, NUMDOSSARD, EQUIPE, NBTOURS FROM Course.Participant";
		FROMID = "SELECT ID, NOM, PRENOM, AGE, SEXE, NUMDOSSARD, EQUIPE, NBTOURS FROM Course.Participant WHERE ID = ?";
		UPDATE = "UPDATE Course.Participant SET NBTOURS=?";
		DELETE = "DELETE FROM Course.Participant WHERE ID=?";
	}

	@Override
	protected void fillStatementForInsert(PreparedStatement stmt, Participant entite) throws SQLException {
		stmt.setString(1, entite.getNom());
		stmt.setString(2, entite.getPrenom());
		stmt.setInt(3, entite.getAge());
		stmt.setString(4, entite.getSexe());
		stmt.setInt(5, entite.getnDossard());
		if(entite.getEquipe() != null){
			stmt.setString(6, entite.getEquipe());
		}else{
			stmt.setString(6, null);
		}
	}

	@Override
	protected Participant createEntityFromResultSet(ResultSet rs) throws SQLException {
		Participant participant = new Participant(
				rs.getInt("ID"),
				rs.getString("nom"),
				rs.getString("prenom"),
				rs.getInt("age"),
				rs.getString("sexe"),
				rs.getInt("age"),
				rs.getInt("NBTOURS")
		);
		if(rs.getString("EQUIPE") != null) participant.setEquipe(rs.getString("EQUIPE"));
		return participant;
	}

	@Override
	protected void fillKey(Participant entite, ResultSet keyRs) throws SQLException {
		entite.setId(keyRs.getInt(1));
	}

	@Override
	protected void fillStatementForUpdate(PreparedStatement stmt, Participant entite) throws SQLException {
		stmt.setInt(1, entite.getNbTours());
	}

	@Override
	protected void fillStatementForDelete(PreparedStatement stmt, Participant entite) throws SQLException {
		stmt.setInt(1, entite.getId());
	}

}
