package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public final class ShareOpenGraphContent extends ShareContent<ShareOpenGraphContent, Builder> {
    public static final Parcelable.Creator<ShareOpenGraphContent> CREATOR = new Parcelable.Creator<ShareOpenGraphContent>() { // from class: com.facebook.share.model.ShareOpenGraphContent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareOpenGraphContent createFromParcel(Parcel parcel) {
            return new ShareOpenGraphContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareOpenGraphContent[] newArray(int i7) {
            return new ShareOpenGraphContent[i7];
        }
    };
    private final ShareOpenGraphAction action;
    private final String previewPropertyName;

    public static final class Builder extends ShareContent.Builder<ShareOpenGraphContent, Builder> {
        private ShareOpenGraphAction action;
        private String previewPropertyName;

        public Builder setAction(@o0 ShareOpenGraphAction shareOpenGraphAction) {
            this.action = shareOpenGraphAction == null ? null : new ShareOpenGraphAction.Builder().readFrom(shareOpenGraphAction).build();
            return this;
        }

        public Builder setPreviewPropertyName(@o0 String str) {
            this.previewPropertyName = str;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareOpenGraphContent build() {
            return new ShareOpenGraphContent(this);
        }

        @Override // com.facebook.share.model.ShareContent.Builder, com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(ShareOpenGraphContent shareOpenGraphContent) {
            return shareOpenGraphContent == null ? this : ((Builder) super.readFrom(shareOpenGraphContent)).setAction(shareOpenGraphContent.getAction()).setPreviewPropertyName(shareOpenGraphContent.getPreviewPropertyName());
        }
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @o0
    public ShareOpenGraphAction getAction() {
        return this.action;
    }

    @o0
    public String getPreviewPropertyName() {
        return this.previewPropertyName;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        super.writeToParcel(parcel, i7);
        parcel.writeParcelable(this.action, 0);
        parcel.writeString(this.previewPropertyName);
    }

    private ShareOpenGraphContent(Builder builder) {
        super(builder);
        this.action = builder.action;
        this.previewPropertyName = builder.previewPropertyName;
    }

    ShareOpenGraphContent(Parcel parcel) {
        super(parcel);
        this.action = new ShareOpenGraphAction.Builder().readFrom(parcel).build();
        this.previewPropertyName = parcel.readString();
    }
}
