package com.haier.hailicommontlib.mvp.model.utils.loading;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.haier.hailicommontlib.R;

/* JADX INFO: loaded from: classes2.dex */
public class b extends AlertDialog implements c3.b<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f26191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f26192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f26193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ImageView f26194d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    AnimationDrawable f26195e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Context f26196f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f26197g;

    public b(Context context, int i7, boolean z7) {
        super(context);
        this.f26193c = null;
        this.f26197g = z7;
        this.f26196f = context;
        this.f26192b = i7;
        this.f26193c = context.getResources().getString(R.string.xlistview_header_hint_loading);
    }

    @Override // c3.b
    public void b() {
        dismiss();
    }

    @Override // c3.b
    public void c() {
        if (isShowing() || ((Activity) this.f26196f).isFinishing()) {
            return;
        }
        show();
    }

    @Override // c3.b
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void a(String str) {
        this.f26193c = str;
        if (this.f26191a != null) {
            if (str == null || str.length() <= 0) {
                this.f26191a.setVisibility(8);
            } else {
                this.f26191a.setText(str);
            }
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        AnimationDrawable animationDrawable = this.f26195e;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.loading_circle);
        this.f26191a = (TextView) findViewById(R.id.tips_loading_msg);
        ImageView imageView = (ImageView) findViewById(R.id.iv_loading);
        this.f26194d = imageView;
        this.f26195e = (AnimationDrawable) imageView.getBackground();
        String str = this.f26193c;
        if (str == null || str.length() <= 0) {
            this.f26191a.setVisibility(8);
        } else {
            this.f26191a.setText(this.f26193c);
        }
        setCanceledOnTouchOutside(this.f26197g);
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
        this.f26197g = z7;
    }

    @Override // android.app.Dialog
    public final void show() {
        try {
            super.show();
            AnimationDrawable animationDrawable = this.f26195e;
            if (animationDrawable != null) {
                animationDrawable.start();
            }
        } catch (Exception e8) {
            e8.printStackTrace();
        }
    }

    public b(Context context, int i7, String str, boolean z7) {
        super(context);
        this.f26196f = context;
        this.f26192b = i7;
        this.f26197g = z7;
        this.f26193c = str;
    }
}
