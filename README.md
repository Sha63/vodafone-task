# vodafone-task
### Items:
* source: contains source code
* Dockerfile: docker file to build image from
* task.jar: executable jar file
### How to run:
* Open cmd
* Navigate to the task_final directory
* Enter the commands:   
```docker build -t task .```   
```docker run -p 8080:8080 task```   
* Open Browser
* got to http://localhost:8080/
