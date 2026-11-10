# Document Management System

Java와 Spring Boot를 기반으로 개발하는 **전자결재 및 문서관리 시스템**입니다.

기업 내부에서 문서를 작성하고, 결재를 요청하고, 승인 또는 반려하는 업무 과정을 구현하는 백엔드 프로젝트입니다.

## 1. 프로젝트 개요

### 개발 목적

- Java 및 Spring Boot를 활용한 백엔드 개발 역량 향상
- Oracle Database를 이용한 관계형 데이터베이스 설계 및 관리
- REST API를 통한 문서 및 결재 기능 구현
- Controller, Service, Repository 계층 구조 학습 및 적용
- 기업 업무 시스템의 개발 및 유지보수 경험을 위한 포트폴리오 제작

### 프로젝트 정보

| 항목 | 내용 |
|---|---|
| 프로젝트명 | Document Management System |
| 개발 형태 | 개인 프로젝트 |
| 개발 언어 | Java 21 |
| 프레임워크 | Spring Boot 4.1.2 |
| 데이터베이스 | Oracle AI Database 26ai Free |
| ORM | Spring Data JPA / Hibernate |
| 빌드 도구 | Gradle |
| 개발 도구 | IntelliJ IDEA |
| 형상 관리 | Git / GitHub |

## 2. 주요 기능

다음 기능들을 단계적으로 구현할 예정입니다.

### 사용자 관리

- 사용자 등록 및 조회
- 사용자 정보 수정
- 사용자별 작성 문서 조회
- 사용자 인증 및 권한 관리

### 문서 관리

- 문서 작성 및 저장
- 문서 목록 및 상세 조회
- 문서 수정 및 삭제
- 문서 상태 관리

### 전자결재

- 문서 결재 요청
- 결재자 지정
- 결재 승인 및 반려
- 결재 상태 및 이력 조회
- 다단계 결재 기능 확장

## 3. 시스템 구조

Spring Boot 기반의 계층형 아키텍처를 사용합니다.

```text
Client
  |
  v
Controller
  |  HTTP 요청 및 응답 처리
  v
Service
  |  비즈니스 로직 및 트랜잭션 처리
  v
Repository
  |  JPA를 통한 데이터 접근
  v
Oracle Database
```

### 계층별 역할

| 계층 | 역할 |
|---|---|
| Controller | REST API 요청 및 응답 처리 |
| Service | 비즈니스 로직 및 트랜잭션 관리 |
| Repository | 데이터베이스 접근 |
| Entity | 데이터베이스 테이블과 Java 객체 매핑 |
| DTO | 계층 간 요청 및 응답 데이터 전달 |

## 4. 데이터베이스 설계

초기에는 다음 세 가지 테이블을 중심으로 설계할 예정입니다.

| 테이블 | 설명 |
|---|---|
| USERS | 사용자 정보 관리 |
| DOCUMENTS | 문서 정보 및 상태 관리 |
| APPROVALS | 결재자, 결재 상태 및 이력 관리 |

### 주요 관계

- USERS → DOCUMENTS: 사용자 한 명이 여러 문서를 작성할 수 있음 (1:N)
- USERS → APPROVALS: 사용자 한 명이 여러 결재를 처리할 수 있음 (1:N)
- DOCUMENTS → APPROVALS: 문서 한 건에 여러 결재 단계가 존재할 수 있음 (1:N)

테이블의 상세 컬럼, 기본키(PK), 외래키(FK), 제약조건은 설계 단계에서 확정합니다.

## 5. 현재 개발 진행 상황

### 완료

- [x] Java 21 개발 환경 구성
- [x] Spring Boot 프로젝트 생성
- [x] Gradle 및 프로젝트 의존성 설정
- [x] Oracle Database 설치 및 연결 테스트
- [x] 데이터베이스 접속 정보 환경변수 분리
- [x] Spring Boot 서버 실행 확인
- [x] `/test` API 동작 확인
- [x] GitHub 저장소 생성 및 불필요한 파일 추적 제외

### 진행 예정

- [ ] 데이터베이스 ERD 및 테이블 설계
- [ ] USERS 테이블 생성
- [ ] 사용자 Entity 및 Repository 구현
- [ ] 사용자 CRUD API 구현
- [ ] DOCUMENTS 테이블 및 문서 CRUD 구현
- [ ] APPROVALS 테이블 및 결재 처리 구현
- [ ] 입력값 검증 및 예외 처리
- [ ] API 및 비즈니스 로직 테스트
- [ ] 사용자 인증 및 권한 관리

## 6. 실행 환경

### 요구 사항

- JDK 21
- Oracle Database 26ai Free
- Gradle Wrapper

### 데이터베이스 설정

`src/main/resources/application.properties`에서 데이터베이스 접속 정보를 설정합니다.

```properties
spring.datasource.url=jdbc:oracle:thin:@//localhost:1521/FREEPDB1
spring.datasource.username=document_user
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.jpa.open-in-view=false
```

실행 전에 로컬 Oracle 데이터베이스와 사용자 계정을 준비하고 `DB_PASSWORD` 환경변수를 설정해야 합니다.

### 서버 실행

Windows 환경에서 프로젝트 루트 디렉터리의 터미널을 열고 실행합니다.

```powershell
.\gradlew.bat bootRun
```

서버 실행 후 다음 주소로 기본 동작을 확인할 수 있습니다.

```text
GET http://localhost:8080/test
```

정상 응답:

```text
Spring Boot Server OK
```

## 7. 개발 기록

프로젝트 개발 과정에서 다음 내용을 지속적으로 기록할 예정입니다.

- 기능별 설계 목적과 구현 방법
- 데이터베이스 테이블 및 관계 설계
- 개발 과정에서 발생한 오류와 해결 방법
- 코드 구조 개선 및 리팩토링 내용
- Git 커밋을 통한 변경 이력 관리

## 8. 향후 확장 계획

기본적인 문서 및 결재 기능 구현 후 다음 기능들을 검토할 예정입니다.

- JWT 기반 로그인 및 인증
- 사용자 역할별 접근 권한
- 다단계 결재선 및 결재 순서 관리
- 문서 검색 및 페이징
- 문서 첨부파일 관리
- 결재 이력 및 감사 로그
- API 명세 문서화
