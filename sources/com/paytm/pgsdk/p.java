package com.paytm.pgsdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import c.o0;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f33086a = "=";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f33087b = "&";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f33088c = "PGSDK";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f33089d = "UTF-8";

    public static synchronized void a(String str) {
        e.a(f33088c, str);
    }

    protected static synchronized Bundle b(String str) {
        Bundle bundle;
        bundle = new Bundle();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() > 0) {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    String string = jSONObject.getString(next);
                    a(next + " = " + string);
                    bundle.putString(next, string);
                }
            }
        } catch (Exception e8) {
            a.e().f(d.f33012o, e8.getMessage());
            a("Error while parsing the Merchant Response");
            k(e8);
        }
        return bundle;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002a  */
    protected static String c(Bundle bundle) {
        JSONObject jSONObject;
        if (bundle != null) {
            try {
                if (bundle.size() > 0) {
                    jSONObject = new JSONObject();
                    for (String str : bundle.keySet()) {
                        jSONObject.put(str, bundle.get(str));
                    }
                } else {
                    jSONObject = null;
                }
            } catch (Exception e8) {
                k(e8);
                return null;
            }
        } else {
            jSONObject = null;
        }
        a("JSON string is " + jSONObject);
        return jSONObject.toString();
    }

    @o0
    public static String d(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.reset();
            return new String(messageDigest.digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e8) {
            k(e8);
            return null;
        }
    }

    protected static synchronized String e(Bundle bundle) {
        StringBuffer stringBuffer;
        try {
            a("Extracting Strings from Bundle...");
            stringBuffer = new StringBuffer();
            boolean z7 = true;
            for (String str : bundle.keySet()) {
                if (z7) {
                    z7 = false;
                } else {
                    stringBuffer.append("&");
                }
                stringBuffer.append(str);
                stringBuffer.append(f33086a);
                stringBuffer.append(bundle.getString(str));
            }
            a("Extracted String is " + stringBuffer.toString());
        } catch (Exception e8) {
            k(e8);
            return null;
        }
        return stringBuffer.toString();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0034  */
    protected static String f(Bundle bundle) {
        JSONObject jSONObject;
        if (bundle != null) {
            try {
                if (bundle.size() > 0) {
                    jSONObject = new JSONObject();
                    for (String str : bundle.keySet()) {
                        jSONObject.put(URLEncoder.encode(str, "UTF-8"), URLEncoder.encode(bundle.getString(str), "UTF-8"));
                    }
                } else {
                    jSONObject = null;
                }
            } catch (Exception e8) {
                k(e8);
                return null;
            }
        } else {
            jSONObject = null;
        }
        a("URL encoded JSON string is " + jSONObject);
        return jSONObject.toString();
    }

    protected static synchronized String g(Bundle bundle) {
        StringBuffer stringBuffer;
        try {
            a("Extracting Strings from Bundle...");
            stringBuffer = new StringBuffer();
            boolean z7 = true;
            for (String str : bundle.keySet()) {
                if (z7) {
                    z7 = false;
                } else {
                    stringBuffer.append("&");
                }
                stringBuffer.append(URLEncoder.encode(str, "UTF-8"));
                stringBuffer.append(f33086a);
                stringBuffer.append(URLEncoder.encode(bundle.getString(str), "UTF-8"));
            }
            a("URL encoded String is " + stringBuffer.toString());
        } catch (Exception e8) {
            k(e8);
            return null;
        }
        return stringBuffer.toString();
    }

    protected static synchronized boolean h(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        return activeNetworkInfo.isConnected();
    }

    public static boolean i(Context context) {
        try {
            context.getPackageManager().getPackageInfo(s.f33093p, 0);
            a.e().h(d.f33014q, d.f33011n, d.A, "true");
            return true;
        } catch (Exception unused) {
            a.e().h(d.f33014q, d.f33011n, d.A, d.G);
            a("Paytm app not installed");
            return false;
        }
    }

    public static boolean j(Context context) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("upi").authority("pay");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(builder.toString()));
        Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent, 0).iterator();
        while (it.hasNext()) {
            if (s.f33093p.equalsIgnoreCase(it.next().activityInfo.packageName)) {
                return true;
            }
        }
        return false;
    }

    protected static synchronized void k(Exception exc) {
        exc.printStackTrace();
    }
}
