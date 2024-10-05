package web.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDaoHibernate;

    @Override
    @Transactional
    public void saveUser(User user) {
        userDaoHibernate.saveUser(user);
    }

    @Override
    @Transactional
    public User getUserById(Long id) {
        return userDaoHibernate.getUserById(id);
    }

    @Override
    @Transactional
    public void removeUserById(long id) {
        userDaoHibernate.removeUserById(id);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDaoHibernate.getAllUsers();
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDaoHibernate.updateUser(user);
    }
}

