package com.google.android.gms.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface b {
    @c.w0("com.google.android.gms.permission.ACTIVITY_RECOGNITION")
    @c.m0
    com.google.android.gms.common.api.n<Status> a(@c.m0 com.google.android.gms.common.api.k kVar, @c.m0 PendingIntent pendingIntent);

    @c.w0("com.google.android.gms.permission.ACTIVITY_RECOGNITION")
    @c.m0
    com.google.android.gms.common.api.n<Status> b(@c.m0 com.google.android.gms.common.api.k kVar, long j7, @c.m0 PendingIntent pendingIntent);
}
