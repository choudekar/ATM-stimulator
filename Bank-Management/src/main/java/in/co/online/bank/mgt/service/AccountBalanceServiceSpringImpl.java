package in.co.online.bank.mgt.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.online.bank.mgt.dao.AccountBalanceDAOInt;
import in.co.online.bank.mgt.dao.UserDAOInt;
import in.co.online.bank.mgt.dto.AccountBalanceDTO;
import in.co.online.bank.mgt.exception.ApplicationException;
import in.co.online.bank.mgt.exception.DuplicateRecordException;

@Service
public class AccountBalanceServiceSpringImpl implements AccountBalanceServiceInt {

	@Autowired
	AccountBalanceDAOInt dao;
	
	@Autowired
	UserDAOInt uDao;

	private static Logger log = Logger.getLogger(AccountBalanceServiceSpringImpl.class);

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(AccountBalanceDTO dto) throws DuplicateRecordException {
		log.debug("AccountBalance spring add start");
		log.debug("AccountBalance spring add end");
		return dao.add(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(AccountBalanceDTO dto) {
		// TODO Auto-generated method stub
		dao.delete(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(AccountBalanceDTO dto) throws DuplicateRecordException{
		log.debug("AccountBalance spring add start");

		log.debug("AccountBalance spring add end");

		dao.update(dto);
	}

	@Transactional(readOnly = true)
	public AccountBalanceDTO findByPK(long id){
		return dao.findByPK(id);
	}

	@Transactional(readOnly = true)
	public AccountBalanceDTO findByName(String name) {
		// TODO Auto-generated method stub
		return dao.findByName(name);
	}

	@Transactional(readOnly = true)
	public List<AccountBalanceDTO> search(AccountBalanceDTO dto) {
		// TODO Auto-generated method stub
		return dao.search(dto);
	}

	@Transactional(readOnly = true)
	public List search(AccountBalanceDTO dto, int pageNo, int pageSize)  {
		return dao.search(dto, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	public Map<Long, AccountBalanceDTO> getMapDTO(Set<Long> ids) {
		// TODO Auto-generated method stub
		return ((AccountBalanceServiceSpringImpl) dao).getMapDTO(ids);
	}

	
	@Override
	@Transactional(readOnly = true)
	public AccountBalanceDTO findByAccountNo(long accNo){
		return dao.findByAccountNo(accNo);
	}

	
	@Override
	@Transactional(readOnly = true)
	public List list() {
		// TODO Auto-generated method stub
		return dao.list();
	}

	@Override
	@Transactional(readOnly = true)
	public List list(int pageNo, int pageSize){
		// TODO Auto-generated method stub
		return dao.list(pageNo, pageSize);
	}

	

	

}
