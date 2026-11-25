package com.realsil.sdk.core.base;

import android.app.NotificationManager;
import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DaemonService extends BaseService {
    @Override // com.realsil.sdk.core.base.BaseService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.cancel(this.notificationId);
        }
    }

    @Override // com.realsil.sdk.core.base.BaseService, android.app.Service
    public int onStartCommand(Intent intent, int i7, int i8) {
        return 1;
    }
}
