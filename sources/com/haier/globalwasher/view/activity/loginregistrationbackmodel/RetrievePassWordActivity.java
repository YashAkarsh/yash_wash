package com.haier.globalwasher.view.activity.loginregistrationbackmodel;

import android.content.Intent;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.RegisterBeen;
import com.haier.globalwasher.modle.utils.i0;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.presenter.e;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class RetrievePassWordActivity extends BaseActivity {
    private Resources C;
    private b D;
    private Intent F;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private e f25589u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private EditText f25590v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private ImageButton f25591w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private ImageButton f25592x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private TextView f25593y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private TextView f25594z;
    private boolean A = true;
    private int B = 6;
    private boolean E = true;
    private String G = "";
    private String H = "";

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
            if (RetrievePassWordActivity.this.f25590v.getText().toString().length() > 0) {
                RetrievePassWordActivity.this.f25592x.setVisibility(0);
                RetrievePassWordActivity.this.f25591w.setVisibility(0);
                RetrievePassWordActivity.this.f25594z.setEnabled(true);
                RetrievePassWordActivity.this.f25594z.setBackgroundResource(R.drawable.background_blue_button);
                return;
            }
            RetrievePassWordActivity.this.A = true;
            RetrievePassWordActivity.this.f25592x.setVisibility(8);
            RetrievePassWordActivity.this.f25591w.setVisibility(8);
            RetrievePassWordActivity.this.f25594z.setEnabled(false);
            RetrievePassWordActivity.this.f25594z.setBackgroundResource(R.drawable.background_huise_button);
        }
    }

    class b implements com.haier.globalwasher.mvp_api.moudle.b<BaseData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private RetrievePassWordActivity f25596a;

        public b(RetrievePassWordActivity retrievePassWordActivity) {
            this.f25596a = retrievePassWordActivity;
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseData baseData) {
            if (!"00000".equals(baseData.getRetCode())) {
                i0.d(this.f25596a, baseData.getRetInfo());
                return;
            }
            RegisterBeen.getInstance().initRegisterBeen();
            RetrievePassWordActivity.this.f25589u.m();
            Intent intent = new Intent(RetrievePassWordActivity.this, (Class<?>) RedisterRetrieveSucceedActivity.class);
            Objects.requireNonNull(RetrievePassWordActivity.this.f25589u);
            intent.putExtra("id", "3");
            RetrievePassWordActivity.this.startActivity(intent);
            RetrievePassWordActivity.this.finish();
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void a() {
        this.f25591w.setVisibility(8);
        this.f25592x.setVisibility(8);
        this.f25594z.setEnabled(false);
        this.f25590v.addTextChangedListener(new a());
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_login_retrieve_pass;
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void d() {
        this.F = getIntent();
        T(false, this);
        c0("", 2, R.color.app_white, 0, new View[0]);
        this.C = getResources();
        boolean booleanExtra = this.F.getBooleanExtra(this.f25589u.f25120d, true);
        this.E = booleanExtra;
        if (booleanExtra) {
            this.G = RegisterBeen.getInstance().getRegionCode() + RegisterBeen.getInstance().getPhoneNumber();
        } else {
            this.H = RegisterBeen.getInstance().getEmail();
        }
        this.f25590v = (EditText) findViewById(R.id.et_phone_pass);
        this.f25591w = (ImageButton) S(R.id.login_password_eye, true);
        this.f25592x = (ImageButton) S(R.id.login_password_dele, true);
        this.f25593y = (TextView) findViewById(R.id.phone_pass_erre);
        this.f25594z = (TextView) S(R.id.bt_login, true);
        this.D = new b(this);
    }

    @Override // com.haier.globalwasher.mvp_api.view.a
    public void e() {
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public com.haier.globalwasher.mvp_api.presenter.b f() {
        e eVar = new e();
        this.f25589u = eVar;
        return eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.bt_login) {
            if (this.f25590v.getText().length() > 0) {
                if (this.f25590v.getText().length() < this.B) {
                    this.f25593y.setText(this.C.getString(R.string.register_pwd_easy));
                    return;
                } else {
                    this.f25593y.setText("");
                    this.f25589u.h(this.G, this.H, this.f25590v.getText().toString().trim(), RegisterBeen.getInstance().getVerifyCode(), this.D);
                    return;
                }
            }
            this.f25593y.setText(this.C.getString(R.string.register_pwd).toLowerCase() + " " + this.C.getString(R.string.mobile_phone_login_can_not_be_empty).toLowerCase());
            return;
        }
        if (id != R.id.login_password_eye) {
            if (id == R.id.login_password_dele) {
                this.f25590v.setText("");
                return;
            }
            return;
        }
        if (this.A) {
            this.A = false;
            this.f25591w.setBackgroundResource(R.drawable.icon_eye_open);
            this.f25590v.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            this.A = true;
            this.f25591w.setBackgroundResource(R.drawable.icon_eye_close);
            this.f25590v.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        this.f25589u.n(this.f25590v);
    }
}
