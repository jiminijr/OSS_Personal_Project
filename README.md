

# OSS_Personal_Project : Moving 2048

# 구현 목표
2048 게임은 타일을 합치며 점수를 2048까지 높이는 퍼즐 게임으로, 간단하면서도 중독성 있는 게임플레이를 제공합니다. 숫자는 2, 4, 8, 16, 32, 64, 128, 512, 1024, 2048 순으로 더해집니다. 빈 타일이 없는 경우 Game Over 창이 나타나며 게임이 종료되고, 2048 숫자를 달성하는 경우 축하 메시지가 나타납니다. 이 프로젝트는 Java 언어를 사용하여 구현되었으며, 게임의 각종 화면 전환과 타일 이동을 더욱 흥미롭게 표현하기 위해 GIF 형식의 모션 그래픽을 활용했습니다.

# 구현 기능
- **메인 메뉴와 초기 화면:** 게임 시작 전 초기 화면과 메인 메뉴 제공.<br/>
- **게임 로직:** 타일 이동 및 합치기, 점수 계산 처리.<br/>
- **애니메이션:** GIF 이미지를 사용한 타일 이동 및 합치기 애니메이션 구현.<br/>
- **순위 저장:** 점수 저장 및 불러오기 기능.<br/>
- **사용자 가이드:** 게임 방법 안내 화면 제공.<br/>
- **화면 관리:** 각 화면 간의 원활한 전환 관리.

# 참조
[1] https://www.romaincousin.fr/2048/ **Motion Graphic Images**

[2] https://github.com/neelgajjar/2048-JAVA

[3] https://github.com/yoon6763/2048

## 프로젝트 디렉토리 구조
```
/OSS_Personal_Project
├── src
│   └── finalProject
│       ├── images
│       ├── Board.java
│       ├── Game.java
│       ├── HowToPlayScreen.java
│       ├── InitialScreen.java
│       ├── Main.java
│       ├── MenuScreen.java
│       ├── Play2048.java
│       ├── PlayerName.java
│       ├── RankingsIO.java
│       ├── ScreenFrame.java
│       └── Tile.java
├── .classpath
├── .gitignore
├── .project
└── README.md
```

# 지원 운영 체제 및 실행 방법
## 지원 운영 체제
|OS|지원 여부|
|------|---|
|windows| ❌ |
|Linux| ⭕ |
|MacOS| ⭕ |

MacOS Terminal과 Linux에서 실행 가능함을 확인하였습니다. Windows의 경우, 확인해보지 못 하였습니다.

## Java 설치 방법
본 프로젝트는 java 문법으로 만들어진 프로젝트입니다. 따라서 프로그램 실행 전 java 설치가 선행되어야 합니다. 

### Windows
```
Java SE Development Kit (JDK) 다운로드 페이지에서 JDK 설치 파일 다운로드 및 설치

JDK 설치 디렉토리(예: C:\Program Files\Java\jdk-11.x.x)를 Path 환경 변수에 추가

명령 프롬프트에서 java -version과 javac -version 명령어로 설치 확인
```

### macOS
```
Homebrew 설치 (설치되어 있지 않은 경우) 후, 터미널에서 다음 명령어 실행:

brew install openjdk@11.

쉘 설정 파일(~/.zshrc 또는 ~/.bash_profile)에 다음 줄 추가: 

export JAVA_HOME=/usr/local/opt/openjdk@11
export PATH=$JAVA_HOME/bin:$PATH.

터미널에서 java -version과 javac -version 명령어로 설치 확인.
```

### Linux
```
패키지 관리자를 사용하여 JDK 설치 (예: Ubuntu):

sudo apt update
sudo apt install openjdk-11-jdk.

터미널에서 java -version과 javac -version 명령어로 설치 확인.
```

## 프로젝트 설정 및 실행 방법
### 1. 프로젝트 디렉토리로 이동
먼저, 프로젝트를 clone 한 후, 터미널을 열고 프로젝트의 루트 디렉토리로 이동합니다.

```
cd OSS_Personal_Project
```
### 2. 소스 파일 컴파일
src/finalProject 디렉토리 안에 있는 자바 소스 파일들을 컴파일합니다. 컴파일된 클래스 파일들을 bin 디렉토리에 저장하도록 합니다. bin 디렉토리가 없는 경우 미리 생성해 줍니다.

```
mkdir -p bin
cp -r src/finalProject/images bin/finalProject/
javac -d bin src/finalProject/*.java
```

이 명령어는 src/finalProject 디렉토리 아래의 모든 자바 파일을 컴파일하여 bin 디렉토리에 출력합니다.

***Note: src/finalProject/RankingsIO.java uses unchecked or unsafe operations.***
***Note: Recompile with -Xlint:unchecked for details.*** 
**위와 같은 경고가 나오는 경우 무시하고 진행하시기 바랍니다.**



### 3. 메인 클래스 실행
컴파일이 완료되면, bin 디렉토리 안에 생성된 클래스 파일을 실행합니다. 

```
java -cp bin finalProject.Main
```
# 실행 예시


<img src="https://github.com/jiminijr/OSS_Personal_Project/assets/95954633/d7d644ac-4c7f-40fa-8221-bd6dcdd2a96a" width="300" height="500"/>
<img src="https://github.com/jiminijr/OSS_Personal_Project/assets/95954633/140f5e81-b7f0-4f64-b47e-fca3f18afb9d" width="300" height="500"/>
<img src="https://github.com/jiminijr/OSS_Personal_Project/assets/95954633/7a9b7fcb-3c35-4500-b910-f51777005bc4" width="300" height="500"/>

# 코드설명

### 1. 메인 게임 로직 (Game.java)
- 게임 초기화 및 재설정: resetGame() 메서드를 통해 게임을 초기화하고 새로운 타일을 추가.
- 타일 이동 및 병합: move(Direction direction) 메서드를 통해 타일을 이동시키고 병합. 타일이 이동할 때마다 새로운 타일을 추가.
- 게임 상태 확인: checkGameState() 메서드를 통해 게임이 종료되었는지 확인. 타일이 더 이상 움직일 수 없으면 게임 종료.
- 이벤트 리스너: GameEventListener 인터페이스를 통해 게임 오버 및 타일 병합 이벤트를 처리.
- 점수 업데이트: 점수가 변경될 때마다 onScoreUpdated(int score) 메서드를 통해 순위 목록을 업데이트.

### 2. 게임 보드 (Board.java)
- 보드 초기화: Board() 생성자에서 4x4 크기의 타일 배열을 생성하고, 각 타일을 빈 타일로 초기화
- 행과 열 접근: getRow(int rowIndex)와 getColumn(int columnIndex) 메서드를 통해 특정 행 또는 열을 가져옴. setRow(int rowIndex, Tile[] row)와 setColumn(int columnIndex, Tile[] column) 메서드를 통해 특정 행 또는 열을 설정함
- 타일 접근: getTileAt(int x, int y) 메서드를 통해 특정 위치의 타일에 접근할 수 있음
- 빈 공간 확인: getAvailableSpace() 메서드를 통해 보드에서 빈 타일들을 리스트로 반환
- 전체 타일 배열 반환: getTiles() 메서드를 통해 전체 타일 배열을 반환

### 3. 메인 화면 (InitialScreen.java, MenuScreen.java)
**닉네임 입력 화면 (InitialScreen.java):**
- 닉네임 입력: 사용자에게 닉네임을 입력받는 텍스트 필드

**메뉴 화면 (MenuScreen.java):**
- 게임 타이틀: 타이틀 이미지 표시.
- How to Play: 게임 방법 화면으로 전환.
- Play Game: 실제 게임 화면으로 전환.
- Rankings: 순위 화면으로 전환.
- Quit: 프로그램 종료.

### 4. 게임 플레이 화면 (Play2048.java)
- 게임 초기화 및 이벤트 설정: Play2048(CardLayout cardLayout, JPanel contentPane): 게임 화면을 초기화하고 이벤트 리스너를 설정.
- 게임 보드 구성: gridPanel: 4x4 타일을 표시하는 패널. labels[][]: 각 타일을 나타내는 JLabel 배열. 키보드 입력 처리: 방향키로 타일 이동. InputMap과 ActionMap을 사용하여 방향키 입력을 처리.
- 게임 업데이트: reset(): 게임을 초기화. update(): 보드와 점수를 업데이트하고 게임 오버 상태를 확인. 버튼 기능: "New Game" (게임 초기화) 및 "Menu" (메뉴 화면 전환) 버튼.
- JButton btnNewButton: "New Game" 버튼, 클릭 시 게임 초기화.
- JButton btnNewButton_1: "Menu" 버튼, 클릭 시 메뉴 화면으로 전환.
팝업 메시지: 2displayGameOverPopup() - 게임 오버 시 팝업 메시지 표시. displayGameTitlePopup() - 2048 타일 달성 시 팝업 메시지 표시.

### 5. 점수와 랭킹 (RankingsIO.java)
- Player 클래스: 플레이어 이름과 점수를 저장합니다.

- Ranking 클래스: addPlayer(Player player): 새로운 플레이어 추가 및 점수 업데이트. printRanking(JTextArea textArea): 순위를 JTextArea에 출력.
savePlayers() / loadPlayers(): 순위 정보를 파일에 저장하고 로드. initializeRanking(): 순위 초기화.

- RankingsIO 클래스: RankingsIO(CardLayout cardLayout, JPanel contentPane): 순위 화면을 초기화하고, 메뉴로 돌아가는 버튼을 추가. 순위 정보를 textArea에 표시.

### 6. 사용자 인터페이스 (ScreenFrame.java)
- 전체 게임 화면의 레이아웃을 관리.
- 게임의 다양한 화면(메인 화면, 게임 플레이 화면 등)을 전환하는 기능을 포함.

### 7. 도움말 화면 (HowToPlayScreen.java)
- 게임 규칙과 플레이 방법을 사용자에게 안내합니다.
- 도움말 정보를 표시하는 화면 구현.


# TODO List
- 점수 로직 개선하여 순위 산출 방법 개선
- 로그인 기능 구현하여 점수 저장 기능 구현
- 서버 내 상위 점수 반영하기
- 순위 페이지 UI 개선 
