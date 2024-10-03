package web.dao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public UserDaoImpl() {
    }

    @Override
    public void saveUser(User user) {

        EntityTransaction entityTr = null;
        try
        {
            entityTr = entityManager.getTransaction();
            entityTr.begin();
            entityManager.persist(user);
            entityTr.commit();
        } catch (Exception e) {
            if ( entityTr != null && entityTr.isActive() ) {
                entityTr.rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public void removeUserById(long id) {

        final String sql = "DELETE FROM User user WHERE user.id =:id";

        EntityTransaction entityTr = null;
        try {
            entityTr = entityManager.getTransaction();
            entityTr.begin();
            int result = entityManager.createNativeQuery(sql).setParameter("id", id).executeUpdate();
            entityTr.commit();
            if (result == 0) {
                throw new OptimisticLockException(" product modified concurrently");
            }
        }
        catch ( Throwable e ) {
            if ( entityTr != null && entityTr.isActive() ) {
                entityTr.rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<User> getAllUsers() {

        final String sql = "FROM User";

        EntityTransaction entityTr = null;
        try
        {
            entityTr = entityManager.getTransaction();
            entityTr.begin();
            List<User> users = entityManager.createNativeQuery(sql, User.class).getResultList();
            entityTr.commit();
            return users;
        } catch (Exception e) {
            if ( entityTr != null && entityTr.isActive() ) {
                entityTr.rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
    }
}

