package androidx.appcompat.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.q1;
import androidx.core.app.e7;
import androidx.core.app.g0;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.r0;
import androidx.lifecycle.t0;
import c.b0;
import c.b1;
import c.h0;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatActivity extends FragmentActivity implements d, e7.b, androidx.appcompat.app.a.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f713c = "androidx:appcompat";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Resources f715b;

    class a implements androidx.savedstate.b.c {
        a() {
        }

        @Override // androidx.savedstate.b.c
        @m0
        public Bundle a() {
            Bundle bundle = new Bundle();
            AppCompatActivity.this.I().D(bundle);
            return bundle;
        }
    }

    class b implements a.c {
        b() {
        }

        @Override // a.c
        public void a(@m0 Context context) {
            e eVarI = AppCompatActivity.this.I();
            eVarI.u();
            eVarI.z(AppCompatActivity.this.getSavedStateRegistry().b(AppCompatActivity.f713c));
        }
    }

    public AppCompatActivity() {
        K();
    }

    private void D() {
        r0.b(getWindow().getDecorView(), this);
        t0.b(getWindow().getDecorView(), this);
        androidx.savedstate.e.b(getWindow().getDecorView(), this);
    }

    private void K() {
        getSavedStateRegistry().j(f713c, new a());
        addOnContextAvailableListener(new b());
    }

    private boolean Q(KeyEvent keyEvent) {
        Window window;
        return (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true;
    }

    @m0
    public e I() {
        if (this.f714a == null) {
            this.f714a = e.i(this, this);
        }
        return this.f714a;
    }

    @o0
    public ActionBar J() {
        return I().s();
    }

    public void L(@m0 e7 e7Var) {
        e7Var.d(this);
    }

    protected void M(int i7) {
    }

    public void N(@m0 e7 e7Var) {
    }

    @Deprecated
    public void O() {
    }

    public boolean P() {
        Intent intentO = o();
        if (intentO == null) {
            return false;
        }
        if (!Z(intentO)) {
            X(intentO);
            return true;
        }
        e7 e7VarH = e7.h(this);
        L(e7VarH);
        N(e7VarH);
        e7VarH.r();
        try {
            androidx.core.app.b.w(this);
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    public void R(@o0 Toolbar toolbar) {
        I().Q(toolbar);
    }

    @Deprecated
    public void S(int i7) {
    }

    @Deprecated
    public void T(boolean z7) {
    }

    @Deprecated
    public void U(boolean z7) {
    }

    @Deprecated
    public void V(boolean z7) {
    }

    @o0
    public androidx.appcompat.view.b W(@m0 androidx.appcompat.view.b.a aVar) {
        return I().T(aVar);
    }

    public void X(@m0 Intent intent) {
        g0.g(this, intent);
    }

    public boolean Y(int i7) {
        return I().I(i7);
    }

    public boolean Z(@m0 Intent intent) {
        return g0.h(this, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        D();
        I().d(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(I().h(context));
    }

    @Override // androidx.appcompat.app.a.c
    @o0
    public androidx.appcompat.app.a.b c() {
        return I().p();
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        ActionBar actionBarJ = J();
        if (getWindow().hasFeature(0)) {
            if (actionBarJ == null || !actionBarJ.l()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        ActionBar actionBarJ = J();
        if (keyCode == 82 && actionBarJ != null && actionBarJ.L(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(@b0 int i7) {
        return (T) I().n(i7);
    }

    @Override // android.app.Activity
    @m0
    public MenuInflater getMenuInflater() {
        return I().r();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.f715b == null && q1.d()) {
            this.f715b = new q1(this, super.getResources());
        }
        Resources resources = this.f715b;
        return resources == null ? super.getResources() : resources;
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        I().v();
    }

    @Override // androidx.appcompat.app.d
    @c.i
    public void l(@m0 androidx.appcompat.view.b bVar) {
    }

    @Override // androidx.appcompat.app.d
    @c.i
    public void m(@m0 androidx.appcompat.view.b bVar) {
    }

    @Override // androidx.core.app.e7.b
    @o0
    public Intent o() {
        return g0.a(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@m0 Configuration configuration) {
        super.onConfigurationChanged(configuration);
        I().y(configuration);
        if (this.f715b != null) {
            this.f715b.updateConfiguration(super.getResources().getConfiguration(), super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        O();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        I().A();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i7, KeyEvent keyEvent) {
        if (Q(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i7, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i7, @m0 MenuItem menuItem) {
        if (super.onMenuItemSelected(i7, menuItem)) {
            return true;
        }
        ActionBar actionBarJ = J();
        if (menuItem.getItemId() != 16908332 || actionBarJ == null || (actionBarJ.p() & 4) == 0) {
            return false;
        }
        return P();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i7, Menu menu) {
        return super.onMenuOpened(i7, menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i7, @m0 Menu menu) {
        super.onPanelClosed(i7, menu);
    }

    @Override // android.app.Activity
    protected void onPostCreate(@o0 Bundle bundle) {
        super.onPostCreate(bundle);
        I().B(bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        I().C();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        I().E();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        I().F();
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i7) {
        super.onTitleChanged(charSequence, i7);
        I().S(charSequence);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        ActionBar actionBarJ = J();
        if (getWindow().hasFeature(0)) {
            if (actionBarJ == null || !actionBarJ.M()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // androidx.appcompat.app.d
    @o0
    public androidx.appcompat.view.b q(@m0 androidx.appcompat.view.b.a aVar) {
        return null;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(@h0 int i7) {
        D();
        I().K(i7);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(@b1 int i7) {
        super.setTheme(i7);
        I().R(i7);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void supportInvalidateOptionsMenu() {
        I().v();
    }

    @c.o
    public AppCompatActivity(@h0 int i7) {
        super(i7);
        K();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        D();
        I().L(view);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        D();
        I().M(view, layoutParams);
    }
}
