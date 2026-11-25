package com.haier.uhome.usdk.api.interfaces;

import com.haier.uhome.usdk.api.ConfigurableDevice;

/* JADX INFO: loaded from: classes2.dex */
public interface IDeviceScanListener {
    void onDeviceRemoved(ConfigurableDevice configurableDevice);

    void onDeviceScanned(ConfigurableDevice configurableDevice);
}
