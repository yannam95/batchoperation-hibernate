package batchoperation;

import org.hibernate.Session;
import org.hibernate.Transaction;



public class Batchdemo {

	public static void main(String[] args) {
		Transaction tx =  null;
		int batchSize = 25;
		try(Session session = HibernateUtil.getSessionFactory().openSession() ) {
			tx = session.beginTransaction();
		//	for ( int i = 1; i <= 100_000; i++ ) {
			for ( int i = 1; i <= 1000; i++ ) {//Keeping number of records less for demo purpose
				Item  itm = new Item();
				itm.setItemno(i);
				
				session.persist(itm);
				if ( i > 0 && i % batchSize == 0 ) {
					System.out.println("batch is ready to be flushed to database");
		            
		            session.flush();
		            session.clear();
		        }
		    }
			tx.commit();
		} catch (Exception e) {
			if(tx != null && tx.isActive())
				tx.rollback();
			throw e;
		}
	}
}