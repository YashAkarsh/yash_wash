package org.chromium.base;

import android.content.res.AssetFileDescriptor;
import android.util.Log;
import java.io.IOException;
import org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes3.dex */
@x6.c("base::android")
public class ApkAssets {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f38598a = "ApkAssets";

    @CalledByNative
    public static long[] open(String str) {
        AssetFileDescriptor assetFileDescriptorOpenNonAssetFd = null;
        try {
            try {
                assetFileDescriptorOpenNonAssetFd = o.e().getAssets().openNonAssetFd(str);
                long[] jArr = {assetFileDescriptorOpenNonAssetFd.getParcelFileDescriptor().detachFd(), assetFileDescriptorOpenNonAssetFd.getStartOffset(), assetFileDescriptorOpenNonAssetFd.getLength()};
                try {
                    assetFileDescriptorOpenNonAssetFd.close();
                } catch (IOException e8) {
                    Log.e(f38598a, "Unable to close AssetFileDescriptor", e8);
                }
                return jArr;
            } catch (IOException e9) {
                if (!e9.getMessage().equals("") && !e9.getMessage().equals(str)) {
                    Log.e(f38598a, "Error while loading asset " + str + ": " + e9);
                }
                long[] jArr2 = {-1, -1, -1};
                if (assetFileDescriptorOpenNonAssetFd != null) {
                    try {
                        assetFileDescriptorOpenNonAssetFd.close();
                    } catch (IOException e10) {
                        Log.e(f38598a, "Unable to close AssetFileDescriptor", e10);
                    }
                }
                return jArr2;
            }
        } catch (Throwable th) {
            if (assetFileDescriptorOpenNonAssetFd != null) {
                try {
                    assetFileDescriptorOpenNonAssetFd.close();
                } catch (IOException e11) {
                    Log.e(f38598a, "Unable to close AssetFileDescriptor", e11);
                }
            }
            throw th;
        }
    }
}
