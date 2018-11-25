public class wordBreakProblem32 {


    public static boolean breakWord(String[] dict,int indexDict,String word,int indexWord,boolean[] used,StringBuffer str){
        if(indexWord<=0){
            String asd=str.toString();
            String[] asd2=asd.split(" ");
            for (int i=asd2.length-1;i>=0;i--)
                System.out.print(asd2[i]+" ");
            System.out.println();

            return true;
        }
        for(int i=indexDict;i>=0;i--){

            if(!used[i]&&dict[i].length()<=indexWord){

                int ind=indexWord-1;
                boolean equal=true;

                for(int j=dict[i].length()-1;j>=0;j--,ind--){
                    if(dict[i].charAt(j)!=word.charAt(ind)){
                        equal=false;
                        break;
                    }
                }
                if(equal){
                  //  used[i]=true;
                 //   System.out.println("equal");
                    if(breakWord(dict,dict.length-1,word,indexWord-dict[i].length(),used,str.append(" "+dict[i]))){

                    }
                    str.delete(str.length()-dict[i].length(),str.length());
                    used[i]=false;
                }
            }
        }
         return false;
    }

    public static void main(String[] args){
        String dict[] = {"mobile","samsung","sam","sung",
                "man","mango","icecream","and",
                "go","i","like","ice","cream"};

        String word= "samsungandmango";
        boolean used[]=new boolean[dict.length];
        StringBuffer str=new StringBuffer();
        breakWord(dict,dict.length-1,word,word.length(),used,str);
    }

}
