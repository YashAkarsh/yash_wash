package com.google.android.gms.internal.base;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public class p extends Handler {
    public p() {
    }

    public p(Looper looper) {
        super(looper);
    }

    public p(Looper looper, Handler.Callback callback) {
        super(looper, callback);
    }
}
