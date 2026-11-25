package com.haier.library.okhttp;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {

    static class a extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ j0 f27555a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.haier.library.a.j f27556b;

        a(j0 j0Var, com.haier.library.a.j jVar) {
            this.f27555a = j0Var;
            this.f27556b = jVar;
        }

        @Override // com.haier.library.okhttp.g
        public void f(com.haier.library.a.h hVar) throws IOException {
            hVar.B(this.f27556b);
        }

        @Override // com.haier.library.okhttp.g
        @Nullable
        public j0 g() {
            return this.f27555a;
        }

        @Override // com.haier.library.okhttp.g
        public long h() throws IOException {
            return this.f27556b.Z();
        }
    }

    static class b extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ j0 f27557a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f27558b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ byte[] f27559c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f27560d;

        b(j0 j0Var, int i7, byte[] bArr, int i8) {
            this.f27557a = j0Var;
            this.f27558b = i7;
            this.f27559c = bArr;
            this.f27560d = i8;
        }

        @Override // com.haier.library.okhttp.g
        public void f(com.haier.library.a.h hVar) throws IOException {
            hVar.T1(this.f27559c, this.f27560d, this.f27558b);
        }

        @Override // com.haier.library.okhttp.g
        @Nullable
        public j0 g() {
            return this.f27557a;
        }

        @Override // com.haier.library.okhttp.g
        public long h() {
            return this.f27558b;
        }
    }

    static class c extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ j0 f27561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ File f27562b;

        c(j0 j0Var, File file) {
            this.f27561a = j0Var;
            this.f27562b = file;
        }

        @Override // com.haier.library.okhttp.g
        public void f(com.haier.library.a.h hVar) throws IOException {
            com.haier.library.a.c0 c0VarG = null;
            try {
                c0VarG = com.haier.library.a.t.g(this.f27562b);
                hVar.f0(c0VarG);
            } finally {
                n.d.s(c0VarG);
            }
        }

        @Override // com.haier.library.okhttp.g
        @Nullable
        public j0 g() {
            return this.f27561a;
        }

        @Override // com.haier.library.okhttp.g
        public long h() {
            return this.f27562b.length();
        }
    }

    public static g a(@Nullable j0 j0Var, com.haier.library.a.j jVar) {
        return new a(j0Var, jVar);
    }

    public static g b(@Nullable j0 j0Var, File file) {
        if (file != null) {
            return new c(j0Var, file);
        }
        throw new NullPointerException("file == null");
    }

    public static g c(@Nullable j0 j0Var, String str) {
        Charset charset = n.d.f27695j;
        if (j0Var != null) {
            Charset charsetF = j0Var.f();
            if (charsetF == null) {
                j0Var = j0.d(j0Var + "; charset=utf-8");
            } else {
                charset = charsetF;
            }
        }
        return d(j0Var, str.getBytes(charset));
    }

    public static g d(@Nullable j0 j0Var, byte[] bArr) {
        return e(j0Var, bArr, 0, bArr.length);
    }

    public static g e(@Nullable j0 j0Var, byte[] bArr, int i7, int i8) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        n.d.r(bArr.length, i7, i8);
        return new b(j0Var, i8, bArr, i7);
    }

    public abstract void f(com.haier.library.a.h hVar) throws IOException;

    @Nullable
    public abstract j0 g();

    public long h() throws IOException {
        return -1L;
    }
}
