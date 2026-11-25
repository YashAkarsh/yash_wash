package com.haier.globalwasher.view.activity.loginregistrationbackmodel;

import android.content.Intent;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.CountryCode;
import com.haier.globalwasher.modle.bean.LoginResultBeen;
import com.haier.globalwasher.modle.bean.RegisterBeen;
import com.haier.globalwasher.modle.utils.i0;
import com.haier.globalwasher.modle.utils.l0;
import com.haier.globalwasher.modle.utils.n0;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.modle.utils.t;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.mvp_api.moudle.BaseListDate;
import com.haier.library.sumhttp.plugin.h;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class LoginActivity extends BaseActivity {
    private ImageButton A;
    private ImageButton B;
    private EditText C;
    private EditText D;
    private TextView E;
    private TextView F;
    private TextView G;
    private TextView H;
    private TextView I;
    private ArrayList<CountryCode> K;
    private CountryCode L;
    private boolean M;
    private Resources O;
    private LoginResultBeen P;
    private f Q;
    private g R;
    t S;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private com.haier.globalwasher.presenter.e f25537x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private TextView f25538y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private ImageButton f25539z;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final int f25534u = 10099;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final int f25535v = h.f27948e;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final String f25536w = "LOGIN_DATA";

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private boolean f25533J = true;
    private int N = 6;
    String T = "";
    private final String U = "ToastUtil";

    class a implements TextView.OnEditorActionListener {
        a() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i7, KeyEvent keyEvent) {
            return i7 == 3;
        }
    }

    class b implements TextView.OnEditorActionListener {
        b() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i7, KeyEvent keyEvent) {
            if (i7 != 3) {
                return false;
            }
            n0.j(textView);
            return true;
        }
    }

    class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
            if (LoginActivity.this.C.getText().toString().length() <= 0) {
                LoginActivity.this.f25539z.setVisibility(8);
            } else if (TextUtils.isEmpty(LoginActivity.this.L.getRegexinfo())) {
                LoginActivity.this.E.setText("");
            } else {
                LoginActivity loginActivity = LoginActivity.this;
                loginActivity.M = l0.e(loginActivity.L.getRegexinfo(), LoginActivity.this.C.getText().toString());
                if (LoginActivity.this.M) {
                    LoginActivity.this.E.setText("");
                }
                LoginActivity.this.f25539z.setVisibility(0);
            }
            if (!LoginActivity.this.M || LoginActivity.this.D.getText().length() < LoginActivity.this.N) {
                LoginActivity.this.G.setEnabled(false);
                LoginActivity.this.G.setBackgroundResource(R.drawable.background_huise_button);
            } else {
                LoginActivity.this.G.setEnabled(true);
                LoginActivity.this.G.setBackgroundResource(R.drawable.background_blue_button);
            }
        }
    }

    class d implements TextWatcher {
        d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
            if (LoginActivity.this.D.getText().toString().length() > 0) {
                LoginActivity.this.B.setVisibility(0);
                LoginActivity.this.A.setVisibility(0);
            } else {
                LoginActivity.this.f25533J = true;
                LoginActivity.this.B.setVisibility(8);
                LoginActivity.this.A.setVisibility(8);
            }
            if (LoginActivity.this.C.getText().length() <= 0) {
                LoginActivity.this.E.setText(LoginActivity.this.O.getString(R.string.register_phone).toLowerCase() + " " + LoginActivity.this.O.getString(R.string.mobile_phone_login_can_not_be_empty).toLowerCase());
            } else if (TextUtils.isEmpty(LoginActivity.this.L.getRegexinfo())) {
                LoginActivity.this.E.setText(LoginActivity.this.O.getString(R.string.register_login_area_code) + " " + LoginActivity.this.O.getString(R.string.mobile_phone_login_can_not_be_empty).toLowerCase());
            } else {
                LoginActivity loginActivity = LoginActivity.this;
                loginActivity.M = l0.e(loginActivity.L.getRegexinfo(), LoginActivity.this.C.getText().toString());
                if (LoginActivity.this.M) {
                    LoginActivity.this.E.setText("");
                } else {
                    LoginActivity.this.E.setText(LoginActivity.this.O.getString(R.string.register_phone_error));
                }
            }
            if (!LoginActivity.this.M || LoginActivity.this.D.getText().length() < LoginActivity.this.N) {
                LoginActivity.this.G.setEnabled(false);
                LoginActivity.this.G.setBackgroundResource(R.drawable.background_huise_button);
            } else {
                LoginActivity.this.G.setEnabled(true);
                LoginActivity.this.G.setBackgroundResource(R.drawable.background_blue_button);
            }
        }
    }

    class e implements t.e {
        e() {
        }

        @Override // com.haier.globalwasher.modle.utils.t.e
        public void a(int i7, CountryCode countryCode) {
            LoginActivity.this.L = countryCode;
            LoginActivity loginActivity = LoginActivity.this;
            loginActivity.T = loginActivity.L.getRegionCode().replace("00", "");
            LoginActivity.this.f25538y.setText("+" + LoginActivity.this.T);
        }
    }

    class f implements com.haier.globalwasher.mvp_api.moudle.b<BaseListDate<CountryCode>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private LoginActivity f25545a;

        public f(LoginActivity loginActivity) {
            this.f25545a = loginActivity;
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseListDate<CountryCode> baseListDate) {
            if (!"00000".equals(baseListDate.getRetCode())) {
                i0.d(LoginActivity.this, baseListDate.getRetInfo());
                return;
            }
            LoginActivity.this.K = baseListDate.getData();
            LoginActivity loginActivity = LoginActivity.this;
            loginActivity.L = (CountryCode) loginActivity.K.get(0);
            LoginActivity loginActivity2 = LoginActivity.this;
            loginActivity2.T = ((CountryCode) loginActivity2.K.get(0)).getRegionCode().replace("00", "");
            LoginActivity.this.f25538y.setText("+" + LoginActivity.this.T);
            if (LoginActivity.this.K.size() == 1) {
                LoginActivity.this.f25538y.setCompoundDrawablesRelative(null, null, null, null);
                LoginActivity.this.f25538y.setOnClickListener(null);
            }
        }
    }

    class g implements com.haier.globalwasher.mvp_api.moudle.b<BaseData<LoginResultBeen>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private LoginActivity f25547a;

        public g(LoginActivity loginActivity) {
            this.f25547a = loginActivity;
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseData<LoginResultBeen> baseData) {
            if (!"00000".equals(baseData.getRetCode())) {
                q.c("ToastUtil", "success3");
                i0.d(this.f25547a, baseData.getRetInfo());
                return;
            }
            q.c("ToastUtil", "success2");
            LoginActivity loginActivity = LoginActivity.this;
            i0.d(loginActivity, loginActivity.O.getString(R.string.account_userlogin_success));
            LoginActivity.this.P = baseData.getData();
            t2.a.b(LoginActivity.this.getApplicationContext(), t2.a.f40354a, t2.a.f40355b, LoginActivity.this.P.getTokenId());
            t2.a.b(LoginActivity.this.getApplicationContext(), t2.a.f40354a, t2.a.f40356c, LoginActivity.this.P.getUserId());
            t2.a.b(LoginActivity.this.getApplicationContext(), t2.a.f40354a, t2.a.f40357d, LoginActivity.this.P.getPhoneNumber());
            t2.a.b(LoginActivity.this.getApplicationContext(), t2.a.f40354a, t2.a.f40359f, LoginActivity.this.P.getUserName());
            RegisterBeen.getInstance().setPhoneNumber(LoginActivity.this.C.getText().toString().trim());
            RegisterBeen.getInstance().setRegionCode(LoginActivity.this.L.getRegionCode());
            if (!"".equals(LoginActivity.this.P.getAvatarURL())) {
                t2.a.b(LoginActivity.this.getApplicationContext(), t2.a.f40354a, t2.a.f40358e, LoginActivity.this.P.getAvatarURL());
            }
            Intent intent = new Intent();
            intent.putExtra("LOGIN_DATA", baseData);
            LoginActivity.this.setResult(h.f27948e, intent);
            LoginActivity.this.f25537x.m();
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity
    public void W() {
        super.W();
        setResult(10099, new Intent());
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void a() {
        this.f25539z.setVisibility(8);
        this.A.setVisibility(8);
        this.B.setVisibility(8);
        this.G.setEnabled(false);
        this.I.getPaint().setFlags(8);
        this.I.getPaint().setAntiAlias(true);
        this.C.setOnEditorActionListener(new a());
        this.D.setOnEditorActionListener(new b());
        this.C.addTextChangedListener(new c());
        this.D.addTextChangedListener(new d());
        this.f25537x.f(this.Q);
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_login_pass;
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void d() {
        T(false, this);
        c0("", 2, R.color.app_white, 0, new View[0]);
        this.O = getResources();
        this.I = (TextView) S(R.id.login_forgot_pass, true);
        this.f25538y = (TextView) S(R.id.et_phone_prefix, true);
        this.f25539z = (ImageButton) S(R.id.login_phone_dele, true);
        this.A = (ImageButton) S(R.id.login_password_eye, true);
        this.B = (ImageButton) S(R.id.login_password_dele, true);
        this.C = (EditText) S(R.id.et_phone, true);
        this.D = (EditText) S(R.id.et_phone_pass, true);
        this.G = (TextView) S(R.id.bt_login, true);
        this.H = (TextView) S(R.id.register, true);
        this.E = (TextView) findViewById(R.id.phone_erre);
        this.F = (TextView) findViewById(R.id.phone_pass_erre);
        this.Q = new f(this);
        this.R = new g(this);
        if (this.L == null) {
            this.L = new CountryCode();
        }
    }

    @Override // com.haier.globalwasher.mvp_api.view.a
    public void e() {
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public com.haier.globalwasher.mvp_api.presenter.b f() {
        com.haier.globalwasher.presenter.e eVar = new com.haier.globalwasher.presenter.e();
        this.f25537x = eVar;
        return eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.login_forgot_pass) {
            startActivity(new Intent(this, (Class<?>) RetrievePhoneActivity.class));
            return;
        }
        if (id == R.id.register) {
            startActivity(new Intent(this, (Class<?>) RegisterActivity.class));
            return;
        }
        if (id == R.id.login_phone_dele) {
            this.C.setText("");
            return;
        }
        if (id == R.id.login_password_dele) {
            this.D.setText("");
            return;
        }
        if (id == R.id.login_password_eye) {
            if (this.f25533J) {
                this.f25533J = false;
                this.A.setBackgroundResource(R.drawable.icon_eye_open);
                this.D.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
                this.f25533J = true;
                this.A.setBackgroundResource(R.drawable.icon_eye_close);
                this.D.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            this.f25537x.n(this.D);
            return;
        }
        if (id == R.id.et_phone_prefix) {
            ArrayList<CountryCode> arrayList = this.K;
            if (arrayList == null || arrayList.size() <= 0) {
                this.f25537x.f(this.Q);
                return;
            } else {
                setOrderState(view);
                return;
            }
        }
        if (id == R.id.bt_login) {
            if (this.C.getText().length() <= 0) {
                this.E.setText(this.O.getString(R.string.register_phone).toLowerCase() + " " + this.O.getString(R.string.mobile_phone_login_can_not_be_empty).toLowerCase());
                return;
            }
            if (TextUtils.isEmpty(this.L.getRegexinfo())) {
                this.E.setText(this.O.getString(R.string.register_login_area_code) + " " + this.O.getString(R.string.mobile_phone_login_can_not_be_empty).toLowerCase());
                return;
            }
            boolean zE = l0.e(this.L.getRegexinfo(), this.C.getText().toString());
            this.M = zE;
            if (!zE) {
                this.E.setText(this.O.getString(R.string.register_phone_error));
                return;
            }
            this.E.setText("");
            if (this.D.getText().length() <= 0) {
                this.F.setText(this.O.getString(R.string.register_pwd).toLowerCase() + " " + this.O.getString(R.string.mobile_phone_login_can_not_be_empty).toLowerCase());
                return;
            }
            if (this.D.getText().length() < this.N) {
                this.F.setText(this.O.getString(R.string.register_pwd_easy));
                return;
            }
            this.F.setText("");
            n0.j(view);
            this.f25537x.d(this.L.getRegionCode() + this.C.getText().toString().trim(), "2", this.D.getText().toString().trim(), "", this.R);
        }
    }

    public void setOrderState(View view) {
        if (this.K == null) {
            this.K = new ArrayList<>();
        }
        if (this.S == null) {
            this.S = new t(this, view, this.K);
        }
        this.S.i(new e());
        this.S.j();
    }
}
