package com.edu.mapper;

import com.edu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    /**
     * 获取所有用户
     * @return
     */
    public List<User> getUserList();
    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    public User queryUserById(@Param("id")int id);

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public User queryUserByName(@Param("username") String username);

    /**
     * 增加用户
     * @param user
     * @return
     */
    public int addUser(User user);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public int editUser(User user);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    public int deleteUser(@Param("id") int id);
}
