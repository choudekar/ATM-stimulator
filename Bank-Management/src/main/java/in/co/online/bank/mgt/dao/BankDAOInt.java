package in.co.online.bank.mgt.dao;

import java.util.List;

import in.co.online.bank.mgt.dto.BankDTO;

public interface BankDAOInt {

   public long add(BankDTO bean);
	
	

	public void delete(BankDTO bean);


    
	public void update(BankDTO bean);
	
	public BankDTO findByPK(long pk);

    
	public BankDTO findByName(String name);

   
	public List<BankDTO> list();
	 
	public List<BankDTO> list(int pageNo, int pageSize);
	 
	public List<BankDTO> search(BankDTO dto);
	
	public List<BankDTO> search(BankDTO dto, int pageNo, int pageSize);
	
}
