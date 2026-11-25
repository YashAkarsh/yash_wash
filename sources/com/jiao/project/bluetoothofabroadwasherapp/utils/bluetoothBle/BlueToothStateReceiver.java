package com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
public class BlueToothStateReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f32375b = 1000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f32376a;

    public interface a {
        void a();

        void b();

        void c();

        void d();
    }

    public void a(a aVar) {
        this.f32376a = aVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction())) {
            switch (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", f32375b)) {
                case 10:
                    this.f32376a.d();
                    break;
                case 11:
                    this.f32376a.a();
                    break;
                case 12:
                    this.f32376a.c();
                    break;
                case 13:
                    this.f32376a.b();
                    break;
                default:
                    com.haier.hailicommontlib.mvp.model.utils.b.c("BlueToothError", "蓝牙状态未知");
                    break;
            }
        }
    }
}
