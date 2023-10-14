package in.co.online.bank.mgt.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.online.bank.mgt.dao.FundTransferDAOInt;
import in.co.online.bank.mgt.dao.UserDAOHibImpl;
import in.co.online.bank.mgt.dao.UserDAOInt;
import in.co.online.bank.mgt.dto.FundTransferDTO;
import in.co.online.bank.mgt.dto.UserDTO;
import in.co.online.bank.mgt.exception.ApplicationException;
import in.co.online.bank.mgt.exception.DuplicateRecordException;

@Service
public class FundTransferServiceSpringImpl implements FundTransferServiceInt {

	@Autowired
	FundTransferDAOInt dao;
	
	@Autowired
	UserDAOInt uDao;

	private static Logger log = Logger.getLogger(FundTransferServiceSpringImpl.class);

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(FundTransferDTO dto) throws DuplicateRecordException {
		log.debug("FundTransfer spring add start");
			UserDTO uBean = uDao.findByAccountNo(dto.getByAccountNo());
			UserDTO bBean = uDao.findByAccountNo(dto.getBenAccountNo());
			dto.setTransferDate(new java.util.Date());
			dto.setByAccHolderName(uBean.getFirstName() +" "+ uBean.getLastName());
			dto.setBenAccHolderName(bBean.getFirstName() +" " + bBean.getLastName());
			dto.setBankName(bBean.getBankName());
		log.debug("FundTransfer spring add end");
		return dao.add(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(FundTransferDTO dto){
		// TODO Auto-generated method stub
		dao.delete(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(FundTransferDTO dto) throws DuplicateRecordException {
		log.debug("FundTransfer spring add start");

		/*
		 * FundTransferDTO existdto = dao.findByName(dto.getName());
		 * 
		 * if (existdto != null && existdto.getId() != dto.getId()) { throw new
		 * DuplicateRecordException("FundTransfer is already exits"); }
		 */

		log.debug("FundTransfer spring add end");

		dao.update(dto);
	}

	@Transactional(readOnly = true)
	public FundTransferDTO findByPK(long id) {
		return dao.findByPK(id);
	}

	@Transactional(readOnly = true)
	public FundTransferDTO findByName(String name) {
		// TODO Auto-generated method stub
		return dao.findByName(name);
	}

	@Transactional(readOnly = true)
	public List<FundTransferDTO> search(FundTransferDTO dto) {
		// TODO Auto-generated method stub
		return dao.search(dto);
	}

	@Transactional(readOnly = true)
	public List search(FundTransferDTO dto, int pageNo, int pageSize)  {
		return dao.search(dto, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	public Map<Long, FundTransferDTO> getMapDTO(Set<Long> ids) {
		// TODO Auto-generated method stub
		return ((FundTransferServiceSpringImpl) dao).getMapDTO(ids);
	}

	
	@Override
	@Transactional(readOnly = true)
	public FundTransferDTO findByAccountNo(long accNo){
		return dao.findByAccountNo(accNo);
	}

	@Override
	@Transactional(readOnly = true)
	public FundTransferDTO findByBenAccountNo(long accNo)  {
		// TODO Auto-generated method stub
		return dao.findByBenAccountNo(accNo);
	}

	@Override
	@Transactional(readOnly = true)
	public List list() throws ApplicationException {
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
