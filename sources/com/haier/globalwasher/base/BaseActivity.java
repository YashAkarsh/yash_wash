package com.haier.globalwasher.base;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import c.n;
import c.t0;
import c.u;
import com.haier.globalwasher.MyApplication;
import com.haier.globalwasher.R;
import com.haier.globalwasher.modle.utils.i0;
import com.haier.globalwasher.modle.utils.n0;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.modle.utils.x;
import com.haier.globalwasher.view.custom_view.FontTextView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseActivity extends FragmentActivity implements com.haier.globalwasher.mvp_api.view.a, View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.haier.globalwasher.mvp_api.presenter.b f24263a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f24265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f24266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Toolbar f24267e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    View f24268f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    View f24269g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LinearLayout f24270h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Bundle f24271i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PersistableBundle f24272j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private View f24273k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private TextView f24274l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ArrayList<PopupWindow> f24275m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ArrayList<DialogInterface> f24276n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    TextView f24277o;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f24264b = "BaseActivity";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f24278p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    ArrayList<View> f24279q = new ArrayList<>();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f24280r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f24281s = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f24282t = 2;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseActivity.this.e();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseActivity.this.W();
            BaseActivity.this.onBackPressed();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseActivity.this.W();
            BaseActivity.this.onBackPressed();
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseActivity.this.W();
            BaseActivity.this.onBackPressed();
        }
    }

    public static boolean I(Window window, boolean z7) {
        if (window != null) {
            try {
                WindowManager.LayoutParams attributes = window.getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i7 = declaredField.getInt(null);
                int i8 = declaredField2.getInt(attributes);
                declaredField2.setInt(attributes, z7 ? i8 | i7 : (~i7) & i8);
                window.setAttributes(attributes);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private void R() {
        int i7 = 0;
        int i8 = 0;
        while (true) {
            ArrayList<PopupWindow> arrayList = this.f24275m;
            if (arrayList == null || i8 >= arrayList.size()) {
                break;
            }
            if (this.f24275m.get(i8) != null) {
                this.f24275m.get(i8).dismiss();
            }
            i8++;
        }
        while (true) {
            ArrayList<DialogInterface> arrayList2 = this.f24276n;
            if (arrayList2 == null || i7 >= arrayList2.size()) {
                return;
            }
            if (this.f24276n.get(i7) != null) {
                this.f24276n.get(i7).dismiss();
            }
            i7++;
        }
    }

    public static boolean X(Window window, boolean z7) {
        if (window != null) {
            try {
                WindowManager.LayoutParams attributes = window.getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i7 = declaredField.getInt(null);
                int i8 = declaredField2.getInt(attributes);
                declaredField2.setInt(attributes, z7 ? i8 | i7 : (~i7) & i8);
                window.setAttributes(attributes);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    @t0(api = 23)
    public boolean J(Window window, boolean z7) {
        if (window == null) {
            return false;
        }
        q.c(this.f24264b, "Rom.isMiui()=" + x.h() + "  Rom.isEmui()=" + x.f());
        if (!x.h()) {
            if (x.g()) {
                I(window, z7);
                return false;
            }
            Y();
            return false;
        }
        Class<?> cls = window.getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i7 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Class<?> cls3 = Integer.TYPE;
            Method method = cls.getMethod("setExtraFlags", cls3, cls3);
            if (z7) {
                method.invoke(window, Integer.valueOf(i7), Integer.valueOf(i7));
            } else {
                method.invoke(window, 0, Integer.valueOf(i7));
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void K(View... viewArr) {
        this.f24279q.clear();
        for (int i7 = 0; i7 < viewArr.length; i7++) {
            if (viewArr[i7].getId() == R.id.utiles_temporarily_no_data) {
                this.f24280r = i7;
            } else if (viewArr[i7].getId() == R.id.utiles_reload_the) {
                this.f24281s = i7;
            }
            this.f24279q.add(viewArr[i7]);
        }
    }

    public void L(DialogInterface dialogInterface) {
        if (this.f24276n == null) {
            this.f24276n = new ArrayList<>();
        }
        this.f24276n.add(dialogInterface);
    }

    public void M(PopupWindow popupWindow) {
        if (this.f24275m == null) {
            this.f24275m = new ArrayList<>();
        }
        this.f24275m.add(popupWindow);
    }

    public View N(@u int i7, View.OnClickListener onClickListener) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        ImageView imageView = new ImageView(this);
        imageView.setImageDrawable(getResources().getDrawable(i7));
        imageView.setOnClickListener(onClickListener);
        layoutParams.setMargins(0, 0, getResources().getDimensionPixelSize(R.dimen.defult_padding_16), 0);
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    public View O(String str, @n int i7, View.OnClickListener onClickListener) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        TextView textView = new TextView(this);
        this.f24277o = textView;
        textView.setTextColor(getResources().getColor(i7));
        this.f24277o.setTextSize(12.0f);
        this.f24277o.setText(str);
        this.f24277o.setOnClickListener(onClickListener);
        layoutParams.setMargins(0, 0, getResources().getDimensionPixelSize(R.dimen.defult_padding_16), 0);
        this.f24277o.setLayoutParams(layoutParams);
        return this.f24277o;
    }

    public View P(String str, View.OnClickListener onClickListener) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        TextView textView = new TextView(this);
        this.f24277o = textView;
        textView.setTextColor(getResources().getColor(R.color.app_white));
        this.f24277o.setTextSize(12.0f);
        this.f24277o.setText(str);
        this.f24277o.setOnClickListener(onClickListener);
        layoutParams.setMargins(0, 0, getResources().getDimensionPixelSize(R.dimen.defult_padding_16), 0);
        this.f24277o.setLayoutParams(layoutParams);
        return this.f24277o;
    }

    public void Q(View view, int i7) {
        if (this.f24279q.size() > i7) {
            for (int i8 = 0; i8 < this.f24279q.size(); i8++) {
                if (view != null) {
                    if (i7 == this.f24281s) {
                        view.setVisibility(8);
                    } else if (!view.isShown()) {
                        view.setVisibility(0);
                    }
                }
                if (i8 == i7) {
                    this.f24279q.get(i8).setVisibility(0);
                } else {
                    this.f24279q.get(i8).setVisibility(8);
                }
            }
        }
    }

    public <V extends View> V S(int i7, boolean z7) {
        V v7 = (V) this.f24266d.findViewById(i7);
        if (z7) {
            v7.setOnClickListener(this);
        }
        return v7;
    }

    public void T(boolean z7, BaseActivity baseActivity) {
        if (this.f24267e != null) {
            ImageView imageView = (ImageView) this.f24273k.findViewById(R.id.iv_bolang);
            if (z7) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        if (baseActivity != null) {
            com.haier.globalwasher.modle.utils.a.c(baseActivity);
        }
    }

    public void U(boolean z7) {
        Toolbar toolbar = this.f24267e;
        if (toolbar != null) {
            if (z7) {
                toolbar.setVisibility(0);
            } else {
                toolbar.setVisibility(8);
            }
            T(z7, this);
        }
    }

    public void V(String str) {
        if (str == null) {
            this.f24274l.setVisibility(8);
            return;
        }
        this.f24274l.setVisibility(0);
        if (str.length() > 0) {
            this.f24274l.setText(str);
        }
    }

    public void W() {
    }

    @t0(api = 23)
    protected void Y() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.getDecorView().setSystemUiVisibility(9216);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
    }

    public void Z(@n int i7) {
        Window window = getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(getResources().getColor(i7));
    }

    @Override // com.haier.globalwasher.mvp_api.view.a
    public abstract void a();

    public final void a0() {
        J(getWindow(), true);
    }

    public void addViewInToolbarBottom(View view) {
        if (view == null) {
            this.f24270h.setVisibility(8);
            return;
        }
        this.f24270h.setVisibility(0);
        if (this.f24278p == 0) {
            this.f24270h.addView(view);
        }
        this.f24278p = 1;
    }

    @Override // com.haier.globalwasher.mvp_api.view.a
    public abstract int b();

    protected void b0(String str, int i7, @n int i8, @n int i9, int i10, View... viewArr) {
        Toolbar toolbar = this.f24267e;
        if (toolbar != null) {
            TextView textView = (TextView) toolbar.findViewById(R.id.toolbar_title);
            ((RelativeLayout) this.f24267e.findViewById(R.id.lly_toolbar_top)).setVisibility(0);
            this.f24267e.setTitle(" ");
            textView.setText("" + str);
            ImageView imageView = (ImageView) this.f24267e.findViewById(R.id.iv_back_image);
            this.f24267e.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            if (i7 == 1) {
                imageView.setVisibility(0);
                imageView.setOnClickListener(new c());
            } else if (i7 != 2) {
                imageView.setVisibility(8);
            } else {
                a0();
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.icon_fanhui_gray));
                imageView.setVisibility(0);
                imageView.setOnClickListener(new d());
            }
            if (viewArr != null && viewArr.length > 0) {
                LinearLayout linearLayout = (LinearLayout) this.f24267e.findViewById(R.id.lly_right_view);
                for (View view : viewArr) {
                    if (view != null) {
                        linearLayout.addView(view);
                    }
                }
            }
            if (i8 != 0 && i8 != -1) {
                this.f24267e.setBackgroundColor(getColor(i8));
            }
            if (i9 != 0 && i9 != -1) {
                textView.setTextColor(getColor(i9));
            }
            if (i10 == 0 || i10 == -1) {
                return;
            }
            textView.setTextSize(i10);
            textView.getPaint().setFakeBoldText(true);
        }
    }

    protected void c0(String str, int i7, @n int i8, @n int i9, View... viewArr) {
        b0(str, i7, i8, i9, 0, viewArr);
    }

    @Override // com.haier.globalwasher.mvp_api.view.a
    public abstract void d();

    public void d0(String str, int i7, View... viewArr) {
        Toolbar toolbar = this.f24267e;
        if (toolbar != null) {
            ((RelativeLayout) toolbar.findViewById(R.id.lly_toolbar_top)).setVisibility(0);
            this.f24267e.setNavigationIcon((Drawable) null);
            FontTextView fontTextView = (FontTextView) this.f24267e.findViewById(R.id.toolbar_title);
            ImageView imageView = (ImageView) this.f24267e.findViewById(R.id.iv_back_image);
            this.f24267e.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            if (i7 == 1) {
                imageView.setVisibility(0);
                imageView.setOnClickListener(new b());
            } else {
                imageView.setVisibility(8);
            }
            fontTextView.setText("" + str);
            fontTextView.setTextColor(getResources().getColor(R.color.toobar_text));
            if (viewArr == null || viewArr.length <= 0) {
                return;
            }
            LinearLayout linearLayout = (LinearLayout) this.f24267e.findViewById(R.id.lly_right_view);
            for (View view : viewArr) {
                if (view != null) {
                    linearLayout.addView(view);
                }
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            n0.i(motionEvent, getCurrentFocus(), this);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void e0(boolean z7) {
        Toolbar toolbar = this.f24267e;
        if (toolbar != null) {
            RelativeLayout relativeLayout = (RelativeLayout) toolbar.findViewById(R.id.lly_toolbar_top);
            if (z7) {
                relativeLayout.setVisibility(0);
            } else {
                relativeLayout.setVisibility(8);
            }
        }
    }

    @Override // com.haier.globalwasher.mvp_api.view.a
    public abstract com.haier.globalwasher.mvp_api.presenter.b f();

    public void f0(String str) {
        TextView textView = this.f24277o;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // android.app.Activity, com.haier.globalwasher.mvp_api.view.a
    public <V extends View> V findViewById(int i7) {
        return (V) this.f24266d.findViewById(i7);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f24271i = bundle;
        setRequestedOrientation(1);
        com.haier.globalwasher.mvp_api.presenter.b bVarF = f();
        this.f24263a = bVarF;
        if (bVarF != null) {
            bVarF.a(this);
        }
        q.c("BaseActivity", "" + getClass().getSimpleName());
        int iB = b();
        this.f24265c = iB;
        this.f24266d = View.inflate(this, iB, null);
        View viewInflate = View.inflate(this, R.layout.activity_base, null);
        this.f24273k = viewInflate;
        Toolbar toolbar = (Toolbar) viewInflate.findViewById(R.id.include2);
        this.f24267e = toolbar;
        this.f24270h = (LinearLayout) toolbar.findViewById(R.id.toolbar_bottom);
        this.f24268f = this.f24273k.findViewById(R.id.utiles_reload_the);
        this.f24269g = this.f24273k.findViewById(R.id.utiles_temporarily_no_data);
        this.f24268f.findViewById(R.id.reload_btn).setOnClickListener(new a());
        ((FrameLayout) this.f24273k.findViewById(R.id.fly_)).addView(this.f24266d);
        this.f24274l = (TextView) this.f24273k.findViewById(R.id.tv_notdata_message);
        K(this.f24269g, this.f24268f);
        setContentView(this.f24273k);
        d();
        a();
        MyApplication.f(this);
        Log.i(this.f24264b, getPackageName() + "--" + getLocalClassName());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        try {
            R();
        } catch (Exception unused) {
            if (MyApplication.f24259o) {
                i0.d(this, "弹窗销毁错误");
            }
        }
        MyApplication.p(this);
        q.c(this.f24264b, "onDestroy=" + toString());
        ArrayList<BaseActivity> arrayList = MyApplication.f24251g;
        if (arrayList == null || arrayList.size() != 0) {
            return;
        }
        MyApplication.e();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i7, KeyEvent keyEvent) {
        if (i7 != 4) {
            return super.onKeyDown(i7, keyEvent);
        }
        onBackPressed();
        W();
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
    }
}
