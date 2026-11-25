package com.facebook.internal;

import com.facebook.FacebookSdk;

/* JADX INFO: loaded from: classes.dex */
public class InstallReferrerUtil {
    private static final String IS_REFERRER_UPDATED = "is_referrer_updated";

    public interface Callback {
        void onReceiveReferrerUrl(String str);
    }

    private InstallReferrerUtil() {
    }

    private static boolean isUpdated() {
        return FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.APP_EVENT_PREFERENCES, 0).getBoolean(IS_REFERRER_UPDATED, false);
    }

    private static void tryConnectReferrerInfo(final Callback callback) {
        final com.android.installreferrer.api.a aVarA = com.android.installreferrer.api.a.d(FacebookSdk.getApplicationContext()).a();
        aVarA.e(new com.android.installreferrer.api.c() { // from class: com.facebook.internal.InstallReferrerUtil.1
            @Override // com.android.installreferrer.api.c
            public void onInstallReferrerServiceDisconnected() {
            }

            @Override // com.android.installreferrer.api.c
            public void onInstallReferrerSetupFinished(int i7) {
                if (i7 != 0) {
                    if (i7 != 2) {
                        return;
                    }
                    InstallReferrerUtil.updateReferrer();
                    return;
                }
                try {
                    String strB = aVarA.b().b();
                    if (strB != null && (strB.contains("fb") || strB.contains("facebook"))) {
                        callback.onReceiveReferrerUrl(strB);
                    }
                    InstallReferrerUtil.updateReferrer();
                } catch (Exception unused) {
                }
            }
        });
    }

    public static void tryUpdateReferrerInfo(Callback callback) {
        if (isUpdated()) {
            return;
        }
        tryConnectReferrerInfo(callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateReferrer() {
        FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.APP_EVENT_PREFERENCES, 0).edit().putBoolean(IS_REFERRER_UPDATED, true).apply();
    }
}
