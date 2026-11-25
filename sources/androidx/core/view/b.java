package androidx.core.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f6542d = "ActionProvider(support)";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f6543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f6544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private InterfaceC0079b f6545c;

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public interface a {
        void b(boolean z7);
    }

    /* JADX INFO: renamed from: androidx.core.view.b$b, reason: collision with other inner class name */
    public interface InterfaceC0079b {
        void onActionProviderVisibilityChanged(boolean z7);
    }

    public b(@c.m0 Context context) {
        this.f6543a = context;
    }

    @c.m0
    public Context a() {
        return this.f6543a;
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return true;
    }

    @c.m0
    public abstract View d();

    @c.m0
    public View e(@c.m0 MenuItem menuItem) {
        return d();
    }

    public boolean f() {
        return false;
    }

    public void g(@c.m0 SubMenu subMenu) {
    }

    public boolean h() {
        return false;
    }

    public void i() {
        if (this.f6545c == null || !h()) {
            return;
        }
        this.f6545c.onActionProviderVisibilityChanged(c());
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void j() {
        this.f6545c = null;
        this.f6544b = null;
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void k(@c.o0 a aVar) {
        this.f6544b = aVar;
    }

    public void l(@c.o0 InterfaceC0079b interfaceC0079b) {
        if (this.f6545c != null && interfaceC0079b != null) {
            Log.w(f6542d, "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f6545c = interfaceC0079b;
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void m(boolean z7) {
        a aVar = this.f6544b;
        if (aVar != null) {
            aVar.b(z7);
        }
    }
}
