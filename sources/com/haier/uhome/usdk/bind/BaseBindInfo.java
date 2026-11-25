package com.haier.uhome.usdk.bind;

import com.haier.uhome.nfc.service.entity.NFCInfo;
import com.haier.uhome.usdk.base.annotation.Keep;
import com.haier.uhome.usdk.bind.BaseBindInfo.a;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public abstract class BaseBindInfo<B extends a> extends l<B> {
    protected NFCInfo nfcInfo;

    public static abstract class a<B extends a, I extends BaseBindInfo> extends l.a<B, I> {
        NFCInfo nfcInfo;

        protected a() {
        }

        @Keep
        public B nfcInfo(NFCInfo nFCInfo) {
            this.nfcInfo = nFCInfo;
            return this;
        }

        protected a(I i7) {
            super(i7);
            this.nfcInfo = i7.getNFCInfo();
        }
    }

    protected BaseBindInfo(B b8) {
        super(b8.mCsNode, b8.mTimeout);
        this.nfcInfo = b8.nfcInfo;
    }

    @Keep
    public NFCInfo getNFCInfo() {
        return this.nfcInfo;
    }
}
