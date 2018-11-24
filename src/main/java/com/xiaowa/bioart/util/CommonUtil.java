package com.xiaowa.bioart.util;

import com.alibaba.fastjson.JSON;
import com.xiaowa.bioart.result.Config;
import net.coobird.thumbnailator.Thumbnails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.File;
import java.io.Reader;
import java.lang.reflect.Field;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import static org.springframework.util.StringUtils.split;

/**
 * Created by hsdev-08 on 2017-05-02.
 */
public class CommonUtil {
    private final static Logger logger = LoggerFactory.getLogger(CommonUtil.class);

    /**
     *
     * 方法说明：clob转字符串
     *
     * 返回：String
     */
    public static String clob2Str(Clob clob){
        String content = "";
        try {
            Reader is = clob.getCharacterStream();
            BufferedReader buff = new BufferedReader(is);// 得到流
            String line = buff.readLine();
            StringBuffer sb = new StringBuffer();
            while (line != null) {// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
                sb.append(line);
                line = buff.readLine();
            }
            content = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }

    public static String getYYYY_MM_DD(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String strdate = simpleDateFormat.format(date);
        return strdate;
    }

    public static String getCurrentDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

    public static String getFormatDate(Timestamp date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return simpleDateFormat.format(date);
    }

    public static String getDateByLong(Timestamp date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    public static String get10Date() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

    public static String DateToStr(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }

    public static String getYYYYmm() {
        String date = "yyyyMM";
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat(date);
        return df.format(d);
    }

    /******
     *author:hsdev-04
     *date:2017-07-27 11:41
     *note:
     ******/
    public static Date StrToDate(String str) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /******
     *author:hsdev-04
     *date:2017-07-27 11:41
     *note:获取具体天数后的时间
     ******/
    public static String afterday(Date date, int day) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new Date(date.getTime() - day * 24 * 60 * 60 * 1000));
    }

    /**
     * 通过时间秒毫秒数判断两个时间的间隔
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDaysByMillisecond(Date date1, Date date2) {
        return (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
    }

    public static int compareDate(String date1, String date2, int stype) {
        int n = 0;

        String[] u = {"天", "月", "年"};
        String formatStyle = stype == 1 ? "yyyy-MM" : "yyyy-MM-dd";

        date2 = date2 == null ? CommonUtil.getCurrentDate() : date2;

        DateFormat df = new SimpleDateFormat(formatStyle);
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(df.parse(date1));
            c2.setTime(df.parse(date2));
        } catch (Exception e3) {
            System.out.println("wrong occured");
        }
        //List list = new ArrayList();
        while (!c1.after(c2)) {                     // 循环对比，直到相等，n 就是所要的结果
            //list.add(df.format(c1.getTime()));    // 这里可以把间隔的日期存到数组中 打印出来
            n++;
            if (stype == 1) {
                c1.add(Calendar.MONTH, 1);          // 比较月份，月份+1
            } else {
                c1.add(Calendar.DATE, 1);           // 比较天数，日期+1
            }
        }

        n = n - 1;

        if (stype == 2) {
            n = (int) n / 365;
        }

        if (stype == 1 && Integer.parseInt(date2.substring(8, 10)) < Integer.parseInt(date1.substring(8, 10))) {
            n = n - 1;
        }
        /* System.out.println(date1+" -- "+date2+" 相差多少"+u[stype]+":"+n);*/
        return n;
    }

    public static Map<String, Object> generateWheres(Map<String, Object> map, String key) {
        if (sql_inj(map.toString())) {
            map.put(key, "禁止使用");
            return map;
        }
        List<String> list = JSON.parseArray(map.get(key).toString(), String.class);
        String condition = CommonUtil.listToMapSql(list);
        if (list.size() != 0) {
            map.put(key, condition);
        } else {
            map.put(key, "");
        }
        return map;
    }

    public static String generateQuerySql(Map<String, Object> map, String key) {
        if (sql_inj(map.toString())) {
            return "禁止使用";
        }
        if (null == map.get(key)) {
            return "";
        }
        List<String> list = JSON.parseArray(map.get(key).toString(), String.class);
        if (list.size() == 0) {
            return "";
        }
        String condition = CommonUtil.listToMapSql(list);
        return condition;
    }


    /******
     *author:hsdev-04
     *date:2017-08-24 13:48
     *note:由map生成查询sql的where
     ******/
    public static String listToMapSql(List<String> list) {
        String returnd = "(";
        ArrayList wherearr = new ArrayList();
        if (list.size() == 0) {
            return returnd;
        }
        for (int i = 0; i < list.size(); i++) {
            String keys = list.get(i);
            String[] subval = keys.split("\\|\\|");
            String key = subval[0];
            String val = " \'" + subval[1] + "\' ";
            String symbol = subval[2];
            String feature = subval[3];
            if (symbol.equals("orstart")) {
                if (returnd.substring(returnd.length() - 1).equals(")")) {
                    returnd = returnd + "or (";
                } else {
                    returnd = returnd + "(";
                }

                continue;
            } else if (symbol.equals("orend")) {
                returnd = returnd + ")";
                continue;
            } else if (!returnd.substring(returnd.length() - 1).equals("(")) {
                returnd = returnd + " and ";
            }
            HashMap features = new HashMap();
            for (int y = 0; y < subval[3].split("&&").length; y++) {
                features.put(subval[3].split("&&")[y], "0");
            }
            String current = "";
            if (subval[1].equals("null") || symbol.equals("null")) {
                current = key + " is null";
            } else if (subval[1].equals("notnull") || symbol.equals("notnull")) {
                current = key + " is not null";
            } else {
                if (symbol.equals("like")) {
                    val = " \'%" + subval[1] + "%\' ";
                }
                if (null != features.get("time")) {
                    key = " convert(datetime," + key + ") ";
                    val = " convert(datetime," + val + ") ";
                }
                if (feature.equals("compare")) {
                    val = subval[1];
                }
                if (feature.equals("doubledot")) {
                    val = " \'\'" + subval[1] + "\'\'";
                }
                current = key + " " + symbol + " " + val;
                if (feature.equals("write")) {
                    current = subval[1];
                }
            }

            returnd = returnd + current;
        }
        System.out.println(returnd + ")");
        return returnd + ")";
    }


    /******
     *author:hsdev-04
     *date:2017-11-02 15:21
     *note:由map生成sql的insert语句
     ******/

    public static String generateInsertSql(Map<String, Object> map) {
        if (sql_inj(map.toString())) {
            return "禁止使用";
        }
        String insertsqlkey = "";
        String insertsqlval = "";
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            insertsqlkey = insertsqlkey + entry.getKey() + ",";
            insertsqlval = insertsqlval + "'" + entry.getValue() + "',";

        }
        return "(" + insertsqlkey.substring(0, insertsqlkey.length() - 1) + ")" + "values(" + insertsqlval.substring(0, insertsqlval.length() - 1) + ")";
    }

    /******
     *author:hsdev-04
     *date:2017-11-02 15:30
     *note:由map生成sql的update语句
     ******/
    public static String generateUpdateSql(Map<String, Object> map) {
        if (sql_inj(map.toString())) {
            return "禁止使用";
        }
        String updatesql = "set ";
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            updatesql = updatesql + entry.getKey() + " = '" + entry.getValue() + "',";

        }
        return updatesql.substring(0, updatesql.length() - 1);
    }


    /******
     *author:hsdev-04
     *date:2017-11-24 10:27
     *note:针对需要将两个表单中的相同字段进行同步的时候
     ******/
    public static HashMap getAssignMap(HashMap map, HashMap returnd, String[] arr) {
        Iterator entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();

            String key = entry.getKey().toString();

            String value = null != entry.getValue() ? entry.getValue().toString() : null;
            if (null != value) {
                for (String workz : arr) {
                    if (key.equals(workz)) {
                        returnd.put(key, value);
                        break;
                    }
                }
            }
        }
        return returnd;
    }

    /******
     *author:hsdev-04
     *date:2018-01-09 10:16
     *note:防止sql注入
     ******/
    public static boolean sql_inj(String str) {
        String inj_str = "exec|insert|select|delete|update|drop|master|truncate|declare|;";
        String inj_stra[] = split(inj_str, "|");
        for (int i = 0; i < inj_stra.length; i++) {
            if (str.toLowerCase().indexOf(inj_stra[i]) >= 0) {
                System.out.print(str + ":因防止sql注入," + str + "禁止使用！");
                return true;
            }
        }
        return false;
    }

    /******
     *author:hsdev-04
     *date:2018-02-12 13:35
     *note:剔除map
     ******/
    public static HashMap kickmap(HashMap map, List<HashMap> columns) {
        ArrayList needremove = new ArrayList();
        Iterator entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            String key = entry.getKey().toString();
            Boolean exist = false;
            for (int a = 0; a < columns.size(); a++) {
                HashMap column = columns.get(a);
                if (column.get("columns").equals(key)) {
                    exist = true;
                }
            }
            if (!exist) {
                needremove.add(key);
            }
        }
        for (int b = 0; b < needremove.size(); b++) {
            map.remove(needremove.get(b));
        }
        return map;
    }

    /******
     *author:hsdev-04
     *date:2018-01-14 23:37
     *note:上传附件
     ******/

    public static ArrayList uploadFiles(MultipartFile[] uploadFile, String param, HttpSession session) throws Exception {
       // Map<String, Object> map = com.hesu.common.util.JSON2MapUtil.parseJSON2Map(param);
        String uid = (String) session.getAttribute("uid");

        ArrayList returnd = new ArrayList();
        for (int i = 0; i < uploadFile.length; i++) {
            HashMap attachinfo = new HashMap();
            //String fileName = AppUtils.genGuidFileName(new Date());
           // attachinfo.put("attach_fn", fileName);
            //获取配置文件中的根路径
            String rootUrl = ResourcesUtil.getValue(Config.SYSTEMCONFIG, uid);
            if (rootUrl == null || rootUrl.trim().equals("")) {
                ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 303, null));
            }
            logger.warn(rootUrl);

            //拼成完整路径
            StringBuilder buffer = new StringBuilder(rootUrl);
//            buffer.append(fileName.substring(0, 4)).append("-");
//            buffer.append(fileName.substring(4, 6)).append("/");
//            buffer.append(fileName.substring(6, 8)).append("/");

            //得到上传文件的原始文件名
            String originalFileName = uploadFile[i].getOriginalFilename();
            System.out.print(originalFileName);
            //获取文件的后缀名
            String extName = originalFileName.substring(originalFileName.lastIndexOf("."));
            attachinfo.put("extname", extName);
            //获取原始文件名
            String old_fn = originalFileName.substring(0, originalFileName.lastIndexOf("."));
            //构建新的文件名
//            String newFileName = fileName + extName;
//            File fileone = new File(buffer.toString());
//            File file = new File(buffer.toString(), newFileName);
//            if (!fileone.exists()) {
//                fileone.mkdirs();
//
//            }
//            file.createNewFile();
//            uploadFile[i].transferTo(file);

//        /上传压缩图片
//            if (extName.equals(".jpg") || extName.equals(".png") || extName.equals(".jpg")) {
//                //构建压缩图片文件名
//                String fileName_zip = fileName + "_zip" + extName;
//                File file_zip = new File(buffer.toString(), fileName_zip);
////            等比缩放
////            Thumbnails.of(file).scale(0.2f).toFile(file_zip);
////            指定大小缩放
//                Thumbnails.of(file).forceSize(100, 120).toFile(file_zip);
//                file_zip.createNewFile();
//            }
//            attachinfo.put("file_name", originalFileName);
//            returnd.add(attachinfo);
        }
        return returnd;
    }


    public static Map ConvertObjToMap(Object obj) {
        Map<String, Object> reMap = new HashMap<String, Object>();
        if (obj == null)
            return null;
        Field[] fields = obj.getClass().getDeclaredFields();
        try {
            for (int i = 0; i < fields.length; i++) {
                try {
                    Field f = obj.getClass().getDeclaredField(fields[i].getName());
                    f.setAccessible(true);
                    Object o = f.get(obj);
                    reMap.put(fields[i].getName(), o);
                } catch (NoSuchFieldException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return reMap;
    }

    public static List<Map<String, Object>> ResultSetToList(ResultSet rs) throws SQLException {
        List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
        ResultSetMetaData rsmd = rs.getMetaData();
        int colCount = rsmd.getColumnCount();
        List<String> colNameList = new ArrayList<String>();
        for (int i = 0; i < colCount; i++) {
            colNameList.add(rsmd.getColumnName(i + 1));
        }
        while (rs.next()) {

            for (int i = 0; i < colCount; i++) {
                Map map = new HashMap<String, Object>();
                String key = colNameList.get(i);
                Object value = rs.getString(colNameList.get(i));
                map.put(key, value);

                results.add(map);
            }
        }
        return results;
    }
}
