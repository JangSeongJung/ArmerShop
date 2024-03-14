package ArmerShop;

import java.util.ArrayList;

public class UserArmerNames {
    ArrayList<ArrayList<String>> plna = new ArrayList<>(); //playernames1
    ArrayList<String> arna = new ArrayList<>(); //armersname
    ArrayList<String> colna = new ArrayList<>(); //columnname
    ArrayList<String> arsort = new ArrayList<>(); //armerssort
    ArrayList<Integer> usernow =new ArrayList<>(); //usernow



    public void Arraysize(int rowN,int columnN) { // 2차원 배열 초기 사이즈 설정하고 0으로 입력해 주는 메소드
        for (int i = 0; i < rowN; i++) {
            ArrayList<String> row = new ArrayList<>();
            for (int j = 0; j < columnN; j++) {
                if (j == 0) {
                    row.add(i+"");
                } else {
                    row.add("");
                }
            }
            plna.add(row);
        }
    }
    public void Playersnamesin() {
        ArrayChange(0,0,"");
        ArrayChange(0,1,"");
        ArrayChange(1,0,"a");
        ArrayChange(1,1,"aa");
        ArrayChange(2,0,"a");
        ArrayChange(2,1,"aa");
        ArrayChange(3,0,"a");
        ArrayChange(3,1,"aa");
    }

    public void ArrayChange(int rowToChange,int columnToChange,String newValue){
        plna.get(rowToChange).set(columnToChange, newValue);
    }
    public void ArmerNamesIn(){
        arna.add("도끼"); arna.add("검"); arna.add("활");
    }
    public void ColNamesIn(){
        colna.add("순번"); colna.add("이름");colna.add("공격력");colna.add("방어도");
        colna.add("숙련도");colna.add("초기금액");colna.add("금일시작금액");colna.add("현재보유금액");
    }
    public void ArmarSortIn(){
        arsort.add("입문용");arsort.add("블론즈");arsort.add("실버");arsort.add("골드");arsort.add("전설");arsort.add("소장용한정판");
    }
    public void UsernowIn(){
        usernow.add(0);usernow.add(0);
    }
    public String GetValue(int rown, int coln){
        String value;
        value=plna.get(rown).get(coln);
        return value;
    }

    public void PlNaListOut(int startN){
        System.out.println("아이디   비번");
        for (int i=startN; i<=plna.size()-1; i++) {
            for (int j=0; j<=plna.get(i).size()-1; j++) {
                String value=plna.get(i).get(j);
                System.out.print(value+ "       ");
            }
            System.out.println();
        }
    }
    public void UserNowOut(int startN){
        for (int i=startN; i<=usernow.size()-1; i++) {
            int value=usernow.get(i);
            System.out.print(value+"  ");
        }
        System.out.println("");
    }
    public void ColNameOut(int startN){
        for (int i=startN; i<=colna.size()-1; i++) {
            String  value=colna.get(i);
            System.out.print(value+"  ");
        }
        System.out.println("");
    }
    public void ArmerSortOut(int startN){
        for (int i=startN; i<=arsort.size()-1; i++) {
            String  value=arsort.get(i);
            System.out.print(value+"  ");
        }
        System.out.println("");
    }
    public void ArNameListOut(int startN){
        for (int i=startN; i<=arna.size()-1; i++) {
            String  value=arna.get(i);
            System.out.print(value+"  ");
        }
        System.out.println("");
    }


}
