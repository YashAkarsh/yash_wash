package com.haier.library.common.util.a;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f26528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f26529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f26530c = 30;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f26531d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c f26532e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f26533f;

    a(Context context, String str, d dVar, c cVar) {
        this.f26528a = context;
        this.f26529b = str;
        this.f26531d = dVar;
        this.f26532e = cVar;
    }

    public void a(int i7) {
        this.f26530c = i7 * 2;
    }

    public void b(Boolean bool) {
        this.f26533f = bool.booleanValue();
        this.f26530c = 0;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i7 = 0;
        while (this.f26530c > 0) {
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e8) {
                e8.printStackTrace();
            }
            if (!this.f26529b.equals(f.e(this.f26528a))) {
                this.f26532e.a();
                i7++;
            }
            this.f26530c--;
        }
        e3.a.e("BindingDevice APConnector loop times=%d", Integer.valueOf(i7));
        this.f26531d.a(this.f26533f);
    }
}
