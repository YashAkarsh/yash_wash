package com.haier.globalwasher.view.custom_view.xlist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.TextView;
import com.haier.globalwasher.R;
import kotlinx.coroutines.internal.b0;

/* JADX INFO: loaded from: classes2.dex */
public class XListView extends ListView implements AbsListView.OnScrollListener {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f25972q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int f25973r = 1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f25974s = 400;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final int f25975t = 50;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final float f25976u = 1.8f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f25977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Scroller f25978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AbsListView.OnScrollListener f25979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f25980d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private XListViewHeader f25981e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private RelativeLayout f25982f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextView f25983g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f25984h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f25985i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f25986j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private XListViewFooter f25987k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f25988l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f25989m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f25990n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f25991o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f25992p;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            XListView xListView = XListView.this;
            xListView.f25984h = xListView.f25982f.getHeight();
            XListView.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (XListView.this.f25986j || XListView.this.f25989m) {
                return;
            }
            XListView.this.k();
        }
    }

    public interface c {
        void g();

        void n();
    }

    public interface d extends AbsListView.OnScrollListener {
        void a(View view);
    }

    public XListView(Context context) {
        super(context);
        this.f25977a = -1.0f;
        this.f25985i = true;
        this.f25986j = false;
        this.f25990n = false;
        g(context);
    }

    private void g(Context context) {
        this.f25978b = new Scroller(context, new DecelerateInterpolator());
        super.setOnScrollListener(this);
        XListViewHeader xListViewHeader = new XListViewHeader(context);
        this.f25981e = xListViewHeader;
        this.f25982f = (RelativeLayout) xListViewHeader.findViewById(R.id.xlistview_header_content);
        TextView textView = (TextView) this.f25981e.findViewById(R.id.xlistview_header_time);
        this.f25983g = textView;
        textView.setVisibility(8);
        addHeaderView(this.f25981e);
        this.f25987k = new XListViewFooter(context);
        this.f25981e.getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    private void h() {
        AbsListView.OnScrollListener onScrollListener = this.f25979c;
        if (onScrollListener instanceof d) {
            ((d) onScrollListener).a(this);
        }
    }

    private void i() {
        int bottomMargin = this.f25987k.getBottomMargin();
        if (bottomMargin > 0) {
            this.f25992p = 1;
            this.f25978b.startScroll(0, bottomMargin, 0, -bottomMargin, f25974s);
            invalidate();
        }
    }

    private void j() {
        int i7;
        int visiableHeight = this.f25981e.getVisiableHeight();
        if (visiableHeight == 0) {
            return;
        }
        boolean z7 = this.f25986j;
        if (!z7 || visiableHeight > this.f25984h) {
            if (!z7 || visiableHeight <= (i7 = this.f25984h)) {
                i7 = 0;
            }
            this.f25992p = 0;
            this.f25978b.startScroll(0, visiableHeight, 0, i7 - visiableHeight, f25974s);
            invalidate();
        }
    }

    private void o(float f8) {
        int bottomMargin = this.f25987k.getBottomMargin() + ((int) f8);
        if (this.f25988l && !this.f25989m) {
            if (bottomMargin > 50) {
                this.f25987k.setState(1);
            } else {
                this.f25987k.setState(0);
            }
        }
        this.f25987k.setBottomMargin(bottomMargin);
    }

    private void p(float f8) {
        XListViewHeader xListViewHeader = this.f25981e;
        xListViewHeader.setVisiableHeight(((int) f8) + xListViewHeader.getVisiableHeight());
        if (!this.f25985i || this.f25986j) {
            return;
        }
        if (this.f25981e.getVisiableHeight() > this.f25984h) {
            this.f25981e.setState(1);
        } else {
            this.f25981e.setState(0);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f25978b.computeScrollOffset()) {
            if (this.f25992p == 0) {
                this.f25981e.setVisiableHeight(this.f25978b.getCurrY());
            } else {
                this.f25987k.setBottomMargin(this.f25978b.getCurrY());
            }
            postInvalidate();
            h();
        }
        super.computeScroll();
    }

    public void f() {
        this.f25977a = -1.0f;
        if (getFirstVisiblePosition() == 0) {
            if (this.f25985i && !this.f25986j) {
                this.f25986j = true;
                this.f25992p = 0;
                int i7 = this.f25984h;
                if (i7 == 0) {
                    this.f25982f.measure(View.MeasureSpec.makeMeasureSpec(((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(b0.f36945j, Integer.MIN_VALUE));
                    this.f25978b.startScroll(0, 0, 0, this.f25982f.getMeasuredHeight(), f25974s);
                    invalidate();
                } else {
                    this.f25978b.startScroll(0, 0, 0, i7, f25974s);
                    invalidate();
                }
                this.f25981e.setState(2);
                c cVar = this.f25980d;
                if (cVar != null) {
                    cVar.g();
                }
            }
            j();
        }
    }

    public void k() {
        this.f25989m = true;
        this.f25987k.setState(2);
        c cVar = this.f25980d;
        if (cVar != null) {
            cVar.n();
        }
    }

    public void l() {
        this.f25986j = true;
        this.f25981e.setState(2);
        c cVar = this.f25980d;
        if (cVar != null) {
            cVar.g();
        }
    }

    public void m() {
        if (this.f25989m) {
            this.f25989m = false;
            i();
            this.f25987k.setState(0);
        }
    }

    public void n() {
        if (this.f25986j) {
            this.f25986j = false;
            j();
            this.f25981e.setState(0);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i7, int i8, int i9) {
        this.f25991o = i9;
        AbsListView.OnScrollListener onScrollListener = this.f25979c;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i7, i8, i9);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i7) {
        AbsListView.OnScrollListener onScrollListener = this.f25979c;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i7);
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            if (!this.f25986j && !this.f25989m) {
                if (this.f25977a == -1.0f) {
                    this.f25977a = motionEvent.getRawY();
                }
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f25977a = motionEvent.getRawY();
                } else if (action != 2) {
                    this.f25977a = -1.0f;
                    if (getFirstVisiblePosition() == 0) {
                        if (this.f25985i && this.f25981e.getVisiableHeight() > this.f25984h) {
                            this.f25986j = true;
                            this.f25981e.setState(2);
                            c cVar = this.f25980d;
                            if (cVar != null) {
                                cVar.g();
                            }
                        }
                        j();
                    } else if (getLastVisiblePosition() == this.f25991o - 1) {
                        if (this.f25988l && this.f25987k.getBottomMargin() > 50 && !this.f25989m) {
                            k();
                        }
                        i();
                    }
                } else {
                    float rawY = motionEvent.getRawY() - this.f25977a;
                    this.f25977a = motionEvent.getRawY();
                    if (getFirstVisiblePosition() == 0 && (this.f25981e.getVisiableHeight() > 0 || rawY > 0.0f)) {
                        p(rawY / f25976u);
                        h();
                    } else if (getLastVisiblePosition() == this.f25991o - 1 && (this.f25987k.getBottomMargin() > 0 || rawY < 0.0f)) {
                        o((-rawY) / f25976u);
                    }
                }
                return super.onTouchEvent(motionEvent);
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public void setNoDataState(boolean z7) {
        if (z7) {
            this.f25987k.setState(3);
        }
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f25979c = onScrollListener;
    }

    public void setPullLoadEnable(boolean z7) {
        this.f25988l = z7;
        if (!z7) {
            this.f25987k.a();
            this.f25987k.setOnClickListener(null);
        } else {
            this.f25989m = false;
            this.f25987k.e();
            this.f25987k.setState(0);
            this.f25987k.setOnClickListener(new b());
        }
    }

    public void setPullRefreshEnable(boolean z7) {
        this.f25985i = z7;
        if (z7) {
            this.f25982f.setVisibility(0);
        } else {
            this.f25982f.setVisibility(4);
        }
    }

    public void setRefreshTime(String str) {
        this.f25983g.setVisibility(8);
        this.f25983g.setText(str);
    }

    public void setXListViewListener(c cVar) {
        this.f25980d = cVar;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (!this.f25990n) {
            this.f25990n = true;
            addFooterView(this.f25987k);
        }
        super.setAdapter(listAdapter);
    }

    public XListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25977a = -1.0f;
        this.f25985i = true;
        this.f25986j = false;
        this.f25990n = false;
        g(context);
    }

    public XListView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f25977a = -1.0f;
        this.f25985i = true;
        this.f25986j = false;
        this.f25990n = false;
        g(context);
    }
}
