package com.facebook.internal.instrument;

import c.o0;
import c.x0;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.internal.Utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public final class InstrumentUtility {
    public static final String CRASH_REPORT_PREFIX = "crash_log_";
    public static final String ERROR_REPORT_PREFIX = "error_log_";
    private static final String FBSDK_PREFIX = "com.facebook";
    private static final String INSTRUMENT_DIR = "instrument";

    public static boolean deleteFile(@o0 String str) {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null || str == null) {
            return false;
        }
        return new File(instrumentReportDir, str).delete();
    }

    @o0
    public static String getCause(Throwable th) {
        if (th == null) {
            return null;
        }
        return th.getCause() == null ? th.toString() : th.getCause().toString();
    }

    @o0
    public static File getInstrumentReportDir() {
        File file = new File(FacebookSdk.getApplicationContext().getCacheDir(), INSTRUMENT_DIR);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    @o0
    public static String getStackTrace(Throwable th) {
        Throwable th2 = null;
        if (th == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        while (th != null && th != th2) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                jSONArray.put(stackTraceElement.toString());
            }
            th2 = th;
            th = th.getCause();
        }
        return jSONArray.toString();
    }

    public static boolean isSDKRelatedException(@o0 Throwable th) {
        if (th == null) {
            return false;
        }
        Throwable th2 = null;
        while (th != null && th != th2) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (stackTraceElement.getClassName().startsWith(FBSDK_PREFIX)) {
                    return true;
                }
            }
            th2 = th;
            th = th.getCause();
        }
        return false;
    }

    public static File[] listCrashReportFiles() {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null) {
            return new File[0];
        }
        File[] fileArrListFiles = instrumentReportDir.listFiles(new FilenameFilter() { // from class: com.facebook.internal.instrument.InstrumentUtility.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.matches(String.format("^%s[0-9]+.json$", InstrumentUtility.CRASH_REPORT_PREFIX));
            }
        });
        return fileArrListFiles != null ? fileArrListFiles : new File[0];
    }

    @o0
    public static JSONObject readFile(@o0 String str, boolean z7) {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir != null && str != null) {
            try {
                return new JSONObject(Utility.readStreamToString(new FileInputStream(new File(instrumentReportDir, str))));
            } catch (Exception unused) {
                if (z7) {
                    deleteFile(str);
                }
            }
        }
        return null;
    }

    public static void sendReports(String str, JSONArray jSONArray, GraphRequest.Callback callback) {
        if (jSONArray.length() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, jSONArray.toString());
            GraphRequest.newPostRequest(null, String.format("%s/instruments", FacebookSdk.getApplicationId()), jSONObject, callback).executeAsync();
        } catch (JSONException unused) {
        }
    }

    public static void writeFile(@o0 String str, @o0 String str2) {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null || str == null || str2 == null) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(instrumentReportDir, str));
            fileOutputStream.write(str2.getBytes());
            fileOutputStream.close();
        } catch (Exception unused) {
        }
    }
}
