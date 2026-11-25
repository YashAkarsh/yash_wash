package kotlin.io;

import java.io.InputStream;
import java.nio.charset.Charset;
import kotlin.g1;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
@h5.h(name = "ConsoleKt")
public final class d {
    @kotlin.internal.f
    private static final void a(byte b8) {
        System.out.print(Byte.valueOf(b8));
    }

    @kotlin.internal.f
    private static final void b(char c8) {
        System.out.print(c8);
    }

    @kotlin.internal.f
    private static final void c(double d8) {
        System.out.print(d8);
    }

    @kotlin.internal.f
    private static final void d(float f8) {
        System.out.print(f8);
    }

    @kotlin.internal.f
    private static final void e(int i7) {
        System.out.print(i7);
    }

    @kotlin.internal.f
    private static final void f(long j7) {
        System.out.print(j7);
    }

    @kotlin.internal.f
    private static final void g(Object obj) {
        System.out.print(obj);
    }

    @kotlin.internal.f
    private static final void h(short s7) {
        System.out.print(Short.valueOf(s7));
    }

    @kotlin.internal.f
    private static final void i(boolean z7) {
        System.out.print(z7);
    }

    @kotlin.internal.f
    private static final void j(char[] message) {
        l0.p(message, "message");
        System.out.print(message);
    }

    @kotlin.internal.f
    private static final void k() {
        System.out.println();
    }

    @kotlin.internal.f
    private static final void l(byte b8) {
        System.out.println(Byte.valueOf(b8));
    }

    @kotlin.internal.f
    private static final void m(char c8) {
        System.out.println(c8);
    }

    @kotlin.internal.f
    private static final void n(double d8) {
        System.out.println(d8);
    }

    @kotlin.internal.f
    private static final void o(float f8) {
        System.out.println(f8);
    }

    @kotlin.internal.f
    private static final void p(int i7) {
        System.out.println(i7);
    }

    @kotlin.internal.f
    private static final void q(long j7) {
        System.out.println(j7);
    }

    @kotlin.internal.f
    private static final void r(Object obj) {
        System.out.println(obj);
    }

    @kotlin.internal.f
    private static final void s(short s7) {
        System.out.println(Short.valueOf(s7));
    }

    @kotlin.internal.f
    private static final void t(boolean z7) {
        System.out.println(z7);
    }

    @kotlin.internal.f
    private static final void u(char[] message) {
        l0.p(message, "message");
        System.out.println(message);
    }

    @a7.e
    public static final String v() {
        r rVar = r.f34794a;
        InputStream inputStream = System.in;
        l0.o(inputStream, "`in`");
        Charset charsetDefaultCharset = Charset.defaultCharset();
        l0.o(charsetDefaultCharset, "defaultCharset()");
        return rVar.d(inputStream, charsetDefaultCharset);
    }

    @a7.d
    @g1(version = i2.a.f34096f)
    public static final String w() {
        String strX = x();
        if (strX != null) {
            return strX;
        }
        throw new v("EOF has already been reached");
    }

    @g1(version = i2.a.f34096f)
    @a7.e
    public static final String x() {
        return v();
    }
}
