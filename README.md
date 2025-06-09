# 🛍️ Spring Boot 쇼핑몰 프로젝트 (학습 기반 실습)

스프링 부트 쇼핑몰 프로젝트 with JPA 책을 참고하여  
Spring Boot 3.5.0 / Spring Security 6.5.0 / JDK 21 기준으로 리팩토링한 학습용 실습 프로젝트 입니다.

## 📚 학습 기간
- 2025년 6월 1일 ~ 2025년 6월 13일

## 📚 학습 목표

- 회원가입, 로그인, 장바구니, 주문, 결제, 권한 관리 등  
  전반적인 이커머스 시스템의 구성 흐름 이해

- Thymeleaf를 활용한 템플릿 기반 UI 렌더링 구현

- 도서를 참고하여 실습하고,  
  최신 환경(Spring Boot 3.x / Spring Security 6.x)에 맞게  
  코드 구조 및 설정을 직접 마이그레이션 및 개선

## ⚙️ 개발 환경
> 도서 예제는 Spring Boot 2.5.2 / Maven 기반이었으며,  
> 저자가 Spring Boot 3 대응 GitHub 예제를 별도로 제공하고 있습니다.  
> 📎 [roadbook2/shop - GitHub](https://github.com/roadbook2/shop)

> 단, Spring Security 설정은 아직 반영되지 않았으며,  
> 공식 카페에서도 "추후 업로드 예정"임이 공지되어 있습니다.  
> 📎 [공지글 보기 (백견불여일타 카페)]([https://cafe.naver.com/springJpa/555](https://cafe.naver.com/f-e/cafes/29707479/articles/867?menuid=30&referrerAllArticles=false))
> 본 프로젝트는 해당 예제를 기반으로 학습하되,  
> **Spring Security 6.5.0 기준 로그아웃 처리 및 보안 설정을 직접 보완**하였습니다.

| 항목             | 내 환경 (마이그레이션 후) |
|------------------|----------------------------|
| 운영체제          | Windows 11                 |
| Java             | JDK 21                     |
| Spring Boot      | 3.5.0                      |
| Spring Security  | 6.5.0                      |
| 빌드 도구         | Gradle                     |
| 데이터베이스      | MySQL                      |
| IDE              | IntelliJ                   |

## 🔧 4장 주요 변경 사항 (Spring Security 설정)

| 변경 항목 | 설명 |
|-----------|------|
| 🔐 **로그아웃 설정 코드 변경** | 기존 `.logoutRequestMatcher(...)` → 최신 `.logoutUrl(...)` 방식으로 변경 |
| 🔐 **로그아웃 처리 방식 변경** | Thymeleaf의 `<a href="/logout">` 대신 `form POST 방식 + CSRF 토큰 포함` 방식으로 수정 (CSRF 대응용) |

