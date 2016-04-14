package com.cardvalue.penguin.model;

/**
 * Created by Mr tao on 2015/6/2.
 */
public class UploadFileMainModel {
    private String title;
    private String lackFiles;//缺少上传照片数量2222
    private String coverUrl;
    private Double coverWidth;//图片宽度
    private Double coverHeight;//图片高度

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLackFiles() {
        return lackFiles;
    }

    public void setLackFiles(String lackFiles) {
        this.lackFiles = lackFiles;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public Double getCoverWidth() {
        return coverWidth;
    }

    public void setCoverWidth(Double coverWidth) {
        this.coverWidth = coverWidth;
    }

    public Double getCoverHeight() {
        return coverHeight;
    }

    public void setCoverHeight(Double coverHeight) {
        this.coverHeight = coverHeight;
    }

    @Override
    public String toString() {
        return "UploadFileMainModel{" +
                "title='" + title + '\'' +
                ", lackFiles='" + lackFiles + '\'' +
                ", coverUrl='" + coverUrl + '\'' +
                ", coverWidth=" + coverWidth +
                ", coverHeight=" + coverHeight +
                '}';
    }
}
