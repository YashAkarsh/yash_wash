package com.haier.globalwasher.modle.utils.loading;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.mvp_api.moudle.c;

/* JADX INFO: loaded from: classes2.dex */
public class b extends AlertDialog implements c<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f24654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f24655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f24656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ImageView f24657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    AnimationDrawable f24658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Context f24659f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f24660g;

    public b(Context context, int i7, boolean z7) {
        super(context);
        this.f24656c = null;
        this.f24660g = z7;
        this.f24659f = context;
        this.f24655b = i7;
        this.f24656c = context.getResources().getString(R.string.xlistview_header_hint_loading);
    }

    @Override // com.haier.globalwasher.mvp_api.moudle.c
    public void b() {
        dismiss();
    }

    @Override // com.haier.globalwasher.mvp_api.moudle.c
    public void c() {
        ((BaseActivity) this.f24659f).L(this);
        if (isShowing() || ((BaseActivity) this.f24659f).isFinishing()) {
            return;
        }
        show();
    }

    @Override // com.haier.globalwasher.mvp_api.moudle.c
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void a(String str) {
        this.f24656c = str;
        if (this.f24654a != null) {
            if (str == null || str.length() <= 0) {
                this.f24654a.setVisibility(8);
            } else {
                this.f24654a.setText(str);
            }
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        AnimationDrawable animationDrawable = this.f24658e;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.loading_circle);
        this.f24654a = (TextView) findViewById(R.id.tips_loading_msg);
        ImageView imageView = (ImageView) findViewById(R.id.iv_loading);
        this.f24657d = imageView;
        this.f24658e = (AnimationDrawable) imageView.getBackground();
        String str = this.f24656c;
        if (str == null || str.length() <= 0) {
            this.f24654a.setVisibility(8);
        } else {
            this.f24654a.setText(this.f24656c);
        }
        setCanceledOnTouchOutside(this.f24660g);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.gravity = 80;
            attributes.width = -1;
            attributes.height = -1;
            window.getDecorView().setPadding(0, 0, 0, 0);
            getWindow().setAttributes(attributes);
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z7) {
        this.f24660g = z7;
    }

    @Override // android.app.Dialog
    public final void show() {
        super.show();
        AnimationDrawable animationDrawable = this.f24658e;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
    }

    public b(Context context, int i7, String str, boolean z7) {
        super(context);
        this.f24659f = context;
        this.f24655b = i7;
        this.f24660g = z7;
        this.f24656c = str;
    }
}
