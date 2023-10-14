package in.co.online.bank.mgt.service;

import java.util.HashMap;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.online.bank.mgt.dao.BankDAOInt;
import in.co.online.bank.mgt.dao.UserDAOInt;
import in.co.online.bank.mgt.dto.BankDTO;
import in.co.online.bank.mgt.dto.UserDTO;
import in.co.online.bank.mgt.exception.DuplicateRecordException;
import in.co.online.bank.mgt.util.EmailBuilder;




/**
 * @author Navigable Set
 *
 *         User Service Implementation
 *
 */

@Service
public class UserServiceSpringImpl implements UserServiceInt {

	@Autowired
	private UserDAOInt dao;

	@Autowired
	private JavaMailSenderImpl mailSender;
 
	@Autowired
	private BankDAOInt bankDao;
	
	private static Logger log = Logger.getLogger(UserServiceSpringImpl.class);
	

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(UserDTO dto) throws DuplicateRecordException {
		log.debug("Service User Add Start");
		UserDTO Exitsdto = dao.findByLogin(dto.getLogin());
		if (Exitsdto != null) {
			throw new DuplicateRecordException("Login is already Exits");
		}
		BankDTO bBean=bankDao.findByPK(dto.getBankId());
		dto.setBankName(bBean.getName());
		dto.setAccountNo(maxAccountNo()+1);
		log.debug("Service User Add End");
		return dao.add(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(UserDTO dto) {
		log.debug("Service User Delete Start");
		dao.delete(dto);
		log.debug("Service User Delete End");
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(UserDTO dto) throws DuplicateRecordException {
		log.debug("Service User update start");
		UserDTO Exitsdto = dao.findByLogin(dto.getLogin());
		if (Exitsdto != null && dto.getId() != Exitsdto.getId()) {
			throw new DuplicateRecordException("Login is already Exits");
		}
		
		UserDTO bean1 = dao.findByPk(dto.getId());
		
		BankDTO bBean=bankDao.findByPK(dto.getBankId());
		dto.setBankName(bBean.getName());
		dto.setAccountNo(bean1.getAccountNo());
		
		dao.update(dto);
		log.debug("Service User Update End");

	}

	@Transactional(readOnly = true)

	public UserDTO findByPk(long pk) {
		log.debug("User Service FindByPk Start");
		log.debug("User Service FindByPk End");
		return dao.findByPk(pk);
	}

	@Transactional(readOnly = true)
	public UserDTO findByLogin(String login) {
		log.debug("User Service FindBYLogin  start");
		log.debug("User Service FindBYLogin  End");
		return dao.findByLogin(login);
	}

	@Transactional(readOnly = true)
	public List<UserDTO> search(UserDTO dto) {
		// TODO Auto-generated method stub
		return dao.search(dto);
	}

	@Transactional(readOnly = true)
	public List<UserDTO> search(UserDTO dto, long pageNo, int pageSize) {
		log.debug("User Service search start");

		log.debug("User Service search End");
		return dao.search(dto, pageNo, pageSize);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean changePassword(Long id, String oldPassword, String newPassword) {
		log.debug("Change User Service start");
		
		UserDTO dtoExist = findByPk(id);

		if (dtoExist != null && dtoExist.getPassword().equals(oldPassword)) {

			dtoExist.setPassword(newPassword);

			dao.update(dtoExist);

			

			log.debug("Change User Service End");
			return true;
		} else {
			return false;
		}

	}

	@Transactional(readOnly = true)
	public UserDTO authenticate(UserDTO dto) {
		
		return dao.authenticate(dto);
		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long registerUser(UserDTO dto) {
		long id = dao.add(dto);

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("login", dto.getLogin());
		map.put("password", dto.getPassword());

		String message = EmailBuilder.getUserRegistrationMessage(map);

		MimeMessage msg = mailSender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(msg);
			helper.setTo(dto.getLogin());
			helper.setSubject("Registration is successful for Hospital Management");
			// use the true flag to indicate the text included is HTML
			helper.setText(message, true);
			mailSender.send(msg);
		} catch (MessagingException e) {
			System.out.println("Mail Sending Failed");
			e.printStackTrace();
		}

		return id;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean forgetPassword(String login) {
		log.debug("Service forgetPassword Started");

		UserDTO dtoExist = dao.findByLogin(login);

		if (dtoExist != null) {

			HashMap<String, String> map = new HashMap<String, String>();
			map.put("firstName", dtoExist.getFirstName());
			map.put("lastName", dtoExist.getLastName());
			map.put("login", dtoExist.getLogin());
			map.put("password", dtoExist.getPassword());

			String message = EmailBuilder.getForgetPasswordMessage(map);

			MimeMessage msg = mailSender.createMimeMessage();

			try {
				MimeMessageHelper helper = new MimeMessageHelper(msg);
				helper.setTo(login);
				helper.setSubject("Hospital Management Password reset");
				// use the true flag to indicate the text included is HTML
				helper.setText(message, true);
				mailSender.send(msg);
			} catch (MessagingException e) {
				e.printStackTrace();
				log.error(e);
				return false;
			}
		} else {
			return false;
		}
		log.debug("Service forgetPassword End");
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public long maxAccountNo() {
		return dao.maxAccountNo();
	}

	@Override
	@Transactional(readOnly = true)
	public UserDTO findByAccountNo(long accNo) {
		// TODO Auto-generated method stub
		return dao.findByAccountNo(accNo);
	}

	
	
}
