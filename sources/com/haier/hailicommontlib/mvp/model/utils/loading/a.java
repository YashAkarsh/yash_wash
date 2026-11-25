package com.haier.hailicommontlib.mvp.model.utils.loading;

import android.app.Activity;
import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f26184e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f26185f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f26186g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f26187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Activity f26188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f26189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c3.b f26190d;

    public a(Activity activity, int i7) {
        this(activity, i7, false);
    }

    public Context a() {
        return this.f26188b;
    }

    public void b() {
        Activity activity;
        if (this.f26190d == null || (activity = this.f26188b) == null || activity.isFinishing()) {
            return;
        }
        this.f26190d.b();
    }

    public <T> void c(T t7) {
        this.f26190d.a(t7);
        if (t7 instanceof String) {
            d();
        }
    }

    public void d() {
        Activity activity;
        if (this.f26190d == null || (activity = this.f26188b) == null || activity.isFinishing()) {
            return;
        }
        this.f26190d.c();
    }

    public a(Activity activity, int i7, boolean z7) {
        this.f26188b = activity;
        if (i7 != 1) {
            if (i7 != 2) {
                this.f26190d = null;
            }
        } else {
            if (this.f26189c == null) {
                this.f26189c = new b(activity, i7, z7);
            }
            this.f26190d = this.f26189c;
        }
    }

    public a(Activity activity, int i7, String str, boolean z7) {
        this.f26188b = activity;
        if (i7 != 1) {
            this.f26190d = null;
            return;
        }
        if (this.f26189c == null) {
            this.f26189c = new b(activity, i7, z7);
        }
        this.f26190d = this.f26189c;
    }
}
