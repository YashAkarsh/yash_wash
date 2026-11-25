package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.appcompat.R;
import androidx.core.view.n2;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {
    private static final String A = "androidx.appcompat.widget.LinearLayoutCompat";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f1501p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f1502q = 1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f1503r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f1504s = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f1505t = 2;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f1506u = 4;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int f1507v = 4;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int f1508w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int f1509x = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final int f1510y = 2;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int f1511z = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1515d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1516e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1517f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f1518g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1519h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int[] f1520i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int[] f1521j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Drawable f1522k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f1523l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f1524m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f1525n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f1526o;

    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i7, int i8) {
            super(i7, i8);
        }

        public LayoutParams(int i7, int i8, float f8) {
            super(i7, i8, f8);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    public LinearLayoutCompat(@c.m0 Context context) {
        this(context, null);
    }

    private void D(View view, int i7, int i8, int i9, int i10) {
        view.layout(i7, i8, i9 + i7, i10 + i8);
    }

    private void l(int i7, int i8) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i9 = 0; i9 < i7; i9++) {
            View viewT = t(i9);
            if (viewT.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) viewT.getLayoutParams();
                if (((LinearLayout.LayoutParams) layoutParams).height == -1) {
                    int i10 = ((LinearLayout.LayoutParams) layoutParams).width;
                    ((LinearLayout.LayoutParams) layoutParams).width = viewT.getMeasuredWidth();
                    measureChildWithMargins(viewT, i8, 0, iMakeMeasureSpec, 0);
                    ((LinearLayout.LayoutParams) layoutParams).width = i10;
                }
            }
        }
    }

    private void m(int i7, int i8) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i9 = 0; i9 < i7; i9++) {
            View viewT = t(i9);
            if (viewT.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) viewT.getLayoutParams();
                if (((LinearLayout.LayoutParams) layoutParams).width == -1) {
                    int i10 = ((LinearLayout.LayoutParams) layoutParams).height;
                    ((LinearLayout.LayoutParams) layoutParams).height = viewT.getMeasuredHeight();
                    measureChildWithMargins(viewT, iMakeMeasureSpec, 0, i8, 0);
                    ((LinearLayout.LayoutParams) layoutParams).height = i10;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:197:0x0452  */
    /* JADX WARN: Code duplicated, block: B:60:0x0177  */
    /* JADX WARN: Code duplicated, block: B:67:0x0199  */
    /* JADX WARN: Code duplicated, block: B:74:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:77:0x01cd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:81:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:84:0x01dd  */
    void A(int i7, int i8) {
        int[] iArr;
        int i9;
        int iMax;
        int iMax2;
        int i10;
        int i11;
        int baseline;
        int i12;
        int i13;
        byte b8;
        int i14;
        int i15;
        boolean z7;
        boolean z8;
        View view;
        int i16;
        boolean z9;
        int i17;
        int measuredHeight;
        int iQ;
        int baseline2;
        int i18;
        this.f1517f = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i7);
        int mode2 = View.MeasureSpec.getMode(i8);
        if (this.f1520i == null || this.f1521j == null) {
            this.f1520i = new int[4];
            this.f1521j = new int[4];
        }
        int[] iArr2 = this.f1520i;
        int[] iArr3 = this.f1521j;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        iArr3[3] = -1;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        boolean z10 = this.f1512a;
        boolean z11 = this.f1519h;
        int i19 = 1073741824;
        boolean z12 = mode == 1073741824;
        int iQ2 = 0;
        int iMax3 = 0;
        int iMax4 = 0;
        int iMax5 = 0;
        int iMax6 = 0;
        boolean z13 = false;
        int iCombineMeasuredStates = 0;
        boolean z14 = false;
        boolean z15 = true;
        float f8 = 0.0f;
        while (true) {
            iArr = iArr3;
            if (iQ2 >= virtualChildCount) {
                break;
            }
            View viewT = t(iQ2);
            if (viewT == null) {
                this.f1517f += B(iQ2);
            } else {
                if (viewT.getVisibility() == 8) {
                    iQ2 += q(viewT, iQ2);
                } else {
                    if (u(iQ2)) {
                        this.f1517f += this.f1523l;
                    }
                    LayoutParams layoutParams = (LayoutParams) viewT.getLayoutParams();
                    float f9 = ((LinearLayout.LayoutParams) layoutParams).weight;
                    float f10 = f8 + f9;
                    if (mode == i19 && ((LinearLayout.LayoutParams) layoutParams).width == 0 && f9 > 0.0f) {
                        if (z12) {
                            this.f1517f += ((LinearLayout.LayoutParams) layoutParams).leftMargin + ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                        } else {
                            int i20 = this.f1517f;
                            this.f1517f = Math.max(i20, ((LinearLayout.LayoutParams) layoutParams).leftMargin + i20 + ((LinearLayout.LayoutParams) layoutParams).rightMargin);
                        }
                        if (z10) {
                            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                            viewT.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                            i15 = iQ2;
                            z7 = z11;
                            z8 = z10;
                            view = viewT;
                        } else {
                            i15 = iQ2;
                            z7 = z11;
                            z8 = z10;
                            view = viewT;
                            z13 = true;
                            i16 = 1073741824;
                        }
                        if (mode2 == i16 && ((LinearLayout.LayoutParams) layoutParams).height == -1) {
                            z9 = true;
                            z14 = true;
                        } else {
                            z9 = false;
                        }
                        i17 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                        measuredHeight = view.getMeasuredHeight() + i17;
                        iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view.getMeasuredState());
                        if (z8 && (baseline2 = view.getBaseline()) != -1) {
                            i18 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                            if (i18 < 0) {
                                i18 = this.f1516e;
                            }
                            int i21 = (((i18 & 112) >> 4) & (-2)) >> 1;
                            iArr2[i21] = Math.max(iArr2[i21], baseline2);
                            iArr[i21] = Math.max(iArr[i21], measuredHeight - baseline2);
                        }
                        iMax4 = Math.max(iMax4, measuredHeight);
                        if (z15 || ((LinearLayout.LayoutParams) layoutParams).height != -1) {
                            z15 = false;
                        } else {
                            z15 = true;
                        }
                        if (((LinearLayout.LayoutParams) layoutParams).weight > 0.0f) {
                            if (!z9) {
                                i17 = measuredHeight;
                            }
                            iMax6 = Math.max(iMax6, i17);
                        } else {
                            int i22 = iMax6;
                            if (!z9) {
                                i17 = measuredHeight;
                            }
                            iMax5 = Math.max(iMax5, i17);
                            iMax6 = i22;
                        }
                        int i23 = i15;
                        iQ = q(view, i23) + i23;
                        f8 = f10;
                    } else {
                        if (((LinearLayout.LayoutParams) layoutParams).width != 0 || f9 <= 0.0f) {
                            b8 = -2;
                            i14 = Integer.MIN_VALUE;
                        } else {
                            b8 = -2;
                            ((LinearLayout.LayoutParams) layoutParams).width = -2;
                            i14 = 0;
                        }
                        i15 = iQ2;
                        int i24 = i14;
                        z7 = z11;
                        z8 = z10;
                        z(viewT, i15, i7, f10 == 0.0f ? this.f1517f : 0, i8, 0);
                        if (i24 != Integer.MIN_VALUE) {
                            ((LinearLayout.LayoutParams) layoutParams).width = i24;
                        }
                        int measuredWidth = viewT.getMeasuredWidth();
                        if (z12) {
                            view = viewT;
                            this.f1517f += ((LinearLayout.LayoutParams) layoutParams).leftMargin + measuredWidth + ((LinearLayout.LayoutParams) layoutParams).rightMargin + s(view);
                        } else {
                            view = viewT;
                            int i25 = this.f1517f;
                            this.f1517f = Math.max(i25, i25 + measuredWidth + ((LinearLayout.LayoutParams) layoutParams).leftMargin + ((LinearLayout.LayoutParams) layoutParams).rightMargin + s(view));
                        }
                        if (z7) {
                            iMax3 = Math.max(measuredWidth, iMax3);
                        }
                    }
                    i16 = 1073741824;
                    if (mode2 == i16) {
                        z9 = false;
                    } else {
                        z9 = false;
                    }
                    i17 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    measuredHeight = view.getMeasuredHeight() + i17;
                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view.getMeasuredState());
                    if (z8) {
                        i18 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                        if (i18 < 0) {
                            i18 = this.f1516e;
                        }
                        int i26 = (((i18 & 112) >> 4) & (-2)) >> 1;
                        iArr2[i26] = Math.max(iArr2[i26], baseline2);
                        iArr[i26] = Math.max(iArr[i26], measuredHeight - baseline2);
                    }
                    iMax4 = Math.max(iMax4, measuredHeight);
                    if (z15) {
                        z15 = false;
                    } else {
                        z15 = false;
                    }
                    if (((LinearLayout.LayoutParams) layoutParams).weight > 0.0f) {
                        if (!z9) {
                            i17 = measuredHeight;
                        }
                        iMax6 = Math.max(iMax6, i17);
                    } else {
                        int i27 = iMax6;
                        if (!z9) {
                            i17 = measuredHeight;
                        }
                        iMax5 = Math.max(iMax5, i17);
                        iMax6 = i27;
                    }
                    int i28 = i15;
                    iQ = q(view, i28) + i28;
                    f8 = f10;
                }
                int i29 = iQ + 1;
                iArr3 = iArr;
                z11 = z7;
                z10 = z8;
                i19 = i16;
                iQ2 = i29;
            }
            z7 = z11;
            z8 = z10;
            int i30 = i19;
            iQ = iQ2;
            i16 = i30;
            int i210 = iQ + 1;
            iArr3 = iArr;
            z11 = z7;
            z10 = z8;
            i19 = i16;
            iQ2 = i210;
        }
        boolean z16 = z11;
        boolean z17 = z10;
        int i31 = iMax4;
        int i32 = iMax5;
        int i33 = iMax6;
        int i34 = iCombineMeasuredStates;
        if (this.f1517f > 0 && u(virtualChildCount)) {
            this.f1517f += this.f1523l;
        }
        int i35 = iArr2[1];
        int iMax7 = (i35 == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) ? i31 : Math.max(i31, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(i35, iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        if (z16 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f1517f = 0;
            int iQ3 = 0;
            while (iQ3 < virtualChildCount) {
                View viewT2 = t(iQ3);
                if (viewT2 == null) {
                    this.f1517f += B(iQ3);
                } else if (viewT2.getVisibility() == 8) {
                    iQ3 += q(viewT2, iQ3);
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) viewT2.getLayoutParams();
                    if (z12) {
                        this.f1517f += ((LinearLayout.LayoutParams) layoutParams2).leftMargin + iMax3 + ((LinearLayout.LayoutParams) layoutParams2).rightMargin + s(viewT2);
                    } else {
                        int i36 = this.f1517f;
                        this.f1517f = Math.max(i36, i36 + iMax3 + ((LinearLayout.LayoutParams) layoutParams2).leftMargin + ((LinearLayout.LayoutParams) layoutParams2).rightMargin + s(viewT2));
                    }
                    iQ3++;
                    iMax7 = iMax7;
                }
                iQ3++;
                iMax7 = iMax7;
            }
        }
        int i37 = iMax7;
        int paddingLeft = this.f1517f + getPaddingLeft() + getPaddingRight();
        this.f1517f = paddingLeft;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i7, 0);
        int i38 = (16777215 & iResolveSizeAndState) - this.f1517f;
        if (z13 || (i38 != 0 && f8 > 0.0f)) {
            float f11 = this.f1518g;
            if (f11 > 0.0f) {
                f8 = f11;
            }
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            this.f1517f = 0;
            int i39 = i32;
            int iMax8 = -1;
            int iCombineMeasuredStates2 = i34;
            int i40 = 0;
            while (i40 < virtualChildCount) {
                View viewT3 = t(i40);
                if (viewT3 == null || viewT3.getVisibility() == 8) {
                    i10 = i38;
                    virtualChildCount = virtualChildCount;
                } else {
                    LayoutParams layoutParams3 = (LayoutParams) viewT3.getLayoutParams();
                    float f12 = ((LinearLayout.LayoutParams) layoutParams3).weight;
                    if (f12 > 0.0f) {
                        int i41 = (int) ((i38 * f12) / f8);
                        float f13 = f8 - f12;
                        int i42 = i38 - i41;
                        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i8, getPaddingTop() + getPaddingBottom() + ((LinearLayout.LayoutParams) layoutParams3).topMargin + ((LinearLayout.LayoutParams) layoutParams3).bottomMargin, ((LinearLayout.LayoutParams) layoutParams3).height);
                        if (((LinearLayout.LayoutParams) layoutParams3).width == 0) {
                            i13 = 1073741824;
                            if (mode == 1073741824) {
                                if (i41 <= 0) {
                                    i41 = 0;
                                }
                                viewT3.measure(View.MeasureSpec.makeMeasureSpec(i41, 1073741824), childMeasureSpec);
                            }
                            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, viewT3.getMeasuredState() & n2.f6743t);
                            f8 = f13;
                            i10 = i42;
                        } else {
                            i13 = 1073741824;
                        }
                        int measuredWidth2 = viewT3.getMeasuredWidth() + i41;
                        if (measuredWidth2 < 0) {
                            measuredWidth2 = 0;
                        }
                        viewT3.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, i13), childMeasureSpec);
                        iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, viewT3.getMeasuredState() & n2.f6743t);
                        f8 = f13;
                        i10 = i42;
                    } else {
                        i10 = i38;
                    }
                    if (z12) {
                        this.f1517f += viewT3.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams3).leftMargin + ((LinearLayout.LayoutParams) layoutParams3).rightMargin + s(viewT3);
                    } else {
                        int i43 = this.f1517f;
                        this.f1517f = Math.max(i43, viewT3.getMeasuredWidth() + i43 + ((LinearLayout.LayoutParams) layoutParams3).leftMargin + ((LinearLayout.LayoutParams) layoutParams3).rightMargin + s(viewT3));
                    }
                    boolean z18 = mode2 != 1073741824 && ((LinearLayout.LayoutParams) layoutParams3).height == -1;
                    int i44 = ((LinearLayout.LayoutParams) layoutParams3).topMargin + ((LinearLayout.LayoutParams) layoutParams3).bottomMargin;
                    int measuredHeight2 = viewT3.getMeasuredHeight() + i44;
                    iMax8 = Math.max(iMax8, measuredHeight2);
                    if (!z18) {
                        i44 = measuredHeight2;
                    }
                    int iMax9 = Math.max(i39, i44);
                    if (z15) {
                        i11 = -1;
                        boolean z19 = ((LinearLayout.LayoutParams) layoutParams3).height == -1;
                        if (z17 && (baseline = viewT3.getBaseline()) != i11) {
                            i12 = ((LinearLayout.LayoutParams) layoutParams3).gravity;
                            if (i12 < 0) {
                                i12 = this.f1516e;
                            }
                            int i45 = (((i12 & 112) >> 4) & (-2)) >> 1;
                            iArr2[i45] = Math.max(iArr2[i45], baseline);
                            iArr[i45] = Math.max(iArr[i45], measuredHeight2 - baseline);
                        }
                        z15 = z19;
                        i39 = iMax9;
                        f8 = f8;
                    } else {
                        i11 = -1;
                    }
                    if (z17) {
                        i12 = ((LinearLayout.LayoutParams) layoutParams3).gravity;
                        if (i12 < 0) {
                            i12 = this.f1516e;
                        }
                        int i46 = (((i12 & 112) >> 4) & (-2)) >> 1;
                        iArr2[i46] = Math.max(iArr2[i46], baseline);
                        iArr[i46] = Math.max(iArr[i46], measuredHeight2 - baseline);
                    }
                    z15 = z19;
                    i39 = iMax9;
                    f8 = f8;
                }
                i40++;
                i38 = i10;
                virtualChildCount = virtualChildCount;
            }
            i9 = virtualChildCount;
            this.f1517f += getPaddingLeft() + getPaddingRight();
            int i47 = iArr2[1];
            iMax = (i47 == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) ? iMax8 : Math.max(iMax8, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(i47, iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
            iMax2 = i39;
            i34 = iCombineMeasuredStates2;
        } else {
            iMax2 = Math.max(i32, i33);
            if (z16 && mode != 1073741824) {
                for (int i48 = 0; i48 < virtualChildCount; i48++) {
                    View viewT4 = t(i48);
                    if (viewT4 != null && viewT4.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((LayoutParams) viewT4.getLayoutParams())).weight > 0.0f) {
                        viewT4.measure(View.MeasureSpec.makeMeasureSpec(iMax3, 1073741824), View.MeasureSpec.makeMeasureSpec(viewT4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i9 = virtualChildCount;
            iMax = i37;
        }
        if (z15 || mode2 == 1073741824) {
            iMax2 = iMax;
        }
        setMeasuredDimension(iResolveSizeAndState | (i34 & n2.f6743t), View.resolveSizeAndState(Math.max(iMax2 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i8, i34 << 16));
        if (z14) {
            l(i9, i7);
        }
    }

    int B(int i7) {
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:150:0x0325  */
    /* JADX WARN: Code duplicated, block: B:156:0x0333  */
    void C(int i7, int i8) {
        int i9;
        int iCombineMeasuredStates;
        int iMax;
        int i10;
        int i11;
        int i12;
        boolean z7;
        boolean z8;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        View view;
        int iMax2;
        boolean z9;
        int iMax3;
        this.f1517f = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i7);
        int mode2 = View.MeasureSpec.getMode(i8);
        int i22 = this.f1513b;
        boolean z10 = this.f1519h;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int iMax4 = 0;
        int i26 = 0;
        int iQ = 0;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = true;
        float f8 = 0.0f;
        while (true) {
            int i27 = 8;
            int i28 = iMax4;
            if (iQ >= virtualChildCount) {
                int i29 = i23;
                int i30 = i25;
                int i31 = i26;
                int i32 = virtualChildCount;
                int i33 = mode2;
                int iMax5 = i24;
                if (this.f1517f > 0) {
                    i9 = i32;
                    if (u(i9)) {
                        this.f1517f += this.f1524m;
                    }
                } else {
                    i9 = i32;
                }
                if (z10 && (i33 == Integer.MIN_VALUE || i33 == 0)) {
                    this.f1517f = 0;
                    int iQ2 = 0;
                    while (iQ2 < i9) {
                        View viewT = t(iQ2);
                        if (viewT == null) {
                            this.f1517f += B(iQ2);
                        } else if (viewT.getVisibility() == i27) {
                            iQ2 += q(viewT, iQ2);
                        } else {
                            LayoutParams layoutParams = (LayoutParams) viewT.getLayoutParams();
                            int i34 = this.f1517f;
                            this.f1517f = Math.max(i34, i34 + i30 + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + s(viewT));
                        }
                        iQ2++;
                        i27 = 8;
                    }
                }
                int paddingTop = this.f1517f + getPaddingTop() + getPaddingBottom();
                this.f1517f = paddingTop;
                int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i8, 0);
                int i35 = (16777215 & iResolveSizeAndState) - this.f1517f;
                if (z11 || (i35 != 0 && f8 > 0.0f)) {
                    float f9 = this.f1518g;
                    if (f9 > 0.0f) {
                        f8 = f9;
                    }
                    this.f1517f = 0;
                    int i36 = i35;
                    int i37 = i31;
                    iCombineMeasuredStates = i29;
                    int i38 = 0;
                    while (i38 < i9) {
                        View viewT2 = t(i38);
                        if (viewT2.getVisibility() == 8) {
                            i10 = i36;
                        } else {
                            LayoutParams layoutParams2 = (LayoutParams) viewT2.getLayoutParams();
                            float f10 = ((LinearLayout.LayoutParams) layoutParams2).weight;
                            if (f10 > 0.0f) {
                                int i39 = (int) ((i36 * f10) / f8);
                                float f11 = f8 - f10;
                                i10 = i36 - i39;
                                int childMeasureSpec = ViewGroup.getChildMeasureSpec(i7, getPaddingLeft() + getPaddingRight() + ((LinearLayout.LayoutParams) layoutParams2).leftMargin + ((LinearLayout.LayoutParams) layoutParams2).rightMargin, ((LinearLayout.LayoutParams) layoutParams2).width);
                                if (((LinearLayout.LayoutParams) layoutParams2).height == 0) {
                                    i13 = 1073741824;
                                    if (i33 == 1073741824) {
                                        if (i39 <= 0) {
                                            i39 = 0;
                                        }
                                        viewT2.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i39, 1073741824));
                                    }
                                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewT2.getMeasuredState() & androidx.core.view.o0.f6793u);
                                    f8 = f11;
                                } else {
                                    i13 = 1073741824;
                                }
                                int measuredHeight = viewT2.getMeasuredHeight() + i39;
                                if (measuredHeight < 0) {
                                    measuredHeight = 0;
                                }
                                viewT2.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight, i13));
                                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewT2.getMeasuredState() & androidx.core.view.o0.f6793u);
                                f8 = f11;
                            } else {
                                i10 = i36;
                            }
                            int i40 = ((LinearLayout.LayoutParams) layoutParams2).leftMargin + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                            int measuredWidth = viewT2.getMeasuredWidth() + i40;
                            iMax5 = Math.max(iMax5, measuredWidth);
                            float f12 = f8;
                            if (mode != 1073741824) {
                                i11 = iCombineMeasuredStates;
                                i12 = -1;
                                z7 = ((LinearLayout.LayoutParams) layoutParams2).width == -1;
                                if (!z7) {
                                    i40 = measuredWidth;
                                }
                                int iMax6 = Math.max(i37, i40);
                                if (z13 || ((LinearLayout.LayoutParams) layoutParams2).width != i12) {
                                    z8 = false;
                                } else {
                                    z8 = true;
                                }
                                int i41 = this.f1517f;
                                this.f1517f = Math.max(i41, viewT2.getMeasuredHeight() + i41 + ((LinearLayout.LayoutParams) layoutParams2).topMargin + ((LinearLayout.LayoutParams) layoutParams2).bottomMargin + s(viewT2));
                                z13 = z8;
                                iCombineMeasuredStates = i11;
                                i37 = iMax6;
                                f8 = f12;
                            } else {
                                i11 = iCombineMeasuredStates;
                                i12 = -1;
                            }
                            if (!z7) {
                                i40 = measuredWidth;
                            }
                            int iMax7 = Math.max(i37, i40);
                            if (z13) {
                                z8 = false;
                            } else {
                                z8 = false;
                            }
                            int i42 = this.f1517f;
                            this.f1517f = Math.max(i42, viewT2.getMeasuredHeight() + i42 + ((LinearLayout.LayoutParams) layoutParams2).topMargin + ((LinearLayout.LayoutParams) layoutParams2).bottomMargin + s(viewT2));
                            z13 = z8;
                            iCombineMeasuredStates = i11;
                            i37 = iMax7;
                            f8 = f12;
                        }
                        i38++;
                        i36 = i10;
                    }
                    this.f1517f += getPaddingTop() + getPaddingBottom();
                    iMax = i37;
                } else {
                    iMax = Math.max(i31, i28);
                    if (z10 && i33 != 1073741824) {
                        for (int i43 = 0; i43 < i9; i43++) {
                            View viewT3 = t(i43);
                            if (viewT3 != null && viewT3.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((LayoutParams) viewT3.getLayoutParams())).weight > 0.0f) {
                                viewT3.measure(View.MeasureSpec.makeMeasureSpec(viewT3.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i30, 1073741824));
                            }
                        }
                    }
                    iCombineMeasuredStates = i29;
                }
                if (z13 || mode == 1073741824) {
                    iMax = iMax5;
                }
                setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i7, iCombineMeasuredStates), iResolveSizeAndState);
                if (z12) {
                    m(i9, i8);
                    return;
                }
                return;
            }
            View viewT4 = t(iQ);
            if (viewT4 == null) {
                this.f1517f += B(iQ);
                i17 = virtualChildCount;
                i18 = mode2;
                iMax4 = i28;
            } else {
                int i44 = i23;
                if (viewT4.getVisibility() == 8) {
                    iQ += q(viewT4, iQ);
                    i17 = virtualChildCount;
                    iMax4 = i28;
                    i23 = i44;
                    i18 = mode2;
                } else {
                    if (u(iQ)) {
                        this.f1517f += this.f1524m;
                    }
                    LayoutParams layoutParams3 = (LayoutParams) viewT4.getLayoutParams();
                    float f13 = ((LinearLayout.LayoutParams) layoutParams3).weight;
                    float f14 = f8 + f13;
                    if (mode2 == 1073741824 && ((LinearLayout.LayoutParams) layoutParams3).height == 0 && f13 > 0.0f) {
                        int i45 = this.f1517f;
                        this.f1517f = Math.max(i45, ((LinearLayout.LayoutParams) layoutParams3).topMargin + i45 + ((LinearLayout.LayoutParams) layoutParams3).bottomMargin);
                        iMax2 = i25;
                        view = viewT4;
                        i20 = i26;
                        z11 = true;
                        i15 = i44;
                        i16 = i24;
                        i17 = virtualChildCount;
                        i18 = mode2;
                        i19 = i28;
                        i21 = iQ;
                    } else {
                        int i46 = i24;
                        if (((LinearLayout.LayoutParams) layoutParams3).height != 0 || f13 <= 0.0f) {
                            i14 = Integer.MIN_VALUE;
                        } else {
                            ((LinearLayout.LayoutParams) layoutParams3).height = -2;
                            i14 = 0;
                        }
                        i15 = i44;
                        int i47 = i14;
                        i16 = i46;
                        int i48 = i25;
                        i17 = virtualChildCount;
                        i18 = mode2;
                        i19 = i28;
                        i20 = i26;
                        i21 = iQ;
                        z(viewT4, iQ, i7, 0, i8, f14 == 0.0f ? this.f1517f : 0);
                        if (i47 != Integer.MIN_VALUE) {
                            ((LinearLayout.LayoutParams) layoutParams3).height = i47;
                        }
                        int measuredHeight2 = viewT4.getMeasuredHeight();
                        int i49 = this.f1517f;
                        view = viewT4;
                        this.f1517f = Math.max(i49, i49 + measuredHeight2 + ((LinearLayout.LayoutParams) layoutParams3).topMargin + ((LinearLayout.LayoutParams) layoutParams3).bottomMargin + s(view));
                        iMax2 = z10 ? Math.max(measuredHeight2, i48) : i48;
                    }
                    if (i22 >= 0 && i22 == i21 + 1) {
                        this.f1514c = this.f1517f;
                    }
                    if (i21 < i22 && ((LinearLayout.LayoutParams) layoutParams3).weight > 0.0f) {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                    if (mode == 1073741824 || ((LinearLayout.LayoutParams) layoutParams3).width != -1) {
                        z9 = false;
                    } else {
                        z9 = true;
                        z12 = true;
                    }
                    int i50 = ((LinearLayout.LayoutParams) layoutParams3).leftMargin + ((LinearLayout.LayoutParams) layoutParams3).rightMargin;
                    int measuredWidth2 = view.getMeasuredWidth() + i50;
                    int iMax8 = Math.max(i16, measuredWidth2);
                    int iCombineMeasuredStates2 = View.combineMeasuredStates(i15, view.getMeasuredState());
                    z13 = z13 && ((LinearLayout.LayoutParams) layoutParams3).width == -1;
                    if (((LinearLayout.LayoutParams) layoutParams3).weight > 0.0f) {
                        if (!z9) {
                            i50 = measuredWidth2;
                        }
                        iMax4 = Math.max(i19, i50);
                        iMax3 = i20;
                    } else {
                        if (!z9) {
                            i50 = measuredWidth2;
                        }
                        iMax3 = Math.max(i20, i50);
                        iMax4 = i19;
                    }
                    int iQ3 = q(view, i21) + i21;
                    i25 = iMax2;
                    f8 = f14;
                    i26 = iMax3;
                    i23 = iCombineMeasuredStates2;
                    iQ = iQ3;
                    i24 = iMax8;
                }
            }
            iQ++;
            mode2 = i18;
            virtualChildCount = i17;
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public int getBaseline() {
        int i7;
        if (this.f1513b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i8 = this.f1513b;
        if (childCount <= i8) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i8);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f1513b == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.f1514c;
        if (this.f1515d == 1 && (i7 = this.f1516e & 112) != 48) {
            if (i7 == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f1517f) / 2;
            } else if (i7 == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.f1517f;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((LayoutParams) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f1513b;
    }

    public Drawable getDividerDrawable() {
        return this.f1522k;
    }

    public int getDividerPadding() {
        return this.f1526o;
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public int getDividerWidth() {
        return this.f1523l;
    }

    @c.y
    public int getGravity() {
        return this.f1516e;
    }

    public int getOrientation() {
        return this.f1515d;
    }

    public int getShowDividers() {
        return this.f1525n;
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f1518g;
    }

    void h(Canvas canvas) {
        int right;
        int left;
        int i7;
        int virtualChildCount = getVirtualChildCount();
        boolean zB = r1.b(this);
        for (int i8 = 0; i8 < virtualChildCount; i8++) {
            View viewT = t(i8);
            if (viewT != null && viewT.getVisibility() != 8 && u(i8)) {
                LayoutParams layoutParams = (LayoutParams) viewT.getLayoutParams();
                k(canvas, zB ? viewT.getRight() + ((LinearLayout.LayoutParams) layoutParams).rightMargin : (viewT.getLeft() - ((LinearLayout.LayoutParams) layoutParams).leftMargin) - this.f1523l);
            }
        }
        if (u(virtualChildCount)) {
            View viewT2 = t(virtualChildCount - 1);
            if (viewT2 != null) {
                LayoutParams layoutParams2 = (LayoutParams) viewT2.getLayoutParams();
                if (zB) {
                    left = viewT2.getLeft() - ((LinearLayout.LayoutParams) layoutParams2).leftMargin;
                    i7 = this.f1523l;
                    right = left - i7;
                } else {
                    right = viewT2.getRight() + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                }
            } else if (zB) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i7 = this.f1523l;
                right = left - i7;
            }
            k(canvas, right);
        }
    }

    void i(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i7 = 0; i7 < virtualChildCount; i7++) {
            View viewT = t(i7);
            if (viewT != null && viewT.getVisibility() != 8 && u(i7)) {
                j(canvas, (viewT.getTop() - ((LinearLayout.LayoutParams) ((LayoutParams) viewT.getLayoutParams())).topMargin) - this.f1524m);
            }
        }
        if (u(virtualChildCount)) {
            View viewT2 = t(virtualChildCount - 1);
            j(canvas, viewT2 == null ? (getHeight() - getPaddingBottom()) - this.f1524m : viewT2.getBottom() + ((LinearLayout.LayoutParams) ((LayoutParams) viewT2.getLayoutParams())).bottomMargin);
        }
    }

    void j(Canvas canvas, int i7) {
        this.f1522k.setBounds(getPaddingLeft() + this.f1526o, i7, (getWidth() - getPaddingRight()) - this.f1526o, this.f1524m + i7);
        this.f1522k.draw(canvas);
    }

    void k(Canvas canvas, int i7) {
        this.f1522k.setBounds(i7, getPaddingTop() + this.f1526o, this.f1523l + i7, (getHeight() - getPaddingBottom()) - this.f1526o);
        this.f1522k.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        int i7 = this.f1515d;
        if (i7 == 0) {
            return new LayoutParams(-2, -2);
        }
        if (i7 == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f1522k == null) {
            return;
        }
        if (this.f1515d == 1) {
            i(canvas);
        } else {
            h(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(A);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(A);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        if (this.f1515d == 1) {
            y(i7, i8, i9, i10);
        } else {
            x(i7, i8, i9, i10);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i7, int i8) {
        if (this.f1515d == 1) {
            C(i7, i8);
        } else {
            A(i7, i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    int q(View view, int i7) {
        return 0;
    }

    int r(View view) {
        return 0;
    }

    int s(View view) {
        return 0;
    }

    public void setBaselineAligned(boolean z7) {
        this.f1512a = z7;
    }

    public void setBaselineAlignedChildIndex(int i7) {
        if (i7 >= 0 && i7 < getChildCount()) {
            this.f1513b = i7;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f1522k) {
            return;
        }
        this.f1522k = drawable;
        if (drawable != null) {
            this.f1523l = drawable.getIntrinsicWidth();
            this.f1524m = drawable.getIntrinsicHeight();
        } else {
            this.f1523l = 0;
            this.f1524m = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i7) {
        this.f1526o = i7;
    }

    public void setGravity(@c.y int i7) {
        if (this.f1516e != i7) {
            if ((8388615 & i7) == 0) {
                i7 |= androidx.core.view.n0.f6717b;
            }
            if ((i7 & 112) == 0) {
                i7 |= 48;
            }
            this.f1516e = i7;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i7) {
        int i8 = i7 & androidx.core.view.n0.f6719d;
        int i9 = this.f1516e;
        if ((8388615 & i9) != i8) {
            this.f1516e = i8 | ((-8388616) & i9);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z7) {
        this.f1519h = z7;
    }

    public void setOrientation(int i7) {
        if (this.f1515d != i7) {
            this.f1515d = i7;
            requestLayout();
        }
    }

    public void setShowDividers(int i7) {
        if (i7 != this.f1525n) {
            requestLayout();
        }
        this.f1525n = i7;
    }

    public void setVerticalGravity(int i7) {
        int i8 = i7 & 112;
        int i9 = this.f1516e;
        if ((i9 & 112) != i8) {
            this.f1516e = i8 | (i9 & org.chromium.net.v.f39676w2);
            requestLayout();
        }
    }

    public void setWeightSum(float f8) {
        this.f1518g = Math.max(0.0f, f8);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    View t(int i7) {
        return getChildAt(i7);
    }

    @c.x0({c.x0.a.LIBRARY})
    protected boolean u(int i7) {
        if (i7 == 0) {
            return (this.f1525n & 1) != 0;
        }
        if (i7 == getChildCount()) {
            return (this.f1525n & 4) != 0;
        }
        if ((this.f1525n & 2) == 0) {
            return false;
        }
        for (int i8 = i7 - 1; i8 >= 0; i8--) {
            if (getChildAt(i8).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    public boolean v() {
        return this.f1512a;
    }

    public boolean w() {
        return this.f1519h;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00af  */
    /* JADX WARN: Code duplicated, block: B:32:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:34:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:36:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:39:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:40:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:42:0x00df  */
    /* JADX WARN: Code duplicated, block: B:44:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ff  */
    void x(int i7, int i8, int i9, int i10) {
        int paddingLeft;
        int i11;
        int i12;
        boolean z7;
        int baseline;
        int i13;
        int i14;
        int measuredHeight;
        boolean zB = r1.b(this);
        int paddingTop = getPaddingTop();
        int i15 = i10 - i8;
        int paddingBottom = i15 - getPaddingBottom();
        int paddingBottom2 = (i15 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i16 = this.f1516e;
        int i17 = i16 & 112;
        boolean z8 = this.f1512a;
        int[] iArr = this.f1520i;
        int[] iArr2 = this.f1521j;
        int iD = androidx.core.view.n0.d(8388615 & i16, n2.Z(this));
        boolean z9 = true;
        if (iD != 1) {
            paddingLeft = iD != 5 ? getPaddingLeft() : ((getPaddingLeft() + i9) - i7) - this.f1517f;
        } else {
            paddingLeft = getPaddingLeft() + (((i9 - i7) - this.f1517f) / 2);
        }
        if (zB) {
            i11 = virtualChildCount - 1;
            i12 = -1;
        } else {
            i11 = 0;
            i12 = 1;
        }
        int iQ = 0;
        while (iQ < virtualChildCount) {
            int i18 = i11 + (i12 * iQ);
            View viewT = t(i18);
            if (viewT == null) {
                paddingLeft += B(i18);
                z7 = z9;
            } else {
                if (viewT.getVisibility() != 8) {
                    int measuredWidth = viewT.getMeasuredWidth();
                    int measuredHeight2 = viewT.getMeasuredHeight();
                    LayoutParams layoutParams = (LayoutParams) viewT.getLayoutParams();
                    int i19 = iQ;
                    if (z8) {
                        virtualChildCount = virtualChildCount;
                        baseline = ((LinearLayout.LayoutParams) layoutParams).height != -1 ? viewT.getBaseline() : -1;
                        i13 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                        if (i13 < 0) {
                            i13 = i17;
                        }
                        i14 = i13 & 112;
                        i17 = i17;
                        if (i14 != 16) {
                            if (i14 != 48) {
                                measuredHeight = ((LinearLayout.LayoutParams) layoutParams).topMargin + paddingTop;
                                if (baseline != -1) {
                                    z7 = true;
                                    measuredHeight += iArr[1] - baseline;
                                }
                            } else if (i14 != 80) {
                                measuredHeight = paddingTop;
                            } else {
                                measuredHeight = (paddingBottom - measuredHeight2) - ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                                if (baseline != -1) {
                                    measuredHeight -= iArr2[2] - (viewT.getMeasuredHeight() - baseline);
                                }
                            }
                            z7 = true;
                        } else {
                            z7 = true;
                            measuredHeight = ((((paddingBottom2 - measuredHeight2) / 2) + paddingTop) + ((LinearLayout.LayoutParams) layoutParams).topMargin) - ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                        }
                        if (u(i18)) {
                            paddingLeft += this.f1523l;
                        }
                        int i20 = ((LinearLayout.LayoutParams) layoutParams).leftMargin + paddingLeft;
                        paddingTop = paddingTop;
                        D(viewT, i20 + r(viewT), measuredHeight, measuredWidth, measuredHeight2);
                        int iS = i20 + measuredWidth + ((LinearLayout.LayoutParams) layoutParams).rightMargin + s(viewT);
                        iQ = i19 + q(viewT, i18);
                        paddingLeft = iS;
                    } else {
                        virtualChildCount = virtualChildCount;
                    }
                    i13 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                    if (i13 < 0) {
                        i13 = i17;
                    }
                    i14 = i13 & 112;
                    i17 = i17;
                    if (i14 != 16) {
                        if (i14 != 48) {
                            measuredHeight = ((LinearLayout.LayoutParams) layoutParams).topMargin + paddingTop;
                            if (baseline != -1) {
                                z7 = true;
                                measuredHeight += iArr[1] - baseline;
                            }
                        } else if (i14 != 80) {
                            measuredHeight = paddingTop;
                        } else {
                            measuredHeight = (paddingBottom - measuredHeight2) - ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                            if (baseline != -1) {
                                measuredHeight -= iArr2[2] - (viewT.getMeasuredHeight() - baseline);
                            }
                        }
                        z7 = true;
                    } else {
                        z7 = true;
                        measuredHeight = ((((paddingBottom2 - measuredHeight2) / 2) + paddingTop) + ((LinearLayout.LayoutParams) layoutParams).topMargin) - ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    }
                    if (u(i18)) {
                        paddingLeft += this.f1523l;
                    }
                    int i21 = ((LinearLayout.LayoutParams) layoutParams).leftMargin + paddingLeft;
                    paddingTop = paddingTop;
                    D(viewT, i21 + r(viewT), measuredHeight, measuredWidth, measuredHeight2);
                    int iS2 = i21 + measuredWidth + ((LinearLayout.LayoutParams) layoutParams).rightMargin + s(viewT);
                    iQ = i19 + q(viewT, i18);
                    paddingLeft = iS2;
                } else {
                    z7 = true;
                }
                iQ++;
                virtualChildCount = virtualChildCount;
                i17 = i17;
                z9 = z7;
                paddingTop = paddingTop;
            }
            iQ++;
            virtualChildCount = virtualChildCount;
            i17 = i17;
            z9 = z7;
            paddingTop = paddingTop;
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x009f  */
    void y(int i7, int i8, int i9, int i10) {
        int paddingTop;
        int i11;
        int i12;
        int i13;
        int i14;
        int paddingLeft = getPaddingLeft();
        int i15 = i9 - i7;
        int paddingRight = i15 - getPaddingRight();
        int paddingRight2 = (i15 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i16 = this.f1516e;
        int i17 = i16 & 112;
        int i18 = i16 & androidx.core.view.n0.f6719d;
        if (i17 != 16) {
            paddingTop = i17 != 80 ? getPaddingTop() : ((getPaddingTop() + i10) - i8) - this.f1517f;
        } else {
            paddingTop = getPaddingTop() + (((i10 - i8) - this.f1517f) / 2);
        }
        int iQ = 0;
        while (iQ < virtualChildCount) {
            View viewT = t(iQ);
            if (viewT == null) {
                paddingTop += B(iQ);
            } else {
                if (viewT.getVisibility() != 8) {
                    int measuredWidth = viewT.getMeasuredWidth();
                    int measuredHeight = viewT.getMeasuredHeight();
                    LayoutParams layoutParams = (LayoutParams) viewT.getLayoutParams();
                    int i19 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                    if (i19 < 0) {
                        i19 = i18;
                    }
                    int iD = androidx.core.view.n0.d(i19, n2.Z(this)) & 7;
                    if (iD != 1) {
                        if (iD != 5) {
                            i13 = ((LinearLayout.LayoutParams) layoutParams).leftMargin + paddingLeft;
                        } else {
                            i11 = paddingRight - measuredWidth;
                            i12 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                        }
                        int i20 = i13;
                        if (u(iQ)) {
                            paddingTop += this.f1524m;
                        }
                        int i21 = paddingTop + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                        D(viewT, i20, i21 + r(viewT), measuredWidth, measuredHeight);
                        int iS = i21 + measuredHeight + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + s(viewT);
                        iQ += q(viewT, iQ);
                        paddingTop = iS;
                        i14 = 1;
                    } else {
                        i11 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                        i12 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    }
                    i13 = i11 - i12;
                    int i22 = i13;
                    if (u(iQ)) {
                        paddingTop += this.f1524m;
                    }
                    int i23 = paddingTop + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    D(viewT, i22, i23 + r(viewT), measuredWidth, measuredHeight);
                    int iS2 = i23 + measuredHeight + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + s(viewT);
                    iQ += q(viewT, iQ);
                    paddingTop = iS2;
                    i14 = 1;
                }
                iQ += i14;
            }
            i14 = 1;
            iQ += i14;
        }
    }

    void z(View view, int i7, int i8, int i9, int i10, int i11) {
        measureChildWithMargins(view, i8, i9, i10, i11);
    }

    public LinearLayoutCompat(@c.m0 Context context, @c.o0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(@c.m0 Context context, @c.o0 AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f1512a = true;
        this.f1513b = -1;
        this.f1514c = 0;
        this.f1516e = BadgeDrawable.f16995r;
        h1 h1VarG = h1.G(context, attributeSet, R.styleable.LinearLayoutCompat, i7, 0);
        n2.z1(this, context, R.styleable.LinearLayoutCompat, attributeSet, h1VarG.B(), i7, 0);
        int iO = h1VarG.o(R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (iO >= 0) {
            setOrientation(iO);
        }
        int iO2 = h1VarG.o(R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (iO2 >= 0) {
            setGravity(iO2);
        }
        boolean zA = h1VarG.a(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!zA) {
            setBaselineAligned(zA);
        }
        this.f1518g = h1VarG.j(R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f1513b = h1VarG.o(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f1519h = h1VarG.a(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(h1VarG.h(R.styleable.LinearLayoutCompat_divider));
        this.f1525n = h1VarG.o(R.styleable.LinearLayoutCompat_showDividers, 0);
        this.f1526o = h1VarG.g(R.styleable.LinearLayoutCompat_dividerPadding, 0);
        h1VarG.I();
    }
}
