package androidx.databinding;

import c.m0;

/* JADX INFO: loaded from: classes.dex */
public class a implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient z f7208a;

    @Override // androidx.databinding.s
    public void a(@m0 s.a aVar) {
        synchronized (this) {
            if (this.f7208a == null) {
                this.f7208a = new z();
            }
        }
        this.f7208a.a(aVar);
    }

    @Override // androidx.databinding.s
    public void b(@m0 s.a aVar) {
        synchronized (this) {
            z zVar = this.f7208a;
            if (zVar == null) {
                return;
            }
            zVar.r(aVar);
        }
    }

    public void e() {
        synchronized (this) {
            z zVar = this.f7208a;
            if (zVar == null) {
                return;
            }
            zVar.m(this, 0, null);
        }
    }

    public void f(int i7) {
        synchronized (this) {
            z zVar = this.f7208a;
            if (zVar == null) {
                return;
            }
            zVar.m(this, i7, null);
        }
    }
}
