package com.haier.globalwasher.view.activity.loginregistrationbackmodel;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.RegisterBeen;
import com.haier.globalwasher.mvp_api.presenter.b;
import com.haier.globalwasher.presenter.e;
import i2.a;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class RedisterRetrieveSucceedActivity extends BaseActivity {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private e f25562u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Intent f25563v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f25564w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private TextView f25565x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private TextView f25566y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private TextView f25567z;

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void a() {
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_register_retriece_succeed;
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void d() {
        T(false, this);
        c0("", 2, R.color.app_white, 0, new View[0]);
        Intent intent = getIntent();
        this.f25563v = intent;
        Objects.requireNonNull(this.f25562u);
        this.f25564w = intent.getStringExtra("id");
        this.f25566y = (TextView) findViewById(R.id.register_hui);
        this.f25565x = (TextView) findViewById(R.id.register_bule);
        this.f25567z = (TextView) S(R.id.bt_login, true);
        if (this.f25564w.equals("2")) {
            this.f25565x.setText(getResources().getString(R.string.register_success_title));
            this.f25566y.setVisibility(0);
            this.f25567z.setText(getResources().getString(R.string.register_success_btn));
        } else {
            this.f25565x.setText(getResources().getString(R.string.find_newpwd_success_title));
            this.f25566y.setVisibility(8);
            this.f25567z.setText(getResources().getString(R.string.account_userlogin_title));
        }
    }

    @Override // com.haier.globalwasher.mvp_api.view.a
    public void e() {
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public b f() {
        e eVar = new e();
        this.f25562u = eVar;
        return eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.bt_login) {
            Toast.makeText(this, a.f34087c, 1).show();
            Log.i("RedisterRetrieveSucceedActivity", a.f34087c);
            if (this.f25564w.equals("2")) {
                this.f25562u.m();
                RegisterBeen.getInstance().initRegisterBeen();
                finish();
            } else {
                this.f25562u.m();
                RegisterBeen.getInstance().initRegisterBeen();
                startActivity(new Intent(this, (Class<?>) LoginActivity.class));
                finish();
            }
        }
    }
}
