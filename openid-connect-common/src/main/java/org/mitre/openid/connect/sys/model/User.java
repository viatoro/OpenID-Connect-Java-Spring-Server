package org.mitre.openid.connect.sys.model;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

import org.mitre.openid.connect.model.DefaultUserInfo;
import org.mitre.openid.connect.model.IAddress;
import org.mitre.openid.connect.model.IUserInfo;

import com.google.gson.JsonObject;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name="SYS_M_USER")
@NamedQueries({
	@NamedQuery(name=User.QUERY_BY_USERNAME, query = "select u from User u WHERE u.username = :" + User.PARAM_USERNAME)
	,@NamedQuery(name=User.QUERY_BY_EMAIL, query = "select u from User u WHERE u.username = :" + User.PARAM_EMAIL)
})
public class User  implements java.io.Serializable,IUserInfo {
	
	public static final String QUERY_BY_USERNAME = "User.getByUsername";
	public static final String QUERY_BY_EMAIL = "User.getByEmailAddress";

	public static final String PARAM_USERNAME = "username";
	public static final String PARAM_EMAIL = "username";
	
	 private Long idUser;
     private PrefixName prefixName;
     private String username;
     private String password;
     private String firstName;
     private String midName;
     private String lastName;
     private String maidenSurname;
     private String nickName;
     private String status;
     private Date createDate;
     private String createUser;
     private Date updateDate;
     private String updateUser;
     private List<UserMapPhone> userMapPhones = new ArrayList<UserMapPhone>(0);
     private List<UserMapAddress> userMapAddresses = new ArrayList<UserMapAddress>(0);
     private List<SocialNetwork> socialNetworks = new ArrayList<SocialNetwork>(0);
     private List<UserMapSocialNetwork> userMapSocialNetworks = new ArrayList<UserMapSocialNetwork>(0);
 	private transient JsonObject src; // source JSON if this is loaded remotely

    public User() {
    }

	
    public User(String username) {
        this.username = username;
    }
    public User(PrefixName prefixName, String username, String password, String firstName, String midName, String lastName, String maidenSurname, String nickName, String status, Date createDate, String createUser, Date updateDate, String updateUser, List<UserMapPhone> userMapPhones, List<UserMapAddress> userMapAddresses, List<SocialNetwork> socialNetworks, List<UserMapSocialNetwork> userMapSocialNetworks) {
       this.prefixName = prefixName;
       this.username = username;
       this.password = password;
       this.firstName = firstName;
       this.midName = midName;
       this.lastName = lastName;
       this.maidenSurname = maidenSurname;
       this.nickName = nickName;
       this.status = status;
       this.createDate = createDate;
       this.createUser = createUser;
       this.updateDate = updateDate;
       this.updateUser = updateUser;
       this.userMapPhones = userMapPhones;
       this.userMapAddresses = userMapAddresses;
       this.socialNetworks = socialNetworks;
       this.userMapSocialNetworks = userMapSocialNetworks;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ID_USER", unique=true, nullable=false)
    public Long getIdUser() {
        return this.idUser;
    }
    
    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_PREFIX_NAME")
    public PrefixName getPrefixName() {
        return this.prefixName;
    }
    
    public void setPrefixName(PrefixName prefixName) {
        this.prefixName = prefixName;
    }

    
    @Column(name="USERNAME", nullable=false)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    
    @Column(name="PASSWORD", length=32)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="FIRST_NAME")
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    @Column(name="MID_NAME")
    public String getMidName() {
        return this.midName;
    }
    
    public void setMidName(String midName) {
        this.midName = midName;
    }

    
    @Column(name="LAST_NAME")
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    @Column(name="MAIDEN_SURNAME")
    public String getMaidenSurname() {
        return this.maidenSurname;
    }
    
    public void setMaidenSurname(String maidenSurname) {
        this.maidenSurname = maidenSurname;
    }

    
    @Column(name="NICK_NAME")
    public String getNickName() {
        return this.nickName;
    }
    
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    
    @Column(name="STATUS", length=1)
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name="CREATE_DATE", length=0)
    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    
    @Column(name="CREATE_USER")
    public String getCreateUser() {
        return this.createUser;
    }
    
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Basic
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name="UPDATE_DATE", length=0)
    public Date getUpdateDate() {
        return this.updateDate;
    }
    
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    
    @Column(name="UPDATE_USER")
    public String getUpdateUser() {
        return this.updateUser;
    }
    
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
    public List<UserMapPhone> getUserMapPhones() {
        return this.userMapPhones;
    }
    
    public void setUserMapPhones(List<UserMapPhone> userMapPhones) {
        this.userMapPhones = userMapPhones;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
    public List<UserMapAddress> getUserMapAddresses() {
        return this.userMapAddresses;
    }
    
    public void setUserMapAddresses(List<UserMapAddress> userMapAddresses) {
        this.userMapAddresses = userMapAddresses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
    public List<SocialNetwork> getSocialNetworks() {
        return this.socialNetworks;
    }
    
    public void setSocialNetworks(List<SocialNetwork> socialNetworks) {
        this.socialNetworks = socialNetworks;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
    public List<UserMapSocialNetwork> getUserMapSocialNetworks() {
        return this.userMapSocialNetworks;
    }
    
    public void setUserMapSocialNetworks(List<UserMapSocialNetwork> userMapSocialNetworks) {
        this.userMapSocialNetworks = userMapSocialNetworks;
    }

    /**
     * toString
     * @return String
     */
     public String toString() {
	  StringBuffer buffer = new StringBuffer();

      buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
      buffer.append("idUser").append("='").append(getIdUser()).append("' ");			
      buffer.append("prefixName").append("='").append(getPrefixName()).append("' ");			
      buffer.append("username").append("='").append(getUsername()).append("' ");			
      buffer.append("password").append("='").append(getPassword()).append("' ");			
      buffer.append("firstName").append("='").append(getFirstName()).append("' ");			
      buffer.append("midName").append("='").append(getMidName()).append("' ");			
      buffer.append("lastName").append("='").append(getLastName()).append("' ");			
      buffer.append("maidenSurname").append("='").append(getMaidenSurname()).append("' ");			
      buffer.append("nickName").append("='").append(getNickName()).append("' ");			
      buffer.append("status").append("='").append(getStatus()).append("' ");			
      buffer.append("createDate").append("='").append(getCreateDate()).append("' ");			
      buffer.append("createUser").append("='").append(getCreateUser()).append("' ");			
      buffer.append("updateDate").append("='").append(getUpdateDate()).append("' ");			
      buffer.append("updateUser").append("='").append(getUpdateUser()).append("' ");			
      buffer.append("]");
      
      return buffer.toString();
     }

   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof User) ) return false;
		 User castOther = ( User ) other; 
         
		 return ( (this.getIdUser()==castOther.getIdUser()) || ( this.getIdUser()!=null && castOther.getIdUser()!=null && this.getIdUser().equals(castOther.getIdUser()) ) )
 && ( (this.getPrefixName()==castOther.getPrefixName()) || ( this.getPrefixName()!=null && castOther.getPrefixName()!=null && this.getPrefixName().equals(castOther.getPrefixName()) ) )
 && ( (this.getUsername()==castOther.getUsername()) || ( this.getUsername()!=null && castOther.getUsername()!=null && this.getUsername().equals(castOther.getUsername()) ) )
 && ( (this.getPassword()==castOther.getPassword()) || ( this.getPassword()!=null && castOther.getPassword()!=null && this.getPassword().equals(castOther.getPassword()) ) )
 && ( (this.getFirstName()==castOther.getFirstName()) || ( this.getFirstName()!=null && castOther.getFirstName()!=null && this.getFirstName().equals(castOther.getFirstName()) ) )
 && ( (this.getMidName()==castOther.getMidName()) || ( this.getMidName()!=null && castOther.getMidName()!=null && this.getMidName().equals(castOther.getMidName()) ) )
 && ( (this.getLastName()==castOther.getLastName()) || ( this.getLastName()!=null && castOther.getLastName()!=null && this.getLastName().equals(castOther.getLastName()) ) )
 && ( (this.getMaidenSurname()==castOther.getMaidenSurname()) || ( this.getMaidenSurname()!=null && castOther.getMaidenSurname()!=null && this.getMaidenSurname().equals(castOther.getMaidenSurname()) ) )
 && ( (this.getNickName()==castOther.getNickName()) || ( this.getNickName()!=null && castOther.getNickName()!=null && this.getNickName().equals(castOther.getNickName()) ) )
 && ( (this.getStatus()==castOther.getStatus()) || ( this.getStatus()!=null && castOther.getStatus()!=null && this.getStatus().equals(castOther.getStatus()) ) )
 && ( (this.getCreateDate()==castOther.getCreateDate()) || ( this.getCreateDate()!=null && castOther.getCreateDate()!=null && this.getCreateDate().equals(castOther.getCreateDate()) ) )
 && ( (this.getCreateUser()==castOther.getCreateUser()) || ( this.getCreateUser()!=null && castOther.getCreateUser()!=null && this.getCreateUser().equals(castOther.getCreateUser()) ) )
 && ( (this.getUpdateDate()==castOther.getUpdateDate()) || ( this.getUpdateDate()!=null && castOther.getUpdateDate()!=null && this.getUpdateDate().equals(castOther.getUpdateDate()) ) )
 && ( (this.getUpdateUser()==castOther.getUpdateUser()) || ( this.getUpdateUser()!=null && castOther.getUpdateUser()!=null && this.getUpdateUser().equals(castOther.getUpdateUser()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getIdUser() == null ? 0 : this.getIdUser().hashCode() );
         result = 37 * result + ( getPrefixName() == null ? 0 : this.getPrefixName().hashCode() );
         result = 37 * result + ( getUsername() == null ? 0 : this.getUsername().hashCode() );
         result = 37 * result + ( getPassword() == null ? 0 : this.getPassword().hashCode() );
         result = 37 * result + ( getFirstName() == null ? 0 : this.getFirstName().hashCode() );
         result = 37 * result + ( getMidName() == null ? 0 : this.getMidName().hashCode() );
         result = 37 * result + ( getLastName() == null ? 0 : this.getLastName().hashCode() );
         result = 37 * result + ( getMaidenSurname() == null ? 0 : this.getMaidenSurname().hashCode() );
         result = 37 * result + ( getNickName() == null ? 0 : this.getNickName().hashCode() );
         result = 37 * result + ( getStatus() == null ? 0 : this.getStatus().hashCode() );
         result = 37 * result + ( getCreateDate() == null ? 0 : this.getCreateDate().hashCode() );
         result = 37 * result + ( getCreateUser() == null ? 0 : this.getCreateUser().hashCode() );
         result = 37 * result + ( getUpdateDate() == null ? 0 : this.getUpdateDate().hashCode() );
         result = 37 * result + ( getUpdateUser() == null ? 0 : this.getUpdateUser().hashCode() );
         
         
         
         
         return result;
   }

@Transient
@Override
public String getSub() {
	return idUser+"";
}


@Override
public void setSub(String sub) {
	// TODO Auto-generated method stub
	
}

@Transient
@Override
public String getPreferredUsername() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public void setPreferredUsername(String preferredUsername) {
	// TODO Auto-generated method stub
	
}

@Transient
@Override
public String getName() {
	return firstName;
}


@Override
public void setName(String name) {
	// TODO Auto-generated method stub
	
}

@Transient
@Override
public String getGivenName() {
	return firstName;
}


@Override
public void setGivenName(String givenName) {
	// TODO Auto-generated method stub
	
}

@Transient
@Override
public String getFamilyName() {
	return lastName;
}


@Override
public void setFamilyName(String familyName) {
	// TODO Auto-generated method stub
	
}

@Transient
@Override
public String getMiddleName() {
	return midName;
}


@Override
public void setMiddleName(String middleName) {
	// TODO Auto-generated method stub
	
}

@Transient
@Override
public String getNickname() {
	return nickName;
}


@Override
public void setNickname(String nickname) {
	// TODO Auto-generated method stub
	
}

@Transient
@Override
public String getProfile() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public void setProfile(String profile) {
	// TODO Auto-generated method stub
	
}

@Transient
@Override
public String getPicture() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public void setPicture(String picture) {
	// TODO Auto-generated method stub
	
}

@Transient
@Override
public String getWebsite() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public void setWebsite(String website) {
	// TODO Auto-generated method stub
	
}

@Transient
@Override
public String getEmail() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public void setEmail(String email) {
	// TODO Auto-generated method stub
	
}

@Transient
@Override
public Boolean getEmailVerified() {
	return "A".equals(status);
}


@Override
public void setEmailVerified(Boolean emailVerified) {
	// TODO Auto-generated method stub
	
}

@Transient
@Override
public String getGender() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public void setGender(String gender) {
	// TODO Auto-generated method stub
	
}

@Transient
@Override
public String getZoneinfo() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public void setZoneinfo(String zoneinfo) {
	// TODO Auto-generated method stub
	
}

@Transient
@Override
public String getLocale() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public void setLocale(String locale) {
	// TODO Auto-generated method stub
	
}

@Transient
@Override
public String getPhoneNumber() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public void setPhoneNumber(String phoneNumber) {
	// TODO Auto-generated method stub
	
}

@Transient
@Override
public Boolean getPhoneNumberVerified() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public void setPhoneNumberVerified(Boolean phoneNumberVerified) {
	// TODO Auto-generated method stub
	
}

@Transient
@Override
public IAddress getAddress() {
	UserMapAddress userMapAddress = userMapAddresses.get(0);
	return  userMapAddress!=null?userMapAddress.getAddress():null;
}


@Override
public void setAddress(IAddress address) {
	// TODO Auto-generated method stub
	
}

@Transient
@Override
public String getUpdatedTime() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public void setUpdatedTime(String updatedTime) {
	// TODO Auto-generated method stub
	
}

@Transient
@Override
public String getBirthdate() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public void setBirthdate(String birthdate) {
	// TODO Auto-generated method stub
	
}

@Transient
@Override
public JsonObject toJson() {
	if (src == null) {

		JsonObject obj = new JsonObject();

		obj.addProperty("sub", this.getSub());

		obj.addProperty("name", this.getName());
		obj.addProperty("preferred_username", this.getPreferredUsername());
		obj.addProperty("given_name", this.getGivenName());
		obj.addProperty("family_name", this.getFamilyName());
		obj.addProperty("middle_name", this.getMiddleName());
		obj.addProperty("nickname", this.getNickname());
		obj.addProperty("profile", this.getProfile());
		obj.addProperty("picture", this.getPicture());
		obj.addProperty("website", this.getWebsite());
		obj.addProperty("gender", this.getGender());
		obj.addProperty("zoneinfo", this.getZoneinfo());
		obj.addProperty("locale", this.getLocale());
		obj.addProperty("updated_at", this.getUpdatedTime());
		obj.addProperty("birthdate", this.getBirthdate());

		obj.addProperty("email", this.getEmail());
		obj.addProperty("email_verified", this.getEmailVerified());

		obj.addProperty("phone_number", this.getPhoneNumber());
		obj.addProperty("phone_number_verified", this.getPhoneNumberVerified());

		if (this.getAddress() != null) {

			JsonObject addr = new JsonObject();
			addr.addProperty("formatted", this.getAddress().getFormatted());
			addr.addProperty("street_address", this.getAddress().getStreetAddress());
			addr.addProperty("locality", this.getAddress().getLocality());
			addr.addProperty("region", this.getAddress().getRegion());
			addr.addProperty("postal_code", this.getAddress().getPostalCode());
			addr.addProperty("country", this.getAddress().getCountry());

			obj.add("address", addr);
		}

		return obj;
	} else {
		return src;
	}
}

@Transient
@Override
public JsonObject getSource() {
	// TODO Auto-generated method stub
	return null;
}   


}


