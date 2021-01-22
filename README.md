
# SRP DIP OCP
    - SRP 
        - 한 클래스는 하나의 책임만 가져야한다. > 관심사를 분리
    - DIP 
        - 추상화에 의존해야지 구체화에 의존하면 안된다 > 객체가 추상화에 의존을 해야함 . 
            구체적에 대한부분은 넣어주어야함
    - OCP
        - 소프트웨어 요소를 새롭게 확장해도 사용 영역의 변경은 닫혀 있다.

#BeanFactory
    - 스프링 컨테이너의 최상위 인터페이스 -> 빈을 관리하고 조회하는 역활

#ApplicationContext
    - beanFactory에 부가적인 기능 추가된 것 
    - 제공하는 부가기능
      - 환경변수 로컬, 개발, 운영등을 구분해서 처리(환경별로 어떤 것에 연결해야할지)
      - 어플리케이션 이벤트 (이벤트를 발행하고 구독하는 모델을 편리하게 지원)
      - 편리한 리소스 조회 (파일, 클래스패스, 외부 등 리소스를 편리하게 조회)
    ** 빈 관리기능 + 편리한 부가 기능 제공 

 ** baenFactory, applicationContext는 스프링 컨테이너라함 **

    