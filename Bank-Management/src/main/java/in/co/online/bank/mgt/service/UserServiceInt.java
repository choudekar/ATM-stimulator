package in.co.online.bank.mgt.service;

import java.util.List;

import in.co.online.bank.mgt.dto.UserDTO;
import in.co.online.bank.mgt.exception.DuplicateRecordException;



/**
 * 
 * User DAO interface.
 * 
 * @author Navigable Set
 * @version 1.0
 * 
 */
public interface UserServiceInt {

	/**
	 * Adds a User.
	 * 
	 * @param dto
	 * @return pk of dto
	 * @throws DuplicateRecordException 
	 */
	public long add(UserDTO dto) throws DuplicateRecordException;

	/**
	 * Update a User.
	 * 
	 * @param dto
	 * @throws DuplicateRecordException 
	 * 
	 */
	public void update(UserDTO dto) throws DuplicateRecordException;

	/**
	 * Delete a User.
	 * 
	 * @param dto
	 * 
	 */
	public void delete(UserDTO dto);

	public long maxAccountNo();
	/**
	 * Find a User by it's login.
	 * 
	 * @param userName
	 * 
	 * @return UserDTO
	 */
	public UserDTO findByLogin(String login);

	/**
	 * Find a User by it's pk.
	 * 
	 * @param id
	 * 
	 * @return UserDTO
	 */
	public UserDTO findByPk(long id);

	/**
	 * Search Users with pagination.
	 * 
	 * @param dto
	 * @param pageNo
	 * @param pageSize
	 * @return List
	 */
	public List<UserDTO> search(UserDTO dto, long pageNo, int pageSize);

	/**
	 * Search Users.
	 * 
	 * @param dto
	 * @return List
	 */
	public List<UserDTO> search(UserDTO dto);


	  /**
     * User Authentication
     * 
     * @return dto : Contains User's information
     * @param login
     *            : User Login
     * @param password
     *            : User Password
     * 
     */
    public UserDTO authenticate(UserDTO dto);
    
	 
    public boolean changePassword(Long id, String oldPassword,
            String newPassword) ;

   
    
    
    
    
    
    
    
    public long registerUser(UserDTO dto)  ;
    
    public UserDTO findByAccountNo(long accNo);
    
    public boolean forgetPassword(String login);
	
}
