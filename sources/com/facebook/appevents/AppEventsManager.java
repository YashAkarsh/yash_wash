package com.facebook.appevents;

import c.x0;
import com.facebook.FacebookSdk;
import com.facebook.appevents.aam.MetadataIndexer;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager;
import com.facebook.internal.FeatureManager;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class AppEventsManager {
    public static void start() {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            FeatureManager.checkFeature(FeatureManager.Feature.AAM, new FeatureManager.Callback() { // from class: com.facebook.appevents.AppEventsManager.1
                @Override // com.facebook.internal.FeatureManager.Callback
                public void onCompleted(boolean z7) {
                    if (z7) {
                        MetadataIndexer.enable();
                    }
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.RestrictiveDataFiltering, new FeatureManager.Callback() { // from class: com.facebook.appevents.AppEventsManager.2
                @Override // com.facebook.internal.FeatureManager.Callback
                public void onCompleted(boolean z7) {
                    if (z7) {
                        RestrictiveDataManager.enable();
                    }
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.PrivacyProtection, new FeatureManager.Callback() { // from class: com.facebook.appevents.AppEventsManager.3
                @Override // com.facebook.internal.FeatureManager.Callback
                public void onCompleted(boolean z7) {
                    if (z7) {
                        ModelManager.enable();
                    }
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.EventDeactivation, new FeatureManager.Callback() { // from class: com.facebook.appevents.AppEventsManager.4
                @Override // com.facebook.internal.FeatureManager.Callback
                public void onCompleted(boolean z7) {
                    if (z7) {
                        EventDeactivationManager.enable();
                    }
                }
            });
        }
    }
}
