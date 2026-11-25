package androidx.test.internal.runner.tracker;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import androidx.test.internal.util.Checks;
import j0.b;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class AnalyticsBasedUsageTracker implements UsageTracker {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f10199i = "InfraTrack";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f10200j = "UTF-8";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f10201k = "an=";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f10202l = "&cd=";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f10203m = "&av=";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f10204n = "&tid=";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f10205o = "&cid=";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f10206p = "&sr=";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f10207q = "&cd2=";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f10208r = "&cd3=";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final URL f10211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f10212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f10213e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f10214f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f10215g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map<String, String> f10216h;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f10217a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Uri f10218b = new Uri.Builder().scheme(b.f34226a).authority("www.google-analytics.com").path("collect").build();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f10219c = "UA-36650409-3";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f10220d = String.valueOf(Build.VERSION.SDK_INT);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f10221e = Build.MODEL;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f10222f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private URL f10223g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f10224h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f10225i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f10226j;

        public Builder(Context targetContext) {
            if (targetContext == null) {
                throw new NullPointerException("Context null!?");
            }
            this.f10217a = targetContext;
        }

        private boolean i() {
            return this.f10217a.checkCallingOrSelfPermission("android.permission.INTERNET") == 0;
        }

        public UsageTracker h() {
            if (!i()) {
                Log.d(AnalyticsBasedUsageTracker.f10199i, "Tracking disabled due to lack of internet permissions");
                return null;
            }
            if (this.f10222f == null) {
                n(this.f10217a.getPackageName());
            }
            if (this.f10222f.contains("com.google.analytics")) {
                Log.d(AnalyticsBasedUsageTracker.f10199i, "Refusing to use analytics while testing analytics.");
                return null;
            }
            try {
                if (!this.f10222f.startsWith("com.google.") && !this.f10222f.startsWith("com.android.") && !this.f10222f.startsWith("android.support.")) {
                    if (!this.f10226j) {
                        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                        messageDigest.reset();
                        messageDigest.update(this.f10222f.getBytes("UTF-8"));
                        String strValueOf = String.valueOf(new BigInteger(messageDigest.digest()).toString(16));
                        this.f10222f = strValueOf.length() != 0 ? "sha256-".concat(strValueOf) : new String("sha256-");
                    }
                    this.f10226j = true;
                }
                try {
                    this.f10223g = new URL(this.f10218b.toString());
                    if (this.f10224h == null) {
                        Display defaultDisplay = ((WindowManager) this.f10217a.getSystemService("window")).getDefaultDisplay();
                        if (defaultDisplay == null) {
                            this.f10224h = "0x0";
                        } else {
                            this.f10224h = defaultDisplay.getWidth() + "x" + defaultDisplay.getHeight();
                        }
                    }
                    if (this.f10225i == null) {
                        this.f10225i = UUID.randomUUID().toString();
                    }
                    return new AnalyticsBasedUsageTracker(this);
                } catch (MalformedURLException e8) {
                    String strValueOf2 = String.valueOf(this.f10218b.toString());
                    Log.w(AnalyticsBasedUsageTracker.f10199i, strValueOf2.length() != 0 ? "Tracking disabled bad url: ".concat(strValueOf2) : new String("Tracking disabled bad url: "), e8);
                    return null;
                }
            } catch (UnsupportedEncodingException e9) {
                Log.d(AnalyticsBasedUsageTracker.f10199i, "Impossible - no utf-8 encoding?", e9);
                return null;
            } catch (NoSuchAlgorithmException e10) {
                Log.d(AnalyticsBasedUsageTracker.f10199i, "Cannot hash package name.", e10);
                return null;
            }
        }

        public Builder j(Uri analyticsUri) {
            Checks.f(analyticsUri);
            this.f10218b = analyticsUri;
            return this;
        }

        public Builder k(String apiLevel) {
            this.f10220d = apiLevel;
            return this;
        }

        public Builder l(String model) {
            this.f10221e = model;
            return this;
        }

        public Builder m(String resolutionVal) {
            this.f10224h = resolutionVal;
            return this;
        }

        public Builder n(String targetPackage) {
            this.f10226j = false;
            this.f10222f = targetPackage;
            return this;
        }

        public Builder o(String trackingId) {
            this.f10219c = trackingId;
            return this;
        }

        public Builder p(String userId) {
            this.f10225i = userId;
            return this;
        }
    }

    @Override // androidx.test.internal.runner.tracker.UsageTracker
    public void a() throws Throwable {
        String str;
        HttpURLConnection httpURLConnection;
        Throwable th;
        synchronized (this.f10216h) {
            if (this.f10216h.isEmpty()) {
                return;
            }
            HashMap map = new HashMap(this.f10216h);
            this.f10216h.clear();
            try {
                str = f10201k + URLEncoder.encode(this.f10210b, "UTF-8") + f10204n + URLEncoder.encode(this.f10209a, "UTF-8") + "&v=1&z=" + SystemClock.uptimeMillis() + f10205o + URLEncoder.encode(this.f10215g, "UTF-8") + f10206p + URLEncoder.encode(this.f10212d, "UTF-8") + f10207q + URLEncoder.encode(this.f10213e, "UTF-8") + f10208r + URLEncoder.encode(this.f10214f, "UTF-8") + "&t=appview&sc=start";
            } catch (IOException e8) {
                Log.w(f10199i, "Impossible error happened. analytics disabled.", e8);
                str = null;
            }
            for (Map.Entry entry : map.entrySet()) {
                try {
                    httpURLConnection = (HttpURLConnection) this.f10211c.openConnection();
                    try {
                        try {
                            byte[] bytes = (str + f10202l + URLEncoder.encode((String) entry.getKey(), "UTF-8") + f10203m + URLEncoder.encode((String) entry.getValue(), "UTF-8")).getBytes();
                            httpURLConnection.setConnectTimeout(3000);
                            httpURLConnection.setReadTimeout(5000);
                            httpURLConnection.setDoOutput(true);
                            httpURLConnection.setFixedLengthStreamingMode(bytes.length);
                            httpURLConnection.getOutputStream().write(bytes);
                            if (httpURLConnection.getResponseCode() / 100 != 2) {
                                String strValueOf = String.valueOf(entry);
                                int responseCode = httpURLConnection.getResponseCode();
                                String responseMessage = httpURLConnection.getResponseMessage();
                                StringBuilder sb = new StringBuilder(strValueOf.length() + 45 + String.valueOf(responseMessage).length());
                                sb.append("Analytics post: ");
                                sb.append(strValueOf);
                                sb.append(" failed. code: ");
                                sb.append(responseCode);
                                sb.append(" - ");
                                sb.append(responseMessage);
                                Log.w(f10199i, sb.toString());
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                    } catch (IOException e9) {
                        e = e9;
                        String strValueOf2 = String.valueOf(entry);
                        StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 25);
                        sb2.append("Analytics post: ");
                        sb2.append(strValueOf2);
                        sb2.append(" failed. ");
                        Log.w(f10199i, sb2.toString(), e);
                        if (httpURLConnection != null) {
                        }
                    }
                } catch (IOException e10) {
                    e = e10;
                    httpURLConnection = null;
                } catch (Throwable th3) {
                    httpURLConnection = null;
                    th = th3;
                }
                httpURLConnection.disconnect();
            }
        }
    }

    @Override // androidx.test.internal.runner.tracker.UsageTracker
    public void b(String usageType, String version) {
        synchronized (this.f10216h) {
            this.f10216h.put(usageType, version);
        }
    }

    private AnalyticsBasedUsageTracker(Builder builder) {
        this.f10216h = new HashMap();
        this.f10209a = (String) Checks.f(builder.f10219c);
        this.f10210b = (String) Checks.f(builder.f10222f);
        this.f10211c = (URL) Checks.f(builder.f10223g);
        this.f10213e = (String) Checks.f(builder.f10220d);
        this.f10214f = (String) Checks.f(builder.f10221e);
        this.f10212d = (String) Checks.f(builder.f10224h);
        this.f10215g = (String) Checks.f(builder.f10225i);
    }
}
