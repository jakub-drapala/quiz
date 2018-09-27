insert into answers(id, answerA, answerB, answerC, answerD, correct)
values(101, 'A', 'B', 'C', 'D', 'a');
insert into answers(id, answerA, answerB, answerC, answerD, correct)
values(102, 'E', 'F', 'G', 'H', 'b');
insert into answers(id, answerA, answerB, answerC, answerD, correct)
values(103, 'I', 'J', 'K', 'L', 'c');
insert into answers(id, answerA, answerB, answerC, answerD, correct)
values(104, 'M', 'N', 'O', 'P', 'd');
insert into answers(id, answerA, answerB, answerC, answerD, correct)
values(105, 'R', 'S', 'T', 'W', 'a');

insert into question(id, content, answers_id)
values(1, 'Content of question 1', 101);
insert into question(id, content, answers_id)
values(2, 'Content of question 2', 102);
insert into question(id, content, answers_id)
values(3, 'Content of question 3', 103);
insert into question(id, content, answers_id)
values(4, 'Content of question 4', 104);
insert into question(id, content, answers_id)
values(5, 'Content of question 5', 105);
--insert into question(id, content)
--values(6, 'Content of question 6');
--insert into question(id, content)
--values(7, 'Content of question 7');
--insert into question(id, content)
--values(8, 'Content of question 8');
--insert into question(id, content)
--values(9, 'Content of question 9');

