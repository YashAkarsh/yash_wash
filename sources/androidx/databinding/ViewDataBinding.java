package androidx.databinding;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import android.view.Choreographer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.library.R;
import androidx.lifecycle.LiveData;
import c.j0;
import c.m0;
import c.o0;
import c.x0;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewDataBinding extends androidx.databinding.a implements z.c {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int f7169r = 1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f7170s = 2;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final int f7171t = 3;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f7172u = "binding_";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int f7173v = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Runnable f7178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f7179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f7180d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private o[] f7181e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final View f7182f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private androidx.databinding.i<y, ViewDataBinding, Void> f7183g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f7184h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Choreographer f7185i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Choreographer.FrameCallback f7186j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Handler f7187k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected final DataBindingComponent f7188l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ViewDataBinding f7189m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private androidx.lifecycle.q f7190n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private OnStartListener f7191o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f7192p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    static int f7168q = Build.VERSION.SDK_INT;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final boolean f7174w = true;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final i f7175x = new a();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final i f7176y = new b();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final i f7177z = new c();
    private static final i A = new d();
    private static final androidx.databinding.i.a<y, ViewDataBinding, Void> B = new e();
    private static final ReferenceQueue<ViewDataBinding> C = new ReferenceQueue<>();
    private static final View.OnAttachStateChangeListener D = new f();

    static class OnStartListener implements androidx.lifecycle.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final WeakReference<ViewDataBinding> f7193a;

        /* synthetic */ OnStartListener(ViewDataBinding viewDataBinding, a aVar) {
            this(viewDataBinding);
        }

        @androidx.lifecycle.y(androidx.lifecycle.m.b.ON_START)
        public void onStart() {
            ViewDataBinding viewDataBinding = this.f7193a.get();
            if (viewDataBinding != null) {
                viewDataBinding.A();
            }
        }

        private OnStartListener(ViewDataBinding viewDataBinding) {
            this.f7193a = new WeakReference<>(viewDataBinding);
        }
    }

    static class a implements i {
        a() {
        }

        @Override // androidx.databinding.ViewDataBinding.i
        public o a(ViewDataBinding viewDataBinding, int i7) {
            return new q(viewDataBinding, i7).c();
        }
    }

    static class b implements i {
        b() {
        }

        @Override // androidx.databinding.ViewDataBinding.i
        public o a(ViewDataBinding viewDataBinding, int i7) {
            return new n(viewDataBinding, i7).c();
        }
    }

    static class c implements i {
        c() {
        }

        @Override // androidx.databinding.ViewDataBinding.i
        public o a(ViewDataBinding viewDataBinding, int i7) {
            return new p(viewDataBinding, i7).c();
        }
    }

    static class d implements i {
        d() {
        }

        @Override // androidx.databinding.ViewDataBinding.i
        public o a(ViewDataBinding viewDataBinding, int i7) {
            return new k(viewDataBinding, i7).c();
        }
    }

    static class e extends androidx.databinding.i.a<y, ViewDataBinding, Void> {
        e() {
        }

        @Override // androidx.databinding.i.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(y yVar, ViewDataBinding viewDataBinding, int i7, Void r7) {
            if (i7 == 1) {
                if (yVar.c(viewDataBinding)) {
                    return;
                }
                viewDataBinding.f7180d = true;
            } else if (i7 == 2) {
                yVar.b(viewDataBinding);
            } else {
                if (i7 != 3) {
                    return;
                }
                yVar.a(viewDataBinding);
            }
        }
    }

    static class f implements View.OnAttachStateChangeListener {
        f() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        @TargetApi(19)
        public void onViewAttachedToWindow(View view) {
            ViewDataBinding.F(view).f7178b.run();
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                ViewDataBinding.this.f7179c = false;
            }
            ViewDataBinding.C0();
            if (ViewDataBinding.this.f7182f.isAttachedToWindow()) {
                ViewDataBinding.this.A();
            } else {
                ViewDataBinding.this.f7182f.removeOnAttachStateChangeListener(ViewDataBinding.D);
                ViewDataBinding.this.f7182f.addOnAttachStateChangeListener(ViewDataBinding.D);
            }
        }
    }

    class h implements Choreographer.FrameCallback {
        h() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j7) {
            ViewDataBinding.this.f7178b.run();
        }
    }

    private interface i {
        o a(ViewDataBinding viewDataBinding, int i7);
    }

    protected static class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String[][] f7196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[][] f7197b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[][] f7198c;

        public j(int i7) {
            this.f7196a = new String[i7][];
            this.f7197b = new int[i7][];
            this.f7198c = new int[i7][];
        }

        public void a(int i7, String[] strArr, int[] iArr, int[] iArr2) {
            this.f7196a[i7] = strArr;
            this.f7197b[i7] = iArr;
            this.f7198c[i7] = iArr2;
        }
    }

    private static class k implements androidx.lifecycle.x, l<LiveData<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final o<LiveData<?>> f7199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        androidx.lifecycle.q f7200b;

        public k(ViewDataBinding viewDataBinding, int i7) {
            this.f7199a = new o<>(viewDataBinding, i7, this);
        }

        @Override // androidx.lifecycle.x
        public void a(@o0 Object obj) {
            ViewDataBinding viewDataBindingA = this.f7199a.a();
            if (viewDataBindingA != null) {
                o<LiveData<?>> oVar = this.f7199a;
                viewDataBindingA.i0(oVar.f7204b, oVar.b(), 0);
            }
        }

        @Override // androidx.databinding.ViewDataBinding.l
        public void b(androidx.lifecycle.q qVar) {
            LiveData<?> liveDataB = this.f7199a.b();
            if (liveDataB != null) {
                if (this.f7200b != null) {
                    liveDataB.o(this);
                }
                if (qVar != null) {
                    liveDataB.j(qVar, this);
                }
            }
            this.f7200b = qVar;
        }

        @Override // androidx.databinding.ViewDataBinding.l
        public o<LiveData<?>> c() {
            return this.f7199a;
        }

        @Override // androidx.databinding.ViewDataBinding.l
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void e(LiveData<?> liveData) {
            androidx.lifecycle.q qVar = this.f7200b;
            if (qVar != null) {
                liveData.j(qVar, this);
            }
        }

        @Override // androidx.databinding.ViewDataBinding.l
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void d(LiveData<?> liveData) {
            liveData.o(this);
        }
    }

    private interface l<T> {
        void b(androidx.lifecycle.q qVar);

        o<T> c();

        void d(T t7);

        void e(T t7);
    }

    protected static abstract class m extends s.a implements androidx.databinding.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f7201a;

        public m(int i7) {
            this.f7201a = i7;
        }

        @Override // androidx.databinding.s.a
        public void f(s sVar, int i7) {
            if (i7 == this.f7201a || i7 == 0) {
                a();
            }
        }
    }

    private static class n extends w.a implements l<w> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final o<w> f7202a;

        public n(ViewDataBinding viewDataBinding, int i7) {
            this.f7202a = new o<>(viewDataBinding, i7, this);
        }

        @Override // androidx.databinding.w.a
        public void a(w wVar) {
            w wVarB;
            ViewDataBinding viewDataBindingA = this.f7202a.a();
            if (viewDataBindingA != null && (wVarB = this.f7202a.b()) == wVar) {
                viewDataBindingA.i0(this.f7202a.f7204b, wVarB, 0);
            }
        }

        @Override // androidx.databinding.ViewDataBinding.l
        public void b(androidx.lifecycle.q qVar) {
        }

        @Override // androidx.databinding.ViewDataBinding.l
        public o<w> c() {
            return this.f7202a;
        }

        @Override // androidx.databinding.w.a
        public void f(w wVar, int i7, int i8) {
            a(wVar);
        }

        @Override // androidx.databinding.w.a
        public void g(w wVar, int i7, int i8) {
            a(wVar);
        }

        @Override // androidx.databinding.w.a
        public void h(w wVar, int i7, int i8, int i9) {
            a(wVar);
        }

        @Override // androidx.databinding.w.a
        public void i(w wVar, int i7, int i8) {
            a(wVar);
        }

        @Override // androidx.databinding.ViewDataBinding.l
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(w wVar) {
            wVar.r0(this);
        }

        @Override // androidx.databinding.ViewDataBinding.l
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void d(w wVar) {
            wVar.q(this);
        }
    }

    private static class o<T> extends WeakReference<ViewDataBinding> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final l<T> f7203a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final int f7204b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private T f7205c;

        public o(ViewDataBinding viewDataBinding, int i7, l<T> lVar) {
            super(viewDataBinding, ViewDataBinding.C);
            this.f7204b = i7;
            this.f7203a = lVar;
        }

        protected ViewDataBinding a() {
            ViewDataBinding viewDataBinding = (ViewDataBinding) get();
            if (viewDataBinding == null) {
                e();
            }
            return viewDataBinding;
        }

        public T b() {
            return this.f7205c;
        }

        public void c(androidx.lifecycle.q qVar) {
            this.f7203a.b(qVar);
        }

        public void d(T t7) {
            e();
            this.f7205c = t7;
            if (t7 != null) {
                this.f7203a.e(t7);
            }
        }

        public boolean e() {
            boolean z7;
            T t7 = this.f7205c;
            if (t7 != null) {
                this.f7203a.d(t7);
                z7 = true;
            } else {
                z7 = false;
            }
            this.f7205c = null;
            return z7;
        }
    }

    private static class p extends x.a implements l<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final o<x> f7206a;

        public p(ViewDataBinding viewDataBinding, int i7) {
            this.f7206a = new o<>(viewDataBinding, i7, this);
        }

        @Override // androidx.databinding.x.a
        public void a(x xVar, Object obj) {
            ViewDataBinding viewDataBindingA = this.f7206a.a();
            if (viewDataBindingA == null || xVar != this.f7206a.b()) {
                return;
            }
            viewDataBindingA.i0(this.f7206a.f7204b, xVar, 0);
        }

        @Override // androidx.databinding.ViewDataBinding.l
        public void b(androidx.lifecycle.q qVar) {
        }

        @Override // androidx.databinding.ViewDataBinding.l
        public o<x> c() {
            return this.f7206a;
        }

        @Override // androidx.databinding.ViewDataBinding.l
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void e(x xVar) {
            xVar.U(this);
        }

        @Override // androidx.databinding.ViewDataBinding.l
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void d(x xVar) {
            xVar.V(this);
        }
    }

    private static class q extends s.a implements l<s> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final o<s> f7207a;

        public q(ViewDataBinding viewDataBinding, int i7) {
            this.f7207a = new o<>(viewDataBinding, i7, this);
        }

        @Override // androidx.databinding.ViewDataBinding.l
        public void b(androidx.lifecycle.q qVar) {
        }

        @Override // androidx.databinding.ViewDataBinding.l
        public o<s> c() {
            return this.f7207a;
        }

        @Override // androidx.databinding.s.a
        public void f(s sVar, int i7) {
            ViewDataBinding viewDataBindingA = this.f7207a.a();
            if (viewDataBindingA != null && this.f7207a.b() == sVar) {
                viewDataBindingA.i0(this.f7207a.f7204b, sVar, i7);
            }
        }

        @Override // androidx.databinding.ViewDataBinding.l
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(s sVar) {
            sVar.a(this);
        }

        @Override // androidx.databinding.ViewDataBinding.l
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(s sVar) {
            sVar.b(this);
        }
    }

    protected ViewDataBinding(DataBindingComponent dataBindingComponent, View view, int i7) {
        this.f7178b = new g();
        this.f7179c = false;
        this.f7180d = false;
        this.f7188l = dataBindingComponent;
        this.f7181e = new o[i7];
        this.f7182f = view;
        if (Looper.myLooper() == null) {
            throw new IllegalStateException("DataBinding must be created in view's UI Thread");
        }
        if (f7174w) {
            this.f7185i = Choreographer.getInstance();
            this.f7186j = new h();
        } else {
            this.f7186j = null;
            this.f7187k = new Handler(Looper.myLooper());
        }
    }

    protected static boolean A0(String str, boolean z7) {
        return str == null ? z7 : Boolean.parseBoolean(str);
    }

    private static int B(String str, int i7, j jVar, int i8) {
        CharSequence charSequenceSubSequence = str.subSequence(str.indexOf(47) + 1, str.length() - 2);
        String[] strArr = jVar.f7196a[i8];
        int length = strArr.length;
        while (i7 < length) {
            if (TextUtils.equals(charSequenceSubSequence, strArr[i7])) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    private static int B0(String str, int i7) {
        int length = str.length();
        int iCharAt = 0;
        while (i7 < length) {
            iCharAt = (iCharAt * 10) + (str.charAt(i7) - '0');
            i7++;
        }
        return iCharAt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void C0() {
        while (true) {
            Reference<? extends ViewDataBinding> referencePoll = C.poll();
            if (referencePoll == null) {
                return;
            }
            if (referencePoll instanceof o) {
                ((o) referencePoll).e();
            }
        }
    }

    private static int D(ViewGroup viewGroup, int i7) {
        String str = (String) viewGroup.getChildAt(i7).getTag();
        String strSubstring = str.substring(0, str.length() - 1);
        int length = strSubstring.length();
        int childCount = viewGroup.getChildCount();
        for (int i8 = i7 + 1; i8 < childCount; i8++) {
            View childAt = viewGroup.getChildAt(i8);
            String str2 = childAt.getTag() instanceof String ? (String) childAt.getTag() : null;
            if (str2 != null && str2.startsWith(strSubstring)) {
                if (str2.length() == str.length() && str2.charAt(str2.length() - 1) == '0') {
                    return i7;
                }
                if (n0(str2, length)) {
                    i7 = i8;
                }
            }
        }
        return i7;
    }

    static ViewDataBinding F(View view) {
        if (view != null) {
            return (ViewDataBinding) view.getTag(R.id.dataBinding);
        }
        return null;
    }

    protected static byte G0(Byte b8) {
        if (b8 == null) {
            return (byte) 0;
        }
        return b8.byteValue();
    }

    protected static char H0(Character ch) {
        if (ch == null) {
            return (char) 0;
        }
        return ch.charValue();
    }

    public static int I() {
        return f7168q;
    }

    protected static double I0(Double d8) {
        if (d8 == null) {
            return 0.0d;
        }
        return d8.doubleValue();
    }

    protected static int J(View view, int i7) {
        return view.getContext().getColor(i7);
    }

    protected static float J0(Float f8) {
        if (f8 == null) {
            return 0.0f;
        }
        return f8.floatValue();
    }

    protected static ColorStateList K(View view, int i7) {
        return view.getContext().getColorStateList(i7);
    }

    protected static int K0(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    protected static Drawable L(View view, int i7) {
        return view.getContext().getDrawable(i7);
    }

    protected static long L0(Long l7) {
        if (l7 == null) {
            return 0L;
        }
        return l7.longValue();
    }

    protected static <K, T> T M(Map<K, T> map, K k7) {
        if (map == null) {
            return null;
        }
        return map.get(k7);
    }

    protected static short M0(Short sh) {
        if (sh == null) {
            return (short) 0;
        }
        return sh.shortValue();
    }

    protected static byte N(byte[] bArr, int i7) {
        if (bArr == null || i7 < 0 || i7 >= bArr.length) {
            return (byte) 0;
        }
        return bArr[i7];
    }

    protected static boolean N0(Boolean bool) {
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    protected static char O(char[] cArr, int i7) {
        if (cArr == null || i7 < 0 || i7 >= cArr.length) {
            return (char) 0;
        }
        return cArr[i7];
    }

    protected static void O0(ViewDataBinding viewDataBinding, androidx.databinding.m mVar, m mVar2) {
        if (mVar != mVar2) {
            if (mVar != null) {
                viewDataBinding.b((m) mVar);
            }
            if (mVar2 != null) {
                viewDataBinding.a(mVar2);
            }
        }
    }

    protected static double P(double[] dArr, int i7) {
        if (dArr == null || i7 < 0 || i7 >= dArr.length) {
            return 0.0d;
        }
        return dArr[i7];
    }

    protected static float R(float[] fArr, int i7) {
        if (fArr == null || i7 < 0 || i7 >= fArr.length) {
            return 0.0f;
        }
        return fArr[i7];
    }

    protected static int S(int[] iArr, int i7) {
        if (iArr == null || i7 < 0 || i7 >= iArr.length) {
            return 0;
        }
        return iArr[i7];
    }

    protected static long T(long[] jArr, int i7) {
        if (jArr == null || i7 < 0 || i7 >= jArr.length) {
            return 0L;
        }
        return jArr[i7];
    }

    @TargetApi(16)
    protected static <T> void T0(LongSparseArray<T> longSparseArray, int i7, T t7) {
        if (longSparseArray == null || i7 < 0 || i7 >= longSparseArray.size()) {
            return;
        }
        longSparseArray.put(i7, t7);
    }

    protected static <T> T U(T[] tArr, int i7) {
        if (tArr == null || i7 < 0 || i7 >= tArr.length) {
            return null;
        }
        return tArr[i7];
    }

    protected static <T> void U0(SparseArray<T> sparseArray, int i7, T t7) {
        if (sparseArray == null || i7 < 0 || i7 >= sparseArray.size()) {
            return;
        }
        sparseArray.put(i7, t7);
    }

    protected static short V(short[] sArr, int i7) {
        if (sArr == null || i7 < 0 || i7 >= sArr.length) {
            return (short) 0;
        }
        return sArr[i7];
    }

    protected static void V0(SparseBooleanArray sparseBooleanArray, int i7, boolean z7) {
        if (sparseBooleanArray == null || i7 < 0 || i7 >= sparseBooleanArray.size()) {
            return;
        }
        sparseBooleanArray.put(i7, z7);
    }

    protected static boolean W(boolean[] zArr, int i7) {
        if (zArr == null || i7 < 0 || i7 >= zArr.length) {
            return false;
        }
        return zArr[i7];
    }

    protected static void W0(SparseIntArray sparseIntArray, int i7, int i8) {
        if (sparseIntArray == null || i7 < 0 || i7 >= sparseIntArray.size()) {
            return;
        }
        sparseIntArray.put(i7, i8);
    }

    protected static int X(SparseIntArray sparseIntArray, int i7) {
        if (sparseIntArray == null || i7 < 0) {
            return 0;
        }
        return sparseIntArray.get(i7);
    }

    @TargetApi(18)
    protected static void X0(SparseLongArray sparseLongArray, int i7, long j7) {
        if (sparseLongArray == null || i7 < 0 || i7 >= sparseLongArray.size()) {
            return;
        }
        sparseLongArray.put(i7, j7);
    }

    @TargetApi(18)
    protected static long Y(SparseLongArray sparseLongArray, int i7) {
        if (sparseLongArray == null || i7 < 0) {
            return 0L;
        }
        return sparseLongArray.get(i7);
    }

    protected static <T> void Y0(androidx.collection.f<T> fVar, int i7, T t7) {
        if (fVar == null || i7 < 0 || i7 >= fVar.B()) {
            return;
        }
        fVar.s(i7, t7);
    }

    @TargetApi(16)
    protected static <T> T Z(LongSparseArray<T> longSparseArray, int i7) {
        if (longSparseArray == null || i7 < 0) {
            return null;
        }
        return longSparseArray.get(i7);
    }

    protected static <T> void Z0(List<T> list, int i7, T t7) {
        if (list == null || i7 < 0 || i7 >= list.size()) {
            return;
        }
        list.set(i7, t7);
    }

    protected static <T> T a0(SparseArray<T> sparseArray, int i7) {
        if (sparseArray == null || i7 < 0) {
            return null;
        }
        return sparseArray.get(i7);
    }

    protected static <K, T> void a1(Map<K, T> map, K k7, T t7) {
        if (map == null) {
            return;
        }
        map.put(k7, t7);
    }

    protected static <T> T b0(androidx.collection.f<T> fVar, int i7) {
        if (fVar == null || i7 < 0) {
            return null;
        }
        return fVar.m(i7);
    }

    protected static void b1(byte[] bArr, int i7, byte b8) {
        if (bArr == null || i7 < 0 || i7 >= bArr.length) {
            return;
        }
        bArr[i7] = b8;
    }

    protected static <T> T c0(List<T> list, int i7) {
        if (list == null || i7 < 0 || i7 >= list.size()) {
            return null;
        }
        return list.get(i7);
    }

    protected static void c1(char[] cArr, int i7, char c8) {
        if (cArr == null || i7 < 0 || i7 >= cArr.length) {
            return;
        }
        cArr[i7] = c8;
    }

    protected static boolean d0(SparseBooleanArray sparseBooleanArray, int i7) {
        if (sparseBooleanArray == null || i7 < 0) {
            return false;
        }
        return sparseBooleanArray.get(i7);
    }

    protected static void d1(double[] dArr, int i7, double d8) {
        if (dArr == null || i7 < 0 || i7 >= dArr.length) {
            return;
        }
        dArr[i7] = d8;
    }

    protected static void e1(float[] fArr, int i7, float f8) {
        if (fArr == null || i7 < 0 || i7 >= fArr.length) {
            return;
        }
        fArr[i7] = f8;
    }

    protected static void f1(int[] iArr, int i7, int i8) {
        if (iArr == null || i7 < 0 || i7 >= iArr.length) {
            return;
        }
        iArr[i7] = i8;
    }

    protected static void g1(long[] jArr, int i7, long j7) {
        if (jArr == null || i7 < 0 || i7 >= jArr.length) {
            return;
        }
        jArr[i7] = j7;
    }

    protected static <T> void h1(T[] tArr, int i7, T t7) {
        if (tArr == null || i7 < 0 || i7 >= tArr.length) {
            return;
        }
        tArr[i7] = t7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(int i7, Object obj, int i8) {
        if (!this.f7192p && s0(i7, obj, i8)) {
            F0();
        }
    }

    protected static void i1(short[] sArr, int i7, short s7) {
        if (sArr == null || i7 < 0 || i7 >= sArr.length) {
            return;
        }
        sArr[i7] = s7;
    }

    protected static void j1(boolean[] zArr, int i7, boolean z7) {
        if (zArr == null || i7 < 0 || i7 >= zArr.length) {
            return;
        }
        zArr[i7] = z7;
    }

    @x0({x0.a.LIBRARY_GROUP})
    protected static <T extends ViewDataBinding> T k0(@m0 LayoutInflater layoutInflater, int i7, @o0 ViewGroup viewGroup, boolean z7, @o0 Object obj) {
        return (T) androidx.databinding.k.k(layoutInflater, i7, viewGroup, z7, u(obj));
    }

    private static boolean n0(String str, int i7) {
        int length = str.length();
        if (length == i7) {
            return false;
        }
        while (i7 < length) {
            if (!Character.isDigit(str.charAt(i7))) {
                return false;
            }
            i7++;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0047  */
    /* JADX WARN: Code duplicated, block: B:68:0x00fc  */
    private static void p0(DataBindingComponent dataBindingComponent, View view, Object[] objArr, j jVar, SparseIntArray sparseIntArray, boolean z7) {
        int i7;
        boolean z8;
        int i8;
        int i9;
        int i10;
        int iB;
        int id;
        int i11;
        int iB0;
        if (F(view) != null) {
            return;
        }
        Object tag = view.getTag();
        String str = tag instanceof String ? (String) tag : null;
        int i12 = 1;
        if (z7 && str != null && str.startsWith("layout")) {
            int iLastIndexOf = str.lastIndexOf(95);
            if (iLastIndexOf > 0) {
                int i13 = iLastIndexOf + 1;
                if (n0(str, i13)) {
                    iB0 = B0(str, i13);
                    if (objArr[iB0] == null) {
                        objArr[iB0] = view;
                    }
                    if (jVar == null) {
                        iB0 = -1;
                    }
                    z8 = true;
                } else {
                    iB0 = -1;
                    z8 = false;
                }
            } else {
                iB0 = -1;
                z8 = false;
            }
            i7 = iB0;
        } else if (str == null || !str.startsWith(f7172u)) {
            i7 = -1;
            z8 = false;
        } else {
            int iB1 = B0(str, f7173v);
            if (objArr[iB1] == null) {
                objArr[iB1] = view;
            }
            if (jVar == null) {
                iB1 = -1;
            }
            i7 = iB1;
            z8 = true;
        }
        if (!z8 && (id = view.getId()) > 0 && sparseIntArray != null && (i11 = sparseIntArray.get(id, -1)) >= 0 && objArr[i11] == null) {
            objArr[i11] = view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            int i14 = 0;
            int i15 = 0;
            while (i14 < childCount) {
                View childAt = viewGroup.getChildAt(i14);
                if (i7 < 0 || !(childAt.getTag() instanceof String)) {
                    i8 = i14;
                    i9 = i15;
                    i10 = 0;
                } else {
                    String str2 = (String) childAt.getTag();
                    if (!str2.endsWith("_0") || !str2.startsWith("layout") || str2.indexOf(47) <= 0 || (iB = B(str2, i15, jVar, i7)) < 0) {
                        i8 = i14;
                        i9 = i15;
                        i10 = 0;
                    } else {
                        int i16 = iB + 1;
                        int i17 = jVar.f7197b[i7][iB];
                        int i18 = jVar.f7198c[i7][iB];
                        int iD = D(viewGroup, i14);
                        if (iD == i14) {
                            objArr[i17] = androidx.databinding.k.c(dataBindingComponent, childAt, i18);
                            i8 = i14;
                            i10 = i12;
                            i9 = i16;
                        } else {
                            int i19 = (iD - i14) + i12;
                            View[] viewArr = new View[i19];
                            for (int i20 = 0; i20 < i19; i20++) {
                                viewArr[i20] = viewGroup.getChildAt(i14 + i20);
                            }
                            objArr[i17] = androidx.databinding.k.d(dataBindingComponent, viewArr, i18);
                            i8 = i14 + (i19 - 1);
                            i9 = i16;
                            i10 = 1;
                        }
                    }
                }
                if (i10 == 0) {
                    p0(dataBindingComponent, childAt, objArr, jVar, sparseIntArray, false);
                }
                int i21 = i9;
                i12 = 1;
                i14 = i8 + 1;
                i15 = i21;
            }
        }
    }

    protected static Object[] q0(DataBindingComponent dataBindingComponent, View view, int i7, j jVar, SparseIntArray sparseIntArray) {
        Object[] objArr = new Object[i7];
        p0(dataBindingComponent, view, objArr, jVar, sparseIntArray, true);
        return objArr;
    }

    protected static Object[] r0(DataBindingComponent dataBindingComponent, View[] viewArr, int i7, j jVar, SparseIntArray sparseIntArray) {
        Object[] objArr = new Object[i7];
        for (View view : viewArr) {
            p0(dataBindingComponent, view, objArr, jVar, sparseIntArray, true);
        }
        return objArr;
    }

    private boolean r1(int i7, Object obj, i iVar) {
        if (obj == null) {
            return m1(i7);
        }
        o oVar = this.f7181e[i7];
        if (oVar == null) {
            D0(i7, obj, iVar);
            return true;
        }
        if (oVar.b() == obj) {
            return false;
        }
        m1(i7);
        D0(i7, obj, iVar);
        return true;
    }

    protected static ViewDataBinding t(Object obj, View view, int i7) {
        return androidx.databinding.k.c(u(obj), view, i7);
    }

    protected static byte t0(String str, byte b8) {
        try {
            return Byte.parseByte(str);
        } catch (NumberFormatException unused) {
            return b8;
        }
    }

    private static DataBindingComponent u(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof DataBindingComponent) {
            return (DataBindingComponent) obj;
        }
        throw new IllegalArgumentException("The provided bindingComponent parameter must be an instance of DataBindingComponent. See  https://issuetracker.google.com/issues/116541301 for details of why this parameter is not defined as DataBindingComponent");
    }

    protected static char u0(String str, char c8) {
        return (str == null || str.isEmpty()) ? c8 : str.charAt(0);
    }

    protected static double v0(String str, double d8) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return d8;
        }
    }

    protected static float w0(String str, float f8) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return f8;
        }
    }

    protected static int x0(String str, int i7) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i7;
        }
    }

    private void y() {
        if (this.f7184h) {
            F0();
            return;
        }
        if (j0()) {
            this.f7184h = true;
            this.f7180d = false;
            androidx.databinding.i<y, ViewDataBinding, Void> iVar = this.f7183g;
            if (iVar != null) {
                iVar.m(this, 1, null);
                if (this.f7180d) {
                    this.f7183g.m(this, 2, null);
                }
            }
            if (!this.f7180d) {
                x();
                androidx.databinding.i<y, ViewDataBinding, Void> iVar2 = this.f7183g;
                if (iVar2 != null) {
                    iVar2.m(this, 3, null);
                }
            }
            this.f7184h = false;
        }
    }

    protected static long y0(String str, long j7) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j7;
        }
    }

    protected static void z(ViewDataBinding viewDataBinding) {
        viewDataBinding.y();
    }

    protected static short z0(String str, short s7) {
        try {
            return Short.parseShort(str);
        } catch (NumberFormatException unused) {
            return s7;
        }
    }

    public void A() {
        ViewDataBinding viewDataBinding = this.f7189m;
        if (viewDataBinding == null) {
            y();
        } else {
            viewDataBinding.A();
        }
    }

    protected void D0(int i7, Object obj, i iVar) {
        if (obj == null) {
            return;
        }
        o oVarA = this.f7181e[i7];
        if (oVarA == null) {
            oVarA = iVar.a(this, i7);
            this.f7181e[i7] = oVarA;
            androidx.lifecycle.q qVar = this.f7190n;
            if (qVar != null) {
                oVarA.c(qVar);
            }
        }
        oVarA.d(obj);
    }

    void E() {
        x();
    }

    public void E0(@m0 y yVar) {
        androidx.databinding.i<y, ViewDataBinding, Void> iVar = this.f7183g;
        if (iVar != null) {
            iVar.r(yVar);
        }
    }

    protected void F0() {
        ViewDataBinding viewDataBinding = this.f7189m;
        if (viewDataBinding != null) {
            viewDataBinding.F0();
            return;
        }
        androidx.lifecycle.q qVar = this.f7190n;
        if (qVar == null || qVar.getLifecycle().b().a(androidx.lifecycle.m.c.STARTED)) {
            synchronized (this) {
                if (this.f7179c) {
                    return;
                }
                this.f7179c = true;
                if (f7174w) {
                    this.f7185i.postFrameCallback(this.f7186j);
                } else {
                    this.f7187k.post(this.f7178b);
                }
            }
        }
    }

    protected void P0(ViewDataBinding viewDataBinding) {
        if (viewDataBinding != null) {
            viewDataBinding.f7189m = this;
        }
    }

    @j0
    public void Q0(@o0 androidx.lifecycle.q qVar) {
        androidx.lifecycle.q qVar2 = this.f7190n;
        if (qVar2 == qVar) {
            return;
        }
        if (qVar2 != null) {
            qVar2.getLifecycle().c(this.f7191o);
        }
        this.f7190n = qVar;
        if (qVar != null) {
            if (this.f7191o == null) {
                this.f7191o = new OnStartListener(this, null);
            }
            qVar.getLifecycle().a(this.f7191o);
        }
        for (o oVar : this.f7181e) {
            if (oVar != null) {
                oVar.c(qVar);
            }
        }
    }

    protected void R0(View view) {
        view.setTag(R.id.dataBinding, this);
    }

    protected void S0(View[] viewArr) {
        for (View view : viewArr) {
            view.setTag(R.id.dataBinding, this);
        }
    }

    @Override // z.c
    @m0
    public View d() {
        return this.f7182f;
    }

    @o0
    public androidx.lifecycle.q e0() {
        return this.f7190n;
    }

    protected Object f0(int i7) {
        o oVar = this.f7181e[i7];
        if (oVar == null) {
            return null;
        }
        return oVar.b();
    }

    public abstract boolean j0();

    public abstract boolean k1(int i7, @o0 Object obj);

    public void l1() {
        for (o oVar : this.f7181e) {
            if (oVar != null) {
                oVar.e();
            }
        }
    }

    public abstract void m0();

    protected boolean m1(int i7) {
        o oVar = this.f7181e[i7];
        if (oVar != null) {
            return oVar.e();
        }
        return false;
    }

    protected boolean n1(int i7, LiveData<?> liveData) {
        this.f7192p = true;
        try {
            return r1(i7, liveData, A);
        } finally {
            this.f7192p = false;
        }
    }

    protected boolean o1(int i7, s sVar) {
        return r1(i7, sVar, f7175x);
    }

    public void p(@m0 y yVar) {
        if (this.f7183g == null) {
            this.f7183g = new androidx.databinding.i<>(B);
        }
        this.f7183g.a(yVar);
    }

    protected boolean p1(int i7, w wVar) {
        return r1(i7, wVar, f7176y);
    }

    protected boolean q1(int i7, x xVar) {
        return r1(i7, xVar, f7177z);
    }

    protected abstract boolean s0(int i7, Object obj, int i8);

    protected void w(Class<?> cls) {
        if (this.f7188l != null) {
            return;
        }
        throw new IllegalStateException("Required DataBindingComponent is null in class " + getClass().getSimpleName() + ". A BindingAdapter in " + cls.getCanonicalName() + " is not static and requires an object to use, retrieved from the DataBindingComponent. If you don't use an inflation method taking a DataBindingComponent, use DataBindingUtil.setDefaultComponent or make all BindingAdapter methods static.");
    }

    protected abstract void x();

    protected ViewDataBinding(Object obj, View view, int i7) {
        this(u(obj), view, i7);
    }
}
