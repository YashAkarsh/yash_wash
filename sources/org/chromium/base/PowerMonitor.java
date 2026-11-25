package org.chromium.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes3.dex */
@x6.c("base::android")
public class PowerMonitor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static PowerMonitor f38727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final /* synthetic */ boolean f38728c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f38729a;

    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            PowerMonitor.d(intent);
        }
    }

    private PowerMonitor() {
    }

    public static void b() {
        ThreadUtils.b();
        if (f38727b != null) {
            return;
        }
        Context contextE = o.e();
        f38727b = new PowerMonitor();
        Intent intentRegisterReceiver = contextE.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver != null) {
            d(intentRegisterReceiver);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        contextE.registerReceiver(new a(), intentFilter);
    }

    public static void c() {
        f38727b = new PowerMonitor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0010  */
    public static void d(Intent intent) {
        boolean z7;
        int intExtra = intent.getIntExtra("plugged", -1);
        PowerMonitor powerMonitor = f38727b;
        if (intExtra != 2) {
            z7 = intExtra != 1;
        }
        powerMonitor.f38729a = z7;
        nativeOnBatteryChargingChanged();
    }

    @CalledByNative
    private static boolean isBatteryPower() {
        if (f38727b == null) {
            b();
        }
        return f38727b.f38729a;
    }

    private static native void nativeOnBatteryChargingChanged();
}
