package fr.course.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class DAOCRUDImpl<E,K> implements DAOCRUD<E,K>{
	protected String INSERT = "";
	protected String SELECT = "";
	protected String FROMID = "";
	protected String UPDATE = "";
	protected String DELETE = "";
	
	protected abstract void fillKey(E entite, ResultSet keyRs) throws SQLException;

	protected abstract void fillStatementForInsert(PreparedStatement stmt, E entite) throws SQLException;
	protected abstract void fillStatementForUpdate(PreparedStatement stmt, E entite) throws SQLException;
	protected abstract void fillStatementForDelete(PreparedStatement stmt, E entite) throws SQLException;

	protected abstract E createEntityFromResultSet(ResultSet rs) throws SQLException;


	@Override
	public E insert(E entite) throws DALException {
		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement stmt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			this.fillStatementForInsert(stmt,entite);
			int nbRows = stmt.executeUpdate();
			if (nbRows == 1) {
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					this.fillKey(entite,rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException("problème dans l'insertion");
		}
		return entite;
	}


	@Override
	public List<E> getAll() throws DALException {
		List<E> result = new ArrayList<E>();
		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement stmt = cnx.prepareStatement(SELECT);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				E entite = this.createEntityFromResultSet(rs);
				result.add(entite);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException("problème dans la selection");
		}
		return result;
	}


	@Override
	public E getFromId(K id) throws DALException {
		E entity = null;
		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement stmt = cnx.prepareStatement(FROMID);
			stmt.setObject(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				entity = this.createEntityFromResultSet(rs);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException("problème dans la selection");
		}
		return entity;

	}

	@Override
	public void update(E entite) throws DALException {
		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement stmt = cnx.prepareStatement(UPDATE);
			this.fillStatementForUpdate(stmt,entite);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException("problème dans la modification");
		}
	}


	@Override
	public void delete(E entite) throws DALException {
		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement stmt = cnx.prepareStatement(DELETE);
			this.fillStatementForDelete(stmt,entite);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException("problème dans l'effacement");
		}
	}

}
