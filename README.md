# Quiz
Quiz is Web app to solve quizzes/tests, which sit in database. 

## Technologies:
* Java 8
* Spring Boot 2.0.5
* Hibernate/JPA
* HTML + CSS
* Thymeleaf

## Description:

**If app is running homepage's url is  http://localhost:8080**
There client can choose questions' category.

Then server display singly all questions from particular category in random order.

Every question has 4 answers including 1 correct. Other are incorrect. So answers' order is radnom.

After last answers score is displayed. All questions with client's answer and correct answer are showed in list-form. If client's answer is right its fonts has green colour, wrong is red. If client doesn't choose a answer, web browser show text "Nie udzielono" in blue colour.


### Start app

**IDE**

To start app, you need download this repository and in your IDE import file pom.xml 

Now you need run main method (com.drapala.quiz.QuizApplication) in your IDE. It is available in quiz/src/main/java/com/drapala/quiz/QuizApplication.class

**cmd**

To start app in cmd, you need except Java 8, Maven 3 installed.

To run, after download you need into quiz folder use command:

```
mvn clean install
```

Next
```
java -jar target/quiz-0.0.1-SNAPSHOT.jar
```

## Database:

All questions and answers are stored in data.sql file.

If app work, database is so available in url: http://localhost:8080/h2-console/

