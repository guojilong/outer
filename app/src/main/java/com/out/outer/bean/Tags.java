package com.out.outer.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guojilong on 2015/8/31.
 */
public class Tags extends Base{

    private int page;
    private List<Tag> tags = new ArrayList<>();

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public int getTotal_page() {
        return total_page;
    }

    public void setTotal_page(int total_page) {
        this.total_page = total_page;
    }

    private int total_page;
}
