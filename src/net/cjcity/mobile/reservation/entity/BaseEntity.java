package net.cjcity.mobile.reservation.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Simple JavaBean domain object with an id property.
 * Used as a base class for objects needing this property.
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 */
public class BaseEntity implements Serializable{

	protected Integer id;
	
	protected String createUser;
	
	protected String updateUser;
	
	private String createUserName;
	
	private String updateUserDupinfo;
	
	protected Date createTime;
	
	protected Date updateTime;
	
	protected Boolean use=true;
	
	private Boolean deleted=false;
	
	private Integer ordr;
	
	private String password;//acl용 password
	private Boolean isAclSkip=false;
	//	@
//	protected Map properties;
	/**
	 * 
	 */
	public BaseEntity() {
//		properties = new HashMap<String, Object>();
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

//	public Map getProperties() {
//		return properties;
//	}
//
//	public Object getProperty(String name) {
//		return properties.get(name);
//	}
//
//	public void setProperty(String name, Object value) {
//		properties.put(name, value);
//	}
	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getCreateTime() {
		if(this.createTime==null)
			return new Date();
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @param use the use to set
	 */
	public void setUse(Boolean use) {
		this.use = use;
	}

	/**
	 * @return the use
	 */
	public Boolean getUse() {
		return use;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setUpdateUserDupinfo(String updateUserDupinfo) {
		this.updateUserDupinfo = updateUserDupinfo;
	}

	public String getUpdateUserDupinfo() {
		return updateUserDupinfo;
	}

	public void setOrdr(Integer ordr) {
		this.ordr = ordr;
	}

	public Integer getOrdr() {
		return ordr;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param isAclSkip the isAclSkip to set
	 */
	public void setIsAclSkip(Boolean isAclSkip) {
		this.isAclSkip = isAclSkip;
	}

	/**
	 * @return the isAclSkip
	 */
	public Boolean getIsAclSkip() {
		return isAclSkip;
	}

	
}
