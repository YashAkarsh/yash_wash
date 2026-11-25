package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.collection.f;
import androidx.core.util.w;
import androidx.core.view.n2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.v;
import androidx.lifecycle.m;
import androidx.lifecycle.o;
import androidx.lifecycle.q;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import c.i;
import c.m0;
import c.o0;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentStateAdapter extends RecyclerView.g<androidx.viewpager2.adapter.a> implements androidx.viewpager2.adapter.b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f11135k = "f#";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f11136l = "s#";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final long f11137m = 10000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final m f11138c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final FragmentManager f11139d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final f<Fragment> f11140e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final f<Fragment.SavedState> f11141f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final f<Integer> f11142g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private FragmentMaxLifecycleEnforcer f11143h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f11144i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f11145j;

    class FragmentMaxLifecycleEnforcer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ViewPager2.j f11151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private RecyclerView.i f11152b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private o f11153c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ViewPager2 f11154d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f11155e = -1;

        class a extends ViewPager2.j {
            a() {
            }

            @Override // androidx.viewpager2.widget.ViewPager2.j
            public void a(int i7) {
                FragmentMaxLifecycleEnforcer.this.d(false);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.j
            public void c(int i7) {
                FragmentMaxLifecycleEnforcer.this.d(false);
            }
        }

        class b extends d {
            b() {
                super(null);
            }

            @Override // androidx.viewpager2.adapter.FragmentStateAdapter.d, androidx.recyclerview.widget.RecyclerView.i
            public void a() {
                FragmentMaxLifecycleEnforcer.this.d(true);
            }
        }

        FragmentMaxLifecycleEnforcer() {
        }

        @m0
        private ViewPager2 a(@m0 RecyclerView recyclerView) {
            ViewParent parent = recyclerView.getParent();
            if (parent instanceof ViewPager2) {
                return (ViewPager2) parent;
            }
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
        }

        void b(@m0 RecyclerView recyclerView) {
            this.f11154d = a(recyclerView);
            a aVar = new a();
            this.f11151a = aVar;
            this.f11154d.n(aVar);
            b bVar = new b();
            this.f11152b = bVar;
            FragmentStateAdapter.this.C(bVar);
            o oVar = new o() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.3
                @Override // androidx.lifecycle.o
                public void g(@m0 q qVar, @m0 m.b bVar2) {
                    FragmentMaxLifecycleEnforcer.this.d(false);
                }
            };
            this.f11153c = oVar;
            FragmentStateAdapter.this.f11138c.a(oVar);
        }

        void c(@m0 RecyclerView recyclerView) {
            a(recyclerView).w(this.f11151a);
            FragmentStateAdapter.this.E(this.f11152b);
            FragmentStateAdapter.this.f11138c.c(this.f11153c);
            this.f11154d = null;
        }

        void d(boolean z7) {
            int currentItem;
            Fragment fragmentM;
            if (FragmentStateAdapter.this.Y() || this.f11154d.getScrollState() != 0 || FragmentStateAdapter.this.f11140e.q() || FragmentStateAdapter.this.e() == 0 || (currentItem = this.f11154d.getCurrentItem()) >= FragmentStateAdapter.this.e()) {
                return;
            }
            long jF = FragmentStateAdapter.this.f(currentItem);
            if ((jF != this.f11155e || z7) && (fragmentM = FragmentStateAdapter.this.f11140e.m(jF)) != null && fragmentM.isAdded()) {
                this.f11155e = jF;
                v vVarR = FragmentStateAdapter.this.f11139d.r();
                Fragment fragment = null;
                for (int i7 = 0; i7 < FragmentStateAdapter.this.f11140e.B(); i7++) {
                    long jR = FragmentStateAdapter.this.f11140e.r(i7);
                    Fragment fragmentC = FragmentStateAdapter.this.f11140e.C(i7);
                    if (fragmentC.isAdded()) {
                        if (jR != this.f11155e) {
                            vVarR.P(fragmentC, m.c.STARTED);
                        } else {
                            fragment = fragmentC;
                        }
                        fragmentC.setMenuVisibility(jR == this.f11155e);
                    }
                }
                if (fragment != null) {
                    vVarR.P(fragment, m.c.RESUMED);
                }
                if (vVarR.B()) {
                    return;
                }
                vVarR.t();
            }
        }
    }

    class a implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FrameLayout f11160a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ androidx.viewpager2.adapter.a f11161b;

        a(FrameLayout frameLayout, androidx.viewpager2.adapter.a aVar) {
            this.f11160a = frameLayout;
            this.f11161b = aVar;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
            if (this.f11160a.getParent() != null) {
                this.f11160a.removeOnLayoutChangeListener(this);
                FragmentStateAdapter.this.U(this.f11161b);
            }
        }
    }

    class b extends FragmentManager.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Fragment f11163a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ FrameLayout f11164b;

        b(Fragment fragment, FrameLayout frameLayout) {
            this.f11163a = fragment;
            this.f11164b = frameLayout;
        }

        @Override // androidx.fragment.app.FragmentManager.m
        public void onFragmentViewCreated(@m0 FragmentManager fragmentManager, @m0 Fragment fragment, @m0 View view, @o0 Bundle bundle) {
            if (fragment == this.f11163a) {
                fragmentManager.T1(this);
                FragmentStateAdapter.this.F(view, this.f11164b);
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentStateAdapter fragmentStateAdapter = FragmentStateAdapter.this;
            fragmentStateAdapter.f11144i = false;
            fragmentStateAdapter.K();
        }
    }

    private static abstract class d extends RecyclerView.i {
        private d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public abstract void a();

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void b(int i7, int i8) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void c(int i7, int i8, @o0 Object obj) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void d(int i7, int i8) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void e(int i7, int i8, int i9) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void f(int i7, int i8) {
            a();
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    public FragmentStateAdapter(@m0 FragmentActivity fragmentActivity) {
        this(fragmentActivity.getSupportFragmentManager(), fragmentActivity.getLifecycle());
    }

    @m0
    private static String I(@m0 String str, long j7) {
        return str + j7;
    }

    private void J(int i7) {
        long jF = f(i7);
        if (this.f11140e.i(jF)) {
            return;
        }
        Fragment fragmentH = H(i7);
        fragmentH.setInitialSavedState(this.f11141f.m(jF));
        this.f11140e.s(jF, fragmentH);
    }

    private boolean L(long j7) {
        View view;
        if (this.f11142g.i(j7)) {
            return true;
        }
        Fragment fragmentM = this.f11140e.m(j7);
        return (fragmentM == null || (view = fragmentM.getView()) == null || view.getParent() == null) ? false : true;
    }

    private static boolean M(@m0 String str, @m0 String str2) {
        return str.startsWith(str2) && str.length() > str2.length();
    }

    private Long N(int i7) {
        Long lValueOf = null;
        for (int i8 = 0; i8 < this.f11142g.B(); i8++) {
            if (this.f11142g.C(i8).intValue() == i7) {
                if (lValueOf != null) {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
                lValueOf = Long.valueOf(this.f11142g.r(i8));
            }
        }
        return lValueOf;
    }

    private static long T(@m0 String str, @m0 String str2) {
        return Long.parseLong(str.substring(str2.length()));
    }

    private void V(long j7) {
        ViewParent parent;
        Fragment fragmentM = this.f11140e.m(j7);
        if (fragmentM == null) {
            return;
        }
        if (fragmentM.getView() != null && (parent = fragmentM.getView().getParent()) != null) {
            ((FrameLayout) parent).removeAllViews();
        }
        if (!G(j7)) {
            this.f11141f.v(j7);
        }
        if (!fragmentM.isAdded()) {
            this.f11140e.v(j7);
            return;
        }
        if (Y()) {
            this.f11145j = true;
            return;
        }
        if (fragmentM.isAdded() && G(j7)) {
            this.f11141f.s(j7, this.f11139d.I1(fragmentM));
        }
        this.f11139d.r().C(fragmentM).t();
        this.f11140e.v(j7);
    }

    private void W() {
        final Handler handler = new Handler(Looper.getMainLooper());
        final c cVar = new c();
        this.f11138c.a(new o() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.5
            @Override // androidx.lifecycle.o
            public void g(@m0 q qVar, @m0 m.b bVar) {
                if (bVar == m.b.ON_DESTROY) {
                    handler.removeCallbacks(cVar);
                    qVar.getLifecycle().c(this);
                }
            }
        });
        handler.postDelayed(cVar, 10000L);
    }

    private void X(Fragment fragment, @m0 FrameLayout frameLayout) {
        this.f11139d.v1(new b(fragment, frameLayout), false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public final void D(boolean z7) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    void F(@m0 View view, @m0 FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (view.getParent() == frameLayout) {
            return;
        }
        if (frameLayout.getChildCount() > 0) {
            frameLayout.removeAllViews();
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        frameLayout.addView(view);
    }

    public boolean G(long j7) {
        return j7 >= 0 && j7 < ((long) e());
    }

    @m0
    public abstract Fragment H(int i7);

    void K() {
        if (!this.f11145j || Y()) {
            return;
        }
        androidx.collection.b bVar = new androidx.collection.b();
        for (int i7 = 0; i7 < this.f11140e.B(); i7++) {
            long jR = this.f11140e.r(i7);
            if (!G(jR)) {
                bVar.add(Long.valueOf(jR));
                this.f11142g.v(jR);
            }
        }
        if (!this.f11144i) {
            this.f11145j = false;
            for (int i8 = 0; i8 < this.f11140e.B(); i8++) {
                long jR2 = this.f11140e.r(i8);
                if (!L(jR2)) {
                    bVar.add(Long.valueOf(jR2));
                }
            }
        }
        Iterator<E> it = bVar.iterator();
        while (it.hasNext()) {
            V(((Long) it.next()).longValue());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public final void u(@m0 androidx.viewpager2.adapter.a aVar, int i7) {
        long jK = aVar.k();
        int id = aVar.P().getId();
        Long lN = N(id);
        if (lN != null && lN.longValue() != jK) {
            V(lN.longValue());
            this.f11142g.v(lN.longValue());
        }
        this.f11142g.s(jK, Integer.valueOf(id));
        J(i7);
        FrameLayout frameLayoutP = aVar.P();
        if (n2.O0(frameLayoutP)) {
            if (frameLayoutP.getParent() != null) {
                throw new IllegalStateException("Design assumption violated.");
            }
            frameLayoutP.addOnLayoutChangeListener(new a(frameLayoutP, aVar));
        }
        K();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    @m0
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public final androidx.viewpager2.adapter.a w(@m0 ViewGroup viewGroup, int i7) {
        return androidx.viewpager2.adapter.a.O(viewGroup);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public final boolean y(@m0 androidx.viewpager2.adapter.a aVar) {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public final void z(@m0 androidx.viewpager2.adapter.a aVar) {
        U(aVar);
        K();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public final void B(@m0 androidx.viewpager2.adapter.a aVar) {
        Long lN = N(aVar.P().getId());
        if (lN != null) {
            V(lN.longValue());
            this.f11142g.v(lN.longValue());
        }
    }

    void U(@m0 final androidx.viewpager2.adapter.a aVar) {
        Fragment fragmentM = this.f11140e.m(aVar.k());
        if (fragmentM == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        FrameLayout frameLayoutP = aVar.P();
        View view = fragmentM.getView();
        if (!fragmentM.isAdded() && view != null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (fragmentM.isAdded() && view == null) {
            X(fragmentM, frameLayoutP);
            return;
        }
        if (fragmentM.isAdded() && view.getParent() != null) {
            if (view.getParent() != frameLayoutP) {
                F(view, frameLayoutP);
                return;
            }
            return;
        }
        if (fragmentM.isAdded()) {
            F(view, frameLayoutP);
            return;
        }
        if (Y()) {
            if (this.f11139d.S0()) {
                return;
            }
            this.f11138c.a(new o() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.2
                @Override // androidx.lifecycle.o
                public void g(@m0 q qVar, @m0 m.b bVar) {
                    if (FragmentStateAdapter.this.Y()) {
                        return;
                    }
                    qVar.getLifecycle().c(this);
                    if (n2.O0(aVar.P())) {
                        FragmentStateAdapter.this.U(aVar);
                    }
                }
            });
            return;
        }
        X(fragmentM, frameLayoutP);
        this.f11139d.r().l(fragmentM, "f" + aVar.k()).P(fragmentM, m.c.STARTED).t();
        this.f11143h.d(false);
    }

    boolean Y() {
        return this.f11139d.Y0();
    }

    @Override // androidx.viewpager2.adapter.b
    @m0
    public final Parcelable a() {
        Bundle bundle = new Bundle(this.f11140e.B() + this.f11141f.B());
        for (int i7 = 0; i7 < this.f11140e.B(); i7++) {
            long jR = this.f11140e.r(i7);
            Fragment fragmentM = this.f11140e.m(jR);
            if (fragmentM != null && fragmentM.isAdded()) {
                this.f11139d.u1(bundle, I(f11135k, jR), fragmentM);
            }
        }
        for (int i8 = 0; i8 < this.f11141f.B(); i8++) {
            long jR2 = this.f11141f.r(i8);
            if (G(jR2)) {
                bundle.putParcelable(I(f11136l, jR2), this.f11141f.m(jR2));
            }
        }
        return bundle;
    }

    @Override // androidx.viewpager2.adapter.b
    public final void b(@m0 Parcelable parcelable) {
        if (!this.f11141f.q() || !this.f11140e.q()) {
            throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
        }
        Bundle bundle = (Bundle) parcelable;
        if (bundle.getClassLoader() == null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        for (String str : bundle.keySet()) {
            if (M(str, f11135k)) {
                this.f11140e.s(T(str, f11135k), this.f11139d.C0(bundle, str));
            } else {
                if (!M(str, f11136l)) {
                    throw new IllegalArgumentException("Unexpected key in savedState: " + str);
                }
                long jT = T(str, f11136l);
                Fragment.SavedState savedState = (Fragment.SavedState) bundle.getParcelable(str);
                if (G(jT)) {
                    this.f11141f.s(jT, savedState);
                }
            }
        }
        if (this.f11140e.q()) {
            return;
        }
        this.f11145j = true;
        this.f11144i = true;
        K();
        W();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long f(int i7) {
        return i7;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    @i
    public void t(@m0 RecyclerView recyclerView) {
        w.a(this.f11143h == null);
        FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer = new FragmentMaxLifecycleEnforcer();
        this.f11143h = fragmentMaxLifecycleEnforcer;
        fragmentMaxLifecycleEnforcer.b(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    @i
    public void x(@m0 RecyclerView recyclerView) {
        this.f11143h.c(recyclerView);
        this.f11143h = null;
    }

    public FragmentStateAdapter(@m0 Fragment fragment) {
        this(fragment.getChildFragmentManager(), fragment.getLifecycle());
    }

    public FragmentStateAdapter(@m0 FragmentManager fragmentManager, @m0 m mVar) {
        this.f11140e = new f<>();
        this.f11141f = new f<>();
        this.f11142g = new f<>();
        this.f11144i = false;
        this.f11145j = false;
        this.f11139d = fragmentManager;
        this.f11138c = mVar;
        super.D(true);
    }
}
