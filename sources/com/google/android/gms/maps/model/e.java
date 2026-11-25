package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.RemoteException;
import c.m0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.internal.maps.b0 f16685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final s f16686b;

    public e(com.google.android.gms.internal.maps.b0 b0Var) {
        s sVar = s.f16701a;
        this.f16685a = (com.google.android.gms.internal.maps.b0) com.google.android.gms.common.internal.u.l(b0Var, "delegate");
        this.f16686b = (s) com.google.android.gms.common.internal.u.l(sVar, "shim");
    }

    public int a() {
        try {
            return this.f16685a.a();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public int b() {
        try {
            return this.f16685a.c();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    @m0
    public List<f> c() {
        try {
            List<IBinder> listB = this.f16685a.b();
            ArrayList arrayList = new ArrayList(listB.size());
            Iterator<IBinder> it = listB.iterator();
            while (it.hasNext()) {
                arrayList.add(new f(com.google.android.gms.internal.maps.d0.u0(it.next())));
            }
            return arrayList;
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public boolean d() {
        try {
            return this.f16685a.f();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        try {
            return this.f16685a.W0(((e) obj).f16685a);
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public int hashCode() {
        try {
            return this.f16685a.d();
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }
}
