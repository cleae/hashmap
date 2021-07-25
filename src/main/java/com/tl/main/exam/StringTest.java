package com.tl.main.exam;

public class StringTest {

        /**
         *
         * @param inputArray string字符串一维数组
         * @return string字符串一维数组
         */
        public static String[] countString (String[] inputArray) {

            int [] res =new int[26];
            for (String str :
                    inputArray) {
                char ele=str.toCharArray()[0];
                res[ele-97]++;
            }
//            String[] count =new
            StringBuilder builder=new StringBuilder();
            for (int i = 0; i < res.length; i++) {
                if (res[i] > 1){
                    int result=i+97;
                    char ch=(char) result;
                    builder.append(ch);
                }
            }
            return builder.toString().split("");
        }



    public int Maximumlength (String x) {
        if(x.length()<3){
            return 0;
        }
        int length=x.length();

        int res=0;
        for(int i=3; i<length ;i+=3){
            if(x.contains(generate(i))){
                res=Math.max(res,i);
                System.out.println("res:"+res);
            }

        }
        return res;
    }

    public String generate(int count){
            final String a="a";
            final String b="b";
            final String c="c";
            String str="";
        for (int i = 0; i < count / 3; i++) {
            str+=a;
        }
        for (int i = 0; i < count / 3; i++) {
            str+=b;
        }
        for (int i = 0; i < count / 3; i++) {
            str+=c;
        }
        return str;
    }



    public static void main(String[] args) {
        String []test= {"a","a","b","c","b"};
        String[] strings = countString(test);

        for (String string :
             strings) {
            System.out.println(string);
        }


        System.out.println((int)'a');


        System.out.println("cbacb".contains("abc"));


        String test2="abaabbcccc";

        System.out.println(new StringTest().Maximumlength(test2));


        System.out.println(new StringTest().generate(3));
    }
}
