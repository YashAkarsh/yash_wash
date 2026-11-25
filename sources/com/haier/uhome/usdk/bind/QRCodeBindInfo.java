package com.haier.uhome.usdk.bind;

/* JADX INFO: loaded from: classes2.dex */
public class QRCodeBindInfo extends BaseBindInfo<Builder> {
    private String mQRCode;

    public static final class Builder extends BaseBindInfo.a<Builder, QRCodeBindInfo> {
        private String mQRCode;

        public Builder code(String str) {
            this.mQRCode = str;
            return this;
        }

        public Builder() {
            this.mQRCode = null;
        }

        @Override // com.haier.uhome.usdk.bind.l.a
        public QRCodeBindInfo build() {
            return new QRCodeBindInfo(this);
        }

        private Builder(QRCodeBindInfo qRCodeBindInfo) {
            super(qRCodeBindInfo);
            this.mQRCode = qRCodeBindInfo.mQRCode;
        }
    }

    public String getQRCode() {
        return this.mQRCode;
    }

    private QRCodeBindInfo(Builder builder) {
        super(builder);
        this.mQRCode = builder.mQRCode;
    }

    @Override // com.haier.uhome.usdk.bind.l
    public Builder rebuild() {
        return new Builder();
    }
}
