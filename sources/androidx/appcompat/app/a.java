package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.n0;
import androidx.drawerlayout.widget.DrawerLayout;
import c.a1;
import c.m0;
import c.o0;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
public class a implements DrawerLayout.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DrawerLayout f782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private androidx.appcompat.graphics.drawable.d f783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Drawable f785e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f786f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f787g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f788h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f789i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    View.OnClickListener f790j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f791k;

    /* JADX INFO: renamed from: androidx.appcompat.app.a$a, reason: collision with other inner class name */
    class ViewOnClickListenerC0019a implements View.OnClickListener {
        ViewOnClickListenerC0019a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            if (aVar.f786f) {
                aVar.v();
                return;
            }
            View.OnClickListener onClickListener = aVar.f790j;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    public interface b {
        void a(Drawable drawable, @a1 int i7);

        Drawable b();

        void c(@a1 int i7);

        boolean d();

        Context e();
    }

    public interface c {
        @o0
        b c();
    }

    private static class d implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Activity f793a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private androidx.appcompat.app.b.a f794b;

        /* JADX INFO: renamed from: androidx.appcompat.app.a$d$a, reason: collision with other inner class name */
        @t0(18)
        static class C0020a {
            private C0020a() {
            }

            @c.t
            static void a(android.app.ActionBar actionBar, int i7) {
                actionBar.setHomeActionContentDescription(i7);
            }

            @c.t
            static void b(android.app.ActionBar actionBar, Drawable drawable) {
                actionBar.setHomeAsUpIndicator(drawable);
            }
        }

        d(Activity activity) {
            this.f793a = activity;
        }

        @Override // androidx.appcompat.app.a.b
        public void a(Drawable drawable, int i7) {
            android.app.ActionBar actionBar = this.f793a.getActionBar();
            if (actionBar != null) {
                C0020a.b(actionBar, drawable);
                C0020a.a(actionBar, i7);
            }
        }

        @Override // androidx.appcompat.app.a.b
        public Drawable b() {
            TypedArray typedArrayObtainStyledAttributes = e().obtainStyledAttributes(null, new int[]{R.attr.homeAsUpIndicator}, R.attr.actionBarStyle, 0);
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
            typedArrayObtainStyledAttributes.recycle();
            return drawable;
        }

        @Override // androidx.appcompat.app.a.b
        public void c(int i7) {
            android.app.ActionBar actionBar = this.f793a.getActionBar();
            if (actionBar != null) {
                C0020a.a(actionBar, i7);
            }
        }

        @Override // androidx.appcompat.app.a.b
        public boolean d() {
            android.app.ActionBar actionBar = this.f793a.getActionBar();
            return (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        @Override // androidx.appcompat.app.a.b
        public Context e() {
            android.app.ActionBar actionBar = this.f793a.getActionBar();
            return actionBar != null ? actionBar.getThemedContext() : this.f793a;
        }
    }

    static class e implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Toolbar f795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Drawable f796b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final CharSequence f797c;

        e(Toolbar toolbar) {
            this.f795a = toolbar;
            this.f796b = toolbar.getNavigationIcon();
            this.f797c = toolbar.getNavigationContentDescription();
        }

        @Override // androidx.appcompat.app.a.b
        public void a(Drawable drawable, @a1 int i7) {
            this.f795a.setNavigationIcon(drawable);
            c(i7);
        }

        @Override // androidx.appcompat.app.a.b
        public Drawable b() {
            return this.f796b;
        }

        @Override // androidx.appcompat.app.a.b
        public void c(@a1 int i7) {
            if (i7 == 0) {
                this.f795a.setNavigationContentDescription(this.f797c);
            } else {
                this.f795a.setNavigationContentDescription(i7);
            }
        }

        @Override // androidx.appcompat.app.a.b
        public boolean d() {
            return true;
        }

        @Override // androidx.appcompat.app.a.b
        public Context e() {
            return this.f795a.getContext();
        }
    }

    public a(Activity activity, DrawerLayout drawerLayout, @a1 int i7, @a1 int i8) {
        this(activity, null, drawerLayout, null, i7, i8);
    }

    private void s(float f8) {
        if (f8 == 1.0f) {
            this.f783c.t(true);
        } else if (f8 == 0.0f) {
            this.f783c.t(false);
        }
        this.f783c.setProgress(f8);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.e
    public void a(View view) {
        s(1.0f);
        if (this.f786f) {
            l(this.f789i);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.e
    public void b(View view) {
        s(0.0f);
        if (this.f786f) {
            l(this.f788h);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.e
    public void c(int i7) {
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.e
    public void d(View view, float f8) {
        if (this.f784d) {
            s(Math.min(1.0f, Math.max(0.0f, f8)));
        } else {
            s(0.0f);
        }
    }

    @m0
    public androidx.appcompat.graphics.drawable.d e() {
        return this.f783c;
    }

    Drawable f() {
        return this.f781a.b();
    }

    public View.OnClickListener g() {
        return this.f790j;
    }

    public boolean h() {
        return this.f786f;
    }

    public boolean i() {
        return this.f784d;
    }

    public void j(Configuration configuration) {
        if (!this.f787g) {
            this.f785e = f();
        }
        u();
    }

    public boolean k(MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != 16908332 || !this.f786f) {
            return false;
        }
        v();
        return true;
    }

    void l(int i7) {
        this.f781a.c(i7);
    }

    void m(Drawable drawable, int i7) {
        if (!this.f791k && !this.f781a.d()) {
            Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
            this.f791k = true;
        }
        this.f781a.a(drawable, i7);
    }

    public void n(@m0 androidx.appcompat.graphics.drawable.d dVar) {
        this.f783c = dVar;
        u();
    }

    public void o(boolean z7) {
        if (z7 != this.f786f) {
            if (z7) {
                m(this.f783c, this.f782b.C(n0.f6717b) ? this.f789i : this.f788h);
            } else {
                m(this.f785e, 0);
            }
            this.f786f = z7;
        }
    }

    public void p(boolean z7) {
        this.f784d = z7;
        if (z7) {
            return;
        }
        s(0.0f);
    }

    public void q(int i7) {
        r(i7 != 0 ? this.f782b.getResources().getDrawable(i7) : null);
    }

    public void r(Drawable drawable) {
        if (drawable == null) {
            this.f785e = f();
            this.f787g = false;
        } else {
            this.f785e = drawable;
            this.f787g = true;
        }
        if (this.f786f) {
            return;
        }
        m(this.f785e, 0);
    }

    public void t(View.OnClickListener onClickListener) {
        this.f790j = onClickListener;
    }

    public void u() {
        if (this.f782b.C(n0.f6717b)) {
            s(1.0f);
        } else {
            s(0.0f);
        }
        if (this.f786f) {
            m(this.f783c, this.f782b.C(n0.f6717b) ? this.f789i : this.f788h);
        }
    }

    void v() {
        int iQ = this.f782b.q(n0.f6717b);
        if (this.f782b.F(n0.f6717b) && iQ != 2) {
            this.f782b.d(n0.f6717b);
        } else if (iQ != 1) {
            this.f782b.K(n0.f6717b);
        }
    }

    public a(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar, @a1 int i7, @a1 int i8) {
        this(activity, toolbar, drawerLayout, null, i7, i8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    a(Activity activity, Toolbar toolbar, DrawerLayout drawerLayout, androidx.appcompat.graphics.drawable.d dVar, @a1 int i7, @a1 int i8) {
        this.f784d = true;
        this.f786f = true;
        this.f791k = false;
        if (toolbar != null) {
            this.f781a = new e(toolbar);
            toolbar.setNavigationOnClickListener(new ViewOnClickListenerC0019a());
        } else if (activity instanceof c) {
            this.f781a = ((c) activity).c();
        } else {
            this.f781a = new d(activity);
        }
        this.f782b = drawerLayout;
        this.f788h = i7;
        this.f789i = i8;
        if (dVar == null) {
            this.f783c = new androidx.appcompat.graphics.drawable.d(this.f781a.e());
        } else {
            this.f783c = dVar;
        }
        this.f785e = f();
    }
}
