package com.gecco.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternUtil {
    public static String delete(String origin){
//        Pattern bef = Pattern.compile("\\<[^\\u4e00-\\u9fa5]*\\>");
        Pattern bef = Pattern.compile("(\\<.*?\\>)|(&nbsp;)");
        Matcher matcher = bef.matcher(origin);
        String answer = matcher.replaceAll("");
        return answer;
    }
    public static String deleteForResource(String origin){
        Pattern bef = Pattern.compile("\\<.*\\>");
        Matcher matcher = bef.matcher(origin);
        String answer = matcher.replaceAll("");
        return answer;
    }

//    public static void main(String[] args) {
//        String s1 = "<a class=\"color_darkPurple\">罕见</a>-李允珍35级可传授技能";
//        System.out.println(new PatternUtil().delete(s1));
//    }
}
