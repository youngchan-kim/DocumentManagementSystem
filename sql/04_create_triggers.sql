-- 해당 트리거가 작동하는 방식 
--update명령 실행 -> before update 트리거 실행 ->updated_at = 현재 시간 
--예)사용자 이름 변경 , 변경내용을 저장하기 직전에 실행 , 수정된 데이터와 함꼐 저장
--UPDATED_AT TIMESTAMP DEFAULT LOCALTIMESTAMP NOT NULL --UPDATED_AT을 자동으로 갱신하는 트리거
--CREATE OR REPLACE TRIGGER: 트리거를 생성하거나 기존 트리거를 교체
--BEFORE UPDATE: 데이터 수정 직전에 실행
--ON 테이블명: 트리거를 적용할 테이블
--FOR EACH ROW: 수정되는 각 행마다 실행
--BEGIN ~ END: 실행할 명령을 작성하는 영역
--:NEW: 수정 후 저장될 행의 값
--UPDATED_AT: 변경할 컬럼
--:=: PL/SQL에서 값을 대입하는 연산자
--LOCALTIMESTAMP: 현재 세션 기준 날짜와 시간

--PL/SQL 블록 Oracle에서 여러 명령문을 하나의 작업 단위로 묶어서 실행하는 코드 구조
--CREATE OR REPLACE TRIGGER TRG_USERS_UPDATED_AT
--BEFORE UPDATE ON USERS
--FOR EACH ROW
--BEGIN
--    :NEW.UPDATED_AT := LOCALTIMESTAMP;
--END;
--/
--CREATE OR REPLACE TRIGGER TRG_DOCUMENTS_UPDATED_AT
--BEFORE UPDATE ON DOCUMENTS
--FOR EACH ROW
--BEGIN
--    :NEW.UPDATED_AT := LOCALTIMESTAMP;
--END;
--/
--CREATE OR REPLACE TRIGGER TRG_APPROVALS_UPDATED_AT
--BEFORE UPDATE ON APPROVALS
--FOR EACH ROW
--BEGIN
--    :NEW.UPDATED_AT := LOCALTIMESTAMP;
--END;
--/

--컴파일 제대로 되었나 확인하기
SELECT
    OBJECT_NAME,
    STATUS
FROM USER_OBJECTS
WHERE OBJECT_TYPE = 'TRIGGER'
ORDER BY OBJECT_NAME;