package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.fragment.R;
import androidx.lifecycle.p0;
import androidx.lifecycle.q0;
import c.a1;
import c.j0;
import c.m0;
import c.o0;
import c.x0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentManager implements androidx.fragment.app.q {
    private static boolean O = false;
    static final String P = "FragmentManager";
    static boolean Q = true;
    public static final int R = 1;
    private static final String S = "androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE";
    private androidx.activity.result.c<IntentSenderRequest> A;
    private androidx.activity.result.c<String[]> B;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private ArrayList<androidx.fragment.app.a> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private ArrayList<Boolean> f7794J;
    private ArrayList<Fragment> K;
    private ArrayList<r> L;
    private androidx.fragment.app.m M;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f7796b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ArrayList<androidx.fragment.app.a> f7798d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayList<Fragment> f7799e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private OnBackPressedDispatcher f7801g;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ArrayList<o> f7806l;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private androidx.fragment.app.h<?> f7812r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private androidx.fragment.app.e f7813s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Fragment f7814t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @o0
    Fragment f7815u;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private androidx.activity.result.c<Intent> f7820z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<p> f7795a = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final u f7797c = new u();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final androidx.fragment.app.i f7800f = new androidx.fragment.app.i(this);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final androidx.activity.g f7802h = new c(false);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicInteger f7803i = new AtomicInteger();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map<String, Bundle> f7804j = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Map<String, n> f7805k = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Map<Fragment, HashSet<androidx.core.os.e>> f7807m = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final w.g f7808n = new d();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final androidx.fragment.app.j f7809o = new androidx.fragment.app.j(this);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final CopyOnWriteArrayList<androidx.fragment.app.n> f7810p = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f7811q = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private androidx.fragment.app.g f7816v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private androidx.fragment.app.g f7817w = new e();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private d0 f7818x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private d0 f7819y = new f();
    ArrayDeque<LaunchedFragmentInfo> C = new ArrayDeque<>();
    private Runnable N = new g();

    class a implements androidx.activity.result.a<ActivityResult> {
        a() {
        }

        @Override // androidx.activity.result.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ActivityResult activityResult) {
            LaunchedFragmentInfo launchedFragmentInfoPollFirst = FragmentManager.this.C.pollFirst();
            if (launchedFragmentInfoPollFirst == null) {
                Log.w(FragmentManager.P, "No IntentSenders were started for " + this);
                return;
            }
            String str = launchedFragmentInfoPollFirst.f7825a;
            int i7 = launchedFragmentInfoPollFirst.f7826b;
            Fragment fragmentI = FragmentManager.this.f7797c.i(str);
            if (fragmentI != null) {
                fragmentI.onActivityResult(i7, activityResult.b(), activityResult.a());
                return;
            }
            Log.w(FragmentManager.P, "Intent Sender result delivered for unknown Fragment " + str);
        }
    }

    class b implements androidx.activity.result.a<Map<String, Boolean>> {
        b() {
        }

        @Override // androidx.activity.result.a
        @SuppressLint({"SyntheticAccessor"})
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Map<String, Boolean> map) {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                iArr[i7] = ((Boolean) arrayList.get(i7)).booleanValue() ? 0 : -1;
            }
            LaunchedFragmentInfo launchedFragmentInfoPollFirst = FragmentManager.this.C.pollFirst();
            if (launchedFragmentInfoPollFirst == null) {
                Log.w(FragmentManager.P, "No permissions were requested for " + this);
                return;
            }
            String str = launchedFragmentInfoPollFirst.f7825a;
            int i8 = launchedFragmentInfoPollFirst.f7826b;
            Fragment fragmentI = FragmentManager.this.f7797c.i(str);
            if (fragmentI != null) {
                fragmentI.onRequestPermissionsResult(i8, strArr, iArr);
                return;
            }
            Log.w(FragmentManager.P, "Permission request result delivered for unknown Fragment " + str);
        }
    }

    class c extends androidx.activity.g {
        c(boolean z7) {
            super(z7);
        }

        @Override // androidx.activity.g
        public void b() {
            FragmentManager.this.P0();
        }
    }

    class d implements w.g {
        d() {
        }

        @Override // androidx.fragment.app.w.g
        public void a(@m0 Fragment fragment, @m0 androidx.core.os.e eVar) {
            if (eVar.c()) {
                return;
            }
            FragmentManager.this.w1(fragment, eVar);
        }

        @Override // androidx.fragment.app.w.g
        public void b(@m0 Fragment fragment, @m0 androidx.core.os.e eVar) {
            FragmentManager.this.j(fragment, eVar);
        }
    }

    class e extends androidx.fragment.app.g {
        e() {
        }

        @Override // androidx.fragment.app.g
        @m0
        public Fragment a(@m0 ClassLoader classLoader, @m0 String str) {
            return FragmentManager.this.H0().b(FragmentManager.this.H0().f(), str, null);
        }
    }

    class f implements d0 {
        f() {
        }

        @Override // androidx.fragment.app.d0
        @m0
        public c0 a(@m0 ViewGroup viewGroup) {
            return new androidx.fragment.app.b(viewGroup);
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentManager.this.h0(true);
        }
    }

    class h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f7834a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f7835b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Fragment f7836c;

        h(ViewGroup viewGroup, View view, Fragment fragment) {
            this.f7834a = viewGroup;
            this.f7835b = view;
            this.f7836c = fragment;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f7834a.endViewTransition(this.f7835b);
            animator.removeListener(this);
            Fragment fragment = this.f7836c;
            View view = fragment.mView;
            if (view == null || !fragment.mHidden) {
                return;
            }
            view.setVisibility(8);
        }
    }

    class i implements androidx.fragment.app.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Fragment f7838a;

        i(Fragment fragment) {
            this.f7838a = fragment;
        }

        @Override // androidx.fragment.app.n
        public void a(@m0 FragmentManager fragmentManager, @m0 Fragment fragment) {
            this.f7838a.onAttachFragment(fragment);
        }
    }

    class j implements androidx.activity.result.a<ActivityResult> {
        j() {
        }

        @Override // androidx.activity.result.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ActivityResult activityResult) {
            LaunchedFragmentInfo launchedFragmentInfoPollFirst = FragmentManager.this.C.pollFirst();
            if (launchedFragmentInfoPollFirst == null) {
                Log.w(FragmentManager.P, "No Activities were started for result for " + this);
                return;
            }
            String str = launchedFragmentInfoPollFirst.f7825a;
            int i7 = launchedFragmentInfoPollFirst.f7826b;
            Fragment fragmentI = FragmentManager.this.f7797c.i(str);
            if (fragmentI != null) {
                fragmentI.onActivityResult(i7, activityResult.b(), activityResult.a());
                return;
            }
            Log.w(FragmentManager.P, "Activity result delivered for unknown Fragment " + str);
        }
    }

    public interface k {
        int a();

        @o0
        @Deprecated
        CharSequence b();

        @a1
        @Deprecated
        int d();

        @a1
        @Deprecated
        int e();

        @o0
        @Deprecated
        CharSequence f();

        @o0
        String getName();
    }

    static class l extends b.a<IntentSenderRequest, ActivityResult> {
        l() {
        }

        @Override // b.a
        @m0
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@m0 Context context, IntentSenderRequest intentSenderRequest) {
            Bundle bundleExtra;
            Intent intent = new Intent(b.b.l.f11260b);
            Intent intentA = intentSenderRequest.a();
            if (intentA != null && (bundleExtra = intentA.getBundleExtra(b.b.k.f11258b)) != null) {
                intent.putExtra(b.b.k.f11258b, bundleExtra);
                intentA.removeExtra(b.b.k.f11258b);
                if (intentA.getBooleanExtra(FragmentManager.S, false)) {
                    intentSenderRequest = new IntentSenderRequest.b(intentSenderRequest.e()).b(null).c(intentSenderRequest.d(), intentSenderRequest.b()).a();
                }
            }
            intent.putExtra(b.b.l.f11261c, intentSenderRequest);
            if (FragmentManager.T0(2)) {
                Log.v(FragmentManager.P, "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        @Override // b.a
        @m0
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public ActivityResult c(int i7, @o0 Intent intent) {
            return new ActivityResult(i7, intent);
        }
    }

    public static abstract class m {
        @Deprecated
        public void onFragmentActivityCreated(@m0 FragmentManager fragmentManager, @m0 Fragment fragment, @o0 Bundle bundle) {
        }

        public void onFragmentAttached(@m0 FragmentManager fragmentManager, @m0 Fragment fragment, @m0 Context context) {
        }

        public void onFragmentCreated(@m0 FragmentManager fragmentManager, @m0 Fragment fragment, @o0 Bundle bundle) {
        }

        public void onFragmentDestroyed(@m0 FragmentManager fragmentManager, @m0 Fragment fragment) {
        }

        public void onFragmentDetached(@m0 FragmentManager fragmentManager, @m0 Fragment fragment) {
        }

        public void onFragmentPaused(@m0 FragmentManager fragmentManager, @m0 Fragment fragment) {
        }

        public void onFragmentPreAttached(@m0 FragmentManager fragmentManager, @m0 Fragment fragment, @m0 Context context) {
        }

        public void onFragmentPreCreated(@m0 FragmentManager fragmentManager, @m0 Fragment fragment, @o0 Bundle bundle) {
        }

        public void onFragmentResumed(@m0 FragmentManager fragmentManager, @m0 Fragment fragment) {
        }

        public void onFragmentSaveInstanceState(@m0 FragmentManager fragmentManager, @m0 Fragment fragment, @m0 Bundle bundle) {
        }

        public void onFragmentStarted(@m0 FragmentManager fragmentManager, @m0 Fragment fragment) {
        }

        public void onFragmentStopped(@m0 FragmentManager fragmentManager, @m0 Fragment fragment) {
        }

        public void onFragmentViewCreated(@m0 FragmentManager fragmentManager, @m0 Fragment fragment, @m0 View view, @o0 Bundle bundle) {
        }

        public void onFragmentViewDestroyed(@m0 FragmentManager fragmentManager, @m0 Fragment fragment) {
        }
    }

    private static class n implements androidx.fragment.app.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final androidx.lifecycle.m f7841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final androidx.fragment.app.p f7842b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final androidx.lifecycle.o f7843c;

        n(@m0 androidx.lifecycle.m mVar, @m0 androidx.fragment.app.p pVar, @m0 androidx.lifecycle.o oVar) {
            this.f7841a = mVar;
            this.f7842b = pVar;
            this.f7843c = oVar;
        }

        @Override // androidx.fragment.app.p
        public void a(@m0 String str, @m0 Bundle bundle) {
            this.f7842b.a(str, bundle);
        }

        public boolean b(androidx.lifecycle.m.c cVar) {
            return this.f7841a.b().a(cVar);
        }

        public void c() {
            this.f7841a.c(this.f7843c);
        }
    }

    public interface o {
        @j0
        void a();
    }

    interface p {
        boolean c(@m0 ArrayList<androidx.fragment.app.a> arrayList, @m0 ArrayList<Boolean> arrayList2);
    }

    private class q implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f7844a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f7845b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f7846c;

        q(String str, int i7, int i8) {
            this.f7844a = str;
            this.f7845b = i7;
            this.f7846c = i8;
        }

        @Override // androidx.fragment.app.FragmentManager.p
        public boolean c(@m0 ArrayList<androidx.fragment.app.a> arrayList, @m0 ArrayList<Boolean> arrayList2) {
            Fragment fragment = FragmentManager.this.f7815u;
            if (fragment == null || this.f7845b >= 0 || this.f7844a != null || !fragment.getChildFragmentManager().o1()) {
                return FragmentManager.this.s1(arrayList, arrayList2, this.f7844a, this.f7845b, this.f7846c);
            }
            return false;
        }
    }

    static class r implements Fragment.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final boolean f7848a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final androidx.fragment.app.a f7849b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f7850c;

        r(@m0 androidx.fragment.app.a aVar, boolean z7) {
            this.f7848a = z7;
            this.f7849b = aVar;
        }

        @Override // androidx.fragment.app.Fragment.l
        public void a() {
            this.f7850c++;
        }

        @Override // androidx.fragment.app.Fragment.l
        public void b() {
            int i7 = this.f7850c - 1;
            this.f7850c = i7;
            if (i7 != 0) {
                return;
            }
            this.f7849b.L.J1();
        }

        void c() {
            androidx.fragment.app.a aVar = this.f7849b;
            aVar.L.y(aVar, this.f7848a, false, false);
        }

        void d() {
            boolean z7 = this.f7850c > 0;
            for (Fragment fragment : this.f7849b.L.G0()) {
                fragment.setOnStartEnterTransitionListener(null);
                if (z7 && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            androidx.fragment.app.a aVar = this.f7849b;
            aVar.L.y(aVar, this.f7848a, !z7, true);
        }

        public boolean e() {
            return this.f7850c == 0;
        }
    }

    @m0
    private androidx.fragment.app.m A0(@m0 Fragment fragment) {
        return this.M.j(fragment);
    }

    private void A1(@m0 ArrayList<androidx.fragment.app.a> arrayList, @m0 ArrayList<Boolean> arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        m0(arrayList, arrayList2);
        int size = arrayList.size();
        int i7 = 0;
        int i8 = 0;
        while (i7 < size) {
            if (!arrayList.get(i7).f8089r) {
                if (i8 != i7) {
                    k0(arrayList, arrayList2, i8, i7);
                }
                i8 = i7 + 1;
                if (arrayList2.get(i7).booleanValue()) {
                    while (i8 < size && arrayList2.get(i8).booleanValue() && !arrayList.get(i8).f8089r) {
                        i8++;
                    }
                }
                k0(arrayList, arrayList2, i7, i8);
                i7 = i8 - 1;
            }
            i7++;
        }
        if (i8 != size) {
            k0(arrayList, arrayList2, i8, size);
        }
    }

    private void B(@m0 Fragment fragment) {
        fragment.performDestroyView();
        this.f7809o.n(fragment, false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.q(null);
        fragment.mInLayout = false;
    }

    private void C1() {
        if (this.f7806l != null) {
            for (int i7 = 0; i7 < this.f7806l.size(); i7++) {
                this.f7806l.get(i7).a();
            }
        }
    }

    private ViewGroup D0(@m0 Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.f7813s.d()) {
            View viewC = this.f7813s.c(fragment.mContainerId);
            if (viewC instanceof ViewGroup) {
                return (ViewGroup) viewC;
            }
        }
        return null;
    }

    static int G1(int i7) {
        if (i7 == 4097) {
            return 8194;
        }
        if (i7 == 4099) {
            return v.K;
        }
        if (i7 != 8194) {
            return 0;
        }
        return v.I;
    }

    @o0
    static Fragment N0(@m0 View view) {
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    private void P1(@m0 Fragment fragment) {
        ViewGroup viewGroupD0 = D0(fragment);
        if (viewGroupD0 == null || fragment.getEnterAnim() + fragment.getExitAnim() + fragment.getPopEnterAnim() + fragment.getPopExitAnim() <= 0) {
            return;
        }
        if (viewGroupD0.getTag(R.id.visible_removing_fragment_view_tag) == null) {
            viewGroupD0.setTag(R.id.visible_removing_fragment_view_tag, fragment);
        }
        ((Fragment) viewGroupD0.getTag(R.id.visible_removing_fragment_view_tag)).setPopDirection(fragment.getPopDirection());
    }

    private void Q(@o0 Fragment fragment) {
        if (fragment == null || !fragment.equals(n0(fragment.mWho))) {
            return;
        }
        fragment.performPrimaryNavigationFragmentChanged();
    }

    private void R1() {
        Iterator<androidx.fragment.app.r> it = this.f7797c.l().iterator();
        while (it.hasNext()) {
            k1(it.next());
        }
    }

    private void S1(RuntimeException runtimeException) {
        Log.e(P, runtimeException.getMessage());
        Log.e(P, "Activity state:");
        PrintWriter printWriter = new PrintWriter(new b0(P));
        androidx.fragment.app.h<?> hVar = this.f7812r;
        if (hVar != null) {
            try {
                hVar.h("  ", null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e8) {
                Log.e(P, "Failed dumping state", e8);
                throw runtimeException;
            }
        }
        try {
            b0("  ", null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e9) {
            Log.e(P, "Failed dumping state", e9);
            throw runtimeException;
        }
    }

    static boolean T0(int i7) {
        return O || Log.isLoggable(P, i7);
    }

    private boolean U0(@m0 Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.t();
    }

    private void U1() {
        synchronized (this.f7795a) {
            if (this.f7795a.isEmpty()) {
                this.f7802h.f(z0() > 0 && W0(this.f7814t));
            } else {
                this.f7802h.f(true);
            }
        }
    }

    private void X(int i7) {
        try {
            this.f7796b = true;
            this.f7797c.d(i7);
            e1(i7, false);
            if (Q) {
                Iterator<c0> it = w().iterator();
                while (it.hasNext()) {
                    it.next().j();
                }
            }
            this.f7796b = false;
            h0(true);
        } catch (Throwable th) {
            this.f7796b = false;
            throw th;
        }
    }

    private void a0() {
        if (this.H) {
            this.H = false;
            R1();
        }
    }

    @Deprecated
    public static void c0(boolean z7) {
        O = z7;
    }

    private void c1(@m0 androidx.collection.b<Fragment> bVar) {
        int size = bVar.size();
        for (int i7 = 0; i7 < size; i7++) {
            Fragment fragmentM = bVar.m(i7);
            if (!fragmentM.mAdded) {
                View viewRequireView = fragmentM.requireView();
                fragmentM.mPostponedAlpha = viewRequireView.getAlpha();
                viewRequireView.setAlpha(0.0f);
            }
        }
    }

    @s
    public static void d0(boolean z7) {
        Q = z7;
    }

    private void e0() {
        if (Q) {
            Iterator<c0> it = w().iterator();
            while (it.hasNext()) {
                it.next().j();
            }
        } else {
            if (this.f7807m.isEmpty()) {
                return;
            }
            for (Fragment fragment : this.f7807m.keySet()) {
                s(fragment);
                f1(fragment);
            }
        }
    }

    private void g0(boolean z7) {
        if (this.f7796b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f7812r == null) {
            if (!this.G) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f7812r.g().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z7) {
            u();
        }
        if (this.I == null) {
            this.I = new ArrayList<>();
            this.f7794J = new ArrayList<>();
        }
        this.f7796b = true;
        try {
            m0(null, null);
        } finally {
            this.f7796b = false;
        }
    }

    private void h(@m0 androidx.collection.b<Fragment> bVar) {
        int i7 = this.f7811q;
        if (i7 < 1) {
            return;
        }
        int iMin = Math.min(i7, 5);
        for (Fragment fragment : this.f7797c.o()) {
            if (fragment.mState < iMin) {
                g1(fragment, iMin);
                if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                    bVar.add(fragment);
                }
            }
        }
    }

    private static void j0(@m0 ArrayList<androidx.fragment.app.a> arrayList, @m0 ArrayList<Boolean> arrayList2, int i7, int i8) {
        while (i7 < i8) {
            androidx.fragment.app.a aVar = arrayList.get(i7);
            if (arrayList2.get(i7).booleanValue()) {
                aVar.V(-1);
                aVar.a0(i7 == i8 + (-1));
            } else {
                aVar.V(1);
                aVar.Z();
            }
            i7++;
        }
    }

    /* JADX WARN: Failed to calculate best type for var: r17v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r17v0 'this'  ??, new type: androidx.fragment.app.FragmentManager
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r8v10 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r8v10 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r8v10 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r8v10 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r8v11 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r8v11 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r8v12 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r8v12 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r8v13 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r8v13 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to set immutable type for var: r17v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r17v0 'this'  ??, new type: androidx.fragment.app.FragmentManager
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r8v10 ??, new type: int
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    private void k0(@c.m0 java.util.ArrayList<androidx.fragment.app.a> r18, @c.m0 java.util.ArrayList<java.lang.Boolean> r19, int r20, int r21) {
        /*
            Method dump skipped, instruction units count: 450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.k0(java.util.ArrayList, java.util.ArrayList, int, int):void");
    }

    private void m0(@o0 ArrayList<androidx.fragment.app.a> arrayList, @o0 ArrayList<Boolean> arrayList2) {
        int iIndexOf;
        int iIndexOf2;
        ArrayList<r> arrayList3 = this.L;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i7 = 0;
        while (i7 < size) {
            r rVar = this.L.get(i7);
            if (arrayList != null && !rVar.f7848a && (iIndexOf2 = arrayList.indexOf(rVar.f7849b)) != -1 && arrayList2 != null && arrayList2.get(iIndexOf2).booleanValue()) {
                this.L.remove(i7);
                i7--;
                size--;
                rVar.c();
            } else if (rVar.e() || (arrayList != null && rVar.f7849b.d0(arrayList, 0, arrayList.size()))) {
                this.L.remove(i7);
                i7--;
                size--;
                if (arrayList == null || rVar.f7848a || (iIndexOf = arrayList.indexOf(rVar.f7849b)) == -1 || arrayList2 == null || !arrayList2.get(iIndexOf).booleanValue()) {
                    rVar.d();
                } else {
                    rVar.c();
                }
            }
            i7++;
        }
    }

    @m0
    public static <F extends Fragment> F o0(@m0 View view) {
        F f8 = (F) t0(view);
        if (f8 != null) {
            return f8;
        }
        throw new IllegalStateException("View " + view + " does not have a Fragment set");
    }

    private boolean r1(@o0 String str, int i7, int i8) {
        h0(false);
        g0(true);
        Fragment fragment = this.f7815u;
        if (fragment != null && i7 < 0 && str == null && fragment.getChildFragmentManager().o1()) {
            return true;
        }
        boolean zS1 = s1(this.I, this.f7794J, str, i7, i8);
        if (zS1) {
            this.f7796b = true;
            try {
                A1(this.I, this.f7794J);
                v();
            } catch (Throwable th) {
                v();
                throw th;
            }
        }
        U1();
        a0();
        this.f7797c.b();
        return zS1;
    }

    private void s(@m0 Fragment fragment) {
        HashSet<androidx.core.os.e> hashSet = this.f7807m.get(fragment);
        if (hashSet != null) {
            Iterator<androidx.core.os.e> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            hashSet.clear();
            B(fragment);
            this.f7807m.remove(fragment);
        }
    }

    @m0
    static FragmentManager s0(@m0 View view) {
        FragmentActivity fragmentActivity;
        Fragment fragmentT0 = t0(view);
        if (fragmentT0 != null) {
            if (fragmentT0.isAdded()) {
                return fragmentT0.getChildFragmentManager();
            }
            throw new IllegalStateException("The Fragment " + fragmentT0 + " that owns View " + view + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
        Context context = view.getContext();
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                fragmentActivity = null;
                break;
            }
            if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (fragmentActivity != null) {
            return fragmentActivity.getSupportFragmentManager();
        }
        throw new IllegalStateException("View " + view + " is not within a subclass of FragmentActivity.");
    }

    @o0
    private static Fragment t0(@m0 View view) {
        while (view != null) {
            Fragment fragmentN0 = N0(view);
            if (fragmentN0 != null) {
                return fragmentN0;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    private int t1(@m0 ArrayList<androidx.fragment.app.a> arrayList, @m0 ArrayList<Boolean> arrayList2, int i7, int i8, @m0 androidx.collection.b<Fragment> bVar) {
        int i9 = i8;
        for (int i10 = i8 - 1; i10 >= i7; i10--) {
            androidx.fragment.app.a aVar = arrayList.get(i10);
            boolean zBooleanValue = arrayList2.get(i10).booleanValue();
            if (aVar.f0() && !aVar.d0(arrayList, i10 + 1, i8)) {
                if (this.L == null) {
                    this.L = new ArrayList<>();
                }
                r rVar = new r(aVar, zBooleanValue);
                this.L.add(rVar);
                aVar.h0(rVar);
                if (zBooleanValue) {
                    aVar.Z();
                } else {
                    aVar.a0(false);
                }
                i9--;
                if (i10 != i9) {
                    arrayList.remove(i10);
                    arrayList.add(i9, aVar);
                }
                h(bVar);
            }
        }
        return i9;
    }

    private void u() {
        if (Y0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private void u0() {
        if (Q) {
            Iterator<c0> it = w().iterator();
            while (it.hasNext()) {
                it.next().k();
            }
        } else if (this.L != null) {
            while (!this.L.isEmpty()) {
                this.L.remove(0).d();
            }
        }
    }

    private void v() {
        this.f7796b = false;
        this.f7794J.clear();
        this.I.clear();
    }

    private boolean v0(@m0 ArrayList<androidx.fragment.app.a> arrayList, @m0 ArrayList<Boolean> arrayList2) {
        synchronized (this.f7795a) {
            if (this.f7795a.isEmpty()) {
                return false;
            }
            int size = this.f7795a.size();
            boolean zC = false;
            for (int i7 = 0; i7 < size; i7++) {
                zC |= this.f7795a.get(i7).c(arrayList, arrayList2);
            }
            this.f7795a.clear();
            this.f7812r.g().removeCallbacks(this.N);
            return zC;
        }
    }

    private Set<c0> w() {
        HashSet hashSet = new HashSet();
        Iterator<androidx.fragment.app.r> it = this.f7797c.l().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = it.next().k().mContainer;
            if (viewGroup != null) {
                hashSet.add(c0.o(viewGroup, M0()));
            }
        }
        return hashSet;
    }

    private Set<c0> x(@m0 ArrayList<androidx.fragment.app.a> arrayList, int i7, int i8) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i7 < i8) {
            Iterator<v.a> it = arrayList.get(i7).f8074c.iterator();
            while (it.hasNext()) {
                Fragment fragment = it.next().f8092b;
                if (fragment != null && (viewGroup = fragment.mContainer) != null) {
                    hashSet.add(c0.n(viewGroup, this));
                }
            }
            i7++;
        }
        return hashSet;
    }

    private void z(@m0 Fragment fragment) {
        Animator animator;
        if (fragment.mView != null) {
            androidx.fragment.app.d.C0098d c0098dC = androidx.fragment.app.d.c(this.f7812r.f(), fragment, !fragment.mHidden, fragment.getPopDirection());
            if (c0098dC == null || (animator = c0098dC.f7993b) == null) {
                if (c0098dC != null) {
                    fragment.mView.startAnimation(c0098dC.f7992a);
                    c0098dC.f7992a.start();
                }
                fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
                if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                }
            } else {
                animator.setTarget(fragment.mView);
                if (!fragment.mHidden) {
                    fragment.mView.setVisibility(0);
                } else if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                } else {
                    ViewGroup viewGroup = fragment.mContainer;
                    View view = fragment.mView;
                    viewGroup.startViewTransition(view);
                    c0098dC.f7993b.addListener(new h(viewGroup, view, fragment));
                }
                c0098dC.f7993b.start();
            }
        }
        R0(fragment);
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    @m0
    androidx.fragment.app.r A(@m0 Fragment fragment) {
        androidx.fragment.app.r rVarN = this.f7797c.n(fragment.mWho);
        if (rVarN != null) {
            return rVarN;
        }
        androidx.fragment.app.r rVar = new androidx.fragment.app.r(this.f7809o, this.f7797c, fragment);
        rVar.o(this.f7812r.f().getClassLoader());
        rVar.u(this.f7811q);
        return rVar;
    }

    @m0
    androidx.fragment.app.e B0() {
        return this.f7813s;
    }

    void B1(@m0 Fragment fragment) {
        this.M.p(fragment);
    }

    void C(@m0 Fragment fragment) {
        if (T0(2)) {
            Log.v(P, "detach: " + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (T0(2)) {
                Log.v(P, "remove from detach: " + fragment);
            }
            this.f7797c.t(fragment);
            if (U0(fragment)) {
                this.D = true;
            }
            P1(fragment);
        }
    }

    @o0
    public Fragment C0(@m0 Bundle bundle, @m0 String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment fragmentN0 = n0(string);
        if (fragmentN0 == null) {
            S1(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return fragmentN0;
    }

    void D() {
        this.E = false;
        this.F = false;
        this.M.r(false);
        X(4);
    }

    void D1(@o0 Parcelable parcelable, @o0 androidx.fragment.app.l lVar) {
        if (this.f7812r instanceof q0) {
            S1(new IllegalStateException("You must use restoreSaveState when your FragmentHostCallback implements ViewModelStoreOwner"));
        }
        this.M.q(lVar);
        E1(parcelable);
    }

    void E() {
        this.E = false;
        this.F = false;
        this.M.r(false);
        X(0);
    }

    @m0
    public androidx.fragment.app.g E0() {
        androidx.fragment.app.g gVar = this.f7816v;
        if (gVar != null) {
            return gVar;
        }
        Fragment fragment = this.f7814t;
        return fragment != null ? fragment.mFragmentManager.E0() : this.f7817w;
    }

    void E1(@o0 Parcelable parcelable) {
        androidx.fragment.app.r rVar;
        if (parcelable == null) {
            return;
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
        if (fragmentManagerState.f7851a == null) {
            return;
        }
        this.f7797c.u();
        for (FragmentState fragmentState : fragmentManagerState.f7851a) {
            if (fragmentState != null) {
                Fragment fragmentI = this.M.i(fragmentState.f7860b);
                if (fragmentI != null) {
                    if (T0(2)) {
                        Log.v(P, "restoreSaveState: re-attaching retained " + fragmentI);
                    }
                    rVar = new androidx.fragment.app.r(this.f7809o, this.f7797c, fragmentI, fragmentState);
                } else {
                    rVar = new androidx.fragment.app.r(this.f7809o, this.f7797c, this.f7812r.f().getClassLoader(), E0(), fragmentState);
                }
                Fragment fragmentK = rVar.k();
                fragmentK.mFragmentManager = this;
                if (T0(2)) {
                    Log.v(P, "restoreSaveState: active (" + fragmentK.mWho + "): " + fragmentK);
                }
                rVar.o(this.f7812r.f().getClassLoader());
                this.f7797c.q(rVar);
                rVar.u(this.f7811q);
            }
        }
        for (Fragment fragment : this.M.l()) {
            if (!this.f7797c.c(fragment.mWho)) {
                if (T0(2)) {
                    Log.v(P, "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + fragmentManagerState.f7851a);
                }
                this.M.p(fragment);
                fragment.mFragmentManager = this;
                androidx.fragment.app.r rVar2 = new androidx.fragment.app.r(this.f7809o, this.f7797c, fragment);
                rVar2.u(1);
                rVar2.m();
                fragment.mRemoving = true;
                rVar2.m();
            }
        }
        this.f7797c.v(fragmentManagerState.f7852b);
        if (fragmentManagerState.f7853c != null) {
            this.f7798d = new ArrayList<>(fragmentManagerState.f7853c.length);
            int i7 = 0;
            while (true) {
                BackStackState[] backStackStateArr = fragmentManagerState.f7853c;
                if (i7 >= backStackStateArr.length) {
                    break;
                }
                androidx.fragment.app.a aVarA = backStackStateArr[i7].a(this);
                if (T0(2)) {
                    Log.v(P, "restoreAllState: back stack #" + i7 + " (index " + aVarA.N + "): " + aVarA);
                    PrintWriter printWriter = new PrintWriter(new b0(P));
                    aVarA.Y("  ", printWriter, false);
                    printWriter.close();
                }
                this.f7798d.add(aVarA);
                i7++;
            }
        } else {
            this.f7798d = null;
        }
        this.f7803i.set(fragmentManagerState.f7854d);
        String str = fragmentManagerState.f7855e;
        if (str != null) {
            Fragment fragmentN0 = n0(str);
            this.f7815u = fragmentN0;
            Q(fragmentN0);
        }
        ArrayList<String> arrayList = fragmentManagerState.f7856f;
        if (arrayList != null) {
            for (int i8 = 0; i8 < arrayList.size(); i8++) {
                Bundle bundle = fragmentManagerState.f7857g.get(i8);
                bundle.setClassLoader(this.f7812r.f().getClassLoader());
                this.f7804j.put(arrayList.get(i8), bundle);
            }
        }
        this.C = new ArrayDeque<>(fragmentManagerState.f7858h);
    }

    void F(@m0 Configuration configuration) {
        for (Fragment fragment : this.f7797c.o()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    @m0
    u F0() {
        return this.f7797c;
    }

    @Deprecated
    androidx.fragment.app.l F1() {
        if (this.f7812r instanceof q0) {
            S1(new IllegalStateException("You cannot use retainNonConfig when your FragmentHostCallback implements ViewModelStoreOwner."));
        }
        return this.M.m();
    }

    boolean G(@m0 MenuItem menuItem) {
        if (this.f7811q < 1) {
            return false;
        }
        for (Fragment fragment : this.f7797c.o()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    @m0
    public List<Fragment> G0() {
        return this.f7797c.o();
    }

    void H() {
        this.E = false;
        this.F = false;
        this.M.r(false);
        X(1);
    }

    @m0
    androidx.fragment.app.h<?> H0() {
        return this.f7812r;
    }

    Parcelable H1() {
        int size;
        u0();
        e0();
        h0(true);
        this.E = true;
        this.M.r(true);
        ArrayList<FragmentState> arrayListW = this.f7797c.w();
        BackStackState[] backStackStateArr = null;
        if (arrayListW.isEmpty()) {
            if (T0(2)) {
                Log.v(P, "saveAllState: no fragments!");
            }
            return null;
        }
        ArrayList<String> arrayListX = this.f7797c.x();
        ArrayList<androidx.fragment.app.a> arrayList = this.f7798d;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (int i7 = 0; i7 < size; i7++) {
                backStackStateArr[i7] = new BackStackState(this.f7798d.get(i7));
                if (T0(2)) {
                    Log.v(P, "saveAllState: adding back stack #" + i7 + ": " + this.f7798d.get(i7));
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.f7851a = arrayListW;
        fragmentManagerState.f7852b = arrayListX;
        fragmentManagerState.f7853c = backStackStateArr;
        fragmentManagerState.f7854d = this.f7803i.get();
        Fragment fragment = this.f7815u;
        if (fragment != null) {
            fragmentManagerState.f7855e = fragment.mWho;
        }
        fragmentManagerState.f7856f.addAll(this.f7804j.keySet());
        fragmentManagerState.f7857g.addAll(this.f7804j.values());
        fragmentManagerState.f7858h = new ArrayList<>(this.C);
        return fragmentManagerState;
    }

    boolean I(@m0 Menu menu, @m0 MenuInflater menuInflater) {
        if (this.f7811q < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z7 = false;
        for (Fragment fragment : this.f7797c.o()) {
            if (fragment != null && V0(fragment) && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z7 = true;
            }
        }
        if (this.f7799e != null) {
            for (int i7 = 0; i7 < this.f7799e.size(); i7++) {
                Fragment fragment2 = this.f7799e.get(i7);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.f7799e = arrayList;
        return z7;
    }

    @m0
    LayoutInflater.Factory2 I0() {
        return this.f7800f;
    }

    @o0
    public Fragment.SavedState I1(@m0 Fragment fragment) {
        androidx.fragment.app.r rVarN = this.f7797c.n(fragment.mWho);
        if (rVarN == null || !rVarN.k().equals(fragment)) {
            S1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        return rVarN.r();
    }

    void J() {
        this.G = true;
        h0(true);
        e0();
        X(-1);
        this.f7812r = null;
        this.f7813s = null;
        this.f7814t = null;
        if (this.f7801g != null) {
            this.f7802h.d();
            this.f7801g = null;
        }
        androidx.activity.result.c<Intent> cVar = this.f7820z;
        if (cVar != null) {
            cVar.d();
            this.A.d();
            this.B.d();
        }
    }

    @m0
    androidx.fragment.app.j J0() {
        return this.f7809o;
    }

    void J1() {
        synchronized (this.f7795a) {
            ArrayList<r> arrayList = this.L;
            boolean z7 = (arrayList == null || arrayList.isEmpty()) ? false : true;
            boolean z8 = this.f7795a.size() == 1;
            if (z7 || z8) {
                this.f7812r.g().removeCallbacks(this.N);
                this.f7812r.g().post(this.N);
                U1();
            }
        }
    }

    void K() {
        X(1);
    }

    @o0
    Fragment K0() {
        return this.f7814t;
    }

    void K1(@m0 Fragment fragment, boolean z7) {
        ViewGroup viewGroupD0 = D0(fragment);
        if (viewGroupD0 == null || !(viewGroupD0 instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) viewGroupD0).setDrawDisappearingViewsLast(!z7);
    }

    void L() {
        for (Fragment fragment : this.f7797c.o()) {
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    @o0
    public Fragment L0() {
        return this.f7815u;
    }

    public void L1(@m0 androidx.fragment.app.g gVar) {
        this.f7816v = gVar;
    }

    void M(boolean z7) {
        for (Fragment fragment : this.f7797c.o()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z7);
            }
        }
    }

    @m0
    d0 M0() {
        d0 d0Var = this.f7818x;
        if (d0Var != null) {
            return d0Var;
        }
        Fragment fragment = this.f7814t;
        return fragment != null ? fragment.mFragmentManager.M0() : this.f7819y;
    }

    void M1(@m0 Fragment fragment, @m0 androidx.lifecycle.m.c cVar) {
        if (fragment.equals(n0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
            fragment.mMaxState = cVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    void N(@m0 Fragment fragment) {
        Iterator<androidx.fragment.app.n> it = this.f7810p.iterator();
        while (it.hasNext()) {
            it.next().a(this, fragment);
        }
    }

    void N1(@o0 Fragment fragment) {
        if (fragment == null || (fragment.equals(n0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.f7815u;
            this.f7815u = fragment;
            Q(fragment2);
            Q(this.f7815u);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    boolean O(@m0 MenuItem menuItem) {
        if (this.f7811q < 1) {
            return false;
        }
        for (Fragment fragment : this.f7797c.o()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    @m0
    p0 O0(@m0 Fragment fragment) {
        return this.M.n(fragment);
    }

    void O1(@m0 d0 d0Var) {
        this.f7818x = d0Var;
    }

    void P(@m0 Menu menu) {
        if (this.f7811q < 1) {
            return;
        }
        for (Fragment fragment : this.f7797c.o()) {
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    void P0() {
        h0(true);
        if (this.f7802h.c()) {
            o1();
        } else {
            this.f7801g.e();
        }
    }

    void Q0(@m0 Fragment fragment) {
        if (T0(2)) {
            Log.v(P, "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        P1(fragment);
    }

    void Q1(@m0 Fragment fragment) {
        if (T0(2)) {
            Log.v(P, "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    void R() {
        X(5);
    }

    void R0(@m0 Fragment fragment) {
        if (fragment.mAdded && U0(fragment)) {
            this.D = true;
        }
    }

    void S(boolean z7) {
        for (Fragment fragment : this.f7797c.o()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z7);
            }
        }
    }

    public boolean S0() {
        return this.G;
    }

    boolean T(@m0 Menu menu) {
        boolean z7 = false;
        if (this.f7811q < 1) {
            return false;
        }
        for (Fragment fragment : this.f7797c.o()) {
            if (fragment != null && V0(fragment) && fragment.performPrepareOptionsMenu(menu)) {
                z7 = true;
            }
        }
        return z7;
    }

    public void T1(@m0 m mVar) {
        this.f7809o.p(mVar);
    }

    void U() {
        U1();
        Q(this.f7815u);
    }

    void V() {
        this.E = false;
        this.F = false;
        this.M.r(false);
        X(7);
    }

    boolean V0(@o0 Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    void W() {
        this.E = false;
        this.F = false;
        this.M.r(false);
        X(5);
    }

    boolean W0(@o0 Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        return fragment.equals(fragmentManager.L0()) && W0(fragmentManager.f7814t);
    }

    boolean X0(int i7) {
        return this.f7811q >= i7;
    }

    void Y() {
        this.F = true;
        this.M.r(true);
        X(4);
    }

    public boolean Y0() {
        return this.E || this.F;
    }

    void Z() {
        X(2);
    }

    void Z0(@m0 Fragment fragment, @m0 String[] strArr, int i7) {
        if (this.B == null) {
            this.f7812r.m(fragment, strArr, i7);
            return;
        }
        this.C.addLast(new LaunchedFragmentInfo(fragment.mWho, i7));
        this.B.b(strArr);
    }

    @Override // androidx.fragment.app.q
    public final void a(@m0 String str, @m0 Bundle bundle) {
        n nVar = this.f7805k.get(str);
        if (nVar == null || !nVar.b(androidx.lifecycle.m.c.STARTED)) {
            this.f7804j.put(str, bundle);
        } else {
            nVar.a(str, bundle);
        }
    }

    void a1(@m0 Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i7, @o0 Bundle bundle) {
        if (this.f7820z == null) {
            this.f7812r.q(fragment, intent, i7, bundle);
            return;
        }
        this.C.addLast(new LaunchedFragmentInfo(fragment.mWho, i7));
        if (intent != null && bundle != null) {
            intent.putExtra(b.b.k.f11258b, bundle);
        }
        this.f7820z.b(intent);
    }

    @Override // androidx.fragment.app.q
    @SuppressLint({"SyntheticAccessor"})
    public final void b(@m0 final String str, @m0 androidx.lifecycle.q qVar, @m0 final androidx.fragment.app.p pVar) {
        final androidx.lifecycle.m lifecycle = qVar.getLifecycle();
        if (lifecycle.b() == androidx.lifecycle.m.c.DESTROYED) {
            return;
        }
        androidx.lifecycle.o oVar = new androidx.lifecycle.o() { // from class: androidx.fragment.app.FragmentManager.6
            @Override // androidx.lifecycle.o
            public void g(@m0 androidx.lifecycle.q qVar2, @m0 androidx.lifecycle.m.b bVar) {
                Bundle bundle;
                if (bVar == androidx.lifecycle.m.b.ON_START && (bundle = (Bundle) FragmentManager.this.f7804j.get(str)) != null) {
                    pVar.a(str, bundle);
                    FragmentManager.this.d(str);
                }
                if (bVar == androidx.lifecycle.m.b.ON_DESTROY) {
                    lifecycle.c(this);
                    FragmentManager.this.f7805k.remove(str);
                }
            }
        };
        lifecycle.a(oVar);
        n nVarPut = this.f7805k.put(str, new n(lifecycle, pVar, oVar));
        if (nVarPut != null) {
            nVarPut.c();
        }
    }

    public void b0(@m0 String str, @o0 FileDescriptor fileDescriptor, @m0 PrintWriter printWriter, @o0 String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.f7797c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList<Fragment> arrayList = this.f7799e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i7 = 0; i7 < size2; i7++) {
                Fragment fragment = this.f7799e.get(i7);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i7);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        ArrayList<androidx.fragment.app.a> arrayList2 = this.f7798d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i8 = 0; i8 < size; i8++) {
                androidx.fragment.app.a aVar = this.f7798d.get(i8);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i8);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.X(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f7803i.get());
        synchronized (this.f7795a) {
            int size3 = this.f7795a.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i9 = 0; i9 < size3; i9++) {
                    p pVar = this.f7795a.get(i9);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i9);
                    printWriter.print(": ");
                    printWriter.println(pVar);
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f7812r);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f7813s);
        if (this.f7814t != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f7814t);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f7811q);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.E);
        printWriter.print(" mStopped=");
        printWriter.print(this.F);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.G);
        if (this.D) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.D);
        }
    }

    void b1(@m0 Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i7, @o0 Intent intent, int i8, int i9, int i10, @o0 Bundle bundle) throws IntentSender.SendIntentException {
        Intent intent2;
        if (this.A == null) {
            this.f7812r.r(fragment, intentSender, i7, intent, i8, i9, i10, bundle);
            return;
        }
        if (bundle != null) {
            if (intent == null) {
                intent2 = new Intent();
                intent2.putExtra(S, true);
            } else {
                intent2 = intent;
            }
            if (T0(2)) {
                Log.v(P, "ActivityOptions " + bundle + " were added to fillInIntent " + intent2 + " for fragment " + fragment);
            }
            intent2.putExtra(b.b.k.f11258b, bundle);
        } else {
            intent2 = intent;
        }
        IntentSenderRequest intentSenderRequestA = new IntentSenderRequest.b(intentSender).b(intent2).c(i9, i8).a();
        this.C.addLast(new LaunchedFragmentInfo(fragment.mWho, i7));
        if (T0(2)) {
            Log.v(P, "Fragment " + fragment + "is launching an IntentSender for result ");
        }
        this.A.b(intentSenderRequestA);
    }

    @Override // androidx.fragment.app.q
    public final void c(@m0 String str) {
        n nVarRemove = this.f7805k.remove(str);
        if (nVarRemove != null) {
            nVarRemove.c();
        }
    }

    @Override // androidx.fragment.app.q
    public final void d(@m0 String str) {
        this.f7804j.remove(str);
    }

    void d1(@m0 Fragment fragment) {
        if (!this.f7797c.c(fragment.mWho)) {
            if (T0(3)) {
                Log.d(P, "Ignoring moving " + fragment + " to state " + this.f7811q + "since it is not added to " + this);
                return;
            }
            return;
        }
        f1(fragment);
        View view = fragment.mView;
        if (view != null && fragment.mIsNewlyAdded && fragment.mContainer != null) {
            float f8 = fragment.mPostponedAlpha;
            if (f8 > 0.0f) {
                view.setAlpha(f8);
            }
            fragment.mPostponedAlpha = 0.0f;
            fragment.mIsNewlyAdded = false;
            androidx.fragment.app.d.C0098d c0098dC = androidx.fragment.app.d.c(this.f7812r.f(), fragment, true, fragment.getPopDirection());
            if (c0098dC != null) {
                Animation animation = c0098dC.f7992a;
                if (animation != null) {
                    fragment.mView.startAnimation(animation);
                } else {
                    c0098dC.f7993b.setTarget(fragment.mView);
                    c0098dC.f7993b.start();
                }
            }
        }
        if (fragment.mHiddenChanged) {
            z(fragment);
        }
    }

    void e1(int i7, boolean z7) {
        androidx.fragment.app.h<?> hVar;
        if (this.f7812r == null && i7 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z7 || i7 != this.f7811q) {
            this.f7811q = i7;
            if (Q) {
                this.f7797c.s();
            } else {
                Iterator<Fragment> it = this.f7797c.o().iterator();
                while (it.hasNext()) {
                    d1(it.next());
                }
                for (androidx.fragment.app.r rVar : this.f7797c.l()) {
                    Fragment fragmentK = rVar.k();
                    if (!fragmentK.mIsNewlyAdded) {
                        d1(fragmentK);
                    }
                    if (fragmentK.mRemoving && !fragmentK.isInBackStack()) {
                        this.f7797c.r(rVar);
                    }
                }
            }
            R1();
            if (this.D && (hVar = this.f7812r) != null && this.f7811q == 7) {
                hVar.s();
                this.D = false;
            }
        }
    }

    void f0(@m0 p pVar, boolean z7) {
        if (!z7) {
            if (this.f7812r == null) {
                if (!this.G) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            u();
        }
        synchronized (this.f7795a) {
            if (this.f7812r == null) {
                if (!z7) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
            } else {
                this.f7795a.add(pVar);
                J1();
            }
        }
    }

    void f1(@m0 Fragment fragment) {
        g1(fragment, this.f7811q);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0161  */
    /* JADX WARN: Code duplicated, block: B:31:0x0063  */
    /* JADX WARN: Code duplicated, block: B:33:0x0068  */
    /* JADX WARN: Code duplicated, block: B:35:0x006d  */
    /* JADX WARN: Code duplicated, block: B:37:0x0072  */
    /* JADX WARN: Code duplicated, block: B:39:0x0077  */
    /* JADX WARN: Code duplicated, block: B:98:0x015e  */
    void g1(@m0 Fragment fragment, int i7) {
        ViewGroup viewGroup;
        androidx.fragment.app.r rVarN = this.f7797c.n(fragment.mWho);
        int i8 = 1;
        if (rVarN == null) {
            rVarN = new androidx.fragment.app.r(this.f7809o, this.f7797c, fragment);
            rVarN.u(1);
        }
        if (fragment.mFromLayout && fragment.mInLayout && fragment.mState == 2) {
            i7 = Math.max(i7, 2);
        }
        int iMin = Math.min(i7, rVarN.d());
        int i9 = fragment.mState;
        if (i9 <= iMin) {
            if (i9 < iMin && !this.f7807m.isEmpty()) {
                s(fragment);
            }
            int i10 = fragment.mState;
            if (i10 != -1) {
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            if (i10 != 4) {
                                if (i10 == 5) {
                                }
                            }
                            if (iMin > 5) {
                                rVarN.p();
                            }
                        }
                        if (iMin > 4) {
                            rVarN.v();
                        }
                        if (iMin > 5) {
                            rVarN.p();
                        }
                    }
                    if (iMin > 2) {
                        rVarN.a();
                    }
                    if (iMin > 4) {
                        rVarN.v();
                    }
                    if (iMin > 5) {
                        rVarN.p();
                    }
                }
                if (iMin > -1) {
                    rVarN.j();
                }
                if (iMin > 1) {
                    rVarN.f();
                }
                if (iMin > 2) {
                    rVarN.a();
                }
                if (iMin > 4) {
                    rVarN.v();
                }
                if (iMin > 5) {
                    rVarN.p();
                }
            } else if (iMin > -1) {
                rVarN.c();
            }
            if (iMin > 0) {
                rVarN.e();
            }
            if (iMin > -1) {
                rVarN.j();
            }
            if (iMin > 1) {
                rVarN.f();
            }
            if (iMin > 2) {
                rVarN.a();
            }
            if (iMin > 4) {
                rVarN.v();
            }
            if (iMin > 5) {
                rVarN.p();
            }
        } else if (i9 > iMin) {
            if (i9 == 0) {
                i8 = iMin;
                if (i8 < 0) {
                    rVarN.i();
                }
                iMin = i8;
            } else {
                if (i9 != 1) {
                    if (i9 != 2) {
                        if (i9 != 4) {
                            if (i9 != 5) {
                                if (i9 == 7) {
                                    if (iMin < 7) {
                                        rVarN.n();
                                    }
                                }
                            }
                            if (iMin < 5) {
                                rVarN.w();
                            }
                        }
                        if (iMin < 4) {
                            if (T0(3)) {
                                Log.d(P, "movefrom ACTIVITY_CREATED: " + fragment);
                            }
                            if (fragment.mView != null && this.f7812r.n(fragment) && fragment.mSavedViewState == null) {
                                rVarN.t();
                            }
                        }
                    }
                    if (iMin < 2) {
                        View view = fragment.mView;
                        if (view != null && (viewGroup = fragment.mContainer) != null) {
                            viewGroup.endViewTransition(view);
                            fragment.mView.clearAnimation();
                            if (!fragment.isRemovingParent()) {
                                androidx.fragment.app.d.C0098d c0098dC = (this.f7811q <= -1 || this.G || fragment.mView.getVisibility() != 0 || fragment.mPostponedAlpha < 0.0f) ? null : androidx.fragment.app.d.c(this.f7812r.f(), fragment, false, fragment.getPopDirection());
                                fragment.mPostponedAlpha = 0.0f;
                                ViewGroup viewGroup2 = fragment.mContainer;
                                View view2 = fragment.mView;
                                if (c0098dC != null) {
                                    androidx.fragment.app.d.a(fragment, c0098dC, this.f7808n);
                                }
                                viewGroup2.removeView(view2);
                                if (T0(2)) {
                                    Log.v(P, "Removing view " + view2 + " for fragment " + fragment + " from container " + viewGroup2);
                                }
                                if (viewGroup2 != fragment.mContainer) {
                                    return;
                                }
                            }
                        }
                        if (this.f7807m.get(fragment) == null) {
                            rVarN.h();
                        }
                    }
                }
                if (iMin >= 1) {
                    i8 = iMin;
                } else if (this.f7807m.get(fragment) == null) {
                    rVarN.g();
                    i8 = iMin;
                }
                if (i8 < 0) {
                    rVarN.i();
                }
                iMin = i8;
            }
        }
        if (fragment.mState != iMin) {
            if (T0(3)) {
                Log.d(P, "moveToState: Fragment state for " + fragment + " not updated inline; expected state " + iMin + " found " + fragment.mState);
            }
            fragment.mState = iMin;
        }
    }

    boolean h0(boolean z7) {
        g0(z7);
        boolean z8 = false;
        while (v0(this.I, this.f7794J)) {
            z8 = true;
            this.f7796b = true;
            try {
                A1(this.I, this.f7794J);
                v();
            } catch (Throwable th) {
                v();
                throw th;
            }
        }
        U1();
        a0();
        this.f7797c.b();
        return z8;
    }

    void h1() {
        if (this.f7812r == null) {
            return;
        }
        this.E = false;
        this.F = false;
        this.M.r(false);
        for (Fragment fragment : this.f7797c.o()) {
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    void i(androidx.fragment.app.a aVar) {
        if (this.f7798d == null) {
            this.f7798d = new ArrayList<>();
        }
        this.f7798d.add(aVar);
    }

    void i0(@m0 p pVar, boolean z7) {
        if (z7 && (this.f7812r == null || this.G)) {
            return;
        }
        g0(z7);
        if (pVar.c(this.I, this.f7794J)) {
            this.f7796b = true;
            try {
                A1(this.I, this.f7794J);
                v();
            } catch (Throwable th) {
                v();
                throw th;
            }
        }
        U1();
        a0();
        this.f7797c.b();
    }

    void i1(@m0 FragmentContainerView fragmentContainerView) {
        View view;
        for (androidx.fragment.app.r rVar : this.f7797c.l()) {
            Fragment fragmentK = rVar.k();
            if (fragmentK.mContainerId == fragmentContainerView.getId() && (view = fragmentK.mView) != null && view.getParent() == null) {
                fragmentK.mContainer = fragmentContainerView;
                rVar.b();
            }
        }
    }

    void j(@m0 Fragment fragment, @m0 androidx.core.os.e eVar) {
        if (this.f7807m.get(fragment) == null) {
            this.f7807m.put(fragment, new HashSet<>());
        }
        this.f7807m.get(fragment).add(eVar);
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    @m0
    @Deprecated
    public v j1() {
        return r();
    }

    androidx.fragment.app.r k(@m0 Fragment fragment) {
        if (T0(2)) {
            Log.v(P, "add: " + fragment);
        }
        androidx.fragment.app.r rVarA = A(fragment);
        fragment.mFragmentManager = this;
        this.f7797c.q(rVarA);
        if (!fragment.mDetached) {
            this.f7797c.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (U0(fragment)) {
                this.D = true;
            }
        }
        return rVarA;
    }

    void k1(@m0 androidx.fragment.app.r rVar) {
        Fragment fragmentK = rVar.k();
        if (fragmentK.mDeferStart) {
            if (this.f7796b) {
                this.H = true;
                return;
            }
            fragmentK.mDeferStart = false;
            if (Q) {
                rVar.m();
            } else {
                f1(fragmentK);
            }
        }
    }

    public void l(@m0 androidx.fragment.app.n nVar) {
        this.f7810p.add(nVar);
    }

    public boolean l0() {
        boolean zH0 = h0(true);
        u0();
        return zH0;
    }

    public void l1() {
        f0(new q(null, -1, 0), false);
    }

    public void m(@m0 o oVar) {
        if (this.f7806l == null) {
            this.f7806l = new ArrayList<>();
        }
        this.f7806l.add(oVar);
    }

    public void m1(int i7, int i8) {
        if (i7 >= 0) {
            f0(new q(null, i7, i8), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i7);
    }

    void n(@m0 Fragment fragment) {
        this.M.g(fragment);
    }

    @o0
    Fragment n0(@m0 String str) {
        return this.f7797c.f(str);
    }

    public void n1(@o0 String str, int i7) {
        f0(new q(str, -1, i7), false);
    }

    int o() {
        return this.f7803i.getAndIncrement();
    }

    public boolean o1() {
        return r1(null, -1, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SyntheticAccessor"})
    void p(@m0 androidx.fragment.app.h<?> hVar, @m0 androidx.fragment.app.e eVar, @o0 Fragment fragment) {
        String str;
        androidx.lifecycle.q qVar;
        if (this.f7812r != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f7812r = hVar;
        this.f7813s = eVar;
        this.f7814t = fragment;
        if (fragment != null) {
            l(new i(fragment));
        } else if (hVar instanceof androidx.fragment.app.n) {
            l((androidx.fragment.app.n) hVar);
        }
        if (this.f7814t != null) {
            U1();
        }
        if (hVar instanceof androidx.activity.h) {
            androidx.activity.h hVar2 = (androidx.activity.h) hVar;
            OnBackPressedDispatcher onBackPressedDispatcher = hVar2.getOnBackPressedDispatcher();
            this.f7801g = onBackPressedDispatcher;
            if (fragment != null) {
                qVar = hVar2;
                qVar = fragment;
            }
            qVar = hVar2;
            onBackPressedDispatcher.b(qVar, this.f7802h);
        }
        if (fragment != null) {
            this.M = fragment.mFragmentManager.A0(fragment);
        } else if (hVar instanceof q0) {
            this.M = androidx.fragment.app.m.k(((q0) hVar).getViewModelStore());
        } else {
            this.M = new androidx.fragment.app.m(false);
        }
        this.M.r(Y0());
        this.f7797c.y(this.M);
        Object obj = this.f7812r;
        if (obj instanceof androidx.activity.result.d) {
            ActivityResultRegistry activityResultRegistry = ((androidx.activity.result.d) obj).getActivityResultRegistry();
            if (fragment != null) {
                str = fragment.mWho + ":";
            } else {
                str = "";
            }
            String str2 = "FragmentManager:" + str;
            this.f7820z = activityResultRegistry.j(str2 + "StartActivityForResult", new b.b.k(), new j());
            this.A = activityResultRegistry.j(str2 + "StartIntentSenderForResult", new l(), new a());
            this.B = activityResultRegistry.j(str2 + "RequestPermissions", new b.b.i(), new b());
        }
    }

    @o0
    public Fragment p0(@c.b0 int i7) {
        return this.f7797c.g(i7);
    }

    public boolean p1(int i7, int i8) {
        if (i7 >= 0) {
            return r1(null, i7, i8);
        }
        throw new IllegalArgumentException("Bad id: " + i7);
    }

    void q(@m0 Fragment fragment) {
        if (T0(2)) {
            Log.v(P, "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            this.f7797c.a(fragment);
            if (T0(2)) {
                Log.v(P, "add from attach: " + fragment);
            }
            if (U0(fragment)) {
                this.D = true;
            }
        }
    }

    @o0
    public Fragment q0(@o0 String str) {
        return this.f7797c.h(str);
    }

    public boolean q1(@o0 String str, int i7) {
        return r1(str, -1, i7);
    }

    @m0
    public v r() {
        return new androidx.fragment.app.a(this);
    }

    Fragment r0(@m0 String str) {
        return this.f7797c.i(str);
    }

    boolean s1(@m0 ArrayList<androidx.fragment.app.a> arrayList, @m0 ArrayList<Boolean> arrayList2, @o0 String str, int i7, int i8) {
        int i9;
        ArrayList<androidx.fragment.app.a> arrayList3 = this.f7798d;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i7 < 0 && (i8 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f7798d.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            if (str != null || i7 >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    androidx.fragment.app.a aVar = this.f7798d.get(size2);
                    if ((str != null && str.equals(aVar.getName())) || (i7 >= 0 && i7 == aVar.N)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i8 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        androidx.fragment.app.a aVar2 = this.f7798d.get(size2);
                        if (str == null || !str.equals(aVar2.getName())) {
                            if (i7 < 0 || i7 != aVar2.N) {
                                break;
                            }
                        }
                    }
                }
                i9 = size2;
            } else {
                i9 = -1;
            }
            if (i9 == this.f7798d.size() - 1) {
                return false;
            }
            for (int size3 = this.f7798d.size() - 1; size3 > i9; size3--) {
                arrayList.add(this.f7798d.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    boolean t() {
        boolean zU0 = false;
        for (Fragment fragment : this.f7797c.m()) {
            if (fragment != null) {
                zU0 = U0(fragment);
            }
            if (zU0) {
                return true;
            }
        }
        return false;
    }

    @m0
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.f7814t;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.f7814t)));
            sb.append(com.alipay.sdk.util.j.f13808d);
        } else {
            androidx.fragment.app.h<?> hVar = this.f7812r;
            if (hVar != null) {
                sb.append(hVar.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.f7812r)));
                sb.append(com.alipay.sdk.util.j.f13808d);
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public void u1(@m0 Bundle bundle, @m0 String str, @m0 Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            S1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.mWho);
    }

    public void v1(@m0 m mVar, boolean z7) {
        this.f7809o.o(mVar, z7);
    }

    int w0() {
        return this.f7797c.k();
    }

    void w1(@m0 Fragment fragment, @m0 androidx.core.os.e eVar) {
        HashSet<androidx.core.os.e> hashSet = this.f7807m.get(fragment);
        if (hashSet != null && hashSet.remove(eVar) && hashSet.isEmpty()) {
            this.f7807m.remove(fragment);
            if (fragment.mState < 5) {
                B(fragment);
                f1(fragment);
            }
        }
    }

    @m0
    List<Fragment> x0() {
        return this.f7797c.m();
    }

    void x1(@m0 Fragment fragment) {
        if (T0(2)) {
            Log.v(P, "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z7 = !fragment.isInBackStack();
        if (!fragment.mDetached || z7) {
            this.f7797c.t(fragment);
            if (U0(fragment)) {
                this.D = true;
            }
            fragment.mRemoving = true;
            P1(fragment);
        }
    }

    void y(@m0 androidx.fragment.app.a aVar, boolean z7, boolean z8, boolean z9) {
        if (z7) {
            aVar.a0(z9);
        } else {
            aVar.Z();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z7));
        if (z8 && this.f7811q >= 1) {
            w.C(this.f7812r.f(), this.f7813s, arrayList, arrayList2, 0, 1, true, this.f7808n);
        }
        if (z9) {
            e1(this.f7811q, true);
        }
        for (Fragment fragment : this.f7797c.m()) {
            if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && aVar.c0(fragment.mContainerId)) {
                float f8 = fragment.mPostponedAlpha;
                if (f8 > 0.0f) {
                    fragment.mView.setAlpha(f8);
                }
                if (z9) {
                    fragment.mPostponedAlpha = 0.0f;
                } else {
                    fragment.mPostponedAlpha = -1.0f;
                    fragment.mIsNewlyAdded = false;
                }
            }
        }
    }

    @m0
    public k y0(int i7) {
        return this.f7798d.get(i7);
    }

    public void y1(@m0 androidx.fragment.app.n nVar) {
        this.f7810p.remove(nVar);
    }

    public int z0() {
        ArrayList<androidx.fragment.app.a> arrayList = this.f7798d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public void z1(@m0 o oVar) {
        ArrayList<o> arrayList = this.f7806l;
        if (arrayList != null) {
            arrayList.remove(oVar);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f7825a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f7826b;

        class a implements Parcelable.Creator<LaunchedFragmentInfo> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public LaunchedFragmentInfo[] newArray(int i7) {
                return new LaunchedFragmentInfo[i7];
            }
        }

        LaunchedFragmentInfo(@m0 String str, int i7) {
            this.f7825a = str;
            this.f7826b = i7;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            parcel.writeString(this.f7825a);
            parcel.writeInt(this.f7826b);
        }

        LaunchedFragmentInfo(@m0 Parcel parcel) {
            this.f7825a = parcel.readString();
            this.f7826b = parcel.readInt();
        }
    }
}
