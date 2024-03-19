package ArmerShop;
import java.util.ArrayList;
import java.util.Scanner;
public class ArmerShopGame{
    public static void main(String[] args) {
        //선언구역 시작
        PlayersList plli1=new PlayersList();  // 플레이어리스트 players1과 동일
        ArmersList arli1=new ArmersList(); // 무기리스트  inven1과 동일
        PurchaseStory pstory1=new PurchaseStory(); // 구입스토리
        Inventory inven1=new Inventory(); // 플레이어들의 보관함
        UserArmerNames names1=new UserArmerNames(); // 이외 잡다한 어레이리스트들 저장
        ArrayList<ArrayList<PlayersList>> plli= new ArrayList<>();
        ArrayList<ArrayList<ArmersList>> arli= new ArrayList<>();
        ArrayList<ArrayList<PurchaseStory>> pstory= new ArrayList<>();
        ArrayList<ArrayList<Inventory>> inven= new ArrayList<>();
        ArrayList<UserArmerNames> names= new ArrayList<>();
        // 선언구역 종료

        //int playersall=Howmanyp(plli1);  // 총 몇명이냐 (이건 인원수를 선택하게 만들 때 코드)
        int playersall=3;  // 일단 3명

        // 각 2차원 어레이리스트 생성 (어레이리스트의 크기에 주의)
        plli1.Arraysize(playersall+1,9); // 인원수에 따라 플레이리스트어레이 생성 기둥 일단 9개
        pstory1.Arraysize(1,5); // 컬럼5개인 스토리 어레이리스트 생성 일단 한줄
        arli1.Arraysize(31,10); // 우선 3가지 무기 6가지 종류이지만 무기*10 이므로 30줄
        inven1.Arraysize(31,playersall*10+1); // 우선 3가지 무기 6가지 종류이지만 무기*10 이므로 30줄
        names1.Arraysize(playersall+1,2);
        // 1차원 어레이리스트 생성 (직접 add 입력)
        names1.Playersnamesin();
        names1.ColNamesIn();
        names1.ArmerNamesIn();
        names1.ArmarSortIn();
        names1.UsernowIn();
        // 2차원 어레이리스트 기본정보입력
        plli1.PlayersListset(); // 플레이이리스트 초기 정보 입력
        arli1.ArmerListSet(); // 무기 순번 셋팅
        ArmerNumin(names1, arli1); // 무기 번호 입력
        arli1.ArmerValueIn(); // 무기 초기 정보 입력
        // 어레이리스트 생성 종료

        // 메인 진행 시작
        int story1=1; // 구입하는 모든 스토리의 순번
        int dayend=0; // 날 종료여부
        int theend=0; // 최종종료여부
        int nextplayer=0; // 다음플레이어로 돌릴 것인가.
        Playersnow(playersall,names1,plli1);  // 현재 플레이어들 상황을 한번 보여주고

        for(int day=1;;day++){  // 하루의 턴이다.
            dayend=0; // 다음 날짜로 선택하는 옵션 리셋
            Dailystart(playersall,inven1,day,arli1,pstory1,plli1); // 시작 멘트 및 초기 리셋작업들 진행

            for(;;){ //특정플레이어 로그인  -- 특정 플레이어의 턴
                nextplayer = 0; // 다음 플레이어로 선택하는 옵션 리셋
                Login(names1); // 로그인 과정
                int p = names1.usernow.get(0); // 현재 몇번째 플레이어인가
                if(names1.usernow.get(1)==1) {
                    for( ; ; ) { // 1 회선택
                        Selprice(plli1,p,arli1); // 구입가격 플레이어에 맞게 수정
                        int sel1=Select1(); //뭐할지 골라라.
                        switch (sel1) {
                            case (1):
                                SelectCase1(names1,inven1,p,playersall); // 전체리스트, 개인리스트 중 선택해서 보여준다.
                                break;
                            case (2):


                                break;
                            case (3):

                                break;
                            case (4):

                                break;
                            case (5):

                                dayend = 1;
                                break;
                            case (6):
                                System.out.println("모든 구매활동을 종료합니다.");
                                theend = 1;
                                break;
                            case (0):
                                // 테스트용(어레이들 출력)
                                //plli1.ListOut(0);
                                //pstory1.ListOut(0);
                                arli1.ListOut(0);
                                //inven1.ListOut(0,playersall);
                                //names1.PlNaListOut(1);
                                names1.UserNowOut(0);
                                //names1.ColNameOut(0);
                                //names1.ArNameListOut(0);
                                //names1.ArmerSortOut(0);

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

            if(theend==1){
                break;
            }
        } // 하루 턴 종료






    } // 메인 종료--------------------------------------------------------------------------
    public static void SelectCase1(UserArmerNames names1,Inventory inven1, int p, int playersall){
        Scanner SC = new Scanner(System.in);
        listment(names1); // 전체인벤, 개인인벤 선택
        int sel2 = SC.nextInt();
        if(sel2==1){
            inven1.ListOut(1,playersall); // 모두 보여주는 경우
        }else if (sel2==2) {
            inven1.ListOut(p, p); // 한명만 보여주는 경우
        }else{
            System.out.println("장난지금 나랑하냐! (1또는 2를 선택해 주십시오. 처음부터 다시 시작합니다)");
        }
    }
    public static void listment(UserArmerNames names1){
        System.out.println("현재 "+names1.usernow.get(0)+"번 플레이어입니다.");
        System.out.println("1.무기 판매리스트 보기  2.플레이어 인벤토리 보기");
    }
    public static int Select1(){
        System.out.println("플레이어의 공격력+방어력+숙련도 를 모두 합한 스탯의 0.1배한 퍼센티지로 무기의 판매금액이 산정됩니다");
        System.out.println("구입한 무기는 하루에 1%씩 내구도가 감소합니다.");
        System.out.println("선택하시오. 1.무기리스트 2.무기구입 3.무기판매 4.다음사람 5.다음날 6.구입전체종료");
        Scanner SC = new Scanner(System.in);
        int sel1 = SC.nextInt();
        return sel1;
    }
    public static void Selprice(PlayersList plli1, int p, ArmersList arli1) { // 플레이어의 스탯으로 구입금액 조정
        float stat=(plli1.GetValue(p,2)+plli1.GetValue(p,3)+plli1.GetValue(p,4))*0.1f;
        float ratio=(100+stat)/100;
        for(int i=1; i<arli1.HowmanyRow(); i++){
            arli1.ArrayChange(i,4,arli1.GetValue(i,3)*ratio);
        }
    }
    public static void Login(UserArmerNames names1) {
        Scanner SC = new Scanner(System.in);
        System.out.println("ID를 입력하십시오.");
        String  ID1 = SC.next(); // 아이디입력
        String pw1="";
        int anyID=0;
        for(int i=1; i<names1.plna.size(); i++){
            if(names1.plna.get(i).get(0).equals(ID1)){
                names1.usernow.set(0,i);
                pw1=names1.plna.get(i).get(1);
                anyID++;
            }
        }
        if(anyID==0){
            System.out.println("ID를 확인하십시오.");
            names1.usernow.set(1,0);
        }else{
            System.out.println("패스워드를 입력하십시오");
            String  pw2 = SC.next(); // 패스워드 입력
            if(pw2.equals(pw1)){
                System.out.println("로그인이 완료되었습니다.");
                names1.usernow.set(1,1);
            }else{
                System.out.println("패스워드를 확인하십시오");
                names1.usernow.set(1,0);
            }
        }
    }
    public static void Dailystart(int playersall, Inventory inven1, int day, ArmersList arli1, PurchaseStory pstory1,PlayersList plli1){
        Durareset(playersall, inven1); // 구입한 무기들 내구도 모두 1씩 다운
        Selreset(day,arli1); // 이미 팔린 무기 3일 지나면 재고 리셋
        pstory1.ArrayChange(0,0,pstory1.GetValue(0,1)); // 스토리 0 0 지점의 값을 0 1 지점 것으로 변경
        System.out.println(day+"일차 거래를 시작합니다."); // 하루(한 턴의 시작)

        for(int p=1; p<plli1.HowmanyRow(); p++){ // 모든 플레이어 오늘 시작 금액 리셋
            if(plli1.GetValue(p,6)!=0 && plli1.GetValue(p,6)==plli1.GetValue(p,5)){
                plli1.ArrayChange(p,5,plli1.GetValue(p,6));
            }
        }
    }
    public static void ArmerNumin(UserArmerNames names1, ArmersList arli1){
        for(int i=0; i<names1.arna.size(); i++){
            for(int j=0; j<names1.arsort.size(); j++){
                arli1.ArrayChange(i*10+j+1,1,i+1);
                arli1.ArrayChange(i*10+j+1,2,j+1);
            }
        }
    }
    public static void Playersnow(int playersall,UserArmerNames names1, PlayersList plli1) {
        System.out.println("현재 플레이어들의 정보입니다."); // 우선 제목
        for(int i=0; i<=playersall-1; i++){
            System.out.print(names1.colna.get(i)+" ");
        }
        System.out.println("");  // 엔터 한번 넣어주고
        for(int i=1; i<plli1.HowmanyRow(); i++){
            System.out.println(plli1.GetValue(i,0)+"  "+names1.GetValue(i,0)+"   "+plli1.GetValue(i,2)+
                    "  "+plli1.GetValue(i,3)+"  "+plli1.GetValue(i,4));
        }
    }
    public static void Durareset(int playersall, Inventory inven1){
        for(int i=0; i<=2; i++){
            for(int j=1; j<=6; j++) {
                for(int k=0; k<playersall; k++){
                    int howm=inven1.GetValue(i*10+j,k*10+6);
                    int dur=inven1.GetValue(i*10+j,k*10+5);
                    if (howm != 0) {
                        inven1.ArrayChange(i*10+j,k*10+5,dur-1);
                    }
                }
            }
        }
    }
    public static void Selreset(int day, ArmersList arli1){
        for(int k=0; k<arli1.HowmanyRow(); k++){
            int v8=arli1.GetValue(k,8);
            int v9=arli1.GetValue(k,9);
            if(v8==0 && v9<=day-3){ // 만약 팔렸던 무기인데 팔린 후 3일이 지났다면 리셋
                arli1.ArrayChange(k,9,0);  // 팔린날짜 리셋
                arli1.ArrayChange(k,8,1);  // 재고 다시 1로 채워줌
            }
        }
    }
    public static int Howmanyp(PlayersList plli1) { // 추후에 사용할지 말지 결정하쟈
        System.out.println("플레이어가 몇 명입니까?");
        Scanner SC = new Scanner(System.in);
        int playersall = SC.nextInt(); // 총 몇명인지 입력하라
        //플레이어 속성 : 0순번, 1공격력, 2방어력, 3숙련도, 4초기금액, 5당일거래전금액, 6현재금액
        return playersall;
    }
}


