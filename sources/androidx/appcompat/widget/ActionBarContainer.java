package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.R;
import androidx.core.view.n2;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
public class ActionBarContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f1289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f1290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f1291d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Drawable f1292e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Drawable f1293f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Drawable f1294g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f1295h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f1296i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f1297j;

    @c.t0(21)
    private static class a {
        private a() {
        }

        public static void a(ActionBarContainer actionBarContainer) {
            actionBarContainer.invalidateOutline();
        }
    }

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    private int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f1292e;
        if (drawable != null && drawable.isStateful()) {
            this.f1292e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f1293f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f1293f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f1294g;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f1294g.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f1289b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1292e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f1293f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f1294g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1290c = findViewById(R.id.action_bar);
        this.f1291d = findViewById(R.id.action_context_bar);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f1288a || super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0048 A[PHI: r0
      0x0048: PHI (r0v8 boolean) = (r0v1 boolean), (r0v1 boolean), (r0v0 boolean) binds: [B:31:0x00a5, B:33:0x00a9, B:15:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        Drawable drawable;
        super.onLayout(z7, i7, i8, i9, i10);
        View view = this.f1289b;
        boolean z8 = true;
        boolean z9 = false;
        boolean z10 = (view == null || view.getVisibility() == 8) ? false : true;
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            int measuredHeight2 = measuredHeight - view.getMeasuredHeight();
            int i11 = layoutParams.bottomMargin;
            view.layout(i7, measuredHeight2 - i11, i9, measuredHeight - i11);
        }
        if (this.f1295h) {
            Drawable drawable2 = this.f1294g;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z8 = z9;
            }
        } else {
            if (this.f1292e != null) {
                if (this.f1290c.getVisibility() == 0) {
                    this.f1292e.setBounds(this.f1290c.getLeft(), this.f1290c.getTop(), this.f1290c.getRight(), this.f1290c.getBottom());
                } else {
                    View view2 = this.f1291d;
                    if (view2 == null || view2.getVisibility() != 0) {
                        this.f1292e.setBounds(0, 0, 0, 0);
                    } else {
                        this.f1292e.setBounds(this.f1291d.getLeft(), this.f1291d.getTop(), this.f1291d.getRight(), this.f1291d.getBottom());
                    }
                }
                z9 = true;
            }
            this.f1296i = z10;
            if (!z10 || (drawable = this.f1293f) == null) {
                z8 = z9;
            } else {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        if (z8) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i7, int i8) {
        int iA;
        int i9;
        if (this.f1290c == null && View.MeasureSpec.getMode(i8) == Integer.MIN_VALUE && (i9 = this.f1297j) >= 0) {
            i8 = View.MeasureSpec.makeMeasureSpec(Math.min(i9, View.MeasureSpec.getSize(i8)), Integer.MIN_VALUE);
        }
        super.onMeasure(i7, i8);
        if (this.f1290c == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i8);
        View view = this.f1289b;
        if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        if (b(this.f1290c)) {
            iA = !b(this.f1291d) ? a(this.f1291d) : 0;
        } else {
            iA = a(this.f1290c);
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min(iA + a(this.f1289b), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i8) : Integer.MAX_VALUE));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f1292e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f1292e);
        }
        this.f1292e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f1290c;
            if (view != null) {
                this.f1292e.setBounds(view.getLeft(), this.f1290c.getTop(), this.f1290c.getRight(), this.f1290c.getBottom());
            }
        }
        boolean z7 = true;
        if (!this.f1295h ? this.f1292e != null || this.f1293f != null : this.f1294g != null) {
            z7 = false;
        }
        setWillNotDraw(z7);
        invalidate();
        a.a(this);
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1294g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f1294g);
        }
        this.f1294g = drawable;
        boolean z7 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1295h && (drawable2 = this.f1294g) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f1295h ? !(this.f1292e != null || this.f1293f != null) : this.f1294g == null) {
            z7 = true;
        }
        setWillNotDraw(z7);
        invalidate();
        a.a(this);
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1293f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f1293f);
        }
        this.f1293f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1296i && (drawable2 = this.f1293f) != null) {
                drawable2.setBounds(this.f1289b.getLeft(), this.f1289b.getTop(), this.f1289b.getRight(), this.f1289b.getBottom());
            }
        }
        boolean z7 = true;
        if (!this.f1295h ? this.f1292e != null || this.f1293f != null : this.f1294g != null) {
            z7 = false;
        }
        setWillNotDraw(z7);
        invalidate();
        a.a(this);
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.f1289b;
        if (view != null) {
            removeView(view);
        }
        this.f1289b = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z7) {
        this.f1288a = z7;
        setDescendantFocusability(z7 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i7) {
        super.setVisibility(i7);
        boolean z7 = i7 == 0;
        Drawable drawable = this.f1292e;
        if (drawable != null) {
            drawable.setVisible(z7, false);
        }
        Drawable drawable2 = this.f1293f;
        if (drawable2 != null) {
            drawable2.setVisible(z7, false);
        }
        Drawable drawable3 = this.f1294g;
        if (drawable3 != null) {
            drawable3.setVisible(z7, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f1292e && !this.f1295h) || (drawable == this.f1293f && this.f1296i) || ((drawable == this.f1294g && this.f1295h) || super.verifyDrawable(drawable));
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        n2.I1(this, new b(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBar);
        this.f1292e = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ActionBar_background);
        this.f1293f = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundStacked);
        this.f1297j = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_height, -1);
        boolean z7 = true;
        if (getId() == R.id.split_action_bar) {
            this.f1295h = true;
            this.f1294g = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundSplit);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f1295h ? this.f1292e != null || this.f1293f != null : this.f1294g != null) {
            z7 = false;
        }
        setWillNotDraw(z7);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i7) {
        if (i7 != 0) {
            return super.startActionModeForChild(view, callback, i7);
        }
        return null;
    }
}
