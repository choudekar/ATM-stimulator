package in.co.online.bank.mgt.service;

import java.util.List;

import in.co.online.bank.mgt.dto.FundTransferDTO;
import in.co.online.bank.mgt.exception.ApplicationException;
import in.co.online.bank.mgt.exception.DuplicateRecordException;

public interface FundTransferServiceInt {

public long add(FundTransferDTO dto) throws DuplicateRecordException;
	
	public void delete(FundTransferDTO dto);

	public void update(FundTransferDTO dto) throws DuplicateRecordException ;
	
	public FundTransferDTO findByPK(long pk);
    
	public FundTransferDTO findByName(String name) ;

	public FundTransferDTO findByAccountNo(long accNo);
   
	public FundTransferDTO findByBenAccountNo(long accNo);
	
	public List list() throws ApplicationException;
	 
	public List list(int pageNo, int pageSize) ;
	 
	public List search(FundTransferDTO dto);
	
	public List search(FundTransferDTO dto, int pageNo, int pageSize) ;
}
