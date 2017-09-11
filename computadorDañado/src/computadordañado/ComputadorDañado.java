package computadordañado;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 *
 * @author ElJoho
 */
public class ComputadorDañado{
    public static void main(String[] args)throws Exception{
        BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
        Fixer fixer;
        String line=buffer.readLine();
        boolean stop=false;
        for(int i=0;i<100&&stop==false;i++){
            if(line.length()<=100000){
                fixer=new Fixer(line);
                line=fixer.fixed();
                System.out.println(line);  
            };
            stop=isEmptyString(line);
            line=buffer.readLine();
        };
    };
    static boolean isEmptyString(String str) {
        if(str==null)return true;
        if(str.length()==0)return true;
        if(str.trim().length()==0)return true;
        for(int n=0;n<str.length();n++) 
            if(!Character.isSpace(str.charAt(n)))return false;
        return true;
    };    
};
class Fixer{
    private char line[];
    private String begin;
    private String end;
    private String fixed;
    public Fixer(){
        this.begin="";
        this.end="";
        this.fixed="";
    };
    public Fixer(String line){
        this();
        this.line=new char[line.length()];
        this.line=line.toCharArray();
        fixing();
    };
    public void fixing(){
        for(int i=0;i<this.line.length;){
            if(i==0&&this.line[i]!='$'&&this.line[i]!='#'){
                fixed+=this.line[i];
                i++;
            }else if(this.line[i]=='#'){
                i++;
                if(i<this.line.length){
                    while(this.line[i]!='#'&&this.line[i]!='$'&&this.line[i]!=0){
                        this.begin+=this.line[i];
                        //System.out.print("i: "+i);
                        i++;
                        if(i>=this.line.length){
                            //System.out.print(" yep ");
                            break;
                        };
                    };
                };
                this.begin+=this.fixed;
                this.fixed=this.begin;
                this.begin="";
                //System.out.println(" ."+this.fixed);
            }else if(this.line[i]=='$'){
                i++;
                if(i<this.line.length){
                    while(this.line[i]!='#'&&this.line[i]!='$'&&this.line[i]!=0){
                        this.end+=this.line[i];
                        i++;
                        if(i>=this.line.length)
                            break;
                    };
                };
                this.fixed+=this.end;
                this.end="";
            }else{
                this.fixed+=this.line[i];
                i++;
            };            
        };
    };
    public String fixed(){
        return this.fixed;
    };
};