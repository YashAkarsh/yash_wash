package com.haier.globalwasher.view.activity;

import android.view.View;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.mvp_api.presenter.b;
import com.haier.globalwasher.view.custom_view.wave_imageview.WaveFunctionView;

/* JADX INFO: loaded from: classes2.dex */
public class Test2Activity extends BaseActivity {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    WaveFunctionView f25456u;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Test2Activity.this.f25456u.c(8);
        }
    }

    public void G() {
        this.f25456u.postDelayed(new a(), 3200L);
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void a() {
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_test2;
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void d() {
        Q(null, -1);
        this.f25456u = (WaveFunctionView) findViewById(R.id.iv_wava_3);
        G();
    }

    @Override // com.haier.globalwasher.mvp_api.view.a
    public void e() {
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public b f() {
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
