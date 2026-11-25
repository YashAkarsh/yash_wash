package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.core.view.n2;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class ListPopupWindow implements androidx.appcompat.view.menu.q {
    private static final String G = "ListPopupWindow";
    private static final boolean H = false;
    static final int I = 250;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static Method f1527J = null;
    private static Method K = null;
    private static Method L = null;
    public static final int M = 0;
    public static final int N = 1;
    public static final int O = -1;
    public static final int P = -2;
    public static final int Q = 0;
    public static final int R = 1;
    public static final int S = 2;
    private Runnable A;
    final Handler B;
    private final Rect C;
    private Rect D;
    private boolean E;
    PopupWindow F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f1528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ListAdapter f1529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    m0 f1530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1531d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1532e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1533f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f1534g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f1535h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1536i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f1537j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f1538k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f1539l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f1540m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f1541n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f1542o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private View f1543p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f1544q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private DataSetObserver f1545r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private View f1546s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Drawable f1547t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private AdapterView.OnItemClickListener f1548u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private AdapterView.OnItemSelectedListener f1549v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final j f1550w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final i f1551x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final h f1552y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final f f1553z;

    class a extends p0 {
        a(View view) {
            super(view);
        }

        @Override // androidx.appcompat.widget.p0
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public ListPopupWindow b() {
            return ListPopupWindow.this;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View viewV = ListPopupWindow.this.v();
            if (viewV == null || viewV.getWindowToken() == null) {
                return;
            }
            ListPopupWindow.this.b();
        }
    }

    class c implements AdapterView.OnItemSelectedListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i7, long j7) {
            m0 m0Var;
            if (i7 == -1 || (m0Var = ListPopupWindow.this.f1530c) == null) {
                return;
            }
            m0Var.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    @c.t0(24)
    static class d {
        private d() {
        }

        @c.t
        static int a(PopupWindow popupWindow, View view, int i7, boolean z7) {
            return popupWindow.getMaxAvailableHeight(view, i7, z7);
        }
    }

    @c.t0(29)
    static class e {
        private e() {
        }

        @c.t
        static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        @c.t
        static void b(PopupWindow popupWindow, boolean z7) {
            popupWindow.setIsClippedToScreen(z7);
        }
    }

    private class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ListPopupWindow.this.s();
        }
    }

    private class g extends DataSetObserver {
        g() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (ListPopupWindow.this.c()) {
                ListPopupWindow.this.b();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    private class h implements AbsListView.OnScrollListener {
        h() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i7, int i8, int i9) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i7) {
            if (i7 != 1 || ListPopupWindow.this.K() || ListPopupWindow.this.F.getContentView() == null) {
                return;
            }
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            listPopupWindow.B.removeCallbacks(listPopupWindow.f1550w);
            ListPopupWindow.this.f1550w.run();
        }
    }

    private class i implements View.OnTouchListener {
        i() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x7 = (int) motionEvent.getX();
            int y7 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = ListPopupWindow.this.F) != null && popupWindow.isShowing() && x7 >= 0 && x7 < ListPopupWindow.this.F.getWidth() && y7 >= 0 && y7 < ListPopupWindow.this.F.getHeight()) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.B.postDelayed(listPopupWindow.f1550w, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            ListPopupWindow listPopupWindow2 = ListPopupWindow.this;
            listPopupWindow2.B.removeCallbacks(listPopupWindow2.f1550w);
            return false;
        }
    }

    private class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m0 m0Var = ListPopupWindow.this.f1530c;
            if (m0Var == null || !n2.O0(m0Var) || ListPopupWindow.this.f1530c.getCount() <= ListPopupWindow.this.f1530c.getChildCount()) {
                return;
            }
            int childCount = ListPopupWindow.this.f1530c.getChildCount();
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            if (childCount <= listPopupWindow.f1542o) {
                listPopupWindow.F.setInputMethodMode(2);
                ListPopupWindow.this.b();
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                f1527J = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i(G, "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                L = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i(G, "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                K = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                Log.i(G, "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public ListPopupWindow(@c.m0 Context context) {
        this(context, null, R.attr.listPopupWindowStyle);
    }

    private int A(View view, int i7, boolean z7) {
        if (Build.VERSION.SDK_INT > 23) {
            return d.a(this.F, view, i7, z7);
        }
        Method method = K;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.F, view, Integer.valueOf(i7), Boolean.valueOf(z7))).intValue();
            } catch (Exception unused) {
                Log.i(G, "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.F.getMaxAvailableHeight(view, i7);
    }

    private static boolean I(int i7) {
        return i7 == 66 || i7 == 23;
    }

    private void R() {
        View view = this.f1543p;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1543p);
            }
        }
    }

    private void i0(boolean z7) {
        if (Build.VERSION.SDK_INT > 28) {
            e.b(this.F, z7);
            return;
        }
        Method method = f1527J;
        if (method != null) {
            try {
                method.invoke(this.F, Boolean.valueOf(z7));
            } catch (Exception unused) {
                Log.i(G, "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    private int r() {
        int measuredHeight;
        int i7;
        int iMakeMeasureSpec;
        View view;
        int i8;
        if (this.f1530c == null) {
            Context context = this.f1528a;
            this.A = new b();
            m0 m0VarU = u(context, !this.E);
            this.f1530c = m0VarU;
            Drawable drawable = this.f1547t;
            if (drawable != null) {
                m0VarU.setSelector(drawable);
            }
            this.f1530c.setAdapter(this.f1529b);
            this.f1530c.setOnItemClickListener(this.f1548u);
            this.f1530c.setFocusable(true);
            this.f1530c.setFocusableInTouchMode(true);
            this.f1530c.setOnItemSelectedListener(new c());
            this.f1530c.setOnScrollListener(this.f1552y);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f1549v;
            if (onItemSelectedListener != null) {
                this.f1530c.setOnItemSelectedListener(onItemSelectedListener);
            }
            m0 m0Var = this.f1530c;
            View view2 = this.f1543p;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i9 = this.f1544q;
                if (i9 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(m0Var, layoutParams);
                } else if (i9 != 1) {
                    Log.e(G, "Invalid hint position " + this.f1544q);
                } else {
                    linearLayout.addView(m0Var, layoutParams);
                    linearLayout.addView(view2);
                }
                int i10 = this.f1532e;
                if (i10 >= 0) {
                    i8 = Integer.MIN_VALUE;
                } else {
                    i10 = 0;
                    i8 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i10, i8), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                measuredHeight = 0;
                view = m0Var;
            }
            this.F.setContentView(view);
        } else {
            View view3 = this.f1543p;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.F.getBackground();
        if (background != null) {
            background.getPadding(this.C);
            Rect rect = this.C;
            int i11 = rect.top;
            i7 = rect.bottom + i11;
            if (!this.f1536i) {
                this.f1534g = -i11;
            }
        } else {
            this.C.setEmpty();
            i7 = 0;
        }
        int iA = A(v(), this.f1534g, this.F.getInputMethodMode() == 2);
        if (this.f1540m || this.f1531d == -1) {
            return iA + i7;
        }
        int i12 = this.f1532e;
        if (i12 == -2) {
            int i13 = this.f1528a.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.C;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i13 - (rect2.left + rect2.right), Integer.MIN_VALUE);
        } else if (i12 != -1) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
        } else {
            int i14 = this.f1528a.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.C;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i14 - (rect3.left + rect3.right), 1073741824);
        }
        int iE = this.f1530c.e(iMakeMeasureSpec, 0, -1, iA - measuredHeight, -1);
        if (iE > 0) {
            measuredHeight += i7 + this.f1530c.getPaddingTop() + this.f1530c.getPaddingBottom();
        }
        return iE + measuredHeight;
    }

    public int B() {
        return this.f1544q;
    }

    @c.o0
    public Object C() {
        if (c()) {
            return this.f1530c.getSelectedItem();
        }
        return null;
    }

    public long D() {
        if (c()) {
            return this.f1530c.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    public int E() {
        if (c()) {
            return this.f1530c.getSelectedItemPosition();
        }
        return -1;
    }

    @c.o0
    public View F() {
        if (c()) {
            return this.f1530c.getSelectedView();
        }
        return null;
    }

    public int G() {
        return this.F.getSoftInputMode();
    }

    public int H() {
        return this.f1532e;
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public boolean J() {
        return this.f1540m;
    }

    public boolean K() {
        return this.F.getInputMethodMode() == 2;
    }

    public boolean L() {
        return this.E;
    }

    public boolean M(int i7, @c.m0 KeyEvent keyEvent) {
        int iD;
        int count;
        if (c() && i7 != 62 && (this.f1530c.getSelectedItemPosition() >= 0 || !I(i7))) {
            int selectedItemPosition = this.f1530c.getSelectedItemPosition();
            boolean z7 = !this.F.isAboveAnchor();
            ListAdapter listAdapter = this.f1529b;
            if (listAdapter != null) {
                boolean zAreAllItemsEnabled = listAdapter.areAllItemsEnabled();
                iD = zAreAllItemsEnabled ? 0 : this.f1530c.d(0, true);
                count = zAreAllItemsEnabled ? listAdapter.getCount() - 1 : this.f1530c.d(listAdapter.getCount() - 1, false);
            } else {
                iD = Integer.MAX_VALUE;
                count = Integer.MIN_VALUE;
            }
            if ((z7 && i7 == 19 && selectedItemPosition <= iD) || (!z7 && i7 == 20 && selectedItemPosition >= count)) {
                s();
                this.F.setInputMethodMode(1);
                b();
                return true;
            }
            this.f1530c.setListSelectionHidden(false);
            if (this.f1530c.onKeyDown(i7, keyEvent)) {
                this.F.setInputMethodMode(2);
                this.f1530c.requestFocusFromTouch();
                b();
                if (i7 == 19 || i7 == 20 || i7 == 23 || i7 == 66) {
                    return true;
                }
            } else if (z7 && i7 == 20) {
                if (selectedItemPosition == count) {
                    return true;
                }
            } else if (!z7 && i7 == 19 && selectedItemPosition == iD) {
                return true;
            }
        }
        return false;
    }

    public boolean N(int i7, @c.m0 KeyEvent keyEvent) {
        if (i7 != 4 || !c()) {
            return false;
        }
        View view = this.f1546s;
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            KeyEvent.DispatcherState keyDispatcherState = view.getKeyDispatcherState();
            if (keyDispatcherState != null) {
                keyDispatcherState.startTracking(keyEvent, this);
            }
            return true;
        }
        if (keyEvent.getAction() != 1) {
            return false;
        }
        KeyEvent.DispatcherState keyDispatcherState2 = view.getKeyDispatcherState();
        if (keyDispatcherState2 != null) {
            keyDispatcherState2.handleUpEvent(keyEvent);
        }
        if (!keyEvent.isTracking() || keyEvent.isCanceled()) {
            return false;
        }
        dismiss();
        return true;
    }

    public boolean O(int i7, @c.m0 KeyEvent keyEvent) {
        if (!c() || this.f1530c.getSelectedItemPosition() < 0) {
            return false;
        }
        boolean zOnKeyUp = this.f1530c.onKeyUp(i7, keyEvent);
        if (zOnKeyUp && I(i7)) {
            dismiss();
        }
        return zOnKeyUp;
    }

    public boolean P(int i7) {
        if (!c()) {
            return false;
        }
        if (this.f1548u == null) {
            return true;
        }
        m0 m0Var = this.f1530c;
        this.f1548u.onItemClick(m0Var, m0Var.getChildAt(i7 - m0Var.getFirstVisiblePosition()), i7, m0Var.getAdapter().getItemId(i7));
        return true;
    }

    public void Q() {
        this.B.post(this.A);
    }

    public void S(@c.o0 View view) {
        this.f1546s = view;
    }

    public void T(@c.b1 int i7) {
        this.F.setAnimationStyle(i7);
    }

    public void U(int i7) {
        Drawable background = this.F.getBackground();
        if (background == null) {
            n0(i7);
            return;
        }
        background.getPadding(this.C);
        Rect rect = this.C;
        this.f1532e = rect.left + rect.right + i7;
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void V(boolean z7) {
        this.f1540m = z7;
    }

    public void W(int i7) {
        this.f1539l = i7;
    }

    public void X(@c.o0 Rect rect) {
        this.D = rect != null ? new Rect(rect) : null;
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void Y(boolean z7) {
        this.f1541n = z7;
    }

    public void Z(int i7) {
        if (i7 < 0 && -2 != i7 && -1 != i7) {
            throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
        }
        this.f1531d = i7;
    }

    public void a(@c.o0 Drawable drawable) {
        this.F.setBackgroundDrawable(drawable);
    }

    public void a0(int i7) {
        this.F.setInputMethodMode(i7);
    }

    @Override // androidx.appcompat.view.menu.q
    public void b() {
        int iR = r();
        boolean zK = K();
        androidx.core.widget.s.d(this.F, this.f1535h);
        if (this.F.isShowing()) {
            if (n2.O0(v())) {
                int width = this.f1532e;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = v().getWidth();
                }
                int i7 = this.f1531d;
                if (i7 == -1) {
                    if (!zK) {
                        iR = -1;
                    }
                    if (zK) {
                        this.F.setWidth(this.f1532e == -1 ? -1 : 0);
                        this.F.setHeight(0);
                    } else {
                        this.F.setWidth(this.f1532e == -1 ? -1 : 0);
                        this.F.setHeight(-1);
                    }
                } else if (i7 != -2) {
                    iR = i7;
                }
                this.F.setOutsideTouchable((this.f1541n || this.f1540m) ? false : true);
                this.F.update(v(), this.f1533f, this.f1534g, width < 0 ? -1 : width, iR < 0 ? -1 : iR);
                return;
            }
            return;
        }
        int width2 = this.f1532e;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = v().getWidth();
        }
        int i8 = this.f1531d;
        if (i8 == -1) {
            iR = -1;
        } else if (i8 != -2) {
            iR = i8;
        }
        this.F.setWidth(width2);
        this.F.setHeight(iR);
        i0(true);
        this.F.setOutsideTouchable((this.f1541n || this.f1540m) ? false : true);
        this.F.setTouchInterceptor(this.f1551x);
        if (this.f1538k) {
            androidx.core.widget.s.c(this.F, this.f1537j);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = L;
            if (method != null) {
                try {
                    method.invoke(this.F, this.D);
                } catch (Exception e8) {
                    Log.e(G, "Could not invoke setEpicenterBounds on PopupWindow", e8);
                }
            }
        } else {
            e.a(this.F, this.D);
        }
        androidx.core.widget.s.e(this.F, v(), this.f1533f, this.f1534g, this.f1539l);
        this.f1530c.setSelection(-1);
        if (!this.E || this.f1530c.isInTouchMode()) {
            s();
        }
        if (this.E) {
            return;
        }
        this.B.post(this.f1553z);
    }

    void b0(int i7) {
        this.f1542o = i7;
    }

    @Override // androidx.appcompat.view.menu.q
    public boolean c() {
        return this.F.isShowing();
    }

    public void c0(Drawable drawable) {
        this.f1547t = drawable;
    }

    public int d() {
        return this.f1533f;
    }

    public void d0(boolean z7) {
        this.E = z7;
        this.F.setFocusable(z7);
    }

    @Override // androidx.appcompat.view.menu.q
    public void dismiss() {
        this.F.dismiss();
        R();
        this.F.setContentView(null);
        this.f1530c = null;
        this.B.removeCallbacks(this.f1550w);
    }

    public void e0(@c.o0 PopupWindow.OnDismissListener onDismissListener) {
        this.F.setOnDismissListener(onDismissListener);
    }

    public void f(int i7) {
        this.f1533f = i7;
    }

    public void f0(@c.o0 AdapterView.OnItemClickListener onItemClickListener) {
        this.f1548u = onItemClickListener;
    }

    public void g0(@c.o0 AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.f1549v = onItemSelectedListener;
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void h0(boolean z7) {
        this.f1538k = true;
        this.f1537j = z7;
    }

    @c.o0
    public Drawable i() {
        return this.F.getBackground();
    }

    public void j0(int i7) {
        this.f1544q = i7;
    }

    public void k(int i7) {
        this.f1534g = i7;
        this.f1536i = true;
    }

    public void k0(@c.o0 View view) {
        boolean zC = c();
        if (zC) {
            R();
        }
        this.f1543p = view;
        if (zC) {
            b();
        }
    }

    @Override // androidx.appcompat.view.menu.q
    @c.o0
    public ListView l() {
        return this.f1530c;
    }

    public void l0(int i7) {
        m0 m0Var = this.f1530c;
        if (!c() || m0Var == null) {
            return;
        }
        m0Var.setListSelectionHidden(false);
        m0Var.setSelection(i7);
        if (m0Var.getChoiceMode() != 0) {
            m0Var.setItemChecked(i7, true);
        }
    }

    public void m0(int i7) {
        this.F.setSoftInputMode(i7);
    }

    public void n0(int i7) {
        this.f1532e = i7;
    }

    public int o() {
        if (this.f1536i) {
            return this.f1534g;
        }
        return 0;
    }

    public void o0(int i7) {
        this.f1535h = i7;
    }

    public void q(@c.o0 ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f1545r;
        if (dataSetObserver == null) {
            this.f1545r = new g();
        } else {
            ListAdapter listAdapter2 = this.f1529b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f1529b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f1545r);
        }
        m0 m0Var = this.f1530c;
        if (m0Var != null) {
            m0Var.setAdapter(this.f1529b);
        }
    }

    public void s() {
        m0 m0Var = this.f1530c;
        if (m0Var != null) {
            m0Var.setListSelectionHidden(true);
            m0Var.requestLayout();
        }
    }

    public View.OnTouchListener t(View view) {
        return new a(view);
    }

    @c.m0
    m0 u(Context context, boolean z7) {
        return new m0(context, z7);
    }

    @c.o0
    public View v() {
        return this.f1546s;
    }

    @c.b1
    public int w() {
        return this.F.getAnimationStyle();
    }

    @c.o0
    public Rect x() {
        if (this.D != null) {
            return new Rect(this.D);
        }
        return null;
    }

    public int y() {
        return this.f1531d;
    }

    public int z() {
        return this.F.getInputMethodMode();
    }

    public ListPopupWindow(@c.m0 Context context, @c.o0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(@c.m0 Context context, @c.o0 AttributeSet attributeSet, @c.f int i7) {
        this(context, attributeSet, i7, 0);
    }

    public ListPopupWindow(@c.m0 Context context, @c.o0 AttributeSet attributeSet, @c.f int i7, @c.b1 int i8) {
        this.f1531d = -2;
        this.f1532e = -2;
        this.f1535h = 1002;
        this.f1539l = 0;
        this.f1540m = false;
        this.f1541n = false;
        this.f1542o = Integer.MAX_VALUE;
        this.f1544q = 0;
        this.f1550w = new j();
        this.f1551x = new i();
        this.f1552y = new h();
        this.f1553z = new f();
        this.C = new Rect();
        this.f1528a = context;
        this.B = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPopupWindow, i7, i8);
        this.f1533f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.f1534g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f1536i = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        AppCompatPopupWindow appCompatPopupWindow = new AppCompatPopupWindow(context, attributeSet, i7, i8);
        this.F = appCompatPopupWindow;
        appCompatPopupWindow.setInputMethodMode(1);
    }
}
