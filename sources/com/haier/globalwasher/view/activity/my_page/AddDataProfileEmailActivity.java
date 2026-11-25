package com.haier.globalwasher.view.activity.my_page;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
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
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.presenter.t;
import com.haier.globalwasher.view.custom_view.FontTextView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class AddDataProfileEmailActivity extends BaseListActivity<ProfilePagePassBeen> implements com.haier.globalwasher.mvp_api.adapter.d<ProfilePagePassBeen, com.haier.globalwasher.mvp_api.adapter.b> {
    private ListView B;
    private com.haier.globalwasher.mvp_api.adapter.a<ProfilePagePassBeen, com.haier.globalwasher.mvp_api.adapter.b> D;
    private FontTextView F;
    private Resources G;
    private String I;
    private t C = new t();
    private ArrayList<ProfilePagePassBeen> E = new ArrayList<>();
    private int H = 60;

    class a extends BaseListActivity<ProfilePagePassBeen>.a {
        a() {
            super();
        }

        @Override // com.haier.globalwasher.base.BaseListActivity.a
        public void f(ArrayList<ProfilePagePassBeen> arrayList) {
            AddDataProfileEmailActivity.this.E.addAll(arrayList);
            AddDataProfileEmailActivity addDataProfileEmailActivity = AddDataProfileEmailActivity.this;
            AddDataProfileEmailActivity addDataProfileEmailActivity2 = AddDataProfileEmailActivity.this;
            addDataProfileEmailActivity.D = new com.haier.globalwasher.mvp_api.adapter.a(addDataProfileEmailActivity2, addDataProfileEmailActivity2.E, AddDataProfileEmailActivity.this);
            AddDataProfileEmailActivity.this.B.setAdapter((ListAdapter) AddDataProfileEmailActivity.this.D);
        }
    }

    class b implements com.haier.globalwasher.mvp_api.moudle.b<BaseData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ EditText f25627a;

        b(EditText editText) {
            this.f25627a = editText;
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseData baseData) {
            if (!"00000".equals(baseData.getRetCode())) {
                i0.d(AddDataProfileEmailActivity.this, baseData.getRetInfo());
                return;
            }
            ProfileAvatarImageBeen.getInstance().setEmail(this.f25627a.getText().toString());
            ProfileAvatarImageBeen.getInstance().setDesensitizationMailNumber(d0.g(this.f25627a.getText().toString()));
            AddDataProfileEmailActivity.this.setResult(1015);
            AddDataProfileEmailActivity addDataProfileEmailActivity = AddDataProfileEmailActivity.this;
            i0.d(addDataProfileEmailActivity, addDataProfileEmailActivity.G.getString(R.string.up_data_code_success));
            AddDataProfileEmailActivity.this.finish();
        }
    }

    class c implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f25629a;

        c(int i7) {
            this.f25629a = i7;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
            ((ProfilePagePassBeen) AddDataProfileEmailActivity.this.E.get(this.f25629a)).setPhone(charSequence.toString());
        }
    }

    class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f25631a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f25632b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ FontTextView f25633c;

        class a extends com.haier.globalwasher.modle.network.a<BaseData> {

            /* JADX INFO: renamed from: com.haier.globalwasher.view.activity.my_page.AddDataProfileEmailActivity$d$a$a, reason: collision with other inner class name */
            class C0334a implements com.haier.globalwasher.mvp_api.moudle.b<BaseData> {
                C0334a() {
                }

                @Override // com.haier.globalwasher.mvp_api.moudle.b
                public void a(Exception exc) {
                }

                @Override // com.haier.globalwasher.mvp_api.moudle.b
                /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
                public void b(BaseData baseData) {
                    if (!"00000".equals(baseData.getRetCode())) {
                        i0.d(AddDataProfileEmailActivity.this, baseData.getRetInfo());
                        return;
                    }
                    AddDataProfileEmailActivity addDataProfileEmailActivity = AddDataProfileEmailActivity.this;
                    i0.d(addDataProfileEmailActivity, addDataProfileEmailActivity.G.getString(R.string.up_data_send_success));
                    t tVar = AddDataProfileEmailActivity.this.C;
                    d dVar = d.this;
                    tVar.q(dVar.f25633c, AddDataProfileEmailActivity.this.H);
                }
            }

            a() {
            }

            @Override // com.haier.globalwasher.modle.network.a
            public void i(Exception exc) {
            }

            @Override // com.haier.globalwasher.modle.network.a
            /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
            public void p(BaseData baseData) {
                if (!"00000".equals(baseData.getRetCode())) {
                    i0.d(AddDataProfileEmailActivity.this, baseData.getRetInfo());
                    return;
                }
                d.this.f25632b.setVisibility(0);
                d.this.f25631a.setVisibility(4);
                d.this.f25632b.setText(AddDataProfileEmailActivity.this.G.getString(R.string.up_data_code) + " " + ((ProfilePagePassBeen) AddDataProfileEmailActivity.this.E.get(0)).getPhone());
                if (RegisterBeen.getInstance().getTime() == 0) {
                    AddDataProfileEmailActivity.this.C.p("", "5", ((ProfilePagePassBeen) AddDataProfileEmailActivity.this.E.get(0)).getPhone(), new C0334a());
                } else {
                    AddDataProfileEmailActivity.this.C.q(d.this.f25633c, RegisterBeen.getInstance().getTime());
                }
            }
        }

        d(TextView textView, TextView textView2, FontTextView fontTextView) {
            this.f25631a = textView;
            this.f25632b = textView2;
            this.f25633c = fontTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d0.j(((ProfilePagePassBeen) AddDataProfileEmailActivity.this.E.get(0)).getPhone())) {
                if (l0.b(((ProfilePagePassBeen) AddDataProfileEmailActivity.this.E.get(0)).getPhone())) {
                    AddDataProfileEmailActivity.this.C.m(((ProfilePagePassBeen) AddDataProfileEmailActivity.this.E.get(0)).getPhone(), new a());
                    return;
                } else {
                    this.f25631a.setVisibility(0);
                    this.f25631a.setText(AddDataProfileEmailActivity.this.G.getString(R.string.register_email_error));
                    return;
                }
            }
            i0.d(AddDataProfileEmailActivity.this, AddDataProfileEmailActivity.this.G.getString(R.string.regster_email).toLowerCase() + AddDataProfileEmailActivity.this.G.getString(R.string.mobile_phone_login_can_not_be_empty).toLowerCase());
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_add_data_profile_email;
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
        if (view.getId() == R.id.tv_submit) {
            EditText editText = (EditText) this.B.getChildAt(0).findViewById(R.id.et_edit);
            EditText editText2 = (EditText) this.B.getChildAt(1).findViewById(R.id.et_edit);
            if (!d0.j(editText.getText().toString()) || !d0.j(editText2.getText().toString())) {
                i0.d(this, this.G.getString(R.string.regster_email).toLowerCase() + this.G.getString(R.string.up_data_code_or).toLowerCase() + this.G.getString(R.string.up_data_verification_code).toLowerCase() + this.G.getString(R.string.mobile_phone_login_can_not_be_empty).toLowerCase());
                return;
            }
            if (editText2.getText().length() < 4) {
                i0.d(this, this.G.getString(R.string.up_data_code_error).toLowerCase());
            } else if (editText.getText().length() > 0) {
                if (l0.b(editText.getText().toString())) {
                    this.C.r(editText.getText().toString().trim(), editText.getText().toString().trim(), editText2.getText().toString().trim(), new b(editText));
                } else {
                    i0.d(this, this.G.getString(R.string.register_email_error).toLowerCase());
                }
            }
        }
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public void p0(int i7, int i8) {
        this.C.i(new a());
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public void i(Context context, int i7, com.haier.globalwasher.mvp_api.adapter.b bVar, ProfilePagePassBeen profilePagePassBeen) {
        bVar.b(R.id.lly_content, R.id.tv_title_not_frame, R.id.et_edit, R.id.cb_image, R.id.tv_warning, R.id.et_code, R.id.tv_email_cont);
        FontTextView fontTextView = (FontTextView) bVar.a(R.id.tv_title_not_frame);
        FontTextView fontTextView2 = (FontTextView) bVar.a(R.id.et_code);
        CheckBox checkBox = (CheckBox) bVar.a(R.id.cb_image);
        EditText editText = (EditText) bVar.a(R.id.et_edit);
        TextView textView = (TextView) bVar.a(R.id.tv_warning);
        TextView textView2 = (TextView) bVar.a(R.id.tv_email_cont);
        fontTextView.setText(profilePagePassBeen.getTitle());
        if (i7 == 0) {
            textView.setVisibility(8);
            checkBox.setVisibility(8);
            fontTextView2.setVisibility(8);
            textView2.setVisibility(8);
            editText.setInputType(32);
            editText.setFilters(new InputFilter[]{new d0.a()});
            editText.addTextChangedListener(new c(i7));
        }
        if (i7 == 1) {
            checkBox.setVisibility(8);
            textView.setVisibility(4);
            textView2.setVisibility(4);
            fontTextView2.setVisibility(0);
            fontTextView2.setText(profilePagePassBeen.getContent());
            editText.setInputType(2);
            fontTextView2.setOnClickListener(new d(textView, textView2, fontTextView2));
        }
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: y0, reason: merged with bridge method [inline-methods] */
    public com.haier.globalwasher.mvp_api.adapter.b x(int i7, ViewGroup viewGroup) {
        return new com.haier.globalwasher.mvp_api.adapter.b(this, View.inflate(this, R.layout.updata_item_not_email, null), 2);
    }
}
