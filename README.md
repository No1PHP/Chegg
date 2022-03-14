#Chegg
### Steps
####1. Configure the datasource of IDE  
####2. In the file "src/main/resources/application.yml", 
configure the parameter   
(1) server:
port: 8002  
change to your own used server port
(2) datasource, change connection parameter to your own, including:  
url, username, password  
####3. Check pom.xml, change JDK version to your own machine's version
####4. Build project
####5. Run Application 
Entry: src/main/java/chegg/Application.java  

### API
All the API is provided in the src/main/java/chegg/controller .   
src/main/java/chegg/service  also has more basic operations that can be further encapsulated in controller api.
#####status :   
200 - Success  
500 - Fail  
student:{name: , email: , school: }  
professor:{name: , email: , school: }  
Professor_Courses:{name: , email: , school: ,course:[]}  

(1) Get students by school name  
    
    return: {status:code, data:students[]}  
    GET: ${server:port}/user/findStudentsOfSchool?schoolName=${name}
(2) List all students  

    return: {status:code, data:students[]}  
    GET: ${server:port}/user/listStudents

(3) Get professors by school name  

    return: {status:code, data:professors[]}  
    GET: ${server:port}/user/findProfsOfSchool?schoolName=${name}  
(4) List all professors  

    return: {status:code, data:professors[]}  
    GET: ${server:port}/user/listProfessors

(5) Get professor with his/her taught courses

    return: {status:code, data:Professor_Courses[]}  
    GET: ${server:port}/user/findprofWithCourses
(6) Get Professor with specified course

    return: {status:code, data:string(professorName) []}
    GET: ${server:port}/user/findCourseProf?courseName=${name}
(7) Get taught courses of a professor

    return: {status:code, data:string(courseName) []}
    GET: ${server:port}/user/findCoursesOfProf?profName=${name}
(8) Get student by email address

    return: {status:code, data:student []}
    GET: ${server:port}/user/findStudentByEmail?email=${email}
(8) Get professor by email address

    return: {status:code, data:professor []}
    GET: ${server:port}/user/findProfByEmail?email=${email}
