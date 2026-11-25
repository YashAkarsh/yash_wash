package com.haier.globalwasher.view.activity.videopage;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.VideoActivityBean;

/* JADX INFO: loaded from: classes2.dex */
public class VedioActivity extends BaseActivity {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private VideoView f25779u;

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.modle.utils.loading.a f25780a;

        a(com.haier.globalwasher.modle.utils.loading.a aVar) {
            this.f25780a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f25780a.a();
            VedioActivity.this.f25779u.stopPlayback();
            VedioActivity.this.f25779u.setOnCompletionListener(null);
            VedioActivity.this.f25779u.setOnPreparedListener(null);
            VedioActivity.this.finish();
        }
    }

    class b implements MediaPlayer.OnPreparedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.modle.utils.loading.a f25782a;

        b(com.haier.globalwasher.modle.utils.loading.a aVar) {
            this.f25782a = aVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            this.f25782a.a();
            mediaPlayer.start();
        }
    }

    public static void h0(BaseActivity baseActivity, VideoActivityBean videoActivityBean) {
        Intent intent = new Intent(baseActivity, (Class<?>) VedioActivity.class);
        intent.putExtra(VideoActivityBean.class.getName(), videoActivityBean);
        baseActivity.startActivity(intent);
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void a() {
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_vedio;
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void d() {
        U(false);
        this.f25779u = (VideoView) findViewById(R.id.vv_videoview);
        ImageView imageView = (ImageView) findViewById(R.id.iv_close);
        com.haier.globalwasher.modle.utils.loading.a aVar = new com.haier.globalwasher.modle.utils.loading.a(this, 1, false);
        aVar.c();
        imageView.setOnClickListener(new a(aVar));
        VideoActivityBean videoActivityBean = (VideoActivityBean) getIntent().getSerializableExtra(VideoActivityBean.class.getName());
        if (videoActivityBean != null) {
            Uri uri = Uri.parse(videoActivityBean.getVedioUrl());
            this.f25779u.setMediaController(new MediaController(this));
            this.f25779u.setVideoURI(uri);
            this.f25779u.setOnPreparedListener(new b(aVar));
        }
    }

    @Override // com.haier.globalwasher.mvp_api.view.a
    public void e() {
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public com.haier.globalwasher.mvp_api.presenter.b f() {
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.haier.globalwasher.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        VideoView videoView = this.f25779u;
        if (videoView == null || videoView.getParent() == null || !(this.f25779u.getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) this.f25779u.getParent()).removeAllViews();
    }
}
