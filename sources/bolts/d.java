package bolts;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import com.facebook.internal.AnalyticsEvents;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f11341d = "user_agent";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f11342e = "version";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f11343f = "referer_app_link";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f11344g = "app_name";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f11345h = "package";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f11346i = "1.0";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static e f11347j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f11348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Bundle f11349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Bundle f11350c;

    static class a implements m<c, b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f11351a;

        a(Context context) {
            this.f11351a = context;
        }

        @Override // bolts.m
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(p<c> pVar) throws Exception {
            return d.j(this.f11351a, pVar.F());
        }
    }

    public enum b {
        FAILED(com.alipay.sdk.util.f.f13791i, false),
        WEB(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB, true),
        APP("app", true);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f11356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f11357b;

        b(String str, boolean z7) {
            this.f11356a = str;
            this.f11357b = z7;
        }

        public String a() {
            return this.f11356a;
        }

        public boolean b() {
            return this.f11357b;
        }
    }

    public d(c cVar, Bundle bundle, Bundle bundle2) {
        if (cVar == null) {
            throw new IllegalArgumentException("appLink must not be null.");
        }
        bundle = bundle == null ? new Bundle() : bundle;
        bundle2 = bundle2 == null ? new Bundle() : bundle2;
        this.f11348a = cVar;
        this.f11349b = bundle;
        this.f11350c = bundle2;
    }

    private Bundle a(Context context) {
        String string;
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        if (context != null) {
            String packageName = context.getPackageName();
            if (packageName != null) {
                bundle2.putString(f11345h, packageName);
            }
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null && (string = context.getString(applicationInfo.labelRes)) != null) {
                bundle2.putString("app_name", string);
            }
        }
        bundle.putAll(c());
        bundle.putString("target_url", b().a().toString());
        bundle.putString("version", "1.0");
        bundle.putString("user_agent", "Bolts Android 1.4.0");
        bundle.putBundle(f11343f, bundle2);
        bundle.putBundle("extras", e());
        return bundle;
    }

    public static e d() {
        return f11347j;
    }

    private JSONObject f(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            jSONObject.put(str, g(bundle.get(str)));
        }
        return jSONObject;
    }

    private Object g(Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            return f((Bundle) obj);
        }
        if (obj instanceof CharSequence) {
            return obj.toString();
        }
        if (obj instanceof List) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                jSONArray.put(g(it.next()));
            }
            return jSONArray;
        }
        int i7 = 0;
        if (obj instanceof SparseArray) {
            JSONArray jSONArray2 = new JSONArray();
            SparseArray sparseArray = (SparseArray) obj;
            while (i7 < sparseArray.size()) {
                jSONArray2.put(sparseArray.keyAt(i7), g(sparseArray.valueAt(i7)));
                i7++;
            }
            return jSONArray2;
        }
        if (obj instanceof Character) {
            return obj.toString();
        }
        if (obj instanceof Boolean) {
            return obj;
        }
        if (obj instanceof Number) {
            return ((obj instanceof Double) || (obj instanceof Float)) ? Double.valueOf(((Number) obj).doubleValue()) : Long.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof boolean[]) {
            JSONArray jSONArray3 = new JSONArray();
            boolean[] zArr = (boolean[]) obj;
            int length = zArr.length;
            while (i7 < length) {
                jSONArray3.put(g(Boolean.valueOf(zArr[i7])));
                i7++;
            }
            return jSONArray3;
        }
        if (obj instanceof char[]) {
            JSONArray jSONArray4 = new JSONArray();
            char[] cArr = (char[]) obj;
            int length2 = cArr.length;
            while (i7 < length2) {
                jSONArray4.put(g(Character.valueOf(cArr[i7])));
                i7++;
            }
            return jSONArray4;
        }
        if (obj instanceof CharSequence[]) {
            JSONArray jSONArray5 = new JSONArray();
            CharSequence[] charSequenceArr = (CharSequence[]) obj;
            int length3 = charSequenceArr.length;
            while (i7 < length3) {
                jSONArray5.put(g(charSequenceArr[i7]));
                i7++;
            }
            return jSONArray5;
        }
        if (obj instanceof double[]) {
            JSONArray jSONArray6 = new JSONArray();
            double[] dArr = (double[]) obj;
            int length4 = dArr.length;
            while (i7 < length4) {
                jSONArray6.put(g(Double.valueOf(dArr[i7])));
                i7++;
            }
            return jSONArray6;
        }
        if (obj instanceof float[]) {
            JSONArray jSONArray7 = new JSONArray();
            float[] fArr = (float[]) obj;
            int length5 = fArr.length;
            while (i7 < length5) {
                jSONArray7.put(g(Float.valueOf(fArr[i7])));
                i7++;
            }
            return jSONArray7;
        }
        if (obj instanceof int[]) {
            JSONArray jSONArray8 = new JSONArray();
            int[] iArr = (int[]) obj;
            int length6 = iArr.length;
            while (i7 < length6) {
                jSONArray8.put(g(Integer.valueOf(iArr[i7])));
                i7++;
            }
            return jSONArray8;
        }
        if (obj instanceof long[]) {
            JSONArray jSONArray9 = new JSONArray();
            long[] jArr = (long[]) obj;
            int length7 = jArr.length;
            while (i7 < length7) {
                jSONArray9.put(g(Long.valueOf(jArr[i7])));
                i7++;
            }
            return jSONArray9;
        }
        if (obj instanceof short[]) {
            JSONArray jSONArray10 = new JSONArray();
            short[] sArr = (short[]) obj;
            int length8 = sArr.length;
            while (i7 < length8) {
                jSONArray10.put(g(Short.valueOf(sArr[i7])));
                i7++;
            }
            return jSONArray10;
        }
        if (!(obj instanceof String[])) {
            return null;
        }
        JSONArray jSONArray11 = new JSONArray();
        String[] strArr = (String[]) obj;
        int length9 = strArr.length;
        while (i7 < length9) {
            jSONArray11.put(g(strArr[i7]));
            i7++;
        }
        return jSONArray11;
    }

    private static e h(Context context) {
        return d() != null ? d() : new t(context);
    }

    public static b j(Context context, c cVar) {
        return new d(cVar, null, null).i(context);
    }

    public static p<b> k(Context context, Uri uri) {
        return l(context, uri, h(context));
    }

    public static p<b> l(Context context, Uri uri, e eVar) {
        return eVar.a(uri).N(new a(context), p.f11391k);
    }

    public static p<b> m(Context context, String str) {
        return n(context, str, h(context));
    }

    public static p<b> n(Context context, String str, e eVar) {
        return l(context, Uri.parse(str), eVar);
    }

    public static p<b> o(Context context, URL url) {
        return p(context, url, h(context));
    }

    public static p<b> p(Context context, URL url, e eVar) {
        return l(context, Uri.parse(url.toString()), eVar);
    }

    private void q(Context context, Intent intent, b bVar, JSONException jSONException) {
        HashMap map = new HashMap();
        if (jSONException != null) {
            map.put("error", jSONException.getLocalizedMessage());
        }
        map.put("success", bVar.b() ? "1" : "0");
        map.put("type", bVar.a());
        o.d(context, o.f11384g, intent, map);
    }

    public static void r(e eVar) {
        f11347j = eVar;
    }

    public c b() {
        return this.f11348a;
    }

    public Bundle c() {
        return this.f11350c;
    }

    public Bundle e() {
        return this.f11349b;
    }

    public b i(Context context) {
        Intent intent;
        PackageManager packageManager = context.getPackageManager();
        Bundle bundleA = a(context);
        Iterator<c.a> it = b().b().iterator();
        do {
            if (!it.hasNext()) {
                intent = null;
                break;
            }
            c.a next = it.next();
            intent = new Intent("android.intent.action.VIEW");
            if (next.d() != null) {
                intent.setData(next.d());
            } else {
                intent.setData(this.f11348a.a());
            }
            intent.setPackage(next.c());
            if (next.b() != null) {
                intent.setClassName(next.c(), next.b());
            }
            intent.putExtra("al_applink_data", bundleA);
        } while (packageManager.resolveActivity(intent, 65536) == null);
        b bVar = b.FAILED;
        if (intent != null) {
            bVar = b.APP;
        } else {
            Uri uriC = b().c();
            if (uriC != null) {
                try {
                    intent = new Intent("android.intent.action.VIEW", uriC.buildUpon().appendQueryParameter("al_applink_data", f(bundleA).toString()).build());
                    bVar = b.WEB;
                } catch (JSONException e8) {
                    q(context, intent, b.FAILED, e8);
                    throw new RuntimeException(e8);
                }
            } else {
                intent = null;
            }
        }
        q(context, intent, bVar, null);
        if (intent != null) {
            context.startActivity(intent);
        }
        return bVar;
    }
}
