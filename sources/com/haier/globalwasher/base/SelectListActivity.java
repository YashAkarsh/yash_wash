package com.haier.globalwasher.base;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.o;
import androidx.viewpager.widget.ViewPager;
import com.haier.globalwasher.R;
import com.haier.globalwasher.modle.utils.n0;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.view.custom_view.NoSlidingViewPager;
import com.haier.globalwasher.view.custom_view.xlist.XListView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SelectListActivity extends BaseActivity {
    public static final int M = 1;
    public static final int N = 2;
    public ArrayList<com.haier.globalwasher.base.a> A;
    ArrayList<d> B;
    private Resources E;
    private HorizontalScrollView H;
    private int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    b f24294J;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private com.haier.globalwasher.mvp_api.presenter.b f24295u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public LinearLayout f24296v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public LinearLayout f24297w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public NoSlidingViewPager f24298x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private XListView f24299y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private com.haier.globalwasher.presenter.c f24300z = new com.haier.globalwasher.presenter.c();
    public ArrayList<Drawable> C = new ArrayList<>();
    public ArrayList<Drawable> D = new ArrayList<>();
    private final int F = 30;
    private String G = "SELECT_LIST";
    private int K = 0;
    private boolean L = false;

    class a implements ViewPager.i {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void h(int i7, float f8, int i8) {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void t(int i7) {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void u(int i7) {
            SelectListActivity selectListActivity = SelectListActivity.this;
            selectListActivity.l0(selectListActivity.B, i7);
            q.c(SelectListActivity.this.G, i7 + "==position");
        }
    }

    class b extends o {
        public b(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.viewpager.widget.a
        public int e() {
            return SelectListActivity.this.A.size();
        }

        @Override // androidx.fragment.app.o
        public Fragment v(int i7) {
            return SelectListActivity.this.A.get(i7);
        }
    }

    private class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f24303a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SelectListActivity selectListActivity = SelectListActivity.this;
            selectListActivity.l0(selectListActivity.B, this.f24303a);
        }

        private c(int i7) {
            this.f24303a = i7;
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public abstract void a();

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_select_list;
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    @TargetApi(23)
    public void d() {
        LinearLayout.LayoutParams layoutParams;
        this.E = getResources();
        this.I = n0.b(this);
        if (k0()) {
            this.C.addAll(p0());
            this.D.addAll(o0());
        }
        this.f24298x = (NoSlidingViewPager) findViewById(R.id.vp_fragment);
        this.f24296v = (LinearLayout) findViewById(R.id.lly_base_container);
        View viewInflate = View.inflate(this, R.layout.select_title_item_not_background, null);
        this.H = (HorizontalScrollView) viewInflate.findViewById(R.id.hsv);
        View viewFindViewById = viewInflate.findViewById(R.id.view_top);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.lly_top_select);
        this.f24297w = linearLayout;
        if (this.L) {
            linearLayout.setBackground(getResources().getDrawable(R.drawable.cardview_background));
            layoutParams = new LinearLayout.LayoutParams(n0.b(this), n0.c(this, 80));
        } else {
            layoutParams = new LinearLayout.LayoutParams(n0.b(this), n0.c(this, 50));
        }
        if (1 == j0()) {
            viewFindViewById.setVisibility(0);
            this.f24296v.addView(viewInflate, 0, layoutParams);
        } else {
            viewFindViewById.setVisibility(8);
            this.f24296v.addView(viewInflate, 1, layoutParams);
        }
        Q(this.f24298x, -1);
        ArrayList<d> arrayListI0 = i0();
        this.B = arrayListI0;
        if (arrayListI0 != null && arrayListI0.size() > 0) {
            ArrayList<com.haier.globalwasher.base.a> arrayListH0 = h0();
            this.A = arrayListH0;
            if (arrayListH0.size() > 0) {
                this.f24298x.setOffscreenPageLimit(this.A.size());
            }
        }
        b bVar = new b(getSupportFragmentManager());
        this.f24294J = bVar;
        this.f24298x.setAdapter(bVar);
        this.f24298x.c(new a());
        l0(this.B, 0);
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public com.haier.globalwasher.mvp_api.presenter.b f() {
        return this.f24300z;
    }

    public abstract ArrayList<com.haier.globalwasher.base.a> h0();

    public abstract ArrayList<d> i0();

    public abstract int j0();

    public abstract boolean k0();

    public void l0(ArrayList<d> arrayList, int i7) {
        b bVar;
        if (this.f24297w == null || arrayList == null) {
            return;
        }
        if (this.f24298x != null && (bVar = this.f24294J) != null && bVar.e() > i7) {
            this.f24298x.setCurrentItem(i7);
        }
        this.B = arrayList;
        this.f24297w.removeAllViews();
        int i8 = 0;
        LinearLayout.LayoutParams layoutParams = null;
        while (i8 < arrayList.size()) {
            View viewInflate = View.inflate(this, R.layout.adapter_base_view, null);
            viewInflate.findViewById(R.id.v_padding).setVisibility(8);
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.lly_margin);
            View viewInflate2 = View.inflate(this, R.layout.select, null);
            TextView textView = (TextView) viewInflate2.findViewById(R.id.tv_name);
            int i9 = this.K;
            if (i9 != 0) {
                textView.setTextSize(i9 / 2);
            }
            textView.setTextColor(this.E.getColor(R.color.first_page_bottom_text_false));
            if (k0()) {
                if (i8 == i7) {
                    if (this.L) {
                        linearLayout.setBackground(getResources().getDrawable(R.drawable.first_laundry_item_select));
                    }
                    textView.setTextColor(this.E.getColor(R.color.first_page_bottom_text_true));
                    if (this.C.size() > i8) {
                        this.C.get(i8).setBounds(0, 0, this.C.get(i8).getMinimumWidth(), this.C.get(i8).getMinimumHeight());
                        textView.setCompoundDrawables(null, this.C.get(i8), null, null);
                    }
                } else {
                    if (this.L) {
                        linearLayout.setBackground(null);
                    }
                    textView.setTextColor(this.E.getColor(R.color.first_page_bottom_text_false));
                    if (this.D.size() > i8) {
                        this.D.get(i8).setBounds(0, 0, this.D.get(i8).getMinimumWidth(), this.D.get(i8).getMinimumHeight());
                        textView.setCompoundDrawables(null, this.D.get(i8), null, null);
                    }
                }
            }
            textView.setText(arrayList.get(i8).a());
            viewInflate2.setOnClickListener(new c(i8));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            if (arrayList.size() <= 4) {
                layoutParams2.weight = 1.0f;
                layoutParams2.width = n0.b(this) / arrayList.size();
            } else {
                layoutParams2.width = n0.b(this) / 4;
            }
            layoutParams2.gravity = 1;
            if (this.L) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -1);
                if (arrayList.size() == 1) {
                    layoutParams3.width = (n0.b(this) - 30) / 2;
                    layoutParams3.height -= 12;
                } else if (arrayList.size() <= 4) {
                    layoutParams3.width = (n0.b(this) - 30) / arrayList.size();
                    layoutParams3.height -= 12;
                } else {
                    layoutParams3.width = n0.b(this) / 4;
                    layoutParams3.height -= 12;
                }
                linearLayout.addView(viewInflate2, layoutParams3);
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams4.setMargins(10, 0, 10, 12);
                linearLayout.setLayoutParams(layoutParams4);
                linearLayout.setGravity(17);
                this.f24297w.addView(viewInflate, layoutParams2);
            } else {
                this.f24297w.addView(viewInflate2, layoutParams2);
            }
            i8++;
            layoutParams = layoutParams2;
        }
        this.f24297w.getWidth();
        if (layoutParams != null) {
            int i10 = layoutParams.width;
            this.H.smoothScrollTo((i10 * i7) - ((this.I / 2) - (i10 / 2)), 0);
        }
    }

    public void m0(int i7) {
        if (this.f24298x == null || this.f24294J.e() <= i7) {
            return;
        }
        this.f24298x.setCurrentItem(i7);
        for (int i8 = 0; i8 < this.f24297w.getChildCount(); i8++) {
            View childAt = this.f24297w.getChildAt(i8);
            View viewFindViewById = childAt.findViewById(R.id.lly_margin);
            TextView textView = (TextView) childAt.findViewById(R.id.tv_name);
            if (k0()) {
                if (i8 == i7) {
                    if (this.L) {
                        viewFindViewById.setBackground(getResources().getDrawable(R.drawable.first_laundry_item_select));
                    }
                    textView.setTextColor(this.E.getColor(R.color.first_page_bottom_text_true));
                    if (this.C.size() > i8) {
                        this.C.get(i8).setBounds(0, 0, this.C.get(i8).getMinimumWidth(), this.C.get(i8).getMinimumHeight());
                        textView.setCompoundDrawables(null, this.C.get(i8), null, null);
                    }
                } else {
                    if (this.L) {
                        viewFindViewById.setBackground(null);
                    }
                    textView.setTextColor(this.E.getColor(R.color.first_page_bottom_text_false));
                    if (this.D.size() > i8) {
                        this.D.get(i8).setBounds(0, 0, this.D.get(i8).getMinimumWidth(), this.D.get(i8).getMinimumHeight());
                        textView.setCompoundDrawables(null, this.D.get(i8), null, null);
                    }
                }
            }
        }
    }

    public void n0(boolean z7) {
        this.L = z7;
    }

    public abstract ArrayList<Drawable> o0();

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.reload_btn) {
            e();
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ArrayList<com.haier.globalwasher.base.a> arrayList = this.A;
        if (arrayList != null) {
            arrayList.clear();
            this.A = null;
        }
        ArrayList<d> arrayList2 = this.B;
        if (arrayList2 != null) {
            arrayList2.clear();
            this.B = null;
        }
        ArrayList<Drawable> arrayList3 = this.D;
        if (arrayList3 != null) {
            arrayList3.clear();
            this.D = null;
        }
        ArrayList<Drawable> arrayList4 = this.C;
        if (arrayList4 != null) {
            arrayList4.clear();
            this.C = null;
        }
    }

    public abstract ArrayList<Drawable> p0();

    public void q0(int i7) {
        this.K = i7;
        ArrayList<d> arrayList = this.B;
        if (arrayList != null) {
            l0(arrayList, 0);
        }
    }
}
