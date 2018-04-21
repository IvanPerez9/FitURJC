# FitURJC

<p align="center">
<img width="300" height="300" src="https://github.com/IvanPerez9/FitURJC/blob/master/FitURJC/img/logoFITURJC.png">
</p>

### Description

* __If you want a online gym, this is the perfect page. You have some filters and inputs fields in order to find your perfect routine.__

  Both sign up as gym and user options availables. As user, you can see the gym page, send feedback and rate them. The restaurant user can   upload images.
  * The private part is the admin's.
  * The public part is the gym's and profile's.
* __Users__:
  * Gym user.
  * Admin user.
  * Default user.
* __Entities__:
  * Users.
  * Courses.
  * Facilities.
  * Schedules.
* __Advanced funcionability__:
  * One user can not be registered in two or more activities at the same time. 
  * Personalized Recommendations.
* __Technology__:
  * Can register using Facebook acount.
* __Graphics__:
  * Dashboard about affluence of users in each activity and courses by category.
* __Authors:__
  * **Carlos Olmo Sahuquillo** [@CarlUndert] (https://github.com/CarlUndert)  
  Contact: c.olmosa@alumnos.urjc.es
  * **Maria Victoria Marcos Gómez** [@VictoriaMG] (https://github.com/VictoriaMG)  
 Contact: mv.marcos@alumnos.urjc.es
  * **Daniel Peña Martinez**     [@dpemar] (https://github.com/dpemar)  
 Contact: d.penam@alumnos.urjc.es
  * **Iván Pérez Huete**      [@IvanPerez9] (https://github.com/IvanPerez9)   
 Contact: i.perezhu@alumnos.urjc.es

 * __Navigation Diagram:__
 <img width="500" height="300" src="https://github.com/IvanPerez9/FitURJC/blob/master/FitURJC/img/Navigation Diagram.png" align="center">

### Pages
 * __Index.html - Main page:__
    ![Index](FitURJC/img/captures/Index1.png)
    ![Index](FitURJC/img/captures/Index2.png)
    ![Index](FitURJC/img/captures/Index3.png)
    ![Index](FitURJC/img/captures/Index4.png)
      * Description: This is the first page you can see in our application. You have a login section and a sign in section too. If you only want to see some superficial information you have some sections to inspect our services along with our professionals.

* __Facilities.html:__
    ![Facilities](FitURJC/img/captures/facilities.png)
  * Description: This section offers images of the different locations that exist in the gym
  
* __Register.html:__
    ![Register](FitURJC/img/captures/Register1.png)
  * Description: Here is where you can register as a new member. It consist of a few typical fields, such as "user name" , "password" ...
       
* __Login.html:__
    ![Login](FitURJC/img/captures/Login1.png)
  * Description: Similar to the previous page, but in this case, you have to be identified yourself as a member.

* __User.html:__
    ![User](FitURJC/img/captures/User1.png)
    ![User](FitURJC/img/captures/User2.png)
    ![User](FitURJC/img/captures/user3.png)
    ![User](FitURJC/img/captures/user4.png)
    * Description: This is the page you can see when you log in. It shows information about your activities, it also shows a record of your past and future activities, and finally some suggestions about group activities you may be interested.
This is the client profile. For example you can check your profile section, description, watch registered activities and update your profile.

* __Courses.html:__
   ![Courses](FitURJC/img/captures/user5.png)
   * Description: This section offers the possibility to sign up the user in any of the courses that are available
 
* __Profile Settings.html:__
    ![Profile settings](FitURJC/img/captures/ProfileSettings1.png)
    * Description: If you are identified like a member, you have the possibility to change your profile pic, password or even set your birthdate.
	
* __Admin.html:__
    ![Admin.html](FitURJC/img/captures/admin1.png)
    ![Admin.html](FitURJC/img/captures/admin2.png)
    ![Admin.html](FitURJC/img/captures/admin3.png)
    * Description: The page of an User that has Admin role. He can manage Users (Delete users, Edit users) and Courses (Delete courses, add courses) In a future this page will have a Graphic part where you will see stadistics about the user preferences.
	
* __Class Diagram:__

    ![Class Diagram](FitURJC/img/captures/ClassDiagram.png)
	
* __Template Diagram:__

    ![Template Diagram](FitURJC/img/captures/TemplateDiagram.png)
	
* __Data Base Model:__

    ![EER Data Base Model](FitURJC/img/captures/EERModelDataBase.png)
    
* __Configuration Instructions:__
  * Description: Spring Framework provides several data access methods, we use data access via JPA to a MySQL database using    Hibernate.
First we create the project, modifying the pom.xml file so that it contains the dependencies and configurations for JPA and MySQL.

    To indicate to Spring how to access the Database, we need to create the configuration file: application.properties located in src / main / resources.

    We have to create a JPA entity, making a relationship with a relational database. Using the CrudRepository interface we can delete, create, edit or search elements in our data set.
    We add the main class in the MySQL database.

 
* __[Trello's Board](https://trello.com/b/2hRp8ruG/fiturjcdaw)__

* __[Relative reference to API documentation file](https://github.com/IvanPerez9/FitURJC/blob/master/src/main/resources/api.md)__

* __[Relative reference to Angular Diagrams Folder](https://github.com/IvanPerez9/FitURJC/tree/master/angular/diagrams)__
