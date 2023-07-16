import java.util.*;
class Sudukoo{
    static int ele[][]=new int[9][9];
    public answer(){
        int r=0,c=0;
        ArrayList a = new ArrayList<>();
        ArrayList b = new ArrayList<>();
        for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++){
                if(ele[i][j]!=0){
                    a.add(ele[i][j]);
                }
            }
        }
        for(int i=1;i<=9;i++){
            int s=0;
            for(int j=0;j<a.size();j++){
                if(i==a.get(j)){
                    s=1;
                }
            }
            if(s==0){
                b.add(i);
            }
        }
        while(b.size()!=0){
            boolean s1 = true;
            int p=0;
            int x,y;
            int s = b.get(0);
            for(int i=r;i<3;i++){
                for(int j=c;j<c+3;j++){
                    if(ele[i][j]==0){
                        for(int k=0;i<9;i++){
                            if(ele[i][k]!=s && ele[k][c]!=s){
                                s=true;
                            }
                            else{
                                s=false;
                            }
                        }
                        if(s=true){
                            p++;
                            x=i;
                            y=j;
                        }
                        if(p>1){
                            x=-1;
                            y=-1;
                        }
                    }
                }
            }
            if(x!=-1 && y!=-1){
                ele[i][j]=s;
                b.remove(n);
            }
            else{
                if(b.size()>1){
                    b.set(0, b.get(1));
                    b.set(b.size()-1, s);
                }
            }
        }
    }
    public static void main(String args[]){
        System.out.print("Enter the no  of given values:");
        int tot_elements;
        Scanner s = new Scanner(System.in);
        tot_elements=s.nextInt();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                ele[i][j]=0;
            }
        }
        for(int i=0;i<tot_elements;i++){
            System.out.print("Enter index row and columns : ");
            int r,c;
            r=s.nextInt();
            c=s.nextInt();
            System.out.print("Enter the number : ");
            ele[r][c]=s.nextInt();
        }
        answer();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(ele[i][j]+" ");
                if((j+1)%3==0){
                    System.out.print("| ");
                }
            }
            if((i+1)%3==0){
                System.out.print("\n- - - - - - - - - - - -\n");
            }
            else{
                System.out.print("\n");
            }
        }
    }
}