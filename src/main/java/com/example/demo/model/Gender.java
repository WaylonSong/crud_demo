package com.example.demo.model;

/**
 * Created by song on 2017/10/23.
 */
//TODO 尚未统一前端显示值与后台传值
public enum Gender{
    Male, Female;
    public String getLabel() {
        switch (this) {
            case Male:
                return "男";
            case Female:
                return "女";
        }
        return super.toString();
    }
}
