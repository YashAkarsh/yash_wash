package bolts;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.test.internal.runner.listener.InstrumentationResultPrinter;
import com.facebook.internal.NativeProtocol;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f11381d = "com.parse.bolts.measurement_event";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f11382e = "event_name";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f11383f = "event_args";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f11384g = "al_nav_out";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f11385h = "al_nav_in";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bundle f11388c;

    private o(Context context, String str, Bundle bundle) {
        this.f11386a = context.getApplicationContext();
        this.f11387b = str;
        this.f11388c = bundle;
    }

    private static Bundle a(Context context, String str, Bundle bundle, Intent intent) {
        Bundle bundle2 = new Bundle();
        ComponentName componentNameResolveActivity = intent.resolveActivity(context.getPackageManager());
        if (componentNameResolveActivity != null) {
            bundle2.putString(InstrumentationResultPrinter.f10179m, componentNameResolveActivity.getShortClassName());
        }
        if (f11384g.equals(str)) {
            if (componentNameResolveActivity != null) {
                bundle2.putString("package", componentNameResolveActivity.getPackageName());
            }
            if (intent.getData() != null) {
                bundle2.putString("outputURL", intent.getData().toString());
            }
            if (intent.getScheme() != null) {
                bundle2.putString("outputURLScheme", intent.getScheme());
            }
        } else if (f11385h.equals(str)) {
            if (intent.getData() != null) {
                bundle2.putString("inputURL", intent.getData().toString());
            }
            if (intent.getScheme() != null) {
                bundle2.putString("inputURLScheme", intent.getScheme());
            }
        }
        for (String str2 : bundle.keySet()) {
            Object obj = bundle.get(str2);
            if (obj instanceof Bundle) {
                Bundle bundle3 = (Bundle) obj;
                for (String str3 : bundle3.keySet()) {
                    String strB = b(bundle3.get(str3));
                    if (str2.equals("referer_app_link")) {
                        if (str3.equalsIgnoreCase("url")) {
                            bundle2.putString("refererURL", strB);
                        } else if (str3.equalsIgnoreCase(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING)) {
                            bundle2.putString("refererAppName", strB);
                        } else if (str3.equalsIgnoreCase("package")) {
                            bundle2.putString("sourceApplication", strB);
                        }
                    }
                    bundle2.putString(str2 + "/" + str3, strB);
                }
            } else {
                String strB2 = b(obj);
                if (str2.equals("target_url")) {
                    Uri uri = Uri.parse(strB2);
                    bundle2.putString("targetURL", uri.toString());
                    bundle2.putString("targetURLHost", uri.getHost());
                } else {
                    bundle2.putString(str2, strB2);
                }
            }
        }
        return bundle2;
    }

    private static String b(Object obj) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof JSONArray) || (obj instanceof JSONObject)) {
            return obj.toString();
        }
        try {
            if (obj instanceof Collection) {
                return new JSONArray((Collection) obj).toString();
            }
            return obj instanceof Map ? new JSONObject((Map) obj).toString() : obj.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    private void c() {
        if (this.f11387b == null) {
            Log.d(getClass().getName(), "Event name is required");
        }
        try {
            Class<?> cls = Class.forName("androidx.localbroadcastmanager.content.a");
            Method method = cls.getMethod("getInstance", Context.class);
            Method method2 = cls.getMethod("sendBroadcast", Intent.class);
            Object objInvoke = method.invoke(null, this.f11386a);
            Intent intent = new Intent(f11381d);
            intent.putExtra(f11382e, this.f11387b);
            intent.putExtra(f11383f, this.f11388c);
            method2.invoke(objInvoke, intent);
        } catch (Exception unused) {
            Log.d(getClass().getName(), "LocalBroadcastManager in android support library is required to raise bolts event.");
        }
    }

    static void d(Context context, String str, Intent intent, Map<String, String> map) {
        Bundle bundle = new Bundle();
        if (intent != null) {
            Bundle bundleA = f.a(intent);
            if (bundleA != null) {
                bundle = a(context, str, bundleA, intent);
            } else {
                Uri data = intent.getData();
                if (data != null) {
                    bundle.putString("intentData", data.toString());
                }
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    for (String str2 : extras.keySet()) {
                        bundle.putString(str2, b(extras.get(str2)));
                    }
                }
            }
        }
        if (map != null) {
            for (String str3 : map.keySet()) {
                bundle.putString(str3, map.get(str3));
            }
        }
        new o(context, str, bundle).c();
    }
}
