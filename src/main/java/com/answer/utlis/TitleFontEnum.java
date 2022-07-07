package com.answer.utlis;

/**
 * @author liufeng
 * @version: V1.0
 * @data: 2022/7/5 10:27
 * @className: TitleFontEnum
 * @packageName: com.answer.utlis
 * @description: 设置标题字体大小
 */
public enum TitleFontEnum {
    H1("h1", 26),
    H2("h2", 24),
    H3("h3", 22);
    private String title;
    private Integer font;

    public String getTitle() {
        return title;
    }

    public Integer getFont() {
        return font;
    }

    TitleFontEnum(String title, Integer font) {
        this.title = title;
        this.font = font;
    }

    public static Integer getFontByTitle(String title) {
        for (TitleFontEnum e : TitleFontEnum.values()) {
            if (title.equals(e.getTitle())) {
                return e.getFont();
            }
        }
        return null;
    }
}
