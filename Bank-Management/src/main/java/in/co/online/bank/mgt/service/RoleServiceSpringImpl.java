package in.co.online.bank.mgt.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.online.bank.mgt.dao.RoleDAOInt;
import in.co.online.bank.mgt.dto.RoleDTO;
import in.co.online.bank.mgt.exception.DuplicateRecordException;




@Service
public class RoleServiceSpringImpl implements RoleServiceInt {

	@Autowired
	RoleDAOInt dao;

	private static Logger log = Logger.getLogger(RoleServiceSpringImpl.class);

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(RoleDTO dto) throws DuplicateRecordException {

		log.debug("Role spring add start");

		RoleDTO existdto = dao.findByName(dto.getName());

		if (existdto != null) {
			throw new DuplicateRecordException("Role is already exits");
		}

		log.debug("Role spring add end");
		return dao.add(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(RoleDTO dto) {
		// TODO Auto-generated method stub
		dao.delete(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(RoleDTO dto) throws DuplicateRecordException {
		log.debug("Role spring add start");

		RoleDTO existdto = dao.findByName(dto.getName());
		
		if (existdto != null && existdto.getId() != dto.getId()) {
			throw new DuplicateRecordException("role is already exits");
		}

		log.debug("Role spring add end");

		dao.update(dto);
	}

	@Transactional(readOnly = true)
	public RoleDTO findByPk(long id) {
		return dao.findByPk(id);
	}

	@Transactional(readOnly = true)
	public RoleDTO findByName(String name) {
		// TODO Auto-generated method stub
		return dao.findByName(name);
	}

	@Transactional(readOnly = true)
	public List<RoleDTO> search(RoleDTO dto) {
		// TODO Auto-generated method stub
		return dao.search(dto);
	}

	@Transactional(readOnly = true)
	public List<RoleDTO> search(RoleDTO dto, long pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	public Map<Long, RoleDTO> getMapDTO(Set<Long> ids) {
		// TODO Auto-generated method stub
		return dao.getMapDTO(ids);
	}

	

}
