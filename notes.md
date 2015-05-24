-----------Table variable

VAR ENROLLMENT BASE RELATION
	{ StudentId  SID,
	  Name        CHAR,
    	  CourseId  CID  }
	KEY  {   StudentId, CourseId  };

-------------Relation-----------------------

RELATION
{ attribute_name attribute_type
[, ...] }
KEY { attribute_name [, ...] }


RELATION
{ MOVIE # MOVIE #,
TITLE CHAR ,
YEAR YEAR ,
DIRECTOR CHAR ,
SCORE SCORE ,
VOTES INTEGER }
KEY { MOVIE # }


------------SELECTing
	//Simply type the variable name you are interested in: "Enrollment"


-------Type Definition---------

TYPE type_name POSSREP {
field_name field_type
[, ...]
CONSTRAINT condition

TYPE SCORE POSSREP {
VALUE RATIONAL
CONSTRAINT
(

	TYPE SID POSSREP SID { C CHAR
	CONSTRAINT LENGTH(C) <= 5
	AND
	STARTS_WITH(C, 'S")
	AND
	IS_DIGITS(SUBSTRING(C,1)))
	}
	INIT SID('S1');