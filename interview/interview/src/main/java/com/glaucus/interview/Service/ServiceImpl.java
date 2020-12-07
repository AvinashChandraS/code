package com.glaucus.interview.Service;

import org.hibernate.StaleObjectStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glaucus.interview.Beans.NumberId;
import com.glaucus.interview.DAO.ServiceDAO;
import com.glaucus.interview.DAO.ServiceDAOImpl;

@Service
public class ServiceImpl {
		
	@Autowired 
	private ServiceDAO dao;
	
	public long increase() {
		long val=0;
		
		synchronized (ServiceDAOImpl.class) {
			try {
				NumberId num=new NumberId();
				val=dao.getData();
				
				System.out.println("getting data"+val);
				dao.updateData(++val);
				System.out.println("data saved....");
				}catch (StaleObjectStateException e) {
					System.out.println("************** race condition occured, try again for perform this. *******************");
					
					
				}catch (Exception e) {
					throw e;
				}
			
		}
		
		
		return val;
	}
}
