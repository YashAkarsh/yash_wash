package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.view.n2;
import androidx.core.view.w5;
import androidx.fragment.R;
import androidx.test.internal.runner.listener.InstrumentationResultPrinter;
import c.m0;
import c.o0;
import c.t0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<View> f7790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<View> f7791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View.OnApplyWindowInsetsListener f7792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f7793d;

    public FragmentContainerView(@m0 Context context) {
        super(context);
        this.f7793d = true;
    }

    private void a(@m0 View view) {
        ArrayList<View> arrayList = this.f7791b;
        if (arrayList == null || !arrayList.contains(view)) {
            return;
        }
        if (this.f7790a == null) {
            this.f7790a = new ArrayList<>();
        }
        this.f7790a.add(view);
    }

    @Override // android.view.ViewGroup
    public void addView(@m0 View view, int i7, @o0 ViewGroup.LayoutParams layoutParams) {
        if (FragmentManager.N0(view) != null) {
            super.addView(view, i7, layoutParams);
            return;
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup
    protected boolean addViewInLayout(@m0 View view, int i7, @o0 ViewGroup.LayoutParams layoutParams, boolean z7) {
        if (FragmentManager.N0(view) != null) {
            return super.addViewInLayout(view, i7, layoutParams, z7);
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup, android.view.View
    @t0(20)
    @m0
    public WindowInsets dispatchApplyWindowInsets(@m0 WindowInsets windowInsets) {
        w5 w5VarK = w5.K(windowInsets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f7792c;
        w5 w5VarK2 = onApplyWindowInsetsListener != null ? w5.K(onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets)) : n2.g1(this, w5VarK);
        if (!w5VarK2.A()) {
            int childCount = getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                n2.p(getChildAt(i7), w5VarK2);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@m0 Canvas canvas) {
        if (this.f7793d && this.f7790a != null) {
            for (int i7 = 0; i7 < this.f7790a.size(); i7++) {
                super.drawChild(canvas, this.f7790a.get(i7), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(@m0 Canvas canvas, @m0 View view, long j7) {
        ArrayList<View> arrayList;
        if (!this.f7793d || (arrayList = this.f7790a) == null || arrayList.size() <= 0 || !this.f7790a.contains(view)) {
            return super.drawChild(canvas, view, j7);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(@m0 View view) {
        ArrayList<View> arrayList = this.f7791b;
        if (arrayList != null) {
            arrayList.remove(view);
            ArrayList<View> arrayList2 = this.f7790a;
            if (arrayList2 != null && arrayList2.remove(view)) {
                this.f7793d = true;
            }
        }
        super.endViewTransition(view);
    }

    @Override // android.view.View
    @t0(20)
    @m0
    public WindowInsets onApplyWindowInsets(@m0 WindowInsets windowInsets) {
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            a(getChildAt(childCount));
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(@m0 View view, boolean z7) {
        if (z7) {
            a(view);
        }
        super.removeDetachedView(view, z7);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(@m0 View view) {
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i7) {
        a(getChildAt(i7));
        super.removeViewAt(i7);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(@m0 View view) {
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i7, int i8) {
        for (int i9 = i7; i9 < i7 + i8; i9++) {
            a(getChildAt(i9));
        }
        super.removeViews(i7, i8);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i7, int i8) {
        for (int i9 = i7; i9 < i7 + i8; i9++) {
            a(getChildAt(i9));
        }
        super.removeViewsInLayout(i7, i8);
    }

    void setDrawDisappearingViewsLast(boolean z7) {
        this.f7793d = z7;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(@o0 LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(@m0 View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.f7792c = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(@m0 View view) {
        if (view.getParent() == this) {
            if (this.f7791b == null) {
                this.f7791b = new ArrayList<>();
            }
            this.f7791b.add(view);
        }
        super.startViewTransition(view);
    }

    public FragmentContainerView(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FragmentContainerView(@m0 Context context, @o0 AttributeSet attributeSet, int i7) {
        String str;
        super(context, attributeSet, i7);
        this.f7793d = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FragmentContainerView);
            if (classAttribute == null) {
                classAttribute = typedArrayObtainStyledAttributes.getString(R.styleable.FragmentContainerView_android_name);
                str = "android:name";
            } else {
                str = InstrumentationResultPrinter.f10179m;
            }
            typedArrayObtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + "\"");
        }
    }

    FragmentContainerView(@m0 Context context, @m0 AttributeSet attributeSet, @m0 FragmentManager fragmentManager) {
        String str;
        super(context, attributeSet);
        this.f7793d = true;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FragmentContainerView);
        classAttribute = classAttribute == null ? typedArrayObtainStyledAttributes.getString(R.styleable.FragmentContainerView_android_name) : classAttribute;
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.FragmentContainerView_android_tag);
        typedArrayObtainStyledAttributes.recycle();
        int id = getId();
        Fragment fragmentP0 = fragmentManager.p0(id);
        if (classAttribute != null && fragmentP0 == null) {
            if (id <= 0) {
                if (string != null) {
                    str = " with tag " + string;
                } else {
                    str = "";
                }
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
            }
            Fragment fragmentA = fragmentManager.E0().a(context.getClassLoader(), classAttribute);
            fragmentA.onInflate(context, attributeSet, (Bundle) null);
            fragmentManager.r().R(true).k(this, fragmentA, string).u();
        }
        fragmentManager.i1(this);
    }
}
