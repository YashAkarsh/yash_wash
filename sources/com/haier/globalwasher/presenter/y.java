package com.haier.globalwasher.presenter;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.haier.globalwasher.modle.bean.MessageBeen;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class y implements com.haier.globalwasher.mvp_api.presenter.b<com.haier.globalwasher.mvp_api.view.a> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f25405c = "bundle";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f25406d = "title";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f25407e = "url_file";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f25408f = "messageId";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f25409g = "request_code";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f25410h = "is_success";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Activity f25411b;

    class a extends com.haier.globalwasher.modle.network.a<BaseData<MessageBeen>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25412g;

        a(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25412g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25412g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData<MessageBeen> baseData) {
            this.f25412g.b(baseData);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.haier.globalwasher.mvp_api.presenter.b
    public void a(com.haier.globalwasher.mvp_api.view.a aVar) {
        if (aVar instanceof Activity) {
            this.f25411b = (Activity) aVar;
        } else if (aVar instanceof Fragment) {
            this.f25411b = ((Fragment) aVar).getActivity();
        }
    }

    public void b(String str, com.haier.globalwasher.mvp_api.moudle.b<BaseData<MessageBeen>> bVar) {
        HashMap map = new HashMap();
        map.put(f25408f, str + "");
        new a(bVar).j(1, this.f25411b, i2.a.R0, "message.queryAppMessageById", map, MessageBeen.class, 1);
    }
}
