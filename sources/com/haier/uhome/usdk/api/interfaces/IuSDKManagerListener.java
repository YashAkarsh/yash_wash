package com.haier.uhome.usdk.api.interfaces;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public interface IuSDKManagerListener extends Serializable {
    void onBusinessMessage(String str);

    void onSessionException(String str);
}
