package androidx.test.internal.runner.junit3;

import android.os.Looper;
import android.util.Log;
import androidx.test.internal.util.AndroidRunnerParams;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import junit.framework.i;
import junit.framework.m;
import junit.framework.n;
import org.junit.k;

/* JADX INFO: loaded from: classes.dex */
@k
class AndroidTestSuite extends DelegatingFilterableTestSuite {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f10121e = "AndroidTestSuite";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AndroidRunnerParams f10122d;

    public AndroidTestSuite(Class<?> testClass, AndroidRunnerParams runnerParams) {
        this(new NonLeakyTestSuite(testClass), runnerParams);
    }

    private void A(final RuntimeException exception) {
        Thread thread = new Thread(new Runnable(this) { // from class: androidx.test.internal.runner.junit3.AndroidTestSuite.3
            @Override // java.lang.Runnable
            public void run() {
                throw exception;
            }
        }, "Terminator");
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException unused) {
        }
    }

    private String x() {
        StringBuilder sb = new StringBuilder();
        Thread threadCurrentThread = Thread.currentThread();
        sb.append(threadCurrentThread.toString());
        sb.append('\n');
        for (StackTraceElement stackTraceElement : threadCurrentThread.getStackTrace()) {
            sb.append("\tat ");
            sb.append(stackTraceElement.toString());
            sb.append('\n');
        }
        sb.append('\n');
        Thread thread = Looper.getMainLooper().getThread();
        sb.append(thread.toString());
        sb.append('\n');
        for (StackTraceElement stackTraceElement2 : thread.getStackTrace()) {
            sb.append("\tat ");
            sb.append(stackTraceElement2.toString());
            sb.append('\n');
        }
        sb.append('\n');
        return sb.toString();
    }

    private void y(final i test, final AndroidTestResult androidTestResult, final long timeout) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactory(this) { // from class: androidx.test.internal.runner.junit3.AndroidTestSuite.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable r7) {
                Thread threadNewThread = Executors.defaultThreadFactory().newThread(r7);
                threadNewThread.setName(AndroidTestSuite.f10121e);
                return threadNewThread;
            }
        });
        Runnable runnable = new Runnable(this) { // from class: androidx.test.internal.runner.junit3.AndroidTestSuite.2
            @Override // java.lang.Runnable
            public void run() {
                test.c(androidTestResult);
            }
        };
        androidTestResult.r(timeout);
        Future<?> futureSubmit = executorServiceNewSingleThreadExecutor.submit(runnable);
        executorServiceNewSingleThreadExecutor.shutdown();
        try {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            if (executorServiceNewSingleThreadExecutor.awaitTermination(timeout, timeUnit)) {
                return;
            }
            executorServiceNewSingleThreadExecutor.shutdownNow();
            if (executorServiceNewSingleThreadExecutor.awaitTermination(1L, TimeUnit.MINUTES)) {
                return;
            }
            Log.e(f10121e, "Failed to to stop test execution thread, the correctness of the test runner is at risk. Abort all execution!");
            try {
                futureSubmit.get(0L, timeUnit);
            } catch (ExecutionException e8) {
                Log.e(f10121e, "Exception from the execution thread", e8.getCause());
            } catch (TimeoutException e9) {
                Log.e(f10121e, "Exception from the execution thread", e9);
            }
            A(new IllegalStateException(String.format("Test timed out after %d milliseconds but execution thread failed to terminate\nDumping instr and main threads:\n%s", Long.valueOf(timeout), x())));
        } catch (InterruptedException e10) {
            Log.e(f10121e, "The correctness of the test runner is at risk. Abort all execution!");
            A(new IllegalStateException(String.format("Test execution thread got interrupted:\n%s\nDumping instr and main threads:\n%s", e10, x())));
        }
    }

    private void z(long timeout, AndroidTestResult result) {
        int iR = r();
        for (int i7 = 0; i7 < iR; i7++) {
            y(p(i7), result, timeout);
        }
    }

    @Override // androidx.test.internal.runner.junit3.DelegatingTestSuite, junit.framework.n, junit.framework.i
    public void c(m result) {
        AndroidTestResult androidTestResult = new AndroidTestResult(this.f10122d.a(), this.f10122d.b(), result);
        long jC = this.f10122d.c();
        if (jC > 0) {
            z(jC, androidTestResult);
        } else {
            super.c(androidTestResult);
        }
    }

    public AndroidTestSuite(n s7, AndroidRunnerParams runnerParams) {
        super(s7);
        this.f10122d = runnerParams;
    }
}
