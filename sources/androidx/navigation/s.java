package androidx.navigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import c.l0;
import c.m0;
import c.x0;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f8899c = "argument";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f8900d = "deepLink";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f8901e = "action";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f8902f = "include";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @x0({x0.a.LIBRARY_GROUP})
    public static final String f8903g = "${applicationId}";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f8904h = new ThreadLocal<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f8905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private x f8906b;

    public s(@m0 Context context, @m0 x xVar) {
        this.f8905a = context;
        this.f8906b = xVar;
    }

    private static u a(TypedValue typedValue, u uVar, u uVar2, String str, String str2) throws XmlPullParserException {
        if (uVar == null || uVar == uVar2) {
            return uVar != null ? uVar : uVar2;
        }
        throw new XmlPullParserException("Type is " + str + " but found " + str2 + ": " + typedValue.data);
    }

    @m0
    private l b(@m0 Resources resources, @m0 XmlResourceParser xmlResourceParser, @m0 AttributeSet attributeSet, int i7) throws XmlPullParserException, IOException {
        int depth;
        l lVarA = this.f8906b.e(xmlResourceParser.getName()).a();
        lVarA.u(this.f8905a, attributeSet);
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2) {
                String name = xmlResourceParser.getName();
                if (f8899c.equals(name)) {
                    g(resources, lVarA, attributeSet, i7);
                } else if (f8900d.equals(name)) {
                    h(resources, lVarA, attributeSet);
                } else if ("action".equals(name)) {
                    d(resources, lVarA, attributeSet, xmlResourceParser, i7);
                } else if (f8902f.equals(name) && (lVarA instanceof n)) {
                    TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.NavInclude);
                    ((n) lVarA).I(c(typedArrayObtainAttributes.getResourceId(R.styleable.NavInclude_graph, 0)));
                    typedArrayObtainAttributes.recycle();
                } else if (lVarA instanceof n) {
                    ((n) lVarA).I(b(resources, xmlResourceParser, attributeSet, i7));
                }
            }
        }
        return lVarA;
    }

    private void d(@m0 Resources resources, @m0 l lVar, @m0 AttributeSet attributeSet, XmlResourceParser xmlResourceParser, int i7) throws XmlPullParserException, IOException {
        int depth;
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R.styleable.NavAction);
        int resourceId = typedArrayObtainAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_android_id, 0);
        d dVar = new d(typedArrayObtainAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_destination, 0));
        t.a aVar = new t.a();
        aVar.d(typedArrayObtainAttributes.getBoolean(androidx.navigation.common.R.styleable.NavAction_launchSingleTop, false));
        aVar.g(typedArrayObtainAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_popUpTo, -1), typedArrayObtainAttributes.getBoolean(androidx.navigation.common.R.styleable.NavAction_popUpToInclusive, false));
        aVar.b(typedArrayObtainAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_enterAnim, -1));
        aVar.c(typedArrayObtainAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_exitAnim, -1));
        aVar.e(typedArrayObtainAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_popEnterAnim, -1));
        aVar.f(typedArrayObtainAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_popExitAnim, -1));
        dVar.e(aVar.a());
        Bundle bundle = new Bundle();
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && f8899c.equals(xmlResourceParser.getName())) {
                f(resources, bundle, attributeSet, i7);
            }
        }
        if (!bundle.isEmpty()) {
            dVar.d(bundle);
        }
        lVar.x(resourceId, dVar);
        typedArrayObtainAttributes.recycle();
    }

    @m0
    private f e(@m0 TypedArray typedArray, @m0 Resources resources, int i7) throws XmlPullParserException {
        f.a aVar = new f.a();
        aVar.c(typedArray.getBoolean(androidx.navigation.common.R.styleable.NavArgument_nullable, false));
        ThreadLocal<TypedValue> threadLocal = f8904h;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        String string = typedArray.getString(androidx.navigation.common.R.styleable.NavArgument_argType);
        Object objK = null;
        u<?> uVarA = string != null ? u.a(string, resources.getResourcePackageName(i7)) : null;
        if (typedArray.getValue(androidx.navigation.common.R.styleable.NavArgument_android_defaultValue, typedValue)) {
            u<Integer> uVar = u.f8922c;
            if (uVarA == uVar) {
                int i8 = typedValue.resourceId;
                if (i8 != 0) {
                    objK = Integer.valueOf(i8);
                } else {
                    if (typedValue.type != 16 || typedValue.data != 0) {
                        throw new XmlPullParserException("unsupported value '" + ((Object) typedValue.string) + "' for " + uVarA.c() + ". Must be a reference to a resource.");
                    }
                    objK = 0;
                }
            } else {
                int i9 = typedValue.resourceId;
                if (i9 != 0) {
                    if (uVarA != null) {
                        throw new XmlPullParserException("unsupported value '" + ((Object) typedValue.string) + "' for " + uVarA.c() + ". You must use a \"" + uVar.c() + "\" type to reference other resources.");
                    }
                    uVarA = uVar;
                    objK = Integer.valueOf(i9);
                } else if (uVarA == u.f8930k) {
                    objK = typedArray.getString(androidx.navigation.common.R.styleable.NavArgument_android_defaultValue);
                } else {
                    int i10 = typedValue.type;
                    if (i10 == 3) {
                        String string2 = typedValue.string.toString();
                        if (uVarA == null) {
                            uVarA = u.d(string2);
                        }
                        objK = uVarA.k(string2);
                    } else if (i10 == 4) {
                        uVarA = a(typedValue, uVarA, u.f8926g, string, androidx.constraintlayout.core.motion.utils.w.b.f3028c);
                        objK = Float.valueOf(typedValue.getFloat());
                    } else if (i10 == 5) {
                        uVarA = a(typedValue, uVarA, u.f8921b, string, "dimension");
                        objK = Integer.valueOf((int) typedValue.getDimension(resources.getDisplayMetrics()));
                    } else if (i10 == 18) {
                        uVarA = a(typedValue, uVarA, u.f8928i, string, androidx.constraintlayout.core.motion.utils.w.b.f3031f);
                        objK = Boolean.valueOf(typedValue.data != 0);
                    } else {
                        if (i10 < 16 || i10 > 31) {
                            throw new XmlPullParserException("unsupported argument type " + typedValue.type);
                        }
                        uVarA = a(typedValue, uVarA, u.f8921b, string, androidx.constraintlayout.core.motion.utils.w.b.f3027b);
                        objK = Integer.valueOf(typedValue.data);
                    }
                }
            }
        }
        if (objK != null) {
            aVar.b(objK);
        }
        if (uVarA != null) {
            aVar.d(uVarA);
        }
        return aVar.a();
    }

    private void f(@m0 Resources resources, @m0 Bundle bundle, @m0 AttributeSet attributeSet, int i7) throws XmlPullParserException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R.styleable.NavArgument);
        String string = typedArrayObtainAttributes.getString(androidx.navigation.common.R.styleable.NavArgument_android_name);
        if (string == null) {
            throw new XmlPullParserException("Arguments must have a name");
        }
        f fVarE = e(typedArrayObtainAttributes, resources, i7);
        if (fVarE.c()) {
            fVarE.e(string, bundle);
        }
        typedArrayObtainAttributes.recycle();
    }

    private void g(@m0 Resources resources, @m0 l lVar, @m0 AttributeSet attributeSet, int i7) throws XmlPullParserException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R.styleable.NavArgument);
        String string = typedArrayObtainAttributes.getString(androidx.navigation.common.R.styleable.NavArgument_android_name);
        if (string == null) {
            throw new XmlPullParserException("Arguments must have a name");
        }
        lVar.a(string, e(typedArrayObtainAttributes, resources, i7));
        typedArrayObtainAttributes.recycle();
    }

    private void h(@m0 Resources resources, @m0 l lVar, @m0 AttributeSet attributeSet) throws XmlPullParserException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R.styleable.NavDeepLink);
        String string = typedArrayObtainAttributes.getString(androidx.navigation.common.R.styleable.NavDeepLink_uri);
        String string2 = typedArrayObtainAttributes.getString(androidx.navigation.common.R.styleable.NavDeepLink_action);
        String string3 = typedArrayObtainAttributes.getString(androidx.navigation.common.R.styleable.NavDeepLink_mimeType);
        if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3)) {
            throw new XmlPullParserException("Every <deepLink> must include at least one of app:uri, app:action, or app:mimeType");
        }
        i.a aVar = new i.a();
        if (string != null) {
            aVar.g(string.replace(f8903g, this.f8905a.getPackageName()));
        }
        if (!TextUtils.isEmpty(string2)) {
            aVar.e(string2.replace(f8903g, this.f8905a.getPackageName()));
        }
        if (string3 != null) {
            aVar.f(string3.replace(f8903g, this.f8905a.getPackageName()));
        }
        lVar.b(aVar.a());
        typedArrayObtainAttributes.recycle();
    }

    @m0
    @SuppressLint({"ResourceType"})
    public n c(@l0 int i7) {
        int next;
        Resources resources = this.f8905a.getResources();
        XmlResourceParser xml = resources.getXml(i7);
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
        do {
            try {
                try {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } catch (Exception e8) {
                    throw new RuntimeException("Exception inflating " + resources.getResourceName(i7) + " line " + xml.getLineNumber(), e8);
                }
            } catch (Throwable th) {
                xml.close();
                throw th;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        l lVarB = b(resources, xml, attributeSetAsAttributeSet, i7);
        if (lVarB instanceof n) {
            n nVar = (n) lVarB;
            xml.close();
            return nVar;
        }
        throw new IllegalArgumentException("Root element <" + name + "> did not inflate into a NavGraph");
    }
}
