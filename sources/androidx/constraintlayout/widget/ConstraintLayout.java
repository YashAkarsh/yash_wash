package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.widgets.h;
import androidx.constraintlayout.core.widgets.k;
import androidx.constraintlayout.core.widgets.n;
import androidx.core.view.n2;
import c.m0;
import c.o0;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {
    private static final String A = "ConstraintLayout";
    private static final boolean B = true;
    private static final boolean C = false;
    private static final boolean D = false;
    private static final boolean E = false;
    private static final boolean F = false;
    public static final int G = 0;
    private static f H = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f4488z = "ConstraintLayout-2.1.4";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    SparseArray<View> f4489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<ConstraintHelper> f4490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected androidx.constraintlayout.core.widgets.f f4491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4492d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4493e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f4494f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f4495g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected boolean f4496h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f4497i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private d f4498j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected androidx.constraintlayout.widget.b f4499k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f4500l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private HashMap<String, Integer> f4501m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f4502n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f4503o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f4504p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f4505q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    int f4506r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    int f4507s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private SparseArray<androidx.constraintlayout.core.widgets.e> f4508t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private e f4509u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private androidx.constraintlayout.core.f f4510v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    b f4511w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f4512x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f4513y;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4603a;

        static {
            int[] iArr = new int[androidx.constraintlayout.core.widgets.e.b.values().length];
            f4603a = iArr;
            try {
                iArr[androidx.constraintlayout.core.widgets.e.b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4603a[androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4603a[androidx.constraintlayout.core.widgets.e.b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4603a[androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    class b implements androidx.constraintlayout.core.widgets.analyzer.b.InterfaceC0040b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ConstraintLayout f4604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f4605b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f4606c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f4607d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f4608e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f4609f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f4610g;

        public b(ConstraintLayout l7) {
            this.f4604a = l7;
        }

        private boolean d(int lastMeasureSpec, int spec, int widgetSize) {
            if (lastMeasureSpec == spec) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(lastMeasureSpec);
            View.MeasureSpec.getSize(lastMeasureSpec);
            int mode2 = View.MeasureSpec.getMode(spec);
            int size = View.MeasureSpec.getSize(spec);
            if (mode2 == 1073741824) {
                return (mode == Integer.MIN_VALUE || mode == 0) && widgetSize == size;
            }
            return false;
        }

        @Override // androidx.constraintlayout.core.widgets.analyzer.b.InterfaceC0040b
        public final void a() {
            int childCount = this.f4604a.getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = this.f4604a.getChildAt(i7);
                if (childAt instanceof Placeholder) {
                    ((Placeholder) childAt).b(this.f4604a);
                }
            }
            int size = this.f4604a.f4490b.size();
            if (size > 0) {
                for (int i8 = 0; i8 < size; i8++) {
                    ((ConstraintHelper) this.f4604a.f4490b.get(i8)).E(this.f4604a);
                }
            }
        }

        @Override // androidx.constraintlayout.core.widgets.analyzer.b.InterfaceC0040b
        @SuppressLint({"WrongCall"})
        public final void b(androidx.constraintlayout.core.widgets.e widget, androidx.constraintlayout.core.widgets.analyzer.b.a measure) {
            int iMakeMeasureSpec;
            int iMakeMeasureSpec2;
            int baseline;
            int iMax;
            int iMax2;
            int iMakeMeasureSpec3;
            int i7;
            if (widget == null) {
                return;
            }
            if (widget.l0() == 8 && !widget.C0()) {
                measure.f3431e = 0;
                measure.f3432f = 0;
                measure.f3433g = 0;
                return;
            }
            if (widget.U() == null) {
                return;
            }
            androidx.constraintlayout.core.widgets.e.b bVar = measure.f3427a;
            androidx.constraintlayout.core.widgets.e.b bVar2 = measure.f3428b;
            int i8 = measure.f3429c;
            int i9 = measure.f3430d;
            int i10 = this.f4605b + this.f4606c;
            int i11 = this.f4607d;
            View view = (View) widget.w();
            int[] iArr = a.f4603a;
            int i12 = iArr[bVar.ordinal()];
            if (i12 == 1) {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8, 1073741824);
            } else if (i12 == 2) {
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f4609f, i11, -2);
            } else if (i12 == 3) {
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f4609f, i11 + widget.I(), -1);
            } else if (i12 != 4) {
                iMakeMeasureSpec = 0;
            } else {
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f4609f, i11, -2);
                boolean z7 = widget.f3644w == 1;
                int i13 = measure.f3436j;
                if (i13 == androidx.constraintlayout.core.widgets.analyzer.b.a.f3425l || i13 == androidx.constraintlayout.core.widgets.analyzer.b.a.f3426m) {
                    if (measure.f3436j == androidx.constraintlayout.core.widgets.analyzer.b.a.f3426m || !z7 || (z7 && (view.getMeasuredHeight() == widget.D())) || (view instanceof Placeholder) || widget.G0()) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(widget.m0(), 1073741824);
                    }
                }
            }
            int i14 = iArr[bVar2.ordinal()];
            if (i14 == 1) {
                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i9, 1073741824);
            } else if (i14 == 2) {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f4610g, i10, -2);
            } else if (i14 == 3) {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f4610g, i10 + widget.k0(), -1);
            } else if (i14 != 4) {
                iMakeMeasureSpec2 = 0;
            } else {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f4610g, i10, -2);
                boolean z8 = widget.f3646x == 1;
                int i15 = measure.f3436j;
                if (i15 == androidx.constraintlayout.core.widgets.analyzer.b.a.f3425l || i15 == androidx.constraintlayout.core.widgets.analyzer.b.a.f3426m) {
                    if (measure.f3436j == androidx.constraintlayout.core.widgets.analyzer.b.a.f3426m || !z8 || (z8 && (view.getMeasuredWidth() == widget.m0())) || (view instanceof Placeholder) || widget.H0()) {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(widget.D(), 1073741824);
                    }
                }
            }
            androidx.constraintlayout.core.widgets.f fVar = (androidx.constraintlayout.core.widgets.f) widget.U();
            if (fVar != null && k.b(ConstraintLayout.this.f4497i, 256) && view.getMeasuredWidth() == widget.m0() && view.getMeasuredWidth() < fVar.m0() && view.getMeasuredHeight() == widget.D() && view.getMeasuredHeight() < fVar.D() && view.getBaseline() == widget.t() && !widget.F0()) {
                if (d(widget.J(), iMakeMeasureSpec, widget.m0()) && d(widget.K(), iMakeMeasureSpec2, widget.D())) {
                    measure.f3431e = widget.m0();
                    measure.f3432f = widget.D();
                    measure.f3433g = widget.t();
                    return;
                }
            }
            androidx.constraintlayout.core.widgets.e.b bVar3 = androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT;
            boolean z9 = bVar == bVar3;
            boolean z10 = bVar2 == bVar3;
            androidx.constraintlayout.core.widgets.e.b bVar4 = androidx.constraintlayout.core.widgets.e.b.MATCH_PARENT;
            boolean z11 = bVar2 == bVar4 || bVar2 == androidx.constraintlayout.core.widgets.e.b.FIXED;
            boolean z12 = bVar == bVar4 || bVar == androidx.constraintlayout.core.widgets.e.b.FIXED;
            boolean z13 = z9 && widget.f3611f0 > 0.0f;
            boolean z14 = z10 && widget.f3611f0 > 0.0f;
            if (view == null) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int i16 = measure.f3436j;
            if (i16 != androidx.constraintlayout.core.widgets.analyzer.b.a.f3425l && i16 != androidx.constraintlayout.core.widgets.analyzer.b.a.f3426m && z9 && widget.f3644w == 0 && z10 && widget.f3646x == 0) {
                i7 = -1;
                iMax2 = 0;
                baseline = 0;
                iMax = 0;
            } else {
                if ((view instanceof VirtualLayout) && (widget instanceof n)) {
                    ((VirtualLayout) view).J((n) widget, iMakeMeasureSpec, iMakeMeasureSpec2);
                } else {
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                }
                widget.J1(iMakeMeasureSpec, iMakeMeasureSpec2);
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                baseline = view.getBaseline();
                int i17 = widget.f3650z;
                iMax = i17 > 0 ? Math.max(i17, measuredWidth) : measuredWidth;
                int i18 = widget.A;
                if (i18 > 0) {
                    iMax = Math.min(i18, iMax);
                }
                int i19 = widget.C;
                iMax2 = i19 > 0 ? Math.max(i19, measuredHeight) : measuredHeight;
                int i20 = widget.D;
                if (i20 > 0) {
                    iMax2 = Math.min(i20, iMax2);
                }
                if (!k.b(ConstraintLayout.this.f4497i, 1)) {
                    if (z13 && z11) {
                        iMax = (int) ((iMax2 * widget.f3611f0) + 0.5f);
                    } else if (z14 && z12) {
                        iMax2 = (int) ((iMax / widget.f3611f0) + 0.5f);
                    }
                }
                if (measuredWidth != iMax || measuredHeight != iMax2) {
                    if (measuredWidth != iMax) {
                        iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(iMax, 1073741824);
                    }
                    if (measuredHeight != iMax2) {
                        iMakeMeasureSpec3 = iMakeMeasureSpec;
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMax2, 1073741824);
                    }
                    iMakeMeasureSpec3 = iMakeMeasureSpec;
                    view.measure(iMakeMeasureSpec3, iMakeMeasureSpec2);
                    widget.J1(iMakeMeasureSpec3, iMakeMeasureSpec2);
                    iMax = view.getMeasuredWidth();
                    iMax2 = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                }
                i7 = -1;
            }
            boolean z15 = baseline != i7;
            measure.f3435i = (iMax == measure.f3429c && iMax2 == measure.f3430d) ? false : true;
            if (layoutParams.f4531g0) {
                z15 = true;
            }
            if (z15 && baseline != -1 && widget.t() != baseline) {
                measure.f3435i = true;
            }
            measure.f3431e = iMax;
            measure.f3432f = iMax2;
            measure.f3434h = z15;
            measure.f3433g = baseline;
        }

        public void c(int widthSpec, int heightSpec, int top, int bottom, int width, int height) {
            this.f4605b = top;
            this.f4606c = bottom;
            this.f4607d = width;
            this.f4608e = height;
            this.f4609f = widthSpec;
            this.f4610g = heightSpec;
        }
    }

    public ConstraintLayout(@m0 Context context) {
        super(context);
        this.f4489a = new SparseArray<>();
        this.f4490b = new ArrayList<>(4);
        this.f4491c = new androidx.constraintlayout.core.widgets.f();
        this.f4492d = 0;
        this.f4493e = 0;
        this.f4494f = Integer.MAX_VALUE;
        this.f4495g = Integer.MAX_VALUE;
        this.f4496h = true;
        this.f4497i = 257;
        this.f4498j = null;
        this.f4499k = null;
        this.f4500l = -1;
        this.f4501m = new HashMap<>();
        this.f4502n = -1;
        this.f4503o = -1;
        this.f4504p = -1;
        this.f4505q = -1;
        this.f4506r = 0;
        this.f4507s = 0;
        this.f4508t = new SparseArray<>();
        this.f4511w = new b(this);
        this.f4512x = 0;
        this.f4513y = 0;
        v(null, 0, 0);
    }

    private void C() {
        boolean zIsInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            androidx.constraintlayout.core.widgets.e eVarU = u(getChildAt(i7));
            if (eVarU != null) {
                eVarU.R0();
            }
        }
        if (zIsInEditMode) {
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    setDesignInformation(0, resourceName, Integer.valueOf(childAt.getId()));
                    int iIndexOf = resourceName.indexOf(47);
                    if (iIndexOf != -1) {
                        resourceName = resourceName.substring(iIndexOf + 1);
                    }
                    o(childAt.getId()).j1(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.f4500l != -1) {
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt2 = getChildAt(i9);
                if (childAt2.getId() == this.f4500l && (childAt2 instanceof Constraints)) {
                    this.f4498j = ((Constraints) childAt2).getConstraintSet();
                }
            }
        }
        d dVar = this.f4498j;
        if (dVar != null) {
            dVar.t(this, true);
        }
        this.f4491c.p2();
        int size = this.f4490b.size();
        if (size > 0) {
            for (int i10 = 0; i10 < size; i10++) {
                this.f4490b.get(i10).H(this);
            }
        }
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt3 = getChildAt(i11);
            if (childAt3 instanceof Placeholder) {
                ((Placeholder) childAt3).c(this);
            }
        }
        this.f4508t.clear();
        this.f4508t.put(0, this.f4491c);
        this.f4508t.put(getId(), this.f4491c);
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt4 = getChildAt(i12);
            this.f4508t.put(childAt4.getId(), u(childAt4));
        }
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt5 = getChildAt(i13);
            androidx.constraintlayout.core.widgets.e eVarU2 = u(childAt5);
            if (eVarU2 != null) {
                LayoutParams layoutParams = (LayoutParams) childAt5.getLayoutParams();
                this.f4491c.b(eVarU2);
                j(zIsInEditMode, childAt5, eVarU2, layoutParams, this.f4508t);
            }
        }
    }

    private void E(androidx.constraintlayout.core.widgets.e widget, LayoutParams layoutParams, SparseArray<androidx.constraintlayout.core.widgets.e> idToWidget, int baselineTarget, androidx.constraintlayout.core.widgets.d.b type) {
        View view = this.f4489a.get(baselineTarget);
        androidx.constraintlayout.core.widgets.e eVar = idToWidget.get(baselineTarget);
        if (eVar == null || view == null || !(view.getLayoutParams() instanceof LayoutParams)) {
            return;
        }
        layoutParams.f4531g0 = true;
        androidx.constraintlayout.core.widgets.d.b bVar = androidx.constraintlayout.core.widgets.d.b.BASELINE;
        if (type == bVar) {
            LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
            layoutParams2.f4531g0 = true;
            layoutParams2.f4561v0.x1(true);
        }
        widget.r(bVar).b(eVar.r(type), layoutParams.D, layoutParams.C, true);
        widget.x1(true);
        widget.r(androidx.constraintlayout.core.widgets.d.b.TOP).x();
        widget.r(androidx.constraintlayout.core.widgets.d.b.BOTTOM).x();
    }

    private boolean F() {
        int childCount = getChildCount();
        boolean z7 = false;
        for (int i7 = 0; i7 < childCount; i7++) {
            if (getChildAt(i7).isLayoutRequested()) {
                z7 = true;
                break;
            }
        }
        if (z7) {
            C();
        }
        return z7;
    }

    private int getPaddingWidth() {
        int iMax = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int iMax2 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
        return iMax2 > 0 ? iMax2 : iMax;
    }

    public static f getSharedValues() {
        if (H == null) {
            H = new f();
        }
        return H;
    }

    private final androidx.constraintlayout.core.widgets.e o(int id) {
        if (id == 0) {
            return this.f4491c;
        }
        View viewFindViewById = this.f4489a.get(id);
        if (viewFindViewById == null && (viewFindViewById = findViewById(id)) != null && viewFindViewById != this && viewFindViewById.getParent() == this) {
            onViewAdded(viewFindViewById);
        }
        if (viewFindViewById == this) {
            return this.f4491c;
        }
        if (viewFindViewById == null) {
            return null;
        }
        return ((LayoutParams) viewFindViewById.getLayoutParams()).f4561v0;
    }

    private void v(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.f4491c.h1(this);
        this.f4491c.U2(this.f4511w);
        this.f4489a.put(getId(), this);
        this.f4498j = null;
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.ConstraintLayout_Layout, defStyleAttr, defStyleRes);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == R.styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.f4492d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f4492d);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.f4493e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f4493e);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.f4494f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f4494f);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.f4495g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f4495g);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.f4497i = typedArrayObtainStyledAttributes.getInt(index, this.f4497i);
                } else if (index == R.styleable.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            z(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f4499k = null;
                        }
                    }
                } else if (index == R.styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        d dVar = new d();
                        this.f4498j = dVar;
                        dVar.w0(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f4498j = null;
                    }
                    this.f4500l = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f4491c.V2(this.f4497i);
    }

    private void y() {
        this.f4496h = true;
        this.f4502n = -1;
        this.f4503o = -1;
        this.f4504p = -1;
        this.f4505q = -1;
        this.f4506r = 0;
        this.f4507s = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(int widthMeasureSpec, int heightMeasureSpec, int measuredWidth, int measuredHeight, boolean isWidthMeasuredTooSmall, boolean isHeightMeasuredTooSmall) {
        b bVar = this.f4511w;
        int i7 = bVar.f4608e;
        int iResolveSizeAndState = View.resolveSizeAndState(measuredWidth + bVar.f4607d, widthMeasureSpec, 0);
        int iResolveSizeAndState2 = View.resolveSizeAndState(measuredHeight + i7, heightMeasureSpec, 0);
        int i8 = iResolveSizeAndState & n2.f6742s;
        int i9 = iResolveSizeAndState2 & n2.f6742s;
        int iMin = Math.min(this.f4494f, i8);
        int iMin2 = Math.min(this.f4495g, i9);
        if (isWidthMeasuredTooSmall) {
            iMin |= 16777216;
        }
        if (isHeightMeasuredTooSmall) {
            iMin2 |= 16777216;
        }
        setMeasuredDimension(iMin, iMin2);
        this.f4502n = iMin;
        this.f4503o = iMin2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(androidx.constraintlayout.core.widgets.f layout, int optimizationLevel, int widthMeasureSpec, int heightMeasureSpec) {
        int iMax;
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        int iMax2 = Math.max(0, getPaddingTop());
        int iMax3 = Math.max(0, getPaddingBottom());
        int i7 = iMax2 + iMax3;
        int paddingWidth = getPaddingWidth();
        this.f4511w.c(widthMeasureSpec, heightMeasureSpec, iMax2, iMax3, paddingWidth, i7);
        int iMax4 = Math.max(0, getPaddingStart());
        int iMax5 = Math.max(0, getPaddingEnd());
        if (iMax4 > 0 || iMax5 > 0) {
            iMax = w() ? iMax5 : iMax4;
        } else {
            iMax = Math.max(0, getPaddingLeft());
        }
        int i8 = size - paddingWidth;
        int i9 = size2 - i7;
        D(layout, mode, i8, mode2, i9);
        layout.Q2(optimizationLevel, mode, i8, mode2, i9, this.f4502n, this.f4503o, iMax, iMax2);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003e A[PHI: r2
      0x003e: PHI (r2v4 androidx.constraintlayout.core.widgets.e$b) = (r2v3 androidx.constraintlayout.core.widgets.e$b), (r2v0 androidx.constraintlayout.core.widgets.e$b) binds: [B:21:0x004a, B:17:0x003c] A[DONT_GENERATE, DONT_INLINE]] */
    protected void D(androidx.constraintlayout.core.widgets.f layout, int widthMode, int widthSize, int heightMode, int heightSize) {
        androidx.constraintlayout.core.widgets.e.b bVar;
        b bVar2 = this.f4511w;
        int i7 = bVar2.f4608e;
        int i8 = bVar2.f4607d;
        androidx.constraintlayout.core.widgets.e.b bVar3 = androidx.constraintlayout.core.widgets.e.b.FIXED;
        int childCount = getChildCount();
        if (widthMode == Integer.MIN_VALUE) {
            bVar = androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT;
            if (childCount == 0) {
                widthSize = Math.max(0, this.f4492d);
            }
        } else if (widthMode == 0) {
            bVar = androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT;
            widthSize = childCount == 0 ? Math.max(0, this.f4492d) : 0;
        } else if (widthMode != 1073741824) {
            bVar = bVar3;
        } else {
            widthSize = Math.min(this.f4494f - i8, widthSize);
            bVar = bVar3;
        }
        if (heightMode == Integer.MIN_VALUE) {
            bVar3 = androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT;
            if (childCount == 0) {
                heightSize = Math.max(0, this.f4493e);
            }
        } else if (heightMode == 0) {
            bVar3 = androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT;
            if (childCount == 0) {
                heightSize = Math.max(0, this.f4493e);
            } else {
                heightSize = 0;
            }
        } else if (heightMode != 1073741824) {
            heightSize = 0;
        } else {
            heightSize = Math.min(this.f4495g - i7, heightSize);
        }
        if (widthSize != layout.m0() || heightSize != layout.D()) {
            layout.M2();
        }
        layout.f2(0);
        layout.g2(0);
        layout.M1(this.f4494f - i8);
        layout.L1(this.f4495g - i7);
        layout.P1(0);
        layout.O1(0);
        layout.D1(bVar);
        layout.c2(widthSize);
        layout.Y1(bVar3);
        layout.y1(heightSize);
        layout.P1(this.f4492d - i8);
        layout.O1(this.f4493e - i7);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p7) {
        return p7 instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<ConstraintHelper> arrayList = this.f4490b;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i7 = 0; i7 < size; i7++) {
                this.f4490b.get(i7).F(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(",");
                    if (strArrSplit.length == 4) {
                        int i9 = Integer.parseInt(strArrSplit[0]);
                        int i10 = Integer.parseInt(strArrSplit[1]);
                        int i11 = Integer.parseInt(strArrSplit[2]);
                        int i12 = (int) ((i9 / 1080.0f) * width);
                        int i13 = (int) ((i10 / 1920.0f) * height);
                        int i14 = (int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(k.a.f34390c);
                        float f8 = i12;
                        float f9 = i13;
                        float f10 = i12 + ((int) ((i11 / 1080.0f) * width));
                        canvas.drawLine(f8, f9, f10, f9, paint);
                        float f11 = i13 + i14;
                        canvas.drawLine(f10, f9, f10, f11, paint);
                        canvas.drawLine(f10, f11, f8, f11, paint);
                        canvas.drawLine(f8, f11, f8, f9, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f8, f9, f10, f11, paint);
                        canvas.drawLine(f8, f11, f10, f9, paint);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void forceLayout() {
        y();
        super.forceLayout();
    }

    public int getMaxHeight() {
        return this.f4495g;
    }

    public int getMaxWidth() {
        return this.f4494f;
    }

    public int getMinHeight() {
        return this.f4493e;
    }

    public int getMinWidth() {
        return this.f4492d;
    }

    public int getOptimizationLevel() {
        return this.f4491c.H2();
    }

    public String getSceneString() {
        int id;
        StringBuilder sb = new StringBuilder();
        if (this.f4491c.f3628o == null) {
            int id2 = getId();
            if (id2 != -1) {
                this.f4491c.f3628o = getContext().getResources().getResourceEntryName(id2);
            } else {
                this.f4491c.f3628o = "parent";
            }
        }
        if (this.f4491c.y() == null) {
            androidx.constraintlayout.core.widgets.f fVar = this.f4491c;
            fVar.j1(fVar.f3628o);
            Log.v(A, " setDebugName " + this.f4491c.y());
        }
        for (androidx.constraintlayout.core.widgets.e eVar : this.f4491c.l2()) {
            View view = (View) eVar.w();
            if (view != null) {
                if (eVar.f3628o == null && (id = view.getId()) != -1) {
                    eVar.f3628o = getContext().getResources().getResourceEntryName(id);
                }
                if (eVar.y() == null) {
                    eVar.j1(eVar.f3628o);
                    Log.v(A, " setDebugName " + eVar.y());
                }
            }
        }
        this.f4491c.b0(sb);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(boolean isInEditMode, View child, androidx.constraintlayout.core.widgets.e widget, LayoutParams layoutParams, SparseArray<androidx.constraintlayout.core.widgets.e> idToWidget) {
        androidx.constraintlayout.core.widgets.e eVar;
        androidx.constraintlayout.core.widgets.e eVar2;
        androidx.constraintlayout.core.widgets.e eVar3;
        androidx.constraintlayout.core.widgets.e eVar4;
        int i7;
        layoutParams.e();
        layoutParams.f4563w0 = false;
        widget.b2(child.getVisibility());
        if (layoutParams.f4537j0) {
            widget.H1(true);
            widget.b2(8);
        }
        widget.h1(child);
        if (child instanceof ConstraintHelper) {
            ((ConstraintHelper) child).B(widget, this.f4491c.O2());
        }
        if (layoutParams.f4533h0) {
            h hVar = (h) widget;
            int i8 = layoutParams.f4555s0;
            int i9 = layoutParams.f4557t0;
            float f8 = layoutParams.f4559u0;
            if (f8 != -1.0f) {
                hVar.y2(f8);
                return;
            } else if (i8 != -1) {
                hVar.w2(i8);
                return;
            } else {
                if (i9 != -1) {
                    hVar.x2(i9);
                    return;
                }
                return;
            }
        }
        int i10 = layoutParams.f4541l0;
        int i11 = layoutParams.f4543m0;
        int i12 = layoutParams.f4545n0;
        int i13 = layoutParams.f4547o0;
        int i14 = layoutParams.f4549p0;
        int i15 = layoutParams.f4551q0;
        float f9 = layoutParams.f4553r0;
        int i16 = layoutParams.f4548p;
        if (i16 != -1) {
            androidx.constraintlayout.core.widgets.e eVar5 = idToWidget.get(i16);
            if (eVar5 != null) {
                widget.m(eVar5, layoutParams.f4552r, layoutParams.f4550q);
            }
        } else {
            if (i10 != -1) {
                androidx.constraintlayout.core.widgets.e eVar6 = idToWidget.get(i10);
                if (eVar6 != null) {
                    androidx.constraintlayout.core.widgets.d.b bVar = androidx.constraintlayout.core.widgets.d.b.LEFT;
                    widget.v0(bVar, eVar6, bVar, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i14);
                }
            } else if (i11 != -1 && (eVar = idToWidget.get(i11)) != null) {
                widget.v0(androidx.constraintlayout.core.widgets.d.b.LEFT, eVar, androidx.constraintlayout.core.widgets.d.b.RIGHT, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i14);
            }
            if (i12 != -1) {
                androidx.constraintlayout.core.widgets.e eVar7 = idToWidget.get(i12);
                if (eVar7 != null) {
                    widget.v0(androidx.constraintlayout.core.widgets.d.b.RIGHT, eVar7, androidx.constraintlayout.core.widgets.d.b.LEFT, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i15);
                }
            } else if (i13 != -1 && (eVar2 = idToWidget.get(i13)) != null) {
                androidx.constraintlayout.core.widgets.d.b bVar2 = androidx.constraintlayout.core.widgets.d.b.RIGHT;
                widget.v0(bVar2, eVar2, bVar2, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i15);
            }
            int i17 = layoutParams.f4534i;
            if (i17 != -1) {
                androidx.constraintlayout.core.widgets.e eVar8 = idToWidget.get(i17);
                if (eVar8 != null) {
                    androidx.constraintlayout.core.widgets.d.b bVar3 = androidx.constraintlayout.core.widgets.d.b.TOP;
                    widget.v0(bVar3, eVar8, bVar3, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.f4564x);
                }
            } else {
                int i18 = layoutParams.f4536j;
                if (i18 != -1 && (eVar3 = idToWidget.get(i18)) != null) {
                    widget.v0(androidx.constraintlayout.core.widgets.d.b.TOP, eVar3, androidx.constraintlayout.core.widgets.d.b.BOTTOM, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.f4564x);
                }
            }
            int i19 = layoutParams.f4538k;
            if (i19 != -1) {
                androidx.constraintlayout.core.widgets.e eVar9 = idToWidget.get(i19);
                if (eVar9 != null) {
                    widget.v0(androidx.constraintlayout.core.widgets.d.b.BOTTOM, eVar9, androidx.constraintlayout.core.widgets.d.b.TOP, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.f4566z);
                }
            } else {
                int i20 = layoutParams.f4540l;
                if (i20 != -1 && (eVar4 = idToWidget.get(i20)) != null) {
                    androidx.constraintlayout.core.widgets.d.b bVar4 = androidx.constraintlayout.core.widgets.d.b.BOTTOM;
                    widget.v0(bVar4, eVar4, bVar4, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.f4566z);
                }
            }
            int i21 = layoutParams.f4542m;
            if (i21 != -1) {
                E(widget, layoutParams, idToWidget, i21, androidx.constraintlayout.core.widgets.d.b.BASELINE);
            } else {
                int i22 = layoutParams.f4544n;
                if (i22 != -1) {
                    E(widget, layoutParams, idToWidget, i22, androidx.constraintlayout.core.widgets.d.b.TOP);
                } else {
                    int i23 = layoutParams.f4546o;
                    if (i23 != -1) {
                        E(widget, layoutParams, idToWidget, i23, androidx.constraintlayout.core.widgets.d.b.BOTTOM);
                    }
                }
            }
            if (f9 >= 0.0f) {
                widget.A1(f9);
            }
            float f10 = layoutParams.H;
            if (f10 >= 0.0f) {
                widget.V1(f10);
            }
        }
        if (isInEditMode && ((i7 = layoutParams.X) != -1 || layoutParams.Y != -1)) {
            widget.R1(i7, layoutParams.Y);
        }
        if (layoutParams.f4527e0) {
            widget.D1(androidx.constraintlayout.core.widgets.e.b.FIXED);
            widget.c2(((ViewGroup.MarginLayoutParams) layoutParams).width);
            if (((ViewGroup.MarginLayoutParams) layoutParams).width == -2) {
                widget.D1(androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT);
            }
        } else if (((ViewGroup.MarginLayoutParams) layoutParams).width == -1) {
            if (layoutParams.f4519a0) {
                widget.D1(androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT);
            } else {
                widget.D1(androidx.constraintlayout.core.widgets.e.b.MATCH_PARENT);
            }
            widget.r(androidx.constraintlayout.core.widgets.d.b.LEFT).f3559g = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            widget.r(androidx.constraintlayout.core.widgets.d.b.RIGHT).f3559g = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        } else {
            widget.D1(androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT);
            widget.c2(0);
        }
        if (layoutParams.f4529f0) {
            widget.Y1(androidx.constraintlayout.core.widgets.e.b.FIXED);
            widget.y1(((ViewGroup.MarginLayoutParams) layoutParams).height);
            if (((ViewGroup.MarginLayoutParams) layoutParams).height == -2) {
                widget.Y1(androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT);
            }
        } else if (((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
            if (layoutParams.f4521b0) {
                widget.Y1(androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT);
            } else {
                widget.Y1(androidx.constraintlayout.core.widgets.e.b.MATCH_PARENT);
            }
            widget.r(androidx.constraintlayout.core.widgets.d.b.TOP).f3559g = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            widget.r(androidx.constraintlayout.core.widgets.d.b.BOTTOM).f3559g = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        } else {
            widget.Y1(androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT);
            widget.y1(0);
        }
        widget.n1(layoutParams.I);
        widget.F1(layoutParams.L);
        widget.a2(layoutParams.M);
        widget.B1(layoutParams.N);
        widget.W1(layoutParams.O);
        widget.e2(layoutParams.f4525d0);
        widget.E1(layoutParams.P, layoutParams.R, layoutParams.T, layoutParams.V);
        widget.Z1(layoutParams.Q, layoutParams.S, layoutParams.U, layoutParams.W);
    }

    public void k(androidx.constraintlayout.core.f metrics) {
        this.f4510v = metrics;
        this.f4491c.E2(metrics);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    public Object n(int type, Object value) {
        if (type != 0 || !(value instanceof String)) {
            return null;
        }
        String str = (String) value;
        HashMap<String, Integer> map = this.f4501m;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.f4501m.get(str);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        View content;
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            androidx.constraintlayout.core.widgets.e eVar = layoutParams.f4561v0;
            if ((childAt.getVisibility() != 8 || layoutParams.f4533h0 || layoutParams.f4535i0 || layoutParams.f4539k0 || zIsInEditMode) && !layoutParams.f4537j0) {
                int iO0 = eVar.o0();
                int iP0 = eVar.p0();
                int iM0 = eVar.m0() + iO0;
                int iD = eVar.D() + iP0;
                childAt.layout(iO0, iP0, iM0, iD);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(iO0, iP0, iM0, iD);
                }
            }
        }
        int size = this.f4490b.size();
        if (size > 0) {
            for (int i8 = 0; i8 < size; i8++) {
                this.f4490b.get(i8).D(this);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.f4512x == widthMeasureSpec) {
            int i7 = this.f4513y;
        }
        if (!this.f4496h) {
            int childCount = getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                if (getChildAt(i8).isLayoutRequested()) {
                    this.f4496h = true;
                    break;
                }
            }
        }
        boolean z7 = this.f4496h;
        this.f4512x = widthMeasureSpec;
        this.f4513y = heightMeasureSpec;
        this.f4491c.Y2(w());
        if (this.f4496h) {
            this.f4496h = false;
            if (F()) {
                this.f4491c.a3();
            }
        }
        B(this.f4491c, this.f4497i, widthMeasureSpec, heightMeasureSpec);
        A(widthMeasureSpec, heightMeasureSpec, this.f4491c.m0(), this.f4491c.D(), this.f4491c.P2(), this.f4491c.N2());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        androidx.constraintlayout.core.widgets.e eVarU = u(view);
        if ((view instanceof Guideline) && !(eVarU instanceof h)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            h hVar = new h();
            layoutParams.f4561v0 = hVar;
            layoutParams.f4533h0 = true;
            hVar.B2(layoutParams.Z);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.I();
            ((LayoutParams) view.getLayoutParams()).f4535i0 = true;
            if (!this.f4490b.contains(constraintHelper)) {
                this.f4490b.add(constraintHelper);
            }
        }
        this.f4489a.put(view.getId(), view);
        this.f4496h = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f4489a.remove(view.getId());
        this.f4491c.o2(u(view));
        this.f4490b.remove(view);
        this.f4496h = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        y();
        super.requestLayout();
    }

    public void setConstraintSet(d set) {
        this.f4498j = set;
    }

    public void setDesignInformation(int type, Object value1, Object value2) {
        if (type == 0 && (value1 instanceof String) && (value2 instanceof Integer)) {
            if (this.f4501m == null) {
                this.f4501m = new HashMap<>();
            }
            String strSubstring = (String) value1;
            int iIndexOf = strSubstring.indexOf("/");
            if (iIndexOf != -1) {
                strSubstring = strSubstring.substring(iIndexOf + 1);
            }
            this.f4501m.put(strSubstring, Integer.valueOf(((Integer) value2).intValue()));
        }
    }

    @Override // android.view.View
    public void setId(int id) {
        this.f4489a.remove(getId());
        super.setId(id);
        this.f4489a.put(getId(), this);
    }

    public void setMaxHeight(int value) {
        if (value == this.f4495g) {
            return;
        }
        this.f4495g = value;
        requestLayout();
    }

    public void setMaxWidth(int value) {
        if (value == this.f4494f) {
            return;
        }
        this.f4494f = value;
        requestLayout();
    }

    public void setMinHeight(int value) {
        if (value == this.f4493e) {
            return;
        }
        this.f4493e = value;
        requestLayout();
    }

    public void setMinWidth(int value) {
        if (value == this.f4492d) {
            return;
        }
        this.f4492d = value;
        requestLayout();
    }

    public void setOnConstraintsChanged(e constraintsChangedListener) {
        this.f4509u = constraintsChangedListener;
        androidx.constraintlayout.widget.b bVar = this.f4499k;
        if (bVar != null) {
            bVar.d(constraintsChangedListener);
        }
    }

    public void setOptimizationLevel(int level) {
        this.f4497i = level;
        this.f4491c.V2(level);
    }

    public void setState(int id, int screenWidth, int screenHeight) {
        androidx.constraintlayout.widget.b bVar = this.f4499k;
        if (bVar != null) {
            bVar.e(id, screenWidth, screenHeight);
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public View t(int id) {
        return this.f4489a.get(id);
    }

    public final androidx.constraintlayout.core.widgets.e u(View view) {
        if (view == this) {
            return this.f4491c;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof LayoutParams) {
            return ((LayoutParams) view.getLayoutParams()).f4561v0;
        }
        view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof LayoutParams) {
            return ((LayoutParams) view.getLayoutParams()).f4561v0;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean w() {
        return ((getContext().getApplicationInfo().flags & 4194304) != 0) && 1 == getLayoutDirection();
    }

    public void x(int layoutDescription) {
        if (layoutDescription == 0) {
            this.f4499k = null;
            return;
        }
        try {
            this.f4499k = new androidx.constraintlayout.widget.b(getContext(), this, layoutDescription);
        } catch (Resources.NotFoundException unused) {
            this.f4499k = null;
        }
    }

    protected void z(int id) {
        this.f4499k = new androidx.constraintlayout.widget.b(getContext(), this, id);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p7) {
        return new LayoutParams(p7);
    }

    public ConstraintLayout(@m0 Context context, @o0 AttributeSet attrs) {
        super(context, attrs);
        this.f4489a = new SparseArray<>();
        this.f4490b = new ArrayList<>(4);
        this.f4491c = new androidx.constraintlayout.core.widgets.f();
        this.f4492d = 0;
        this.f4493e = 0;
        this.f4494f = Integer.MAX_VALUE;
        this.f4495g = Integer.MAX_VALUE;
        this.f4496h = true;
        this.f4497i = 257;
        this.f4498j = null;
        this.f4499k = null;
        this.f4500l = -1;
        this.f4501m = new HashMap<>();
        this.f4502n = -1;
        this.f4503o = -1;
        this.f4504p = -1;
        this.f4505q = -1;
        this.f4506r = 0;
        this.f4507s = 0;
        this.f4508t = new SparseArray<>();
        this.f4511w = new b(this);
        this.f4512x = 0;
        this.f4513y = 0;
        v(attrs, 0, 0);
    }

    public ConstraintLayout(@m0 Context context, @o0 AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f4489a = new SparseArray<>();
        this.f4490b = new ArrayList<>(4);
        this.f4491c = new androidx.constraintlayout.core.widgets.f();
        this.f4492d = 0;
        this.f4493e = 0;
        this.f4494f = Integer.MAX_VALUE;
        this.f4495g = Integer.MAX_VALUE;
        this.f4496h = true;
        this.f4497i = 257;
        this.f4498j = null;
        this.f4499k = null;
        this.f4500l = -1;
        this.f4501m = new HashMap<>();
        this.f4502n = -1;
        this.f4503o = -1;
        this.f4504p = -1;
        this.f4505q = -1;
        this.f4506r = 0;
        this.f4507s = 0;
        this.f4508t = new SparseArray<>();
        this.f4511w = new b(this);
        this.f4512x = 0;
        this.f4513y = 0;
        v(attrs, defStyleAttr, 0);
    }

    @TargetApi(21)
    public ConstraintLayout(@m0 Context context, @o0 AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.f4489a = new SparseArray<>();
        this.f4490b = new ArrayList<>(4);
        this.f4491c = new androidx.constraintlayout.core.widgets.f();
        this.f4492d = 0;
        this.f4493e = 0;
        this.f4494f = Integer.MAX_VALUE;
        this.f4495g = Integer.MAX_VALUE;
        this.f4496h = true;
        this.f4497i = 257;
        this.f4498j = null;
        this.f4499k = null;
        this.f4500l = -1;
        this.f4501m = new HashMap<>();
        this.f4502n = -1;
        this.f4503o = -1;
        this.f4504p = -1;
        this.f4505q = -1;
        this.f4506r = 0;
        this.f4507s = 0;
        this.f4508t = new SparseArray<>();
        this.f4511w = new b(this);
        this.f4512x = 0;
        this.f4513y = 0;
        v(attrs, defStyleAttr, defStyleRes);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static final int A0 = Integer.MIN_VALUE;
        public static final int B0 = 0;
        public static final int C0 = 1;
        public static final int D0 = 1;
        public static final int E0 = 2;
        public static final int F0 = 3;
        public static final int G0 = 4;
        public static final int H0 = 5;
        public static final int I0 = 6;
        public static final int J0 = 7;
        public static final int K0 = 8;
        public static final int L0 = 1;
        public static final int M0 = 0;
        public static final int N0 = 2;
        public static final int O0 = 0;
        public static final int P0 = 1;
        public static final int Q0 = 2;
        public static final int R0 = 0;
        public static final int S0 = 1;
        public static final int T0 = 2;
        public static final int U0 = 3;

        /* JADX INFO: renamed from: x0, reason: collision with root package name */
        public static final int f4514x0 = 0;

        /* JADX INFO: renamed from: y0, reason: collision with root package name */
        public static final int f4515y0 = 0;

        /* JADX INFO: renamed from: z0, reason: collision with root package name */
        public static final int f4516z0 = -1;
        public int A;
        public int B;
        public int C;
        public int D;
        boolean E;
        boolean F;
        public float G;
        public float H;
        public String I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        float f4517J;
        int K;
        public float L;
        public float M;
        public int N;
        public int O;
        public int P;
        public int Q;
        public int R;
        public int S;
        public int T;
        public int U;
        public float V;
        public float W;
        public int X;
        public int Y;
        public int Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4518a;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public boolean f4519a0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4520b;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public boolean f4521b0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f4522c;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public String f4523c0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f4524d;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public int f4525d0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f4526e;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        boolean f4527e0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f4528f;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        boolean f4529f0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f4530g;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        boolean f4531g0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f4532h;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        boolean f4533h0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f4534i;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        boolean f4535i0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f4536j;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        boolean f4537j0;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f4538k;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        boolean f4539k0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f4540l;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        int f4541l0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f4542m;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        int f4543m0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f4544n;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        int f4545n0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f4546o;

        /* JADX INFO: renamed from: o0, reason: collision with root package name */
        int f4547o0;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f4548p;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        int f4549p0;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f4550q;

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        int f4551q0;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public float f4552r;

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        float f4553r0;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f4554s;

        /* JADX INFO: renamed from: s0, reason: collision with root package name */
        int f4555s0;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f4556t;

        /* JADX INFO: renamed from: t0, reason: collision with root package name */
        int f4557t0;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f4558u;

        /* JADX INFO: renamed from: u0, reason: collision with root package name */
        float f4559u0;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f4560v;

        /* JADX INFO: renamed from: v0, reason: collision with root package name */
        androidx.constraintlayout.core.widgets.e f4561v0;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f4562w;

        /* JADX INFO: renamed from: w0, reason: collision with root package name */
        public boolean f4563w0;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f4564x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f4565y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f4566z;

        private static class a {
            public static final int A = 26;
            public static final int B = 27;
            public static final int C = 28;
            public static final int D = 29;
            public static final int E = 30;
            public static final int F = 31;
            public static final int G = 32;
            public static final int H = 33;
            public static final int I = 34;

            /* JADX INFO: renamed from: J, reason: collision with root package name */
            public static final int f4567J = 35;
            public static final int K = 36;
            public static final int L = 37;
            public static final int M = 38;
            public static final int N = 39;
            public static final int O = 40;
            public static final int P = 41;
            public static final int Q = 42;
            public static final int R = 43;
            public static final int S = 44;
            public static final int T = 45;
            public static final int U = 46;
            public static final int V = 47;
            public static final int W = 48;
            public static final int X = 49;
            public static final int Y = 50;
            public static final int Z = 51;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final int f4568a = 0;

            /* JADX INFO: renamed from: a0, reason: collision with root package name */
            public static final int f4569a0 = 52;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final int f4570b = 1;

            /* JADX INFO: renamed from: b0, reason: collision with root package name */
            public static final int f4571b0 = 53;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final int f4572c = 2;

            /* JADX INFO: renamed from: c0, reason: collision with root package name */
            public static final int f4573c0 = 54;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static final int f4574d = 3;

            /* JADX INFO: renamed from: d0, reason: collision with root package name */
            public static final int f4575d0 = 55;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final int f4576e = 4;

            /* JADX INFO: renamed from: e0, reason: collision with root package name */
            public static final int f4577e0 = 64;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final int f4578f = 5;

            /* JADX INFO: renamed from: f0, reason: collision with root package name */
            public static final int f4579f0 = 65;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final int f4580g = 6;

            /* JADX INFO: renamed from: g0, reason: collision with root package name */
            public static final int f4581g0 = 66;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public static final int f4582h = 7;

            /* JADX INFO: renamed from: h0, reason: collision with root package name */
            public static final int f4583h0 = 67;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public static final int f4584i = 8;

            /* JADX INFO: renamed from: i0, reason: collision with root package name */
            public static final SparseIntArray f4585i0;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public static final int f4586j = 9;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public static final int f4587k = 10;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public static final int f4588l = 11;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public static final int f4589m = 12;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public static final int f4590n = 13;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public static final int f4591o = 14;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public static final int f4592p = 15;

            /* JADX INFO: renamed from: q, reason: collision with root package name */
            public static final int f4593q = 16;

            /* JADX INFO: renamed from: r, reason: collision with root package name */
            public static final int f4594r = 17;

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            public static final int f4595s = 18;

            /* JADX INFO: renamed from: t, reason: collision with root package name */
            public static final int f4596t = 19;

            /* JADX INFO: renamed from: u, reason: collision with root package name */
            public static final int f4597u = 20;

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public static final int f4598v = 21;

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public static final int f4599w = 22;

            /* JADX INFO: renamed from: x, reason: collision with root package name */
            public static final int f4600x = 23;

            /* JADX INFO: renamed from: y, reason: collision with root package name */
            public static final int f4601y = 24;

            /* JADX INFO: renamed from: z, reason: collision with root package name */
            public static final int f4602z = 25;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f4585i0 = sparseIntArray;
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth, 64);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight, 65);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toTopOf, 52);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBottomOf, 53);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_guidelineUseRtl, 67);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBaseline, 55);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_marginBaseline, 54);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTag, 51);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_wrapBehaviorInParent, 66);
            }

            private a() {
            }
        }

        public LayoutParams(LayoutParams source) {
            super((ViewGroup.MarginLayoutParams) source);
            this.f4518a = -1;
            this.f4520b = -1;
            this.f4522c = -1.0f;
            this.f4524d = true;
            this.f4526e = -1;
            this.f4528f = -1;
            this.f4530g = -1;
            this.f4532h = -1;
            this.f4534i = -1;
            this.f4536j = -1;
            this.f4538k = -1;
            this.f4540l = -1;
            this.f4542m = -1;
            this.f4544n = -1;
            this.f4546o = -1;
            this.f4548p = -1;
            this.f4550q = 0;
            this.f4552r = 0.0f;
            this.f4554s = -1;
            this.f4556t = -1;
            this.f4558u = -1;
            this.f4560v = -1;
            this.f4562w = Integer.MIN_VALUE;
            this.f4564x = Integer.MIN_VALUE;
            this.f4565y = Integer.MIN_VALUE;
            this.f4566z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.f4517J = 0.0f;
            this.K = 1;
            this.L = -1.0f;
            this.M = -1.0f;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 1.0f;
            this.W = 1.0f;
            this.X = -1;
            this.Y = -1;
            this.Z = -1;
            this.f4519a0 = false;
            this.f4521b0 = false;
            this.f4523c0 = null;
            this.f4525d0 = 0;
            this.f4527e0 = true;
            this.f4529f0 = true;
            this.f4531g0 = false;
            this.f4533h0 = false;
            this.f4535i0 = false;
            this.f4537j0 = false;
            this.f4539k0 = false;
            this.f4541l0 = -1;
            this.f4543m0 = -1;
            this.f4545n0 = -1;
            this.f4547o0 = -1;
            this.f4549p0 = Integer.MIN_VALUE;
            this.f4551q0 = Integer.MIN_VALUE;
            this.f4553r0 = 0.5f;
            this.f4561v0 = new androidx.constraintlayout.core.widgets.e();
            this.f4563w0 = false;
            this.f4518a = source.f4518a;
            this.f4520b = source.f4520b;
            this.f4522c = source.f4522c;
            this.f4524d = source.f4524d;
            this.f4526e = source.f4526e;
            this.f4528f = source.f4528f;
            this.f4530g = source.f4530g;
            this.f4532h = source.f4532h;
            this.f4534i = source.f4534i;
            this.f4536j = source.f4536j;
            this.f4538k = source.f4538k;
            this.f4540l = source.f4540l;
            this.f4542m = source.f4542m;
            this.f4544n = source.f4544n;
            this.f4546o = source.f4546o;
            this.f4548p = source.f4548p;
            this.f4550q = source.f4550q;
            this.f4552r = source.f4552r;
            this.f4554s = source.f4554s;
            this.f4556t = source.f4556t;
            this.f4558u = source.f4558u;
            this.f4560v = source.f4560v;
            this.f4562w = source.f4562w;
            this.f4564x = source.f4564x;
            this.f4565y = source.f4565y;
            this.f4566z = source.f4566z;
            this.A = source.A;
            this.B = source.B;
            this.C = source.C;
            this.D = source.D;
            this.G = source.G;
            this.H = source.H;
            this.I = source.I;
            this.f4517J = source.f4517J;
            this.K = source.K;
            this.L = source.L;
            this.M = source.M;
            this.N = source.N;
            this.O = source.O;
            this.f4519a0 = source.f4519a0;
            this.f4521b0 = source.f4521b0;
            this.P = source.P;
            this.Q = source.Q;
            this.R = source.R;
            this.T = source.T;
            this.S = source.S;
            this.U = source.U;
            this.V = source.V;
            this.W = source.W;
            this.X = source.X;
            this.Y = source.Y;
            this.Z = source.Z;
            this.f4527e0 = source.f4527e0;
            this.f4529f0 = source.f4529f0;
            this.f4531g0 = source.f4531g0;
            this.f4533h0 = source.f4533h0;
            this.f4541l0 = source.f4541l0;
            this.f4543m0 = source.f4543m0;
            this.f4545n0 = source.f4545n0;
            this.f4547o0 = source.f4547o0;
            this.f4549p0 = source.f4549p0;
            this.f4551q0 = source.f4551q0;
            this.f4553r0 = source.f4553r0;
            this.f4523c0 = source.f4523c0;
            this.f4525d0 = source.f4525d0;
            this.f4561v0 = source.f4561v0;
            this.E = source.E;
            this.F = source.F;
        }

        public String a() {
            return this.f4523c0;
        }

        public androidx.constraintlayout.core.widgets.e b() {
            return this.f4561v0;
        }

        public void c() {
            androidx.constraintlayout.core.widgets.e eVar = this.f4561v0;
            if (eVar != null) {
                eVar.R0();
            }
        }

        public void d(String text) {
            this.f4561v0.j1(text);
        }

        public void e() {
            this.f4533h0 = false;
            this.f4527e0 = true;
            this.f4529f0 = true;
            int i7 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i7 == -2 && this.f4519a0) {
                this.f4527e0 = false;
                if (this.P == 0) {
                    this.P = 1;
                }
            }
            int i8 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i8 == -2 && this.f4521b0) {
                this.f4529f0 = false;
                if (this.Q == 0) {
                    this.Q = 1;
                }
            }
            if (i7 == 0 || i7 == -1) {
                this.f4527e0 = false;
                if (i7 == 0 && this.P == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.f4519a0 = true;
                }
            }
            if (i8 == 0 || i8 == -1) {
                this.f4529f0 = false;
                if (i8 == 0 && this.Q == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.f4521b0 = true;
                }
            }
            if (this.f4522c == -1.0f && this.f4518a == -1 && this.f4520b == -1) {
                return;
            }
            this.f4533h0 = true;
            this.f4527e0 = true;
            this.f4529f0 = true;
            if (!(this.f4561v0 instanceof h)) {
                this.f4561v0 = new h();
            }
            ((h) this.f4561v0).B2(this.Z);
        }

        /* JADX WARN: Code duplicated, block: B:17:0x004a  */
        /* JADX WARN: Code duplicated, block: B:20:0x0051  */
        /* JADX WARN: Code duplicated, block: B:23:0x0058  */
        /* JADX WARN: Code duplicated, block: B:26:0x005e  */
        /* JADX WARN: Code duplicated, block: B:29:0x0064  */
        /* JADX WARN: Code duplicated, block: B:38:0x007a  */
        /* JADX WARN: Code duplicated, block: B:39:0x0082 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:40:0x0084  */
        /* JADX WARN: Code duplicated, block: B:41:0x008b A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:42:0x008d  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @TargetApi(17)
        public void resolveLayoutDirection(int layoutDirection) {
            int i7;
            int i8;
            int i9;
            int i10;
            int i11 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
            int i12 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
            super.resolveLayoutDirection(layoutDirection);
            boolean z7 = false;
            boolean z8 = 1 == getLayoutDirection();
            this.f4545n0 = -1;
            this.f4547o0 = -1;
            this.f4541l0 = -1;
            this.f4543m0 = -1;
            this.f4549p0 = this.f4562w;
            this.f4551q0 = this.f4565y;
            float f8 = this.G;
            this.f4553r0 = f8;
            int i13 = this.f4518a;
            this.f4555s0 = i13;
            int i14 = this.f4520b;
            this.f4557t0 = i14;
            float f9 = this.f4522c;
            this.f4559u0 = f9;
            if (z8) {
                int i15 = this.f4554s;
                if (i15 != -1) {
                    this.f4545n0 = i15;
                } else {
                    int i16 = this.f4556t;
                    if (i16 != -1) {
                        this.f4547o0 = i16;
                    } else {
                        i7 = this.f4558u;
                        if (i7 != -1) {
                            this.f4543m0 = i7;
                            z7 = true;
                        }
                        i8 = this.f4560v;
                        if (i8 != -1) {
                            this.f4541l0 = i8;
                            z7 = true;
                        }
                        i9 = this.A;
                        if (i9 != Integer.MIN_VALUE) {
                            this.f4551q0 = i9;
                        }
                        i10 = this.B;
                        if (i10 != Integer.MIN_VALUE) {
                            this.f4549p0 = i10;
                        }
                        if (z7) {
                            this.f4553r0 = 1.0f - f8;
                        }
                        if (this.f4533h0 && this.Z == 1 && this.f4524d) {
                            if (f9 != -1.0f) {
                                this.f4559u0 = 1.0f - f9;
                                this.f4555s0 = -1;
                                this.f4557t0 = -1;
                            } else if (i13 != -1) {
                                this.f4557t0 = i13;
                                this.f4555s0 = -1;
                                this.f4559u0 = -1.0f;
                            } else if (i14 != -1) {
                                this.f4555s0 = i14;
                                this.f4557t0 = -1;
                                this.f4559u0 = -1.0f;
                            }
                        }
                    }
                }
                z7 = true;
                i7 = this.f4558u;
                if (i7 != -1) {
                    this.f4543m0 = i7;
                    z7 = true;
                }
                i8 = this.f4560v;
                if (i8 != -1) {
                    this.f4541l0 = i8;
                    z7 = true;
                }
                i9 = this.A;
                if (i9 != Integer.MIN_VALUE) {
                    this.f4551q0 = i9;
                }
                i10 = this.B;
                if (i10 != Integer.MIN_VALUE) {
                    this.f4549p0 = i10;
                }
                if (z7) {
                    this.f4553r0 = 1.0f - f8;
                }
                if (this.f4533h0) {
                    if (f9 != -1.0f) {
                        this.f4559u0 = 1.0f - f9;
                        this.f4555s0 = -1;
                        this.f4557t0 = -1;
                    } else if (i13 != -1) {
                        this.f4557t0 = i13;
                        this.f4555s0 = -1;
                        this.f4559u0 = -1.0f;
                    } else if (i14 != -1) {
                        this.f4555s0 = i14;
                        this.f4557t0 = -1;
                        this.f4559u0 = -1.0f;
                    }
                }
            } else {
                int i17 = this.f4554s;
                if (i17 != -1) {
                    this.f4543m0 = i17;
                }
                int i18 = this.f4556t;
                if (i18 != -1) {
                    this.f4541l0 = i18;
                }
                int i19 = this.f4558u;
                if (i19 != -1) {
                    this.f4545n0 = i19;
                }
                int i20 = this.f4560v;
                if (i20 != -1) {
                    this.f4547o0 = i20;
                }
                int i21 = this.A;
                if (i21 != Integer.MIN_VALUE) {
                    this.f4549p0 = i21;
                }
                int i22 = this.B;
                if (i22 != Integer.MIN_VALUE) {
                    this.f4551q0 = i22;
                }
            }
            if (this.f4558u == -1 && this.f4560v == -1 && this.f4556t == -1 && this.f4554s == -1) {
                int i23 = this.f4530g;
                if (i23 != -1) {
                    this.f4545n0 = i23;
                    if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i12 > 0) {
                        ((ViewGroup.MarginLayoutParams) this).rightMargin = i12;
                    }
                } else {
                    int i24 = this.f4532h;
                    if (i24 != -1) {
                        this.f4547o0 = i24;
                        if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i12 > 0) {
                            ((ViewGroup.MarginLayoutParams) this).rightMargin = i12;
                        }
                    }
                }
                int i25 = this.f4526e;
                if (i25 != -1) {
                    this.f4541l0 = i25;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i11 <= 0) {
                        return;
                    }
                    ((ViewGroup.MarginLayoutParams) this).leftMargin = i11;
                    return;
                }
                int i26 = this.f4528f;
                if (i26 != -1) {
                    this.f4543m0 = i26;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i11 <= 0) {
                        return;
                    }
                    ((ViewGroup.MarginLayoutParams) this).leftMargin = i11;
                }
            }
        }

        public LayoutParams(Context c8, AttributeSet attrs) {
            super(c8, attrs);
            this.f4518a = -1;
            this.f4520b = -1;
            this.f4522c = -1.0f;
            this.f4524d = true;
            this.f4526e = -1;
            this.f4528f = -1;
            this.f4530g = -1;
            this.f4532h = -1;
            this.f4534i = -1;
            this.f4536j = -1;
            this.f4538k = -1;
            this.f4540l = -1;
            this.f4542m = -1;
            this.f4544n = -1;
            this.f4546o = -1;
            this.f4548p = -1;
            this.f4550q = 0;
            this.f4552r = 0.0f;
            this.f4554s = -1;
            this.f4556t = -1;
            this.f4558u = -1;
            this.f4560v = -1;
            this.f4562w = Integer.MIN_VALUE;
            this.f4564x = Integer.MIN_VALUE;
            this.f4565y = Integer.MIN_VALUE;
            this.f4566z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.f4517J = 0.0f;
            this.K = 1;
            this.L = -1.0f;
            this.M = -1.0f;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 1.0f;
            this.W = 1.0f;
            this.X = -1;
            this.Y = -1;
            this.Z = -1;
            this.f4519a0 = false;
            this.f4521b0 = false;
            this.f4523c0 = null;
            this.f4525d0 = 0;
            this.f4527e0 = true;
            this.f4529f0 = true;
            this.f4531g0 = false;
            this.f4533h0 = false;
            this.f4535i0 = false;
            this.f4537j0 = false;
            this.f4539k0 = false;
            this.f4541l0 = -1;
            this.f4543m0 = -1;
            this.f4545n0 = -1;
            this.f4547o0 = -1;
            this.f4549p0 = Integer.MIN_VALUE;
            this.f4551q0 = Integer.MIN_VALUE;
            this.f4553r0 = 0.5f;
            this.f4561v0 = new androidx.constraintlayout.core.widgets.e();
            this.f4563w0 = false;
            TypedArray typedArrayObtainStyledAttributes = c8.obtainStyledAttributes(attrs, R.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                int i8 = a.f4585i0.get(index);
                switch (i8) {
                    case 1:
                        this.Z = typedArrayObtainStyledAttributes.getInt(index, this.Z);
                        break;
                    case 2:
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f4548p);
                        this.f4548p = resourceId;
                        if (resourceId == -1) {
                            this.f4548p = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 3:
                        this.f4550q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f4550q);
                        break;
                    case 4:
                        float f8 = typedArrayObtainStyledAttributes.getFloat(index, this.f4552r) % 360.0f;
                        this.f4552r = f8;
                        if (f8 < 0.0f) {
                            this.f4552r = (360.0f - f8) % 360.0f;
                        }
                        break;
                    case 5:
                        this.f4518a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f4518a);
                        break;
                    case 6:
                        this.f4520b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f4520b);
                        break;
                    case 7:
                        this.f4522c = typedArrayObtainStyledAttributes.getFloat(index, this.f4522c);
                        break;
                    case 8:
                        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, this.f4526e);
                        this.f4526e = resourceId2;
                        if (resourceId2 == -1) {
                            this.f4526e = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 9:
                        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, this.f4528f);
                        this.f4528f = resourceId3;
                        if (resourceId3 == -1) {
                            this.f4528f = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 10:
                        int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, this.f4530g);
                        this.f4530g = resourceId4;
                        if (resourceId4 == -1) {
                            this.f4530g = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 11:
                        int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, this.f4532h);
                        this.f4532h = resourceId5;
                        if (resourceId5 == -1) {
                            this.f4532h = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 12:
                        int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, this.f4534i);
                        this.f4534i = resourceId6;
                        if (resourceId6 == -1) {
                            this.f4534i = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 13:
                        int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, this.f4536j);
                        this.f4536j = resourceId7;
                        if (resourceId7 == -1) {
                            this.f4536j = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 14:
                        int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, this.f4538k);
                        this.f4538k = resourceId8;
                        if (resourceId8 == -1) {
                            this.f4538k = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 15:
                        int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, this.f4540l);
                        this.f4540l = resourceId9;
                        if (resourceId9 == -1) {
                            this.f4540l = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 16:
                        int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, this.f4542m);
                        this.f4542m = resourceId10;
                        if (resourceId10 == -1) {
                            this.f4542m = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 17:
                        int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, this.f4554s);
                        this.f4554s = resourceId11;
                        if (resourceId11 == -1) {
                            this.f4554s = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 18:
                        int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, this.f4556t);
                        this.f4556t = resourceId12;
                        if (resourceId12 == -1) {
                            this.f4556t = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 19:
                        int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, this.f4558u);
                        this.f4558u = resourceId13;
                        if (resourceId13 == -1) {
                            this.f4558u = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 20:
                        int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, this.f4560v);
                        this.f4560v = resourceId14;
                        if (resourceId14 == -1) {
                            this.f4560v = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 21:
                        this.f4562w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f4562w);
                        break;
                    case 22:
                        this.f4564x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f4564x);
                        break;
                    case 23:
                        this.f4565y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f4565y);
                        break;
                    case 24:
                        this.f4566z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f4566z);
                        break;
                    case 25:
                        this.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.A);
                        break;
                    case 26:
                        this.B = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.B);
                        break;
                    case 27:
                        this.f4519a0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f4519a0);
                        break;
                    case 28:
                        this.f4521b0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f4521b0);
                        break;
                    case 29:
                        this.G = typedArrayObtainStyledAttributes.getFloat(index, this.G);
                        break;
                    case 30:
                        this.H = typedArrayObtainStyledAttributes.getFloat(index, this.H);
                        break;
                    case 31:
                        int i9 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.P = i9;
                        if (i9 == 1) {
                            Log.e(ConstraintLayout.A, "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                        }
                        break;
                    case 32:
                        int i10 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.Q = i10;
                        if (i10 == 1) {
                            Log.e(ConstraintLayout.A, "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                        }
                        break;
                    case 33:
                        try {
                            this.R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.R);
                        } catch (Exception unused) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.R) == -2) {
                                this.R = -2;
                            }
                        }
                        break;
                    case 34:
                        try {
                            this.T = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.T);
                        } catch (Exception unused2) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.T) == -2) {
                                this.T = -2;
                            }
                        }
                        break;
                    case 35:
                        this.V = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.V));
                        this.P = 2;
                        break;
                    case 36:
                        try {
                            this.S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.S);
                        } catch (Exception unused3) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.S) == -2) {
                                this.S = -2;
                            }
                        }
                        break;
                    case 37:
                        try {
                            this.U = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.U);
                        } catch (Exception unused4) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.U) == -2) {
                                this.U = -2;
                            }
                        }
                        break;
                    case 38:
                        this.W = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.W));
                        this.Q = 2;
                        break;
                    default:
                        switch (i8) {
                            case 44:
                                d.C0(this, typedArrayObtainStyledAttributes.getString(index));
                                break;
                            case 45:
                                this.L = typedArrayObtainStyledAttributes.getFloat(index, this.L);
                                break;
                            case 46:
                                this.M = typedArrayObtainStyledAttributes.getFloat(index, this.M);
                                break;
                            case 47:
                                this.N = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case a.W /* 48 */:
                                this.O = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.X = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.X);
                                break;
                            case 50:
                                this.Y = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.Y);
                                break;
                            case a.Z /* 51 */:
                                this.f4523c0 = typedArrayObtainStyledAttributes.getString(index);
                                break;
                            case a.f4569a0 /* 52 */:
                                int resourceId15 = typedArrayObtainStyledAttributes.getResourceId(index, this.f4544n);
                                this.f4544n = resourceId15;
                                if (resourceId15 == -1) {
                                    this.f4544n = typedArrayObtainStyledAttributes.getInt(index, -1);
                                }
                                break;
                            case a.f4571b0 /* 53 */:
                                int resourceId16 = typedArrayObtainStyledAttributes.getResourceId(index, this.f4546o);
                                this.f4546o = resourceId16;
                                if (resourceId16 == -1) {
                                    this.f4546o = typedArrayObtainStyledAttributes.getInt(index, -1);
                                }
                                break;
                            case 54:
                                this.D = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.D);
                                break;
                            case 55:
                                this.C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.C);
                                break;
                            default:
                                switch (i8) {
                                    case 64:
                                        d.A0(this, typedArrayObtainStyledAttributes, index, 0);
                                        this.E = true;
                                        break;
                                    case 65:
                                        d.A0(this, typedArrayObtainStyledAttributes, index, 1);
                                        this.F = true;
                                        break;
                                    case 66:
                                        this.f4525d0 = typedArrayObtainStyledAttributes.getInt(index, this.f4525d0);
                                        break;
                                    case a.f4583h0 /* 67 */:
                                        this.f4524d = typedArrayObtainStyledAttributes.getBoolean(index, this.f4524d);
                                        break;
                                }
                                break;
                        }
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            e();
        }

        public LayoutParams(int width, int height) {
            super(width, height);
            this.f4518a = -1;
            this.f4520b = -1;
            this.f4522c = -1.0f;
            this.f4524d = true;
            this.f4526e = -1;
            this.f4528f = -1;
            this.f4530g = -1;
            this.f4532h = -1;
            this.f4534i = -1;
            this.f4536j = -1;
            this.f4538k = -1;
            this.f4540l = -1;
            this.f4542m = -1;
            this.f4544n = -1;
            this.f4546o = -1;
            this.f4548p = -1;
            this.f4550q = 0;
            this.f4552r = 0.0f;
            this.f4554s = -1;
            this.f4556t = -1;
            this.f4558u = -1;
            this.f4560v = -1;
            this.f4562w = Integer.MIN_VALUE;
            this.f4564x = Integer.MIN_VALUE;
            this.f4565y = Integer.MIN_VALUE;
            this.f4566z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.f4517J = 0.0f;
            this.K = 1;
            this.L = -1.0f;
            this.M = -1.0f;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 1.0f;
            this.W = 1.0f;
            this.X = -1;
            this.Y = -1;
            this.Z = -1;
            this.f4519a0 = false;
            this.f4521b0 = false;
            this.f4523c0 = null;
            this.f4525d0 = 0;
            this.f4527e0 = true;
            this.f4529f0 = true;
            this.f4531g0 = false;
            this.f4533h0 = false;
            this.f4535i0 = false;
            this.f4537j0 = false;
            this.f4539k0 = false;
            this.f4541l0 = -1;
            this.f4543m0 = -1;
            this.f4545n0 = -1;
            this.f4547o0 = -1;
            this.f4549p0 = Integer.MIN_VALUE;
            this.f4551q0 = Integer.MIN_VALUE;
            this.f4553r0 = 0.5f;
            this.f4561v0 = new androidx.constraintlayout.core.widgets.e();
            this.f4563w0 = false;
        }

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
            this.f4518a = -1;
            this.f4520b = -1;
            this.f4522c = -1.0f;
            this.f4524d = true;
            this.f4526e = -1;
            this.f4528f = -1;
            this.f4530g = -1;
            this.f4532h = -1;
            this.f4534i = -1;
            this.f4536j = -1;
            this.f4538k = -1;
            this.f4540l = -1;
            this.f4542m = -1;
            this.f4544n = -1;
            this.f4546o = -1;
            this.f4548p = -1;
            this.f4550q = 0;
            this.f4552r = 0.0f;
            this.f4554s = -1;
            this.f4556t = -1;
            this.f4558u = -1;
            this.f4560v = -1;
            this.f4562w = Integer.MIN_VALUE;
            this.f4564x = Integer.MIN_VALUE;
            this.f4565y = Integer.MIN_VALUE;
            this.f4566z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.f4517J = 0.0f;
            this.K = 1;
            this.L = -1.0f;
            this.M = -1.0f;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 1.0f;
            this.W = 1.0f;
            this.X = -1;
            this.Y = -1;
            this.Z = -1;
            this.f4519a0 = false;
            this.f4521b0 = false;
            this.f4523c0 = null;
            this.f4525d0 = 0;
            this.f4527e0 = true;
            this.f4529f0 = true;
            this.f4531g0 = false;
            this.f4533h0 = false;
            this.f4535i0 = false;
            this.f4537j0 = false;
            this.f4539k0 = false;
            this.f4541l0 = -1;
            this.f4543m0 = -1;
            this.f4545n0 = -1;
            this.f4547o0 = -1;
            this.f4549p0 = Integer.MIN_VALUE;
            this.f4551q0 = Integer.MIN_VALUE;
            this.f4553r0 = 0.5f;
            this.f4561v0 = new androidx.constraintlayout.core.widgets.e();
            this.f4563w0 = false;
        }
    }
}
