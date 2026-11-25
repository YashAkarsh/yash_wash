package com.haier.globalwasher.modle.bean.pay;

/* JADX INFO: loaded from: classes2.dex */
public class PayListBeen {
    private String activityname;
    private String code;
    private String description;
    private String displyName;
    private String endTime;
    private Integer id;
    private String imgUrl;
    private boolean isSelect = false;
    private boolean isSelectContent;
    private Integer sort;

    public String getActivityname() {
        return this.activityname;
    }

    public String getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDisplyName() {
        return this.displyName;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public String getId() {
        return this.id + "";
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public Integer getSort() {
        return this.sort;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public boolean isSelectContent() {
        return this.isSelectContent;
    }

    public void setActivityname(String str) {
        this.activityname = str;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDisplyName(String str) {
        this.displyName = str;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public void setSelect(boolean z7) {
        this.isSelect = z7;
    }

    public void setSelectContent(boolean z7) {
        this.isSelectContent = z7;
    }

    public void setSort(Integer num) {
        this.sort = num;
    }
}
