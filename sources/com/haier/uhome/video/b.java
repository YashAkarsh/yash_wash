package com.haier.uhome.video;

import com.haier.uhome.usdk.base.api.ICallback;

/* JADX INFO: loaded from: classes2.dex */
public interface b {
    void a(VideoDefinition videoDefinition, ICallback<Void> iCallback);

    void a(f fVar);

    void a(String str, IScreenshotCallback iScreenshotCallback);

    void a(boolean z7);

    boolean a(String str, IRecordingCallback iRecordingCallback);

    int f();

    VideoDefinition g();

    boolean h();

    void i();

    boolean k_();

    void l_();

    void m_();

    void n_();
}
