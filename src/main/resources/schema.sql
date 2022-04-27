CREATE TABLE IF NOT EXISTS blumen2.users
(
    user_id bigint NOT NULL DEFAULT nextval('blumen2.users_user_id_seq'::regclass),
    active boolean,
    address1 character varying(255) COLLATE pg_catalog."default",
    address2 character varying(255) COLLATE pg_catalog."default",
    city character varying(255) COLLATE pg_catalog."default",
    created_by character varying(255) COLLATE pg_catalog."default",
    created_date timestamp without time zone,
    edited_by character varying(255) COLLATE pg_catalog."default",
    edited_date timestamp without time zone,
    exp integer NOT NULL,
    expiry_date timestamp without time zone,
    fax character varying(255) COLLATE pg_catalog."default",
    first_name character varying(255) COLLATE pg_catalog."default",
    first_time boolean,
    hashed_code character varying(255) COLLATE pg_catalog."default",
    issue_date timestamp without time zone,
    ita integer NOT NULL,
    last_login timestamp without time zone,
    last_name character varying(255) COLLATE pg_catalog."default",
    link_expiry_date timestamp without time zone,
    mobile character varying(255) COLLATE pg_catalog."default",
    notes character varying(255) COLLATE pg_catalog."default",
    org_id character varying(255) COLLATE pg_catalog."default",
    org_type character varying(255) COLLATE pg_catalog."default",
    password character varying(255) COLLATE pg_catalog."default",
    phone1 character varying(255) COLLATE pg_catalog."default",
    phone2 character varying(255) COLLATE pg_catalog."default",
    scope character varying(255) COLLATE pg_catalog."default",
    security_answer1 character varying(255) COLLATE pg_catalog."default",
    security_answer2 character varying(255) COLLATE pg_catalog."default",
    security_question1 character varying(255) COLLATE pg_catalog."default",
    security_question2 character varying(255) COLLATE pg_catalog."default",
    site_location character varying(255) COLLATE pg_catalog."default",
    state character varying(255) COLLATE pg_catalog."default",
    temp_link character varying(255) COLLATE pg_catalog."default",
    username character varying(255) COLLATE pg_catalog."default",
    wrong_attempt integer,
    zipcode character varying(255) COLLATE pg_catalog."default",
    bolt_id bigint,
    email character varying(255) COLLATE pg_catalog."default",
    role_name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (user_id),
    CONSTRAINT fklmerp822xi020yhuoqf0xd1qx FOREIGN KEY (bolt_id)
        REFERENCES blumen2.bolt (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE blumen2.users
    OWNER to blumen2;



CREATE SEQUENCE  IF NOT EXISTS blumen2.users_user_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE blumen2.users_user_id_seq
    OWNER TO blumen2;