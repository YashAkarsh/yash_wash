package androidx.appcompat.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f1008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1009b;

    public interface a {
        void a(b bVar);

        boolean b(b bVar, Menu menu);

        boolean c(b bVar, Menu menu);

        boolean d(b bVar, MenuItem menuItem);
    }

    public abstract void c();

    public abstract View d();

    public abstract Menu e();

    public abstract MenuInflater f();

    public abstract CharSequence g();

    public Object h() {
        return this.f1008a;
    }

    public abstract CharSequence i();

    public boolean j() {
        return this.f1009b;
    }

    public abstract void k();

    public boolean l() {
        return false;
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public boolean m() {
        return true;
    }

    public abstract void n(View view);

    public abstract void o(int i7);

    public abstract void p(CharSequence charSequence);

    public void q(Object obj) {
        this.f1008a = obj;
    }

    public abstract void r(int i7);

    public abstract void s(CharSequence charSequence);

    public void t(boolean z7) {
        this.f1009b = z7;
    }
}
