package com.facebook.internal.instrument.errorreport;

import c.o0;
import c.x0;
import com.facebook.internal.instrument.InstrumentUtility;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public final class ErrorReportData {
    private static final String PARAM_TIMESTAMP = "timestamp";
    private static final String PRARAM_ERROR_MESSAGE = "error_message";

    @o0
    private String errorMessage;
    private String filename;

    @o0
    private Long timestamp;

    public ErrorReportData(String str) {
        this.timestamp = Long.valueOf(System.currentTimeMillis() / 1000);
        this.errorMessage = str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(InstrumentUtility.ERROR_REPORT_PREFIX);
        stringBuffer.append(this.timestamp);
        stringBuffer.append(".json");
        this.filename = stringBuffer.toString();
    }

    public void clear() {
        InstrumentUtility.deleteFile(this.filename);
    }

    public int compareTo(ErrorReportData errorReportData) {
        Long l7 = this.timestamp;
        if (l7 == null) {
            return -1;
        }
        Long l8 = errorReportData.timestamp;
        if (l8 == null) {
            return 1;
        }
        return l8.compareTo(l7);
    }

    @o0
    public JSONObject getParameters() {
        JSONObject jSONObject = new JSONObject();
        try {
            Long l7 = this.timestamp;
            if (l7 != null) {
                jSONObject.put("timestamp", l7);
            }
            jSONObject.put("error_message", this.errorMessage);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public boolean isValid() {
        return (this.errorMessage == null || this.timestamp == null) ? false : true;
    }

    public void save() {
        if (isValid()) {
            InstrumentUtility.writeFile(this.filename, toString());
        }
    }

    @o0
    public String toString() {
        JSONObject parameters = getParameters();
        if (parameters == null) {
            return null;
        }
        return parameters.toString();
    }

    public ErrorReportData(File file) {
        String name = file.getName();
        this.filename = name;
        JSONObject file2 = InstrumentUtility.readFile(name, true);
        if (file2 != null) {
            this.timestamp = Long.valueOf(file2.optLong("timestamp", 0L));
            this.errorMessage = file2.optString("error_message", null);
        }
    }
}
