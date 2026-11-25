package org.chromium.net;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.HandlerThread;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import org.chromium.base.ApplicationStatus;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes3.dex */
@x6.c("net::android")
public class AndroidCellularSignalStrength {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AndroidCellularSignalStrength f38979b = new AndroidCellularSignalStrength();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile int f38980a = Integer.MIN_VALUE;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AndroidCellularSignalStrength.this.new b();
        }
    }

    private class b extends PhoneStateListener implements ApplicationStatus.f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final /* synthetic */ boolean f38982c = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TelephonyManager f38983a;

        b() {
            ThreadUtils.a();
            TelephonyManager telephonyManager = (TelephonyManager) org.chromium.base.o.e().getSystemService("phone");
            this.f38983a = telephonyManager;
            if (telephonyManager.getSimState() != 5) {
                return;
            }
            ApplicationStatus.s(this);
            a(ApplicationStatus.getStateForApplication());
        }

        private void b() {
            this.f38983a.listen(this, 256);
        }

        private void c() {
            AndroidCellularSignalStrength.this.f38980a = Integer.MIN_VALUE;
            this.f38983a.listen(this, 0);
        }

        @Override // org.chromium.base.ApplicationStatus.f
        public void a(int i7) {
            if (i7 == 1) {
                b();
            } else if (i7 == 2) {
                c();
            }
        }

        @Override // android.telephony.PhoneStateListener
        @TargetApi(23)
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            if (ApplicationStatus.getStateForApplication() != 1) {
                return;
            }
            try {
                AndroidCellularSignalStrength.this.f38980a = signalStrength.getLevel();
            } catch (SecurityException unused) {
                AndroidCellularSignalStrength.this.f38980a = Integer.MIN_VALUE;
            }
        }
    }

    private AndroidCellularSignalStrength() {
        HandlerThread handlerThread = new HandlerThread("AndroidCellularSignalStrength");
        handlerThread.start();
        new Handler(handlerThread.getLooper()).post(new a());
    }

    @TargetApi(23)
    @CalledByNative
    private static int getSignalStrengthLevel() {
        return f38979b.f38980a;
    }
}
