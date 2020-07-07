# spring-rest-api
[Spring boot](https://spring.io/projects/spring-boot) restfull API(the backend) and **MySql** database and frontend design and implement by [Angular(10)](https://angular.io/) and **Bootstrap4**

### Assumptions on this app
1. No need authentication with the Angular client and rest api.
2. Simple Employee mamangement scenarios that controlled by super admins
3. No home page, so redirected to employee registration view
4. Ignored H2 embbeded database on spring boot and connect with MySQL(Production ready)
5. No validation on client side, Validating on serverside
6. Fixed departments and fixed rolls
7. If user roll changes "Employee" to "Supervisor", the assignee will be removed on this employee


Required Environment Configurations on Windows
- [x] MySQL running on Apache server (Xampp) - [Tutorial for setup xampp on windows](https://www.geeksforgeeks.org/how-to-install-xampp-on-windows/)
- [x] Java - [Tutorial for setup Java on windows](https://www.guru99.com/install-java.html)
- [x] NodeJs - [Tutorial for setup NodeJs on windows](https://docs.microsoft.com/en-us/windows/nodejs/setup-on-windows)
- [x] Angular - [Tutorial for setup Angular](https://angular.io/guide/setup-local)

Great!. Now we have setup the environment that we want to buil and run our applications.
Now clone or download this repository. If you download unzip the zip file and please follow below guild lines.

### start MySQL

1. Using xampp controll panel run both **Apache** and **MySQL** services.
2. Open phpmyadmin on localhost and Create a database and named it as ```restdb```.

### start rest api

1. After unzipped the zip file that downloaded, go to **api** folder. Inside of this folder contains source code of the spring boot rest api app.
2. go to ```target``` folder. In my case the path is ```C:\Users\EJ\Downloads\spring-rest-api-master\api\target```. Ok, now we are on folder that contains production build *jar* file of our rest api. We can deploy to any server and run our rest api using only this *jar* file.
3. Now we want to run this jar file. Todo that we can use ```command line interface ```(In windows we call it ```Command Prompt(cmd)```). Just open the cmd on this folder and enter **java -jar ou-rest-0.0.1.jar** and hit enter(or return button). Now you can see our spring boot app is running on slef hosted tomcat server. That's the **beauty of spring boot**.
4. When running if there any error such like ```Unknown database 'restdb'```, means you didn't create a database on your localhost. Please follow below steps again.
5. And if your port 8080 is busy or used by another app, It will throw an exeptions, Please **stop all the services running on port 8080 before run Jar file**
6. Finally without any exception you can see running *tomcat server on port 8080*.
7. Now our rest api is running on localhost:8080

### start Angular frontend

1. After unzipped the zip file that downloaded, go to **views** folder. Inside of this folder contains source code of the Angular frontend. 
2. In my case the path is ```C:\Users\EJ\Downloads\spring-rest-api-master\views```. And open *cmd* on this folder and enter ```npm install```. Then all npm module dependecies are will download.
3. Now we can run Angular app by typing ```ng serve -o``` in cmd just after the npm modules are installed.
4. Now you can see app is running on ```localhost:4200```. If your port 4200 is busy, please stop all the services running on port 4200.

Great, Now you hosted the *rest api and the angular app*. 

 
