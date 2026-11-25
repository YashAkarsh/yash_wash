package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import androidx.appcompat.R;
import c.b1;
import c.t;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
public class d extends ContextWrapper {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Configuration f1010f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Resources.Theme f1012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LayoutInflater f1013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Configuration f1014d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Resources f1015e;

    @t0(17)
    static class a {
        private a() {
        }

        @t
        static Context a(d dVar, Configuration configuration) {
            return dVar.createConfigurationContext(configuration);
        }
    }

    public d() {
        super(null);
    }

    private Resources b() {
        if (this.f1015e == null) {
            Configuration configuration = this.f1014d;
            if (configuration == null || (Build.VERSION.SDK_INT >= 26 && e(configuration))) {
                this.f1015e = super.getResources();
            } else {
                this.f1015e = a.a(this, this.f1014d).getResources();
            }
        }
        return this.f1015e;
    }

    private void d() {
        boolean z7 = this.f1012b == null;
        if (z7) {
            this.f1012b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f1012b.setTo(theme);
            }
        }
        f(this.f1012b, this.f1011a, z7);
    }

    @t0(26)
    private static boolean e(Configuration configuration) {
        if (configuration == null) {
            return true;
        }
        if (f1010f == null) {
            Configuration configuration2 = new Configuration();
            configuration2.fontScale = 0.0f;
            f1010f = configuration2;
        }
        return configuration.equals(f1010f);
    }

    public void a(Configuration configuration) {
        if (this.f1015e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f1014d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f1014d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public int c() {
        return this.f1011a;
    }

    protected void f(Resources.Theme theme, int i7, boolean z7) {
        theme.applyStyle(i7, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f1013c == null) {
            this.f1013c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f1013c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1012b;
        if (theme != null) {
            return theme;
        }
        if (this.f1011a == 0) {
            this.f1011a = R.style.Theme_AppCompat_Light;
        }
        d();
        return this.f1012b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i7) {
        if (this.f1011a != i7) {
            this.f1011a = i7;
            d();
        }
    }

    public d(Context context, @b1 int i7) {
        super(context);
        this.f1011a = i7;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f1012b = theme;
    }
}
