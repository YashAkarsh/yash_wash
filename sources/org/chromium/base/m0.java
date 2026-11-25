package org.chromium.base;

import android.os.StrictMode;
import java.io.Closeable;

/* JADX INFO: loaded from: classes3.dex */
public final class m0 implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StrictMode.ThreadPolicy f38821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StrictMode.VmPolicy f38822b;

    private m0(StrictMode.ThreadPolicy threadPolicy, StrictMode.VmPolicy vmPolicy) {
        this.f38821a = threadPolicy;
        this.f38822b = vmPolicy;
    }

    public static m0 b() {
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
        return new m0(vmPolicy);
    }

    public static m0 e() {
        return new m0(StrictMode.allowThreadDiskReads());
    }

    public static m0 q() {
        return new m0(StrictMode.allowThreadDiskWrites());
    }

    public static m0 r() {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitCustomSlowCalls().build());
        return new m0(threadPolicy);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        StrictMode.ThreadPolicy threadPolicy = this.f38821a;
        if (threadPolicy != null) {
            StrictMode.setThreadPolicy(threadPolicy);
        }
        StrictMode.VmPolicy vmPolicy = this.f38822b;
        if (vmPolicy != null) {
            StrictMode.setVmPolicy(vmPolicy);
        }
    }

    private m0(StrictMode.ThreadPolicy threadPolicy) {
        this(threadPolicy, null);
    }

    private m0(StrictMode.VmPolicy vmPolicy) {
        this(null, vmPolicy);
    }
}
