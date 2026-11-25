package com.haier.globalwasher.modle.bean.share.medias;

import com.haier.globalwasher.modle.bean.share.H5ShareJsonbean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseMedia extends H5ShareJsonbean {
    public BaseMedia(H5ShareJsonbean h5ShareJsonbean) {
        setCallBackMethodName(h5ShareJsonbean.getCallBackMethodName());
        setDescription(h5ShareJsonbean.getDescription());
        setImgUrl(h5ShareJsonbean.getImgUrl());
        setMusicJumpUrl(h5ShareJsonbean.getMusicJumpUrl());
        setMusicUrl(h5ShareJsonbean.getMusicUrl());
        setText(h5ShareJsonbean.getText());
        setTitle(h5ShareJsonbean.getTitle());
        setVideoUrl(h5ShareJsonbean.getVideoUrl());
        setZoomIMGUrl(h5ShareJsonbean.getZoomIMGUrl());
        setUrl(h5ShareJsonbean.getUrl());
    }
}
