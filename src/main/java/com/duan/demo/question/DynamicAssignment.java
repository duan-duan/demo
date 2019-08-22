package com.duan.demo.question;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.text.MessageFormat;

/**
 * @Description:
 * @author: wangruirui
 * @date: 2019/06/20
 */
public class DynamicAssignment {
    public static void main(String[] args){

        ExpressionParser parser = new SpelExpressionParser();


        String expression = "({0}$0}{1})$1}{2}$2}{3}";
        Double[] paramArray = {1.4,3.5,3.2,4.1};
        Object[] operatorArry = {"+","*","/"};

        expression = MessageFormat.format(expression, paramArray);

        expression = expression.replaceAll("\\$","{");

        expression = MessageFormat.format(expression, operatorArry);


        int two1 = parser.parseExpression(expression).getValue(Integer.class);

        System.out.println(two1);


        System.out.println(calculate(3,2,2));


    }

    public static int calculate(int a,int b,int c){
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp3 = parser.parseExpression("("+a+" + "+b+") * "+c);
        int msg3 = (Integer) exp3.getValue();
        return msg3;

    }

}
