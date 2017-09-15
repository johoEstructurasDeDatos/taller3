package distribucioncelular;
import static java.lang.System.gc;
import java.util.Scanner;
/**
 *
 * @author ElJoho
 */
public class DistribucionCelular{
    private static Scanner inp=new Scanner(System.in);
    public static void main(String[] args)throws Exception{
        byte T=(byte)inp.nextInt();
        int n;
        int H;
        Pile antennas=new Pile();
        if(T>=1&&T<=10){
            for(int i=0;i<T;i++){
                n=inp.nextInt();
                if(n>=2&&n<=1000000){
                    for(int i1=0;i1<n;i1++){
                       H=inp.nextInt();
                       if(H>=1&&H<=100000000)
                            System.out.print(antennas.push(H)+" ");
                       else{
                       };
                    };
                    System.out.println("");
                }else{
                };
                antennas.hReset();
                n=0;
                H=0;
            };
        }else{
        };
    };
};
class Antenna{
    int antenna[]=new int[2],
        big[]=new int[2];
    boolean biggest;
    Antenna next;
    
    public Antenna(){
        this.biggest=false;
        this.antenna[0]=this.big[0]=0;
        this.antenna[1]=this.big[1]=1;
        this.next=null;
    }
    public Antenna(int heigth){
        this();
        this.antenna[0]=heigth;  
    }
};

class Pile{
    private Antenna top,
                    end;
    private int size;
    public Pile(){
        this.top=null;
        this.size=0;
    };
    public int push(int heigth){
        Antenna next=new Antenna(heigth);
        next.next=this.top;
        this.top=next;
        signal();
        this.size++;
        return this.top.antenna[1];
    };
    public void pull(){
        this.top=top.next;
        this.size--;
    };
    public void hReset(){
        this.top=null;
        this.size=0;
        System.gc();
    };
    public void signal(){
        Antenna A=this.top.next;
        for(int i=0;i<this.size;i++){
            if(A.biggest){
                if(this.top.antenna[0]>=A.antenna[0]){
                    this.top.antenna[1]+=A.antenna[1];
                    this.top.biggest=true;
                    this.top.big[0]=A.big[0];
                    this.top.big[1]=A.big[1];
                }else{
                };
                i=this.size;
            }else if(this.top.antenna[0]>=A.antenna[0]){
                A=A.next;
                this.top.antenna[1]++;
            }else if(this.top.antenna[0]>=A.big[0]){
                this.top.antenna[1]+=A.big[1]-1;
                this.top.big[0]=A.big[0];
                this.top.big[1]=A.big[1];
                i=size;
            }else{
                A=A.next;
                this.top.antenna[1]++;
            };            
        };
    };
};