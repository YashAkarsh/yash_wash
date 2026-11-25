package androidx.appcompat.widget;

import android.R;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
public class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f1884a = {R.attr.state_checked};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f1885b = new int[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Rect f1886c = new Rect();

    @c.t0(18)
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final boolean f1887a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Method f1888b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Field f1889c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Field f1890d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final Field f1891e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final Field f1892f;

        /* JADX WARN: Code duplicated, block: B:25:0x004b  */
        /* JADX WARN: Code duplicated, block: B:26:0x0058  */
        static {
            Method method;
            Field field;
            Field field2;
            Field field3;
            Field field4;
            boolean z7;
            try {
                Class<?> cls = Class.forName("android.graphics.Insets");
                method = Drawable.class.getMethod("getOpticalInsets", new Class[0]);
                try {
                    field = cls.getField(ViewHierarchyConstants.DIMENSION_LEFT_KEY);
                    try {
                        field2 = cls.getField(ViewHierarchyConstants.DIMENSION_TOP_KEY);
                        try {
                            field3 = cls.getField("right");
                            try {
                                field4 = cls.getField("bottom");
                                z7 = true;
                            } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException unused) {
                                field4 = null;
                                z7 = false;
                            }
                        } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException unused2) {
                            field3 = null;
                        }
                    } catch (ClassNotFoundException unused3) {
                        field2 = null;
                        field3 = field2;
                        field4 = null;
                        z7 = false;
                        if (z7) {
                            f1888b = method;
                            f1889c = field;
                            f1890d = field2;
                            f1891e = field3;
                            f1892f = field4;
                            f1887a = true;
                            return;
                        }
                        f1888b = null;
                        f1889c = null;
                        f1890d = null;
                        f1891e = null;
                        f1892f = null;
                        f1887a = false;
                    } catch (NoSuchFieldException unused4) {
                        field2 = null;
                        field3 = field2;
                        field4 = null;
                        z7 = false;
                        if (z7) {
                            f1888b = method;
                            f1889c = field;
                            f1890d = field2;
                            f1891e = field3;
                            f1892f = field4;
                            f1887a = true;
                            return;
                        }
                        f1888b = null;
                        f1889c = null;
                        f1890d = null;
                        f1891e = null;
                        f1892f = null;
                        f1887a = false;
                    } catch (NoSuchMethodException unused5) {
                        field2 = null;
                        field3 = field2;
                        field4 = null;
                        z7 = false;
                        if (z7) {
                            f1888b = method;
                            f1889c = field;
                            f1890d = field2;
                            f1891e = field3;
                            f1892f = field4;
                            f1887a = true;
                            return;
                        }
                        f1888b = null;
                        f1889c = null;
                        f1890d = null;
                        f1891e = null;
                        f1892f = null;
                        f1887a = false;
                    }
                } catch (ClassNotFoundException unused6) {
                    field = null;
                    field2 = field;
                    field3 = field2;
                    field4 = null;
                    z7 = false;
                    if (z7) {
                        f1888b = method;
                        f1889c = field;
                        f1890d = field2;
                        f1891e = field3;
                        f1892f = field4;
                        f1887a = true;
                        return;
                    }
                    f1888b = null;
                    f1889c = null;
                    f1890d = null;
                    f1891e = null;
                    f1892f = null;
                    f1887a = false;
                } catch (NoSuchFieldException unused7) {
                    field = null;
                    field2 = field;
                    field3 = field2;
                    field4 = null;
                    z7 = false;
                    if (z7) {
                        f1888b = method;
                        f1889c = field;
                        f1890d = field2;
                        f1891e = field3;
                        f1892f = field4;
                        f1887a = true;
                        return;
                    }
                    f1888b = null;
                    f1889c = null;
                    f1890d = null;
                    f1891e = null;
                    f1892f = null;
                    f1887a = false;
                } catch (NoSuchMethodException unused8) {
                    field = null;
                    field2 = field;
                    field3 = field2;
                    field4 = null;
                    z7 = false;
                    if (z7) {
                        f1888b = method;
                        f1889c = field;
                        f1890d = field2;
                        f1891e = field3;
                        f1892f = field4;
                        f1887a = true;
                        return;
                    }
                    f1888b = null;
                    f1889c = null;
                    f1890d = null;
                    f1891e = null;
                    f1892f = null;
                    f1887a = false;
                }
            } catch (ClassNotFoundException unused9) {
                method = null;
                field = null;
            } catch (NoSuchFieldException unused10) {
                method = null;
                field = null;
            } catch (NoSuchMethodException unused11) {
                method = null;
                field = null;
            }
            if (z7) {
                f1888b = method;
                f1889c = field;
                f1890d = field2;
                f1891e = field3;
                f1892f = field4;
                f1887a = true;
                return;
            }
            f1888b = null;
            f1889c = null;
            f1890d = null;
            f1891e = null;
            f1892f = null;
            f1887a = false;
        }

        private a() {
        }

        @c.m0
        static Rect a(@c.m0 Drawable drawable) {
            if (Build.VERSION.SDK_INT < 29 && f1887a) {
                try {
                    Object objInvoke = f1888b.invoke(drawable, new Object[0]);
                    if (objInvoke != null) {
                        return new Rect(f1889c.getInt(objInvoke), f1890d.getInt(objInvoke), f1891e.getInt(objInvoke), f1892f.getInt(objInvoke));
                    }
                } catch (IllegalAccessException | InvocationTargetException unused) {
                }
            }
            return k0.f1886c;
        }
    }

    @c.t0(29)
    static class b {
        private b() {
        }

        @c.t
        static Insets a(Drawable drawable) {
            return drawable.getOpticalInsets();
        }
    }

    private k0() {
    }

    public static boolean a(@c.m0 Drawable drawable) {
        return true;
    }

    static void b(@c.m0 Drawable drawable) {
        String name = drawable.getClass().getName();
        int i7 = Build.VERSION.SDK_INT;
        if (i7 < 29 || i7 >= 31 || !"android.graphics.drawable.ColorStateListDrawable".equals(name)) {
            return;
        }
        c(drawable);
    }

    private static void c(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(f1884a);
        } else {
            drawable.setState(f1885b);
        }
        drawable.setState(state);
    }

    @c.m0
    public static Rect d(@c.m0 Drawable drawable) {
        if (Build.VERSION.SDK_INT < 29) {
            return a.a(androidx.core.graphics.drawable.d.q(drawable));
        }
        Insets insetsA = b.a(drawable);
        return new Rect(insetsA.left, insetsA.top, insetsA.right, insetsA.bottom);
    }

    public static PorterDuff.Mode e(int i7, PorterDuff.Mode mode) {
        if (i7 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i7 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i7 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i7) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
