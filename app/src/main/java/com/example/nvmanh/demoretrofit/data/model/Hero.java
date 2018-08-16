package com.example.nvmanh.demoretrofit.data.model;

import com.google.gson.annotations.SerializedName;

public class Hero {
    @SerializedName("ma")
    private String mId;
    @SerializedName("ten1")
    private String mName1;
    @SerializedName("ten2")
    private String mName2;
    @SerializedName("anhDaiDien")
    private String mAvatar;
    @SerializedName("truyenThuyet")
    private String mHistory;

    public Hero() {
    }

    public Hero(String id, String name1, String name2, String avatar, String history) {
        mId = id;
        mName1 = name1;
        mName2 = name2;
        mAvatar = avatar;
        mHistory = history;
    }

    public String getId() {
        return mId;
    }

    public String getName1() {
        return mName1;
    }

    public String getName2() {
        return mName2;
    }

    public String getAvatar() {
        return mAvatar;
    }

    public String getHistory() {
        return mHistory;
    }
}