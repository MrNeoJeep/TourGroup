package com.edu.controller;

import com.edu.constant.Code;
import com.edu.constant.Result;
import com.edu.pojo.Activity;
import com.edu.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @PostMapping
    public Result save(@RequestBody Activity activity) {
        boolean flag = activityService.save(activity);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    @PutMapping
    public Result update(@RequestBody Activity activity) {
        boolean flag = activityService.update(activity);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = activityService.delete(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Activity activity = activityService.getById(id);
        Integer code = activity != null ? Code.GET_OK : Code.GET_ERR;
        String msg = activity != null ? "" : "数据查询失败，请重试！";
        return new Result(code, activity, msg);
    }

    @GetMapping
    public Result getAll() {
        List<Activity> activityList = activityService.getAll();
        Integer code = activityList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = activityList != null ? "" : "数据查询失败，请重试！";
        return new Result(code, activityList, msg);
    }
}