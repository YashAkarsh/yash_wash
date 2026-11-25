package com.haier.globalwasher.modle.utils.loading;

import android.content.Context;
import com.haier.globalwasher.mvp_api.moudle.c;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f24647e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f24648f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f24649g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f24650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f24651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f24652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f24653d;

    public a(Context context, int i7, boolean z7) {
        this.f24651b = context;
        if (i7 != 1) {
            if (i7 != 2) {
                this.f24653d = null;
            }
        } else {
            if (this.f24652c == null) {
                this.f24652c = new b(context, i7, z7);
            }
            this.f24653d = this.f24652c;
        }
    }

    public void a() {
        c cVar = this.f24653d;
        if (cVar != null) {
            cVar.b();
        }
    }

    public <T> void b(T t7) {
        this.f24653d.a(t7);
        if (t7 instanceof String) {
            c();
        }
    }

    public void c() {
        c cVar = this.f24653d;
        if (cVar != null) {
            cVar.c();
        }
    }

    public a(Context context, int i7, String str, boolean z7) {
        this.f24651b = context;
        if (i7 != 1) {
            this.f24653d = null;
            return;
        }
        if (this.f24652c == null) {
            this.f24652c = new b(context, i7, z7);
        }
        this.f24653d = this.f24652c;
    }
}
