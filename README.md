# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

# 학습 목표
## 경험해야할 학습 목표
* TDD 기반으로 프로그래밍하는 경험
* 메소드 분리 + 클래스를 분리하는 리팩토링 경험
점진적으로 리팩토링하는 경험
# 경험할 객체지향 생활 체조 원칙
* 규칙 1: 한 메서드에 오직 한 단계의 들여쓰기만 한다.
* 규칙 2: else 예약어를 쓰지 않는다.
* 규칙 3: 모든 원시값과 문자열을 포장한다.
* 규칙 5: 줄여쓰지 않는다(축약 금지).
* 규칙 8: 일급 콜렉션을 쓴다.

1. merge를 완료했다는 통보를 받으면 브랜치 변경 및 작업 브랜치 삭제(option)한다.
  : git checkout 본인_아이디
2. 통합(merge)한 next-step 저장소와 동기화하기 위해 next-step 저장소 추가(최초 한번만)
  : git remote add upstream https://github.com/next-step/java-lottoModel.git
3. next-step 저장소에서 자기 브랜치 가져오기(또는 갱신하기)
  :git fetch upstream taegoon 
4. NextStep 원격 저장소 로컬 동기화
  :git rebase upstream/taegoon

# 1단계 - 문자열 계산기
- [x] 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
- [x] 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
- [x] 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
- [x] 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 
   즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

# 2단계 - 로또(자동)
- [x] 로또 Game수 확인
- [x] 로또 번호 정렬
- [x] 입력한 게임수 만큼 로또 생성
- [x] 지난 당첨 번호 와 이번 당첨 번화 매칭 갯수 테스트
- [x] 당첨 번호 문자 -> 숫자 변환
- [x] 수익률 계산
- [x] 로또 연산자 테스트
- [x] 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
- [x] UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- [x] indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다
- [x] 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다
- [x] 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
- [x] 자바 코드 컨벤션을 지키면서 프로그래밍
- [x] else 예약어를 쓰지 않는다
- [x] 일급 콜렉션을 쓴다(Lotto Class)
- [x] 한 메서드에 오직 한 단계의 들여쓰기만 한다
- [x] else 예약어를 쓰지 않는다.
- [x] 입력 값 포장하는 Class 생성

# 3단계 - 로또(2등)
- [x] 2등을 위해 추가 번호를 하나 더 추첨한다.
- [x] 추가 번호는 당첨 번호에서 제외한 수여야 함
- [x] 당첨 통계에 2등도 추가해야 한다.
- [x] 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
- [x] java enum을 적용해 프로그래밍을 구현한다.
- [x] Lotto 일급 콜렉션을 쓴다.
- [x] indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
- [X] 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.

# 4단계 - 로또(수동)
- [x] 수동으로 구매할 로또 수를 입력
- [ ] 수동으로 구매할 번호를 입력
- [ ] 금액 , 수동 생성수 입력후 자동 생성수 계산
  - 입력 금액으로 발생한 Game수는 수동 생성수 보다 크거나 같아야 함
  - 수동 생성수가 구매 가능한 금액보다 많으면 예외 발생
- [ ] 개행문'\n'으로 개임 번호 split



