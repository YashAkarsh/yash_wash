package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.app.e7;
import androidx.lifecycle.p0;
import androidx.lifecycle.q0;
import c.b0;
import c.l0;
import c.m0;
import c.o0;
import c.x0;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class NavController {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f8757p = "NavController";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f8758q = "android-support-nav:controller:navigatorState";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f8759r = "android-support-nav:controller:navigatorState:names";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f8760s = "android-support-nav:controller:backStack";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    static final String f8761t = "android-support-nav:controller:deepLinkIds";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    static final String f8762u = "android-support-nav:controller:deepLinkExtras";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    static final String f8763v = "android-support-nav:controller:deepLinkHandled";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @m0
    public static final String f8764w = "android-support-nav:controller:deepLinkIntent";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Activity f8766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private s f8767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    n f8768d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Bundle f8769e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Parcelable[] f8770f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f8771g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private androidx.lifecycle.q f8773i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private h f8774j;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Deque<g> f8772h = new ArrayDeque();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private x f8775k = new x();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final CopyOnWriteArrayList<b> f8776l = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final androidx.lifecycle.p f8777m = new androidx.lifecycle.o() { // from class: androidx.navigation.NavController.1
        @Override // androidx.lifecycle.o
        public void g(@m0 androidx.lifecycle.q qVar, @m0 androidx.lifecycle.m.b bVar) {
            NavController navController = NavController.this;
            if (navController.f8768d != null) {
                Iterator<g> it = navController.f8772h.iterator();
                while (it.hasNext()) {
                    it.next().f(bVar);
                }
            }
        }
    };

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final androidx.activity.g f8778n = new a(false);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f8779o = true;

    class a extends androidx.activity.g {
        a(boolean z7) {
            super(z7);
        }

        @Override // androidx.activity.g
        public void b() {
            NavController.this.I();
        }
    }

    public interface b {
        void a(@m0 NavController navController, @m0 l lVar, @o0 Bundle bundle);
    }

    public NavController(@m0 Context context) {
        this.f8765a = context;
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                this.f8766b = (Activity) context;
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        x xVar = this.f8775k;
        xVar.a(new o(xVar));
        this.f8775k.a(new androidx.navigation.b(this.f8765a));
    }

    private void C(@m0 l lVar, @o0 Bundle bundle, @o0 t tVar, @o0 w.a aVar) {
        boolean z7 = false;
        boolean zK = (tVar == null || tVar.e() == -1) ? false : K(tVar.e(), tVar.f());
        w wVarE = this.f8775k.e(lVar.o());
        Bundle bundleF = lVar.f(bundle);
        l lVarB = wVarE.b(lVar, bundleF, tVar, aVar);
        if (lVarB != null) {
            if (!(lVarB instanceof c)) {
                while (!this.f8772h.isEmpty() && (this.f8772h.peekLast().b() instanceof c) && K(this.f8772h.peekLast().b().m(), true)) {
                }
            }
            if (this.f8772h.isEmpty()) {
                this.f8772h.add(new g(this.f8765a, this.f8768d, bundleF, this.f8773i, this.f8774j));
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            l lVarP = lVarB;
            while (lVarP != null && e(lVarP.m()) == null) {
                lVarP = lVarP.p();
                if (lVarP != null) {
                    arrayDeque.addFirst(new g(this.f8765a, lVarP, bundleF, this.f8773i, this.f8774j));
                }
            }
            this.f8772h.addAll(arrayDeque);
            this.f8772h.add(new g(this.f8765a, lVarB, lVarB.f(bundleF), this.f8773i, this.f8774j));
        } else if (tVar != null && tVar.g()) {
            g gVarPeekLast = this.f8772h.peekLast();
            if (gVarPeekLast != null) {
                gVarPeekLast.g(bundle);
            }
            z7 = true;
        }
        W();
        if (zK || lVarB != null || z7) {
            c();
        }
    }

    private void H(@o0 Bundle bundle) {
        Activity activity;
        ArrayList<String> stringArrayList;
        Bundle bundle2 = this.f8769e;
        if (bundle2 != null && (stringArrayList = bundle2.getStringArrayList(f8759r)) != null) {
            for (String str : stringArrayList) {
                w wVarE = this.f8775k.e(str);
                Bundle bundle3 = this.f8769e.getBundle(str);
                if (bundle3 != null) {
                    wVarE.c(bundle3);
                }
            }
        }
        Parcelable[] parcelableArr = this.f8770f;
        boolean z7 = false;
        if (parcelableArr != null) {
            for (Parcelable parcelable : parcelableArr) {
                NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) parcelable;
                l lVarE = e(navBackStackEntryState.b());
                if (lVarE == null) {
                    throw new IllegalStateException("Restoring the Navigation back stack failed: destination " + l.l(this.f8765a, navBackStackEntryState.b()) + " cannot be found from the current destination " + k());
                }
                Bundle bundleA = navBackStackEntryState.a();
                if (bundleA != null) {
                    bundleA.setClassLoader(this.f8765a.getClassLoader());
                }
                this.f8772h.add(new g(this.f8765a, lVarE, bundleA, this.f8773i, this.f8774j, navBackStackEntryState.e(), navBackStackEntryState.d()));
            }
            W();
            this.f8770f = null;
        }
        if (this.f8768d == null || !this.f8772h.isEmpty()) {
            c();
            return;
        }
        if (!this.f8771g && (activity = this.f8766b) != null && r(activity.getIntent())) {
            z7 = true;
        }
        if (z7) {
            return;
        }
        C(this.f8768d, bundle, null, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x000e  */
    private void W() {
        boolean z7;
        androidx.activity.g gVar = this.f8778n;
        if (this.f8779o) {
            z7 = l() > 1;
        }
        gVar.f(z7);
    }

    private boolean c() {
        l lVarP;
        while (!this.f8772h.isEmpty() && (this.f8772h.peekLast().b() instanceof n) && K(this.f8772h.peekLast().b().m(), true)) {
        }
        if (this.f8772h.isEmpty()) {
            return false;
        }
        l lVarB = this.f8772h.peekLast().b();
        if (!(lVarB instanceof c)) {
            lVarP = null;
            break;
        }
        Iterator<g> itDescendingIterator = this.f8772h.descendingIterator();
        while (true) {
            if (!itDescendingIterator.hasNext()) {
                lVarP = null;
                break;
            }
            lVarP = itDescendingIterator.next().b();
            if (!(lVarP instanceof n) && !(lVarP instanceof c)) {
                break;
            }
        }
        HashMap map = new HashMap();
        Iterator<g> itDescendingIterator2 = this.f8772h.descendingIterator();
        while (itDescendingIterator2.hasNext()) {
            g next = itDescendingIterator2.next();
            androidx.lifecycle.m.c cVarC = next.c();
            l lVarB2 = next.b();
            if (lVarB != null && lVarB2.m() == lVarB.m()) {
                androidx.lifecycle.m.c cVar = androidx.lifecycle.m.c.RESUMED;
                if (cVarC != cVar) {
                    map.put(next, cVar);
                }
                lVarB = lVarB.p();
            } else if (lVarP == null || lVarB2.m() != lVarP.m()) {
                next.i(androidx.lifecycle.m.c.CREATED);
            } else {
                if (cVarC == androidx.lifecycle.m.c.RESUMED) {
                    next.i(androidx.lifecycle.m.c.STARTED);
                } else {
                    androidx.lifecycle.m.c cVar2 = androidx.lifecycle.m.c.STARTED;
                    if (cVarC != cVar2) {
                        map.put(next, cVar2);
                    }
                }
                lVarP = lVarP.p();
            }
        }
        for (g gVar : this.f8772h) {
            androidx.lifecycle.m.c cVar3 = (androidx.lifecycle.m.c) map.get(gVar);
            if (cVar3 != null) {
                gVar.i(cVar3);
            } else {
                gVar.j();
            }
        }
        g gVarPeekLast = this.f8772h.peekLast();
        Iterator<b> it = this.f8776l.iterator();
        while (it.hasNext()) {
            it.next().a(this, gVarPeekLast.b(), gVarPeekLast.a());
        }
        return true;
    }

    @o0
    private String f(@m0 int[] iArr) {
        n nVar;
        n nVar2 = this.f8768d;
        int i7 = 0;
        while (true) {
            l lVarL = null;
            if (i7 >= iArr.length) {
                return null;
            }
            int i8 = iArr[i7];
            if (i7 != 0) {
                lVarL = nVar2.L(i8);
            } else if (this.f8768d.m() == i8) {
                lVarL = this.f8768d;
            }
            if (lVarL == null) {
                return l.l(this.f8765a, i8);
            }
            if (i7 != iArr.length - 1) {
                while (true) {
                    nVar = (n) lVarL;
                    if (!(nVar.L(nVar.O()) instanceof n)) {
                        break;
                    }
                    lVarL = nVar.L(nVar.O());
                }
                nVar2 = nVar;
            }
            i7++;
        }
    }

    private int l() {
        Iterator<g> it = this.f8772h.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            if (!(it.next().b() instanceof n)) {
                i7++;
            }
        }
        return i7;
    }

    public void A(@m0 k kVar, @o0 t tVar) {
        B(kVar, tVar, null);
    }

    public void B(@m0 k kVar, @o0 t tVar, @o0 w.a aVar) {
        l.b bVarT = this.f8768d.t(kVar);
        if (bVarT != null) {
            C(bVarT.b(), bVarT.c(), tVar, aVar);
            return;
        }
        throw new IllegalArgumentException("Navigation destination that matches request " + kVar + " cannot be found in the navigation graph " + this.f8768d);
    }

    public void D(@m0 m mVar) {
        t(mVar.e(), mVar.d());
    }

    public void E(@m0 m mVar, @o0 t tVar) {
        u(mVar.e(), mVar.d(), tVar);
    }

    public void F(@m0 m mVar, @m0 w.a aVar) {
        v(mVar.e(), mVar.d(), null, aVar);
    }

    public boolean G() {
        if (l() != 1) {
            return I();
        }
        l lVarK = k();
        int iM = lVarK.m();
        for (n nVarP = lVarK.p(); nVarP != null; nVarP = nVarP.p()) {
            if (nVarP.O() != iM) {
                Bundle bundle = new Bundle();
                Activity activity = this.f8766b;
                if (activity != null && activity.getIntent() != null && this.f8766b.getIntent().getData() != null) {
                    bundle.putParcelable(f8764w, this.f8766b.getIntent());
                    l.b bVarT = this.f8768d.t(new k(this.f8766b.getIntent()));
                    if (bVarT != null) {
                        bundle.putAll(bVarT.c());
                    }
                }
                new j(this).g(nVarP.m()).d(bundle).b().r();
                Activity activity2 = this.f8766b;
                if (activity2 != null) {
                    activity2.finish();
                }
                return true;
            }
            iM = nVarP.m();
        }
        return false;
    }

    public boolean I() {
        if (this.f8772h.isEmpty()) {
            return false;
        }
        return J(k().m(), true);
    }

    public boolean J(@b0 int i7, boolean z7) {
        return K(i7, z7) && c();
    }

    boolean K(@b0 int i7, boolean z7) {
        boolean z8;
        boolean z9 = false;
        if (this.f8772h.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<g> itDescendingIterator = this.f8772h.descendingIterator();
        while (true) {
            if (!itDescendingIterator.hasNext()) {
                z8 = false;
                break;
            }
            l lVarB = itDescendingIterator.next().b();
            w wVarE = this.f8775k.e(lVarB.o());
            if (z7 || lVarB.m() != i7) {
                arrayList.add(wVarE);
            }
            if (lVarB.m() == i7) {
                z8 = true;
                break;
            }
        }
        if (!z8) {
            Log.i(f8757p, "Ignoring popBackStack to destination " + l.l(this.f8765a, i7) + " as it was not found on the current back stack");
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext() && ((w) it.next()).e()) {
            g gVarRemoveLast = this.f8772h.removeLast();
            gVarRemoveLast.i(androidx.lifecycle.m.c.DESTROYED);
            h hVar = this.f8774j;
            if (hVar != null) {
                hVar.g(gVarRemoveLast.f8838f);
            }
            z9 = true;
        }
        W();
        return z9;
    }

    public void L(@m0 b bVar) {
        this.f8776l.remove(bVar);
    }

    @c.i
    public void M(@o0 Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(this.f8765a.getClassLoader());
        this.f8769e = bundle.getBundle(f8758q);
        this.f8770f = bundle.getParcelableArray(f8760s);
        this.f8771g = bundle.getBoolean(f8763v);
    }

    @o0
    @c.i
    public Bundle N() {
        Bundle bundle;
        ArrayList<String> arrayList = new ArrayList<>();
        Bundle bundle2 = new Bundle();
        for (Map.Entry<String, w<? extends l>> entry : this.f8775k.f().entrySet()) {
            String key = entry.getKey();
            Bundle bundleD = entry.getValue().d();
            if (bundleD != null) {
                arrayList.add(key);
                bundle2.putBundle(key, bundleD);
            }
        }
        if (arrayList.isEmpty()) {
            bundle = null;
        } else {
            bundle = new Bundle();
            bundle2.putStringArrayList(f8759r, arrayList);
            bundle.putBundle(f8758q, bundle2);
        }
        if (!this.f8772h.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Parcelable[] parcelableArr = new Parcelable[this.f8772h.size()];
            Iterator<g> it = this.f8772h.iterator();
            int i7 = 0;
            while (it.hasNext()) {
                parcelableArr[i7] = new NavBackStackEntryState(it.next());
                i7++;
            }
            bundle.putParcelableArray(f8760s, parcelableArr);
        }
        if (this.f8771g) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean(f8763v, this.f8771g);
        }
        return bundle;
    }

    @c.i
    public void O(@l0 int i7) {
        P(i7, null);
    }

    @c.i
    public void P(@l0 int i7, @o0 Bundle bundle) {
        R(n().c(i7), bundle);
    }

    @c.i
    public void Q(@m0 n nVar) {
        R(nVar, null);
    }

    @c.i
    public void R(@m0 n nVar, @o0 Bundle bundle) {
        n nVar2 = this.f8768d;
        if (nVar2 != null) {
            K(nVar2.m(), true);
        }
        this.f8768d = nVar;
        H(bundle);
    }

    void S(@m0 androidx.lifecycle.q qVar) {
        this.f8773i = qVar;
        qVar.getLifecycle().a(this.f8777m);
    }

    @x0({x0.a.LIBRARY_GROUP})
    public void T(@m0 x xVar) {
        if (!this.f8772h.isEmpty()) {
            throw new IllegalStateException("NavigatorProvider must be set before setGraph call");
        }
        this.f8775k = xVar;
    }

    void U(@m0 OnBackPressedDispatcher onBackPressedDispatcher) {
        if (this.f8773i == null) {
            throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()");
        }
        this.f8778n.d();
        onBackPressedDispatcher.b(this.f8773i, this.f8778n);
    }

    void V(@m0 p0 p0Var) {
        if (!this.f8772h.isEmpty()) {
            throw new IllegalStateException("ViewModelStore should be set before setGraph call");
        }
        this.f8774j = h.h(p0Var);
    }

    public void a(@m0 b bVar) {
        if (!this.f8772h.isEmpty()) {
            g gVarPeekLast = this.f8772h.peekLast();
            bVar.a(this, gVarPeekLast.b(), gVarPeekLast.a());
        }
        this.f8776l.add(bVar);
    }

    @m0
    public j b() {
        return new j(this);
    }

    void d(boolean z7) {
        this.f8779o = z7;
        W();
    }

    l e(@b0 int i7) {
        n nVar = this.f8768d;
        if (nVar == null) {
            return null;
        }
        if (nVar.m() == i7) {
            return this.f8768d;
        }
        n nVarB = this.f8772h.isEmpty() ? this.f8768d : this.f8772h.getLast().b();
        return (nVarB instanceof n ? nVarB : nVarB.p()).L(i7);
    }

    @x0({x0.a.LIBRARY_GROUP})
    @m0
    public Deque<g> g() {
        return this.f8772h;
    }

    @m0
    public g h(@b0 int i7) {
        g next;
        Iterator<g> itDescendingIterator = this.f8772h.descendingIterator();
        do {
            if (!itDescendingIterator.hasNext()) {
                next = null;
                break;
            }
            next = itDescendingIterator.next();
        } while (next.b().m() != i7);
        if (next != null) {
            return next;
        }
        throw new IllegalArgumentException("No destination with ID " + i7 + " is on the NavController's back stack");
    }

    @m0
    Context i() {
        return this.f8765a;
    }

    @o0
    public g j() {
        if (this.f8772h.isEmpty()) {
            return null;
        }
        return this.f8772h.getLast();
    }

    @o0
    public l k() {
        g gVarJ = j();
        if (gVarJ != null) {
            return gVarJ.b();
        }
        return null;
    }

    @m0
    public n m() {
        n nVar = this.f8768d;
        if (nVar != null) {
            return nVar;
        }
        throw new IllegalStateException("You must call setGraph() before calling getGraph()");
    }

    @m0
    public s n() {
        if (this.f8767c == null) {
            this.f8767c = new s(this.f8765a, this.f8775k);
        }
        return this.f8767c;
    }

    @m0
    public x o() {
        return this.f8775k;
    }

    @o0
    public g p() {
        Iterator<g> itDescendingIterator = this.f8772h.descendingIterator();
        if (itDescendingIterator.hasNext()) {
            itDescendingIterator.next();
        }
        while (itDescendingIterator.hasNext()) {
            g next = itDescendingIterator.next();
            if (!(next.b() instanceof n)) {
                return next;
            }
        }
        return null;
    }

    @m0
    public q0 q(@b0 int i7) {
        if (this.f8774j == null) {
            throw new IllegalStateException("You must call setViewModelStore() before calling getViewModelStoreOwner().");
        }
        g gVarH = h(i7);
        if (gVarH.b() instanceof n) {
            return gVarH;
        }
        throw new IllegalArgumentException("No NavGraph with ID " + i7 + " is on the NavController's back stack");
    }

    public boolean r(@o0 Intent intent) {
        l.b bVarT;
        n nVar;
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        int[] intArray = extras != null ? extras.getIntArray(f8761t) : null;
        Bundle bundle = new Bundle();
        Bundle bundle2 = extras != null ? extras.getBundle(f8762u) : null;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if ((intArray == null || intArray.length == 0) && intent.getData() != null && (bVarT = this.f8768d.t(new k(intent))) != null) {
            intArray = bVarT.b().g();
            bundle.putAll(bVarT.c());
        }
        if (intArray == null || intArray.length == 0) {
            return false;
        }
        String strF = f(intArray);
        if (strF != null) {
            Log.i(f8757p, "Could not find destination " + strF + " in the navigation graph, ignoring the deep link from " + intent);
            return false;
        }
        bundle.putParcelable(f8764w, intent);
        int flags = intent.getFlags();
        int i7 = 268435456 & flags;
        if (i7 != 0 && (flags & 32768) == 0) {
            intent.addFlags(32768);
            e7.h(this.f8765a).b(intent).r();
            Activity activity = this.f8766b;
            if (activity != null) {
                activity.finish();
                this.f8766b.overridePendingTransition(0, 0);
            }
            return true;
        }
        if (i7 != 0) {
            if (!this.f8772h.isEmpty()) {
                K(this.f8768d.m(), true);
            }
            int i8 = 0;
            while (i8 < intArray.length) {
                int i9 = i8 + 1;
                int i10 = intArray[i8];
                l lVarE = e(i10);
                if (lVarE == null) {
                    throw new IllegalStateException("Deep Linking failed: destination " + l.l(this.f8765a, i10) + " cannot be found from the current destination " + k());
                }
                C(lVarE, bundle, new t.a().b(0).c(0).a(), null);
                i8 = i9;
            }
            return true;
        }
        n nVar2 = this.f8768d;
        int i11 = 0;
        while (i11 < intArray.length) {
            int i12 = intArray[i11];
            l lVarL = i11 == 0 ? this.f8768d : nVar2.L(i12);
            if (lVarL == null) {
                throw new IllegalStateException("Deep Linking failed: destination " + l.l(this.f8765a, i12) + " cannot be found in graph " + nVar2);
            }
            if (i11 != intArray.length - 1) {
                while (true) {
                    nVar = (n) lVarL;
                    if (!(nVar.L(nVar.O()) instanceof n)) {
                        break;
                    }
                    lVarL = nVar.L(nVar.O());
                }
                nVar2 = nVar;
            } else {
                C(lVarL, lVarL.f(bundle), new t.a().g(this.f8768d.m(), true).b(0).c(0).a(), null);
            }
            i11++;
        }
        this.f8771g = true;
        return true;
    }

    public void s(@b0 int i7) {
        t(i7, null);
    }

    public void t(@b0 int i7, @o0 Bundle bundle) {
        u(i7, bundle, null);
    }

    public void u(@b0 int i7, @o0 Bundle bundle, @o0 t tVar) {
        v(i7, bundle, tVar, null);
    }

    public void v(@b0 int i7, @o0 Bundle bundle, @o0 t tVar, @o0 w.a aVar) {
        int iB;
        l lVarB = this.f8772h.isEmpty() ? this.f8768d : this.f8772h.getLast().b();
        if (lVarB == null) {
            throw new IllegalStateException("no current navigation node");
        }
        d dVarH = lVarB.h(i7);
        Bundle bundle2 = null;
        if (dVarH != null) {
            if (tVar == null) {
                tVar = dVarH.c();
            }
            iB = dVarH.b();
            Bundle bundleA = dVarH.a();
            if (bundleA != null) {
                bundle2 = new Bundle();
                bundle2.putAll(bundleA);
            }
        } else {
            iB = i7;
        }
        if (bundle != null) {
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            bundle2.putAll(bundle);
        }
        if (iB == 0 && tVar != null && tVar.e() != -1) {
            J(tVar.e(), tVar.f());
            return;
        }
        if (iB == 0) {
            throw new IllegalArgumentException("Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo");
        }
        l lVarE = e(iB);
        if (lVarE != null) {
            C(lVarE, bundle2, tVar, aVar);
            return;
        }
        String strL = l.l(this.f8765a, iB);
        if (dVarH == null) {
            throw new IllegalArgumentException("Navigation action/destination " + strL + " cannot be found from the current destination " + lVarB);
        }
        throw new IllegalArgumentException("Navigation destination " + strL + " referenced from action " + l.l(this.f8765a, i7) + " cannot be found from the current destination " + lVarB);
    }

    public void w(@m0 Uri uri) {
        z(new k(uri, null, null));
    }

    public void x(@m0 Uri uri, @o0 t tVar) {
        A(new k(uri, null, null), tVar);
    }

    public void y(@m0 Uri uri, @o0 t tVar, @o0 w.a aVar) {
        B(new k(uri, null, null), tVar, aVar);
    }

    public void z(@m0 k kVar) {
        A(kVar, null);
    }
}
