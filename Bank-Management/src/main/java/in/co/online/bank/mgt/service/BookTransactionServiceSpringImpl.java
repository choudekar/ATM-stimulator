package in.co.online.bank.mgt.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.online.bank.mgt.dao.BookTransactionDAOInt;
import in.co.online.bank.mgt.dao.UserDAOInt;
import in.co.online.bank.mgt.dto.BookTransactionDTO;
import in.co.online.bank.mgt.dto.UserDTO;
import in.co.online.bank.mgt.exception.ApplicationException;
import in.co.online.bank.mgt.exception.DuplicateRecordException;
import in.co.online.bank.mgt.exception.RecordNotFoundException;

@Service
public class BookTransactionServiceSpringImpl implements BookTransactionServiceInt {

	@Autowired
	BookTransactionDAOInt dao;
	
	@Autowired
	UserDAOInt uDao;

	private static Logger log = Logger.getLogger(BookTransactionServiceSpringImpl.class);

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(BookTransactionDTO dto) throws  DuplicateRecordException {
		log.debug("BookTransaction spring add start");
		UserDTO uBean = uDao.findByAccountNo(dto.getAccountNo());
		

		if (uBean == null) {
			throw new DuplicateRecordException("Account No. Do Not EXIST");
		}
		
		dto.setAccHolderName(uBean.getFirstName()+" "+uBean.getLastName());
		dto.setBankId(uBean.getBankId());
		dto.setBankName(uBean.getBankName());
		log.debug("BookTransaction spring add end");
		return dao.add(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(BookTransactionDTO dto) {
		// TODO Auto-generated method stub
		dao.delete(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(BookTransactionDTO dto) throws DuplicateRecordException {
		log.debug("BookTransaction spring add start");

		UserDTO uBean = uDao.findByAccountNo(dto.getAccountNo());
		

		if (uBean == null && uBean.getId()!=dto.getId()) {
			throw new DuplicateRecordException("Account No. Do Not EXIST");
		}

		log.debug("BookTransaction spring add end");

		dao.update(dto);
	}

	@Transactional(readOnly = true)
	public BookTransactionDTO findByPK(long id) {
		return dao.findByPK(id);
	}

	@Transactional(readOnly = true)
	public BookTransactionDTO findByName(String name) {
		// TODO Auto-generated method stub
		return dao.findByName(name);
	}

	@Transactional(readOnly = true)
	public List<BookTransactionDTO> search(BookTransactionDTO dto) {
		// TODO Auto-generated method stub
		return dao.search(dto);
	}

	@Transactional(readOnly = true)
	public List search(BookTransactionDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	public Map<Long, BookTransactionDTO> getMapDTO(Set<Long> ids) {
		// TODO Auto-generated method stub
		return ((BookTransactionServiceSpringImpl) dao).getMapDTO(ids);
	}

	
	@Override
	@Transactional(readOnly = true)
	public BookTransactionDTO findByAccountNo(long accNo) {
		return dao.findByAccountNo(accNo);
	}

	
	@Override
	@Transactional(readOnly = true)
	public List list()  {
		// TODO Auto-generated method stub
		return dao.list();
	}

	@Override
	@Transactional(readOnly = true)
	public List list(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return dao.list(pageNo, pageSize);
	}

	

	

}
