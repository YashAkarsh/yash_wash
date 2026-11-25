package org.junit.internal.runners.statements;

import org.junit.runners.model.j;

/* JADX INFO: loaded from: classes3.dex */
public class a extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f39892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class<? extends Throwable> f39893b;

    public a(j jVar, Class<? extends Throwable> cls) {
        this.f39892a = jVar;
        this.f39893b = cls;
    }

    @Override // org.junit.runners.model.j
    public void a() throws Exception {
        boolean z7;
        try {
            this.f39892a.a();
            z7 = true;
        } catch (org.junit.internal.b e8) {
            throw e8;
        } catch (Throwable th) {
            if (!this.f39893b.isAssignableFrom(th.getClass())) {
                throw new Exception("Unexpected exception, expected<" + this.f39893b.getName() + "> but was<" + th.getClass().getName() + ">", th);
            }
            z7 = false;
        }
        if (z7) {
            throw new AssertionError("Expected exception: " + this.f39893b.getName());
        }
    }
}
