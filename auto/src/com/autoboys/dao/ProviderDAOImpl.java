package com.autoboys.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.autoboys.domain.*;
import com.autoboys.util.*;
public class ProviderDAOImpl implements ProviderDAO {
	
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;

	/**
	 * Used to save or update a provider.
	 */
	public void saveOrUpdateProvider(Provider provider) {
		try {
			session.saveOrUpdate(provider);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * Used to delete a provider.
	 */
	
	public void deleteProvider(Long providerId) {
		try {
			Provider provider = (Provider) session.get(Provider.class, providerId);
			session.delete(provider);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} 
	}
	
	/**
	 * Used to list all the providers.
	 */
	@SuppressWarnings("unchecked")
	public List<Provider> listProvider() {
		List<Provider> courses = null;
		try {
			courses = session.createQuery("from Provider").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}

	/**
	 * Used to list a single provider by Id.
	 */
	
	public Provider listProviderById(Long providerId) {
		Provider provider = null;
		try {
			provider = (Provider) session.get(Provider.class, providerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return provider;
	}

	/**
	 * 更新主要信息
	 */
	public int updateMainInfo(Provider provider) {
		int ret = 0;
		try {
			String sql = " update Provider set REGION_ID =?, SHORT_NAME=?,FULL_NAME=?, AGENT=?,TELEPHONE=?, "   
      + " SERVICE_PHONE=?,SERVICE_TIME=?,ADDRESS=?,REMARK=?,QUALIFICATION=?"
      + " where id = ?";
			session.beginTransaction();
			Query q = session.createQuery(sql);
			
			q.setLong(0, provider.getREGION_ID());
			q.setString(1, provider.getSHORT_NAME());
			q.setString(2, provider.getFULL_NAME());
			q.setString(3, provider.getAGENT());
			q.setString(4, provider.getTELEPHONE());
			q.setString(5, provider.getSERVICE_PHONE());
			q.setString(6, provider.getSERVICE_TIME());
			q.setString(7, provider.getADDRESS());
			q.setString(8, provider.getREMARK());
			q.setString(9, provider.getQUALIFICATION());
			q.setLong(10, provider.getID());
			ret = q.executeUpdate();
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return ret;
	}
	
	public int updateLogo(Provider prov) {
		int ret = 0;
		Connection conn = null;
		try {
			conn = ProxoolConnection.getConnection();
			CallableStatement cs = conn.prepareCall(" update provider set logo =? where id = ?");
			cs.setString(1,prov.getLOGO());
			cs.setLong(2, prov.getID());

			ret = cs.executeUpdate();
			
			//session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			//session.getTransaction().rollback();
		} finally {
			try {conn.close();}catch(Exception e){}
		}
		return ret;
	}
	
/*	public int updateLogo(Long id, String logo) {
		int ret = 0;
		try {
			String sql = " update provider set logo =? where id = ?";
			session.beginTransaction();
			Query q = session.createSQLQuery(sql);
			
			q.setString(0,logo);
			q.setLong(1, id);

			ret = q.executeUpdate();
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return ret;
	}*/
	
	public int updateImage(Long providerId,String imagePath,int index) {
		int ret = 0;
		Connection conn = null;
		try {
			conn = ProxoolConnection.getConnection();
			CallableStatement cs = conn.prepareCall("{Call p_update_provider_image(?,?)}");
			cs.setLong(1, providerId);
			cs.setString(2, imagePath);
			cs.executeUpdate();
			cs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			//session.getTransaction().rollback();
		} finally {
			try {conn.close();}catch(Exception e){}
		}
		return ret;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Provider> qryProviderList(int pageNo ,int pageSize) {
		List<Provider> list = new ArrayList<Provider>();
		try {
			java.sql.Connection conn = null;
			try {
				String sql = "select b.*,f_getRegionName(b.REGION_ID) regionName from (select a.*,rownum rn from (select * from provider order by status,apply_date) a where rownum<=?) b where rn >?";
				conn = ProxoolConnection.getConnection();
		        QueryRunner qRunner = new QueryRunner();   
		        list = (List<Provider>) qRunner.query(conn, sql, new BeanListHandler(Provider.class),pageNo*pageSize,(pageNo-1)*pageSize);
		        
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {conn.close();}catch(Exception e){}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}	
	
	
	public int qryCount() {
		int ret = 0;
		try {
			StringBuilder sb =  new StringBuilder("select count(1) from provider");
			Query q = session.createSQLQuery(sb.toString());
			ret = ((java.math.BigDecimal)q.uniqueResult()).intValue();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}	
}
