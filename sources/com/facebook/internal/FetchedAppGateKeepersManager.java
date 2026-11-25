package com.facebook.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import c.o0;
import c.x0;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.haier.uhome.account.api.RetInfoContent;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public final class FetchedAppGateKeepersManager {
    private static final String APPLICATION_FIELDS = "fields";
    private static final long APPLICATION_GATEKEEPER_CACHE_TIMEOUT = 3600000;
    private static final String APPLICATION_GATEKEEPER_EDGE = "mobile_sdk_gk";
    private static final String APPLICATION_GATEKEEPER_FIELD = "gatekeepers";
    private static final String APPLICATION_GRAPH_DATA = "data";
    private static final String APPLICATION_PLATFORM = "platform";
    private static final String APPLICATION_SDK_VERSION = "sdk_version";
    private static final String APP_GATEKEEPERS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_GATEKEEPERS.%s";
    private static final String APP_GATEKEEPERS_PREFS_STORE = "com.facebook.internal.preferences.APP_GATEKEEPERS";
    private static final String APP_PLATFORM = "android";
    private static final String TAG = "com.facebook.internal.FetchedAppGateKeepersManager";

    @o0
    private static Long timestamp;
    private static final AtomicBoolean isLoading = new AtomicBoolean(false);
    private static final ConcurrentLinkedQueue<Callback> callbacks = new ConcurrentLinkedQueue<>();
    private static final Map<String, JSONObject> fetchedAppGateKeepers = new ConcurrentHashMap();

    public interface Callback {
        void onCompleted();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @o0
    public static JSONObject getAppGateKeepersQueryResponse(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(APPLICATION_PLATFORM, "android");
        bundle.putString(APPLICATION_SDK_VERSION, FacebookSdk.getSdkVersion());
        bundle.putString("fields", APPLICATION_GATEKEEPER_FIELD);
        GraphRequest graphRequestNewGraphPathRequest = GraphRequest.newGraphPathRequest(null, String.format("%s/%s", str, APPLICATION_GATEKEEPER_EDGE), null);
        graphRequestNewGraphPathRequest.setSkipClientToken(true);
        graphRequestNewGraphPathRequest.setParameters(bundle);
        return graphRequestNewGraphPathRequest.executeAndWait().getJSONObject();
    }

    public static boolean getGateKeeperForKey(String str, String str2, boolean z7) {
        loadAppGateKeepersAsync();
        if (str2 != null) {
            Map<String, JSONObject> map = fetchedAppGateKeepers;
            if (map.containsKey(str2)) {
                return map.get(str2).optBoolean(str, z7);
            }
        }
        return z7;
    }

    private static boolean isTimestampValid(@o0 Long l7) {
        return l7 != null && System.currentTimeMillis() - l7.longValue() < 3600000;
    }

    static void loadAppGateKeepersAsync() {
        loadAppGateKeepersAsync(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized JSONObject parseAppGateKeepersFromJSON(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        Map<String, JSONObject> map = fetchedAppGateKeepers;
        jSONObject2 = map.containsKey(str) ? map.get(str) : new JSONObject();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("data");
        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray != null ? jSONArrayOptJSONArray.optJSONObject(0) : null;
        if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optJSONArray(APPLICATION_GATEKEEPER_FIELD) != null) {
            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(APPLICATION_GATEKEEPER_FIELD);
            for (int i7 = 0; i7 < jSONArrayOptJSONArray2.length(); i7++) {
                try {
                    JSONObject jSONObject3 = jSONArrayOptJSONArray2.getJSONObject(i7);
                    jSONObject2.put(jSONObject3.getString(RetInfoContent.BindKEY_ISNULL), jSONObject3.getBoolean("value"));
                } catch (JSONException e8) {
                    Utility.logd("FacebookSDK", e8);
                }
            }
        }
        fetchedAppGateKeepers.put(str, jSONObject2);
        return jSONObject2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void pollCallbacks() {
        Handler handler = new Handler(Looper.getMainLooper());
        while (true) {
            ConcurrentLinkedQueue<Callback> concurrentLinkedQueue = callbacks;
            if (concurrentLinkedQueue.isEmpty()) {
                return;
            }
            final Callback callbackPoll = concurrentLinkedQueue.poll();
            if (callbackPoll != null) {
                handler.post(new Runnable() { // from class: com.facebook.internal.FetchedAppGateKeepersManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        callbackPoll.onCompleted();
                    }
                });
            }
        }
    }

    @o0
    static JSONObject queryAppGateKeepers(String str, boolean z7) {
        if (!z7) {
            Map<String, JSONObject> map = fetchedAppGateKeepers;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        JSONObject appGateKeepersQueryResponse = getAppGateKeepersQueryResponse(str);
        if (appGateKeepersQueryResponse == null) {
            return null;
        }
        FacebookSdk.getApplicationContext().getSharedPreferences(APP_GATEKEEPERS_PREFS_STORE, 0).edit().putString(String.format(APP_GATEKEEPERS_PREFS_KEY_FORMAT, str), appGateKeepersQueryResponse.toString()).apply();
        return parseAppGateKeepersFromJSON(str, appGateKeepersQueryResponse);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0017 A[Catch: all -> 0x006e, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:5:0x0005, B:6:0x000a, B:8:0x0012, B:11:0x0017, B:15:0x002f, B:17:0x0040, B:22:0x004f, B:23:0x0052, B:27:0x005a, B:31:0x0064, B:20:0x0048), top: B:39:0x0005, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:13:0x002d A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:15:0x002f A[Catch: all -> 0x006e, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:5:0x0005, B:6:0x000a, B:8:0x0012, B:11:0x0017, B:15:0x002f, B:17:0x0040, B:22:0x004f, B:23:0x0052, B:27:0x005a, B:31:0x0064, B:20:0x0048), top: B:39:0x0005, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x004f A[Catch: all -> 0x006e, TryCatch #1 {, blocks: (B:5:0x0005, B:6:0x000a, B:8:0x0012, B:11:0x0017, B:15:0x002f, B:17:0x0040, B:22:0x004f, B:23:0x0052, B:27:0x005a, B:31:0x0064, B:20:0x0048), top: B:39:0x0005, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0058 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:27:0x005a A[Catch: all -> 0x006e, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:5:0x0005, B:6:0x000a, B:8:0x0012, B:11:0x0017, B:15:0x002f, B:17:0x0040, B:22:0x004f, B:23:0x0052, B:27:0x005a, B:31:0x0064, B:20:0x0048), top: B:39:0x0005, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0062 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:31:0x0064 A[Catch: all -> 0x006e, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:5:0x0005, B:6:0x000a, B:8:0x0012, B:11:0x0017, B:15:0x002f, B:17:0x0040, B:22:0x004f, B:23:0x0052, B:27:0x005a, B:31:0x0064, B:20:0x0048), top: B:39:0x0005, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:8:0x0012 A[Catch: all -> 0x006e, TRY_LEAVE, TryCatch #1 {, blocks: (B:5:0x0005, B:6:0x000a, B:8:0x0012, B:11:0x0017, B:15:0x002f, B:17:0x0040, B:22:0x004f, B:23:0x0052, B:27:0x005a, B:31:0x0064, B:20:0x0048), top: B:39:0x0005, inners: #0 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:13:0x002d, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:25:0x0058, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:29:0x0062, please report this as an issue */
    static synchronized void loadAppGateKeepersAsync(@o0 Callback callback) {
        final Context applicationContext;
        final String applicationId;
        final String str;
        JSONObject jSONObject;
        String string;
        Executor executor;
        if (callback == null) {
            if (isTimestampValid(timestamp)) {
                pollCallbacks();
                return;
            }
            applicationContext = FacebookSdk.getApplicationContext();
            applicationId = FacebookSdk.getApplicationId();
            str = String.format(APP_GATEKEEPERS_PREFS_KEY_FORMAT, applicationId);
            if (applicationContext == null) {
                return;
            }
            jSONObject = null;
            string = applicationContext.getSharedPreferences(APP_GATEKEEPERS_PREFS_STORE, 0).getString(str, null);
            if (!Utility.isNullOrEmpty(string)) {
                jSONObject = new JSONObject(string);
                if (jSONObject != null) {
                    parseAppGateKeepersFromJSON(applicationId, jSONObject);
                }
            }
            executor = FacebookSdk.getExecutor();
            if (executor == null) {
                return;
            }
            if (isLoading.compareAndSet(false, true)) {
                executor.execute(new Runnable() { // from class: com.facebook.internal.FetchedAppGateKeepersManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        JSONObject appGateKeepersQueryResponse = FetchedAppGateKeepersManager.getAppGateKeepersQueryResponse(applicationId);
                        if (appGateKeepersQueryResponse != null) {
                            FetchedAppGateKeepersManager.parseAppGateKeepersFromJSON(applicationId, appGateKeepersQueryResponse);
                            applicationContext.getSharedPreferences(FetchedAppGateKeepersManager.APP_GATEKEEPERS_PREFS_STORE, 0).edit().putString(str, appGateKeepersQueryResponse.toString()).apply();
                            Long unused = FetchedAppGateKeepersManager.timestamp = Long.valueOf(System.currentTimeMillis());
                        }
                        FetchedAppGateKeepersManager.pollCallbacks();
                        FetchedAppGateKeepersManager.isLoading.set(false);
                    }
                });
                return;
            }
            return;
        }
        callbacks.add(callback);
        if (isTimestampValid(timestamp)) {
            pollCallbacks();
            return;
        }
        applicationContext = FacebookSdk.getApplicationContext();
        applicationId = FacebookSdk.getApplicationId();
        str = String.format(APP_GATEKEEPERS_PREFS_KEY_FORMAT, applicationId);
        if (applicationContext == null) {
            return;
        }
        jSONObject = null;
        string = applicationContext.getSharedPreferences(APP_GATEKEEPERS_PREFS_STORE, 0).getString(str, null);
        if (!Utility.isNullOrEmpty(string)) {
            try {
                jSONObject = new JSONObject(string);
            } catch (JSONException e8) {
                Utility.logd("FacebookSDK", e8);
            }
            if (jSONObject != null) {
                parseAppGateKeepersFromJSON(applicationId, jSONObject);
            }
        }
        executor = FacebookSdk.getExecutor();
        if (executor == null) {
            return;
        }
        if (isLoading.compareAndSet(false, true)) {
            return;
        }
        executor.execute(new Runnable() { // from class: com.facebook.internal.FetchedAppGateKeepersManager.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject appGateKeepersQueryResponse = FetchedAppGateKeepersManager.getAppGateKeepersQueryResponse(applicationId);
                if (appGateKeepersQueryResponse != null) {
                    FetchedAppGateKeepersManager.parseAppGateKeepersFromJSON(applicationId, appGateKeepersQueryResponse);
                    applicationContext.getSharedPreferences(FetchedAppGateKeepersManager.APP_GATEKEEPERS_PREFS_STORE, 0).edit().putString(str, appGateKeepersQueryResponse.toString()).apply();
                    Long unused = FetchedAppGateKeepersManager.timestamp = Long.valueOf(System.currentTimeMillis());
                }
                FetchedAppGateKeepersManager.pollCallbacks();
                FetchedAppGateKeepersManager.isLoading.set(false);
            }
        });
        return;
        throw th;
    }
}
