package com.haier.uhome.smart.api.DeviceGroup;

/* JADX INFO: loaded from: classes2.dex */
public enum DeviceGroupReqType {
    GROUP_MEMBER_ADD,
    GROUP_MEMBER_DEL,
    GROUP_DESTROY;

    public static DeviceGroupReqType getInstance(int i7) {
        try {
            return values()[i7];
        } catch (Exception unused) {
            return GROUP_MEMBER_ADD;
        }
    }
}
