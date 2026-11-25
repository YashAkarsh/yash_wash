package com.facebook;

import android.os.Handler;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class ProgressNoopOutputStream extends OutputStream implements RequestOutputStream {
    private int batchMax;
    private final Handler callbackHandler;
    private GraphRequest currentRequest;
    private RequestProgress currentRequestProgress;
    private final Map<GraphRequest, RequestProgress> progressMap = new HashMap();

    ProgressNoopOutputStream(Handler handler) {
        this.callbackHandler = handler;
    }

    void addProgress(long j7) {
        if (this.currentRequestProgress == null) {
            RequestProgress requestProgress = new RequestProgress(this.callbackHandler, this.currentRequest);
            this.currentRequestProgress = requestProgress;
            this.progressMap.put(this.currentRequest, requestProgress);
        }
        this.currentRequestProgress.addToMax(j7);
        this.batchMax = (int) (((long) this.batchMax) + j7);
    }

    int getMaxProgress() {
        return this.batchMax;
    }

    Map<GraphRequest, RequestProgress> getProgressMap() {
        return this.progressMap;
    }

    @Override // com.facebook.RequestOutputStream
    public void setCurrentRequest(GraphRequest graphRequest) {
        this.currentRequest = graphRequest;
        this.currentRequestProgress = graphRequest != null ? this.progressMap.get(graphRequest) : null;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        addProgress(bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i7, int i8) {
        addProgress(i8);
    }

    @Override // java.io.OutputStream
    public void write(int i7) {
        addProgress(1L);
    }
}
