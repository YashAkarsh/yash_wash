package w2;

import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.mvp_api.presenter.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T> implements b<com.haier.globalwasher.mvp_api.view.a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BaseActivity f40494b;

    @Override // com.haier.globalwasher.mvp_api.presenter.b
    public void a(com.haier.globalwasher.mvp_api.view.a aVar) {
        if (aVar instanceof com.haier.globalwasher.base.a) {
            this.f40494b = (BaseActivity) ((com.haier.globalwasher.base.a) aVar).getActivity();
        } else {
            this.f40494b = (BaseActivity) aVar;
        }
        f(this.f40494b);
    }

    public abstract BaseActivity f(BaseActivity baseActivity);
}
