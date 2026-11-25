package easypay.appinvoke.manager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.d;
import androidx.fragment.app.v;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.google.gson.g;
import com.haier.uhome.account.api.Const;
import com.haier.uhome.usdk.base.a;
import easypay.appinvoke.actions.EasypayBrowserFragment;
import easypay.appinvoke.actions.GAEventManager;
import easypay.appinvoke.utils.EasyPayConfigDownloader;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;
import paytm.assist.easypay.easypay.appinvoke.R;
import w4.e;
import x4.b;
import x4.c;
import x4.f;

/* JADX INFO: loaded from: classes2.dex */
public class PaytmAssist {
    private static PaytmAssist assistInstance = null;
    private static Context context = null;
    private static boolean isEasyPayActive = true;
    public static boolean isEasyPayEnabled = true;
    private String appVersionTest;
    private String bankName;
    private String cardDetails;
    private String cardScheme;
    private EasyPayHelper easyPayHelper;
    private EasypayBrowserFragment fragment;
    private Integer fragmentViewId;
    private boolean isAssistEngineTerminated;
    private String lastLoadedUrl;
    private AppCompatActivity mActivity;
    private StringBuilder mAnalyticsExtraParam;
    private GAEventManager mAnalyticsManager;
    private b mAppCallback;
    private c mEventCallBack;
    private ArrayList<f> mWcListListener;
    private String mid;
    private String orderId;
    private String payType;
    private WebViewClient paymentWebClient;
    private EasypayWebViewClient webClientInstance;
    private WebView webView = null;
    private Map<String, Object> mEventMap = new HashMap();
    private boolean isShowNbLoader = false;
    private String configUrlToHit = "";
    private boolean isFragmentResumed = true;
    private boolean isFragmentStopped = true;

    private void accessCheckApi() {
        new Thread(new Runnable() { // from class: easypay.appinvoke.manager.PaytmAssist.2
            @Override // java.lang.Runnable
            public void run() {
                if (PaytmAssist.this.mid != null) {
                    try {
                        HashMap map = new HashMap();
                        map.put("mid", PaytmAssist.this.mid);
                        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
                        if (new OkHttpClient().newCall(new Request.Builder().url(Constants.WelcomeApi).post(RequestBody.create(mediaType, new g().d().z(map))).build()).execute().body() == null || PaytmAssist.this.mActivity == null) {
                            return;
                        }
                        PaytmAssist.this.mActivity.runOnUiThread(new Runnable() { // from class: easypay.appinvoke.manager.PaytmAssist.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PaytmAssist.this.initAssist();
                            }
                        });
                    } catch (Exception e8) {
                        e8.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void configureWebClient() {
        WebViewClient paymentWebClient = getAssistInstance().getPaymentWebClient();
        if (paymentWebClient == null) {
            paymentWebClient = getAssistInstance().getWebClientInstance();
        }
        this.webView.setWebViewClient(paymentWebClient);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadBankWiseConfig(String str) {
        try {
            Intent intent = new Intent(this.mActivity, (Class<?>) EasyPayConfigDownloader.class);
            intent.putExtra(Constants.EXTRA_BANK_REQ_JSON, str);
            EasyPayConfigDownloader.n(this.mActivity.getBaseContext(), intent);
        } catch (Exception unused) {
        }
    }

    private void fetchAPIByAppVersion(final String str) {
        new Thread(new Runnable() { // from class: easypay.appinvoke.manager.PaytmAssist.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Constants.FETCH_URL_API).openConnection();
                    httpURLConnection.setReadTimeout(a.ba);
                    httpURLConnection.setConnectTimeout(13000);
                    httpURLConnection.setRequestMethod(Const.HTTP_REQUEST_TYPE_POST);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("deviceType", "android");
                    jSONObject.put("version", "8.2.2");
                    jSONObject.put("orderId", PaytmAssist.getAssistInstance().getOrderId());
                    jSONObject.put("mid", PaytmAssist.getAssistInstance().getMid());
                    jSONObject.put("deviceType", "ANDROID");
                    easypay.appinvoke.utils.b.a("Fetch APi requestURL:https://securegw.paytm.in/payassist/api/getURLByAppVersion", this);
                    httpURLConnection.setRequestProperty("Content-Type", "application/json");
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(jSONObject.toString().getBytes());
                    outputStream.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5120);
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        } else {
                            sb.append(line);
                        }
                    }
                    e eVar = (e) new com.google.gson.f().n(sb.toString(), e.class);
                    if (eVar != null && eVar.a() == 200) {
                        if (TextUtils.isEmpty(eVar.c())) {
                            PaytmAssist.this.setConfigUrlToHit("");
                        } else {
                            PaytmAssist.this.setConfigUrlToHit(eVar.c());
                            PaytmAssist.this.downloadBankWiseConfig(str);
                            easypay.appinvoke.utils.b.a("Get Config URL to hitURL:" + PaytmAssist.this.getConfigUrlToHit(), this);
                        }
                    }
                    bufferedInputStream.close();
                } catch (MalformedURLException e8) {
                    e8.printStackTrace();
                } catch (IOException e9) {
                    e9.printStackTrace();
                } catch (JSONException e10) {
                    e10.printStackTrace();
                }
            }
        }).start();
    }

    private String freeStorage() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return Long.toString((((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount())) / PlaybackStateCompat.G);
        } catch (Exception unused) {
            return "";
        }
    }

    public static synchronized PaytmAssist getAssistInstance() {
        if (assistInstance == null) {
            assistInstance = new PaytmAssist();
        }
        return assistInstance;
    }

    public static Context getContext() {
        return context;
    }

    public static boolean getEasyPayActiveStatus() {
        return isEasyPayActive;
    }

    public static void getEasyPayEnabledStatus(boolean z7) {
        isEasyPayEnabled = z7;
    }

    private String getNetworkType(Context context2) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getType() == 1) {
                    return "WIFI";
                }
                if (activeNetworkInfo.getType() == 0) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return "2G";
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return "3G";
                        case 13:
                            return "4G";
                        default:
                            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                    }
                }
            }
            return null;
        } catch (Exception e8) {
            e8.printStackTrace();
            return null;
        }
    }

    private WebViewClient getPaymentWebClient() {
        return this.paymentWebClient;
    }

    private void inflatePaytmAssist() {
        try {
            easypay.appinvoke.utils.b.a("Creating EasypayBrowserFragment", this);
            EasypayBrowserFragment easypayBrowserFragmentQ0 = EasypayBrowserFragment.q0();
            this.fragment = easypayBrowserFragmentQ0;
            setFragment(easypayBrowserFragmentQ0);
            v vVarR = this.mActivity.getSupportFragmentManager().r();
            if (this.mActivity == null || this.fragment.isAdded()) {
                return;
            }
            vVarR.g(this.fragmentViewId.intValue(), this.fragment);
            vVarR.r();
            this.webView.setWebChromeClient(new v4.a(this.fragment));
            this.mAnalyticsManager.j(this.mActivity.getPackageName(), this.orderId, this.mActivity.getPackageManager().getPackageInfo(this.mActivity.getPackageName(), 0).versionName);
            this.mAnalyticsManager.u(this.mid);
        } catch (Exception e8) {
            e8.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initAssist() {
        Context context2;
        AppCompatActivity appCompatActivity = this.mActivity;
        if (appCompatActivity == null || (context2 = context) == null) {
            return;
        }
        try {
            if (!isEasyPayEnabled) {
                this.mAnalyticsManager.j(this.mActivity.getPackageName(), this.orderId, appCompatActivity.getPackageManager().getPackageInfo(this.mActivity.getPackageName(), 0).versionName);
            } else if (d.a(context2, "android.permission.READ_SMS") == 0) {
                this.mAnalyticsManager.o(true);
                inflatePaytmAssist();
                if (this.mActivity.getPackageManager() != null) {
                    this.mAnalyticsManager.j(this.mActivity.getPackageName(), this.orderId, this.mActivity.getPackageManager().getPackageInfo(this.mActivity.getPackageName(), 0).versionName);
                } else {
                    this.mAnalyticsManager.j(this.mActivity.getPackageName(), this.orderId, "Version Not Found");
                }
            } else {
                if (d.a(context, "android.permission.READ_SMS") == 0 || !isEasyPayEnabled) {
                    return;
                }
                this.mAnalyticsManager.o(false);
                inflatePaytmAssist();
                if (this.mActivity.getPackageManager() != null) {
                    this.mAnalyticsManager.j(this.mActivity.getPackageName(), this.orderId, this.mActivity.getPackageManager().getPackageInfo(this.mActivity.getPackageName(), 0).versionName);
                } else {
                    this.mAnalyticsManager.j(this.mActivity.getPackageName(), this.orderId, "Version Not Found");
                }
            }
        } catch (Exception unused) {
        }
    }

    private static void setAssistInstance(PaytmAssist paytmAssist) {
        assistInstance = paytmAssist;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConfigUrlToHit(String str) {
        this.configUrlToHit = str;
    }

    public static void setContext(Context context2) {
        context = context2;
    }

    public static void setEasyPayActiveStatus(boolean z7) {
        isEasyPayActive = z7;
    }

    public static boolean setEasyPayEnabledStatus() {
        return isEasyPayEnabled;
    }

    private void setEasyPayHelper() {
        this.easyPayHelper = new EasyPayHelper();
    }

    private void setFragmentViewId(Integer num) {
        this.fragmentViewId = num;
    }

    private void setWebClientInstance(EasypayWebViewClient easypayWebViewClient) {
        this.webClientInstance = easypayWebViewClient;
    }

    private void setWebView(WebView webView) {
        this.webView = webView;
    }

    public String geTxnBank() {
        if (TextUtils.isEmpty(this.bankName)) {
            return null;
        }
        return this.bankName;
    }

    public String getAppVersionTest() {
        return this.appVersionTest;
    }

    boolean getAssistEngineTerminatedStatus() {
        return this.isAssistEngineTerminated;
    }

    String getCardDetails() {
        return this.cardDetails;
    }

    public String getConfigUrlToHit() {
        return this.configUrlToHit;
    }

    public EasyPayHelper getEasyPayHelper() {
        EasyPayHelper easyPayHelper = this.easyPayHelper;
        return easyPayHelper == null ? new EasyPayHelper() : easyPayHelper;
    }

    public EasypayBrowserFragment getFragment() {
        return this.fragment;
    }

    public String getLastLoadedUrl() {
        return this.lastLoadedUrl;
    }

    public String getMid() {
        return this.mid;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getTxnPayType() {
        if (TextUtils.isEmpty(this.payType)) {
            this.payType = "";
        }
        return this.payType;
    }

    public EasypayWebViewClient getWebClientInstance() {
        if (this.webClientInstance == null && this.mActivity != null) {
            this.webClientInstance = new EasypayWebViewClient(this.mActivity);
        }
        return this.webClientInstance;
    }

    public WebView getWebView() {
        return this.webView;
    }

    public StringBuilder getmAnalyticsExtraParam() {
        return this.mAnalyticsExtraParam;
    }

    public GAEventManager getmAnalyticsManager() {
        return this.mAnalyticsManager;
    }

    public c getmEventCallBack() {
        return this.mEventCallBack;
    }

    public Map<String, Object> getmEventMap() {
        return this.mEventMap;
    }

    ArrayList<f> getmWcListListener() {
        return this.mWcListListener;
    }

    public boolean isAssistLayoutPopped() {
        EasypayBrowserFragment easypayBrowserFragment = this.fragment;
        if (easypayBrowserFragment != null) {
            return easypayBrowserFragment.f33632w;
        }
        return false;
    }

    public boolean isFragmentPaused() {
        return this.isFragmentStopped;
    }

    public boolean isFragmentResumed() {
        return this.isFragmentResumed;
    }

    public void registerSMSCallBack(b bVar) {
        this.mAppCallback = bVar;
    }

    public void removeAssist() {
        try {
            EasypayBrowserFragment easypayBrowserFragment = this.fragment;
            if (easypayBrowserFragment != null && easypayBrowserFragment.isAdded()) {
                v vVarR = this.mActivity.getSupportFragmentManager().r();
                vVarR.C(this.fragment);
                vVarR.s();
            }
            if (this.mActivity != null) {
                this.mActivity = null;
            }
            if (assistInstance != null) {
                assistInstance = null;
            }
            if (context != null) {
                context = null;
            }
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public void sendEvent(String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setAction("com.paytm.com.paytm.pgsdk.easypay.appinvoke.CUSTOM_EVENT");
        intent.putExtra("eventName", str);
        intent.putExtra("data0", str2);
        intent.putExtra("data1", str3);
        this.mActivity.sendBroadcast(intent);
    }

    public void setAppSMSCallback(String str) {
        b bVar = this.mAppCallback;
        if (bVar != null) {
            bVar.p(str);
        }
    }

    public void setAppVersionTest(String str) {
        easypay.appinvoke.utils.b.a("AppVersion:" + str, this);
        this.appVersionTest = str;
    }

    void setAssistEngineTerminatedStatus(boolean z7) {
        this.isAssistEngineTerminated = z7;
    }

    public boolean setAssistLoader() {
        return this.isShowNbLoader;
    }

    public void setBankInfo(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && str.contains("-")) {
            str = str.substring(0, str.indexOf("-"));
        }
        this.bankName = str;
        this.payType = str2.toLowerCase();
        this.cardScheme = str3.toLowerCase();
        GAEventManager gAEventManager = this.mAnalyticsManager;
        if (gAEventManager != null) {
            gAEventManager.y(this.payType);
            this.mAnalyticsManager.f(str3);
            this.cardDetails = str + str3 + str2;
            String lowerCase = (str + str3 + str2).toLowerCase();
            if (lowerCase.contains(Constants.EASYPAY_PAYTYPE_ATM) || lowerCase.contains("idebit") || lowerCase.contains("atm")) {
                this.mAnalyticsManager.n(true);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Constants.EXTRA_BANK_CODE, str);
                jSONObject.put("payType", str2);
                jSONObject.put(Constants.EXTRA_BANK_SCHEME, str3);
                fetchAPIByAppVersion(jSONObject.toString());
            } catch (JSONException e8) {
                e8.printStackTrace();
            }
        }
    }

    public void setFragment(EasypayBrowserFragment easypayBrowserFragment) {
        this.fragment = easypayBrowserFragment;
    }

    public void setFragmentPaused(boolean z7) {
        this.isFragmentStopped = z7;
    }

    public void setFragmentResumed(boolean z7) {
        this.isFragmentResumed = z7;
    }

    void setLastLoadedUrl(String str) {
        this.lastLoadedUrl = str;
    }

    public void setLoaderVisibility(boolean z7) {
        this.isShowNbLoader = z7;
    }

    public void setMid(String str) {
        this.mid = str;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setPaymentWebClient(WebViewClient webViewClient) {
        if (webViewClient != null) {
            this.paymentWebClient = webViewClient;
        } else {
            this.paymentWebClient = this.webClientInstance;
        }
        configureWebClient();
    }

    public void setToolbarText(AppCompatActivity appCompatActivity, String str) throws ClassCastException {
        View viewInflate = appCompatActivity.getLayoutInflater().inflate(R.layout.easy_pay_toolbar, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.easy_pay_toolbar_tv)).setText(str);
        ActionBar actionBarJ = appCompatActivity.J();
        if (actionBarJ != null) {
            actionBarJ.V(viewInflate);
            actionBarJ.m0(false);
        }
    }

    public void setTxnBank(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.bankName = str;
    }

    public void setTxnPayType(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.payType = str;
    }

    public void setmAnalyticsExtraParam(StringBuilder sb) {
        this.mAnalyticsExtraParam = sb;
    }

    public void setmAnalyticsManager(GAEventManager gAEventManager) {
        this.mAnalyticsManager = gAEventManager;
    }

    protected void setmWcListListener(ArrayList<f> arrayList) {
        this.mWcListListener = arrayList;
    }

    public void startAssist() {
        accessCheckApi();
    }

    @SuppressLint({"JavascriptInterface"})
    public boolean startConfigAssist(Context context2, Boolean bool, Boolean bool2, Integer num, WebView webView, Activity activity, String str, String str2) {
        context = context2;
        this.mActivity = (AppCompatActivity) activity;
        isEasyPayActive = bool.booleanValue();
        isEasyPayEnabled = bool2.booleanValue();
        setWebView(webView);
        setContext(context2);
        setFragmentViewId(num);
        this.orderId = str;
        this.mAnalyticsManager = new GAEventManager();
        StringBuilder sb = new StringBuilder();
        this.mAnalyticsExtraParam = sb;
        sb.append("networkInfo");
        if (getNetworkType(context) != null) {
            this.mAnalyticsExtraParam.append(getNetworkType(context));
        }
        this.mAnalyticsExtraParam.append("deviceInfo");
        StringBuilder sb2 = this.mAnalyticsExtraParam;
        String str3 = Build.MANUFACTURER;
        sb2.append(str3);
        StringBuilder sb3 = this.mAnalyticsExtraParam;
        String str4 = Build.MODEL;
        sb3.append(str4);
        StringBuilder sb4 = this.mAnalyticsExtraParam;
        String str5 = Build.DEVICE;
        sb4.append(str5);
        StringBuilder sb5 = this.mAnalyticsExtraParam;
        String str6 = Build.BRAND;
        sb5.append(str6);
        this.mAnalyticsExtraParam.append("Security patchLevel:");
        this.mAnalyticsExtraParam.append(Build.DISPLAY);
        String strFreeStorage = freeStorage();
        if (TextUtils.isEmpty(strFreeStorage)) {
            strFreeStorage = "N/A";
        }
        this.mAnalyticsExtraParam.append(strFreeStorage);
        this.mEventMap.put("deviceInfo", str3 + "|" + str4 + "|" + str5 + "|" + str6 + "|" + freeStorage());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        Map<String, Object> map = this.mEventMap;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(displayMetrics.heightPixels);
        sb6.append("|");
        sb6.append(displayMetrics.widthPixels);
        map.put(ServerProtocol.DIALOG_PARAM_DISPLAY, sb6.toString());
        double d8 = (double) displayMetrics.densityDpi;
        double d9 = ((double) displayMetrics.heightPixels) / d8;
        double d10 = ((double) displayMetrics.widthPixels) / d8;
        this.mEventMap.put("displayInInches", d9 + "|" + d10);
        this.fragmentViewId = num;
        this.mid = str2;
        this.mWcListListener = new ArrayList<>();
        setWebClientInstance(activity);
        this.webView.addJavascriptInterface(this.mActivity, "Android");
        setOrderId(this.orderId);
        setMid(this.mid);
        setEasyPayHelper();
        this.mAnalyticsManager.I(bool2.booleanValue());
        return true;
    }

    private void setWebClientInstance(Activity activity) {
        if (activity != null) {
            this.webClientInstance = new EasypayWebViewClient(activity);
        }
    }
}
