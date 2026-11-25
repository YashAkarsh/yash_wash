package org.junit.runner;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f39965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f39966b;

    public f(c cVar, String str) {
        if (str == null || cVar == null) {
            throw null;
        }
        this.f39965a = cVar;
        this.f39966b = str;
    }

    public String a() {
        return this.f39966b;
    }

    public c b() {
        return this.f39965a;
    }
}
