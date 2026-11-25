package androidx.test.internal.util;

import c.g1;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes.dex */
public final class ProcSummary {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f10248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f10249e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f10250f;

    @g1
    static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f10251a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f10252b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f10253c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f10254d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f10255e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f10256f;

        Builder() {
        }

        ProcSummary g() {
            return new ProcSummary(this);
        }

        Builder h(String cmdline) {
            this.f10254d = cmdline;
            return this;
        }

        Builder i(String name) {
            this.f10251a = name;
            return this;
        }

        Builder j(String ppid) {
            try {
                Integer.parseInt(ppid);
                this.f10256f = ppid;
                return this;
            } catch (NumberFormatException unused) {
                String strValueOf = String.valueOf(ppid);
                throw new IllegalArgumentException(strValueOf.length() != 0 ? "not a pid: ".concat(strValueOf) : new String("not a pid: "));
            }
        }

        Builder k(String pid) {
            try {
                Integer.parseInt(pid);
                this.f10252b = pid;
                return this;
            } catch (NumberFormatException unused) {
                String strValueOf = String.valueOf(pid);
                throw new IllegalArgumentException(strValueOf.length() != 0 ? "not a pid: ".concat(strValueOf) : new String("not a pid: "));
            }
        }

        Builder l(String uid) {
            try {
                Integer.parseInt(uid);
                this.f10253c = uid;
                return this;
            } catch (NumberFormatException unused) {
                String strValueOf = String.valueOf(uid);
                throw new IllegalArgumentException(strValueOf.length() != 0 ? "not a uid: ".concat(strValueOf) : new String("not a uid: "));
            }
        }

        Builder m(long startTime) {
            this.f10255e = startTime;
            return this;
        }
    }

    public static class SummaryException extends RuntimeException {
        public SummaryException(String msg, Throwable cause) {
            super(msg, cause);
        }

        public SummaryException(String msg) {
            super(msg);
        }
    }

    @g1
    static ProcSummary a(String statLine, String statusContent, String cmdline) {
        String[] strArrSplit = statLine.substring(statLine.lastIndexOf(41) + 2).split(" ", -1);
        String strSubstring = statusContent.substring(statusContent.indexOf("\nUid:") + 1);
        return new Builder().k(statLine.substring(0, statLine.indexOf(32))).i(statLine.substring(statLine.indexOf(40) + 1, statLine.lastIndexOf(41))).j(strArrSplit[1]).l(strSubstring.substring(0, strSubstring.indexOf(10)).split("\\s", -1)[1]).h(cmdline.trim().replace((char) 0, ' ')).m(Long.parseLong(strArrSplit[19])).g();
    }

    private static final String b(File path) throws Throwable {
        StringBuilder sb = new StringBuilder();
        char[] cArr = new char[1024];
        InputStreamReader inputStreamReader = null;
        try {
            try {
                InputStreamReader inputStreamReader2 = new InputStreamReader(new FileInputStream(path));
                while (true) {
                    try {
                        int i7 = inputStreamReader2.read(cArr, 0, 1024);
                        if (i7 == -1) {
                            break;
                        }
                        sb.append(cArr, 0, i7);
                    } catch (IOException e8) {
                        e = e8;
                        String strValueOf = String.valueOf(path);
                        StringBuilder sb2 = new StringBuilder(strValueOf.length() + 16);
                        sb2.append("Could not read: ");
                        sb2.append(strValueOf);
                        throw new SummaryException(sb2.toString(), e);
                    } catch (RuntimeException e9) {
                        e = e9;
                        String strValueOf2 = String.valueOf(path);
                        StringBuilder sb3 = new StringBuilder(strValueOf2.length() + 15);
                        sb3.append("Error reading: ");
                        sb3.append(strValueOf2);
                        throw new SummaryException(sb3.toString(), e);
                    } catch (Throwable th) {
                        th = th;
                        inputStreamReader = inputStreamReader2;
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                }
                String string = sb.toString();
                try {
                    inputStreamReader2.close();
                } catch (IOException unused2) {
                }
                return string;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e10) {
            e = e10;
        } catch (RuntimeException e11) {
            e = e11;
        }
    }

    public static ProcSummary c(String pid) {
        return a(b(new File(new File("/proc", pid), "stat")), b(new File(new File("/proc", pid), "status")), b(new File(new File("/proc", pid), "cmdline")));
    }

    public boolean equals(Object o7) {
        if (o7 == null || !(o7 instanceof ProcSummary)) {
            return false;
        }
        ProcSummary procSummary = (ProcSummary) o7;
        return procSummary.f10245a.equals(this.f10245a) && procSummary.f10246b.equals(this.f10246b) && procSummary.f10247c.equals(this.f10247c) && procSummary.f10248d.equals(this.f10248d) && procSummary.f10249e.equals(this.f10249e) && procSummary.f10250f == this.f10250f;
    }

    public int hashCode() {
        return this.f10246b.hashCode();
    }

    public String toString() {
        return String.format("ProcSummary(name: '%s', cmdline: '%s', pid: '%s', parent: '%s', realUid: '%s', startTime: %d)", this.f10245a, this.f10249e, this.f10246b, this.f10247c, this.f10248d, Long.valueOf(this.f10250f));
    }

    private ProcSummary(Builder b8) {
        this.f10245a = (String) Checks.f(b8.f10251a);
        this.f10246b = (String) Checks.f(b8.f10252b);
        this.f10248d = (String) Checks.f(b8.f10253c);
        this.f10247c = (String) Checks.f(b8.f10256f);
        this.f10249e = (String) Checks.f(b8.f10254d);
        this.f10250f = b8.f10255e;
    }
}
