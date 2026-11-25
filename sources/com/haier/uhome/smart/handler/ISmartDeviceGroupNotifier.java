package com.haier.uhome.smart.handler;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface ISmartDeviceGroupNotifier {
    void notifyDeviceGroupControl(int i7, int i8, String str, String str2);

    void notifyGroupMember(String str, int i7, List<String> list);
}
