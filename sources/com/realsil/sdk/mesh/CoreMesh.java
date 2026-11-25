package com.realsil.sdk.mesh;

import java.util.List;
import r4.a;

/* JADX INFO: loaded from: classes2.dex */
public class CoreMesh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte f33244a = 2;

    static {
        System.loadLibrary("coreMesh");
    }

    public static native void AppKeyAdd(short s7, short s8, short s9, byte[] bArr);

    @Deprecated
    public static native void CfgClientSetNetKeyIndex(short s7);

    public static native byte CfgModelSubAdd(short s7, short s8, boolean z7, short s9, int i7);

    public static native byte CfgModelSubDelete(short s7, short s8, boolean z7, short s9, int i7);

    public static native void CompoDataGet(short s7, byte b8);

    public static native byte[] MeshK3(byte[] bArr);

    public static native boolean MeshModelRegister(short s7, int i7);

    public static native boolean MeshModelSub(short s7, int i7, short s8);

    public static native void MeshStackInit(short s7, byte[] bArr, byte[] bArr2, List<a> list, long j7, long j8);

    public static native void ModelAppBind(short s7, short s8, short s9, int i7);

    public static native byte ModelAppUnbind(short s7, short s8, short s9, int i7);

    public static native byte NodeReset(short s7);

    public static native void OsTimerCallback(long j7, int i7);

    public static native boolean ProvInvite(byte b8, byte[] bArr, int i7);

    public static native boolean ProxyCfgAddRemoveAddr(short s7, boolean z7, short[] sArr, short s8);

    public static native boolean ProxyReceive(byte b8, byte[] bArr, short s7);

    public static native void UnprovisioningCmd();

    public static native void addDevKey(List<a> list);

    public static native byte generic_on_off_get(short s7, short s8);

    public static native byte generic_on_off_set(short s7, short s8, boolean z7, byte b8, boolean z8);

    public static native byte[] identityHashGen(byte[] bArr, byte[] bArr2, short s7);

    public static native byte[] identityKeyGen(byte[] bArr);

    public static native byte light_cwrgb_get(short s7, short s8);

    public static native byte light_cwrgb_set(Object obj, short s7, short s8, byte[] bArr, boolean z7);

    public static native void meshChangeNetwork(short s7, byte[] bArr, byte[] bArr2, long j7, long j8);

    public static native void meshStartQueueAndCustomer();

    public static native void noticeMeshProtocalConnected(byte b8);

    public static native void noticeMeshProtocalDisConnected(byte b8);

    public static native boolean proxyCfgSetFilterType(int i7, int i8);

    public static native byte proxyFilterAddAddr(int i7, short s7);

    public static native byte proxyFilterRemoveAddr(int i7, short s7);

    public static native byte sendModelData(int i7, short s7, byte[] bArr, int i8, int i9);

    public static native void setCfgNodeIdentity(short s7, short s8, byte b8);

    public static native void setMeshJniLog(boolean z7, String str);

    public static native void setTtlValue(short s7);
}
