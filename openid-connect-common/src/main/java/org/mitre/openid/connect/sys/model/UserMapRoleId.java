package org.mitre.openid.connect.sys.model;



import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UserMapRoleId generated by hbm2java
 */
@Embeddable
public class UserMapRoleId  implements java.io.Serializable {


     private Long idUser;
     private Long idRole;

    public UserMapRoleId() {
    }

    public UserMapRoleId(Long idUser, Long idRole) {
       this.idUser = idUser;
       this.idRole = idRole;
    }
   


    @Column(name="ID_USER", nullable=false)
    public Long getIdUser() {
        return this.idUser;
    }
    
    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }


    @Column(name="ID_ROLE", nullable=false)
    public Long getIdRole() {
        return this.idRole;
    }
    
    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof UserMapRoleId) ) return false;
		 UserMapRoleId castOther = ( UserMapRoleId ) other; 
         
		 return ( (this.getIdUser()==castOther.getIdUser()) || ( this.getIdUser()!=null && castOther.getIdUser()!=null && this.getIdUser().equals(castOther.getIdUser()) ) )
 && ( (this.getIdRole()==castOther.getIdRole()) || ( this.getIdRole()!=null && castOther.getIdRole()!=null && this.getIdRole().equals(castOther.getIdRole()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getIdUser() == null ? 0 : this.getIdUser().hashCode() );
         result = 37 * result + ( getIdRole() == null ? 0 : this.getIdRole().hashCode() );
         return result;
   }   


}

