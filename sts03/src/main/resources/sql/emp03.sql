CREATE TABLE `emp03` (
	`sabun` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(10) NOT NULL,
	`nalja` TIMESTAMP NOT NULL,
	`pay` INT NOT NULL DEFAULT 0,
	`deptno` INT NOT NULL DEFAULT 0,
	PRIMARY KEY (`sabun`),
	CONSTRAINT `FK1_dept03` FOREIGN KEY (`deptno`) REFERENCES `dept03` (`deptno`)
)
COLLATE='utf8_general_ci'
;
