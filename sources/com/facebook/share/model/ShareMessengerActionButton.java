package com.facebook.share.model;

import android.os.Parcel;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class ShareMessengerActionButton implements ShareModel {
    private final String title;

    public static abstract class Builder<M extends ShareMessengerActionButton, B extends Builder> implements ShareModelBuilder<M, B> {
        private String title;

        public B setTitle(@o0 String str) {
            this.title = str;
            return this;
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public B readFrom(M m7) {
            return m7 == null ? this : (B) setTitle(m7.getTitle());
        }
    }

    protected ShareMessengerActionButton(Builder builder) {
        this.title = builder.title;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeString(this.title);
    }

    ShareMessengerActionButton(Parcel parcel) {
        this.title = parcel.readString();
    }
}
