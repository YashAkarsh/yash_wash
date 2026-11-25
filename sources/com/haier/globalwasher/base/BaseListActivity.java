package com.haier.globalwasher.base;

import android.widget.ListView;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.mvp_api.moudle.BaseListDate;
import com.haier.globalwasher.view.custom_view.xlist.XListView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseListActivity<T> extends BaseActivity implements XListView.c {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private w2.a f24287u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private XListView f24288v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private ListView f24289w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f24290x = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private ArrayList<T> f24291y = new ArrayList<>();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f24292z = true;
    String A = "ThisDataLinsenter";

    public abstract class a implements com.haier.globalwasher.mvp_api.moudle.b<BaseListDate<T>> {
        public a() {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
            BaseListActivity.this.o0();
            if (BaseListActivity.this.f24288v == null) {
                BaseListActivity baseListActivity = BaseListActivity.this;
                baseListActivity.Q(baseListActivity.f24289w, BaseListActivity.this.f24281s);
            } else {
                BaseListActivity baseListActivity2 = BaseListActivity.this;
                baseListActivity2.Q(baseListActivity2.f24288v, BaseListActivity.this.f24281s);
            }
        }

        public abstract void f(ArrayList<T> arrayList);

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void b(BaseListDate<T> baseListDate) {
            BaseListActivity.this.o0();
            BaseListActivity baseListActivity = BaseListActivity.this;
            baseListActivity.Q(baseListActivity.f24288v, -1);
            if (!"00000".equals(baseListDate.getRetCode()) || baseListDate.getData() == null) {
                if (BaseListActivity.this.f24288v == null) {
                    BaseListActivity baseListActivity2 = BaseListActivity.this;
                    baseListActivity2.Q(baseListActivity2.f24289w, BaseListActivity.this.f24280r);
                    return;
                } else {
                    BaseListActivity baseListActivity3 = BaseListActivity.this;
                    baseListActivity3.Q(baseListActivity3.f24288v, BaseListActivity.this.f24280r);
                    return;
                }
            }
            if (BaseListActivity.this.f24290x == 1) {
                BaseListActivity.this.f24291y.clear();
            }
            BaseListActivity.this.f24291y.addAll(baseListDate.getData());
            if (BaseListActivity.this.f24291y.size() <= 0) {
                if (BaseListActivity.this.f24288v == null) {
                    BaseListActivity baseListActivity4 = BaseListActivity.this;
                    baseListActivity4.Q(baseListActivity4.f24289w, BaseListActivity.this.f24280r);
                    return;
                } else {
                    BaseListActivity baseListActivity5 = BaseListActivity.this;
                    baseListActivity5.Q(baseListActivity5.f24288v, BaseListActivity.this.f24280r);
                    return;
                }
            }
            if (baseListDate.getData().size() <= 0 || baseListDate.getData().size() != 10) {
                if (BaseListActivity.this.f24292z && BaseListActivity.this.f24288v != null) {
                    BaseListActivity.this.f24288v.setPullLoadEnable(false);
                }
            } else if (BaseListActivity.this.f24292z && BaseListActivity.this.f24288v != null) {
                BaseListActivity.this.f24288v.setPullLoadEnable(true);
            }
            q.c(BaseListActivity.this.A, "arrayList.size=" + BaseListActivity.this.f24291y.size());
            f(BaseListActivity.this.f24291y);
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void a() {
        this.f24290x = 1;
        p0(1, 1);
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void d() {
        ListView listViewM0 = m0();
        this.f24289w = listViewM0;
        if (listViewM0 == null) {
            return;
        }
        if (!(listViewM0 instanceof XListView)) {
            this.f24292z = false;
            return;
        }
        XListView xListView = (XListView) listViewM0;
        this.f24288v = xListView;
        boolean z7 = this.f24292z;
        if (!z7) {
            xListView.setPullRefreshEnable(z7);
            this.f24288v.setPullLoadEnable(this.f24292z);
        } else {
            xListView.setXListViewListener(this);
            this.f24288v.setPullRefreshEnable(this.f24292z);
            this.f24288v.setPullLoadEnable(this.f24292z);
        }
    }

    @Override // com.haier.globalwasher.mvp_api.view.a
    public void e() {
        this.f24290x = 1;
        p0(1, 1);
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public com.haier.globalwasher.mvp_api.presenter.b f() {
        w2.a aVar = (w2.a) l0();
        this.f24287u = aVar;
        return aVar;
    }

    @Override // com.haier.globalwasher.view.custom_view.xlist.XListView.c
    public void g() {
        this.f24290x = 1;
        p0(1, 0);
    }

    public abstract com.haier.globalwasher.mvp_api.presenter.b l0();

    public abstract ListView m0();

    @Override // com.haier.globalwasher.view.custom_view.xlist.XListView.c
    public void n() {
        int i7 = this.f24290x + 1;
        this.f24290x = i7;
        p0(i7, 0);
    }

    public void n0(boolean z7) {
        this.f24292z = z7;
        XListView xListView = this.f24288v;
        if (xListView != null) {
            xListView.setPullRefreshEnable(z7);
            this.f24288v.setPullLoadEnable(z7);
        }
    }

    public void o0() {
        XListView xListView = this.f24288v;
        if (xListView != null) {
            xListView.m();
            this.f24288v.n();
        }
    }

    public abstract void p0(int i7, int i8);
}
