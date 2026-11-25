package com.haier.uhome.usdk.base.json;

import com.haier.uhome.usdk.base.d.e;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class OutGoing {

    @b(serialize = false)
    private e nativeSender;

    public abstract String buildJson();

    public e getNativeSender() {
        return this.nativeSender;
    }

    public void setNativeSender(e eVar) {
        this.nativeSender = eVar;
    }
}
