package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.core.view.n2;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes.dex */
public abstract class Transition implements Cloneable {
    private static final String H = "Transition";
    static final boolean I = false;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final int f10609J = 1;
    private static final int K = 1;
    public static final int L = 2;
    public static final int M = 3;
    public static final int N = 4;
    private static final int O = 4;
    private static final String P = "instance";
    private static final String Q = "name";
    private static final String R = "id";
    private static final String S = "itemId";
    private static final int[] T = {2, 1, 3, 4};
    private static final PathMotion U = new a();
    private static ThreadLocal<androidx.collection.a<Animator, d>> V = new ThreadLocal<>();
    a0 D;
    private f E;
    private androidx.collection.a<String, String> F;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ArrayList<d0> f10629t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ArrayList<d0> f10630u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10610a = getClass().getName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f10611b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f10612c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TimeInterpolator f10613d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ArrayList<Integer> f10614e = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    ArrayList<View> f10615f = new ArrayList<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ArrayList<String> f10616g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ArrayList<Class<?>> f10617h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ArrayList<Integer> f10618i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ArrayList<View> f10619j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ArrayList<Class<?>> f10620k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ArrayList<String> f10621l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ArrayList<Integer> f10622m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ArrayList<View> f10623n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ArrayList<Class<?>> f10624o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private e0 f10625p = new e0();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private e0 f10626q = new e0();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    TransitionSet f10627r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int[] f10628s = T;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ViewGroup f10631v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    boolean f10632w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    ArrayList<Animator> f10633x = new ArrayList<>();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f10634y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f10635z = false;
    private boolean A = false;
    private ArrayList<h> B = null;
    private ArrayList<Animator> C = new ArrayList<>();
    private PathMotion G = U;

    static class a extends PathMotion {
        a() {
        }

        @Override // androidx.transition.PathMotion
        public Path a(float f8, float f9, float f10, float f11) {
            Path path = new Path();
            path.moveTo(f8, f9);
            path.lineTo(f10, f11);
            return path;
        }
    }

    class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ androidx.collection.a f10636a;

        b(androidx.collection.a aVar) {
            this.f10636a = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f10636a.remove(animator);
            Transition.this.f10633x.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Transition.this.f10633x.add(animator);
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Transition.this.t();
            animator.removeListener(this);
        }
    }

    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        View f10639a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f10640b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        d0 f10641c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        h1 f10642d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Transition f10643e;

        d(View view, String str, Transition transition, h1 h1Var, d0 d0Var) {
            this.f10639a = view;
            this.f10640b = str;
            this.f10641c = d0Var;
            this.f10642d = h1Var;
            this.f10643e = transition;
        }
    }

    private static class e {
        private e() {
        }

        static <T> ArrayList<T> a(ArrayList<T> arrayList, T t7) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (!arrayList.contains(t7)) {
                arrayList.add(t7);
            }
            return arrayList;
        }

        static <T> ArrayList<T> b(ArrayList<T> arrayList, T t7) {
            if (arrayList == null) {
                return arrayList;
            }
            arrayList.remove(t7);
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList;
        }
    }

    public static abstract class f {
        public abstract Rect a(@c.m0 Transition transition);
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface g {
    }

    public interface h {
        void a(@c.m0 Transition transition);

        void b(@c.m0 Transition transition);

        void c(@c.m0 Transition transition);

        void d(@c.m0 Transition transition);

        void e(@c.m0 Transition transition);
    }

    public Transition() {
    }

    private ArrayList<Class<?>> D(ArrayList<Class<?>> arrayList, Class<?> cls, boolean z7) {
        if (cls != null) {
            return z7 ? e.a(arrayList, cls) : e.b(arrayList, cls);
        }
        return arrayList;
    }

    private ArrayList<View> E(ArrayList<View> arrayList, View view, boolean z7) {
        if (view != null) {
            return z7 ? e.a(arrayList, view) : e.b(arrayList, view);
        }
        return arrayList;
    }

    private static androidx.collection.a<Animator, d> P() {
        androidx.collection.a<Animator, d> aVar = V.get();
        if (aVar != null) {
            return aVar;
        }
        androidx.collection.a<Animator, d> aVar2 = new androidx.collection.a<>();
        V.set(aVar2);
        return aVar2;
    }

    private static boolean Y(int i7) {
        return i7 >= 1 && i7 <= 4;
    }

    private static boolean a0(d0 d0Var, d0 d0Var2, String str) {
        Object obj = d0Var.f10674a.get(str);
        Object obj2 = d0Var2.f10674a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    private void b0(androidx.collection.a<View, d0> aVar, androidx.collection.a<View, d0> aVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i7 = 0; i7 < size; i7++) {
            View viewValueAt = sparseArray.valueAt(i7);
            if (viewValueAt != null && Z(viewValueAt) && (view = sparseArray2.get(sparseArray.keyAt(i7))) != null && Z(view)) {
                d0 d0Var = aVar.get(viewValueAt);
                d0 d0Var2 = aVar2.get(view);
                if (d0Var != null && d0Var2 != null) {
                    this.f10629t.add(d0Var);
                    this.f10630u.add(d0Var2);
                    aVar.remove(viewValueAt);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void c0(androidx.collection.a<View, d0> aVar, androidx.collection.a<View, d0> aVar2) {
        d0 d0VarRemove;
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View viewK = aVar.k(size);
            if (viewK != null && Z(viewK) && (d0VarRemove = aVar2.remove(viewK)) != null && Z(d0VarRemove.f10675b)) {
                this.f10629t.add(aVar.m(size));
                this.f10630u.add(d0VarRemove);
            }
        }
    }

    private void d0(androidx.collection.a<View, d0> aVar, androidx.collection.a<View, d0> aVar2, androidx.collection.f<View> fVar, androidx.collection.f<View> fVar2) {
        View viewM;
        int iB = fVar.B();
        for (int i7 = 0; i7 < iB; i7++) {
            View viewC = fVar.C(i7);
            if (viewC != null && Z(viewC) && (viewM = fVar2.m(fVar.r(i7))) != null && Z(viewM)) {
                d0 d0Var = aVar.get(viewC);
                d0 d0Var2 = aVar2.get(viewM);
                if (d0Var != null && d0Var2 != null) {
                    this.f10629t.add(d0Var);
                    this.f10630u.add(d0Var2);
                    aVar.remove(viewC);
                    aVar2.remove(viewM);
                }
            }
        }
    }

    private void e0(androidx.collection.a<View, d0> aVar, androidx.collection.a<View, d0> aVar2, androidx.collection.a<String, View> aVar3, androidx.collection.a<String, View> aVar4) {
        View view;
        int size = aVar3.size();
        for (int i7 = 0; i7 < size; i7++) {
            View viewO = aVar3.o(i7);
            if (viewO != null && Z(viewO) && (view = aVar4.get(aVar3.k(i7))) != null && Z(view)) {
                d0 d0Var = aVar.get(viewO);
                d0 d0Var2 = aVar2.get(view);
                if (d0Var != null && d0Var2 != null) {
                    this.f10629t.add(d0Var);
                    this.f10630u.add(d0Var2);
                    aVar.remove(viewO);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void f0(e0 e0Var, e0 e0Var2) {
        androidx.collection.a<View, d0> aVar = new androidx.collection.a<>(e0Var.f10685a);
        androidx.collection.a<View, d0> aVar2 = new androidx.collection.a<>(e0Var2.f10685a);
        int i7 = 0;
        while (true) {
            int[] iArr = this.f10628s;
            if (i7 >= iArr.length) {
                g(aVar, aVar2);
                return;
            }
            int i8 = iArr[i7];
            if (i8 == 1) {
                c0(aVar, aVar2);
            } else if (i8 == 2) {
                e0(aVar, aVar2, e0Var.f10688d, e0Var2.f10688d);
            } else if (i8 == 3) {
                b0(aVar, aVar2, e0Var.f10686b, e0Var2.f10686b);
            } else if (i8 == 4) {
                d0(aVar, aVar2, e0Var.f10687c, e0Var2.f10687c);
            }
            i7++;
        }
    }

    private void g(androidx.collection.a<View, d0> aVar, androidx.collection.a<View, d0> aVar2) {
        for (int i7 = 0; i7 < aVar.size(); i7++) {
            d0 d0VarO = aVar.o(i7);
            if (Z(d0VarO.f10675b)) {
                this.f10629t.add(d0VarO);
                this.f10630u.add(null);
            }
        }
        for (int i8 = 0; i8 < aVar2.size(); i8++) {
            d0 d0VarO2 = aVar2.o(i8);
            if (Z(d0VarO2.f10675b)) {
                this.f10630u.add(d0VarO2);
                this.f10629t.add(null);
            }
        }
    }

    private static int[] g0(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i7 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String strTrim = stringTokenizer.nextToken().trim();
            if ("id".equalsIgnoreCase(strTrim)) {
                iArr[i7] = 3;
            } else if (P.equalsIgnoreCase(strTrim)) {
                iArr[i7] = 1;
            } else if ("name".equalsIgnoreCase(strTrim)) {
                iArr[i7] = 2;
            } else if (S.equalsIgnoreCase(strTrim)) {
                iArr[i7] = 4;
            } else {
                if (!strTrim.isEmpty()) {
                    throw new InflateException("Unknown match type in matchOrder: '" + strTrim + "'");
                }
                int[] iArr2 = new int[iArr.length - 1];
                System.arraycopy(iArr, 0, iArr2, 0, i7);
                i7--;
                iArr = iArr2;
            }
            i7++;
        }
        return iArr;
    }

    private static void h(e0 e0Var, View view, d0 d0Var) {
        e0Var.f10685a.put(view, d0Var);
        int id = view.getId();
        if (id >= 0) {
            if (e0Var.f10686b.indexOfKey(id) >= 0) {
                e0Var.f10686b.put(id, null);
            } else {
                e0Var.f10686b.put(id, view);
            }
        }
        String strX0 = n2.x0(view);
        if (strX0 != null) {
            if (e0Var.f10688d.containsKey(strX0)) {
                e0Var.f10688d.put(strX0, null);
            } else {
                e0Var.f10688d.put(strX0, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (e0Var.f10687c.o(itemIdAtPosition) < 0) {
                    n2.Q1(view, true);
                    e0Var.f10687c.s(itemIdAtPosition, view);
                    return;
                }
                View viewM = e0Var.f10687c.m(itemIdAtPosition);
                if (viewM != null) {
                    n2.Q1(viewM, false);
                    e0Var.f10687c.s(itemIdAtPosition, null);
                }
            }
        }
    }

    private static boolean i(int[] iArr, int i7) {
        int i8 = iArr[i7];
        for (int i9 = 0; i9 < i7; i9++) {
            if (iArr[i9] == i8) {
                return true;
            }
        }
        return false;
    }

    private void l(View view, boolean z7) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList<Integer> arrayList = this.f10618i;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList2 = this.f10619j;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList<Class<?>> arrayList3 = this.f10620k;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i7 = 0; i7 < size; i7++) {
                        if (this.f10620k.get(i7).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    d0 d0Var = new d0(view);
                    if (z7) {
                        n(d0Var);
                    } else {
                        k(d0Var);
                    }
                    d0Var.f10676c.add(this);
                    m(d0Var);
                    if (z7) {
                        h(this.f10625p, view, d0Var);
                    } else {
                        h(this.f10626q, view, d0Var);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList<Integer> arrayList4 = this.f10622m;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList<View> arrayList5 = this.f10623n;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList<Class<?>> arrayList6 = this.f10624o;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i8 = 0; i8 < size2; i8++) {
                                    if (this.f10624o.get(i8).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i9 = 0; i9 < viewGroup.getChildCount(); i9++) {
                                l(viewGroup.getChildAt(i9), z7);
                            }
                        }
                    }
                }
            }
        }
    }

    private void q0(Animator animator, androidx.collection.a<Animator, d> aVar) {
        if (animator != null) {
            animator.addListener(new b(aVar));
            j(animator);
        }
    }

    private ArrayList<Integer> x(ArrayList<Integer> arrayList, int i7, boolean z7) {
        if (i7 > 0) {
            return z7 ? e.a(arrayList, Integer.valueOf(i7)) : e.b(arrayList, Integer.valueOf(i7));
        }
        return arrayList;
    }

    private static <T> ArrayList<T> y(ArrayList<T> arrayList, T t7, boolean z7) {
        if (t7 != null) {
            return z7 ? e.a(arrayList, t7) : e.b(arrayList, t7);
        }
        return arrayList;
    }

    @c.m0
    public Transition A(@c.m0 View view, boolean z7) {
        this.f10619j = E(this.f10619j, view, z7);
        return this;
    }

    @c.m0
    public Transition A0(long j7) {
        this.f10611b = j7;
        return this;
    }

    @c.m0
    public Transition B(@c.m0 Class<?> cls, boolean z7) {
        this.f10620k = D(this.f10620k, cls, z7);
        return this;
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    protected void B0() {
        if (this.f10634y == 0) {
            ArrayList<h> arrayList = this.B;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.B.clone();
                int size = arrayList2.size();
                for (int i7 = 0; i7 < size; i7++) {
                    ((h) arrayList2.get(i7)).a(this);
                }
            }
            this.A = false;
        }
        this.f10634y++;
    }

    @c.m0
    public Transition C(@c.m0 String str, boolean z7) {
        this.f10621l = y(this.f10621l, str, z7);
        return this;
    }

    String C0(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f10612c != -1) {
            str2 = str2 + "dur(" + this.f10612c + ") ";
        }
        if (this.f10611b != -1) {
            str2 = str2 + "dly(" + this.f10611b + ") ";
        }
        if (this.f10613d != null) {
            str2 = str2 + "interp(" + this.f10613d + ") ";
        }
        if (this.f10614e.size() <= 0 && this.f10615f.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.f10614e.size() > 0) {
            for (int i7 = 0; i7 < this.f10614e.size(); i7++) {
                if (i7 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f10614e.get(i7);
            }
        }
        if (this.f10615f.size() > 0) {
            for (int i8 = 0; i8 < this.f10615f.size(); i8++) {
                if (i8 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f10615f.get(i8);
            }
        }
        return str3 + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    void F(ViewGroup viewGroup) {
        androidx.collection.a<Animator, d> aVarP = P();
        int size = aVarP.size();
        if (viewGroup == null || size == 0) {
            return;
        }
        h1 h1VarD = q0.d(viewGroup);
        androidx.collection.a aVar = new androidx.collection.a(aVarP);
        aVarP.clear();
        for (int i7 = size - 1; i7 >= 0; i7--) {
            d dVar = (d) aVar.o(i7);
            if (dVar.f10639a != null && h1VarD != null && h1VarD.equals(dVar.f10642d)) {
                ((Animator) aVar.k(i7)).end();
            }
        }
    }

    public long G() {
        return this.f10612c;
    }

    @c.o0
    public Rect H() {
        f fVar = this.E;
        if (fVar == null) {
            return null;
        }
        return fVar.a(this);
    }

    @c.o0
    public f I() {
        return this.E;
    }

    @c.o0
    public TimeInterpolator J() {
        return this.f10613d;
    }

    d0 L(View view, boolean z7) {
        TransitionSet transitionSet = this.f10627r;
        if (transitionSet != null) {
            return transitionSet.L(view, z7);
        }
        ArrayList<d0> arrayList = z7 ? this.f10629t : this.f10630u;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i7 = 0;
        while (true) {
            if (i7 >= size) {
                i7 = -1;
                break;
            }
            d0 d0Var = arrayList.get(i7);
            if (d0Var == null) {
                return null;
            }
            if (d0Var.f10675b == view) {
                break;
            }
            i7++;
        }
        if (i7 >= 0) {
            return (z7 ? this.f10630u : this.f10629t).get(i7);
        }
        return null;
    }

    @c.m0
    public String M() {
        return this.f10610a;
    }

    @c.m0
    public PathMotion N() {
        return this.G;
    }

    @c.o0
    public a0 O() {
        return this.D;
    }

    public long Q() {
        return this.f10611b;
    }

    @c.m0
    public List<Integer> R() {
        return this.f10614e;
    }

    @c.o0
    public List<String> S() {
        return this.f10616g;
    }

    @c.o0
    public List<Class<?>> T() {
        return this.f10617h;
    }

    @c.m0
    public List<View> U() {
        return this.f10615f;
    }

    @c.o0
    public String[] V() {
        return null;
    }

    @c.o0
    public d0 W(@c.m0 View view, boolean z7) {
        TransitionSet transitionSet = this.f10627r;
        if (transitionSet != null) {
            return transitionSet.W(view, z7);
        }
        return (z7 ? this.f10625p : this.f10626q).f10685a.get(view);
    }

    public boolean X(@c.o0 d0 d0Var, @c.o0 d0 d0Var2) {
        if (d0Var == null || d0Var2 == null) {
            return false;
        }
        String[] strArrV = V();
        if (strArrV == null) {
            Iterator<String> it = d0Var.f10674a.keySet().iterator();
            while (it.hasNext()) {
                if (a0(d0Var, d0Var2, it.next())) {
                }
            }
            return false;
        }
        for (String str : strArrV) {
            if (!a0(d0Var, d0Var2, str)) {
            }
        }
        return false;
        return true;
    }

    boolean Z(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.f10618i;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.f10619j;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.f10620k;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i7 = 0; i7 < size; i7++) {
                if (this.f10620k.get(i7).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.f10621l != null && n2.x0(view) != null && this.f10621l.contains(n2.x0(view))) {
            return false;
        }
        if ((this.f10614e.size() == 0 && this.f10615f.size() == 0 && (((arrayList = this.f10617h) == null || arrayList.isEmpty()) && ((arrayList2 = this.f10616g) == null || arrayList2.isEmpty()))) || this.f10614e.contains(Integer.valueOf(id)) || this.f10615f.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.f10616g;
        if (arrayList6 != null && arrayList6.contains(n2.x0(view))) {
            return true;
        }
        if (this.f10617h != null) {
            for (int i8 = 0; i8 < this.f10617h.size(); i8++) {
                if (this.f10617h.get(i8).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    @c.m0
    public Transition a(@c.m0 h hVar) {
        if (this.B == null) {
            this.B = new ArrayList<>();
        }
        this.B.add(hVar);
        return this;
    }

    @c.m0
    public Transition b(@c.b0 int i7) {
        if (i7 != 0) {
            this.f10614e.add(Integer.valueOf(i7));
        }
        return this;
    }

    @c.m0
    public Transition c(@c.m0 View view) {
        this.f10615f.add(view);
        return this;
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    protected void cancel() {
        for (int size = this.f10633x.size() - 1; size >= 0; size--) {
            this.f10633x.get(size).cancel();
        }
        ArrayList<h> arrayList = this.B;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.B.clone();
        int size2 = arrayList2.size();
        for (int i7 = 0; i7 < size2; i7++) {
            ((h) arrayList2.get(i7)).d(this);
        }
    }

    @c.m0
    public Transition d(@c.m0 Class<?> cls) {
        if (this.f10617h == null) {
            this.f10617h = new ArrayList<>();
        }
        this.f10617h.add(cls);
        return this;
    }

    @c.m0
    public Transition e(@c.m0 String str) {
        if (this.f10616g == null) {
            this.f10616g = new ArrayList<>();
        }
        this.f10616g.add(str);
        return this;
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void h0(View view) {
        if (this.A) {
            return;
        }
        androidx.collection.a<Animator, d> aVarP = P();
        int size = aVarP.size();
        h1 h1VarD = q0.d(view);
        for (int i7 = size - 1; i7 >= 0; i7--) {
            d dVarO = aVarP.o(i7);
            if (dVarO.f10639a != null && h1VarD.equals(dVarO.f10642d)) {
                androidx.transition.a.b(aVarP.k(i7));
            }
        }
        ArrayList<h> arrayList = this.B;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.B.clone();
            int size2 = arrayList2.size();
            for (int i8 = 0; i8 < size2; i8++) {
                ((h) arrayList2.get(i8)).b(this);
            }
        }
        this.f10635z = true;
    }

    void i0(ViewGroup viewGroup) {
        d dVar;
        this.f10629t = new ArrayList<>();
        this.f10630u = new ArrayList<>();
        f0(this.f10625p, this.f10626q);
        androidx.collection.a<Animator, d> aVarP = P();
        int size = aVarP.size();
        h1 h1VarD = q0.d(viewGroup);
        for (int i7 = size - 1; i7 >= 0; i7--) {
            Animator animatorK = aVarP.k(i7);
            if (animatorK != null && (dVar = aVarP.get(animatorK)) != null && dVar.f10639a != null && h1VarD.equals(dVar.f10642d)) {
                d0 d0Var = dVar.f10641c;
                View view = dVar.f10639a;
                d0 d0VarW = W(view, true);
                d0 d0VarL = L(view, true);
                if (d0VarW == null && d0VarL == null) {
                    d0VarL = this.f10626q.f10685a.get(view);
                }
                if (!(d0VarW == null && d0VarL == null) && dVar.f10643e.X(d0Var, d0VarL)) {
                    if (animatorK.isRunning() || animatorK.isStarted()) {
                        animatorK.cancel();
                    } else {
                        aVarP.remove(animatorK);
                    }
                }
            }
        }
        s(viewGroup, this.f10625p, this.f10626q, this.f10629t, this.f10630u);
        r0();
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    protected void j(Animator animator) {
        if (animator == null) {
            t();
            return;
        }
        if (G() >= 0) {
            animator.setDuration(G());
        }
        if (Q() >= 0) {
            animator.setStartDelay(Q() + animator.getStartDelay());
        }
        if (J() != null) {
            animator.setInterpolator(J());
        }
        animator.addListener(new c());
        animator.start();
    }

    @c.m0
    public Transition j0(@c.m0 h hVar) {
        ArrayList<h> arrayList = this.B;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(hVar);
        if (this.B.size() == 0) {
            this.B = null;
        }
        return this;
    }

    public abstract void k(@c.m0 d0 d0Var);

    @c.m0
    public Transition k0(@c.b0 int i7) {
        if (i7 != 0) {
            this.f10614e.remove(Integer.valueOf(i7));
        }
        return this;
    }

    @c.m0
    public Transition l0(@c.m0 View view) {
        this.f10615f.remove(view);
        return this;
    }

    void m(d0 d0Var) {
        String[] strArrB;
        if (this.D == null || d0Var.f10674a.isEmpty() || (strArrB = this.D.b()) == null) {
            return;
        }
        boolean z7 = false;
        int i7 = 0;
        while (true) {
            if (i7 >= strArrB.length) {
                z7 = true;
                break;
            } else if (!d0Var.f10674a.containsKey(strArrB[i7])) {
                break;
            } else {
                i7++;
            }
        }
        if (z7) {
            return;
        }
        this.D.a(d0Var);
    }

    @c.m0
    public Transition m0(@c.m0 Class<?> cls) {
        ArrayList<Class<?>> arrayList = this.f10617h;
        if (arrayList != null) {
            arrayList.remove(cls);
        }
        return this;
    }

    public abstract void n(@c.m0 d0 d0Var);

    @c.m0
    public Transition n0(@c.m0 String str) {
        ArrayList<String> arrayList = this.f10616g;
        if (arrayList != null) {
            arrayList.remove(str);
        }
        return this;
    }

    void o(ViewGroup viewGroup, boolean z7) {
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        androidx.collection.a<String, String> aVar;
        p(z7);
        if ((this.f10614e.size() > 0 || this.f10615f.size() > 0) && (((arrayList = this.f10616g) == null || arrayList.isEmpty()) && ((arrayList2 = this.f10617h) == null || arrayList2.isEmpty()))) {
            for (int i7 = 0; i7 < this.f10614e.size(); i7++) {
                View viewFindViewById = viewGroup.findViewById(this.f10614e.get(i7).intValue());
                if (viewFindViewById != null) {
                    d0 d0Var = new d0(viewFindViewById);
                    if (z7) {
                        n(d0Var);
                    } else {
                        k(d0Var);
                    }
                    d0Var.f10676c.add(this);
                    m(d0Var);
                    if (z7) {
                        h(this.f10625p, viewFindViewById, d0Var);
                    } else {
                        h(this.f10626q, viewFindViewById, d0Var);
                    }
                }
            }
            for (int i8 = 0; i8 < this.f10615f.size(); i8++) {
                View view = this.f10615f.get(i8);
                d0 d0Var2 = new d0(view);
                if (z7) {
                    n(d0Var2);
                } else {
                    k(d0Var2);
                }
                d0Var2.f10676c.add(this);
                m(d0Var2);
                if (z7) {
                    h(this.f10625p, view, d0Var2);
                } else {
                    h(this.f10626q, view, d0Var2);
                }
            }
        } else {
            l(viewGroup, z7);
        }
        if (z7 || (aVar = this.F) == null) {
            return;
        }
        int size = aVar.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i9 = 0; i9 < size; i9++) {
            arrayList3.add(this.f10625p.f10688d.remove(this.F.k(i9)));
        }
        for (int i10 = 0; i10 < size; i10++) {
            View view2 = (View) arrayList3.get(i10);
            if (view2 != null) {
                this.f10625p.f10688d.put(this.F.o(i10), view2);
            }
        }
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void o0(View view) {
        if (this.f10635z) {
            if (!this.A) {
                androidx.collection.a<Animator, d> aVarP = P();
                int size = aVarP.size();
                h1 h1VarD = q0.d(view);
                for (int i7 = size - 1; i7 >= 0; i7--) {
                    d dVarO = aVarP.o(i7);
                    if (dVarO.f10639a != null && h1VarD.equals(dVarO.f10642d)) {
                        androidx.transition.a.c(aVarP.k(i7));
                    }
                }
                ArrayList<h> arrayList = this.B;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.B.clone();
                    int size2 = arrayList2.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        ((h) arrayList2.get(i8)).e(this);
                    }
                }
            }
            this.f10635z = false;
        }
    }

    void p(boolean z7) {
        if (z7) {
            this.f10625p.f10685a.clear();
            this.f10625p.f10686b.clear();
            this.f10625p.f10687c.e();
        } else {
            this.f10626q.f10685a.clear();
            this.f10626q.f10686b.clear();
            this.f10626q.f10687c.e();
        }
    }

    @Override // 
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public Transition clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.C = new ArrayList<>();
            transition.f10625p = new e0();
            transition.f10626q = new e0();
            transition.f10629t = null;
            transition.f10630u = null;
            return transition;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @c.o0
    public Animator r(@c.m0 ViewGroup viewGroup, @c.o0 d0 d0Var, @c.o0 d0 d0Var2) {
        return null;
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    protected void r0() {
        B0();
        androidx.collection.a<Animator, d> aVarP = P();
        for (Animator animator : this.C) {
            if (aVarP.containsKey(animator)) {
                B0();
                q0(animator, aVarP);
            }
        }
        this.C.clear();
        t();
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0043  */
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    protected void s(ViewGroup viewGroup, e0 e0Var, e0 e0Var2, ArrayList<d0> arrayList, ArrayList<d0> arrayList2) {
        Animator animatorR;
        int i7;
        View view;
        Animator animator;
        d0 d0Var;
        Animator animator2;
        d0 d0Var2;
        androidx.collection.a<Animator, d> aVarP = P();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long jMin = Long.MAX_VALUE;
        int i8 = 0;
        while (i8 < size) {
            d0 d0Var3 = arrayList.get(i8);
            d0 d0Var4 = arrayList2.get(i8);
            if (d0Var3 != null && !d0Var3.f10676c.contains(this)) {
                d0Var3 = null;
            }
            if (d0Var4 != null && !d0Var4.f10676c.contains(this)) {
                d0Var4 = null;
            }
            if (d0Var3 == null && d0Var4 == null) {
                i7 = size;
            } else if (!(d0Var3 == null || d0Var4 == null || X(d0Var3, d0Var4)) || (animatorR = r(viewGroup, d0Var3, d0Var4)) == null) {
                i7 = size;
            } else {
                if (d0Var4 != null) {
                    view = d0Var4.f10675b;
                    String[] strArrV = V();
                    if (strArrV != null && strArrV.length > 0) {
                        d0Var2 = new d0(view);
                        i7 = size;
                        d0 d0Var5 = e0Var2.f10685a.get(view);
                        if (d0Var5 != null) {
                            int i9 = 0;
                            while (i9 < strArrV.length) {
                                Map<String, Object> map = d0Var2.f10674a;
                                String str = strArrV[i9];
                                map.put(str, d0Var5.f10674a.get(str));
                                i9++;
                                strArrV = strArrV;
                            }
                        }
                        int size2 = aVarP.size();
                        int i10 = 0;
                        while (true) {
                            if (i10 >= size2) {
                                animator2 = animatorR;
                                break;
                            }
                            d dVar = aVarP.get(aVarP.k(i10));
                            if (dVar.f10641c != null && dVar.f10639a == view && dVar.f10640b.equals(M()) && dVar.f10641c.equals(d0Var2)) {
                                animator2 = null;
                                break;
                            }
                            i10++;
                        }
                    } else {
                        i7 = size;
                        animator2 = animatorR;
                        d0Var2 = null;
                    }
                    animator = animator2;
                    d0Var = d0Var2;
                } else {
                    i7 = size;
                    view = d0Var3.f10675b;
                    animator = animatorR;
                    d0Var = null;
                }
                if (animator != null) {
                    a0 a0Var = this.D;
                    if (a0Var != null) {
                        long jC = a0Var.c(viewGroup, this, d0Var3, d0Var4);
                        sparseIntArray.put(this.C.size(), (int) jC);
                        jMin = Math.min(jC, jMin);
                    }
                    aVarP.put(animator, new d(view, M(), this, q0.d(viewGroup), d0Var));
                    this.C.add(animator);
                    jMin = jMin;
                }
            }
            i8++;
            size = i7;
        }
        if (sparseIntArray.size() != 0) {
            for (int i11 = 0; i11 < sparseIntArray.size(); i11++) {
                Animator animator3 = this.C.get(sparseIntArray.keyAt(i11));
                animator3.setStartDelay((((long) sparseIntArray.valueAt(i11)) - jMin) + animator3.getStartDelay());
            }
        }
    }

    void s0(boolean z7) {
        this.f10632w = z7;
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    protected void t() {
        int i7 = this.f10634y - 1;
        this.f10634y = i7;
        if (i7 == 0) {
            ArrayList<h> arrayList = this.B;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.B.clone();
                int size = arrayList2.size();
                for (int i8 = 0; i8 < size; i8++) {
                    ((h) arrayList2.get(i8)).c(this);
                }
            }
            for (int i9 = 0; i9 < this.f10625p.f10687c.B(); i9++) {
                View viewC = this.f10625p.f10687c.C(i9);
                if (viewC != null) {
                    n2.Q1(viewC, false);
                }
            }
            for (int i10 = 0; i10 < this.f10626q.f10687c.B(); i10++) {
                View viewC2 = this.f10626q.f10687c.C(i10);
                if (viewC2 != null) {
                    n2.Q1(viewC2, false);
                }
            }
            this.A = true;
        }
    }

    @c.m0
    public Transition t0(long j7) {
        this.f10612c = j7;
        return this;
    }

    public String toString() {
        return C0("");
    }

    @c.m0
    public Transition u(@c.b0 int i7, boolean z7) {
        this.f10622m = x(this.f10622m, i7, z7);
        return this;
    }

    public void u0(@c.o0 f fVar) {
        this.E = fVar;
    }

    @c.m0
    public Transition v(@c.m0 View view, boolean z7) {
        this.f10623n = E(this.f10623n, view, z7);
        return this;
    }

    @c.m0
    public Transition v0(@c.o0 TimeInterpolator timeInterpolator) {
        this.f10613d = timeInterpolator;
        return this;
    }

    @c.m0
    public Transition w(@c.m0 Class<?> cls, boolean z7) {
        this.f10624o = D(this.f10624o, cls, z7);
        return this;
    }

    public void w0(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.f10628s = T;
            return;
        }
        for (int i7 = 0; i7 < iArr.length; i7++) {
            if (!Y(iArr[i7])) {
                throw new IllegalArgumentException("matches contains invalid value");
            }
            if (i(iArr, i7)) {
                throw new IllegalArgumentException("matches contains a duplicate value");
            }
        }
        this.f10628s = (int[]) iArr.clone();
    }

    public void x0(@c.o0 PathMotion pathMotion) {
        if (pathMotion == null) {
            this.G = U;
        } else {
            this.G = pathMotion;
        }
    }

    public void y0(@c.o0 a0 a0Var) {
        this.D = a0Var;
    }

    @c.m0
    public Transition z(@c.b0 int i7, boolean z7) {
        this.f10618i = x(this.f10618i, i7, z7);
        return this;
    }

    Transition z0(ViewGroup viewGroup) {
        this.f10631v = viewGroup;
        return this;
    }

    @SuppressLint({"RestrictedApi"})
    public Transition(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.f10784c);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long jK = androidx.core.content.res.q.k(typedArrayObtainStyledAttributes, xmlResourceParser, androidx.constraintlayout.core.motion.utils.w.h.f3144b, 1, -1);
        if (jK >= 0) {
            t0(jK);
        }
        long jK2 = androidx.core.content.res.q.k(typedArrayObtainStyledAttributes, xmlResourceParser, "startDelay", 2, -1);
        if (jK2 > 0) {
            A0(jK2);
        }
        int iL = androidx.core.content.res.q.l(typedArrayObtainStyledAttributes, xmlResourceParser, "interpolator", 0, 0);
        if (iL > 0) {
            v0(AnimationUtils.loadInterpolator(context, iL));
        }
        String strM = androidx.core.content.res.q.m(typedArrayObtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (strM != null) {
            w0(g0(strM));
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
