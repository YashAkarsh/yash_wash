package com.haier.globalwasher.modle.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.util.Log;
import com.haier.globalwasher.R;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class b implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, Closeable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f24540e = "b";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f24541f = 0.1f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final long f24542g = 200;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f24543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MediaPlayer f24544b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f24545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f24546d;

    public b(Activity activity) {
        this.f24543a = activity;
        q();
    }

    private MediaPlayer b(Context context) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(3);
        mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.setOnErrorListener(this);
        try {
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = context.getResources().openRawResourceFd(R.raw.beep);
            try {
                mediaPlayer.setDataSource(assetFileDescriptorOpenRawResourceFd.getFileDescriptor(), assetFileDescriptorOpenRawResourceFd.getStartOffset(), assetFileDescriptorOpenRawResourceFd.getLength());
                assetFileDescriptorOpenRawResourceFd.close();
                mediaPlayer.setVolume(0.1f, 0.1f);
                mediaPlayer.prepare();
                return mediaPlayer;
            } catch (Throwable th) {
                assetFileDescriptorOpenRawResourceFd.close();
                throw th;
            }
        } catch (IOException e8) {
            Log.w(f24540e, e8);
            mediaPlayer.release();
            return null;
        }
    }

    private static boolean f(SharedPreferences sharedPreferences, Context context) {
        return ((AudioManager) context.getSystemService("audio")).getRingerMode() == 2;
    }

    private synchronized void q() {
        boolean zF = f(PreferenceManager.getDefaultSharedPreferences(this.f24543a), this.f24543a);
        this.f24545c = zF;
        this.f24546d = true;
        if (zF && this.f24544b == null) {
            this.f24543a.setVolumeControlStream(3);
            this.f24544b = b(this.f24543a);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        MediaPlayer mediaPlayer = this.f24544b;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.f24544b = null;
        }
    }

    public synchronized void e() {
        MediaPlayer mediaPlayer;
        if (this.f24545c && (mediaPlayer = this.f24544b) != null) {
            mediaPlayer.start();
        }
        if (this.f24546d) {
            ((Vibrator) this.f24543a.getSystemService("vibrator")).vibrate(f24542g);
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer.seekTo(0);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public synchronized boolean onError(MediaPlayer mediaPlayer, int i7, int i8) {
        try {
            if (i7 == 100) {
                this.f24543a.finish();
            } else {
                mediaPlayer.release();
                this.f24544b = null;
                q();
            }
        } catch (Throwable th) {
            throw th;
        }
        return true;
    }
}
