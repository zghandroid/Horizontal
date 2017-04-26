package com.example.zhang.horizontalgridview.http.bean.nba;

/**
 * Created by 12345 on 2017/4/25.
 */

public class NBAIndex {

    /**
     * type : news
     * id : 20170425036701
     * column : videos
     * needUpdate : 0
     */

    private String type;
    private String id;
    private String column;
    private String needUpdate;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getNeedUpdate() {
        return needUpdate;
    }

    public void setNeedUpdate(String needUpdate) {
        this.needUpdate = needUpdate;
    }
}
