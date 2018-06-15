package com.cg.daosrvices;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.beans.Associate;
import com.cg.exception.PayrollServicesDownException;
@Component("daoServices")
public class PayrollDaoServicesImpl implements PayrollDaoServices{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public int insertAssociate(Associate associate) throws PayrollServicesDownException {
		Session session=sessionFactory.openSession();
		int associateId=(int) session.save(associate);
		session.close();
		return associateId;
	}
	@Override
	public boolean updateAssociate(Associate associate) throws PayrollServicesDownException {
		Session session=sessionFactory.openSession();
		session.update(associate);
		session.flush();
		session.close();
		return true;
	}

	@Override
	public boolean deleteAssociate(int associateId) throws PayrollServicesDownException {
		Session session=sessionFactory.openSession();
		Query query = session.createQuery("delete from Associate where id= :associateId");
		query.setInteger("associateId", associateId);
		session.flush();
		session.close();
		return true;
	}

	@Override
	public Associate getAssociate(int associateId) throws PayrollServicesDownException {
		Session session=sessionFactory.openSession();
		Query query = session.createQuery("from Associate where associateId= :associateId");
		query.setInteger("associateId", associateId);
		Associate associate = (Associate) query.uniqueResult();
		session.close();
		return associate;
	}

	@Override
	public List<Associate> getAssociates() throws PayrollServicesDownException {
		Session session=sessionFactory.openSession();
		/*Query query = session.createQuery("from Student");
        List<Associate> associates = (List<Associate>) query.list();*/
		List<Associate> associates=session.createQuery("FROM Student").list();
		session.close();
		return   associates;
	}

}
