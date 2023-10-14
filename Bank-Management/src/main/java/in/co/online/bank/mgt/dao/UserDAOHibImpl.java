package in.co.online.bank.mgt.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.online.bank.mgt.dto.UserDTO;


/**
 * Hibernate implementation of User DAO.
 * 
 * @author Navigable Set
 * @version 1.0
 *
 */
@Repository
public class UserDAOHibImpl implements UserDAOInt {

	@Autowired
	private EntityManager entityManager;

	public long add(UserDTO dto) {
		long pk = (Long) entityManager.unwrap(Session.class).save(dto);
		return pk;
	}

	public void update(UserDTO dto) {
		entityManager.unwrap(Session.class).merge(dto);

	}

	public void delete(UserDTO dto) {
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
	}

	public UserDTO findByLogin(String login) {
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(UserDTO.class);
		criteria.add(Restrictions.like("login", login));
		return (UserDTO) criteria.uniqueResult();
	}

	public UserDTO findByPk(long id) {
		Session session = entityManager.unwrap(Session.class);
		UserDTO dto = (UserDTO) session.get(UserDTO.class, id);
		// session.evict(dto);
		return dto;
	}

	public List<UserDTO> search(UserDTO dto, long pageNo, int pageSize) {

		Session session = entityManager.unwrap(Session.class);

		Criteria criteria = session.createCriteria(UserDTO.class);

		if (dto != null) {

			if (dto.getId() > 0) {

				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				criteria.add(Restrictions.like("firstName", dto.getFirstName() + "%"));
			}
			if (dto.getLastName() != null && dto.getLastName().length() > 0) {
				criteria.add(Restrictions.like("lastName", dto.getLastName() + "%"));
			}
			if (dto.getLogin() != null && dto.getLogin().length() > 0) {

				criteria.add(Restrictions.like("login", dto.getLogin() + "%"));

			}
			if (dto.getEmailId() != null && dto.getEmailId().length() > 0) {

				criteria.add(Restrictions.like("emailId", dto.getEmailId() + "%"));

			}
			if (dto.getRoleId() > 0) {
				criteria.add(Restrictions.eq("roleId", dto.getRoleId()));
			}
			
			if (dto.getAccountNo() > 0) {
				criteria.add(Restrictions.eq("accountNo", dto.getAccountNo()));
			}

			if (pageSize > 0) {

				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}
		return criteria.list();
	}

	public List<UserDTO> search(UserDTO dto) {
		return search(dto, 0, 0);
	}

	public UserDTO authenticate(UserDTO dto) {

		Session session = entityManager.unwrap(Session.class);

		Criteria criteria = session.createCriteria(UserDTO.class);

		criteria.add(Restrictions.like("login", dto.getLogin()));
		criteria.add(Restrictions.like("password", dto.getPassword()));
		
		return (UserDTO)criteria.uniqueResult();
	}

	@Override
	public UserDTO findByAccountNo(long accNo) {
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(UserDTO.class);
		criteria.add(Restrictions.like("accountNo", accNo));
		return (UserDTO) criteria.uniqueResult();
	}

	@Override
	public long maxAccountNo() {
		Session session = entityManager.unwrap(Session.class);
		UserDTO dto = null;
		DetachedCriteria maxId = DetachedCriteria.forClass(UserDTO.class)
			    .setProjection( Projections.max("accountNo") );
		
		Criteria criteria = session.createCriteria(UserDTO.class);
		criteria.add(Property.forName("accountNo").eq(maxId));
		List list = criteria.list();

		if (list.size() >0) {
			dto = (UserDTO) list.get(0);
		} else {
			dto = null;
		}
		return dto.getAccountNo();
	}

}
