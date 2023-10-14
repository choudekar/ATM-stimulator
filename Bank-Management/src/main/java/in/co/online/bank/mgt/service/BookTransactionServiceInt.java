package in.co.online.bank.mgt.service;

import java.util.List;

import in.co.online.bank.mgt.dto.BookTransactionDTO;
import in.co.online.bank.mgt.exception.ApplicationException;
import in.co.online.bank.mgt.exception.DuplicateRecordException;
import in.co.online.bank.mgt.exception.RecordNotFoundException;

public interface BookTransactionServiceInt {

	public long add(BookTransactionDTO dto) throws  DuplicateRecordException;

	public void delete(BookTransactionDTO dto);

	public void update(BookTransactionDTO dto) throws DuplicateRecordException;

	public BookTransactionDTO findByPK(long pk);

	public BookTransactionDTO findByAccountNo(long accNo);

	public BookTransactionDTO findByName(String name);

	public List<BookTransactionDTO> list();

	public List<BookTransactionDTO> list(int pageNo, int pageSize);

	public List<BookTransactionDTO> search(BookTransactionDTO dto);

	public List<BookTransactionDTO> search(BookTransactionDTO dto, int pageNo, int pageSize);

}
