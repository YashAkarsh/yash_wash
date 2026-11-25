package com.haier.uhome.video.bean;

/* JADX INFO: loaded from: classes2.dex */
public class MessagePlaybackNode {
    public long endTime;
    public String recordType = "";
    public long startTime;

    public long getDuration() {
        return this.endTime - this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public String getRecordType() {
        return this.recordType;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public void setEndTime(long j7) {
        this.endTime = j7;
    }

    public void setRecordType(String str) {
        this.recordType = str;
    }

    public void setStartTime(long j7) {
        this.startTime = j7;
    }

    public String toString() {
        return "MessagePlaybackNode{startTime=" + this.startTime + ", endTime=" + this.endTime + ", recordType='" + this.recordType + "'}";
    }
}
