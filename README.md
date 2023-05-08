# mini-project01
- FISA 1팀의 JDBC 활용 미니 프로젝트입니다.
- Java 기본 문법과 JDBC를 활용하여 TQQQ/SQQQ 종목을 통한 모의투자 프로그램을 구현하였습니다.
<br></br>

# TQQQ / SQQQ 란
![20230509054117](https://user-images.githubusercontent.com/114793764/236930413-8f55fa74-226a-4642-9b35-e5c0009a447f.png)
- QQQ : 나스닥에 상장된 주식들 중 금융주를 제외한 상위 100 종목을 1배로 추종하는 미국의 ETF 입니다.
- TQQQ : 나스닥 지수를 3배 추종하는 ETF 입니다.
- SQQQ : 마찬가지로 나스닥 지수를 3배 추종하지만, 인버스 상품입니다.
<br></br>
- ex) TQQQ의 주가가 10% 오르면 SQQQ의 주가는 10% 떨어집니다.
- ex) TQQQ의 주가가 10% 내리면, SQQQ의 주가는 10% 상승합니다.
<br></br>

# 구현 내용
### 시작 화면
1. ID와 PW를 입력받아 회원가입을 진행합니다. ID 중복을 체크하며 회원가입이 완료되면 회원 DB에 저장됩니다.
2. 로그인을 진행합니다. ID/PW 중 일치하지 않는 내용이 있으면 다시 로그인을 시도합니다.
### 메인 화면
1. 모의투자 시작 : 모의투자 시작 페이지로 이동합니다.
2. 랭킹 조회 : 랭킹 조회 페이지로 이동합니다.
3. 로그아웃 : 로그아웃하고 시작화면으로 이동합니다.
### 1. 모의투자 시작
- 총 5번의 턴이 주어집니다.
- TQQQ / SQQQ 종목의 액수, 보유량, 현재 주가를 보여줍니다.
- 현재 가진 현금과 총액(현금+종목)을 보여줍니다.
- 거래를 마치고 다음 턴으로 넘어가면 주가가 변동됩니다.
- 게임이 종료되면 현재 회원의 최고기록(총액)을 최신화 한 뒤 메인페이지로 돌아갑니다.
1. TQQQ 사기 : TQQQ를 n개 매수합니다.
2. TQQQ 팔기 : SQQQ를 n개 매도합니다.
3. SQQQ 사기 : TQQQ를 n개 매수합니다.
4. SQQQ 팔기 : SQQQ를 n개 매도합니다.
5. 넘어가기 : 거래를 마치고 다음 턴으로 넘어갑니다.
99. 때려치기 : 모의투자를 종료하고 메인페이지로 돌아갑니다. 게임은 기록되지 않습니다.
### 2. 랭킹 조회
- 회원의 ID를 최고기록 기준으로 내림차순 정렬하여 보여줍니다.
- 아무 키나 누르면 메인페이지로 이동합니다.
<br></br>


# 팀원
|  | 정은기 | 박상건 | 이다인 | 박세린 | 김영현 |
| :---: | :---: | :---: | :---: | :---: | :---: |
| GitHub | [![eunki96](https://github.com/eunki96.png?width=200px)](https://github.com/eunki96)  | [![CodeYasuo](https://github.com/CodeYasuo.png?width=200px)](https://github.com/CodeYasuo) | [![dain-lee](https://github.com/dain-lee.png?width=200px)](https://github.com/dain-lee)  | [![Serapple](https://github.com/Serapple.png?width=200px)](https://github.com/Serapple)  |   |
| 역할 | 모의투자 구현 | 로그인, 회원가입 구현 |  |  | 랭킹시스템 구현 |
