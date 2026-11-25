package com.haier.library.okhttp;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class e0 extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final j0 f27534c = j0.a("application/x-www-form-urlencoded");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<String> f27535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f27536b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<String> f27537a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<String> f27538b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Charset f27539c;

        public a() {
            this(null);
        }

        public a a(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (str2 == null) {
                throw new NullPointerException("value == null");
            }
            this.f27537a.add(h0.h(str, HttpUrl.FORM_ENCODE_SET, false, false, true, true, this.f27539c));
            this.f27538b.add(h0.h(str2, HttpUrl.FORM_ENCODE_SET, false, false, true, true, this.f27539c));
            return this;
        }

        public e0 b() {
            return new e0(this.f27537a, this.f27538b);
        }

        public a c(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (str2 == null) {
                throw new NullPointerException("value == null");
            }
            this.f27537a.add(h0.h(str, HttpUrl.FORM_ENCODE_SET, true, false, true, true, this.f27539c));
            this.f27538b.add(h0.h(str2, HttpUrl.FORM_ENCODE_SET, true, false, true, true, this.f27539c));
            return this;
        }

        public a(Charset charset) {
            this.f27537a = new ArrayList();
            this.f27538b = new ArrayList();
            this.f27539c = charset;
        }
    }

    e0(List<String> list, List<String> list2) {
        this.f27535a = n.d.m(list);
        this.f27536b = n.d.m(list2);
    }

    private long j(@Nullable com.haier.library.a.h hVar, boolean z7) {
        com.haier.library.a.g gVar = z7 ? new com.haier.library.a.g() : hVar.c();
        int size = this.f27535a.size();
        for (int i7 = 0; i7 < size; i7++) {
            if (i7 > 0) {
                gVar.y1(38);
            }
            gVar.b(this.f27535a.get(i7));
            gVar.y1(61);
            gVar.b(this.f27536b.get(i7));
        }
        if (!z7) {
            return 0L;
        }
        long jY0 = gVar.Y0();
        gVar.h2();
        return jY0;
    }

    @Override // com.haier.library.okhttp.g
    public void f(com.haier.library.a.h hVar) throws IOException {
        j(hVar, false);
    }

    @Override // com.haier.library.okhttp.g
    public j0 g() {
        return f27534c;
    }

    @Override // com.haier.library.okhttp.g
    public long h() {
        return j(null, true);
    }

    public int i() {
        return this.f27535a.size();
    }

    public String k(int i7) {
        return this.f27535a.get(i7);
    }

    public String l(int i7) {
        return h0.i(k(i7), true);
    }

    public String m(int i7) {
        return this.f27536b.get(i7);
    }

    public String n(int i7) {
        return h0.i(m(i7), true);
    }
}
