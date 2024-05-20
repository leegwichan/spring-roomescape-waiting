## 로그인 계정

- 로그인 가능한 계정
    - 관리자 계정 - id : admin@abc.com / pw : 1234 / name : 관리자
    - 일반 유저 계정 - id : bri@abc.com / pw : 1234 / name : 브리
    - 일반 유저 계정 - id : brown@abc.com / pw : 1234 / name : 브라운
    - 일반 유저 계정 - id : duck@abc.com / pw : 1234 / name : 오리

## 1단계 요구사항

- 엔티티 매핑
    - [x] Theme
    - [x] Time
    - [x] Member
- 연관관계 매핑
    - [x] Reservation
- DAO -> CrudRepository (JpaRepository) 로 전환
    - [x] Theme
    - [x] Time
    - [x] Member
    - [x] Reservation
- 추가적인 리팩터링
    - [x] 멤버에 패스워드 추가

## 2단계 요구사항

- [x] 자신의 예약 목록 조회
- [x] 자신의 예약 목록 화면 응답
    - [x] "/reservation-mine" URL 요청 시 `reservation-mine.html` 가 응답된다.
    - [x] js, html 파일 추가

## 3단계 요구사항

- [ ] 예약 대기 요청
  - 해당 예약이 존재해야 한다.
  - 해당 예약이 현재 날짜 이후이어야 한다.
  - 같은 예약 및 예약 대기에 해당 유저가 없어야 한다. (중복 예약 불가)
- [ ] 예약 대기 취소
  - 요청자가 해당 예약의 주인이어야 한다.
- [ ] 내 예약 (대기) 목록 조회
  - 예약 & 예약 대기 목록을 모두 보여주어야 한다.
- [ ] '유저 예약' 화면 수정
  - 시간 선택 이후 존재하는 예약이면 '예약 대기' 버튼 활성화
  - 시간 선택 이휴 존재하지 않는 예약이면 '예약하기' 버튼 활성화
- [ ] '내 예약' 화면 수정
  - '예약 대기'일 경우에만 '취소' 버튼 생성

## 4단계 요구사항

- [ ] 어드민 예약 대기 조회
  - 모든 유저의 예약 대기를 조회
- [ ] 어드민 예약 대기 취소
  - 모든 유저의 예약을 취소 가능
- [ ] 예약 취소 기능 변경
  - 예약 취소 발생 시, 예약 대기자가 있는 경우 자동으로 예약 승인 됨
- [ ] '어드민 예약 관리' 화면 추가
  - 자동 승인되므로 '거절' 버튼만 추가
