package com.haier.globalwasher.view.activity.loginregistrationbackmodel;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.CountryCode;
import com.haier.globalwasher.modle.bean.RegisterBeen;
import com.haier.globalwasher.modle.utils.i0;
import com.haier.globalwasher.modle.utils.l0;
import com.haier.globalwasher.modle.utils.t;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.mvp_api.moudle.BaseListDate;
import com.haier.globalwasher.presenter.e;
import com.haier.globalwasher.presenter.y;
import com.haier.globalwasher.view.activity.WebActivity;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class LoginPhoneActivity extends BaseActivity {
    private TextView A;
    private ArrayList<CountryCode> C;
    private CountryCode D;
    private boolean E;
    private c F;
    private d G;
    private Resources H;
    t I;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    e f25550u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private TextView f25551v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private TextView f25552w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private EditText f25553x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private ImageButton f25554y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private ImageView f25555z;
    private boolean B = true;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    String f25549J = "";

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
            if (LoginPhoneActivity.this.f25553x.getText().toString().length() > 0) {
                LoginPhoneActivity.this.f25554y.setVisibility(0);
                LoginPhoneActivity.this.f25552w.setEnabled(true);
                LoginPhoneActivity.this.f25552w.setBackgroundResource(R.drawable.background_blue_button);
            } else {
                LoginPhoneActivity.this.f25554y.setVisibility(8);
                LoginPhoneActivity.this.f25552w.setEnabled(false);
                LoginPhoneActivity.this.f25552w.setBackgroundResource(R.drawable.background_huise_button);
            }
        }
    }

    class b implements t.e {
        b() {
        }

        @Override // com.haier.globalwasher.modle.utils.t.e
        public void a(int i7, CountryCode countryCode) {
            LoginPhoneActivity.this.D = countryCode;
            LoginPhoneActivity loginPhoneActivity = LoginPhoneActivity.this;
            loginPhoneActivity.f25549J = loginPhoneActivity.D.getRegionCode().replace("00", "");
            LoginPhoneActivity.this.f25551v.setText("+" + LoginPhoneActivity.this.f25549J);
        }
    }

    class c implements com.haier.globalwasher.mvp_api.moudle.b<BaseListDate<CountryCode>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private LoginPhoneActivity f25558a;

        public c(LoginPhoneActivity loginPhoneActivity) {
            this.f25558a = loginPhoneActivity;
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseListDate<CountryCode> baseListDate) {
            if (!"00000".equals(baseListDate.getRetCode())) {
                i0.d(this.f25558a, baseListDate.getRetInfo());
                return;
            }
            LoginPhoneActivity.this.C = baseListDate.getData();
            LoginPhoneActivity.this.C = baseListDate.getData();
            for (int i7 = 0; i7 < LoginPhoneActivity.this.C.size(); i7++) {
                if (Locale.getDefault().getCountry().equals(((CountryCode) LoginPhoneActivity.this.C.get(i7)).getCode())) {
                    LoginPhoneActivity loginPhoneActivity = LoginPhoneActivity.this;
                    loginPhoneActivity.D = (CountryCode) loginPhoneActivity.C.get(i7);
                    LoginPhoneActivity loginPhoneActivity2 = LoginPhoneActivity.this;
                    loginPhoneActivity2.f25549J = ((CountryCode) loginPhoneActivity2.C.get(i7)).getRegionCode().replace("00", "");
                    LoginPhoneActivity.this.f25551v.setText("+" + LoginPhoneActivity.this.f25549J);
                }
            }
        }
    }

    class d implements com.haier.globalwasher.mvp_api.moudle.b<BaseData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private LoginPhoneActivity f25560a;

        public d(LoginPhoneActivity loginPhoneActivity) {
            this.f25560a = loginPhoneActivity;
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseData baseData) {
            if (!"00000".equals(baseData.getRetCode())) {
                i0.d(this.f25560a, baseData.getRetInfo());
            } else {
                i0.d(this.f25560a, LoginPhoneActivity.this.H.getString(R.string.verify_code_send_SMS));
                LoginPhoneActivity.this.p0();
            }
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void a() {
        this.f25554y.setVisibility(8);
        this.f25552w.setEnabled(false);
        this.A.getPaint().setFlags(8);
        this.A.getPaint().setAntiAlias(true);
        this.f25553x.addTextChangedListener(new a());
        this.f25550u.f(this.F);
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_login_phone;
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void d() {
        T(false, this);
        c0("", 2, R.color.app_white, 0, new View[0]);
        this.H = getResources();
        this.f25551v = (TextView) S(R.id.et_phone_prefix, true);
        this.f25554y = (ImageButton) S(R.id.login_phone_dele, true);
        this.f25553x = (EditText) findViewById(R.id.et_phone);
        this.f25552w = (TextView) S(R.id.bt_login, true);
        this.f25555z = (ImageView) S(R.id.agreement_img, true);
        this.A = (TextView) S(R.id.agreement_text, true);
        this.F = new c(this);
        this.G = new d(this);
        if (this.D == null) {
            this.D = new CountryCode();
        }
    }

    @Override // com.haier.globalwasher.mvp_api.view.a
    public void e() {
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public com.haier.globalwasher.mvp_api.presenter.b f() {
        e eVar = new e();
        this.f25550u = eVar;
        return eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.login_phone_dele) {
            this.f25553x.setText("");
            return;
        }
        if (id == R.id.et_phone_prefix) {
            ArrayList<CountryCode> arrayList = this.C;
            if (arrayList == null || arrayList.size() <= 0) {
                this.f25550u.f(this.F);
                return;
            } else {
                setOrderState(view);
                return;
            }
        }
        if (id == R.id.agreement_img) {
            if (this.B) {
                this.B = false;
                this.f25552w.setEnabled(false);
                this.f25552w.setBackgroundResource(R.drawable.background_huise_button);
                this.f25555z.setImageResource(R.drawable.btn_xieyi_dis);
                return;
            }
            this.B = true;
            this.f25552w.setEnabled(true);
            this.f25552w.setBackgroundResource(R.drawable.background_blue_button);
            this.f25555z.setImageResource(R.drawable.btn_xieyi_pre);
            return;
        }
        if (id == R.id.agreement_text) {
            Intent intent = new Intent(this, (Class<?>) WebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString(y.f25407e, i2.a.f34088c0);
            intent.putExtra(y.f25405c, bundle);
            startActivity(intent);
            return;
        }
        if (id == R.id.bt_login) {
            if (this.f25553x.getText().length() <= 0) {
                i0.d(this, this.H.getString(R.string.register_phone).toLowerCase() + " " + this.H.getString(R.string.mobile_phone_login_can_not_be_empty).toLowerCase());
                return;
            }
            if (TextUtils.isEmpty(this.D.getRegexinfo())) {
                i0.d(this, this.H.getString(R.string.register_login_area_code) + " " + this.H.getString(R.string.mobile_phone_login_can_not_be_empty).toLowerCase());
                return;
            }
            boolean zE = l0.e(this.D.getRegexinfo(), this.f25553x.getText().toString());
            this.E = zE;
            if (!zE) {
                i0.d(this, this.H.getString(R.string.register_phone_error));
                return;
            }
            if (!this.B) {
                i0.d(this, this.H.getString(R.string.register_login_CheckAgreement));
                return;
            }
            if (RegisterBeen.getInstance().getTime() != 0) {
                p0();
                return;
            }
            this.f25550u.j(this.D.getRegionCode() + this.f25553x.getText().toString().trim(), "4", this.G);
        }
    }

    public void p0() {
        RegisterBeen.getInstance().setPhoneNumber(this.f25553x.getText().toString().trim());
        RegisterBeen.getInstance().setRegionCode(this.D.getRegionCode());
        Intent intent = new Intent(this, (Class<?>) VerificationCodeActivity.class);
        Objects.requireNonNull(this.f25550u);
        intent.putExtra("id", "1");
        startActivity(intent);
    }

    public void setOrderState(View view) {
        if (this.C == null) {
            this.C = new ArrayList<>();
        }
        if (this.I == null) {
            this.I = new t(this, view, this.C);
        }
        this.I.i(new b());
        this.I.j();
    }
}
