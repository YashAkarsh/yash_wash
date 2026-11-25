package com.haier.uhome.video.bean;

/* JADX INFO: loaded from: classes2.dex */
public class PlayAddressBean {
    private int endTime;
    private boolean endflag;
    private int startTime;
    private String url;

    public int getEndTime() {
        return this.endTime;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isEndflag() {
        return this.endflag;
    }

    public void setEndTime(int i7) {
        this.endTime = i7;
    }

    public void setEndflag(boolean z7) {
        this.endflag = z7;
    }

    public void setStartTime(int i7) {
        this.startTime = i7;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "PlayAddressBean{endTime=" + this.endTime + ", endflag=" + this.endflag + ", startTime=" + this.startTime + ", url='" + this.url + "'}";
    }
}
