package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.n2;
import androidx.fragment.R;
import c.m0;
import c.o0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewGroup f7952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ArrayList<e> f7953b = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ArrayList<e> f7954c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f7955d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f7956e = false;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f7957a;

        a(d dVar) {
            this.f7957a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c0.this.f7953b.contains(this.f7957a)) {
                this.f7957a.e().a(this.f7957a.f().mView);
            }
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f7959a;

        b(d dVar) {
            this.f7959a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.f7953b.remove(this.f7959a);
            c0.this.f7954c.remove(this.f7959a);
        }
    }

    static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7961a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f7962b;

        static {
            int[] iArr = new int[e.b.values().length];
            f7962b = iArr;
            try {
                iArr[e.b.ADDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7962b[e.b.REMOVING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7962b[e.b.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[e.c.values().length];
            f7961a = iArr2;
            try {
                iArr2[e.c.REMOVED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7961a[e.c.VISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7961a[e.c.GONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7961a[e.c.INVISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private static class d extends e {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @m0
        private final r f7963h;

        d(@m0 e.c cVar, @m0 e.b bVar, @m0 r rVar, @m0 androidx.core.os.e eVar) {
            super(cVar, bVar, rVar.k(), eVar);
            this.f7963h = rVar;
        }

        @Override // androidx.fragment.app.c0.e
        public void c() {
            super.c();
            this.f7963h.m();
        }

        @Override // androidx.fragment.app.c0.e
        void l() {
            if (g() == e.b.ADDING) {
                Fragment fragmentK = this.f7963h.k();
                View viewFindFocus = fragmentK.mView.findFocus();
                if (viewFindFocus != null) {
                    fragmentK.setFocusedView(viewFindFocus);
                    if (FragmentManager.T0(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + fragmentK);
                    }
                }
                View viewRequireView = f().requireView();
                if (viewRequireView.getParent() == null) {
                    this.f7963h.b();
                    viewRequireView.setAlpha(0.0f);
                }
                if (viewRequireView.getAlpha() == 0.0f && viewRequireView.getVisibility() == 0) {
                    viewRequireView.setVisibility(4);
                }
                viewRequireView.setAlpha(fragmentK.getPostOnViewCreatedAlpha());
            }
        }
    }

    static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m0
        private c f7964a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @m0
        private b f7965b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @m0
        private final Fragment f7966c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @m0
        private final List<Runnable> f7967d = new ArrayList();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @m0
        private final HashSet<androidx.core.os.e> f7968e = new HashSet<>();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f7969f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f7970g = false;

        class a implements androidx.core.os.e.b {
            a() {
            }

            @Override // androidx.core.os.e.b
            public void onCancel() {
                e.this.b();
            }
        }

        enum b {
            NONE,
            ADDING,
            REMOVING
        }

        enum c {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            @m0
            static c b(int i7) {
                if (i7 == 0) {
                    return VISIBLE;
                }
                if (i7 == 4) {
                    return INVISIBLE;
                }
                if (i7 == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException("Unknown visibility " + i7);
            }

            @m0
            static c c(@m0 View view) {
                return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? INVISIBLE : b(view.getVisibility());
            }

            void a(@m0 View view) {
                int i7 = c.f7961a[ordinal()];
                if (i7 == 1) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (FragmentManager.T0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (i7 == 2) {
                    if (FragmentManager.T0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    view.setVisibility(0);
                    return;
                }
                if (i7 == 3) {
                    if (FragmentManager.T0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                    return;
                }
                if (i7 != 4) {
                    return;
                }
                if (FragmentManager.T0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                }
                view.setVisibility(4);
            }
        }

        e(@m0 c cVar, @m0 b bVar, @m0 Fragment fragment, @m0 androidx.core.os.e eVar) {
            this.f7964a = cVar;
            this.f7965b = bVar;
            this.f7966c = fragment;
            eVar.d(new a());
        }

        final void a(@m0 Runnable runnable) {
            this.f7967d.add(runnable);
        }

        final void b() {
            if (h()) {
                return;
            }
            this.f7969f = true;
            if (this.f7968e.isEmpty()) {
                c();
                return;
            }
            Iterator it = new ArrayList(this.f7968e).iterator();
            while (it.hasNext()) {
                ((androidx.core.os.e) it.next()).a();
            }
        }

        @c.i
        public void c() {
            if (this.f7970g) {
                return;
            }
            if (FragmentManager.T0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f7970g = true;
            Iterator<Runnable> it = this.f7967d.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }

        public final void d(@m0 androidx.core.os.e eVar) {
            if (this.f7968e.remove(eVar) && this.f7968e.isEmpty()) {
                c();
            }
        }

        @m0
        public c e() {
            return this.f7964a;
        }

        @m0
        public final Fragment f() {
            return this.f7966c;
        }

        @m0
        b g() {
            return this.f7965b;
        }

        final boolean h() {
            return this.f7969f;
        }

        final boolean i() {
            return this.f7970g;
        }

        public final void j(@m0 androidx.core.os.e eVar) {
            l();
            this.f7968e.add(eVar);
        }

        final void k(@m0 c cVar, @m0 b bVar) {
            int i7 = c.f7962b[bVar.ordinal()];
            if (i7 == 1) {
                if (this.f7964a == c.REMOVED) {
                    if (FragmentManager.T0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f7966c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f7965b + " to ADDING.");
                    }
                    this.f7964a = c.VISIBLE;
                    this.f7965b = b.ADDING;
                    return;
                }
                return;
            }
            if (i7 == 2) {
                if (FragmentManager.T0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f7966c + " mFinalState = " + this.f7964a + " -> REMOVED. mLifecycleImpact  = " + this.f7965b + " to REMOVING.");
                }
                this.f7964a = c.REMOVED;
                this.f7965b = b.REMOVING;
                return;
            }
            if (i7 == 3 && this.f7964a != c.REMOVED) {
                if (FragmentManager.T0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f7966c + " mFinalState = " + this.f7964a + " -> " + cVar + ". ");
                }
                this.f7964a = cVar;
            }
        }

        void l() {
        }

        @m0
        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.f7964a + "} {mLifecycleImpact = " + this.f7965b + "} {mFragment = " + this.f7966c + com.alipay.sdk.util.j.f13808d;
        }
    }

    c0(@m0 ViewGroup viewGroup) {
        this.f7952a = viewGroup;
    }

    private void a(@m0 e.c cVar, @m0 e.b bVar, @m0 r rVar) {
        synchronized (this.f7953b) {
            androidx.core.os.e eVar = new androidx.core.os.e();
            e eVarH = h(rVar.k());
            if (eVarH != null) {
                eVarH.k(cVar, bVar);
                return;
            }
            d dVar = new d(cVar, bVar, rVar, eVar);
            this.f7953b.add(dVar);
            dVar.a(new a(dVar));
            dVar.a(new b(dVar));
        }
    }

    @o0
    private e h(@m0 Fragment fragment) {
        for (e eVar : this.f7953b) {
            if (eVar.f().equals(fragment) && !eVar.h()) {
                return eVar;
            }
        }
        return null;
    }

    @o0
    private e i(@m0 Fragment fragment) {
        for (e eVar : this.f7954c) {
            if (eVar.f().equals(fragment) && !eVar.h()) {
                return eVar;
            }
        }
        return null;
    }

    @m0
    static c0 n(@m0 ViewGroup viewGroup, @m0 FragmentManager fragmentManager) {
        return o(viewGroup, fragmentManager.M0());
    }

    @m0
    static c0 o(@m0 ViewGroup viewGroup, @m0 d0 d0Var) {
        Object tag = viewGroup.getTag(R.id.special_effects_controller_view_tag);
        if (tag instanceof c0) {
            return (c0) tag;
        }
        c0 c0VarA = d0Var.a(viewGroup);
        viewGroup.setTag(R.id.special_effects_controller_view_tag, c0VarA);
        return c0VarA;
    }

    private void q() {
        for (e eVar : this.f7953b) {
            if (eVar.g() == e.b.ADDING) {
                eVar.k(e.c.b(eVar.f().requireView().getVisibility()), e.b.NONE);
            }
        }
    }

    void b(@m0 e.c cVar, @m0 r rVar) {
        if (FragmentManager.T0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + rVar.k());
        }
        a(cVar, e.b.ADDING, rVar);
    }

    void c(@m0 r rVar) {
        if (FragmentManager.T0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + rVar.k());
        }
        a(e.c.GONE, e.b.NONE, rVar);
    }

    void d(@m0 r rVar) {
        if (FragmentManager.T0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + rVar.k());
        }
        a(e.c.REMOVED, e.b.REMOVING, rVar);
    }

    void e(@m0 r rVar) {
        if (FragmentManager.T0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + rVar.k());
        }
        a(e.c.VISIBLE, e.b.NONE, rVar);
    }

    abstract void f(@m0 List<e> list, boolean z7);

    void g() {
        if (this.f7956e) {
            return;
        }
        if (!n2.O0(this.f7952a)) {
            j();
            this.f7955d = false;
            return;
        }
        synchronized (this.f7953b) {
            if (!this.f7953b.isEmpty()) {
                ArrayList<e> arrayList = new ArrayList(this.f7954c);
                this.f7954c.clear();
                for (e eVar : arrayList) {
                    if (FragmentManager.T0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + eVar);
                    }
                    eVar.b();
                    if (!eVar.i()) {
                        this.f7954c.add(eVar);
                    }
                }
                q();
                ArrayList arrayList2 = new ArrayList(this.f7953b);
                this.f7953b.clear();
                this.f7954c.addAll(arrayList2);
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((e) it.next()).l();
                }
                f(arrayList2, this.f7955d);
                this.f7955d = false;
            }
        }
    }

    void j() {
        boolean zO0 = n2.O0(this.f7952a);
        synchronized (this.f7953b) {
            q();
            Iterator<e> it = this.f7953b.iterator();
            while (it.hasNext()) {
                it.next().l();
            }
            for (e eVar : new ArrayList(this.f7954c)) {
                if (FragmentManager.T0(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SpecialEffectsController: ");
                    sb.append(zO0 ? "" : "Container " + this.f7952a + " is not attached to window. ");
                    sb.append("Cancelling running operation ");
                    sb.append(eVar);
                    Log.v("FragmentManager", sb.toString());
                }
                eVar.b();
            }
            for (e eVar2 : new ArrayList(this.f7953b)) {
                if (FragmentManager.T0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    sb2.append(zO0 ? "" : "Container " + this.f7952a + " is not attached to window. ");
                    sb2.append("Cancelling pending operation ");
                    sb2.append(eVar2);
                    Log.v("FragmentManager", sb2.toString());
                }
                eVar2.b();
            }
        }
    }

    void k() {
        if (this.f7956e) {
            this.f7956e = false;
            g();
        }
    }

    @o0
    e.b l(@m0 r rVar) {
        e eVarH = h(rVar.k());
        e.b bVarG = eVarH != null ? eVarH.g() : null;
        e eVarI = i(rVar.k());
        return (eVarI == null || !(bVarG == null || bVarG == e.b.NONE)) ? bVarG : eVarI.g();
    }

    @m0
    public ViewGroup m() {
        return this.f7952a;
    }

    void p() {
        synchronized (this.f7953b) {
            q();
            this.f7956e = false;
            for (int size = this.f7953b.size() - 1; size >= 0; size--) {
                e eVar = this.f7953b.get(size);
                e.c cVarC = e.c.c(eVar.f().mView);
                e.c cVarE = eVar.e();
                e.c cVar = e.c.VISIBLE;
                if (cVarE == cVar && cVarC != cVar) {
                    this.f7956e = eVar.f().isPostponed();
                    break;
                }
            }
        }
    }

    void r(boolean z7) {
        this.f7955d = z7;
    }
}
