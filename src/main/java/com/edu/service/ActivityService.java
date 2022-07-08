package com.edu.service;

import com.edu.pojo.Activity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ActivityService {
    public boolean save(Activity activity);

    public boolean update(Activity activity);

    public boolean delete(Integer id);

    public Activity getById(Integer id);

    public List<Activity> getAll();

    public int addActivity(Activity activity);

    public List<Activity> getHeadAct(String head);

    public boolean updatemember(String member,Integer id);

    public List<Activity> getYiJiaRu(String username);

    public boolean addcosted(Integer costed,Integer id);

    public int updateActivity(Activity activity);

    public Activity queryActivityByName(String name);
}