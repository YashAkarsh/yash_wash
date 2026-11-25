package com.haier.globalwasher.modle.bean.share;

import android.graphics.Bitmap;
import com.haier.globalwasher.modle.js_api.BaseJsBean;

/* JADX INFO: loaded from: classes2.dex */
public class H5ShareJsonbean extends BaseJsBean {
    private Bitmap bitmap;
    private String description;
    private String imgUrl;
    private String musicJumpUrl;
    private String musicUrl;
    private String text;
    private String title;
    private String url;
    private String videoUrl;
    private String zoomIMGUrl;

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public String getMusicJumpUrl() {
        return this.musicJumpUrl;
    }

    public String getMusicUrl() {
        return this.musicUrl;
    }

    public String getText() {
        return this.text;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getZoomIMGUrl() {
        return this.zoomIMGUrl;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public void setMusicJumpUrl(String str) {
        this.musicJumpUrl = str;
    }

    public void setMusicUrl(String str) {
        this.musicUrl = str;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVideoUrl(String str) {
        this.videoUrl = str;
    }

    public void setZoomIMGUrl(String str) {
        this.zoomIMGUrl = str;
    }

    public String toString() {
        return "H5ShareJsonbean{text='" + this.text + "', url='" + this.url + "', imgUrl='" + this.imgUrl + "', videoUrl='" + this.videoUrl + "', musicUrl='" + this.musicUrl + "', musicJumpUrl='" + this.musicJumpUrl + "', title='" + this.title + "', zoomIMGUrl='" + this.zoomIMGUrl + "', description='" + this.description + "', callBackMethodName='" + getCallBackMethodName() + "'}";
    }
}
