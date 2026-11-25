package com.haier.uhome.video;

import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.video.api.MonitorPlaybackListener;
import com.haier.uhome.video.bean.CloudVideoDateBean;
import com.haier.uhome.video.bean.DateBean;
import com.haier.uhome.video.bean.DeviceImgReqBean;
import com.haier.uhome.video.bean.DeviceImgRespBean;
import com.haier.uhome.video.bean.MessagePlaybackNode;
import com.haier.uhome.video.bean.MonitorDateListNode;
import com.haier.uhome.video.bean.MonitorPhotoListBean;
import com.haier.uhome.video.bean.MonitorPlaybackExistDateMessage;
import com.haier.uhome.video.bean.MonitorPlaybackMessage;
import com.haier.uhome.video.bean.PhotoListBean;
import com.haier.uhome.video.bean.PlayAddressBean;
import com.haier.uhome.video.bean.VideoPlayAddressBean;
import com.haier.uhome.video.bean.VideoPlayListBean;
import com.tencentcs.iotvideo.IPropertySettingListener;
import com.tencentcs.iotvideo.IoTVideoSdk;
import com.tencentcs.iotvideo.iotvideoplayer.IErrorListener;
import com.tencentcs.iotvideo.iotvideoplayer.IPreparedListener;
import com.tencentcs.iotvideo.iotvideoplayer.IRecordListener;
import com.tencentcs.iotvideo.iotvideoplayer.ISnapShotListener;
import com.tencentcs.iotvideo.iotvideoplayer.IStatusListener;
import com.tencentcs.iotvideo.iotvideoplayer.ITimeListener;
import com.tencentcs.iotvideo.iotvideoplayer.IUserDataListener;
import com.tencentcs.iotvideo.iotvideoplayer.IoTVideoView;
import com.tencentcs.iotvideo.iotvideoplayer.player.PlaybackPlayer;
import com.tencentcs.iotvideo.iotvideoplayer.player.TransmissionConnection;
import com.tencentcs.iotvideo.messagemgr.DataMessage;
import com.tencentcs.iotvideo.messagemgr.IPlaybackInnerUserDataLister;
import com.tencentcs.iotvideo.messagemgr.PlaybackExistDateMessage;
import com.tencentcs.iotvideo.messagemgr.PlaybackMessage;
import com.tencentcs.iotvideo.utils.rxjava.IResultListener;
import com.tencentcs.iotvideo.utils.rxjava.SubscriberListener;
import com.tencentcs.iotvideo.vas.VasMgr;
import com.tencentcs.iotvideo.vas.VasService;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.DateUtils;

/* JADX INFO: loaded from: classes2.dex */
public class d extends com.haier.library.common.util.m implements c, IErrorListener, IPreparedListener, IStatusListener, ITimeListener, IPlaybackInnerUserDataLister {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ICallback<Void> f32135d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f32136e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f32137f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f32138g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ScheduledFuture f32139h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ScheduledFuture f32140i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private f f32141j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ICallback<byte[]> f32142k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private com.haier.uhome.usdk.base.api.p f32143l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f32144m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private VideoDefinition f32145n = VideoDefinition.HD;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PlaybackPlayer f32132a = new PlaybackPlayer();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private VasService f32133b = VasMgr.getVasService();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TransmissionConnection f32134c = new TransmissionConnection();

    public d(String str, IoTVideoView ioTVideoView, ICallback<Void> iCallback) {
        this.f32135d = iCallback;
        this.f32138g = str;
        this.f32132a.setVideoView(ioTVideoView);
        this.f32132a.setPreparedListener(this);
        this.f32132a.setStatusListener(this);
        this.f32132a.setTimeListener(this);
        this.f32132a.setErrorListener(this);
        this.f32132a.setPlaybackInnerUserDataLister(this);
        q();
        n();
    }

    private void n() {
        com.haier.library.sumhttp.request.a.h().j(this.f32138g, "", new m3.a<com.haier.library.sumhttp.response.f>() { // from class: com.haier.uhome.video.d.2
            @Override // m3.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.library.sumhttp.response.f fVar) {
                e3.a.e("videoPlayback onSuccess: data = " + fVar, new Object[0]);
                if (fVar == null || !fVar.c()) {
                    d.this.f32135d.onFailure(ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR.toError());
                    return;
                }
                if (fVar.f() == null || fVar.f().a() == null || fVar.f().b() == null || fVar.f().f() == null) {
                    return;
                }
                g.a().a(Long.parseLong(fVar.f().a()), fVar.f().b());
                d.this.f32136e = fVar.f().f();
                d.this.f32137f = fVar.f().e();
                d.this.f32135d.onSuccess(null);
                d.this.b(fVar.f().c());
            }

            @Override // m3.a
            public void onError(Exception exc) {
                e3.a.e("videoPlayback onError: e = " + exc.toString(), new Object[0]);
                d.this.f32135d.onFailure(ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR.toError());
            }
        });
    }

    private void o() {
        com.haier.library.sumhttp.request.a.h().j(this.f32138g, "", new m3.a<com.haier.library.sumhttp.response.f>() { // from class: com.haier.uhome.video.d.3
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

    private void p() {
        ScheduledFuture scheduledFuture = this.f32139h;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.f32139h.cancel(true);
        this.f32139h = null;
    }

    private void q() {
        if (this.f32143l == null) {
            this.f32143l = new com.haier.uhome.usdk.base.api.p() { // from class: com.haier.uhome.video.d.4
                @Override // com.haier.uhome.usdk.base.api.p
                public void a(boolean z7) {
                    if (!d.this.f32144m) {
                        e3.a.e("onAppStateChanged: isClickPlay is false", new Object[0]);
                    } else if (z7) {
                        d.this.f32132a.resume(new IPropertySettingListener() { // from class: com.haier.uhome.video.d.4.1
                            public void onResult(int i7, String str) {
                            }
                        });
                    } else {
                        d.this.f32132a.pause(new IPropertySettingListener() { // from class: com.haier.uhome.video.d.4.2
                            public void onResult(int i7, String str) {
                            }
                        });
                    }
                }
            };
        }
        com.haier.uhome.usdk.base.api.r.a().a(this.f32143l);
    }

    private void r() {
        if (this.f32143l == null) {
            e3.a.h("unRegisterSystemListener with a null SystemListener object", new Object[0]);
        } else {
            com.haier.uhome.usdk.base.api.r.a().b(this.f32143l);
        }
    }

    private void s() {
        if (this.f32140i == null) {
            this.f32140i = com.haier.library.common.thread.m.scheduleWithFixedDelayToFuture(new Runnable() { // from class: com.haier.uhome.video.l
                @Override // java.lang.Runnable
                public final void run() {
                    this.f32209a.u();
                }
            }, 2L, 2L, TimeUnit.SECONDS);
        }
    }

    private void t() {
        ScheduledFuture scheduledFuture = this.f32140i;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        f fVar = this.f32141j;
        if (fVar != null) {
            fVar.a(0);
        }
        this.f32140i.cancel(true);
        this.f32140i = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u() {
        int iF = f();
        f fVar = this.f32141j;
        if (fVar != null) {
            fVar.a(iF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v() {
        e3.a.e("updateAuthorizationInfo start", new Object[0]);
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w() {
        e3.a.e("getLocalPhotoDataByPhotoId: setPreparedListener ", new Object[0]);
    }

    @Override // com.haier.uhome.video.c
    public void k() {
        this.f32132a.pause(new IPropertySettingListener() { // from class: com.haier.uhome.video.d.6
            public void onResult(int i7, String str) {
            }
        });
    }

    @Override // com.haier.uhome.video.b
    public boolean k_() {
        return this.f32132a.isMute();
    }

    @Override // com.haier.uhome.video.c
    public boolean l() {
        return this.f32132a.isPlaying();
    }

    @Override // com.haier.uhome.video.b
    public void l_() {
        this.f32144m = true;
        this.f32132a.play();
    }

    @Override // com.haier.uhome.video.c
    public void m() {
        this.f32132a.resume(new IPropertySettingListener() { // from class: com.haier.uhome.video.d.7
            public void onResult(int i7, String str) {
            }
        });
    }

    @Override // com.haier.uhome.video.b
    public void m_() {
        this.f32144m = false;
        this.f32132a.stop();
        t();
    }

    @Override // com.haier.uhome.video.b
    public void n_() {
        r();
        p();
        t();
        if (this.f32138g != null) {
            this.f32138g = null;
        }
        if (this.f32135d != null) {
            this.f32135d = null;
        }
        PlaybackPlayer playbackPlayer = this.f32132a;
        if (playbackPlayer != null) {
            playbackPlayer.setVideoView((IoTVideoView) null);
            this.f32132a.setPreparedListener((IPreparedListener) null);
            this.f32132a.setStatusListener((IStatusListener) null);
            this.f32132a.setTimeListener((ITimeListener) null);
            this.f32132a.setErrorListener((IErrorListener) null);
            this.f32132a.setPlaybackInnerUserDataLister((IPlaybackInnerUserDataLister) null);
            this.f32132a.release();
            this.f32132a = null;
        }
        TransmissionConnection transmissionConnection = this.f32134c;
        if (transmissionConnection != null) {
            transmissionConnection.stop();
            this.f32134c.release();
            this.f32134c = null;
        }
    }

    public void onError(int i7) {
        e3.a.e("MonitorPlaybackService onError: error = " + i7, new Object[0]);
        if (this.f32141j == null) {
            e3.a.e("MonitorPlayerService onError mMonitorPlayerListener is null", new Object[0]);
            return;
        }
        if (this.f32135d == null) {
            e3.a.e("MonitorPlayerService onError mICallback is null", new Object[0]);
            return;
        }
        uSDKError usdkerrorA = com.haier.uhome.video.a.a.a(i7);
        HashMap<String, String> map = new HashMap<>(1);
        map.put("monitor_error_code", String.valueOf(i7));
        usdkerrorA.a(map);
        this.f32141j.a(usdkerrorA);
    }

    public void onPlayFileFinished(long j7) {
        e3.a.e("MonitorPlaybackService onPlayFileFinished: l = " + j7, new Object[0]);
        f fVar = this.f32141j;
        if (fVar != null) {
            fVar.b(j7);
        }
    }

    public void onPlayFileStart(long j7) {
        e3.a.e("MonitorPlaybackService onPlayFileStart: ", new Object[0]);
    }

    public void onPrepared() {
        e3.a.e("onPrepared: ", new Object[0]);
    }

    public void onSeekRet(boolean z7, long j7) {
        e3.a.e("MonitorPlaybackService onSeekRet: b = " + z7 + " l = " + j7, new Object[0]);
    }

    public void onStatus(int i7) {
        e3.a.e("MonitorPlayerService onStatus : %s", Integer.valueOf(i7));
        f fVar = this.f32141j;
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
                s();
                break;
            case 6:
                fVar.a(i.STATE_PAUSE);
                break;
            case 7:
                fVar.a(i.STATE_STOP);
                t();
                break;
            case 8:
                fVar.a(i.STATE_SEEKING);
                break;
        }
    }

    public void onTime(long j7) {
        e3.a.e("MonitorPlaybackService onTime: time = " + j7, new Object[0]);
        f fVar = this.f32141j;
        if (fVar != null) {
            fVar.a(j7);
        }
    }

    public void onViewerNumberChanged(byte b8) {
        e3.a.e("MonitorPlaybackService onViewerNumberChanged: ", new Object[0]);
    }

    private void c(long j7) {
        this.f32139h = com.haier.library.common.thread.m.scheduleWithFixedDelayToFuture(new Runnable() { // from class: com.haier.uhome.video.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f32206a.v();
            }
        }, j7, j7, TimeUnit.HOURS);
    }

    @Override // com.haier.uhome.video.b
    public int f() {
        return this.f32132a.getAvBytesPerSec();
    }

    @Override // com.haier.uhome.video.b
    public VideoDefinition g() {
        return this.f32145n;
    }

    @Override // com.haier.uhome.video.b
    public boolean h() {
        return this.f32132a.isRecording();
    }

    @Override // com.haier.uhome.video.b
    public void i() {
        this.f32132a.stopRecord();
    }

    @Override // com.haier.uhome.video.c
    public void j() {
        this.f32132a.prepare();
    }

    @Override // com.haier.uhome.video.c
    public void b(long j7, MessagePlaybackNode messagePlaybackNode) {
        this.f32132a.setDataResource(this.f32136e, j7, new PlaybackMessage.PlaybackNode(messagePlaybackNode.startTime, messagePlaybackNode.endTime, messagePlaybackNode.recordType));
    }

    @Override // com.haier.uhome.video.c
    public void a(long j7, long j8, int i7, int i8, String str, final MonitorPlaybackListener<MonitorPlaybackMessage> monitorPlaybackListener) {
        PlaybackPlayer.getPlaybackListV2(this.f32136e, j7, j8, i7, i8, str, new IResultListener<PlaybackMessage>() { // from class: com.haier.uhome.video.d.1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(PlaybackMessage playbackMessage) {
                MonitorPlaybackMessage monitorPlaybackMessage = new MonitorPlaybackMessage();
                ArrayList<MessagePlaybackNode> arrayList = new ArrayList<>();
                for (PlaybackMessage.PlaybackNode playbackNode : playbackMessage.playbackList) {
                    MessagePlaybackNode messagePlaybackNode = new MessagePlaybackNode();
                    messagePlaybackNode.setStartTime(playbackNode.startTime);
                    messagePlaybackNode.setEndTime(playbackNode.endTime);
                    messagePlaybackNode.setRecordType(playbackNode.recordType);
                    arrayList.add(messagePlaybackNode);
                }
                monitorPlaybackMessage.setCurrentPage(playbackMessage.currentPage);
                monitorPlaybackMessage.setPageCount(playbackMessage.pageCount);
                monitorPlaybackMessage.setPlaybackList(arrayList);
                MonitorPlaybackListener monitorPlaybackListener2 = monitorPlaybackListener;
                if (monitorPlaybackListener2 != null) {
                    monitorPlaybackListener2.onSuccess(monitorPlaybackMessage);
                }
            }

            public void onError(int i9, String str2) {
                if (monitorPlaybackListener != null) {
                    uSDKError usdkerrorA = com.haier.uhome.video.a.a.a(i9);
                    HashMap<String, String> map = new HashMap<>(2);
                    map.put("monitor_error_code", String.valueOf(i9));
                    map.put("monitor_error_msg", str2);
                    usdkerrorA.a(map);
                    monitorPlaybackListener.onError(usdkerrorA);
                }
            }

            public void onStart() {
                MonitorPlaybackListener monitorPlaybackListener2 = monitorPlaybackListener;
                if (monitorPlaybackListener2 != null) {
                    monitorPlaybackListener2.onStart();
                }
            }
        });
    }

    @Override // com.haier.uhome.video.c
    public void b(long j7, long j8, int i7, int i8, final MonitorPlaybackListener<List<MonitorPhotoListBean>> monitorPlaybackListener) {
        IoTVideoSdk.getMessageMgr().sendDataToDeviceWithResponse(this.f32136e, ("{\"type\":\"getPhotoList\",\"startTime\":" + j7 + ",\"endTime\":" + j8 + ",\"id\":" + i7 + ",\"count\":" + i8 + com.alipay.sdk.util.j.f13808d).getBytes(), new IResultListener<DataMessage>() { // from class: com.haier.uhome.video.d.8
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(DataMessage dataMessage) {
                String str;
                try {
                    str = new String(dataMessage.data, "utf-8");
                } catch (UnsupportedEncodingException e8) {
                    e8.printStackTrace();
                    str = null;
                }
                List<PhotoListBean> listO = com.haier.library.json.a.o(str, PhotoListBean.class);
                ArrayList arrayList = new ArrayList();
                for (PhotoListBean photoListBean : listO) {
                    MonitorPhotoListBean monitorPhotoListBean = new MonitorPhotoListBean();
                    monitorPhotoListBean.setId(photoListBean.getId());
                    monitorPhotoListBean.setDescribe(photoListBean.getDescribe());
                    monitorPhotoListBean.setName(photoListBean.getName());
                    monitorPhotoListBean.setTime(photoListBean.getTime());
                    monitorPhotoListBean.setThumbnail(photoListBean.getThumbnail());
                    monitorPhotoListBean.setType(d.this.a(photoListBean.getType()));
                    arrayList.add(monitorPhotoListBean);
                }
                MonitorPlaybackListener monitorPlaybackListener2 = monitorPlaybackListener;
                if (monitorPlaybackListener2 != null) {
                    monitorPlaybackListener2.onSuccess(arrayList);
                }
            }

            public void onError(int i9, String str) {
                if (monitorPlaybackListener != null) {
                    uSDKError usdkerrorA = com.haier.uhome.video.a.a.a(i9);
                    HashMap<String, String> map = new HashMap<>(2);
                    map.put("monitor_error_code", String.valueOf(i9));
                    map.put("monitor_error_msg", str);
                    usdkerrorA.a(map);
                    monitorPlaybackListener.onError(usdkerrorA);
                }
            }

            public void onStart() {
                MonitorPlaybackListener monitorPlaybackListener2 = monitorPlaybackListener;
                if (monitorPlaybackListener2 != null) {
                    monitorPlaybackListener2.onStart();
                }
            }
        });
    }

    @Override // com.haier.uhome.video.c
    public void a(long j7, long j8, int i7, int i8, final MonitorPlaybackListener<MonitorPlaybackExistDateMessage> monitorPlaybackListener) {
        PlaybackPlayer.getExistRecordDateList(this.f32136e, j7, j8, i7, i8, new IResultListener<PlaybackExistDateMessage>() { // from class: com.haier.uhome.video.d.5
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(PlaybackExistDateMessage playbackExistDateMessage) {
                MonitorPlaybackExistDateMessage monitorPlaybackExistDateMessage = new MonitorPlaybackExistDateMessage();
                ArrayList<MonitorDateListNode> arrayList = new ArrayList<>();
                for (PlaybackExistDateMessage.DateListNode dateListNode : playbackExistDateMessage.playbackList) {
                    MonitorDateListNode monitorDateListNode = new MonitorDateListNode();
                    monitorDateListNode.setDateTime(dateListNode.dateTime);
                    arrayList.add(monitorDateListNode);
                }
                monitorPlaybackExistDateMessage.setCurrentPage(playbackExistDateMessage.currentPage);
                monitorPlaybackExistDateMessage.setPageCount(playbackExistDateMessage.pageCount);
                monitorPlaybackExistDateMessage.setPlaybackList(arrayList);
                MonitorPlaybackListener monitorPlaybackListener2 = monitorPlaybackListener;
                if (monitorPlaybackListener2 != null) {
                    monitorPlaybackListener2.onSuccess(monitorPlaybackExistDateMessage);
                }
            }

            public void onError(int i9, String str) {
                if (monitorPlaybackListener != null) {
                    uSDKError usdkerrorA = com.haier.uhome.video.a.a.a(i9);
                    HashMap<String, String> map = new HashMap<>(2);
                    map.put("monitor_error_code", String.valueOf(i9));
                    map.put("monitor_error_msg", str);
                    usdkerrorA.a(map);
                    monitorPlaybackListener.onError(usdkerrorA);
                }
            }

            public void onStart() {
                MonitorPlaybackListener monitorPlaybackListener2 = monitorPlaybackListener;
                if (monitorPlaybackListener2 != null) {
                    monitorPlaybackListener2.onStart();
                }
            }
        });
    }

    @Override // com.haier.uhome.video.c
    public void a(long j7, MessagePlaybackNode messagePlaybackNode) {
        if (messagePlaybackNode != null) {
            this.f32132a.seek(j7, new PlaybackMessage.PlaybackNode(messagePlaybackNode.getStartTime(), messagePlaybackNode.getEndTime(), messagePlaybackNode.recordType));
        } else {
            ICallback<Void> iCallback = this.f32135d;
            if (iCallback != null) {
                iCallback.onFailure(ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            }
        }
    }

    @Override // com.haier.uhome.video.c
    public void b(long j7, long j8, final MonitorPlaybackListener<PlayAddressBean> monitorPlaybackListener) {
        this.f32133b.getVideoPlayAddressWithDeviceId(this.f32136e, j7, j8, this.f32137f, new SubscriberListener() { // from class: com.haier.uhome.video.d.11
            public void onFail(Throwable th) {
                if (monitorPlaybackListener != null) {
                    uSDKError error = ErrorConst.ERR_USER_FAIL_GET_DATA.toError();
                    HashMap<String, String> map = new HashMap<>(1);
                    map.put("monitor_error_msg", th.toString());
                    error.a(map);
                    monitorPlaybackListener.onError(error);
                }
            }

            public void onStart() {
                MonitorPlaybackListener monitorPlaybackListener2 = monitorPlaybackListener;
                if (monitorPlaybackListener2 != null) {
                    monitorPlaybackListener2.onStart();
                }
            }

            public void onSuccess(com.google.gson.o oVar) {
                if (monitorPlaybackListener != null) {
                    monitorPlaybackListener.onSuccess(((VideoPlayAddressBean) com.haier.library.json.a.z(oVar.toString(), VideoPlayAddressBean.class)).getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j7) {
        long jCurrentTimeMillis = ((j7 - System.currentTimeMillis()) / DateUtils.MILLIS_PER_HOUR) - 1;
        e3.a.e("startUpdateTimer: updateTimeHour : %s", Long.valueOf(jCurrentTimeMillis));
        c(jCurrentTimeMillis);
    }

    @Override // com.haier.uhome.video.b
    public void a(f fVar) {
        this.f32141j = fVar;
    }

    @Override // com.haier.uhome.video.b
    public void a(boolean z7) {
        this.f32132a.mute(z7);
    }

    @Override // com.haier.uhome.video.c
    public void a(int i7, final int i8, final ICallback<byte[]> iCallback) {
        this.f32142k = iCallback;
        final StringBuilder sb = new StringBuilder();
        DeviceImgReqBean deviceImgReqBean = new DeviceImgReqBean();
        deviceImgReqBean.setImgID(i7);
        deviceImgReqBean.setSn(0);
        deviceImgReqBean.setSegmentId(0);
        deviceImgReqBean.setSegmentLenMax(8192);
        final byte[] bArrA = com.haier.uhome.video.a.b.a(deviceImgReqBean);
        this.f32134c.setDataResource(this.f32136e);
        this.f32134c.setPreparedListener(new IPreparedListener() { // from class: com.haier.uhome.video.m
            public final void a() {
                d.w();
            }
        });
        this.f32134c.setStatusListener(new IStatusListener() { // from class: com.haier.uhome.video.n
            public final void a(int i9) {
                this.f32210a.a(bArrA, i8, i9);
            }
        });
        this.f32134c.setErrorListener(new IErrorListener() { // from class: com.haier.uhome.video.o
            public final void a(int i9) {
                this.f32213a.a(iCallback, i9);
            }
        });
        this.f32134c.setUserDataListener(new IUserDataListener() { // from class: com.haier.uhome.video.p
            public final void a(byte[] bArr) {
                this.f32215a.a(sb, iCallback, bArr);
            }
        });
        if (this.f32132a.isConnectedDevice()) {
            this.f32134c.sendUserData(bArrA);
            a(i8);
        } else {
            this.f32134c.prepare();
            this.f32134c.play();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(byte[] bArr, int i7, int i8) {
        e3.a.e("getLocalPhotoDataByPhotoId: setStatusListener i = " + i8, new Object[0]);
        if (i8 == 3) {
            this.f32134c.sendUserData(bArr);
            a(i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ICallback iCallback, int i7) {
        e3.a.e("getLocalPhotoDataByPhotoId: setErrorListener i = " + i7, new Object[0]);
        d();
        iCallback.onFailure(com.haier.uhome.video.a.a.a(i7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(StringBuilder sb, ICallback iCallback, byte[] bArr) {
        e3.a.e("getLocalPhotoDataByPhotoId: bytes", new Object[0]);
        d();
        DeviceImgRespBean deviceImgRespBeanB = com.haier.uhome.video.a.b.b(bArr);
        if (deviceImgRespBeanB != null) {
            sb.append(com.haier.uhome.video.a.b.a(deviceImgRespBeanB.getSegment(), true));
            if (deviceImgRespBeanB.segmentNum != deviceImgRespBeanB.segmentId) {
                return;
            }
            iCallback.onSuccess(com.haier.uhome.video.a.b.a(sb.toString()));
            this.f32134c.stop();
            return;
        }
        e3.a.e("getLocalPhotoDataByPhotoId deviceImgRespBean is null", new Object[0]);
    }

    @Override // com.haier.uhome.video.c
    public void a(int i7, final MonitorPlaybackListener<DateBean> monitorPlaybackListener) {
        this.f32133b.getVideoDateListWithDeviceId(this.f32136e, i7, this.f32137f, new SubscriberListener() { // from class: com.haier.uhome.video.d.9
            public void onFail(Throwable th) {
                if (monitorPlaybackListener != null) {
                    uSDKError error = ErrorConst.ERR_USER_FAIL_GET_DATA.toError();
                    HashMap<String, String> map = new HashMap<>(1);
                    map.put("monitor_error_msg", th.toString());
                    error.a(map);
                    monitorPlaybackListener.onError(error);
                }
            }

            public void onStart() {
                MonitorPlaybackListener monitorPlaybackListener2 = monitorPlaybackListener;
                if (monitorPlaybackListener2 != null) {
                    monitorPlaybackListener2.onStart();
                }
            }

            public void onSuccess(com.google.gson.o oVar) {
                if (monitorPlaybackListener != null) {
                    CloudVideoDateBean cloudVideoDateBean = (CloudVideoDateBean) com.haier.library.json.a.z(oVar.toString(), CloudVideoDateBean.class);
                    if (cloudVideoDateBean.getCode() == 0) {
                        monitorPlaybackListener.onSuccess(cloudVideoDateBean.getData());
                    }
                }
            }
        });
    }

    @Override // com.haier.uhome.video.c
    public void a(long j7, long j8, final MonitorPlaybackListener<List<VideoPlayListBean.DataBean>> monitorPlaybackListener) {
        this.f32133b.getVideoPlayListWithDeviceId(this.f32136e, j7, j8, this.f32137f, new SubscriberListener() { // from class: com.haier.uhome.video.d.10
            public void onFail(Throwable th) {
                if (monitorPlaybackListener != null) {
                    uSDKError error = ErrorConst.ERR_USER_FAIL_GET_DATA.toError();
                    HashMap<String, String> map = new HashMap<>(1);
                    map.put("monitor_error_msg", th.toString());
                    error.a(map);
                    monitorPlaybackListener.onError(error);
                }
            }

            public void onStart() {
                MonitorPlaybackListener monitorPlaybackListener2 = monitorPlaybackListener;
                if (monitorPlaybackListener2 != null) {
                    monitorPlaybackListener2.onStart();
                }
            }

            public void onSuccess(com.google.gson.o oVar) {
                if (monitorPlaybackListener != null) {
                    VideoPlayListBean videoPlayListBean = (VideoPlayListBean) com.haier.library.json.a.z(oVar.toString(), VideoPlayListBean.class);
                    if (videoPlayListBean.getCode() == 0) {
                        monitorPlaybackListener.onSuccess(videoPlayListBean.getData());
                    }
                }
            }
        });
    }

    @Override // com.haier.uhome.video.b
    public void a(VideoDefinition videoDefinition, ICallback<Void> iCallback) {
        this.f32145n = videoDefinition;
        if (VideoDefinition.HD.equals(videoDefinition)) {
            this.f32132a.changeDefinition((byte) 2);
        } else if (VideoDefinition.SD.equals(videoDefinition)) {
            this.f32132a.changeDefinition((byte) 1);
        } else {
            this.f32132a.changeDefinition((byte) 0);
        }
    }

    @Override // com.haier.uhome.video.b
    public void a(final String str, final IScreenshotCallback iScreenshotCallback) {
        if (iScreenshotCallback == null) {
            e3.a.e("takeScreenshot iSnapShotListener is null", new Object[0]);
        } else {
            this.f32132a.snapShot(str, new ISnapShotListener() { // from class: com.haier.uhome.video.k
                public final void a(int i7, String str2) {
                    d.a(iScreenshotCallback, str, i7, str2);
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
            e3.a.e("MonitorPlaybackService startRecording Path Incorrect format", new Object[0]);
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
        e3.a.e("MonitorPlaybackService startRecording: path = " + str + " fileName = " + str2, new Object[0]);
        return this.f32132a.startRecord(str, str2, new IRecordListener() { // from class: com.haier.uhome.video.d.12
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

    @Override // com.haier.library.common.util.m
    protected void a() {
        e3.a.e("MonitorPlaybackService timeout", new Object[0]);
        TransmissionConnection transmissionConnection = this.f32134c;
        if (transmissionConnection != null) {
            transmissionConnection.stop();
        }
        ICallback<byte[]> iCallback = this.f32142k;
        if (iCallback != null) {
            iCallback.onFailure(ErrorConst.ERR_USDK_TIMEOUT.toError());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PlayerImageType a(int i7) {
        if (i7 == 0) {
            return PlayerImageType.IMAGE_TYPE_ALARM;
        }
        if (i7 == 1) {
            return PlayerImageType.IMAGE_TYPE_EVENT;
        }
        return PlayerImageType.IMAGE_TYPE_NORAM;
    }
}
