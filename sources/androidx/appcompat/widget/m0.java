package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R;
import androidx.core.view.n4;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class m0 extends ListView {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f1896o = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f1897p = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Rect f1898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1901d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1902e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1903f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Field f1904g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private c f1905h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1906i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f1907j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f1908k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private n4 f1909l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private androidx.core.widget.p f1910m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    d f1911n;

    @c.t0(21)
    static class a {
        private a() {
        }

        @c.t
        static void a(View view, float f8, float f9) {
            view.drawableHotspotChanged(f8, f9);
        }
    }

    @c.t0(30)
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static Method f1912a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static Method f1913b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static Method f1914c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static boolean f1915d;

        static {
            try {
                Class cls = Integer.TYPE;
                Class cls2 = Float.TYPE;
                Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, Boolean.TYPE, cls2, cls2);
                f1912a = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
                f1913b = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
                f1914c = declaredMethod3;
                declaredMethod3.setAccessible(true);
                f1915d = true;
            } catch (NoSuchMethodException e8) {
                e8.printStackTrace();
            }
        }

        private b() {
        }

        static boolean a() {
            return f1915d;
        }

        @SuppressLint({"BanUncheckedReflection"})
        static void b(m0 m0Var, int i7, View view) {
            try {
                f1912a.invoke(m0Var, Integer.valueOf(i7), view, Boolean.FALSE, -1, -1);
                f1913b.invoke(m0Var, Integer.valueOf(i7));
                f1914c.invoke(m0Var, Integer.valueOf(i7));
            } catch (IllegalAccessException e8) {
                e8.printStackTrace();
            } catch (InvocationTargetException e9) {
                e9.printStackTrace();
            }
        }
    }

    private static class c extends androidx.appcompat.graphics.drawable.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f1916b;

        c(Drawable drawable) {
            super(drawable);
            this.f1916b = true;
        }

        void c(boolean z7) {
            this.f1916b = z7;
        }

        @Override // androidx.appcompat.graphics.drawable.c, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f1916b) {
                super.draw(canvas);
            }
        }

        @Override // androidx.appcompat.graphics.drawable.c, android.graphics.drawable.Drawable
        public void setHotspot(float f8, float f9) {
            if (this.f1916b) {
                super.setHotspot(f8, f9);
            }
        }

        @Override // androidx.appcompat.graphics.drawable.c, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i7, int i8, int i9, int i10) {
            if (this.f1916b) {
                super.setHotspotBounds(i7, i8, i9, i10);
            }
        }

        @Override // androidx.appcompat.graphics.drawable.c, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f1916b) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // androidx.appcompat.graphics.drawable.c, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z7, boolean z8) {
            if (this.f1916b) {
                return super.setVisible(z7, z8);
            }
            return false;
        }
    }

    private class d implements Runnable {
        d() {
        }

        public void a() {
            m0 m0Var = m0.this;
            m0Var.f1911n = null;
            m0Var.removeCallbacks(this);
        }

        public void b() {
            m0.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            m0 m0Var = m0.this;
            m0Var.f1911n = null;
            m0Var.drawableStateChanged();
        }
    }

    m0(@c.m0 Context context, boolean z7) {
        super(context, null, R.attr.dropDownListViewStyle);
        this.f1898a = new Rect();
        this.f1899b = 0;
        this.f1900c = 0;
        this.f1901d = 0;
        this.f1902e = 0;
        this.f1907j = z7;
        setCacheColorHint(0);
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f1904g = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e8) {
            e8.printStackTrace();
        }
    }

    private void a() {
        this.f1908k = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f1903f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        n4 n4Var = this.f1909l;
        if (n4Var != null) {
            n4Var.d();
            this.f1909l = null;
        }
    }

    private void b(View view, int i7) {
        performItemClick(view, i7, getItemIdAtPosition(i7));
    }

    private void c(Canvas canvas) {
        Drawable selector;
        if (this.f1898a.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f1898a);
        selector.draw(canvas);
    }

    private void g(int i7, View view) {
        Rect rect = this.f1898a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f1899b;
        rect.top -= this.f1900c;
        rect.right += this.f1901d;
        rect.bottom += this.f1902e;
        try {
            boolean z7 = this.f1904g.getBoolean(this);
            if (view.isEnabled() != z7) {
                this.f1904g.set(this, Boolean.valueOf(!z7));
                if (i7 != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e8) {
            e8.printStackTrace();
        }
    }

    private void h(int i7, View view) {
        Drawable selector = getSelector();
        boolean z7 = (selector == null || i7 == -1) ? false : true;
        if (z7) {
            selector.setVisible(false, false);
        }
        g(i7, view);
        if (z7) {
            Rect rect = this.f1898a;
            float fExactCenterX = rect.exactCenterX();
            float fExactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            androidx.core.graphics.drawable.d.k(selector, fExactCenterX, fExactCenterY);
        }
    }

    private void i(int i7, View view, float f8, float f9) {
        h(i7, view);
        Drawable selector = getSelector();
        if (selector == null || i7 == -1) {
            return;
        }
        androidx.core.graphics.drawable.d.k(selector, f8, f9);
    }

    private void j(View view, int i7, float f8, float f9) {
        View childAt;
        this.f1908k = true;
        a.a(this, f8, f9);
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i8 = this.f1903f;
        if (i8 != -1 && (childAt = getChildAt(i8 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f1903f = i7;
        a.a(view, f8 - view.getLeft(), f9 - view.getTop());
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        i(i7, view, f8, f9);
        k(false);
        refreshDrawableState();
    }

    private void k(boolean z7) {
        c cVar = this.f1905h;
        if (cVar != null) {
            cVar.c(z7);
        }
    }

    private boolean l() {
        return this.f1908k;
    }

    private void m() {
        Drawable selector = getSelector();
        if (selector != null && l() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    public int d(int i7, boolean z7) {
        int iMin;
        ListAdapter adapter = getAdapter();
        if (adapter != null && !isInTouchMode()) {
            int count = adapter.getCount();
            if (!getAdapter().areAllItemsEnabled()) {
                if (z7) {
                    iMin = Math.max(0, i7);
                    while (iMin < count && !adapter.isEnabled(iMin)) {
                        iMin++;
                    }
                } else {
                    iMin = Math.min(i7, count - 1);
                    while (iMin >= 0 && !adapter.isEnabled(iMin)) {
                        iMin--;
                    }
                }
                if (iMin < 0 || iMin >= count) {
                    return -1;
                }
                return iMin;
            }
            if (i7 >= 0 && i7 < count) {
                return i7;
            }
        }
        return -1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.f1911n != null) {
            return;
        }
        super.drawableStateChanged();
        k(true);
        m();
    }

    public int e(int i7, int i8, int i9, int i10, int i11) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int measuredHeight = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        View view = null;
        while (i12 < count) {
            int itemViewType = adapter.getItemViewType(i12);
            if (itemViewType != i13) {
                view = null;
                i13 = itemViewType;
            }
            view = adapter.getView(i12, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i15 = layoutParams.height;
            view.measure(i7, i15 > 0 ? View.MeasureSpec.makeMeasureSpec(i15, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i12 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i10) {
                return (i11 < 0 || i12 <= i11 || i14 <= 0 || measuredHeight == i10) ? i10 : i14;
            }
            if (i11 >= 0 && i12 >= i11) {
                i14 = measuredHeight;
            }
            i12++;
        }
        return measuredHeight;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004a  */
    /* JADX WARN: Code duplicated, block: B:25:0x004f  */
    /* JADX WARN: Code duplicated, block: B:27:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0065  */
    /* JADX WARN: Code duplicated, block: B:31:0x0069  */
    /* JADX WARN: Code duplicated, block: B:9:0x0011  */
    public boolean f(MotionEvent motionEvent, int i7) {
        boolean z7;
        boolean z8;
        androidx.core.widget.p pVar;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            z7 = false;
        } else {
            if (actionMasked != 2) {
                if (actionMasked != 3) {
                    z7 = true;
                    z8 = false;
                } else {
                    z8 = false;
                    z7 = false;
                }
                if (z7 || z8) {
                    a();
                }
                if (z7) {
                    if (this.f1910m == null) {
                        this.f1910m = new androidx.core.widget.p(this);
                    }
                    this.f1910m.o(true);
                    this.f1910m.onTouch(this, motionEvent);
                } else {
                    pVar = this.f1910m;
                    if (pVar != null) {
                        pVar.o(false);
                    }
                }
                return z7;
            }
            z7 = true;
        }
        int iFindPointerIndex = motionEvent.findPointerIndex(i7);
        if (iFindPointerIndex < 0) {
            z8 = false;
            z7 = false;
        } else {
            int x7 = (int) motionEvent.getX(iFindPointerIndex);
            int y7 = (int) motionEvent.getY(iFindPointerIndex);
            int iPointToPosition = pointToPosition(x7, y7);
            if (iPointToPosition == -1) {
                z8 = true;
            } else {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                j(childAt, iPointToPosition, x7, y7);
                if (actionMasked == 1) {
                    b(childAt, iPointToPosition);
                }
                z7 = true;
                z8 = false;
            }
        }
        if (z7) {
            a();
        } else {
            a();
        }
        if (z7) {
            if (this.f1910m == null) {
                this.f1910m = new androidx.core.widget.p(this);
            }
            this.f1910m.o(true);
            this.f1910m.onTouch(this, motionEvent);
        } else {
            pVar = this.f1910m;
            if (pVar != null) {
                pVar.o(false);
            }
        }
        return z7;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f1907j || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f1907j || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f1907j || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f1907j && this.f1906i) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f1911n = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(@c.m0 MotionEvent motionEvent) {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f1911n == null) {
            d dVar = new d();
            this.f1911n = dVar;
            dVar.b();
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (i7 < 30 || !b.a()) {
                        setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                    } else {
                        b.b(this, iPointToPosition, childAt);
                    }
                }
                m();
            }
        } else {
            setSelection(-1);
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f1903f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        d dVar = this.f1911n;
        if (dVar != null) {
            dVar.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    void setListSelectionHidden(boolean z7) {
        this.f1906i = z7;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        c cVar = drawable != null ? new c(drawable) : null;
        this.f1905h = cVar;
        super.setSelector(cVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f1899b = rect.left;
        this.f1900c = rect.top;
        this.f1901d = rect.right;
        this.f1902e = rect.bottom;
    }
}
