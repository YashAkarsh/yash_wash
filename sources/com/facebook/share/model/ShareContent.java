package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import c.o0;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareContent.Builder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class ShareContent<P extends ShareContent, E extends Builder> implements ShareModel {
    private final Uri contentUrl;
    private final ShareHashtag hashtag;
    private final String pageId;
    private final List<String> peopleIds;
    private final String placeId;
    private final String ref;

    public static abstract class Builder<P extends ShareContent, E extends Builder> implements ShareModelBuilder<P, E> {
        private Uri contentUrl;
        private ShareHashtag hashtag;
        private String pageId;
        private List<String> peopleIds;
        private String placeId;
        private String ref;

        public E setContentUrl(@o0 Uri uri) {
            this.contentUrl = uri;
            return this;
        }

        public E setPageId(@o0 String str) {
            this.pageId = str;
            return this;
        }

        public E setPeopleIds(@o0 List<String> list) {
            this.peopleIds = list == null ? null : Collections.unmodifiableList(list);
            return this;
        }

        public E setPlaceId(@o0 String str) {
            this.placeId = str;
            return this;
        }

        public E setRef(@o0 String str) {
            this.ref = str;
            return this;
        }

        public E setShareHashtag(@o0 ShareHashtag shareHashtag) {
            this.hashtag = shareHashtag;
            return this;
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public E readFrom(P p7) {
            return p7 == null ? this : (E) setContentUrl(p7.getContentUrl()).setPeopleIds(p7.getPeopleIds()).setPlaceId(p7.getPlaceId()).setPageId(p7.getPageId()).setRef(p7.getRef()).setShareHashtag(p7.getShareHashtag());
        }
    }

    protected ShareContent(Builder builder) {
        this.contentUrl = builder.contentUrl;
        this.peopleIds = builder.peopleIds;
        this.placeId = builder.placeId;
        this.pageId = builder.pageId;
        this.ref = builder.ref;
        this.hashtag = builder.hashtag;
    }

    private List<String> readUnmodifiableStringList(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        if (arrayList.size() == 0) {
            return null;
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @o0
    public Uri getContentUrl() {
        return this.contentUrl;
    }

    @o0
    public String getPageId() {
        return this.pageId;
    }

    @o0
    public List<String> getPeopleIds() {
        return this.peopleIds;
    }

    @o0
    public String getPlaceId() {
        return this.placeId;
    }

    @o0
    public String getRef() {
        return this.ref;
    }

    @o0
    public ShareHashtag getShareHashtag() {
        return this.hashtag;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeParcelable(this.contentUrl, 0);
        parcel.writeStringList(this.peopleIds);
        parcel.writeString(this.placeId);
        parcel.writeString(this.pageId);
        parcel.writeString(this.ref);
        parcel.writeParcelable(this.hashtag, 0);
    }

    protected ShareContent(Parcel parcel) {
        this.contentUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.peopleIds = readUnmodifiableStringList(parcel);
        this.placeId = parcel.readString();
        this.pageId = parcel.readString();
        this.ref = parcel.readString();
        this.hashtag = new ShareHashtag.Builder().readFrom(parcel).build();
    }
}
