package com.haier.globalwasher.view.activity.loginregistrationbackmodel;

import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.LoginResultBeen;
import com.haier.globalwasher.modle.bean.RegisterBeen;
import com.haier.globalwasher.modle.utils.i0;
import com.haier.globalwasher.modle.utils.n0;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.presenter.e;
import com.haier.globalwasher.view.custom_view.VerificationCodeEditText;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class VerificationCodeActivity extends BaseActivity {
    private String A;
    private Resources C;
    private d D;
    private c E;
    private b F;
    private LoginResultBeen G;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private e f25613u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private VerificationCodeEditText f25614v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private TextView f25615w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private TextView f25616x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private TextView f25617y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Intent f25618z;
    private boolean B = true;
    private String H = "";
    private String I = "";

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private String f25612J = "";

    class a implements com.haier.globalwasher.view.custom_view.a.InterfaceC0339a {
        a() {
        }

        @Override // com.haier.globalwasher.view.custom_view.a.InterfaceC0339a
        public void a(CharSequence charSequence) {
            if (TextUtils.isEmpty(charSequence) || charSequence.length() < 4) {
                return;
            }
            n0.j(VerificationCodeActivity.this.f25614v);
            if (VerificationCodeActivity.this.A.equals("1")) {
                VerificationCodeActivity.this.H = "4";
                VerificationCodeActivity.this.I = RegisterBeen.getInstance().getRegionCode() + RegisterBeen.getInstance().getPhoneNumber();
            } else if (VerificationCodeActivity.this.A.equals("2")) {
                VerificationCodeActivity.this.H = "2";
                VerificationCodeActivity.this.I = RegisterBeen.getInstance().getRegionCode() + RegisterBeen.getInstance().getPhoneNumber();
            } else if (VerificationCodeActivity.this.A.equals("3")) {
                VerificationCodeActivity.this.H = "3";
                if (VerificationCodeActivity.this.B) {
                    VerificationCodeActivity.this.I = RegisterBeen.getInstance().getRegionCode() + RegisterBeen.getInstance().getPhoneNumber();
                } else {
                    VerificationCodeActivity.this.f25612J = RegisterBeen.getInstance().getEmail();
                }
            }
            VerificationCodeActivity.this.f25613u.i(VerificationCodeActivity.this.I, VerificationCodeActivity.this.H, charSequence.toString(), VerificationCodeActivity.this.f25612J, VerificationCodeActivity.this.E);
            RegisterBeen.getInstance().setVerifyCode(charSequence.toString());
        }

        @Override // com.haier.globalwasher.view.custom_view.a.InterfaceC0339a
        public void b(CharSequence charSequence, int i7, int i8, int i9) {
        }
    }

    class b implements com.haier.globalwasher.mvp_api.moudle.b<BaseData<LoginResultBeen>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private VerificationCodeActivity f25620a;

        public b(VerificationCodeActivity verificationCodeActivity) {
            this.f25620a = verificationCodeActivity;
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseData<LoginResultBeen> baseData) {
            if (!"00000".equals(baseData.getRetCode())) {
                i0.d(this.f25620a, baseData.getRetInfo());
                return;
            }
            VerificationCodeActivity.this.G = baseData.getData();
            t2.a.b(VerificationCodeActivity.this.getApplicationContext(), t2.a.f40354a, t2.a.f40355b, VerificationCodeActivity.this.G.getTokenId());
            t2.a.b(VerificationCodeActivity.this.getApplicationContext(), t2.a.f40354a, t2.a.f40356c, VerificationCodeActivity.this.G.getUserId());
            t2.a.b(VerificationCodeActivity.this.getApplicationContext(), t2.a.f40354a, t2.a.f40357d, VerificationCodeActivity.this.G.getPhoneNumber());
            t2.a.b(VerificationCodeActivity.this.getApplicationContext(), t2.a.f40354a, t2.a.f40359f, VerificationCodeActivity.this.G.getUserName());
            if (!"".equals(VerificationCodeActivity.this.G.getAvatarURL())) {
                t2.a.b(VerificationCodeActivity.this.getApplicationContext(), t2.a.f40354a, t2.a.f40358e, VerificationCodeActivity.this.G.getAvatarURL());
            }
            RegisterBeen.getInstance().initRegisterBeen();
            if (VerificationCodeActivity.this.A.equals("1")) {
                VerificationCodeActivity verificationCodeActivity = VerificationCodeActivity.this;
                i0.d(verificationCodeActivity, verificationCodeActivity.C.getString(R.string.account_userlogin_success));
                VerificationCodeActivity.this.f25613u.m();
                this.f25620a.finish();
                return;
            }
            if (VerificationCodeActivity.this.A.equals("2")) {
                Intent intent = new Intent(VerificationCodeActivity.this, (Class<?>) RedisterRetrieveSucceedActivity.class);
                Objects.requireNonNull(VerificationCodeActivity.this.f25613u);
                intent.putExtra("id", "2");
                VerificationCodeActivity.this.f25613u.m();
                VerificationCodeActivity.this.startActivity(intent);
                this.f25620a.finish();
            }
        }
    }

    class c implements com.haier.globalwasher.mvp_api.moudle.b<BaseData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private VerificationCodeActivity f25622a;

        public c(VerificationCodeActivity verificationCodeActivity) {
            this.f25622a = verificationCodeActivity;
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseData baseData) {
            if (!"00000".equals(baseData.getRetCode())) {
                i0.d(this.f25622a, baseData.getRetInfo());
                return;
            }
            if (VerificationCodeActivity.this.A.equals("1")) {
                VerificationCodeActivity.this.f25613u.d(RegisterBeen.getInstance().getRegionCode() + RegisterBeen.getInstance().getPhoneNumber(), "1", "", RegisterBeen.getInstance().getVerifyCode(), VerificationCodeActivity.this.F);
                return;
            }
            if (VerificationCodeActivity.this.A.equals("2")) {
                VerificationCodeActivity.this.f25613u.g(RegisterBeen.getInstance().getRegionCode() + RegisterBeen.getInstance().getPhoneNumber(), RegisterBeen.getInstance().getUserName(), RegisterBeen.getInstance().getPassword(), RegisterBeen.getInstance().getVerifyCode(), RegisterBeen.getInstance().getEmail(), VerificationCodeActivity.this.F);
                return;
            }
            if (VerificationCodeActivity.this.A.equals("3")) {
                Intent intent = new Intent(this.f25622a, (Class<?>) RetrievePassWordActivity.class);
                intent.putExtra(VerificationCodeActivity.this.f25613u.f25120d, VerificationCodeActivity.this.B);
                this.f25622a.startActivity(intent);
            }
        }
    }

    class d implements com.haier.globalwasher.mvp_api.moudle.b<BaseData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private VerificationCodeActivity f25624a;

        public d(VerificationCodeActivity verificationCodeActivity) {
            this.f25624a = verificationCodeActivity;
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseData baseData) {
            if ("00000".equals(baseData.getRetCode())) {
                i0.d(this.f25624a, VerificationCodeActivity.this.C.getString(R.string.verify_code_send_SMS));
            } else {
                i0.d(this.f25624a, baseData.getRetInfo());
            }
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void a() {
        if (RegisterBeen.getInstance().getTime() == 0) {
            this.f25613u.l(this.f25616x, 60);
        } else {
            this.f25613u.l(this.f25616x, RegisterBeen.getInstance().getTime());
        }
        if (!this.A.equals("3")) {
            this.f25617y.setText(this.C.getString(R.string.verify_code_send_success_hint_a) + " " + RegisterBeen.getInstance().getPhoneNumber());
        } else if (this.B) {
            this.f25617y.setText(this.C.getString(R.string.verify_code_send_success_hint_a) + " " + RegisterBeen.getInstance().getPhoneNumber());
        } else {
            this.f25617y.setText(this.C.getString(R.string.up_data_code) + " " + RegisterBeen.getInstance().getEmail());
        }
        this.f25614v.setOnVerificationCodeChangedListener(new a());
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_verification_code;
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void d() {
        Intent intent = getIntent();
        this.f25618z = intent;
        Objects.requireNonNull(this.f25613u);
        this.A = intent.getStringExtra("id");
        this.B = this.f25618z.getBooleanExtra(this.f25613u.f25120d, true);
        T(false, this);
        c0("", 2, R.color.app_white, 0, new View[0]);
        this.C = getResources();
        this.f25615w = (TextView) findViewById(R.id.phone_pass_erre);
        this.f25616x = (TextView) S(R.id.verification_code_time, true);
        this.f25617y = (TextView) findViewById(R.id.verification_code_text);
        this.f25614v = (VerificationCodeEditText) findViewById(R.id.verification_code);
        this.D = new d(this);
        this.E = new c(this);
        this.F = new b(this);
    }

    @Override // com.haier.globalwasher.mvp_api.view.a
    public void e() {
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public com.haier.globalwasher.mvp_api.presenter.b f() {
        e eVar = new e();
        this.f25613u = eVar;
        return eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.verification_code_time) {
            this.f25613u.l(this.f25616x, 60);
            if (this.A.equals("1")) {
                this.H = "4";
                this.I = RegisterBeen.getInstance().getRegionCode() + RegisterBeen.getInstance().getPhoneNumber();
            } else if (this.A.equals("2")) {
                this.H = "2";
                this.I = RegisterBeen.getInstance().getRegionCode() + RegisterBeen.getInstance().getPhoneNumber();
            } else if (this.A.equals("3")) {
                this.H = "3";
                if (this.B) {
                    this.I = RegisterBeen.getInstance().getRegionCode() + RegisterBeen.getInstance().getPhoneNumber();
                } else {
                    this.f25612J = RegisterBeen.getInstance().getEmail();
                }
            }
            this.f25613u.k(this.I, this.H, this.f25612J, this.D);
        }
    }
}
