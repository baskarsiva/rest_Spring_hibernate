package dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.EmployeeUser;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactoryDB() {
		return sessionFactory;
	}

	@Override
	public EmployeeUser getUser(String userId) {
		Session session = sessionFactory.openSession();

		TypedQuery query = (TypedQuery) session.createQuery("from user u");
		List<EmployeeUser> list = query.getResultList();

		Iterator<EmployeeUser> itr = list.iterator();
		EmployeeUser user = null;
		while (itr.hasNext()) {
			user = itr.next();
			System.out.println(user.getUserId() + " " + user.getPassword());
		}

		session.close();
		System.out.println("success");

		return user;
	}

	
	// Query query = session.createQuery("insert into Stock(stock_code, stock_name)" +
// "select stock_code, stock_name from backup_stock");
// int result = query.executeUpdate();

	@Override
	public String saveUser(EmployeeUser user) {
		try {
			Session session = sessionFactory.openSession();
			Transaction t = session.beginTransaction();
			
			Query query = (Query) session.createQuery("insert into employee("+user.getUserId()+", "+user.getPassword()+")" +
					"select id, password from employee");
			System.out.println(query);
			 int result = query.executeUpdate();
			 
//			session.save(user);
			t.commit();
			session.close();
			System.out.println("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

}
