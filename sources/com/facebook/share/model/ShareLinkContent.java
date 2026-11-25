package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public final class ShareLinkContent extends ShareContent<ShareLinkContent, Builder> {
    public static final Parcelable.Creator<ShareLinkContent> CREATOR = new Parcelable.Creator<ShareLinkContent>() { // from class: com.facebook.share.model.ShareLinkContent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareLinkContent createFromParcel(Parcel parcel) {
            return new ShareLinkContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareLinkContent[] newArray(int i7) {
            return new ShareLinkContent[i7];
        }
    };

    @Deprecated
    private final String contentDescription;

    @Deprecated
    private final String contentTitle;

    @Deprecated
    private final Uri imageUrl;
    private final String quote;

    public static final class Builder extends ShareContent.Builder<ShareLinkContent, Builder> {
        static final String TAG = "Builder";

        @Deprecated
        private String contentDescription;

        @Deprecated
        private String contentTitle;

        @Deprecated
        private Uri imageUrl;
        private String quote;

        @Deprecated
        public Builder setContentDescription(@o0 String str) {
            Log.w(TAG, "This method does nothing. ContentDescription is deprecated in Graph API 2.9.");
            return this;
        }

        @Deprecated
        public Builder setContentTitle(@o0 String str) {
            Log.w(TAG, "This method does nothing. ContentTitle is deprecated in Graph API 2.9.");
            return this;
        }

        @Deprecated
        public Builder setImageUrl(@o0 Uri uri) {
            Log.w(TAG, "This method does nothing. ImageUrl is deprecated in Graph API 2.9.");
            return this;
        }

        public Builder setQuote(@o0 String str) {
            this.quote = str;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareLinkContent build() {
            return new ShareLinkContent(this);
        }

        @Override // com.facebook.share.model.ShareContent.Builder, com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(ShareLinkContent shareLinkContent) {
            return shareLinkContent == null ? this : ((Builder) super.readFrom(shareLinkContent)).setContentDescription(shareLinkContent.getContentDescription()).setImageUrl(shareLinkContent.getImageUrl()).setContentTitle(shareLinkContent.getContentTitle()).setQuote(shareLinkContent.getQuote());
        }
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public String getContentDescription() {
        return this.contentDescription;
    }

    @o0
    @Deprecated
    public String getContentTitle() {
        return this.contentTitle;
    }

    @o0
    @Deprecated
    public Uri getImageUrl() {
        return this.imageUrl;
    }

    @o0
    public String getQuote() {
        return this.quote;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        super.writeToParcel(parcel, i7);
        parcel.writeString(this.contentDescription);
        parcel.writeString(this.contentTitle);
        parcel.writeParcelable(this.imageUrl, 0);
        parcel.writeString(this.quote);
    }

    private ShareLinkContent(Builder builder) {
        super(builder);
        this.contentDescription = builder.contentDescription;
        this.contentTitle = builder.contentTitle;
        this.imageUrl = builder.imageUrl;
        this.quote = builder.quote;
    }

    ShareLinkContent(Parcel parcel) {
        super(parcel);
        this.contentDescription = parcel.readString();
        this.contentTitle = parcel.readString();
        this.imageUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.quote = parcel.readString();
    }
}
