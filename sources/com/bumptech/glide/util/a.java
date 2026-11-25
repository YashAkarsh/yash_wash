package com.bumptech.glide.util;

import android.util.Log;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f14909b = "ByteArrayPool";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f14910c = 65536;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f14911d = 2146304;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f14912e = 32;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final a f14913f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Queue<byte[]> f14914a = i.d(0);

    private a() {
    }

    public static a b() {
        return f14913f;
    }

    public void a() {
        synchronized (this.f14914a) {
            this.f14914a.clear();
        }
    }

    public byte[] c() {
        byte[] bArrPoll;
        synchronized (this.f14914a) {
            bArrPoll = this.f14914a.poll();
        }
        if (bArrPoll == null) {
            bArrPoll = new byte[65536];
            if (Log.isLoggable(f14909b, 3)) {
                Log.d(f14909b, "Created temp bytes");
            }
        }
        return bArrPoll;
    }

    public boolean d(byte[] bArr) {
        boolean z7 = false;
        if (bArr.length != 65536) {
            return false;
        }
        synchronized (this.f14914a) {
            if (this.f14914a.size() < 32) {
                this.f14914a.offer(bArr);
                z7 = true;
            }
        }
        return z7;
    }
}
