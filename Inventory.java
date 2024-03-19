package ArmerShop;

import java.util.ArrayList;

public class Inventory {
    ArrayList<ArrayList<Integer>> inven = new ArrayList<>();

    public void Arraysize(int rowN,int columnN) { // 2차원 배열 초기 사이즈 설정하고 0으로 입력해 주는 메소드
        for (int i = 0; i < rowN; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < columnN; j++) {
                if (j == 0) {
                    row.add(i);
                } else {
                    row.add(0);
                }
            }
            inven.add(row);
        }
    }
    public void ListOut(int startN,int playersall){

        for (int i=startN; i<=inven.size()-1; i++) {
            if(i==startN){
                for(int k=0; k<=playersall-1; k++){
                    System.out.print("무기이름 무기등급 힘   민첩   내구도  보유개수        ");
                }
                System.out.println("");
            }
            for(int k=0; k<=playersall-1; k++){
                int temnum=0;
                for(int l=0; l<=playersall-1; l++){
                    temnum=temnum+inven.get(i).get(l*10+6);
                }
                if(temnum!=0){
                    for (int j=1; j<=6; j++) {  // 만약 개인 인벤토리의 항목이 늘어난다면 리미트숫자를 늘려주어야 함
                        int value=inven.get(i).get(k*10+j);  // 사람 명수에 따라 오른쪽으로 열칸씩 증가, 0인덱스는 순번이고 1~10 이 한명 인벤
                        System.out.print(value+ "      ");
                    }
                    System.out.println();
                }
            }
        }
    }
    public void ArrayChange(int rowToChange,int columnToChange,int newValue){
        inven.get(rowToChange).set(columnToChange, newValue);
    }
    public void AddColumn(){
        for(int i=0; i<inven.size(); i++){
            inven.get(i).add(0);
        }
    }
    public void DelColumn(int delcomnum){
        for(int i=0; i<inven.size(); i++){
            inven.get(i).remove(delcomnum);
        }
    }
    public int GetValue(int rown, int coln){
        int value;
        value=inven.get(rown).get(coln);
        return value;
    }
    public int HowmanyColumn(){
        int value;
        value=inven.get(0).size();
        return value;
    }
    public int HowmanyRow(){
        int value;
        value=inven.size();
        return value;
    }
    public void AddRow(int story1) { // 2차원 배열 초기 사이즈 설정하고 0으로 입력해 주는 메소드
        ArrayList<Integer> row = new ArrayList<>();
        int i= inven.get(0).size();
        int r=inven.size();
        for (int j = 0; j < i; j++) {
            if (j == 0) {
                row.add(story1);
            } else {
                row.add(0);
            }
        }
        inven.add(row);
    }
}

