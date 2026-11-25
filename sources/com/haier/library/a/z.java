package com.haier.library.a;

import android.support.v4.media.session.PlaybackStateCompat;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final long f26338a = 65536;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    static y f26339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static long f26340c;

    private z() {
    }

    static y a() {
        synchronized (z.class) {
            y yVar = f26339b;
            if (yVar == null) {
                return new y();
            }
            f26339b = yVar.f26336f;
            yVar.f26336f = null;
            f26340c -= PlaybackStateCompat.f450z;
            return yVar;
        }
    }

    static void b(y yVar) {
        if (yVar.f26336f != null || yVar.f26337g != null) {
            throw new IllegalArgumentException();
        }
        if (yVar.f26334d) {
            return;
        }
        synchronized (z.class) {
            long j7 = f26340c;
            if (j7 + PlaybackStateCompat.f450z > 65536) {
                return;
            }
            f26340c = j7 + PlaybackStateCompat.f450z;
            yVar.f26336f = f26339b;
            yVar.f26333c = 0;
            yVar.f26332b = 0;
            f26339b = yVar;
        }
    }
}
