package com.ghostben.forcesolve;
/**
 * @program: arithmetic
 * @description: 处理程序的边沿问题，例如使用if来排除程序中的特殊情况
 * @author: ghostben
 * @create: 2018-10-02 01:18
 **/
public class DealConQues {
    public static void main(String[] args) {

        cancleDiff("safsda dfds dfdf,sdfd,ererew,dfddf");
        dealFinalDiff("abcdefg");
    }

    /**
    *@author    : Microphoneben
    *@date      : 2018/10/2
    *@description : DealConQues
    *一刀切方法： 通过使用事先补齐的方式，通过设法补充我们的问题，让边沿跟中间的处理逻辑一致。这样我们就可以使用一刀切的方法处理问题
    */
    public static void cancleDiff(String string){
        //这里使用一刀切防范处理这个问题，所以我们首先扩充这个字符串
        string += ',';

        //定义一个空字符串使用来进行保存切割出来的子字符串
        String stringCopy = " ";
        for(int i = 0; i < string.length(); i++){
            char ch = string.charAt(i);
            if(ch != ' ' && ch != ','){
                //追加字符串
                stringCopy += ch;
            }else{
                System.out.println(stringCopy);
                // 清空字符串
                stringCopy = " ";
            }
        }
    }
    /**
    *@author    : Microphoneben
    *@date      : 2018/10/2
    *@description : DealConQues
    *一刀切方法： 通过使用事后修正的方式，通过修正我们没有处理到的问题的边缘，增加问题的后续处理方式，这样我们就可以使用一刀切的方法处理问题
     * 在给定的字符串中，每一个字符后添加一个“,”。
    */
    public static void dealFinalDiff(String string){
        //用来存放结果的字符串
        String resultString = "";
        for (int i = 0; i < string.length(); i++){
            resultString += "," + string.charAt(i);
        }
        resultString = resultString.substring(1);
        System.out.println(resultString);
    }
}