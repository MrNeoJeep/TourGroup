package com.edu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
    private Integer id;
    private String time;
    private String head;
    private String content;
    private String starting;//出发地
    private String member;
    private Integer cost;
    private Integer costed;
    private int finish;
    private String ending;

}