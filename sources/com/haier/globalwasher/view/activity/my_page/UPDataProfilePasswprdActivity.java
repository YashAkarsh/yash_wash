package com.haier.globalwasher.view.activity.my_page;

import android.content.Context;
import android.content.res.Resources;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.presenter.q;
import com.haier.globalwasher.presenter.t;
import com.haier.globalwasher.view.custom_view.FontTextView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class UPDataProfilePasswprdActivity extends BaseListActivity<ProfilePagePassBeen> implements com.haier.globalwasher.mvp_api.adapter.d<ProfilePagePassBeen, com.haier.globalwasher.mvp_api.adapter.b> {
    private ListView B;
    private com.haier.globalwasher.mvp_api.adapter.a<ProfilePagePassBeen, com.haier.globalwasher.mvp_api.adapter.b> D;
    private FontTextView F;
    e G;
    private Resources H;
    private t C = new t();
    private ArrayList<ProfilePagePassBeen> E = new ArrayList<>();
    private int I = 60;

    class a extends BaseListActivity<ProfilePagePassBeen>.a {
        a() {
            super();
        }

        @Override // com.haier.globalwasher.base.BaseListActivity.a
        public void f(ArrayList<ProfilePagePassBeen> arrayList) {
            UPDataProfilePasswprdActivity.this.E.addAll(arrayList);
            UPDataProfilePasswprdActivity uPDataProfilePasswprdActivity = UPDataProfilePasswprdActivity.this;
            UPDataProfilePasswprdActivity uPDataProfilePasswprdActivity2 = UPDataProfilePasswprdActivity.this;
            uPDataProfilePasswprdActivity.D = new com.haier.globalwasher.mvp_api.adapter.a(uPDataProfilePasswprdActivity2, uPDataProfilePasswprdActivity2.E, UPDataProfilePasswprdActivity.this);
            UPDataProfilePasswprdActivity.this.B.setAdapter((ListAdapter) UPDataProfilePasswprdActivity.this.D);
        }
    }

    class b implements com.haier.globalwasher.mvp_api.moudle.b<BaseData> {
        b() {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseData baseData) {
            if (!"00000".equals(baseData.getRetCode())) {
                i0.d(UPDataProfilePasswprdActivity.this, baseData.getRetInfo());
                return;
            }
            ProfileAvatarImageBeen.getInstance().setHavepwd(true);
            UPDataProfilePasswprdActivity uPDataProfilePasswprdActivity = UPDataProfilePasswprdActivity.this;
            i0.d(uPDataProfilePasswprdActivity, uPDataProfilePasswprdActivity.H.getString(R.string.change_name_success));
            new q().p(UPDataProfilePasswprdActivity.this, 2);
            UPDataProfilePasswprdActivity.this.finish();
        }
    }

    class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FontTextView f25699a;

        c(FontTextView fontTextView) {
            this.f25699a = fontTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (RegisterBeen.getInstance().getTime() != 0) {
                UPDataProfilePasswprdActivity.this.C.q(this.f25699a, RegisterBeen.getInstance().getTime());
            } else {
                UPDataProfilePasswprdActivity.this.C.o(ProfileAvatarImageBeen.getInstance().getPhoneNumber(), "3", UPDataProfilePasswprdActivity.this.G);
                UPDataProfilePasswprdActivity.this.C.q(this.f25699a, UPDataProfilePasswprdActivity.this.I);
            }
        }
    }

    class d implements CompoundButton.OnCheckedChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ EditText f25701a;

        d(EditText editText) {
            this.f25701a = editText;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z7) {
            if (z7) {
                this.f25701a.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
                this.f25701a.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    class e implements com.haier.globalwasher.mvp_api.moudle.b<BaseData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private UPDataProfilePasswprdActivity f25703a;

        public e(UPDataProfilePasswprdActivity uPDataProfilePasswprdActivity) {
            this.f25703a = uPDataProfilePasswprdActivity;
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseData baseData) {
            if ("00000".equals(baseData.getRetCode())) {
                i0.d(this.f25703a, UPDataProfilePasswprdActivity.this.H.getString(R.string.verify_code_send_SMS));
            } else {
                i0.d(this.f25703a, baseData.getRetInfo());
            }
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_up_data_profile_pass;
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public com.haier.globalwasher.mvp_api.presenter.b l0() {
        return this.C;
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public ListView m0() {
        d0(getResources().getString(R.string.modified_data_password), 1, new View[0]);
        this.B = (ListView) findViewById(R.id.lv);
        this.F = (FontTextView) S(R.id.tv_submit, true);
        this.H = getResources();
        this.G = new e(this);
        return this.B;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.tv_submit) {
            EditText editText = (EditText) this.B.getChildAt(1).findViewById(R.id.et_edit);
            View childAt = this.B.getChildAt(2);
            EditText editText2 = (EditText) childAt.findViewById(R.id.et_edit);
            FontTextView fontTextView = (FontTextView) childAt.findViewById(R.id.tv_warning);
            if (editText.getText() == null || editText2.getText() == null || editText.getText().length() < 4) {
                return;
            }
            if (editText2.getText().length() < 6) {
                fontTextView.setText(getResources().getString(R.string.change_password_delif));
            } else {
                fontTextView.setText("");
                this.C.n(ProfileAvatarImageBeen.getInstance().getPhoneNumber(), editText2.getText().toString().trim(), editText.getText().toString().trim(), new b());
            }
        }
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public void p0(int i7, int i8) {
        this.C.l(new a());
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public void i(Context context, int i7, com.haier.globalwasher.mvp_api.adapter.b bVar, ProfilePagePassBeen profilePagePassBeen) {
        bVar.b(R.id.lly_content, R.id.tv_title_not_frame, R.id.et_edit, R.id.cb_image, R.id.tv_warning, R.id.et_code);
        LinearLayout linearLayout = (LinearLayout) bVar.a(R.id.lly_content);
        FontTextView fontTextView = (FontTextView) bVar.a(R.id.tv_title_not_frame);
        FontTextView fontTextView2 = (FontTextView) bVar.a(R.id.et_code);
        CheckBox checkBox = (CheckBox) bVar.a(R.id.cb_image);
        EditText editText = (EditText) bVar.a(R.id.et_edit);
        TextView textView = (TextView) bVar.a(R.id.tv_warning);
        fontTextView.setText(profilePagePassBeen.getTitle());
        if (i7 == 0) {
            checkBox.setVisibility(8);
            textView.setVisibility(8);
            fontTextView2.setVisibility(8);
            editText.setText(d0.h(profilePagePassBeen.getPhone()));
            editText.setInputType(1);
            editText.setEnabled(false);
            linearLayout.setBackground(context.getResources().getDrawable(R.drawable.cardview_background_huise_not_projection));
        }
        if (i7 == 1) {
            checkBox.setVisibility(8);
            textView.setVisibility(8);
            fontTextView2.setVisibility(0);
            fontTextView2.setText(profilePagePassBeen.getContent());
            editText.setInputType(2);
            fontTextView2.setOnClickListener(new c(fontTextView2));
        }
        if (i7 == 2) {
            textView.setVisibility(0);
            ((LinearLayout.LayoutParams) fontTextView.getLayoutParams()).topMargin = 0;
            checkBox.setVisibility(0);
            checkBox.setOnCheckedChangeListener(new d(editText));
        }
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: y0, reason: merged with bridge method [inline-methods] */
    public com.haier.globalwasher.mvp_api.adapter.b x(int i7, ViewGroup viewGroup) {
        return new com.haier.globalwasher.mvp_api.adapter.b(this, View.inflate(this, R.layout.updata_item_not_pass_frame, null), 2);
    }
}
