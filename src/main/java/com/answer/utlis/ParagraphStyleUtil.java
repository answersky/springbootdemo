package com.answer.utlis;

import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import java.util.List;

/**
 * @author liufeng
 * @version: V1.0
 * @data: 2022/7/5 10:29
 * @className: ParagraphStyleUtil
 * @packageName: com.answer.utlis
 * @description: 设置文本样式工具
 */
public class ParagraphStyleUtil {
    /**
     * 段落缩进
     *
     * @param paragraph
     */
    public static void setIndentationFirstLine(XWPFParagraph paragraph) {
        paragraph.setFirstLineIndent(400);
    }

    /**
     * 设置文本样式
     *
     * @param run
     * @param text
     */
    public static void setText(XWPFRun run, String text) {

    }

    /**
     * 设置标题 根据富文本的tag来判断
     *
     * @param run
     * @param title
     */
    public static void setTitle(XWPFRun run, String title) {
        // 加粗
        run.setBold(true);
        run.setFontSize(TitleFontEnum.getFontByTitle(title));
    }

    /**
     * 设置单元格水平位置和垂直位置
     *
     * @param xwpfTable
     * @param verticalLoction    单元格中内容垂直上TOP，下BOTTOM，居中CENTER，BOTH两端对齐
     * @param horizontalLocation 单元格中内容水平居中center,left居左，right居右，both两端对齐
     */
    public static void setCellLocation(XWPFTable xwpfTable, String verticalLoction, String horizontalLocation) {
        List<XWPFTableRow> rows = xwpfTable.getRows();
        for (XWPFTableRow row : rows) {
            List<XWPFTableCell> cells = row.getTableCells();
            for (XWPFTableCell cell : cells) {
                CTTc cttc = cell.getCTTc();
                CTP ctp = cttc.getPList().get(0);
                CTPPr ctppr = ctp.getPPr();
                if (ctppr == null) {
                    ctppr = ctp.addNewPPr();
                }
                CTJc ctjc = ctppr.getJc();
                if (ctjc == null) {
                    ctjc = ctppr.addNewJc();
                }
                ctjc.setVal(STJc.Enum.forString(horizontalLocation)); //水平居中
                cell.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.valueOf(verticalLoction));//垂直居中
            }
        }
    }

    /**
     * 设置表格位置
     *
     * @param xwpfTable
     * @param location  整个表格居中center,left居左，right居右，both两端对齐
     */
    public static void setTableLocation(XWPFTable xwpfTable, String location) {
        CTTbl cttbl = xwpfTable.getCTTbl();
        CTTblPr tblpr = cttbl.getTblPr() == null ? cttbl.addNewTblPr() : cttbl.getTblPr();
        CTJc cTJc = tblpr.addNewJc();
        cTJc.setVal(STJc.Enum.forString(location));
    }

    /**
     * 设置图片居中
     *
     * @param xwpfParagraph
     */
    public static void setImageCenter(XWPFParagraph xwpfParagraph) {
        //居中
        xwpfParagraph.setAlignment(ParagraphAlignment.CENTER);
    }
}
