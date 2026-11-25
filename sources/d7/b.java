package d7;

import org.junit.runner.i;
import org.junit.runner.l;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f33510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final org.junit.runner.manipulation.a f33511b;

    public b(i iVar, org.junit.runner.manipulation.a aVar) {
        this.f33510a = iVar;
        this.f33511b = aVar;
    }

    @Override // org.junit.runner.i
    public l h() {
        try {
            l lVarH = this.f33510a.h();
            this.f33511b.a(lVarH);
            return lVarH;
        } catch (org.junit.runner.manipulation.c unused) {
            return new org.junit.internal.runners.b(org.junit.runner.manipulation.a.class, new Exception(String.format("No tests found matching %s from %s", this.f33511b.b(), this.f33510a.toString())));
        }
    }
}
