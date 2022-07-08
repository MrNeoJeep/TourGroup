package com.edu.service.impl;

import com.edu.dao.ActivityDao;
import com.edu.mapper.ActivityMapper;
import com.edu.pojo.Activity;
import com.edu.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityDao activityDao;

    @Autowired
    private ActivityMapper activityMapper;
    @Override
    public boolean save(Activity activity) {
        activityDao.save(activity);
        return true;
    }

    @Override
    public boolean update(Activity activity) {
        activityDao.update(activity);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        activityDao.delete(id);
        return true;
    }

    @Override
    public Activity getById(Integer id) {
        return activityDao.getById(id);
    }

    @Override
    public List<Activity> getAll() {
        return activityDao.getAll();
    }



    @Override
    public int addActivity(Activity activity) {
        return activityMapper.addActivity(activity);
    }

    @Override
    public List<Activity> getHeadAct(String head) {
        return  activityDao.getHeadAct(head);
    }

    @Override
    public boolean updatemember(String member, Integer id) {
        activityDao.updatemember(member, id);
        return true;
    }

    @Override
    public List<Activity> getYiJiaRu(String username) {
        List<Activity> activityList = activityDao.getAll();
        String[] split;
        List<Activity> ans = new ArrayList<>();
        for (Activity activity : activityList) {
            String member = activity.getMember();
            if(member == null) continue;
            System.out.println(activity.getMember());
            split = member.split(",");//以逗号分割
            boolean k = false;
            for (String string2 : split) {
                System.out.println("数据-->>>" + string2);
                if (Objects.equals(string2, username)) {
                    k = true;
                    break;
                }
            }
            if (k)
                ans.add(activity);
        }
        return ans;
    }

    @Override
    public boolean addcosted(Integer costed,Integer id){
        activityDao.addcosted(costed, id);
        return true;
    }

    @Override
    public int updateActivity(Activity activity) {
        return activityMapper.updateActivity(activity);
    }

    @Override
    public Activity queryActivityByName(String name) {
        return activityMapper.queryActivityByName(name);
    }

}