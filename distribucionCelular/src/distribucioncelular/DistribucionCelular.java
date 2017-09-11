package distribucioncelular;
import java.util.Scanner;
/**
 *
 * @author ElJoho
 */
public class DistribucionCelular{
    public static void main(String[] args)throws Exception{
        Scanner inp=new Scanner(System.in);
        byte T=(byte)inp.nextInt();
        int n;
        int H;
        Pile antennas=new Pile();
        if(T>=1&&T<=10){
            for(int i=0;i<T;i++){
                n=inp.nextInt();
                if(n>=2&&n<=1000000){
                    antennas=new Pile(n);
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
                antennas.clear();
                n=0;
                H=0;
            };
        }else{
        };
    };
};

class Pile{
    private int antennas[][][];
    private int buzy;
    public Pile(){
        this.buzy=0;
    };
    public Pile(int antennas){
        this();
        this.antennas=new int[2][3][antennas];
    };
    public int push(int heigth){
        this.antennas[0][0][this.buzy]=heigth;
        this.antennas[0][1][this.buzy]++;
        this.antennas[1][0][this.buzy]=this.antennas[1][0][this.buzy]=0;//Altura del ultimo grande
        this.antennas[1][1][this.buzy]=this.antennas[1][1][this.buzy]=1;
        signal();
        this.buzy++;
        return this.antennas[0][1][this.buzy-1];
    };
    public void signal(){
        //System.out.println("Buzy: "+this.buzy);
        if(this.buzy==0){
            this.antennas[0][2][0]=1;//Biggest
            //System.out.print("6. ");   
        }else{
            for(int i=this.buzy;i>0;i--){
                if(this.antennas[0][2][i-1]==1){//¿el anterior es el mayor de todos?
                    if(this.antennas[0][0][this.buzy]>=this.antennas[0][0][i-1]){
                        this.antennas[0][1][this.buzy]+=this.antennas[0][1][i-1];//Señal
                        this.antennas[0][2][this.buzy]=1;//Biggest
                        this.antennas[1][0][this.buzy]=this.antennas[1][0][i-1];//Altura del ultimo grande
                        this.antennas[1][1][this.buzy]=this.antennas[1][1][i-1];//Señal del ultimo grande
                        //System.out.println("1. ");
                    }else{
                        //System.out.println("2. ");
                    };
                    i=-1;
                }else if(this.antennas[0][0][this.buzy]>=this.antennas[0][0][i-1]){//Anterior no es el mayor de todos,es mayor que el anterior?
                    this.antennas[0][1][this.buzy]++;
                    //System.out.print("3. ");
                }else if(this.antennas[0][0][this.buzy]>=this.antennas[1][0][i-1]){
                    this.antennas[0][1][this.buzy]+=this.antennas[1][1][i-1]-1;//Señal
                    this.antennas[1][0][this.buzy]=this.antennas[1][0][i-1];//Altura del ultimo grande
                    this.antennas[1][1][this.buzy]=this.antennas[1][1][i-1];//Señal del ultimo grande
                    i=-1;
                    //System.out.print("4. ");
                }else{
                    this.antennas[0][1][this.buzy]++;
                    //System.out.print("5. ");
                }; 
            };
        };
    };
    public void clear(){
        this.antennas=new int[1][1][1];
        this.antennas[0][0][0]=0;
        this.buzy=0;
    };
};