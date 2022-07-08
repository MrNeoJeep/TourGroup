package com.edu.pojo;

import javax.persistence.criteria.CriteriaBuilder;

public class AddCosted {
    private Integer activityid;
    private String money;
    private String yijiao;

    public Integer getActivityid() {
        return activityid;
    }

    public void setActivityid(Integer activityid) {
        this.activityid = activityid;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getYijiao() {
        return yijiao;
    }

    public void setYijiao(String yijiao) {
        this.yijiao = yijiao;
    }
}
