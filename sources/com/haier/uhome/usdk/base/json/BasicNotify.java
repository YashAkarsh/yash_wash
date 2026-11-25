package com.haier.uhome.usdk.base.json;

import com.haier.uhome.usdk.base.c.e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BasicNotify extends InComing {
    protected abstract e getNotifyHandler();

    @Override // com.haier.uhome.usdk.base.json.InComing
    public void handle() {
        getNotifyHandler().handle(this);
    }

    public String toString() {
        return "BasicNotify{}";
    }
}
