package com.cardvalue.penguin.model;

import com.cardvalue.penguin.dto.ConfirmlistDetailDTO;

import java.util.List;

/**
 * Created by Mr tao on 2015/6/10.
 */
public class ConfirmlistModel {
    private String title;
    private List<ConfirmlistDetailDTO> items;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ConfirmlistDetailDTO> getItems() {
        return items;
    }

    public void setItems(List<ConfirmlistDetailDTO> items) {
        this.items = items;
    }
}
