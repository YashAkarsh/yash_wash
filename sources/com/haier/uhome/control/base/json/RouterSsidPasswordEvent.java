package com.haier.uhome.control.base.json;

/* JADX INFO: loaded from: classes2.dex */
public class RouterSsidPasswordEvent {
    private String bleDevId;
    private String devId;
    private int progress;
    private int result;
    private int state;
    private int stateCode;

    public String getBleDevId() {
        return this.bleDevId;
    }

    public String getDevId() {
        return this.devId;
    }

    public int getProgress() {
        return this.progress;
    }

    public int getResult() {
        return this.result;
    }

    public int getState() {
        return this.state;
    }

    public int getStateCode() {
        return this.stateCode;
    }

    public void setBleDevId(String str) {
        this.bleDevId = str;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setProgress(int i7) {
        this.progress = i7;
    }

    public void setResult(int i7) {
        this.result = i7;
    }

    public void setState(int i7) {
        this.state = i7;
    }

    public void setStateCode(int i7) {
        this.stateCode = i7;
    }

    public String toString() {
        return "RouterSsidPasswordEvent{devId='" + this.devId + "', bleDevId='" + this.bleDevId + "', progress=" + this.progress + ", result=" + this.result + ", state=" + this.state + ", stateCode=" + this.stateCode + '}';
    }
}
