package com.facebook.internal.instrument;

import c.x0;
import com.facebook.FacebookSdk;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.crashreport.CrashHandler;
import com.facebook.internal.instrument.errorreport.ErrorReportHandler;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class InstrumentManager {
    public static void start() {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            FeatureManager.checkFeature(FeatureManager.Feature.CrashReport, new FeatureManager.Callback() { // from class: com.facebook.internal.instrument.InstrumentManager.1
                @Override // com.facebook.internal.FeatureManager.Callback
                public void onCompleted(boolean z7) {
                    if (z7) {
                        CrashHandler.enable();
                    }
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.ErrorReport, new FeatureManager.Callback() { // from class: com.facebook.internal.instrument.InstrumentManager.2
                @Override // com.facebook.internal.FeatureManager.Callback
                public void onCompleted(boolean z7) {
                    if (z7) {
                        ErrorReportHandler.enable();
                    }
                }
            });
        }
    }
}
