package com.haier.uhome.usdk.api;

import android.content.Context;
import com.haier.uhome.usdk.api.interfaces.IMonitorPlayerListener;
import com.haier.uhome.usdk.api.widget.VideoView;
import com.haier.uhome.usdk.base.annotation.Keep;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.video.IRecordingCallback;
import com.haier.uhome.video.IScreenshotCallback;
import com.haier.uhome.video.VideoDefinition;
import com.haier.uhome.video.api.MonitorPlaybackListener;
import com.haier.uhome.video.bean.DateBean;
import com.haier.uhome.video.bean.MessagePlaybackNode;
import com.haier.uhome.video.bean.MonitorPhotoListBean;
import com.haier.uhome.video.bean.MonitorPlaybackExistDateMessage;
import com.haier.uhome.video.bean.MonitorPlaybackMessage;
import com.haier.uhome.video.bean.PlayAddressBean;
import com.haier.uhome.video.bean.VideoPlayListBean;
import com.tencentcs.iotvideo.vas.VasMgr;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class MonitorPlaybackPlayer {
    private static com.haier.uhome.video.d monitorPlaybackService;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static MonitorPlaybackPlayer f30305a = new MonitorPlaybackPlayer();

        private a() {
        }
    }

    @Deprecated
    public static void createPlaybackPlayer(uSDKDevice usdkdevice, VideoView videoView, final ICallback<MonitorPlaybackPlayer> iCallback) {
        if (iCallback == null) {
            e3.a.e("MonitorPlayer iCallback is null", new Object[0]);
            return;
        }
        Context contextB = com.haier.uhome.usdk.base.service.e.a().b();
        if (contextB == null) {
            e3.a.e("MonitorPlayer context is null", new Object[0]);
            iCallback.onFailure(ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        com.haier.uhome.video.g.a().a(contextB);
        com.haier.uhome.video.g.a().c();
        com.haier.uhome.video.g.a().a(e3.a.m());
        VasMgr.init();
        if (usdkdevice != null) {
            monitorPlaybackService = new com.haier.uhome.video.d(usdkdevice.getDeviceId(), videoView, new ICallback<Void>() { // from class: com.haier.uhome.usdk.api.MonitorPlaybackPlayer.1
                @Override // com.haier.uhome.usdk.base.api.ICallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(Void r7) {
                    iCallback.onSuccess(MonitorPlaybackPlayer.getInstance());
                }

                @Override // com.haier.uhome.usdk.base.api.ICallback
                public void onFailure(uSDKError usdkerror) {
                    iCallback.onFailure(usdkerror);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MonitorPlaybackPlayer getInstance() {
        return a.f30305a;
    }

    @Keep
    public void addPlayerListener(final IMonitorPlayerListener iMonitorPlayerListener) {
        com.haier.uhome.video.d dVar = monitorPlaybackService;
        if (dVar != null) {
            dVar.a(new com.haier.uhome.video.f() { // from class: com.haier.uhome.usdk.api.MonitorPlaybackPlayer.3
                @Override // com.haier.uhome.video.f
                public void a(com.haier.uhome.video.i iVar) {
                    IMonitorPlayerListener iMonitorPlayerListener2 = iMonitorPlayerListener;
                    if (iMonitorPlayerListener2 != null) {
                        iMonitorPlayerListener2.onPlayerStatusUpdate(MonitorPlayerStatus.getPlayerStatus(iVar.name()));
                    }
                }

                @Override // com.haier.uhome.video.f
                public void b(long j7) {
                    IMonitorPlayerListener iMonitorPlayerListener2 = iMonitorPlayerListener;
                    if (iMonitorPlayerListener2 != null) {
                        iMonitorPlayerListener2.onPlayFileFinished(j7);
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
                public void a(long j7) {
                    IMonitorPlayerListener iMonitorPlayerListener2 = iMonitorPlayerListener;
                    if (iMonitorPlayerListener2 != null) {
                        iMonitorPlayerListener2.onTime(j7);
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
            return;
        }
        e3.a.v("MonitorPlaybackPlayer addPlayerListener monitorPlaybackService is null", new Object[0]);
        if (iMonitorPlayerListener != null) {
            iMonitorPlayerListener.onReceiveError(ErrorConst.ERR_USDK_INVALID_PARAM.toError());
        }
    }

    @Keep
    public void changeDefinition(VideoDefinition videoDefinition, ICallback<Void> iCallback) {
        com.haier.uhome.video.d dVar = monitorPlaybackService;
        if (dVar != null) {
            dVar.a(videoDefinition, iCallback);
        }
    }

    @Keep
    public void destroyPlayer() {
        com.haier.uhome.video.d dVar = monitorPlaybackService;
        if (dVar != null) {
            dVar.n_();
            monitorPlaybackService = null;
        }
    }

    @Keep
    public void getCloudVideoDateListByTimezone(int i7, MonitorPlaybackListener<DateBean> monitorPlaybackListener) {
        com.haier.uhome.video.d dVar = monitorPlaybackService;
        if (dVar != null) {
            dVar.a(i7, monitorPlaybackListener);
            return;
        }
        e3.a.v("MonitorPlaybackPlayer getCloudVideoDateListByTimezone monitorPlaybackService is null", new Object[0]);
        if (monitorPlaybackListener != null) {
            monitorPlaybackListener.onError(ErrorConst.ERR_USDK_INVALID_PARAM.toError());
        }
    }

    @Keep
    public void getCloudVideoPlayListByDeviceId(long j7, long j8, MonitorPlaybackListener<List<VideoPlayListBean.DataBean>> monitorPlaybackListener) {
        com.haier.uhome.video.d dVar = monitorPlaybackService;
        if (dVar != null) {
            dVar.a(j7, j8, monitorPlaybackListener);
            return;
        }
        e3.a.v("MonitorPlaybackPlayer getCloudVideoPlayListByDeviceId monitorPlaybackService is null", new Object[0]);
        if (monitorPlaybackListener != null) {
            monitorPlaybackListener.onError(ErrorConst.ERR_USDK_INVALID_PARAM.toError());
        }
    }

    @Keep
    public VideoDefinition getDefinition() {
        return monitorPlaybackService.g();
    }

    @Keep
    public void getDevicePhotoList(long j7, long j8, int i7, int i8, MonitorPlaybackListener<List<MonitorPhotoListBean>> monitorPlaybackListener) {
        com.haier.uhome.video.d dVar = monitorPlaybackService;
        if (dVar != null) {
            dVar.b(j7, j8, i7, i8, monitorPlaybackListener);
            return;
        }
        e3.a.v("MonitorPlaybackPlayer getDevicePhotoList monitorPlaybackService is null", new Object[0]);
        if (monitorPlaybackListener != null) {
            monitorPlaybackListener.onError(ErrorConst.ERR_USDK_INVALID_PARAM.toError());
        }
    }

    @Keep
    public void getLocalPhotoDataByPhotoId(int i7, int i8, ICallback<byte[]> iCallback) {
        com.haier.uhome.video.d dVar = monitorPlaybackService;
        if (dVar != null) {
            dVar.a(i7, i8, iCallback);
            return;
        }
        e3.a.v("MonitorPlaybackPlayer getLocalPhotoDataByPhotoId monitorPlaybackService is null", new Object[0]);
        if (iCallback != null) {
            iCallback.onFailure(ErrorConst.ERR_USDK_INVALID_PARAM.toError());
        }
    }

    @Keep
    public void getPlaybackDateList(long j7, long j8, int i7, int i8, MonitorPlaybackListener<MonitorPlaybackExistDateMessage> monitorPlaybackListener) {
        if (monitorPlaybackService == null) {
            e3.a.v("MonitorPlaybackPlayer getPlaybackDateList monitorPlaybackService is null", new Object[0]);
            if (monitorPlaybackListener != null) {
                monitorPlaybackListener.onError(ErrorConst.ERR_USDK_INVALID_PARAM.toError());
                return;
            }
            return;
        }
        if (monitorPlaybackListener == null) {
            e3.a.v("MonitorPlaybackPlayer getPlaybackDateList monitorPlaybackListener is null", new Object[0]);
        } else if (uSDKCloudConnectionState.CLOUD_CONNECTION_STATE_CONNECTED != uSDKDeviceManager.getSingleInstance().getCloudConnectionState()) {
            monitorPlaybackListener.onError(ErrorConst.ERR_USDK_CLOUD_OFFLINE.toError());
        } else {
            monitorPlaybackService.a(j7, j8, i7, i8, monitorPlaybackListener);
        }
    }

    @Keep
    public void getPlaybackList(long j7, long j8, int i7, int i8, String str, MonitorPlaybackListener<MonitorPlaybackMessage> monitorPlaybackListener) {
        com.haier.uhome.video.d dVar = monitorPlaybackService;
        if (dVar != null) {
            dVar.a(j7, j8, i7, i8, str, monitorPlaybackListener);
            return;
        }
        e3.a.v("MonitorPlaybackPlayer getPlaybackList monitorPlaybackService is null", new Object[0]);
        if (monitorPlaybackListener != null) {
            monitorPlaybackListener.onError(ErrorConst.ERR_USDK_INVALID_PARAM.toError());
        }
    }

    @Keep
    public void getVideoPlayAddressByDeviceId(long j7, long j8, MonitorPlaybackListener<PlayAddressBean> monitorPlaybackListener) {
        com.haier.uhome.video.d dVar = monitorPlaybackService;
        if (dVar != null) {
            dVar.b(j7, j8, monitorPlaybackListener);
            return;
        }
        e3.a.v("MonitorPlaybackPlayer getVideoPlayAddressByDeviceId monitorPlaybackService is null", new Object[0]);
        if (monitorPlaybackListener != null) {
            monitorPlaybackListener.onError(ErrorConst.ERR_USDK_INVALID_PARAM.toError());
        }
    }

    @Keep
    public boolean isPlaying() {
        com.haier.uhome.video.d dVar = monitorPlaybackService;
        if (dVar != null) {
            return dVar.l();
        }
        e3.a.v("MonitorPlaybackPlayer videoPlay monitorPlaybackService is null", new Object[0]);
        return false;
    }

    @Keep
    public boolean isRecording() {
        com.haier.uhome.video.d dVar = monitorPlaybackService;
        if (dVar == null) {
            return false;
        }
        return dVar.h();
    }

    @Keep
    public void mute(boolean z7) {
        com.haier.uhome.video.d dVar = monitorPlaybackService;
        if (dVar == null) {
            e3.a.v("MonitorPlaybackPlayer mute monitorPlaybackService is null", new Object[0]);
        } else {
            dVar.a(z7);
        }
    }

    @Keep
    public void pause() {
        com.haier.uhome.video.d dVar = monitorPlaybackService;
        if (dVar == null) {
            e3.a.v("MonitorPlaybackPlayer pause monitorPlaybackService is null", new Object[0]);
        } else {
            dVar.k();
        }
    }

    @Keep
    public void resume() {
        com.haier.uhome.video.d dVar = monitorPlaybackService;
        if (dVar == null) {
            e3.a.v("MonitorPlaybackPlayer resume monitorPlaybackService is null", new Object[0]);
        } else {
            dVar.m();
        }
    }

    @Keep
    public void seekToTime(long j7, MessagePlaybackNode messagePlaybackNode) {
        com.haier.uhome.video.d dVar = monitorPlaybackService;
        if (dVar == null) {
            e3.a.v("MonitorPlaybackPlayer seekToTime monitorPlaybackService is null", new Object[0]);
        } else {
            dVar.a(j7, messagePlaybackNode);
        }
    }

    @Keep
    public void setDataResource(long j7, MessagePlaybackNode messagePlaybackNode) {
        com.haier.uhome.video.d dVar = monitorPlaybackService;
        if (dVar == null) {
            e3.a.v("MonitorPlaybackPlayer setDataResource monitorPlaybackService is null", new Object[0]);
        } else {
            dVar.b(j7, messagePlaybackNode);
        }
    }

    @Keep
    public boolean startRecording(String str, IRecordingCallback iRecordingCallback) {
        return monitorPlaybackService.a(str, iRecordingCallback);
    }

    @Keep
    public void stopRecording() {
        monitorPlaybackService.i();
    }

    @Keep
    public void takeScreenshot(String str, IScreenshotCallback iScreenshotCallback) {
        com.haier.uhome.video.d dVar = monitorPlaybackService;
        if (dVar == null) {
            e3.a.v("MonitorPlaybackPlayer takeScreenshot monitorPlaybackService is null", new Object[0]);
        } else {
            dVar.a(str, iScreenshotCallback);
        }
    }

    @Keep
    public void videoPlay() {
        com.haier.uhome.video.d dVar = monitorPlaybackService;
        if (dVar == null) {
            e3.a.v("MonitorPlaybackPlayer videoPlay monitorPlaybackService is null", new Object[0]);
        } else {
            dVar.l_();
        }
    }

    @Keep
    public void videoStop() {
        com.haier.uhome.video.d dVar = monitorPlaybackService;
        if (dVar == null) {
            e3.a.v("MonitorPlaybackPlayer videoStop monitorPlaybackService is null", new Object[0]);
        } else {
            dVar.m_();
        }
    }

    private MonitorPlaybackPlayer() {
    }

    @Keep
    public static void createPlaybackPlayer(String str, VideoView videoView, final ICallback<MonitorPlaybackPlayer> iCallback) {
        if (str == null) {
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
            iCallback.onFailure(ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        com.haier.uhome.video.g.a().a(contextB);
        com.haier.uhome.video.g.a().c();
        com.haier.uhome.video.g.a().a(e3.a.m());
        VasMgr.init();
        monitorPlaybackService = new com.haier.uhome.video.d(str, videoView, new ICallback<Void>() { // from class: com.haier.uhome.usdk.api.MonitorPlaybackPlayer.2
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                iCallback.onSuccess(MonitorPlaybackPlayer.getInstance());
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                iCallback.onFailure(usdkerror);
            }
        });
    }
}
