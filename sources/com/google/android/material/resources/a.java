package com.google.android.material.resources;

import android.graphics.Typeface;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public final class a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Typeface f18129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterfaceC0202a f18130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f18131c;

    /* JADX INFO: renamed from: com.google.android.material.resources.a$a, reason: collision with other inner class name */
    public interface InterfaceC0202a {
        void a(Typeface typeface);
    }

    public a(InterfaceC0202a interfaceC0202a, Typeface typeface) {
        this.f18129a = typeface;
        this.f18130b = interfaceC0202a;
    }

    private void d(Typeface typeface) {
        if (this.f18131c) {
            return;
        }
        this.f18130b.a(typeface);
    }

    @Override // com.google.android.material.resources.f
    public void a(int i7) {
        d(this.f18129a);
    }

    @Override // com.google.android.material.resources.f
    public void b(Typeface typeface, boolean z7) {
        d(typeface);
    }

    public void c() {
        this.f18131c = true;
    }
}
