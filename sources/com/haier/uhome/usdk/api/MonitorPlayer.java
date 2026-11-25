package com.haier.uhome.usdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.haier.uhome.usdk.api.interfaces.IMonitorPlayerListener;
import com.haier.uhome.usdk.api.widget.VideoView;
import com.haier.uhome.usdk.base.annotation.Keep;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.video.IRecordingCallback;
import com.haier.uhome.video.IScreenshotCallback;
import com.haier.uhome.video.VideoDefinition;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class MonitorPlayer {
    private static com.haier.uhome.video.h monitorPlayerService;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static MonitorPlayer f30310a = new MonitorPlayer();

        private a() {
        }
    }

    @Deprecated
    public static void createPlayer(uSDKDevice usdkdevice, VideoView videoView, final ICallback<MonitorPlayer> iCallback) {
        if (iCallback == null) {
            e3.a.e("MonitorPlayer iCallback is null", new Object[0]);
            return;
        }
        Context contextB = com.haier.uhome.usdk.base.service.e.a().b();
        if (contextB == null) {
            e3.a.e("MonitorPlayer context is null", new Object[0]);
            return;
        }
        com.haier.uhome.video.g.a().a(contextB);
        com.haier.uhome.video.g.a().c();
        com.haier.uhome.video.g.a().a(e3.a.m());
        if (usdkdevice != null) {
            monitorPlayerService = new com.haier.uhome.video.h(usdkdevice.getDeviceId(), videoView, new ICallback<Void>() { // from class: com.haier.uhome.usdk.api.MonitorPlayer.1
                @Override // com.haier.uhome.usdk.base.api.ICallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(Void r7) {
                    iCallback.onSuccess(MonitorPlayer.getInstance());
                }

                @Override // com.haier.uhome.usdk.base.api.ICallback
                public void onFailure(uSDKError usdkerror) {
                    iCallback.onFailure(usdkerror);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MonitorPlayer getInstance() {
        return a.f30310a;
    }

    @Keep
    public void addPlayerListener(final IMonitorPlayerListener iMonitorPlayerListener) {
        com.haier.uhome.video.h hVar = monitorPlayerService;
        if (hVar == null) {
            e3.a.e("addPlayerListener: monitorPlayerService is null", new Object[0]);
        } else {
            hVar.a(new com.haier.uhome.video.f() { // from class: com.haier.uhome.usdk.api.MonitorPlayer.3
                @Override // com.haier.uhome.video.f
                public void a(long j7) {
                }

                @Override // com.haier.uhome.video.f
                public void b(long j7) {
                }

                @Override // com.haier.uhome.video.f
                public void a(com.haier.uhome.video.i iVar) {
                    IMonitorPlayerListener iMonitorPlayerListener2 = iMonitorPlayerListener;
                    if (iMonitorPlayerListener2 != null) {
                        iMonitorPlayerListener2.onPlayerStatusUpdate(MonitorPlayerStatus.getPlayerStatus(iVar.name()));
                    }
                }

                @Override // com.haier.uhome.video.f
                public void a(uSDKError usdkerror) {
                    IMonitorPlayerListener iMonitorPlayerListener2 = iMonitorPlayerListener;
                    if (iMonitorPlayerListener2 != null) {
                        iMonitorPlayerListener2.onReceiveError(usdkerror);
                    }
                }

                @Override // com.haier.uhome.video.f
                public void a(int i7) {
                    IMonitorPlayerListener iMonitorPlayerListener2 = iMonitorPlayerListener;
                    if (iMonitorPlayerListener2 != null) {
                        iMonitorPlayerListener2.updateSpeed(i7);
                    }
                }
            });
        }
    }

    @Keep
    public void changeDefinition(VideoDefinition videoDefinition, ICallback<Void> iCallback) {
        com.haier.uhome.video.h hVar = monitorPlayerService;
        if (hVar != null) {
            hVar.a(videoDefinition, iCallback);
        }
    }

    @Keep
    public void destroyPlayer() {
        com.haier.uhome.video.h hVar = monitorPlayerService;
        if (hVar != null) {
            hVar.n_();
            monitorPlayerService = null;
        }
    }

    @Keep
    public VideoDefinition getDefinition() {
        return monitorPlayerService.g();
    }

    @Keep
    public boolean isMute() {
        com.haier.uhome.video.h hVar = monitorPlayerService;
        if (hVar != null) {
            return hVar.k_();
        }
        return false;
    }

    @Keep
    public boolean isRecording() {
        com.haier.uhome.video.h hVar = monitorPlayerService;
        if (hVar == null) {
            return false;
        }
        return hVar.h();
    }

    @Keep
    public void mute(boolean z7) {
        com.haier.uhome.video.h hVar = monitorPlayerService;
        if (hVar != null) {
            hVar.a(z7);
        }
    }

    @Keep
    public void play() {
        com.haier.uhome.video.h hVar = monitorPlayerService;
        if (hVar != null) {
            hVar.l_();
        }
    }

    @Keep
    public boolean startRecording(String str, IRecordingCallback iRecordingCallback) {
        return monitorPlayerService.a(str, iRecordingCallback);
    }

    @Keep
    public void startTalk() {
        com.haier.uhome.video.h hVar = monitorPlayerService;
        if (hVar != null) {
            hVar.a();
        }
    }

    @Keep
    public void stop() {
        com.haier.uhome.video.h hVar = monitorPlayerService;
        if (hVar != null) {
            hVar.m_();
        }
    }

    @Keep
    public void stopRecording() {
        monitorPlayerService.i();
    }

    @Keep
    public void stopTalk() {
        com.haier.uhome.video.h hVar = monitorPlayerService;
        if (hVar != null) {
            hVar.j();
        }
    }

    @Keep
    public void takeScreenshot(String str, IScreenshotCallback iScreenshotCallback) {
        com.haier.uhome.video.h hVar = monitorPlayerService;
        if (hVar == null) {
            e3.a.v("MonitorPlaybackPlayer takeScreenshot monitorPlaybackService is null", new Object[0]);
        } else {
            hVar.a(str, iScreenshotCallback);
        }
    }

    private MonitorPlayer() {
    }

    @Keep
    public static void createPlayer(String str, VideoView videoView, final ICallback<MonitorPlayer> iCallback) {
        if (TextUtils.isEmpty(str)) {
            e3.a.e("MonitorPlayer deviceId is null", new Object[0]);
            return;
        }
        if (iCallback == null) {
            e3.a.e("MonitorPlayer iCallback is null", new Object[0]);
            return;
        }
        Context contextB = com.haier.uhome.usdk.base.service.e.a().b();
        if (contextB == null) {
            e3.a.e("MonitorPlayer context is null", new Object[0]);
            return;
        }
        com.haier.uhome.video.g.a().a(contextB);
        com.haier.uhome.video.g.a().c();
        com.haier.uhome.video.g.a().a(e3.a.m());
        monitorPlayerService = new com.haier.uhome.video.h(str, videoView, new ICallback<Void>() { // from class: com.haier.uhome.usdk.api.MonitorPlayer.2
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                iCallback.onSuccess(MonitorPlayer.getInstance());
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                iCallback.onFailure(usdkerror);
            }
        });
    }
}
