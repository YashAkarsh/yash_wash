package androidx.navigation.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.navigation.NavController;
import androidx.navigation.l;
import androidx.navigation.n;
import androidx.navigation.t;
import c.b0;
import c.m0;
import c.o0;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationView;
import java.lang.ref.WeakReference;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NavController f8952a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ androidx.navigation.ui.c f8953b;

        a(NavController navController, androidx.navigation.ui.c cVar) {
            this.f8952a = navController;
            this.f8953b = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.f(this.f8952a, this.f8953b);
        }
    }

    class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NavController f8954a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ androidx.navigation.ui.c f8955b;

        b(NavController navController, androidx.navigation.ui.c cVar) {
            this.f8954a = navController;
            this.f8955b = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.f(this.f8954a, this.f8955b);
        }
    }

    class c implements NavigationView.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NavController f8956a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ NavigationView f8957b;

        c(NavController navController, NavigationView navigationView) {
            this.f8956a = navController;
            this.f8957b = navigationView;
        }

        @Override // com.google.android.material.navigation.NavigationView.c
        public boolean a(@m0 MenuItem menuItem) {
            boolean zG = e.g(menuItem, this.f8956a);
            if (zG) {
                ViewParent parent = this.f8957b.getParent();
                if (parent instanceof androidx.customview.widget.c) {
                    ((androidx.customview.widget.c) parent).close();
                } else {
                    BottomSheetBehavior bottomSheetBehaviorA = e.a(this.f8957b);
                    if (bottomSheetBehaviorA != null) {
                        bottomSheetBehaviorA.K0(5);
                    }
                }
            }
            return zG;
        }
    }

    class d implements NavController.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference f8958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ NavController f8959b;

        d(WeakReference weakReference, NavController navController) {
            this.f8958a = weakReference;
            this.f8959b = navController;
        }

        @Override // androidx.navigation.NavController.b
        public void a(@m0 NavController navController, @m0 l lVar, @o0 Bundle bundle) {
            NavigationView navigationView = (NavigationView) this.f8958a.get();
            if (navigationView == null) {
                this.f8959b.L(this);
                return;
            }
            Menu menu = navigationView.getMenu();
            int size = menu.size();
            for (int i7 = 0; i7 < size; i7++) {
                MenuItem item = menu.getItem(i7);
                item.setChecked(e.c(lVar, item.getItemId()));
            }
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.ui.e$e, reason: collision with other inner class name */
    class C0117e implements BottomNavigationView.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NavController f8960a;

        C0117e(NavController navController) {
            this.f8960a = navController;
        }

        @Override // com.google.android.material.navigation.NavigationBarView.e
        public boolean a(@m0 MenuItem menuItem) {
            return e.g(menuItem, this.f8960a);
        }
    }

    class f implements NavController.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference f8961a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ NavController f8962b;

        f(WeakReference weakReference, NavController navController) {
            this.f8961a = weakReference;
            this.f8962b = navController;
        }

        @Override // androidx.navigation.NavController.b
        public void a(@m0 NavController navController, @m0 l lVar, @o0 Bundle bundle) {
            BottomNavigationView bottomNavigationView = (BottomNavigationView) this.f8961a.get();
            if (bottomNavigationView == null) {
                this.f8962b.L(this);
                return;
            }
            Menu menu = bottomNavigationView.getMenu();
            int size = menu.size();
            for (int i7 = 0; i7 < size; i7++) {
                MenuItem item = menu.getItem(i7);
                if (e.c(lVar, item.getItemId())) {
                    item.setChecked(true);
                }
            }
        }
    }

    private e() {
    }

    static BottomSheetBehavior a(@m0 View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.f) {
            CoordinatorLayout.Behavior behaviorF = ((CoordinatorLayout.f) layoutParams).f();
            if (behaviorF instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) behaviorF;
            }
            return null;
        }
        Object parent = view.getParent();
        if (parent instanceof View) {
            return a((View) parent);
        }
        return null;
    }

    static l b(@m0 n nVar) {
        l lVarL = nVar;
        while (lVarL instanceof n) {
            n nVar2 = (n) lVarL;
            lVarL = nVar2.L(nVar2.O());
        }
        return lVarL;
    }

    static boolean c(@m0 l lVar, @b0 int i7) {
        while (lVar.m() != i7 && lVar.p() != null) {
            lVar = lVar.p();
        }
        return lVar.m() == i7;
    }

    static boolean d(@m0 l lVar, @m0 Set<Integer> set) {
        while (!set.contains(Integer.valueOf(lVar.m()))) {
            lVar = lVar.p();
            if (lVar == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean e(@m0 NavController navController, @o0 androidx.customview.widget.c cVar) {
        return f(navController, new androidx.navigation.ui.c.b(navController.m()).d(cVar).a());
    }

    public static boolean f(@m0 NavController navController, @m0 androidx.navigation.ui.c cVar) {
        androidx.customview.widget.c cVarC = cVar.c();
        l lVarK = navController.k();
        Set<Integer> setD = cVar.d();
        if (cVarC != null && lVarK != null && d(lVarK, setD)) {
            cVarC.open();
            return true;
        }
        if (navController.G()) {
            return true;
        }
        if (cVar.b() != null) {
            return cVar.b().a();
        }
        return false;
    }

    public static boolean g(@m0 MenuItem menuItem, @m0 NavController navController) {
        t.a aVarF = new t.a().d(true).b(R.anim.nav_default_enter_anim).c(R.anim.nav_default_exit_anim).e(R.anim.nav_default_pop_enter_anim).f(R.anim.nav_default_pop_exit_anim);
        if ((menuItem.getOrder() & 196608) == 0) {
            aVarF.g(b(navController.m()).m(), false);
        }
        try {
            navController.u(menuItem.getItemId(), null, aVarF.a());
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public static void h(@m0 AppCompatActivity appCompatActivity, @m0 NavController navController) {
        j(appCompatActivity, navController, new androidx.navigation.ui.c.b(navController.m()).a());
    }

    public static void i(@m0 AppCompatActivity appCompatActivity, @m0 NavController navController, @o0 androidx.customview.widget.c cVar) {
        j(appCompatActivity, navController, new androidx.navigation.ui.c.b(navController.m()).d(cVar).a());
    }

    public static void j(@m0 AppCompatActivity appCompatActivity, @m0 NavController navController, @m0 androidx.navigation.ui.c cVar) {
        navController.a(new androidx.navigation.ui.b(appCompatActivity, cVar));
    }

    public static void k(@m0 Toolbar toolbar, @m0 NavController navController) {
        m(toolbar, navController, new androidx.navigation.ui.c.b(navController.m()).a());
    }

    public static void l(@m0 Toolbar toolbar, @m0 NavController navController, @o0 androidx.customview.widget.c cVar) {
        m(toolbar, navController, new androidx.navigation.ui.c.b(navController.m()).d(cVar).a());
    }

    public static void m(@m0 Toolbar toolbar, @m0 NavController navController, @m0 androidx.navigation.ui.c cVar) {
        navController.a(new androidx.navigation.ui.f(toolbar, cVar));
        toolbar.setNavigationOnClickListener(new a(navController, cVar));
    }

    public static void n(@m0 CollapsingToolbarLayout collapsingToolbarLayout, @m0 Toolbar toolbar, @m0 NavController navController) {
        p(collapsingToolbarLayout, toolbar, navController, new androidx.navigation.ui.c.b(navController.m()).a());
    }

    public static void o(@m0 CollapsingToolbarLayout collapsingToolbarLayout, @m0 Toolbar toolbar, @m0 NavController navController, @o0 androidx.customview.widget.c cVar) {
        p(collapsingToolbarLayout, toolbar, navController, new androidx.navigation.ui.c.b(navController.m()).d(cVar).a());
    }

    public static void p(@m0 CollapsingToolbarLayout collapsingToolbarLayout, @m0 Toolbar toolbar, @m0 NavController navController, @m0 androidx.navigation.ui.c cVar) {
        navController.a(new androidx.navigation.ui.d(collapsingToolbarLayout, toolbar, cVar));
        toolbar.setNavigationOnClickListener(new b(navController, cVar));
    }

    public static void q(@m0 BottomNavigationView bottomNavigationView, @m0 NavController navController) {
        bottomNavigationView.setOnNavigationItemSelectedListener(new C0117e(navController));
        navController.a(new f(new WeakReference(bottomNavigationView), navController));
    }

    public static void r(@m0 NavigationView navigationView, @m0 NavController navController) {
        navigationView.setNavigationItemSelectedListener(new c(navController, navigationView));
        navController.a(new d(new WeakReference(navigationView), navController));
    }
}
