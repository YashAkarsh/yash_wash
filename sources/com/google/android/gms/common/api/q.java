package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
public class q extends b {
    public q(@m0 Status status) {
        super(status);
    }

    @m0
    public PendingIntent d() {
        return a().Q();
    }

    public void e(@m0 Activity activity, int i7) throws IntentSender.SendIntentException {
        a().I0(activity, i7);
    }
}
