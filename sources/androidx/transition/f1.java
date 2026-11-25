package androidx.transition;

import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
class f1 implements h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IBinder f10702a;

    f1(IBinder iBinder) {
        this.f10702a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f1) && ((f1) obj).f10702a.equals(this.f10702a);
    }

    public int hashCode() {
        return this.f10702a.hashCode();
    }
}
