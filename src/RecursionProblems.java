//14/3/2021
import java.io.*;//for files
import java.util.Scanner;//for scanner
public class RecursionProblems {

    public static void main(String[] args) throws FileNotFoundException {
                  /**Main method*/
        File inFile=new File("input.in.txt");
        if(!inFile.exists()){//if input file dose not exsist
            System.out.println("input file does not exsist!");
            System.exit(0);
        }
        
   Scanner input=new Scanner(inFile);//read input file
   PrintWriter output=new PrintWriter("input.out.txt");//crate output file
   
   int n=input.nextInt();//first number in input file
   String command=null;
   for(int i=0;i<n;i++){//iterate n number -commands number-
    command=input.next();
    
   if(command.matches("nthMultipleof")) {
        /**Command#1*/
     int num1=input.nextInt();
     int num2=input.nextInt();
     output.println("Commnad: nthMultipleof "+num1+" "+num2);
       if(nthMultipleof(num1,num2)==0)//if num1 is not multiple of num2
         output.println("Output: "+num1+" is not a multiple of "+num2);
       else
         output.println("Output: "+num1+" is the "+nthMultipleof(num1,num2)+"-th multiple of "+num2); //if num1 is multiple of num2  
    output.println("");
}
   
   if(command.matches("findSmallest")) {
       /**Command#2*/ 
       String strNum=input.next();
       String arrString[]=strNum.split(";");
       int array[]=new int[arrString.length];
       for(int j=0;j<array.length;j++){
           array[j]=Integer.parseInt(arrString[j]);
       }
    output.println("Commnad: findSmallest "+strNum); //print all numbers  
    output.println("Output: The smallest number is: "+findSamllest(array,array.length)); //print the smallest number in the array  
    output.println("");   
}
   
   if(command.matches("isPatternStringOfN")) {
       /**Command#3*/
    String str=input.next();
    int size=input.nextInt();
  output.println("Commnad: isPatternStringOfN "+str+" "+size);
        if(isPatternStringOfN(str,size))
     output.println("Output: "+str+" is a composed of a pattern of size "+size);// str size equal the number of pattern
    else
     output.println("Output: "+str+" is not composed of a pattern of size "+size);// str size was not equal to the number of pattern
  output.println("");
   }
   }
   
   output.close();//close output file
   input.close();//close input file
    }
    
 //_______________________________________________________________________   
    
public static int nthMultipleof(int a,int b){
  /** method that check if a is multiple of b or not */  
   if(a%b!=0) 
       return 0;//a is not mutiple of b
   else if(a==b)
       return 1;//a is first mutiple of b because they are equal
   else
 return 1+nthMultipleof(a-b,b);//return the nth Multiple of b
} 
//_______________________________________________________________________

public static int findSamllest(int a[],int n){
 /**method that return the smallest number in the array */ 
if(n==1) 
    return a[0];//if there is only one element it will be the smallest number
else
return Math.min(a[n-1],findSamllest(a,n-1)); //return the smallest number in the array   
}
//_______________________________________________________________________

public static boolean isPatternStringOfN(String str,int length){
    /***/  
  if(str.length()%length!=0) 
      return false;//the str length dose not equal to the pattern
  else if(str.length()==length)
      return true;//the str length equals to the pattern
 else
     return isPatternStringOfN(str.substring(length),length); //return the number of pattern
}
}
