package com.answer.utlis;

import com.alibaba.fastjson.JSON;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author liufeng
 * @version: V1.0
 * @data: 2022/7/6 17:51
 * @className: SpElUtil
 * @packageName: com.answer.utlis
 * @description:
 */
public class SpElUtil {

    public static void main(String[] args) {
        EvaluationContext context = new StandardEvaluationContext();
        getStandContextBySpEl(context, "2==2");
//        getStandContextBySpEl(context,"%E6%A3%80%E9%AA%8C%E6%8A%A5%E5%91%8A%20%E6%96%87%E6%A1%A3%EF%BC%9A%E4%BA%A7%E5%93%81%E5%90%8D%E7%A7%B0%EF%BC%9Acs062402%20%E4%BA%A7%E5%93%81%E6%89%B9%E5%8F%B7%EF%BC%9Acs087%20%E6%8A%A5%E5%91%8A%E7%BC%96%E5%8F%B7%EF%BC%9AJYBGLS2022070015%24%24%");
    }

    public static Object getStandContextBySpEl(EvaluationContext context, String spEl) {
        Object obj = null;
        if (context != null && spEl != null) {
            ExpressionParser parser = new SpelExpressionParser();
            obj = parser.parseExpression(spEl).getValue(context);
        }
        System.out.println(JSON.toJSONString(obj));
        return obj;
    }
}
