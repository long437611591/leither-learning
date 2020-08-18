package arm.sec.iot.service.impl;

import arm.sec.iot.entity.User;
import arm.sec.iot.service.UserService;

public class UserServiceIml implements UserService{
    @Override
    public void saveUser(String name,String pasString) {
        User user1  =new User(name,pasString);
        user1.insert();
    }
}