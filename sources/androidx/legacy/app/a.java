package androidx.legacy.app;

import android.R;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.n0;
import androidx.core.view.n2;
import androidx.drawerlayout.widget.DrawerLayout;
import c.a1;
import c.m0;
import c.o0;
import c.u;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class a implements DrawerLayout.e {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f8180m = "ActionBarDrawerToggle";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int[] f8181n = {R.attr.homeAsUpIndicator};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final float f8182o = 0.33333334f;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f8183p = 16908332;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Activity f8184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterfaceC0099a f8185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DrawerLayout f8186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f8187d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f8188e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Drawable f8189f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Drawable f8190g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private d f8191h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f8192i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f8193j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f8194k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private c f8195l;

    /* JADX INFO: renamed from: androidx.legacy.app.a$a, reason: collision with other inner class name */
    @Deprecated
    public interface InterfaceC0099a {
        void a(Drawable drawable, @a1 int i7);

        @o0
        Drawable b();

        void c(@a1 int i7);
    }

    @Deprecated
    public interface b {
        @o0
        InterfaceC0099a c();
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Method f8196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Method f8197b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ImageView f8198c;

        c(Activity activity) {
            try {
                this.f8196a = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", Drawable.class);
                this.f8197b = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", Integer.TYPE);
            } catch (NoSuchMethodException unused) {
                View viewFindViewById = activity.findViewById(16908332);
                if (viewFindViewById == null) {
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) viewFindViewById.getParent();
                if (viewGroup.getChildCount() != 2) {
                    return;
                }
                View childAt = viewGroup.getChildAt(0);
                childAt = childAt.getId() == 16908332 ? viewGroup.getChildAt(1) : childAt;
                if (childAt instanceof ImageView) {
                    this.f8198c = (ImageView) childAt;
                }
            }
        }
    }

    private class d extends InsetDrawable implements Drawable.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f8199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Rect f8200b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f8201c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f8202d;

        d(Drawable drawable) {
            super(drawable, 0);
            this.f8199a = true;
            this.f8200b = new Rect();
        }

        public float a() {
            return this.f8201c;
        }

        public void b(float f8) {
            this.f8202d = f8;
            invalidateSelf();
        }

        public void c(float f8) {
            this.f8201c = f8;
            invalidateSelf();
        }

        @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(@m0 Canvas canvas) {
            copyBounds(this.f8200b);
            canvas.save();
            boolean z7 = n2.Z(a.this.f8184a.getWindow().getDecorView()) == 1;
            int i7 = z7 ? -1 : 1;
            float fWidth = this.f8200b.width();
            canvas.translate((-this.f8202d) * fWidth * this.f8201c * i7, 0.0f);
            if (z7 && !this.f8199a) {
                canvas.translate(fWidth, 0.0f);
                canvas.scale(-1.0f, 1.0f);
            }
            super.draw(canvas);
            canvas.restore();
        }
    }

    public a(Activity activity, DrawerLayout drawerLayout, @u int i7, @a1 int i8, @a1 int i9) {
        this(activity, drawerLayout, !e(activity), i7, i8, i9);
    }

    private static boolean e(Context context) {
        return context.getApplicationInfo().targetSdkVersion >= 21;
    }

    private Drawable f() {
        InterfaceC0099a interfaceC0099a = this.f8185b;
        if (interfaceC0099a != null) {
            return interfaceC0099a.b();
        }
        ActionBar actionBar = this.f8184a.getActionBar();
        TypedArray typedArrayObtainStyledAttributes = (actionBar != null ? actionBar.getThemedContext() : this.f8184a).obtainStyledAttributes(null, f8181n, R.attr.actionBarStyle, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.recycle();
        return drawable;
    }

    private void j(int i7) {
        InterfaceC0099a interfaceC0099a = this.f8185b;
        if (interfaceC0099a != null) {
            interfaceC0099a.c(i7);
            return;
        }
        ActionBar actionBar = this.f8184a.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeActionContentDescription(i7);
        }
    }

    private void k(Drawable drawable, int i7) {
        InterfaceC0099a interfaceC0099a = this.f8185b;
        if (interfaceC0099a != null) {
            interfaceC0099a.a(drawable, i7);
            return;
        }
        ActionBar actionBar = this.f8184a.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(drawable);
            actionBar.setHomeActionContentDescription(i7);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.e
    public void a(View view) {
        this.f8191h.c(1.0f);
        if (this.f8187d) {
            j(this.f8194k);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.e
    public void b(View view) {
        this.f8191h.c(0.0f);
        if (this.f8187d) {
            j(this.f8193j);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.e
    public void c(int i7) {
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.e
    public void d(View view, float f8) {
        float fA = this.f8191h.a();
        this.f8191h.c(f8 > 0.5f ? Math.max(fA, Math.max(0.0f, f8 - 0.5f) * 2.0f) : Math.min(fA, f8 * 2.0f));
    }

    public boolean g() {
        return this.f8187d;
    }

    public void h(Configuration configuration) {
        if (!this.f8188e) {
            this.f8189f = f();
        }
        this.f8190g = androidx.core.content.d.i(this.f8184a, this.f8192i);
        o();
    }

    public boolean i(MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != 16908332 || !this.f8187d) {
            return false;
        }
        if (this.f8186c.F(n0.f6717b)) {
            this.f8186c.d(n0.f6717b);
            return true;
        }
        this.f8186c.K(n0.f6717b);
        return true;
    }

    public void l(boolean z7) {
        if (z7 != this.f8187d) {
            if (z7) {
                k(this.f8191h, this.f8186c.C(n0.f6717b) ? this.f8194k : this.f8193j);
            } else {
                k(this.f8189f, 0);
            }
            this.f8187d = z7;
        }
    }

    public void m(int i7) {
        n(i7 != 0 ? androidx.core.content.d.i(this.f8184a, i7) : null);
    }

    public void n(Drawable drawable) {
        if (drawable == null) {
            this.f8189f = f();
            this.f8188e = false;
        } else {
            this.f8189f = drawable;
            this.f8188e = true;
        }
        if (this.f8187d) {
            return;
        }
        k(this.f8189f, 0);
    }

    public void o() {
        if (this.f8186c.C(n0.f6717b)) {
            this.f8191h.c(1.0f);
        } else {
            this.f8191h.c(0.0f);
        }
        if (this.f8187d) {
            k(this.f8191h, this.f8186c.C(n0.f6717b) ? this.f8194k : this.f8193j);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Activity activity, DrawerLayout drawerLayout, boolean z7, @u int i7, @a1 int i8, @a1 int i9) {
        this.f8187d = true;
        this.f8184a = activity;
        if (activity instanceof b) {
            this.f8185b = ((b) activity).c();
        } else {
            this.f8185b = null;
        }
        this.f8186c = drawerLayout;
        this.f8192i = i7;
        this.f8193j = i8;
        this.f8194k = i9;
        this.f8189f = f();
        this.f8190g = androidx.core.content.d.i(activity, i7);
        d dVar = new d(this.f8190g);
        this.f8191h = dVar;
        dVar.b(z7 ? f8182o : 0.0f);
    }
}
