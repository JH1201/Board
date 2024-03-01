CREATE TABLE tbl_board(
                          boardId Long auto_increment,
                          title varchar (30) not null,
                          content varchar (3000) not null,
                          name varchar (30) not null,
                          date varchar(30) not null,
                          read varchar (30) not null default 0,
                          primary key(boardId)
);

CREATE TABLE tbl_member(
                          memberId Long auto_increment,
                          userName varchar (30) not null,
                          userId varchar (30) not null ,
                          userPw varchar (30) not null,
                          primary key(memberId)
);

/*
INSERT INTO tbl_board( title, content, name, date) VALUES ('제목1', '내용1', '이름1', '2024-02-09');
INSERT INTO tbl_board( title, content, name, date) VALUES ('제목2', '내용2', '이름2', '2024-02-10');
INSERT INTO tbl_board( title, content, name, date) VALUES ('제목3', '내용3', '이름3', '2024-02-11');
INSERT INTO tbl_board( title, content, name, date) VALUES ('제목4', '내용4', '이름4', '2024-02-12');
INSERT INTO tbl_board( title, content, name, date) VALUES ('제목5', '내용5', '이름5', '2024-02-13');
INSERT INTO tbl_board( title, content, name, date) VALUES ('제목6', '내용6', '이름6', '2024-02-14');
INSERT INTO tbl_board( title, content, name, date) VALUES ('제목7', '내용7', '이름7', '2024-02-15');
INSERT INTO tbl_board( title, content, name, date) VALUES ('제목8', '내용8', '이름8', '2024-02-16');
INSERT INTO tbl_board( title, content, name, date) VALUES ('제목9', '내용9', '이름9', '2024-02-17');
INSERT INTO tbl_board( title, content, name, date) VALUES ('제목10', '내용10', '이름10', '2024-02-18');


 */