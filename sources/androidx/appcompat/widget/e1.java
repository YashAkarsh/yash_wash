package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
public class e1 extends ContextWrapper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f1819c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ArrayList<WeakReference<e1>> f1820d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Resources f1821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Resources.Theme f1822b;

    private e1(@c.m0 Context context) {
        super(context);
        if (!q1.d()) {
            this.f1821a = new g1(this, context.getResources());
            this.f1822b = null;
            return;
        }
        q1 q1Var = new q1(this, context.getResources());
        this.f1821a = q1Var;
        Resources.Theme themeNewTheme = q1Var.newTheme();
        this.f1822b = themeNewTheme;
        themeNewTheme.setTo(context.getTheme());
    }

    private static boolean a(@c.m0 Context context) {
        return ((context instanceof e1) || (context.getResources() instanceof g1) || (context.getResources() instanceof q1) || !q1.d()) ? false : true;
    }

    public static Context b(@c.m0 Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (f1819c) {
            ArrayList<WeakReference<e1>> arrayList = f1820d;
            if (arrayList == null) {
                f1820d = new ArrayList<>();
            } else {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    WeakReference<e1> weakReference = f1820d.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f1820d.remove(size);
                    }
                }
                for (int size2 = f1820d.size() - 1; size2 >= 0; size2--) {
                    WeakReference<e1> weakReference2 = f1820d.get(size2);
                    e1 e1Var = weakReference2 != null ? weakReference2.get() : null;
                    if (e1Var != null && e1Var.getBaseContext() == context) {
                        return e1Var;
                    }
                }
            }
            e1 e1Var2 = new e1(context);
            f1820d.add(new WeakReference<>(e1Var2));
            return e1Var2;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f1821a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f1821a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1822b;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i7) {
        Resources.Theme theme = this.f1822b;
        if (theme == null) {
            super.setTheme(i7);
        } else {
            theme.applyStyle(i7, true);
        }
    }
}
