package androidx.core.content.pm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY_GROUP})
public class w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5654a = "ShortcutXmlParser";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f5655b = "android.app.shortcuts";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f5656c = "shortcut";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f5657d = "shortcutId";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile ArrayList<String> f5658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f5659f = new Object();

    private w1() {
    }

    private static String a(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str);
        return attributeValue == null ? xmlPullParser.getAttributeValue(null, str) : attributeValue;
    }

    @c.h1
    @c.m0
    public static List<String> b(@c.m0 Context context) {
        if (f5658e == null) {
            synchronized (f5659f) {
                if (f5658e == null) {
                    f5658e = new ArrayList<>();
                    f5658e.addAll(e(context));
                }
            }
        }
        return f5658e;
    }

    @c.m0
    private static XmlResourceParser c(Context context, ActivityInfo activityInfo) {
        XmlResourceParser xmlResourceParserLoadXmlMetaData = activityInfo.loadXmlMetaData(context.getPackageManager(), f5655b);
        if (xmlResourceParserLoadXmlMetaData != null) {
            return xmlResourceParserLoadXmlMetaData;
        }
        throw new IllegalArgumentException("Failed to open android.app.shortcuts meta-data resource of " + activityInfo.name);
    }

    @c.m0
    @c.g1
    public static List<String> d(@c.m0 XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String strA;
        ArrayList arrayList = new ArrayList(1);
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || (next == 3 && xmlPullParser.getDepth() <= 0)) {
                break;
            }
            int depth = xmlPullParser.getDepth();
            String name = xmlPullParser.getName();
            if (next == 2 && depth == 2 && f5656c.equals(name) && (strA = a(xmlPullParser, f5657d)) != null) {
                arrayList.add(strA);
            }
        }
        return arrayList;
    }

    @c.m0
    private static Set<String> e(@c.m0 Context context) {
        HashSet hashSet = new HashSet();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 128);
        if (listQueryIntentActivities != null && listQueryIntentActivities.size() != 0) {
            try {
                Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
                while (it.hasNext()) {
                    ActivityInfo activityInfo = it.next().activityInfo;
                    Bundle bundle = activityInfo.metaData;
                    if (bundle != null && bundle.containsKey(f5655b)) {
                        XmlResourceParser xmlResourceParserC = c(context, activityInfo);
                        try {
                            hashSet.addAll(d(xmlResourceParserC));
                            if (xmlResourceParserC != null) {
                                xmlResourceParserC.close();
                            }
                        } catch (Throwable th) {
                            if (xmlResourceParserC != null) {
                                try {
                                    xmlResourceParserC.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    }
                }
            } catch (Exception e8) {
                Log.e(f5654a, "Failed to parse the Xml resource: ", e8);
            }
        }
        return hashSet;
    }
}
