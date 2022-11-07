package com.answer.utlis;

/**
 * @author liufeng
 * @version: V1.0
 * @data: 2022/9/16 14:24
 * @className: TextCircledEnum
 * @packageName: com.answer.utlis
 * @description:
 */
public enum TextCircledEnum {

    Zero("\\\\textcircled\\{0\\}", "⓪"),
    One("\\\\textcircled\\{1\\}", "①"),
    Two("\\\\textcircled\\{2\\}", "②"),
    Three("\\\\textcircled\\{3\\}", "③"),
    Four("\\\\textcircled\\{4\\}", "④"),
    Five("\\\\textcircled\\{5\\}", "⑤"),
    Six("\\\\textcircled\\{6\\}", "⑥"),
    Seven("\\\\textcircled\\{7\\}", "⑦"),
    Eight("\\\\textcircled\\{8\\}", "⑧"),
    Nine("\\\\textcircled\\{9\\}", "⑨"),
    Ten("\\\\textcircled\\{10\\}", "⑩");

    TextCircledEnum(String code, String v) {
        this.code = code;
        this.v = v;
    }

    public final String code;
    public final String v;

    public static String replaceTextCircled(String latex) {
        for (TextCircledEnum c : TextCircledEnum.values()) {
            latex = latex.replaceAll(c.code, c.v);
        }
        return latex;
    }
}
