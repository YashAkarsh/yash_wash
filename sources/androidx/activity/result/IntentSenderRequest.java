package androidx.activity.result;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class IntentSenderRequest implements Parcelable {

    @m0
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final IntentSender f612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    private final Intent f613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f615d;

    class a implements Parcelable.Creator<IntentSenderRequest> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public IntentSenderRequest createFromParcel(Parcel parcel) {
            return new IntentSenderRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public IntentSenderRequest[] newArray(int i7) {
            return new IntentSenderRequest[i7];
        }
    }

    IntentSenderRequest(@m0 IntentSender intentSender, @o0 Intent intent, int i7, int i8) {
        this.f612a = intentSender;
        this.f613b = intent;
        this.f614c = i7;
        this.f615d = i8;
    }

    @o0
    public Intent a() {
        return this.f613b;
    }

    public int b() {
        return this.f614c;
    }

    public int d() {
        return this.f615d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @m0
    public IntentSender e() {
        return this.f612a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        parcel.writeParcelable(this.f612a, i7);
        parcel.writeParcelable(this.f613b, i7);
        parcel.writeInt(this.f614c);
        parcel.writeInt(this.f615d);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private IntentSender f616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Intent f617b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f618c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f619d;

        public b(@m0 IntentSender intentSender) {
            this.f616a = intentSender;
        }

        @m0
        public IntentSenderRequest a() {
            return new IntentSenderRequest(this.f616a, this.f617b, this.f618c, this.f619d);
        }

        @m0
        public b b(@o0 Intent intent) {
            this.f617b = intent;
            return this;
        }

        @m0
        public b c(int i7, int i8) {
            this.f619d = i7;
            this.f618c = i8;
            return this;
        }

        public b(@m0 PendingIntent pendingIntent) {
            this(pendingIntent.getIntentSender());
        }
    }

    IntentSenderRequest(@m0 Parcel parcel) {
        this.f612a = (IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader());
        this.f613b = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.f614c = parcel.readInt();
        this.f615d = parcel.readInt();
    }
}
