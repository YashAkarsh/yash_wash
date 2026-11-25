package com.haier.uhome.usdk.base.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.haier.uhome.usdk.base.api.p;
import com.haier.uhome.usdk.base.api.r;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class f extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicBoolean f31383a;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static f f31384a = new f();

        private a() {
        }
    }

    public static f a() {
        return a.f31384a;
    }

    public boolean b() {
        return this.f31383a.get();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        e3.a.e("SystemEventReceiver.onReceive " + action, new Object[0]);
        for (p pVar : r.a().g()) {
            if (pVar != null) {
                if ("android.intent.action.SCREEN_ON".equals(action)) {
                    this.f31383a.set(true);
                    pVar.b(true);
                } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    this.f31383a.set(false);
                    pVar.b(false);
                }
            }
        }
    }

    private f() {
        this.f31383a = new AtomicBoolean(true);
    }
}
