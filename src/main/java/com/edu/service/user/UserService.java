package com.edu.service.user;

import com.edu.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
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
    public User queryUserById(int id);

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public User queryUserByName(String username);

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
    public int deleteUser(int id);
}
