package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import c.m0;
import c.o0;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final CopyOnWriteArrayList<a> f8010a = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    private final FragmentManager f8011b;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m0
        final FragmentManager.m f8012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f8013b;

        a(@m0 FragmentManager.m mVar, boolean z7) {
            this.f8012a = mVar;
            this.f8013b = z7;
        }
    }

    j(@m0 FragmentManager fragmentManager) {
        this.f8011b = fragmentManager;
    }

    void a(@m0 Fragment fragment, @o0 Bundle bundle, boolean z7) {
        Fragment fragmentK0 = this.f8011b.K0();
        if (fragmentK0 != null) {
            fragmentK0.getParentFragmentManager().J0().a(fragment, bundle, true);
        }
        for (a aVar : this.f8010a) {
            if (!z7 || aVar.f8013b) {
                aVar.f8012a.onFragmentActivityCreated(this.f8011b, fragment, bundle);
            }
        }
    }

    void b(@m0 Fragment fragment, boolean z7) {
        Context contextF = this.f8011b.H0().f();
        Fragment fragmentK0 = this.f8011b.K0();
        if (fragmentK0 != null) {
            fragmentK0.getParentFragmentManager().J0().b(fragment, true);
        }
        for (a aVar : this.f8010a) {
            if (!z7 || aVar.f8013b) {
                aVar.f8012a.onFragmentAttached(this.f8011b, fragment, contextF);
            }
        }
    }

    void c(@m0 Fragment fragment, @o0 Bundle bundle, boolean z7) {
        Fragment fragmentK0 = this.f8011b.K0();
        if (fragmentK0 != null) {
            fragmentK0.getParentFragmentManager().J0().c(fragment, bundle, true);
        }
        for (a aVar : this.f8010a) {
            if (!z7 || aVar.f8013b) {
                aVar.f8012a.onFragmentCreated(this.f8011b, fragment, bundle);
            }
        }
    }

    void d(@m0 Fragment fragment, boolean z7) {
        Fragment fragmentK0 = this.f8011b.K0();
        if (fragmentK0 != null) {
            fragmentK0.getParentFragmentManager().J0().d(fragment, true);
        }
        for (a aVar : this.f8010a) {
            if (!z7 || aVar.f8013b) {
                aVar.f8012a.onFragmentDestroyed(this.f8011b, fragment);
            }
        }
    }

    void e(@m0 Fragment fragment, boolean z7) {
        Fragment fragmentK0 = this.f8011b.K0();
        if (fragmentK0 != null) {
            fragmentK0.getParentFragmentManager().J0().e(fragment, true);
        }
        for (a aVar : this.f8010a) {
            if (!z7 || aVar.f8013b) {
                aVar.f8012a.onFragmentDetached(this.f8011b, fragment);
            }
        }
    }

    void f(@m0 Fragment fragment, boolean z7) {
        Fragment fragmentK0 = this.f8011b.K0();
        if (fragmentK0 != null) {
            fragmentK0.getParentFragmentManager().J0().f(fragment, true);
        }
        for (a aVar : this.f8010a) {
            if (!z7 || aVar.f8013b) {
                aVar.f8012a.onFragmentPaused(this.f8011b, fragment);
            }
        }
    }

    void g(@m0 Fragment fragment, boolean z7) {
        Context contextF = this.f8011b.H0().f();
        Fragment fragmentK0 = this.f8011b.K0();
        if (fragmentK0 != null) {
            fragmentK0.getParentFragmentManager().J0().g(fragment, true);
        }
        for (a aVar : this.f8010a) {
            if (!z7 || aVar.f8013b) {
                aVar.f8012a.onFragmentPreAttached(this.f8011b, fragment, contextF);
            }
        }
    }

    void h(@m0 Fragment fragment, @o0 Bundle bundle, boolean z7) {
        Fragment fragmentK0 = this.f8011b.K0();
        if (fragmentK0 != null) {
            fragmentK0.getParentFragmentManager().J0().h(fragment, bundle, true);
        }
        for (a aVar : this.f8010a) {
            if (!z7 || aVar.f8013b) {
                aVar.f8012a.onFragmentPreCreated(this.f8011b, fragment, bundle);
            }
        }
    }

    void i(@m0 Fragment fragment, boolean z7) {
        Fragment fragmentK0 = this.f8011b.K0();
        if (fragmentK0 != null) {
            fragmentK0.getParentFragmentManager().J0().i(fragment, true);
        }
        for (a aVar : this.f8010a) {
            if (!z7 || aVar.f8013b) {
                aVar.f8012a.onFragmentResumed(this.f8011b, fragment);
            }
        }
    }

    void j(@m0 Fragment fragment, @m0 Bundle bundle, boolean z7) {
        Fragment fragmentK0 = this.f8011b.K0();
        if (fragmentK0 != null) {
            fragmentK0.getParentFragmentManager().J0().j(fragment, bundle, true);
        }
        for (a aVar : this.f8010a) {
            if (!z7 || aVar.f8013b) {
                aVar.f8012a.onFragmentSaveInstanceState(this.f8011b, fragment, bundle);
            }
        }
    }

    void k(@m0 Fragment fragment, boolean z7) {
        Fragment fragmentK0 = this.f8011b.K0();
        if (fragmentK0 != null) {
            fragmentK0.getParentFragmentManager().J0().k(fragment, true);
        }
        for (a aVar : this.f8010a) {
            if (!z7 || aVar.f8013b) {
                aVar.f8012a.onFragmentStarted(this.f8011b, fragment);
            }
        }
    }

    void l(@m0 Fragment fragment, boolean z7) {
        Fragment fragmentK0 = this.f8011b.K0();
        if (fragmentK0 != null) {
            fragmentK0.getParentFragmentManager().J0().l(fragment, true);
        }
        for (a aVar : this.f8010a) {
            if (!z7 || aVar.f8013b) {
                aVar.f8012a.onFragmentStopped(this.f8011b, fragment);
            }
        }
    }

    void m(@m0 Fragment fragment, @m0 View view, @o0 Bundle bundle, boolean z7) {
        Fragment fragmentK0 = this.f8011b.K0();
        if (fragmentK0 != null) {
            fragmentK0.getParentFragmentManager().J0().m(fragment, view, bundle, true);
        }
        for (a aVar : this.f8010a) {
            if (!z7 || aVar.f8013b) {
                aVar.f8012a.onFragmentViewCreated(this.f8011b, fragment, view, bundle);
            }
        }
    }

    void n(@m0 Fragment fragment, boolean z7) {
        Fragment fragmentK0 = this.f8011b.K0();
        if (fragmentK0 != null) {
            fragmentK0.getParentFragmentManager().J0().n(fragment, true);
        }
        for (a aVar : this.f8010a) {
            if (!z7 || aVar.f8013b) {
                aVar.f8012a.onFragmentViewDestroyed(this.f8011b, fragment);
            }
        }
    }

    public void o(@m0 FragmentManager.m mVar, boolean z7) {
        this.f8010a.add(new a(mVar, z7));
    }

    public void p(@m0 FragmentManager.m mVar) {
        synchronized (this.f8010a) {
            int size = this.f8010a.size();
            for (int i7 = 0; i7 < size; i7++) {
                if (this.f8010a.get(i7).f8012a == mVar) {
                    this.f8010a.remove(i7);
                    break;
                }
            }
        }
    }
}
