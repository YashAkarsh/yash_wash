package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f1566l = "ScrollingTabContainerView";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Interpolator f1567m = new DecelerateInterpolator();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f1568n = 200;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Runnable f1569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f1570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    LinearLayoutCompat f1571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Spinner f1572d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f1573e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f1574f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f1575g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f1576h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f1577i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected ViewPropertyAnimator f1578j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected final e f1579k;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f1580a;

        a(View view) {
            this.f1580a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ScrollingTabContainerView.this.smoothScrollTo(this.f1580a.getLeft() - ((ScrollingTabContainerView.this.getWidth() - this.f1580a.getWidth()) / 2), 0);
            ScrollingTabContainerView.this.f1569a = null;
        }
    }

    private class b extends BaseAdapter {
        b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ScrollingTabContainerView.this.f1571c.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i7) {
            return ((d) ScrollingTabContainerView.this.f1571c.getChildAt(i7)).b();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i7) {
            return i7;
        }

        @Override // android.widget.Adapter
        public View getView(int i7, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ScrollingTabContainerView.this.g((ActionBar.e) getItem(i7), true);
            }
            ((d) view).a((ActionBar.e) getItem(i7));
            return view;
        }
    }

    private class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((d) view).b().g();
            int childCount = ScrollingTabContainerView.this.f1571c.getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = ScrollingTabContainerView.this.f1571c.getChildAt(i7);
                childAt.setSelected(childAt == view);
            }
        }
    }

    private class d extends LinearLayout {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final String f1584g = "androidx.appcompat.app.ActionBar$Tab";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int[] f1585a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ActionBar.e f1586b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private TextView f1587c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ImageView f1588d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private View f1589e;

        public d(Context context, ActionBar.e eVar, boolean z7) {
            super(context, null, R.attr.actionBarTabStyle);
            int[] iArr = {android.R.attr.background};
            this.f1585a = iArr;
            this.f1586b = eVar;
            h1 h1VarG = h1.G(context, null, iArr, R.attr.actionBarTabStyle, 0);
            if (h1VarG.C(0)) {
                setBackgroundDrawable(h1VarG.h(0));
            }
            h1VarG.I();
            if (z7) {
                setGravity(8388627);
            }
            c();
        }

        public void a(ActionBar.e eVar) {
            this.f1586b = eVar;
            c();
        }

        public ActionBar.e b() {
            return this.f1586b;
        }

        public void c() {
            ActionBar.e eVar = this.f1586b;
            View viewB = eVar.b();
            if (viewB != null) {
                ViewParent parent = viewB.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewB);
                    }
                    addView(viewB);
                }
                this.f1589e = viewB;
                TextView textView = this.f1587c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f1588d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f1588d.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.f1589e;
            if (view != null) {
                removeView(view);
                this.f1589e = null;
            }
            Drawable drawableC = eVar.c();
            CharSequence charSequenceF = eVar.f();
            if (drawableC != null) {
                if (this.f1588d == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f1588d = appCompatImageView;
                }
                this.f1588d.setImageDrawable(drawableC);
                this.f1588d.setVisibility(0);
            } else {
                ImageView imageView2 = this.f1588d;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f1588d.setImageDrawable(null);
                }
            }
            boolean z7 = !TextUtils.isEmpty(charSequenceF);
            if (z7) {
                if (this.f1587c == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, R.attr.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f1587c = appCompatTextView;
                }
                this.f1587c.setText(charSequenceF);
                this.f1587c.setVisibility(0);
            } else {
                TextView textView2 = this.f1587c;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f1587c.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f1588d;
            if (imageView3 != null) {
                imageView3.setContentDescription(eVar.a());
            }
            l1.a(this, z7 ? null : eVar.a());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(f1584g);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(f1584g);
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i7, int i8) {
            super.onMeasure(i7, i8);
            if (ScrollingTabContainerView.this.f1574f > 0) {
                int measuredWidth = getMeasuredWidth();
                int i9 = ScrollingTabContainerView.this.f1574f;
                if (measuredWidth > i9) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i9, 1073741824), i8);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z7) {
            boolean z8 = isSelected() != z7;
            super.setSelected(z7);
            if (z8 && z7) {
                sendAccessibilityEvent(4);
            }
        }
    }

    protected class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1591a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1592b;

        protected e() {
        }

        public e a(ViewPropertyAnimator viewPropertyAnimator, int i7) {
            this.f1592b = i7;
            ScrollingTabContainerView.this.f1578j = viewPropertyAnimator;
            return this;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f1591a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f1591a) {
                return;
            }
            ScrollingTabContainerView scrollingTabContainerView = ScrollingTabContainerView.this;
            scrollingTabContainerView.f1578j = null;
            scrollingTabContainerView.setVisibility(this.f1592b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ScrollingTabContainerView.this.setVisibility(0);
            this.f1591a = false;
        }
    }

    public ScrollingTabContainerView(@c.m0 Context context) {
        super(context);
        this.f1579k = new e();
        setHorizontalScrollBarEnabled(false);
        androidx.appcompat.view.a aVarB = androidx.appcompat.view.a.b(context);
        setContentHeight(aVarB.f());
        this.f1575g = aVarB.e();
        LinearLayoutCompat linearLayoutCompatF = f();
        this.f1571c = linearLayoutCompatF;
        addView(linearLayoutCompatF, new ViewGroup.LayoutParams(-2, -1));
    }

    private Spinner e() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, R.attr.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    private LinearLayoutCompat f() {
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), null, R.attr.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        return linearLayoutCompat;
    }

    private boolean h() {
        Spinner spinner = this.f1572d;
        return spinner != null && spinner.getParent() == this;
    }

    private void i() {
        if (h()) {
            return;
        }
        if (this.f1572d == null) {
            this.f1572d = e();
        }
        removeView(this.f1571c);
        addView(this.f1572d, new ViewGroup.LayoutParams(-2, -1));
        if (this.f1572d.getAdapter() == null) {
            this.f1572d.setAdapter((SpinnerAdapter) new b());
        }
        Runnable runnable = this.f1569a;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f1569a = null;
        }
        this.f1572d.setSelection(this.f1577i);
    }

    private boolean j() {
        if (!h()) {
            return false;
        }
        removeView(this.f1572d);
        addView(this.f1571c, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f1572d.getSelectedItemPosition());
        return false;
    }

    public void a(ActionBar.e eVar, int i7, boolean z7) {
        d dVarG = g(eVar, false);
        this.f1571c.addView(dVarG, i7, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        Spinner spinner = this.f1572d;
        if (spinner != null) {
            ((b) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (z7) {
            dVarG.setSelected(true);
        }
        if (this.f1573e) {
            requestLayout();
        }
    }

    public void b(ActionBar.e eVar, boolean z7) {
        d dVarG = g(eVar, false);
        this.f1571c.addView(dVarG, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        Spinner spinner = this.f1572d;
        if (spinner != null) {
            ((b) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (z7) {
            dVarG.setSelected(true);
        }
        if (this.f1573e) {
            requestLayout();
        }
    }

    public void c(int i7) {
        View childAt = this.f1571c.getChildAt(i7);
        Runnable runnable = this.f1569a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        a aVar = new a(childAt);
        this.f1569a = aVar;
        post(aVar);
    }

    public void d(int i7) {
        ViewPropertyAnimator viewPropertyAnimator = this.f1578j;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
        if (i7 != 0) {
            ViewPropertyAnimator viewPropertyAnimatorAlpha = animate().alpha(0.0f);
            viewPropertyAnimatorAlpha.setDuration(200L);
            viewPropertyAnimatorAlpha.setInterpolator(f1567m);
            viewPropertyAnimatorAlpha.setListener(this.f1579k.a(viewPropertyAnimatorAlpha, i7));
            viewPropertyAnimatorAlpha.start();
            return;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        ViewPropertyAnimator viewPropertyAnimatorAlpha2 = animate().alpha(1.0f);
        viewPropertyAnimatorAlpha2.setDuration(200L);
        viewPropertyAnimatorAlpha2.setInterpolator(f1567m);
        viewPropertyAnimatorAlpha2.setListener(this.f1579k.a(viewPropertyAnimatorAlpha2, i7));
        viewPropertyAnimatorAlpha2.start();
    }

    d g(ActionBar.e eVar, boolean z7) {
        d dVar = new d(getContext(), eVar, z7);
        if (z7) {
            dVar.setBackgroundDrawable(null);
            dVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.f1576h));
        } else {
            dVar.setFocusable(true);
            if (this.f1570b == null) {
                this.f1570b = new c();
            }
            dVar.setOnClickListener(this.f1570b);
        }
        return dVar;
    }

    public void k() {
        this.f1571c.removeAllViews();
        Spinner spinner = this.f1572d;
        if (spinner != null) {
            ((b) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.f1573e) {
            requestLayout();
        }
    }

    public void l(int i7) {
        this.f1571c.removeViewAt(i7);
        Spinner spinner = this.f1572d;
        if (spinner != null) {
            ((b) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.f1573e) {
            requestLayout();
        }
    }

    public void m(int i7) {
        ((d) this.f1571c.getChildAt(i7)).c();
        Spinner spinner = this.f1572d;
        if (spinner != null) {
            ((b) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.f1573e) {
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f1569a;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.appcompat.view.a aVarB = androidx.appcompat.view.a.b(getContext());
        setContentHeight(aVarB.f());
        this.f1575g = aVarB.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f1569a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i7, long j7) {
        ((d) view).b().g();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i7, int i8) {
        int mode = View.MeasureSpec.getMode(i7);
        boolean z7 = mode == 1073741824;
        setFillViewport(z7);
        int childCount = this.f1571c.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f1574f = -1;
        } else {
            if (childCount > 2) {
                this.f1574f = (int) (View.MeasureSpec.getSize(i7) * 0.4f);
            } else {
                this.f1574f = View.MeasureSpec.getSize(i7) / 2;
            }
            this.f1574f = Math.min(this.f1574f, this.f1575g);
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f1576h, 1073741824);
        if (!z7 && this.f1573e) {
            this.f1571c.measure(0, iMakeMeasureSpec);
            if (this.f1571c.getMeasuredWidth() > View.MeasureSpec.getSize(i7)) {
                i();
            } else {
                j();
            }
        } else {
            j();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i7, iMakeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z7 || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.f1577i);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z7) {
        this.f1573e = z7;
    }

    public void setContentHeight(int i7) {
        this.f1576h = i7;
        requestLayout();
    }

    public void setTabSelected(int i7) {
        this.f1577i = i7;
        int childCount = this.f1571c.getChildCount();
        int i8 = 0;
        while (i8 < childCount) {
            View childAt = this.f1571c.getChildAt(i8);
            boolean z7 = i8 == i7;
            childAt.setSelected(z7);
            if (z7) {
                c(i7);
            }
            i8++;
        }
        Spinner spinner = this.f1572d;
        if (spinner == null || i7 < 0) {
            return;
        }
        spinner.setSelection(i7);
    }
}
