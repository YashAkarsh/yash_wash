package com.haier.uhome.video;

import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.video.api.MonitorPlaybackListener;
import com.haier.uhome.video.bean.DateBean;
import com.haier.uhome.video.bean.MessagePlaybackNode;
import com.haier.uhome.video.bean.MonitorPhotoListBean;
import com.haier.uhome.video.bean.MonitorPlaybackExistDateMessage;
import com.haier.uhome.video.bean.MonitorPlaybackMessage;
import com.haier.uhome.video.bean.PlayAddressBean;
import com.haier.uhome.video.bean.VideoPlayListBean;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface c extends b {
    void a(int i7, int i8, ICallback<byte[]> iCallback);

    void a(int i7, MonitorPlaybackListener<DateBean> monitorPlaybackListener);

    void a(long j7, long j8, int i7, int i8, MonitorPlaybackListener<MonitorPlaybackExistDateMessage> monitorPlaybackListener);

    void a(long j7, long j8, int i7, int i8, String str, MonitorPlaybackListener<MonitorPlaybackMessage> monitorPlaybackListener);

    void a(long j7, long j8, MonitorPlaybackListener<List<VideoPlayListBean.DataBean>> monitorPlaybackListener);

    void a(long j7, MessagePlaybackNode messagePlaybackNode);

    void b(long j7, long j8, int i7, int i8, MonitorPlaybackListener<List<MonitorPhotoListBean>> monitorPlaybackListener);

    void b(long j7, long j8, MonitorPlaybackListener<PlayAddressBean> monitorPlaybackListener);

    void b(long j7, MessagePlaybackNode messagePlaybackNode);

    void j();

    void k();

    boolean l();

    void m();
}
