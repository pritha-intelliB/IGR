package com.igr.hibernate.util;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import com.igr.commonUtility.CommonOptionsVO;
import com.igr.commonUtility.CommonThriceOptionsVO;
import com.igr.hibernate.model.deedCategoryModel;
import com.igr.hibernate.model.deedTypeModel;
import com.igr.hibernate.model.feeStructureModel;
import com.igr.hibernate.model.partyTypeModel;
import com.igr.hibernate.model.provisionalTokenTypeModel;
import com.igr.hibernate.model.userLogModel;
import com.igr.registration.IssueFirstTokenAction;

public class HibernateManager extends HibernateUtil {

	private static final Logger log = Logger.getLogger(HibernateManager.class);

	public int addUserLog(userLogModel userLog) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int returnValue = 0;
		try {
			if (session != null) {
				session.beginTransaction();
				session.save(userLog);
				session.getTransaction().commit();
				returnValue = 1;
			} else
				returnValue = 0;

		} catch (Exception e) {
			session.getTransaction().rollback();
			log.fatal("Error " + e);
			returnValue = 0;
		} finally {
			if (session.isOpen())
				session.close();
		}
		return returnValue;

	}

	public int addFirstToken(provisionalTokenTypeModel tokenModel) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int returnValue = 0;
		try {
			if (session != null) {
				session.beginTransaction();
				session.save(tokenModel);
				session.getTransaction().commit();
				returnValue = 1;
			} else
				returnValue = 0;

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			returnValue = 0;
		} finally {
			if (session.isOpen())
				session.close();
		}
		return returnValue;

	}

	public int insertDeedTypeFeeStructure(deedTypeModel deedType,
			 List<partyTypeModel> model) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int returnValue = 0;
		try {
			if (session != null) {
				session.beginTransaction();
				session.save(deedType);
				ListIterator<partyTypeModel> listItr = model.listIterator();
				while (listItr.hasNext()) {
					partyTypeModel mode = (partyTypeModel) listItr.next();
					mode.setDeed_type_id(deedType.getDeed_type_id());
					session.save(mode);
				}

				session.getTransaction().commit();
				returnValue = 1;
			} else
				returnValue = 0;

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			returnValue = 0;
		} finally {
			if (session.isOpen())
				session.close();
		}
		return returnValue;

	}

	public List<CommonOptionsVO> searchDeedType(int language) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<CommonOptionsVO> deedTypeList= new ArrayList();
		try {
			if (session != null) {
				session.beginTransaction();
				
				Query q = session
						.createQuery(" SELECT deed_name,deed_type_id FROM deedTypeModel E WHERE E.lang_id ="
								+ language + "  ORDER BY E.deed_name  ");
				List<Object[]> deedTypes = (List<Object[]>) q.list();
				for (Object[] deedType : deedTypes) {
					CommonOptionsVO optionVO = new CommonOptionsVO(String.valueOf(deedType[1]),(String)deedType[0]);
					deedTypeList.add(optionVO);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return deedTypeList;

	}
	
	
	public int insertDeedCategory(deedCategoryModel deedCategory) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int returnValue = 0;
		try {
			if (session != null) {
				session.beginTransaction();
				session.save(deedCategory);
				session.getTransaction().commit();
				returnValue = 1;
			} else
				returnValue = 0;

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			returnValue = 0;
		} finally {
			if (session.isOpen())
				session.close();
		}
		return returnValue;

	}
	
	
	
	public List<CommonOptionsVO> searchDeedCategory(int language) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<CommonOptionsVO> deedTypeList= new ArrayList();
		try {
			if (session != null) {
				session.beginTransaction();
				
				Query q = session
						.createQuery(" SELECT category_name,deed_category_id FROM deedCategoryModel E WHERE E.lang_id ="
								+ language + "  ORDER BY E.category_name  ");
				List<Object[]> deedTypes = (List<Object[]>) q.list();
				for (Object[] deedType : deedTypes) {
					CommonOptionsVO optionVO = new CommonOptionsVO(String.valueOf(deedType[1]),(String)deedType[0]);
					deedTypeList.add(optionVO);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return deedTypeList;

	}

	
	
	
	
	public int insertFeeMaster(feeStructureModel feeMaster) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int returnValue = 0;
		try {
			if (session != null) {
				session.beginTransaction();
				session.save(feeMaster);
				session.getTransaction().commit();
				returnValue = 1;
			} else
				returnValue = 0;

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			returnValue = 0;
		} finally {
			if (session.isOpen())
				session.close();
		}
		return returnValue;

	}
}