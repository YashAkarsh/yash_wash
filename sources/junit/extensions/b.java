package junit.extensions;

import junit.framework.i;
import junit.framework.m;

/* JADX INFO: loaded from: classes2.dex */
public class b extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f34337b;

    public b(i iVar, int i7) {
        super(iVar);
        if (i7 < 0) {
            throw new IllegalArgumentException("Repetition count must be >= 0");
        }
        this.f34337b = i7;
    }

    @Override // junit.extensions.c, junit.framework.i
    public int a() {
        return super.a() * this.f34337b;
    }

    @Override // junit.extensions.c, junit.framework.i
    public void c(m mVar) {
        for (int i7 = 0; i7 < this.f34337b && !mVar.n(); i7++) {
            super.c(mVar);
        }
    }

    @Override // junit.extensions.c
    public String toString() {
        return super.toString() + "(repeated)";
    }
}
