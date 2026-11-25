package com.facebook.appevents.suggestedevents;

import android.app.Activity;
import c.x0;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public final class SuggestedEventsManager {
    private static final String ELIGIBLE_EVENTS_KEY = "eligible_for_prediction_events";
    private static final String PRODUCTION_EVENTS_KEY = "production_events";
    private static final AtomicBoolean enabled = new AtomicBoolean(false);
    private static final Set<String> productionEvents = new HashSet();
    private static final Set<String> eligibleEvents = new HashSet();

    public static synchronized void enable() {
        AtomicBoolean atomicBoolean = enabled;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        initialize();
    }

    private static void initialize() {
        String suggestedEventsSetting;
        File ruleFile;
        try {
            FetchedAppSettings fetchedAppSettingsQueryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (fetchedAppSettingsQueryAppSettings == null || (suggestedEventsSetting = fetchedAppSettingsQueryAppSettings.getSuggestedEventsSetting()) == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject(suggestedEventsSetting);
            if (jSONObject.has(PRODUCTION_EVENTS_KEY)) {
                JSONArray jSONArray = jSONObject.getJSONArray(PRODUCTION_EVENTS_KEY);
                for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                    productionEvents.add(jSONArray.getString(i7));
                }
            }
            if (jSONObject.has(ELIGIBLE_EVENTS_KEY)) {
                JSONArray jSONArray2 = jSONObject.getJSONArray(ELIGIBLE_EVENTS_KEY);
                for (int i8 = 0; i8 < jSONArray2.length(); i8++) {
                    eligibleEvents.add(jSONArray2.getString(i8));
                }
            }
            if ((productionEvents.isEmpty() && eligibleEvents.isEmpty()) || (ruleFile = ModelManager.getRuleFile(ModelManager.MODEL_SUGGESTED_EVENTS)) == null) {
                return;
            }
            FeatureExtractor.initialize(ruleFile);
            Activity currentActivity = ActivityLifecycleTracker.getCurrentActivity();
            if (currentActivity != null) {
                trackActivity(currentActivity);
            }
        } catch (Exception unused) {
        }
    }

    static boolean isEligibleEvents(String str) {
        return eligibleEvents.contains(str);
    }

    public static boolean isEnabled() {
        return enabled.get();
    }

    static boolean isProductionEvents(String str) {
        return productionEvents.contains(str);
    }

    public static void trackActivity(Activity activity) {
        try {
            if (enabled.get() && FeatureExtractor.isInitialized() && (!productionEvents.isEmpty() || !eligibleEvents.isEmpty())) {
                ViewObserver.startTrackingActivity(activity);
            } else {
                ViewObserver.stopTrackingActivity(activity);
            }
        } catch (Exception unused) {
        }
    }
}
