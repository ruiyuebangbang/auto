package com.autoboys.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SQLQuery;
import com.autoboys.domain.Member;
import com.autoboys.domain.ProviderRegion;
import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class MemberDAOImpl implements MemberDAO {
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;

	/**
	 * Used to save or update a member.
	 */
	public void saveOrUpdateMember(Member member) {
		try {
			session.saveOrUpdate(member);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			System.out.println(e.toString());
		}
	}
	/**
	 * Used to delete a member.
	 */
	
	public void deleteMember(Long memberId) {
		try {
			Member member = (Member) session.get(Member.class, memberId);
			session.delete(member);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} 
	}
	
	/**
	 * Used to list all the members.
	 */
	@SuppressWarnings("unchecked")
	public List<Member> listMember() {
		List<Member> courses = null;
		try {
			courses = session.createQuery("from Member").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}
	
	/**
	 * Used to list all the members.
	 */
	@SuppressWarnings("unchecked")
	public List<Member> listMemberByPro(Long pid) {
		List<Member> courses = null;
		try {
			// 
			Query q = session.createSQLQuery("select * from Member where provider_id=?").addEntity(Member.class);
			q.setLong(0, pid);
			courses = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}

	/**
	 * Used to query a single member by Id.
	 */
	
	public Member queryMemberById(Long memberId) {
		Member member = null;
		try {
			member = (Member) session.get(Member.class, memberId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}
	
	/**
	 * Used to query a single member by mobile phone.
	 */
	
	public Member queryMemberByMobilePhone(String mobilePhone) {
		try {
			SQLQuery query = session.createSQLQuery("select * from member where mobile_phone = ?");
			query.setParameter(0,mobilePhone);
			query.addEntity(Member.class);
			List<Member> members = query.list();
			if(members.size() ==0){
				return null;
			}else{
				return members.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * 
	 */
	public Member queryByNickName(String nickName) {
		try {
			SQLQuery query = session.createSQLQuery("select * from member where nick_name = ?");
			query.setParameter(0,nickName);
			query.addEntity(Member.class);
			List<Member> members = query.list();
			if(members.size() ==0){
				return null;
			}else{
				return members.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public Member queryByUserName(String userName) {
		try {
			SQLQuery query = session.createSQLQuery("select * from member where MOBIEPHONE = ? or email = ?");
			query.setParameter(0,userName);
			query.setParameter(1,userName);
			query.addEntity(Member.class);
			List<Member> members = query.list();
			if(members.size() ==0){
				return null;
			}else{
				return members.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public int modifyPassword(Member member) {
		int ret = 0;
		try {
			session.beginTransaction();  
			Query query = session.createSQLQuery("update Member t set t.password=? where id = ?");
			query.setString(0, member.getPassword());
			query.setLong(1,member.getId());
			ret = query.executeUpdate();  
			session.getTransaction().commit();  

		} catch (Exception e) {
			e.printStackTrace();		
		}
		return ret;
	}
}
