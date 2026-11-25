package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import c.o0;
import c.x0;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class AttributionIdentifiers {
    private static final String ANDROID_ID_COLUMN_NAME = "androidid";
    private static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
    private static final String ATTRIBUTION_ID_CONTENT_PROVIDER = "com.facebook.katana.provider.AttributionIdProvider";
    private static final String ATTRIBUTION_ID_CONTENT_PROVIDER_WAKIZASHI = "com.facebook.wakizashi.provider.AttributionIdProvider";
    private static final int CONNECTION_RESULT_SUCCESS = 0;
    private static final long IDENTIFIER_REFRESH_INTERVAL_MILLIS = 3600000;
    private static final String LIMIT_TRACKING_COLUMN_NAME = "limit_tracking";
    private static final String TAG = "com.facebook.internal.AttributionIdentifiers";
    private static AttributionIdentifiers recentlyFetchedIdentifiers;
    private String androidAdvertiserId;
    private String androidInstallerPackage;
    private String attributionId;
    private long fetchTime;
    private boolean limitTracking;

    private static final class GoogleAdInfo implements IInterface {
        private static final int FIRST_TRANSACTION_CODE = 1;
        private static final int SECOND_TRANSACTION_CODE = 2;
        private IBinder binder;

        GoogleAdInfo(IBinder iBinder) {
            this.binder = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.binder;
        }

        public String getAdvertiserId() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.binder.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        public boolean isTrackingLimited() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                parcelObtain.writeInt(1);
                this.binder.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    private static final class GoogleAdServiceConnection implements ServiceConnection {
        private AtomicBoolean consumed;
        private final BlockingQueue<IBinder> queue;

        private GoogleAdServiceConnection() {
            this.consumed = new AtomicBoolean(false);
            this.queue = new LinkedBlockingDeque();
        }

        public IBinder getBinder() throws InterruptedException {
            if (this.consumed.compareAndSet(true, true)) {
                throw new IllegalStateException("Binder already consumed");
            }
            return this.queue.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder != null) {
                try {
                    this.queue.put(iBinder);
                } catch (InterruptedException unused) {
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    private static AttributionIdentifiers cacheAndReturnIdentifiers(AttributionIdentifiers attributionIdentifiers) {
        attributionIdentifiers.fetchTime = System.currentTimeMillis();
        recentlyFetchedIdentifiers = attributionIdentifiers;
        return attributionIdentifiers;
    }

    private static AttributionIdentifiers getAndroidId(Context context) {
        AttributionIdentifiers androidIdViaReflection = getAndroidIdViaReflection(context);
        if (androidIdViaReflection != null) {
            return androidIdViaReflection;
        }
        AttributionIdentifiers androidIdViaService = getAndroidIdViaService(context);
        return androidIdViaService == null ? new AttributionIdentifiers() : androidIdViaService;
    }

    private static AttributionIdentifiers getAndroidIdViaReflection(Context context) {
        Method methodQuietly;
        Object objInvokeMethodQuietly;
        try {
            if (!isGooglePlayServicesAvailable(context) || (methodQuietly = Utility.getMethodQuietly("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", (Class<?>[]) new Class[]{Context.class})) == null || (objInvokeMethodQuietly = Utility.invokeMethodQuietly(null, methodQuietly, context)) == null) {
                return null;
            }
            Method methodQuietly2 = Utility.getMethodQuietly(objInvokeMethodQuietly.getClass(), "getId", (Class<?>[]) new Class[0]);
            Method methodQuietly3 = Utility.getMethodQuietly(objInvokeMethodQuietly.getClass(), "isLimitAdTrackingEnabled", (Class<?>[]) new Class[0]);
            if (methodQuietly2 != null && methodQuietly3 != null) {
                AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
                attributionIdentifiers.androidAdvertiserId = (String) Utility.invokeMethodQuietly(objInvokeMethodQuietly, methodQuietly2, new Object[0]);
                attributionIdentifiers.limitTracking = ((Boolean) Utility.invokeMethodQuietly(objInvokeMethodQuietly, methodQuietly3, new Object[0])).booleanValue();
                return attributionIdentifiers;
            }
            return null;
        } catch (Exception e8) {
            Utility.logd("android_id", e8);
            return null;
        }
    }

    private static AttributionIdentifiers getAndroidIdViaService(Context context) {
        GoogleAdServiceConnection googleAdServiceConnection = new GoogleAdServiceConnection();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, googleAdServiceConnection, 1)) {
            try {
                GoogleAdInfo googleAdInfo = new GoogleAdInfo(googleAdServiceConnection.getBinder());
                AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
                attributionIdentifiers.androidAdvertiserId = googleAdInfo.getAdvertiserId();
                attributionIdentifiers.limitTracking = googleAdInfo.isTrackingLimited();
                return attributionIdentifiers;
            } catch (Exception e8) {
                Utility.logd("android_id", e8);
                return null;
            } finally {
                context.unbindService(googleAdServiceConnection);
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x006d A[Catch: all -> 0x00d9, Exception -> 0x00db, TryCatch #4 {Exception -> 0x00db, all -> 0x00d9, blocks: (B:3:0x000b, B:5:0x0015, B:7:0x0019, B:10:0x002a, B:12:0x0045, B:14:0x004d, B:21:0x0067, B:23:0x006d, B:25:0x0071, B:27:0x0076, B:17:0x0057, B:19:0x005f, B:48:0x00d1, B:49:0x00d8), top: B:66:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0071 A[Catch: all -> 0x00d9, Exception -> 0x00db, TryCatch #4 {Exception -> 0x00db, all -> 0x00d9, blocks: (B:3:0x000b, B:5:0x0015, B:7:0x0019, B:10:0x002a, B:12:0x0045, B:14:0x004d, B:21:0x0067, B:23:0x006d, B:25:0x0071, B:27:0x0076, B:17:0x0057, B:19:0x005f, B:48:0x00d1, B:49:0x00d8), top: B:66:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0076 A[Catch: all -> 0x00d9, Exception -> 0x00db, TRY_LEAVE, TryCatch #4 {Exception -> 0x00db, all -> 0x00d9, blocks: (B:3:0x000b, B:5:0x0015, B:7:0x0019, B:10:0x002a, B:12:0x0045, B:14:0x004d, B:21:0x0067, B:23:0x006d, B:25:0x0071, B:27:0x0076, B:17:0x0057, B:19:0x005f, B:48:0x00d1, B:49:0x00d8), top: B:66:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0089  */
    /* JADX WARN: Code duplicated, block: B:32:0x008a A[Catch: all -> 0x00c8, Exception -> 0x00cc, TryCatch #5 {Exception -> 0x00cc, all -> 0x00c8, blocks: (B:29:0x0083, B:32:0x008a, B:35:0x00a0, B:37:0x00a6, B:40:0x00be), top: B:65:0x0083 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:61:0x0101  */
    /* JADX WARN: Code duplicated, block: B:65:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @o0
    public static AttributionIdentifiers getAttributionIdentifiers(Context context) {
        Cursor cursor;
        Uri uri;
        Uri uri2;
        String installerPackageName;
        Cursor cursorQuery;
        int columnIndex;
        int columnIndex2;
        AttributionIdentifiers androidId = getAndroidId(context);
        Cursor cursor2 = null;
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new FacebookException("getAttributionIdentifiers cannot be called on the main thread.");
            }
            if (recentlyFetchedIdentifiers != null) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                AttributionIdentifiers attributionIdentifiers = recentlyFetchedIdentifiers;
                if (jCurrentTimeMillis - attributionIdentifiers.fetchTime < 3600000) {
                    return attributionIdentifiers;
                }
            }
            String[] strArr = {ATTRIBUTION_ID_COLUMN_NAME, ANDROID_ID_COLUMN_NAME, LIMIT_TRACKING_COLUMN_NAME};
            ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(ATTRIBUTION_ID_CONTENT_PROVIDER, 0);
            ProviderInfo providerInfoResolveContentProvider2 = context.getPackageManager().resolveContentProvider(ATTRIBUTION_ID_CONTENT_PROVIDER_WAKIZASHI, 0);
            if (providerInfoResolveContentProvider == null || !FacebookSignatureValidator.validateSignature(context, providerInfoResolveContentProvider.packageName)) {
                if (providerInfoResolveContentProvider2 == null || !FacebookSignatureValidator.validateSignature(context, providerInfoResolveContentProvider2.packageName)) {
                    uri = null;
                } else {
                    uri2 = Uri.parse("content://com.facebook.wakizashi.provider.AttributionIdProvider");
                }
                installerPackageName = getInstallerPackageName(context);
                if (installerPackageName != null) {
                    androidId.androidInstallerPackage = installerPackageName;
                }
                if (uri == null) {
                    return cacheAndReturnIdentifiers(androidId);
                }
                cursorQuery = context.getContentResolver().query(uri, strArr, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (!cursorQuery.moveToFirst()) {
                            int columnIndex3 = cursorQuery.getColumnIndex(ATTRIBUTION_ID_COLUMN_NAME);
                            columnIndex = cursorQuery.getColumnIndex(ANDROID_ID_COLUMN_NAME);
                            columnIndex2 = cursorQuery.getColumnIndex(LIMIT_TRACKING_COLUMN_NAME);
                            androidId.attributionId = cursorQuery.getString(columnIndex3);
                            if (columnIndex > 0 && columnIndex2 > 0 && androidId.getAndroidAdvertiserId() == null) {
                                androidId.androidAdvertiserId = cursorQuery.getString(columnIndex);
                                androidId.limitTracking = Boolean.parseBoolean(cursorQuery.getString(columnIndex2));
                            }
                            cursorQuery.close();
                            return cacheAndReturnIdentifiers(androidId);
                        }
                    } catch (Exception e8) {
                        cursor = cursorQuery;
                        e = e8;
                        try {
                            Utility.logd(TAG, "Caught unexpected exception in getAttributionId(): " + e.toString());
                            if (cursor != null) {
                                cursor.close();
                            }
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = cursor;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        cursor2 = cursorQuery;
                        th = th2;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
                AttributionIdentifiers attributionIdentifiersCacheAndReturnIdentifiers = cacheAndReturnIdentifiers(androidId);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return attributionIdentifiersCacheAndReturnIdentifiers;
            }
            uri2 = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
            uri = uri2;
            installerPackageName = getInstallerPackageName(context);
            if (installerPackageName != null) {
                androidId.androidInstallerPackage = installerPackageName;
            }
            if (uri == null) {
                return cacheAndReturnIdentifiers(androidId);
            }
            cursorQuery = context.getContentResolver().query(uri, strArr, null, null, null);
            if (cursorQuery != null) {
                if (!cursorQuery.moveToFirst()) {
                    int columnIndex4 = cursorQuery.getColumnIndex(ATTRIBUTION_ID_COLUMN_NAME);
                    columnIndex = cursorQuery.getColumnIndex(ANDROID_ID_COLUMN_NAME);
                    columnIndex2 = cursorQuery.getColumnIndex(LIMIT_TRACKING_COLUMN_NAME);
                    androidId.attributionId = cursorQuery.getString(columnIndex4);
                    if (columnIndex > 0) {
                        androidId.androidAdvertiserId = cursorQuery.getString(columnIndex);
                        androidId.limitTracking = Boolean.parseBoolean(cursorQuery.getString(columnIndex2));
                    }
                    cursorQuery.close();
                    return cacheAndReturnIdentifiers(androidId);
                }
            }
            AttributionIdentifiers attributionIdentifiersCacheAndReturnIdentifiers2 = cacheAndReturnIdentifiers(androidId);
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return attributionIdentifiersCacheAndReturnIdentifiers2;
        } catch (Exception e9) {
            e = e9;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static AttributionIdentifiers getCachedIdentifiers() {
        return recentlyFetchedIdentifiers;
    }

    @o0
    private static String getInstallerPackageName(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            return packageManager.getInstallerPackageName(context.getPackageName());
        }
        return null;
    }

    private static boolean isGooglePlayServicesAvailable(Context context) {
        Method methodQuietly = Utility.getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", (Class<?>[]) new Class[]{Context.class});
        if (methodQuietly == null) {
            return false;
        }
        Object objInvokeMethodQuietly = Utility.invokeMethodQuietly(null, methodQuietly, context);
        return (objInvokeMethodQuietly instanceof Integer) && ((Integer) objInvokeMethodQuietly).intValue() == 0;
    }

    @x0({x0.a.LIBRARY_GROUP})
    public static boolean isTrackingLimited(Context context) {
        AttributionIdentifiers attributionIdentifiers = getAttributionIdentifiers(context);
        return attributionIdentifiers != null && attributionIdentifiers.isTrackingLimited();
    }

    public String getAndroidAdvertiserId() {
        if (FacebookSdk.isInitialized() && FacebookSdk.getAdvertiserIDCollectionEnabled()) {
            return this.androidAdvertiserId;
        }
        return null;
    }

    public String getAndroidInstallerPackage() {
        return this.androidInstallerPackage;
    }

    public String getAttributionId() {
        return this.attributionId;
    }

    public boolean isTrackingLimited() {
        return this.limitTracking;
    }
}
