package com.web.core.mapper;

import com.web.core.pojo.User;

import javax.management.Query;
import java.util.List;

public interface UserMapper {

    List<User> queryAll(int start,int limit);
}
