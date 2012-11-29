
#node.js+java 整合範例

使用此專案之前請先安裝下列套件

* [gradle](http://gradle.org/)
* [grails](http://grails.org/)
* [nodejs](http://nodejs.org/)

請自行參考安裝方式

---
此轉案包含兩個範例，[slide與說明可參考這](http://smlsunxie.github.com/slides/java-with-node.html)


* node-java

	展示nodejs 使用 [node-java](https://github.com/nearinfinity/node-java) 的sample，其中java的建置使用gradle
	
	範例執行方式：
	
	1. 進入 node-java 根目錄
	2. java 建置： ``gradle clean build jar deploy``
	3. node 啟動： ``node app.js``

* node + java use rest

	展示node 與 java 透過rest 整合溝通的samle，java部分使用grails
	
	範例執行方式：
	
	1. 進入 node-frontend 根目錄
	2. node 啟動： ``node app.js``
	3. 進入 grails-backend 根目錄
	4. grails啟動：``grails run-app``
