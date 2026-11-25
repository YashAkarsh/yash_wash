package com.haier.globalwasher.presenter;

import com.haier.globalwasher.modle.bean.TestBeen;
import com.haier.globalwasher.mvp_api.moudle.BaseListDate;

/* JADX INFO: loaded from: classes2.dex */
public class s implements com.haier.globalwasher.mvp_api.presenter.b<com.haier.globalwasher.mvp_api.view.a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.haier.globalwasher.mvp_api.view.a f25303b;

    class a extends com.haier.globalwasher.modle.network.a<BaseListDate<TestBeen>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25304g;

        a(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25304g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25304g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseListDate<TestBeen> baseListDate) {
            this.f25304g.b(baseListDate);
        }
    }

    @Override // com.haier.globalwasher.mvp_api.presenter.b
    public void a(com.haier.globalwasher.mvp_api.view.a aVar) {
        this.f25303b = aVar;
    }

    public void b(com.haier.globalwasher.mvp_api.moudle.b<BaseListDate<TestBeen>> bVar) {
        new a(bVar);
    }
}
