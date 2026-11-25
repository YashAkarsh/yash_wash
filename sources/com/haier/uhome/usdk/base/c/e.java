package com.haier.uhome.usdk.base.c;

import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {
    public final void handle(BasicNotify basicNotify) {
        handleReceive(basicNotify);
    }

    protected abstract void handleReceive(BasicNotify basicNotify);
}
