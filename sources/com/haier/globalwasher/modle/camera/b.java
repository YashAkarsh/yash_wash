package com.haier.globalwasher.modle.camera;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.RejectedExecutionException;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public class b implements Camera.AutoFocusCallback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f24362f = "b";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final long f24363g = 2000;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Collection<String> f24364h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f24365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f24366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f24367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Camera f24368d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AsyncTask<?, ?, ?> f24369e;

    private final class a extends AsyncTask<Object, Object, Object> {
        @Override // android.os.AsyncTask
        protected Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException unused) {
            }
            b.this.c();
            return null;
        }

        private a() {
        }
    }

    static {
        ArrayList arrayList = new ArrayList(2);
        f24364h = arrayList;
        arrayList.add(z0.f37389c);
        arrayList.add("macro");
    }

    public b(Context context, Camera camera) {
        this.f24368d = camera;
        String focusMode = camera.getParameters().getFocusMode();
        boolean zContains = f24364h.contains(focusMode);
        this.f24367c = zContains;
        Log.i(f24362f, "Current focus mode '" + focusMode + "'; use auto focus? " + zContains);
        c();
    }

    @SuppressLint({"NewApi"})
    private synchronized void a() {
        if (!this.f24365a && this.f24369e == null) {
            a aVar = new a();
            try {
                aVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                this.f24369e = aVar;
            } catch (RejectedExecutionException e8) {
                Log.w(f24362f, "Could not request auto focus", e8);
            }
        }
    }

    private synchronized void b() {
        AsyncTask<?, ?, ?> asyncTask = this.f24369e;
        if (asyncTask != null) {
            if (asyncTask.getStatus() != AsyncTask.Status.FINISHED) {
                this.f24369e.cancel(true);
            }
            this.f24369e = null;
        }
    }

    public synchronized void c() {
        if (this.f24367c) {
            this.f24369e = null;
            if (!this.f24365a && !this.f24366b) {
                try {
                    this.f24368d.autoFocus(this);
                    this.f24366b = true;
                } catch (RuntimeException e8) {
                    Log.w(f24362f, "Unexpected exception while focusing", e8);
                    a();
                }
            }
        }
    }

    public synchronized void d() {
        this.f24365a = true;
        if (this.f24367c) {
            b();
            try {
                this.f24368d.cancelAutoFocus();
            } catch (RuntimeException e8) {
                Log.w(f24362f, "Unexpected exception while cancelling focusing", e8);
            }
        }
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public synchronized void onAutoFocus(boolean z7, Camera camera) {
        this.f24366b = false;
        a();
    }
}
