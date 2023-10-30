public class Number {
    int value;

    public void setDenary(int value) {
        this.value = value;
    }

    public Number(int value) {
        this.value = value;
    }
    public int getDenary(){
        return this.value;
    }
    public String getSignedBinary() {
        String s = "";
        int pn=0;
        while((1<<pn)<=Math.abs(value)){
            pn++;
        }
        int pow = 1 << (pn-1), target = 0;
        if (value < 0) {
            target = (1<<pn) + value;
            s += '1';
        } else {
            target = value;
            s += '0';
        }
        for (int i = 1; i <= pn; i++) {
            if (target >= pow) {
                target -= pow;
                s += '1';
            } else {
                s += '0';
            }
            pow /= 2;
        }
        return s;
    }
    public String getHexadecimal(){
        String s=getSignedBinary(),ans="";
        int rem=s.length()%4;
        for(int i=0;i<s.length()/4+(rem!=0?1:0);i++){
            int num=0;
            for(int j=3;j>=0;j--){
                if(i==0&&rem!=0&&j>=rem)continue;
                if(s.charAt((i-1)*4+(3-j)+(rem==0?4:rem))=='1'){
                    num+=(1<<j);
                }
            }
            if(num==0)continue;
            if(num<=9){
                ans+=(char)(num+'0');
            }
            else{
                num-=10;
                ans+=(char)(num+'A');
            }
        }
        return ans;
    }
    public void negate(){
        this.value*=-1;
    }
    public String toString(){
        String s="Number{denary="+Integer.toString(value)+" binary="+getSignedBinary()+" hexadecimal="+getHexadecimal()+"}";
        return s;
    }
}
