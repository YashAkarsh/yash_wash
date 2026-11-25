package androidx.test.rule.logging;

import android.app.Instrumentation;
import android.app.UiAutomation;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.test.annotation.Beta;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@Beta
public class AtraceLogger {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f10382h = "atrace --async_start -b %d -c %s";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f10383i = "atrace --async_dump -b %d -z %s";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f10384j = "atrace --async_stop -b %d -z %s";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f10385k = "AtraceLogger";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f10386l = " ";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f10387m = 8192;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static volatile AtraceLogger f10388n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private UiAutomation f10389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f10390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<ByteArrayOutputStream> f10391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Thread f10392d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private File f10393e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f10394f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private IOException f10395g;

    private class DumpTraceRunnable implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f10396a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f10397b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f10398c;

        DumpTraceRunnable(String traceCategories, int bufferSize, int dumpIntervalInSecs) {
            this.f10396a = traceCategories;
            this.f10397b = bufferSize;
            this.f10398c = dumpIntervalInSecs;
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    try {
                        Thread.sleep(this.f10398c * 1000);
                        String str = String.format(AtraceLogger.f10383i, Integer.valueOf(this.f10397b), this.f10396a);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        AtraceLogger atraceLogger = AtraceLogger.this;
                        atraceLogger.i(atraceLogger.f10389a.executeShellCommand(str), byteArrayOutputStream);
                        AtraceLogger.this.f10391c.add(byteArrayOutputStream);
                        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                        StringBuilder sb = new StringBuilder(54);
                        sb.append("Time taken by - DumpTraceRunnable ");
                        sb.append(jCurrentTimeMillis2);
                        Log.i(AtraceLogger.f10385k, sb.toString());
                    } catch (InterruptedException unused) {
                    }
                } catch (IOException e8) {
                    AtraceLogger.this.f10395g = e8;
                    return;
                }
            }
            String str2 = String.format(AtraceLogger.f10384j, Integer.valueOf(this.f10397b), this.f10396a);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            AtraceLogger atraceLogger2 = AtraceLogger.this;
            atraceLogger2.i(atraceLogger2.f10389a.executeShellCommand(str2), byteArrayOutputStream2);
            AtraceLogger.this.f10391c.add(byteArrayOutputStream2);
        }
    }

    private AtraceLogger(Instrumentation instrumentation) {
        this.f10389a = instrumentation.getUiAutomation();
    }

    private void g() throws IOException {
        int i7 = 0;
        for (ByteArrayOutputStream byteArrayOutputStream : this.f10391c) {
            FileOutputStream fileOutputStream = new FileOutputStream(this.f10390b != null ? new File(this.f10393e, String.format("%s-atrace-%d.txt", this.f10390b, Integer.valueOf(i7))) : new File(this.f10393e, String.format("atrace-%d.txt", Integer.valueOf(i7))));
            try {
                fileOutputStream.write(byteArrayOutputStream.toByteArray());
                fileOutputStream.close();
                i7++;
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        }
    }

    public static AtraceLogger h(Instrumentation instrumentation) {
        if (f10388n == null) {
            synchronized (AtraceLogger.class) {
                if (f10388n == null) {
                    f10388n = new AtraceLogger(instrumentation);
                }
            }
        }
        return f10388n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(ParcelFileDescriptor pfDescriptor, ByteArrayOutputStream outputStream) throws IOException {
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(pfDescriptor);
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int i7 = autoCloseInputStream.read(bArr);
                if (i7 < 0) {
                    autoCloseInputStream.close();
                    return;
                }
                outputStream.write(bArr, 0, i7);
            }
        } catch (Throwable th) {
            autoCloseInputStream.close();
            throw th;
        }
    }

    public void e(Set<String> traceCategoriesSet, int atraceBufferSize, int dumpIntervalSecs, File destDirectory, String traceFileName) throws IOException {
        if (this.f10394f) {
            throw new IllegalStateException("Attempted multiple atrace start");
        }
        if (traceCategoriesSet.isEmpty()) {
            throw new IllegalArgumentException("Empty categories. Should contain atleast one category");
        }
        if (destDirectory == null) {
            throw new IllegalArgumentException("Destination directory cannot be null");
        }
        if (!destDirectory.exists() && !destDirectory.mkdirs()) {
            throw new IOException("Unable to create the destination directory");
        }
        this.f10393e = destDirectory;
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> it = traceCategoriesSet.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
            stringBuffer.append(" ");
        }
        if (traceFileName != null && !traceFileName.isEmpty()) {
            this.f10390b = traceFileName;
        }
        String str = String.format(f10382h, Integer.valueOf(atraceBufferSize), stringBuffer.toString());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            i(this.f10389a.executeShellCommand(str), byteArrayOutputStream);
            byteArrayOutputStream.close();
            this.f10394f = true;
            this.f10395g = null;
            this.f10391c = new ArrayList();
            Thread thread = new Thread(new DumpTraceRunnable(stringBuffer.toString(), atraceBufferSize, dumpIntervalSecs));
            this.f10392d = thread;
            thread.start();
        } catch (Throwable th) {
            byteArrayOutputStream.close();
            throw th;
        }
    }

    public void f() throws InterruptedException, IOException {
        if (!this.f10394f) {
            throw new IllegalStateException("ATrace is not running currently. Start atrace beforestopping.");
        }
        try {
            this.f10392d.interrupt();
            this.f10392d.join();
            IOException iOException = this.f10395g;
            if (iOException != null) {
                throw iOException;
            }
            g();
            Iterator<ByteArrayOutputStream> it = this.f10391c.iterator();
            while (it.hasNext()) {
                it.next().close();
            }
            this.f10394f = false;
            this.f10390b = null;
        } catch (Throwable th) {
            Iterator<ByteArrayOutputStream> it2 = this.f10391c.iterator();
            while (it2.hasNext()) {
                it2.next().close();
            }
            this.f10394f = false;
            this.f10390b = null;
            throw th;
        }
    }
}
