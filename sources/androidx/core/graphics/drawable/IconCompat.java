package androidx.core.graphics.drawable;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.util.w;
import androidx.core.view.n2;
import androidx.versionedparcelable.CustomVersionedParcelable;
import c.b0;
import c.g1;
import c.m0;
import c.o0;
import c.t0;
import c.x0;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    @g1
    static final String A = "obj";

    @g1
    static final String B = "int1";

    @g1
    static final String C = "int2";

    @g1
    static final String D = "tint_list";

    @g1
    static final String E = "tint_mode";

    @g1
    static final String F = "string1";
    static final PorterDuff.Mode G = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f5784k = "IconCompat";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f5785l = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f5786m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f5787n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f5788o = 3;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f5789p = 4;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f5790q = 5;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f5791r = 6;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final float f5792s = 0.25f;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final float f5793t = 0.6666667f;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final float f5794u = 0.9166667f;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final float f5795v = 0.010416667f;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final float f5796w = 0.020833334f;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int f5797x = 61;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final int f5798y = 30;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @g1
    static final String f5799z = "type";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public int f5800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f5801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    @x0({x0.a.LIBRARY})
    public byte[] f5802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @o0
    @x0({x0.a.LIBRARY})
    public Parcelable f5803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @x0({x0.a.LIBRARY})
    public int f5804e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @x0({x0.a.LIBRARY})
    public int f5805f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @o0
    @x0({x0.a.LIBRARY})
    public ColorStateList f5806g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    PorterDuff.Mode f5807h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @o0
    @x0({x0.a.LIBRARY})
    public String f5808i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @o0
    @x0({x0.a.LIBRARY})
    public String f5809j;

    @t0(23)
    static class a {
        private a() {
        }

        @o0
        static IconCompat a(@m0 Context context, @m0 Icon icon) {
            int iE = e(icon);
            if (iE == 2) {
                String strD = d(icon);
                try {
                    return IconCompat.y(IconCompat.C(context, strD), strD, c(icon));
                } catch (Resources.NotFoundException unused) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            }
            if (iE == 4) {
                return IconCompat.t(f(icon));
            }
            if (iE == 6) {
                return IconCompat.q(f(icon));
            }
            IconCompat iconCompat = new IconCompat(-1);
            iconCompat.f5801b = icon;
            return iconCompat;
        }

        static IconCompat b(@m0 Object obj) {
            w.l(obj);
            int iE = e(obj);
            if (iE == 2) {
                return IconCompat.y(null, d(obj), c(obj));
            }
            if (iE == 4) {
                return IconCompat.t(f(obj));
            }
            if (iE == 6) {
                return IconCompat.q(f(obj));
            }
            IconCompat iconCompat = new IconCompat(-1);
            iconCompat.f5801b = obj;
            return iconCompat;
        }

        @c.u
        @b0
        static int c(@m0 Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.a(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException e8) {
                Log.e(IconCompat.f5784k, "Unable to get icon resource", e8);
                return 0;
            } catch (NoSuchMethodException e9) {
                Log.e(IconCompat.f5784k, "Unable to get icon resource", e9);
                return 0;
            } catch (InvocationTargetException e10) {
                Log.e(IconCompat.f5784k, "Unable to get icon resource", e10);
                return 0;
            }
        }

        @o0
        static String d(@m0 Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.b(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e8) {
                Log.e(IconCompat.f5784k, "Unable to get icon package", e8);
                return null;
            } catch (NoSuchMethodException e9) {
                Log.e(IconCompat.f5784k, "Unable to get icon package", e9);
                return null;
            } catch (InvocationTargetException e10) {
                Log.e(IconCompat.f5784k, "Unable to get icon package", e10);
                return null;
            }
        }

        static int e(@m0 Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.c(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getType", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException e8) {
                Log.e(IconCompat.f5784k, "Unable to get icon type " + obj, e8);
                return -1;
            } catch (NoSuchMethodException e9) {
                Log.e(IconCompat.f5784k, "Unable to get icon type " + obj, e9);
                return -1;
            } catch (InvocationTargetException e10) {
                Log.e(IconCompat.f5784k, "Unable to get icon type " + obj, e10);
                return -1;
            }
        }

        @o0
        @c.t
        static Uri f(@m0 Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.d(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e8) {
                Log.e(IconCompat.f5784k, "Unable to get icon uri", e8);
                return null;
            } catch (NoSuchMethodException e9) {
                Log.e(IconCompat.f5784k, "Unable to get icon uri", e9);
                return null;
            } catch (InvocationTargetException e10) {
                Log.e(IconCompat.f5784k, "Unable to get icon uri", e10);
                return null;
            }
        }

        @c.t
        static Drawable g(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        @c.t
        static Icon h(IconCompat iconCompat, Context context) {
            Icon iconCreateWithBitmap;
            switch (iconCompat.f5800a) {
                case -1:
                    return (Icon) iconCompat.f5801b;
                case 0:
                default:
                    throw new IllegalArgumentException("Unknown type");
                case 1:
                    iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.f5801b);
                    break;
                case 2:
                    iconCreateWithBitmap = Icon.createWithResource(iconCompat.B(), iconCompat.f5804e);
                    break;
                case 3:
                    iconCreateWithBitmap = Icon.createWithData((byte[]) iconCompat.f5801b, iconCompat.f5804e, iconCompat.f5805f);
                    break;
                case 4:
                    iconCreateWithBitmap = Icon.createWithContentUri((String) iconCompat.f5801b);
                    break;
                case 5:
                    iconCreateWithBitmap = Build.VERSION.SDK_INT < 26 ? Icon.createWithBitmap(IconCompat.o((Bitmap) iconCompat.f5801b, false)) : b.b((Bitmap) iconCompat.f5801b);
                    break;
                case 6:
                    int i7 = Build.VERSION.SDK_INT;
                    if (i7 >= 30) {
                        iconCreateWithBitmap = d.a(iconCompat.E());
                    } else {
                        if (context == null) {
                            throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + iconCompat.E());
                        }
                        InputStream inputStreamF = iconCompat.F(context);
                        if (inputStreamF == null) {
                            throw new IllegalStateException("Cannot load adaptive icon from uri: " + iconCompat.E());
                        }
                        if (i7 < 26) {
                            iconCreateWithBitmap = Icon.createWithBitmap(IconCompat.o(BitmapFactory.decodeStream(inputStreamF), false));
                        } else {
                            iconCreateWithBitmap = b.b(BitmapFactory.decodeStream(inputStreamF));
                        }
                    }
                    break;
            }
            ColorStateList colorStateList = iconCompat.f5806g;
            if (colorStateList != null) {
                iconCreateWithBitmap.setTintList(colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.f5807h;
            if (mode != IconCompat.G) {
                iconCreateWithBitmap.setTintMode(mode);
            }
            return iconCreateWithBitmap;
        }
    }

    @t0(26)
    static class b {
        private b() {
        }

        @c.t
        static Drawable a(Drawable drawable, Drawable drawable2) {
            h.a();
            return g.a(drawable, drawable2);
        }

        @c.t
        static Icon b(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    @t0(28)
    static class c {
        private c() {
        }

        @c.t
        static int a(Object obj) {
            return ((Icon) obj).getResId();
        }

        @c.t
        static String b(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        @c.t
        static int c(Object obj) {
            return ((Icon) obj).getType();
        }

        @c.t
        static Uri d(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    @t0(30)
    static class d {
        private d() {
        }

        @c.t
        static Icon a(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    @x0({x0.a.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface e {
    }

    @x0({x0.a.LIBRARY})
    public IconCompat() {
        this.f5800a = -1;
        this.f5802c = null;
        this.f5803d = null;
        this.f5804e = 0;
        this.f5805f = 0;
        this.f5806g = null;
        this.f5807h = G;
        this.f5808i = null;
    }

    static Resources C(Context context, String str) {
        if ("android".equals(str)) {
            return Resources.getSystem();
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 8192);
            if (applicationInfo != null) {
                return packageManager.getResourcesForApplication(applicationInfo);
            }
            return null;
        } catch (PackageManager.NameNotFoundException e8) {
            Log.e(f5784k, String.format("Unable to find pkg=%s for icon", str), e8);
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Drawable H(Context context) {
        switch (this.f5800a) {
            case 1:
                return new BitmapDrawable(context.getResources(), (Bitmap) this.f5801b);
            case 2:
                String strB = B();
                if (TextUtils.isEmpty(strB)) {
                    strB = context.getPackageName();
                }
                try {
                    return androidx.core.content.res.i.g(C(context, strB), this.f5804e, context.getTheme());
                } catch (RuntimeException e8) {
                    Log.e(f5784k, String.format("Unable to load resource 0x%08x from pkg=%s", Integer.valueOf(this.f5804e), this.f5801b), e8);
                }
                break;
            case 3:
                return new BitmapDrawable(context.getResources(), BitmapFactory.decodeByteArray((byte[]) this.f5801b, this.f5804e, this.f5805f));
            case 4:
                InputStream inputStreamF = F(context);
                if (inputStreamF != null) {
                    return new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(inputStreamF));
                }
                return null;
            case 5:
                return new BitmapDrawable(context.getResources(), o((Bitmap) this.f5801b, false));
            case 6:
                InputStream inputStreamF2 = F(context);
                if (inputStreamF2 != null) {
                    return Build.VERSION.SDK_INT >= 26 ? b.a(null, new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(inputStreamF2))) : new BitmapDrawable(context.getResources(), o(BitmapFactory.decodeStream(inputStreamF2), false));
                }
                return null;
            default:
                return null;
        }
    }

    private static String N(int i7) {
        switch (i7) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    @o0
    public static IconCompat k(@m0 Bundle bundle) {
        int i7 = bundle.getInt("type");
        IconCompat iconCompat = new IconCompat(i7);
        iconCompat.f5804e = bundle.getInt(B);
        iconCompat.f5805f = bundle.getInt(C);
        iconCompat.f5809j = bundle.getString(F);
        if (bundle.containsKey(D)) {
            iconCompat.f5806g = (ColorStateList) bundle.getParcelable(D);
        }
        if (bundle.containsKey(E)) {
            iconCompat.f5807h = PorterDuff.Mode.valueOf(bundle.getString(E));
        }
        switch (i7) {
            case -1:
            case 1:
            case 5:
                iconCompat.f5801b = bundle.getParcelable(A);
                return iconCompat;
            case 0:
            default:
                Log.w(f5784k, "Unknown type " + i7);
                return null;
            case 2:
            case 4:
            case 6:
                iconCompat.f5801b = bundle.getString(A);
                return iconCompat;
            case 3:
                iconCompat.f5801b = bundle.getByteArray(A);
                return iconCompat;
        }
    }

    @o0
    @t0(23)
    public static IconCompat l(@m0 Context context, @m0 Icon icon) {
        w.l(icon);
        return a.a(context, icon);
    }

    @o0
    @t0(23)
    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public static IconCompat m(@m0 Icon icon) {
        return a.b(icon);
    }

    @o0
    @t0(23)
    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public static IconCompat n(@m0 Icon icon) {
        if (a.e(icon) == 2 && a.c(icon) == 0) {
            return null;
        }
        return a.b(icon);
    }

    @g1
    static Bitmap o(Bitmap bitmap, boolean z7) {
        int iMin = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * f5793t);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(3);
        float f8 = iMin;
        float f9 = 0.5f * f8;
        float f10 = f5794u * f9;
        if (z7) {
            float f11 = f5795v * f8;
            paint.setColor(0);
            paint.setShadowLayer(f11, 0.0f, f8 * f5796w, 1023410176);
            canvas.drawCircle(f9, f9, f10, paint);
            paint.setShadowLayer(f11, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f9, f9, f10, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(n2.f6743t);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - iMin)) / 2.0f, (-(bitmap.getHeight() - iMin)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f9, f9, f10, paint);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    @m0
    public static IconCompat p(@m0 Bitmap bitmap) {
        androidx.core.util.r.d(bitmap);
        IconCompat iconCompat = new IconCompat(5);
        iconCompat.f5801b = bitmap;
        return iconCompat;
    }

    @m0
    public static IconCompat q(@m0 Uri uri) {
        androidx.core.util.r.d(uri);
        return r(uri.toString());
    }

    @m0
    public static IconCompat r(@m0 String str) {
        androidx.core.util.r.d(str);
        IconCompat iconCompat = new IconCompat(6);
        iconCompat.f5801b = str;
        return iconCompat;
    }

    @m0
    public static IconCompat s(@m0 Bitmap bitmap) {
        androidx.core.util.r.d(bitmap);
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.f5801b = bitmap;
        return iconCompat;
    }

    @m0
    public static IconCompat t(@m0 Uri uri) {
        androidx.core.util.r.d(uri);
        return u(uri.toString());
    }

    @m0
    public static IconCompat u(@m0 String str) {
        androidx.core.util.r.d(str);
        IconCompat iconCompat = new IconCompat(4);
        iconCompat.f5801b = str;
        return iconCompat;
    }

    @m0
    public static IconCompat v(@m0 byte[] bArr, int i7, int i8) {
        androidx.core.util.r.d(bArr);
        IconCompat iconCompat = new IconCompat(3);
        iconCompat.f5801b = bArr;
        iconCompat.f5804e = i7;
        iconCompat.f5805f = i8;
        return iconCompat;
    }

    @m0
    public static IconCompat x(@m0 Context context, @c.u int i7) {
        androidx.core.util.r.d(context);
        return y(context.getResources(), context.getPackageName(), i7);
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    @m0
    public static IconCompat y(@o0 Resources resources, @m0 String str, @c.u int i7) {
        androidx.core.util.r.d(str);
        if (i7 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f5804e = i7;
        if (resources != null) {
            try {
                iconCompat.f5801b = resources.getResourceName(i7);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.f5801b = str;
        }
        iconCompat.f5809j = str;
        return iconCompat;
    }

    @c.u
    public int A() {
        int i7 = this.f5800a;
        if (i7 == -1) {
            return a.c(this.f5801b);
        }
        if (i7 == 2) {
            return this.f5804e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    @m0
    public String B() {
        int i7 = this.f5800a;
        if (i7 == -1) {
            return a.d(this.f5801b);
        }
        if (i7 == 2) {
            String str = this.f5809j;
            return (str == null || TextUtils.isEmpty(str)) ? ((String) this.f5801b).split(":", -1)[0] : this.f5809j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int D() {
        int i7 = this.f5800a;
        return i7 == -1 ? a.e(this.f5801b) : i7;
    }

    @m0
    public Uri E() {
        int i7 = this.f5800a;
        if (i7 == -1) {
            return a.f(this.f5801b);
        }
        if (i7 == 4 || i7 == 6) {
            return Uri.parse((String) this.f5801b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    @o0
    @x0({x0.a.LIBRARY_GROUP})
    public InputStream F(@m0 Context context) {
        Uri uriE = E();
        String scheme = uriE.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(uriE);
            } catch (Exception e8) {
                Log.w(f5784k, "Unable to load image from URI: " + uriE, e8);
                return null;
            }
        }
        try {
            return new FileInputStream(new File((String) this.f5801b));
        } catch (FileNotFoundException e9) {
            Log.w(f5784k, "Unable to load image from path: " + uriE, e9);
            return null;
        }
    }

    @o0
    public Drawable G(@m0 Context context) {
        j(context);
        return a.g(M(context), context);
    }

    @m0
    public IconCompat I(@c.l int i7) {
        return J(ColorStateList.valueOf(i7));
    }

    @m0
    public IconCompat J(@o0 ColorStateList colorStateList) {
        this.f5806g = colorStateList;
        return this;
    }

    @m0
    public IconCompat K(@o0 PorterDuff.Mode mode) {
        this.f5807h = mode;
        return this;
    }

    @t0(23)
    @m0
    @Deprecated
    public Icon L() {
        return M(null);
    }

    @t0(23)
    @m0
    public Icon M(@o0 Context context) {
        return a.h(this, context);
    }

    @m0
    public Bundle a() {
        Bundle bundle = new Bundle();
        switch (this.f5800a) {
            case -1:
                bundle.putParcelable(A, (Parcelable) this.f5801b);
                break;
            case 0:
            default:
                throw new IllegalArgumentException("Invalid icon");
            case 1:
            case 5:
                bundle.putParcelable(A, (Bitmap) this.f5801b);
                break;
            case 2:
            case 4:
            case 6:
                bundle.putString(A, (String) this.f5801b);
                break;
            case 3:
                bundle.putByteArray(A, (byte[]) this.f5801b);
                break;
        }
        bundle.putInt("type", this.f5800a);
        bundle.putInt(B, this.f5804e);
        bundle.putInt(C, this.f5805f);
        bundle.putString(F, this.f5809j);
        ColorStateList colorStateList = this.f5806g;
        if (colorStateList != null) {
            bundle.putParcelable(D, colorStateList);
        }
        PorterDuff.Mode mode = this.f5807h;
        if (mode != G) {
            bundle.putString(E, mode.name());
        }
        return bundle;
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void g() {
        this.f5807h = PorterDuff.Mode.valueOf(this.f5808i);
        switch (this.f5800a) {
            case -1:
                Parcelable parcelable = this.f5803d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                this.f5801b = parcelable;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.f5803d;
                if (parcelable2 != null) {
                    this.f5801b = parcelable2;
                    return;
                }
                byte[] bArr = this.f5802c;
                this.f5801b = bArr;
                this.f5800a = 3;
                this.f5804e = 0;
                this.f5805f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f5802c, Charset.forName(CharEncoding.UTF_16));
                this.f5801b = str;
                if (this.f5800a == 2 && this.f5809j == null) {
                    this.f5809j = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f5801b = this.f5802c;
                return;
        }
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void h(boolean z7) {
        this.f5808i = this.f5807h.name();
        switch (this.f5800a) {
            case -1:
                if (z7) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                this.f5803d = (Parcelable) this.f5801b;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (!z7) {
                    this.f5803d = (Parcelable) this.f5801b;
                    return;
                }
                Bitmap bitmap = (Bitmap) this.f5801b;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                this.f5802c = byteArrayOutputStream.toByteArray();
                return;
            case 2:
                this.f5802c = ((String) this.f5801b).getBytes(Charset.forName(CharEncoding.UTF_16));
                return;
            case 3:
                this.f5802c = (byte[]) this.f5801b;
                return;
            case 4:
            case 6:
                this.f5802c = this.f5801b.toString().getBytes(Charset.forName(CharEncoding.UTF_16));
                return;
        }
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public void i(@m0 Intent intent, @o0 Drawable drawable, @m0 Context context) {
        Bitmap bitmapCopy;
        j(context);
        int i7 = this.f5800a;
        if (i7 == 1) {
            bitmapCopy = (Bitmap) this.f5801b;
            if (drawable != null) {
                bitmapCopy = bitmapCopy.copy(bitmapCopy.getConfig(), true);
            }
        } else if (i7 == 2) {
            try {
                Context contextCreatePackageContext = context.createPackageContext(B(), 0);
                if (drawable == null) {
                    intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(contextCreatePackageContext, this.f5804e));
                    return;
                }
                Drawable drawableI = androidx.core.content.d.i(contextCreatePackageContext, this.f5804e);
                if (drawableI.getIntrinsicWidth() <= 0 || drawableI.getIntrinsicHeight() <= 0) {
                    int launcherLargeIconSize = ((ActivityManager) contextCreatePackageContext.getSystemService("activity")).getLauncherLargeIconSize();
                    bitmapCopy = Bitmap.createBitmap(launcherLargeIconSize, launcherLargeIconSize, Bitmap.Config.ARGB_8888);
                } else {
                    bitmapCopy = Bitmap.createBitmap(drawableI.getIntrinsicWidth(), drawableI.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                }
                drawableI.setBounds(0, 0, bitmapCopy.getWidth(), bitmapCopy.getHeight());
                drawableI.draw(new Canvas(bitmapCopy));
            } catch (PackageManager.NameNotFoundException e8) {
                throw new IllegalArgumentException("Can't find package " + this.f5801b, e8);
            }
        } else {
            if (i7 != 5) {
                throw new IllegalArgumentException("Icon type not supported for intent shortcuts");
            }
            bitmapCopy = o((Bitmap) this.f5801b, true);
        }
        if (drawable != null) {
            int width = bitmapCopy.getWidth();
            int height = bitmapCopy.getHeight();
            drawable.setBounds(width / 2, height / 2, width, height);
            drawable.draw(new Canvas(bitmapCopy));
        }
        intent.putExtra("android.intent.extra.shortcut.ICON", bitmapCopy);
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public void j(@m0 Context context) {
        Object obj;
        if (this.f5800a != 2 || (obj = this.f5801b) == null) {
            return;
        }
        String str = (String) obj;
        if (str.contains(":")) {
            String str2 = str.split(":", -1)[1];
            String str3 = str2.split("/", -1)[0];
            String str4 = str2.split("/", -1)[1];
            String str5 = str.split(":", -1)[0];
            if ("0_resource_name_obfuscated".equals(str4)) {
                Log.i(f5784k, "Found obfuscated resource, not trying to update resource id for it");
                return;
            }
            String strB = B();
            int identifier = C(context, strB).getIdentifier(str4, str3, str5);
            if (this.f5804e != identifier) {
                Log.i(f5784k, "Id has changed for " + strB + " " + str);
                this.f5804e = identifier;
            }
        }
    }

    @m0
    public String toString() {
        if (this.f5800a == -1) {
            return String.valueOf(this.f5801b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(N(this.f5800a));
        switch (this.f5800a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f5801b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f5801b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f5809j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(A())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f5804e);
                if (this.f5805f != 0) {
                    sb.append(" off=");
                    sb.append(this.f5805f);
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f5801b);
                break;
        }
        if (this.f5806g != null) {
            sb.append(" tint=");
            sb.append(this.f5806g);
        }
        if (this.f5807h != G) {
            sb.append(" mode=");
            sb.append(this.f5807h);
        }
        sb.append(")");
        return sb.toString();
    }

    @o0
    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public Bitmap z() {
        int i7 = this.f5800a;
        if (i7 == -1) {
            Object obj = this.f5801b;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        }
        if (i7 == 1) {
            return (Bitmap) this.f5801b;
        }
        if (i7 == 5) {
            return o((Bitmap) this.f5801b, true);
        }
        throw new IllegalStateException("called getBitmap() on " + this);
    }

    IconCompat(int i7) {
        this.f5802c = null;
        this.f5803d = null;
        this.f5804e = 0;
        this.f5805f = 0;
        this.f5806g = null;
        this.f5807h = G;
        this.f5808i = null;
        this.f5800a = i7;
    }
}
