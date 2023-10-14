package in.co.online.bank.mgt.service;

import java.util.List;

import in.co.online.bank.mgt.dto.AccountBalanceDTO;
import in.co.online.bank.mgt.exception.ApplicationException;
import in.co.online.bank.mgt.exception.DuplicateRecordException;

public interface AccountBalanceServiceInt {

	public long add(AccountBalanceDTO dto) throws  DuplicateRecordException;

	public void delete(AccountBalanceDTO dto) ;

	public void update(AccountBalanceDTO dto) throws DuplicateRecordException;

	public AccountBalanceDTO findByPK(long pk);

	public AccountBalanceDTO findByName(String name);

	public AccountBalanceDTO findByAccountNo(long accNo);

	public List list();

	public List list(int pageNo, int pageSize);

	public List search(AccountBalanceDTO dto) ;

	public List search(AccountBalanceDTO dto, int pageNo, int pageSize) ;

}
