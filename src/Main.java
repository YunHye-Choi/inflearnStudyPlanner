import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        List<Lecture> lectures = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int sectionNum = 0;

        while (true) {
            String next = sc.nextLine().trim();
            if (next.startsWith("섹션")) {
                for (int i = 0; i < 2; i ++)
                    next = sc.nextLine();
                sectionNum ++;
            } else {
                String timeStr = sc.nextLine();
                String[] arr = timeStr.split(":");
                int min = Integer.parseInt(arr[0].trim());
                int sec = Integer.parseInt(arr[1].trim());
                int time = min * 60 + sec;

                lectures.add(new Lecture("섹션 " + sectionNum, next, time));
                if (next.trim().endsWith("다음으로"))
                    break;
            }
        }

        int sum = 0;
        int max = 60 * 28;
        int index = 0;
        int day = 1;
        int lecCount = 0;
        for (Lecture lecture : lectures){
            index ++;
            if (sum > max) {
                System.out.print("DAY" + day);
                System.out.print("\t" + lectures.get(index - lecCount - 1).getName());
                System.out.print("\t" + lecture.getName());
                System.out.print("\t" + (sum / 60) + "분 " + (sum % 60) + "초 \n");
                sum = 0;
                day++;
                lecCount = 0;
            } else {
                sum += lecture.getTime();
                lecCount ++;
            }
        }

    }

    static class Lecture {
        String section;
        String name;
        int time; // sec

        public Lecture (String s, String n, int time){
            this.section = s;
            this.name = n;
            this.time = time;
        }

        public int getTime() {
            return time;
        }

        public String getName() {
            return section + ". " + name;
        }

    }
}

/**
 *
 섹션 1. 타임리프 - 기본 기능
 19
 강 ∙ 2시간 34분
 프로젝트 생성
 06 : 33
 타임리프 소개
 06 : 51
 텍스트 - text, utext
 13 : 32
 변수 - SpringEL
 08 : 22
 기본 객체들
 06 : 45
 유틸리티 객체와 날짜
 05 : 02
 URL 링크
 06 : 22
 리터럴
 05 : 58
 연산
 06 : 27
 속성 값 설정
 12 : 05
 반복
 08 : 48
 조건부 평가
 04 : 05
 주석
 06 : 47
 블록
 04 : 15
 자바스크립트 인라인
 14 : 23
 템플릿 조각
 09 : 27
 템플릿 레이아웃1
 09 : 11
 템플릿 레이아웃2
 07 : 52
 정리
 11 : 34
 섹션 2. 타임리프 - 스프링 통합과 폼
 10
 강 ∙ 1시간 39분
 프로젝트 설정
 04 : 14
 타임리프 스프링 통합
 06 : 00
 입력 폼 처리
 14 : 57
 요구사항 추가
 05 : 23
 체크 박스 - 단일1
 12 : 45
 체크 박스 - 단일2
 11 : 54
 체크 박스 - 멀티
 20 : 59
 라디오 버튼
 11 : 13
 셀렉트 박스
 07 : 13
 정리
 04 : 39
 섹션 3. 메시지, 국제화
 7
 강 ∙ 52분
 프로젝트 설정
 03 : 01
 메시지, 국제화 소개
 07 : 15
 스프링 메시지 소스 설정
 07 : 36
 스프링 메시지 소스 사용
 11 : 14
 웹 애플리케이션에 메시지 적용하기
 10 : 37
 웹 애플리케이션에 국제화 적용하기
 08 : 33
 정리
 04 : 15
 섹션 4. 검증1 - Validation
 17
 강 ∙ 3시간 3분
 검증 요구사항
 07 : 04
 프로젝트 설정 V1
 02 : 19
 검증 직접 처리 - 소개
 05 : 10
 검증 직접 처리 - 개발
 31 : 20
 프로젝트 준비 V2
 05 : 10
 BindingResult1
 18 : 58
 BindingResult2
 09 : 46
 FieldError, ObjectError
 11 : 25
 오류 코드와 메시지 처리1
 13 : 43
 오류 코드와 메시지 처리2
 10 : 58
 오류 코드와 메시지 처리3
 10 : 01
 오류 코드와 메시지 처리4
 13 : 42
 오류 코드와 메시지 처리5
 10 : 11
 오류 코드와 메시지 처리6
 06 : 27
 Validator 분리1
 10 : 15
 Validator 분리2
 10 : 39
 정리
 06 : 07
 섹션 5. 검증2 - Bean Validation
 14
 강 ∙ 1시간 43분
 Bean Validation - 소개
 04 : 53
 Bean Validation - 시작
 09 : 37
 Bean Validation - 프로젝트 준비 V3
 02 : 53
 Bean Validation - 스프링 적용
 13 : 11
 Bean Validation - 에러 코드
 05 : 25
 Bean Validation - 오브젝트 오류
 05 : 31
 Bean Validation - 수정에 적용
 04 : 43
 Bean Validation - 한계
 06 : 09
 Bean Validation - groups
 10 : 28
 Form 전송 객체 분리 - 프로젝트 준비 V4
 01 : 47
 Form 전송 객체 분리 - 소개
 06 : 44
 Form 전송 객체 분리 - 개발
 13 : 33
 Bean Validation - HTTP 메시지 컨버터
 13 : 21
 정리
 04 : 50
 섹션 6. 로그인 처리1 - 쿠키, 세션
 14
 강 ∙ 2시간 20분
 로그인 요구사항
 02 : 51
 프로젝트 생성
 07 : 36
 홈 화면
 01 : 01
 회원 가입
 14 : 45
 로그인 기능
 12 : 04
 로그인 처리하기 - 쿠키 사용
 17 : 39
 쿠키와 보안 문제
 08 : 26
 로그인 처리하기 - 세션 동작 방식
 08 : 18
 로그인 처리하기 - 세션 직접 만들기
 19 : 33
 로그인 처리하기 - 직접 만든 세션 적용
 09 : 15
 로그인 처리하기 - 서블릿 HTTP 세션1
 11 : 01
 로그인 처리하기 - 서블릿 HTTP 세션2
 07 : 38
 세션 정보와 타임아웃 설정
 16 : 36
 정리
 03 : 38
 섹션 7. 로그인 처리2 - 필터, 인터셉터
 8
 강 ∙ 1시간 39분
 서블릿 필터 - 소개
 09 : 52
 서블릿 필터 - 요청 로그
 14 : 26
 서블릿 필터 - 인증 체크
 22 : 45
 스프링 인터셉터 - 소개
 08 : 52
 스프링 인터셉터 - 요청 로그
 16 : 18
 스프링 인터셉터 - 인증 체크
 08 : 40
 ArgumentResolver 활용
 11 : 17
 정리
 07 : 20
 섹션 8. 예외 처리와 오류 페이지
 9
 강 ∙ 1시간 22분
 프로젝트 생성
 03 : 41
 서블릿 예외 처리 - 시작
 13 : 58
 서블릿 예외 처리 - 오류 화면 제공
 10 : 52
 서블릿 예외 처리 - 오류 페이지 작동 원리
 09 : 49
 서블릿 예외 처리 - 필터
 12 : 26
 서블릿 예외 처리 - 인터셉터
 07 : 49
 스프링 부트 - 오류 페이지1
 08 : 33
 스프링 부트 - 오류 페이지2
 08 : 14
 정리
 07 : 08
 섹션 9. API 예외 처리
 9
 강 ∙ 2시간 13분
 시작
 17 : 53
 스프링 부트 기본 오류 처리
 10 : 41
 HandlerExceptionResolver 시작
 19 : 56
 HandlerExceptionResolver 활용
 14 : 28
 스프링이 제공하는 ExceptionResolver1
 16 : 11
 스프링이 제공하는 ExceptionResolver2
 10 : 16
 @ExceptionHandler
 26 : 40
 @ControllerAdvice
 07 : 36
 정리
 09 : 36
 섹션 10. 스프링 타입 컨버터
 11
 강 ∙ 1시간 43분
 프로젝트 생성
 01 : 39
 스프링 타입 컨버터 소개
 09 : 37
 타입 컨버터 - Converter
 18 : 42
 컨버전 서비스 - ConversionService
 12 : 01
 스프링에 Converter 적용하기
 09 : 49
 뷰 템플릿에 컨버터 적용하기
 13 : 40
 포맷터 - Formatter
 10 : 49
 포맷터를 지원하는 컨버전 서비스
 05 : 54
 포맷터 적용하기
 04 : 49
 스프링이 제공하는 기본 포맷터
 09 : 40
 정리
 06 : 57
 섹션 11. 파일 업로드
 7
 강 ∙ 1시간 34분
 파일 업로드 소개
 08 : 16
 프로젝트 생성
 02 : 22
 서블릿과 파일 업로드1
 17 : 42
 서블릿과 파일 업로드2
 13 : 39
 스프링과 파일 업로드
 06 : 01
 예제로 구현하는 파일 업로드, 다운로드
 42 : 04
 정리
 04 : 45
 섹션 12. 다음으로
 1
 강 ∙ 17분
 다음으로
 17 : 02
 */