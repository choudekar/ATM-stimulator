package in.co.online.bank.mgt.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import in.co.online.bank.mgt.dto.RoleDTO;
import in.co.online.bank.mgt.exception.DuplicateRecordException;





public interface RoleServiceInt {

	
	
	public long add(RoleDTO dto) throws DuplicateRecordException;

	
	public void update(RoleDTO dto) throws DuplicateRecordException;

	
	public void delete(RoleDTO dto);
	

  
	public RoleDTO findByName(String name);
	

	
	public RoleDTO findByPk(long id);

	
	public List<RoleDTO> search(RoleDTO dto, long pageNo, int pageSize);

	
	public List<RoleDTO> search(RoleDTO dto);
	
	
	
	public Map<Long, RoleDTO> getMapDTO(Set<Long> ids);
	
}
