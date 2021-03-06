package ImageHoster.repository;

import ImageHoster.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

@Repository
public class CommentRepository {
    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;
    /**
     * @param comment
     * Method will add comment in DB for the respective picture
     */
    public void addComment(Comment comment) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try
        {
            transaction.begin();
            em.persist(comment);
            transaction.commit();
        }
        catch (Exception e) {  transaction.rollback(); }
    }
}