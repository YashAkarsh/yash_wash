package com.haier.uhome.video.bean;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class MonitorPlaybackMessage {
    public int currentPage;
    public int pageCount;
    public ArrayList<MessagePlaybackNode> playbackList = new ArrayList<>();

    public int getCurrentPage() {
        return this.currentPage;
    }

    public int getPageCount() {
        return this.pageCount;
    }

    public ArrayList<MessagePlaybackNode> getPlaybackList() {
        return this.playbackList;
    }

    public void setCurrentPage(int i7) {
        this.currentPage = i7;
    }

    public void setPageCount(int i7) {
        this.pageCount = i7;
    }

    public void setPlaybackList(ArrayList<MessagePlaybackNode> arrayList) {
        this.playbackList = arrayList;
    }

    public String toString() {
        return "MonitorPlaybackMessage{currentPage=" + this.currentPage + ", pageCount=" + this.pageCount + ", playbackList=" + this.playbackList + '}';
    }
}
