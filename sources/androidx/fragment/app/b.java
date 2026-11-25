package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.app.d7;
import androidx.core.view.c2;
import androidx.core.view.i4;
import androidx.core.view.n2;
import c.m0;
import c.o0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class b extends c0 {

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7902a;

        static {
            int[] iArr = new int[c0.e.c.values().length];
            f7902a = iArr;
            try {
                iArr[c0.e.c.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7902a[c0.e.c.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7902a[c0.e.c.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7902a[c0.e.c.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.b$b, reason: collision with other inner class name */
    class RunnableC0096b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f7903a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c0.e f7904b;

        RunnableC0096b(List list, c0.e eVar) {
            this.f7903a = list;
            this.f7904b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f7903a.contains(this.f7904b)) {
                this.f7903a.remove(this.f7904b);
                b.this.s(this.f7904b);
            }
        }
    }

    class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f7906a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f7907b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f7908c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ c0.e f7909d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ k f7910e;

        c(ViewGroup viewGroup, View view, boolean z7, c0.e eVar, k kVar) {
            this.f7906a = viewGroup;
            this.f7907b = view;
            this.f7908c = z7;
            this.f7909d = eVar;
            this.f7910e = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f7906a.endViewTransition(this.f7907b);
            if (this.f7908c) {
                this.f7909d.e().a(this.f7907b);
            }
            this.f7910e.a();
        }
    }

    class d implements androidx.core.os.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Animator f7912a;

        d(Animator animator) {
            this.f7912a = animator;
        }

        @Override // androidx.core.os.e.b
        public void onCancel() {
            this.f7912a.end();
        }
    }

    class e implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f7914a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f7915b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f7916c;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                eVar.f7914a.endViewTransition(eVar.f7915b);
                e.this.f7916c.a();
            }
        }

        e(ViewGroup viewGroup, View view, k kVar) {
            this.f7914a = viewGroup;
            this.f7915b = view;
            this.f7916c = kVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f7914a.post(new a());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    class f implements androidx.core.os.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f7919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f7920b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f7921c;

        f(View view, ViewGroup viewGroup, k kVar) {
            this.f7919a = view;
            this.f7920b = viewGroup;
            this.f7921c = kVar;
        }

        @Override // androidx.core.os.e.b
        public void onCancel() {
            this.f7919a.clearAnimation();
            this.f7920b.endViewTransition(this.f7919a);
            this.f7921c.a();
        }
    }

    class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c0.e f7923a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c0.e f7924b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f7925c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ androidx.collection.a f7926d;

        g(c0.e eVar, c0.e eVar2, boolean z7, androidx.collection.a aVar) {
            this.f7923a = eVar;
            this.f7924b = eVar2;
            this.f7925c = z7;
            this.f7926d = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.f(this.f7923a.f(), this.f7924b.f(), this.f7925c, this.f7926d, false);
        }
    }

    class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ y f7928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f7929b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Rect f7930c;

        h(y yVar, View view, Rect rect) {
            this.f7928a = yVar;
            this.f7929b = view;
            this.f7930c = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f7928a.k(this.f7929b, this.f7930c);
        }
    }

    class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f7932a;

        i(ArrayList arrayList) {
            this.f7932a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.B(this.f7932a, 4);
        }
    }

    class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ m f7934a;

        j(m mVar) {
            this.f7934a = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f7934a.a();
        }
    }

    private static class k extends l {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f7936c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f7937d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @o0
        private androidx.fragment.app.d.C0098d f7938e;

        k(@m0 c0.e eVar, @m0 androidx.core.os.e eVar2, boolean z7) {
            super(eVar, eVar2);
            this.f7937d = false;
            this.f7936c = z7;
        }

        @o0
        androidx.fragment.app.d.C0098d e(@m0 Context context) {
            if (this.f7937d) {
                return this.f7938e;
            }
            androidx.fragment.app.d.C0098d c0098dC = androidx.fragment.app.d.c(context, b().f(), b().e() == c0.e.c.VISIBLE, this.f7936c);
            this.f7938e = c0098dC;
            this.f7937d = true;
            return c0098dC;
        }
    }

    private static class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m0
        private final c0.e f7939a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @m0
        private final androidx.core.os.e f7940b;

        l(@m0 c0.e eVar, @m0 androidx.core.os.e eVar2) {
            this.f7939a = eVar;
            this.f7940b = eVar2;
        }

        void a() {
            this.f7939a.d(this.f7940b);
        }

        @m0
        c0.e b() {
            return this.f7939a;
        }

        @m0
        androidx.core.os.e c() {
            return this.f7940b;
        }

        boolean d() {
            c0.e.c cVar;
            c0.e.c cVarC = c0.e.c.c(this.f7939a.f().mView);
            c0.e.c cVarE = this.f7939a.e();
            return cVarC == cVarE || !(cVarC == (cVar = c0.e.c.VISIBLE) || cVarE == cVar);
        }
    }

    private static class m extends l {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @o0
        private final Object f7941c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f7942d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @o0
        private final Object f7943e;

        m(@m0 c0.e eVar, @m0 androidx.core.os.e eVar2, boolean z7, boolean z8) {
            super(eVar, eVar2);
            if (eVar.e() == c0.e.c.VISIBLE) {
                this.f7941c = z7 ? eVar.f().getReenterTransition() : eVar.f().getEnterTransition();
                this.f7942d = z7 ? eVar.f().getAllowReturnTransitionOverlap() : eVar.f().getAllowEnterTransitionOverlap();
            } else {
                this.f7941c = z7 ? eVar.f().getReturnTransition() : eVar.f().getExitTransition();
                this.f7942d = true;
            }
            if (!z8) {
                this.f7943e = null;
            } else if (z7) {
                this.f7943e = eVar.f().getSharedElementReturnTransition();
            } else {
                this.f7943e = eVar.f().getSharedElementEnterTransition();
            }
        }

        @o0
        private y f(Object obj) {
            if (obj == null) {
                return null;
            }
            y yVar = w.f8100b;
            if (yVar != null && yVar.e(obj)) {
                return yVar;
            }
            y yVar2 = w.f8101c;
            if (yVar2 != null && yVar2.e(obj)) {
                return yVar2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + b().f() + " is not a valid framework Transition or AndroidX Transition");
        }

        @o0
        y e() {
            y yVarF = f(this.f7941c);
            y yVarF2 = f(this.f7943e);
            if (yVarF == null || yVarF2 == null || yVarF == yVarF2) {
                return yVarF != null ? yVarF : yVarF2;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + b().f() + " returned Transition " + this.f7941c + " which uses a different Transition  type than its shared element transition " + this.f7943e);
        }

        @o0
        public Object g() {
            return this.f7943e;
        }

        @o0
        Object h() {
            return this.f7941c;
        }

        public boolean i() {
            return this.f7943e != null;
        }

        boolean j() {
            return this.f7942d;
        }
    }

    b(@m0 ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void w(@m0 List<k> list, @m0 List<c0.e> list2, boolean z7, @m0 Map<c0.e, Boolean> map) {
        ViewGroup viewGroupM = m();
        Context context = viewGroupM.getContext();
        ArrayList<k> arrayList = new ArrayList();
        boolean z8 = false;
        for (k kVar : list) {
            if (kVar.d()) {
                kVar.a();
            } else {
                androidx.fragment.app.d.C0098d c0098dE = kVar.e(context);
                if (c0098dE == null) {
                    kVar.a();
                } else {
                    Animator animator = c0098dE.f7993b;
                    if (animator == null) {
                        arrayList.add(kVar);
                    } else {
                        c0.e eVarB = kVar.b();
                        Fragment fragmentF = eVarB.f();
                        if (Boolean.TRUE.equals(map.get(eVarB))) {
                            if (FragmentManager.T0(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + fragmentF + " as this Fragment was involved in a Transition.");
                            }
                            kVar.a();
                        } else {
                            boolean z9 = eVarB.e() == c0.e.c.GONE;
                            if (z9) {
                                list2.remove(eVarB);
                            }
                            View view = fragmentF.mView;
                            viewGroupM.startViewTransition(view);
                            animator.addListener(new c(viewGroupM, view, z9, eVarB, kVar));
                            animator.setTarget(view);
                            animator.start();
                            kVar.c().d(new d(animator));
                            z8 = true;
                        }
                    }
                }
            }
        }
        for (k kVar2 : arrayList) {
            c0.e eVarB2 = kVar2.b();
            Fragment fragmentF2 = eVarB2.f();
            if (z7) {
                if (FragmentManager.T0(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragmentF2 + " as Animations cannot run alongside Transitions.");
                }
                kVar2.a();
            } else if (z8) {
                if (FragmentManager.T0(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragmentF2 + " as Animations cannot run alongside Animators.");
                }
                kVar2.a();
            } else {
                View view2 = fragmentF2.mView;
                Animation animation = (Animation) androidx.core.util.w.l(((androidx.fragment.app.d.C0098d) androidx.core.util.w.l(kVar2.e(context))).f7992a);
                if (eVarB2.e() != c0.e.c.REMOVED) {
                    view2.startAnimation(animation);
                    kVar2.a();
                } else {
                    viewGroupM.startViewTransition(view2);
                    androidx.fragment.app.d.e eVar = new androidx.fragment.app.d.e(animation, viewGroupM, view2);
                    eVar.setAnimationListener(new e(viewGroupM, view2, kVar2));
                    view2.startAnimation(eVar);
                }
                kVar2.c().d(new f(view2, viewGroupM, kVar2));
            }
        }
    }

    @m0
    private Map<c0.e, Boolean> x(@m0 List<m> list, @m0 List<c0.e> list2, boolean z7, @o0 c0.e eVar, @o0 c0.e eVar2) {
        Iterator<m> it;
        View view;
        Object obj;
        ArrayList<View> arrayList;
        Object obj2;
        ArrayList<View> arrayList2;
        c0.e eVar3;
        c0.e eVar4;
        View view2;
        Object objN;
        ArrayList<View> arrayList3;
        b bVar;
        c0.e eVar5;
        c0.e eVar6;
        View view3;
        d7 enterTransitionCallback;
        d7 exitTransitionCallback;
        ArrayList<String> arrayList4;
        View view4;
        String strQ;
        ArrayList<String> arrayList5;
        b bVar2 = this;
        c0.e eVar7 = eVar;
        c0.e eVar8 = eVar2;
        HashMap map = new HashMap();
        y yVar = null;
        for (m mVar : list) {
            if (!mVar.d()) {
                y yVarE = mVar.e();
                if (yVar == null) {
                    yVar = yVarE;
                } else if (yVarE != null && yVar != yVarE) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + mVar.b().f() + " returned Transition " + mVar.h() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (yVar == null) {
            for (m mVar2 : list) {
                map.put(mVar2.b(), Boolean.FALSE);
                mVar2.a();
            }
            return map;
        }
        View view5 = new View(m().getContext());
        Rect rect = new Rect();
        ArrayList<View> arrayList6 = new ArrayList<>();
        ArrayList<View> arrayList7 = new ArrayList<>();
        androidx.collection.a aVar = new androidx.collection.a();
        Object obj3 = null;
        View view6 = null;
        boolean z8 = false;
        for (m mVar3 : list) {
            if (!mVar3.i() || eVar7 == null || eVar8 == null) {
                arrayList3 = arrayList7;
                bVar = bVar2;
                eVar5 = eVar7;
                eVar6 = eVar8;
                view3 = view5;
                view6 = view6;
            } else {
                Object objB = yVar.B(yVar.g(mVar3.g()));
                ArrayList<String> sharedElementSourceNames = eVar2.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementSourceNames2 = eVar.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementTargetNames = eVar.f().getSharedElementTargetNames();
                View view7 = view6;
                int i7 = 0;
                while (i7 < sharedElementTargetNames.size()) {
                    int iIndexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i7));
                    ArrayList<String> arrayList8 = sharedElementTargetNames;
                    if (iIndexOf != -1) {
                        sharedElementSourceNames.set(iIndexOf, sharedElementSourceNames2.get(i7));
                    }
                    i7++;
                    sharedElementTargetNames = arrayList8;
                }
                ArrayList<String> sharedElementTargetNames2 = eVar2.f().getSharedElementTargetNames();
                if (z7 == 0) {
                    enterTransitionCallback = eVar.f().getExitTransitionCallback();
                    exitTransitionCallback = eVar2.f().getEnterTransitionCallback();
                } else {
                    enterTransitionCallback = eVar.f().getEnterTransitionCallback();
                    exitTransitionCallback = eVar2.f().getExitTransitionCallback();
                }
                int i8 = 0;
                for (int size = sharedElementSourceNames.size(); i8 < size; size = size) {
                    aVar.put(sharedElementSourceNames.get(i8), sharedElementTargetNames2.get(i8));
                    i8++;
                }
                androidx.collection.a<String, View> aVar2 = new androidx.collection.a<>();
                bVar2.u(aVar2, eVar.f().mView);
                aVar2.t(sharedElementSourceNames);
                if (enterTransitionCallback != null) {
                    enterTransitionCallback.d(sharedElementSourceNames, aVar2);
                    int size2 = sharedElementSourceNames.size() - 1;
                    while (size2 >= 0) {
                        String str = sharedElementSourceNames.get(size2);
                        View view8 = aVar2.get(str);
                        if (view8 == null) {
                            aVar.remove(str);
                            arrayList5 = sharedElementSourceNames;
                        } else {
                            arrayList5 = sharedElementSourceNames;
                            if (!str.equals(n2.x0(view8))) {
                                aVar.put(n2.x0(view8), (String) aVar.remove(str));
                            }
                        }
                        size2--;
                        sharedElementSourceNames = arrayList5;
                    }
                    arrayList4 = sharedElementSourceNames;
                } else {
                    arrayList4 = sharedElementSourceNames;
                    aVar.t(aVar2.keySet());
                }
                androidx.collection.a<String, View> aVar3 = new androidx.collection.a<>();
                bVar2.u(aVar3, eVar2.f().mView);
                aVar3.t(sharedElementTargetNames2);
                aVar3.t(aVar.values());
                if (exitTransitionCallback != null) {
                    exitTransitionCallback.d(sharedElementTargetNames2, aVar3);
                    for (int size3 = sharedElementTargetNames2.size() - 1; size3 >= 0; size3--) {
                        String str2 = sharedElementTargetNames2.get(size3);
                        View view9 = aVar3.get(str2);
                        if (view9 == null) {
                            String strQ2 = w.q(aVar, str2);
                            if (strQ2 != null) {
                                aVar.remove(strQ2);
                            }
                        } else if (!str2.equals(n2.x0(view9)) && (strQ = w.q(aVar, str2)) != null) {
                            aVar.put(strQ, n2.x0(view9));
                        }
                    }
                } else {
                    w.y(aVar, aVar3);
                }
                bVar2.v(aVar2, aVar.keySet());
                bVar2.v(aVar3, aVar.values());
                if (aVar.isEmpty()) {
                    arrayList6.clear();
                    arrayList7.clear();
                    eVar5 = eVar;
                    arrayList3 = arrayList7;
                    bVar = bVar2;
                    view3 = view5;
                    view6 = view7;
                    obj3 = null;
                    eVar6 = eVar2;
                } else {
                    w.f(eVar2.f(), eVar.f(), z7, aVar2, true);
                    ArrayList<String> arrayList9 = arrayList4;
                    HashMap map2 = map;
                    View view10 = view5;
                    ArrayList<View> arrayList10 = arrayList7;
                    c2.a(m(), new g(eVar2, eVar, z7, aVar3));
                    arrayList6.addAll(aVar2.values());
                    if (arrayList9.isEmpty()) {
                        view6 = view7;
                    } else {
                        View view11 = aVar2.get(arrayList9.get(0));
                        yVar.v(objB, view11);
                        view6 = view11;
                    }
                    arrayList3 = arrayList10;
                    arrayList3.addAll(aVar3.values());
                    if (sharedElementTargetNames2.isEmpty() || (view4 = aVar3.get(sharedElementTargetNames2.get(0))) == null) {
                        bVar = this;
                    } else {
                        bVar = this;
                        c2.a(m(), bVar.new h(yVar, view4, rect));
                        z8 = true;
                    }
                    yVar.z(objB, view10, arrayList6);
                    view3 = view10;
                    yVar.t(objB, null, null, null, null, objB, arrayList3);
                    Boolean bool = Boolean.TRUE;
                    eVar5 = eVar;
                    map = map2;
                    map.put(eVar5, bool);
                    eVar6 = eVar2;
                    map.put(eVar6, bool);
                    obj3 = objB;
                }
            }
            arrayList6 = arrayList6;
            bVar2 = bVar;
            rect = rect;
            view5 = view3;
            eVar8 = eVar6;
            aVar = aVar;
            arrayList7 = arrayList3;
            eVar7 = eVar5;
            yVar = yVar;
        }
        View view12 = view6;
        androidx.collection.a aVar4 = aVar;
        ArrayList<View> arrayList11 = arrayList7;
        b bVar3 = bVar2;
        c0.e eVar9 = eVar7;
        ArrayList<View> arrayList12 = arrayList6;
        Rect rect2 = rect;
        y yVar2 = yVar;
        c0.e eVar10 = eVar8;
        View view13 = view5;
        ArrayList arrayList13 = new ArrayList();
        Iterator<m> it2 = list.iterator();
        Object obj4 = null;
        Object objN2 = null;
        while (it2.hasNext()) {
            m next = it2.next();
            if (next.d()) {
                map.put(next.b(), Boolean.FALSE);
                next.a();
            } else {
                Object objG = yVar2.g(next.h());
                c0.e eVarB = next.b();
                boolean z9 = obj3 != null && (eVarB == eVar9 || eVarB == eVar10);
                if (objG == null) {
                    if (!z9) {
                        map.put(eVarB, Boolean.FALSE);
                        next.a();
                    }
                    arrayList2 = arrayList11;
                    arrayList = arrayList12;
                    it = it2;
                    view = view13;
                    objN = obj4;
                    eVar3 = eVar10;
                    view2 = view12;
                } else {
                    it = it2;
                    ArrayList<View> arrayList14 = new ArrayList<>();
                    Object obj5 = obj4;
                    bVar3.t(arrayList14, eVarB.f().mView);
                    if (z9) {
                        if (eVarB == eVar9) {
                            arrayList14.removeAll(arrayList12);
                        } else {
                            arrayList14.removeAll(arrayList11);
                        }
                    }
                    if (arrayList14.isEmpty()) {
                        yVar2.a(objG, view13);
                        arrayList2 = arrayList11;
                        arrayList = arrayList12;
                        view = view13;
                        eVar4 = eVarB;
                        obj2 = objN2;
                        eVar3 = eVar10;
                        obj = obj5;
                    } else {
                        yVar2.b(objG, arrayList14);
                        view = view13;
                        obj = obj5;
                        arrayList = arrayList12;
                        obj2 = objN2;
                        arrayList2 = arrayList11;
                        eVar3 = eVar10;
                        yVar2.t(objG, objG, arrayList14, null, null, null, null);
                        if (eVarB.e() == c0.e.c.GONE) {
                            eVar4 = eVarB;
                            list2.remove(eVar4);
                            ArrayList<View> arrayList15 = new ArrayList<>(arrayList14);
                            arrayList15.remove(eVar4.f().mView);
                            yVar2.r(objG, eVar4.f().mView, arrayList15);
                            c2.a(m(), bVar3.new i(arrayList14));
                        } else {
                            eVar4 = eVarB;
                        }
                    }
                    if (eVar4.e() == c0.e.c.VISIBLE) {
                        arrayList13.addAll(arrayList14);
                        if (z8) {
                            yVar2.u(objG, rect2);
                        }
                        view2 = view12;
                    } else {
                        view2 = view12;
                        yVar2.v(objG, view2);
                    }
                    map.put(eVar4, Boolean.TRUE);
                    if (next.j()) {
                        objN2 = yVar2.n(obj2, objG, null);
                        objN = obj;
                    } else {
                        objN = yVar2.n(obj, objG, null);
                        objN2 = obj2;
                    }
                }
                eVar10 = eVar3;
                obj4 = objN;
                view12 = view2;
                view13 = view;
                arrayList12 = arrayList;
                arrayList11 = arrayList2;
                it2 = it;
            }
        }
        ArrayList<View> arrayList16 = arrayList11;
        ArrayList<View> arrayList17 = arrayList12;
        c0.e eVar11 = eVar10;
        Object objM = yVar2.m(objN2, obj4, obj3);
        for (m mVar4 : list) {
            if (!mVar4.d()) {
                Object objH = mVar4.h();
                c0.e eVarB2 = mVar4.b();
                boolean z10 = obj3 != null && (eVarB2 == eVar9 || eVarB2 == eVar11);
                if (objH != null || z10) {
                    if (n2.U0(m())) {
                        yVar2.w(mVar4.b().f(), objM, mVar4.c(), bVar3.new j(mVar4));
                    } else {
                        if (FragmentManager.T0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Container " + m() + " has not been laid out. Completing operation " + eVarB2);
                        }
                        mVar4.a();
                    }
                }
            }
        }
        if (!n2.U0(m())) {
            return map;
        }
        w.B(arrayList13, 4);
        ArrayList<String> arrayListO = yVar2.o(arrayList16);
        yVar2.c(m(), objM);
        yVar2.y(m(), arrayList17, arrayList16, arrayListO, aVar4);
        w.B(arrayList13, 0);
        yVar2.A(obj3, arrayList17, arrayList16);
        return map;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0085  */
    @Override // androidx.fragment.app.c0
    void f(@m0 List<c0.e> list, boolean z7) {
        c0.e eVar = null;
        c0.e eVar2 = null;
        for (c0.e eVar3 : list) {
            c0.e.c cVarC = c0.e.c.c(eVar3.f().mView);
            int i7 = a.f7902a[eVar3.e().ordinal()];
            if (i7 == 1 || i7 == 2 || i7 == 3) {
                if (cVarC == c0.e.c.VISIBLE && eVar == null) {
                    eVar = eVar3;
                }
            } else if (i7 == 4 && cVarC != c0.e.c.VISIBLE) {
                eVar2 = eVar3;
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(list);
        for (c0.e eVar4 : list) {
            androidx.core.os.e eVar5 = new androidx.core.os.e();
            eVar4.j(eVar5);
            arrayList.add(new k(eVar4, eVar5, z7));
            androidx.core.os.e eVar6 = new androidx.core.os.e();
            eVar4.j(eVar6);
            boolean z8 = false;
            if (z7) {
                if (eVar4 == eVar) {
                    z8 = true;
                }
            } else if (eVar4 == eVar2) {
                z8 = true;
            }
            arrayList2.add(new m(eVar4, eVar6, z7, z8));
            eVar4.a(new RunnableC0096b(arrayList3, eVar4));
        }
        Map<c0.e, Boolean> mapX = x(arrayList2, arrayList3, z7, eVar, eVar2);
        w(arrayList, arrayList3, mapX.containsValue(Boolean.TRUE), mapX);
        Iterator<c0.e> it = arrayList3.iterator();
        while (it.hasNext()) {
            s(it.next());
        }
        arrayList3.clear();
    }

    void s(@m0 c0.e eVar) {
        eVar.e().a(eVar.f().mView);
    }

    void t(ArrayList<View> arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (i4.c(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = viewGroup.getChildAt(i7);
            if (childAt.getVisibility() == 0) {
                t(arrayList, childAt);
            }
        }
    }

    void u(Map<String, View> map, @m0 View view) {
        String strX0 = n2.x0(view);
        if (strX0 != null) {
            map.put(strX0, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = viewGroup.getChildAt(i7);
                if (childAt.getVisibility() == 0) {
                    u(map, childAt);
                }
            }
        }
    }

    void v(@m0 androidx.collection.a<String, View> aVar, @m0 Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = aVar.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(n2.x0(it.next().getValue()))) {
                it.remove();
            }
        }
    }
}
