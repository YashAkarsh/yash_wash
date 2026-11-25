package com.google.android.gms.common.api.internal;

import android.os.SystemClock;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;

/* JADX INFO: loaded from: classes.dex */
final class i2<T> implements com.google.android.gms.tasks.f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f15269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f15270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c<?> f15271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f15272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f15273e;

    @g1.d0
    i2(i iVar, int i7, c<?> cVar, long j7, long j8, @c.o0 String str, @c.o0 String str2) {
        this.f15269a = iVar;
        this.f15270b = i7;
        this.f15271c = cVar;
        this.f15272d = j7;
        this.f15273e = j8;
    }

    @c.o0
    static <T> i2<T> b(i iVar, int i7, c<?> cVar) {
        boolean zR0;
        if (!iVar.g()) {
            return null;
        }
        RootTelemetryConfiguration rootTelemetryConfigurationA = com.google.android.gms.common.internal.w.b().a();
        if (rootTelemetryConfigurationA == null) {
            zR0 = true;
        } else {
            if (!rootTelemetryConfigurationA.p0()) {
                return null;
            }
            zR0 = rootTelemetryConfigurationA.r0();
            v1 v1VarX = iVar.x(cVar);
            if (v1VarX != null) {
                if (!(v1VarX.s() instanceof com.google.android.gms.common.internal.e)) {
                    return null;
                }
                com.google.android.gms.common.internal.e eVar = (com.google.android.gms.common.internal.e) v1VarX.s();
                if (eVar.S() && !eVar.j()) {
                    ConnectionTelemetryConfiguration connectionTelemetryConfigurationC = c(v1VarX, eVar, i7);
                    if (connectionTelemetryConfigurationC == null) {
                        return null;
                    }
                    v1VarX.D();
                    zR0 = connectionTelemetryConfigurationC.s0();
                }
            }
        }
        return new i2<>(iVar, i7, cVar, zR0 ? System.currentTimeMillis() : 0L, zR0 ? SystemClock.elapsedRealtime() : 0L, null, null);
    }

    @c.o0
    private static ConnectionTelemetryConfiguration c(v1<?> v1Var, com.google.android.gms.common.internal.e<?> eVar, int i7) {
        int[] iArrQ;
        int[] iArrP0;
        ConnectionTelemetryConfiguration connectionTelemetryConfigurationQ = eVar.Q();
        if (connectionTelemetryConfigurationQ == null || !connectionTelemetryConfigurationQ.r0() || ((iArrQ = connectionTelemetryConfigurationQ.Q()) != null ? !g1.b.c(iArrQ, i7) : !((iArrP0 = connectionTelemetryConfigurationQ.p0()) == null || !g1.b.c(iArrP0, i7))) || v1Var.p() >= connectionTelemetryConfigurationQ.K()) {
            return null;
        }
        return connectionTelemetryConfigurationQ;
    }

    @Override // com.google.android.gms.tasks.f
    @c.h1
    public final void a(@c.m0 com.google.android.gms.tasks.m<T> mVar) {
        v1 v1VarX;
        int iS0;
        int i7;
        int i8;
        int iK;
        long j7;
        long j8;
        int iElapsedRealtime;
        if (this.f15269a.g()) {
            RootTelemetryConfiguration rootTelemetryConfigurationA = com.google.android.gms.common.internal.w.b().a();
            if ((rootTelemetryConfigurationA == null || rootTelemetryConfigurationA.p0()) && (v1VarX = this.f15269a.x(this.f15271c)) != null && (v1VarX.s() instanceof com.google.android.gms.common.internal.e)) {
                com.google.android.gms.common.internal.e eVar = (com.google.android.gms.common.internal.e) v1VarX.s();
                int i9 = 0;
                boolean zR0 = this.f15272d > 0;
                int iH = eVar.H();
                if (rootTelemetryConfigurationA != null) {
                    zR0 &= rootTelemetryConfigurationA.r0();
                    int iK2 = rootTelemetryConfigurationA.K();
                    int iQ = rootTelemetryConfigurationA.Q();
                    iS0 = rootTelemetryConfigurationA.s0();
                    if (eVar.S() && !eVar.j()) {
                        ConnectionTelemetryConfiguration connectionTelemetryConfigurationC = c(v1VarX, eVar, this.f15270b);
                        if (connectionTelemetryConfigurationC == null) {
                            return;
                        }
                        boolean z7 = connectionTelemetryConfigurationC.s0() && this.f15272d > 0;
                        iQ = connectionTelemetryConfigurationC.K();
                        zR0 = z7;
                    }
                    i8 = iK2;
                    i7 = iQ;
                } else {
                    iS0 = 0;
                    i7 = 100;
                    i8 = 5000;
                }
                i iVar = this.f15269a;
                if (mVar.v()) {
                    iK = 0;
                } else {
                    if (mVar.t()) {
                        i9 = 100;
                    } else {
                        Exception excQ = mVar.q();
                        if (excQ instanceof com.google.android.gms.common.api.b) {
                            Status statusA = ((com.google.android.gms.common.api.b) excQ).a();
                            int iP0 = statusA.p0();
                            ConnectionResult connectionResultK = statusA.K();
                            iK = connectionResultK == null ? -1 : connectionResultK.K();
                            i9 = iP0;
                        } else {
                            i9 = 101;
                        }
                    }
                    iK = -1;
                }
                if (zR0) {
                    long j9 = this.f15272d;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    iElapsedRealtime = (int) (SystemClock.elapsedRealtime() - this.f15273e);
                    j7 = j9;
                    j8 = jCurrentTimeMillis;
                } else {
                    j7 = 0;
                    j8 = 0;
                    iElapsedRealtime = -1;
                }
                iVar.L(new MethodInvocation(this.f15270b, i9, iK, j7, j8, null, null, iH, iElapsedRealtime), iS0, i8, i7);
            }
        }
    }
}
