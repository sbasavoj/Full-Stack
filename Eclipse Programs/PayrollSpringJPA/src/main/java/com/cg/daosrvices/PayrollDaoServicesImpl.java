package com.cg.daosrvices;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.beans.Associate;
import com.cg.exception.PayrollServicesDownException;
@Component("daoServices")
public class PayrollDaoServicesImpl implements PayrollDaoServices{
	@Autowired
	EntityManagerFactory entityManagerFactory;
	@Override
	public int insertAssociate(Associate associate) throws PayrollServicesDownException {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(associate);
		entityManager.flush();
		entityManager.getTransaction().commit();
		entityManager.close();
		return associate.getAssociateId();
	}
	@Override
	public boolean updateAssociate(Associate associate) throws PayrollServicesDownException {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(associate);
		entityManager.flush();
		entityManager.getTransaction().commit();
		entityManager.close();
		return true;
	}
	@Override
	public boolean deleteAssociate(int associateId) throws PayrollServicesDownException {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Associate associate=entityManager.find(Associate.class, associateId);
		entityManager.remove(associate);
		entityManager.flush();
		entityManager.getTransaction().commit();
		entityManager.close();
		return false;
	}
	@Override
	public Associate getAssociate(int associateId) throws PayrollServicesDownException {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Associate associate=entityManager.find(Associate.class, associateId);
		entityManager.flush();
		entityManager.getTransaction().commit();
		entityManager.close();
		return associate;
	}
	@Override
	public List<Associate> getAssociates() throws PayrollServicesDownException {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		TypedQuery<Associate> query = entityManager.createQuery("Select e from Associate e",Associate.class);
		List<Associate> associates=query.getResultList();
		entityManager.flush();
		entityManager.getTransaction().commit();
		entityManager.close();
		return associates;
	}
}