package com.google.android.gms.common.internal;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class c0 implements com.google.android.gms.common.api.a.d.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c.m0
    public static final c0 f15673b = a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c.o0
    private final String f15674a;

    @c1.a
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @c.o0
        private String f15675a;

        private a() {
        }

        @c1.a
        @c.m0
        public c0 a() {
            return new c0(this.f15675a, null);
        }

        @c1.a
        @c.m0
        public a b(@c.o0 String str) {
            this.f15675a = str;
            return this;
        }

        /* synthetic */ a(g0 g0Var) {
        }
    }

    /* synthetic */ c0(String str, h0 h0Var) {
        this.f15674a = str;
    }

    @c1.a
    @c.m0
    public static a a() {
        return new a(null);
    }

    @c.m0
    public final Bundle b() {
        Bundle bundle = new Bundle();
        String str = this.f15674a;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    public final boolean equals(@c.o0 Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c0) {
            return s.b(this.f15674a, ((c0) obj).f15674a);
        }
        return false;
    }

    public final int hashCode() {
        return s.c(this.f15674a);
    }
}
