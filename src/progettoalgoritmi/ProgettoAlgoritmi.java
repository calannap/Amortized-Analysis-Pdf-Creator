
package progettoalgoritmi;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

/**
 *
 * @author Lee
 */
public class ProgettoAlgoritmi {
   String nomeF = "",pathF = "";
   private static ProgettoAlgoritmi asd = new ProgettoAlgoritmi();
   String cond,costo1,costo2,costo3;
   int costo4,costo5,costo6,costo7,costo8;

   private ProgettoAlgoritmi (){
      
   }
   
   public static ProgettoAlgoritmi getSingle(){
        return asd;
   }
   
   public void setPath(String s){
       pathF = s;
   }
   
   public void setName(String s){
       nomeF = s;
   }
   
   public void setVar(String s1,String s2,String s3){
       cond=s1;
       costo1=s2;
       costo2=s3;
       costo3 = getCos(costo1);
       costo4=Integer.parseInt(costo3)/(Integer.parseInt(cond)-1);
       costo5=costo4*(Integer.parseInt(cond));
       costo6=Integer.parseInt(costo2)+costo5;
       costo7=(Integer.parseInt(cond))*(Integer.parseInt(cond)-1);
       costo8=costo7/(Integer.parseInt(cond));
   }
   
    public static void main(String[] args) 
    {
       
      Gui dir = new Gui();
       dir.setVisible(true);  

        
    }
    
    

    
public String getCos(String s){
    
        for (int i=0;i<s.length();i++){
            if(s.substring(i).equals("i")){
               return (s.substring(0,i));
            
            }
        }
        return "0";
    }

    
   public int proced(int i){
       
       int x=0;
       
       if(isPower(i,Integer.parseInt(cond)))
           x=i;
       else
           x=Integer.parseInt(costo2);
       return x;
       
    }
    
   public  boolean isPower(int x, int y) {
        double d = Math.log(Math.abs(x)) / Math.log(Math.abs(y));

        if ((x > 0 && y > 0) || (x < 0 && y < 0)) {
            if (d == (int) d) {
                return true;
            } else {
                return false;
            }
        } else if (x > 0 && y < 0) {
            if ((int) d % 2 == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
   public int getExp(int x,int y){
    int i=0;
       if(y>x+1)
           i=y;
       else
           i=x+1;
        for (;i<x*x*x*x;i++){
            if(isPower(i,x))
                return i;
        }
            
    return 0;
    }
   public void executeCommand(String command) {

		StringBuffer output = new StringBuffer();
                System.out.println(command);
		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
                        p.waitFor();
                        

		} catch (Exception e) {
			e.printStackTrace();
		}

		

	}
    
    public void openFile(String path){
    
    if (Desktop.isDesktopSupported()) {
    try {
        File myFile = new File(path);
        Desktop.getDesktop().open(myFile);
    } catch (IOException ex) {
        // no application registered for PDFs
    }
}}
    
    public String setCode(){
        
        String var = "\\documentclass[a4paper]{article}\n" +
        "\\usepackage{subscript}\n" +
        "\\usepackage[T1]{fontenc}\n" +
        "\\usepackage[utf8]{inputenc}\n" +
        "\\usepackage[italian]{babel}\n" +
        "\\usepackage{amsmath}\n" +
        "\\begin{document}\n" +
        "Una sequenza di n operazioni viene eseguita su una struttura dati. \\\\\n" +
        "La i-esima operazione costa "+ costo1 +" se i e' una potenza esatta di "+cond+" , altrimenti costa "+costo2+". \\\\\n" +
        "\n" +
        "\\[ {c\\textsubscript{i}} =\n" +
        "  \\begin{cases}\n" +
        "    "+costo1+"       & \\quad \\text{se i }  \\text{ e' una potenza di "+cond+"}\\\\\n" +
        "   "+costo2+"  & \\quad \\text{} \\text{altrimenti}\\\\\n" +
        "  \\end{cases}\n" +
        "\\]\n" +
        "\\\\\n" +
        "\\\\\n" +
        "{\n" +
        "\\centering\n" +
        "\\begin{tabular}{ l | c }\n" +
        "\\hline\n" +
        "i & {c\\textsubscript{i}} \\\\ \\hline\n" +
        "1 & "+proced(1)+"  \\\\\n" +
        " 2 & "+proced(2)+"  \\\\\n" +
        " 3 & "+proced(3)+"  \\\\\n" +
        " 4 & "+proced(4)+"  \\\\\n" +
        " 5 & "+proced(5)+"  \\\\\n" +
        " 6 & "+proced(6)+"  \\\\\n" +
        " 7 & "+proced(7)+"  \\\\\n" +
        " 8 & "+proced(8)+"  \\\\\n" +
        " 9 & "+proced(9)+"  \\\\\n" +
        "... & ... \\\\\n" +
        " "+(getExp(Integer.parseInt(cond),16)-1)+" & "+proced((getExp(Integer.parseInt(cond),16)-1))+"  \\\\\n" +
        " "+getExp(Integer.parseInt(cond),16)+" & "+proced(getExp(Integer.parseInt(cond),16))+"  \\\\\n" +
        "\\end{tabular}\n" +
        "}\n" +
        "$\\sum\\limits_{i=1}^n {c\\textsubscript{i}}= \\sum\\limits_{\\substack{i=1 \\\\ i\\notin"+cond+"^N}}^n "+costo2+" +\\sum\\limits_{\\substack{i=1 \\\\ i\\in"+cond+"^N}}^n "+costo1+" $\n" +
        "\\\\\n" +
        "\\\\\n" +
        "$="+costo2+"n- (\\left \\lfloor{\\lg_{"+cond+"} n}\\right \\rfloor +1) +\\frac{"+costo3+"}{"+(Integer.parseInt(cond)-1)+"} ("+cond+"^{\\left \\lfloor{\\lg_{"+cond+"} n}\\right \\rfloor+1}-1)$\n" +
        "\\\\\n" +
        "\\\\\n" +
        "$\\leq "+costo2+"n+"+costo4+"*"+""+cond+"^{\\lg {n+1}}$\n" +
        "\\\\\n" +
        "\\\\\n" +
        "$= "+costo2+"n+"+costo4+"*"+""+cond+"n$\n" +
        "\\\\\n" +
        "\\\\\n" +
        "$="+costo2+"n+"+costo5+"n="+costo6+"n$\n" +
        "\\\\\n" +
        "\\\\\n" +
        "$T(n) \\leq "+costo6+"n , \\hat{c} \\leq \\frac{"+costo6+"n}{n} = "+costo6+"$\n" +
        "\\\\\n" +
        "\\\\" +
        "Metodo del potenziale\n" +
        "\\[ {\\Phi\\textsubscript{i}} =\n" +
        "  \\begin{cases}\n" +
        "    0       & \\quad \\text{se } i=0\\\\\n" +
        "   "+costo7+"(i-"+cond+"^{\\left \\lfloor{\\lg_{"+cond+"} i}\\right \\rfloor})  & \\quad \\text{} \\text{se i $\\geq$ 1}\\\\\n" +
        "  \\end{cases}\n" +
        "\\]\n" +
        "$\\Phi\\textsubscript{i} \\geq \\Phi\\textsubscript{0} \\quad \\forall i \\geq 0$\n" +
        "\\\\\n" +        "\\\\\n" + 
        "$\\hat{c}\\textsubscript{i}=c\\textsubscript{i}+\\Delta\\Phi\\textsubscript{i}$\n" +   
        "\\\\\n" +        "\\\\\n" + 
        "caso 1 $i\\notin"+cond+"^N$\n" +
        "\\\\\n" +        "\\\\\n" + 
        "$\\hat{c}\\textsubscript{i}="+costo2+"+\\Phi\\textsubscript{i}-\\Phi\\textsubscript{i-1}= "+costo2+"+"+costo7+"(i-"+cond+"^{\\left \\lfloor{\\lg_{"+cond+"} i}\\right \\rfloor})-"+costo7+"(i-1-"+cond+"^{\\left \\lfloor{\\lg_{"+cond+"} i-1}\\right \\rfloor})$\n" +
        "\\\\\n" +         "\\\\\n" + 
        "$="+costo2+"+"+costo5+"="+costo6+"$\n" +      
        "\\\\\n" +         "\\\\\n" + 
        "caso 2 $i\\in"+cond+"^N$\n" +    
        "\\\\\n" +        "\\\\\n" + 
        "$\\hat{c}\\textsubscript{i}="+costo1+"+\\Phi\\textsubscript{i}-\\Phi\\textsubscript{i-1}= "+costo1+"+"+costo7+"(i-"+cond+"^{\\left \\lfloor{\\lg_{"+cond+"} i}\\right \\rfloor})-"+costo7+"(i-1-"+cond+"^{\\left \\lfloor{\\lg_{"+cond+"} i-1}\\right \\rfloor})$\n" +
        "\\\\\n" +         "\\\\\n" + 
        "$="+costo1+"+"+costo7+"(-i)-"+costo7+"(-1-\\frac{i}{"+cond+"})$\n" +    
        "\\\\\n" +         "\\\\\n" +      
        "$="+costo1+"-"+costo7+"i+"+costo7+"+"+costo8+"i$\n" +    
        "\\\\\n" +         "\\\\\n" +    
        "$="+costo7+"$\n" +
        "\\\\\n" +         "\\\\\n" +   
        "caso 3 $i=1$\n" +               
        "\\\\\n" +         "\\\\\n" +   
        "$\\hat{c}\\textsubscript{i}="+costo3+"+\\Phi\\textsubscript{i}-\\Phi\\textsubscript{i-1}= "+costo3+"+"+costo7+"(i-"+cond+"^{\\left \\lfloor{\\lg_{"+cond+"} i}\\right \\rfloor})$\n" +
        "\\\\\n" +         "\\\\\n" +     
        "$= "+costo3+"$\n" +
        "\\end{document}";
        return var;
    }
    
    public void execLatex(){
    try {
        
        String codice="";
        codice = this.setCode();

        File logFile=new File(pathF,nomeF+".tex");

        BufferedWriter writer = new BufferedWriter(new FileWriter(logFile));
        writer.write (codice);
            //Close writer
        writer.close();
        
        
        if(OsUtils.isWindows())
        this.openFile(pathF+"/"+nomeF+".tex");
        if(OsUtils.isMac())
        this.openFile("/"+pathF+"/"+nomeF+".tex");    
 

        } 
    catch(Exception e) 
        {
        e.printStackTrace();
        }
    
    }
    
    
    public void getPdf() throws InterruptedException{

        
             if(OsUtils.isWindows()){
                this.executeCommand("pdflatex -output-directory=\""+pathF+"\" \""+pathF+"/"+nomeF+".tex\"");
                this.openFile(pathF+"/"+nomeF+".pdf");
             }
             if(OsUtils.isMac()){
                this.executeCommand("pdflatex -output-directory=/"+pathF+" /"+pathF+"/"+nomeF+".tex");
                this.openFile("/"+pathF+"/"+nomeF+".pdf");
             }
             
             
    }
}
