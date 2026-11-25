package com.haier.globalwasher.view.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.TestBeen;
import com.haier.globalwasher.presenter.s;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class c extends com.haier.globalwasher.base.a implements com.haier.globalwasher.mvp_api.adapter.d<TestBeen, a> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private com.haier.globalwasher.mvp_api.adapter.a<TestBeen, a> f26121m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private s f26122n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private BaseActivity f26123o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    ArrayList f26124p;

    class a extends com.haier.globalwasher.mvp_api.adapter.e {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TextView f26125f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final TextView f26126g;

        public a(View view) {
            super(c.this.f26123o, view, 1);
            this.f26125f = (TextView) view.findViewById(R.id.tv_1);
            this.f26126g = (TextView) view.findViewById(R.id.tv_2);
        }
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public void i(Context context, int i7, a aVar, TestBeen testBeen) {
        aVar.f26125f.setText(testBeen.getParam1());
        aVar.f26126g.setText(testBeen.getParam2());
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public a x(int i7, ViewGroup viewGroup) {
        return new a(LayoutInflater.from(getActivity()).inflate(R.layout.textadapter, viewGroup, false));
    }

    @Override // com.haier.globalwasher.base.a, com.haier.globalwasher.mvp_api.view.a
    public void a() {
        ListView listView = (ListView) findViewById(R.id.lv_);
        ArrayList arrayList = new ArrayList();
        this.f26124p = arrayList;
        arrayList.add(new TestBeen("姓名", "张三"));
        this.f26124p.add(new TestBeen("姓名", "李四"));
        this.f26124p.add(new TestBeen("姓名", "王五"));
        this.f26124p.add(new TestBeen("姓名", "马六"));
        this.f26124p.add(new TestBeen("姓名", "刘七"));
        this.f26124p.add(new TestBeen("姓名", "拐八"));
        com.haier.globalwasher.mvp_api.adapter.a<TestBeen, a> aVar = this.f26121m;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
            return;
        }
        com.haier.globalwasher.mvp_api.adapter.a<TestBeen, a> aVar2 = new com.haier.globalwasher.mvp_api.adapter.a<>(this.f26123o, this.f26124p, this);
        this.f26121m = aVar2;
        listView.setAdapter((ListAdapter) aVar2);
    }

    @Override // com.haier.globalwasher.base.a, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.fragment_test;
    }

    @Override // com.haier.globalwasher.base.a, com.haier.globalwasher.mvp_api.view.a
    public void d() {
        BaseActivity baseActivity = (BaseActivity) getActivity();
        this.f26123o = baseActivity;
        baseActivity.d0("测试fragment", 0, new View[0]);
        B(null, -1);
    }

    @Override // com.haier.globalwasher.mvp_api.view.a
    public void e() {
    }

    @Override // com.haier.globalwasher.base.a, com.haier.globalwasher.mvp_api.view.a
    public com.haier.globalwasher.mvp_api.presenter.b f() {
        s sVar = new s();
        this.f26122n = sVar;
        return sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
