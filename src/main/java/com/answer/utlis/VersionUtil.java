package com.answer.utlis;

/**
 * @author lix
 * @title: 版本管理工具类
 * @date 2022/2/1814:31
 */
public class VersionUtil {

    /**
     * @description: 升级版本
     * @author lix
     * @date 2022/2/18 14:32
     */
    public static String upgradeVersion(String version) {
        int versionNum = Integer.parseInt(version);
        versionNum += 1;
        //如果+1后的长度小于version的长度，则需要补0，大于则不用补
        if (String.valueOf(versionNum).length() < version.length()) {
            int num = version.length() - String.valueOf(versionNum).length();
            String result = "";
            for (int i = 0; i < num; i++) {
                result = result.concat("0");
            }
            return result + versionNum;
        }
        return versionNum + "";
    }

    public static void main(String[] args) {
        System.out.println(upgradeVersion("99999"));
    }
}
