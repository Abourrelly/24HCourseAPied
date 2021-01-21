package fr.course.dal;

import java.util.List;

public interface DAOCRUD<E,K> {
	public E insert(E entite) throws DALException;
	public List<E> getAll() throws DALException;
	public E getFromId(K id) throws DALException;
	public void update(E entite) throws DALException;
	public void delete(E entite) throws DALException;

}
