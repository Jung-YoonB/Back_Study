/*
    * 테이블 생성 : member
            id 컬럼 (숫자, 기본키)
            name 컬럼 (문자 50바이트 가변 길이, NOT NULL)
            email 컬럼 (문자 100바이트 가변 길이, NOT NULL)
            age 컬럼(숫자)
    * 시퀀스 생성 : SEQ_MEMBER_ID
            시작 번호 1, 증가값 1, 캐시 x
*/
DROP TABLE member;
DROP SEQUENCE SEQ_MEMBER_ID;

CREATE TABLE member (
    id NUMBER CONSTRAINT PK_MEMBER_ID PRIMARY KEY,
    name VARCHAR2(50) CONSTRAINT NN_MEMBER_NAME NOT NULL,
    email VARCHAR2(100) CONSTRAINT NN_MEMBER_EMAIL NOT NULL,
    age NUMBER
);

CREATE SEQUENCE SEQ_MEMBER_ID
START WITH 1
INCREMENT BY 1
NOCACHE;

-- 데이터 조회 : select
SELECT * FROM member;

-- 데이터 추가 : insert
INSERT INTO member VALUES (seq_member_id.nextval, '홍길동', 'gildong@gamil.com', 20);
INSERT INTO member VALUES (seq_member_id.nextval, '고갈비', 'galbi@gamil.com', 20);
INSERT INTO member VALUES (seq_member_id.nextval, '순대국', 'sundae@gamil.com', 20);

COMMIT;

-- 확인 후 java에 적용
SELECT * FROM member WHERE name = '홍길동';
SELECT * FROM member WHERE name = '' or '1' = '1';

SELECT * FROM member WHERE name = ?;
