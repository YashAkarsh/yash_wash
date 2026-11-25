package androidx.core.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.OnReceiveContentListener;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"PrivateConstructorForUtilityClass"})
public class n2 {
    public static final int A = 1;
    public static final int B = 1;
    public static final int C = 2;
    public static final int D = 4;
    public static final int E = 8;
    public static final int F = 16;
    public static final int G = 32;
    private static Field I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static boolean f6723J = false;
    private static Field K = null;
    private static boolean L = false;
    private static Method M = null;
    private static Method N = null;
    private static boolean O = false;
    private static WeakHashMap<View, String> P = null;
    private static Method R = null;
    private static Field S = null;
    private static ThreadLocal<Rect> U = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6724a = "ViewCompat";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public static final int f6725b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public static final int f6726c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public static final int f6727d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f6728e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f6729f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f6730g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f6731h = 4;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f6732i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f6733j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f6734k = 2;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Deprecated
    public static final int f6735l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Deprecated
    public static final int f6736m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Deprecated
    public static final int f6737n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f6738o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f6739p = 1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f6740q = 2;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f6741r = 3;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Deprecated
    public static final int f6742s = 16777215;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Deprecated
    public static final int f6743t = -16777216;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Deprecated
    public static final int f6744u = 16;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Deprecated
    public static final int f6745v = 16777216;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f6746w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f6747x = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f6748y = 2;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f6749z = 0;
    private static final AtomicInteger H = new AtomicInteger(1);
    private static WeakHashMap<View, n4> Q = null;
    private static boolean T = false;
    private static final int[] V = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
    private static final b2 W = new b2() { // from class: androidx.core.view.m2
        @Override // androidx.core.view.b2
        public final k a(k kVar) {
            return n2.c1(kVar);
        }
    };
    private static final e X = new e();

    class a extends f<Boolean> {
        a(int i7, Class cls, int i8) {
            super(i7, cls, i8);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.n2.f
        @c.t0(28)
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Boolean d(@c.m0 View view) {
            return Boolean.valueOf(q.d(view));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.n2.f
        @c.t0(28)
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(@c.m0 View view, Boolean bool) {
            q.i(view, bool.booleanValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.n2.f
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface a0 {
    }

    class b extends f<CharSequence> {
        b(int i7, Class cls, int i8, int i9) {
            super(i7, cls, i8, i9);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.n2.f
        @c.t0(28)
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public CharSequence d(View view) {
            return q.b(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.n2.f
        @c.t0(28)
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, CharSequence charSequence) {
            q.h(view, charSequence);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.n2.f
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface b0 {
    }

    class c extends f<CharSequence> {
        c(int i7, Class cls, int i8, int i9) {
            super(i7, cls, i8, i9);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.n2.f
        @c.t0(30)
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public CharSequence d(View view) {
            return s.a(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.n2.f
        @c.t0(30)
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, CharSequence charSequence) {
            s.c(view, charSequence);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.n2.f
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    static class c0 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final ArrayList<WeakReference<View>> f6750d = new ArrayList<>();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @c.o0
        private WeakHashMap<View, Boolean> f6751a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private SparseArray<WeakReference<View>> f6752b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private WeakReference<KeyEvent> f6753c = null;

        c0() {
        }

        static c0 a(View view) {
            c0 c0Var = (c0) view.getTag(R.id.tag_unhandled_key_event_manager);
            if (c0Var != null) {
                return c0Var;
            }
            c0 c0Var2 = new c0();
            view.setTag(R.id.tag_unhandled_key_event_manager, c0Var2);
            return c0Var2;
        }

        @c.o0
        private View c(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f6751a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View viewC = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (viewC != null) {
                            return viewC;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private SparseArray<WeakReference<View>> d() {
            if (this.f6752b == null) {
                this.f6752b = new SparseArray<>();
            }
            return this.f6752b;
        }

        private boolean e(@c.m0 View view, @c.m0 KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((z) arrayList.get(size)).onUnhandledKeyEvent(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        private void g() {
            WeakHashMap<View, Boolean> weakHashMap = this.f6751a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList = f6750d;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                if (this.f6751a == null) {
                    this.f6751a = new WeakHashMap<>();
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ArrayList<WeakReference<View>> arrayList2 = f6750d;
                    View view = arrayList2.get(size).get();
                    if (view == null) {
                        arrayList2.remove(size);
                    } else {
                        this.f6751a.put(view, Boolean.TRUE);
                        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                            this.f6751a.put((View) parent, Boolean.TRUE);
                        }
                    }
                }
            }
        }

        static void h(View view) {
            ArrayList<WeakReference<View>> arrayList = f6750d;
            synchronized (arrayList) {
                Iterator<WeakReference<View>> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next().get() == view) {
                        return;
                    }
                }
                f6750d.add(new WeakReference<>(view));
            }
        }

        static void i(View view) {
            synchronized (f6750d) {
                int i7 = 0;
                while (true) {
                    ArrayList<WeakReference<View>> arrayList = f6750d;
                    if (i7 >= arrayList.size()) {
                        return;
                    }
                    if (arrayList.get(i7).get() == view) {
                        arrayList.remove(i7);
                        return;
                    }
                    i7++;
                }
            }
        }

        boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View viewC = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (viewC != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference<>(viewC));
                }
            }
            return viewC != null;
        }

        boolean f(KeyEvent keyEvent) {
            WeakReference<View> weakReferenceValueAt;
            int iIndexOfKey;
            WeakReference<KeyEvent> weakReference = this.f6753c;
            if (weakReference != null && weakReference.get() == keyEvent) {
                return false;
            }
            this.f6753c = new WeakReference<>(keyEvent);
            SparseArray<WeakReference<View>> sparseArrayD = d();
            if (keyEvent.getAction() != 1 || (iIndexOfKey = sparseArrayD.indexOfKey(keyEvent.getKeyCode())) < 0) {
                weakReferenceValueAt = null;
            } else {
                weakReferenceValueAt = sparseArrayD.valueAt(iIndexOfKey);
                sparseArrayD.removeAt(iIndexOfKey);
            }
            if (weakReferenceValueAt == null) {
                weakReferenceValueAt = sparseArrayD.get(keyEvent.getKeyCode());
            }
            if (weakReferenceValueAt == null) {
                return false;
            }
            View view = weakReferenceValueAt.get();
            if (view != null && n2.O0(view)) {
                e(view, keyEvent);
            }
            return true;
        }
    }

    class d extends f<Boolean> {
        d(int i7, Class cls, int i8) {
            super(i7, cls, i8);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.n2.f
        @c.t0(28)
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Boolean d(View view) {
            return Boolean.valueOf(q.c(view));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.n2.f
        @c.t0(28)
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, Boolean bool) {
            q.g(view, bool.booleanValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.n2.f
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakHashMap<View, Boolean> f6754a = new WeakHashMap<>();

        e() {
        }

        @c.t0(19)
        private void b(View view, boolean z7) {
            boolean z8 = view.isShown() && view.getWindowVisibility() == 0;
            if (z7 != z8) {
                n2.d1(view, z8 ? 16 : 32);
                this.f6754a.put(view, Boolean.valueOf(z8));
            }
        }

        @c.t0(19)
        private void c(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @c.t0(19)
        private void e(View view) {
            h.o(view.getViewTreeObserver(), this);
        }

        @c.t0(19)
        void a(View view) {
            this.f6754a.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(this);
            if (k.b(view)) {
                c(view);
            }
        }

        @c.t0(19)
        void d(View view) {
            this.f6754a.remove(view);
            view.removeOnAttachStateChangeListener(this);
            e(view);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @c.t0(19)
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry<View, Boolean> entry : this.f6754a.entrySet()) {
                    b(entry.getKey(), entry.getValue().booleanValue());
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        @c.t0(19)
        public void onViewAttachedToWindow(View view) {
            c(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    static abstract class f<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f6755a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class<T> f6756b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f6757c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f6758d;

        f(int i7, Class<T> cls, int i8) {
            this(i7, cls, 0, i8);
        }

        private boolean b() {
            return true;
        }

        private boolean c() {
            return Build.VERSION.SDK_INT >= this.f6757c;
        }

        boolean a(Boolean bool, Boolean bool2) {
            return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
        }

        abstract T d(View view);

        abstract void e(View view, T t7);

        T f(View view) {
            if (c()) {
                return d(view);
            }
            if (!b()) {
                return null;
            }
            T t7 = (T) view.getTag(this.f6755a);
            if (this.f6756b.isInstance(t7)) {
                return t7;
            }
            return null;
        }

        void g(View view, T t7) {
            if (c()) {
                e(view, t7);
            } else if (b() && h(f(view), t7)) {
                n2.C(view);
                view.setTag(this.f6755a, t7);
                n2.d1(view, this.f6758d);
            }
        }

        boolean h(T t7, T t8) {
            return !t8.equals(t7);
        }

        f(int i7, Class<T> cls, int i8, int i9) {
            this.f6755a = i7;
            this.f6756b = cls;
            this.f6758d = i8;
            this.f6757c = i9;
        }
    }

    @c.t0(15)
    static class g {
        private g() {
        }

        @c.t
        static boolean a(@c.m0 View view) {
            return view.hasOnClickListeners();
        }
    }

    @c.t0(16)
    static class h {
        private h() {
        }

        @c.t
        static AccessibilityNodeProvider a(View view) {
            return view.getAccessibilityNodeProvider();
        }

        @c.t
        static boolean b(View view) {
            return view.getFitsSystemWindows();
        }

        @c.t
        static int c(View view) {
            return view.getImportantForAccessibility();
        }

        @c.t
        static int d(View view) {
            return view.getMinimumHeight();
        }

        @c.t
        static int e(View view) {
            return view.getMinimumWidth();
        }

        @c.t
        static ViewParent f(View view) {
            return view.getParentForAccessibility();
        }

        @c.t
        static int g(View view) {
            return view.getWindowSystemUiVisibility();
        }

        @c.t
        static boolean h(View view) {
            return view.hasOverlappingRendering();
        }

        @c.t
        static boolean i(View view) {
            return view.hasTransientState();
        }

        @c.t
        static boolean j(View view, int i7, Bundle bundle) {
            return view.performAccessibilityAction(i7, bundle);
        }

        @c.t
        static void k(View view) {
            view.postInvalidateOnAnimation();
        }

        @c.t
        static void l(View view, int i7, int i8, int i9, int i10) {
            view.postInvalidateOnAnimation(i7, i8, i9, i10);
        }

        @c.t
        static void m(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        @c.t
        static void n(View view, Runnable runnable, long j7) {
            view.postOnAnimationDelayed(runnable, j7);
        }

        @c.t
        static void o(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        @c.t
        static void p(View view) {
            view.requestFitSystemWindows();
        }

        @c.t
        static void q(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        @c.t
        static void r(View view, boolean z7) {
            view.setHasTransientState(z7);
        }

        @c.t
        static void s(View view, int i7) {
            view.setImportantForAccessibility(i7);
        }
    }

    @c.t0(17)
    static class i {
        private i() {
        }

        @c.t
        static int a() {
            return View.generateViewId();
        }

        @c.t
        static Display b(@c.m0 View view) {
            return view.getDisplay();
        }

        @c.t
        static int c(View view) {
            return view.getLabelFor();
        }

        @c.t
        static int d(View view) {
            return view.getLayoutDirection();
        }

        @c.t
        static int e(View view) {
            return view.getPaddingEnd();
        }

        @c.t
        static int f(View view) {
            return view.getPaddingStart();
        }

        @c.t
        static boolean g(View view) {
            return view.isPaddingRelative();
        }

        @c.t
        static void h(View view, int i7) {
            view.setLabelFor(i7);
        }

        @c.t
        static void i(View view, Paint paint) {
            view.setLayerPaint(paint);
        }

        @c.t
        static void j(View view, int i7) {
            view.setLayoutDirection(i7);
        }

        @c.t
        static void k(View view, int i7, int i8, int i9, int i10) {
            view.setPaddingRelative(i7, i8, i9, i10);
        }
    }

    @c.t0(18)
    static class j {
        private j() {
        }

        @c.t
        static Rect a(@c.m0 View view) {
            return view.getClipBounds();
        }

        @c.t
        static boolean b(@c.m0 View view) {
            return view.isInLayout();
        }

        @c.t
        static void c(@c.m0 View view, Rect rect) {
            view.setClipBounds(rect);
        }
    }

    @c.t0(19)
    static class k {
        private k() {
        }

        @c.t
        static int a(View view) {
            return view.getAccessibilityLiveRegion();
        }

        @c.t
        static boolean b(@c.m0 View view) {
            return view.isAttachedToWindow();
        }

        @c.t
        static boolean c(@c.m0 View view) {
            return view.isLaidOut();
        }

        @c.t
        static boolean d(@c.m0 View view) {
            return view.isLayoutDirectionResolved();
        }

        @c.t
        static void e(ViewParent viewParent, View view, View view2, int i7) {
            viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i7);
        }

        @c.t
        static void f(View view, int i7) {
            view.setAccessibilityLiveRegion(i7);
        }

        @c.t
        static void g(AccessibilityEvent accessibilityEvent, int i7) {
            accessibilityEvent.setContentChangeTypes(i7);
        }
    }

    @c.t0(20)
    static class l {
        private l() {
        }

        @c.t
        static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        @c.t
        static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        @c.t
        static void c(View view) {
            view.requestApplyInsets();
        }
    }

    @c.t0(21)
    private static class m {

        class a implements View.OnApplyWindowInsetsListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            w5 f6759a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ View f6760b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ z1 f6761c;

            a(View view, z1 z1Var) {
                this.f6760b = view;
                this.f6761c = z1Var;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                w5 w5VarL = w5.L(windowInsets, view);
                int i7 = Build.VERSION.SDK_INT;
                if (i7 < 30) {
                    m.a(windowInsets, this.f6760b);
                    if (w5VarL.equals(this.f6759a)) {
                        return this.f6761c.a(view, w5VarL).J();
                    }
                }
                this.f6759a = w5VarL;
                w5 w5VarA = this.f6761c.a(view, w5VarL);
                if (i7 >= 30) {
                    return w5VarA.J();
                }
                n2.v1(view);
                return w5VarA.J();
            }
        }

        private m() {
        }

        @c.t
        static void a(@c.m0 WindowInsets windowInsets, @c.m0 View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        @c.t
        static w5 b(@c.m0 View view, @c.m0 w5 w5Var, @c.m0 Rect rect) {
            WindowInsets windowInsetsJ = w5Var.J();
            if (windowInsetsJ != null) {
                return w5.L(view.computeSystemWindowInsets(windowInsetsJ, rect), view);
            }
            rect.setEmpty();
            return w5Var;
        }

        @c.t
        static boolean c(@c.m0 View view, float f8, float f9, boolean z7) {
            return view.dispatchNestedFling(f8, f9, z7);
        }

        @c.t
        static boolean d(@c.m0 View view, float f8, float f9) {
            return view.dispatchNestedPreFling(f8, f9);
        }

        @c.t
        static boolean e(View view, int i7, int i8, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i7, i8, iArr, iArr2);
        }

        @c.t
        static boolean f(View view, int i7, int i8, int i9, int i10, int[] iArr) {
            return view.dispatchNestedScroll(i7, i8, i9, i10, iArr);
        }

        @c.t
        static ColorStateList g(View view) {
            return view.getBackgroundTintList();
        }

        @c.t
        static PorterDuff.Mode h(View view) {
            return view.getBackgroundTintMode();
        }

        @c.t
        static float i(View view) {
            return view.getElevation();
        }

        @c.o0
        @c.t
        public static w5 j(@c.m0 View view) {
            return w5.a.a(view);
        }

        @c.t
        static String k(View view) {
            return view.getTransitionName();
        }

        @c.t
        static float l(View view) {
            return view.getTranslationZ();
        }

        @c.t
        static float m(@c.m0 View view) {
            return view.getZ();
        }

        @c.t
        static boolean n(View view) {
            return view.hasNestedScrollingParent();
        }

        @c.t
        static boolean o(View view) {
            return view.isImportantForAccessibility();
        }

        @c.t
        static boolean p(View view) {
            return view.isNestedScrollingEnabled();
        }

        @c.t
        static void q(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        @c.t
        static void r(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        @c.t
        static void s(View view, float f8) {
            view.setElevation(f8);
        }

        @c.t
        static void t(View view, boolean z7) {
            view.setNestedScrollingEnabled(z7);
        }

        @c.t
        static void u(@c.m0 View view, @c.o0 z1 z1Var) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(R.id.tag_on_apply_window_listener, z1Var);
            }
            if (z1Var == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, z1Var));
            }
        }

        @c.t
        static void v(View view, String str) {
            view.setTransitionName(str);
        }

        @c.t
        static void w(View view, float f8) {
            view.setTranslationZ(f8);
        }

        @c.t
        static void x(@c.m0 View view, float f8) {
            view.setZ(f8);
        }

        @c.t
        static boolean y(View view, int i7) {
            return view.startNestedScroll(i7);
        }

        @c.t
        static void z(View view) {
            view.stopNestedScroll();
        }
    }

    @c.t0(23)
    private static class n {
        private n() {
        }

        @c.o0
        public static w5 a(@c.m0 View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            w5 w5VarK = w5.K(rootWindowInsets);
            w5VarK.H(w5VarK);
            w5VarK.d(view.getRootView());
            return w5VarK;
        }

        @c.t
        static int b(@c.m0 View view) {
            return view.getScrollIndicators();
        }

        @c.t
        static void c(@c.m0 View view, int i7) {
            view.setScrollIndicators(i7);
        }

        @c.t
        static void d(@c.m0 View view, int i7, int i8) {
            view.setScrollIndicators(i7, i8);
        }
    }

    @c.t0(24)
    static class o {
        private o() {
        }

        @c.t
        static void a(@c.m0 View view) {
            view.cancelDragAndDrop();
        }

        @c.t
        static void b(View view) {
            view.dispatchFinishTemporaryDetach();
        }

        @c.t
        static void c(View view) {
            view.dispatchStartTemporaryDetach();
        }

        @c.t
        static void d(@c.m0 View view, PointerIcon pointerIcon) {
            view.setPointerIcon(pointerIcon);
        }

        @c.t
        static boolean e(@c.m0 View view, @c.o0 ClipData clipData, @c.m0 View.DragShadowBuilder dragShadowBuilder, @c.o0 Object obj, int i7) {
            return view.startDragAndDrop(clipData, dragShadowBuilder, obj, i7);
        }

        @c.t
        static void f(@c.m0 View view, @c.m0 View.DragShadowBuilder dragShadowBuilder) {
            view.updateDragShadow(dragShadowBuilder);
        }
    }

    @c.t0(26)
    static class p {
        private p() {
        }

        @c.t
        static void a(@c.m0 View view, Collection<View> collection, int i7) {
            view.addKeyboardNavigationClusters(collection, i7);
        }

        @c.t
        static int b(View view) {
            return view.getImportantForAutofill();
        }

        @c.t
        static int c(@c.m0 View view) {
            return view.getNextClusterForwardId();
        }

        @c.t
        static boolean d(@c.m0 View view) {
            return view.hasExplicitFocusable();
        }

        @c.t
        static boolean e(@c.m0 View view) {
            return view.isFocusedByDefault();
        }

        @c.t
        static boolean f(View view) {
            return view.isImportantForAutofill();
        }

        @c.t
        static boolean g(@c.m0 View view) {
            return view.isKeyboardNavigationCluster();
        }

        @c.t
        static View h(@c.m0 View view, View view2, int i7) {
            return view.keyboardNavigationClusterSearch(view2, i7);
        }

        @c.t
        static boolean i(@c.m0 View view) {
            return view.restoreDefaultFocus();
        }

        @c.t
        static void j(@c.m0 View view, String... strArr) {
            view.setAutofillHints(strArr);
        }

        @c.t
        static void k(@c.m0 View view, boolean z7) {
            view.setFocusedByDefault(z7);
        }

        @c.t
        static void l(View view, int i7) {
            view.setImportantForAutofill(i7);
        }

        @c.t
        static void m(@c.m0 View view, boolean z7) {
            view.setKeyboardNavigationCluster(z7);
        }

        @c.t
        static void n(View view, int i7) {
            view.setNextClusterForwardId(i7);
        }

        @c.t
        static void o(@c.m0 View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    @c.t0(28)
    static class q {
        private q() {
        }

        @c.t
        static void a(@c.m0 View view, @c.m0 final z zVar) {
            androidx.collection.i iVar = (androidx.collection.i) view.getTag(R.id.tag_unhandled_key_listeners);
            if (iVar == null) {
                iVar = new androidx.collection.i();
                view.setTag(R.id.tag_unhandled_key_listeners, iVar);
            }
            Objects.requireNonNull(zVar);
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener = new View.OnUnhandledKeyEventListener() { // from class: androidx.core.view.s3
                @Override // android.view.View.OnUnhandledKeyEventListener
                public final boolean onUnhandledKeyEvent(View view2, KeyEvent keyEvent) {
                    return zVar.onUnhandledKeyEvent(view2, keyEvent);
                }
            };
            iVar.put(zVar, onUnhandledKeyEventListener);
            view.addOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        @c.t
        static CharSequence b(View view) {
            return view.getAccessibilityPaneTitle();
        }

        @c.t
        static boolean c(View view) {
            return view.isAccessibilityHeading();
        }

        @c.t
        static boolean d(View view) {
            return view.isScreenReaderFocusable();
        }

        @c.t
        static void e(@c.m0 View view, @c.m0 z zVar) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListenerA;
            androidx.collection.i iVar = (androidx.collection.i) view.getTag(R.id.tag_unhandled_key_listeners);
            if (iVar == null || (onUnhandledKeyEventListenerA = o3.a(iVar.get(zVar))) == null) {
                return;
            }
            view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListenerA);
        }

        @c.t
        static <T> T f(View view, int i7) {
            return (T) view.requireViewById(i7);
        }

        @c.t
        static void g(View view, boolean z7) {
            view.setAccessibilityHeading(z7);
        }

        @c.t
        static void h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        @c.t
        static void i(View view, boolean z7) {
            view.setScreenReaderFocusable(z7);
        }
    }

    @c.t0(29)
    private static class r {
        private r() {
        }

        @c.t
        static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        @c.t
        static List<Rect> b(View view) {
            return view.getSystemGestureExclusionRects();
        }

        @c.t
        static void c(@c.m0 View view, @c.m0 Context context, @c.m0 int[] iArr, @c.o0 AttributeSet attributeSet, @c.m0 TypedArray typedArray, int i7, int i8) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i7, i8);
        }

        @c.t
        static void d(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    @c.t0(30)
    private static class s {
        private s() {
        }

        @c.t
        static CharSequence a(View view) {
            return view.getStateDescription();
        }

        @c.o0
        public static d7 b(@c.m0 View view) {
            WindowInsetsController windowInsetsController = view.getWindowInsetsController();
            if (windowInsetsController != null) {
                return d7.l(windowInsetsController);
            }
            return null;
        }

        @c.t
        static void c(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    @c.t0(31)
    private static final class t {
        private t() {
        }

        @c.o0
        @c.t
        public static String[] a(@c.m0 View view) {
            return view.getReceiveContentMimeTypes();
        }

        @c.o0
        @c.t
        public static androidx.core.view.k b(@c.m0 View view, @c.m0 androidx.core.view.k kVar) {
            ContentInfo contentInfoL = kVar.l();
            ContentInfo contentInfoPerformReceiveContent = view.performReceiveContent(contentInfoL);
            if (contentInfoPerformReceiveContent == null) {
                return null;
            }
            return contentInfoPerformReceiveContent == contentInfoL ? kVar : androidx.core.view.k.m(contentInfoPerformReceiveContent);
        }

        @c.t
        public static void c(@c.m0 View view, @c.o0 String[] strArr, @c.o0 a2 a2Var) {
            if (a2Var == null) {
                view.setOnReceiveContentListener(strArr, null);
            } else {
                view.setOnReceiveContentListener(strArr, new y(a2Var));
            }
        }
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface u {
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface v {
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface w {
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface x {
    }

    @c.t0(31)
    private static final class y implements OnReceiveContentListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @c.m0
        private final a2 f6762a;

        y(@c.m0 a2 a2Var) {
            this.f6762a = a2Var;
        }

        @Override // android.view.OnReceiveContentListener
        @c.o0
        public ContentInfo onReceiveContent(@c.m0 View view, @c.m0 ContentInfo contentInfo) {
            androidx.core.view.k kVarM = androidx.core.view.k.m(contentInfo);
            androidx.core.view.k kVarA = this.f6762a.a(view, kVarM);
            if (kVarA == null) {
                return null;
            }
            return kVarA == kVarM ? contentInfo : kVarA.l();
        }
    }

    public interface z {
        boolean onUnhandledKeyEvent(@c.m0 View view, @c.m0 KeyEvent keyEvent);
    }

    @Deprecated
    protected n2() {
    }

    @c.f1
    static boolean A(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return c0.a(view).f(keyEvent);
    }

    public static float A0(@c.m0 View view) {
        return m.l(view);
    }

    private static f<Boolean> A1() {
        return new a(R.id.tag_screen_reader_focusable, Boolean.class, 28);
    }

    @Deprecated
    public static void A2(View view, float f8) {
        view.setY(f8);
    }

    public static void B(@c.m0 View view) {
        C(view);
    }

    @c.o0
    @Deprecated
    public static d7 B0(@c.m0 View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return s.b(view);
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                Window window = ((Activity) context).getWindow();
                if (window != null) {
                    return r4.a(window, view);
                }
                return null;
            }
        }
        return null;
    }

    public static void B1(@c.m0 View view, @c.o0 androidx.core.view.a aVar) {
        if (aVar == null && (F(view) instanceof androidx.core.view.a.C0076a)) {
            aVar = new androidx.core.view.a();
        }
        view.setAccessibilityDelegate(aVar == null ? null : aVar.d());
    }

    public static void B2(@c.m0 View view, float f8) {
        m.x(view, f8);
    }

    static void C(@c.m0 View view) {
        androidx.core.view.a aVarE = E(view);
        if (aVarE == null) {
            aVarE = new androidx.core.view.a();
        }
        B1(view, aVarE);
    }

    @Deprecated
    public static int C0(@c.m0 View view) {
        return h.g(view);
    }

    @c.f1
    public static void C1(@c.m0 View view, boolean z7) {
        b().g(view, Boolean.valueOf(z7));
    }

    public static boolean C2(@c.m0 View view, @c.o0 ClipData clipData, @c.m0 View.DragShadowBuilder dragShadowBuilder, @c.o0 Object obj, int i7) {
        return Build.VERSION.SDK_INT >= 24 ? o.e(view, clipData, dragShadowBuilder, obj, i7) : view.startDrag(clipData, dragShadowBuilder, obj, i7);
    }

    public static int D() {
        return i.a();
    }

    @Deprecated
    public static float D0(View view) {
        return view.getX();
    }

    public static void D1(@c.m0 View view, int i7) {
        k.f(view, i7);
    }

    public static boolean D2(@c.m0 View view, int i7) {
        return m.y(view, i7);
    }

    @c.o0
    public static androidx.core.view.a E(@c.m0 View view) {
        View.AccessibilityDelegate accessibilityDelegateF = F(view);
        if (accessibilityDelegateF == null) {
            return null;
        }
        return accessibilityDelegateF instanceof androidx.core.view.a.C0076a ? ((androidx.core.view.a.C0076a) accessibilityDelegateF).f6422a : new androidx.core.view.a(accessibilityDelegateF);
    }

    @Deprecated
    public static float E0(View view) {
        return view.getY();
    }

    @c.f1
    public static void E1(@c.m0 View view, @c.o0 CharSequence charSequence) {
        k1().g(view, charSequence);
        if (charSequence != null) {
            X.a(view);
        } else {
            X.d(view);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean E2(@c.m0 View view, int i7, int i8) {
        if (view instanceof r1) {
            return ((r1) view).g(i7, i8);
        }
        if (i8 == 0) {
            return D2(view, i7);
        }
        return false;
    }

    @c.o0
    private static View.AccessibilityDelegate F(@c.m0 View view) {
        return Build.VERSION.SDK_INT >= 29 ? r.a(view) : G(view);
    }

    public static float F0(@c.m0 View view) {
        return m.m(view);
    }

    @Deprecated
    public static void F1(View view, boolean z7) {
        view.setActivated(z7);
    }

    private static f<CharSequence> F2() {
        return new c(R.id.tag_state_description, CharSequence.class, 64, 30);
    }

    @c.o0
    private static View.AccessibilityDelegate G(@c.m0 View view) {
        if (T) {
            return null;
        }
        if (S == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                S = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                T = true;
                return null;
            }
        }
        try {
            Object obj = S.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            T = true;
            return null;
        }
    }

    public static boolean G0(@c.m0 View view) {
        return F(view) != null;
    }

    @Deprecated
    public static void G1(View view, @c.v(from = 0.0d, to = 1.0d) float f8) {
        view.setAlpha(f8);
    }

    public static void G2(@c.m0 View view) {
        m.z(view);
    }

    public static int H(@c.m0 View view) {
        return k.a(view);
    }

    public static boolean H0(@c.m0 View view) {
        return Build.VERSION.SDK_INT >= 26 ? p.d(view) : view.hasFocusable();
    }

    public static void H1(@c.m0 View view, @c.o0 String... strArr) {
        if (Build.VERSION.SDK_INT >= 26) {
            p.j(view, strArr);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void H2(@c.m0 View view, int i7) {
        if (view instanceof r1) {
            ((r1) view).h(i7);
        } else if (i7 == 0) {
            G2(view);
        }
    }

    @c.o0
    public static androidx.core.view.accessibility.r0 I(@c.m0 View view) {
        AccessibilityNodeProvider accessibilityNodeProviderA = h.a(view);
        if (accessibilityNodeProviderA != null) {
            return new androidx.core.view.accessibility.r0(accessibilityNodeProviderA);
        }
        return null;
    }

    public static boolean I0(@c.m0 View view) {
        return m.n(view);
    }

    public static void I1(@c.m0 View view, @c.o0 Drawable drawable) {
        h.q(view, drawable);
    }

    private static void I2(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    @c.o0
    @c.f1
    public static CharSequence J(@c.m0 View view) {
        return k1().f(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean J0(@c.m0 View view, int i7) {
        if (view instanceof r1) {
            ((r1) view).d(i7);
            return false;
        }
        if (i7 == 0) {
            return I0(view);
        }
        return false;
    }

    public static void J1(@c.m0 View view, @c.o0 ColorStateList colorStateList) {
        m.q(view, colorStateList);
    }

    public static void J2(@c.m0 View view, @c.m0 View.DragShadowBuilder dragShadowBuilder) {
        if (Build.VERSION.SDK_INT >= 24) {
            o.f(view, dragShadowBuilder);
        }
    }

    private static List<androidx.core.view.accessibility.l0.a> K(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(R.id.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    public static boolean K0(@c.m0 View view) {
        return g.a(view);
    }

    public static void K1(@c.m0 View view, @c.o0 PorterDuff.Mode mode) {
        m.r(view, mode);
    }

    @Deprecated
    public static float L(View view) {
        return view.getAlpha();
    }

    public static boolean L0(@c.m0 View view) {
        return h.h(view);
    }

    @SuppressLint({"BanUncheckedReflection"})
    @Deprecated
    public static void L1(ViewGroup viewGroup, boolean z7) {
        if (R == null) {
            try {
                R = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException e8) {
                Log.e(f6724a, "Unable to find childrenDrawingOrderEnabled", e8);
            }
            R.setAccessible(true);
        }
        try {
            R.invoke(viewGroup, Boolean.valueOf(z7));
        } catch (IllegalAccessException e9) {
            Log.e(f6724a, "Unable to invoke childrenDrawingOrderEnabled", e9);
        } catch (IllegalArgumentException e10) {
            Log.e(f6724a, "Unable to invoke childrenDrawingOrderEnabled", e10);
        } catch (InvocationTargetException e11) {
            Log.e(f6724a, "Unable to invoke childrenDrawingOrderEnabled", e11);
        }
    }

    private static int M(View view, @c.m0 CharSequence charSequence) {
        List<androidx.core.view.accessibility.l0.a> listK = K(view);
        for (int i7 = 0; i7 < listK.size(); i7++) {
            if (TextUtils.equals(charSequence, listK.get(i7).c())) {
                return listK.get(i7).b();
            }
        }
        int i8 = -1;
        int i9 = 0;
        while (true) {
            int[] iArr = V;
            if (i9 >= iArr.length || i8 != -1) {
                break;
            }
            int i10 = iArr[i9];
            boolean z7 = true;
            for (int i11 = 0; i11 < listK.size(); i11++) {
                z7 &= listK.get(i11).b() != i10;
            }
            if (z7) {
                i8 = i10;
            }
            i9++;
        }
        return i8;
    }

    public static boolean M0(@c.m0 View view) {
        return h.i(view);
    }

    public static void M1(@c.m0 View view, @c.o0 Rect rect) {
        j.c(view, rect);
    }

    @c.o0
    public static ColorStateList N(@c.m0 View view) {
        return m.g(view);
    }

    @c.f1
    public static boolean N0(@c.m0 View view) {
        Boolean boolF = b().f(view);
        return boolF != null && boolF.booleanValue();
    }

    public static void N1(@c.m0 View view, float f8) {
        m.s(view, f8);
    }

    @c.o0
    public static PorterDuff.Mode O(@c.m0 View view) {
        return m.h(view);
    }

    public static boolean O0(@c.m0 View view) {
        return k.b(view);
    }

    @Deprecated
    public static void O1(View view, boolean z7) {
        view.setFitsSystemWindows(z7);
    }

    @c.o0
    public static Rect P(@c.m0 View view) {
        return j.a(view);
    }

    public static boolean P0(@c.m0 View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return p.e(view);
        }
        return false;
    }

    public static void P1(@c.m0 View view, boolean z7) {
        if (Build.VERSION.SDK_INT >= 26) {
            p.k(view, z7);
        }
    }

    @c.o0
    public static Display Q(@c.m0 View view) {
        return i.b(view);
    }

    public static boolean Q0(@c.m0 View view) {
        return m.o(view);
    }

    public static void Q1(@c.m0 View view, boolean z7) {
        h.r(view, z7);
    }

    public static float R(@c.m0 View view) {
        return m.i(view);
    }

    public static boolean R0(@c.m0 View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return p.f(view);
        }
        return true;
    }

    @c.f1
    public static void R1(@c.m0 View view, int i7) {
        h.s(view, i7);
    }

    private static Rect S() {
        if (U == null) {
            U = new ThreadLocal<>();
        }
        Rect rect = U.get();
        if (rect == null) {
            rect = new Rect();
            U.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static boolean S0(@c.m0 View view) {
        return j.b(view);
    }

    public static void S1(@c.m0 View view, int i7) {
        if (Build.VERSION.SDK_INT >= 26) {
            p.l(view, i7);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static b2 T(@c.m0 View view) {
        return view instanceof b2 ? (b2) view : W;
    }

    public static boolean T0(@c.m0 View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return p.g(view);
        }
        return false;
    }

    public static void T1(@c.m0 View view, boolean z7) {
        if (Build.VERSION.SDK_INT >= 26) {
            p.m(view, z7);
        }
    }

    public static boolean U(@c.m0 View view) {
        return h.b(view);
    }

    public static boolean U0(@c.m0 View view) {
        return k.c(view);
    }

    public static void U1(@c.m0 View view, @c.b0 int i7) {
        i.h(view, i7);
    }

    public static int V(@c.m0 View view) {
        return h.c(view);
    }

    public static boolean V0(@c.m0 View view) {
        return k.d(view);
    }

    public static void V1(@c.m0 View view, @c.o0 Paint paint) {
        i.i(view, paint);
    }

    @SuppressLint({"InlinedApi"})
    public static int W(@c.m0 View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return p.b(view);
        }
        return 0;
    }

    public static boolean W0(@c.m0 View view) {
        return m.p(view);
    }

    @Deprecated
    public static void W1(View view, int i7, Paint paint) {
        view.setLayerType(i7, paint);
    }

    public static int X(@c.m0 View view) {
        return i.c(view);
    }

    @Deprecated
    public static boolean X0(View view) {
        return view.isOpaque();
    }

    public static void X1(@c.m0 View view, int i7) {
        i.j(view, i7);
    }

    @Deprecated
    public static int Y(View view) {
        return view.getLayerType();
    }

    public static boolean Y0(@c.m0 View view) {
        return i.g(view);
    }

    public static void Y1(@c.m0 View view, boolean z7) {
        m.t(view, z7);
    }

    public static int Z(@c.m0 View view) {
        return i.d(view);
    }

    @c.f1
    public static boolean Z0(@c.m0 View view) {
        Boolean boolF = A1().f(view);
        return boolF != null && boolF.booleanValue();
    }

    public static void Z1(@c.m0 View view, int i7) {
        if (Build.VERSION.SDK_INT >= 26) {
            p.n(view, i7);
        }
    }

    @c.o0
    @Deprecated
    public static Matrix a0(View view) {
        return view.getMatrix();
    }

    @Deprecated
    public static void a1(View view) {
        view.jumpDrawablesToCurrentState();
    }

    public static void a2(@c.m0 View view, @c.o0 z1 z1Var) {
        m.u(view, z1Var);
    }

    private static f<Boolean> b() {
        return new d(R.id.tag_accessibility_heading, Boolean.class, 28);
    }

    @Deprecated
    public static int b0(View view) {
        return view.getMeasuredHeightAndState();
    }

    @c.o0
    public static View b1(@c.m0 View view, @c.o0 View view2, int i7) {
        if (Build.VERSION.SDK_INT >= 26) {
            return p.h(view, view2, i7);
        }
        return null;
    }

    public static void b2(@c.m0 View view, @c.o0 String[] strArr, @c.o0 a2 a2Var) {
        if (Build.VERSION.SDK_INT >= 31) {
            t.c(view, strArr, a2Var);
            return;
        }
        if (strArr == null || strArr.length == 0) {
            strArr = null;
        }
        boolean z7 = false;
        if (a2Var != null) {
            androidx.core.util.w.b(strArr != null, "When the listener is set, MIME types must also be set");
        }
        if (strArr != null) {
            for (String str : strArr) {
                if (str.startsWith("*")) {
                    z7 = true;
                    break;
                }
            }
            androidx.core.util.w.b(!z7, "A MIME type set here must not start with *: " + Arrays.toString(strArr));
        }
        view.setTag(R.id.tag_on_receive_content_mime_types, strArr);
        view.setTag(R.id.tag_on_receive_content_listener, a2Var);
    }

    public static int c(@c.m0 View view, @c.m0 CharSequence charSequence, @c.m0 androidx.core.view.accessibility.t0 t0Var) {
        int iM = M(view, charSequence);
        if (iM != -1) {
            d(view, new androidx.core.view.accessibility.l0.a(iM, charSequence, t0Var));
        }
        return iM;
    }

    @Deprecated
    public static int c0(View view) {
        return view.getMeasuredState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ androidx.core.view.k c1(androidx.core.view.k kVar) {
        return kVar;
    }

    @Deprecated
    public static void c2(View view, int i7) {
        view.setOverScrollMode(i7);
    }

    private static void d(@c.m0 View view, @c.m0 androidx.core.view.accessibility.l0.a aVar) {
        C(view);
        s1(aVar.b(), view);
        K(view).add(aVar);
        d1(view, 0);
    }

    @Deprecated
    public static int d0(View view) {
        return view.getMeasuredWidthAndState();
    }

    @c.t0(19)
    static void d1(View view, int i7) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z7 = J(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (H(view) != 0 || z7) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z7 ? 32 : 2048);
                k.g(accessibilityEventObtain, i7);
                if (z7) {
                    accessibilityEventObtain.getText().add(J(view));
                    x2(view);
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i7 == 32) {
                AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.setEventType(32);
                k.g(accessibilityEventObtain2, i7);
                accessibilityEventObtain2.setSource(view);
                view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.getText().add(J(view));
                accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
                return;
            }
            if (view.getParent() != null) {
                try {
                    k.e(view.getParent(), view, view, i7);
                } catch (AbstractMethodError e8) {
                    Log.e(f6724a, view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e8);
                }
            }
        }
    }

    public static void d2(@c.m0 View view, @c.r0 int i7, @c.r0 int i8, @c.r0 int i9, @c.r0 int i10) {
        i.k(view, i7, i8, i9, i10);
    }

    public static void e(@c.m0 View view, @c.m0 Collection<View> collection, int i7) {
        if (Build.VERSION.SDK_INT >= 26) {
            p.a(view, collection, i7);
        }
    }

    public static int e0(@c.m0 View view) {
        return h.d(view);
    }

    public static void e1(@c.m0 View view, int i7) {
        view.offsetLeftAndRight(i7);
    }

    @Deprecated
    public static void e2(View view, float f8) {
        view.setPivotX(f8);
    }

    public static void f(@c.m0 View view, @c.m0 z zVar) {
        if (Build.VERSION.SDK_INT >= 28) {
            q.a(view, zVar);
            return;
        }
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
        if (arrayList == null) {
            arrayList = new ArrayList();
            view.setTag(R.id.tag_unhandled_key_listeners, arrayList);
        }
        arrayList.add(zVar);
        if (arrayList.size() == 1) {
            c0.h(view);
        }
    }

    public static int f0(@c.m0 View view) {
        return h.e(view);
    }

    public static void f1(@c.m0 View view, int i7) {
        view.offsetTopAndBottom(i7);
    }

    @Deprecated
    public static void f2(View view, float f8) {
        view.setPivotY(f8);
    }

    @c.m0
    public static n4 g(@c.m0 View view) {
        if (Q == null) {
            Q = new WeakHashMap<>();
        }
        n4 n4Var = Q.get(view);
        if (n4Var != null) {
            return n4Var;
        }
        n4 n4Var2 = new n4(view);
        Q.put(view, n4Var2);
        return n4Var2;
    }

    public static int g0(@c.m0 View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return p.c(view);
        }
        return -1;
    }

    @c.m0
    public static w5 g1(@c.m0 View view, @c.m0 w5 w5Var) {
        WindowInsets windowInsetsJ = w5Var.J();
        if (windowInsetsJ != null) {
            WindowInsets windowInsetsB = l.b(view, windowInsetsJ);
            if (!windowInsetsB.equals(windowInsetsJ)) {
                return w5.L(windowInsetsB, view);
            }
        }
        return w5Var;
    }

    public static void g2(@c.m0 View view, @c.o0 g2 g2Var) {
        if (Build.VERSION.SDK_INT >= 24) {
            o.d(view, l2.a(g2Var != null ? g2Var.b() : null));
        }
    }

    private static void h() {
        try {
            M = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);
            N = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);
        } catch (NoSuchMethodException e8) {
            Log.e(f6724a, "Couldn't find method", e8);
        }
        O = true;
    }

    @c.o0
    public static String[] h0(@c.m0 View view) {
        return Build.VERSION.SDK_INT >= 31 ? t.a(view) : (String[]) view.getTag(R.id.tag_on_receive_content_mime_types);
    }

    @Deprecated
    public static void h1(View view, AccessibilityEvent accessibilityEvent) {
        view.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    @Deprecated
    public static void h2(View view, float f8) {
        view.setRotation(f8);
    }

    @Deprecated
    public static boolean i(View view, int i7) {
        return view.canScrollHorizontally(i7);
    }

    @Deprecated
    public static int i0(View view) {
        return view.getOverScrollMode();
    }

    public static void i1(@c.m0 View view, @c.m0 androidx.core.view.accessibility.l0 l0Var) {
        view.onInitializeAccessibilityNodeInfo(l0Var.W1());
    }

    @Deprecated
    public static void i2(View view, float f8) {
        view.setRotationX(f8);
    }

    @Deprecated
    public static boolean j(View view, int i7) {
        return view.canScrollVertically(i7);
    }

    @c.r0
    public static int j0(@c.m0 View view) {
        return i.e(view);
    }

    @Deprecated
    public static void j1(View view, AccessibilityEvent accessibilityEvent) {
        view.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Deprecated
    public static void j2(View view, float f8) {
        view.setRotationY(f8);
    }

    public static void k(@c.m0 View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            o.a(view);
        }
    }

    @c.r0
    public static int k0(@c.m0 View view) {
        return i.f(view);
    }

    private static f<CharSequence> k1() {
        return new b(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28);
    }

    @Deprecated
    public static void k2(View view, boolean z7) {
        view.setSaveFromParentEnabled(z7);
    }

    @Deprecated
    public static int l(int i7, int i8) {
        return View.combineMeasuredStates(i7, i8);
    }

    @c.o0
    public static ViewParent l0(@c.m0 View view) {
        return h.f(view);
    }

    public static boolean l1(@c.m0 View view, int i7, @c.o0 Bundle bundle) {
        return h.j(view, i7, bundle);
    }

    @Deprecated
    public static void l2(View view, float f8) {
        view.setScaleX(f8);
    }

    private static void m(View view, int i7) {
        view.offsetLeftAndRight(i7);
        if (view.getVisibility() == 0) {
            I2(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                I2((View) parent);
            }
        }
    }

    @Deprecated
    public static float m0(View view) {
        return view.getPivotX();
    }

    @c.o0
    public static androidx.core.view.k m1(@c.m0 View view, @c.m0 androidx.core.view.k kVar) {
        if (Log.isLoggable(f6724a, 3)) {
            Log.d(f6724a, "performReceiveContent: " + kVar + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return t.b(view, kVar);
        }
        a2 a2Var = (a2) view.getTag(R.id.tag_on_receive_content_listener);
        if (a2Var == null) {
            return T(view).a(kVar);
        }
        androidx.core.view.k kVarA = a2Var.a(view, kVar);
        if (kVarA == null) {
            return null;
        }
        return T(view).a(kVarA);
    }

    @Deprecated
    public static void m2(View view, float f8) {
        view.setScaleY(f8);
    }

    private static void n(View view, int i7) {
        view.offsetTopAndBottom(i7);
        if (view.getVisibility() == 0) {
            I2(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                I2((View) parent);
            }
        }
    }

    @Deprecated
    public static float n0(View view) {
        return view.getPivotY();
    }

    public static void n1(@c.m0 View view) {
        h.k(view);
    }

    @c.f1
    public static void n2(@c.m0 View view, boolean z7) {
        A1().g(view, Boolean.valueOf(z7));
    }

    @c.m0
    public static w5 o(@c.m0 View view, @c.m0 w5 w5Var, @c.m0 Rect rect) {
        return m.b(view, w5Var, rect);
    }

    @c.o0
    public static w5 o0(@c.m0 View view) {
        return n.a(view);
    }

    public static void o1(@c.m0 View view, int i7, int i8, int i9, int i10) {
        h.l(view, i7, i8, i9, i10);
    }

    public static void o2(@c.m0 View view, int i7) {
        n.c(view, i7);
    }

    @c.m0
    public static w5 p(@c.m0 View view, @c.m0 w5 w5Var) {
        WindowInsets windowInsetsJ = w5Var.J();
        if (windowInsetsJ != null) {
            WindowInsets windowInsetsA = l.a(view, windowInsetsJ);
            if (!windowInsetsA.equals(windowInsetsJ)) {
                return w5.L(windowInsetsA, view);
            }
        }
        return w5Var;
    }

    @Deprecated
    public static float p0(View view) {
        return view.getRotation();
    }

    public static void p1(@c.m0 View view, @c.m0 Runnable runnable) {
        h.m(view, runnable);
    }

    public static void p2(@c.m0 View view, int i7, int i8) {
        n.d(view, i7, i8);
    }

    public static void q(@c.m0 View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            o.b(view);
            return;
        }
        if (!O) {
            h();
        }
        Method method = N;
        if (method == null) {
            view.onFinishTemporaryDetach();
            return;
        }
        try {
            method.invoke(view, new Object[0]);
        } catch (Exception e8) {
            Log.d(f6724a, "Error calling dispatchFinishTemporaryDetach", e8);
        }
    }

    @Deprecated
    public static float q0(View view) {
        return view.getRotationX();
    }

    @SuppressLint({"LambdaLast"})
    public static void q1(@c.m0 View view, @c.m0 Runnable runnable, long j7) {
        h.n(view, runnable, j7);
    }

    @c.f1
    public static void q2(@c.m0 View view, @c.o0 CharSequence charSequence) {
        F2().g(view, charSequence);
    }

    public static boolean r(@c.m0 View view, float f8, float f9, boolean z7) {
        return m.c(view, f8, f9, z7);
    }

    @Deprecated
    public static float r0(View view) {
        return view.getRotationY();
    }

    public static void r1(@c.m0 View view, int i7) {
        s1(i7, view);
        d1(view, 0);
    }

    public static void r2(@c.m0 View view, @c.m0 List<Rect> list) {
        if (Build.VERSION.SDK_INT >= 29) {
            r.d(view, list);
        }
    }

    public static boolean s(@c.m0 View view, float f8, float f9) {
        return m.d(view, f8, f9);
    }

    @Deprecated
    public static float s0(View view) {
        return view.getScaleX();
    }

    private static void s1(int i7, View view) {
        List<androidx.core.view.accessibility.l0.a> listK = K(view);
        for (int i8 = 0; i8 < listK.size(); i8++) {
            if (listK.get(i8).b() == i7) {
                listK.remove(i8);
                return;
            }
        }
    }

    public static void s2(@c.m0 View view, @c.o0 CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            p.o(view, charSequence);
        }
    }

    public static boolean t(@c.m0 View view, int i7, int i8, @c.o0 int[] iArr, @c.o0 int[] iArr2) {
        return m.e(view, i7, i8, iArr, iArr2);
    }

    @Deprecated
    public static float t0(View view) {
        return view.getScaleY();
    }

    public static void t1(@c.m0 View view, @c.m0 z zVar) {
        if (Build.VERSION.SDK_INT >= 28) {
            q.e(view, zVar);
            return;
        }
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
        if (arrayList != null) {
            arrayList.remove(zVar);
            if (arrayList.size() == 0) {
                c0.i(view);
            }
        }
    }

    public static void t2(@c.m0 View view, @c.o0 String str) {
        m.v(view, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean u(@c.m0 View view, int i7, int i8, @c.o0 int[] iArr, @c.o0 int[] iArr2, int i9) {
        if (view instanceof r1) {
            return ((r1) view).b(i7, i8, iArr, iArr2, i9);
        }
        if (i9 == 0) {
            return t(view, i7, i8, iArr, iArr2);
        }
        return false;
    }

    public static int u0(@c.m0 View view) {
        return n.b(view);
    }

    public static void u1(@c.m0 View view, @c.m0 androidx.core.view.accessibility.l0.a aVar, @c.o0 CharSequence charSequence, @c.o0 androidx.core.view.accessibility.t0 t0Var) {
        if (t0Var == null && charSequence == null) {
            r1(view, aVar.b());
        } else {
            d(view, aVar.a(charSequence, t0Var));
        }
    }

    @Deprecated
    public static void u2(View view, float f8) {
        view.setTranslationX(f8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void v(@c.m0 View view, int i7, int i8, int i9, int i10, @c.o0 int[] iArr, int i11, @c.m0 int[] iArr2) {
        if (view instanceof s1) {
            ((s1) view).c(i7, i8, i9, i10, iArr, i11, iArr2);
        } else {
            x(view, i7, i8, i9, i10, iArr, i11);
        }
    }

    @c.o0
    @c.f1
    public static CharSequence v0(@c.m0 View view) {
        return F2().f(view);
    }

    public static void v1(@c.m0 View view) {
        l.c(view);
    }

    @Deprecated
    public static void v2(View view, float f8) {
        view.setTranslationY(f8);
    }

    public static boolean w(@c.m0 View view, int i7, int i8, int i9, int i10, @c.o0 int[] iArr) {
        return m.f(view, i7, i8, i9, i10, iArr);
    }

    @c.m0
    public static List<Rect> w0(@c.m0 View view) {
        return Build.VERSION.SDK_INT >= 29 ? r.b(view) : Collections.emptyList();
    }

    @c.m0
    public static <T extends View> T w1(@c.m0 View view, @c.b0 int i7) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T) q.f(view, i7);
        }
        T t7 = (T) view.findViewById(i7);
        if (t7 != null) {
            return t7;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this View");
    }

    public static void w2(@c.m0 View view, float f8) {
        m.w(view, f8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean x(@c.m0 View view, int i7, int i8, int i9, int i10, @c.o0 int[] iArr, int i11) {
        if (view instanceof r1) {
            return ((r1) view).a(i7, i8, i9, i10, iArr, i11);
        }
        if (i11 == 0) {
            return w(view, i7, i8, i9, i10, iArr);
        }
        return false;
    }

    @c.o0
    public static String x0(@c.m0 View view) {
        return m.k(view);
    }

    @Deprecated
    public static int x1(int i7, int i8, int i9) {
        return View.resolveSizeAndState(i7, i8, i9);
    }

    private static void x2(View view) {
        if (V(view) == 0) {
            R1(view, 1);
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (V((View) parent) == 4) {
                R1(view, 2);
                return;
            }
        }
    }

    public static void y(@c.m0 View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            o.c(view);
            return;
        }
        if (!O) {
            h();
        }
        Method method = M;
        if (method == null) {
            view.onStartTemporaryDetach();
            return;
        }
        try {
            method.invoke(view, new Object[0]);
        } catch (Exception e8) {
            Log.d(f6724a, "Error calling dispatchStartTemporaryDetach", e8);
        }
    }

    @Deprecated
    public static float y0(View view) {
        return view.getTranslationX();
    }

    public static boolean y1(@c.m0 View view) {
        return Build.VERSION.SDK_INT >= 26 ? p.i(view) : view.requestFocus();
    }

    public static void y2(@c.m0 View view, @c.o0 u4.b bVar) {
        u4.h(view, bVar);
    }

    @c.f1
    static boolean z(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return c0.a(view).b(view, keyEvent);
    }

    @Deprecated
    public static float z0(View view) {
        return view.getTranslationY();
    }

    public static void z1(@c.m0 View view, @c.m0 @SuppressLint({"ContextFirst"}) Context context, @c.m0 int[] iArr, @c.o0 AttributeSet attributeSet, @c.m0 TypedArray typedArray, int i7, int i8) {
        if (Build.VERSION.SDK_INT >= 29) {
            r.c(view, context, iArr, attributeSet, typedArray, i7, i8);
        }
    }

    @Deprecated
    public static void z2(View view, float f8) {
        view.setX(f8);
    }
}
