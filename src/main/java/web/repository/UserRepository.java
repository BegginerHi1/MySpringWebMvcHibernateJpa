package web.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    private final EntityManager em;


    @Autowired
    public UserRepository(EntityManager em) {
        this.em = em;
    }

    public List<User> list() {
        return em.createQuery("from User", User.class).getResultList();
    }

    public User user(int id) {
        return em.find(User.class,id);
    }

    public void save(User user) {
        em.persist(user);
        em.flush();
    }

    public void update(User user,int id) {
        em.merge(user);
        em.flush();
    }

    public void delete(int id) throws NullPointerException {
        User user = user(id);
        if (user == null) {
            throw new NullPointerException("User not found");
        }
        em.remove(user);
        em.flush();
    }
}
