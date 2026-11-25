package androidx.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6800a = "LayoutInflaterCompatHC";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Field f6801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f6802c;

    static class a implements LayoutInflater.Factory2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final r0 f6803a;

        a(r0 r0Var) {
            this.f6803a = r0Var;
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.f6803a.onCreateView(null, str, context, attributeSet);
        }

        @c.m0
        public String toString() {
            return getClass().getName() + "{" + this.f6803a + com.alipay.sdk.util.j.f13808d;
        }

        @Override // android.view.LayoutInflater.Factory2
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.f6803a.onCreateView(view, str, context, attributeSet);
        }
    }

    private q0() {
    }

    private static void a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        if (!f6802c) {
            try {
                Field declaredField = LayoutInflater.class.getDeclaredField("mFactory2");
                f6801b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e8) {
                Log.e(f6800a, "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e8);
            }
            f6802c = true;
        }
        Field field = f6801b;
        if (field != null) {
            try {
                field.set(layoutInflater, factory2);
            } catch (IllegalAccessException e9) {
                Log.e(f6800a, "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e9);
            }
        }
    }

    @Deprecated
    public static r0 b(LayoutInflater layoutInflater) {
        LayoutInflater.Factory factory = layoutInflater.getFactory();
        if (factory instanceof a) {
            return ((a) factory).f6803a;
        }
        return null;
    }

    @Deprecated
    public static void c(@c.m0 LayoutInflater layoutInflater, @c.m0 r0 r0Var) {
        layoutInflater.setFactory2(new a(r0Var));
    }

    public static void d(@c.m0 LayoutInflater layoutInflater, @c.m0 LayoutInflater.Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
    }
}
