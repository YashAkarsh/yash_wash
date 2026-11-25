package androidx.fragment.app;

import android.content.Context;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.d7;
import androidx.core.view.c2;
import androidx.core.view.n2;
import c.m0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f8099a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final y f8100b = new x();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final y f8101c = x();

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f8102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Fragment f8103b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ androidx.core.os.e f8104c;

        a(g gVar, Fragment fragment, androidx.core.os.e eVar) {
            this.f8102a = gVar;
            this.f8103b = fragment;
            this.f8104c = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8102a.a(this.f8103b, this.f8104c);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f8105a;

        b(ArrayList arrayList) {
            this.f8105a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.B(this.f8105a, 4);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f8106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Fragment f8107b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ androidx.core.os.e f8108c;

        c(g gVar, Fragment fragment, androidx.core.os.e eVar) {
            this.f8106a = gVar;
            this.f8107b = fragment;
            this.f8108c = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8106a.a(this.f8107b, this.f8108c);
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f8109a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ y f8110b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f8111c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Fragment f8112d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f8113e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f8114f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ArrayList f8115g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Object f8116h;

        d(Object obj, y yVar, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            this.f8109a = obj;
            this.f8110b = yVar;
            this.f8111c = view;
            this.f8112d = fragment;
            this.f8113e = arrayList;
            this.f8114f = arrayList2;
            this.f8115g = arrayList3;
            this.f8116h = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj = this.f8109a;
            if (obj != null) {
                this.f8110b.p(obj, this.f8111c);
                this.f8114f.addAll(w.k(this.f8110b, this.f8109a, this.f8112d, this.f8113e, this.f8111c));
            }
            if (this.f8115g != null) {
                if (this.f8116h != null) {
                    ArrayList<View> arrayList = new ArrayList<>();
                    arrayList.add(this.f8111c);
                    this.f8110b.q(this.f8116h, this.f8115g, arrayList);
                }
                this.f8115g.clear();
                this.f8115g.add(this.f8111c);
            }
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Fragment f8117a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Fragment f8118b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f8119c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ androidx.collection.a f8120d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f8121e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ y f8122f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Rect f8123g;

        e(Fragment fragment, Fragment fragment2, boolean z7, androidx.collection.a aVar, View view, y yVar, Rect rect) {
            this.f8117a = fragment;
            this.f8118b = fragment2;
            this.f8119c = z7;
            this.f8120d = aVar;
            this.f8121e = view;
            this.f8122f = yVar;
            this.f8123g = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.f(this.f8117a, this.f8118b, this.f8119c, this.f8120d, false);
            View view = this.f8121e;
            if (view != null) {
                this.f8122f.k(view, this.f8123g);
            }
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ y f8124a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ androidx.collection.a f8125b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f8126c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ h f8127d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f8128e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f8129f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Fragment f8130g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Fragment f8131h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f8132i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ ArrayList f8133j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ Object f8134k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ Rect f8135l;

        f(y yVar, androidx.collection.a aVar, Object obj, h hVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z7, ArrayList arrayList2, Object obj2, Rect rect) {
            this.f8124a = yVar;
            this.f8125b = aVar;
            this.f8126c = obj;
            this.f8127d = hVar;
            this.f8128e = arrayList;
            this.f8129f = view;
            this.f8130g = fragment;
            this.f8131h = fragment2;
            this.f8132i = z7;
            this.f8133j = arrayList2;
            this.f8134k = obj2;
            this.f8135l = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.collection.a<String, View> aVarH = w.h(this.f8124a, this.f8125b, this.f8126c, this.f8127d);
            if (aVarH != null) {
                this.f8128e.addAll(aVarH.values());
                this.f8128e.add(this.f8129f);
            }
            w.f(this.f8130g, this.f8131h, this.f8132i, aVarH, false);
            Object obj = this.f8126c;
            if (obj != null) {
                this.f8124a.A(obj, this.f8133j, this.f8128e);
                View viewT = w.t(aVarH, this.f8127d, this.f8134k, this.f8132i);
                if (viewT != null) {
                    this.f8124a.k(viewT, this.f8135l);
                }
            }
        }
    }

    interface g {
        void a(@m0 Fragment fragment, @m0 androidx.core.os.e eVar);

        void b(@m0 Fragment fragment, @m0 androidx.core.os.e eVar);
    }

    static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Fragment f8136a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f8137b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public androidx.fragment.app.a f8138c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Fragment f8139d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f8140e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public androidx.fragment.app.a f8141f;

        h() {
        }
    }

    private w() {
    }

    private static void A(y yVar, Object obj, Object obj2, androidx.collection.a<String, View> aVar, boolean z7, androidx.fragment.app.a aVar2) {
        ArrayList<String> arrayList = aVar2.f8087p;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        View view = aVar.get(z7 ? aVar2.f8088q.get(0) : aVar2.f8087p.get(0));
        yVar.v(obj, view);
        if (obj2 != null) {
            yVar.v(obj2, view);
        }
    }

    static void B(ArrayList<View> arrayList, int i7) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i7);
        }
    }

    static void C(@m0 Context context, @m0 androidx.fragment.app.e eVar, ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i7, int i8, boolean z7, g gVar) {
        ViewGroup viewGroup;
        SparseArray sparseArray = new SparseArray();
        for (int i9 = i7; i9 < i8; i9++) {
            androidx.fragment.app.a aVar = arrayList.get(i9);
            if (arrayList2.get(i9).booleanValue()) {
                e(aVar, sparseArray, z7);
            } else {
                c(aVar, sparseArray, z7);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(context);
            int size = sparseArray.size();
            for (int i10 = 0; i10 < size; i10++) {
                int iKeyAt = sparseArray.keyAt(i10);
                androidx.collection.a<String, String> aVarD = d(iKeyAt, arrayList, arrayList2, i7, i8);
                h hVar = (h) sparseArray.valueAt(i10);
                if (eVar.d() && (viewGroup = (ViewGroup) eVar.c(iKeyAt)) != null) {
                    if (z7) {
                        o(viewGroup, hVar, view, aVarD, gVar);
                    } else {
                        n(viewGroup, hVar, view, aVarD, gVar);
                    }
                }
            }
        }
    }

    static boolean D() {
        return (f8100b == null && f8101c == null) ? false : true;
    }

    private static void a(ArrayList<View> arrayList, androidx.collection.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View viewO = aVar.o(size);
            if (collection.contains(n2.x0(viewO))) {
                arrayList.add(viewO);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x0058  */
    /* JADX WARN: Code duplicated, block: B:55:0x006f  */
    /* JADX WARN: Code duplicated, block: B:56:0x0071  */
    /* JADX WARN: Code duplicated, block: B:63:0x0080 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:64:0x0082  */
    /* JADX WARN: Code duplicated, block: B:65:0x0085  */
    /* JADX WARN: Code duplicated, block: B:69:0x008d  */
    /* JADX WARN: Code duplicated, block: B:70:0x008f  */
    private static void b(androidx.fragment.app.a aVar, v.a aVar2, SparseArray<h> sparseArray, boolean z7, boolean z8) {
        int i7;
        boolean z9;
        boolean z10;
        boolean z11;
        View view;
        boolean z12;
        Fragment fragment = aVar2.f8092b;
        if (fragment == null || (i7 = fragment.mContainerId) == 0) {
            return;
        }
        int i8 = z7 ? f8099a[aVar2.f8091a] : aVar2.f8091a;
        boolean z13 = false;
        boolean z14 = true;
        if (i8 == 1) {
            if (z8) {
                z9 = fragment.mIsNewlyAdded;
            } else if (!fragment.mAdded || fragment.mHidden) {
                z9 = false;
            } else {
                z9 = true;
            }
            z10 = false;
            z13 = z9;
            z11 = false;
        } else if (i8 == 3) {
            if (z8 ? !fragment.mAdded || fragment.mHidden : fragment.mAdded || (view = fragment.mView) == null || view.getVisibility() != 0 || fragment.mPostponedAlpha < 0.0f) {
                z12 = false;
            } else {
                z12 = true;
            }
            z10 = z12;
            z11 = true;
            z14 = false;
        } else if (i8 == 4) {
            if (!z8 ? !(!fragment.mAdded || fragment.mHidden) : fragment.mHiddenChanged && fragment.mAdded && fragment.mHidden) {
                z12 = false;
            } else {
                z12 = true;
            }
            z10 = z12;
            z11 = true;
            z14 = false;
        } else if (i8 == 5) {
            if (!z8) {
                z9 = fragment.mHidden;
            } else if (fragment.mHiddenChanged && !fragment.mHidden && fragment.mAdded) {
                z9 = true;
            } else {
                z9 = false;
            }
            z10 = false;
            z13 = z9;
            z11 = false;
        } else if (i8 == 6) {
            if (z8) {
                z12 = false;
            } else {
                z12 = false;
            }
            z10 = z12;
            z11 = true;
            z14 = false;
        } else if (i8 != 7) {
            z11 = false;
            z14 = false;
            z10 = false;
        } else {
            if (z8) {
                z9 = fragment.mIsNewlyAdded;
            } else {
                if (fragment.mAdded) {
                }
                z9 = false;
            }
            z10 = false;
            z13 = z9;
            z11 = false;
        }
        h hVarP = sparseArray.get(i7);
        if (z13) {
            hVarP = p(hVarP, sparseArray, i7);
            hVarP.f8136a = fragment;
            hVarP.f8137b = z7;
            hVarP.f8138c = aVar;
        }
        if (!z8 && z14) {
            if (hVarP != null && hVarP.f8139d == fragment) {
                hVarP.f8139d = null;
            }
            if (!aVar.f8089r) {
                FragmentManager fragmentManager = aVar.L;
                fragmentManager.F0().q(fragmentManager.A(fragment));
                fragmentManager.f1(fragment);
            }
        }
        if (z10 && (hVarP == null || hVarP.f8139d == null)) {
            hVarP = p(hVarP, sparseArray, i7);
            hVarP.f8139d = fragment;
            hVarP.f8140e = z7;
            hVarP.f8141f = aVar;
        }
        if (z8 || !z11 || hVarP == null || hVarP.f8136a != fragment) {
            return;
        }
        hVarP.f8136a = null;
    }

    public static void c(androidx.fragment.app.a aVar, SparseArray<h> sparseArray, boolean z7) {
        int size = aVar.f8074c.size();
        for (int i7 = 0; i7 < size; i7++) {
            b(aVar, aVar.f8074c.get(i7), sparseArray, false, z7);
        }
    }

    private static androidx.collection.a<String, String> d(int i7, ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i8, int i9) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        androidx.collection.a<String, String> aVar = new androidx.collection.a<>();
        for (int i10 = i9 - 1; i10 >= i8; i10--) {
            androidx.fragment.app.a aVar2 = arrayList.get(i10);
            if (aVar2.c0(i7)) {
                boolean zBooleanValue = arrayList2.get(i10).booleanValue();
                ArrayList<String> arrayList5 = aVar2.f8087p;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (zBooleanValue) {
                        arrayList3 = aVar2.f8087p;
                        arrayList4 = aVar2.f8088q;
                    } else {
                        ArrayList<String> arrayList6 = aVar2.f8087p;
                        arrayList3 = aVar2.f8088q;
                        arrayList4 = arrayList6;
                    }
                    for (int i11 = 0; i11 < size; i11++) {
                        String str = arrayList4.get(i11);
                        String str2 = arrayList3.get(i11);
                        String strRemove = aVar.remove(str2);
                        if (strRemove != null) {
                            aVar.put(str, strRemove);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    public static void e(androidx.fragment.app.a aVar, SparseArray<h> sparseArray, boolean z7) {
        if (aVar.L.B0().d()) {
            for (int size = aVar.f8074c.size() - 1; size >= 0; size--) {
                b(aVar, aVar.f8074c.get(size), sparseArray, true, z7);
            }
        }
    }

    static void f(Fragment fragment, Fragment fragment2, boolean z7, androidx.collection.a<String, View> aVar, boolean z8) {
        d7 enterTransitionCallback = z7 ? fragment2.getEnterTransitionCallback() : fragment.getEnterTransitionCallback();
        if (enterTransitionCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = aVar == null ? 0 : aVar.size();
            for (int i7 = 0; i7 < size; i7++) {
                arrayList2.add(aVar.k(i7));
                arrayList.add(aVar.o(i7));
            }
            if (z8) {
                enterTransitionCallback.g(arrayList2, arrayList, null);
            } else {
                enterTransitionCallback.f(arrayList2, arrayList, null);
            }
        }
    }

    private static boolean g(y yVar, List<Object> list) {
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            if (!yVar.e(list.get(i7))) {
                return false;
            }
        }
        return true;
    }

    static androidx.collection.a<String, View> h(y yVar, androidx.collection.a<String, String> aVar, Object obj, h hVar) {
        d7 enterTransitionCallback;
        ArrayList<String> arrayList;
        String strQ;
        Fragment fragment = hVar.f8136a;
        View view = fragment.getView();
        if (aVar.isEmpty() || obj == null || view == null) {
            aVar.clear();
            return null;
        }
        androidx.collection.a<String, View> aVar2 = new androidx.collection.a<>();
        yVar.j(aVar2, view);
        androidx.fragment.app.a aVar3 = hVar.f8138c;
        if (hVar.f8137b) {
            enterTransitionCallback = fragment.getExitTransitionCallback();
            arrayList = aVar3.f8087p;
        } else {
            enterTransitionCallback = fragment.getEnterTransitionCallback();
            arrayList = aVar3.f8088q;
        }
        if (arrayList != null) {
            aVar2.t(arrayList);
            aVar2.t(aVar.values());
        }
        if (enterTransitionCallback != null) {
            enterTransitionCallback.d(arrayList, aVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view2 = aVar2.get(str);
                if (view2 == null) {
                    String strQ2 = q(aVar, str);
                    if (strQ2 != null) {
                        aVar.remove(strQ2);
                    }
                } else if (!str.equals(n2.x0(view2)) && (strQ = q(aVar, str)) != null) {
                    aVar.put(strQ, n2.x0(view2));
                }
            }
        } else {
            y(aVar, aVar2);
        }
        return aVar2;
    }

    private static androidx.collection.a<String, View> i(y yVar, androidx.collection.a<String, String> aVar, Object obj, h hVar) {
        d7 exitTransitionCallback;
        ArrayList<String> arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        Fragment fragment = hVar.f8139d;
        androidx.collection.a<String, View> aVar2 = new androidx.collection.a<>();
        yVar.j(aVar2, fragment.requireView());
        androidx.fragment.app.a aVar3 = hVar.f8141f;
        if (hVar.f8140e) {
            exitTransitionCallback = fragment.getEnterTransitionCallback();
            arrayList = aVar3.f8088q;
        } else {
            exitTransitionCallback = fragment.getExitTransitionCallback();
            arrayList = aVar3.f8087p;
        }
        if (arrayList != null) {
            aVar2.t(arrayList);
        }
        if (exitTransitionCallback != null) {
            exitTransitionCallback.d(arrayList, aVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = aVar2.get(str);
                if (view == null) {
                    aVar.remove(str);
                } else if (!str.equals(n2.x0(view))) {
                    aVar.put(n2.x0(view), aVar.remove(str));
                }
            }
        } else {
            aVar.t(aVar2.keySet());
        }
        return aVar2;
    }

    private static y j(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        y yVar = f8100b;
        if (yVar != null && g(yVar, arrayList)) {
            return yVar;
        }
        y yVar2 = f8101c;
        if (yVar2 != null && g(yVar2, arrayList)) {
            return yVar2;
        }
        if (yVar == null && yVar2 == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    static ArrayList<View> k(y yVar, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = fragment.getView();
        if (view2 != null) {
            yVar.f(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        yVar.b(obj, arrayList2);
        return arrayList2;
    }

    private static Object l(y yVar, ViewGroup viewGroup, View view, androidx.collection.a<String, String> aVar, h hVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        Rect rect;
        Fragment fragment = hVar.f8136a;
        Fragment fragment2 = hVar.f8139d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z7 = hVar.f8137b;
        Object objU = aVar.isEmpty() ? null : u(yVar, fragment, fragment2, z7);
        androidx.collection.a<String, View> aVarI = i(yVar, aVar, objU, hVar);
        if (aVar.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(aVarI.values());
            obj3 = objU;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z7, aVarI, true);
        if (obj3 != null) {
            rect = new Rect();
            yVar.z(obj3, view, arrayList);
            A(yVar, obj3, obj2, aVarI, hVar.f8140e, hVar.f8141f);
            if (obj != null) {
                yVar.u(obj, rect);
            }
        } else {
            rect = null;
        }
        c2.a(viewGroup, new f(yVar, aVar, obj3, hVar, arrayList2, view, fragment, fragment2, z7, arrayList, obj, rect));
        return obj3;
    }

    private static Object m(y yVar, ViewGroup viewGroup, View view, androidx.collection.a<String, String> aVar, h hVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        View view2;
        Rect rect;
        Fragment fragment = hVar.f8136a;
        Fragment fragment2 = hVar.f8139d;
        if (fragment != null) {
            fragment.requireView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z7 = hVar.f8137b;
        Object objU = aVar.isEmpty() ? null : u(yVar, fragment, fragment2, z7);
        androidx.collection.a<String, View> aVarI = i(yVar, aVar, objU, hVar);
        androidx.collection.a<String, View> aVarH = h(yVar, aVar, objU, hVar);
        if (aVar.isEmpty()) {
            if (aVarI != null) {
                aVarI.clear();
            }
            if (aVarH != null) {
                aVarH.clear();
            }
            obj3 = null;
        } else {
            a(arrayList, aVarI, aVar.keySet());
            a(arrayList2, aVarH, aVar.values());
            obj3 = objU;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z7, aVarI, true);
        if (obj3 != null) {
            arrayList2.add(view);
            yVar.z(obj3, view, arrayList);
            A(yVar, obj3, obj2, aVarI, hVar.f8140e, hVar.f8141f);
            Rect rect2 = new Rect();
            View viewT = t(aVarH, hVar, obj, z7);
            if (viewT != null) {
                yVar.u(obj, rect2);
            }
            rect = rect2;
            view2 = viewT;
        } else {
            view2 = null;
            rect = null;
        }
        c2.a(viewGroup, new e(fragment, fragment2, z7, aVarH, view2, yVar, rect));
        return obj3;
    }

    private static void n(@m0 ViewGroup viewGroup, h hVar, View view, androidx.collection.a<String, String> aVar, g gVar) {
        Object obj;
        Fragment fragment = hVar.f8136a;
        Fragment fragment2 = hVar.f8139d;
        y yVarJ = j(fragment2, fragment);
        if (yVarJ == null) {
            return;
        }
        boolean z7 = hVar.f8137b;
        boolean z8 = hVar.f8140e;
        Object objR = r(yVarJ, fragment, z7);
        Object objS = s(yVarJ, fragment2, z8);
        ArrayList arrayList = new ArrayList();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object objL = l(yVarJ, viewGroup, view, aVar, hVar, arrayList, arrayList2, objR, objS);
        if (objR == null && objL == null) {
            obj = objS;
            if (obj == null) {
                return;
            }
        } else {
            obj = objS;
        }
        ArrayList<View> arrayListK = k(yVarJ, obj, fragment2, arrayList, view);
        if (arrayListK == null || arrayListK.isEmpty()) {
            obj = null;
        }
        Object obj2 = obj;
        yVarJ.a(objR, view);
        Object objV = v(yVarJ, objR, obj2, objL, fragment, hVar.f8137b);
        if (fragment2 != null && arrayListK != null && (arrayListK.size() > 0 || arrayList.size() > 0)) {
            androidx.core.os.e eVar = new androidx.core.os.e();
            gVar.b(fragment2, eVar);
            yVarJ.w(fragment2, objV, eVar, new c(gVar, fragment2, eVar));
        }
        if (objV != null) {
            ArrayList<View> arrayList3 = new ArrayList<>();
            yVarJ.t(objV, objR, arrayList3, obj2, arrayListK, objL, arrayList2);
            z(yVarJ, viewGroup, fragment, view, arrayList2, objR, arrayList3, obj2, arrayListK);
            yVarJ.x(viewGroup, arrayList2, aVar);
            yVarJ.c(viewGroup, objV);
            yVarJ.s(viewGroup, arrayList2, aVar);
        }
    }

    private static void o(@m0 ViewGroup viewGroup, h hVar, View view, androidx.collection.a<String, String> aVar, g gVar) {
        Object obj;
        Fragment fragment = hVar.f8136a;
        Fragment fragment2 = hVar.f8139d;
        y yVarJ = j(fragment2, fragment);
        if (yVarJ == null) {
            return;
        }
        boolean z7 = hVar.f8137b;
        boolean z8 = hVar.f8140e;
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object objR = r(yVarJ, fragment, z7);
        Object objS = s(yVarJ, fragment2, z8);
        Object objM = m(yVarJ, viewGroup, view, aVar, hVar, arrayList2, arrayList, objR, objS);
        if (objR == null && objM == null) {
            obj = objS;
            if (obj == null) {
                return;
            }
        } else {
            obj = objS;
        }
        ArrayList<View> arrayListK = k(yVarJ, obj, fragment2, arrayList2, view);
        ArrayList<View> arrayListK2 = k(yVarJ, objR, fragment, arrayList, view);
        B(arrayListK2, 4);
        Object objV = v(yVarJ, objR, obj, objM, fragment, z7);
        if (fragment2 != null && arrayListK != null && (arrayListK.size() > 0 || arrayList2.size() > 0)) {
            androidx.core.os.e eVar = new androidx.core.os.e();
            gVar.b(fragment2, eVar);
            yVarJ.w(fragment2, objV, eVar, new a(gVar, fragment2, eVar));
        }
        if (objV != null) {
            w(yVarJ, obj, fragment2, arrayListK);
            ArrayList<String> arrayListO = yVarJ.o(arrayList);
            yVarJ.t(objV, objR, arrayListK2, obj, arrayListK, objM, arrayList);
            yVarJ.c(viewGroup, objV);
            yVarJ.y(viewGroup, arrayList2, arrayList, arrayListO, aVar);
            B(arrayListK2, 0);
            yVarJ.A(objM, arrayList2, arrayList);
        }
    }

    private static h p(h hVar, SparseArray<h> sparseArray, int i7) {
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h();
        sparseArray.put(i7, hVar2);
        return hVar2;
    }

    static String q(androidx.collection.a<String, String> aVar, String str) {
        int size = aVar.size();
        for (int i7 = 0; i7 < size; i7++) {
            if (str.equals(aVar.o(i7))) {
                return aVar.k(i7);
            }
        }
        return null;
    }

    private static Object r(y yVar, Fragment fragment, boolean z7) {
        if (fragment == null) {
            return null;
        }
        return yVar.g(z7 ? fragment.getReenterTransition() : fragment.getEnterTransition());
    }

    private static Object s(y yVar, Fragment fragment, boolean z7) {
        if (fragment == null) {
            return null;
        }
        return yVar.g(z7 ? fragment.getReturnTransition() : fragment.getExitTransition());
    }

    static View t(androidx.collection.a<String, View> aVar, h hVar, Object obj, boolean z7) {
        ArrayList<String> arrayList;
        androidx.fragment.app.a aVar2 = hVar.f8138c;
        if (obj == null || aVar == null || (arrayList = aVar2.f8087p) == null || arrayList.isEmpty()) {
            return null;
        }
        return aVar.get(z7 ? aVar2.f8087p.get(0) : aVar2.f8088q.get(0));
    }

    private static Object u(y yVar, Fragment fragment, Fragment fragment2, boolean z7) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return yVar.B(yVar.g(z7 ? fragment2.getSharedElementReturnTransition() : fragment.getSharedElementEnterTransition()));
    }

    private static Object v(y yVar, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z7) {
        boolean allowReturnTransitionOverlap;
        if (obj == null || obj2 == null || fragment == null) {
            allowReturnTransitionOverlap = true;
        } else {
            allowReturnTransitionOverlap = z7 ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
        }
        return allowReturnTransitionOverlap ? yVar.n(obj2, obj, obj3) : yVar.m(obj2, obj, obj3);
    }

    private static void w(y yVar, Object obj, Fragment fragment, ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            yVar.r(obj, fragment.getView(), arrayList);
            c2.a(fragment.mContainer, new b(arrayList));
        }
    }

    private static y x() {
        try {
            return (y) androidx.transition.g.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static void y(@m0 androidx.collection.a<String, String> aVar, @m0 androidx.collection.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.o(size))) {
                aVar.m(size);
            }
        }
    }

    private static void z(y yVar, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        c2.a(viewGroup, new d(obj, yVar, view, fragment, arrayList, arrayList2, arrayList3, obj2));
    }
}
