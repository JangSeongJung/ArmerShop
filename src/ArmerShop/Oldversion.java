package ArmerShop;
import java.util.Scanner;
public class Oldversion {
    public static void main(String[] args) {
        float[][] players1=Howmanyp();  // 총 몇명이냐
        float[][] story=new float[20][5]; // 구매 스토리 저장
        int story1=1; // 구입하는 모든 스토리의 순번
        int dayend=0; // 날 종료
        int theend=0; // 최종종료
        int nextplayer=0; // 다음플레이어로 돌릴 것인가.

        String[][] playernames1=Playernamearray(players1); // 플레이어 이름 어레이 새로 생성
        playernames1=Playernamein(players1,playernames1); // 플레이어 이름2 입력
        players1=Playerinformin1(); // 플레이어 정보1 입력
        String[] columnname=Columnname();                // 리스트의 이름 정리
        Playersnow(players1,playernames1,columnname); // 현재 플레이어 정보 총정리

        String armersname[]=Armername();              // 무기 이름
        String armerssort[]=Armersort();              // 무기 소분류
        float inven1[][]=Inven1();            // 무기들의 정보 입력
        float invenP1[][]=InvenP1();
        float invenP2[][]=InvenP2();
        float invenP3[][]=InvenP3(); // player 1 2 3 의 인벤토리를 만들어주자
        String armernamecolumn[]=Columnname2();        // 무기리스트 컬럼이름
        Armersnow(inven1,armernamecolumn,armersname,armerssort);
        int[] Usernow=new int[100];  //  지금 접속하는 유저의 데이터 배열

        for(int day=1;;day++){  // 하루의 턴이다.
            dayend=0; // 다음 날짜로 선택하는 옵션 리셋
            invenP1 = Durareset(invenP1);
            invenP2 = Durareset(invenP2);
            invenP3 = Durareset(invenP3); // 플레이어들의 인벤토리에 보유한 무기들의 내구도가 하루에 1%씩 감소한다.
            inven1=Selreset(inven1,day); // 3일 지났다면 팔렸던 것 리셋

            // --------------------------------------------------------------------------------------------------------------------------------------------------------
            story[0][0]=story[0][1]; //어제 최종 금액이 오늘의 시작금액이 된다.
            players1=Dailystart(players1,day); //플레이어의 당일 시작금액 리셋 및 하루 시작 멘트
            for(;;){ //특정플레이어 로그인  -- 특정 플레이어의 턴
                Usernow=Login(playernames1, Usernow); // 로그인여부 확인
                int p = Usernow[0]; // 현재 몇번째 플레이어인가
                if(Usernow[1]==1) {
                    for( ; ; ) { // 1 회선택
                        nextplayer = 0; // 다음 플레이어로 선택하는 옵션 리셋
                        inven1 = Selprice(inven1, players1, p); // 판매금액을 플레이어에 맞게 재설정
                        int sel1 = Select1(); // 뭐할지 골라라
                        switch (sel1) {
                            case (1):
                                Scanner SC = new Scanner(System.in);
                                listment(Usernow); // 전체인벤, 개인인벤 선택
                                int sel2 = SC.nextInt();
                                showlist(inven1, armernamecolumn, armersname, armerssort, sel1, sel2, p, invenP1, invenP2, invenP3); // 인벤 보여주는 메서드
                                break;
                            case (2):
                                int i = Findarmername("구입"); //살 무기 번호 입력
                                float nowplayerhave=Nowplayerhave(p,invenP1,invenP2,invenP3,i); //지금 플레이어가 가졌는지 확인한 결과
                                if (inven1[i][8]==0 && inven1[i][9] != 0) { // 구입한 내역이 있고 아직 리셋되지 않았다면
                                    System.out.println("선택하신 무기는 아직 구매하실 수 없습니다.");
                                } else if(nowplayerhave!=0) {
                                    System.out.println("현재 플레이어가 이미 구입한 무기입니다.");
                                } else {
                                    float price1 = inven1[i][4]; // 현재 해당 무기의 보정된 판매금액
                                    story = Storyadd(story, story1, day, i, price1, p); // 구입내역 스토리에 추가
                                    story1++; // 스토리 다음 행으로 늘려라
                                    players1[p][6] = players1[p][6] - price1; // 각 플레이어의 현재 금액에서 구입한 금액만큼 제외
                                    if(p==1){ // 각 플레이어의 인벤토리에 입력
                                        invenP1=Personaladd(inven1,invenP1,i);
                                    }else if(p==2){
                                        invenP2=Personaladd(inven1,invenP2,i);
                                    }else if(p==3){
                                        invenP3=Personaladd(inven1,invenP3,i);
                                    }
                                    inven1[i][8]--;
                                    inven1[i][9] = day; // 3일간 못 사도록 오늘 날짜를 기입
                                    System.out.println("무기 구입을 완료했습니다.");
                                }
                                break;
                            case (3):
                                int j = Findarmername("판매"); //판매할 무기 번호 입력
                                if(p==1){ // 각 플레이어의 인벤토리에 입력
                                    players1=selitem2(invenP1,players1,inven1,j,p);
                                    invenP1=selitem1(invenP1,players1,inven1,j,p);
                                    inven1=selitem3(invenP1,inven1,j);
                                }else if(p==2){
                                    players1=selitem2(invenP2,players1,inven1,j,p);
                                    invenP2=selitem1(invenP2,players1,inven1,j,p);
                                    inven1=selitem3(invenP2,inven1,j);
                                }else if(p==3){
                                    players1=selitem2(invenP3,players1,inven1,j,p);
                                    invenP3=selitem1(invenP3,players1,inven1,j,p);
                                    inven1=selitem3(invenP3,inven1,j);
                                }
                                break;
                            case (4):
                                Nextplayer(players1, p);
                                nextplayer=1;
                                break;
                            case (5):

                                dayend = 1;
                                break;
                            case (6):
                                System.out.println("모든 구매활동을 종료합니다.");
                                theend = 1;
                                break;
                            case (0):

                                f2ArrayShow(players1);
                                f2ArrayShow(story);
                                //s2ArrayShow(playernames1);
                                //s1ArrayShow(columnname);
                                //s1ArrayShow(armersname);
                                //s1ArrayShow(armerssort);
                                //f2ArrayShow(inven1);
                                //f2ArrayShow(invenP1);
                                //i1ArrayShow(Usernow);
                                break;
                            default:
                                System.out.println("1~4 중 하나를 선택하셔야 합니다.");
                        }
                        if(theend==1 || dayend==1 || nextplayer==1){
                            break;
                        }
                    } // 1회선택 종료
                }
                if(theend==1 || dayend==1){
                    break;
                }
            } // 특정플레이어 턴 종료
            story=Dayend(story,day); // 마무리 멘트 및 스토리 정리
            if(theend==1){
                break;
            }
        } // 하루 턴 종료
    } //------------------------------------------------------------main 종료

    public static void f2ArrayShow(float[][] array){
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[0].length; j++){
                System.out.print(array[i][j]+"   ");
            }
            System.out.println("");
        }
    }
    public static void s2ArrayShow(String[][] array){
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[0].length; j++){
                System.out.print(array[i][j]+"   ");
            }
            System.out.println("");
        }
    }
    public static void s1ArrayShow(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "   ");
        }
    }
    public static void i1ArrayShow(int[] array){
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+"   ");
        }
    }
    public static float Nowplayerhave(int p, float[][]invenP1, float[][]invenP2, float[][]invenP3, int i){
        float nowplayerhave=0;
        if (p == 1) {
            nowplayerhave=invenP1[i][6];
        } else if (p == 2) {
            nowplayerhave=invenP2[i][6];
        } else if (p == 3) {
            nowplayerhave=invenP3[i][6];
        }
        return nowplayerhave;
    }
    public static float[][] selitem3(float[][]invenP1, float[][]inven1, int j){
        if (invenP1[j][5] == 100) {
            inven1[j][8]++;
            System.out.println("판매가 완료되었습니다.");
        }
        return inven1;
    }
    public static float[][] selitem1(float[][]invenP1, float[][] players1, float[][]inven1, int j, int p){
        if (invenP1[j][5] != 100) {
            if (players1[p][8]==18) { // 다 수리하기로 한 게 맞다면
                invenP1[j][5] = 100;
                System.out.println("해당 무기를 수리 완료하였습니다. 다시 판매작업을 진행해 주십시오.");
            }
        }else{
            invenP1[j][6]--;
        }
        return invenP1;
    }
    public static float[][] selitem2(float[][]invenP1, float[][] players1, float[][]inven1, int j, int p){
        if (invenP1[j][5] != 100) {
            System.out.println("판매하고자 하는 무기의 현재 내구도가 100%가 아닙니다. 수리하시겠습니까? 1.예 2.아니오");
            Scanner SC2 = new Scanner(System.in);
            int sel3 = SC2.nextInt();
            if(sel3==1){
                float selprice=((100-invenP1[j][5])/100)*inven1[j][5]; // 채우기 위한 금액 선정
                players1[p][6]=players1[p][6]-selprice; // 우선 내구도 안바꾸고 금액 변경
                players1[p][8]=18; // 모두 수리하기로 했느냐
            }
        }
        return players1;
    }
    public static void listment(int[] Usernow){
        System.out.println("현재 "+Usernow[0]+"번 플레이어입니다.");
        System.out.println("1.무기 판매리스트 보기  2.플레이어 인벤토리 보기");
    }
    public static void showlist(float[][] inven1,String[] armernamecolumn,String[] armersname, String[] armerssort,int sel1, int sel2, int p,float[][] invenP1,float[][] invenP2,float[][] invenP3){
        if(sel2==1){
            Armersnow(inven1,armernamecolumn,armersname,armerssort);
        }else if(sel2==2) {
            if (p == 1) {
                ArmersnowP1(invenP1, armersname, armerssort);
            } else if (p == 2) {
                ArmersnowP1(invenP2, armersname, armerssort);
            } else if (p == 3) {
                ArmersnowP1(invenP3, armersname, armerssort);
            }
        }else{
            System.out.println("1과 2 중에 고르시오.");
        }
    }
    public static int[] Login(String[][] playernames1, int[] Usernow) {
        Scanner SC = new Scanner(System.in);
        System.out.println("ID를 입력하십시오.");
        String  ID1 = SC.next(); // 아이디입력
        String pw1="";
        int anyID=0;
        for(int i=1; i<=playernames1.length-1; i++){
            if(playernames1[i][0].equals(ID1)){
                Usernow[0]=i;
                pw1=playernames1[i][1];
                anyID++;
            }
        }
        if(anyID==0){
            System.out.println("ID를 확인하십시오.");
            Usernow[1]=0;
        }else{
            System.out.println("패스워드를 입력하십시오");
            String  pw2 = SC.next(); // 패스워드 입력
            if(pw2.equals(pw1)){
                System.out.println("로그인이 완료되었습니다.");
                Usernow[1]=1;
            }else{
                System.out.println("패스워드를 확인하십시오");
                Usernow[1]=0;
            }
        }
        return Usernow;
    }
    public static float[][] Dayend(float[][] story,  int day){
        System.out.println(day+"번째 날의 구입이 모두 종료되었습니다.");
        for(int k=1; k<=story.length-1; k++){
            if(story[k][1]==day){ // 오늘 사람들이 산걸 다 더한다.
                story[0][1]=story[0][1]+story[k][4]; // 맨 윗줄은 모든 매출의 합산이다 맨 왼칸은 어제까지 한칸 오른쪽은 오늘까지
            }
        }
        System.out.println("금일 판매된 총 금액은 "+(story[0][1]-story[0][0])+"원이며 현재까지 누적 수익은 "+story[0][1]+"원입니다.");
        return story;
    }
    public static float[][] Durareset(float[][] invenP){
        for(int i=0; i<=2; i++){
            for(int j=1; j<=6; j++) {
                if (invenP[i * 10 + j][6] != 0) {
                    invenP[i * 10 + j][5]--;
                }
            }
        }
        return invenP;
    }
    public static float[][] Selreset(float[][] inven1,  int day){
        for(int k=1; k<=inven1.length-1; k++){
            if(inven1[k][8]==0 && inven1[k][9]<=day-3){ // 만약 팔렸던 무기인데 팔린 후 3일이 지났다면 리셋
                inven1[k][9]=0;
                inven1[k][8]=1;
            }
        }
        return inven1;
    }
    public static void Nextplayer(float[][] players1, int p){
        if(players1[p][5]-players1[p][6]!=0){
            System.out.println(p+"번째 플레이어는 오늘 총 "+(players1[p][5]-players1[p][6])+"원을 사용하였으며 현재 남은 금액은 "+players1[p][6]+"원 입니다.");
        }
        System.out.println("다음 플레이어로 넘어갑니다.");
    }

    public static float[][] Personaladd(float[][] inven1, float[][] invenP, int i){
        invenP[i][0]=inven1[i][0];
        invenP[i][1]=inven1[i][1];
        invenP[i][2]=inven1[i][2];
        invenP[i][3]=inven1[i][5];
        invenP[i][4]=inven1[i][6];
        invenP[i][5]=inven1[i][7];
        invenP[i][6]++;
        return invenP;
    }
    public static float[][] Storyadd(float[][] story, int story1, int day, int i, float price1, int p){
        story[story1][0]=story1+1; story[story1][1]=day;
        story[story1][2]=p; story[story1][3]=i; story[story1][4]=price1;  // 스토리에 입력
        return story;
    }
    public static float[][] Dailystart(float[][] players1, int day){
        System.out.println(day+"일차 거래를 시작합니다."); // 하루(한 턴의 시작)
        for(int p=1; p<=players1.length-1; p++){ // 모든 플레이어 오늘 시작 금액 리셋
            if(players1[p][6]!=0){
                players1[p][5]=players1[p][6];
            }else{
                players1[p][5]=players1[p][4];
                players1[p][6]=players1[p][4];
            }
        }
        return players1;
    }

    public static int Findarmername(String act){ //--------------------------------------------------------------------------
        int namenum1=0;
        Scanner SC = new Scanner(System.in);
        System.out.println(act+"하고자 하는 무기의 번호를 입력하십시오.");
        namenum1 = SC.nextInt(); // 무기 번호입력
        return namenum1;
    }
    public static int Select1(){
        System.out.println("플레이어의 공격력+방어력+숙련도 를 모두 합한 스탯의 0.1배한 퍼센티지로 무기의 판매금액이 산정됩니다");
        System.out.println("구입한 무기는 하루에 1%씩 내구도가 감소합니다.");
        System.out.println("선택하시오. 1.무기리스트 2.무기구입 3.무기판매 4.다음사람 5.다음날 6.구입전체종료");
        Scanner SC = new Scanner(System.in);
        int sel1 = SC.nextInt();
        return sel1;
    }
    public static float[][] Selprice(float[][] inven1, float[][] players1, int p) { // 플레이어의 스탯으로 구입금액 조정
        for(int i=1; i<=inven1.length-1; i++){
            float stat=(players1[p][1]+players1[p][2]+players1[p][3])*0.1f;
            float ratio=(100+stat)/100;
            for(int j=1; j<=inven1.length-1; j++){
                inven1[i][4]=inven1[i][3]*ratio;
            }
        }
        return inven1;
    }
    public static void ArmersnowP1(float[][] invenP1,  String[] armersname, String[] armerssort) {
        System.out.println("\n현재 보유한 무기들의 정보입니다."); // 무기정리 언급
        System.out.print("순번  무기종류  소분류  힘  민첩   내구도  보유개수");
        System.out.println("");
        for(int i=0; i<=2; i++){
            for(int j=1; j<=6; j++) {
                if (invenP1[i * 10 + j][6] != 0) {
                    System.out.println((i * 10 + j) + "    " + armersname[i] + "   " + armerssort[j - 1] + " " + invenP1[i * 10 + j][2]
                            + " " + invenP1[i * 10 + j][3] + "   " + invenP1[i * 10 + j][4] + "   " + invenP1[i * 10 + j][5]+ "   " + invenP1[i * 10 + j][6]);

                }
            }
        }
    }
    public static void Armersnow(float[][] inven1, String[] armersnamecolumn, String[] armersname, String[] armerssort) {
        System.out.println("\n현재 무기들의 정보입니다."); // 무기정리 언급
        for(int i=0; i<=7; i++){
            System.out.print(armersnamecolumn[i]+"  ");
        }
        System.out.println("");
        for(int i=0; i<=2; i++){
            for(int j=1; j<=6; j++){
                String selOK="";
                if(inven1[i*10+j][8]==0){
                    selOK="판매불가";
                }else{
                    selOK="판매가능";
                }
                System.out.println((i*10+j)+"    "+armersname[i]+"   "+armerssort[j-1]+" "+inven1[i*10+j][3]
                        +" "+inven1[i*10+j][4]+"   "+inven1[i*10+j][5]+"   "+inven1[i*10+j][6]+"   "+inven1[i*10+j][7]+"   "+inven1[i*10+j][8]+"   "+selOK);
            }
        }
    }
    public static String[] Columnname2() {
        String columname2[]=new String[]{"순번","무기종류","소분류","기본가격","판매가격","힘","민첩","내구도","현재개수"};
        return columname2;
    }
    public static String[] Armersort(){
        String arms2[]=new String[]{"입문용","블론즈등급","실버등급","골드등급","전설등급","소장용한정판"};
        return arms2;
    }
    public static String[] Armername(){
        String[] arms=new String[]{"도끼","검","면봉"};
        return arms;
    }
    public static float[][] InvenP1(){
        float[][] invenP1=new float[31][10];
        return invenP1;
    }
    public static float[][] InvenP2(){
        float[][] invenP2=new float[1000][1000];
        return invenP2;
    }
    public static float[][] InvenP3(){
        float[][] invenP3=new float[1000][1000];
        return invenP3;
    }
    public static float[][] Inven1(){
        float[][] Inven1=new float[31][10];

        for(int i=0; i<=2; i++){
            for(int j=1; j<=10; j++){
                Inven1[i*10+j][0]=i*10+j;
                Inven1[i*10+j][1]=i+1;
                Inven1[i*10+j][2]=j;
                Inven1[i*10+j][3]=5000;
                Inven1[i*10+j][5]=80;
                Inven1[i*10+j][6]=60;
                Inven1[i*10+j][7]=100;
                Inven1[i*10+j][8]=1;
                Inven1[i*10+j][9]=0;
            }
        }
        Inven1[0][3]=10;
        return Inven1;
    }
    public static void Playersnow(float[][] players1, String[][] playernames1, String[] Columnname) {
        System.out.println("현재 플레이어들의 정보입니다."); // 우선 제목
        for(int i=0; i<=4; i++){
            System.out.print(Columnname[i]+" ");
        }
        System.out.println("");  // 엔터 한번 넣어주고
        for(int i=1; i<=players1.length-1; i++){
            System.out.println(players1[i][0]+"  "+playernames1[i][0]+"   "+players1[i][2]+
                    "  "+players1[i][3]+"  "+players1[i][4]);
        }
    }
    public static String[] Columnname() { // 중간에 이름만 다른 배열에서 끌고 옴
        String Columname[]=new String[]{"순번","이름","공격력","방어도","숙련도","초기금액","오늘초기금액","현재보유금액"};
        return Columname;
    }

    public static float[][] Playerinformin1() { // 이것도 지정
        float[][] players1=new float[][]{{0,0,0,0,0,0,0,0,0},{1,1,10,20,30,50000,0,0,0},{2,2,40,50,60,100000,0,0,0},{3,3,70,80,90,200000,0,0,0}};
        return players1;
    }
    public static String[][] Playernamein(float[][] players1, String[][] playernames1) {
        playernames1=new String[][]{{"",""},{"a","aa"},{"b","bb"},{"c","cc"}}; // 우선 지정
        return playernames1;
    }
    public static String[][] Playernamearray(float[][] players1) { // 이름은 텍스트이므로 따로 생성
        String[][] playernames1;
        playernames1=new String[players1.length][20]; //플레이어 이름
        return playernames1;
    }
    public static float[][] Howmanyp() {
        float players1[][];
        /*
        System.out.println("플레이어가 몇 명입니까?");
        Scanner SC = new Scanner(System.in);
        int playersall = SC.nextInt(); // 총 몇명인지 입력하라
        */
        int playersall=3;  // 일단 3명으로 지정
        players1=new float[playersall+1][100]; //플레이어 속성 : 0순번, 1공격력, 2방어력, 3숙련도, 4초기금액, 5당일거래전금액, 6현재금액
        return players1;
    }
}
// 판매했을 때 왜 2개가 늘어나는지를 체크하라