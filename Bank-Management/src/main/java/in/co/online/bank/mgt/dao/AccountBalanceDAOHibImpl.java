package in.co.online.bank.mgt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.online.bank.mgt.dto.AccountBalanceDTO;

/**
 * Hibernate implementation of AccountBalance DAO.
 *
 */

@Repository
public class AccountBalanceDAOHibImpl implements AccountBalanceDAOInt {

	@Autowired
	private EntityManager entityManager;

	public long add(AccountBalanceDTO dto) {
		long pk = (Long) entityManager.unwrap(Session.class).save(dto);
		return pk;
	}

	public void update(AccountBalanceDTO dto) {
		entityManager.unwrap(Session.class).merge(dto);

	}

	public void delete(AccountBalanceDTO dto) {
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));

	}

	public AccountBalanceDTO findByName(String name) {
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(AccountBalanceDTO.class);
		criteria.add(Restrictions.eq("name", name));
		return (AccountBalanceDTO) criteria.uniqueResult();
	}

	public AccountBalanceDTO findByPK(long id) {
		Session session = entityManager.unwrap(Session.class);
		AccountBalanceDTO dto = (AccountBalanceDTO) session.get(AccountBalanceDTO.class, id);

		return dto;
	}

	public List<AccountBalanceDTO> search(AccountBalanceDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	public Map<Long, AccountBalanceDTO> getMapDTO(Set<Long> ids) {
		Session session = entityManager.unwrap(Session.class);
		Map<Long, AccountBalanceDTO> map = new HashMap<Long, AccountBalanceDTO>();

		for (Long id : ids) {
			map.put(id, (AccountBalanceDTO) session.get(AccountBalanceDTO.class, id));
		}
		return map;

	}

	@Override
	public AccountBalanceDTO findByAccountNo(long accNo) {
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(AccountBalanceDTO.class);
		criteria.add(Restrictions.eq("accountNo", accNo));
		return (AccountBalanceDTO) criteria.uniqueResult();
	}

	@Override
	public List<AccountBalanceDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<AccountBalanceDTO> list(int pageNo, int pageSize) {
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(AccountBalanceDTO.class);
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			criteria.setFirstResult((int) pageNo);
			criteria.setMaxResults(pageSize);
		}
		return criteria.list();
	}

	@Override
	public List<AccountBalanceDTO> search(AccountBalanceDTO dto, int pageNo, int pageSize) {
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(AccountBalanceDTO.class);
		if (dto != null) {

			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
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

}
