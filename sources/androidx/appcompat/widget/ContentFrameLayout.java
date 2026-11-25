package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.n2;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY})
public class ContentFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TypedValue f1491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TypedValue f1492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TypedValue f1493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TypedValue f1494d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TypedValue f1495e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TypedValue f1496f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Rect f1497g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private a f1498h;

    public interface a {
        void a();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(@c.m0 Context context) {
        this(context, null);
    }

    @c.x0({c.x0.a.LIBRARY})
    public void a(Rect rect) {
        fitSystemWindows(rect);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f1495e == null) {
            this.f1495e = new TypedValue();
        }
        return this.f1495e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f1496f == null) {
            this.f1496f = new TypedValue();
        }
        return this.f1496f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f1493c == null) {
            this.f1493c = new TypedValue();
        }
        return this.f1493c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f1494d == null) {
            this.f1494d = new TypedValue();
        }
        return this.f1494d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f1491a == null) {
            this.f1491a = new TypedValue();
        }
        return this.f1491a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f1492b == null) {
            this.f1492b = new TypedValue();
        }
        return this.f1492b;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f1498h;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f1498h;
        if (aVar != null) {
            aVar.onDetachedFromWindow();
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004a  */
    /* JADX WARN: Code duplicated, block: B:22:0x0060  */
    /* JADX WARN: Code duplicated, block: B:37:0x0086  */
    /* JADX WARN: Code duplicated, block: B:54:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:56:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:57:0x00db  */
    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i7, int i8) {
        boolean z7;
        int i9;
        int i10;
        float fraction;
        int i11;
        int i12;
        float fraction2;
        int i13;
        int i14;
        float fraction3;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        boolean z8 = true;
        boolean z9 = displayMetrics.widthPixels < displayMetrics.heightPixels;
        int mode = View.MeasureSpec.getMode(i7);
        int mode2 = View.MeasureSpec.getMode(i8);
        if (mode != Integer.MIN_VALUE) {
            z7 = false;
        } else {
            TypedValue typedValue = z9 ? this.f1494d : this.f1493c;
            if (typedValue == null || (i13 = typedValue.type) == 0) {
                z7 = false;
            } else {
                if (i13 == 5) {
                    fraction3 = typedValue.getDimension(displayMetrics);
                } else {
                    if (i13 == 6) {
                        int i15 = displayMetrics.widthPixels;
                        fraction3 = typedValue.getFraction(i15, i15);
                    } else {
                        i14 = 0;
                    }
                    if (i14 > 0) {
                        Rect rect = this.f1497g;
                        i7 = View.MeasureSpec.makeMeasureSpec(Math.min(i14 - (rect.left + rect.right), View.MeasureSpec.getSize(i7)), 1073741824);
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                }
                i14 = (int) fraction3;
                if (i14 > 0) {
                    Rect rect2 = this.f1497g;
                    i7 = View.MeasureSpec.makeMeasureSpec(Math.min(i14 - (rect2.left + rect2.right), View.MeasureSpec.getSize(i7)), 1073741824);
                    z7 = true;
                } else {
                    z7 = false;
                }
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            TypedValue typedValue2 = z9 ? this.f1495e : this.f1496f;
            if (typedValue2 != null && (i11 = typedValue2.type) != 0) {
                if (i11 == 5) {
                    fraction2 = typedValue2.getDimension(displayMetrics);
                } else {
                    if (i11 == 6) {
                        int i16 = displayMetrics.heightPixels;
                        fraction2 = typedValue2.getFraction(i16, i16);
                    } else {
                        i12 = 0;
                    }
                    if (i12 > 0) {
                        Rect rect3 = this.f1497g;
                        i8 = View.MeasureSpec.makeMeasureSpec(Math.min(i12 - (rect3.top + rect3.bottom), View.MeasureSpec.getSize(i8)), 1073741824);
                    }
                }
                i12 = (int) fraction2;
                if (i12 > 0) {
                    Rect rect4 = this.f1497g;
                    i8 = View.MeasureSpec.makeMeasureSpec(Math.min(i12 - (rect4.top + rect4.bottom), View.MeasureSpec.getSize(i8)), 1073741824);
                }
            }
        }
        super.onMeasure(i7, i8);
        int measuredWidth = getMeasuredWidth();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        if (z7 || mode != Integer.MIN_VALUE) {
            z8 = false;
        } else {
            TypedValue typedValue3 = z9 ? this.f1492b : this.f1491a;
            if (typedValue3 == null || (i9 = typedValue3.type) == 0) {
                z8 = false;
            } else {
                if (i9 == 5) {
                    fraction = typedValue3.getDimension(displayMetrics);
                } else {
                    if (i9 == 6) {
                        int i17 = displayMetrics.widthPixels;
                        fraction = typedValue3.getFraction(i17, i17);
                    } else {
                        i10 = 0;
                    }
                    if (i10 > 0) {
                        Rect rect5 = this.f1497g;
                        i10 -= rect5.left + rect5.right;
                    }
                    if (measuredWidth < i10) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i10, 1073741824);
                    } else {
                        z8 = false;
                    }
                }
                i10 = (int) fraction;
                if (i10 > 0) {
                    Rect rect6 = this.f1497g;
                    i10 -= rect6.left + rect6.right;
                }
                if (measuredWidth < i10) {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i10, 1073741824);
                } else {
                    z8 = false;
                }
            }
        }
        if (z8) {
            super.onMeasure(iMakeMeasureSpec, i8);
        }
    }

    public void setAttachListener(a aVar) {
        this.f1498h = aVar;
    }

    @c.x0({c.x0.a.LIBRARY})
    public void setDecorPadding(int i7, int i8, int i9, int i10) {
        this.f1497g.set(i7, i8, i9, i10);
        if (n2.U0(this)) {
            requestLayout();
        }
    }

    public ContentFrameLayout(@c.m0 Context context, @c.o0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(@c.m0 Context context, @c.o0 AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f1497g = new Rect();
    }
}
