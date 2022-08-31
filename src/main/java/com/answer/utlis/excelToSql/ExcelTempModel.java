package com.answer.utlis.excelToSql;

import lombok.Data;

/**
 * @author liufeng
 * @version: V1.0
 * @data: 2022/8/31 10:47
 * @className: ExcelTempModel
 * @packageName: com.answer.utlis.excelToSql
 * @description:
 */
@Data
public class ExcelTempModel {
    private String pageCode;

    private String uniqueKey;

    private String name;

    private String chineseName;

    private String englishName;

    private String pageModule;

    private String menu;
}
