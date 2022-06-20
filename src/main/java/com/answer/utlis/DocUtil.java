package com.answer.utlis;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.xmlbeans.XmlCursor;
import org.assertj.core.util.Lists;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liufeng
 * 2022/1/28 10:20
 */
public class DocUtil {

    public static void main(String[] args) throws IOException {
        writeWord();
    }

    public static void writeWord() throws IOException {
        String templatePath = "template/demo.docx";
        Resource resource = new ClassPathResource(templatePath);
        InputStream inputStream = resource.getInputStream();
        XWPFDocument docx = new XWPFDocument(inputStream);

        List<XWPFParagraph> paragraphs = docx.getParagraphs();
        for (int i = 0; i < paragraphs.size(); i++) {
            XWPFParagraph xwpfParagraph = paragraphs.get(i);
            DocUtil.replaceText(xwpfParagraph);
        }

        for (int i = 0; i < paragraphs.size(); i++) {
            XWPFParagraph xwpfParagraph = paragraphs.get(i);
            List<XWPFRun> xwpfRuns = xwpfParagraph.getRuns();
            for (int k = 0; k < xwpfRuns.size(); k++) {
                XWPFRun xwpfRun = xwpfRuns.get(k);
                if (xwpfRun.toString().contains("${title}")) {
                    String str = xwpfRun.toString();
                    xwpfRun.setText(str.replace("${title}", "文本模板"), 0);
                }

                if (xwpfRun.toString().contains("${first_content}")) {
                    String str = xwpfRun.toString();
                    xwpfRun.setText(str.replace("${first_content}", "文本模板内容1"), 0);
                }

                if (xwpfRun.toString().contains("${third}")) {
                    String str = xwpfRun.toString();
                    xwpfRun.setText(str.replace("${third}", "文本模板内容3"), 0);
                }

                if (xwpfRun.toString().contains("${second_content}")) {
                    String str = xwpfRun.toString();
                    xwpfRun.setText(str.replace("${second_content}", "文本模板内容2"), 0);
                }

                if (xwpfRun.toString().contains("${name}")) {
                    String str = xwpfRun.toString();
                    xwpfRun.setText(str.replace("${name}", "高效液相色谱法"), 0);
                }

                if (xwpfRun.toString().contains("${equiments}")) {
                    String str = xwpfRun.toString();
                    xwpfRun.setText(str.replace("${equiments}", "设备1 仪器2 仪器3"), 0);
                }

                if (xwpfRun.toString().contains("${inspectionItemList}")) {
                    List<String> data = Lists.newArrayList("30℃", "20℃", "20g", "10g/s");
                    List<List<String>> datas = new ArrayList<>();
                    datas.add(data);
                    XmlCursor tableCursor = xwpfParagraph.getCTP().newCursor();
                    insertTable(tableCursor, docx, Lists.newArrayList("柱温", "进样盘温度", "进样量", "流速"), datas);
                }

                if (xwpfRun.toString().contains("${pic}")) {
                    InputStream is = null;
                    try {
                        String path = "12.png";
                        Resource re = new ClassPathResource(path);
                        is = re.getInputStream();
                        xwpfRun.addPicture(is, XWPFDocument.PICTURE_TYPE_PNG, "pic.png", Units.toEMU(200), Units.toEMU(200));
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        if (is != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    String str = xwpfRun.toString();
                    xwpfRun.setText(str.replace("${pic}", ""), 0);


                    XmlCursor cursor3 = xwpfParagraph.getCTP().newCursor();
                    XWPFParagraph newPara3 = docx.insertNewParagraph(cursor3);
                    newPara3.createRun().setText("图片", 0);
                    XmlCursor cursor = xwpfParagraph.getCTP().newCursor();
                    XWPFParagraph newPara = docx.insertNewParagraph(cursor);
                    newPara.setAlignment(ParagraphAlignment.CENTER);//居中
                    XWPFRun newParaRun = newPara.createRun();
                    InputStream ips = null;
                    try {
                        String path = "12.png";
                        Resource re = new ClassPathResource(path);
                        ips = re.getInputStream();
                        newParaRun.addPicture(ips, XWPFDocument.PICTURE_TYPE_PNG, "pic.png", Units.toEMU(200), Units.toEMU(200));
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        if (ips != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    XmlCursor cursor4 = xwpfParagraph.getCTP().newCursor();
                    XWPFParagraph newPara4 = docx.insertNewParagraph(cursor4);
                    //居中
                    newPara4.setAlignment(ParagraphAlignment.CENTER);
                    XWPFRun newParaRun4 = newPara4.createRun();
                    InputStream ips1 = null;
                    try {
                        String path = "12.png";
                        Resource re = new ClassPathResource(path);
                        ips1 = re.getInputStream();
                        newParaRun4.addPicture(ips1, XWPFDocument.PICTURE_TYPE_PNG, "pic2.png", Units.toEMU(200), Units.toEMU(200));
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        if (ips1 != null) {
                            try {
                                ips1.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }

        //创建表格
        XWPFTable xwpfTable = docx.createTable(2, 2);
        xwpfTable.getRow(0).getCell(0).setText("aa");
        xwpfTable.getRow(0).getCell(1).setText("bb");
        XWPFTableRow tableRow = xwpfTable.getRow(1);
        tableRow.getCell(0).setText("12");
        tableRow.getCell(1).setText("34");

        //获取文档的表格
        List<XWPFTable> tables = docx.getTables();
        XWPFTable table = tables.get(0);
        //第一行为title  第二行填充数据
        for (XWPFTableRow row : table.getRows()) {
            List<XWPFTableCell> cells = row.getTableCells();
            boolean removeFlag = false;
            for (XWPFTableCell cell : cells) {
                String cellValue = cell.getText();
                if ("${productBatchNo}".equals(cellValue)) {
                    cell.setText("10");
                }
                if ("${storageCondition}".equals(cellValue)) {
                    removeFlag = true;
                    break;
                }

                //在表格指定的列中添加表格
                if ("${inspectionItemList}".equals(cellValue)) {
                    List<XWPFParagraph> pps = cell.getParagraphs();
                    for (XWPFParagraph p : pps) {
                        DocUtil.replaceText(p);
                        for (XWPFRun r : p.getRuns()) {
                            String text = r.getText(0);
                            if ("${inspectionItemList}".equals(text)) {
                                r.setText("", 0);
                            }
                        }
                    }

                    List<String> titles = Lists.newArrayList("指标", "指标说明", "公式", "参考值", "说明", "计算值");
                    //需要插入的数据
                    List<String> datas = Lists.newArrayList("1", "2", "3", "4", "5", "6");
                    inserTableToCell(cell, titles, datas);
                }
            }

        }


        //创建表格
        List<String> data = Lists.newArrayList("30℃", "20℃", "20g", "10g/s", "");
        List<String> data2 = Lists.newArrayList("", "20℃", "20g", "10g/s", "table");
        List<List<String>> datas = new ArrayList<>();
        datas.add(data);
        datas.add(data2);
        createTableAndMerge(docx, Lists.newArrayList("柱温", "进样盘温度", "进样量", "流速", "标准"), datas);

        //输出到write.docx
        OutputStream os = new FileOutputStream("D:\\app\\write.docx");
        docx.write(os);
        inputStream.close();
        os.close();
    }

    public static void replaceText(XWPFParagraph para) {
        List<XWPFRun> runs = para.getRuns();
        //合并 "产品规格：${"，"productSpecification"，"}"
        String str = "";
        for (int i = 0; i < runs.size(); i++) {
            XWPFRun run = runs.get(i);
            String runText = run.toString();
            str = str + runText;
        }
        System.out.println("解析到word模板:" + str);
        for (int i = runs.size() - 1; i >= 0; i--) {
            para.removeRun(i);
        }
        para.insertNewRun(0).setText(str);
    }

    /**
     * 在指定列插入表格
     *
     * @param cell
     * @param titles
     * @param datas
     */
    private static void inserTableToCell(XWPFTableCell cell, List<String> titles, List<String> datas) {
        XWPFParagraph paragraph = cell.addParagraph();
        XmlCursor cursor = paragraph.getCTP().newCursor();
        String uri = CTTbl.type.getName().getNamespaceURI();
        String localPart = "tbl";
        cursor.beginElement(localPart, uri);
        cursor.toParent();
        CTTbl t = (CTTbl) cursor.getObject();
        XWPFTable table = new XWPFTable(t, cell);

        int size = titles.size();
        XWPFTableRow row = table.getRow(0);
        for (int col = 1; col < size; col++) {//默认会创建一列，即从第2列开始
            // 第一行创建了多少列，后续增加的行自动增加列
            CTTcPr cPr = row.createCell().getCTTc().addNewTcPr();
            CTTblWidth width = cPr.addNewTcW();
        }

        for (int i = 0; i < size; i++) {
            tableTextCenter(row, i);
            String title = titles.get(i);
            row.getCell(i).setText(title);
        }

        XWPFTableRow row1 = table.createRow();
        for (int i = 0; i < size; i++) {
            tableTextCenter(row1, i);
            String item = datas.get(i);
            row1.getCell(i).setText(item);
        }

        //开始合并列，将第一行的4,5列合并
        mergeLine(table, 1, 3, 4);
    }


    /**
     * 表格文字居中
     *
     * @param row   行
     * @param index 列所在位置
     */
    public static void tableTextCenter(XWPFTableRow row, int index) {
        XWPFTableCell tableCell = row.getCell(index);
        CTTc cttc = tableCell.getCTTc();
        CTTcPr ctPr = cttc.addNewTcPr();
        ctPr.addNewVAlign().setVal(STVerticalJc.CENTER);
        cttc.getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
    }


    /**
     * 获取文件模板对象
     *
     * @param templatePath 模板路径
     * @return
     * @throws IOException
     */
    public static XWPFDocument getDoc(String templatePath) throws IOException {
        Resource resource = new ClassPathResource(templatePath);
        InputStream inputStream = resource.getInputStream();
        return new XWPFDocument(inputStream);
    }

    public static void createTableAndMerge(XWPFDocument docx, List<String> titles, List<List<String>> tableDatas) {
        //创建表格
        int row = tableDatas.size() + 1;
        int cell = titles.size();
        XWPFTable xwpfTable = docx.createTable(row, cell);
        for (int index = 0; index < cell; index++) {
            //设置表头
            xwpfTable.getRow(0).getCell(index).setText(titles.get(index));
        }

        for (int index = 0; index < tableDatas.size(); index++) {
            //设置表格数据
            XWPFTableRow tableRow = xwpfTable.getRow(index + 1);
            List<String> datas = tableDatas.get(index);
            for (int k = 0; k < titles.size(); k++) {
                if ("table".equals(datas.get(k))) {
                    //插入表格
                    List<String> titleList = Lists.newArrayList("指标", "指标说明", "公式", "参考值", "说明", "计算值");
                    //需要插入的数据
                    List<String> dataList = Lists.newArrayList("1", "2", "3", "4", "5", "6");
                    XWPFTableCell tableCell = tableRow.getCell(k);
                    inserTableToCell(tableCell, titleList, dataList);
                } else {
                    tableRow.getCell(k).setText(datas.get(k));
                }
            }
        }

        //开始合并列，将第一行的4,5列合并
        mergeLine(xwpfTable, 1, 3, 4);

        //合并行，将第1行跟第2行的第一列数据合并
        mergeColumn(xwpfTable, 0, 1, 2);

    }

    //row 指定行、fromCell 开始列数、toCell 结束列数。
    public static void mergeLine(XWPFTable table, int row, int fromCell, int toCell) {
        for (int cellIndex = fromCell; cellIndex <= toCell; cellIndex++) {
            XWPFTableCell cell = table.getRow(row).getCell(cellIndex);
            if (cellIndex == fromCell) {
                cell.getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.RESTART);
            } else {
                cell.getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.CONTINUE);
            }
        }
    }

    // word表格跨行并单元格
    //col 指定列、fromRow 开始行、toRow 结束行。
    public static void mergeColumn(XWPFTable table, int col, int fromRow, int toRow) {
        for (int rowIndex = fromRow; rowIndex <= toRow; rowIndex++) {
            XWPFTableCell cell = table.getRow(rowIndex).getCell(col);
            if (rowIndex == fromRow) {
                cell.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.RESTART);
            } else {
                cell.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.CONTINUE);
            }
        }
    }


    /**
     * 创建表格填充数据
     *
     * @param titles     表头
     * @param tableDatas 数据
     */
    public static void createTable(XWPFDocument docx, List<String> titles, List<List<String>> tableDatas) {
        //创建表格
        int row = tableDatas.size() + 1;
        int cell = titles.size();
        XWPFTable xwpfTable = docx.createTable(row, cell);
        for (int index = 0; index < cell; index++) {
            //设置表头
            xwpfTable.getRow(0).getCell(index).setText(titles.get(index));
        }

        for (int index = 0; index < tableDatas.size(); index++) {
            //设置表格数据
            XWPFTableRow tableRow = xwpfTable.getRow(index + 1);
            List<String> datas = tableDatas.get(index);
            for (int k = 0; k < titles.size(); k++) {
                tableRow.getCell(k).setText(datas.get(k));
            }
        }

    }

    public static void insertTable(XmlCursor cursor, XWPFDocument docx, List<String> titles, List<List<String>> tableDatas) {
        System.out.println(titles + "title");
        System.out.println(tableDatas + "tableDatas");

        XWPFTable xwpfTable = docx.insertNewTbl(cursor);
        XWPFTableRow titleRow = xwpfTable.getRow(0);
        //创建表格
        int cell = titles.size();
        for (int index = 0; index < cell; index++) {
            if (index > 0) {
                titleRow.addNewTableCell().setText(titles.get(index));
            } else {
                //设置表头
                titleRow.getCell(index).setText(titles.get(index));
            }

        }
        if (null != tableDatas) {


            for (int index = 0; index < tableDatas.size(); index++) {
                //设置表格数据
                XWPFTableRow tableRow = xwpfTable.createRow();
                List<String> datas = tableDatas.get(index);
                for (int k = 0; k < titles.size(); k++) {
                    XWPFTableCell cell1 = tableRow.getCell(k);
                    if (null != cell1) {
                        String s = datas.get(k);
                        if (StringUtils.isNotBlank(s)) {
                            cell1.setText(s);
                        }

                    }

                }
            }
        }
    }

}
