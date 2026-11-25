package com.haier.uhome.usdk.api;

/* JADX INFO: loaded from: classes2.dex */
public enum uSDKCloudConnectionState {
    CLOUD_CONNECTION_STATE_UNCONNECTED(com.haier.uhome.control.cloud.api.b.UNCONNECTED),
    CLOUD_CONNECTION_STATE_CONNECTING(com.haier.uhome.control.cloud.api.b.CONNECTING),
    CLOUD_CONNECTION_STATE_CONNECTED(com.haier.uhome.control.cloud.api.b.CONNECTED),
    CLOUD_CONNECTION_STATE_CONNECT_FAILED(com.haier.uhome.control.cloud.api.b.CONNECT_FAILED);

    private static final String PREFIX = "CLOUD_CONNECTION_STATE_";
    private com.haier.uhome.control.cloud.api.b cloudConnectionState;

    uSDKCloudConnectionState(com.haier.uhome.control.cloud.api.b bVar) {
        this.cloudConnectionState = bVar;
    }

    public static uSDKCloudConnectionState getInstance(String str) {
        try {
            return valueOf(PREFIX + str);
        } catch (Exception unused) {
            return CLOUD_CONNECTION_STATE_UNCONNECTED;
        }
    }

    public String getDescription() {
        return this.cloudConnectionState.a();
    }
}
