package com.facebook.internal;

import android.net.Uri;
import c.o0;
import java.util.EnumSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class FetchedAppSettings {
    private boolean IAPAutomaticLoggingEnabled;
    private boolean automaticLoggingEnabled;
    private boolean codelessEventsEnabled;
    private Map<String, Map<String, DialogFeatureConfig>> dialogConfigMap;
    private FacebookRequestErrorClassification errorClassification;
    private JSONArray eventBindings;
    private String nuxContent;
    private boolean nuxEnabled;

    @o0
    private String rawAamRules;

    @o0
    private String restrictiveDataSetting;
    private String sdkUpdateMessage;
    private int sessionTimeoutInSeconds;
    private String smartLoginBookmarkIconURL;
    private String smartLoginMenuIconURL;
    private EnumSet<SmartLoginOption> smartLoginOptions;

    @o0
    private String suggestedEventsSetting;
    private boolean supportsImplicitLogging;
    private boolean trackUninstallEnabled;

    public static class DialogFeatureConfig {
        private static final String DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR = "\\|";
        private static final String DIALOG_CONFIG_NAME_KEY = "name";
        private static final String DIALOG_CONFIG_URL_KEY = "url";
        private static final String DIALOG_CONFIG_VERSIONS_KEY = "versions";
        private String dialogName;
        private Uri fallbackUrl;
        private String featureName;
        private int[] featureVersionSpec;

        private DialogFeatureConfig(String str, String str2, Uri uri, int[] iArr) {
            this.dialogName = str;
            this.featureName = str2;
            this.fallbackUrl = uri;
            this.featureVersionSpec = iArr;
        }

        public static DialogFeatureConfig parseDialogConfig(JSONObject jSONObject) {
            String strOptString = jSONObject.optString("name");
            if (Utility.isNullOrEmpty(strOptString)) {
                return null;
            }
            String[] strArrSplit = strOptString.split(DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR);
            if (strArrSplit.length != 2) {
                return null;
            }
            String str = strArrSplit[0];
            String str2 = strArrSplit[1];
            if (Utility.isNullOrEmpty(str) || Utility.isNullOrEmpty(str2)) {
                return null;
            }
            String strOptString2 = jSONObject.optString("url");
            return new DialogFeatureConfig(str, str2, Utility.isNullOrEmpty(strOptString2) ? null : Uri.parse(strOptString2), parseVersionSpec(jSONObject.optJSONArray(DIALOG_CONFIG_VERSIONS_KEY)));
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0028  */
        private static int[] parseVersionSpec(JSONArray jSONArray) {
            if (jSONArray == null) {
                return null;
            }
            int length = jSONArray.length();
            int[] iArr = new int[length];
            for (int i7 = 0; i7 < length; i7++) {
                int i8 = -1;
                int iOptInt = jSONArray.optInt(i7, -1);
                if (iOptInt == -1) {
                    String strOptString = jSONArray.optString(i7);
                    if (Utility.isNullOrEmpty(strOptString)) {
                        i8 = iOptInt;
                    } else {
                        try {
                            i8 = Integer.parseInt(strOptString);
                        } catch (NumberFormatException e8) {
                            Utility.logd("FacebookSDK", e8);
                        }
                    }
                } else {
                    i8 = iOptInt;
                }
                iArr[i7] = i8;
            }
            return iArr;
        }

        public String getDialogName() {
            return this.dialogName;
        }

        public Uri getFallbackUrl() {
            return this.fallbackUrl;
        }

        public String getFeatureName() {
            return this.featureName;
        }

        public int[] getVersionSpec() {
            return this.featureVersionSpec;
        }
    }

    public FetchedAppSettings(boolean z7, String str, boolean z8, int i7, EnumSet<SmartLoginOption> enumSet, Map<String, Map<String, DialogFeatureConfig>> map, boolean z9, FacebookRequestErrorClassification facebookRequestErrorClassification, String str2, String str3, boolean z10, boolean z11, JSONArray jSONArray, String str4, boolean z12, @o0 String str5, @o0 String str6, @o0 String str7) {
        this.supportsImplicitLogging = z7;
        this.nuxContent = str;
        this.nuxEnabled = z8;
        this.dialogConfigMap = map;
        this.errorClassification = facebookRequestErrorClassification;
        this.sessionTimeoutInSeconds = i7;
        this.automaticLoggingEnabled = z9;
        this.smartLoginOptions = enumSet;
        this.smartLoginBookmarkIconURL = str2;
        this.smartLoginMenuIconURL = str3;
        this.IAPAutomaticLoggingEnabled = z10;
        this.codelessEventsEnabled = z11;
        this.eventBindings = jSONArray;
        this.sdkUpdateMessage = str4;
        this.trackUninstallEnabled = z12;
        this.rawAamRules = str5;
        this.suggestedEventsSetting = str6;
        this.restrictiveDataSetting = str7;
    }

    public static DialogFeatureConfig getDialogFeatureConfig(String str, String str2, String str3) {
        FetchedAppSettings appSettingsWithoutQuery;
        Map<String, DialogFeatureConfig> map;
        if (Utility.isNullOrEmpty(str2) || Utility.isNullOrEmpty(str3) || (appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(str)) == null || (map = appSettingsWithoutQuery.getDialogConfigurations().get(str2)) == null) {
            return null;
        }
        return map.get(str3);
    }

    public boolean getAutomaticLoggingEnabled() {
        return this.automaticLoggingEnabled;
    }

    public boolean getCodelessEventsEnabled() {
        return this.codelessEventsEnabled;
    }

    public Map<String, Map<String, DialogFeatureConfig>> getDialogConfigurations() {
        return this.dialogConfigMap;
    }

    public FacebookRequestErrorClassification getErrorClassification() {
        return this.errorClassification;
    }

    public JSONArray getEventBindings() {
        return this.eventBindings;
    }

    public boolean getIAPAutomaticLoggingEnabled() {
        return this.IAPAutomaticLoggingEnabled;
    }

    public String getNuxContent() {
        return this.nuxContent;
    }

    public boolean getNuxEnabled() {
        return this.nuxEnabled;
    }

    @o0
    public String getRawAamRules() {
        return this.rawAamRules;
    }

    @o0
    public String getRestrictiveDataSetting() {
        return this.restrictiveDataSetting;
    }

    public String getSdkUpdateMessage() {
        return this.sdkUpdateMessage;
    }

    public int getSessionTimeoutInSeconds() {
        return this.sessionTimeoutInSeconds;
    }

    public String getSmartLoginBookmarkIconURL() {
        return this.smartLoginBookmarkIconURL;
    }

    public String getSmartLoginMenuIconURL() {
        return this.smartLoginMenuIconURL;
    }

    public EnumSet<SmartLoginOption> getSmartLoginOptions() {
        return this.smartLoginOptions;
    }

    @o0
    public String getSuggestedEventsSetting() {
        return this.suggestedEventsSetting;
    }

    public boolean getTrackUninstallEnabled() {
        return this.trackUninstallEnabled;
    }

    public boolean supportsImplicitLogging() {
        return this.supportsImplicitLogging;
    }
}
