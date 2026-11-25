package com.haier.globalwasher.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.haier.globalwasher.R;
import com.haier.globalwasher.modle.bean.TestBeen;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class j extends com.haier.globalwasher.mvp_api.adapter.a implements com.haier.globalwasher.mvp_api.adapter.d<TestBeen, com.haier.globalwasher.mvp_api.adapter.b> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f25824e;

    public j(Context context, List list, com.haier.globalwasher.mvp_api.adapter.d dVar) {
        super(context, list, dVar);
        this.f25824e = context;
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void i(Context context, int i7, com.haier.globalwasher.mvp_api.adapter.b bVar, TestBeen testBeen) {
        bVar.b(R.id.tv_1, R.id.tv_2);
        TextView textView = (TextView) bVar.a(R.id.tv_1);
        TextView textView2 = (TextView) bVar.a(R.id.tv_2);
        textView.setText(testBeen.getParam1());
        textView2.setText(testBeen.getParam2());
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public com.haier.globalwasher.mvp_api.adapter.b x(int i7, ViewGroup viewGroup) {
        return new com.haier.globalwasher.mvp_api.adapter.b(this.f25824e, LayoutInflater.from(this.f25824e).inflate(R.layout.textadapter, viewGroup, false), 1);
    }
}
