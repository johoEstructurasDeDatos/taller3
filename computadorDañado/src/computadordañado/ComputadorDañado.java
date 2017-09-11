package computadordañado;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
/**
 *
 * @author ElJoho
 */
public class ComputadorDañado{
    public static void main(String[] args)throws Exception{
        BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
        Fixer fixer;
        Scanner inp=new Scanner(System.in);
        //String line=buffer.readLine();
        StringBuilder line;
        for(int i=0;i<100&&buffer.readLine().toString().trim().length()!=0;i++){
            line=new StringBuilder(buffer.readLine());
            if(line.length()<=100000){
                fixer=new Fixer(line);
                line=fixer.fixed();
                System.out.println(line);  
            }else{};
            line=new StringBuilder(buffer.readLine());
        };
    };   
};
class Fixer{
    private char line[];
    //private String  temporal,
                    //fixed;
    private StringBuilder   temporall,
                            fixedd;
    public Fixer(){
        //this.temporal="";
        //this.fixed="";
        this.fixedd=new StringBuilder();
        this.temporall=new StringBuilder();
    };
    public Fixer(StringBuilder line){
        this();
        this.line=new char[line.length()];
        this.line=line.toString().toCharArray();
        fixing();
    };
    public void fixing(){
        for(int i=0;i<this.line.length;){
            if(i==0&&this.line[i]!='$'&&this.line[i]!='#'){
                //this.fixed+=this.line[i];
                this.fixedd.append(this.line[i]);
                i++;
            }else if(this.line[i]=='#'){
                i++;
                if(i<this.line.length){
                    while(this.line[i]!='#'&&this.line[i]!='$'&&this.line[i]!=0){
                        //this.temporal+=this.line[i];
                        this.temporall.append(this.line[i]);
                        i++;
                        if(i>=this.line.length){
                            break;
                        };
                    };
                };
                //this.temporal+=this.fixed;
                this.temporall.append(this.fixedd);
                //this.fixed=this.temporal;
                this.fixedd=this.temporall;
                //this.temporal="";
                this.temporall=new StringBuilder();
            }else if(this.line[i]=='$'){
                i++;
                if(i<this.line.length){
                    while(this.line[i]!='#'&&this.line[i]!='$'&&this.line[i]!=0){
                        //this.temporal+=this.line[i];
                        this.temporall.append(this.line[i]);
                        i++;
                        if(i>=this.line.length)
                            break;
                    };
                };
                //this.fixed+=this.temporal;
                this.fixedd.append(this.temporall);
                //this.temporal="";
                this.temporall=new StringBuilder();
            }else{
                //this.fixed+=this.line[i];
                this.fixedd.append(this.line[i]);
                i++;
            };            
        };
    };
    public StringBuilder fixed(){
        return this.fixedd;
    };
};