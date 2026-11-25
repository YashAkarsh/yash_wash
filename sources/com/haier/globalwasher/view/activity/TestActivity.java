package com.haier.globalwasher.view.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import c.t0;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.TestBeen;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.mvp_api.adapter.b;
import com.haier.globalwasher.mvp_api.adapter.d;
import com.haier.globalwasher.mvp_api.moudle.BaseListDate;
import com.haier.globalwasher.presenter.s;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class TestActivity extends BaseActivity implements d<TestBeen, b> {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private com.haier.globalwasher.mvp_api.adapter.a<TestBeen, b> f25458u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private s f25459v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final String f25460w = "TestActivity";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    ListView f25461x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    ArrayList<TestBeen> f25462y;

    class a implements com.haier.globalwasher.mvp_api.moudle.b<BaseListDate<TestBeen>> {
        a() {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
            q.c("TestActivity", exc.toString());
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseListDate<TestBeen> baseListDate) {
        }
    }

    public static final byte[] i0(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[100];
        while (true) {
            int i7 = inputStream.read(bArr, 0, 100);
            if (i7 <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i7);
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void a() {
        this.f25459v.b(new a());
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_test;
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void d() {
        d0(getResources().getString(R.string.test_activity_name), 0, new View[0]);
        this.f25461x = (ListView) findViewById(R.id.lv_);
        com.haier.globalwasher.mvp_api.adapter.a<TestBeen, b> aVar = this.f25458u;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
            return;
        }
        this.f25462y = new ArrayList<>();
        for (int i7 = 0; i7 < 50; i7++) {
            this.f25462y.add(new TestBeen("姓名", i7 + "张三"));
        }
        com.haier.globalwasher.mvp_api.adapter.a<TestBeen, b> aVar2 = new com.haier.globalwasher.mvp_api.adapter.a<>(this, this.f25462y, this);
        this.f25458u = aVar2;
        this.f25461x.setAdapter((ListAdapter) aVar2);
    }

    @Override // com.haier.globalwasher.mvp_api.view.a
    public void e() {
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public com.haier.globalwasher.mvp_api.presenter.b f() {
        s sVar = new s();
        this.f25459v = sVar;
        return sVar;
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    @t0(api = 21)
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public void i(Context context, int i7, b bVar, TestBeen testBeen) {
        bVar.b(R.id.tv_1, R.id.tv_2, R.id.lly_margin);
        LinearLayout linearLayout = (LinearLayout) bVar.a(R.id.lly_margin);
        linearLayout.setTranslationZ(8.0f);
        linearLayout.setElevation(8.0f);
        TextView textView = (TextView) bVar.a(R.id.tv_1);
        TextView textView2 = (TextView) bVar.a(R.id.tv_2);
        textView.setText(testBeen.getParam1());
        textView2.setText(testBeen.getParam2());
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
    public b x(int i7, ViewGroup viewGroup) {
        return new b(this, LayoutInflater.from(this).inflate(R.layout.textadapter, viewGroup, false), 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        view.getId();
    }
}
