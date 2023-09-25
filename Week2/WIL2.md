기초 백엔드 스터디 2주차
===
***
## HTTP (HyperText Transfer Protocol)
> 서로 다른 시스템들 사이에서 통신을 주고 받게 해주는 application계층의 protocol

#### HTTP의 특징
1. Transfer Layer<br>
TCP/IP 기반으로 서버와 클라이언트 간의 요청을 전송한다.
    * TCP (Transmission Control Protocol) : 패킷을 전송할 때 논리적인 경로를 배정하여 전송하는 방식으로, 패킷을 추적 및 관리하기 때문에 데이터 전송의 신뢰성이 높지만 속도가 상대적으로 느리고 연속성이 떨어진다.
    * IP (Internet Protocol) : 주소와 같은 개념으로, 패킷이 도달할 목적지의 정보를 담고있다.

2. 비연결성 (Connectionless)<br>
클라이언트와 서버가 연결된 후, 클라이언트의 요청에 따라 서버가 응답을 마치면 연결이 끊긴다.

3. 무상태성 (Stateless)<br>
비연결성에 따라 서버가 클라이언트와 연결에 대한 정보를 저장하지 않아 클라이언트를 식별하지 못한다.

#### HTTP의 연결
1. HTTP클라이언트가 80번 포트에서 서버로의 TCP연결을 시작한다.

2. 서버에서 TCP연결을 수락하여 알려준다.
3. 클라이언트에서 TCP Connection Socket에 URL이 포함된 request 메시지(오브젝트)를 남긴다.
4. 서버가 request 메시지를 받아 요청된 오브젝트를 포함한 response 메시지를 소켓으로 보낸다.
5. 서버가 TCP연결을 종료한다.
6. 클라이언트가 HTML파일이 포함된 response 메시지를 받아 파일을 보여준다. 
7. 오브젝트에 따라 이 과정을 반복한다.

#### HTTP Message
HTTP Message를 통해 데이터를 주고받으며 request(요청)과 response(응답) 두 종류가 있다.
~~~
Get / HTTP/1.1
Host: developer.mozilla.org
Accept-Language: fr
~~~
* GET : Method
* / : Path
* HTTP/1.1 : Version of Protocol
* 나머지 : Headers

#### HTTP Method
클라이언트가 서버에 요청을 보낼 때, 목적 및 종류를 알리는 수단.
* GET : 리소스 조회
* POST : 요청 데이터 처리, 주로 등록에 사용
* PUT : 리소스 대체, 없으면 생성
* PATCH : 리소스 부분 변경
* DELETE : 리소스 삭제
* HEAD : 리소스 조회(상태 줄과 헤더만 반환)
* OPTIONS : 대상 리소스에 대한 통신 가능 옵션 설명
* CONNECT : 대상 리소스로 식별되는 서버에 대한 터널 설정
* TRACE : 대상 리소스에 대한 경로를 따라 메시지 루프백 테스트 수행

#### HTTP 상태 코드
서버에서 클라이언트로 response 메시지를 보낼 때, request에 대한 처리 상태를 알려주는 코드
* 1xx (Informational) : 요청이 처리되어 처리중
* 2xx (Successful) : 정상 처리
* 3xx (Redirection) : 추가 행동 필요
* 4xx (Client Error) : 클라이언트 오류. 잘못된 request를 수행할 수 없음
* 5xx (Server Error) : 서버 오류. 서버가 정상 request를 수행할 수 없음.

## HTTPS (HyperText Transfer Protocol Secure)
Secure에서 유추할 수 있듯이 HTTP에 데이터 암호화가 추가된 프로토콜이다.

#### 암호화 방식
1. 대칭키 암호화<br>
클라이언트와 서버가 동일한 키를 사용해 암호화/복호화를 진행한다. 키가 노출되면 매우 위험하지만 연산 속도가 빠르다.

2. 비대칭키 암호화<br>
1개의 쌍으로 구성된 공개키와 개인키를 암호화/복호화에 사용한다. 키가 노출되어도 비교적 안전하지만 연산 속도가 다르다.
    > 공개키로 암호화 하면 개인키로만, 개인키로 암호화 하면 공개키로만 복호화할 수 있다. 개인키로 복호화 할 경우 본인만 볼 수 있고, 공개키로 복호화 할 경우 신뢰성을 보장할 수 있다.

#### HTTPS의 연결
1. 클라이언트가 서버로 최초 연결 시도를 한다

2. 서버는 공개키를 클라이언트에 넘겨준다
    
3. 클라이언트는 공개키의 유효성을 검사하고 세션키를 발급한다
    > 세션키는 주고 받는 데이터를 암호화하기 위해 사용되는 대칭키
4. 클라이언트는 세션키를 보관하며 추가로 서버의 공개키로 세션키를 암호화하여 서버로 전송한다

5. 서버는 개인키로 암호화된 세션키를 복호화하여 세션키를 얻는다
    > 처음 연결을 성립하여 세션키를 안전하게 공유하기 위해 비대칭키가 사용된다.
6. 클라이언트와 서버는 동일한 세션키를 공유하므로 데이터를 전달할 때 세션키로 암호화/복호화를 진행한다
    
## HTTP와 HTTPS의 차이점
* HTTP : 암호화가 없어 보안에 취약하지만 속도가 빠르다.

* HTTPS : 암호화/복호화의 과정이 필요해 HTTP보다    속도가 느리지만 안전하다. 또한 인증서(공개키)를 발급하고 유지하기 위한 추가 비용이 발생한다.

따라서 개인 정보와 같은 민감한 데이터를 주고 받을 땐 HTTPS, 단순한 정보 조회 등 덜 민감한 데이터를 처리할 때는 HTTP를 사용하는 것이 좋다.



## API URI 설계
* 이벤트 목록 조회
    >Get /events/lists

* 이벤트 조회
    >Get /events

* 이벤트 등록
    >Post /events

* 이벤트 수정
    >PATCH /events

* 이벤트 삭제
    >DELETE /events

* 이벤트 상태 변경
    >PATCH /events/states 

* 특정 이벤트의 주문 목록 조회
    >GET /events/{eventsNo}/orders/lists

* 멤버 목록 조회
    >GET /members/lists

* 특정 멤버 권한 변경
    >PATCH /members/{memberId}/authority

* 특정 멤버 정보 조회
    >GET /members/{memberId}/informations

* 특정 멤버 정보 변경
    >PATCH /members/{memberId}/informations

* 멤버 등록
    >POST /members/{memberId}