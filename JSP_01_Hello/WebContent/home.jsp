<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
// 여기는 JSP파일 내에 Java 코드를 작성하는 영역

int num1 = 30;
int num2 = 40;

int sum = num1 + num2;
System.out.println(sum);

%>
<!DOCTYPE html>
<html>
<!-- 
head tag는 페이지에 대한 정보 등을 기록하는 부분
웹페이지에 표시되지는 않지만 웹페이지에 어떤 것을 표시하기 위한
다양한 설정 등을 기록하는 부분
-->
<head>
	<meta charset="UTF-8">
	<!-- 웹페이지를 표시할 때 제목으로 사용되는 문자열 -->
	<title>나의 첫번째 홈페이지</title>
</head>
<!-- 웹페이지에 나타날 정보들을 표시하는 영역 -->
<!-- 디자인과 관련된 문서표시를 하는 부분 -->
<body>
	<!-- h tag는 h1 ~ h6 까지 사용되며 본문보다 큰 글자를 표시 -->
	<h2>나는 Home.jsp 입니다</h2>
	<h3>반갑습니다</h3>
	<h4>우리나라만세</h4>
	<h4><%= sum %></h4>
	<p>paragraph</p>
	<p>문단tag</p>
	<p>본문tag</p>
	<p>웹페이지에서는 Enter의 의미가 없다.</p>
	<p>한 개의 문단 내의 문자열이 매우 커서 한 줄에 표시가 되지 않을 때는
	자동으로 다음 줄로 넘겨져서 표시가 된다.
	이러한 현상을 Auto Word Wrap 이라고 한다.</p>
	<p>문서를 작성하면서 Enter키를 입력해도
	웹페이지에서는 단지 1개의 빈칸으로 인식한다.
	여러 줄에 걸쳐 문서를 작성하기 위해 Enter를 입력하지만
	실제 웹페이지에서 볼 때는 단지 1개의 빈칸으로만 인식한다.
	<p>문자열을 표시하면서 br tag를 사용하면 해당 위치에서 강제 줄바꿈이 된다.<br/>
	br tag는 임의로 문단내에서 문자열을 여러줄에 표시하고자 할 때 사용한다.<br/>
	break 의 약자로</p>
	<p> br tag로 줄바꿈을 하면 문단 내에서는<br/> 
	위아래 여백이 없는 상태로 문자열들이<br/>
	표시된다.
	<p>우리나라<br/>
	대한민국<br/>
	Republic of Korea</p>
	
	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nisl tincidunt eget nullam non. Quis hendrerit dolor magna eget est lorem ipsum dolor sit. Volutpat odio facilisis mauris sit amet massa. Commodo odio aenean sed adipiscing diam donec adipiscing tristique. Mi eget mauris pharetra et. Non tellus orci ac auctor augue. Elit at imperdiet dui accumsan sit. Ornare arcu dui vivamus arcu felis. Egestas integer eget aliquet nibh praesent. In hac habitasse platea dictumst quisque sagittis purus. Pulvinar elementum integer enim neque volutpat ac.
Senectus et netus et malesuada. Nunc pulvinar sapien et ligula ullamcorper malesuada proin. Neque convallis a cras semper auctor. Libero id faucibus nisl tincidunt eget. Leo a diam sollicitudin tempor id. A lacus vestibulum sed arcu non odio euismod lacinia. In tellus integer feugiat scelerisque. Feugiat in fermentum posuere urna nec tincidunt praesent. Porttitor rhoncus dolor purus non enim praesent elementum facilisis. Nisi scelerisque eu ultrices vitae auctor eu augue ut lectus. Ipsum faucibus vitae aliquet nec ullamcorper sit amet risus. Et malesuada fames ac turpis egestas sed. Sit amet nisl suscipit adipiscing bibendum est ultricies. Arcu ac tortor dignissim convallis aenean et tortor at. Pretium viverra suspendisse potenti nullam ac tortor vitae purus. Eros donec ac odio tempor orci dapibus ultrices. Elementum nibh tellus molestie nunc. Et magnis dis parturient montes nascetur. Est placerat in egestas erat imperdiet. Consequat interdum varius sit amet mattis vulputate enim.
Sit amet nulla facilisi morbi tempus. Nulla facilisi cras fermentum odio eu. Etiam erat velit scelerisque in dictum non consectetur a erat. Enim nulla aliquet porttitor lacus luctus accumsan tortor posuere. Ut sem nulla pharetra diam. Fames ac turpis egestas maecenas. Bibendum neque egestas congue quisque egestas diam. Laoreet id donec ultrices tincidunt arcu non sodales neque. Eget felis eget nunc lobortis mattis aliquam faucibus purus. Faucibus interdum posuere lorem ipsum dolor sit.
	<p>농업생산성의 제고와 농지의 합리적인 이용을 위하거나 불가피한 사정으로 발생하는 농지의 임대차와 위탁경영은 법률이 정하는 바에 의하여 인정된다. 대통령은 국무회의의 의장이 되고, 국무총리는 부의장이 된다. 언론·출판은 타인의 명예나 권리 또는 공중도덕이나 사회윤리를 침해하여서는 아니된다. 언론·출판이 타인의 명예나 권리를 침해한 때에는 피해자는 이에 대한 피해의 배상을 청구할 수 있다.

모든 국민은 인간다운 생활을 할 권리를 가진다. 국가는 사회보장·사회복지의 증진에 노력할 의무를 진다. 평화통일정책의 수립에 관한 대통령의 자문에 응하기 위하여 민주평화통일자문회의를 둘 수 있다. 대통령은 국가의 안위에 관계되는 중대한 교전상태에 있어서 국가를 보위하기 위하여 긴급한 조치가 필요하고 국회의 집회가 불가능한 때에 한하여 법률의 효력을 가지는 명령을 발할 수 있다.

원장은 국회의 동의를 얻어 대통령이 임명하고, 그 임기는 4년으로 하며, 1차에 한하여 중임할 수 있다. 국가는 평생교육을 진흥하여야 한다. 누구든지 체포 또는 구속을 당한 때에는 적부의 심사를 법원에 청구할 권리를 가진다. 국무위원은 국정에 관하여 대통령을 보좌하며, 국무회의의 구성원으로서 국정을 심의한다.
	
</body>
</html>