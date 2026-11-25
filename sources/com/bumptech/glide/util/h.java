package com.bumptech.glide.util;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Class<?> f14931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Class<?> f14932b;

    public h() {
    }

    public void a(Class<?> cls, Class<?> cls2) {
        this.f14931a = cls;
        this.f14932b = cls2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        return this.f14931a.equals(hVar.f14931a) && this.f14932b.equals(hVar.f14932b);
    }

    public int hashCode() {
        return (this.f14931a.hashCode() * 31) + this.f14932b.hashCode();
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f14931a + ", second=" + this.f14932b + '}';
    }

    public h(Class<?> cls, Class<?> cls2) {
        a(cls, cls2);
    }
}
