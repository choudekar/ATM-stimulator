package in.co.online.bank.mgt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.online.bank.mgt.dto.RoleDTO;



/**
 * Hibernate implementation of Role DAO.
 *
 */

@Repository
public class RoleDAOHibImpl implements RoleDAOInt {

	@Autowired
	private EntityManager entityManager;

	public long add(RoleDTO dto) {

		long pk = (Long) entityManager.unwrap(Session.class).save(dto);
		return pk;
	}

	public void update(RoleDTO dto) {
		entityManager.unwrap(Session.class).merge(dto);

	}

	public void delete(RoleDTO dto) {
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));

	}

	public RoleDTO findByName(String name) {
		Session session = entityManager.unwrap(Session.class);

		Criteria criteria = session.createCriteria(RoleDTO.class);

		criteria.add(Restrictions.eq("roleName", name));

		return (RoleDTO) criteria.uniqueResult();
	}

	public RoleDTO findByPk(long id) {
		Session session = entityManager.unwrap(Session.class);
		RoleDTO dto = (RoleDTO) session.get(RoleDTO.class, id);
		
		return dto;
	}

	public List<RoleDTO> search(RoleDTO dto, long pageNo, int pageSize) {
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(RoleDTO.class);

		if (dto != null) {
		
			if (dto.getId() > 0) {

				criteria.add(Restrictions.eq("id", dto.getId()));

			}
			if (dto.getName() != null && dto.getName().length() > 0) {
				criteria.add(Restrictions.like("name", dto.getName() + "%"));
			}

			if (pageSize > 0) {

				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}

		return criteria.list();
	}

	public List<RoleDTO> search(RoleDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	public Map<Long, RoleDTO> getMapDTO(Set<Long> ids) {
		Session session = entityManager.unwrap(Session.class);
		Map<Long, RoleDTO> map = new HashMap<Long, RoleDTO>();	
		
		for (Long id : ids) {
			map.put(id,  (RoleDTO) session.get(RoleDTO.class, id));
		}	
		return map;
		
		
	}

}
