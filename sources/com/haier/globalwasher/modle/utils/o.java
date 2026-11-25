package com.haier.globalwasher.modle.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f24671e = "o";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f24672f = 300000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f24673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BroadcastReceiver f24674b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f24675c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AsyncTask<Object, Object, Object> f24676d;

    private class a extends AsyncTask<Object, Object, Object> {
        @Override // android.os.AsyncTask
        protected Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(o.f24672f);
                Log.i(o.f24671e, "Finishing activity due to inactivity");
                o.this.f24673a.finish();
                return null;
            } catch (InterruptedException unused) {
                return null;
            }
        }

        private a() {
        }
    }

    private class b extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                if (intent.getIntExtra("plugged", -1) <= 0) {
                    o.this.e();
                } else {
                    o.this.d();
                }
            }
        }

        private b() {
        }
    }

    public o(Activity activity) {
        this.f24673a = activity;
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() {
        AsyncTask<Object, Object, Object> asyncTask = this.f24676d;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.f24676d = null;
        }
    }

    @SuppressLint({"NewApi"})
    public synchronized void e() {
        d();
        a aVar = new a();
        this.f24676d = aVar;
        aVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
    }

    public synchronized void f() {
        d();
        if (this.f24675c) {
            this.f24673a.unregisterReceiver(this.f24674b);
            this.f24675c = false;
        } else {
            Log.w(f24671e, "PowerStatusReceiver was never registered?");
        }
    }

    public synchronized void g() {
        if (this.f24675c) {
            Log.w(f24671e, "PowerStatusReceiver was already registered?");
        } else {
            if (Build.VERSION.SDK_INT >= 33) {
                this.f24673a.registerReceiver(this.f24674b, new IntentFilter("android.intent.action.BATTERY_CHANGED"), 4);
            } else {
                this.f24673a.registerReceiver(this.f24674b, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            }
            this.f24675c = true;
        }
        e();
    }

    public void h() {
        d();
    }
}
