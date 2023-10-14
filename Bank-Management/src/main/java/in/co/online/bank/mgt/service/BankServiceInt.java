package in.co.online.bank.mgt.service;

import java.util.List;

import in.co.online.bank.mgt.dto.BankDTO;
import in.co.online.bank.mgt.exception.ApplicationException;
import in.co.online.bank.mgt.exception.DuplicateRecordException;

public interface BankServiceInt {

   public long add(BankDTO bean) throws DuplicateRecordException;
	
	

	public void delete(BankDTO bean);


    
	public void update(BankDTO bean) throws DuplicateRecordException;
	
	public BankDTO findByPK(long pk);

    
	public BankDTO findByName(String name);

   
	public List<BankDTO> list();
	 
	public List<BankDTO> list(int pageNo, int pageSize);
	 
	public List<BankDTO> search(BankDTO dto);
	
	public List<BankDTO> search(BankDTO dto, int pageNo, int pageSize);
	
}
