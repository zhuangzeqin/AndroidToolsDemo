package com.eeepay.zzq.androidtoolsdemo.bean;

import java.io.Serializable;

/**
 * 描述：class describe
 * 作者：zhuangzeqin
 * 时间: 2020/6/19-15:15
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public class TestModel2 implements Serializable {
    private String imagePath;
    private String  name;

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    private int itemType;


    private String content;
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "TestModel{" +
                "imagePath='" + imagePath + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
