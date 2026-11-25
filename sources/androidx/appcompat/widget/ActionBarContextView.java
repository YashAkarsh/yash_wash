package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.view.n2;
import androidx.core.view.n4;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
public class ActionBarContextView extends androidx.appcompat.widget.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private CharSequence f1298j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CharSequence f1299k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private View f1300l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private View f1301m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private View f1302n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private LinearLayout f1303o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private TextView f1304p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private TextView f1305q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f1306r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f1307s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f1308t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f1309u;

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ androidx.appcompat.view.b f1310a;

        a(androidx.appcompat.view.b bVar) {
            this.f1310a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f1310a.c();
        }
    }

    public ActionBarContextView(@c.m0 Context context) {
        this(context, null);
    }

    private void r() {
        if (this.f1303o == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f1303o = linearLayout;
            this.f1304p = (TextView) linearLayout.findViewById(R.id.action_bar_title);
            this.f1305q = (TextView) this.f1303o.findViewById(R.id.action_bar_subtitle);
            if (this.f1306r != 0) {
                this.f1304p.setTextAppearance(getContext(), this.f1306r);
            }
            if (this.f1307s != 0) {
                this.f1305q.setTextAppearance(getContext(), this.f1307s);
            }
        }
        this.f1304p.setText(this.f1298j);
        this.f1305q.setText(this.f1299k);
        boolean z7 = !TextUtils.isEmpty(this.f1298j);
        boolean z8 = !TextUtils.isEmpty(this.f1299k);
        int i7 = 0;
        this.f1305q.setVisibility(z8 ? 0 : 8);
        LinearLayout linearLayout2 = this.f1303o;
        if (!z7 && !z8) {
            i7 = 8;
        }
        linearLayout2.setVisibility(i7);
        if (this.f1303o.getParent() == null) {
            addView(this.f1303o);
        }
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ void c(int i7) {
        super.c(i7);
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ boolean d() {
        return super.d();
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ void e() {
        super.e();
    }

    @Override // androidx.appcompat.widget.a
    public boolean f() {
        ActionMenuPresenter actionMenuPresenter = this.f1702d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.F();
        }
        return false;
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ boolean g() {
        return super.g();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f1299k;
    }

    public CharSequence getTitle() {
        return this.f1298j;
    }

    @Override // androidx.appcompat.widget.a
    public boolean h() {
        ActionMenuPresenter actionMenuPresenter = this.f1702d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.I();
        }
        return false;
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ boolean i() {
        return super.i();
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ void m() {
        super.m();
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ n4 n(int i7, long j7) {
        return super.n(i7, j7);
    }

    @Override // androidx.appcompat.widget.a
    public boolean o() {
        ActionMenuPresenter actionMenuPresenter = this.f1702d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.R();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.f1702d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.F();
            this.f1702d.G();
        }
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        boolean zB = r1.b(this);
        int paddingRight = zB ? (i9 - i7) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i10 - i8) - getPaddingTop()) - getPaddingBottom();
        View view = this.f1300l;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1300l.getLayoutParams();
            int i11 = zB ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i12 = zB ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int iK = androidx.appcompat.widget.a.k(paddingRight, i11, zB);
            paddingRight = androidx.appcompat.widget.a.k(iK + l(this.f1300l, iK, paddingTop, paddingTop2, zB), i12, zB);
        }
        int iL = paddingRight;
        LinearLayout linearLayout = this.f1303o;
        if (linearLayout != null && this.f1302n == null && linearLayout.getVisibility() != 8) {
            iL += l(this.f1303o, iL, paddingTop, paddingTop2, zB);
        }
        int i13 = iL;
        View view2 = this.f1302n;
        if (view2 != null) {
            l(view2, i13, paddingTop, paddingTop2, zB);
        }
        int paddingLeft = zB ? getPaddingLeft() : (i9 - i7) - getPaddingRight();
        ActionMenuView actionMenuView = this.f1701c;
        if (actionMenuView != null) {
            l(actionMenuView, paddingLeft, paddingTop, paddingTop2, !zB);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i7, int i8) {
        if (View.MeasureSpec.getMode(i7) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i8) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i7);
        int size2 = this.f1703e;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i8);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingTop;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.f1300l;
        if (view != null) {
            int iJ = j(view, paddingLeft, iMakeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1300l.getLayoutParams();
            paddingLeft = iJ - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f1701c;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = j(this.f1701c, paddingLeft, iMakeMeasureSpec, 0);
        }
        LinearLayout linearLayout = this.f1303o;
        if (linearLayout != null && this.f1302n == null) {
            if (this.f1308t) {
                this.f1303o.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f1303o.getMeasuredWidth();
                boolean z7 = measuredWidth <= paddingLeft;
                if (z7) {
                    paddingLeft -= measuredWidth;
                }
                this.f1303o.setVisibility(z7 ? 0 : 8);
            } else {
                paddingLeft = j(linearLayout, paddingLeft, iMakeMeasureSpec, 0);
            }
        }
        View view2 = this.f1302n;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i9 = layoutParams.width;
            int i10 = i9 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i9 >= 0) {
                paddingLeft = Math.min(i9, paddingLeft);
            }
            int i11 = layoutParams.height;
            int i12 = i11 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i11 >= 0) {
                iMin = Math.min(i11, iMin);
            }
            this.f1302n.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i10), View.MeasureSpec.makeMeasureSpec(iMin, i12));
        }
        if (this.f1703e > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i13 = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            int measuredHeight = getChildAt(i14).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i13) {
                i13 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i13);
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void p() {
        if (this.f1300l == null) {
            t();
        }
    }

    public void q(androidx.appcompat.view.b bVar) {
        View view = this.f1300l;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.f1309u, (ViewGroup) this, false);
            this.f1300l = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.f1300l);
        }
        View viewFindViewById = this.f1300l.findViewById(R.id.action_mode_close_button);
        this.f1301m = viewFindViewById;
        viewFindViewById.setOnClickListener(new a(bVar));
        androidx.appcompat.view.menu.g gVar = (androidx.appcompat.view.menu.g) bVar.e();
        ActionMenuPresenter actionMenuPresenter = this.f1702d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.C();
        }
        ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(getContext());
        this.f1702d = actionMenuPresenter2;
        actionMenuPresenter2.P(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        gVar.c(this.f1702d, this.f1700b);
        ActionMenuView actionMenuView = (ActionMenuView) this.f1702d.n(this);
        this.f1701c = actionMenuView;
        n2.I1(actionMenuView, null);
        addView(this.f1701c, layoutParams);
    }

    public boolean s() {
        return this.f1308t;
    }

    @Override // androidx.appcompat.widget.a
    public void setContentHeight(int i7) {
        this.f1703e = i7;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f1302n;
        if (view2 != null) {
            removeView(view2);
        }
        this.f1302n = view;
        if (view != null && (linearLayout = this.f1303o) != null) {
            removeView(linearLayout);
            this.f1303o = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1299k = charSequence;
        r();
    }

    public void setTitle(CharSequence charSequence) {
        this.f1298j = charSequence;
        r();
        n2.E1(this, charSequence);
    }

    public void setTitleOptional(boolean z7) {
        if (z7 != this.f1308t) {
            requestLayout();
        }
        this.f1308t = z7;
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i7) {
        super.setVisibility(i7);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void t() {
        removeAllViews();
        this.f1302n = null;
        this.f1701c = null;
        this.f1702d = null;
        View view = this.f1301m;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    public ActionBarContextView(@c.m0 Context context, @c.o0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.actionModeStyle);
    }

    public ActionBarContextView(@c.m0 Context context, @c.o0 AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        h1 h1VarG = h1.G(context, attributeSet, R.styleable.ActionMode, i7, 0);
        n2.I1(this, h1VarG.h(R.styleable.ActionMode_background));
        this.f1306r = h1VarG.u(R.styleable.ActionMode_titleTextStyle, 0);
        this.f1307s = h1VarG.u(R.styleable.ActionMode_subtitleTextStyle, 0);
        this.f1703e = h1VarG.q(R.styleable.ActionMode_height, 0);
        this.f1309u = h1VarG.u(R.styleable.ActionMode_closeItemLayout, R.layout.abc_action_mode_close_item_material);
        h1VarG.I();
    }
}
