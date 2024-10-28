import java.util.*;
class demo{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the password");
        String password=sc.next();
        if(check(password)){
            System.out.println("given password is strong");
        }
        else{
            String str=generate(password);
            System.out.println("given password is weak:");
            System.out.println("strong password:"+str);
        }
    }
    public static boolean check(String password){
        if(password.length()<8){
            return false;
        }
        boolean upper=false,lower=false,digit=false,special=false;
        for(int i=0;i<password.length();i++){
            char c=password.charAt(i);
            if(Character.isUpperCase(c)){
                upper=true;
            }
            if(Character.isLowerCase(c)){
                lower=true;
            }
            if(Character.isDigit(c)){
                digit=true;
            }
            if(!Character.isLetter(c) || !Character.isDigit(c)){
                special=true;
            }
        }
        return upper&&lower&&digit&&special;
    }
    public static String generate(String password){
        String upper="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower="abcdefghijklmnopqrstuvwxyz";
        String digit="0123456789";
        String special="!@?$%^&*_+";
        Random random=new Random();
        StringBuilder sb=new StringBuilder(password);
        while(sb.length()<8){
             int index=random.nextInt(lower.length());
            char randomlower=lower.charAt(index);
            sb.append(randomlower);
        }
        if(!checkupper(password)){
            int index=random.nextInt(upper.length());
            char randomupper=upper.charAt(index);
            sb.append(randomupper);
        }
        if(!checklower(password)){
             int index=random.nextInt(lower.length());
            char randomlower=lower.charAt(index);
            sb.append(randomlower);
        }
        if(!checkdigit(password)){
             int index=random.nextInt(digit.length());
            char randomdigit=digit.charAt(index);
            sb.append(randomdigit);
        }
        if(!checkspecial(password)){
             int index=random.nextInt(special.length());
            char randomspecial=special.charAt(index);
            sb.append(randomspecial);
        }
        return sb.toString();
    }
    public static boolean checkupper(String password){
        for(int i=0;i<password.length();i++){
            char c=password.charAt(i);
            if(Character.isUpperCase(c)){
                return true;
            }
        }
        return false;
    }
     public static boolean checklower(String password){
        for(int i=0;i<password.length();i++){
            char c=password.charAt(i);
            if(Character.isLowerCase(c)){
                return true;
            }
        }
        return false;
    }
     public static boolean checkdigit(String password){
        for(int i=0;i<password.length();i++){
            char c=password.charAt(i);
            if(Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }
     public static boolean checkspecial(String password){
        for(int i=0;i<password.length();i++){
            char c=password.charAt(i);
            if(!Character.isUpperCase(c) || !Character.isLowerCase(c)){
                return true;
            }
        }
        return false;
    }
}