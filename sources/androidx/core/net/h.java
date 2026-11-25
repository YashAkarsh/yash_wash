package androidx.core.net;

import android.net.TrafficStats;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import c.m0;
import c.t;
import c.t0;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    @t0(24)
    static class a {
        private a() {
        }

        @t
        static void a(DatagramSocket datagramSocket) throws SocketException {
            TrafficStats.tagDatagramSocket(datagramSocket);
        }

        @t
        static void b(DatagramSocket datagramSocket) throws SocketException {
            TrafficStats.untagDatagramSocket(datagramSocket);
        }
    }

    private h() {
    }

    @Deprecated
    public static void a() {
        TrafficStats.clearThreadStatsTag();
    }

    @Deprecated
    public static int b() {
        return TrafficStats.getThreadStatsTag();
    }

    @Deprecated
    public static void c(int i7) {
        TrafficStats.incrementOperationCount(i7);
    }

    @Deprecated
    public static void d(int i7, int i8) {
        TrafficStats.incrementOperationCount(i7, i8);
    }

    @Deprecated
    public static void e(int i7) {
        TrafficStats.setThreadStatsTag(i7);
    }

    public static void f(@m0 DatagramSocket datagramSocket) throws SocketException {
        if (Build.VERSION.SDK_INT >= 24) {
            a.a(datagramSocket);
            return;
        }
        ParcelFileDescriptor parcelFileDescriptorFromDatagramSocket = ParcelFileDescriptor.fromDatagramSocket(datagramSocket);
        TrafficStats.tagSocket(new c(datagramSocket, parcelFileDescriptorFromDatagramSocket.getFileDescriptor()));
        parcelFileDescriptorFromDatagramSocket.detachFd();
    }

    @Deprecated
    public static void g(Socket socket) throws SocketException {
        TrafficStats.tagSocket(socket);
    }

    public static void h(@m0 DatagramSocket datagramSocket) throws SocketException {
        if (Build.VERSION.SDK_INT >= 24) {
            a.b(datagramSocket);
            return;
        }
        ParcelFileDescriptor parcelFileDescriptorFromDatagramSocket = ParcelFileDescriptor.fromDatagramSocket(datagramSocket);
        TrafficStats.untagSocket(new c(datagramSocket, parcelFileDescriptorFromDatagramSocket.getFileDescriptor()));
        parcelFileDescriptorFromDatagramSocket.detachFd();
    }

    @Deprecated
    public static void i(Socket socket) throws SocketException {
        TrafficStats.untagSocket(socket);
    }
}
