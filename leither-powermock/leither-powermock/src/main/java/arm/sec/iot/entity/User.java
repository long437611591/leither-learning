package arm.sec.iot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;


public class User {

    private String name ;
    private String password;

    public void insert() {
        throw new UnsupportedOperationException();
    }

    public User(User user){
        this.name = user.getName();
        this.password = user.getPassword();
    }

    public User(String name,String pasString) {
        this.name = name;
        this.password = pasString;
	}

	public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}