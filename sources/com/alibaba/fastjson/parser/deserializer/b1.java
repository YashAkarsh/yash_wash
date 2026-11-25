package com.alibaba.fastjson.parser.deserializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class b1 extends e implements com.alibaba.fastjson.serializer.y0, com.alibaba.fastjson.serializer.z, e1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f12853b = "yyyy-MM-dd HH:mm:ss";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b1 f12852a = new b1();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final DateTimeFormatter f12854c = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final DateTimeFormatter f12855d = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final DateTimeFormatter f12856e = DateTimeFormatter.ofPattern("yyyy年M月d日 HH:mm:ss");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final DateTimeFormatter f12857f = DateTimeFormatter.ofPattern("yyyy年M月d日 H时m分s秒");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final DateTimeFormatter f12858g = DateTimeFormatter.ofPattern("yyyy년M월d일 HH:mm:ss");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final DateTimeFormatter f12859h = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final DateTimeFormatter f12860i = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final DateTimeFormatter f12861j = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final DateTimeFormatter f12862k = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final DateTimeFormatter f12863l = DateTimeFormatter.ofPattern("yyyyMMdd");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final DateTimeFormatter f12864m = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final DateTimeFormatter f12865n = DateTimeFormatter.ofPattern("yyyy年M月d日");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final DateTimeFormatter f12866o = DateTimeFormatter.ofPattern("yyyy년M월d일");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final DateTimeFormatter f12867p = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final DateTimeFormatter f12868q = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final DateTimeFormatter f12869r = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final DateTimeFormatter f12870s = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final DateTimeFormatter f12871t = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f12872u = "yyyy-MM-dd'T'HH:mm:ss";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final DateTimeFormatter f12873v = DateTimeFormatter.ofPattern(f12872u);

    private void j(com.alibaba.fastjson.serializer.j1 j1Var, TemporalAccessor temporalAccessor, String str) {
        j1Var.a2((str == f12872u ? f12873v : DateTimeFormatter.ofPattern(str)).format(temporalAccessor));
    }

    @Override // com.alibaba.fastjson.serializer.y0
    public void c(com.alibaba.fastjson.serializer.n0 n0Var, Object obj, Object obj2, Type type, int i7) throws IOException {
        com.alibaba.fastjson.serializer.j1 j1Var = n0Var.f13143k;
        if (obj == null) {
            j1Var.X1();
            return;
        }
        if (type == null) {
            type = obj.getClass();
        }
        if (type != LocalDateTime.class) {
            j1Var.a2(obj.toString());
            return;
        }
        com.alibaba.fastjson.serializer.k1 k1Var = com.alibaba.fastjson.serializer.k1.UseISO8601DateFormat;
        int iB = k1Var.b();
        LocalDateTime localDateTimeA = u0.a(obj);
        String strY = n0Var.y();
        if ((strY == null && (i7 & iB) != 0) || n0Var.G(k1Var)) {
            strY = f12872u;
        }
        if (localDateTimeA.getNano() == 0 || strY != null) {
            if (strY == null) {
                strY = com.alibaba.fastjson.a.f12531e;
            }
            j(j1Var, localDateTimeA, strY);
        } else if (j1Var.G(com.alibaba.fastjson.serializer.k1.WriteDateUseDateFormat)) {
            j(j1Var, localDateTimeA, com.alibaba.fastjson.a.f12531e);
        } else {
            j1Var.W1(localDateTimeA.atZone(com.alibaba.fastjson.a.f12527a.toZoneId()).toInstant().toEpochMilli());
        }
    }

    @Override // com.alibaba.fastjson.serializer.z
    public void d(com.alibaba.fastjson.serializer.n0 n0Var, Object obj, com.alibaba.fastjson.serializer.p pVar) throws IOException {
        j(n0Var.f13143k, r.a(obj), pVar.g());
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public int e() {
        return 4;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e
    public <T> T f(com.alibaba.fastjson.parser.b bVar, Type type, Object obj, String str, int i7) {
        DateTimeFormatter dateTimeFormatterOfPattern;
        com.alibaba.fastjson.parser.d dVar = bVar.f12789f;
        if (dVar.L0() == 8) {
            dVar.E();
            return null;
        }
        if (dVar.L0() != 4) {
            if (dVar.L0() != 2) {
                throw new UnsupportedOperationException();
            }
            long jQ = dVar.q();
            dVar.E();
            if (type == LocalDateTime.class) {
                return (T) LocalDateTime.ofInstant(Instant.ofEpochMilli(jQ), com.alibaba.fastjson.a.f12527a.toZoneId());
            }
            if (type == LocalDate.class) {
                return (T) LocalDateTime.ofInstant(Instant.ofEpochMilli(jQ), com.alibaba.fastjson.a.f12527a.toZoneId()).toLocalDate();
            }
            if (type == LocalTime.class) {
                return (T) LocalDateTime.ofInstant(Instant.ofEpochMilli(jQ), com.alibaba.fastjson.a.f12527a.toZoneId()).toLocalTime();
            }
            throw new UnsupportedOperationException();
        }
        String strX0 = dVar.x0();
        dVar.E();
        if (str != null) {
            dateTimeFormatterOfPattern = "yyyy-MM-dd HH:mm:ss".equals(str) ? f12854c : DateTimeFormatter.ofPattern(str);
        } else {
            dateTimeFormatterOfPattern = null;
        }
        if ("".equals(strX0)) {
            return null;
        }
        if (type == LocalDateTime.class) {
            return (strX0.length() == 10 || strX0.length() == 8) ? (T) LocalDateTime.of(h(strX0, str, dateTimeFormatterOfPattern), LocalTime.MIN) : (T) g(strX0, dateTimeFormatterOfPattern);
        }
        if (type == LocalDate.class) {
            if (strX0.length() != 23) {
                return (T) h(strX0, str, dateTimeFormatterOfPattern);
            }
            LocalDateTime localDateTime = LocalDateTime.parse(strX0);
            return (T) LocalDate.of(localDateTime.getYear(), localDateTime.getMonthValue(), localDateTime.getDayOfMonth());
        }
        if (type == LocalTime.class) {
            if (strX0.length() != 23) {
                return (T) LocalTime.parse(strX0);
            }
            LocalDateTime localDateTime2 = LocalDateTime.parse(strX0);
            return (T) LocalTime.of(localDateTime2.getHour(), localDateTime2.getMinute(), localDateTime2.getSecond(), localDateTime2.getNano());
        }
        if (type == ZonedDateTime.class) {
            if (dateTimeFormatterOfPattern == f12854c) {
                dateTimeFormatterOfPattern = f12871t;
            }
            return (T) i(strX0, dateTimeFormatterOfPattern);
        }
        if (type == OffsetDateTime.class) {
            return (T) OffsetDateTime.parse(strX0);
        }
        if (type == OffsetTime.class) {
            return (T) OffsetTime.parse(strX0);
        }
        if (type == ZoneId.class) {
            return (T) ZoneId.of(strX0);
        }
        if (type == Period.class) {
            return (T) Period.parse(strX0);
        }
        if (type == Duration.class) {
            return (T) Duration.parse(strX0);
        }
        if (type == Instant.class) {
            return (T) Instant.parse(strX0);
        }
        return null;
    }

    protected LocalDateTime g(String str, DateTimeFormatter dateTimeFormatter) {
        if (dateTimeFormatter == null) {
            if (str.length() == 19) {
                char cCharAt = str.charAt(4);
                char cCharAt2 = str.charAt(7);
                char cCharAt3 = str.charAt(10);
                char cCharAt4 = str.charAt(13);
                char cCharAt5 = str.charAt(16);
                if (cCharAt4 == ':' && cCharAt5 == ':') {
                    if (cCharAt == '-' && cCharAt2 == '-') {
                        if (cCharAt3 == 'T') {
                            dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                        } else if (cCharAt3 == ' ') {
                            dateTimeFormatter = f12854c;
                        }
                    } else if (cCharAt == '-' && cCharAt2 == '-') {
                        dateTimeFormatter = f12854c;
                    } else if (cCharAt == '/' && cCharAt2 == '/') {
                        dateTimeFormatter = f12855d;
                    } else {
                        char cCharAt6 = str.charAt(0);
                        char cCharAt7 = str.charAt(1);
                        char cCharAt8 = str.charAt(2);
                        char cCharAt9 = str.charAt(3);
                        char cCharAt10 = str.charAt(5);
                        if (cCharAt8 == '/' && cCharAt10 == '/') {
                            int i7 = ((cCharAt9 - '0') * 10) + (cCharAt - '0');
                            if (((cCharAt6 - '0') * 10) + (cCharAt7 - '0') > 12) {
                                dateTimeFormatter = f12860i;
                            } else if (i7 > 12) {
                                dateTimeFormatter = f12859h;
                            } else {
                                String country = Locale.getDefault().getCountry();
                                if (country.equals("US")) {
                                    dateTimeFormatter = f12859h;
                                } else if (country.equals("BR") || country.equals("AU")) {
                                    dateTimeFormatter = f12860i;
                                }
                            }
                        } else if (cCharAt8 == '.' && cCharAt10 == '.') {
                            dateTimeFormatter = f12861j;
                        } else if (cCharAt8 == '-' && cCharAt10 == '-') {
                            dateTimeFormatter = f12862k;
                        }
                    }
                }
            }
            if (str.length() >= 17) {
                char cCharAt11 = str.charAt(4);
                if (cCharAt11 == 24180) {
                    dateTimeFormatter = str.charAt(str.length() - 1) == 31186 ? f12857f : f12856e;
                } else if (cCharAt11 == 45380) {
                    dateTimeFormatter = f12858g;
                }
            }
        }
        return dateTimeFormatter == null ? LocalDateTime.parse(str) : LocalDateTime.parse(str, dateTimeFormatter);
    }

    protected LocalDate h(String str, String str2, DateTimeFormatter dateTimeFormatter) {
        DateTimeFormatter dateTimeFormatter2;
        if (dateTimeFormatter == null) {
            if (str.length() == 8) {
                dateTimeFormatter = f12863l;
            }
            if (str.length() == 10) {
                char cCharAt = str.charAt(4);
                char cCharAt2 = str.charAt(7);
                if (cCharAt == '/' && cCharAt2 == '/') {
                    dateTimeFormatter = f12864m;
                }
                char cCharAt3 = str.charAt(0);
                char cCharAt4 = str.charAt(1);
                char cCharAt5 = str.charAt(2);
                char cCharAt6 = str.charAt(3);
                char cCharAt7 = str.charAt(5);
                if (cCharAt5 == '/' && cCharAt7 == '/') {
                    int i7 = ((cCharAt6 - '0') * 10) + (cCharAt - '0');
                    if (((cCharAt3 - '0') * 10) + (cCharAt4 - '0') > 12) {
                        dateTimeFormatter = f12868q;
                    } else if (i7 > 12) {
                        dateTimeFormatter = f12867p;
                    } else {
                        String country = Locale.getDefault().getCountry();
                        if (country.equals("US")) {
                            dateTimeFormatter = f12867p;
                        } else if (country.equals("BR") || country.equals("AU")) {
                            dateTimeFormatter = f12868q;
                        }
                    }
                } else {
                    if (cCharAt5 == '.' && cCharAt7 == '.') {
                        dateTimeFormatter2 = f12869r;
                    } else if (cCharAt5 == '-' && cCharAt7 == '-') {
                        dateTimeFormatter2 = f12870s;
                    }
                    dateTimeFormatter = dateTimeFormatter2;
                }
            }
            if (str.length() >= 9) {
                char cCharAt8 = str.charAt(4);
                if (cCharAt8 == 24180) {
                    dateTimeFormatter = f12865n;
                } else if (cCharAt8 == 45380) {
                    dateTimeFormatter = f12866o;
                }
            }
        }
        return dateTimeFormatter == null ? LocalDate.parse(str) : LocalDate.parse(str, dateTimeFormatter);
    }

    protected ZonedDateTime i(String str, DateTimeFormatter dateTimeFormatter) {
        if (dateTimeFormatter == null) {
            if (str.length() == 19) {
                char cCharAt = str.charAt(4);
                char cCharAt2 = str.charAt(7);
                char cCharAt3 = str.charAt(10);
                char cCharAt4 = str.charAt(13);
                char cCharAt5 = str.charAt(16);
                if (cCharAt4 == ':' && cCharAt5 == ':') {
                    if (cCharAt == '-' && cCharAt2 == '-') {
                        if (cCharAt3 == 'T') {
                            dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                        } else if (cCharAt3 == ' ') {
                            dateTimeFormatter = f12854c;
                        }
                    } else if (cCharAt == '-' && cCharAt2 == '-') {
                        dateTimeFormatter = f12854c;
                    } else if (cCharAt == '/' && cCharAt2 == '/') {
                        dateTimeFormatter = f12855d;
                    } else {
                        char cCharAt6 = str.charAt(0);
                        char cCharAt7 = str.charAt(1);
                        char cCharAt8 = str.charAt(2);
                        char cCharAt9 = str.charAt(3);
                        char cCharAt10 = str.charAt(5);
                        if (cCharAt8 == '/' && cCharAt10 == '/') {
                            int i7 = ((cCharAt9 - '0') * 10) + (cCharAt - '0');
                            if (((cCharAt6 - '0') * 10) + (cCharAt7 - '0') > 12) {
                                dateTimeFormatter = f12860i;
                            } else if (i7 > 12) {
                                dateTimeFormatter = f12859h;
                            } else {
                                String country = Locale.getDefault().getCountry();
                                if (country.equals("US")) {
                                    dateTimeFormatter = f12859h;
                                } else if (country.equals("BR") || country.equals("AU")) {
                                    dateTimeFormatter = f12860i;
                                }
                            }
                        } else if (cCharAt8 == '.' && cCharAt10 == '.') {
                            dateTimeFormatter = f12861j;
                        } else if (cCharAt8 == '-' && cCharAt10 == '-') {
                            dateTimeFormatter = f12862k;
                        }
                    }
                }
            }
            if (str.length() >= 17) {
                char cCharAt11 = str.charAt(4);
                if (cCharAt11 == 24180) {
                    dateTimeFormatter = str.charAt(str.length() - 1) == 31186 ? f12857f : f12856e;
                } else if (cCharAt11 == 45380) {
                    dateTimeFormatter = f12858g;
                }
            }
        }
        return dateTimeFormatter == null ? ZonedDateTime.parse(str) : ZonedDateTime.parse(str, dateTimeFormatter);
    }
}
