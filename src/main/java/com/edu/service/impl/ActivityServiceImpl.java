package com.edu.service.impl;

import com.edu.dao.ActivityDao;
import com.edu.mapper.ActivityMapper;
import com.edu.pojo.Activity;
import com.edu.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Activity> getHeadAct(Integer head) {
        return  activityDao.getHeadAct(head);
    }
}