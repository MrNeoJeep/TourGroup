package com.edu.dao;

import com.edu.pojo.Activity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ActivityDao {
    @Insert("insert into activity (time, head, content, starting, member, cost, costed,finish,ending) values(#{time}, #{head}, #{content}, #{starting}, #{member}, #{cost}, #{costed},#{finish},#{ending})")
    public void save(Activity activity);

    @Update("update activity set time = #{time}, head = #{head}, content = #{content}, starting = #{starting}, member = #{member}, cost = #{cost} , costed = #{costed} where id = #{id}")
    public void update(Activity activity);

    @Delete("delete from activity where id = #{id}")
    public void delete(Integer id);

    @Select("select * from activity where id = #{id}")
    public Activity getById(Integer id);

    @Select("select * from activity")
    public List<Activity> getAll();

    @Select("select * from activity where head = #{head}")
    public List<Activity> getHeadAct(String head);

    @Update("update activity set member = #{member} where id = #{id}")
    public void updatemember(@Param("member") String member,@Param("id") Integer id);

    @Update("update activity set costed = #{costed} where id = #{id}")
    public void addcosted(@Param("costed") Integer costed,@Param("id") Integer id);
}