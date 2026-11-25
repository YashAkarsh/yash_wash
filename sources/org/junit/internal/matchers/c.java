package org.junit.internal.matchers;

import java.lang.Throwable;
import org.hamcrest.g;
import org.hamcrest.i;
import org.hamcrest.k;
import org.hamcrest.p;

/* JADX INFO: loaded from: classes3.dex */
public class c<T extends Throwable> extends p<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k<String> f39847c;

    public c(k<String> kVar) {
        this.f39847c = kVar;
    }

    @i
    public static <T extends Throwable> k<T> h(k<String> kVar) {
        return new c(kVar);
    }

    @Override // org.hamcrest.m
    public void b(g gVar) {
        gVar.d("exception with message ");
        gVar.b(this.f39847c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.hamcrest.p
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void e(T t7, g gVar) {
        gVar.d("message ");
        this.f39847c.a(t7.getMessage(), gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.hamcrest.p
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean f(T t7) {
        return this.f39847c.c(t7.getMessage());
    }
}
