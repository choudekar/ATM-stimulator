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

import in.co.online.bank.mgt.dto.FundTransferDTO;
import in.co.online.bank.mgt.exception.ApplicationException;


/**
 * Hibernate implementation of FundTransfer DAO.
 *
 */

@Repository
public class FundTransferDAOHibImpl implements FundTransferDAOInt {

	@Autowired
	private EntityManager entityManager;

	public long add(FundTransferDTO dto) {

		long pk = (Long) entityManager.unwrap(Session.class).save(dto);
		return pk;
	}

	public void update(FundTransferDTO dto) {
		entityManager.unwrap(Session.class).merge(dto);

	}

	public void delete(FundTransferDTO dto) {
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));

	}

	public FundTransferDTO findByName(String name) {
		Session session = entityManager.unwrap(Session.class);

		Criteria criteria = session.createCriteria(FundTransferDTO.class);

		criteria.add(Restrictions.eq("name", name));

		return (FundTransferDTO) criteria.uniqueResult();
	}

	public FundTransferDTO findByPK(long id) {
		Session session = entityManager.unwrap(Session.class);
		FundTransferDTO dto = (FundTransferDTO) session.get(FundTransferDTO.class, id);
		return dto;
	}

	public List<FundTransferDTO> search(FundTransferDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	public Map<Long, FundTransferDTO> getMapDTO(Set<Long> ids) {
		Session session = entityManager.unwrap(Session.class);
		Map<Long, FundTransferDTO> map = new HashMap<Long, FundTransferDTO>();

		for (Long id : ids) {
			map.put(id, (FundTransferDTO) session.get(FundTransferDTO.class, id));
		}
		return map;

	}
	@Override
	public List<FundTransferDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<FundTransferDTO> list(int pageNo, int pageSize) {
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(FundTransferDTO.class);
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		return criteria.list();
	}

	@Override
	public List<FundTransferDTO> search(FundTransferDTO dto, int pageNo, int pageSize) {
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(FundTransferDTO.class);

		if (dto != null) {

			if (dto.getId() > 0) {

				criteria.add(Restrictions.eq("id", dto.getId()));

			}
			if (dto.getByAccountNo() > 0) {
				criteria.add(Restrictions.eq("byAccountNo", dto.getByAccountNo()));
			}
			if (dto.getBenAccountNo() > 0) {
				criteria.add(Restrictions.eq("benAccountNo", dto.getBenAccountNo()));
			}
			if (dto.getByAccHolderName() != null && dto.getByAccHolderName().length() > 0) {
				criteria.add(Restrictions.like("byAccHolderName", dto.getByAccHolderName() + "%"));
			}
			if (dto.getBenAccHolderName() != null && dto.getBenAccHolderName().length() > 0) {
				criteria.add(Restrictions.like("benAccHolderName", dto.getBenAccHolderName() + "%"));
			}

			if (pageSize > 0) {

				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}
		return criteria.list();
	}

	@Override
	public FundTransferDTO findByAccountNo(long accNo) {
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(FundTransferDTO.class);
		criteria.add(Restrictions.eq("accountNo", accNo));
		return (FundTransferDTO) criteria.uniqueResult();
	}

	@Override
	public FundTransferDTO findByBenAccountNo(long accNo){
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(FundTransferDTO.class);
		criteria.add(Restrictions.eq("benAccHolderName", accNo));
		return (FundTransferDTO) criteria.uniqueResult();
	}

}
