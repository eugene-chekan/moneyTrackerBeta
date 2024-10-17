package lt.ehu.student.moneytrackerbeta.dao;

import lt.ehu.student.moneytrackerbeta.exception.DaoException;

import java.sql.SQLException;
import java.util.List;

public interface BaseDao<T> {
    boolean create(T t) throws DaoException, SQLException;
    boolean update(T t) throws DaoException;
    boolean delete(T t) throws DaoException;
    List<T> findAll() throws DaoException, SQLException;
    T findById(int id) throws DaoException;
}
