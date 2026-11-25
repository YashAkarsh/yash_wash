package com.haier.globalwasher.view.activity.loginregistrationbackmodel;

import android.content.Intent;
import android.content.res.Resources;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.CountryCode;
import com.haier.globalwasher.modle.bean.RegisterBeen;
import com.haier.globalwasher.modle.utils.d0;
import com.haier.globalwasher.modle.utils.i0;
import com.haier.globalwasher.modle.utils.l0;
import com.haier.globalwasher.modle.utils.t;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.mvp_api.moudle.BaseListDate;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class RetrievePhoneActivity extends BaseActivity {
    private EditText A;
    private ArrayList<CountryCode> B;
    private CountryCode C;
    private boolean D;
    private boolean E;
    private d G;
    private e H;
    private Resources I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private TextView f25598J;
    private TextView K;
    private TextView L;
    private LinearLayout M;
    private RelativeLayout N;
    t Q;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    com.haier.globalwasher.presenter.e f25599u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private TextView f25600v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private TextView f25601w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private EditText f25602x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private ImageButton f25603y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private ImageButton f25604z;
    private boolean F = true;
    private String O = "";
    private String P = "";
    String R = "";

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
            if (RetrievePhoneActivity.this.f25602x.getText().toString().length() <= 0) {
                RetrievePhoneActivity.this.f25603y.setVisibility(8);
                RetrievePhoneActivity.this.f25601w.setEnabled(false);
                RetrievePhoneActivity.this.f25601w.setBackgroundResource(R.drawable.background_huise_button);
            } else {
                if (TextUtils.isEmpty(RetrievePhoneActivity.this.C.getRegexinfo())) {
                    RetrievePhoneActivity.this.f25598J.setText("");
                    return;
                }
                RetrievePhoneActivity retrievePhoneActivity = RetrievePhoneActivity.this;
                retrievePhoneActivity.D = l0.e(retrievePhoneActivity.C.getRegexinfo(), RetrievePhoneActivity.this.f25602x.getText().toString());
                if (RetrievePhoneActivity.this.D) {
                    RetrievePhoneActivity.this.f25598J.setText("");
                }
                RetrievePhoneActivity.this.f25603y.setVisibility(0);
                RetrievePhoneActivity.this.f25601w.setEnabled(true);
                RetrievePhoneActivity.this.f25601w.setBackgroundResource(R.drawable.background_blue_button);
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
            if (RetrievePhoneActivity.this.A.getText().toString().length() <= 0) {
                RetrievePhoneActivity.this.f25604z.setVisibility(8);
                RetrievePhoneActivity.this.f25601w.setEnabled(false);
                RetrievePhoneActivity.this.f25601w.setBackgroundResource(R.drawable.background_huise_button);
                return;
            }
            RetrievePhoneActivity retrievePhoneActivity = RetrievePhoneActivity.this;
            retrievePhoneActivity.E = l0.b(retrievePhoneActivity.A.getText().toString());
            if (RetrievePhoneActivity.this.E) {
                RetrievePhoneActivity.this.f25598J.setText("");
            }
            RetrievePhoneActivity.this.f25604z.setVisibility(0);
            RetrievePhoneActivity.this.f25601w.setEnabled(true);
            RetrievePhoneActivity.this.f25601w.setBackgroundResource(R.drawable.background_blue_button);
        }
    }

    class c implements t.e {
        c() {
        }

        @Override // com.haier.globalwasher.modle.utils.t.e
        public void a(int i7, CountryCode countryCode) {
            RetrievePhoneActivity.this.C = countryCode;
            RetrievePhoneActivity retrievePhoneActivity = RetrievePhoneActivity.this;
            retrievePhoneActivity.R = retrievePhoneActivity.C.getRegionCode().replace("00", "");
            RetrievePhoneActivity.this.f25600v.setText("+" + RetrievePhoneActivity.this.R);
        }
    }

    class d implements com.haier.globalwasher.mvp_api.moudle.b<BaseListDate<CountryCode>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private RetrievePhoneActivity f25608a;

        public d(RetrievePhoneActivity retrievePhoneActivity) {
            this.f25608a = retrievePhoneActivity;
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseListDate<CountryCode> baseListDate) {
            if (!"00000".equals(baseListDate.getRetCode())) {
                i0.d(this.f25608a, baseListDate.getRetInfo());
                return;
            }
            RetrievePhoneActivity.this.B = baseListDate.getData();
            RetrievePhoneActivity retrievePhoneActivity = RetrievePhoneActivity.this;
            retrievePhoneActivity.C = (CountryCode) retrievePhoneActivity.B.get(0);
            RetrievePhoneActivity retrievePhoneActivity2 = RetrievePhoneActivity.this;
            retrievePhoneActivity2.R = ((CountryCode) retrievePhoneActivity2.B.get(0)).getRegionCode().replace("00", "");
            RetrievePhoneActivity.this.f25600v.setText("+" + RetrievePhoneActivity.this.R);
            if (RetrievePhoneActivity.this.B.size() == 1) {
                RetrievePhoneActivity.this.f25600v.setCompoundDrawablesRelative(null, null, null, null);
                RetrievePhoneActivity.this.f25600v.setOnClickListener(null);
            }
        }
    }

    class e implements com.haier.globalwasher.mvp_api.moudle.b<BaseData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private RetrievePhoneActivity f25610a;

        public e(RetrievePhoneActivity retrievePhoneActivity) {
            this.f25610a = retrievePhoneActivity;
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseData baseData) {
            if (!"00000".equals(baseData.getRetCode())) {
                i0.d(this.f25610a, baseData.getRetInfo());
            } else {
                i0.d(this.f25610a, RetrievePhoneActivity.this.I.getString(R.string.verify_code_send_SMS));
                RetrievePhoneActivity.this.w0();
            }
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void a() {
        this.f25603y.setVisibility(8);
        this.f25604z.setVisibility(8);
        this.f25601w.setEnabled(false);
        this.F = true;
        this.K.setTextColor(getColor(R.color.app_zhexian_blue_relg));
        this.L.setTextColor(getColor(R.color.app_ret_gre));
        this.M.setVisibility(0);
        this.N.setVisibility(8);
        this.f25602x.addTextChangedListener(new a());
        this.A.setFilters(new InputFilter[]{new d0.a()});
        this.A.addTextChangedListener(new b());
        this.f25599u.f(this.G);
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_login_retrieve_phone;
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void d() {
        T(false, this);
        c0("", 2, R.color.app_white, 0, new View[0]);
        this.I = getResources();
        this.f25600v = (TextView) S(R.id.et_phone_prefix, true);
        this.f25603y = (ImageButton) S(R.id.login_phone_dele, true);
        this.f25604z = (ImageButton) S(R.id.email_dele, true);
        this.f25602x = (EditText) findViewById(R.id.et_phone);
        this.A = (EditText) findViewById(R.id.et_email);
        this.f25598J = (TextView) findViewById(R.id.phone_erre);
        this.K = (TextView) S(R.id.tv_phone, true);
        this.L = (TextView) S(R.id.tv_email, true);
        this.M = (LinearLayout) findViewById(R.id.lly_phone);
        this.N = (RelativeLayout) findViewById(R.id.rly_email);
        this.f25601w = (TextView) S(R.id.bt_login, true);
        this.G = new d(this);
        this.H = new e(this);
        if (this.C == null) {
            this.C = new CountryCode();
        }
    }

    @Override // com.haier.globalwasher.mvp_api.view.a
    public void e() {
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public com.haier.globalwasher.mvp_api.presenter.b f() {
        com.haier.globalwasher.presenter.e eVar = new com.haier.globalwasher.presenter.e();
        this.f25599u = eVar;
        return eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_phone) {
            this.F = true;
            this.K.setTextColor(getColor(R.color.app_zhexian_blue_relg));
            this.L.setTextColor(getColor(R.color.app_ret_gre));
            this.M.setVisibility(0);
            this.N.setVisibility(8);
            this.A.setText("");
            this.P = "";
            return;
        }
        if (id == R.id.tv_email) {
            this.F = false;
            this.K.setTextColor(getColor(R.color.app_ret_gre));
            this.L.setTextColor(getColor(R.color.app_zhexian_blue_relg));
            this.M.setVisibility(8);
            this.N.setVisibility(0);
            this.f25602x.setText("");
            this.O = "";
            return;
        }
        if (id != R.id.bt_login) {
            if (id == R.id.login_phone_dele) {
                this.f25602x.setText("");
                return;
            }
            if (id == R.id.email_dele) {
                this.A.setText("");
                return;
            }
            if (id == R.id.et_phone_prefix) {
                ArrayList<CountryCode> arrayList = this.B;
                if (arrayList == null || arrayList.size() <= 0) {
                    this.f25599u.f(this.G);
                    return;
                } else {
                    setOrderState(view);
                    return;
                }
            }
            return;
        }
        if (this.F) {
            if (this.f25602x.getText().length() <= 0) {
                this.f25598J.setText(this.I.getString(R.string.register_phone).toLowerCase() + " " + this.I.getString(R.string.mobile_phone_login_can_not_be_empty).toLowerCase());
                return;
            }
            if (TextUtils.isEmpty(this.C.getRegexinfo())) {
                this.f25598J.setText(this.I.getString(R.string.register_login_area_code) + " " + this.I.getString(R.string.mobile_phone_login_can_not_be_empty).toLowerCase());
                return;
            }
            boolean zE = l0.e(this.C.getRegexinfo(), this.f25602x.getText().toString());
            this.D = zE;
            if (!zE) {
                this.f25598J.setText(this.I.getString(R.string.register_phone_error));
                return;
            }
            this.f25598J.setText("");
            this.O = this.C.getRegionCode() + this.f25602x.getText().toString().trim();
        } else {
            if (this.A.getText().length() <= 0) {
                this.f25598J.setText(this.I.getString(R.string.regster_email).toLowerCase() + " " + this.I.getString(R.string.mobile_phone_login_can_not_be_empty).toLowerCase());
                return;
            }
            boolean zB = l0.b(this.A.getText().toString());
            this.E = zB;
            if (!zB) {
                this.f25598J.setText(this.I.getString(R.string.register_email_error));
                return;
            } else {
                this.f25598J.setText("");
                this.P = this.A.getText().toString().trim();
            }
        }
        if (RegisterBeen.getInstance().getTime() == 0) {
            this.f25599u.k(this.O, "3", this.P, this.H);
        } else {
            w0();
        }
    }

    public void setOrderState(View view) {
        if (this.B == null) {
            this.B = new ArrayList<>();
        }
        if (this.Q == null) {
            this.Q = new t(this, view, this.B);
        }
        this.Q.i(new c());
        this.Q.j();
    }

    public void w0() {
        RegisterBeen.getInstance().setPhoneNumber(this.f25602x.getText().toString().trim());
        RegisterBeen.getInstance().setRegionCode(this.C.getRegionCode());
        RegisterBeen.getInstance().setEmail(this.A.getText().toString().trim());
        Intent intent = new Intent(this, (Class<?>) VerificationCodeActivity.class);
        Objects.requireNonNull(this.f25599u);
        intent.putExtra("id", "3");
        intent.putExtra(this.f25599u.f25120d, this.F);
        startActivity(intent);
    }
}
