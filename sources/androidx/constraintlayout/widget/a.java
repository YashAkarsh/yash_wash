package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import androidx.core.view.n2;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f4632i = "TransitionLayout";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f4633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f4634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f4635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f4637e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f4638f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f4639g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f4640h;

    /* JADX INFO: renamed from: androidx.constraintlayout.widget.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0046a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4641a;

        static {
            int[] iArr = new int[b.values().length];
            f4641a = iArr;
            try {
                iArr[b.REFERENCE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4641a[b.BOOLEAN_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4641a[b.STRING_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4641a[b.COLOR_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4641a[b.COLOR_DRAWABLE_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4641a[b.INT_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4641a[b.FLOAT_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4641a[b.DIMENSION_TYPE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public enum b {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    public a(String name, b attributeType) {
        this.f4633a = false;
        this.f4634b = name;
        this.f4635c = attributeType;
    }

    private static int b(int c8) {
        int i7 = (c8 & (~(c8 >> 31))) - 255;
        return (i7 & (i7 >> 31)) + 255;
    }

    public static HashMap<String, a> d(HashMap<String, a> base, View view) {
        HashMap<String, a> map = new HashMap<>();
        Class<?> cls = view.getClass();
        for (String str : base.keySet()) {
            a aVar = base.get(str);
            try {
                if (str.equals("BackgroundColor")) {
                    map.put(str, new a(aVar, Integer.valueOf(((ColorDrawable) view.getBackground()).getColor())));
                } else {
                    map.put(str, new a(aVar, cls.getMethod("getMap" + str, new Class[0]).invoke(view, new Object[0])));
                }
            } catch (IllegalAccessException e8) {
                e8.printStackTrace();
            } catch (NoSuchMethodException e9) {
                e9.printStackTrace();
            } catch (InvocationTargetException e10) {
                e10.printStackTrace();
            }
        }
        return map;
    }

    public static void q(Context context, XmlPullParser parser, HashMap<String, a> custom) {
        b bVar;
        Object objValueOf;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(parser), R.styleable.CustomAttribute);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        String string = null;
        Object objValueOf2 = null;
        b bVar2 = null;
        boolean z7 = false;
        for (int i7 = 0; i7 < indexCount; i7++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i7);
            if (index == R.styleable.CustomAttribute_attributeName) {
                string = typedArrayObtainStyledAttributes.getString(index);
                if (string != null && string.length() > 0) {
                    string = Character.toUpperCase(string.charAt(0)) + string.substring(1);
                }
            } else if (index == R.styleable.CustomAttribute_methodName) {
                string = typedArrayObtainStyledAttributes.getString(index);
                z7 = true;
            } else if (index == R.styleable.CustomAttribute_customBoolean) {
                objValueOf2 = Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(index, false));
                bVar2 = b.BOOLEAN_TYPE;
            } else {
                if (index == R.styleable.CustomAttribute_customColorValue) {
                    bVar = b.COLOR_TYPE;
                    objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                } else if (index == R.styleable.CustomAttribute_customColorDrawableValue) {
                    bVar = b.COLOR_DRAWABLE_TYPE;
                    objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                } else if (index == R.styleable.CustomAttribute_customPixelDimension) {
                    bVar = b.DIMENSION_TYPE;
                    objValueOf = Float.valueOf(TypedValue.applyDimension(1, typedArrayObtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                } else if (index == R.styleable.CustomAttribute_customDimension) {
                    bVar = b.DIMENSION_TYPE;
                    objValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.CustomAttribute_customFloatValue) {
                    bVar = b.FLOAT_TYPE;
                    objValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getFloat(index, Float.NaN));
                } else if (index == R.styleable.CustomAttribute_customIntegerValue) {
                    bVar = b.INT_TYPE;
                    objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getInteger(index, -1));
                } else if (index == R.styleable.CustomAttribute_customStringValue) {
                    bVar = b.STRING_TYPE;
                    objValueOf = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == R.styleable.CustomAttribute_customReference) {
                    bVar = b.REFERENCE_TYPE;
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                    if (resourceId == -1) {
                        resourceId = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    objValueOf = Integer.valueOf(resourceId);
                }
                Object obj = objValueOf;
                bVar2 = bVar;
                objValueOf2 = obj;
            }
        }
        if (string != null && objValueOf2 != null) {
            custom.put(string, new a(string, bVar2, objValueOf2, z7));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public static void r(View view, HashMap<String, a> map) {
        Class<?> cls = view.getClass();
        for (String str : map.keySet()) {
            a aVar = map.get(str);
            String str2 = aVar.f4633a ? str : "set" + str;
            try {
                switch (C0046a.f4641a[aVar.f4635c.ordinal()]) {
                    case 1:
                        cls.getMethod(str2, Integer.TYPE).invoke(view, Integer.valueOf(aVar.f4636d));
                        break;
                    case 2:
                        cls.getMethod(str2, Boolean.TYPE).invoke(view, Boolean.valueOf(aVar.f4639g));
                        break;
                    case 3:
                        cls.getMethod(str2, CharSequence.class).invoke(view, aVar.f4638f);
                        break;
                    case 4:
                        cls.getMethod(str2, Integer.TYPE).invoke(view, Integer.valueOf(aVar.f4640h));
                        break;
                    case 5:
                        Method method = cls.getMethod(str2, Drawable.class);
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(aVar.f4640h);
                        method.invoke(view, colorDrawable);
                        break;
                    case 6:
                        cls.getMethod(str2, Integer.TYPE).invoke(view, Integer.valueOf(aVar.f4636d));
                        break;
                    case 7:
                        cls.getMethod(str2, Float.TYPE).invoke(view, Float.valueOf(aVar.f4637e));
                        break;
                    case 8:
                        cls.getMethod(str2, Float.TYPE).invoke(view, Float.valueOf(aVar.f4637e));
                        break;
                }
            } catch (IllegalAccessException e8) {
                Log.e(f4632i, " Custom Attribute \"" + str + "\" not found on " + cls.getName());
                e8.printStackTrace();
            } catch (NoSuchMethodException e9) {
                Log.e(f4632i, e9.getMessage());
                Log.e(f4632i, " Custom Attribute \"" + str + "\" not found on " + cls.getName());
                StringBuilder sb = new StringBuilder();
                sb.append(cls.getName());
                sb.append(" must have a method ");
                sb.append(str2);
                Log.e(f4632i, sb.toString());
            } catch (InvocationTargetException e10) {
                Log.e(f4632i, " Custom Attribute \"" + str + "\" not found on " + cls.getName());
                e10.printStackTrace();
            }
        }
    }

    public void a(View view) {
        String str;
        Class<?> cls = view.getClass();
        String str2 = this.f4634b;
        if (this.f4633a) {
            str = str2;
        } else {
            str = "set" + str2;
        }
        try {
            switch (C0046a.f4641a[this.f4635c.ordinal()]) {
                case 1:
                case 6:
                    cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf(this.f4636d));
                    break;
                case 2:
                    cls.getMethod(str, Boolean.TYPE).invoke(view, Boolean.valueOf(this.f4639g));
                    break;
                case 3:
                    cls.getMethod(str, CharSequence.class).invoke(view, this.f4638f);
                    break;
                case 4:
                    cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf(this.f4640h));
                    break;
                case 5:
                    Method method = cls.getMethod(str, Drawable.class);
                    ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setColor(this.f4640h);
                    method.invoke(view, colorDrawable);
                    break;
                case 7:
                    cls.getMethod(str, Float.TYPE).invoke(view, Float.valueOf(this.f4637e));
                    break;
                case 8:
                    cls.getMethod(str, Float.TYPE).invoke(view, Float.valueOf(this.f4637e));
                    break;
                default:
                    break;
            }
        } catch (IllegalAccessException e8) {
            Log.e(f4632i, " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
            e8.printStackTrace();
        } catch (NoSuchMethodException e9) {
            Log.e(f4632i, e9.getMessage());
            Log.e(f4632i, " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
            StringBuilder sb = new StringBuilder();
            sb.append(cls.getName());
            sb.append(" must have a method ");
            sb.append(str);
            Log.e(f4632i, sb.toString());
        } catch (InvocationTargetException e10) {
            Log.e(f4632i, " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
            e10.printStackTrace();
        }
    }

    public boolean c(a constraintAttribute) {
        b bVar;
        if (constraintAttribute == null || (bVar = this.f4635c) != constraintAttribute.f4635c) {
            return false;
        }
        switch (C0046a.f4641a[bVar.ordinal()]) {
            case 1:
            case 6:
                return this.f4636d == constraintAttribute.f4636d;
            case 2:
                return this.f4639g == constraintAttribute.f4639g;
            case 3:
                return this.f4636d == constraintAttribute.f4636d;
            case 4:
            case 5:
                return this.f4640h == constraintAttribute.f4640h;
            case 7:
                return this.f4637e == constraintAttribute.f4637e;
            case 8:
                return this.f4637e == constraintAttribute.f4637e;
            default:
                return false;
        }
    }

    public int e() {
        return this.f4640h;
    }

    public float f() {
        return this.f4637e;
    }

    public int g() {
        return this.f4636d;
    }

    public String h() {
        return this.f4634b;
    }

    public String i() {
        return this.f4638f;
    }

    public b j() {
        return this.f4635c;
    }

    public float k() {
        switch (C0046a.f4641a[this.f4635c.ordinal()]) {
            case 2:
                return this.f4639g ? 1.0f : 0.0f;
            case 3:
                throw new RuntimeException("Cannot interpolate String");
            case 4:
            case 5:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 6:
                return this.f4636d;
            case 7:
                return this.f4637e;
            case 8:
                return this.f4637e;
            default:
                return Float.NaN;
        }
    }

    public void l(float[] ret) {
        switch (C0046a.f4641a[this.f4635c.ordinal()]) {
            case 2:
                ret[0] = this.f4639g ? 1.0f : 0.0f;
                return;
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
            case 5:
                int i7 = this.f4640h;
                int i8 = (i7 >> 24) & 255;
                float fPow = (float) Math.pow(((i7 >> 16) & 255) / 255.0f, 2.2d);
                float fPow2 = (float) Math.pow(((i7 >> 8) & 255) / 255.0f, 2.2d);
                float fPow3 = (float) Math.pow((i7 & 255) / 255.0f, 2.2d);
                ret[0] = fPow;
                ret[1] = fPow2;
                ret[2] = fPow3;
                ret[3] = i8 / 255.0f;
                return;
            case 6:
                ret[0] = this.f4636d;
                return;
            case 7:
                ret[0] = this.f4637e;
                return;
            case 8:
                ret[0] = this.f4637e;
                return;
            default:
                return;
        }
    }

    public boolean m() {
        return this.f4639g;
    }

    public boolean n() {
        int i7 = C0046a.f4641a[this.f4635c.ordinal()];
        return (i7 == 1 || i7 == 2 || i7 == 3) ? false : true;
    }

    public boolean o() {
        return this.f4633a;
    }

    public int p() {
        int i7 = C0046a.f4641a[this.f4635c.ordinal()];
        return (i7 == 4 || i7 == 5) ? 4 : 1;
    }

    public void s(int value) {
        this.f4640h = value;
    }

    public void t(float value) {
        this.f4637e = value;
    }

    public void u(int value) {
        this.f4636d = value;
    }

    public void v(String value) {
        this.f4638f = value;
    }

    public void w(Object value) {
        switch (C0046a.f4641a[this.f4635c.ordinal()]) {
            case 1:
            case 6:
                this.f4636d = ((Integer) value).intValue();
                break;
            case 2:
                this.f4639g = ((Boolean) value).booleanValue();
                break;
            case 3:
                this.f4638f = (String) value;
                break;
            case 4:
            case 5:
                this.f4640h = ((Integer) value).intValue();
                break;
            case 7:
                this.f4637e = ((Float) value).floatValue();
                break;
            case 8:
                this.f4637e = ((Float) value).floatValue();
                break;
        }
    }

    public void x(float[] value) {
        switch (C0046a.f4641a[this.f4635c.ordinal()]) {
            case 1:
            case 6:
                this.f4636d = (int) value[0];
                return;
            case 2:
                this.f4639g = ((double) value[0]) > 0.5d;
                return;
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
            case 5:
                int iHSVToColor = Color.HSVToColor(value);
                this.f4640h = iHSVToColor;
                this.f4640h = (b((int) (value[3] * 255.0f)) << 24) | (iHSVToColor & n2.f6742s);
                return;
            case 7:
                this.f4637e = value[0];
                return;
            case 8:
                this.f4637e = value[0];
                return;
            default:
                return;
        }
    }

    public a(String name, b attributeType, Object value, boolean method) {
        this.f4634b = name;
        this.f4635c = attributeType;
        this.f4633a = method;
        w(value);
    }

    public a(a source, Object value) {
        this.f4633a = false;
        this.f4634b = source.f4634b;
        this.f4635c = source.f4635c;
        w(value);
    }
}
