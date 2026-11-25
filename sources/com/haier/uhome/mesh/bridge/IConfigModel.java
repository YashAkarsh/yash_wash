package com.haier.uhome.mesh.bridge;

import com.haier.uhome.mesh.api.model.MeshDeviceNode;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.s;

/* JADX INFO: loaded from: classes2.dex */
public interface IConfigModel {
    void addModelToGroup(int i7, int i8, int i9, int i10, s sVar);

    void bindAppKeyToModel(int i7, int i8, int i9, int i10, s sVar);

    void inviteByOOB(String str, int i7, byte[] bArr, int i8, ICallback<MeshDeviceNode> iCallback);

    boolean isNodeIdentifyAdvAddress(int i7, byte[] bArr, byte[] bArr2);

    void rmModelFromGroup(int i7, int i8, int i9, int i10, s sVar);

    void setAppKey(int i7, int i8, int i9, s sVar);

    void setCallback(IConfigCallback iConfigCallback);

    void setCfgNodeIdentity(int i7, int i8, s sVar);

    void setProxyFilterType(int i7, s sVar);

    void unBindAppKeyFromModel(int i7, int i8, int i9, int i10, s sVar);

    void unsetDevice(int i7, s sVar);
}
