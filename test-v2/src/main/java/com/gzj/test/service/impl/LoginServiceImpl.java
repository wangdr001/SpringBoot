package com.gzj.test.service.impl;

import com.gzj.test.entity.Permissions;
import com.gzj.test.entity.Role;
import com.gzj.test.entity.User;
import com.gzj.test.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public User getUserByName(String userName) {
        return getMapByName(userName);
    }

    /**
     * 模拟数据库查询
     * @param userName 用户名
     * @return User
     */
    private User getMapByName(String userName) {

        //权限
        Permissions permissions1 = new Permissions("1", "query");
        Permissions permissions2 = new Permissions("2", "add");
        Set<Permissions> permissionsSet = new HashSet<>();
        permissionsSet.add(permissions1);
        permissionsSet.add(permissions2);

        //角色
        Role role = new Role("1", "admin", permissionsSet);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);

        //用户
        User user = new User("1", "zhangsan", "123456", roleSet);
        Map<String, User> map = new HashMap<>();
        map.put(user.getUserName(), user);

        Set<Permissions> permissionsSet1 = new HashSet<>();
        permissionsSet1.add(permissions1);
        Role role1 = new Role("2", "user", permissionsSet1);
        Set<Role> roleSet1 = new HashSet<>();
        roleSet1.add(role1);
        User user1 = new User("2", "lisi", "123456", roleSet1);
        map.put(user1.getUserName(), user1);
        
        return map.get(userName);
    }
}
