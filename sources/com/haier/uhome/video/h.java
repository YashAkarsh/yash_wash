package com.haier.uhome.video;

import android.content.Context;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.tencentcs.iotvideo.IPropertySettingListener;
import com.tencentcs.iotvideo.iotvideoplayer.IErrorListener;
import com.tencentcs.iotvideo.iotvideoplayer.IRecordListener;
import com.tencentcs.iotvideo.iotvideoplayer.ISnapShotListener;
import com.tencentcs.iotvideo.iotvideoplayer.IStatusListener;
import com.tencentcs.iotvideo.iotvideoplayer.IoTVideoView;
import com.tencentcs.iotvideo.iotvideoplayer.player.MonitorPlayer;
import com.tencentcs.iotvideo.messagemgr.IAppLinkListener;
import com.tencentcs.iotvideo.utils.rxjava.IResultListener;
import java.util.HashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.DateUtils;

/* JADX INFO: loaded from: classes2.dex */
public class h implements e, IErrorListener, IStatusListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MonitorPlayer f32168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f f32169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f32170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ScheduledFuture f32171d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ICallback<Void> f32172e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f32173f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.haier.uhome.usdk.base.api.p f32174g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f32175h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ScheduledFuture f32176i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private VideoDefinition f32177j = VideoDefinition.HD;

    public h(String str, IoTVideoView ioTVideoView, ICallback<Void> iCallback) {
        this.f32170c = str;
        this.f32172e = iCallback;
        MonitorPlayer monitorPlayer = new MonitorPlayer();
        this.f32168a = monitorPlayer;
        monitorPlayer.setVideoView(ioTVideoView);
        this.f32168a.setStatusListener(this);
        this.f32168a.setErrorListener(this);
        this.f32168a.getAvBytesPerSec();
        k();
        m();
        o();
    }

    private void k() {
        if (this.f32174g == null) {
            this.f32174g = new com.haier.uhome.usdk.base.api.p() { // from class: com.haier.uhome.video.h.1
                @Override // com.haier.uhome.usdk.base.api.p
                public void a(boolean z7) {
                    if (!h.this.f32175h) {
                        e3.a.e("onAppStateChanged: isClickPlay is false", new Object[0]);
                    } else if (z7) {
                        h.this.f32168a.play();
                    } else {
                        h.this.f32168a.stop();
                    }
                }
            };
        }
        com.haier.uhome.usdk.base.api.r.a().a(this.f32174g);
    }

    private void l() {
        if (this.f32174g == null) {
            e3.a.h("unRegisterSystemListener with a null SystemListener object", new Object[0]);
        } else {
            com.haier.uhome.usdk.base.api.r.a().b(this.f32174g);
        }
    }

    private void m() {
        g.a().a(new IAppLinkListener() { // from class: com.haier.uhome.video.t
            public final void a(int i7) {
                this.f32222a.a(i7);
            }
        });
    }

    private void n() {
        ScheduledFuture scheduledFuture = this.f32171d;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.f32171d.cancel(true);
        this.f32171d = null;
    }

    private void o() {
        com.haier.library.sumhttp.request.a.h().j(this.f32170c, "", new m3.a<com.haier.library.sumhttp.response.f>() { // from class: com.haier.uhome.video.h.10
            @Override // m3.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.library.sumhttp.response.f fVar) {
                e3.a.e("videoPlay onSuccess: data = " + fVar, new Object[0]);
                if (fVar == null || !fVar.c()) {
                    h.this.f32172e.onFailure(ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR.toError());
                    return;
                }
                if (fVar.f() == null || fVar.f().a() == null || fVar.f().b() == null || fVar.f().f() == null) {
                    return;
                }
                g.a().a(Long.parseLong(fVar.f().a()), fVar.f().b());
                h.this.f32168a.setDataResource(fVar.f().f());
                h.this.b(fVar.f().c());
            }

            @Override // m3.a
            public void onError(Exception exc) {
                e3.a.e("videoPlay onError: e = " + exc.toString(), new Object[0]);
                h.this.f32172e.onFailure(ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR.toError());
            }
        });
    }

    private void p() {
        com.haier.library.sumhttp.request.a.h().j(this.f32170c, "", new m3.a<com.haier.library.sumhttp.response.f>() { // from class: com.haier.uhome.video.h.2
            @Override // m3.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.library.sumhttp.response.f fVar) {
                if (fVar == null || !fVar.c() || fVar.f() == null || fVar.f().b() == null) {
                    return;
                }
                e3.a.e("updateTempAccessInfo onSuccess: isUpdateSuccess : %s", Boolean.valueOf(g.a().a(fVar.f().b())));
            }

            @Override // m3.a
            public void onError(Exception exc) {
                e3.a.e("updateTempAccessInfo onError: e : %s", exc.toString());
            }
        });
    }

    private void q() {
        if (this.f32176i == null) {
            this.f32176i = com.haier.library.common.thread.m.scheduleWithFixedDelayToFuture(new Runnable() { // from class: com.haier.uhome.video.q
                @Override // java.lang.Runnable
                public final void run() {
                    this.f32218a.s();
                }
            }, 2L, 2L, TimeUnit.SECONDS);
        }
    }

    private void r() {
        ScheduledFuture scheduledFuture = this.f32176i;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        f fVar = this.f32169b;
        if (fVar != null) {
            fVar.a(0);
        }
        this.f32176i.cancel(true);
        this.f32176i = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s() {
        int iF = f();
        f fVar = this.f32169b;
        if (fVar != null) {
            fVar.a(iF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t() {
        e3.a.e("updateAuthorizationInfo start", new Object[0]);
        p();
    }

    @Override // com.haier.uhome.video.b
    public boolean h() {
        return this.f32168a.isRecording();
    }

    @Override // com.haier.uhome.video.b
    public void i() {
        this.f32168a.stopRecord();
    }

    @Override // com.haier.uhome.video.e
    public void j() {
        f fVar;
        if (this.f32168a.isPlaying() || (fVar = this.f32169b) == null) {
            this.f32168a.stopTalk(new IPropertySettingListener() { // from class: com.haier.uhome.video.h.4
                public void onResult(int i7, String str) {
                }
            });
        } else {
            fVar.a(ErrorConst.ERR_USDK_MONITOR_DEVICE_NOT_PLAY.toError());
        }
    }

    @Override // com.haier.uhome.video.b
    public boolean k_() {
        return this.f32168a.isMute();
    }

    @Override // com.haier.uhome.video.b
    public void l_() {
        if (this.f32168a.isPlaying() || this.f32173f != 1) {
            e3.a.e("videoPlay APP LINK OFFLINE ", new Object[0]);
        } else {
            this.f32175h = true;
            this.f32168a.play();
        }
    }

    @Override // com.haier.uhome.video.b
    public void m_() {
        f fVar;
        if (!this.f32168a.isPlaying() && (fVar = this.f32169b) != null) {
            fVar.a(ErrorConst.ERR_USDK_MONITOR_DEVICE_NOT_PLAY.toError());
            return;
        }
        this.f32175h = false;
        this.f32168a.stop();
        r();
    }

    @Override // com.haier.uhome.video.b
    public void n_() {
        MonitorPlayer monitorPlayer = this.f32168a;
        if (monitorPlayer != null && monitorPlayer.isPlaying()) {
            this.f32168a.stop();
        }
        g.a().b();
        g.a().d();
        l();
        n();
        r();
        if (this.f32170c != null) {
            this.f32170c = null;
        }
        if (this.f32172e != null) {
            this.f32172e = null;
        }
        MonitorPlayer monitorPlayer2 = this.f32168a;
        if (monitorPlayer2 != null) {
            monitorPlayer2.setVideoView((IoTVideoView) null);
            this.f32168a.setErrorListener((IErrorListener) null);
            this.f32168a.setStatusListener((IStatusListener) null);
            this.f32168a = null;
        }
        if (this.f32169b != null) {
            this.f32169b = null;
        }
    }

    public void onError(int i7) {
        if (this.f32169b == null) {
            e3.a.e("MonitorPlayerService onError mMonitorPlayerListener is null", new Object[0]);
            return;
        }
        if (this.f32172e == null) {
            e3.a.e("MonitorPlayerService onError mICallback is null", new Object[0]);
            return;
        }
        uSDKError usdkerrorA = com.haier.uhome.video.a.a.a(i7);
        HashMap<String, String> map = new HashMap<>(1);
        map.put("monitor_error_code", String.valueOf(i7));
        usdkerrorA.a(map);
        this.f32169b.a(usdkerrorA);
    }

    public void onStatus(int i7) {
        e3.a.e("MonitorPlayerService onStatus : %s", Integer.valueOf(i7));
        f fVar = this.f32169b;
        if (fVar == null) {
            e3.a.e("MonitorPlayerService onStatus mMonitorPlayerListener is null", new Object[0]);
        }
        switch (i7) {
            case 0:
                fVar.a(i.STATE_IDLE);
                break;
            case 1:
                fVar.a(i.STATE_INITIALIZED);
                break;
            case 2:
                fVar.a(i.STATE_PREPARING);
                break;
            case 3:
                fVar.a(i.STATE_READY);
                break;
            case 4:
                fVar.a(i.STATE_LOADING);
                break;
            case 5:
                fVar.a(i.STATE_PLAY);
                q();
                break;
            case 6:
                fVar.a(i.STATE_PAUSE);
                break;
            case 7:
                this.f32168a.stopTalk(new IPropertySettingListener() { // from class: com.haier.uhome.video.h.9
                    public void onResult(int i8, String str) {
                    }
                });
                this.f32169b.a(i.STATE_STOP);
                r();
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j7) {
        long jCurrentTimeMillis = ((j7 - System.currentTimeMillis()) / DateUtils.MILLIS_PER_HOUR) - 1;
        e3.a.e("startUpdateTimer: updateTimeHour : %s", Long.valueOf(jCurrentTimeMillis));
        a(jCurrentTimeMillis);
    }

    @Override // com.haier.uhome.video.b
    public int f() {
        return this.f32168a.getAvBytesPerSec();
    }

    @Override // com.haier.uhome.video.b
    public VideoDefinition g() {
        return this.f32177j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i7) {
        e3.a.e("initAppLink: state = %s", Integer.valueOf(i7));
        if (1 == i7) {
            this.f32173f = i7;
            this.f32172e.onSuccess(null);
        }
    }

    @Override // com.haier.uhome.video.e
    public void a() {
        f fVar;
        if (!this.f32168a.isPlaying() && (fVar = this.f32169b) != null) {
            fVar.a(ErrorConst.ERR_USDK_MONITOR_DEVICE_NOT_PLAY.toError());
        } else {
            new com.haier.library.common.thread.m<Void, Void, Void>() { // from class: com.haier.uhome.video.h.3
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.haier.library.common.thread.m
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Void doInBackground(Void... voidArr) {
                    Context contextB = com.haier.uhome.usdk.base.service.e.a().b();
                    if (contextB == null || !com.haier.library.common.util.permissions.d.d().c(contextB, "android.permission.RECORD_AUDIO").c()) {
                        return null;
                    }
                    h.this.f32168a.startTalk(new IPropertySettingListener() { // from class: com.haier.uhome.video.h.3.1
                        public void onResult(int i7, String str) {
                        }
                    });
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    @Override // com.haier.uhome.video.b
    public void a(boolean z7) {
        this.f32168a.mute(z7);
    }

    @Override // com.haier.uhome.video.b
    public void a(f fVar) {
        this.f32169b = fVar;
    }

    @Override // com.haier.uhome.video.b
    public void a(final VideoDefinition videoDefinition, final ICallback<Void> iCallback) {
        if (iCallback == null) {
            e3.a.e("MonitorPlayerService changeDefinition iCallback is null", new Object[0]);
            return;
        }
        if (VideoDefinition.HD.equals(videoDefinition)) {
            this.f32168a.changeDefinition((byte) 2, new IResultListener<Boolean>() { // from class: com.haier.uhome.video.h.5
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(Boolean bool) {
                    h.this.f32177j = videoDefinition;
                    iCallback.onSuccess(null);
                }

                public void onError(int i7, String str) {
                    iCallback.onFailure(ErrorConst.ERR_USDK_PLAYER_INTERNAL_FAILURE.toError());
                }

                public void onStart() {
                }
            });
        } else if (VideoDefinition.SD.equals(videoDefinition)) {
            this.f32168a.changeDefinition((byte) 1, new IResultListener<Boolean>() { // from class: com.haier.uhome.video.h.6
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(Boolean bool) {
                    h.this.f32177j = videoDefinition;
                    iCallback.onSuccess(null);
                }

                public void onError(int i7, String str) {
                    iCallback.onFailure(ErrorConst.ERR_USDK_PLAYER_INTERNAL_FAILURE.toError());
                }

                public void onStart() {
                }
            });
        } else {
            this.f32168a.changeDefinition((byte) 0, new IResultListener<Boolean>() { // from class: com.haier.uhome.video.h.7
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(Boolean bool) {
                    h.this.f32177j = videoDefinition;
                    iCallback.onSuccess(null);
                }

                public void onError(int i7, String str) {
                    iCallback.onFailure(ErrorConst.ERR_USDK_PLAYER_INTERNAL_FAILURE.toError());
                }

                public void onStart() {
                }
            });
        }
    }

    @Override // com.haier.uhome.video.b
    public void a(final String str, final IScreenshotCallback iScreenshotCallback) {
        if (iScreenshotCallback == null) {
            e3.a.e("takeScreenshot iSnapShotListener is null", new Object[0]);
        } else {
            this.f32168a.snapShot(str, new ISnapShotListener() { // from class: com.haier.uhome.video.r
                public final void a(int i7, String str2) {
                    h.a(iScreenshotCallback, str, i7, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(IScreenshotCallback iScreenshotCallback, String str, int i7, String str2) {
        if (i7 == 0) {
            iScreenshotCallback.onResult(str, ErrorConst.RET_USDK_OK.toError());
            return;
        }
        uSDKError error = ErrorConst.ERR_USDK_PLAYER_COMMON_FAILURE.toError();
        error.a(String.valueOf(i7));
        iScreenshotCallback.onResult(str2, error);
    }

    @Override // com.haier.uhome.video.b
    public boolean a(String str, final IRecordingCallback iRecordingCallback) {
        if (str == null || !str.contains("/")) {
            e3.a.e("MonitorPlayerService startRecording Path Incorrect format", new Object[0]);
            return false;
        }
        if (iRecordingCallback == null) {
            e3.a.e("startRecording iRecordingCallback is null", new Object[0]);
            return false;
        }
        String[] strArrSplit = str.split("/");
        String str2 = strArrSplit[strArrSplit.length - 1];
        StringBuilder sb = new StringBuilder();
        for (int i7 = 0; i7 < strArrSplit.length - 1; i7++) {
            String str3 = strArrSplit[i7];
            if (!str3.isEmpty()) {
                sb.append("/" + str3);
                str = sb.toString();
            }
        }
        e3.a.e("MonitorPlayerService startRecording: path = " + str + " fileName = " + str2, new Object[0]);
        return this.f32168a.startRecord(str, str2, new IRecordListener() { // from class: com.haier.uhome.video.h.8
            public void onPositionUpdated(long j7, long j8) {
            }

            public void onResult(int i8, String str4) {
                if (i8 == 0) {
                    iRecordingCallback.onResult(str4, ErrorConst.RET_USDK_OK.toError());
                    return;
                }
                uSDKError error = ErrorConst.ERR_USDK_PLAYER_COMMON_FAILURE.toError();
                error.a(String.valueOf(i8));
                iRecordingCallback.onResult(str4, error);
            }

            public void onStartRecord() {
                iRecordingCallback.onStartRecord();
            }
        });
    }

    private void a(long j7) {
        this.f32171d = com.haier.library.common.thread.m.scheduleWithFixedDelayToFuture(new Runnable() { // from class: com.haier.uhome.video.s
            @Override // java.lang.Runnable
            public final void run() {
                this.f32221a.t();
            }
        }, j7, j7, TimeUnit.HOURS);
    }
}
