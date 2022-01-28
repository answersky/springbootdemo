package com.answer.utlis;

import org.apache.poi.xwpf.usermodel.*;
import org.assertj.core.util.Lists;
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
        String templatePath = "template/moban.docx";
        Resource resource = new ClassPathResource(templatePath);
        InputStream inputStream = resource.getInputStream();
        XWPFDocument docx = new XWPFDocument(inputStream);

        List<XWPFParagraph> paragraphs = docx.getParagraphs();
        for (XWPFParagraph xwpfParagraph : paragraphs) {
            //获取该段所有的文本对象
            List<XWPFRun> runs = xwpfParagraph.getRuns();
            for (XWPFRun xwpfRun : runs) {
                if (xwpfRun.toString().contains("${title}")) {
                    String str = xwpfRun.toString();
                    xwpfRun.setText(str.replace("${title}", "文本模板"), 0);
                }

                if (xwpfRun.toString().contains("${first_content}")) {
                    String str = xwpfRun.toString();
                    xwpfRun.setText(str.replace("${first_content}", "文本模板内容1"), 0);
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
            }
        }

        //获取文档的表格
        List<XWPFTable> tables = docx.getTables();
        XWPFTable table = tables.get(0);
        //第一行为title  第二行填充数据
        XWPFTableRow row = table.getRow(1);
        List<XWPFTableCell> cells = row.getTableCells();
        for (XWPFTableCell cell : cells) {
            cell.setText("10");
        }

        //创建表格
        List<String> data = Lists.newArrayList("30℃", "20℃", "20g", "10g/s");
        List<List<String>> datas = new ArrayList<>();
        datas.add(data);
        createTable(docx, Lists.newArrayList("柱温", "进样盘温度", "进样量", "流速"), datas);

        //输出到write.docx
        OutputStream os = new FileOutputStream("D:\\app\\write.docx");
        docx.write(os);
        inputStream.close();
        os.close();
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

}
