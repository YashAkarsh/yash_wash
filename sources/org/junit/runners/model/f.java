package org.junit.runners.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class f extends Exception {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f40050b = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<Throwable> f40051a;

    public f(List<Throwable> list) {
        this.f40051a = new ArrayList(list);
    }

    public static void a(List<Throwable> list) throws Exception {
        if (list.isEmpty()) {
            return;
        }
        if (list.size() != 1) {
            throw new org.junit.internal.runners.model.b(list);
        }
        throw org.junit.internal.k.b(list.get(0));
    }

    public List<Throwable> b() {
        return Collections.unmodifiableList(this.f40051a);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder(String.format("There were %d errors:", Integer.valueOf(this.f40051a.size())));
        for (Throwable th : this.f40051a) {
            sb.append(String.format("\n  %s(%s)", th.getClass().getName(), th.getMessage()));
        }
        return sb.toString();
    }
}
