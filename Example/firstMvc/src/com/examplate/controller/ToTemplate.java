package com.examplate.controller;

import com.examplate.SpareInfo;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
public class ToTemplate {
    @RequestMapping("temp")
    public String callTemplate(Model model) {
        List<SpareInfo> list = new ArrayList<SpareInfo>();
        SpareInfo info = new SpareInfo();
        info.setTemplateId(1);
        info.setIsOriginal("否");
        info.setBigClass("基础信息");
        info.setSmallClass("物料编码");
        info.setOriginalItem("小刀");
        info.setPrimitiveItems("铁");
        info.setSubstituteItem("菜刀");
        info.setSortNo("1");
        list.add(info);
        SpareInfo info1 = new SpareInfo();
        info1.setTemplateId(2);
        info1.setIsOriginal("否");
        info1.setBigClass("基础信息");
        info1.setSmallClass("功能位置");
        info1.setOriginalItem("麻袋");
        info1.setPrimitiveItems("塑料");
        info1.setSubstituteItem("清洁袋");
        info1.setSortNo("2");
        list.add(info1);
        SpareInfo info2 = new SpareInfo();
        info2.setTemplateId(3);
        info2.setIsOriginal("否");
        info2.setBigClass("基础信息");
        info2.setSmallClass("质保等级");
        info2.setOriginalItem("橘子");
        info2.setPrimitiveItems("水果");
        info2.setSubstituteItem("香蕉");
        info2.setSortNo("3");
        list.add(info2);
        try {
            // 获取一个模板对象
            Template t = getTemplate("spareinfo.ftl");
            // 执行插值，并输出到指定的输出流中
            Writer writer = new StringWriter();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("mblist", list);// list变了前台数据
            map.put("bigClass", list.get(0).getBigClass());//
            map.put("isOriginal", list.get(0).getIsOriginal());// 否否原物项
            t.process(map, writer);
            String s = writer.toString();
            model.addAttribute("info",s);
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "list";
    }

    /**
     * 获取模板文件
     * @param name
     * @return
     */
    public Template getTemplate(String name){
        Template template = null;
        String classpath = this.getClass().getResource("/").getPath().replaceFirst("/", "");
        String webappRoot = classpath.replaceAll("classes/", "ftl/");
        Configuration cfg = new Configuration();
        try {
            cfg.setDirectoryForTemplateLoading(new File(webappRoot));
            template = cfg.getTemplate(name);
        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return template;
    }
}
