package org.chromium.net;

import android.annotation.SuppressLint;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f39125a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f39126b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f39127c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f39128d = 3;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f39129e = 4;

        public abstract a a(String str, String str2);

        @SuppressLint({"WrongConstant"})
        public abstract d b();

        public abstract a c(boolean z7);

        public abstract a d(String str);

        public abstract a e(int i7);
    }

    public static abstract class b {
        public void a(d dVar, u0 u0Var) {
        }

        public abstract void b(d dVar, u0 u0Var, k kVar);

        public abstract void c(d dVar, u0 u0Var, ByteBuffer byteBuffer, boolean z7);

        public abstract void d(d dVar, u0 u0Var);

        public void e(d dVar, u0 u0Var, u0.a aVar) {
        }

        public abstract void f(d dVar);

        public abstract void g(d dVar, u0 u0Var);

        public abstract void h(d dVar, u0 u0Var, ByteBuffer byteBuffer, boolean z7);
    }

    public abstract void a();

    public abstract void b();

    public abstract boolean c();

    public abstract void d(ByteBuffer byteBuffer);

    public abstract void e();

    public abstract void f(ByteBuffer byteBuffer, boolean z7);
}
