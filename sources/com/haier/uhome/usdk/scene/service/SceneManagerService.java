package com.haier.uhome.usdk.scene.service;

import com.haier.uhome.usdk.scene.json.LocalScenesProtocol;
import com.haier.uhome.usdk.scene.json.down.BaseDown;
import com.haier.uhome.usdk.scene.json.down.DeviceAttrResp;
import com.haier.uhome.usdk.scene.json.down.DeviceAttrsReport;
import com.haier.uhome.usdk.scene.json.down.SceneExecuteResp;
import com.haier.uhome.usdk.scene.json.down.SceneSubscribeResp;
import com.haier.uhome.usdk.scene.json.down.SceneUnsubscribeResp;
import com.haier.uhome.usdk.scene.json.up.BaseUp;
import com.haier.uhome.usdk.scene.json.up.DeviceAttrReq;
import com.haier.uhome.usdk.scene.json.up.SceneExecuteReq;
import com.haier.uhome.usdk.scene.json.up.SceneSubscribeReq;
import com.haier.uhome.usdk.scene.json.up.SceneUnsubscribeReq;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public class SceneManagerService {
    private final SceneNativeService mSceneNativeService;
    private SceneListener mScenesListener;

    private static class SingletonFactory {
        private static SceneManagerService sInstance = new SceneManagerService();

        private SingletonFactory() {
        }
    }

    private int dataDown(BaseDown baseDown) {
        return this.mSceneNativeService.userDataDown(baseDown.buildJson());
    }

    public static SceneManagerService getInstance() {
        return SingletonFactory.sInstance;
    }

    private void sendDeviceAttrReq(BaseUp baseUp) {
        DeviceAttrReq deviceAttrReq = (DeviceAttrReq) baseUp;
        SceneListener sceneListener = this.mScenesListener;
        if (sceneListener != null) {
            sceneListener.onAttrReq(deviceAttrReq);
        }
    }

    private void sendSceneExecuteReq(BaseUp baseUp) {
        SceneExecuteReq sceneExecuteReq = (SceneExecuteReq) baseUp;
        SceneListener sceneListener = this.mScenesListener;
        if (sceneListener != null) {
            sceneListener.onSceneExecuteReq(sceneExecuteReq);
        }
    }

    private void sendSubscribeReq(BaseUp baseUp) {
        SceneSubscribeReq sceneSubscribeReq = (SceneSubscribeReq) baseUp;
        SceneListener sceneListener = this.mScenesListener;
        if (sceneListener != null) {
            sceneListener.onSceneSubscribeReq(sceneSubscribeReq);
        }
    }

    private void sendUnsubscribeReq(BaseUp baseUp) {
        SceneUnsubscribeReq sceneUnsubscribeReq = (SceneUnsubscribeReq) baseUp;
        SceneListener sceneListener = this.mScenesListener;
        if (sceneListener != null) {
            sceneListener.onSceneUnsubscribeReq(sceneUnsubscribeReq);
        }
    }

    public void process(String str) {
        try {
            BaseUp baseUp = LocalScenesProtocol.getBaseUp(str);
            if (baseUp instanceof DeviceAttrReq) {
                sendDeviceAttrReq(baseUp);
            } else if (baseUp instanceof SceneExecuteReq) {
                sendSceneExecuteReq(baseUp);
            } else if (baseUp instanceof SceneSubscribeReq) {
                sendSubscribeReq(baseUp);
            } else if (baseUp instanceof SceneUnsubscribeReq) {
                sendUnsubscribeReq(baseUp);
            }
        } catch (JSONException e8) {
            e3.a.v("process error with %s", e8.getMessage());
        }
    }

    public void reportDeviceAttrs(DeviceAttrsReport deviceAttrsReport) {
        dataDown(deviceAttrsReport);
    }

    public void sendDeviceAttrResp(DeviceAttrResp deviceAttrResp) {
        dataDown(deviceAttrResp);
    }

    public void sendSceneExecuteResp(SceneExecuteResp sceneExecuteResp) {
        dataDown(sceneExecuteResp);
    }

    public void sendSceneSubscribeResp(SceneSubscribeResp sceneSubscribeResp) {
        e3.a.e("sendSceneSubscribeResp: sceneSubscribeResp = %s", sceneSubscribeResp.toString());
        dataDown(sceneSubscribeResp);
    }

    public void sendSceneUnsubscribeResp(SceneUnsubscribeResp sceneUnsubscribeResp) {
        dataDown(sceneUnsubscribeResp);
    }

    public void setScenesListener(SceneListener sceneListener) {
        this.mScenesListener = sceneListener;
    }

    private SceneManagerService() {
        this.mSceneNativeService = SceneNativeService.getInstance();
    }
}
