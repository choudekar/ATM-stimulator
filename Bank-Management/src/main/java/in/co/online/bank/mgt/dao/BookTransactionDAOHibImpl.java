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

import in.co.online.bank.mgt.dto.BankDTO;
import in.co.online.bank.mgt.dto.BookTransactionDTO;

/**
 * Hibernate implementation of BookTransaction DAO.
 *
 */

@Repository
public class BookTransactionDAOHibImpl implements BookTransactionDAOInt {

	@Autowired
	private EntityManager entityManager;

	public long add(BookTransactionDTO dto) {
		long pk = (Long) entityManager.unwrap(Session.class).save(dto);
		return pk;
	}

	public void update(BookTransactionDTO dto) {
		entityManager.unwrap(Session.class).merge(dto);

	}

	public void delete(BookTransactionDTO dto) {
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));

	}

	public BookTransactionDTO findByName(String name) {
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(BookTransactionDTO.class);
		criteria.add(Restrictions.eq("name", name));
		return (BookTransactionDTO) criteria.uniqueResult();
	}

	public BookTransactionDTO findByPK(long id) {
		Session session = entityManager.unwrap(Session.class);
		BookTransactionDTO dto = (BookTransactionDTO) session.get(BookTransactionDTO.class, id);

		return dto;
	}

	public List<BookTransactionDTO> search(BookTransactionDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	public Map<Long, BookTransactionDTO> getMapDTO(Set<Long> ids) {
		Session session = entityManager.unwrap(Session.class);
		Map<Long, BookTransactionDTO> map = new HashMap<Long, BookTransactionDTO>();

		for (Long id : ids) {
			map.put(id, (BookTransactionDTO) session.get(BookTransactionDTO.class, id));
		}
		return map;

	}

	@Override
	public BookTransactionDTO findByAccountNo(long accNo) {
		Session session =entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(BookTransactionDTO.class);
		criteria.add(Restrictions.eq("accountNo", accNo));
		return (BookTransactionDTO) criteria.uniqueResult();
	}

	@Override
	public List<BookTransactionDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<BookTransactionDTO> list(int pageNo, int pageSize) {
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(BookTransactionDTO.class);
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			criteria.setFirstResult((int) pageNo);
			criteria.setMaxResults(pageSize);
		}
		return criteria.list();
	}

	@Override
	public List<BookTransactionDTO> search(BookTransactionDTO dto, int pageNo, int pageSize) {
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(BookTransactionDTO.class);
		if (dto != null) {

			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getAccountNo() > 0) {
				criteria.add(Restrictions.eq("accountNo", dto.getAccountNo()));
			}
			if (dto.getAccHolderName() != null && dto.getAccHolderName().length() > 0) {
				criteria.add(Restrictions.like("AccHolderName", dto.getAccHolderName() + "%"));
			}
			if (pageSize > 0) {

				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}
		return criteria.list();
	}

}
