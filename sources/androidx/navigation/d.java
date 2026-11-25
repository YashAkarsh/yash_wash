package androidx.navigation;

import android.os.Bundle;
import c.b0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @b0
    private final int f8795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private t f8796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bundle f8797c;

    public d(@b0 int i7) {
        this(i7, null);
    }

    @o0
    public Bundle a() {
        return this.f8797c;
    }

    public int b() {
        return this.f8795a;
    }

    @o0
    public t c() {
        return this.f8796b;
    }

    public void d(@o0 Bundle bundle) {
        this.f8797c = bundle;
    }

    public void e(@o0 t tVar) {
        this.f8796b = tVar;
    }

    public d(@b0 int i7, @o0 t tVar) {
        this(i7, tVar, null);
    }

    public d(@b0 int i7, @o0 t tVar, @o0 Bundle bundle) {
        this.f8795a = i7;
        this.f8796b = tVar;
        this.f8797c = bundle;
    }
}
