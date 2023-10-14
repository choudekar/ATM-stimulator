package in.co.online.bank.mgt.dao;

import java.util.List;

import in.co.online.bank.mgt.dto.BookTransactionDTO;

public interface BookTransactionDAOInt {

	public long add(BookTransactionDTO dto);

	public void delete(BookTransactionDTO dto);

	public void update(BookTransactionDTO dto);

	public BookTransactionDTO findByPK(long pk);

	public BookTransactionDTO findByAccountNo(long accNo);

	public BookTransactionDTO findByName(String name);

	public List<BookTransactionDTO> list() ;

	public List<BookTransactionDTO> list(int pageNo, int pageSize);

	public List<BookTransactionDTO> search(BookTransactionDTO dto);

	public List<BookTransactionDTO> search(BookTransactionDTO dto, int pageNo, int pageSize);

}
