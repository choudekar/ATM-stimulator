package in.co.online.bank.mgt.dao;

import java.util.List;

import in.co.online.bank.mgt.dto.FundTransferDTO;
import in.co.online.bank.mgt.exception.ApplicationException;

public interface FundTransferDAOInt {

public long add(FundTransferDTO dto);
	
	public void delete(FundTransferDTO dto);

	public void update(FundTransferDTO dto);
	
	public FundTransferDTO findByPK(long pk);
    
	public FundTransferDTO findByName(String name);

	public FundTransferDTO findByAccountNo(long accNo) ;
   
	public FundTransferDTO findByBenAccountNo(long accNo);
	
	public List list();
	 
	public List list(int pageNo, int pageSize);
	 
	public List search(FundTransferDTO dto);
	
	public List search(FundTransferDTO dto, int pageNo, int pageSize);
}
