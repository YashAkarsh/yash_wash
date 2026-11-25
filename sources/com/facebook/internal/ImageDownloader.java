package com.facebook.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.facebook.FacebookException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ImageDownloader {
    private static final int CACHE_READ_QUEUE_MAX_CONCURRENT = 2;
    private static final int DOWNLOAD_QUEUE_MAX_CONCURRENT = 8;
    private static Handler handler;
    private static WorkQueue downloadQueue = new WorkQueue(8);
    private static WorkQueue cacheReadQueue = new WorkQueue(2);
    private static final Map<RequestKey, DownloaderContext> pendingRequests = new HashMap();

    private static class CacheReadWorkItem implements Runnable {
        private boolean allowCachedRedirects;
        private Context context;
        private RequestKey key;

        CacheReadWorkItem(Context context, RequestKey requestKey, boolean z7) {
            this.context = context;
            this.key = requestKey;
            this.allowCachedRedirects = z7;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageDownloader.readFromCache(this.key, this.context, this.allowCachedRedirects);
        }
    }

    private static class DownloadImageWorkItem implements Runnable {
        private Context context;
        private RequestKey key;

        DownloadImageWorkItem(Context context, RequestKey requestKey) {
            this.context = context;
            this.key = requestKey;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            ImageDownloader.download(this.key, this.context);
        }
    }

    private static class DownloaderContext {
        boolean isCancelled;
        ImageRequest request;
        WorkQueue.WorkItem workItem;

        private DownloaderContext() {
        }
    }

    private static class RequestKey {
        private static final int HASH_MULTIPLIER = 37;
        private static final int HASH_SEED = 29;
        Object tag;
        Uri uri;

        RequestKey(Uri uri, Object obj) {
            this.uri = uri;
            this.tag = obj;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof RequestKey)) {
                return false;
            }
            RequestKey requestKey = (RequestKey) obj;
            return requestKey.uri == this.uri && requestKey.tag == this.tag;
        }

        public int hashCode() {
            return ((1073 + this.uri.hashCode()) * 37) + this.tag.hashCode();
        }
    }

    public static boolean cancelRequest(ImageRequest imageRequest) {
        boolean z7;
        RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
        Map<RequestKey, DownloaderContext> map = pendingRequests;
        synchronized (map) {
            DownloaderContext downloaderContext = map.get(requestKey);
            if (downloaderContext != null) {
                z7 = true;
                if (downloaderContext.workItem.cancel()) {
                    map.remove(requestKey);
                } else {
                    downloaderContext.isCancelled = true;
                }
            } else {
                z7 = false;
            }
        }
        return z7;
    }

    public static void clearCache(Context context) {
        ImageResponseCache.clearCache(context);
        UrlRedirectCache.clearCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:52:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public static void download(RequestKey requestKey, Context context) throws Throwable {
        HttpURLConnection httpURLConnection;
        Exception facebookException;
        InputStream inputStreamInterceptAndCacheImageStream;
        Bitmap bitmapDecodeStream;
        ?? r7 = 0;
        InputStream inputStream = null;
        r7 = 0;
        Bitmap bitmap = null;
        boolean z7 = true;
        try {
            httpURLConnection = (HttpURLConnection) new URL(requestKey.uri.toString()).openConnection();
            try {
                try {
                    httpURLConnection.setInstanceFollowRedirects(false);
                    int responseCode = httpURLConnection.getResponseCode();
                    try {
                        if (responseCode != 200) {
                            if (responseCode == 301 || responseCode == 302) {
                                try {
                                    String headerField = httpURLConnection.getHeaderField("location");
                                    if (!Utility.isNullOrEmpty(headerField)) {
                                        Uri uri = Uri.parse(headerField);
                                        UrlRedirectCache.cacheUriRedirect(requestKey.uri, uri);
                                        DownloaderContext downloaderContextRemovePendingRequest = removePendingRequest(requestKey);
                                        if (downloaderContextRemovePendingRequest != null && !downloaderContextRemovePendingRequest.isCancelled) {
                                            enqueueCacheRead(downloaderContextRemovePendingRequest.request, new RequestKey(uri, requestKey.tag), false);
                                        }
                                    }
                                    z7 = false;
                                    bitmapDecodeStream = null;
                                    facebookException = null;
                                } catch (IOException e8) {
                                    e = e8;
                                    z7 = false;
                                    context = 0;
                                    Utility.closeQuietly(context);
                                    Utility.disconnectQuietly(httpURLConnection);
                                    facebookException = e;
                                }
                            } else {
                                inputStreamInterceptAndCacheImageStream = httpURLConnection.getErrorStream();
                                StringBuilder sb = new StringBuilder();
                                if (inputStreamInterceptAndCacheImageStream != null) {
                                    InputStreamReader inputStreamReader = new InputStreamReader(inputStreamInterceptAndCacheImageStream);
                                    char[] cArr = new char[128];
                                    while (true) {
                                        int i7 = inputStreamReader.read(cArr, 0, 128);
                                        if (i7 <= 0) {
                                            break;
                                        } else {
                                            sb.append(cArr, 0, i7);
                                        }
                                    }
                                    Utility.closeQuietly(inputStreamReader);
                                } else {
                                    sb.append("Unexpected error while downloading an image.");
                                }
                                facebookException = new FacebookException(sb.toString());
                                bitmapDecodeStream = null;
                            }
                            Utility.closeQuietly(inputStream);
                            Utility.disconnectQuietly(httpURLConnection);
                            bitmap = bitmapDecodeStream;
                            if (z7) {
                                issueResponse(requestKey, facebookException, bitmap, false);
                            }
                        }
                        inputStreamInterceptAndCacheImageStream = ImageResponseCache.interceptAndCacheImageStream(context, httpURLConnection);
                        bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamInterceptAndCacheImageStream);
                        facebookException = null;
                        inputStream = inputStreamInterceptAndCacheImageStream;
                        Utility.closeQuietly(inputStream);
                        Utility.disconnectQuietly(httpURLConnection);
                        bitmap = bitmapDecodeStream;
                    } catch (IOException e9) {
                        e = e9;
                        Utility.closeQuietly(context);
                        Utility.disconnectQuietly(httpURLConnection);
                        facebookException = e;
                    } catch (Throwable th) {
                        th = th;
                        r7 = context;
                        Utility.closeQuietly(r7);
                        Utility.disconnectQuietly(httpURLConnection);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e10) {
                e = e10;
            }
        } catch (IOException e11) {
            e = e11;
            context = 0;
            httpURLConnection = null;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
        }
        if (z7) {
            issueResponse(requestKey, facebookException, bitmap, false);
        }
    }

    public static void downloadAsync(ImageRequest imageRequest) {
        if (imageRequest == null) {
            return;
        }
        RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
        Map<RequestKey, DownloaderContext> map = pendingRequests;
        synchronized (map) {
            DownloaderContext downloaderContext = map.get(requestKey);
            if (downloaderContext != null) {
                downloaderContext.request = imageRequest;
                downloaderContext.isCancelled = false;
                downloaderContext.workItem.moveToFront();
            } else {
                enqueueCacheRead(imageRequest, requestKey, imageRequest.isCachedRedirectAllowed());
            }
        }
    }

    private static void enqueueCacheRead(ImageRequest imageRequest, RequestKey requestKey, boolean z7) {
        enqueueRequest(imageRequest, requestKey, cacheReadQueue, new CacheReadWorkItem(imageRequest.getContext(), requestKey, z7));
    }

    private static void enqueueDownload(ImageRequest imageRequest, RequestKey requestKey) {
        enqueueRequest(imageRequest, requestKey, downloadQueue, new DownloadImageWorkItem(imageRequest.getContext(), requestKey));
    }

    private static void enqueueRequest(ImageRequest imageRequest, RequestKey requestKey, WorkQueue workQueue, Runnable runnable) {
        Map<RequestKey, DownloaderContext> map = pendingRequests;
        synchronized (map) {
            DownloaderContext downloaderContext = new DownloaderContext();
            downloaderContext.request = imageRequest;
            map.put(requestKey, downloaderContext);
            downloaderContext.workItem = workQueue.addActiveWorkItem(runnable);
        }
    }

    private static synchronized Handler getHandler() {
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        return handler;
    }

    private static void issueResponse(RequestKey requestKey, final Exception exc, final Bitmap bitmap, final boolean z7) {
        final ImageRequest imageRequest;
        final ImageRequest.Callback callback;
        DownloaderContext downloaderContextRemovePendingRequest = removePendingRequest(requestKey);
        if (downloaderContextRemovePendingRequest == null || downloaderContextRemovePendingRequest.isCancelled || (callback = (imageRequest = downloaderContextRemovePendingRequest.request).getCallback()) == null) {
            return;
        }
        getHandler().post(new Runnable() { // from class: com.facebook.internal.ImageDownloader.1
            @Override // java.lang.Runnable
            public void run() {
                callback.onCompleted(new ImageResponse(imageRequest, exc, z7, bitmap));
            }
        });
    }

    public static void prioritizeRequest(ImageRequest imageRequest) {
        RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
        Map<RequestKey, DownloaderContext> map = pendingRequests;
        synchronized (map) {
            DownloaderContext downloaderContext = map.get(requestKey);
            if (downloaderContext != null) {
                downloaderContext.workItem.moveToFront();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readFromCache(RequestKey requestKey, Context context, boolean z7) {
        InputStream cachedImageStream;
        Uri redirectedUri;
        boolean z8 = false;
        if (!z7 || (redirectedUri = UrlRedirectCache.getRedirectedUri(requestKey.uri)) == null) {
            cachedImageStream = null;
        } else {
            cachedImageStream = ImageResponseCache.getCachedImageStream(redirectedUri, context);
            if (cachedImageStream != null) {
                z8 = true;
            }
        }
        if (!z8) {
            cachedImageStream = ImageResponseCache.getCachedImageStream(requestKey.uri, context);
        }
        if (cachedImageStream != null) {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(cachedImageStream);
            Utility.closeQuietly(cachedImageStream);
            issueResponse(requestKey, null, bitmapDecodeStream, z8);
        } else {
            DownloaderContext downloaderContextRemovePendingRequest = removePendingRequest(requestKey);
            if (downloaderContextRemovePendingRequest == null || downloaderContextRemovePendingRequest.isCancelled) {
                return;
            }
            enqueueDownload(downloaderContextRemovePendingRequest.request, requestKey);
        }
    }

    private static DownloaderContext removePendingRequest(RequestKey requestKey) {
        DownloaderContext downloaderContextRemove;
        Map<RequestKey, DownloaderContext> map = pendingRequests;
        synchronized (map) {
            downloaderContextRemove = map.remove(requestKey);
        }
        return downloaderContextRemove;
    }
}
