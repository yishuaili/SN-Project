package com.sn.mycircle.dao;

import java.util.List;

import com.sn.mycircle.utils.MyCircleEntity;

/**
 * Generic CRUD operation.
 * 
 * @author MJ_Lee
 * 
 * @param <T> Entity
 */
public interface GenericDao<T extends MyCircleEntity> {
	/**
	 * Get the entity with the specified id.
	 * @param id the entity identifier to look up.
	 * @return the found entity or null if not found.
	 */
	public T get(Integer id);

	/**
	 * @return all the entities in the repository.
	 */
	public List<T> getAll();

	/**
	 * Save or update the specified entity in the repository.
	 *
	 * @param object the entity to save or update.
	 */
	public void persist(T object);

	/**
	 * Delete the specified entity from the repository.
	 * @param object the entity to remove.
	 */
	public void delete(T object);
}
