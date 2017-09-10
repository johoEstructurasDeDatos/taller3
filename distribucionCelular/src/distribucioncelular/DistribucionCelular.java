package distribucioncelular;
/**
 *
 * @author ElJoho
 */
public class DistribucionCelular{
    public static void main(String[] args){
        
    };
};
class Antenna{
    private int antenna[]=new int[2],
                big[]=new int[2],
                little[]=new int[2];
    private boolean biggest;
    private Antenna next;
    
    public Antenna(){
        this.biggest=false;
        this.antenna[0]=this.big[0]=this.little[0]=0;
        this.antenna[1]=this.big[1]=this.little[1]=1;
        this.next=null;
    };
    public Antenna(int heigth){
        this();
        setHeigth(heigth);  
    };
    public void setBiggest(boolean is){
        this.biggest=is;
    };
    public boolean biggest(){
        return this.biggest;
    };
    public int signal(){
        return this.antenna[1];
    };
    public void setSignal(int signal){
        this.antenna[1]+=signal;
    };
    public int heigth(){
        return this.antenna[0];
    };
    public void setHeigth(int heigth){
        this.antenna[0]=heigth;
    };
    public int big(int box){
        return this.big[box];
    };
    public void setBig(int box,int value){
        this.big[box]=value;
    };
    public int little(int box){
        return this.little[box];
    };
    public void setLittle(int box,int value){
        this.little[box]=value;
    };
    public void setNext(Antenna next){
        this.next=next;
    };
    public Antenna next(){
        return this.next;
    };
};

class Butty{
    Antenna     begin,
                end;
    int size;
    //Constructores
    public Butty(){
        this.begin=this.end=null;
        this.size=0;
    };
    //Modificadores
    public void insert(int heigth){
        Antenna next=new Antenna(heigth);
        if(voidButty())
            this.begin=next;
        else
            end.setNext(next);
        this.end=begin;
        size++;
    };
    public void remove(){
        begin=begin.next();
        size--;
    };
    //Emisores
    public int signal(){
        return end.signal();
    };
    public boolean voidButty(){
        return this.begin==null;
    };
    public int size(){
        return this.size;
    };
    
};