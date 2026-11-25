package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.util.Log;
import c.m0;
import c.o0;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.u;
import com.google.android.gms.common.internal.y;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "BitmapTeleporterCreator")
@c1.a
@y
public class BitmapTeleporter extends AbstractSafeParcelable implements ReflectedParcelable {

    @c1.a
    @m0
    public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new m();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.g(id = 1)
    final int f15531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    @SafeParcelable.c(id = 2)
    ParcelFileDescriptor f15532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(id = 3)
    final int f15533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @o0
    private Bitmap f15534d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f15535e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private File f15536f;

    @SafeParcelable.b
    BitmapTeleporter(@SafeParcelable.e(id = 1) int i7, @SafeParcelable.e(id = 2) ParcelFileDescriptor parcelFileDescriptor, @SafeParcelable.e(id = 3) int i8) {
        this.f15531a = i7;
        this.f15532b = parcelFileDescriptor;
        this.f15533c = i8;
        this.f15534d = null;
        this.f15535e = false;
    }

    private static final void p0(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e8) {
            Log.w("BitmapTeleporter", "Could not close stream", e8);
        }
    }

    @o0
    @c1.a
    public Bitmap K() {
        if (!this.f15535e) {
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream((ParcelFileDescriptor) u.k(this.f15532b)));
            try {
                try {
                    byte[] bArr = new byte[dataInputStream.readInt()];
                    int i7 = dataInputStream.readInt();
                    int i8 = dataInputStream.readInt();
                    Bitmap.Config configValueOf = Bitmap.Config.valueOf(dataInputStream.readUTF());
                    dataInputStream.read(bArr);
                    p0(dataInputStream);
                    ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i7, i8, configValueOf);
                    bitmapCreateBitmap.copyPixelsFromBuffer(byteBufferWrap);
                    this.f15534d = bitmapCreateBitmap;
                    this.f15535e = true;
                } catch (IOException e8) {
                    throw new IllegalStateException("Could not read from parcel file descriptor", e8);
                }
            } catch (Throwable th) {
                p0(dataInputStream);
                throw th;
            }
        }
        return this.f15534d;
    }

    @c1.a
    public void Q(@m0 File file) {
        if (file == null) {
            throw new NullPointerException("Cannot set null temp directory");
        }
        this.f15536f = file;
    }

    @c1.a
    public void i() {
        if (this.f15535e) {
            return;
        }
        try {
            ((ParcelFileDescriptor) u.k(this.f15532b)).close();
        } catch (IOException e8) {
            Log.w("BitmapTeleporter", "Could not close PFD", e8);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@m0 Parcel parcel, int i7) {
        if (this.f15532b == null) {
            Bitmap bitmap = (Bitmap) u.k(this.f15534d);
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bitmap.getRowBytes() * bitmap.getHeight());
            bitmap.copyPixelsToBuffer(byteBufferAllocate);
            byte[] bArrArray = byteBufferAllocate.array();
            File file = this.f15536f;
            if (file == null) {
                throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
            }
            try {
                File fileCreateTempFile = File.createTempFile("teleporter", ".tmp", file);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                    this.f15532b = ParcelFileDescriptor.open(fileCreateTempFile, 268435456);
                    fileCreateTempFile.delete();
                    DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(fileOutputStream));
                    try {
                        try {
                            dataOutputStream.writeInt(bArrArray.length);
                            dataOutputStream.writeInt(bitmap.getWidth());
                            dataOutputStream.writeInt(bitmap.getHeight());
                            dataOutputStream.writeUTF(bitmap.getConfig().toString());
                            dataOutputStream.write(bArrArray);
                            p0(dataOutputStream);
                        } catch (IOException e8) {
                            throw new IllegalStateException("Could not write into unlinked file", e8);
                        }
                    } catch (Throwable th) {
                        p0(dataOutputStream);
                        throw th;
                    }
                } catch (FileNotFoundException unused) {
                    throw new IllegalStateException("Temporary file is somehow already deleted");
                }
            } catch (IOException e9) {
                throw new IllegalStateException("Could not create temporary file", e9);
            }
        }
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, this.f15531a);
        e1.b.S(parcel, 2, this.f15532b, i7 | 1, false);
        e1.b.F(parcel, 3, this.f15533c);
        e1.b.b(parcel, iA);
        this.f15532b = null;
    }

    @c1.a
    public BitmapTeleporter(@m0 Bitmap bitmap) {
        this.f15531a = 1;
        this.f15532b = null;
        this.f15533c = 0;
        this.f15534d = bitmap;
        this.f15535e = true;
    }
}
