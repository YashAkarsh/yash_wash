package com.haier.globalwasher.modle.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.haier.globalwasher.MyApplication;
import com.haier.globalwasher.R;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AlertDialog f24749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Button f24750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Button f24751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Button f24752d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static TextView f24753e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static TextView f24754f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static TextView f24755g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static TextView f24756h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static TextView f24757i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static TextView f24758j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static View f24759k;

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f24760a;

        a(View.OnClickListener onClickListener) {
            this.f24760a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            z.f24749a.dismiss();
            View.OnClickListener onClickListener = this.f24760a;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f24761a;

        b(View.OnClickListener onClickListener) {
            this.f24761a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f24761a.onClick(view);
            z.f24749a.cancel();
        }
    }

    class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f24762a;

        c(View.OnClickListener onClickListener) {
            this.f24762a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f24762a.onClick(view);
            z.f24749a.cancel();
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            z.f24749a.cancel();
        }
    }

    class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f24763a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f24764b;

        e(int i7, View.OnClickListener onClickListener) {
            this.f24763a = i7;
            this.f24764b = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f24763a == 1) {
                z.f24749a.dismiss();
            } else {
                this.f24764b.onClick(view);
                z.f24749a.dismiss();
            }
        }
    }

    class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f24765a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f24766b;

        f(int i7, View.OnClickListener onClickListener) {
            this.f24765a = i7;
            this.f24766b = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View.OnClickListener onClickListener;
            z.f24749a.dismiss();
            if (this.f24765a == 1 || (onClickListener = this.f24766b) == null) {
                return;
            }
            onClickListener.onClick(view);
        }
    }

    class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f24767a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f24768b;

        g(int i7, View.OnClickListener onClickListener) {
            this.f24767a = i7;
            this.f24768b = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View.OnClickListener onClickListener;
            z.f24749a.dismiss();
            if (this.f24767a == 1 || (onClickListener = this.f24768b) == null) {
                return;
            }
            onClickListener.onClick(view);
        }
    }

    class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f24769a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f24770b;

        h(int i7, View.OnClickListener onClickListener) {
            this.f24769a = i7;
            this.f24770b = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f24769a == 1) {
                z.f24749a.dismiss();
            } else {
                z.f24749a.dismiss();
                this.f24770b.onClick(view);
            }
        }
    }

    class i implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f24771a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f24772b;

        i(int i7, View.OnClickListener onClickListener) {
            this.f24771a = i7;
            this.f24772b = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f24771a == 1) {
                z.f24749a.dismiss();
            } else {
                z.f24749a.dismiss();
                this.f24772b.onClick(view);
            }
        }
    }

    class j implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f24773a;

        j(View.OnClickListener onClickListener) {
            this.f24773a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            z.f24749a.dismiss();
            View.OnClickListener onClickListener = this.f24773a;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    public static void b(Activity activity, int i7, int i8, int i9, String str, String str2, String str3, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        if (com.haier.globalwasher.modle.utils.i.a()) {
            return;
        }
        if (activity == null) {
            i0.d(MyApplication.k(), "上下文等于NULL");
            return;
        }
        f24749a = new AlertDialog.Builder(activity).create();
        if (!activity.isFinishing()) {
            try {
                f24749a.show();
            } catch (Exception unused) {
            }
        }
        f24749a.setCancelable(false);
        f24749a.getWindow().setBackgroundDrawable(new ColorDrawable());
        f24749a.setContentView(R.layout.show_pop_dialog_button);
        f24753e = (TextView) f24749a.getWindow().findViewById(R.id.font_button_title_id);
        f24754f = (TextView) f24749a.getWindow().findViewById(R.id.font_button_text_id);
        TextView textView = (TextView) f24749a.getWindow().findViewById(R.id.font_button_id);
        f24756h = textView;
        textView.setText("" + str3);
        if ("".equals(str)) {
            f24753e.setVisibility(8);
        } else {
            f24753e.setVisibility(0);
        }
        if (i7 == 1) {
            f24749a.getWindow().findViewById(R.id.button_img).setVisibility(0);
        } else {
            f24749a.getWindow().findViewById(R.id.button_img).setVisibility(8);
        }
        f24753e.setText("" + str);
        f24754f.setText("" + str2);
        f24749a.getWindow().findViewById(R.id.font_button_id).setOnClickListener(new f(i8, onClickListener));
        f24749a.getWindow().findViewById(R.id.button_img).setOnClickListener(new g(i9, onClickListener2));
    }

    public static void c(Activity activity, int i7, int i8, String str, String str2, String str3, String str4, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        if (activity == null) {
            i0.d(MyApplication.k(), "上下文等于NULL");
            return;
        }
        f24749a = new AlertDialog.Builder(activity).create();
        if (!activity.isFinishing()) {
            f24749a.show();
        }
        f24749a.setCancelable(false);
        f24749a.getWindow().setBackgroundDrawable(new ColorDrawable());
        f24749a.setContentView(R.layout.show_pop_dialog_tow_button);
        f24753e = (TextView) f24749a.getWindow().findViewById(R.id.font_button_title_id);
        f24754f = (TextView) f24749a.getWindow().findViewById(R.id.font_button_text_id);
        f24758j = (TextView) f24749a.getWindow().findViewById(R.id.font_button_id_no);
        f24757i = (TextView) f24749a.getWindow().findViewById(R.id.font_button_id_yes);
        f24758j.setText("" + str3);
        f24757i.setText("" + str4);
        if ("".equals(str)) {
            f24753e.setVisibility(8);
        } else {
            f24753e.setVisibility(0);
        }
        f24753e.setText("" + str);
        f24754f.setText("" + str2);
        f24749a.getWindow().findViewById(R.id.font_button_id_no).setOnClickListener(new h(i7, onClickListener));
        f24749a.getWindow().findViewById(R.id.font_button_id_yes).setOnClickListener(new i(i8, onClickListener2));
    }

    public static void d(Activity activity, int i7, String str, String str2, String str3, View.OnClickListener onClickListener) {
        if (activity == null) {
            i0.d(MyApplication.k(), "上下文等于NULL");
            return;
        }
        f24749a = new AlertDialog.Builder(activity).create();
        if (!activity.isFinishing()) {
            f24749a.show();
        }
        f24749a.getWindow().setBackgroundDrawable(new ColorDrawable());
        f24749a.setContentView(R.layout.show_pop_dialog_no_button);
        f24753e = (TextView) f24749a.getWindow().findViewById(R.id.font_no_button_title_id);
        f24754f = (TextView) f24749a.getWindow().findViewById(R.id.font_no_button_text_id);
        f24755g = (TextView) f24749a.getWindow().findViewById(R.id.font_no_button_texts_id);
        f24759k = f24749a.getWindow().findViewById(R.id.font_no_button_line_id);
        if (TextUtils.isEmpty(str3)) {
            f24755g.setVisibility(8);
            f24759k.setVisibility(8);
        } else {
            f24755g.setVisibility(0);
            f24759k.setVisibility(0);
        }
        if ("".equals(str)) {
            f24753e.setVisibility(8);
        } else {
            f24753e.setVisibility(0);
        }
        f24753e.setText("" + str);
        f24754f.setText("" + str2);
        f24755g.setText("" + str3);
        f24749a.getWindow().findViewById(R.id.no_button_img).setOnClickListener(new e(i7, onClickListener));
    }

    public static void e(Activity activity, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        int width = activity.getWindowManager().getDefaultDisplay().getWidth();
        AlertDialog alertDialogCreate = new AlertDialog.Builder(activity).create();
        f24749a = alertDialogCreate;
        alertDialogCreate.show();
        Window window = f24749a.getWindow();
        window.setGravity(80);
        window.setLayout(width, -2);
        window.setContentView(R.layout.person_image);
        Button button = (Button) window.findViewById(R.id.person_image_camera_bt);
        f24750b = button;
        button.setOnClickListener(new b(onClickListener));
        Button button2 = (Button) window.findViewById(R.id.person_image_phote_bt);
        f24751c = button2;
        button2.setOnClickListener(new c(onClickListener2));
        Button button3 = (Button) window.findViewById(R.id.person_image_cancel_bt);
        f24752d = button3;
        button3.setOnClickListener(new d());
    }

    public static void f(Activity activity, String str, String str2, String str3, String str4, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        if (activity == null) {
            i0.d(MyApplication.k(), "上下文等于NULL");
            return;
        }
        f24749a = new AlertDialog.Builder(activity).create();
        if (!activity.isFinishing()) {
            f24749a.show();
        }
        Window window = f24749a.getWindow();
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.95d);
            attributes.gravity = 17;
            window.setAttributes(attributes);
            window.setBackgroundDrawable(new ColorDrawable());
        }
        f24749a.setCancelable(false);
        f24749a.getWindow().setBackgroundDrawable(new ColorDrawable());
        f24749a.setContentView(R.layout.show_pop_dialog_tow_button);
        f24753e = (TextView) f24749a.getWindow().findViewById(R.id.font_button_title_id);
        f24754f = (TextView) f24749a.getWindow().findViewById(R.id.font_button_text_id);
        f24758j = (TextView) f24749a.getWindow().findViewById(R.id.font_button_id_no);
        f24757i = (TextView) f24749a.getWindow().findViewById(R.id.font_button_id_yes);
        f24758j.setText("" + str3);
        f24757i.setText("" + str4);
        if ("".equals(str)) {
            f24753e.setVisibility(8);
        } else {
            f24753e.setVisibility(0);
        }
        f24753e.setText("" + str);
        f24754f.setText("" + str2);
        f24749a.getWindow().findViewById(R.id.font_button_id_no).setOnClickListener(new j(onClickListener));
        f24749a.getWindow().findViewById(R.id.font_button_id_yes).setOnClickListener(new a(onClickListener2));
    }
}
