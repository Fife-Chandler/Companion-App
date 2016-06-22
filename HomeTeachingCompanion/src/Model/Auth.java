package Model;

public class Auth {
    private Integer id;
    private String username;
    private String password;
    private boolean privileage;
    private String description;
    private Integer memberID;
    
    public Auth(
	Integer id,
	String username,
  	String password, 
	boolean privileage, 
	String description,
	Integer memberID
	) 
	{
        this.id = id;
        this.username = username;
        this.password = password;
        this.privileage = privileage;
        this.description = description;
        this.memberID = memberID;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isPrivileage() {
        return privileage;
    }

    public void setPrivileage(boolean privileage) {
        this.privileage = privileage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMemberID() {
        return memberID;
    }

    public void setMemberID(Integer memberID) {
        this.memberID = memberID;
    }
}
