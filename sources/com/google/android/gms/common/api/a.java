package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import c.m0;
import c.o0;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class a<O extends d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AbstractC0179a<?, O> f15075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g<?> f15076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f15077c;

    /* JADX INFO: renamed from: com.google.android.gms.common.api.a$a, reason: collision with other inner class name */
    @g1.d0
    @c1.a
    public static abstract class AbstractC0179a<T extends f, O> extends e<T, O> {
        @c1.a
        @m0
        @Deprecated
        public T c(@m0 Context context, @m0 Looper looper, @m0 com.google.android.gms.common.internal.f fVar, @m0 O o7, @m0 k.b bVar, @m0 k.c cVar) {
            return (T) d(context, looper, fVar, o7, bVar, cVar);
        }

        @c1.a
        @m0
        public T d(@m0 Context context, @m0 Looper looper, @m0 com.google.android.gms.common.internal.f fVar, @m0 O o7, @m0 com.google.android.gms.common.api.internal.f fVar2, @m0 com.google.android.gms.common.api.internal.q qVar) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    @c1.a
    public interface b {
    }

    @c1.a
    public static class c<C extends b> {
    }

    public interface d {

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        @m0
        public static final C0181d f15078l0 = new C0181d(null);

        /* JADX INFO: renamed from: com.google.android.gms.common.api.a$d$a, reason: collision with other inner class name */
        public interface InterfaceC0180a extends c, e {
            @m0
            Account F();
        }

        public interface b extends c {
            @o0
            GoogleSignInAccount E();
        }

        public interface c extends d {
        }

        /* JADX INFO: renamed from: com.google.android.gms.common.api.a$d$d, reason: collision with other inner class name */
        public static final class C0181d implements e {
            private C0181d() {
            }

            /* synthetic */ C0181d(z zVar) {
            }
        }

        public interface e extends d {
        }

        public interface f extends c, e {
        }
    }

    @g1.d0
    @c1.a
    public static abstract class e<T extends b, O> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @c1.a
        public static final int f15079a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @c1.a
        public static final int f15080b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @c1.a
        public static final int f15081c = Integer.MAX_VALUE;

        @c1.a
        @m0
        public List<Scope> a(@o0 O o7) {
            return Collections.emptyList();
        }

        @c1.a
        public int b() {
            return Integer.MAX_VALUE;
        }
    }

    @c1.a
    public interface f extends b {
        @c1.a
        boolean a();

        @c1.a
        boolean c();

        @c1.a
        boolean d();

        @c1.a
        void f();

        @c1.a
        @m0
        Set<Scope> g();

        @c1.a
        void h(@o0 com.google.android.gms.common.internal.m mVar, @o0 Set<Scope> set);

        @c1.a
        void i(@m0 String str);

        @c1.a
        boolean j();

        @c1.a
        @m0
        String k();

        @c1.a
        void l(@m0 com.google.android.gms.common.internal.e.c cVar);

        @c1.a
        void m(@m0 com.google.android.gms.common.internal.e.InterfaceC0183e interfaceC0183e);

        @c1.a
        @m0
        Feature[] n();

        @c1.a
        void o(@m0 String str, @o0 FileDescriptor fileDescriptor, @m0 PrintWriter printWriter, @o0 String[] strArr);

        @c1.a
        boolean p();

        @c1.a
        int r();

        @c1.a
        @m0
        Feature[] s();

        @o0
        @c1.a
        String u();

        @c1.a
        @m0
        Intent v();

        @c1.a
        boolean w();

        @o0
        @c1.a
        IBinder x();
    }

    @g1.d0
    @c1.a
    public static final class g<C extends f> extends c<C> {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @c1.a
    public <C extends f> a(@m0 String str, @m0 AbstractC0179a<C, O> abstractC0179a, @m0 g<C> gVar) {
        com.google.android.gms.common.internal.u.l(abstractC0179a, "Cannot construct an Api with a null ClientBuilder");
        com.google.android.gms.common.internal.u.l(gVar, "Cannot construct an Api with a null ClientKey");
        this.f15077c = str;
        this.f15075a = abstractC0179a;
        this.f15076b = gVar;
    }

    @m0
    public final AbstractC0179a<?, O> a() {
        return this.f15075a;
    }

    @m0
    public final c<?> b() {
        return this.f15076b;
    }

    @m0
    public final e<?, O> c() {
        return this.f15075a;
    }

    @m0
    public final String d() {
        return this.f15077c;
    }
}
