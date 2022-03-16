package com.answer.utlis;

import cn.hutool.core.convert.Convert;
import com.answer.model.ExcelModel;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.assertj.core.util.Lists;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author liufeng
 * 2022/3/11 10:19
 */
public class ExcelUtils {
    /**
     * 2003- 版本的excel
     */
    private final static String excel2003L = ".xls";
    /**
     * 2007+ 版本的excel
     */
    private final static String excel2007U = ".xlsx";

    public static <E> List<E> getListByExcel(InputStream in, String fileName, Class<E> object, List<String> titles) throws Exception {
        List<E> list = null;

        //创建Excel工作薄
        Workbook work = getWorkbook(in, fileName);
        if (work == null) {
            throw new Exception("创建Excel工作薄为空！");
        }
        //页数
        Sheet sheet = null;
        //行数
        Row row = null;
        //列数
        Cell cell = null;

        list = new ArrayList<E>();
        //遍历Excel中所有的sheet
        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);
            if (sheet == null) {
                continue;
            }

            //遍历当前sheet中的所有行
            for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
                row = sheet.getRow(j);
                if (row == null || row.getFirstCellNum() == j) {
                    continue;
                }

                //遍历所有的列
                E e = object.newInstance();
                for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
                    cell = row.getCell(y);
                    Object value = getValue(cell);
                    if (y < titles.size()) {
                        String column = titles.get(y);
                        Field field = e.getClass().getDeclaredField(column);
                        field.setAccessible(true);
                        Type type = field.getGenericType();
                        field.set(e, Convert.convert(type, value));
                    }
                }
                list.add(e);
            }
        }

        return list;

    }

    public static Workbook getWorkbook(InputStream inStr, String fileName) throws Exception {
        Workbook wb = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if (excel2003L.equals(fileType)) {
            //2003-
            wb = new HSSFWorkbook(inStr);
        } else if (excel2007U.equals(fileType)) {
            //2007+
            wb = new XSSFWorkbook(inStr);
        } else {
            throw new Exception("解析的文件格式有误！");
        }
        return wb;
    }

    public static String getValue(Cell cell) {
        String value = "";
        if (null == cell) {
            return value;
        }
        switch (cell.getCellType()) {
            //数值型
            case Cell.CELL_TYPE_NUMERIC:
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    //如果是date类型则 ，获取该cell的date值
                    Date date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    value = format.format(date);
                    ;
                } else {// 纯数字
                    BigDecimal big = new BigDecimal(cell.getNumericCellValue());
                    value = big.toString();
                    //解决1234.0  去掉后面的.0
                    if (null != value && !"".equals(value.trim())) {
                        String[] item = value.split("[.]");
                        if (1 < item.length && "0".equals(item[1])) {
                            value = item[0];
                        }
                    }
                }
                break;
            //字符串类型
            case Cell.CELL_TYPE_STRING:
                value = cell.getStringCellValue().toString();
                break;
            // 公式类型
            case Cell.CELL_TYPE_FORMULA:
                //读公式计算值
                value = String.valueOf(cell.getNumericCellValue());
                // 如果获取的数据值为非法值,则转换为获取字符串
                if (value.equals("NaN")) {
                    value = cell.getStringCellValue().toString();
                }
                break;
            // 布尔类型
            case Cell.CELL_TYPE_BOOLEAN:
                value = " " + cell.getBooleanCellValue();
                break;
            default:
                value = cell.getStringCellValue().toString();
        }
        if ("null".endsWith(value.trim())) {
            value = "";
        }
        return value;
    }

    public static void main(String[] args) throws Exception {
//        String filepath = "D:\\app\\xls表.xls";
        String filepath = "D:\\app\\aa.xlsx";
        InputStream inputStream = new FileInputStream(new File(filepath));
        List<String> titles = Lists.newArrayList("productName", "requestNo", "spec", "age", "time");
        List<ExcelModel> list = ExcelUtils.getListByExcel(inputStream, "aa.xlsx", ExcelModel.class, titles);
        System.out.println(list);

    }


}
