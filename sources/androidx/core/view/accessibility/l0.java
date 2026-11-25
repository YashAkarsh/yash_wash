package androidx.core.view.accessibility;

import android.R;
import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import c.x0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class l0 {
    public static final int A = 256;
    public static final int B = 512;
    public static final int C = 1024;
    public static final int D = 2048;
    public static final int E = 4096;
    public static final int F = 8192;
    public static final int G = 16384;
    public static final int H = 32768;
    public static final int I = 65536;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final int f6455J = 131072;
    public static final int K = 262144;
    public static final int L = 524288;
    public static final int M = 1048576;
    public static final int N = 2097152;
    public static final String O = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
    public static final String P = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
    public static final String Q = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
    public static final String R = "ACTION_ARGUMENT_SELECTION_START_INT";
    public static final String S = "ACTION_ARGUMENT_SELECTION_END_INT";
    public static final String T = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
    public static final String U = "android.view.accessibility.action.ARGUMENT_ROW_INT";
    public static final String V = "android.view.accessibility.action.ARGUMENT_COLUMN_INT";
    public static final String W = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE";
    public static final String X = "ACTION_ARGUMENT_MOVE_WINDOW_X";
    public static final String Y = "ACTION_ARGUMENT_MOVE_WINDOW_Y";

    @SuppressLint({"ActionValue"})
    public static final String Z = "android.view.accessibility.action.ARGUMENT_PRESS_AND_HOLD_DURATION_MILLIS_INT";

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final int f6456a0 = 1;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final int f6457b0 = 2;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final int f6458c0 = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f6459d = "AccessibilityNodeInfo.roleDescription";

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final int f6460d0 = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f6461e = "androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY";

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final int f6462e0 = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f6463f = "androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY";

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final int f6464f0 = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f6465g = "androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY";

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final int f6466g0 = 16;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f6467h = "androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY";

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private static int f6468h0 = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f6469i = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f6470j = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f6471k = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f6472l = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f6473m = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f6474n = "androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f6475o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f6476p = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f6477q = 4;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int f6478r = 8;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f6479s = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f6480t = 2;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f6481u = 4;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f6482v = 8;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f6483w = 16;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f6484x = 32;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f6485y = 64;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f6486z = 128;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AccessibilityNodeInfo f6487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public int f6488b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6489c = -1;

    public static class a {
        public static final a B;
        public static final a C;
        public static final a D;
        public static final a E;
        public static final a F;
        public static final a G;

        @c.m0
        public static final a H;

        @c.m0
        public static final a I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        @c.m0
        public static final a f6490J;

        @c.m0
        public static final a K;
        public static final a L;
        public static final a M;
        public static final a N;
        public static final a O;
        public static final a P;

        @c.m0
        public static final a Q;

        @c.m0
        public static final a R;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final String f6491e = "A11yActionCompat";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f6513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f6514b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Class<? extends t0.a> f6515c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @x0({x0.a.LIBRARY_GROUP_PREFIX})
        protected final t0 f6516d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f6492f = new a(1, null);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f6493g = new a(2, null);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f6494h = new a(4, null);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f6495i = new a(8, null);

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final a f6496j = new a(16, null);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final a f6497k = new a(32, null);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final a f6498l = new a(64, null);

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final a f6499m = new a(128, null);

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final a f6500n = new a(256, (CharSequence) null, (Class<? extends t0.a>) t0.b.class);

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final a f6501o = new a(512, (CharSequence) null, (Class<? extends t0.a>) t0.b.class);

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final a f6502p = new a(1024, (CharSequence) null, (Class<? extends t0.a>) t0.c.class);

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final a f6503q = new a(2048, (CharSequence) null, (Class<? extends t0.a>) t0.c.class);

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final a f6504r = new a(4096, null);

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final a f6505s = new a(8192, null);

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final a f6506t = new a(16384, null);

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final a f6507u = new a(32768, null);

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final a f6508v = new a(65536, null);

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final a f6509w = new a(131072, (CharSequence) null, (Class<? extends t0.a>) t0.g.class);

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final a f6510x = new a(262144, null);

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final a f6511y = new a(524288, null);

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final a f6512z = new a(1048576, null);
        public static final a A = new a(2097152, (CharSequence) null, (Class<? extends t0.a>) t0.h.class);

        static {
            int i7 = Build.VERSION.SDK_INT;
            B = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);
            C = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, t0.e.class);
            D = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);
            E = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);
            F = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);
            G = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);
            H = new a(i7 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
            I = new a(i7 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
            f6490J = new a(i7 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
            K = new a(i7 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
            L = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);
            M = new a(i7 >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, R.id.accessibilityActionSetProgress, null, null, t0.f.class);
            N = new a(i7 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id.accessibilityActionMoveWindow, null, null, t0.d.class);
            O = new a(i7 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
            P = new a(i7 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
            Q = new a(i7 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
            R = new a(i7 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
        }

        public a(int i7, CharSequence charSequence) {
            this(null, i7, charSequence, null, null);
        }

        @x0({x0.a.LIBRARY_GROUP_PREFIX})
        public a a(CharSequence charSequence, t0 t0Var) {
            return new a(null, this.f6514b, charSequence, t0Var, this.f6515c);
        }

        public int b() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f6513a).getId();
        }

        public CharSequence c() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f6513a).getLabel();
        }

        @x0({x0.a.LIBRARY_GROUP_PREFIX})
        public boolean d(View view, Bundle bundle) {
            if (this.f6516d == null) {
                return false;
            }
            Class<? extends t0.a> cls = this.f6515c;
            t0.a aVar = null;
            if (cls != null) {
                try {
                    t0.a aVarNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    try {
                        aVarNewInstance.a(bundle);
                        aVar = aVarNewInstance;
                    } catch (Exception e8) {
                        e = e8;
                        aVar = aVarNewInstance;
                        Class<? extends t0.a> cls2 = this.f6515c;
                        Log.e(f6491e, "Failed to execute command with argument class ViewCommandArgument: " + (cls2 == null ? "null" : cls2.getName()), e);
                    }
                } catch (Exception e9) {
                    e = e9;
                }
            }
            return this.f6516d.a(view, aVar);
        }

        public boolean equals(@c.o0 Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object obj2 = this.f6513a;
            if (obj2 == null) {
                return aVar.f6513a == null;
            }
            return obj2.equals(aVar.f6513a);
        }

        public int hashCode() {
            Object obj = this.f6513a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        @x0({x0.a.LIBRARY_GROUP_PREFIX})
        public a(int i7, CharSequence charSequence, t0 t0Var) {
            this(null, i7, charSequence, t0Var, null);
        }

        a(Object obj) {
            this(obj, 0, null, null, null);
        }

        private a(int i7, CharSequence charSequence, Class<? extends t0.a> cls) {
            this(null, i7, charSequence, null, cls);
        }

        a(Object obj, int i7, CharSequence charSequence, t0 t0Var, Class<? extends t0.a> cls) {
            this.f6514b = i7;
            this.f6516d = t0Var;
            if (obj == null) {
                this.f6513a = new AccessibilityNodeInfo.AccessibilityAction(i7, charSequence);
            } else {
                this.f6513a = obj;
            }
            this.f6515c = cls;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f6517b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f6518c = 1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f6519d = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f6520a;

        b(Object obj) {
            this.f6520a = obj;
        }

        public static b e(int i7, int i8, boolean z7) {
            return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i7, i8, z7));
        }

        public static b f(int i7, int i8, boolean z7, int i9) {
            return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i7, i8, z7, i9));
        }

        public int a() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.f6520a).getColumnCount();
        }

        public int b() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.f6520a).getRowCount();
        }

        public int c() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.f6520a).getSelectionMode();
        }

        public boolean d() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.f6520a).isHierarchical();
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f6521a;

        c(Object obj) {
            this.f6521a = obj;
        }

        public static c g(int i7, int i8, int i9, int i10, boolean z7) {
            return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i7, i8, i9, i10, z7));
        }

        public static c h(int i7, int i8, int i9, int i10, boolean z7, boolean z8) {
            return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i7, i8, i9, i10, z7, z8));
        }

        public int a() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.f6521a).getColumnIndex();
        }

        public int b() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.f6521a).getColumnSpan();
        }

        public int c() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.f6521a).getRowIndex();
        }

        public int d() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.f6521a).getRowSpan();
        }

        @Deprecated
        public boolean e() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.f6521a).isHeading();
        }

        public boolean f() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.f6521a).isSelected();
        }
    }

    public static class d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f6522b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f6523c = 1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f6524d = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f6525a;

        d(Object obj) {
            this.f6525a = obj;
        }

        public static d e(int i7, float f8, float f9, float f10) {
            return new d(AccessibilityNodeInfo.RangeInfo.obtain(i7, f8, f9, f10));
        }

        public float a() {
            return ((AccessibilityNodeInfo.RangeInfo) this.f6525a).getCurrent();
        }

        public float b() {
            return ((AccessibilityNodeInfo.RangeInfo) this.f6525a).getMax();
        }

        public float c() {
            return ((AccessibilityNodeInfo.RangeInfo) this.f6525a).getMin();
        }

        public int d() {
            return ((AccessibilityNodeInfo.RangeInfo) this.f6525a).getType();
        }
    }

    @Deprecated
    public l0(Object obj) {
        this.f6487a = (AccessibilityNodeInfo) obj;
    }

    public static l0 C0() {
        return X1(AccessibilityNodeInfo.obtain());
    }

    public static l0 D0(View view) {
        return X1(AccessibilityNodeInfo.obtain(view));
    }

    public static l0 E0(View view, int i7) {
        return Y1(AccessibilityNodeInfo.obtain(view, i7));
    }

    public static l0 F0(l0 l0Var) {
        return X1(AccessibilityNodeInfo.obtain(l0Var.f6487a));
    }

    private SparseArray<WeakReference<ClickableSpan>> M(View view) {
        SparseArray<WeakReference<ClickableSpan>> sparseArrayS = S(view);
        if (sparseArrayS != null) {
            return sparseArrayS;
        }
        SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
        view.setTag(androidx.core.R.id.tag_accessibility_clickable_spans, sparseArray);
        return sparseArray;
    }

    private void N0(View view) {
        SparseArray<WeakReference<ClickableSpan>> sparseArrayS = S(view);
        if (sparseArrayS != null) {
            ArrayList arrayList = new ArrayList();
            for (int i7 = 0; i7 < sparseArrayS.size(); i7++) {
                if (sparseArrayS.valueAt(i7).get() == null) {
                    arrayList.add(Integer.valueOf(i7));
                }
            }
            for (int i8 = 0; i8 < arrayList.size(); i8++) {
                sparseArrayS.remove(((Integer) arrayList.get(i8)).intValue());
            }
        }
    }

    private void Q0(int i7, boolean z7) {
        Bundle bundleD = D();
        if (bundleD != null) {
            int i8 = bundleD.getInt(f6467h, 0) & (~i7);
            if (!z7) {
                i7 = 0;
            }
            bundleD.putInt(f6467h, i7 | i8);
        }
    }

    private SparseArray<WeakReference<ClickableSpan>> S(View view) {
        return (SparseArray) view.getTag(androidx.core.R.id.tag_accessibility_clickable_spans);
    }

    public static l0 X1(@c.m0 AccessibilityNodeInfo accessibilityNodeInfo) {
        return new l0(accessibilityNodeInfo);
    }

    static l0 Y1(Object obj) {
        if (obj != null) {
            return new l0(obj);
        }
        return null;
    }

    private void e(ClickableSpan clickableSpan, Spanned spanned, int i7) {
        i(f6470j).add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        i(f6471k).add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        i(f6472l).add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        i(f6469i).add(Integer.valueOf(i7));
    }

    private boolean e0() {
        return !i(f6470j).isEmpty();
    }

    private int f0(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i7 = 0; i7 < sparseArray.size(); i7++) {
                if (clickableSpan.equals(sparseArray.valueAt(i7).get())) {
                    return sparseArray.keyAt(i7);
                }
            }
        }
        int i8 = f6468h0;
        f6468h0 = i8 + 1;
        return i8;
    }

    private void h() {
        this.f6487a.getExtras().remove(f6470j);
        this.f6487a.getExtras().remove(f6471k);
        this.f6487a.getExtras().remove(f6472l);
        this.f6487a.getExtras().remove(f6469i);
    }

    private List<Integer> i(String str) {
        ArrayList<Integer> integerArrayList = this.f6487a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f6487a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    private static String o(int i7) {
        if (i7 == 1) {
            return "ACTION_FOCUS";
        }
        if (i7 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i7) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            case R.id.accessibilityActionImeEnter:
                return "ACTION_IME_ENTER";
            default:
                switch (i7) {
                    case R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i7) {
                            case R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            case R.id.accessibilityActionPressAndHold:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                return "ACTION_UNKNOWN";
                        }
                }
        }
    }

    private boolean r(int i7) {
        Bundle bundleD = D();
        return bundleD != null && (bundleD.getInt(f6467h, 0) & i7) == i7;
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public static ClickableSpan[] x(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    public CharSequence A() {
        return this.f6487a.getContentDescription();
    }

    public boolean A0() {
        return Build.VERSION.SDK_INT >= 29 ? this.f6487a.isTextEntryKey() : r(8);
    }

    public void A1(View view, int i7) {
        this.f6488b = i7;
        this.f6487a.setParent(view, i7);
    }

    public int B() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.f6487a.getDrawingOrder();
        }
        return 0;
    }

    public boolean B0() {
        return this.f6487a.isVisibleToUser();
    }

    public void B1(boolean z7) {
        this.f6487a.setPassword(z7);
    }

    public CharSequence C() {
        return this.f6487a.getError();
    }

    public void C1(d dVar) {
        this.f6487a.setRangeInfo((AccessibilityNodeInfo.RangeInfo) dVar.f6525a);
    }

    public Bundle D() {
        return this.f6487a.getExtras();
    }

    public void D1(@c.o0 CharSequence charSequence) {
        this.f6487a.getExtras().putCharSequence(f6459d, charSequence);
    }

    @c.o0
    public CharSequence E() {
        return Build.VERSION.SDK_INT >= 26 ? this.f6487a.getHintText() : this.f6487a.getExtras().getCharSequence(f6465g);
    }

    public void E1(boolean z7) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f6487a.setScreenReaderFocusable(z7);
        } else {
            Q0(1, z7);
        }
    }

    @Deprecated
    public Object F() {
        return this.f6487a;
    }

    public void F1(boolean z7) {
        this.f6487a.setScrollable(z7);
    }

    public int G() {
        return this.f6487a.getInputType();
    }

    public boolean G0(int i7) {
        return this.f6487a.performAction(i7);
    }

    public void G1(boolean z7) {
        this.f6487a.setSelected(z7);
    }

    public l0 H() {
        return Y1(this.f6487a.getLabelFor());
    }

    public boolean H0(int i7, Bundle bundle) {
        return this.f6487a.performAction(i7, bundle);
    }

    public void H1(boolean z7) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f6487a.setShowingHintText(z7);
        } else {
            Q0(4, z7);
        }
    }

    public l0 I() {
        return Y1(this.f6487a.getLabeledBy());
    }

    public void I0() {
        this.f6487a.recycle();
    }

    public void I1(View view) {
        this.f6489c = -1;
        this.f6487a.setSource(view);
    }

    public int J() {
        return this.f6487a.getLiveRegion();
    }

    public boolean J0() {
        return this.f6487a.refresh();
    }

    public void J1(View view, int i7) {
        this.f6489c = i7;
        this.f6487a.setSource(view, i7);
    }

    public int K() {
        return this.f6487a.getMaxTextLength();
    }

    public boolean K0(a aVar) {
        return this.f6487a.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f6513a);
    }

    public void K1(@c.o0 CharSequence charSequence) {
        if (androidx.core.os.a.h()) {
            this.f6487a.setStateDescription(charSequence);
        } else {
            this.f6487a.getExtras().putCharSequence(f6474n, charSequence);
        }
    }

    public int L() {
        return this.f6487a.getMovementGranularities();
    }

    public boolean L0(View view) {
        return this.f6487a.removeChild(view);
    }

    public void L1(CharSequence charSequence) {
        this.f6487a.setText(charSequence);
    }

    public boolean M0(View view, int i7) {
        return this.f6487a.removeChild(view, i7);
    }

    public void M1(boolean z7) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f6487a.setTextEntryKey(z7);
        } else {
            Q0(8, z7);
        }
    }

    public CharSequence N() {
        return this.f6487a.getPackageName();
    }

    public void N1(int i7, int i8) {
        this.f6487a.setTextSelection(i7, i8);
    }

    @c.o0
    public CharSequence O() {
        return Build.VERSION.SDK_INT >= 28 ? this.f6487a.getPaneTitle() : this.f6487a.getExtras().getCharSequence(f6461e);
    }

    public void O0(boolean z7) {
        this.f6487a.setAccessibilityFocused(z7);
    }

    public void O1(@c.o0 CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f6487a.setTooltipText(charSequence);
        } else {
            this.f6487a.getExtras().putCharSequence(f6463f, charSequence);
        }
    }

    public l0 P() {
        return Y1(this.f6487a.getParent());
    }

    public void P0(@c.m0 List<String> list) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f6487a.setAvailableExtraData(list);
        }
    }

    public void P1(@c.m0 e eVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f6487a.setTouchDelegateInfo(eVar.f6526a);
        }
    }

    public d Q() {
        AccessibilityNodeInfo.RangeInfo rangeInfo = this.f6487a.getRangeInfo();
        if (rangeInfo != null) {
            return new d(rangeInfo);
        }
        return null;
    }

    public void Q1(View view) {
        this.f6487a.setTraversalAfter(view);
    }

    @c.o0
    public CharSequence R() {
        return this.f6487a.getExtras().getCharSequence(f6459d);
    }

    @Deprecated
    public void R0(Rect rect) {
        this.f6487a.setBoundsInParent(rect);
    }

    public void R1(View view, int i7) {
        this.f6487a.setTraversalAfter(view, i7);
    }

    public void S0(Rect rect) {
        this.f6487a.setBoundsInScreen(rect);
    }

    public void S1(View view) {
        this.f6487a.setTraversalBefore(view);
    }

    @c.o0
    public CharSequence T() {
        return androidx.core.os.a.h() ? this.f6487a.getStateDescription() : this.f6487a.getExtras().getCharSequence(f6474n);
    }

    public void T0(boolean z7) {
        this.f6487a.setCanOpenPopup(z7);
    }

    public void T1(View view, int i7) {
        this.f6487a.setTraversalBefore(view, i7);
    }

    public CharSequence U() {
        if (!e0()) {
            return this.f6487a.getText();
        }
        List<Integer> listI = i(f6470j);
        List<Integer> listI2 = i(f6471k);
        List<Integer> listI3 = i(f6472l);
        List<Integer> listI4 = i(f6469i);
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f6487a.getText(), 0, this.f6487a.getText().length()));
        for (int i7 = 0; i7 < listI.size(); i7++) {
            spannableString.setSpan(new androidx.core.view.accessibility.a(listI4.get(i7).intValue(), this, D().getInt(f6473m)), listI.get(i7).intValue(), listI2.get(i7).intValue(), listI3.get(i7).intValue());
        }
        return spannableString;
    }

    public void U0(boolean z7) {
        this.f6487a.setCheckable(z7);
    }

    public void U1(String str) {
        this.f6487a.setViewIdResourceName(str);
    }

    public int V() {
        return this.f6487a.getTextSelectionEnd();
    }

    public void V0(boolean z7) {
        this.f6487a.setChecked(z7);
    }

    public void V1(boolean z7) {
        this.f6487a.setVisibleToUser(z7);
    }

    public int W() {
        return this.f6487a.getTextSelectionStart();
    }

    public void W0(CharSequence charSequence) {
        this.f6487a.setClassName(charSequence);
    }

    public AccessibilityNodeInfo W1() {
        return this.f6487a;
    }

    @c.o0
    public CharSequence X() {
        return Build.VERSION.SDK_INT >= 28 ? this.f6487a.getTooltipText() : this.f6487a.getExtras().getCharSequence(f6463f);
    }

    public void X0(boolean z7) {
        this.f6487a.setClickable(z7);
    }

    @c.o0
    public e Y() {
        AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo;
        if (Build.VERSION.SDK_INT < 29 || (touchDelegateInfo = this.f6487a.getTouchDelegateInfo()) == null) {
            return null;
        }
        return new e(touchDelegateInfo);
    }

    public void Y0(Object obj) {
        this.f6487a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((b) obj).f6520a);
    }

    public l0 Z() {
        return Y1(this.f6487a.getTraversalAfter());
    }

    public void Z0(Object obj) {
        this.f6487a.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((c) obj).f6521a);
    }

    public void a(int i7) {
        this.f6487a.addAction(i7);
    }

    public l0 a0() {
        return Y1(this.f6487a.getTraversalBefore());
    }

    public void a1(CharSequence charSequence) {
        this.f6487a.setContentDescription(charSequence);
    }

    public void b(a aVar) {
        this.f6487a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f6513a);
    }

    public String b0() {
        return this.f6487a.getViewIdResourceName();
    }

    public void b1(boolean z7) {
        this.f6487a.setContentInvalid(z7);
    }

    public void c(View view) {
        this.f6487a.addChild(view);
    }

    public u0 c0() {
        return u0.r(this.f6487a.getWindow());
    }

    public void c1(boolean z7) {
        this.f6487a.setContextClickable(z7);
    }

    public void d(View view, int i7) {
        this.f6487a.addChild(view, i7);
    }

    public int d0() {
        return this.f6487a.getWindowId();
    }

    public void d1(boolean z7) {
        this.f6487a.setDismissable(z7);
    }

    public void e1(int i7) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f6487a.setDrawingOrder(i7);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof l0)) {
            return false;
        }
        l0 l0Var = (l0) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f6487a;
        if (accessibilityNodeInfo == null) {
            if (l0Var.f6487a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(l0Var.f6487a)) {
            return false;
        }
        return this.f6489c == l0Var.f6489c && this.f6488b == l0Var.f6488b;
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public void f(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 26) {
            h();
            N0(view);
            ClickableSpan[] clickableSpanArrX = x(charSequence);
            if (clickableSpanArrX == null || clickableSpanArrX.length <= 0) {
                return;
            }
            D().putInt(f6473m, androidx.core.R.id.accessibility_action_clickable_span);
            SparseArray<WeakReference<ClickableSpan>> sparseArrayM = M(view);
            for (int i7 = 0; i7 < clickableSpanArrX.length; i7++) {
                int iF0 = f0(clickableSpanArrX[i7], sparseArrayM);
                sparseArrayM.put(iF0, new WeakReference<>(clickableSpanArrX[i7]));
                e(clickableSpanArrX[i7], (Spanned) charSequence, iF0);
            }
        }
    }

    public void f1(boolean z7) {
        this.f6487a.setEditable(z7);
    }

    public boolean g() {
        return this.f6487a.canOpenPopup();
    }

    public boolean g0() {
        return this.f6487a.isAccessibilityFocused();
    }

    public void g1(boolean z7) {
        this.f6487a.setEnabled(z7);
    }

    public boolean h0() {
        return this.f6487a.isCheckable();
    }

    public void h1(CharSequence charSequence) {
        this.f6487a.setError(charSequence);
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f6487a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public boolean i0() {
        return this.f6487a.isChecked();
    }

    public void i1(boolean z7) {
        this.f6487a.setFocusable(z7);
    }

    public List<l0> j(String str) {
        ArrayList arrayList = new ArrayList();
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByText = this.f6487a.findAccessibilityNodeInfosByText(str);
        int size = listFindAccessibilityNodeInfosByText.size();
        for (int i7 = 0; i7 < size; i7++) {
            arrayList.add(X1(listFindAccessibilityNodeInfosByText.get(i7)));
        }
        return arrayList;
    }

    public boolean j0() {
        return this.f6487a.isClickable();
    }

    public void j1(boolean z7) {
        this.f6487a.setFocused(z7);
    }

    public List<l0> k(String str) {
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId = this.f6487a.findAccessibilityNodeInfosByViewId(str);
        ArrayList arrayList = new ArrayList();
        Iterator<AccessibilityNodeInfo> it = listFindAccessibilityNodeInfosByViewId.iterator();
        while (it.hasNext()) {
            arrayList.add(X1(it.next()));
        }
        return arrayList;
    }

    public boolean k0() {
        return this.f6487a.isContentInvalid();
    }

    public void k1(boolean z7) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f6487a.setHeading(z7);
        } else {
            Q0(2, z7);
        }
    }

    public l0 l(int i7) {
        return Y1(this.f6487a.findFocus(i7));
    }

    public boolean l0() {
        return this.f6487a.isContextClickable();
    }

    public void l1(@c.o0 CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f6487a.setHintText(charSequence);
        } else {
            this.f6487a.getExtras().putCharSequence(f6465g, charSequence);
        }
    }

    public l0 m(int i7) {
        return Y1(this.f6487a.focusSearch(i7));
    }

    public boolean m0() {
        return this.f6487a.isDismissable();
    }

    public void m1(boolean z7) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f6487a.setImportantForAccessibility(z7);
        }
    }

    public List<a> n() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.f6487a.getActionList();
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i7 = 0; i7 < size; i7++) {
            arrayList.add(new a(actionList.get(i7)));
        }
        return arrayList;
    }

    public boolean n0() {
        return this.f6487a.isEditable();
    }

    public void n1(int i7) {
        this.f6487a.setInputType(i7);
    }

    public boolean o0() {
        return this.f6487a.isEnabled();
    }

    public void o1(View view) {
        this.f6487a.setLabelFor(view);
    }

    public int p() {
        return this.f6487a.getActions();
    }

    public boolean p0() {
        return this.f6487a.isFocusable();
    }

    public void p1(View view, int i7) {
        this.f6487a.setLabelFor(view, i7);
    }

    @c.m0
    public List<String> q() {
        return Build.VERSION.SDK_INT >= 26 ? this.f6487a.getAvailableExtraData() : Collections.emptyList();
    }

    public boolean q0() {
        return this.f6487a.isFocused();
    }

    public void q1(View view) {
        this.f6487a.setLabeledBy(view);
    }

    public boolean r0() {
        if (Build.VERSION.SDK_INT >= 28) {
            return this.f6487a.isHeading();
        }
        if (r(2)) {
            return true;
        }
        c cVarZ = z();
        return cVarZ != null && cVarZ.e();
    }

    public void r1(View view, int i7) {
        this.f6487a.setLabeledBy(view, i7);
    }

    @Deprecated
    public void s(Rect rect) {
        this.f6487a.getBoundsInParent(rect);
    }

    public boolean s0() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.f6487a.isImportantForAccessibility();
        }
        return true;
    }

    public void s1(int i7) {
        this.f6487a.setLiveRegion(i7);
    }

    public void t(Rect rect) {
        this.f6487a.getBoundsInScreen(rect);
    }

    public boolean t0() {
        return this.f6487a.isLongClickable();
    }

    public void t1(boolean z7) {
        this.f6487a.setLongClickable(z7);
    }

    @c.m0
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        s(rect);
        sb.append("; boundsInParent: " + rect);
        t(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(N());
        sb.append("; className: ");
        sb.append(w());
        sb.append("; text: ");
        sb.append(U());
        sb.append("; contentDescription: ");
        sb.append(A());
        sb.append("; viewId: ");
        sb.append(b0());
        sb.append("; checkable: ");
        sb.append(h0());
        sb.append("; checked: ");
        sb.append(i0());
        sb.append("; focusable: ");
        sb.append(p0());
        sb.append("; focused: ");
        sb.append(q0());
        sb.append("; selected: ");
        sb.append(y0());
        sb.append("; clickable: ");
        sb.append(j0());
        sb.append("; longClickable: ");
        sb.append(t0());
        sb.append("; enabled: ");
        sb.append(o0());
        sb.append("; password: ");
        sb.append(v0());
        sb.append("; scrollable: " + x0());
        sb.append("; [");
        List<a> listN = n();
        for (int i7 = 0; i7 < listN.size(); i7++) {
            a aVar = listN.get(i7);
            String strO = o(aVar.b());
            if (strO.equals("ACTION_UNKNOWN") && aVar.c() != null) {
                strO = aVar.c().toString();
            }
            sb.append(strO);
            if (i7 != listN.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public l0 u(int i7) {
        return Y1(this.f6487a.getChild(i7));
    }

    public boolean u0() {
        return this.f6487a.isMultiLine();
    }

    public void u1(int i7) {
        this.f6487a.setMaxTextLength(i7);
    }

    public int v() {
        return this.f6487a.getChildCount();
    }

    public boolean v0() {
        return this.f6487a.isPassword();
    }

    public void v1(int i7) {
        this.f6487a.setMovementGranularities(i7);
    }

    public CharSequence w() {
        return this.f6487a.getClassName();
    }

    public boolean w0() {
        return Build.VERSION.SDK_INT >= 28 ? this.f6487a.isScreenReaderFocusable() : r(1);
    }

    public void w1(boolean z7) {
        this.f6487a.setMultiLine(z7);
    }

    public boolean x0() {
        return this.f6487a.isScrollable();
    }

    public void x1(CharSequence charSequence) {
        this.f6487a.setPackageName(charSequence);
    }

    public b y() {
        AccessibilityNodeInfo.CollectionInfo collectionInfo = this.f6487a.getCollectionInfo();
        if (collectionInfo != null) {
            return new b(collectionInfo);
        }
        return null;
    }

    public boolean y0() {
        return this.f6487a.isSelected();
    }

    public void y1(@c.o0 CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f6487a.setPaneTitle(charSequence);
        } else {
            this.f6487a.getExtras().putCharSequence(f6461e, charSequence);
        }
    }

    public c z() {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo = this.f6487a.getCollectionItemInfo();
        if (collectionItemInfo != null) {
            return new c(collectionItemInfo);
        }
        return null;
    }

    public boolean z0() {
        return Build.VERSION.SDK_INT >= 26 ? this.f6487a.isShowingHintText() : r(4);
    }

    public void z1(View view) {
        this.f6488b = -1;
        this.f6487a.setParent(view);
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AccessibilityNodeInfo.TouchDelegateInfo f6526a;

        public e(@c.m0 Map<Region, View> map) {
            if (Build.VERSION.SDK_INT < 29) {
                this.f6526a = null;
            } else {
                q0.a();
                this.f6526a = p0.a(map);
            }
        }

        @c.o0
        public Region a(@c.e0(from = 0) int i7) {
            if (Build.VERSION.SDK_INT >= 29) {
                return this.f6526a.getRegionAt(i7);
            }
            return null;
        }

        @c.e0(from = 0)
        public int b() {
            if (Build.VERSION.SDK_INT >= 29) {
                return this.f6526a.getRegionCount();
            }
            return 0;
        }

        @c.o0
        public l0 c(@c.m0 Region region) {
            AccessibilityNodeInfo targetForRegion;
            if (Build.VERSION.SDK_INT < 29 || (targetForRegion = this.f6526a.getTargetForRegion(region)) == null) {
                return null;
            }
            return l0.X1(targetForRegion);
        }

        e(@c.m0 AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo) {
            this.f6526a = touchDelegateInfo;
        }
    }

    private l0(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f6487a = accessibilityNodeInfo;
    }
}
