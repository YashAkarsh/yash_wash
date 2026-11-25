package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import c.o0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ShareMediaContent extends ShareContent<ShareMediaContent, Builder> {
    public static final Parcelable.Creator<ShareMediaContent> CREATOR = new Parcelable.Creator<ShareMediaContent>() { // from class: com.facebook.share.model.ShareMediaContent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareMediaContent createFromParcel(Parcel parcel) {
            return new ShareMediaContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareMediaContent[] newArray(int i7) {
            return new ShareMediaContent[i7];
        }
    };
    private final List<ShareMedia> media;

    public static class Builder extends ShareContent.Builder<ShareMediaContent, Builder> {
        private final List<ShareMedia> media = new ArrayList();

        public Builder addMedia(@o0 List<ShareMedia> list) {
            if (list != null) {
                Iterator<ShareMedia> it = list.iterator();
                while (it.hasNext()) {
                    addMedium(it.next());
                }
            }
            return this;
        }

        public Builder addMedium(@o0 ShareMedia shareMedia) {
            ShareMedia shareMediaBuild;
            if (shareMedia != null) {
                if (shareMedia instanceof SharePhoto) {
                    shareMediaBuild = new SharePhoto.Builder().readFrom((SharePhoto) shareMedia).build();
                } else {
                    if (!(shareMedia instanceof ShareVideo)) {
                        throw new IllegalArgumentException("medium must be either a SharePhoto or ShareVideo");
                    }
                    shareMediaBuild = new ShareVideo.Builder().readFrom((ShareVideo) shareMedia).build();
                }
                this.media.add(shareMediaBuild);
            }
            return this;
        }

        public Builder setMedia(@o0 List<ShareMedia> list) {
            this.media.clear();
            addMedia(list);
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareMediaContent build() {
            return new ShareMediaContent(this);
        }

        @Override // com.facebook.share.model.ShareContent.Builder, com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(ShareMediaContent shareMediaContent) {
            return shareMediaContent == null ? this : ((Builder) super.readFrom(shareMediaContent)).addMedia(shareMediaContent.getMedia());
        }
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @o0
    public List<ShareMedia> getMedia() {
        return this.media;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        super.writeToParcel(parcel, i7);
        parcel.writeParcelableArray((ShareMedia[]) this.media.toArray(), i7);
    }

    private ShareMediaContent(Builder builder) {
        super(builder);
        this.media = Collections.unmodifiableList(builder.media);
    }

    ShareMediaContent(Parcel parcel) {
        super(parcel);
        this.media = Arrays.asList((ShareMedia[]) parcel.readParcelableArray(ShareMedia.class.getClassLoader()));
    }
}
