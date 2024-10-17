package lt.ehu.student.moneytrackerbeta.service;

import lt.ehu.student.moneytrackerbeta.exception.ServiceException;
import lt.ehu.student.moneytrackerbeta.model.Asset;

import java.util.List;

public interface UserService {
    boolean verifyLogin(String username, String password) throws ServiceException;

    boolean registerUser(String username, String password, String firstName, String lastName, String email) throws ServiceException;

    boolean isUsernameTaken(String username) throws ServiceException;

    String getFirstName(String username) throws ServiceException;

    int getUserId(String username) throws ServiceException;

    List<Asset> findAssets(int userId) throws ServiceException;
}
