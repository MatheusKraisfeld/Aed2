import java.io.*;
import java.*;
import java.util.Formatter;
import java.util.Scanner;
import java.io.File;
import java.nio.charset.*;

class MyIO {
 
   private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in, Charset.forName("ISO-8859-1")));
   private static String charset = "ISO-8859-1";
 
   public static void setCharset(String charset_){
      charset = charset_;
      in = new BufferedReader(new InputStreamReader(System.in, Charset.forName(charset)));
   }
 
   public static void print(){
   }
 
   public static void print(int x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      }
      catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }
 
   public static void print(double x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      }
      catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }
 
   public static void print(String x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      }
      catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }
 
   public static void print(boolean x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      }
      catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }
 
   public static void print(char x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      }
      catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }
 
   public static void println(){
   }
 
   public static void println(int x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      }
      catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }
 
   public static void println(double x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      }
      catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }
 
   public static void println(String x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      }
      catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }
 
   public static void println(boolean x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      }
      catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }
 
   public static void println(char x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      }
      catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }
 
   public static void printf(String formato, double x){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.printf(formato, x);// "%.2f"
      }
      catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
   }
 
   public static double readDouble(){
      double d = -1;
      try{
         d = Double.parseDouble(readString().trim().replace(",","."));
      }
      catch(Exception e){}
      return d;
   }
 
   public static double readDouble(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }
      catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readDouble();
   }
 
   public static float readFloat(){
      return (float) readDouble();
   }
 
   public static float readFloat(String str){
      return (float) readDouble(str);
   }
 
   public static int readInt(){
      int i = -1;
      try{
         i = Integer.parseInt(readString().trim());
      }
      catch(Exception e){}
      return i;
   }
 
   public static int readInt(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }
      catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readInt();
   }
 
   public static String readString(){
      String s = "";
      char tmp;
      try{
         do{
            tmp = (char)in.read();
            if(tmp != '\n' && tmp != ' ' && tmp != 13){
               s += tmp;
            }
         }while(tmp != '\n' && tmp != ' ');
      }
      catch(IOException ioe){
         System.out.println("lerPalavra: " + ioe.getMessage());
      }
      return s;
   }
 
   public static String readString(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }
      catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readString();
   }
 
   public static String readLine(){
      String s = "";
      char tmp;
      try{
         do{
            tmp = (char)in.read();
            if(tmp != '\n' && tmp != 13){
               s += tmp;
            }
         }while(tmp != '\n');
      }
      catch(IOException ioe){
         System.out.println("lerPalavra: " + ioe.getMessage());
      }
      return s;
   }
 
   public static String readLine(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }
      catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readLine();
   }
 
   public static char readChar(){
      char resp = ' ';
      try{
         resp  = (char)in.read();
      }
      catch(Exception e){}
      return resp;
   }
 
   public static char readChar(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }
      catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readChar();
   }
 
   public static boolean readBoolean(){
      boolean resp = false;
      String str = "";
   
      try{
         str = readString();
      }
      catch(Exception e){}
   
      if(str.equals("true") || str.equals("TRUE") || str.equals("t") || str.equals("1") || 
            str.equals("verdadeiro") || str.equals("VERDADEIRO") || str.equals("V")){
         resp = true;
      }
   
      return resp;
   }
 
   public static boolean readBoolean(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }
      catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      return readBoolean();
   }
 
   public static void pause(){
      try{
         in.read();
      }
      catch(Exception e){}
   }
 
   public static void pause(String str){
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      }
      catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
      pause();
   }
}

//-----------------------------------------------//----------------------------------------//------------------------
public class TP03Q01LerArquivo{
   public static void main(String[] args) {
      int contador;
      double numeros;
      long pos;
   
      try{
         RandomAccessFile arq = new RandomAccessFile("Escrita.txt", "rw");//crio um arquivo txt chamado Escrita
         contador = MyIO.readInt();//leio o primeiro inteiro que o arquivo(pub.in) possui;
        
         for (int i = 0;i<contador;i++) {//leio os doubles do pub.in e escrevo eles no Escrita.txt;
            numeros = MyIO.readDouble();
            arq.writeDouble(numeros);
         }
         
         pos = arq.getFilePointer() - 8;
      
         //pelos numeros serem double temos que andar de 8 em 8;  
         for(long i=pos;i>=0;i=i-8){
            
            arq.seek(i);
            double entrada = arq.readDouble();
            if(entrada == (int)entrada){
               MyIO.println((int)entrada);
            }
            else{
               MyIO.println(entrada);	
            }
         
         
         }
      
      
         arq.close();
      }
      catch(IOException ex){
         System.out.println(ex.toString());
      }
   
   
   }

}
