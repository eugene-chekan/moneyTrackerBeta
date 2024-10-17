package lt.ehu.student.moneytrackerbeta.dao.impl;

import lt.ehu.student.moneytrackerbeta.connection.ConnectionPool;
import lt.ehu.student.moneytrackerbeta.dao.BaseDao;
import lt.ehu.student.moneytrackerbeta.exception.DaoException;
import lt.ehu.student.moneytrackerbeta.model.Asset;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AssetDao implements BaseDao<Asset> {
    private static final Logger logger = LogManager.getLogger(AssetDao.class);
    private static final String SELECT_ASSETS_BY_USER_ID = "SELECT id, user_id, name, description, init_balance, current_balance, currency FROM public.asset WHERE user_id = ?";
    private static final String INSERT_ASSET = "INSERT INTO public.asset (user_id, name, description, init_balance, current_balance, currency) VALUES (?, ?, ?, ?, ?, ?)";
    @Override
    public boolean create(Asset asset) throws DaoException, SQLException {
        logger.info("Creating new asset: {}", asset.getName());
        PreparedStatement statement;
        Connection connection = null;
        // Implement the logic to add a user to the database
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(INSERT_ASSET);

            statement.setInt(1, asset.getUserId());
            statement.setString(2, asset.getName());
            statement.setString(3, asset.getDescription());
            statement.setBigDecimal(4, asset.getInitBalance());
            statement.setBigDecimal(5, asset.getCurrentBalance());
            statement.setInt(6, asset.getCurrency());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.error("Error while adding new asset to the database", e);
            throw new DaoException("Error while adding new asset to the database", e);
        }
    }

    @Override
    public boolean update(Asset asset) throws DaoException {
        return false;
    }

    @Override
    public boolean delete(Asset asset) throws DaoException {
        return false;
    }

    @Override
    public List<Asset> findAll() throws DaoException, SQLException {
        return List.of();
    }

    public List<Asset> findAllByUserId(int userId) throws DaoException, SQLException {
        logger.info("Finding all assets by user ID: {}", userId);
        PreparedStatement statement;
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SELECT_ASSETS_BY_USER_ID);
            statement.setInt(1, userId);
            var resultSet = statement.executeQuery();
            var assets = new java.util.ArrayList<Asset>();
            while (resultSet.next()) {
                var asset = new Asset(
                        resultSet.getString("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getBigDecimal("init_balance"),
                        resultSet.getBigDecimal("current_balance"),
                        resultSet.getInt("currency")
                );
                assets.add(asset);
            }
            return assets;
        } catch (SQLException e) {
            logger.error("Error while retrieving assets from the database", e);
            throw new DaoException("Error while retrieving assets from the database", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().releaseConnection(connection);
            }
        }
    }

    @Override
    public Asset findById(int id) throws DaoException {
        return null;
    }
}
