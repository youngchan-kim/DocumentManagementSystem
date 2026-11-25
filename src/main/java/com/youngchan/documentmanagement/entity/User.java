package com.youngchan.documentmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

// Oracle에서 작성했던 USERS 테이블의 기본키
// USER_ID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY
@Entity
@Table(name = "USERS")
public class User {
    //해당 필드가 기본키(PK)임을 선언
    @Id
    // @GeneratedValue기본키 생성 방식을 지정 DB의 IDENTITY 기능으로 번호 생성
    //Java가 직접 번호를 계산하는 게 아니라 Oracle이 USER_ID를 자동 생성하도록 맡긴다는 의미
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")  //Oracle의 USER_ID 컬럼과 연결
    private Long userId;
    //nullable = false: NULL을 허용하지 않음
    //unique = true: 중복값을 허용하지 않는다는 매핑 정보
    @Column(name = "LOGIN_ID", nullable = false,unique = true,length = 50)
    private String loginId;
    @Column(name = "PASSWORD_HASH", nullable = false,length = 255)
    private String passwordHash;
    @Column(name = "USER_NAME", nullable = false,length = 100)
    private String userName;
    @Column(name = "EMAIL", nullable = false,unique = true,length = 255)
    private String email;
    @Column(name = "STATUS", nullable = false,length = 20)
    private String status;
    @Column(name = "CREATED_AT", nullable = false)
    private java.time.LocalDateTime createdAt;
    @Column(name = "UPDATED_AT", nullable = false)
    private java.time.LocalDateTime updatedAt;

    //Oracle NUMBER → Java Long
    //Oracle VARCHAR2 → Java String
    //Oracle TIMESTAMP → Java LocalDateTime
}
//JPA 어노테이션
/*
@Entity	JPA가 관리하는 Entity 클래스임을 선언
@Table(name = "USERS")	Oracle의 USERS 테이블과 연결
@Id	기본키(PK) 지정
@GeneratedValue	기본키 자동 생성 방식 지정
@Column	DB 컬럼과 Java 필드 연결
*/