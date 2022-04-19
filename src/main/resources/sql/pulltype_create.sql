-- blumen2.pulltype definition

-- Drop table

-- DROP TABLE blumen2.pulltype;

CREATE TABLE blumen2.pulltype (
	pull_type_id int8 NOT NULL,
	apr bool NOT NULL,
	data_fields varchar(300) NULL,
	is_numeric bool NOT NULL,
	is_primary bool NOT NULL,
	no_edit bool NOT NULL,
	pull_desc varchar(100) NOT NULL,
	pull_type varchar(30) NOT NULL,
	quick_edit_desc varchar(500) NULL,
	ser_type int8 NOT NULL,
	sort_order varchar(255) NULL,
	proj_type int8 NOT NULL,
	CONSTRAINT pulltype_pkey PRIMARY KEY (pull_type_id)
);


-- blumen2.pulltype foreign keys

ALTER TABLE blumen2.pulltype ADD CONSTRAINT fkolhtsd5p4iih6mncpbjl9sahx FOREIGN KEY (proj_type) REFERENCES blumen2.organization_type(id);