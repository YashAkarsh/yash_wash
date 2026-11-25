package com.haier.globalwasher.presenter;

import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.HelpPageBeen;
import com.haier.globalwasher.mvp_api.moudle.BaseListDate;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class d extends w2.a<BaseActivity> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BaseActivity f25101c;

    @Override // w2.a
    public BaseActivity f(BaseActivity baseActivity) {
        this.f25101c = baseActivity;
        return baseActivity;
    }

    public void g(com.haier.globalwasher.mvp_api.moudle.b<BaseListDate<HelpPageBeen>> bVar) {
        BaseListDate<HelpPageBeen> baseListDate = new BaseListDate<>();
        ArrayList<HelpPageBeen> arrayList = new ArrayList<>();
        arrayList.add(new HelpPageBeen("I will to eat foot of last hours!", 0));
        arrayList.add(new HelpPageBeen("You ask, I don't answer", 0));
        arrayList.add(new HelpPageBeen("Making a long entry can be folded so that I can test the multiline data of the entry text.", 0));
        arrayList.add(new HelpPageBeen("I don't know what to say！", 0));
        baseListDate.setRetCode("00000");
        baseListDate.setData(arrayList);
        bVar.b(baseListDate);
    }
}
