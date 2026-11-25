package com.haier.uhome.usdk.scanner;

/* JADX INFO: loaded from: classes2.dex */
public interface IDeviceScannerListener {
    void onDeviceAdd(ConfigurableDevice configurableDevice);

    void onDeviceRemove(ConfigurableDevice configurableDevice);

    void onDeviceUpdate(ConfigurableDevice configurableDevice);
}
