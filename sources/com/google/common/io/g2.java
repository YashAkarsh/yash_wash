package com.google.common.io;

import com.google.common.collect.ib;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public final class g2 {

    static class a implements b0<List<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final List<String> f21980a = ib.q();

        a() {
        }

        @Override // com.google.common.io.b0
        public boolean b(String str) {
            this.f21980a.add(str);
            return true;
        }

        @Override // com.google.common.io.b0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public List<String> a() {
            return this.f21980a;
        }
    }

    private static final class b extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final URL f21981a;

        /* synthetic */ b(URL url, a aVar) {
            this(url);
        }

        @Override // com.google.common.io.g
        public InputStream m() throws IOException {
            return this.f21981a.openStream();
        }

        public String toString() {
            return "Resources.asByteSource(" + this.f21981a + ")";
        }

        private b(URL url) {
            this.f21981a = (URL) com.google.common.base.e0.E(url);
        }
    }

    private g2() {
    }

    public static g a(URL url) {
        return new b(url, null);
    }

    public static p b(URL url, Charset charset) {
        return a(url).a(charset);
    }

    public static void c(URL url, OutputStream outputStream) throws Throwable {
        a(url).g(outputStream);
    }

    public static URL d(Class<?> cls, String str) {
        URL resource = cls.getResource(str);
        com.google.common.base.e0.y(resource != null, "resource %s relative to %s not found.", str, cls.getName());
        return resource;
    }

    @u1.a
    public static URL e(String str) {
        URL resource = ((ClassLoader) com.google.common.base.x.a(Thread.currentThread().getContextClassLoader(), g2.class.getClassLoader())).getResource(str);
        com.google.common.base.e0.u(resource != null, "resource %s not found.", str);
        return resource;
    }

    @u1.a
    public static <T> T f(URL url, Charset charset, b0<T> b0Var) throws IOException {
        return (T) b(url, charset).u(b0Var);
    }

    public static List<String> g(URL url, Charset charset) throws IOException {
        return (List) f(url, charset, new a());
    }

    public static byte[] h(URL url) throws IOException {
        return a(url).o();
    }

    public static String i(URL url, Charset charset) throws IOException {
        return b(url, charset).r();
    }
}
