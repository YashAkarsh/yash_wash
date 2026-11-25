package com.haier.uhome.usdk.scene.service;

/* JADX INFO: loaded from: classes2.dex */
public class SceneNativeService {
    private final SceneNative mScenesNative;

    private static class SingletonFactory {
        private static SceneNativeService sInstance = new SceneNativeService();

        private SingletonFactory() {
        }
    }

    public static SceneNativeService getInstance() {
        return SingletonFactory.sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(String str) {
        SceneManagerService.getInstance().process(str);
    }

    public int init() {
        e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.H, "init().", new Object[0]);
        int iInit = this.mScenesNative.init();
        e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.H, "init() ret %d", Integer.valueOf(iInit));
        return iInit;
    }

    public int unInit() {
        e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.H, "unInit().", new Object[0]);
        int iUnInit = this.mScenesNative.unInit();
        e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.H, "unInit() ret %d", Integer.valueOf(iUnInit));
        return iUnInit;
    }

    public int userDataDown(String str) {
        e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.H, "userDataDown(%s).", str);
        int iUserDataDown = this.mScenesNative.userDataDown(str);
        e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.H, "userDataDown(%d) ret %s", Integer.valueOf(iUserDataDown), str);
        return iUserDataDown;
    }

    private SceneNativeService() {
        SceneNative sceneNative = new SceneNative();
        this.mScenesNative = sceneNative;
        sceneNative.setUserPackageReceive(new com.haier.uhome.usdk.base.a.b() { // from class: com.haier.uhome.usdk.scene.service.f
            @Override // com.haier.uhome.usdk.base.a.b
            public final void onReceive(String str) {
                SceneNativeService.lambda$new$0(str);
            }
        });
    }
}
