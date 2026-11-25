package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import androidx.core.R;
import c.m0;
import c.o0;
import c.t;
import c.t0;
import c.x0;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f5713a = 400;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f5714b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5715c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f5716d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f5717e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f5718f = 500;

    @t0(21)
    static class a {
        private a() {
        }

        @t
        static int a(TypedArray typedArray, int i7) {
            return typedArray.getType(i7);
        }
    }

    public interface b {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    public static final class d implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m0
        private final e[] f5719a;

        public d(@m0 e[] eVarArr) {
            this.f5719a = eVarArr;
        }

        @m0
        public e[] a() {
            return this.f5719a;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m0
        private final String f5720a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f5721b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f5722c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f5723d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f5724e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f5725f;

        public e(@m0 String str, int i7, boolean z7, @o0 String str2, int i8, int i9) {
            this.f5720a = str;
            this.f5721b = i7;
            this.f5722c = z7;
            this.f5723d = str2;
            this.f5724e = i8;
            this.f5725f = i9;
        }

        @m0
        public String a() {
            return this.f5720a;
        }

        public int b() {
            return this.f5725f;
        }

        public int c() {
            return this.f5724e;
        }

        @o0
        public String d() {
            return this.f5723d;
        }

        public int e() {
            return this.f5721b;
        }

        public boolean f() {
            return this.f5722c;
        }
    }

    private f() {
    }

    private static int a(TypedArray typedArray, int i7) {
        return a.a(typedArray, i7);
    }

    @o0
    public static b b(@m0 XmlPullParser xmlPullParser, @m0 Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return d(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    @m0
    public static List<List<byte[]>> c(@m0 Resources resources, @c.e int i7) {
        if (i7 == 0) {
            return Collections.emptyList();
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i7);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(typedArrayObtainTypedArray, 0) == 1) {
                for (int i8 = 0; i8 < typedArrayObtainTypedArray.length(); i8++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i8, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i7)));
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    @o0
    private static b d(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    @o0
    private static b e(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamily);
        String string = typedArrayObtainAttributes.getString(R.styleable.FontFamily_fontProviderAuthority);
        String string2 = typedArrayObtainAttributes.getString(R.styleable.FontFamily_fontProviderPackage);
        String string3 = typedArrayObtainAttributes.getString(R.styleable.FontFamily_fontProviderQuery);
        int resourceId = typedArrayObtainAttributes.getResourceId(R.styleable.FontFamily_fontProviderCerts, 0);
        int integer = typedArrayObtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchTimeout, f5718f);
        String string4 = typedArrayObtainAttributes.getString(R.styleable.FontFamily_fontProviderSystemFontFamily);
        typedArrayObtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                g(xmlPullParser);
            }
            return new C0059f(new androidx.core.provider.h(string, string2, string3, c(resources, resourceId)), integer, integer2, string4);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(f(xmlPullParser, resources));
                } else {
                    g(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new d((e[]) arrayList.toArray(new e[0]));
    }

    private static e f(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamilyFont);
        int i7 = typedArrayObtainAttributes.getInt(typedArrayObtainAttributes.hasValue(R.styleable.FontFamilyFont_fontWeight) ? R.styleable.FontFamilyFont_fontWeight : R.styleable.FontFamilyFont_android_fontWeight, f5713a);
        boolean z7 = 1 == typedArrayObtainAttributes.getInt(typedArrayObtainAttributes.hasValue(R.styleable.FontFamilyFont_fontStyle) ? R.styleable.FontFamilyFont_fontStyle : R.styleable.FontFamilyFont_android_fontStyle, 0);
        int i8 = typedArrayObtainAttributes.hasValue(R.styleable.FontFamilyFont_ttcIndex) ? R.styleable.FontFamilyFont_ttcIndex : R.styleable.FontFamilyFont_android_ttcIndex;
        String string = typedArrayObtainAttributes.getString(typedArrayObtainAttributes.hasValue(R.styleable.FontFamilyFont_fontVariationSettings) ? R.styleable.FontFamilyFont_fontVariationSettings : R.styleable.FontFamilyFont_android_fontVariationSettings);
        int i9 = typedArrayObtainAttributes.getInt(i8, 0);
        int i10 = typedArrayObtainAttributes.hasValue(R.styleable.FontFamilyFont_font) ? R.styleable.FontFamilyFont_font : R.styleable.FontFamilyFont_android_font;
        int resourceId = typedArrayObtainAttributes.getResourceId(i10, 0);
        String string2 = typedArrayObtainAttributes.getString(i10);
        typedArrayObtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new e(string2, i7, z7, string, i9, resourceId);
    }

    private static void g(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i7 = 1;
        while (i7 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i7++;
            } else if (next == 3) {
                i7--;
            }
        }
    }

    private static List<byte[]> h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: androidx.core.content.res.f$f, reason: collision with other inner class name */
    public static final class C0059f implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m0
        private final androidx.core.provider.h f5726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f5727b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f5728c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @o0
        private final String f5729d;

        @x0({x0.a.LIBRARY})
        public C0059f(@m0 androidx.core.provider.h hVar, int i7, int i8, @o0 String str) {
            this.f5726a = hVar;
            this.f5728c = i7;
            this.f5727b = i8;
            this.f5729d = str;
        }

        public int a() {
            return this.f5728c;
        }

        @m0
        public androidx.core.provider.h b() {
            return this.f5726a;
        }

        @o0
        @x0({x0.a.LIBRARY})
        public String c() {
            return this.f5729d;
        }

        public int d() {
            return this.f5727b;
        }

        public C0059f(@m0 androidx.core.provider.h hVar, int i7, int i8) {
            this(hVar, i7, i8, null);
        }
    }
}
