package com.haier.globalwasher.base;

import android.widget.ListView;
import com.haier.globalwasher.mvp_api.moudle.BaseListDate;
import com.haier.globalwasher.view.custom_view.xlist.XListView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b<T> extends com.haier.globalwasher.base.a implements XListView.c {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private w2.a f24318m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private XListView f24319n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ListView f24320o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f24321p = 1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ArrayList<T> f24322q = new ArrayList<>();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f24323r = true;

    public abstract class a implements com.haier.globalwasher.mvp_api.moudle.b<BaseListDate<T>> {
        public a() {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
            b.this.M();
            if (b.this.f24319n == null) {
                b bVar = b.this;
                bVar.B(bVar.f24320o, b.this.f24315k);
            } else {
                b bVar2 = b.this;
                bVar2.B(bVar2.f24319n, b.this.f24315k);
            }
        }

        public abstract void f(ArrayList<T> arrayList);

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void b(BaseListDate<T> baseListDate) {
            b.this.M();
            b bVar = b.this;
            bVar.B(bVar.f24319n, -1);
            if (!"00000".equals(baseListDate.getRetCode()) || baseListDate.getData() == null) {
                if (b.this.f24319n == null) {
                    b bVar2 = b.this;
                    bVar2.B(bVar2.f24320o, b.this.f24314j);
                    return;
                } else {
                    b bVar3 = b.this;
                    bVar3.B(bVar3.f24319n, b.this.f24314j);
                    return;
                }
            }
            if (b.this.f24321p == 1) {
                b.this.f24322q.clear();
            }
            b.this.f24322q.addAll(baseListDate.getData());
            if (b.this.f24322q.size() <= 0) {
                if (b.this.f24319n == null) {
                    b bVar4 = b.this;
                    bVar4.B(bVar4.f24320o, b.this.f24314j);
                    return;
                } else {
                    b bVar5 = b.this;
                    bVar5.B(bVar5.f24319n, b.this.f24314j);
                    return;
                }
            }
            if (baseListDate.getData().size() <= 0 || baseListDate.getData().size() != 10) {
                if (b.this.f24323r && b.this.f24319n != null) {
                    b.this.f24319n.setPullLoadEnable(false);
                }
            } else if (b.this.f24323r && b.this.f24319n != null) {
                b.this.f24319n.setPullLoadEnable(true);
            }
            f(b.this.f24322q);
        }
    }

    public abstract com.haier.globalwasher.mvp_api.presenter.b J();

    public abstract ListView K();

    public void L(boolean z7) {
        this.f24323r = z7;
        XListView xListView = this.f24319n;
        if (xListView != null) {
            xListView.setPullRefreshEnable(z7);
            this.f24319n.setPullLoadEnable(z7);
        }
    }

    public void M() {
        XListView xListView = this.f24319n;
        if (xListView != null) {
            xListView.m();
            this.f24319n.n();
        }
    }

    public abstract void N(int i7, int i8);

    @Override // com.haier.globalwasher.base.a, com.haier.globalwasher.mvp_api.view.a
    public void a() {
        this.f24321p = 1;
        N(1, 1);
    }

    @Override // com.haier.globalwasher.base.a, com.haier.globalwasher.mvp_api.view.a
    public void d() {
        if (!(K() instanceof XListView)) {
            this.f24323r = false;
            this.f24320o = K();
            return;
        }
        XListView xListView = (XListView) K();
        this.f24319n = xListView;
        boolean z7 = this.f24323r;
        if (!z7) {
            xListView.setPullRefreshEnable(z7);
            this.f24319n.setPullLoadEnable(this.f24323r);
        } else {
            xListView.setXListViewListener(this);
            this.f24319n.setPullRefreshEnable(this.f24323r);
            this.f24319n.setPullLoadEnable(this.f24323r);
        }
    }

    @Override // com.haier.globalwasher.mvp_api.view.a
    public void e() {
        N(this.f24321p, 1);
    }

    @Override // com.haier.globalwasher.base.a, com.haier.globalwasher.mvp_api.view.a
    public com.haier.globalwasher.mvp_api.presenter.b f() {
        w2.a aVar = (w2.a) J();
        this.f24318m = aVar;
        return aVar;
    }

    @Override // com.haier.globalwasher.view.custom_view.xlist.XListView.c
    public void g() {
        this.f24321p = 1;
        N(1, 0);
    }

    @Override // com.haier.globalwasher.view.custom_view.xlist.XListView.c
    public void n() {
        int i7 = this.f24321p + 1;
        this.f24321p = i7;
        N(i7, 0);
    }
}
