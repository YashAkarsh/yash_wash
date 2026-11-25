package com.haier.uhome.usdk.scene.service;

import com.haier.library.common.thread.m;
import com.haier.uhome.usdk.scene.json.down.DeviceAttrResp;
import com.haier.uhome.usdk.scene.json.down.DeviceAttrsReport;
import com.haier.uhome.usdk.scene.json.down.SceneExecuteResp;
import com.haier.uhome.usdk.scene.json.down.SceneSubscribeResp;
import com.haier.uhome.usdk.scene.json.down.SceneUnsubscribeResp;

/* JADX INFO: loaded from: classes2.dex */
public class SceneManager {

    private static class SingletonFactory {
        private static SceneManager sInstance = new SceneManager();

        private SingletonFactory() {
        }
    }

    public static SceneManager getInstance() {
        return SingletonFactory.sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$reportDeviceAttrs$0(DeviceAttrsReport deviceAttrsReport) {
        SceneManagerService.getInstance().reportDeviceAttrs(deviceAttrsReport);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendDeviceAttrResp$1(DeviceAttrResp deviceAttrResp) {
        SceneManagerService.getInstance().sendDeviceAttrResp(deviceAttrResp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendSceneExecuteResp$2(SceneExecuteResp sceneExecuteResp) {
        SceneManagerService.getInstance().sendSceneExecuteResp(sceneExecuteResp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendSceneSubscribeResp$3(SceneSubscribeResp sceneSubscribeResp) {
        SceneManagerService.getInstance().sendSceneSubscribeResp(sceneSubscribeResp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendSceneUnsubscribeResp$4(SceneUnsubscribeResp sceneUnsubscribeResp) {
        SceneManagerService.getInstance().sendSceneUnsubscribeResp(sceneUnsubscribeResp);
    }

    public void reportDeviceAttrs(final DeviceAttrsReport deviceAttrsReport) {
        m.execute(new Runnable() { // from class: com.haier.uhome.usdk.scene.service.b
            @Override // java.lang.Runnable
            public final void run() {
                SceneManager.lambda$reportDeviceAttrs$0(deviceAttrsReport);
            }
        });
    }

    public void sendDeviceAttrResp(final DeviceAttrResp deviceAttrResp) {
        m.execute(new Runnable() { // from class: com.haier.uhome.usdk.scene.service.d
            @Override // java.lang.Runnable
            public final void run() {
                SceneManager.lambda$sendDeviceAttrResp$1(deviceAttrResp);
            }
        });
    }

    public void sendSceneExecuteResp(final SceneExecuteResp sceneExecuteResp) {
        m.execute(new Runnable() { // from class: com.haier.uhome.usdk.scene.service.c
            @Override // java.lang.Runnable
            public final void run() {
                SceneManager.lambda$sendSceneExecuteResp$2(sceneExecuteResp);
            }
        });
    }

    public void sendSceneSubscribeResp(final SceneSubscribeResp sceneSubscribeResp) {
        m.execute(new Runnable() { // from class: com.haier.uhome.usdk.scene.service.a
            @Override // java.lang.Runnable
            public final void run() {
                SceneManager.lambda$sendSceneSubscribeResp$3(sceneSubscribeResp);
            }
        });
    }

    public void sendSceneUnsubscribeResp(final SceneUnsubscribeResp sceneUnsubscribeResp) {
        m.execute(new Runnable() { // from class: com.haier.uhome.usdk.scene.service.e
            @Override // java.lang.Runnable
            public final void run() {
                SceneManager.lambda$sendSceneUnsubscribeResp$4(sceneUnsubscribeResp);
            }
        });
    }

    public void setScenesListener(SceneListener sceneListener) {
        SceneManagerService.getInstance().setScenesListener(sceneListener);
    }

    private SceneManager() {
    }
}
