package com.haier.globalwasher.view.activity.loginregistrationbackmodel;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.CountryCode;
import com.haier.globalwasher.modle.bean.RegisterBeen;
import com.haier.globalwasher.modle.utils.d0;
import com.haier.globalwasher.modle.utils.i0;
import com.haier.globalwasher.modle.utils.l0;
import com.haier.globalwasher.modle.utils.n0;
import com.haier.globalwasher.modle.utils.t;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.mvp_api.moudle.BaseListDate;
import com.haier.globalwasher.presenter.y;
import com.haier.globalwasher.view.activity.WebActivity;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class RegisterActivity extends BaseActivity {
    private TextView A;
    t A0;
    private TextView B;
    private TextView C;
    private TextView D;
    private EditText E;
    private ImageButton F;
    private ImageButton G;
    private ImageButton H;
    private ImageButton I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private TextView f25568J;
    private TextView K;
    private TextView L;
    private TextView M;
    private boolean P;
    private boolean Q;
    private j U;
    private k V;
    private i W;
    private ArrayList<CountryCode> X;
    private CountryCode Y;
    private Resources Z;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private com.haier.globalwasher.presenter.e f25569u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private EditText f25570v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private TextView f25571w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private EditText f25572x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private EditText f25573y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private ImageView f25574z;
    private boolean N = true;
    private boolean O = true;
    private int R = 4;
    private int S = 6;
    private int T = 15;
    String B0 = "";

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
            if (RegisterActivity.this.f25570v.getText().toString().length() > 0) {
                RegisterActivity.this.G.setVisibility(0);
            } else {
                RegisterActivity.this.G.setVisibility(8);
            }
            if (RegisterActivity.this.f25570v.getText().length() >= RegisterActivity.this.R) {
                RegisterActivity.this.L.setText("");
            }
            if (RegisterActivity.this.f25570v.getText().length() < RegisterActivity.this.R || !RegisterActivity.this.P || !RegisterActivity.this.Q || RegisterActivity.this.f25573y.getText().length() < RegisterActivity.this.S) {
                RegisterActivity.this.B.setEnabled(false);
                RegisterActivity.this.B.setBackgroundResource(R.drawable.background_huise_button);
            } else {
                RegisterActivity.this.B.setEnabled(true);
                RegisterActivity.this.B.setBackgroundResource(R.drawable.background_blue_button);
            }
        }
    }

    class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
            if (RegisterActivity.this.f25572x.getText().toString().length() <= 0) {
                RegisterActivity.this.F.setVisibility(8);
            } else if (TextUtils.isEmpty(RegisterActivity.this.Y.getRegexinfo())) {
                RegisterActivity.this.f25568J.setText("");
            } else {
                RegisterActivity registerActivity = RegisterActivity.this;
                registerActivity.P = l0.e(registerActivity.Y.getRegexinfo(), RegisterActivity.this.f25572x.getText().toString());
                if (RegisterActivity.this.P) {
                    RegisterActivity.this.f25568J.setText("");
                }
                RegisterActivity.this.F.setVisibility(0);
            }
            if (RegisterActivity.this.f25570v.getText().length() <= 0) {
                RegisterActivity.this.L.setText(RegisterActivity.this.Z.getString(R.string.register_name).toLowerCase() + " " + RegisterActivity.this.Z.getString(R.string.mobile_phone_login_can_not_be_empty).toLowerCase());
            } else if (RegisterActivity.this.f25570v.getText().length() < RegisterActivity.this.R) {
                RegisterActivity.this.L.setText(RegisterActivity.this.Z.getString(R.string.register_name_easy));
            } else {
                RegisterActivity.this.L.setText("");
            }
            if (RegisterActivity.this.f25570v.getText().length() < RegisterActivity.this.R || !RegisterActivity.this.P || !RegisterActivity.this.Q || RegisterActivity.this.f25573y.getText().length() < RegisterActivity.this.S) {
                RegisterActivity.this.B.setEnabled(false);
                RegisterActivity.this.B.setBackgroundResource(R.drawable.background_huise_button);
            } else {
                RegisterActivity.this.B.setEnabled(true);
                RegisterActivity.this.B.setBackgroundResource(R.drawable.background_blue_button);
            }
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
            if (RegisterActivity.this.E.getText().toString().length() > 0) {
                RegisterActivity registerActivity = RegisterActivity.this;
                registerActivity.Q = l0.b(registerActivity.E.getText().toString().trim());
                if (RegisterActivity.this.Q) {
                    RegisterActivity.this.M.setText("");
                }
            }
            if (RegisterActivity.this.f25572x.getText().length() <= 0) {
                RegisterActivity.this.f25568J.setText(RegisterActivity.this.Z.getString(R.string.register_phone).toLowerCase() + " " + RegisterActivity.this.Z.getString(R.string.mobile_phone_login_can_not_be_empty).toLowerCase());
            } else if (TextUtils.isEmpty(RegisterActivity.this.Y.getRegexinfo())) {
                RegisterActivity.this.f25568J.setText(RegisterActivity.this.Z.getString(R.string.register_login_area_code) + " " + RegisterActivity.this.Z.getString(R.string.mobile_phone_login_can_not_be_empty).toLowerCase());
            } else {
                RegisterActivity registerActivity2 = RegisterActivity.this;
                registerActivity2.P = l0.e(registerActivity2.Y.getRegexinfo(), RegisterActivity.this.f25572x.getText().toString());
                if (RegisterActivity.this.P) {
                    RegisterActivity.this.f25568J.setText("");
                } else {
                    RegisterActivity.this.f25568J.setText(RegisterActivity.this.Z.getString(R.string.register_phone_error));
                }
            }
            if (RegisterActivity.this.f25570v.getText().length() <= 0) {
                RegisterActivity.this.L.setText(RegisterActivity.this.Z.getString(R.string.register_name).toLowerCase() + " " + RegisterActivity.this.Z.getString(R.string.mobile_phone_login_can_not_be_empty).toLowerCase());
            } else if (RegisterActivity.this.f25570v.getText().length() < RegisterActivity.this.R) {
                RegisterActivity.this.L.setText(RegisterActivity.this.Z.getString(R.string.register_name_easy));
            } else {
                RegisterActivity.this.L.setText("");
            }
            if (RegisterActivity.this.f25570v.getText().length() < RegisterActivity.this.R || !RegisterActivity.this.P || !RegisterActivity.this.Q || RegisterActivity.this.f25573y.getText().length() < RegisterActivity.this.S) {
                RegisterActivity.this.B.setEnabled(false);
                RegisterActivity.this.B.setBackgroundResource(R.drawable.background_huise_button);
            } else {
                RegisterActivity.this.B.setEnabled(true);
                RegisterActivity.this.B.setBackgroundResource(R.drawable.background_blue_button);
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
            if (RegisterActivity.this.f25573y.getText().toString().length() > 0) {
                RegisterActivity.this.I.setVisibility(0);
                RegisterActivity.this.H.setVisibility(0);
            } else {
                RegisterActivity.this.N = true;
                RegisterActivity.this.I.setVisibility(8);
                RegisterActivity.this.H.setVisibility(8);
            }
            if (RegisterActivity.this.E.getText().length() > 0) {
                RegisterActivity registerActivity = RegisterActivity.this;
                registerActivity.Q = l0.b(registerActivity.E.getText().toString());
                if (RegisterActivity.this.Q) {
                    RegisterActivity.this.M.setText("");
                } else {
                    RegisterActivity.this.M.setText(RegisterActivity.this.Z.getString(R.string.register_email_error));
                }
            } else {
                RegisterActivity.this.M.setText(RegisterActivity.this.Z.getString(R.string.regster_email).toLowerCase() + " " + RegisterActivity.this.Z.getString(R.string.mobile_phone_login_can_not_be_empty).toLowerCase());
            }
            if (RegisterActivity.this.f25572x.getText().length() <= 0) {
                RegisterActivity.this.f25568J.setText(RegisterActivity.this.Z.getString(R.string.register_phone).toLowerCase() + " " + RegisterActivity.this.Z.getString(R.string.mobile_phone_login_can_not_be_empty).toLowerCase());
            } else if (TextUtils.isEmpty(RegisterActivity.this.Y.getRegexinfo())) {
                RegisterActivity.this.f25568J.setText(RegisterActivity.this.Z.getString(R.string.register_login_area_code) + " " + RegisterActivity.this.Z.getString(R.string.mobile_phone_login_can_not_be_empty).toLowerCase());
            } else {
                RegisterActivity registerActivity2 = RegisterActivity.this;
                registerActivity2.P = l0.e(registerActivity2.Y.getRegexinfo(), RegisterActivity.this.f25572x.getText().toString());
                if (RegisterActivity.this.P) {
                    RegisterActivity.this.f25568J.setText("");
                } else {
                    RegisterActivity.this.f25568J.setText(RegisterActivity.this.Z.getString(R.string.register_phone_error));
                }
            }
            if (RegisterActivity.this.f25570v.getText().length() <= 0) {
                RegisterActivity.this.L.setText(RegisterActivity.this.Z.getString(R.string.register_name).toLowerCase() + " " + RegisterActivity.this.Z.getString(R.string.mobile_phone_login_can_not_be_empty).toLowerCase());
            } else if (RegisterActivity.this.f25570v.getText().length() < RegisterActivity.this.R) {
                RegisterActivity.this.L.setText(RegisterActivity.this.Z.getString(R.string.register_name_easy));
            } else {
                RegisterActivity.this.L.setText("");
            }
            if (RegisterActivity.this.f25570v.getText().length() < RegisterActivity.this.R || !RegisterActivity.this.P || !RegisterActivity.this.Q || RegisterActivity.this.f25573y.getText().length() < RegisterActivity.this.S) {
                RegisterActivity.this.B.setEnabled(false);
                RegisterActivity.this.B.setBackgroundResource(R.drawable.background_huise_button);
            } else {
                RegisterActivity.this.B.setEnabled(true);
                RegisterActivity.this.B.setBackgroundResource(R.drawable.background_blue_button);
            }
        }
    }

    class e implements TextView.OnEditorActionListener {
        e() {
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

    class f implements TextView.OnEditorActionListener {
        f() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i7, KeyEvent keyEvent) {
            return i7 == 3;
        }
    }

    class g implements TextView.OnEditorActionListener {
        g() {
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

    class h implements t.e {
        h() {
        }

        @Override // com.haier.globalwasher.modle.utils.t.e
        public void a(int i7, CountryCode countryCode) {
            RegisterActivity.this.Y = countryCode;
            RegisterActivity registerActivity = RegisterActivity.this;
            registerActivity.B0 = registerActivity.Y.getRegionCode().replace("00", "");
            RegisterActivity.this.f25571w.setText("+" + RegisterActivity.this.B0);
        }
    }

    class i implements com.haier.globalwasher.mvp_api.moudle.b<BaseData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private RegisterActivity f25583a;

        public i(RegisterActivity registerActivity) {
            this.f25583a = registerActivity;
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseData baseData) {
            if (!"00000".equals(baseData.getRetCode())) {
                i0.d(RegisterActivity.this, baseData.getRetInfo());
                return;
            }
            RegisterActivity.this.f25569u.j(RegisterActivity.this.Y.getRegionCode() + RegisterActivity.this.f25572x.getText().toString().trim(), "2", RegisterActivity.this.V);
        }
    }

    class j implements com.haier.globalwasher.mvp_api.moudle.b<BaseListDate<CountryCode>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private RegisterActivity f25585a;

        public j(RegisterActivity registerActivity) {
            this.f25585a = registerActivity;
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseListDate<CountryCode> baseListDate) {
            if (!"00000".equals(baseListDate.getRetCode())) {
                i0.d(RegisterActivity.this, baseListDate.getRetInfo());
                return;
            }
            RegisterActivity.this.X = baseListDate.getData();
            RegisterActivity registerActivity = RegisterActivity.this;
            registerActivity.Y = (CountryCode) registerActivity.X.get(0);
            RegisterActivity registerActivity2 = RegisterActivity.this;
            registerActivity2.B0 = ((CountryCode) registerActivity2.X.get(0)).getRegionCode().replace("00", "");
            RegisterActivity.this.f25571w.setText("+" + RegisterActivity.this.B0);
            if (RegisterActivity.this.X.size() == 1) {
                RegisterActivity.this.f25571w.setCompoundDrawablesRelative(null, null, null, null);
                RegisterActivity.this.f25571w.setOnClickListener(null);
            }
        }
    }

    class k implements com.haier.globalwasher.mvp_api.moudle.b<BaseData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private RegisterActivity f25587a;

        public k(RegisterActivity registerActivity) {
            this.f25587a = registerActivity;
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseData baseData) {
            if (!"00000".equals(baseData.getRetCode())) {
                i0.d(RegisterActivity.this, baseData.getRetInfo());
            } else {
                i0.d(this.f25587a, RegisterActivity.this.Z.getString(R.string.verify_code_send_SMS));
                RegisterActivity.this.H0();
            }
        }
    }

    public void H0() {
        RegisterBeen.getInstance().setPhoneNumber(this.f25572x.getText().toString().trim());
        RegisterBeen.getInstance().setRegionCode(this.Y.getRegionCode());
        RegisterBeen.getInstance().setUserName(this.f25570v.getText().toString().trim());
        RegisterBeen.getInstance().setPassword(this.f25573y.getText().toString().trim());
        RegisterBeen.getInstance().setEmail(this.E.getText().toString().trim());
        Intent intent = new Intent(this, (Class<?>) VerificationCodeActivity.class);
        Objects.requireNonNull(this.f25569u);
        intent.putExtra("id", "2");
        startActivity(intent);
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void a() {
        this.F.setVisibility(8);
        this.H.setVisibility(8);
        this.I.setVisibility(8);
        this.G.setVisibility(8);
        this.B.setEnabled(false);
        this.C.getPaint().setFlags(8);
        this.C.getPaint().setAntiAlias(true);
        this.A.getPaint().setFlags(8);
        this.A.getPaint().setAntiAlias(true);
        this.f25570v.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.T)});
        this.f25570v.setFilters(new InputFilter[]{new d0.a()});
        this.f25570v.addTextChangedListener(new a());
        this.f25572x.addTextChangedListener(new b());
        this.E.setFilters(new InputFilter[]{new d0.a()});
        this.E.addTextChangedListener(new c());
        this.f25573y.addTextChangedListener(new d());
        this.f25572x.setOnEditorActionListener(new e());
        this.f25570v.setOnEditorActionListener(new f());
        this.f25573y.setOnEditorActionListener(new g());
        this.f25569u.f(this.U);
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_register;
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void d() {
        T(false, this);
        Resources resources = getResources();
        this.Z = resources;
        b0(resources.getString(R.string.register_title), 2, R.color.app_white, R.color.lingin_color, 24, new View[0]);
        this.f25570v = (EditText) findViewById(R.id.et_phone_name);
        this.f25571w = (TextView) S(R.id.et_phone_prefix, true);
        this.f25572x = (EditText) findViewById(R.id.et_phone);
        this.f25573y = (EditText) findViewById(R.id.et_phone_pass);
        this.f25574z = (ImageView) S(R.id.agreement_img, true);
        this.A = (TextView) S(R.id.agreement_text, true);
        this.B = (TextView) S(R.id.bt_login, true);
        this.C = (TextView) S(R.id.login_forgot_pass, true);
        this.D = (TextView) S(R.id.register, true);
        this.E = (EditText) findViewById(R.id.et_email);
        this.F = (ImageButton) S(R.id.login_phone_dele, true);
        this.G = (ImageButton) S(R.id.login_name_dele, true);
        this.H = (ImageButton) S(R.id.login_password_eye, true);
        this.I = (ImageButton) S(R.id.login_password_dele, true);
        this.f25568J = (TextView) findViewById(R.id.phone_erre);
        this.K = (TextView) findViewById(R.id.phone_pass_erre);
        this.L = (TextView) findViewById(R.id.name_erre);
        this.M = (TextView) findViewById(R.id.email_erre);
        this.U = new j(this);
        this.V = new k(this);
        this.W = new i(this);
        if (this.Y == null) {
            this.Y = new CountryCode();
        }
    }

    @Override // com.haier.globalwasher.mvp_api.view.a
    public void e() {
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public com.haier.globalwasher.mvp_api.presenter.b f() {
        com.haier.globalwasher.presenter.e eVar = new com.haier.globalwasher.presenter.e();
        this.f25569u = eVar;
        return eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.login_name_dele) {
            this.f25570v.setText("");
            return;
        }
        if (id == R.id.login_phone_dele) {
            this.f25572x.setText("");
            return;
        }
        if (id == R.id.login_password_dele) {
            this.f25573y.setText("");
            return;
        }
        if (id == R.id.login_password_eye) {
            if (this.N) {
                this.N = false;
                this.H.setBackgroundResource(R.drawable.icon_eye_open);
                this.f25573y.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
                this.N = true;
                this.H.setBackgroundResource(R.drawable.icon_eye_close);
                this.f25573y.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            this.f25569u.n(this.f25573y);
            return;
        }
        if (id == R.id.agreement_img) {
            if (this.O) {
                this.O = false;
                this.B.setEnabled(false);
                this.B.setBackgroundResource(R.drawable.background_huise_button);
                this.f25574z.setImageResource(R.drawable.btn_xieyi_dis);
                return;
            }
            this.O = true;
            this.B.setEnabled(true);
            this.B.setBackgroundResource(R.drawable.background_blue_button);
            this.f25574z.setImageResource(R.drawable.btn_xieyi_pre);
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
        if (id == R.id.login_forgot_pass) {
            startActivity(new Intent(this, (Class<?>) RetrievePhoneActivity.class));
            return;
        }
        if (id == R.id.register) {
            finish();
            return;
        }
        if (id != R.id.bt_login) {
            if (id == R.id.et_phone_prefix) {
                ArrayList<CountryCode> arrayList = this.X;
                if (arrayList == null || arrayList.size() <= 0) {
                    this.f25569u.f(this.U);
                    return;
                } else {
                    setOrderState(view);
                    return;
                }
            }
            return;
        }
        if (this.f25570v.getText().length() <= 0) {
            this.L.setText(this.Z.getString(R.string.register_name).toLowerCase() + " " + this.Z.getString(R.string.mobile_phone_login_can_not_be_empty).toLowerCase());
            return;
        }
        if (this.f25570v.getText().length() < this.R) {
            this.L.setText(this.Z.getString(R.string.register_name_easy));
            return;
        }
        this.L.setText("");
        if (this.f25572x.getText().length() <= 0) {
            this.f25568J.setText(this.Z.getString(R.string.register_phone).toLowerCase() + " " + this.Z.getString(R.string.mobile_phone_login_can_not_be_empty).toLowerCase());
            return;
        }
        if (TextUtils.isEmpty(this.Y.getRegexinfo())) {
            this.f25568J.setText(this.Z.getString(R.string.register_login_area_code) + " " + this.Z.getString(R.string.mobile_phone_login_can_not_be_empty).toLowerCase());
            return;
        }
        boolean zE = l0.e(this.Y.getRegexinfo(), this.f25572x.getText().toString());
        this.P = zE;
        if (!zE) {
            this.f25568J.setText(this.Z.getString(R.string.register_phone_error));
            return;
        }
        this.f25568J.setText("");
        if (this.E.getText().length() <= 0) {
            this.M.setText(this.Z.getString(R.string.regster_email).toLowerCase() + " " + this.Z.getString(R.string.mobile_phone_login_can_not_be_empty).toLowerCase());
            return;
        }
        boolean zB = l0.b(this.E.getText().toString());
        this.Q = zB;
        if (!zB) {
            this.M.setText(this.Z.getString(R.string.register_email_error));
            return;
        }
        this.M.setText("");
        if (this.f25573y.getText().length() <= 0) {
            this.K.setText(this.Z.getString(R.string.register_pwd).toLowerCase() + " " + this.Z.getString(R.string.mobile_phone_login_can_not_be_empty).toLowerCase());
            return;
        }
        if (this.f25573y.getText().length() < this.S) {
            this.K.setText(this.Z.getString(R.string.register_pwd_easy));
            return;
        }
        this.K.setText("");
        if (!this.O) {
            i0.d(this, this.Z.getString(R.string.register_login_CheckAgreement));
            return;
        }
        if (RegisterBeen.getInstance().getTime() != 0) {
            H0();
            return;
        }
        this.f25569u.e(this.Y.getRegionCode() + this.f25572x.getText().toString().trim(), this.E.getText().toString().trim(), this.W);
    }

    public void setOrderState(View view) {
        if (this.X == null) {
            this.X = new ArrayList<>();
        }
        if (this.A0 == null) {
            this.A0 = new t(this, view, this.X);
        }
        this.A0.i(new h());
        this.A0.j();
    }
}
