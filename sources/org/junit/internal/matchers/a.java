package org.junit.internal.matchers;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Throwable;
import org.hamcrest.g;
import org.hamcrest.i;
import org.hamcrest.k;
import org.hamcrest.p;

/* JADX INFO: loaded from: classes3.dex */
public class a<T extends Throwable> extends p<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k<T> f39845c;

    public a(k<T> kVar) {
        this.f39845c = kVar;
    }

    @i
    public static <T extends Exception> k<T> h(k<T> kVar) {
        return new a(kVar);
    }

    @i
    public static <T extends Throwable> k<T> i(k<T> kVar) {
        return new a(kVar);
    }

    private String k(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    @Override // org.hamcrest.m
    public void b(g gVar) {
        this.f39845c.b(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.hamcrest.p
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void e(T t7, g gVar) {
        this.f39845c.a(t7, gVar);
        gVar.d("\nStacktrace was: ");
        gVar.d(k(t7));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.hamcrest.p
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public boolean f(T t7) {
        return this.f39845c.c(t7);
    }
}
