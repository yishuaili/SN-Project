package com.sn.mycircle.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.sn.mycircle.utils.MyCircleEntity;

/**
 * 
 * @author MJ_Lee
 *
 * @param <T> Entity
 */
public class GenericDaoJpa<T extends MyCircleEntity> implements GenericDao<T> {
	
	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	protected EntityManager entityManager;
	
	protected Class<T> entityType;
	
	protected static Logger logger = Logger.getLogger(GenericDaoJpa.class); 
	
	/**
	 * Constructor.
	 * @param entityType the class of the persistent objects managed by this DAO.
	 */
	public GenericDaoJpa(Class<T> entityType) {
		this.entityType = entityType;
	}

	@Override
	@Transactional(readOnly=true)
	public T get(Integer id) {
		logger.debug(" Get "+entityType.getName()+" by id");
		if (id == null) {
			logger.error(" id required");
			return null;
		} else {			
			return entityManager.find(entityType, id);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<T> getAll() {
		logger.debug(" Get all "+entityType.getName());
		Query query = entityManager.createQuery("select o from " + entityType.getName() + " o");
		return query.getResultList();
	}

	@Override
	public void persist(T object) {
		logger.debug(" Save the object "+object.getClass().getName());		
		entityManager.persist(object);
	}

	@Override
	public void delete(T object) {
		logger.debug(" Delete the object "+object.getClass().getName());
		entityManager.remove(object);

	}

}
