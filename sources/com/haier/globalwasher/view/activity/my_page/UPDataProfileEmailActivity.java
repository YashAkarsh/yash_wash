package com.haier.globalwasher.view.activity.my_page;

import android.content.Context;
import android.content.res.Resources;
import android.text.InputFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseListActivity;
import com.haier.globalwasher.modle.bean.ProfileAvatarImageBeen;
import com.haier.globalwasher.modle.bean.ProfilePagePassBeen;
import com.haier.globalwasher.modle.bean.RegisterBeen;
import com.haier.globalwasher.modle.utils.d0;
import com.haier.globalwasher.modle.utils.i0;
import com.haier.globalwasher.modle.utils.l0;
import com.haier.globalwasher.mvp_api.adapter.d;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.presenter.t;
import com.haier.globalwasher.view.custom_view.FontTextView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class UPDataProfileEmailActivity extends BaseListActivity<ProfilePagePassBeen> implements d<ProfilePagePassBeen, com.haier.globalwasher.mvp_api.adapter.b> {
    private ListView B;
    private com.haier.globalwasher.mvp_api.adapter.a<ProfilePagePassBeen, com.haier.globalwasher.mvp_api.adapter.b> D;
    private FontTextView F;
    private Resources G;
    private FontTextView I;
    private t C = new t();
    private ArrayList<ProfilePagePassBeen> E = new ArrayList<>();
    private int H = 60;

    class a extends BaseListActivity<ProfilePagePassBeen>.a {
        a() {
            super();
        }

        @Override // com.haier.globalwasher.base.BaseListActivity.a
        public void f(ArrayList<ProfilePagePassBeen> arrayList) {
            UPDataProfileEmailActivity.this.E.addAll(arrayList);
            UPDataProfileEmailActivity uPDataProfileEmailActivity = UPDataProfileEmailActivity.this;
            UPDataProfileEmailActivity uPDataProfileEmailActivity2 = UPDataProfileEmailActivity.this;
            uPDataProfileEmailActivity.D = new com.haier.globalwasher.mvp_api.adapter.a(uPDataProfileEmailActivity2, uPDataProfileEmailActivity2.E, UPDataProfileEmailActivity.this);
            UPDataProfileEmailActivity.this.B.setAdapter((ListAdapter) UPDataProfileEmailActivity.this.D);
        }
    }

    class b extends com.haier.globalwasher.modle.network.a<BaseData> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ TextView f25689g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ FontTextView f25690h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ EditText f25691i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ FontTextView f25692j;

        class a implements com.haier.globalwasher.mvp_api.moudle.b<BaseData> {
            a() {
            }

            @Override // com.haier.globalwasher.mvp_api.moudle.b
            public void a(Exception exc) {
            }

            @Override // com.haier.globalwasher.mvp_api.moudle.b
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void b(BaseData baseData) {
                if (!"00000".equals(baseData.getRetCode())) {
                    i0.d(UPDataProfileEmailActivity.this, baseData.getRetInfo());
                    return;
                }
                UPDataProfileEmailActivity uPDataProfileEmailActivity = UPDataProfileEmailActivity.this;
                i0.d(uPDataProfileEmailActivity, uPDataProfileEmailActivity.G.getString(R.string.up_data_send_success));
                t tVar = UPDataProfileEmailActivity.this.C;
                b bVar = b.this;
                tVar.q(bVar.f25692j, UPDataProfileEmailActivity.this.H);
            }
        }

        b(TextView textView, FontTextView fontTextView, EditText editText, FontTextView fontTextView2) {
            this.f25689g = textView;
            this.f25690h = fontTextView;
            this.f25691i = editText;
            this.f25692j = fontTextView2;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData baseData) {
            if (!"00000".equals(baseData.getRetCode())) {
                i0.d(UPDataProfileEmailActivity.this, baseData.getRetInfo());
                return;
            }
            this.f25689g.setVisibility(0);
            this.f25690h.setVisibility(4);
            this.f25689g.setText(UPDataProfileEmailActivity.this.G.getString(R.string.up_data_code) + " " + this.f25691i.getText().toString());
            if (RegisterBeen.getInstance().getTime() == 0) {
                UPDataProfileEmailActivity.this.C.p("", "5", this.f25691i.getText().toString(), new a());
            } else {
                UPDataProfileEmailActivity.this.C.q(this.f25692j, RegisterBeen.getInstance().getTime());
            }
        }
    }

    class c implements com.haier.globalwasher.mvp_api.moudle.b<BaseData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ EditText f25695a;

        c(EditText editText) {
            this.f25695a = editText;
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseData baseData) {
            if (!"00000".equals(baseData.getRetCode())) {
                i0.d(UPDataProfileEmailActivity.this, baseData.getRetInfo());
                return;
            }
            ProfileAvatarImageBeen.getInstance().setEmail(this.f25695a.getText().toString());
            ProfileAvatarImageBeen.getInstance().setDesensitizationMailNumber(d0.g(this.f25695a.getText().toString()));
            UPDataProfileEmailActivity.this.setResult(1015);
            UPDataProfileEmailActivity uPDataProfileEmailActivity = UPDataProfileEmailActivity.this;
            i0.d(uPDataProfileEmailActivity, uPDataProfileEmailActivity.G.getString(R.string.up_data_code_success));
            UPDataProfileEmailActivity.this.finish();
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_up_data_profile_email;
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public com.haier.globalwasher.mvp_api.presenter.b l0() {
        return this.C;
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public ListView m0() {
        d0(getResources().getString(R.string.modified_data_email), 1, new View[0]);
        this.B = (ListView) findViewById(R.id.lv);
        this.F = (FontTextView) S(R.id.tv_submit, true);
        this.G = getResources();
        return this.B;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.et_code) {
            EditText editText = (EditText) this.B.getChildAt(1).findViewById(R.id.et_edit);
            View childAt = this.B.getChildAt(2);
            FontTextView fontTextView = (FontTextView) childAt.findViewById(R.id.tv_warning);
            TextView textView = (TextView) childAt.findViewById(R.id.tv_email_cont);
            FontTextView fontTextView2 = (FontTextView) childAt.findViewById(R.id.et_code);
            if (!d0.j(editText.getText().toString())) {
                i0.d(this, this.G.getString(R.string.regster_email).toLowerCase() + this.G.getString(R.string.mobile_phone_login_can_not_be_empty).toLowerCase());
                return;
            }
            if (editText.getText().toString().equals(ProfileAvatarImageBeen.getInstance().getEmail())) {
                fontTextView.setVisibility(0);
                fontTextView.setText(this.G.getString(R.string.register_email_error_same));
                return;
            } else if (l0.b(editText.getText().toString())) {
                this.C.m(editText.getText().toString(), new b(textView, fontTextView, editText, fontTextView2));
                return;
            } else {
                fontTextView.setVisibility(0);
                fontTextView.setText(this.G.getString(R.string.register_email_error));
                return;
            }
        }
        if (id == R.id.tv_submit) {
            EditText editText2 = (EditText) this.B.getChildAt(1).findViewById(R.id.et_edit);
            View childAt2 = this.B.getChildAt(2);
            EditText editText3 = (EditText) childAt2.findViewById(R.id.et_edit);
            FontTextView fontTextView3 = (FontTextView) childAt2.findViewById(R.id.tv_warning);
            if (!d0.j(editText2.getText().toString()) || !d0.j(editText3.getText().toString())) {
                i0.d(this, this.G.getString(R.string.regster_email).toLowerCase() + this.G.getString(R.string.up_data_code_or).toLowerCase() + this.G.getString(R.string.up_data_verification_code).toLowerCase() + this.G.getString(R.string.mobile_phone_login_can_not_be_empty).toLowerCase());
                return;
            }
            if (editText3.getText().length() < 4) {
                i0.d(this, this.G.getString(R.string.up_data_code_error).toLowerCase());
            } else if (editText2.getText().length() > 0) {
                if (l0.b(editText2.getText().toString())) {
                    this.C.r(ProfileAvatarImageBeen.getInstance().getEmail(), editText2.getText().toString().trim(), editText3.getText().toString().trim(), new c(editText2));
                } else {
                    fontTextView3.setText(this.G.getString(R.string.register_email_error));
                }
            }
        }
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public void p0(int i7, int i8) {
        this.C.k(new a());
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public void i(Context context, int i7, com.haier.globalwasher.mvp_api.adapter.b bVar, ProfilePagePassBeen profilePagePassBeen) {
        bVar.b(R.id.lly_content, R.id.tv_title_not_frame, R.id.et_edit, R.id.cb_image, R.id.tv_warning, R.id.et_code, R.id.tv_email_cont);
        LinearLayout linearLayout = (LinearLayout) bVar.a(R.id.lly_content);
        FontTextView fontTextView = (FontTextView) bVar.a(R.id.tv_title_not_frame);
        this.I = (FontTextView) bVar.a(R.id.et_code);
        CheckBox checkBox = (CheckBox) bVar.a(R.id.cb_image);
        EditText editText = (EditText) bVar.a(R.id.et_edit);
        TextView textView = (TextView) bVar.a(R.id.tv_warning);
        TextView textView2 = (TextView) bVar.a(R.id.tv_email_cont);
        fontTextView.setText(profilePagePassBeen.getTitle());
        if (i7 == 0) {
            checkBox.setVisibility(8);
            textView2.setVisibility(8);
            textView.setVisibility(8);
            this.I.setVisibility(8);
            editText.setText(profilePagePassBeen.getPhone());
            editText.setInputType(1);
            editText.setEnabled(false);
            linearLayout.setBackground(context.getDrawable(R.drawable.cardview_background_huise_not_projection));
        }
        if (i7 == 1) {
            textView.setVisibility(8);
            checkBox.setVisibility(8);
            this.I.setVisibility(8);
            textView2.setVisibility(8);
            editText.setInputType(32);
            editText.setFilters(new InputFilter[]{new d0.a()});
        }
        if (i7 == 2) {
            checkBox.setVisibility(8);
            textView.setVisibility(4);
            textView2.setVisibility(4);
            this.I.setVisibility(0);
            this.I.setText(profilePagePassBeen.getContent());
            editText.setInputType(2);
            this.I.setOnClickListener(this);
        }
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: y0, reason: merged with bridge method [inline-methods] */
    public com.haier.globalwasher.mvp_api.adapter.b x(int i7, ViewGroup viewGroup) {
        return new com.haier.globalwasher.mvp_api.adapter.b(this, View.inflate(this, R.layout.updata_item_not_email, null), 2);
    }
}
