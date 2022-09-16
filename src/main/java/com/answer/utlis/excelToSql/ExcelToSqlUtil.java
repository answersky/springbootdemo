package com.answer.utlis.excelToSql;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.answer.utlis.ExcelUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liufeng
 * @version: V1.0
 * @data: 2022/8/31 10:33
 * @className: ExcelToSqlUtil
 * @packageName: com.answer.utlis
 * @description: excel 内容转换成sql add语句
 */
public class ExcelToSqlUtil {

    public static void main(String[] args) throws Exception {
        //读取excel
        String filePath = "D:\\app\\国际化.xls";
        String fileName = "国际化.xls";
//        List<String> titles = Lists.newArrayList("name", "chineseName", "englishName", "uniqueKey", "menu", "pageModule", "pageCode");
        List<String> titles = Lists.newArrayList("uniqueKey", "name", "chineseName", "englishName", "menu", "pageModule", "pageCode");

        List<ExcelTempModel> jsonDatas = readExcel(filePath, titles, fileName);

//        //读取json文本
//        String jsonFile = "D:\\app\\lims3.json";
//        List<ExcelTempModel> jsonDatas = readJsonText(jsonFile);

        //生成sql
        String tableName = "lims_internationalization_config";
        List<String> columns = Lists.newArrayList("name", "chinese_name", "english_name", "unique_key", "menu", "page_code", "page_module", "create_time", "tenant_id", "module_code");
        generateSql(jsonDatas, tableName, columns);
    }

    private static List<ExcelTempModel> readJsonText(String filePath) throws IOException {
        List<ExcelTempModel> list = new ArrayList<>();
        File file = new File(filePath);
        String content = FileUtils.readFileToString(file, "UTF-8");
        JSONArray arr = JSON.parseArray(content);
        for (int i = 0; i < arr.size(); i++) {
            JSONObject jsonObject = arr.getJSONObject(i);
            ExcelTempModel excelTempModel = new ExcelTempModel();
            excelTempModel.setName(jsonObject.getString("name"));
            excelTempModel.setUniqueKey(jsonObject.getString("uniqueKey"));
            excelTempModel.setEnglishName(jsonObject.getString("englishName"));
            System.out.println(excelTempModel);
            list.add(excelTempModel);
        }
        return list;
    }

    private static void generateSql(List<ExcelTempModel> dataList, String tableName, List<String> columns) {
        if (ObjectUtil.isNotEmpty(dataList)) {
            for (ExcelTempModel excelTempModel : dataList) {
                List<String> data = Lists.newArrayList(excelTempModel.getName(), excelTempModel.getChineseName(), excelTempModel.getEnglishName(), excelTempModel.getUniqueKey(), excelTempModel.getMenu(),
                        excelTempModel.getPageCode(), excelTempModel.getPageModule());
                String sql = "insert into " + tableName + "(" + StringUtils.join(columns, ",") + ") values ('" + StringUtils.join(data, "','") + "',now(),'MD20210918064853y3','qclims');";
                System.out.println(sql);
                writeToText(sql);
            }
        }
    }

    private static void writeToText(String sql) {
        File file = new File("D:\\app\\sql3.txt");
        FileWriter writer = null;
        try {
            //覆盖写入 是否追加 true
            writer = new FileWriter(file, true);
            writer.write(sql + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<ExcelTempModel> readExcel(String filePath, List<String> titles, String fileName) throws Exception {
        InputStream inputStream = new FileInputStream(new File(filePath));
        List<ExcelTempModel> list = ExcelUtils.getListByExcel(inputStream, fileName, ExcelTempModel.class, titles);
        return list;
    }
}
