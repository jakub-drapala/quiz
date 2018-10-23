# Quiz
Quiz is Web app to solve quizzes/tests, which sit in database. 

## Technologies:
* Java 8
* Spring Boot 2.0.5
* Hibernate/JPA
* HTML + CSS
* Thymeleaf

**If app is running homepage's url is *localhost:8080***

There client can choose questions' category.

Then server display singly all questions from particular category in random order.

Every question has 4 answers including 1 correct. Other are incorrect. So answers' order is radnom.

After last answers score is displayed. All questions with client's answer and correct answer are showed in list-form. If client's answer is right its fonts has green colour, wrong is red. If client doesn't choose a answer, web browser show text "Nie udzielono" in blue colour.

### Start app

**IDE

To start app, you need download this repository and in your IDE import file pom.xml 

**cmd

To start app in cmd, you need except Java 8, Maven 3 installed.

To run, after download you need into quiz folder use command:
...
mvn clean install
...




