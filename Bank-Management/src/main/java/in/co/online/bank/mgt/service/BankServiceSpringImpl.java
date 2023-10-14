package in.co.online.bank.mgt.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.online.bank.mgt.dao.BankDAOInt;
import in.co.online.bank.mgt.dto.BankDTO;
import in.co.online.bank.mgt.exception.DuplicateRecordException;




@Service
public class BankServiceSpringImpl implements BankServiceInt {

	@Autowired
	BankDAOInt dao;

	private static Logger log = Logger.getLogger(BankServiceSpringImpl.class);

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(BankDTO dto) throws DuplicateRecordException {

		log.debug("Bank spring add start");

		BankDTO existdto = dao.findByName(dto.getName());

		if (existdto != null) {
			throw new DuplicateRecordException("Bank is already exits");
		}

		log.debug("Bank spring add end");
		return dao.add(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(BankDTO dto) {
		// TODO Auto-generated method stub
		dao.delete(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(BankDTO dto) throws DuplicateRecordException {
		log.debug("Bank spring add start");

		BankDTO existdto = dao.findByName(dto.getName());
		
		if (existdto != null && existdto.getId() != dto.getId()) {
			throw new DuplicateRecordException("Bank is already exits");
		}

		log.debug("Bank spring add end");

		dao.update(dto);
	}

	@Transactional(readOnly = true)
	public BankDTO findByPK(long pk) {
		return dao.findByPK(pk);
	}

	@Transactional(readOnly = true)
	public BankDTO findByName(String name) {
		// TODO Auto-generated method stub
		return dao.findByName(name);
	}

	@Transactional(readOnly = true)
	public List<BankDTO> search(BankDTO dto) {
		// TODO Auto-generated method stub
		return dao.search(dto);
	}

	@Transactional(readOnly = true)
	public List<BankDTO> search(BankDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	public Map<Long, BankDTO> getMapDTO(Set<Long> ids) {
		// TODO Auto-generated method stub
		return ((BankServiceSpringImpl) dao).getMapDTO(ids);
	}

	
	@Override
	@Transactional(readOnly = true)
	public List<BankDTO> list() {
		return dao.list();
	}

	@Override
	@Transactional(readOnly = true)
	public List<BankDTO> list(int pageNo, int pageSize) {
		return dao.list(pageNo, pageSize);
	}

	

	

}
