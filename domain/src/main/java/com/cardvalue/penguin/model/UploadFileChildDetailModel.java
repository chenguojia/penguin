package com.cardvalue.penguin.model;

/**
 * Created by Mr tao on 2015/6/2.
 */
public class UploadFileChildDetailModel {

    private String checklistId;//分组id
    private String fileId;//文件id
    private String name;//文件中文描述名称
    private Double width;//图片宽度
    private Double height;//图片高度
    private String url;//图片显示url
    private String time;//时间
    private String thumbnail;//压缩图片位置
    private String fileName;//文件名称

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(String checklistId) {
        this.checklistId = checklistId;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
