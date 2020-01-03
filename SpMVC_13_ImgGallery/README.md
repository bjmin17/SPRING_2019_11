# 이미지 갤러리 프로젝트
* 2020-01-03

### WYSWYG(What you see What you Get) Editor
* summernote : https://summernote.org/

* textarea에 id 값을 설정하고 id에 jquery를 이용해서 속성을 설정해주면 간편하게 WYSWYG 방식으로 문서를 작성할 수 있다.

### Drag and Drop으로 파일 올리기
* Drag And Drop 을 수행할 box를 만들기
* jquery에 dragover, drop event를 설정
* e.originalEvent.dataTransfer 로 부터 files 객체를 추출하고
* files 객체의 0 번째 file 객체를 추출

* ajax를 사용해서 서버로 파일을 업로드 수행하고
* 파일이름등을 다시 response로 되돌려 받아서
* form img_file input box에 저장을 하고

* 내용을 form post로 upload하면 나머지 정보를 db에 저장(파일따로, 내용따로)