package org.junit.internal;

import org.hamcrest.m;
import org.hamcrest.n;

/* JADX INFO: loaded from: classes3.dex */
public class b extends RuntimeException implements m {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f39832e = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f39833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f39834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f39835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final org.hamcrest.k<?> f39836d;

    @Deprecated
    public b(String str, boolean z7, Object obj, org.hamcrest.k<?> kVar) {
        this.f39833a = str;
        this.f39835c = obj;
        this.f39836d = kVar;
        this.f39834b = z7;
        if (obj instanceof Throwable) {
            initCause((Throwable) obj);
        }
    }

    @Override // org.hamcrest.m
    public void b(org.hamcrest.g gVar) {
        String str = this.f39833a;
        if (str != null) {
            gVar.d(str);
        }
        if (this.f39834b) {
            if (this.f39833a != null) {
                gVar.d(": ");
            }
            gVar.d("got: ");
            gVar.e(this.f39835c);
            if (this.f39836d != null) {
                gVar.d(", expected: ");
                gVar.b(this.f39836d);
            }
        }
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return n.n(this);
    }

    @Deprecated
    public b(Object obj, org.hamcrest.k<?> kVar) {
        this(null, true, obj, kVar);
    }

    @Deprecated
    public b(String str, Object obj, org.hamcrest.k<?> kVar) {
        this(str, true, obj, kVar);
    }

    @Deprecated
    public b(String str) {
        this(str, false, null, null);
    }

    @Deprecated
    public b(String str, Throwable th) {
        this(str, false, null, null);
        initCause(th);
    }
}
