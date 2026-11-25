package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.content.d;
import androidx.core.view.n2;
import c.l;
import c.m0;
import c.n;
import c.o0;
import c.u;

/* JADX INFO: loaded from: classes.dex */
public class PagerTabStrip extends PagerTitleStrip {
    private static final String I = "PagerTabStrip";

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static final int f11051J = 3;
    private static final int K = 6;
    private static final int L = 16;
    private static final int M = 32;
    private static final int N = 64;
    private static final int O = 1;
    private static final int P = 32;
    private int A;
    private boolean B;
    private boolean C;
    private int D;
    private boolean E;
    private float F;
    private float G;
    private int H;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f11052s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f11053t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f11054u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f11055v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f11056w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f11057x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Paint f11058y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Rect f11059z;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewPager viewPager = PagerTabStrip.this.f11066a;
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewPager viewPager = PagerTabStrip.this.f11066a;
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }
    }

    public PagerTabStrip(@m0 Context context) {
        this(context, null);
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    void c(int i7, float f8, boolean z7) {
        Rect rect = this.f11059z;
        int height = getHeight();
        int left = this.f11068c.getLeft() - this.f11057x;
        int right = this.f11068c.getRight() + this.f11057x;
        int i8 = height - this.f11053t;
        rect.set(left, i8, right, height);
        super.c(i7, f8, z7);
        this.A = (int) (Math.abs(f8 - 0.5f) * 2.0f * 255.0f);
        rect.union(this.f11068c.getLeft() - this.f11057x, i8, this.f11068c.getRight() + this.f11057x, height);
        invalidate(rect);
    }

    public boolean getDrawFullUnderline() {
        return this.B;
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    int getMinHeight() {
        return Math.max(super.getMinHeight(), this.f11056w);
    }

    @l
    public int getTabIndicatorColor() {
        return this.f11052s;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.f11068c.getLeft() - this.f11057x;
        int right = this.f11068c.getRight() + this.f11057x;
        int i7 = height - this.f11053t;
        this.f11058y.setColor((this.A << 24) | (this.f11052s & n2.f6742s));
        float f8 = height;
        canvas.drawRect(left, i7, right, f8, this.f11058y);
        if (this.B) {
            this.f11058y.setColor((this.f11052s & n2.f6742s) | n2.f6743t);
            canvas.drawRect(getPaddingLeft(), height - this.D, getWidth() - getPaddingRight(), f8, this.f11058y);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.E) {
            return false;
        }
        float x7 = motionEvent.getX();
        float y7 = motionEvent.getY();
        if (action == 0) {
            this.F = x7;
            this.G = y7;
            this.E = false;
        } else if (action != 1) {
            if (action == 2 && (Math.abs(x7 - this.F) > this.H || Math.abs(y7 - this.G) > this.H)) {
                this.E = true;
            }
        } else if (x7 < this.f11068c.getLeft() - this.f11057x) {
            ViewPager viewPager = this.f11066a;
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        } else if (x7 > this.f11068c.getRight() + this.f11057x) {
            ViewPager viewPager2 = this.f11066a;
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
        return true;
    }

    @Override // android.view.View
    public void setBackgroundColor(@l int i7) {
        super.setBackgroundColor(i7);
        if (this.C) {
            return;
        }
        this.B = (i7 & n2.f6743t) == 0;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.C) {
            return;
        }
        this.B = drawable == null;
    }

    @Override // android.view.View
    public void setBackgroundResource(@u int i7) {
        super.setBackgroundResource(i7);
        if (this.C) {
            return;
        }
        this.B = i7 == 0;
    }

    public void setDrawFullUnderline(boolean z7) {
        this.B = z7;
        this.C = true;
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int i7, int i8, int i9, int i10) {
        int i11 = this.f11054u;
        if (i10 < i11) {
            i10 = i11;
        }
        super.setPadding(i7, i8, i9, i10);
    }

    public void setTabIndicatorColor(@l int i7) {
        this.f11052s = i7;
        this.f11058y.setColor(i7);
        invalidate();
    }

    public void setTabIndicatorColorResource(@n int i7) {
        setTabIndicatorColor(d.f(getContext(), i7));
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void setTextSpacing(int i7) {
        int i8 = this.f11055v;
        if (i7 < i8) {
            i7 = i8;
        }
        super.setTextSpacing(i7);
    }

    public PagerTabStrip(@m0 Context context, @o0 AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f11058y = paint;
        this.f11059z = new Rect();
        this.A = 255;
        this.B = false;
        this.C = false;
        int i7 = this.f11079n;
        this.f11052s = i7;
        paint.setColor(i7);
        float f8 = context.getResources().getDisplayMetrics().density;
        this.f11053t = (int) ((3.0f * f8) + 0.5f);
        this.f11054u = (int) ((6.0f * f8) + 0.5f);
        this.f11055v = (int) (64.0f * f8);
        this.f11057x = (int) ((16.0f * f8) + 0.5f);
        this.D = (int) ((1.0f * f8) + 0.5f);
        this.f11056w = (int) ((f8 * 32.0f) + 0.5f);
        this.H = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.f11067b.setFocusable(true);
        this.f11067b.setOnClickListener(new a());
        this.f11069d.setFocusable(true);
        this.f11069d.setOnClickListener(new b());
        if (getBackground() == null) {
            this.B = true;
        }
    }
}
