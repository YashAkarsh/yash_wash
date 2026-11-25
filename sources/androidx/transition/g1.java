package androidx.transition;

import android.view.View;
import android.view.WindowId;

/* JADX INFO: loaded from: classes.dex */
@c.t0(18)
class g1 implements h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WindowId f10721a;

    g1(@c.m0 View view) {
        this.f10721a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof g1) && ((g1) obj).f10721a.equals(this.f10721a);
    }

    public int hashCode() {
        return this.f10721a.hashCode();
    }
}
