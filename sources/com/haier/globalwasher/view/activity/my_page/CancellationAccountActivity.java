package com.haier.globalwasher.view.activity.my_page;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.utils.d0;
import com.haier.globalwasher.presenter.broadcast_receiver.QuitLoginBroadcastReceiver;
import com.haier.globalwasher.view.activity.WebActivity;
import java.lang.ref.SoftReference;
import java.text.MessageFormat;

/* JADX INFO: loaded from: classes2.dex */
public class CancellationAccountActivity extends BaseActivity {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    x2.a f25647u = new x2.a();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private TextView f25648v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private CheckBox f25649w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private TextView f25650x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private TextView f25651y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    QuitLoginBroadcastReceiver f25652z;

    class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z7) {
            if (z7) {
                CancellationAccountActivity.this.f25650x.setBackground(CancellationAccountActivity.this.getResources().getDrawable(R.drawable.background_blue_button, null));
                CancellationAccountActivity.this.f25650x.setOnClickListener(CancellationAccountActivity.this);
            } else {
                CancellationAccountActivity.this.f25650x.setBackground(CancellationAccountActivity.this.getResources().getDrawable(R.drawable.background_huise_button, null));
                CancellationAccountActivity.this.f25650x.setOnClickListener(null);
            }
        }
    }

    private class b extends ClickableSpan {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f25654c = 1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f25655d = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25656a;

        public b(int i7) {
            this.f25656a = i7;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            int i7 = this.f25656a;
            if (i7 == 1) {
                CancellationAccountActivity.this.f25649w.performClick();
            } else {
                if (i7 != 2) {
                    return;
                }
                CancellationAccountActivity cancellationAccountActivity = CancellationAccountActivity.this;
                WebActivity.j0(cancellationAccountActivity, cancellationAccountActivity.getResources().getString(R.string.scan_qr_code_title), i2.a.S1);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
        }
    }

    private static class c extends QuitLoginBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private SoftReference<BaseActivity> f25658a;

        public c(BaseActivity baseActivity) {
            this.f25658a = new SoftReference<>(baseActivity);
        }

        @Override // com.haier.globalwasher.presenter.broadcast_receiver.QuitLoginBroadcastReceiver
        protected void a(Intent intent) {
            if (this.f25658a.get() == null || this.f25658a.get().isFinishing()) {
                return;
            }
            this.f25658a.get().finish();
        }
    }

    public static void i0(BaseActivity baseActivity) {
        baseActivity.startActivity(new Intent(baseActivity, (Class<?>) CancellationAccountActivity.class));
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void a() {
        this.f25649w.setOnCheckedChangeListener(new a());
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_cancellation_account;
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void d() {
        d0(getResources().getString(R.string.secuity_center_cancellation_accoun), 1, new View[0]);
        this.f25648v = (TextView) findViewById(R.id.tv_phone_number);
        this.f25649w = (CheckBox) findViewById(R.id.cb_prompt_is_read);
        this.f25650x = (TextView) findViewById(R.id.tv_jump_next_page);
        this.f25651y = (TextView) findViewById(R.id.tv_url_of_protocol);
        this.f25648v.setText(MessageFormat.format(getResources().getString(R.string.cancellation_account_msg_1), d0.d(t2.a.a(this, t2.a.f40354a, t2.a.f40357d))));
        SpannableString spannableString = new SpannableString(getResources().getString(R.string.cancellation_account_protocol));
        int iIndexOf = spannableString.toString().indexOf("《");
        int iIndexOf2 = spannableString.toString().indexOf("》") + 1;
        spannableString.setSpan(new b(2), iIndexOf, iIndexOf2, 33);
        spannableString.setSpan(new b(1), 0, iIndexOf, 33);
        spannableString.setSpan(new TextAppearanceSpan(this, R.style.string_color_change_gray), 0, iIndexOf, 33);
        spannableString.setSpan(new TextAppearanceSpan(this, R.style.string_color_change_blue), iIndexOf, iIndexOf2, 33);
        this.f25651y.setText(spannableString, TextView.BufferType.SPANNABLE);
        this.f25651y.setMovementMethod(LinkMovementMethod.getInstance());
        this.f25652z = new c(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(i2.a.f34126p);
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(this.f25652z, intentFilter, 4);
        } else {
            registerReceiver(this.f25652z, intentFilter);
        }
    }

    @Override // com.haier.globalwasher.mvp_api.view.a
    public void e() {
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public com.haier.globalwasher.mvp_api.presenter.b f() {
        return this.f25647u;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.tv_jump_next_page) {
            AuthenticationCenterActivity.w0(this);
        }
    }
}
