# 로또 - TDD

# 3단계 - 로또(자동)

## 기능 요구사항
- 로또 구입 금액 입력
- 구입 금액에 해당하는 로또 발급
- 로또 1장의 가격 1000원
- 당첨 번호 입력 및 당첨통계 출력


## 구현 기능 목록
- 구입 금액 입력
  - 양수의 숫자만 가능하도록 입력 제한
  
- 구입 금액에 따른 로또 자동 생성
  - 한장 당 1000원
  - 로또 번호는 1부터 45까지 존재
  - 로또 번호 6개를 가지는 로또 발급

- 당첨 번호 입력
  - 6 자리
  - 양수의 숫자만 가지도록, 6자리만 입력하도록 제한

- 당첨 통계 구현
  - 당첨번호와 발급된 로또를 비교
    - 3개, 4개, 5개, 6개 일치 및 갯수 출력
  - 수익률 출력
