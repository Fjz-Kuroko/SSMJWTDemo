package pers.kuroko.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pers.kuroko.entity.User;

@Repository("userDao")
@Mapper
public interface UserDao {
    User login(User user);
}
