package lt.ehu.student.moneytrackerbeta.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface BaseDao<M> {
    boolean create(M m) throws Exception;
    boolean update(M m) throws Exception;
    boolean delete(M m) throws Exception;
    List<M> findAll() throws SQLException, IOException;
    M findById(int id) throws SQLException, IOException;
}
