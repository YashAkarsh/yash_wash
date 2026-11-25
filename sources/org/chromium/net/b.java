package org.chromium.net;

import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import javax.annotation.CheckForNull;
import org.chromium.base.ThreadUtils;

/* JADX INFO: loaded from: classes3.dex */
@c.d
@x6.e
public class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile b f39112e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    private volatile String f39113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @CheckForNull
    private volatile String f39114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @CheckForNull
    private volatile String f39115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private C0522b f39116d;

    /* JADX INFO: renamed from: org.chromium.net.b$b, reason: collision with other inner class name */
    private class C0522b extends PhoneStateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        private ServiceState f39117a;

        private C0522b() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onServiceStateChanged(ServiceState serviceState) {
            ServiceState serviceState2 = this.f39117a;
            if (serviceState2 == null || !serviceState2.equals(serviceState)) {
                this.f39117a = serviceState;
                b.this.l(b.i());
            }
        }
    }

    private b() {
    }

    private static b d() {
        final b bVar = new b();
        ThreadUtils.k(new Runnable() { // from class: org.chromium.net.a
            @Override // java.lang.Runnable
            public final void run() {
                b.j(this.f39104a);
            }
        });
        return bVar;
    }

    public static b e() {
        b bVarD = f39112e;
        if (bVarD == null) {
            synchronized (b.class) {
                bVarD = f39112e;
                if (bVarD == null) {
                    bVarD = d();
                    f39112e = bVarD;
                }
            }
        }
        return bVarD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CheckForNull
    public static TelephonyManager i() {
        return (TelephonyManager) org.chromium.base.o.e().getSystemService("phone");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(b bVar) {
        TelephonyManager telephonyManagerI = i();
        if (telephonyManagerI != null) {
            bVar.k(telephonyManagerI);
        }
    }

    @c.j0
    private void k(TelephonyManager telephonyManager) {
        ThreadUtils.b();
        C0522b c0522b = new C0522b();
        this.f39116d = c0522b;
        telephonyManager.listen(c0522b, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(@CheckForNull TelephonyManager telephonyManager) {
        if (telephonyManager == null) {
            return;
        }
        this.f39113a = telephonyManager.getNetworkCountryIso();
        this.f39114b = telephonyManager.getNetworkOperator();
        this.f39115c = telephonyManager.getSimOperator();
    }

    public String f() {
        if (this.f39113a == null) {
            TelephonyManager telephonyManagerI = i();
            if (telephonyManagerI == null) {
                return "";
            }
            this.f39113a = telephonyManagerI.getNetworkCountryIso();
        }
        return this.f39113a;
    }

    public String g() {
        if (this.f39114b == null) {
            TelephonyManager telephonyManagerI = i();
            if (telephonyManagerI == null) {
                return "";
            }
            this.f39114b = telephonyManagerI.getNetworkOperator();
        }
        return this.f39114b;
    }

    public String h() {
        if (this.f39115c == null) {
            TelephonyManager telephonyManagerI = i();
            if (telephonyManagerI == null) {
                return "";
            }
            this.f39115c = telephonyManagerI.getSimOperator();
        }
        return this.f39115c;
    }
}
