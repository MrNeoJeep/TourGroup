package com.edu.mapper;

import com.edu.pojo.Activity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ActivityMapper {
    /**
     * 增加活动
     * @param activity
     * @return
     */
    public int addActivity(Activity activity);

    public int updateActivity(Activity activity);

    public Activity queryActivityByName(String name);
}
