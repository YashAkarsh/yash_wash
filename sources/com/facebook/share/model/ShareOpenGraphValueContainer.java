package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import c.o0;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.facebook.share.model.ShareOpenGraphValueContainer.Builder;
import java.util.ArrayList;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class ShareOpenGraphValueContainer<P extends ShareOpenGraphValueContainer, E extends Builder> implements ShareModel {
    private final Bundle bundle;

    public static abstract class Builder<P extends ShareOpenGraphValueContainer, E extends Builder> implements ShareModelBuilder<P, E> {
        private Bundle bundle = new Bundle();

        public E putBoolean(String str, boolean z7) {
            this.bundle.putBoolean(str, z7);
            return this;
        }

        public E putBooleanArray(String str, @o0 boolean[] zArr) {
            this.bundle.putBooleanArray(str, zArr);
            return this;
        }

        public E putDouble(String str, double d8) {
            this.bundle.putDouble(str, d8);
            return this;
        }

        public E putDoubleArray(String str, @o0 double[] dArr) {
            this.bundle.putDoubleArray(str, dArr);
            return this;
        }

        public E putInt(String str, int i7) {
            this.bundle.putInt(str, i7);
            return this;
        }

        public E putIntArray(String str, @o0 int[] iArr) {
            this.bundle.putIntArray(str, iArr);
            return this;
        }

        public E putLong(String str, long j7) {
            this.bundle.putLong(str, j7);
            return this;
        }

        public E putLongArray(String str, @o0 long[] jArr) {
            this.bundle.putLongArray(str, jArr);
            return this;
        }

        public E putObject(String str, @o0 ShareOpenGraphObject shareOpenGraphObject) {
            this.bundle.putParcelable(str, shareOpenGraphObject);
            return this;
        }

        public E putObjectArrayList(String str, @o0 ArrayList<ShareOpenGraphObject> arrayList) {
            this.bundle.putParcelableArrayList(str, arrayList);
            return this;
        }

        public E putPhoto(String str, @o0 SharePhoto sharePhoto) {
            this.bundle.putParcelable(str, sharePhoto);
            return this;
        }

        public E putPhotoArrayList(String str, @o0 ArrayList<SharePhoto> arrayList) {
            this.bundle.putParcelableArrayList(str, arrayList);
            return this;
        }

        public E putString(String str, @o0 String str2) {
            this.bundle.putString(str, str2);
            return this;
        }

        public E putStringArrayList(String str, @o0 ArrayList<String> arrayList) {
            this.bundle.putStringArrayList(str, arrayList);
            return this;
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public E readFrom(P p7) {
            if (p7 != null) {
                this.bundle.putAll(p7.getBundle());
            }
            return this;
        }
    }

    protected ShareOpenGraphValueContainer(Builder<P, E> builder) {
        this.bundle = (Bundle) ((Builder) builder).bundle.clone();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @o0
    public Object get(String str) {
        return this.bundle.get(str);
    }

    public boolean getBoolean(String str, boolean z7) {
        return this.bundle.getBoolean(str, z7);
    }

    @o0
    public boolean[] getBooleanArray(String str) {
        return this.bundle.getBooleanArray(str);
    }

    public Bundle getBundle() {
        return (Bundle) this.bundle.clone();
    }

    public double getDouble(String str, double d8) {
        return this.bundle.getDouble(str, d8);
    }

    @o0
    public double[] getDoubleArray(String str) {
        return this.bundle.getDoubleArray(str);
    }

    public int getInt(String str, int i7) {
        return this.bundle.getInt(str, i7);
    }

    @o0
    public int[] getIntArray(String str) {
        return this.bundle.getIntArray(str);
    }

    public long getLong(String str, long j7) {
        return this.bundle.getLong(str, j7);
    }

    @o0
    public long[] getLongArray(String str) {
        return this.bundle.getLongArray(str);
    }

    public ShareOpenGraphObject getObject(String str) {
        Object obj = this.bundle.get(str);
        if (obj instanceof ShareOpenGraphObject) {
            return (ShareOpenGraphObject) obj;
        }
        return null;
    }

    @o0
    public ArrayList<ShareOpenGraphObject> getObjectArrayList(String str) {
        ArrayList<Parcelable> parcelableArrayList = this.bundle.getParcelableArrayList(str);
        if (parcelableArrayList == null) {
            return null;
        }
        ArrayList<ShareOpenGraphObject> arrayList = new ArrayList<>();
        for (Parcelable parcelable : parcelableArrayList) {
            if (parcelable instanceof ShareOpenGraphObject) {
                arrayList.add((ShareOpenGraphObject) parcelable);
            }
        }
        return arrayList;
    }

    @o0
    public SharePhoto getPhoto(String str) {
        Parcelable parcelable = this.bundle.getParcelable(str);
        if (parcelable instanceof SharePhoto) {
            return (SharePhoto) parcelable;
        }
        return null;
    }

    @o0
    public ArrayList<SharePhoto> getPhotoArrayList(String str) {
        ArrayList<Parcelable> parcelableArrayList = this.bundle.getParcelableArrayList(str);
        if (parcelableArrayList == null) {
            return null;
        }
        ArrayList<SharePhoto> arrayList = new ArrayList<>();
        for (Parcelable parcelable : parcelableArrayList) {
            if (parcelable instanceof SharePhoto) {
                arrayList.add((SharePhoto) parcelable);
            }
        }
        return arrayList;
    }

    @o0
    public String getString(String str) {
        return this.bundle.getString(str);
    }

    @o0
    public ArrayList<String> getStringArrayList(String str) {
        return this.bundle.getStringArrayList(str);
    }

    public Set<String> keySet() {
        return this.bundle.keySet();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeBundle(this.bundle);
    }

    ShareOpenGraphValueContainer(Parcel parcel) {
        this.bundle = parcel.readBundle(Builder.class.getClassLoader());
    }
}
