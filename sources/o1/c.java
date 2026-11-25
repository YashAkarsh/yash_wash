package o1;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c.b0;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final View f37562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f37563b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @b0
    private int f37564c = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public c(b bVar) {
        this.f37562a = (View) bVar;
    }

    private void a() {
        ViewParent parent = this.f37562a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).l(this.f37562a);
        }
    }

    @b0
    public int b() {
        return this.f37564c;
    }

    public boolean c() {
        return this.f37563b;
    }

    public void d(@m0 Bundle bundle) {
        this.f37563b = bundle.getBoolean("expanded", false);
        this.f37564c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.f37563b) {
            a();
        }
    }

    @m0
    public Bundle e() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.f37563b);
        bundle.putInt("expandedComponentIdHint", this.f37564c);
        return bundle;
    }

    public boolean f(boolean z7) {
        if (this.f37563b == z7) {
            return false;
        }
        this.f37563b = z7;
        a();
        return true;
    }

    public void g(@b0 int i7) {
        this.f37564c = i7;
    }
}
