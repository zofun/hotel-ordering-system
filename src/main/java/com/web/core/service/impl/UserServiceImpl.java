package com.web.core.service.impl;

import com.web.core.mapper.UserMapper;
import com.web.core.pojo.User;
import com.web.core.service.UserService;
import com.web.utils.EncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author TCW
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;


    @Override
    public boolean register(User user) {
        //判断username是否已经被注册
        if (userMapper.selectCountByUsername(user.getUsername())>=1){
            return false;
        }

        //对密码进行加密
        String[] result = EncryptUtils.encryptPassword(user.getPassword());
        user.setPassword(result[0]);
        user.setSalt(result[1]);

        userMapper.insertUser(user);
        return true;
    }
}
