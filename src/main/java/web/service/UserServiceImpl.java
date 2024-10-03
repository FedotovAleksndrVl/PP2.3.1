package web.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.model.User;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDaoHibernate;

    @Transactional
    @Override
    public void saveUser(User user) {
        userDaoHibernate.saveUser(user);
    }

    @Transactional
    @Override
    public User getUserById(Long id) {
        return userDaoHibernate.getUserById(id);
    }

    @Transactional
    @Override
    public void removeUserById(long id) {
        userDaoHibernate.removeUserById(id);
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDaoHibernate.getAllUsers();
    }

}

