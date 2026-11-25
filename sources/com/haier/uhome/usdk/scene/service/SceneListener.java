package com.haier.uhome.usdk.scene.service;

import com.haier.uhome.usdk.scene.json.up.DeviceAttrReq;
import com.haier.uhome.usdk.scene.json.up.SceneExecuteReq;
import com.haier.uhome.usdk.scene.json.up.SceneSubscribeReq;
import com.haier.uhome.usdk.scene.json.up.SceneUnsubscribeReq;

/* JADX INFO: loaded from: classes2.dex */
public interface SceneListener {
    void onAttrReq(DeviceAttrReq deviceAttrReq);

    void onSceneExecuteReq(SceneExecuteReq sceneExecuteReq);

    void onSceneSubscribeReq(SceneSubscribeReq sceneSubscribeReq);

    void onSceneUnsubscribeReq(SceneUnsubscribeReq sceneUnsubscribeReq);
}
