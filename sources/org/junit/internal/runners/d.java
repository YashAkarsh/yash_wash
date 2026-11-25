package org.junit.internal.runners;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class d extends Exception {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f39856b = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<Throwable> f39857a;

    public d(List<Throwable> list) {
        this.f39857a = list;
    }

    public List<Throwable> a() {
        return this.f39857a;
    }

    public d(Throwable... thArr) {
        this((List<Throwable>) Arrays.asList(thArr));
    }

    public d(String str) {
        this(new Exception(str));
    }
}
