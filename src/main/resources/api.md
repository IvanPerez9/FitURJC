## IMPORTANT INFORMATION
All API queries must be preceded by /api

## User
Below are queries regarding the user entity. These must be preceded by /user.

* ##### Success Response:

	* HttpStatus.OK

* ##### Error Response:

	* Code: 404 NOT FOUND
	
### OBTAIN USER DATABASE

It shows all the database of the users.

* ##### URL

	< / >

* ##### Method:

	`GET`

* ##### Success Response:
      [
          {
              "id": 1,
              "nickname": "WW",
              "email": "ww@gmail.com"
          },
          {
              "id": 2,
              "nickname": "TF",
              "email": "tt@gmail.com"
          },
          {
              "id": 3,
              "nickname": "CM",
              "email": "cm@gmail.com"
          },
          {
              "id": 4,
              "nickname": "admin",
              "email": "admin@gmail.com"
          },
          {
              "id": 5,
              "nickname": null,
              "email": "fiturjc@gmail.com"
          }
      ]
      
      	
### OBTAIN THE DATA OF THE USER LOGGED 
      
      It can change all the data of an user.
      
* ##### URL
      
      	< / >
      
* ##### Method:
      
      	`GET`

* ##### URL Params

	* Required:

		`id=[long]`
* ##### Success Response:
              {
                  "id": 4,
                  "nickname": "admin",
                  "name": "Admin",
                  "surname": "Admin",
                  "imgSrc": "/uploads/img/default",
                  "email": "admin@gmail.com",
                  "age": 25
              }	

### CHANGE A SPECIFIC USER 
      
      It can change all the data of an user.
      
* ##### URL
      
      	< / >
      
* ##### Method:
      
      	`PATCH`

* ##### URL Params

	* Required:

		`id=[long]`
		
* ##### Success Response:
      {
              "id": 4,
              "nickname": "admin",
              "name": "Xilliam",
              "surname": "Xallace",
              "passwordHash": "$2a$10$UjjW8rl8YlBrFsNvKXSYP.WkbTFKZMKv8zMZkSL1WVnXkgZM80vN.",
              "imgSrc": "/uploads/img/default",
              "email": "xx@gmail.com",
              "age": 25,
              "roles": [
                  "ROLE_USER",
                  "ROLE_ADMIN"
              ],
              "fullProfile": true,
              "admin": true
      }

## Schedules
Below are queries regarding the schedules entity. These must be preceded by /schedules.

* ##### Success Response:

	* HttpStatus.OK

* ##### Error Response:

	* Code: 401 UNAUTHORIZED

### OBTAIN SCHEDULES DATABASE

It shows all the database of the schedules.

* ##### URL

	< / >

* ##### Method:

	`GET`

* ##### Success Response:
      [
          {
              "idSchedule": 1,
              "schedule": "10:00-11:00",
              "course": {}
          },
          {
              "idSchedule": 2,
              "schedule": "11:00-12:00",
              "course": 1
          },
          {
              "idSchedule": 3,
              "schedule": "12:00-13:00",
              "course": {}
          },
          {
              "idSchedule": 4,
              "schedule": "17:00-18:00",
              "course": 2
          },
          {
              "idSchedule": 5,
              "schedule": "12:00-13:00",
              "course": {}
          },
          {
              "idSchedule": 6,
              "schedule": "17:00-18:00",
              "course": 3
          },
          {
              "idSchedule": 7,
              "schedule": "18:00-19:00",
              "course": {}
          },
          {
              "idSchedule": 8,
              "schedule": "10:00-11:00",
              "course": 4
          },
          {
              "idSchedule": 9,
              "schedule": "11:00-12:00",
              "course": {}
          },
          {
              "idSchedule": 10,
              "schedule": "12:00-13:00",
              "course": 5
          },
          {
              "idSchedule": 11,
              "schedule": "17:00-18:00",
              "course": {}
          },
          {
              "idSchedule": 12,
              "schedule": "18:00-19:00",
              "course": 6
          },
          {
              "idSchedule": 13,
              "schedule": "10:00-11:00",
              "course": {}
          },
          {
              "idSchedule": 14,
              "schedule": "11:00-12:00",
              "course": 7
          },
          {
              "idSchedule": 15,
              "schedule": "12:00-13:00",
              "course": {}
          },
          {
              "idSchedule": 16,
              "schedule": "17:00-18:00",
              "course": 8
          },
          {
              "idSchedule": 17,
              "schedule": "10:00-11:00",
              "course": {}
          },
          {
              "idSchedule": 18,
              "schedule": "11:00-12:00",
              "course": 9
          },
          {
              "idSchedule": 19,
              "schedule": "18:00-19:00",
              "course": {}
          },
          {
              "idSchedule": 20,
              "schedule": "10:00-11:00",
              "course": 10
          },
          {
              "idSchedule": 21,
              "schedule": "11:00-12:00",
              "course": {}
          },
          {
              "idSchedule": 22,
              "schedule": "12:00-13:00",
              "course": 11
          },
          {
              "idSchedule": 23,
              "schedule": "17:00-18:00",
              "course": {}
          },
          {
              "idSchedule": 24,
              "schedule": "18:00-19:00",
              "course": 12
          }
      ]
### SUBSCRIBE IN A SPECIFIC SCHEDULE

You can join any schedule. (If its not already full).

* ##### URL

	< /{id}/join >

* ##### Method:

	`PUT`

* ##### URL Params

	* Required:

		`id=[long]`
		
* ##### Success Response:
              {
                  "idSchedule": 2,
                  "schedule": "11:00-12:00",
                  "listUsers": [
                      {}
                  ],
                  "course": {},
                  "full": false
              }

### UNSUBSCRIBE IN A SPECIFIC SCHEDULE

You can unsubscribe on any schedule.

* ##### URL

	< /{id}/unsubscribe >

* ##### Method:

	`PUT`

* ##### URL Params

	* Required:

		`id=[long]`
		
* ##### Success Response:
              {
                  "idSchedule": 1,
                  "schedule": "10:00-11:00",
                  "listUsers": [],
                  "course": {},
                  "full": false
              }

### OBTAIN A SPECIFIC DATA OF A SCHEDULE

It shows all the data of any schedule.

* ##### URL

	< / >

* ##### Method:

	`GET`

* ##### URL Params

	* Required:

		`id=[long]`
		
* ##### Success Response:
      {
            "idSchedule": 1,
            "schedule": "10:00-11:00",
            "listUsers": [],
            "course": {
            "id": 1,
            "src": "/img/courses/Aerobic.jpg",
            "name": "Aerobic",
            "category": "CARDIO",
            "description": "Turn your heartbeat up while you dance to the latest music hits! A real fat burning session",
            "schedules": [
                        {
                            "idSchedule": 2,
                            "schedule": "11:00-12:00",
                            "listUsers": [],
                            "course": 1,
                            "full": false,
                            "user": []
                        }
                    ]
                },
                "full": false,
                "user": []
      }

      

### REMOVE A SCHEDULE

delete a schedule specifying its id.

* ##### URL

	< / >

* ##### Method:

	`DELETE`

* ##### URL Params

	* Required:

		`id=[long]`

* ##### Success Response:

		* HttpStatus.OK

* ##### Error Response:

	* Code: 405 METHOD NOT ALLOWED
	
## Courses
Below are queries regarding the courses entity. These must be preceded by /courses.

* ##### Success Response:

	* HttpStatus.OK

* ##### Error Response:

	* Code: 401 UNAUTHORIZED

### OBTAIN COURSES DATABASE

It shows all the current courses.

* ##### URL

	< / >

* ##### Method:

	`GET`

* ##### Success Response:
      [
                {
                    "id": 3,
                    "name": "Dumbbells"
                },
                {
                    "id": 4,
                    "name": "Pilates"
                },
                {
                    "id": 5,
                    "name": "Spinning"
                },
                {
                    "id": 6,
                    "name": "Step"
                },
                {
                    "id": 7,
                    "name": "Swimming"
                },
                {
                    "id": 8,
                    "name": "Switching circuit"
                },
                {
                    "id": 9,
                    "name": "Yoga"
                },
                {
                    "id": 10,
                    "name": "Boxing"
                },
                {
                    "id": 11,
                    "name": "Cardio"
                },
                {
                    "id": 12,
                    "name": "CrossFit"
                }
            ]
     
### OBTAIN A SPECIFIC DATA OF A SCHEDULE

It shows all the data of any course.

* ##### URL

	< / >

* ##### Method:

	`GET`

* ##### URL Params

	* Required:

		`id=[long]`

* ##### Success Response:
      {
          "id": 3,
          "src": "/img/courses/Dumbbells.jpg",
          "name": "Dumbbells",
          "category": "CARDIO",
          "description": "Enjoy the best fitness rooms with the best equipment and training programmes adapted for you, allowing you to get the best from your training.",
          "schedules": [
              {
                  "idSchedule": 5,
                  "schedule": "12:00-13:00",
                  "listUsers": [],
                  "course": 3,
                  "full": false
              },
              {
                  "idSchedule": 6,
                  "schedule": "17:00-18:00",
                  "listUsers": [],
                  "course": 3,
                  "full": false
              }
          ]
      }

	
	


## Admin
Below are queries regarding the admin entity. These must be preceded by /admin.

* ##### Success Response:

	* HttpStatus.OK

* ##### Error Response:

	* Code: 404 NOT FOUND
	
### OBTAIN USER DATA

It shows all the data of any user.

* ##### URL

	< / >

* ##### Method:

	`GET`
	
* ##### Success Response:
      [
          {
              "id": 1,
              "nickname": "WW",
              "name": "William",
              "surname": "Wallace",
              "passwordHash": "$2a$10$xi61dpkasPtIgXhduckl8.gmOg6RaL4IL9YX9E23m26G0yalZ34X2",
              "imgSrc": "/uploads/img/default",
              "email": "ww@gmail.com",
              "age": 25,
              "roles": [
                  "ROLE_USER"
              ],
              "fullProfile": true,
              "admin": false
          },
          {
              "id": 2,
              "nickname": "TF",
              "name": "Travis",
              "surname": "Filmer",
              "passwordHash": "$2a$10$v/tPVHWE9XaO.IMCKxNxluAW1rf.Kxt0/AdYINFBNmJasrs8UUNfa",
              "imgSrc": "/uploads/img/default",
              "email": "tt@gmail.com",
              "age": 29,
              "roles": [
                  "ROLE_USER"
              ],
              "fullProfile": true,
              "admin": false
          },
          {
              "id": 3,
              "nickname": "CM",
              "name": "Cillian",
              "surname": "Murphy",
              "passwordHash": "$2a$10$hKlf7z7Gl0yvKfg3PC21wueJNEUGaiq1tLnQrUrEecu8chvaO2Ihm",
              "imgSrc": "/uploads/img/default",
              "email": "cm@gmail.com",
              "age": 28,
              "roles": [
                  "ROLE_USER"
              ],
              "fullProfile": true,
              "admin": false
          },
          {
              "id": 4,
              "nickname": "admin",
              "name": "Admin",
              "surname": "Admin",
              "passwordHash": "$2a$10$aKXYF.venDjkfoqY8mowze9ADzT303BogCjlpHcUZtS1nEIAUXCFq",
              "imgSrc": "/uploads/img/default",
              "email": "admin@gmail.com",
              "age": 25,
              "roles": [
                  "ROLE_USER",
                  "ROLE_ADMIN"
              ],
              "fullProfile": true,
              "admin": true
          }
      ]
### OBTAIN USER DATA

It shows all the data of a specific user.

* ##### URL

	< / >

* ##### Method:

	`GET`

* ##### URL Params

	* Required:

		`id=[long]`

* ##### Success Response:
      {
          "id": 1, 
          "nickname": "WW", 
          "name": "William", 
          "surname": "Wallace", 
          "imgSrc": "/uploads/img/default", 
          "email": "ww@gmail.com", 
          "age": 25, 
          "roles": [
              "ROLE_USER"
          ] 
      }		

### REMOVE A USER

delete a user specifying its id.

* ##### URL

	< /delete >

* ##### Method:

	`DELETE`

* ##### URL Params

	* Required:

		`id=[long]`

* ##### Success Response:

		* HttpStatus.OK

* ##### Error Response:

	* Code: 405 METHOD NOT ALLOWED
	
### OBTAIN EXPLICIT COURSES DATABASE

It shows all the information of the current courses.

* ##### URL

	< /courses >

* ##### Method:

	`GET`

* ##### Success Response:
      [
          {
              "id": 3,
              "src": "/img/courses/Dumbbells.jpg",
              "name": "Dumbbells",
              "category": "CARDIO",
              "description": "Enjoy the best fitness rooms with the best equipment and training programmes adapted for you, allowing you to get the best from your training.",
              "schedules": [
                  {
                      "idSchedule": 5,
                      "schedule": "12:00-13:00",
                      "listUsers": [],
                      "course": 3,
                      "full": false,
                      "user": []
                  },
                  {
                      "idSchedule": 6,
                      "schedule": "17:00-18:00",
                      "listUsers": [],
                      "course": 3,
                      "full": false,
                      "user": []
                  }
              ]
          },
          {
              "id": 4,
              "src": "/img/courses/Pilates.jpg",
              "name": "Pilates",
              "category": "STRENGTH",
              "description": "system of exercises of stretching and muscular strengthening, it also helps us to unify body and mind",
              "schedules": [
                  {
                      "idSchedule": 7,
                      "schedule": "18:00-19:00",
                      "listUsers": [],
                      "course": 4,
                      "full": false,
                      "user": []
                  },
                  {
                      "idSchedule": 8,
                      "schedule": "10:00-11:00",
                      "listUsers": [],
                      "course": 4,
                      "full": false,
                      "user": []
                  }
              ]
          },
          {
              "id": 5,
              "src": "/img/courses/Spinning.jpg",
              "name": "Spinning",
              "category": "FREESTYLE",
              "description": "Are those group activities that are aimed to improve the cardiorespiratory system and result in increased aerobic capacity and decreased body fat",
              "schedules": [
                  {
                      "idSchedule": 9,
                      "schedule": "11:00-12:00",
                      "listUsers": [],
                      "course": 5,
                      "full": false,
                      "user": []
                  },
                  {
                      "idSchedule": 10,
                      "schedule": "12:00-13:00",
                      "listUsers": [],
                      "course": 5,
                      "full": false,
                      "user": []
                  }
              ]
          },
          {
              "id": 6,
              "src": "/img/courses/Step.jpg",
              "name": "Step",
              "category": "FREESTYLE",
              "description": "Step is low-impact physical training to improve resistance, strength and flexibility.",
              "schedules": [
                  {
                      "idSchedule": 11,
                      "schedule": "17:00-18:00",
                      "listUsers": [],
                      "course": 6,
                      "full": false,
                      "user": []
                  },
                  {
                      "idSchedule": 12,
                      "schedule": "18:00-19:00",
                      "listUsers": [],
                      "course": 6,
                      "full": false,
                      "user": []
                  }
              ]
          },
          {
              "id": 7,
              "src": "/img/courses/Swiming.jpg",
              "name": "Swiming",
              "category": "DANCE",
              "description": "If you like water-based training, aqua is the activity for you!",
              "schedules": [
                  {
                      "idSchedule": 13,
                      "schedule": "10:00-11:00",
                      "listUsers": [],
                      "course": 7,
                      "full": false,
                      "user": []
                  },
                  {
                      "idSchedule": 14,
                      "schedule": "11:00-12:00",
                      "listUsers": [],
                      "course": 7,
                      "full": false,
                      "user": []
                  }
              ]
          }
         
      ]
		

## Schedules
Below is the query that regards the register entity. These must be preceded by /register.

* ##### Success Response:

	* HttpStatus.OK

* ##### Error Response:

	* Code: 405 METHOD NOT ALLOWED

### OBTAIN SCHEDULES DATABASE

It shows all the database of the schedules.

* ##### URL

	< / >

* ##### Method:

	`POST`

* ##### Success Response:
      {
          "id": 5,
          "nickname": "XX",
          "email": "xxx@gmail.com"
      }
      
## Course
Below is query that regards the course funcionality. These must be preceded by /course.

* ##### Success Response:

	* HttpStatus.OK

* ##### Error Response:

	* Code: 405 METHOD NOT ALLOWED

### ADD COURSE (ADMIN)

It shows all the database of the schedules.

* ##### URL

	< /add >

* ##### Method:

	`POST`

* ##### Success Response:
      {
          "src": "/img/courses/Aerobic.jpg",
          "category": "CARDIO",
          "description": "Turn sddsds heartbeat up while you dance to the latest music hits! A real fat burning session",
          "schedules": []
      }

### REMOVE A COURSE

delete a course specifying its id.

* ##### URL

	< /delete >

* ##### Method:

	`DELETE`

* ##### URL Params

	* Required:

		`id=[long]`

* ##### Success Response:

		* HttpStatus.OK

* ##### Error Response:

	* Code: 405 METHOD NOT ALLOWED
