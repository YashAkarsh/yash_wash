package com.haier.uhome.usdk.base.json;

/* JADX INFO: loaded from: classes2.dex */
public abstract class InComing {
    private int mTo;

    public int getTo() {
        return this.mTo;
    }

    public abstract void handle();

    public void setTo(int i7) {
        this.mTo = i7;
    }
}
