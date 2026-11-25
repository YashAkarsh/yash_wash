package com.haier.globalwasher.modle.bean;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class RunModeBeen implements Serializable {
    private String code;
    private String isDisply;
    private boolean isSelect = false;
    private String modeDescription;
    private String modeFeature;
    private String modeId;
    private String modeImage;
    private String modeName;
    private String price;
    private ArrayList<ShowRunModeBeen> showRunMode;
    private ArrayList<ShowRunModeBeen> subRunMode;
    private String timeDuration;

    public String getCode() {
        return this.code;
    }

    public String getIsDisply() {
        return this.isDisply;
    }

    public String getModeDescription() {
        return this.modeDescription;
    }

    public String getModeFeature() {
        return this.modeFeature;
    }

    public String getModeId() {
        return this.modeId;
    }

    public String getModeImage() {
        return this.modeImage;
    }

    public String getModeName() {
        return this.modeName;
    }

    public String getPrice() {
        return this.price;
    }

    public ArrayList<ShowRunModeBeen> getShowRunMode() {
        return this.showRunMode;
    }

    public ArrayList<ShowRunModeBeen> getSubRunMode() {
        return this.subRunMode;
    }

    public String getTimeDuration() {
        return this.timeDuration;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setIsDisply(String str) {
        this.isDisply = str;
    }

    public void setModeDescription(String str) {
        this.modeDescription = str;
    }

    public void setModeFeature(String str) {
        this.modeFeature = str;
    }

    public void setModeId(String str) {
        this.modeId = str;
    }

    public void setModeImage(String str) {
        this.modeImage = str;
    }

    public void setModeName(String str) {
        this.modeName = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setSelect(boolean z7) {
        this.isSelect = z7;
    }

    public void setShowRunMode(ArrayList<ShowRunModeBeen> arrayList) {
        this.showRunMode = arrayList;
    }

    public void setSubRunMode(ArrayList<ShowRunModeBeen> arrayList) {
        this.subRunMode = arrayList;
    }

    public void setTimeDuration(String str) {
        this.timeDuration = str;
    }

    public String toString() {
        return "RunModeBeen{modeId='" + this.modeId + "', modeName='" + this.modeName + "', price='" + this.price + "', timeDuration='" + this.timeDuration + "', modeDescription='" + this.modeDescription + "', modeFeature='" + this.modeFeature + "', isDisply='" + this.isDisply + "', code='" + this.code + "', modeImage='" + this.modeImage + "', showRunMode=" + this.showRunMode + ", subRunMode=" + this.subRunMode + ", isSelect=" + this.isSelect + '}';
    }
}
