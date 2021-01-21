package fr.course.dal.dao;

import fr.course.bo.Participant;
import fr.course.dal.DAOCRUDImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ParticipantDAOImpl extends DAOCRUDImpl<Participant, Integer> {

	public ParticipantDAOImpl() {
		INSERT = "INSERT INTO Course.Participant (immat,nbPlace) VALUES (?,?)";
		SELECT = "SELECT idCar,immat,nbPlace FROM car";
		FROMID = "SELECT idCar,immat,nbPlace FROM car WHERE idCar = ?";
		UPDATE = "UPDATE car SET immat=?, nbPlace=? WHERE idCar = ?";
		DELETE = "DELETE FROM car WHERE idCar=?";
	}

	@Override
	protected void fillKey(Participant entite, ResultSet keyRs) throws SQLException {
		entite.setId(keyRs.getInt(1));
	}

	@Override
	protected void fillStatementForInsert(PreparedStatement stmt, Participant entite) throws SQLException {
		stmt.setString(1, entite.getNom());
		stmt.setString(2, entite.getPrenom());
		stmt.setInt(3, entite.getAge());
		stmt.setString(4, entite.getSexe());
		stmt.setInt(5, entite.getnDossard());

	}

	@Override
	protected void fillStatementForUpdate(PreparedStatement stmt, Participant entite) throws SQLException {

	}

	@Override
	protected void fillStatementForDelete(PreparedStatement stmt, Participant entite) throws SQLException {

	}

	@Override
	protected Participant createEntityFromResultSet(ResultSet rs) throws SQLException {
		return new Participant(
				rs.getString("nom"),
				rs.getString("prenom"),
				rs.getInt("age"),
				rs.getString("sexe"),
				rs.getInt("age")
		);
	}

	@Override
	protected void fillKey(Car entite, ResultSet keyRs) throws SQLException {
		entite.setIdCar(keyRs.getInt(1));
	}

	@Override
	protected void fillStatementForInsert(PreparedStatement stmt, Car entite) throws SQLException {
		stmt.setString(1, entite.getImmat());
		stmt.setInt(2, entite.getNbPlaces());
	}

	@Override
	protected void fillStatementForUpdate(PreparedStatement stmt, Car entite) throws SQLException {
		stmt.setString(1, entite.getImmat());
		stmt.setInt(2, entite.getNbPlaces());
		stmt.setInt(3, entite.getIdCar());
	}

	@Override
	protected void fillStatementForDelete(PreparedStatement stmt, Car entite) throws SQLException {
		stmt.setInt(1, entite.getIdCar());
	}

}
