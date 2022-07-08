package com.edu.controller;

import com.edu.constant.Code;
import com.edu.constant.Result;
import com.edu.mapper.UserMapper;
import com.edu.pojo.Activity;
import com.edu.pojo.User;
import com.edu.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;
    @Autowired
    private UserMapper userMapper;

    //创建项目
    @RequestMapping("/createAct")
    public String save(String time, String content, String starting, String cost, String ending, HttpSession session) {
        Activity activity = new Activity();

        activity.setTime(time);
        activity.setContent(content);
        activity.setStarting(starting);
        activity.setCost(Integer.parseInt(cost));
        activity.setEnding(ending);
        String username = (String) session.getAttribute("username");
        User user = userMapper.queryUserByName(username);
        //设置团长
        activity.setHead(user.getId());
        //设置成员
        activity.setMember(user.getId()+"0");
        activity.setCosted(0);
        //0代表活动未完成，1代表活动完成。
        activity.setFinish(0);
//        System.out.println(activity);
        int flag = activityService.addActivity(activity);
        String msg = "fail";
        if(flag > 0){
            msg = "success";
        }
//        System.out.println("msg = "+msg);
        return msg;
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
    public List<Activity> getAll() {
        List<Activity> activityList = activityService.getAll();
        Integer code = activityList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = activityList != null ? "" : "数据查询失败，请重试！";
        return activityList;
    }

    @GetMapping("/GetHeadAct/{head}")
    public List<Activity> getHeadAct(@PathVariable Integer head){
        List<Activity> activityList = activityService.getHeadAct(head);
        return activityList;
    }

}