package com.haier.globalwasher.presenter;

import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.MessageBeen;
import com.haier.globalwasher.mvp_api.moudle.BaseListDate;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class f extends w2.a<com.haier.globalwasher.mvp_api.view.a> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f25138f = "1";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BaseActivity f25139c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f25140d = "type";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f25141e = "pageNumber";

    class a extends com.haier.globalwasher.modle.network.a<BaseListDate<MessageBeen>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25142g;

        a(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25142g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25142g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseListDate<MessageBeen> baseListDate) {
            this.f25142g.b(baseListDate);
        }
    }

    @Override // w2.a
    public BaseActivity f(BaseActivity baseActivity) {
        this.f25139c = baseActivity;
        return baseActivity;
    }

    public void g(int i7, int i8, String str, com.haier.globalwasher.mvp_api.moudle.b<BaseListDate<MessageBeen>> bVar) {
        HashMap map = new HashMap();
        map.put("pageNumber", i8 + "");
        map.put("type", str);
        new a(bVar).j(i7, this.f25139c, i2.a.P0, i2.a.Q0, map, MessageBeen.class, 2);
    }
}
