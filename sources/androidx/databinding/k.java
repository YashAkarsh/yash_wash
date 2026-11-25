package androidx.databinding;

import android.R;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static j f7286a = new DataBinderMapperImpl();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static DataBindingComponent f7287b = null;

    private k() {
    }

    @o0
    public static <T extends ViewDataBinding> T a(@m0 View view) {
        return (T) b(view, f7287b);
    }

    @o0
    public static <T extends ViewDataBinding> T b(@m0 View view, DataBindingComponent dataBindingComponent) {
        T t7 = (T) h(view);
        if (t7 != null) {
            return t7;
        }
        Object tag = view.getTag();
        if (!(tag instanceof String)) {
            throw new IllegalArgumentException("View is not a binding layout");
        }
        int iE = f7286a.e((String) tag);
        if (iE != 0) {
            return (T) f7286a.c(dataBindingComponent, view, iE);
        }
        throw new IllegalArgumentException("View is not a binding layout. Tag: " + tag);
    }

    static <T extends ViewDataBinding> T c(DataBindingComponent dataBindingComponent, View view, int i7) {
        return (T) f7286a.c(dataBindingComponent, view, i7);
    }

    static <T extends ViewDataBinding> T d(DataBindingComponent dataBindingComponent, View[] viewArr, int i7) {
        return (T) f7286a.d(dataBindingComponent, viewArr, i7);
    }

    private static <T extends ViewDataBinding> T e(DataBindingComponent dataBindingComponent, ViewGroup viewGroup, int i7, int i8) {
        int childCount = viewGroup.getChildCount();
        int i9 = childCount - i7;
        if (i9 == 1) {
            return (T) c(dataBindingComponent, viewGroup.getChildAt(childCount - 1), i8);
        }
        View[] viewArr = new View[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            viewArr[i10] = viewGroup.getChildAt(i10 + i7);
        }
        return (T) d(dataBindingComponent, viewArr, i8);
    }

    @o0
    public static String f(int i7) {
        return f7286a.b(i7);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0038  */
    @o0
    public static <T extends ViewDataBinding> T g(@m0 View view) {
        while (view != null) {
            T t7 = (T) ViewDataBinding.F(view);
            if (t7 != null) {
                return t7;
            }
            Object tag = view.getTag();
            if (tag instanceof String) {
                String str = (String) tag;
                if (str.startsWith("layout") && str.endsWith("_0")) {
                    char cCharAt = str.charAt(6);
                    int iIndexOf = str.indexOf(47, 7);
                    boolean z7 = true;
                    boolean z8 = false;
                    if (cCharAt == '/') {
                        if (iIndexOf != -1) {
                            z7 = false;
                        }
                        z8 = z7;
                    } else if (cCharAt == '-' && iIndexOf != -1) {
                        if (str.indexOf(47, iIndexOf + 1) != -1) {
                            z7 = false;
                        }
                        z8 = z7;
                    }
                    if (z8) {
                        return null;
                    }
                }
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    @o0
    public static <T extends ViewDataBinding> T h(@m0 View view) {
        return (T) ViewDataBinding.F(view);
    }

    @o0
    public static DataBindingComponent i() {
        return f7287b;
    }

    public static <T extends ViewDataBinding> T j(@m0 LayoutInflater layoutInflater, int i7, @o0 ViewGroup viewGroup, boolean z7) {
        return (T) k(layoutInflater, i7, viewGroup, z7, f7287b);
    }

    public static <T extends ViewDataBinding> T k(@m0 LayoutInflater layoutInflater, int i7, @o0 ViewGroup viewGroup, boolean z7, @o0 DataBindingComponent dataBindingComponent) {
        boolean z8 = viewGroup != null && z7;
        return z8 ? (T) e(dataBindingComponent, viewGroup, z8 ? viewGroup.getChildCount() : 0, i7) : (T) c(dataBindingComponent, layoutInflater.inflate(i7, viewGroup, z7), i7);
    }

    public static <T extends ViewDataBinding> T l(@m0 Activity activity, int i7) {
        return (T) m(activity, i7, f7287b);
    }

    public static <T extends ViewDataBinding> T m(@m0 Activity activity, int i7, @o0 DataBindingComponent dataBindingComponent) {
        activity.setContentView(i7);
        return (T) e(dataBindingComponent, (ViewGroup) activity.getWindow().getDecorView().findViewById(R.id.content), 0, i7);
    }

    public static void n(@o0 DataBindingComponent dataBindingComponent) {
        f7287b = dataBindingComponent;
    }
}
