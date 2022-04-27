-- blumen2.pull_down_master definition

-- Drop table

-- DROP TABLE blumen2.pull_down_master;

CREATE TABLE blumen2.pull_down_master (
	id bigserial NOT NULL,
	deleted bool NULL,
	inoriginal bool NOT NULL,
	is_numeric bool NULL,
	lastmodify timestamp NULL,
	lastuser varchar(50) NOT NULL,
	longpullna varchar(4000) NOT NULL,
	organizationid int8 NULL,
	projtype int8 NULL,
	pullid int8 NOT NULL,
	pullname varchar(50) NOT NULL,
	pulltype varchar(50) NOT NULL,
	timestamp_column timestamp NULL,
	CONSTRAINT pull_down_master_pkey PRIMARY KEY (id)
);


-- blumen2.pull_down_master foreign keys

ALTER TABLE blumen2.pull_down_master ADD CONSTRAINT pull_down_master_fk FOREIGN KEY (organizationid) REFERENCES blumen2.organization(org_id);
ALTER TABLE blumen2.pull_down_master ADD CONSTRAINT pull_down_master_fk_1 FOREIGN KEY (projtype) REFERENCES blumen2.organization_type(id);