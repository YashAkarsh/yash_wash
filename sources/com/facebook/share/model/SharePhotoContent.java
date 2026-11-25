package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import c.o0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class SharePhotoContent extends ShareContent<SharePhotoContent, Builder> {
    public static final Parcelable.Creator<SharePhotoContent> CREATOR = new Parcelable.Creator<SharePhotoContent>() { // from class: com.facebook.share.model.SharePhotoContent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SharePhotoContent createFromParcel(Parcel parcel) {
            return new SharePhotoContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SharePhotoContent[] newArray(int i7) {
            return new SharePhotoContent[i7];
        }
    };
    private final List<SharePhoto> photos;

    public static class Builder extends ShareContent.Builder<SharePhotoContent, Builder> {
        private final List<SharePhoto> photos = new ArrayList();

        public Builder addPhoto(@o0 SharePhoto sharePhoto) {
            if (sharePhoto != null) {
                this.photos.add(new SharePhoto.Builder().readFrom(sharePhoto).build());
            }
            return this;
        }

        public Builder addPhotos(@o0 List<SharePhoto> list) {
            if (list != null) {
                Iterator<SharePhoto> it = list.iterator();
                while (it.hasNext()) {
                    addPhoto(it.next());
                }
            }
            return this;
        }

        public Builder setPhotos(@o0 List<SharePhoto> list) {
            this.photos.clear();
            addPhotos(list);
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public SharePhotoContent build() {
            return new SharePhotoContent(this);
        }

        @Override // com.facebook.share.model.ShareContent.Builder, com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(SharePhotoContent sharePhotoContent) {
            return sharePhotoContent == null ? this : ((Builder) super.readFrom(sharePhotoContent)).addPhotos(sharePhotoContent.getPhotos());
        }
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @o0
    public List<SharePhoto> getPhotos() {
        return this.photos;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        super.writeToParcel(parcel, i7);
        SharePhoto.Builder.writePhotoListTo(parcel, i7, this.photos);
    }

    private SharePhotoContent(Builder builder) {
        super(builder);
        this.photos = Collections.unmodifiableList(builder.photos);
    }

    SharePhotoContent(Parcel parcel) {
        super(parcel);
        this.photos = Collections.unmodifiableList(SharePhoto.Builder.readPhotoListFrom(parcel));
    }
}
