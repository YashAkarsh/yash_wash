package com.google.android.gms.common.api.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public final class p implements com.google.android.gms.common.api.a.f, ServiceConnection {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f15367l = "p";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c.o0
    private final String f15368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c.o0
    private final String f15369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @c.o0
    private final ComponentName f15370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f15371d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final f f15372e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Handler f15373f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final q f15374g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @c.o0
    private IBinder f15375h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f15376i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @c.o0
    private String f15377j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @c.o0
    private String f15378k;

    @c1.a
    public p(@c.m0 Context context, @c.m0 Looper looper, @c.m0 ComponentName componentName, @c.m0 f fVar, @c.m0 q qVar) {
        this(context, looper, null, null, componentName, fVar, qVar);
    }

    @c.h1
    private final void B() {
        if (Thread.currentThread() != this.f15373f.getLooper().getThread()) {
            throw new IllegalStateException("This method should only run on the NonGmsServiceBrokerClient's handler thread.");
        }
    }

    private final void C(String str) {
        String.valueOf(this.f15375h);
    }

    public final void A(@c.o0 String str) {
        this.f15378k = str;
    }

    @Override // com.google.android.gms.common.api.a.f
    @c.h1
    public final boolean a() {
        B();
        return this.f15375h != null;
    }

    @Override // com.google.android.gms.common.api.a.f
    public final boolean c() {
        return false;
    }

    @Override // com.google.android.gms.common.api.a.f
    public final boolean d() {
        return false;
    }

    final /* synthetic */ void e() {
        this.f15376i = false;
        this.f15375h = null;
        C("Disconnected.");
        this.f15372e.i0(1);
    }

    @Override // com.google.android.gms.common.api.a.f
    @c.h1
    public final void f() {
        B();
        C("Disconnect called.");
        try {
            this.f15371d.unbindService(this);
        } catch (IllegalArgumentException unused) {
        }
        this.f15376i = false;
        this.f15375h = null;
    }

    @Override // com.google.android.gms.common.api.a.f
    @c.m0
    public final Set<Scope> g() {
        return Collections.emptySet();
    }

    @Override // com.google.android.gms.common.api.a.f
    public final void h(@c.o0 com.google.android.gms.common.internal.m mVar, @c.o0 Set<Scope> set) {
    }

    @Override // com.google.android.gms.common.api.a.f
    @c.h1
    public final void i(@c.m0 String str) {
        B();
        this.f15377j = str;
        f();
    }

    @Override // com.google.android.gms.common.api.a.f
    @c.h1
    public final boolean j() {
        B();
        return this.f15376i;
    }

    @Override // com.google.android.gms.common.api.a.f
    @c.m0
    public final String k() {
        String str = this.f15368a;
        if (str != null) {
            return str;
        }
        com.google.android.gms.common.internal.u.k(this.f15370c);
        return this.f15370c.getPackageName();
    }

    @Override // com.google.android.gms.common.api.a.f
    @c.h1
    public final void l(@c.m0 com.google.android.gms.common.internal.e.c cVar) {
        B();
        C("Connect started.");
        if (a()) {
            try {
                i("connect() called when already connected");
            } catch (Exception unused) {
            }
        }
        try {
            Intent intent = new Intent();
            ComponentName componentName = this.f15370c;
            if (componentName != null) {
                intent.setComponent(componentName);
            } else {
                intent.setPackage(this.f15368a).setAction(this.f15369b);
            }
            boolean zBindService = this.f15371d.bindService(intent, this, com.google.android.gms.common.internal.j.c());
            this.f15376i = zBindService;
            if (!zBindService) {
                this.f15375h = null;
                this.f15374g.u0(new ConnectionResult(16));
            }
            C("Finished connect.");
        } catch (SecurityException e8) {
            this.f15376i = false;
            this.f15375h = null;
            throw e8;
        }
    }

    @Override // com.google.android.gms.common.api.a.f
    public final void m(@c.m0 com.google.android.gms.common.internal.e.InterfaceC0183e interfaceC0183e) {
    }

    @Override // com.google.android.gms.common.api.a.f
    @c.m0
    public final Feature[] n() {
        return new Feature[0];
    }

    @Override // com.google.android.gms.common.api.a.f
    public final void o(@c.m0 String str, @c.o0 FileDescriptor fileDescriptor, @c.m0 PrintWriter printWriter, @c.o0 String[] strArr) {
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(@c.m0 ComponentName componentName, @c.m0 final IBinder iBinder) {
        this.f15373f.post(new Runnable() { // from class: com.google.android.gms.common.api.internal.l2
            @Override // java.lang.Runnable
            public final void run() {
                this.f15322a.z(iBinder);
            }
        });
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(@c.m0 ComponentName componentName) {
        this.f15373f.post(new Runnable() { // from class: com.google.android.gms.common.api.internal.k2
            @Override // java.lang.Runnable
            public final void run() {
                this.f15317a.e();
            }
        });
    }

    @Override // com.google.android.gms.common.api.a.f
    public final boolean p() {
        return false;
    }

    @Override // com.google.android.gms.common.api.a.f
    public final int r() {
        return 0;
    }

    @Override // com.google.android.gms.common.api.a.f
    @c.m0
    public final Feature[] s() {
        return new Feature[0];
    }

    @Override // com.google.android.gms.common.api.a.f
    @c.o0
    public final String u() {
        return this.f15377j;
    }

    @Override // com.google.android.gms.common.api.a.f
    @c.m0
    public final Intent v() {
        return new Intent();
    }

    @Override // com.google.android.gms.common.api.a.f
    public final boolean w() {
        return false;
    }

    @Override // com.google.android.gms.common.api.a.f
    @c.o0
    public final IBinder x() {
        return null;
    }

    @c.h1
    @c.o0
    @c1.a
    public IBinder y() {
        B();
        return this.f15375h;
    }

    final /* synthetic */ void z(IBinder iBinder) {
        this.f15376i = false;
        this.f15375h = iBinder;
        C("Connected.");
        this.f15372e.y0(new Bundle());
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
    
        if (r6 != null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private p(android.content.Context r2, android.os.Looper r3, @c.o0 java.lang.String r4, @c.o0 java.lang.String r5, @c.o0 android.content.ComponentName r6, com.google.android.gms.common.api.internal.f r7, com.google.android.gms.common.api.internal.q r8) {
        /*
            r1 = this;
            r1.<init>()
            r0 = 0
            r1.f15376i = r0
            r0 = 0
            r1.f15377j = r0
            r1.f15371d = r2
            com.google.android.gms.internal.base.p r2 = new com.google.android.gms.internal.base.p
            r2.<init>(r3)
            r1.f15373f = r2
            r1.f15372e = r7
            r1.f15374g = r8
            if (r4 == 0) goto L1e
            if (r5 == 0) goto L1e
            if (r6 != 0) goto L27
            r6 = r0
            goto L20
        L1e:
            if (r6 == 0) goto L27
        L20:
            r1.f15368a = r4
            r1.f15369b = r5
            r1.f15370c = r6
            return
        L27:
            java.lang.AssertionError r2 = new java.lang.AssertionError
            java.lang.String r3 = "Must specify either package or component, but not both"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.p.<init>(android.content.Context, android.os.Looper, java.lang.String, java.lang.String, android.content.ComponentName, com.google.android.gms.common.api.internal.f, com.google.android.gms.common.api.internal.q):void");
    }

    @c1.a
    public p(@c.m0 Context context, @c.m0 Looper looper, @c.m0 String str, @c.m0 String str2, @c.m0 f fVar, @c.m0 q qVar) {
        this(context, looper, str, str2, null, fVar, qVar);
    }
}
