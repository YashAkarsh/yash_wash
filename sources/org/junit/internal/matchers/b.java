package org.junit.internal.matchers;

import java.lang.Throwable;
import org.hamcrest.g;
import org.hamcrest.i;
import org.hamcrest.k;
import org.hamcrest.p;

/* JADX INFO: loaded from: classes3.dex */
public class b<T extends Throwable> extends p<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k<? extends Throwable> f39846c;

    public b(k<? extends Throwable> kVar) {
        this.f39846c = kVar;
    }

    @i
    public static <T extends Throwable> k<T> h(k<? extends Throwable> kVar) {
        return new b(kVar);
    }

    @Override // org.hamcrest.m
    public void b(g gVar) {
        gVar.d("exception with cause ");
        gVar.b(this.f39846c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.hamcrest.p
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void e(T t7, g gVar) {
        gVar.d("cause ");
        this.f39846c.a(t7.getCause(), gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.hamcrest.p
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean f(T t7) {
        return this.f39846c.c(t7.getCause());
    }
}
