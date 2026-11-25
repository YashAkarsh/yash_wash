package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.maps.internal.p1;
import com.google.android.gms.maps.internal.s1;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f16509a = "f";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @GuardedBy("MapsInitializer.class")
    private static boolean f16510b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy("MapsInitializer.class")
    private static a f16511c = a.LEGACY;

    public enum a {
        LEGACY,
        LATEST
    }

    private f() {
    }

    public static synchronized int a(@c.m0 Context context) {
        return b(context, null, null);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0048  */
    public static synchronized int b(@c.m0 Context context, @c.o0 a aVar, @c.o0 h hVar) {
        com.google.android.gms.common.internal.u.l(context, "Context is null");
        Log.d(f16509a, "preferredRenderer: ".concat(String.valueOf(aVar)));
        if (f16510b) {
            if (hVar != null) {
                hVar.a(f16511c);
            }
            return 0;
        }
        try {
            s1 s1VarA = p1.a(context, aVar);
            try {
                b.l(s1VarA.c());
                com.google.android.gms.maps.model.b.h(s1VarA.l());
                int i7 = 1;
                f16510b = true;
                if (aVar == null) {
                    i7 = 0;
                } else {
                    int iOrdinal = aVar.ordinal();
                    if (iOrdinal != 0) {
                        if (iOrdinal != 1) {
                            i7 = 0;
                        } else {
                            i7 = 2;
                        }
                    }
                }
                try {
                    if (s1VarA.a() == 2) {
                        f16511c = a.LATEST;
                    }
                    s1VarA.Q1(com.google.android.gms.dynamic.f.z3(context), i7);
                } catch (RemoteException e8) {
                    Log.e(f16509a, "Failed to retrieve renderer type or log initialization.", e8);
                }
                Log.d(f16509a, "loadedRenderer: ".concat(String.valueOf(f16511c)));
                if (hVar != null) {
                    hVar.a(f16511c);
                }
                return 0;
            } catch (RemoteException e9) {
                throw new com.google.android.gms.maps.model.k(e9);
            }
        } catch (com.google.android.gms.common.i e10) {
            return e10.f15582a;
        }
    }
}
