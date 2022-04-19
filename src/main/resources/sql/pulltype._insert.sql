INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1,true,'main.gender',true,false,false,'APR II D - Gender','GENDER',NULL,0,'-1',1),
	 (2,false,'yearly.partstatus',true,false,false,'APR II A - Participant Status','PARTSTATUS',NULL,0,'10',1),
	 (3,true,'main.eligibilit',true,false,false,'APR II B - Eligibility','ELIGIBILITY',NULL,0,'10',1),
	 (4,true,'main.ethnic',true,false,false,'APR II C - Ethnicity','ETHNIC',NULL,0,'10',1),
	 (5,true,'yearly.dualenroll',true,false,false,'APR II H - Dual Enrollment','DUALENROLL',NULL,0,'10',1),
	 (6,true,'yearly.rigorous',true,false,false,'APR II I - Rigorous Enrollment','RIGOROUS',NULL,0,'10',1),
	 (7,true,'yearly.othertrio',true,false,false,'APR II J - Served by Other Trio','OTHERTRIO',NULL,0,'10',1),
	 (8,true,'yearly.fafsa',true,false,false,'APR II K - FAFSA completion','FAFSA',NULL,0,'10',1),
	 (9,true,'yearly.vcalllen',true,false,false,'APR II L - Competitive Preference Priorities (CPP)','VCALLLEN',NULL,0,'10',1),
	 (10,true,'yearlychild.servalue',true,true,false,'APR IV - End Status','ENDSTATUS',NULL,4,'10',1);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (11,true,'yearly.collegety',true,false,false,'APR IV D - College Type','COLLEGETYPE',NULL,0,'10',1),
	 (12,true,'yearly.standing
semester.standing',true,false,true,'APR III - Grade / Standing','STANDING','APR III - Grade / Standing~Standing',0,'10~50',1),
	 (13,true,'main.highdegree
yearly.degree',true,false,false,'APR IV E - Highest Degree Complete','HIGHDEGREE','APR IV E - Highest Degree Completed~Degree/Certificate Completed (Non APR)',0,'10~50',1),
	 (14,false,'yearly.school
main.schoolent
main.schoolend',false,false,true,'APR II M - School Name/Code','SCHOOL','APR II M - School(Current Fiscal Year)~School (Entry into Project)~School (End of Project)',0,'10~50~50',1),
	 (15,true,'main.acadneed',true,false,false,'Academic Need','ACADNEED',NULL,0,'50',1),
	 (16,true,'yearly.acadstand',true,false,false,'Academic Standing','ACADSTAND',NULL,0,'50',1),
	 (17,true,'activity.actgid',true,false,true,'Activity Group','ACTIVITYGROUP',NULL,2,'50',1),
	 (18,true,NULL,true,false,false,'Activity Group Type','ACTIVITYGROUPTYPE',NULL,0,'50',1),
	 (19,true,'yearly.advancemat',true,false,false,'Advanced Math Course','ADVANCEMAT',NULL,0,'50',1),
	 (20,true,'yearly.apcourse',true,false,false,'Advanced Placement Course','APCOURSE',NULL,0,'50',1);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (21,false,'yearly.advisor',false,false,false,'Advisor','ADVISOR',NULL,0,'50',1),
	 (22,false,'asset.amake',false,false,false,'Asset Make','ASSET MAKE',NULL,0,'50',1),
	 (23,false,'asset.amodel',false,false,false,'Asset Model','ASSET MODEL',NULL,0,'50',1),
	 (24,false,'asset.astatus',true,false,false,'Asset Status','ASSETSTATUS',NULL,0,'50',1),
	 (25,false,'asset.atype',false,false,false,'Asset Type','ASSET TYPE',NULL,0,'50',1),
	 (26,true,'yearly.adegree',true,false,false,'Associate Degree','ADEGREE',NULL,0,'50',1),
	 (27,true,'main.atralgebra',true,false,false,'At Risk Algebra','ATRALGEBRA',NULL,0,'50',1),
	 (28,true,'main.atrlowgpa',true,false,false,'At Risk Low GPA','ATRLOWGPA',NULL,0,'50',1),
	 (29,true,'main.atrschool',true,false,false,'At Risk Out of School','ATRSCHOOL',NULL,0,'50',1),
	 (30,true,'main.atrstdtest',true,false,false,'At Risk Standard Test','ATRSTDTEST',NULL,0,'50',1);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (31,true,'main.commcoll',true,false,false,'Attended Community College','COMMCOLL',NULL,0,'50',1),
	 (32,false,'main.birthplace',false,false,false,'Birth Place','BIRTH PLACE',NULL,0,'50',1),
	 (33,false,'botform_submission.SUBMISSION_STATUS',true,false,false,'BOT Form Status','BOTFORMSTATUS',NULL,0,'50',1),
	 (34,true,'yearly.certi',true,false,false,'Certificate/ Diploma Completed','CERTI',NULL,0,'50',1),
	 (35,true,'main.vetschecir',true,false,false,'Circumstances of Recheduling','VETSCHECIR',NULL,0,'50',1),
	 (36,false,'main.codes',false,false,false,'Codes','CODES',NULL,0,'50',1),
	 (37,true,'main.cohortyear',true,false,false,'Cohort Year','COHORTYEAR',NULL,0,'50',1),
	 (38,true,'main.enterexam',true,false,false,'College Entrance Exam','ENTEREXAM',NULL,0,'50',1),
	 (39,true,'yearly.collgradel',true,false,false,'College Grade Level','COLLGRADE',NULL,0,'50',1),
	 (40,true,'yearly.collready',true,false,false,'College Ready','COLLREADY',NULL,0,'50',1);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (41,true,NULL,true,false,false,'Compare Symbols','COMPARE',NULL,0,'50',1),
	 (42,true,'yearly.completeyr',true,false,false,'Completion Year','COMPLETEYR',NULL,0,'50',1),
	 (43,true,NULL,true,false,false,'Component Type','COMPONENT',NULL,0,'50',1),
	 (44,true,NULL,true,false,false,'Component Type-APR','APRCOMPONENT',NULL,0,'50',1),
	 (45,true,'contact.stftype',true,false,false,'Contact Staff Type','CONTACTSTAFFTYPE',NULL,0,'50',1),
	 (46,false,'contact.conttype',true,false,false,'Contact Type','CONTACTTYPE',NULL,0,'50',1),
	 (47,false,'courses.courseinst',false,false,false,'Course Instructor','COURSE INSTRUCTOR',NULL,0,'50',1),
	 (48,false,'courses.coursename',false,false,false,'Course Name','COURSE NAME',NULL,0,'50',1),
	 (49,false,'courses.coursenum',false,true,false,'Course Number','COURSE NUMBER',NULL,0,'50',1),
	 (50,false,'main.custom1',false,false,false,'Custom Field 1','CUSTOM1',NULL,0,'50',1);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (51,false,'main.custom2',false,false,false,'Custom Field 2','CUSTOM2',NULL,0,'50',1),
	 (52,false,'yearly.custom3',false,false,false,'Custom Field 3','CUSTOM3',NULL,0,'50',1),
	 (53,false,'yearly.custom4',false,false,false,'Custom Field 4','CUSTOM4',NULL,0,'50',1),
	 (54,false,'maincfields.customname',true,true,false,'Custom Field Names','CUSTOMFIELDNAME',NULL,0,'50',1),
	 (55,true,NULL,true,true,true,'Custom Field Type','CUSTOMFIELDTYPE',NULL,0,'50',1),
	 (56,false,'classes.days',false,false,false,'Days','DAYS',NULL,0,'50',1),
	 (57,true,'yearly.deceased',true,false,false,'Deceased or Incapacitated','DECEASED',NULL,0,'50',1),
	 (58,true,'main.disconnect',true,false,false,'Disconnected Youth','DISCONNECT',NULL,0,'50',1),
	 (59,true,'main.docemploy',true,false,false,'Doctorate Employment Activity','DOCEMPLOY',NULL,0,'50',1),
	 (60,true,'yearly.decredenti',true,false,false,'Dual Enrollment Credentials','DECREDENTI',NULL,0,'50',1);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (61,false,'main.eligtype',false,false,false,'Eligibility Type','ELIGIBILITY TYPE',NULL,0,'50',1),
	 (62,true,'yearly.employ',true,false,false,'Employment','EMPLOY',NULL,0,'50',1),
	 (63,true,NULL,true,false,false,'English Instructions','ENGLISH',NULL,0,'50',1),
	 (64,false,'main.ethnictype',false,false,false,'Ethnic Type (National Origin)','ETHNIC TYPE',NULL,0,'50',1),
	 (65,true,'main.finaidrecd',true,false,false,'Financial Aid','FINAIDRECD',NULL,0,'50',1),
	 (66,false,'yearly.finaidname',false,false,false,'Financial Aid Name','FINANCIAL AID NAME',NULL,0,'50',1),
	 (67,true,'yearly.finaidreas',true,false,false,'Financial Aid Un-met Reason','FINAIDREAS',NULL,0,'50',1),
	 (68,false,'yearly.finaidunme',false,false,false,'Financial Aid Unmet Name','FINANCIAL AID UNMET',NULL,0,'50',1),
	 (69,true,NULL,true,false,false,'Foreign Language Instructions','FOREIGNLANGUAGE',NULL,0,'50',1),
	 (70,true,'eddata.contfreq',true,false,false,'Frequency of contacts between participants','CONTFREQ',NULL,0,'50',1);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (71,true,'yearly.fundsource',true,false,false,'Funding Source','FUNDSOURCE',NULL,0,'50',1),
	 (72,true,'yearly.gradelevel',true,false,false,'Grade Level (at end of reporting period)','GRADELEVEL',NULL,0,'50',1),
	 (73,true,'yearly.gradestart',true,false,false,'Grade Level (at start of reporting period)','GRADESTART',NULL,0,'50',1),
	 (74,true,'main.enterlevel',true,false,false,'Grade Level (at time of first entry into project)','ENTERLEVEL',NULL,0,'50',1),
	 (75,true,'yearly.hsgradepro',true,false,false,'Grade Progression Over Year','GRADEPRO',NULL,0,'50',1),
	 (76,true,'yearly.gradassist',true,false,false,'Graduate Assistantships','GRADASSIST',NULL,0,'50',1),
	 (77,true,'yearly.gradstudyl',true,false,false,'Graduate Current Year of Study','GRADSTUDYL',NULL,0,'50',1),
	 (78,true,'main.gdegree',true,false,false,'Graduate Degree Earned','GDEGREE',NULL,0,'50',1),
	 (79,false,'graduated.degreein',true,false,false,'Graduate Degree In','DEGREEIN',NULL,0,'50',1),
	 (80,false,'graduated.gdedustat',true,false,false,'Graduate Educational Status','GRADUATEEDUCATIONALSTATUS',NULL,0,'50',1);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (81,false,'graduated.employtype',true,false,false,'Graduate Employment Type','EMPLOYTYPE',NULL,0,'50',1),
	 (82,true,'main.gradadm',true,false,false,'Graduate School Admissions Test','GRADADM',NULL,0,'50',1),
	 (83,true,'yearly.enrollobj',true,false,false,'Graduate School Enrollment Objective','ENROLLOBJ',NULL,0,'50',1),
	 (84,true,'yearly.gpersist',true,false,false,'Graduate Student Persistence Status','GPERSIST',NULL,0,'50',1),
	 (85,true,'main.bdegreeco',true,false,false,'Graduating Cohort Year of Bachelor''s Degree','BDEGREECO',NULL,0,'50',1),
	 (86,true,'main.yearcogrd',true,false,false,'Graduation Cohort Year','YEARCOGRD',NULL,0,'50',1),
	 (87,false,'main.healthname',false,false,false,'Health Name','HEALTH NAME',NULL,0,'50',1),
	 (88,true,'yearly.hsgradstat',true,false,false,'High School Graduation Status','GRADSTATUS',NULL,0,'50',1),
	 (89,true,'yearly.vettest',true,false,false,'Improved Score on Standardized Test','VETTEST',NULL,0,'50',1),
	 (90,false,'main.incomelev',false,false,false,'Income Level','INCOME LEVEL',NULL,0,'50',1);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (91,false,'main.incomesou',false,false,false,'Income Source','INCOME SOURCE',NULL,0,'50',1),
	 (92,true,'yearly.initiative',true,false,false,'Initiative','INITIATIVE',NULL,0,'50',1),
	 (93,true,'yearly.mcintern',true,false,false,'Internship','INTERN',NULL,0,'50',1),
	 (94,false,'labservice.labserid',true,false,true,'Lab Service','LABSERVICE',NULL,0,'50',1),
	 (95,true,'yearly.partlength',true,false,false,'Length of Project Participation','PARTLENGTH',NULL,0,'50',1),
	 (96,true,'yearly.mcnmajor',true,false,false,'Major of Graduate Study','MCNMAJOR',NULL,0,'50',1),
	 (97,false,'main.marrstatus',true,false,false,'Marital Status','MARITALSTATUS',NULL,0,'50',1),
	 (98,true,NULL,true,false,false,'Mathematics Instructions/ Tutorials','MATH',NULL,0,'50',1),
	 (99,false,'classes.meettime',false,false,false,'Meeting Time','MEETING TIME',NULL,0,'50',1),
	 (100,false,'usermessages.msgstatus',true,false,false,'Message Priority Type','MSGSTATUS',NULL,0,'50',1);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (101,false,'graduated.milirank',false,false,false,'Military Rank','MILITARY RANK',NULL,0,'50',1),
	 (102,false,'graduated.militaryty',true,false,false,'Military Type','MILITARYTYPE',NULL,0,'50',1),
	 (103,true,'yearlychild.servalue',true,true,false,'Old End Status-For TS and EOC (prior to 2006-07)','OLDENDSTATUS',NULL,7,'50',1),
	 (104,false,'mainchild.ptitle',false,false,false,'Parent/ Guardian Relationship','PARENT RELATION',NULL,0,'50',1),
	 (105,true,'yearly.projretain',true,false,false,'Participant Retention in Project','PROJRETAIN',NULL,0,'50',1),
	 (106,true,'yearly.endstatus',true,false,false,'Participant Status (at end of Reporting Period)','PARTSTATUSEND',NULL,0,'50',1),
	 (107,true,'yearly.partlevel',true,false,false,'Participation Level','PARTLEVEL',NULL,0,'50',1),
	 (108,true,'yearly.persistend',true,false,false,'Persistence Graduation Status at end of year','PERSISTEND',NULL,0,'50',1),
	 (109,true,'yearly.persiststa',true,false,false,'Persistence Status at beginning at next year','PERSISTSTA',NULL,0,'50',1),
	 (110,true,'yearly.pscomplete',true,false,false,'Postsecondary Completion Objective','PSCOMPLETE',NULL,0,'50',1);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (111,true,'yearly.psenroll',true,false,false,'Postsecondary Enrollment Objective','PSENROLL',NULL,0,'50',1),
	 (112,true,'yearly.pseterm',true,false,false,'Postsecondary Grading Period','PSETERM',NULL,0,'50',1),
	 (113,true,'yearly.persistden',true,false,false,'Postsecondary Persistence Objective-Denominator','PERSISTDEN',NULL,0,'50',1),
	 (114,true,'yearly.persistnum',true,false,false,'Postsecondary Persistence Objective-Numerator','PERSISTNUM',NULL,0,'50',1),
	 (115,true,'yearly.psremediat',true,false,false,'Postsecondary Remediation','PSREMEDIAT',NULL,0,'50',1),
	 (116,true,'yearly.stemdegree',true,false,false,'Postsecondary STEM Degree','STEMDEGREE',NULL,0,'50',1),
	 (117,false,'lablog.visitreason',false,false,false,'Reason for Visit','VISIT REASON',NULL,0,'50',1),
	 (118,true,'yearly.reasonleav',true,false,false,'Reason for Withdrawal/Leaving Project','REASON',NULL,0,'50',1),
	 (119,true,'yearly.greason',true,false,false,'Reason left Graduate School','GREASON',NULL,0,'50',1),
	 (120,true,'yearly.noenreason',true,false,false,'Reason Not Enrolled','NOENREASON',NULL,0,'50',1);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (121,true,'main.vetscherea',true,false,false,'Reason of Recheduling','VETSCHEREA',NULL,0,'50',1),
	 (122,true,'yearly.recupdated',true,false,false,'Record Updated','RECUPDATED',NULL,0,'50',1),
	 (123,true,'yearly.recruit',true,false,false,'Recruitment','RECRUIT',NULL,0,'50',1),
	 (124,false,'main.referedby',false,false,false,'Referred By','REFERRED BY',NULL,0,'50',1),
	 (125,true,'yearly.mcresearch
',true,false,false,'Research Activities','RESEARCH',NULL,0,'50',1),
	 (126,true,'main.vetrevsche',true,false,false,'Revised Scheduled Completion Year','VETREVSCHE',NULL,0,'50',1),
	 (127,false,'classes.room',false,false,false,'Room','ROOM',NULL,0,'50',1),
	 (128,true,'main.vetsche',true,false,false,'Scheduled Completion Year','VETSCHE',NULL,0,'50',1),
	 (129,true,'yearly.mcscholar',true,false,false,'Scholarly Activity','SCHOLAR',NULL,0,'50',1),
	 (130,true,NULL,true,false,false,'Science Instruction/Tutorials','SCIENCE',NULL,0,'50',1);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (131,true,'yearly.schpersist',true,false,false,'Secondary School Retention','SCHPERSIST',NULL,0,'50',1),
	 (132,true,'yearly.selftran',true,false,false,'Source of Postsecondary Education Information','SELFTRAN',NULL,0,'50',1),
	 (133,false,'staff.stfcodes',false,false,false,'Staff Codes','STAFF CODES',NULL,0,'50',1),
	 (134,true,NULL,true,false,false,'Standing Group Type (APR Column)','STANDINGGROUPTYPE',NULL,0,'50',1),
	 (135,true,'main.statetest',true,false,false,'State-Developed Test to Measure Academic Skills','STATETEST',NULL,0,'50',1),
	 (136,true,'main.mcstem',true,false,false,'STEM Major','MCSTEM',NULL,0,'50',1),
	 (137,true,'yearly.sumbridge',true,false,false,'Summer Bridge','SUMBRIDGE',NULL,0,'50',1),
	 (138,false,NULL,false,false,true,'Teacher','TEACHER',NULL,0,'50',1),
	 (139,true,'yearly.trackcomp',true,false,false,'Tracking Completed','TRACKCOMP',NULL,0,'50',1),
	 (140,true,'yearly.transfers',true,false,false,'Transfers','TRANSFERS',NULL,0,'50',1);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (141,false,'yearly.tutor',false,false,true,'Tutor','TUTOR',NULL,0,'50',1),
	 (142,true,'yearly.testtype',true,false,false,'Type of Standarized Tests','TESTTYPE',NULL,0,'50',1),
	 (143,true,'eddata.summerresi',true,false,false,'UB,UBMS,VUB Summer residential Program Type','SUMMERRESI',NULL,0,'50',1),
	 (144,true,'eddata.regional',true,false,false,'UBMS Project type','REGIONAL',NULL,0,'50',1),
	 (145,true,'yearly.vcall',true,false,false,'Veteran Called to Active Duty Status','VCALL',NULL,0,'50',1),
	 (146,true,'yearly.vgradelev',true,false,false,'Veteran Educational Status (at end)','VGRADELEVEL',NULL,0,'50',1),
	 (147,true,'main.venterlev',true,false,false,'Veteran Educational Status (Entry into Project)','VENTERLEVEL',NULL,0,'50',1),
	 (148,true,'main.venterjob',true,false,false,'Veteran Employment Status','VENTERJOB',NULL,0,'50',1),
	 (149,true,'main.vfinaidrec',true,false,false,'Veteran Financial Aid','VFINAIDREC',NULL,0,'50',1),
	 (150,false,'formslog.formname',false,false,false,'Wallet Name','Wallet Name',NULL,0,'50',1);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (151,true,NULL,true,false,false,'Yearly Child Service Heading','SERHEADING',NULL,0,'50',1),
	 (152,true,NULL,true,false,false,'Yearly Child Service Type','SERTYPE',NULL,0,'50',1),
	 (153,true,NULL,true,false,false,'Yes-No Options','YESNO',NULL,0,'50',1),
	 (154,false,'contactchild.activityid
yearlychild.servalue',true,true,true,'Activity','ACTIVITY','Activity~Activity',1,'50~50',1),
	 (155,true,'yearlychild.servalue
contact.aprsubject',true,true,false,'APR Subject Types','APR SUBJECT','APR Subject Types~APR Subject Types',6,'50~50',1),
	 (156,true,'main.bdegree
yearly.bdegree',true,false,false,'Bachelor''s Degree','BDEGREE','Bachelor''s Degree~Bachelor''s Degree Attained',0,'50~50',1),
	 (157,false,'botform_submission.form_name
botform_maintenance.form_name',false,false,false,'BOT Form Name','BOT FORM NAME','BOT Form Name~BOT Form Name',0,'50~50',1),
	 (158,true,'yearly.enroll
main.enterenrol',true,false,false,'Enrollment Status','ENROLL','Enrollment Status (at the end of the academic year)~Enrollment Status (in academic year first served)',0,'50~50',1),
	 (159,false,'exam.examname
examchild.examname',false,false,false,'Exam Name','EXAM NAME','Exam Name~Exam Name',0,'50~50',1),
	 (160,true,'main.lepentry
main.leplastser',true,false,false,'Limited English Proficiency Status','LIMITEDENGPRO','Limited English Proficiency (Date of First Participation)~Limited English Proficiency (Date of Last Service)',0,'50~50',1);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (161,false,'yearly.major
graduated.major',false,false,false,'Major','MAJOR','Major~Major',0,'50~50',1),
	 (162,false,'main.sitelocate
appusers.sitelocate',false,false,false,'Site Location','SITE LOCATION','Site Location~Site Location',0,'50~50',1),
	 (163,false,'yearly.counsel
yearly.tutor',false,true,true,'Staff','STAFF','Staff~Tutor',0,'50~50',1),
	 (164,true,'main.staterlagr
main.statemathg',true,false,false,'State Grade level in which student was Assessed','STATE10GRADE','Grade level when Assessed for State 10th Reading Standard~Grade level when Assessed for State 10th Math Standard',0,'50~50',1),
	 (165,true,'main.state8rla
main.state8math',true,false,false,'State Met 8th Grade Achievement Standard Options','STATE8MET','Met 8th Grade State Reading Language Art Standard~Met 8th Grade State Math Standard',0,'50~50',1),
	 (166,false,'contact.stfid
classes.stfid',true,true,true,'STFID - DO NOT USE','STFID','Stfid~Stfid',0,'50~50',1),
	 (167,false,'classes.subject
contact.subject',false,false,false,'Subject ( Classes/ Contacts)','SUBJECT','Subject~Subject',0,'50~50',1),
	 (168,false,'formslog.formtype
yearlychild.servalue',true,true,false,'Wallet Type','Wallet Type','Wallet Type~Wallet Type',5,'50~50',1),
	 (169,false,'classes.semester
courses.semester
semester.semester',true,true,false,'Semester Type','SEMESTER','Semester~Semester~Semester',0,'50~50~50',1),
	 (170,false,'yearly.college
main.collegeent
main.gradcoll
main.gdoccoll',false,false,true,'College','COLLEGE','College~College - Entry~Graduate School First Attended~Doctorate College',0,'50~50~50~50',1);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (171,false,'yearly.counsel
graduated.counsel',false,false,true,'Counselor','COUNSELOR','Counselor~Counselor',0,'50~50~50~50',1),
	 (172,true,'main.gpascale
main.msgpascale
yearly.gpaendsc
yearly.gpastartsc',true,false,false,'GPA Scale','GPASCALE','GPA HS Scale (Entry into Project)~GPA MS Scale(Entry into Project)~GPA Scale (at end of Reporting Period)~GPA Scale (at start of Reporting Period)',0,'50~50~50~50',1),
	 (173,false,'staff.stfcustom1
staff.stfcustom2
staff.stfcustom3
staff.stfcustom4',false,false,false,'Staff Custom Field','STAFF CUSTOM','Staff Custom 1~Staff Custom 2~ Staff Custom 3~Staff Custom 4',0,'50~50~50~50',1),
	 (174,true,'main.state10rla
main.state10mat
yearly.state10rla
yearly.state10mat',true,false,false,'State Met 10th Grade Achievement Standard Options','STATE10MET','Met 10th Grade State Reading Language Art Standard~Met 10th Grade State Math Standard~Met HS State Acad. Achievement Standard at Proficient Level—Reading/language arts~Met HS State Acad. Achievement Standard at Proficient Level—Math',0,'50~50~50~50',1),
	 (175,true,'main.city
mainchild.pcity
eddata.city
graduated.city
school.city
staff.stfcity',false,false,false,'City','CITY','City~City~City~City~City~City',0,'50~50~50~50~50~50',1),
	 (176,false,'main.state
eddata.state
graduated.state
main.dlstate
mainchild.pstate
school.state
staff.stfstate
staffchild.stfstate',false,false,false,'State (Postal Address)','STATE','State (Postal Address)~State~State~State (Driving License)~State~State~State~State',0,'50~50~50~50~50~50~50~50',1),
	 (241,true,'main.finaidrecd',true,false,false,'Financial Aid','FINAIDRECD',NULL,0,'50',2),
	 (242,false,'yearly.finaidname',false,false,false,'Financial Aid Name','FINANCIAL AID NAME',NULL,0,'50',2),
	 (177,false,'main.phn1ty
main.phn2ty
mainchild.pphn1ty
mainchild.pphn2ty
mainchild.pphn3ty
staff.stfphn1ty
staff.stfphn2ty
staff.stfphn3ty
staffchild.stfphn1ty
staffchild.stfphn2ty
staffchild.stfphn3ty',false,false,false,'Phone Type','PHONE TYPE','Phone Type 1~Phone Type 2~Phone Type 1~Phone Type 2~Phone Type 3~Phone Type 1~Phone Type 2~Phone Type 3~Phone Type 1~Phone Type 2~Phone Type 3',0,'50~50~50~50~50~50~50~50~50~50',1),
	 (178,true,'main.track',true,false,false,'APR IV E - Tracking Graduate','TRACK',NULL,0,'A',1);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (179,true,'yearly.partstatus',true,false,false,'APR II A - Participant Status','PARTSTATUS',NULL,0,'10',2),
	 (180,true,'main.eligibilit',true,false,false,'APR II B - Eligibility','ELIGIBILITY',NULL,0,'10',2),
	 (181,true,'main.ethnic',true,false,false,'APR II C - Ethnicity','ETHNIC',NULL,0,'10',2),
	 (182,true,'main.gender',true,false,false,'APR II D - Gender','GENDER',NULL,0,'10',2),
	 (183,true,'yearly.othertrio',true,false,false,'APR II G - Served by Other Trio','OTHERTRIO',NULL,0,'10',2),
	 (184,true,'yearly.vgradelev',true,false,false,'APR II I - Military Connected','VGRADELEVEL',NULL,0,'10',2),
	 (185,true,'yearlychild.servalue',true,true,false,'APR IV - End Status','ENDSTATUS',NULL,4,'10',2),
	 (186,true,'yearly.collegety',true,false,false,'APR IV E - College Type','COLLEGETYPE',NULL,0,'10',2),
	 (187,false,'yearly.standing
semester.standing',true,false,true,'APR III - Grade / Standing','STANDING','APR III - Grade / Standing~Standing',0,'10~50',2),
	 (188,false,'yearly.school
main.schoolent
main.schoolend',false,false,true,'APR II H - School','SCHOOL','APR II H - School(Current Fiscal Year)~School (Entry into Project)~School (End of Project)',0,'10~50~50',2);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (189,true,'main.acadneed',true,false,false,'Academic Need','ACADNEED',NULL,0,'50',2),
	 (190,true,'yearly.acadstand',true,false,false,'Academic Standing','ACADSTAND',NULL,0,'50',2),
	 (191,true,'activity.actgid',true,false,true,'Activity Group','ACTIVITYGROUP',NULL,2,'50',2),
	 (192,true,NULL,true,false,false,'Activity Group Type','ACTIVITYGROUPTYPE',NULL,0,'50',2),
	 (193,true,'yearly.advancemat',true,false,false,'Advanced Math Course','ADVANCEMAT',NULL,0,'50',2),
	 (194,true,'yearly.apcourse',true,false,false,'Advanced Placement Course','APCOURSE',NULL,0,'50',2),
	 (195,false,'yearly.advisor',false,false,false,'Advisor','ADVISOR',NULL,0,'50',2),
	 (196,false,'asset.amake',false,false,false,'Asset Make','ASSET MAKE',NULL,0,'50',2),
	 (197,false,'asset.amodel',false,false,false,'Asset Model','ASSET MODEL',NULL,0,'50',2),
	 (198,false,'asset.astatus',true,false,false,'Asset Status','ASSETSTATUS',NULL,0,'50',2);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (199,false,'asset.atype',false,false,false,'Asset Type','ASSET TYPE',NULL,0,'50',2),
	 (200,true,'yearly.adegree',true,false,false,'Associate Degree','ADEGREE',NULL,0,'50',2),
	 (201,true,'main.atralgebra',true,false,false,'At Risk Algebra','ATRALGEBRA',NULL,0,'50',2),
	 (202,true,'main.atrlowgpa',true,false,false,'At Risk Low GPA','ATRLOWGPA',NULL,0,'50',2),
	 (203,true,'main.atrschool',true,false,false,'At Risk Out of School','ATRSCHOOL',NULL,0,'50',2),
	 (204,true,'main.atrstdtest',true,false,false,'At Risk Standard Test','ATRSTDTEST',NULL,0,'50',2),
	 (205,true,'main.commcoll',true,false,false,'Attended Community College','COMMCOLL',NULL,0,'50',2),
	 (206,false,'main.birthplace',false,false,false,'Birth Place','BIRTH PLACE',NULL,0,'50',2),
	 (207,false,'botform_submission.SUBMISSION_STATUS',true,false,false,'BOT Form Status','BOTFORMSTATUS',NULL,0,'50',2),
	 (208,true,'yearly.certi',true,false,false,'Certificate/ Diploma Completed','CERTI',NULL,0,'50',2);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (209,true,'main.vetschecir',true,false,false,'Circumstances of Recheduling','VETSCHECIR',NULL,0,'50',2),
	 (210,false,'main.codes',false,false,false,'Codes','CODES',NULL,0,'50',2),
	 (211,true,'main.cohortyear',true,false,false,'Cohort Year','COHORTYEAR',NULL,0,'50',2),
	 (212,true,'main.enterexam',true,false,false,'College Entrance Exam','ENTEREXAM',NULL,0,'50',2),
	 (213,true,'yearly.collgradel',true,false,false,'College Grade Level','COLLGRADE',NULL,0,'50',2),
	 (214,true,'yearly.collready',true,false,false,'College Ready','COLLREADY',NULL,0,'50',2),
	 (215,true,NULL,true,false,false,'Compare Symbols','COMPARE',NULL,0,'50',2),
	 (216,true,'yearly.completeyr',true,false,false,'Completion Year','COMPLETEYR',NULL,0,'50',2),
	 (217,true,NULL,true,false,false,'Component Type','COMPONENT',NULL,0,'50',2),
	 (218,true,NULL,true,false,false,'Component Type-APR','APRCOMPONENT',NULL,0,'50',2);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (219,true,'contact.stftype',true,false,false,'Contact Staff Type','CONTACTSTAFFTYPE',NULL,0,'50',2),
	 (220,false,'contact.conttype',true,false,false,'Contact Type','CONTACTTYPE',NULL,0,'50',2),
	 (221,false,'courses.courseinst',false,false,false,'Course Instructor','COURSE INSTRUCTOR',NULL,0,'50',2),
	 (222,false,'courses.coursename',false,false,false,'Course Name','COURSE NAME',NULL,0,'50',2),
	 (223,false,'courses.coursenum',false,true,false,'Course Number','COURSE NUMBER',NULL,0,'50',2),
	 (224,false,'main.custom1',false,false,false,'Custom Field 1','CUSTOM1',NULL,0,'50',2),
	 (225,false,'main.custom2',false,false,false,'Custom Field 2','CUSTOM2',NULL,0,'50',2),
	 (226,false,'yearly.custom3',false,false,false,'Custom Field 3','CUSTOM3',NULL,0,'50',2),
	 (227,false,'yearly.custom4',false,false,false,'Custom Field 4','CUSTOM4',NULL,0,'50',2),
	 (228,false,'maincfields.customname',true,true,false,'Custom Field Names','CUSTOMFIELDNAME',NULL,0,'50',2);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (229,true,NULL,true,true,true,'Custom Field Type','CUSTOMFIELDTYPE',NULL,0,'50',2),
	 (230,false,'classes.days',false,false,false,'Days','DAYS',NULL,0,'50',2),
	 (231,true,'yearly.deceased',true,false,false,'Deceased or Incapacitated','DECEASED',NULL,0,'50',2),
	 (232,true,'main.disconnect',true,false,false,'Disconnected Youth','DISCONNECT',NULL,0,'50',2),
	 (233,true,'main.docemploy',true,false,false,'Doctorate Employment Activity','DOCEMPLOY',NULL,0,'50',2),
	 (234,true,'yearly.dualenroll',true,false,false,'Dual Enrollment','DUALENROLL',NULL,0,'50',2),
	 (235,true,'yearly.decredenti',true,false,false,'Dual Enrollment Credentials','DECREDENTI',NULL,0,'50',2),
	 (236,false,'main.eligtype',false,false,false,'Eligibility Type','ELIGIBILITY TYPE',NULL,0,'50',2),
	 (237,true,'yearly.employ',true,false,false,'Employment','EMPLOY',NULL,0,'50',2),
	 (238,true,NULL,true,false,false,'English Instructions','ENGLISH',NULL,0,'50',2);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (239,false,'main.ethnictype',false,false,false,'Ethnic Type (National Origin)','ETHNIC TYPE',NULL,0,'50',2),
	 (240,true,' ',true,false,false,'FAFSA completion','FAFSA',NULL,0,'50',2),
	 (243,true,'yearly.finaidreas',true,false,false,'Financial Aid Un-met Reason','FINAIDREAS',NULL,0,'50',2),
	 (244,false,'yearly.finaidunme',false,false,false,'Financial Aid Unmet Name','FINANCIAL AID UNMET',NULL,0,'50',2),
	 (245,true,NULL,true,false,false,'Foreign Language Instructions','FOREIGNLANGUAGE',NULL,0,'50',2),
	 (246,true,'eddata.contfreq',true,false,false,'Frequency of contacts between participants','CONTFREQ',NULL,0,'50',2),
	 (247,true,'yearly.fundsource',true,false,false,'Funding Source','FUNDSOURCE',NULL,0,'50',2),
	 (248,true,'yearly.gradelevel',true,false,false,'Grade Level (at end of reporting period)','GRADELEVEL',NULL,0,'50',2),
	 (249,true,'yearly.gradestart',true,false,false,'Grade Level (at start of reporting period)','GRADESTART',NULL,0,'50',2),
	 (250,true,'main.enterlevel',true,false,false,'Grade Level (at time of first entry into project)','ENTERLEVEL',NULL,0,'50',2);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (251,true,'yearly.hsgradepro',true,false,false,'Grade Progression Over Year','GRADEPRO',NULL,0,'50',2),
	 (252,true,'yearly.gradassist',true,false,false,'Graduate Assistantships','GRADASSIST',NULL,0,'50',2),
	 (253,true,'yearly.gradstudyl',true,false,false,'Graduate Current Year of Study','GRADSTUDYL',NULL,0,'50',2),
	 (254,true,'main.gdegree',true,false,false,'Graduate Degree Earned','GDEGREE',NULL,0,'50',2),
	 (255,false,'graduated.degreein',true,false,false,'Graduate Degree In','DEGREEIN',NULL,0,'50',2),
	 (256,false,'graduated.gdedustat',true,false,false,'Graduate Educational Status','GRADUATEEDUCATIONALSTATUS',NULL,0,'50',2),
	 (257,false,'graduated.employtype',true,false,false,'Graduate Employment Type','EMPLOYTYPE',NULL,0,'50',2),
	 (258,true,'main.gradadm',true,false,false,'Graduate School Admissions Test','GRADADM',NULL,0,'50',2),
	 (259,true,'yearly.enrollobj',true,false,false,'Graduate School Enrollment Objective','ENROLLOBJ',NULL,0,'50',2),
	 (260,true,'yearly.gpersist',true,false,false,'Graduate Student Persistence Status','GPERSIST',NULL,0,'50',2);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (261,true,'main.bdegreeco',true,false,false,'Graduating Cohort Year of Bachelor''s Degree','BDEGREECO',NULL,0,'50',2),
	 (262,true,'main.yearcogrd',true,false,false,'Graduation Cohort Year','YEARCOGRD',NULL,0,'50',2),
	 (263,false,'main.healthname',false,false,false,'Health Name','HEALTH NAME',NULL,0,'50',2),
	 (264,true,'yearly.hsgradstat',true,false,false,'High School Graduation Status','GRADSTATUS',NULL,0,'50',2),
	 (265,true,'yearly.vettest',true,false,false,'Improved Score on Standardized Test','VETTEST',NULL,0,'50',2),
	 (266,false,'main.incomelev',false,false,false,'Income Level','INCOME LEVEL',NULL,0,'50',2),
	 (267,false,'main.incomesou',false,false,false,'Income Source','INCOME SOURCE',NULL,0,'50',2),
	 (268,true,'yearly.initiative',true,false,false,'Initiative','INITIATIVE',NULL,0,'50',2),
	 (269,true,'yearly.mcintern',true,false,false,'Internship','INTERN',NULL,0,'50',2),
	 (270,false,'labservice.labserid',true,false,true,'Lab Service','LABSERVICE',NULL,0,'50',2);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (271,true,'yearly.partlength',true,false,false,'Length of Project Participation','PARTLENGTH',NULL,0,'50',2),
	 (272,true,'yearly.mcnmajor',true,false,false,'Major of Graduate Study','MCNMAJOR',NULL,0,'50',2),
	 (273,false,'main.marrstatus',true,false,false,'Marital Status','MARITALSTATUS',NULL,0,'50',2),
	 (274,true,NULL,true,false,false,'Mathematics Instructions/ Tutorials','MATH',NULL,0,'50',2),
	 (275,false,'classes.meettime',false,false,false,'Meeting Time','MEETING TIME',NULL,0,'50',2),
	 (276,false,'usermessages.msgstatus',true,false,false,'Message Priority Type','MSGSTATUS',NULL,0,'50',2),
	 (277,false,'graduated.milirank',false,false,false,'Military Rank','MILITARY RANK',NULL,0,'50',2),
	 (278,false,'graduated.militaryty',true,false,false,'Military Type','MILITARYTYPE',NULL,0,'50',2),
	 (279,true,'yearlychild.servalue',true,true,false,'Old End Status-For TS and EOC (prior to 2006-07)','OLDENDSTATUS',NULL,7,'50',2),
	 (280,false,'mainchild.ptitle',false,false,false,'Parent/ Guardian Relationship','PARENT RELATION',NULL,0,'50',2);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (281,true,'yearly.projretain',true,false,false,'Participant Retention in Project','PROJRETAIN',NULL,0,'50',2),
	 (282,true,'yearly.endstatus',true,false,false,'Participant Status (at end of Reporting Period)','PARTSTATUSEND',NULL,0,'50',2),
	 (283,true,'yearly.partlevel',true,false,false,'Participation Level','PARTLEVEL',NULL,0,'50',2),
	 (284,true,'yearly.persistend',true,false,false,'Persistence Graduation Status at end of year','PERSISTEND',NULL,0,'50',2),
	 (285,true,'yearly.persiststa',true,false,false,'Persistence Status at beginning at next year','PERSISTSTA',NULL,0,'50',2),
	 (286,true,'yearly.pscomplete',true,false,false,'Postsecondary Completion Objective','PSCOMPLETE',NULL,0,'50',2),
	 (287,true,'yearly.psenroll',true,false,false,'Postsecondary Enrollment Objective','PSENROLL',NULL,0,'50',2),
	 (288,true,'yearly.pseterm',true,false,false,'Postsecondary Grading Period','PSETERM',NULL,0,'50',2),
	 (289,true,'yearly.persistden',true,false,false,'Postsecondary Persistence Objective-Denominator','PERSISTDEN',NULL,0,'50',2),
	 (290,true,'yearly.persistnum',true,false,false,'Postsecondary Persistence Objective-Numerator','PERSISTNUM',NULL,0,'50',2);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (291,true,'yearly.psremediat',true,false,false,'Postsecondary Remediation','PSREMEDIAT',NULL,0,'50',2),
	 (292,true,'yearly.stemdegree',true,false,false,'Postsecondary STEM Degree','STEMDEGREE',NULL,0,'50',2),
	 (293,false,'lablog.visitreason',false,false,false,'Reason for Visit','VISIT REASON',NULL,0,'50',2),
	 (294,true,'yearly.reasonleav',true,false,false,'Reason for Withdrawal/Leaving Project','REASON',NULL,0,'50',2),
	 (295,true,'yearly.greason',true,false,false,'Reason left Graduate School','GREASON',NULL,0,'50',2),
	 (296,true,'yearly.noenreason',true,false,false,'Reason Not Enrolled','NOENREASON',NULL,0,'50',2),
	 (297,true,'main.vetscherea',true,false,false,'Reason of Recheduling','VETSCHEREA',NULL,0,'50',2),
	 (298,true,'yearly.recupdated',true,false,false,'Record Updated','RECUPDATED',NULL,0,'50',2),
	 (299,true,'yearly.recruit',true,false,false,'Recruitment','RECRUIT',NULL,0,'50',2),
	 (300,false,'main.referedby',false,false,false,'Referred By','REFERRED BY',NULL,0,'50',2);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (301,true,'yearly.mcresearch',true,false,false,'Research Activities','RESEARCH',NULL,0,'50',2),
	 (302,true,'main.vetrevsche',true,false,false,'Revised Scheduled Completion Year','VETREVSCHE',NULL,0,'50',2),
	 (303,true,'yearly.rigorous',true,false,false,'Rigorous Enrollment','RIGOROUS',NULL,0,'50',2),
	 (304,false,'classes.room',false,false,false,'Room','ROOM',NULL,0,'50',2),
	 (305,true,'main.vetsche',true,false,false,'Scheduled Completion Year','VETSCHE',NULL,0,'50',2),
	 (306,true,'yearly.mcscholar',true,false,false,'Scholarly Activity','SCHOLAR',NULL,0,'50',2),
	 (307,true,NULL,true,false,false,'Science Instruction/Tutorials','SCIENCE',NULL,0,'50',2),
	 (308,true,'yearly.schpersist',true,false,false,'Secondary School Retention','SCHPERSIST',NULL,0,'50',2),
	 (309,true,'yearly.selftran',true,false,false,'Source of Postsecondary Education Information','SELFTRAN',NULL,0,'50',2),
	 (310,false,'staff.stfcodes',false,false,false,'Staff Codes','STAFF CODES',NULL,0,'50',2);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (311,true,NULL,true,false,false,'Standing Group Type (APR Column)','STANDINGGROUPTYPE',NULL,0,'50',2),
	 (312,true,'main.statetest',true,false,false,'State-Developed Test to Measure Academic Skills','STATETEST',NULL,0,'50',2),
	 (313,true,'main.mcstem',true,false,false,'STEM Major','MCSTEM',NULL,0,'50',2),
	 (314,true,'yearly.sumbridge',true,false,false,'Summer Bridge','SUMBRIDGE',NULL,0,'50',2),
	 (315,false,NULL,false,false,true,'Teacher','TEACHER',NULL,0,'50',2),
	 (316,true,'yearly.trackcomp',true,false,false,'Tracking Completed','TRACKCOMP',NULL,0,'50',2),
	 (317,true,'main.track',true,false,false,'Tracking Graduate','TRACK',NULL,0,'50',2),
	 (318,true,'yearly.transfers',true,false,false,'Transfers','TRANSFERS',NULL,0,'50',2),
	 (319,false,'yearly.tutor',false,false,true,'Tutor','TUTOR',NULL,0,'50',2),
	 (320,true,'yearly.testtype',true,false,false,'Type of Standarized Tests','TESTTYPE',NULL,0,'50',2);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (321,true,'eddata.summerresi',true,false,false,'UB,UBMS,VUB Summer residential Program Type','SUMMERRESI',NULL,0,'50',2),
	 (322,true,'eddata.regional',true,false,false,'UBMS Project type','REGIONAL',NULL,0,'50',2),
	 (323,true,'yearly.vcalllen',true,false,false,'Veteran Call to Active Duty Length','VCALLLEN',NULL,0,'50',2),
	 (324,true,'yearly.vcall',true,false,false,'Veteran Called to Active Duty Status','VCALL',NULL,0,'50',2),
	 (325,true,'main.venterlev',true,false,false,'Veteran Educational Status (Entry into Project)','VENTERLEVEL',NULL,0,'50',2),
	 (326,true,'main.venterjob',true,false,false,'Veteran Employment Status','VENTERJOB',NULL,0,'50',2),
	 (327,true,'main.vfinaidrec',true,false,false,'Veteran Financial Aid','VFINAIDREC',NULL,0,'50',2),
	 (328,false,'formslog.formname',false,false,false,'Wallet Name','Wallet Name',NULL,0,'50',2),
	 (329,true,NULL,true,false,false,'Yearly Child Service Heading','SERHEADING',NULL,0,'50',2),
	 (330,true,NULL,true,false,false,'Yearly Child Service Type','SERTYPE',NULL,0,'50',2);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (331,true,NULL,true,false,false,'Yes-No Options','YESNO',NULL,0,'50',2),
	 (332,false,'contactchild.activityid
yearlychild.servalue',true,true,true,'Activity','ACTIVITY','Activity~Activity',1,'50~50',2),
	 (333,true,'yearlychild.servalue
contact.aprsubject',true,true,false,'APR Subject Types','APR SUBJECT','APR Subject Types~APR Subject Types',6,'50~50',2),
	 (334,true,'main.bdegree
yearly.bdegree',true,false,false,'Bachelor''s Degree','BDEGREE','Bachelor''s Degree~Bachelor''s Degree Attained',0,'50~50',2),
	 (335,false,'botform_submission.FORM_NAME
BOTFORM_MAINTENANCE.FORM_NAME',false,false,false,'BOT Form Name','BOT FORM NAME','BOT Form Name~BOT Form Name',0,'50~50',2),
	 (336,true,'main.highdegree
yearly.degree',true,false,false,'Degree/Certificate Completed','HIGHDEGREE','Degree/Certificate Completed~Degree/Certificate Undergraduate Completed',0,'50~50',2),
	 (337,true,'yearly.enroll
main.enterenrol',true,false,false,'Enrollment Status','ENROLL','Enrollment Status (at the end of the academic year)~Enrollment Status (in academic year first served)',0,'50~50',2),
	 (338,false,'exam.examname
examchild.examname',false,false,false,'Exam Name','EXAM NAME','Exam Name~Exam Name',0,'50~50',2),
	 (339,true,'main.lepentry
main.leplastser',true,false,false,'Limited English Proficiency Status','LIMITEDENGPRO','Limited English Proficiency (Date of First Participation)~Limited English Proficiency (Date of Last Service)',0,'50~50',2),
	 (340,false,'yearly.major
graduated.major',false,false,false,'Major','MAJOR','Major~Major',0,'50~50',2);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (341,false,'main.sitelocate
appusers.sitelocate',false,false,false,'Site Location','SITE LOCATION','Site Location~Site Location',0,'50~50',2),
	 (342,false,'yearly.counsel
yearly.tutor',false,true,true,'Staff','STAFF','Staff~Tutor',0,'50~50',2),
	 (343,true,'main.staterlagr
main.statemathg',true,false,false,'State Grade level in which student was Assessed','STATE10GRADE','Grade level when Assessed for State 10th Reading Standard~Grade level when Assessed for State 10th Math Standard',0,'50~50',2),
	 (344,true,'main.state8rla
main.state8math',true,false,false,'State Met 8th Grade Achievement Standard Options','STATE8MET','Met 8th Grade State Reading Language Art Standard~Met 8th Grade State Math Standard',0,'50~50',2),
	 (345,false,'contact.stfid
classes.stfid',true,true,true,'STFID - DO NOT USE','STFID','Stfid~Stfid',0,'50~50',2),
	 (346,false,'classes.subject
contact.subject',false,false,false,'Subject ( Classes/ Contacts)','SUBJECT','Subject~Subject',0,'50~50',2),
	 (347,false,'formslog.formtype
yearlychild.servalue',true,true,false,'Wallet Type','Wallet Type','Wallet Type Formslog ~Wallet Type Yearly Child',5,'50~50',2),
	 (348,false,'classes.semester
courses.semester
semester.semester',true,true,false,'Semester Type','SEMESTER','Semester~Semester~Semester',0,'50~50~50',2),
	 (349,true,'yearly.college
main.collegeent
main.gradcoll
main.gdoccoll',false,false,true,'College','COLLEGE','College~College - Entry~Graduate School First Attended~Doctorate College',0,'50~50~50~50',2),
	 (350,false,'yearly.counsel
graduated.counsel',false,false,true,'Counselor','COUNSELOR','Counselor~Counselor',0,'50~50~50~50',2);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (351,true,'main.gpascale
main.msgpascale
yearly.gpaendsc
yearly.gpastartsc',true,false,false,'GPA Scale','GPASCALE','GPA HS Scale (Entry into Project)~GPA MS Scale(Entry into Project)~GPA Scale (at end of Reporting Period)~GPA Scale (at start of Reporting Period)',0,'50~50~50~50',2),
	 (352,false,'staff.stfcustom1
staff.stfcustom2
staff.stfcustom3
staff.stfcustom4',false,false,false,'Staff Custom Field','STAFF CUSTOM','Staff Custom 1~Staff Custom 2~ Staff Custom 3~Staff Custom 4',0,'50~50~50~50',2),
	 (353,true,'main.state10rla
main.state10mat
yearly.state10rla
yearly.state10mat',true,false,false,'State Met 10th Grade Achievement Standard Options','STATE10MET','Met 10th Grade State Reading Language Art Standard~Met 10th Grade State Math Standard~Met HS State Acad. Achievement Standard at Proficient Level—Reading/language arts~Met HS State Acad. Achievement Standard at Proficient Level—Math',0,'50~50~50~50',2),
	 (354,true,'main.city
mainchild.pcity
eddata.city
graduated.city
school.city
staff.stfcity',false,false,false,'City','CITY','City~City~City~City~City~City',0,'50~50~50~50~50~50',2),
	 (406,true,'main.commcoll',true,false,false,'Attended Community College','COMMCOLL',NULL,0,'50',3),
	 (407,false,'main.birthplace',false,false,false,'Birth Place','BIRTH PLACE',NULL,0,'50',3),
	 (355,false,'main.state
eddata.state
graduated.state
main.dlstate
mainchild.pstate
school.state
staff.stfstate
staffchild.stfstate',false,false,false,'State (Postal Address)','STATE','State (Postal Address)~State~State~State (Driving License)~State~State~State~State',0,'50~50~50~50~50~50~50~50',2),
	 (356,false,'main.phn1ty
main.phn2ty
mainchild.pphn1ty
mainchild.pphn2ty
mainchild.pphn3ty
staff.stfphn1ty
staff.stfphn2ty
staff.stfphn3ty
staffchild.stfphn1ty
staffchild.stfphn2ty
staffchild.stfphn3ty',false,false,false,'Phone Type','PHONE TYPE','Phone Type 1~Phone Type 2~Phone Type 1~Phone Type 2~Phone Type 3~Phone Type 1~Phone Type 2~Phone Type 3~Phone Type 1~Phone Type 2~Phone Type 3',0,'50~50~50~50~50~50~50~50~50~50',2),
	 (357,false,'main.referedby',false,false,false,'Referred By','REFERRED BY',NULL,0,'1',3),
	 (358,true,'main.gender',true,false,false,'APR 09 - Gender','GENDER',NULL,0,'10',3);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (359,true,'main.ethnic',true,false,false,'APR 10 - 15 - Ethnicity /Race','ETHNIC',NULL,0,'10',3),
	 (360,true,'main.eligibilit',true,false,false,'APR 16 - Eligibility','ELIGIBILITY',NULL,0,'10',3),
	 (361,true,'main.atrstdtest',true,false,false,'APR 17 - At Risk Reading or Math','ATRSTDTEST',NULL,0,'10',3),
	 (362,true,'main.atrlowgpa',true,false,false,'APR 18 - At Risk - Low GPA','ATRLOWGPA',NULL,0,'10',3),
	 (363,true,'main.atralgebra',true,false,false,'APR 19 - At Risk - Pre-Algebra or Algebra','ATRALGEBRA',NULL,0,'10',3),
	 (364,true,'main.disconnect',true,false,false,'APR 21 - Disconnected Youth','DISCONNECT',NULL,0,'10',3),
	 (365,true,'main.acadneed',true,false,false,'APR 22 - Other Academic Need','ACADNEED',NULL,0,'10',3),
	 (366,true,'main.enterlevel',true,false,false,'APR 25 - Grade Level at First Service','ENTERLEVEL',NULL,0,'10',3),
	 (367,true,'yearly.deceased',true,false,false,'APR 26 - Deceased or Incapacitated','DECEASED',NULL,0,'10',3),
	 (368,true,'yearly.partstatus',true,false,false,'APR 27 - Participant Status','PARTSTATUS',NULL,0,'10',3);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (369,true,'yearly.partlevel',true,false,false,'APR 28 - Participation Level','PARTLEVEL',NULL,0,'10',3),
	 (370,true,'yearly.othertrio',true,false,false,'APR 29 - Served by Other Federally Funded Program','OTHERTRIO',NULL,0,'10',3),
	 (371,true,'yearly.gradestart',true,false,false,'APR 30 - Grade Level at starting of this fiscal year','GRADESTART',NULL,0,'10',3),
	 (372,true,'yearly.gradelevel',true,false,false,'APR 31 - Grade Level at the beginning of the following fiscal year','GRADELEVEL',NULL,0,'10',3),
	 (373,true,'yearly.hsgradstat',true,false,false,'APR 34 - HS Graduation Status','GRADSTATUS',NULL,0,'10',3),
	 (374,true,'yearly.rigorous',true,false,false,'APR 36 - Rigorous Program','RIGOROUS',NULL,0,'10',3),
	 (375,true,'yearly.schpersist',true,false,false,'APR 37 - Secondary School Retention Objective-Numerator for reporting year','SCHPERSIST',NULL,0,'10',3),
	 (376,true,'yearly.apcourse',true,false,false,'APR 40 - Advanced Placement Course Completed','APCOURSE',NULL,0,'10',3),
	 (377,true,'yearly.dualenroll',true,false,false,'APR 41 - Dual Enrollment','DUALENROLL',NULL,0,'10',3),
	 (378,true,'yearly.decredenti',true,false,false,'APR 42 - Dual Enrollment Credentials Completed','DECREDENTI',NULL,0,'10',3);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (379,true,'yearly.advancemat',true,false,false,'APR 43 - Advanced Math Courses Completed ','ADVANCEMAT',NULL,0,'10',3),
	 (380,true,'yearly.fafsa',true,false,false,'APR 44 - FAFSA completion','FAFSA',NULL,0,'10',3),
	 (381,true,'yearly.reasonleav',true,false,false,'APR 46 - Reason for Leaving Program','REASON',NULL,0,'10',3),
	 (382,true,'yearly.employ',true,false,false,'APR 48 - Employment','EMPLOY',NULL,0,'10',3),
	 (383,true,'yearly.selftran',true,false,false,'APR 52 - Source of Postsecondary Education Information','SELFTRAN',NULL,0,'10',3),
	 (384,true,'yearly.collgradel',true,false,false,'APR 56 - College Status Beginning of Next Academic Year','COLLGRADE',NULL,0,'10',3),
	 (385,true,'yearly.certi',true,false,false,'APR 57 - Certificate/ Diploma Completed','CERTI',NULL,0,'10',3),
	 (386,true,'yearly.adegree',true,false,false,'APR 59 - Associate Degree Attained','ADEGREE',NULL,0,'10',3),
	 (387,true,'yearly.psenroll',true,false,false,'APR 63 - Postsecondary Enrollment Objective-for Current Reporting Year','PSENROLL',NULL,0,'10',3),
	 (388,true,'yearly.psremediat',true,false,false,'APR 64 - Postsecondary Remediation','PSREMEDIAT',NULL,0,'10',3);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (389,true,'yearly.pscomplete',true,false,false,'APR 65 - Postsecondary Completion Objective - Numerator','PSCOMPLETE',NULL,0,'10',3),
	 (390,true,'yearly.stemdegree',true,false,false,'APR 66 - Postsecondary STEM Degree','STEMDEGREE',NULL,0,'10',3),
	 (391,true,'yearly.state10rla
yearly.state10mat
main.state10rla
main.state10mat',true,false,false,'APR 38/39 - Met HS State Achievement Level','STATE10MET','APR 38 -  Met HS State Achievement Level-Reading/Language Arts~APR 39 - Met HS State Achievement Level-Math~Met 10th Grade State Reading Language Art Standard~Met 10th Grade State Math Standard',0,'10~10~50~50',3),
	 (392,true,'main.lepentry
main.leplastser',true,false,false,'APR 20 - Limited English Proficiency - at Start','LIMITEDENGPRO','APR 20 - Limited English Proficiency - at Start~Limited English Proficiency (Date of Last Service)',0,'10~50',3),
	 (393,true,'yearly.bdegree
main.bdegree',true,false,false,'APR 61 - Bachelor''s Degree Attained','BDEGREE','APR 61 - Bachelor''s Degree Attained~Bachelors Degree',0,'10~50',3),
	 (394,false,'main.schoolent
yearly.school
main.schoolend',false,false,true,'APR 23 - School (Entry School)','SCHOOL','APR 23 - Entry School~School(Current Fiscal Year)~School (End of Project)',0,'10~50~50',3),
	 (395,false,'main.collegeent
yearly.college
main.gradcoll
main.gdoccoll',false,false,true,'APR 55 - College','COLLEGE','APR 55 - First College Attended~College~Graduate School First Attended~Doctorate College',0,'10~50~50~50',3),
	 (396,true,'main.city
mainchild.pcity
eddata.city
graduated.city
school.city
staff.stfcity',false,false,false,'City','CITY','City~City~City~City~City~City',0,'5~50~50~50~50~50',3),
	 (397,true,'yearly.acadstand',true,false,false,'Academic Standing','ACADSTAND',NULL,0,'50',3),
	 (398,true,'activity.actgid',true,false,true,'Activity Group','ACTIVITYGROUP',NULL,2,'50',3);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (399,true,NULL,true,false,false,'Activity Group Type','ACTIVITYGROUPTYPE',NULL,0,'50',3),
	 (400,false,'yearly.advisor',false,false,false,'Advisor','ADVISOR',NULL,0,'50',3),
	 (401,false,'asset.amake',false,false,false,'Asset Make','ASSET MAKE',NULL,0,'50',3),
	 (402,false,'asset.amodel',false,false,false,'Asset Model','ASSET MODEL',NULL,0,'50',3),
	 (403,false,'asset.astatus',true,false,false,'Asset Status','ASSETSTATUS',NULL,0,'50',3),
	 (404,false,'asset.atype',false,false,false,'Asset Type','ASSET TYPE',NULL,0,'50',3),
	 (405,true,'main.atrschool',true,false,false,'At Risk Out of School','ATRSCHOOL',NULL,0,'50',3),
	 (408,false,'botform_submission.SUBMISSION_STATUS',true,false,false,'BOT Form Status','BOTFORMSTATUS',NULL,0,'50',3),
	 (409,true,'main.vetschecir',true,false,false,'Circumstances of Recheduling','VETSCHECIR',NULL,0,'50',3),
	 (410,false,'main.codes',false,false,false,'Codes','CODES',NULL,0,'50',3);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (411,true,'main.cohortyear',true,false,false,'Cohort Year','COHORTYEAR',NULL,0,'50',3),
	 (412,true,'main.enterexam',true,false,false,'College Entrance Exam','ENTEREXAM',NULL,0,'50',3),
	 (413,true,'yearly.collready',true,false,false,'College Ready','COLLREADY',NULL,0,'50',3),
	 (414,true,'yearly.collegety',true,false,false,'College Type','COLLEGETYPE',NULL,0,'50',3),
	 (415,true,NULL,true,false,false,'Compare Symbols','COMPARE',NULL,0,'50',3),
	 (416,true,'yearly.completeyr',true,false,false,'Completion Year','COMPLETEYR',NULL,0,'50',3),
	 (417,true,NULL,true,false,false,'Component Type','COMPONENT',NULL,0,'50',3),
	 (418,true,NULL,true,false,false,'Component Type-APR','APRCOMPONENT',NULL,0,'50',3),
	 (419,true,'contact.stftype',true,false,false,'Contact Staff Type','CONTACTSTAFFTYPE',NULL,0,'50',3),
	 (420,false,'contact.conttype',true,false,false,'Contact Type','CONTACTTYPE',NULL,0,'50',3);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (421,false,'courses.courseinst',false,false,false,'Course Instructor','COURSE INSTRUCTOR',NULL,0,'50',3),
	 (422,false,'courses.coursename',false,false,false,'Course Name','COURSE NAME',NULL,0,'50',3),
	 (423,false,'courses.coursenum',false,true,false,'Course Number','COURSE NUMBER',NULL,0,'50',3),
	 (424,false,'main.custom1',false,false,false,'Custom Field 1','CUSTOM1',NULL,0,'50',3),
	 (425,false,'main.custom2',false,false,false,'Custom Field 2','CUSTOM2',NULL,0,'50',3),
	 (426,false,'yearly.custom3',false,false,false,'Custom Field 3','CUSTOM3',NULL,0,'50',3),
	 (427,false,'yearly.custom4',false,false,false,'Custom Field 4','CUSTOM4',NULL,0,'50',3),
	 (428,false,'maincfields.customname',true,true,false,'Custom Field Names','CUSTOMFIELDNAME',NULL,0,'50',3),
	 (429,true,NULL,true,true,true,'Custom Field Type','CUSTOMFIELDTYPE',NULL,0,'50',3),
	 (430,false,'classes.days',false,false,false,'Days','DAYS',NULL,0,'50',3);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (431,true,'main.docemploy',true,false,false,'Doctorate Employment Activity','DOCEMPLOY',NULL,0,'50',3),
	 (432,false,'main.eligtype',false,false,false,'Eligibility Type','ELIGIBILITY TYPE',NULL,0,'50',3),
	 (433,true,'yearlychild.servalue',true,true,false,'End Status','ENDSTATUS',NULL,4,'50',3),
	 (434,true,NULL,true,false,false,'English Instructions','ENGLISH',NULL,0,'50',3),
	 (435,false,'main.ethnictype',false,false,false,'Ethnic Type (National Origin)','ETHNIC TYPE',NULL,0,'50',3),
	 (436,true,'main.finaidrecd',true,false,false,'Financial Aid','FINAIDRECD',NULL,0,'50',3),
	 (437,false,'yearly.finaidname',false,false,false,'Financial Aid Name','FINANCIAL AID NAME',NULL,0,'50',3),
	 (438,true,'yearly.finaidreas',true,false,false,'Financial Aid Un-met Reason','FINAIDREAS',NULL,0,'50',3),
	 (439,false,'yearly.finaidunme',false,false,false,'Financial Aid Unmet Name','FINANCIAL AID UNMET',NULL,0,'50',3),
	 (440,true,NULL,true,false,false,'Foreign Language Instructions','FOREIGNLANGUAGE',NULL,0,'50',3);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (441,true,'eddata.contfreq',true,false,false,'Frequency of contacts between participants','CONTFREQ',NULL,0,'50',3),
	 (442,true,'yearly.fundsource',true,false,false,'Funding Source','FUNDSOURCE',NULL,0,'50',3),
	 (443,true,'yearly.hsgradepro',true,false,false,'Grade Progression Over Year','GRADEPRO',NULL,0,'50',3),
	 (444,true,'yearly.gradassist',true,false,false,'Graduate Assistantships','GRADASSIST',NULL,0,'50',3),
	 (445,true,'yearly.gradstudyl',true,false,false,'Graduate Current Year of Study','GRADSTUDYL',NULL,0,'50',3),
	 (446,true,'main.gdegree',true,false,false,'Graduate Degree Earned','GDEGREE',NULL,0,'50',3),
	 (447,false,'graduated.degreein',true,false,false,'Graduate Degree In','DEGREEIN',NULL,0,'50',3),
	 (448,false,'graduated.gdedustat',true,false,false,'Graduate Educational Status','GRADUATEEDUCATIONALSTATUS',NULL,0,'50',3),
	 (449,false,'graduated.employtype',true,false,false,'Graduate Employment Type','EMPLOYTYPE',NULL,0,'50',3),
	 (450,true,'main.gradadm',true,false,false,'Graduate School Admissions Test','GRADADM',NULL,0,'50',3);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (451,true,'yearly.enrollobj',true,false,false,'Graduate School Enrollment Objective','ENROLLOBJ',NULL,0,'50',3),
	 (452,true,'yearly.gpersist',true,false,false,'Graduate Student Persistence Status','GPERSIST',NULL,0,'50',3),
	 (453,true,'main.bdegreeco',true,false,false,'Graduating Cohort Year of Bachelor''s Degree','BDEGREECO',NULL,0,'50',3),
	 (454,true,'main.yearcogrd',true,false,false,'Graduation Cohort Year','YEARCOGRD',NULL,0,'50',3),
	 (455,false,'main.healthname',false,false,false,'Health Name','HEALTH NAME',NULL,0,'50',3),
	 (456,true,'yearly.vettest',true,false,false,'Improved Score on Standardized Test','VETTEST',NULL,0,'50',3),
	 (457,false,'main.incomelev',false,false,false,'Income Level','INCOME LEVEL',NULL,0,'50',3),
	 (458,false,'main.incomesou',false,false,false,'Income Source','INCOME SOURCE',NULL,0,'50',3),
	 (459,true,'yearly.initiative',true,false,false,'Initiative','INITIATIVE',NULL,0,'50',3),
	 (460,true,'yearly.mcintern',true,false,false,'Internship','INTERN',NULL,0,'50',3);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (461,false,'labservice.labserid',true,false,true,'Lab Service','LABSERVICE',NULL,0,'50',3),
	 (462,true,'yearly.partlength',true,false,false,'Length of Project Participation','PARTLENGTH',NULL,0,'50',3),
	 (463,true,'yearly.mcnmajor',true,false,false,'Major of Graduate Study','MCNMAJOR',NULL,0,'50',3),
	 (464,false,'main.marrstatus',true,false,false,'Marital Status','MARITALSTATUS',NULL,0,'50',3),
	 (465,true,NULL,true,false,false,'Mathematics Instructions/ Tutorials','MATH',NULL,0,'50',3),
	 (466,false,'classes.meettime',false,false,false,'Meeting Time','MEETING TIME',NULL,0,'50',3),
	 (467,false,'usermessages.msgstatus',true,false,false,'Message Priority Type','MSGSTATUS',NULL,0,'50',3),
	 (468,false,'graduated.milirank',false,false,false,'Military Rank','MILITARY RANK',NULL,0,'50',3),
	 (469,false,'graduated.militaryty',true,false,false,'Military Type','MILITARYTYPE',NULL,0,'50',3),
	 (470,true,'yearlychild.servalue',true,true,false,'Old End Status-For TS and EOC (prior to 2006-07)','OLDENDSTATUS',NULL,7,'50',3);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (471,false,'mainchild.ptitle',false,false,false,'Parent/ Guardian Relationship','PARENT RELATION',NULL,0,'50',3),
	 (472,true,'yearly.projretain',true,false,false,'Participant Retention in Project','PROJRETAIN',NULL,0,'50',3),
	 (473,true,'yearly.endstatus',true,false,false,'Participant Status (at end of Reporting Period)','PARTSTATUSEND',NULL,0,'50',3),
	 (474,true,'yearly.persistend',true,false,false,'Persistence Graduation Status at end of year','PERSISTEND',NULL,0,'50',3),
	 (475,true,'yearly.persiststa',true,false,false,'Persistence Status at beginning at next year','PERSISTSTA',NULL,0,'50',3),
	 (476,true,'yearly.pseterm',true,false,false,'Postsecondary Grading Period','PSETERM',NULL,0,'50',3),
	 (477,true,'yearly.persistden',true,false,false,'Postsecondary Persistence Objective-Denominator','PERSISTDEN',NULL,0,'50',3),
	 (478,true,'yearly.persistnum',true,false,false,'Postsecondary Persistence Objective-Numerator','PERSISTNUM',NULL,0,'50',3),
	 (479,false,'lablog.visitreason',false,false,false,'Reason for Visit','VISIT REASON',NULL,0,'50',3),
	 (480,true,'yearly.greason',true,false,false,'Reason left Graduate School','GREASON',NULL,0,'50',3);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (481,true,'yearly.noenreason',true,false,false,'Reason Not Enrolled','NOENREASON',NULL,0,'50',3),
	 (482,true,'main.vetscherea',true,false,false,'Reason of Recheduling','VETSCHEREA',NULL,0,'50',3),
	 (483,true,'yearly.recupdated',true,false,false,'Record Updated','RECUPDATED',NULL,0,'50',3),
	 (484,true,'yearly.recruit',true,false,false,'Recruitment','RECRUIT',NULL,0,'50',3),
	 (485,true,'yearly.mcresearch
',true,false,false,'Research Activities','RESEARCH',NULL,0,'50',3),
	 (486,true,'main.vetrevsche',true,false,false,'Revised Scheduled Completion Year','VETREVSCHE',NULL,0,'50',3),
	 (487,false,'classes.room',false,false,false,'Room','ROOM',NULL,0,'50',3),
	 (488,true,'main.vetsche',true,false,false,'Scheduled Completion Year','VETSCHE',NULL,0,'50',3),
	 (489,true,'yearly.mcscholar',true,false,false,'Scholarly Activity','SCHOLAR',NULL,0,'50',3),
	 (490,true,NULL,true,false,false,'Science Instruction/Tutorials','SCIENCE',NULL,0,'50',3);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (491,false,'staff.stfcodes',false,false,false,'Staff Codes','STAFF CODES',NULL,0,'50',3),
	 (492,true,NULL,true,false,false,'Standing Group Type (APR Column)','STANDINGGROUPTYPE',NULL,0,'50',3),
	 (493,true,'main.statetest',true,false,false,'State-Developed Test to Measure Academic Skills','STATETEST',NULL,0,'50',3),
	 (494,true,'main.mcstem',true,false,false,'STEM Major','MCSTEM',NULL,0,'50',3),
	 (495,true,'yearly.sumbridge',true,false,false,'Summer Bridge','SUMBRIDGE',NULL,0,'50',3),
	 (496,false,NULL,false,false,true,'Teacher','TEACHER',NULL,0,'50',3),
	 (497,true,'yearly.trackcomp',true,false,false,'Tracking Completed','TRACKCOMP',NULL,0,'50',3),
	 (498,true,'main.track',true,false,false,'Tracking Graduate','TRACK',NULL,0,'50',3),
	 (499,true,'yearly.transfers',true,false,false,'Transfers','TRANSFERS',NULL,0,'50',3),
	 (500,false,'yearly.tutor',false,false,true,'Tutor','TUTOR',NULL,0,'50',3);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (501,true,'yearly.testtype',true,false,false,'Type of Standarized Tests','TESTTYPE',NULL,0,'50',3),
	 (502,true,'eddata.summerresi',true,false,false,'UB,UBMS,VUB Summer residential Program Type','SUMMERRESI',NULL,0,'50',3),
	 (503,true,'eddata.regional',true,false,false,'UBMS Project type','REGIONAL',NULL,0,'50',3),
	 (504,true,'yearly.vcalllen',true,false,false,'Veteran Call to Active Duty Length','VCALLLEN',NULL,0,'50',3),
	 (505,true,'yearly.vcall',true,false,false,'Veteran Called to Active Duty Status','VCALL',NULL,0,'50',3),
	 (506,true,'yearly.vgradelev',true,false,false,'Veteran Educational Status (at end)','VGRADELEVEL',NULL,0,'50',3),
	 (507,true,'main.venterlev',true,false,false,'Veteran Educational Status (Entry into Project)','VENTERLEVEL',NULL,0,'50',3),
	 (508,true,'main.venterjob',true,false,false,'Veteran Employment Status','VENTERJOB',NULL,0,'50',3),
	 (509,true,'main.vfinaidrec',true,false,false,'Veteran Financial Aid','VFINAIDREC',NULL,0,'50',3),
	 (510,false,'formslog.formname',false,false,false,'Wallet Name','Wallet Name',NULL,0,'50',3);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (511,true,NULL,true,false,false,'Yearly Child Service Heading','SERHEADING',NULL,0,'50',3),
	 (512,true,NULL,true,false,false,'Yearly Child Service Type','SERTYPE',NULL,0,'50',3),
	 (513,true,NULL,true,false,false,'Yes-No Options','YESNO',NULL,0,'50',3),
	 (514,false,'contactchild.activityid
yearlychild.servalue',true,true,true,'Activity','ACTIVITY','Activity~Activity',1,'50~50',3),
	 (515,true,'yearlychild.servalue
contact.aprsubject',true,true,false,'APR Subject Types','APR SUBJECT','APR Subject Types~APR Subject Types',6,'50~50',3),
	 (516,false,'botform_submission.FORM_NAME
BOTFORM_MAINTENANCE.FORM_NAME',false,false,false,'BOT Form Name','BOT FORM NAME','BOT Form Name~BOT Form Name',0,'50~50',3),
	 (517,true,'main.highdegree
yearly.degree',true,false,false,'Degree/Certificate Completed','HIGHDEGREE','Degree/Certificate Completed~Degree/Certificate Undergraduate Completed',0,'50~50',3),
	 (518,true,'yearly.enroll
main.enterenrol',true,false,false,'Enrollment Status','ENROLL','Enrollment Status (at the end of the academic year)~Enrollment Status (in academic year first served)',0,'50~50',3),
	 (519,false,'exam.examname
examchild.examname',false,false,false,'Exam Name','EXAM NAME','Exam Name~Exam Name ',0,'50~50',3),
	 (520,false,'yearly.standing
semester.standing',true,false,true,'Grade / Standing Type','STANDING','Standing~Standing',0,'50~50',3);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (521,false,'yearly.major
graduated.major',false,false,false,'Major','MAJOR','Major~Major',0,'50~50',3),
	 (522,false,'main.sitelocate
appusers.sitelocate',false,false,false,'Site Location','SITE LOCATION','Site Location~Site Location',0,'50~50',3),
	 (523,false,'yearly.counsel
yearly.tutor',false,true,true,'Staff','STAFF','Staff~Tutor',0,'50~50',3),
	 (524,true,'main.staterlagr
main.statemathg',true,false,false,'State Grade level in which student was Assessed','STATE10GRADE','Grade level when Assessed for State 10th Reading Standard~Grade level when Assessed for State 10th Math Standard',0,'50~50',3),
	 (525,true,'main.state8rla
main.state8math',true,false,false,'State Met 8th Grade Achievement Standard Options','STATE8MET','Met 8th Grade State Reading Language Art Standard~Met 8th Grade State Math Standard',0,'50~50',3),
	 (526,false,'contact.stfid
classes.stfid',true,true,true,'STFID - DO NOT USE','STFID','Stfid~Stfid',0,'50~50',3),
	 (527,false,'classes.subject
contact.subject',false,false,false,'Subject ( Classes/ Contacts)','SUBJECT','Subject~Subject',0,'50~50',3),
	 (528,false,'formslog.formtype
yearlychild.servalue',true,true,false,'Wallet Type','Wallet Type','Wallet Type Formslog ~Wallet Type Yearly Child',5,'50~50',3),
	 (529,false,'classes.semester
courses.semester
semester.semester',true,true,false,'Semester Type','SEMESTER','Semester~Semester~Semester',0,'50~50~50',3),
	 (530,false,'yearly.counsel
graduated.counsel',false,false,true,'Counselor','COUNSELOR','Counselor~Counselor',0,'50~50~50~50',3);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (531,true,'main.gpascale
main.msgpascale
yearly.gpaendsc
yearly.gpastartsc',true,false,false,'GPA Scale','GPASCALE','GPA HS Scale (Entry into Project)~GPA MS Scale(Entry into Project)~GPA Scale (at end of Reporting Period)~GPA Scale (at start of Reporting Period)',0,'50~50~50~50',3),
	 (532,false,'staff.stfcustom1
staff.stfcustom2
staff.stfcustom3
staff.stfcustom4',false,false,false,'Staff Custom Field','STAFF CUSTOM','Staff Custom 1~Staff Custom 2~ Staff Custom 3~Staff Custom 4',0,'50~50~50~50',3),
	 (533,false,'main.state
eddata.state
graduated.state
main.dlstate
mainchild.pstate
school.state
staff.stfstate
staffchild.stfstate',false,false,false,'State (Postal Address)','STATE','State (Postal Address)~State~State~State (Driving License)~State~State~State~State',0,'50~50~50~50~50~50~50~50',3),
	 (534,false,'main.phn1ty
main.phn2ty
mainchild.pphn1ty
mainchild.pphn2ty
mainchild.pphn3ty
staff.stfphn1ty
staff.stfphn2ty
staff.stfphn3ty
staffchild.stfphn1ty
staffchild.stfphn2ty
staffchild.stfphn3ty',false,false,false,'Phone Type','PHONE TYPE','Phone Type 1~Phone Type 2~Phone Type 1~Phone Type 2~Phone Type 3~Phone Type 1~Phone Type 2~Phone Type 3~Phone Type 1~Phone Type 2~Phone Type 3',0,'50~50~50~50~50~50~50~50~50~50',3),
	 (535,true,'main.gender',true,false,false,'APR 09 - Gender','GENDER',NULL,0,'10',4),
	 (536,true,'main.ethnic',true,false,false,'APR 10 - 15 - Ethnicity /Race','ETHNIC',NULL,0,'10',4),
	 (537,true,'main.eligibilit',true,false,false,'APR 16 - Eligibility','ELIGIBILITY',NULL,0,'10',4),
	 (538,true,'main.atrschool',true,false,false,'APR 17 - At Risk - Out of School for Five Years','ATRSCHOOL',NULL,0,'10',4),
	 (539,true,'main.atrstdtest',true,false,false,'APR 18 - At Risk-Low Standardized Test Scores','ATRSTDTEST',NULL,0,'10',4),
	 (540,true,'main.acadneed',true,false,false,'APR 20 - Academic Need','ACADNEED',NULL,0,'10',4);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (541,true,'yearly.recruit',true,false,false,'APR 21 - Recruitment','RECRUIT',NULL,0,'10',4),
	 (542,true,'main.venterlev',true,false,false,'APR 23 - Veteran Educational Status','VENTERLEVEL',NULL,0,'10',4),
	 (543,true,'main.venterjob',true,false,false,'APR 24 - Employment Status','VENTERJOB',NULL,0,'10',4),
	 (544,true,'yearly.deceased',true,false,false,'APR 25 - Deceased or Incapacitated','DECEASED',NULL,0,'10',4),
	 (545,true,'yearly.partstatus',true,false,false,'APR 26 - Participant Status','PARTSTATUS',NULL,0,'10',4),
	 (546,true,'yearly.othertrio',true,false,false,'APR 27 - Served by Other Federally Funded Program','OTHERTRIO',NULL,0,'10',4),
	 (547,true,'yearly.vcall',true,false,false,'APR 28 - Called to Active Duty Following Enrollment','VCALL',NULL,0,'10',4),
	 (548,true,'yearly.vettest',true,false,false,'APR 29 - Academic Improvement on Standardized Test','VETTEST',NULL,0,'10',4),
	 (549,true,'yearly.completeyr',true,false,false,'APR 31 - VUB Program Completion Year','COMPLETEYR',NULL,0,'10',4),
	 (550,true,'yearly.reasonleav',true,false,false,'APR 32 - Reason for Leaving Program','REASON',NULL,0,'10',4);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (551,true,'yearly.selftran',true,false,false,'APR 40 - Source of Postsecondary Education Information','SELFTRAN',NULL,0,'10',4),
	 (552,true,'yearly.collgradel',true,false,false,'APR 41 - College Status Beginning of Next Academic Year','COLLGRADE',NULL,0,'10',4),
	 (553,true,'yearly.psremediat',true,false,false,'APR 42 - Postsecondary Remediation','PSREMEDIAT',NULL,0,'10',4),
	 (554,true,'yearly.certi',true,false,false,'APR 43 - Certificate/ Diploma Completed','CERTI',NULL,0,'10',4),
	 (555,true,'yearly.adegree',true,false,false,'APR 45 - Associate Degree Attained','ADEGREE',NULL,0,'10',4),
	 (556,true,'yearly.vcalllen',true,false,false,'APR 49 - Length of Active Duty','VCALLLEN',NULL,0,'10',4),
	 (557,true,'yearly.bdegree
main.bdegree',true,false,false,'APR 47 - Bachelor''s Degree Attained','BDEGREE','APR 47 - Bachelor''s Degree Attained~Bachelors Degree',0,'10~50',4),
	 (558,false,'main.collegeent
yearly.college
main.gradcoll
main.gdoccoll',false,false,true,'APR 39 - College','COLLEGE','APR 39 - College First Attended~College~Graduate School First Attended~Doctorate College',0,'10~50~50~50',4),
	 (559,true,'yearly.acadstand',true,false,false,'Academic Standing','ACADSTAND',NULL,0,'50',4),
	 (560,true,'activity.actgid',true,false,true,'Activity Group','ACTIVITYGROUP',NULL,2,'50',4);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (561,true,NULL,true,false,false,'Activity Group Type','ACTIVITYGROUPTYPE',NULL,0,'50',4),
	 (562,true,'yearly.advancemat',true,false,false,'Advanced Math Course','ADVANCEMAT',NULL,0,'50',4),
	 (563,true,'yearly.apcourse',true,false,false,'Advanced Placement Course','APCOURSE',NULL,0,'50',4),
	 (564,false,'yearly.advisor',false,false,false,'Advisor','ADVISOR',NULL,0,'50',4),
	 (565,false,'asset.amake',false,false,false,'Asset Make','ASSET MAKE',NULL,0,'50',4),
	 (566,false,'asset.amodel',false,false,false,'Asset Model','ASSET MODEL',NULL,0,'50',4),
	 (567,false,'asset.astatus',true,false,false,'Asset Status','ASSETSTATUS',NULL,0,'50',4),
	 (568,false,'asset.atype',false,false,false,'Asset Type','ASSET TYPE',NULL,0,'50',4),
	 (569,true,'main.atralgebra',true,false,false,'At Risk Algebra','ATRALGEBRA',NULL,0,'50',4),
	 (570,true,'main.atrlowgpa',true,false,false,'At Risk Low GPA','ATRLOWGPA',NULL,0,'50',4);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (571,true,'main.commcoll',true,false,false,'Attended Community College','COMMCOLL',NULL,0,'50',4),
	 (572,false,'main.birthplace',false,false,false,'Birth Place','BIRTH PLACE',NULL,0,'50',4),
	 (573,false,'botform_submission.SUBMISSION_STATUS',true,false,false,'BOT Form Status','BOTFORMSTATUS',NULL,0,'50',4),
	 (574,true,'main.vetschecir',true,false,false,'Circumstances of Recheduling','VETSCHECIR',NULL,0,'50',4),
	 (575,false,'main.codes',false,false,false,'Codes','CODES',NULL,0,'50',4),
	 (576,true,'main.cohortyear',true,false,false,'Cohort Year','COHORTYEAR',NULL,0,'50',4),
	 (577,true,'main.enterexam',true,false,false,'College Entrance Exam','ENTEREXAM',NULL,0,'50',4),
	 (578,true,'yearly.collready',true,false,false,'College Ready','COLLREADY',NULL,0,'50',4),
	 (579,true,'yearly.collegety',true,false,false,'College Type','COLLEGETYPE',NULL,0,'50',4),
	 (580,true,NULL,true,false,false,'Compare Symbols','COMPARE',NULL,0,'50',4);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (581,true,NULL,true,false,false,'Component Type','COMPONENT',NULL,0,'50',4),
	 (582,true,NULL,true,false,false,'Component Type-APR','APRCOMPONENT',NULL,0,'50',4),
	 (583,true,'contact.stftype',true,false,false,'Contact Staff Type','CONTACTSTAFFTYPE',NULL,0,'50',4),
	 (584,false,'contact.conttype',true,false,false,'Contact Type','CONTACTTYPE',NULL,0,'50',4),
	 (585,false,'courses.courseinst',false,false,false,'Course Instructor','COURSE INSTRUCTOR',NULL,0,'50',4),
	 (586,false,'courses.coursename',false,false,false,'Course Name','COURSE NAME',NULL,0,'50',4),
	 (587,false,'courses.coursenum',false,true,false,'Course Number','COURSE NUMBER',NULL,0,'50',4),
	 (588,false,'main.custom1',false,false,false,'Custom Field 1','CUSTOM1',NULL,0,'50',4),
	 (589,false,'main.custom2',false,false,false,'Custom Field 2','CUSTOM2',NULL,0,'50',4),
	 (590,false,'yearly.custom3',false,false,false,'Custom Field 3','CUSTOM3',NULL,0,'50',4);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (591,false,'yearly.custom4',false,false,false,'Custom Field 4','CUSTOM4',NULL,0,'50',4),
	 (592,false,'maincfields.customname',true,true,false,'Custom Field Names','CUSTOMFIELDNAME',NULL,0,'50',4),
	 (593,true,NULL,true,true,true,'Custom Field Type','CUSTOMFIELDTYPE',NULL,0,'50',4),
	 (594,false,'classes.days',false,false,false,'Days','DAYS',NULL,0,'50',4),
	 (595,true,'main.disconnect',true,false,false,'Disconnected Youth','DISCONNECT',NULL,0,'50',4),
	 (596,true,'main.docemploy',true,false,false,'Doctorate Employment Activity','DOCEMPLOY',NULL,0,'50',4),
	 (597,true,'yearly.dualenroll',true,false,false,'Dual Enrollment','DUALENROLL',NULL,0,'50',4),
	 (598,true,'yearly.decredenti',true,false,false,'Dual Enrollment Credentials','DECREDENTI',NULL,0,'50',4),
	 (599,false,'main.eligtype',false,false,false,'Eligibility Type','ELIGIBILITY TYPE',NULL,0,'50',4),
	 (600,true,'yearly.employ',true,false,false,'Employment','EMPLOY',NULL,0,'50',4);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (601,true,'yearlychild.servalue',true,true,false,'End Status','ENDSTATUS',NULL,4,'50',4),
	 (602,true,NULL,true,false,false,'English Instructions','ENGLISH',NULL,0,'50',4),
	 (603,false,'main.ethnictype',false,false,false,'Ethnic Type (National Origin)','ETHNIC TYPE',NULL,0,'50',4),
	 (604,true,'yearly.fafsa',true,false,false,'FAFSA completion','FAFSA',NULL,0,'50',4),
	 (605,true,'main.finaidrecd',true,false,false,'Financial Aid','FINAIDRECD',NULL,0,'50',4),
	 (606,false,'yearly.finaidname',false,false,false,'Financial Aid Name','FINANCIAL AID NAME',NULL,0,'50',4),
	 (607,true,'yearly.finaidreas',true,false,false,'Financial Aid Un-met Reason','FINAIDREAS',NULL,0,'50',4),
	 (608,false,'yearly.finaidunme',false,false,false,'Financial Aid Unmet Name','FINANCIAL AID UNMET',NULL,0,'50',4),
	 (609,true,NULL,true,false,false,'Foreign Language Instructions','FOREIGNLANGUAGE',NULL,0,'50',4),
	 (610,true,'eddata.contfreq',true,false,false,'Frequency of contacts between participants','CONTFREQ',NULL,0,'50',4);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (611,true,'yearly.fundsource',true,false,false,'Funding Source','FUNDSOURCE',NULL,0,'50',4),
	 (612,true,'yearly.gradelevel',true,false,false,'Grade Level (at end of reporting period)','GRADELEVEL',NULL,0,'50',4),
	 (613,true,'yearly.gradestart',true,false,false,'Grade Level (at start of reporting period)','GRADESTART',NULL,0,'50',4),
	 (614,true,'main.enterlevel',true,false,false,'Grade Level (at time of first entry into project)','ENTERLEVEL',NULL,0,'50',4),
	 (615,true,'yearly.hsgradepro',true,false,false,'Grade Progression Over Year','GRADEPRO',NULL,0,'50',4),
	 (616,true,'yearly.gradassist',true,false,false,'Graduate Assistantships','GRADASSIST',NULL,0,'50',4),
	 (617,true,'yearly.gradstudyl',true,false,false,'Graduate Current Year of Study','GRADSTUDYL',NULL,0,'50',4),
	 (618,true,'main.gdegree',true,false,false,'Graduate Degree Earned','GDEGREE',NULL,0,'50',4),
	 (619,false,'graduated.degreein',true,false,false,'Graduate Degree In','DEGREEIN',NULL,0,'50',4),
	 (620,false,'graduated.gdedustat',true,false,false,'Graduate Educational Status','GRADUATEEDUCATIONALSTATUS',NULL,0,'50',4);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (621,false,'graduated.employtype',true,false,false,'Graduate Employment Type','EMPLOYTYPE',NULL,0,'50',4),
	 (622,true,'main.gradadm',true,false,false,'Graduate School Admissions Test','GRADADM',NULL,0,'50',4),
	 (623,true,'yearly.enrollobj',true,false,false,'Graduate School Enrollment Objective','ENROLLOBJ',NULL,0,'50',4),
	 (624,true,'yearly.gpersist',true,false,false,'Graduate Student Persistence Status','GPERSIST',NULL,0,'50',4),
	 (625,true,'main.bdegreeco',true,false,false,'Graduating Cohort Year of Bachelor''s Degree','BDEGREECO',NULL,0,'50',4),
	 (626,true,'main.yearcogrd',true,false,false,'Graduation Cohort Year','YEARCOGRD',NULL,0,'50',4),
	 (627,false,'main.healthname',false,false,false,'Health Name','HEALTH NAME',NULL,0,'50',4),
	 (628,true,'yearly.hsgradstat',true,false,false,'High School Graduation Status','GRADSTATUS',NULL,0,'50',4),
	 (629,false,'main.incomelev',false,false,false,'Income Level','INCOME LEVEL',NULL,0,'50',4),
	 (630,false,'main.incomesou',false,false,false,'Income Source','INCOME SOURCE',NULL,0,'50',4);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (631,true,'yearly.initiative',true,false,false,'Initiative','INITIATIVE',NULL,0,'50',4),
	 (632,true,'yearly.mcintern',true,false,false,'Internship','INTERN',NULL,0,'50',4),
	 (633,false,'labservice.labserid',true,false,true,'Lab Service','LABSERVICE',NULL,0,'50',4),
	 (634,true,'yearly.partlength',true,false,false,'Length of Project Participation','PARTLENGTH',NULL,0,'50',4),
	 (635,true,'yearly.mcnmajor',true,false,false,'Major of Graduate Study','MCNMAJOR',NULL,0,'50',4),
	 (636,false,'main.marrstatus',true,false,false,'Marital Status','MARITALSTATUS',NULL,0,'50',4),
	 (637,true,NULL,true,false,false,'Mathematics Instructions/ Tutorials','MATH',NULL,0,'50',4),
	 (638,false,'classes.meettime',false,false,false,'Meeting Time','MEETING TIME',NULL,0,'50',4),
	 (639,false,'usermessages.msgstatus',true,false,false,'Message Priority Type','MSGSTATUS',NULL,0,'50',4),
	 (640,false,'graduated.milirank',false,false,false,'Military Rank','MILITARY RANK',NULL,0,'50',4);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (641,false,'graduated.militaryty',true,false,false,'Military Type','MILITARYTYPE',NULL,0,'50',4),
	 (642,true,'yearlychild.servalue',true,true,false,'Old End Status-For TS and EOC (prior to 2006-07)','OLDENDSTATUS',NULL,7,'50',4),
	 (643,false,'mainchild.ptitle',false,false,false,'Parent/ Guardian Relationship','PARENT RELATION',NULL,0,'50',4),
	 (644,true,'yearly.projretain',true,false,false,'Participant Retention in Project','PROJRETAIN',NULL,0,'50',4),
	 (645,true,'yearly.endstatus',true,false,false,'Participant Status (at end of Reporting Period)','PARTSTATUSEND',NULL,0,'50',4),
	 (646,true,'yearly.partlevel',true,false,false,'Participation Level','PARTLEVEL',NULL,0,'50',4),
	 (647,true,'yearly.persistend',true,false,false,'Persistence Graduation Status at end of year','PERSISTEND',NULL,0,'50',4),
	 (648,true,'yearly.persiststa',true,false,false,'Persistence Status at beginning at next year','PERSISTSTA',NULL,0,'50',4),
	 (649,true,'yearly.pscomplete',true,false,false,'Postsecondary Completion Objective','PSCOMPLETE',NULL,0,'50',4),
	 (650,true,'yearly.psenroll',true,false,false,'Postsecondary Enrollment Objective','PSENROLL',NULL,0,'50',4);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (651,true,'yearly.pseterm',true,false,false,'Postsecondary Grading Period','PSETERM',NULL,0,'50',4),
	 (652,true,'yearly.persistden',true,false,false,'Postsecondary Persistence Objective-Denominator','PERSISTDEN',NULL,0,'50',4),
	 (653,true,'yearly.persistnum',true,false,false,'Postsecondary Persistence Objective-Numerator','PERSISTNUM',NULL,0,'50',4),
	 (654,true,'yearly.stemdegree',true,false,false,'Postsecondary STEM Degree','STEMDEGREE',NULL,0,'50',4),
	 (655,false,'lablog.visitreason',false,false,false,'Reason for Visit','VISIT REASON',NULL,0,'50',4),
	 (656,true,'yearly.greason',true,false,false,'Reason left Graduate School','GREASON',NULL,0,'50',4),
	 (657,true,'yearly.noenreason',true,false,false,'Reason Not Enrolled','NOENREASON',NULL,0,'50',4),
	 (658,true,'main.vetscherea',true,false,false,'Reason of Recheduling','VETSCHEREA',NULL,0,'50',4),
	 (659,true,'yearly.recupdated',true,false,false,'Record Updated','RECUPDATED',NULL,0,'50',4),
	 (660,false,'main.referedby',false,false,false,'Referred By','REFERRED BY',NULL,0,'50',4);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (661,true,'yearly.mcresearch
',true,false,false,'Research Activities','RESEARCH',NULL,0,'50',4),
	 (662,true,'main.vetrevsche',true,false,false,'Revised Scheduled Completion Year','VETREVSCHE',NULL,0,'50',4),
	 (663,true,'yearly.rigorous',true,false,false,'Rigorous Enrollment','RIGOROUS',NULL,0,'50',4),
	 (664,false,'classes.room',false,false,false,'Room','ROOM',NULL,0,'50',4),
	 (665,true,'main.vetsche',true,false,false,'Scheduled Completion Year','VETSCHE',NULL,0,'50',4),
	 (666,true,'yearly.mcscholar',true,false,false,'Scholarly Activity','SCHOLAR',NULL,0,'50',4),
	 (667,true,NULL,true,false,false,'Science Instruction/Tutorials','SCIENCE',NULL,0,'50',4),
	 (668,true,'yearly.schpersist',true,false,false,'Secondary School Retention','SCHPERSIST',NULL,0,'50',4),
	 (669,false,'staff.stfcodes',false,false,false,'Staff Codes','STAFF CODES',NULL,0,'50',4),
	 (670,true,NULL,true,false,false,'Standing Group Type (APR Column)','STANDINGGROUPTYPE',NULL,0,'50',4);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (671,true,'main.statetest',true,false,false,'State-Developed Test to Measure Academic Skills','STATETEST',NULL,0,'50',4),
	 (672,true,'main.mcstem',true,false,false,'STEM Major','MCSTEM',NULL,0,'50',4),
	 (673,true,'yearly.sumbridge',true,false,false,'Summer Bridge','SUMBRIDGE',NULL,0,'50',4),
	 (674,false,NULL,false,false,true,'Teacher','TEACHER',NULL,0,'50',4),
	 (675,true,'yearly.trackcomp',true,false,false,'Tracking Completed','TRACKCOMP',NULL,0,'50',4),
	 (676,true,'main.track',true,false,false,'Tracking Graduate','TRACK',NULL,0,'50',4),
	 (677,true,'yearly.transfers',true,false,false,'Transfers','TRANSFERS',NULL,0,'50',4),
	 (678,false,'yearly.tutor',false,false,true,'Tutor','TUTOR',NULL,0,'50',4),
	 (679,true,'yearly.testtype',true,false,false,'Type of Standarized Tests','TESTTYPE',NULL,0,'50',4),
	 (680,true,'eddata.summerresi',true,false,false,'UB,UBMS,VUB Summer residential Program Type','SUMMERRESI',NULL,0,'50',4);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (681,true,'eddata.regional',true,false,false,'UBMS Project type','REGIONAL',NULL,0,'50',4),
	 (682,true,'yearly.vgradelev',true,false,false,'Veteran Educational Status (at end)','VGRADELEVEL',NULL,0,'50',4),
	 (683,true,'main.vfinaidrec',true,false,false,'Veteran Financial Aid','VFINAIDREC',NULL,0,'50',4),
	 (684,false,'formslog.formname',false,false,false,'Wallet Name','Wallet Name',NULL,0,'50',4),
	 (685,true,NULL,true,false,false,'Yearly Child Service Heading','SERHEADING',NULL,0,'50',4),
	 (686,true,NULL,true,false,false,'Yearly Child Service Type','SERTYPE',NULL,0,'50',4),
	 (687,true,NULL,true,false,false,'Yes-No Options','YESNO',NULL,0,'50',4),
	 (688,false,'contactchild.activityid
yearlychild.servalue',true,true,true,'Activity','ACTIVITY','Activity~Activity',1,'50~50',4),
	 (689,true,'yearlychild.servalue
contact.aprsubject',true,true,false,'APR Subject Types','APR SUBJECT','APR Subject Types~APR Subject Types',6,'50~50',4),
	 (690,false,'botform_submission.FORM_NAME
BOTFORM_MAINTENANCE.FORM_NAME',false,false,false,'BOT Form Name','BOT FORM NAME','BOT Form Name~BOT Form Name',0,'50~50',4);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (691,true,'main.highdegree
yearly.degree',true,false,false,'Degree/Certificate Completed','HIGHDEGREE','Degree/Certificate Completed~Degree/Certificate Undergraduate Completed',0,'50~50',4),
	 (692,true,'yearly.enroll
main.enterenrol',true,false,false,'Enrollment Status','ENROLL','Enrollment Status (at the end of the academic year)~Enrollment Status (in academic year first served)',0,'50~50',4),
	 (693,false,'exam.examname
examchild.examname',false,false,false,'Exam Name','EXAM NAME','Exam Name~Exam Name',0,'50~50',4),
	 (694,false,'yearly.standing
semester.standing',true,false,true,'Grade / Standing Type','STANDING','Standing~Standing',0,'50~50',4),
	 (695,true,'main.lepentry
main.leplastser',true,false,false,'Limited English Proficiency Status','LIMITEDENGPRO','Limited English Proficiency (Date of First Participation)~Limited English Proficiency (Date of Last Service)',0,'50~50',4),
	 (696,false,'yearly.major
graduated.major',false,false,false,'Major','MAJOR','Major~Major',0,'50~50',4),
	 (697,false,'main.sitelocate
appusers.sitelocate',false,false,false,'Site Location','SITE LOCATION','Site Location~Site Location',0,'50~50',4),
	 (698,false,'yearly.counsel
yearly.tutor',false,true,true,'Staff','STAFF','Staff~Tutor',0,'50~50',4),
	 (699,true,'main.staterlagr
main.statemathg',true,false,false,'State Grade level in which student was Assessed','STATE10GRADE','Grade level when Assessed for State 10th Reading Standard~Grade level when Assessed for State 10th Math Standard',0,'50~50',4),
	 (700,true,'main.state8rla
main.state8math',true,false,false,'State Met 8th Grade Achievement Standard Options','STATE8MET','Met 8th Grade State Reading Language Art Standard~Met 8th Grade State Math Standard',0,'50~50',4);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (701,false,'contact.stfid
classes.stfid',true,true,true,'STFID - DO NOT USE','STFID','Stfid~Stfid',0,'50~50',4),
	 (702,false,'classes.subject
contact.subject',false,false,false,'Subject ( Classes/ Contacts)','SUBJECT','Subject~Subject',0,'50~50',4),
	 (703,false,'formslog.formtype
yearlychild.servalue',true,true,false,'Wallet Type','Wallet Type','Wallet Type Formslog ~Wallet Type Yearly Child',5,'50~50',4),
	 (704,false,'main.schoolent
yearly.school
main.schoolend',false,false,true,'School Name/Code','SCHOOL','School (Entry into Project)~School(Current Fiscal Year)~School (End of Project)',0,'50~50~50',4),
	 (705,false,'classes.semester
courses.semester
semester.semester',true,true,false,'Semester Type','SEMESTER','Semester~Semester~Semester',0,'50~50~50',4),
	 (706,false,'yearly.counsel
graduated.counsel',false,false,true,'Counselor','COUNSELOR','Counselor~Counselor',0,'50~50~50~50',4),
	 (707,true,'main.gpascale
main.msgpascale
yearly.gpaendsc
yearly.gpastartsc',true,false,false,'GPA Scale','GPASCALE','GPA HS Scale (Entry into Project)~GPA MS Scale(Entry into Project)~GPA Scale (at end of Reporting Period)~GPA Scale (at start of Reporting Period)',0,'50~50~50~50',4),
	 (708,false,'staff.stfcustom1
staff.stfcustom2
staff.stfcustom3
staff.stfcustom4',false,false,false,'Staff Custom Field','STAFF CUSTOM','Staff Custom 1~Staff Custom 2~ Staff Custom 3~Staff Custom 4',0,'50~50~50~50',4),
	 (709,true,'main.state10rla
main.state10mat
yearly.state10rla
yearly.state10mat',true,false,false,'State Met 10th Grade Achievement Standard Options','STATE10MET','Met 10th Grade State Reading Language Art Standard~Met 10th Grade State Math Standard~Met HS State Acad. Achievement Standard at Proficient Level—Reading/language arts~Met HS State Acad. Achievement Standard at Proficient Level—Math',0,'50~50~50~50',4),
	 (710,true,'main.city
mainchild.pcity
eddata.city
graduated.city
school.city
staff.stfcity',false,false,false,'City','CITY','City~City~City~City~City~City',0,'50~50~50~50~50~50',4);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (711,true,'main.state
eddata.state
graduated.state
main.dlstate
mainchild.pstate
school.state
staff.stfstate
staffchild.stfstate',false,false,false,'State (Postal Address)','STATE','State (Postal Address)~State~State~State (Driving License)~State~State~State~State',0,'50~50~50~50~50~50~50~50',4),
	 (712,false,'main.phn1ty
main.phn2ty
mainchild.pphn1ty
mainchild.pphn2ty
mainchild.pphn3ty
staff.stfphn1ty
staff.stfphn2ty
staff.stfphn3ty
staffchild.stfphn1ty
staffchild.stfphn2ty
staffchild.stfphn3ty',false,false,false,'Phone Type','PHONE TYPE','Phone Type 1~Phone Type 2~Phone Type 1~Phone Type 2~Phone Type 3~Phone Type 1~Phone Type 2~Phone Type 3~Phone Type 1~Phone Type 2~Phone Type 3',0,'50~50~50~50~50~50~50~50~50~50',4),
	 (713,true,'main.gender',true,false,false,'APR 09 - Gender','GENDER',NULL,0,'10',5),
	 (714,true,'main.ethnic',true,false,false,'APR 10 - 15 - Ethnicity /Race','ETHNIC',NULL,0,'10',5),
	 (715,true,'main.eligibilit',true,false,false,'APR 16 - Eligibility','ELIGIBILITY',NULL,0,'10',5),
	 (716,true,'main.atrstdtest',true,false,false,'APR 17 - At Risk Reading or Math','ATRSTDTEST',NULL,0,'10',5),
	 (717,true,'main.atrlowgpa',true,false,false,'APR 18 - At Risk - Low GPA','ATRLOWGPA',NULL,0,'10',5),
	 (718,true,'main.atralgebra',true,false,false,'APR 19 - At Risk - Pre-Algebra or Algebra','ATRALGEBRA',NULL,0,'10',5),
	 (719,true,'main.disconnect',true,false,false,'APR 21 - Disconnected Youth','DISCONNECT',NULL,0,'10',5),
	 (720,true,'main.acadneed',true,false,false,'APR 22 - Other Academic Need','ACADNEED',NULL,0,'10',5);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (721,true,'main.enterlevel',true,false,false,'APR 25 - Grade Level at First Service','ENTERLEVEL',NULL,0,'10',5),
	 (722,true,'yearly.deceased',true,false,false,'APR 26 - Deceased or Incapacitated','DECEASED',NULL,0,'10',5),
	 (723,true,'yearly.partstatus',true,false,false,'APR 27 - Participant Status','PARTSTATUS',NULL,0,'10',5),
	 (724,true,'yearly.partlevel',true,false,false,'APR 28 - Participation Level','PARTLEVEL',NULL,0,'10',5),
	 (725,true,'yearly.othertrio',true,false,false,'APR 29 - Served by Other Federally Funded Program','OTHERTRIO',NULL,0,'10',5),
	 (726,true,'yearly.gradestart',true,false,false,'APR 30 - Grade Level at starting of this fiscal year','GRADESTART',NULL,0,'10',5),
	 (727,true,'yearly.gradelevel',true,false,false,'APR 31 - Grade Level at the beginning of the following fiscal year','GRADELEVEL',NULL,0,'10',5),
	 (728,true,'yearly.hsgradstat',true,false,false,'APR 34 - HS Graduation Status','GRADSTATUS',NULL,0,'10',5),
	 (729,true,'yearly.rigorous',true,false,false,'APR 36 - Rigorous Program','RIGOROUS',NULL,0,'10',5),
	 (730,true,'yearly.schpersist',true,false,false,'APR 37 - Secondary School Retention Objective-Numerator for reporting year','SCHPERSIST',NULL,0,'10',5);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (731,true,'yearly.apcourse',true,false,false,'APR 40 - Advanced Placement Course Completed','APCOURSE',NULL,0,'10',5),
	 (732,true,'yearly.dualenroll',true,false,false,'APR 41 - Dual Enrollment','DUALENROLL',NULL,0,'10',5),
	 (733,true,'yearly.decredenti',true,false,false,'APR 42 - Dual Enrollment Credentials Completed','DECREDENTI',NULL,0,'10',5),
	 (734,true,'yearly.advancemat',true,false,false,'APR 43 - Advanced Math Courses Completed ','ADVANCEMAT',NULL,0,'10',5),
	 (735,true,'yearly.fafsa',true,false,false,'APR 44 - FAFSA completion','FAFSA',NULL,0,'10',5),
	 (736,true,'yearly.reasonleav',true,false,false,'APR 46 - Reason for Leaving Program','REASON',NULL,0,'10',5),
	 (737,true,'yearly.employ',true,false,false,'APR 48 - Employment','EMPLOY',NULL,0,'10',5),
	 (738,true,'yearly.selftran',true,false,false,'APR 52 - Source of Postsecondary Education Information','SELFTRAN',NULL,0,'10',5),
	 (739,true,'yearly.collgradel',true,false,false,'APR 56 - College Status Beginning of Next Academic Year','COLLGRADE',NULL,0,'10',5),
	 (740,true,'yearly.certi',true,false,false,'APR 57 - Certificate/ Diploma Completed','CERTI',NULL,0,'10',5);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (741,true,'yearly.adegree',true,false,false,'APR 59 - Associate Degree Attained','ADEGREE',NULL,0,'10',5),
	 (742,true,'yearly.psenroll',true,false,false,'APR 63 - Postsecondary Enrollment Objective-for Current Reporting Year','PSENROLL',NULL,0,'10',5),
	 (743,true,'yearly.psremediat',true,false,false,'APR 64 - Postsecondary Remediation','PSREMEDIAT',NULL,0,'10',5),
	 (744,true,'yearly.pscomplete',true,false,false,'APR 65 - Postsecondary Completion Objective - Numerator','PSCOMPLETE',NULL,0,'10',5),
	 (745,true,'yearly.stemdegree',true,false,false,'APR 66 - Postsecondary STEM Degree','STEMDEGREE',NULL,0,'10',5),
	 (746,true,'yearly.state10rla
yearly.state10mat
main.state10rla
main.state10mat',true,false,false,'APR 38/39 - Met HS State Achievement Level','STATE10MET','APR 38 -  Met HS State Achievement Level-Reading/Language Arts~APR 39 - Met HS State Achievement Level-Math~Met 10th Grade State Reading Language Art Standard~Met 10th Grade State Math Standard',0,'10~10~50~50',5),
	 (747,true,'main.lepentry
main.leplastser',true,false,false,'APR 20 - Limited English Proficiency - at Start','LIMITEDENGPRO','APR 20 - Limited English Proficiency - at Start~Limited English Proficiency (Date of Last Service)',0,'10~50',5),
	 (748,true,'yearly.bdegree
main.bdegree',true,false,false,'APR 61 - Bachelor''s Degree Attained','BDEGREE','APR 61 - Bachelor''s Degree Attained~Bachelors Degree',0,'10~50',5),
	 (749,false,'main.schoolent
yearly.school
main.schoolend',false,false,true,'APR 23 - School (Entry School)','SCHOOL','APR 23 - Entry School~School(Current Fiscal Year)~School (End of Project)',0,'10~50~50',5),
	 (750,false,'main.collegeent
yearly.college
main.gradcoll
main.gdoccoll',false,false,true,'APR 55 - College','COLLEGE','APR 55 - First College Attended~College~Graduate School First Attended~Doctorate College',0,'10~50~50~50',5);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (751,true,'yearly.acadstand',true,false,false,'Academic Standing','ACADSTAND',NULL,0,'50',5),
	 (752,true,'activity.actgid',true,false,true,'Activity Group','ACTIVITYGROUP',NULL,2,'50',5),
	 (753,true,NULL,true,false,false,'Activity Group Type','ACTIVITYGROUPTYPE',NULL,0,'50',5),
	 (754,false,'yearly.advisor',false,false,false,'Advisor','ADVISOR',NULL,0,'50',5),
	 (755,false,'asset.amake',false,false,false,'Asset Make','ASSET MAKE',NULL,0,'50',5),
	 (756,false,'asset.amodel',false,false,false,'Asset Model','ASSET MODEL',NULL,0,'50',5),
	 (757,false,'asset.astatus',true,false,false,'Asset Status','ASSETSTATUS',NULL,0,'50',5),
	 (758,false,'asset.atype',false,false,false,'Asset Type','ASSET TYPE',NULL,0,'50',5),
	 (759,true,'main.atrschool',true,false,false,'At Risk Out of School','ATRSCHOOL',NULL,0,'50',5),
	 (760,true,'main.commcoll',true,false,false,'Attended Community College','COMMCOLL',NULL,0,'50',5);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (761,false,'main.birthplace',false,false,false,'Birth Place','BIRTH PLACE',NULL,0,'50',5),
	 (762,false,'botform_submission.SUBMISSION_STATUS',true,false,false,'BOT Form Status','BOTFORMSTATUS',NULL,0,'50',5),
	 (763,true,'main.vetschecir',true,false,false,'Circumstances of Recheduling','VETSCHECIR',NULL,0,'50',5),
	 (764,false,'main.codes',false,false,false,'Codes','CODES',NULL,0,'50',5),
	 (765,true,'main.cohortyear',true,false,false,'Cohort Year','COHORTYEAR',NULL,0,'50',5),
	 (766,true,'main.enterexam',true,false,false,'College Entrance Exam','ENTEREXAM',NULL,0,'50',5),
	 (767,true,'yearly.collready',true,false,false,'College Ready','COLLREADY',NULL,0,'50',5),
	 (768,true,'yearly.collegety',true,false,false,'College Type','COLLEGETYPE',NULL,0,'50',5),
	 (769,true,NULL,true,false,false,'Compare Symbols','COMPARE',NULL,0,'50',5),
	 (770,true,'yearly.completeyr',true,false,false,'Completion Year','COMPLETEYR',NULL,0,'50',5);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (771,true,NULL,true,false,false,'Component Type','COMPONENT',NULL,0,'50',5),
	 (772,true,NULL,true,false,false,'Component Type-APR','APRCOMPONENT',NULL,0,'50',5),
	 (773,true,'contact.stftype',true,false,false,'Contact Staff Type','CONTACTSTAFFTYPE',NULL,0,'50',5),
	 (774,false,'contact.conttype',true,false,false,'Contact Type','CONTACTTYPE',NULL,0,'50',5),
	 (775,false,'courses.courseinst',false,false,false,'Course Instructor','COURSE INSTRUCTOR',NULL,0,'50',5),
	 (776,false,'courses.coursename',false,false,false,'Course Name','COURSE NAME',NULL,0,'50',5),
	 (777,false,'courses.coursenum',false,true,false,'Course Number','COURSE NUMBER',NULL,0,'50',5),
	 (778,false,'main.custom1',false,false,false,'Custom Field 1','CUSTOM1',NULL,0,'50',5),
	 (779,false,'main.custom2',false,false,false,'Custom Field 2','CUSTOM2',NULL,0,'50',5),
	 (780,false,'yearly.custom3',false,false,false,'Custom Field 3','CUSTOM3',NULL,0,'50',5);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (781,false,'yearly.custom4',false,false,false,'Custom Field 4','CUSTOM4',NULL,0,'50',5),
	 (782,false,'maincfields.customname',true,true,false,'Custom Field Names','CUSTOMFIELDNAME',NULL,0,'50',5),
	 (783,true,NULL,true,true,true,'Custom Field Type','CUSTOMFIELDTYPE',NULL,0,'50',5),
	 (784,false,'classes.days',false,false,false,'Days','DAYS',NULL,0,'50',5),
	 (785,true,'main.docemploy',true,false,false,'Doctorate Employment Activity','DOCEMPLOY',NULL,0,'50',5),
	 (786,false,'main.eligtype',false,false,false,'Eligibility Type','ELIGIBILITY TYPE',NULL,0,'50',5),
	 (787,true,'yearlychild.servalue',true,true,false,'End Status','ENDSTATUS',NULL,4,'50',5),
	 (788,true,NULL,true,false,false,'English Instructions','ENGLISH',NULL,0,'50',5),
	 (789,false,'main.ethnictype',false,false,false,'Ethnic Type (National Origin)','ETHNIC TYPE',NULL,0,'50',5),
	 (790,true,'main.finaidrecd',true,false,false,'Financial Aid','FINAIDRECD',NULL,0,'50',5);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (791,false,'yearly.finaidname',false,false,false,'Financial Aid Name','FINANCIAL AID NAME',NULL,0,'50',5),
	 (792,true,'yearly.finaidreas',true,false,false,'Financial Aid Un-met Reason','FINAIDREAS',NULL,0,'50',5),
	 (793,false,'yearly.finaidunme',false,false,false,'Financial Aid Unmet Name','FINANCIAL AID UNMET',NULL,0,'50',5),
	 (794,true,NULL,true,false,false,'Foreign Language Instructions','FOREIGNLANGUAGE',NULL,0,'50',5),
	 (795,true,'eddata.contfreq',true,false,false,'Frequency of contacts between participants','CONTFREQ',NULL,0,'50',5),
	 (796,true,'yearly.fundsource',true,false,false,'Funding Source','FUNDSOURCE',NULL,0,'50',5),
	 (797,true,'yearly.hsgradepro',true,false,false,'Grade Progression Over Year','GRADEPRO',NULL,0,'50',5),
	 (798,true,'yearly.gradassist',true,false,false,'Graduate Assistantships','GRADASSIST',NULL,0,'50',5),
	 (799,true,'yearly.gradstudyl',true,false,false,'Graduate Current Year of Study','GRADSTUDYL',NULL,0,'50',5),
	 (800,true,'main.gdegree',true,false,false,'Graduate Degree Earned','GDEGREE',NULL,0,'50',5);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (801,false,'graduated.degreein',true,false,false,'Graduate Degree In','DEGREEIN',NULL,0,'50',5),
	 (802,false,'graduated.gdedustat',true,false,false,'Graduate Educational Status','GRADUATEEDUCATIONALSTATUS',NULL,0,'50',5),
	 (803,false,'graduated.employtype',true,false,false,'Graduate Employment Type','EMPLOYTYPE',NULL,0,'50',5),
	 (804,true,'main.gradadm',true,false,false,'Graduate School Admissions Test','GRADADM',NULL,0,'50',5),
	 (805,true,'yearly.enrollobj',true,false,false,'Graduate School Enrollment Objective','ENROLLOBJ',NULL,0,'50',5),
	 (806,true,'yearly.gpersist',true,false,false,'Graduate Student Persistence Status','GPERSIST',NULL,0,'50',5),
	 (807,true,'main.bdegreeco',true,false,false,'Graduating Cohort Year of Bachelor''s Degree','BDEGREECO',NULL,0,'50',5),
	 (808,true,'main.yearcogrd',true,false,false,'Graduation Cohort Year','YEARCOGRD',NULL,0,'50',5),
	 (809,false,'main.healthname',false,false,false,'Health Name','HEALTH NAME',NULL,0,'50',5),
	 (810,true,'yearly.vettest',true,false,false,'Improved Score on Standardized Test','VETTEST',NULL,0,'50',5);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (811,false,'main.incomelev',false,false,false,'Income Level','INCOME LEVEL',NULL,0,'50',5),
	 (812,false,'main.incomesou',false,false,false,'Income Source','INCOME SOURCE',NULL,0,'50',5),
	 (813,true,'yearly.initiative',true,false,false,'Initiative','INITIATIVE',NULL,0,'50',5),
	 (814,true,'yearly.mcintern',true,false,false,'Internship','INTERN',NULL,0,'50',5),
	 (815,false,'labservice.labserid',true,false,true,'Lab Service','LABSERVICE',NULL,0,'50',5),
	 (816,true,'yearly.partlength',true,false,false,'Length of Project Participation','PARTLENGTH',NULL,0,'50',5),
	 (817,true,'yearly.mcnmajor',true,false,false,'Major of Graduate Study','MCNMAJOR',NULL,0,'50',5),
	 (818,false,'main.marrstatus',true,false,false,'Marital Status','MARITALSTATUS',NULL,0,'50',5),
	 (819,true,NULL,true,false,false,'Mathematics Instructions/ Tutorials','MATH',NULL,0,'50',5),
	 (820,false,'classes.meettime',false,false,false,'Meeting Time','MEETING TIME',NULL,0,'50',5);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (821,false,'usermessages.msgstatus',true,false,false,'Message Priority Type','MSGSTATUS',NULL,0,'50',5),
	 (822,false,'graduated.milirank',false,false,false,'Military Rank','MILITARY RANK',NULL,0,'50',5),
	 (823,false,'graduated.militaryty',true,false,false,'Military Type','MILITARYTYPE',NULL,0,'50',5),
	 (824,true,'yearlychild.servalue',true,true,false,'Old End Status-For TS and EOC (prior to 2006-07)','OLDENDSTATUS',NULL,7,'50',5),
	 (825,false,'mainchild.ptitle',false,false,false,'Parent/ Guardian Relationship','PARENT RELATION',NULL,0,'50',5),
	 (826,true,'yearly.projretain',true,false,false,'Participant Retention in Project','PROJRETAIN',NULL,0,'50',5),
	 (827,true,'yearly.endstatus',true,false,false,'Participant Status (at end of Reporting Period)','PARTSTATUSEND',NULL,0,'50',5),
	 (828,true,'yearly.persistend',true,false,false,'Persistence Graduation Status at end of year','PERSISTEND',NULL,0,'50',5),
	 (829,true,'yearly.persiststa',true,false,false,'Persistence Status at beginning at next year','PERSISTSTA',NULL,0,'50',5),
	 (830,true,'yearly.pseterm',true,false,false,'Postsecondary Grading Period','PSETERM',NULL,0,'50',5);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (831,true,'yearly.persistden',true,false,false,'Postsecondary Persistence Objective-Denominator','PERSISTDEN',NULL,0,'50',5),
	 (832,true,'yearly.persistnum',true,false,false,'Postsecondary Persistence Objective-Numerator','PERSISTNUM',NULL,0,'50',5),
	 (833,false,'lablog.visitreason',false,false,false,'Reason for Visit','VISIT REASON',NULL,0,'50',5),
	 (834,true,'yearly.greason',true,false,false,'Reason left Graduate School','GREASON',NULL,0,'50',5),
	 (835,true,'yearly.noenreason',true,false,false,'Reason Not Enrolled','NOENREASON',NULL,0,'50',5),
	 (836,true,'main.vetscherea',true,false,false,'Reason of Recheduling','VETSCHEREA',NULL,0,'50',5),
	 (837,true,'yearly.recupdated',true,false,false,'Record Updated','RECUPDATED',NULL,0,'50',5),
	 (838,true,'yearly.recruit',true,false,false,'Recruitment','RECRUIT',NULL,0,'50',5),
	 (839,false,'main.referedby',false,false,false,'Referred By','REFERRED BY',NULL,0,'50',5),
	 (840,true,'yearly.mcresearch
',true,false,false,'Research Activities','RESEARCH',NULL,0,'50',5);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (841,true,'main.vetrevsche',true,false,false,'Revised Scheduled Completion Year','VETREVSCHE',NULL,0,'50',5),
	 (842,false,'classes.room',false,false,false,'Room','ROOM',NULL,0,'50',5),
	 (843,true,'main.vetsche',true,false,false,'Scheduled Completion Year','VETSCHE',NULL,0,'50',5),
	 (844,true,'yearly.mcscholar',true,false,false,'Scholarly Activity','SCHOLAR',NULL,0,'50',5),
	 (845,true,NULL,true,false,false,'Science Instruction/Tutorials','SCIENCE',NULL,0,'50',5),
	 (846,false,'staff.stfcodes',false,false,false,'Staff Codes','STAFF CODES',NULL,0,'50',5),
	 (847,true,NULL,true,false,false,'Standing Group Type (APR Column)','STANDINGGROUPTYPE',NULL,0,'50',5),
	 (848,true,'main.statetest',true,false,false,'State-Developed Test to Measure Academic Skills','STATETEST',NULL,0,'50',5),
	 (849,true,'main.mcstem',true,false,false,'STEM Major','MCSTEM',NULL,0,'50',5),
	 (850,true,'yearly.sumbridge',true,false,false,'Summer Bridge','SUMBRIDGE',NULL,0,'50',5);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (851,false,NULL,false,false,true,'Teacher','TEACHER',NULL,0,'50',5),
	 (852,true,'yearly.trackcomp',true,false,false,'Tracking Completed','TRACKCOMP',NULL,0,'50',5),
	 (853,true,'main.track',true,false,false,'Tracking Graduate','TRACK',NULL,0,'50',5),
	 (854,true,'yearly.transfers',true,false,false,'Transfers','TRANSFERS',NULL,0,'50',5),
	 (855,false,'yearly.tutor',false,false,true,'Tutor','TUTOR',NULL,0,'50',5),
	 (856,true,'yearly.testtype',true,false,false,'Type of Standarized Tests','TESTTYPE',NULL,0,'50',5),
	 (857,true,'eddata.summerresi',true,false,false,'UB,UBMS,VUB Summer residential Program Type','SUMMERRESI',NULL,0,'50',5),
	 (858,true,'eddata.regional',true,false,false,'UBMS Project type','REGIONAL',NULL,0,'50',5),
	 (859,true,'yearly.vcalllen',true,false,false,'Veteran Call to Active Duty Length','VCALLLEN',NULL,0,'50',5),
	 (860,true,'yearly.vcall',true,false,false,'Veteran Called to Active Duty Status','VCALL',NULL,0,'50',5);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (861,true,'yearly.vgradelev',true,false,false,'Veteran Educational Status (at end)','VGRADELEVEL',NULL,0,'50',5),
	 (862,true,'main.venterlev',true,false,false,'Veteran Educational Status (Entry into Project)','VENTERLEVEL',NULL,0,'50',5),
	 (863,true,'main.venterjob',true,false,false,'Veteran Employment Status','VENTERJOB',NULL,0,'50',5),
	 (864,true,'main.vfinaidrec',true,false,false,'Veteran Financial Aid','VFINAIDREC',NULL,0,'50',5),
	 (865,false,'formslog.formname',false,false,false,'Wallet Name','Wallet Name',NULL,0,'50',5),
	 (866,true,NULL,true,false,false,'Yearly Child Service Heading','SERHEADING',NULL,0,'50',5),
	 (867,true,NULL,true,false,false,'Yearly Child Service Type','SERTYPE',NULL,0,'50',5),
	 (868,true,NULL,true,false,false,'Yes-No Options','YESNO',NULL,0,'50',5),
	 (869,false,'contactchild.activityid
yearlychild.servalue',true,true,true,'Activity','ACTIVITY','Activity~Activity',1,'50~50',5),
	 (870,true,'yearlychild.servalue
contact.aprsubject',true,true,false,'APR Subject Types','APR SUBJECT','APR Subject Types~APR Subject Types',6,'50~50',5);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (871,false,'botform_submission.FORM_NAME
BOTFORM_MAINTENANCE.FORM_NAME',false,false,false,'BOT Form Name','BOT FORM NAME','BOT Form Name~BOT Form Name',0,'50~50',5),
	 (872,true,'main.highdegree
yearly.degree',true,false,false,'Degree/Certificate Completed','HIGHDEGREE','Degree/Certificate Completed~Degree/Certificate Undergraduate Completed',0,'50~50',5),
	 (873,true,'yearly.enroll
main.enterenrol',true,false,false,'Enrollment Status','ENROLL','Enrollment Status (at the end of the academic year)~Enrollment Status (in academic year first served)',0,'50~50',5),
	 (874,false,'exam.examname
examchild.examname',false,false,false,'Exam Name','EXAM NAME','Exam Name~Exam Name ',0,'50~50',5),
	 (875,false,'yearly.standing
semester.standing',true,false,true,'Grade / Standing Type','STANDING','Standing~Standing',0,'50~50',5),
	 (876,false,'yearly.major
graduated.major',false,false,false,'Major','MAJOR','Major~Major',0,'50~50',5),
	 (877,false,'main.sitelocate
appusers.sitelocate',false,false,false,'Site Location','SITE LOCATION','Site Location~Site Location',0,'50~50',5),
	 (878,false,'yearly.counsel
yearly.tutor',false,true,true,'Staff','STAFF','Staff~Tutor',0,'50~50',5),
	 (879,true,'main.staterlagr
main.statemathg',true,false,false,'State Grade level in which student was Assessed','STATE10GRADE','Grade level when Assessed for State 10th Reading Standard~Grade level when Assessed for State 10th Math Standard',0,'50~50',5),
	 (880,true,'main.state8rla
main.state8math',true,false,false,'State Met 8th Grade Achievement Standard Options','STATE8MET','Met 8th Grade State Reading Language Art Standard~Met 8th Grade State Math Standard',0,'50~50',5);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (881,false,'contact.stfid
classes.stfid',true,true,true,'STFID - DO NOT USE','STFID','Stfid~Stfid',0,'50~50',5),
	 (882,false,'classes.subject
contact.subject',false,false,false,'Subject ( Classes/ Contacts)','SUBJECT','Subject~Subject',0,'50~50',5),
	 (883,false,'formslog.formtype
yearlychild.servalue',true,true,false,'Wallet Type','Wallet Type','Wallet Type Formslog ~Wallet Type Yearly Child',5,'50~50',5),
	 (884,false,'classes.semester
courses.semester
semester.semester',true,true,false,'Semester Type','SEMESTER','Semester~Semester~Semester',0,'50~50~50',5),
	 (885,false,'yearly.counsel
graduated.counsel',false,false,true,'Counselor','COUNSELOR','Counselor~Counselor',0,'50~50~50~50',5),
	 (886,true,'main.gpascale
main.msgpascale
yearly.gpaendsc
yearly.gpastartsc',true,false,false,'GPA Scale','GPASCALE','GPA HS Scale (Entry into Project)~GPA MS Scale(Entry into Project)~GPA Scale (at end of Reporting Period)~GPA Scale (at start of Reporting Period)',0,'50~50~50~50',5),
	 (887,false,'staff.stfcustom1
staff.stfcustom2
staff.stfcustom3
staff.stfcustom4',false,false,false,'Staff Custom Field','STAFF CUSTOM','Staff Custom 1~Staff Custom 2~ Staff Custom 3~Staff Custom 4',0,'50~50~50~50',5),
	 (888,true,'main.city
mainchild.pcity
eddata.city
graduated.city
school.city
staff.stfcity',false,false,false,'City','CITY','City~City~City~City~City~City',0,'50~50~50~50~50~50',5),
	 (889,false,'main.state
eddata.state
graduated.state
main.dlstate
mainchild.pstate
school.state
staff.stfstate
staffchild.stfstate',false,false,false,'State (Postal Address)','STATE','State (Postal Address)~State~State~State (Driving License)~State~State~State~State',0,'50~50~50~50~50~50~50~50',5),
	 (890,false,'main.phn1ty
main.phn2ty
mainchild.pphn1ty
mainchild.pphn2ty
mainchild.pphn3ty
staff.stfphn1ty
staff.stfphn2ty
staff.stfphn3ty
staffchild.stfphn1ty
staffchild.stfphn2ty
staffchild.stfphn3ty',false,false,false,'Phone Type','PHONE TYPE','Phone Type 1~Phone Type 2~Phone Type 1~Phone Type 2~Phone Type 3~Phone Type 1~Phone Type 2~Phone Type 3~Phone Type 1~Phone Type 2~Phone Type 3',0,'50~50~50~50~50~50~50~50~50~50',5);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (891,true,'main.gender',true,false,false,'APR 08 - Gender','GENDER',NULL,0,'10',6),
	 (892,true,'main.ethnic',true,false,false,'APR 09 - 14 - Ethnicity /Race','ETHNIC',NULL,0,'10',6),
	 (893,true,'main.eligibilit',true,false,false,'APR 15 - Eligibility','ELIGIBILITY',NULL,0,'10',6),
	 (894,true,'main.acadneed',true,false,false,'APR 16 - Academic Need','ACADNEED',NULL,0,'10',6),
	 (895,true,'main.enterlevel',true,false,false,'APR 19 - Entry Grade Level','ENTERLEVEL',NULL,0,'10',6),
	 (896,true,'main.cohortyear',true,false,false,'APR 21 - Cohort Year','COHORTYEAR',NULL,0,'10',6),
	 (897,true,'yearly.partstatus',true,false,false,'APR 22 - Participant Status','PARTSTATUS',NULL,0,'10',6),
	 (898,true,'yearly.acadstand',true,false,false,'APR 24 - Academic Standing','ACADSTAND',NULL,0,'10',6),
	 (899,true,'yearly.gradestart',true,false,false,'APR 26 - College Grade Level at Start','GRADESTART',NULL,0,'10',6),
	 (900,true,'yearly.collgradel',true,false,false,'APR 27 - College Grade Level at End','COLLGRADE',NULL,0,'10',6);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (901,true,'yearly.reasonleav',true,false,false,'APR 29 - Reasons for Withdrawal','REASON',NULL,0,'10',6),
	 (902,true,'yearly.transfers',true,false,false,'APR 30 - Transfer Status','TRANSFERS',NULL,0,'10',6),
	 (903,true,'yearly.mcnmajor',true,false,false,'APR 33 - Field of Study Degree','MCNMAJOR',NULL,0,'10',6),
	 (904,true,'yearly.persiststa',true,false,false,'APR 34 - Persistence Status (Beginning of Next Year)','PERSISTSTA',NULL,0,'10',6),
	 (905,true,'yearly.deceased',true,false,false,'Deceased or Incapacitated','DECEASED',NULL,0,'10',6),
	 (906,true,'yearly.enroll
main.enterenrol',true,false,false,'APR 20/23 - Enrollment Status','ENROLL','APR 23 - Enrollment Status at end of year~APR 20 - Enrollment Status (year first served)',0,'10~10',6),
	 (907,true,'yearly.degree
main.highdegree',true,false,false,'APR 31 - Degree Completed at Institution','HIGHDEGREE','APR 31 - Undergraduate Degree/Certificate Completed~Degree/Certificate Completed',0,'10~50',6),
	 (908,true,'activity.actgid',true,false,true,'Activity Group','ACTIVITYGROUP',NULL,2,'50',6),
	 (909,true,NULL,true,false,false,'Activity Group Type','ACTIVITYGROUPTYPE',NULL,0,'50',6),
	 (910,true,'yearly.advancemat',true,false,false,'Advanced Math Course','ADVANCEMAT',NULL,0,'50',6);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (911,true,'yearly.apcourse',true,false,false,'Advanced Placement Course','APCOURSE',NULL,0,'50',6),
	 (912,false,'yearly.advisor',false,false,false,'Advisor','ADVISOR',NULL,0,'50',6),
	 (913,false,'asset.amake',false,false,false,'Asset Make','ASSET MAKE',NULL,0,'50',6),
	 (914,false,'asset.amodel',false,false,false,'Asset Model','ASSET MODEL',NULL,0,'50',6),
	 (915,false,'asset.astatus',true,false,false,'Asset Status','ASSETSTATUS',NULL,0,'50',6),
	 (916,false,'asset.atype',false,false,false,'Asset Type','ASSET TYPE',NULL,0,'50',6),
	 (917,true,'yearly.adegree',true,false,false,'Associate Degree','ADEGREE',NULL,0,'50',6),
	 (918,true,'main.atralgebra',true,false,false,'At Risk Algebra','ATRALGEBRA',NULL,0,'50',6),
	 (919,true,'main.atrlowgpa',true,false,false,'At Risk Low GPA','ATRLOWGPA',NULL,0,'50',6),
	 (920,true,'main.atrschool',true,false,false,'At Risk Out of School','ATRSCHOOL',NULL,0,'50',6);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (921,true,'main.atrstdtest',true,false,false,'At Risk Standard Test','ATRSTDTEST',NULL,0,'50',6),
	 (922,true,'main.commcoll',true,false,false,'Attended Community College','COMMCOLL',NULL,0,'50',6),
	 (923,false,'main.birthplace',false,false,false,'Birth Place','BIRTH PLACE',NULL,0,'50',6),
	 (924,false,'botform_submission.SUBMISSION_STATUS',true,false,false,'BOT Form Status','BOTFORMSTATUS',NULL,0,'50',6),
	 (925,true,'yearly.certi',true,false,false,'Certificate/ Diploma Completed','CERTI',NULL,0,'50',6),
	 (926,true,'main.vetschecir',true,false,false,'Circumstances of Recheduling','VETSCHECIR',NULL,0,'50',6),
	 (927,false,'main.codes',false,false,false,'Codes','CODES',NULL,0,'50',6),
	 (928,true,'main.enterexam',true,false,false,'College Entrance Exam','ENTEREXAM',NULL,0,'50',6),
	 (929,true,'yearly.collready',true,false,false,'College Ready','COLLREADY',NULL,0,'50',6),
	 (930,true,'yearly.collegety',true,false,false,'College Type','COLLEGETYPE',NULL,0,'50',6);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (931,true,NULL,true,false,false,'Compare Symbols','COMPARE',NULL,0,'50',6),
	 (932,true,'yearly.completeyr',true,false,false,'Completion Year','COMPLETEYR',NULL,0,'50',6),
	 (933,true,NULL,true,false,false,'Component Type','COMPONENT',NULL,0,'50',6),
	 (934,true,NULL,true,false,false,'Component Type-APR','APRCOMPONENT',NULL,0,'50',6),
	 (935,true,'contact.stftype',true,false,false,'Contact Staff Type','CONTACTSTAFFTYPE',NULL,0,'50',6),
	 (936,false,'contact.conttype',true,false,false,'Contact Type','CONTACTTYPE',NULL,0,'50',6),
	 (937,false,'courses.courseinst',false,false,false,'Course Instructor','COURSE INSTRUCTOR',NULL,0,'50',6),
	 (938,false,'courses.coursename',false,false,false,'Course Name','COURSE NAME',NULL,0,'50',6),
	 (939,false,'courses.coursenum',false,true,false,'Course Number','COURSE NUMBER',NULL,0,'50',6),
	 (940,false,'main.custom1',false,false,false,'Custom Field 1','CUSTOM1',NULL,0,'50',6);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (941,false,'main.custom2',false,false,false,'Custom Field 2','CUSTOM2',NULL,0,'50',6),
	 (942,false,'yearly.custom3',false,false,false,'Custom Field 3','CUSTOM3',NULL,0,'50',6),
	 (943,false,'yearly.custom4',false,false,false,'Custom Field 4','CUSTOM4',NULL,0,'50',6),
	 (944,false,'maincfields.customname',true,true,false,'Custom Field Names','CUSTOMFIELDNAME',NULL,0,'50',6),
	 (945,true,NULL,true,true,true,'Custom Field Type','CUSTOMFIELDTYPE',NULL,0,'50',6),
	 (946,false,'classes.days',false,false,false,'Days','DAYS',NULL,0,'50',6),
	 (947,true,'main.disconnect',true,false,false,'Disconnected Youth','DISCONNECT',NULL,0,'50',6),
	 (948,true,'main.docemploy',true,false,false,'Doctorate Employment Activity','DOCEMPLOY',NULL,0,'50',6),
	 (949,true,'yearly.dualenroll',true,false,false,'Dual Enrollment','DUALENROLL',NULL,0,'50',6),
	 (950,true,'yearly.decredenti',true,false,false,'Dual Enrollment Credentials','DECREDENTI',NULL,0,'50',6);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (951,false,'main.eligtype',false,false,false,'Eligibility Type','ELIGIBILITY TYPE',NULL,0,'50',6),
	 (952,true,'yearly.employ',true,false,false,'Employment','EMPLOY',NULL,0,'50',6),
	 (953,true,'yearlychild.servalue',true,true,false,'End Status','ENDSTATUS',NULL,4,'50',6),
	 (954,true,NULL,true,false,false,'English Instructions','ENGLISH',NULL,0,'50',6),
	 (955,false,'main.ethnictype',false,false,false,'Ethnic Type (National Origin)','ETHNIC TYPE',NULL,0,'50',6),
	 (956,true,'yearly.fafsa',true,false,false,'FAFSA completion','FAFSA',NULL,0,'50',6),
	 (957,true,'main.finaidrecd',true,false,false,'Financial Aid','FINAIDRECD',NULL,0,'50',6),
	 (958,false,'yearly.finaidname',false,false,false,'Financial Aid Name Description','FINANCIAL AID NAME',NULL,0,'50',6),
	 (959,true,'yearly.finaidreas',true,false,false,'Financial Aid Un-met Reason','FINAIDREAS',NULL,0,'50',6),
	 (960,false,'yearly.finaidunme',false,false,false,'Financial Aid Unmet Name','FINANCIAL AID UNMET',NULL,0,'50',6);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (961,true,NULL,true,false,false,'Foreign Language Instructions','FOREIGNLANGUAGE',NULL,0,'50',6),
	 (962,true,'eddata.contfreq',true,false,false,'Frequency of contacts between participants','CONTFREQ',NULL,0,'50',6),
	 (963,true,'yearly.fundsource',true,false,false,'Funding Source','FUNDSOURCE',NULL,0,'50',6),
	 (964,true,'yearly.gradelevel',true,false,false,'Grade Level (at end of reporting period)','GRADELEVEL',NULL,0,'50',6),
	 (965,true,'yearly.hsgradepro',true,false,false,'Grade Progression Over Year','GRADEPRO',NULL,0,'50',6),
	 (966,true,'yearly.gradassist',true,false,false,'Graduate Assistantships','GRADASSIST',NULL,0,'50',6),
	 (967,true,'yearly.gradstudyl',true,false,false,'Graduate Current Year of Study','GRADSTUDYL',NULL,0,'50',6),
	 (968,true,'main.gdegree',true,false,false,'Graduate Degree Earned','GDEGREE',NULL,0,'50',6),
	 (969,false,'graduated.degreein',true,false,false,'Graduate Degree In','DEGREEIN',NULL,0,'50',6),
	 (970,false,'graduated.gdedustat',true,false,false,'Graduate Educational Status','GRADUATEEDUCATIONALSTATUS',NULL,0,'50',6);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (971,false,'graduated.employtype',true,false,false,'Graduate Employment Type','EMPLOYTYPE',NULL,0,'50',6),
	 (972,true,'main.gradadm',true,false,false,'Graduate School Admissions Test','GRADADM',NULL,0,'50',6),
	 (973,true,'yearly.enrollobj',true,false,false,'Graduate School Enrollment Objective','ENROLLOBJ',NULL,0,'50',6),
	 (974,true,'yearly.gpersist',true,false,false,'Graduate Student Persistence Status','GPERSIST',NULL,0,'50',6),
	 (975,true,'main.bdegreeco',true,false,false,'Graduating Cohort Year of Bachelor''s Degree','BDEGREECO',NULL,0,'50',6),
	 (976,true,'main.yearcogrd',true,false,false,'Graduation Cohort Year','YEARCOGRD',NULL,0,'50',6),
	 (977,false,'main.healthname',false,false,false,'Health Name','HEALTH NAME',NULL,0,'50',6),
	 (978,true,'yearly.hsgradstat',true,false,false,'High School Graduation Status','GRADSTATUS',NULL,0,'50',6),
	 (979,true,'yearly.vettest',true,false,false,'Improved Score on Standardized Test','VETTEST',NULL,0,'50',6),
	 (980,false,'main.incomelev',false,false,false,'Income Level','INCOME LEVEL',NULL,0,'50',6);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (981,false,'main.incomesou',false,false,false,'Income Source','INCOME SOURCE',NULL,0,'50',6),
	 (982,true,'yearly.initiative',true,false,false,'Initiative','INITIATIVE',NULL,0,'50',6),
	 (983,true,'yearly.mcintern',true,false,false,'Internship','INTERN',NULL,0,'50',6),
	 (984,false,'labservice.labserid',true,false,true,'Lab Service','LABSERVICE',NULL,0,'50',6),
	 (985,true,'yearly.partlength',true,false,false,'Length of Project Participation','PARTLENGTH',NULL,0,'50',6),
	 (986,false,'main.marrstatus',true,false,false,'Marital Status','MARITALSTATUS',NULL,0,'50',6),
	 (987,true,NULL,true,false,false,'Mathematics Instructions/ Tutorials','MATH',NULL,0,'50',6),
	 (988,false,'classes.meettime',false,false,false,'Meeting Time','MEETING TIME',NULL,0,'50',6),
	 (989,false,'usermessages.msgstatus',true,false,false,'Message Priority Type','MSGSTATUS',NULL,0,'50',6),
	 (990,false,'graduated.milirank',false,false,false,'Military Rank','MILITARY RANK',NULL,0,'50',6);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (991,false,'graduated.militaryty',true,false,false,'Military Type','MILITARYTYPE',NULL,0,'50',6),
	 (992,true,'yearlychild.servalue',true,true,false,'Old End Status-For TS and EOC (prior to 2006-07)','OLDENDSTATUS',NULL,7,'50',6),
	 (993,false,'mainchild.ptitle',false,false,false,'Parent/ Guardian Relationship','PARENT RELATION',NULL,0,'50',6),
	 (994,true,'yearly.projretain',true,false,false,'Participant Retention in Project','PROJRETAIN',NULL,0,'50',6),
	 (995,true,'yearly.endstatus',true,false,false,'Participant Status (at end of Reporting Period)','PARTSTATUSEND',NULL,0,'50',6),
	 (996,true,'yearly.partlevel',true,false,false,'Participation Level','PARTLEVEL',NULL,0,'50',6),
	 (997,true,'yearly.persistend',true,false,false,'Persistence Graduation Status at end of year','PERSISTEND',NULL,0,'50',6),
	 (998,true,'yearly.pscomplete',true,false,false,'Postsecondary Completion Objective','PSCOMPLETE',NULL,0,'50',6),
	 (999,true,'yearly.psenroll',true,false,false,'Postsecondary Enrollment Objective','PSENROLL',NULL,0,'50',6),
	 (1000,true,'yearly.pseterm',true,false,false,'Postsecondary Grading Period','PSETERM',NULL,0,'50',6);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1001,true,'yearly.persistden',true,false,false,'Postsecondary Persistence Objective-Denominator','PERSISTDEN',NULL,0,'50',6),
	 (1002,true,'yearly.persistnum',true,false,false,'Postsecondary Persistence Objective-Numerator','PERSISTNUM',NULL,0,'50',6),
	 (1003,true,'yearly.psremediat',true,false,false,'Postsecondary Remediation','PSREMEDIAT',NULL,0,'50',6),
	 (1004,true,'yearly.stemdegree',true,false,false,'Postsecondary STEM Degree','STEMDEGREE',NULL,0,'50',6),
	 (1005,false,'lablog.visitreason',false,false,false,'Reason for Visit','VISIT REASON',NULL,0,'50',6),
	 (1006,true,'yearly.greason',true,false,false,'Reason left Graduate School','GREASON',NULL,0,'50',6),
	 (1007,true,'yearly.noenreason',true,false,false,'Reason Not Enrolled','NOENREASON',NULL,0,'50',6),
	 (1008,true,'main.vetscherea',true,false,false,'Reason of Recheduling','VETSCHEREA',NULL,0,'50',6),
	 (1009,true,'yearly.recupdated',true,false,false,'Record Updated','RECUPDATED',NULL,0,'50',6),
	 (1010,true,'yearly.recruit',true,false,false,'Recruitment','RECRUIT',NULL,0,'50',6);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1011,false,'main.referedby',false,false,false,'Referred By','REFERRED BY',NULL,0,'50',6),
	 (1012,true,'yearly.mcresearch
',true,false,false,'Research Activities','RESEARCH',NULL,0,'50',6),
	 (1013,true,'main.vetrevsche',true,false,false,'Revised Scheduled Completion Year','VETREVSCHE',NULL,0,'50',6),
	 (1014,true,'yearly.rigorous',true,false,false,'Rigorous Enrollment','RIGOROUS',NULL,0,'50',6),
	 (1015,false,'classes.room',false,false,false,'Room','ROOM',NULL,0,'50',6),
	 (1016,true,'main.vetsche',true,false,false,'Scheduled Completion Year','VETSCHE',NULL,0,'50',6),
	 (1017,true,'yearly.mcscholar',true,false,false,'Scholarly Activity','SCHOLAR',NULL,0,'50',6),
	 (1018,true,NULL,true,false,false,'Science Instruction/Tutorials','SCIENCE',NULL,0,'50',6),
	 (1019,true,'yearly.schpersist',true,false,false,'Secondary School Retention','SCHPERSIST',NULL,0,'50',6),
	 (1020,true,'yearly.selftran',true,false,false,'Source of Postsecondary Education Information','SELFTRAN',NULL,0,'50',6);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1021,false,'staff.stfcodes',false,false,false,'Staff Codes','STAFF CODES',NULL,0,'50',6),
	 (1022,true,NULL,true,false,false,'Standing Group Type (APR Column)','STANDINGGROUPTYPE',NULL,0,'50',6),
	 (1023,true,'main.statetest',true,false,false,'State-Developed Test to Measure Academic Skills','STATETEST',NULL,0,'50',6),
	 (1024,true,'main.mcstem',true,false,false,'STEM Major','MCSTEM',NULL,0,'50',6),
	 (1025,true,'yearly.sumbridge',true,false,false,'Summer Bridge','SUMBRIDGE',NULL,0,'50',6),
	 (1026,false,NULL,false,false,true,'Teacher','TEACHER',NULL,0,'50',6),
	 (1027,true,'yearly.trackcomp',true,false,false,'Tracking Completed','TRACKCOMP',NULL,0,'50',6),
	 (1028,true,'main.track',true,false,false,'Tracking Graduate','TRACK',NULL,0,'50',6),
	 (1029,true,'yearly.othertrio',true,false,false,'Trio Programs','OTHERTRIO',NULL,0,'50',6),
	 (1030,false,'yearly.tutor',false,false,true,'Tutor','TUTOR',NULL,0,'50',6);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1031,true,'yearly.testtype',true,false,false,'Type of Standarized Tests','TESTTYPE',NULL,0,'50',6),
	 (1032,true,'eddata.summerresi',true,false,false,'UB,UBMS,VUB Summer residential Program Type','SUMMERRESI',NULL,0,'50',6),
	 (1033,true,'eddata.regional',true,false,false,'UBMS Project type','REGIONAL',NULL,0,'50',6),
	 (1034,true,'yearly.vcalllen',true,false,false,'Veteran Call to Active Duty Length','VCALLLEN',NULL,0,'50',6),
	 (1035,true,'yearly.vcall',true,false,false,'Veteran Called to Active Duty Status','VCALL',NULL,0,'50',6),
	 (1036,true,'yearly.vgradelev',true,false,false,'Veteran Educational Status (at end)','VGRADELEVEL',NULL,0,'50',6),
	 (1037,true,'main.venterlev',true,false,false,'Veteran Educational Status (Entry into Project)','VENTERLEVEL',NULL,0,'50',6),
	 (1038,true,'main.venterjob',true,false,false,'Veteran Employment Status','VENTERJOB',NULL,0,'50',6),
	 (1039,true,'main.vfinaidrec',true,false,false,'Veteran Financial Aid','VFINAIDREC',NULL,0,'50',6),
	 (1040,false,'formslog.formname',false,false,false,'Wallet Name','Wallet Name',NULL,0,'50',6);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1041,true,NULL,true,false,false,'Yearly Child Service Heading','SERHEADING',NULL,0,'50',6),
	 (1042,true,NULL,true,false,false,'Yearly Child Service Type','SERTYPE',NULL,0,'50',6),
	 (1043,true,NULL,true,false,false,'Yes-No Options','YESNO',NULL,0,'50',6),
	 (1044,false,'contactchild.activityid
yearlychild.servalue',true,true,true,'Activity','ACTIVITY','Activity~Activity',1,'50~50',6),
	 (1045,true,'yearlychild.servalue
contact.aprsubject',true,true,false,'APR Subject Types','APR SUBJECT','APR Subject Types~APR Subject Types',6,'50~50',6),
	 (1046,true,'main.bdegree
yearly.bdegree',true,false,false,'Bachelor''s Degree','BDEGREE','Bachelor''s Degree~Bachelor''s Degree Attained',0,'50~50',6),
	 (1047,false,'botform_submission.FORM_NAME
 BOTFORM_MAINTENANCE.FORM_NAME',false,false,false,'BOT Form Name','BOT FORM NAME','BOT Form Name~BOT Form Name',0,'50~50',6),
	 (1048,false,'exam.examname
examchild.examname',false,false,false,'Exam Name','EXAM NAME','Exam Name~Exam Name',0,'50~50',6),
	 (1049,false,'yearly.standing
semester.standing',true,false,true,'Grade / Standing Type','STANDING','Standing~Standing',0,'50~50',6),
	 (1050,true,'main.lepentry
main.leplastser',true,false,false,'Limited English Proficiency Status','LIMITEDENGPRO','Limited English Proficiency (Date of First Participation)~Limited English Proficiency (Date of Last Service)',0,'50~50',6);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1051,false,'yearly.major
graduated.major',false,false,false,'Major','MAJOR','Major~Major',0,'50~50',6),
	 (1052,false,'main.sitelocate
appusers.sitelocate',false,false,false,'Site Location','SITE LOCATION','Site Location~Site Location',0,'50~50',6),
	 (1053,false,'yearly.counsel
yearly.tutor',false,true,true,'Staff','STAFF','Staff~Tutor',0,'50~50',6),
	 (1054,true,'main.staterlagr
main.statemathg',true,false,false,'State Grade level in which student was Assessed','STATE10GRADE','Grade level when Assessed for State 10th Reading Standard~Grade level when Assessed for State 10th Math Standard',0,'50~50',6),
	 (1055,true,'main.state8rla
main.state8math',true,false,false,'State Met 8th Grade Achievement Standard Options','STATE8MET','Met 8th Grade State Reading Language Art Standard~Met 8th Grade State Math Standard',0,'50~50',6),
	 (1056,false,'contact.stfid
classes.stfid',true,true,true,'STFID - DO NOT USE','STFID','Stfid~Stfid',0,'50~50',6),
	 (1057,false,'classes.subject
contact.subject',false,false,false,'Subject ( Classes/ Contacts)','SUBJECT','Subject~Subject',0,'50~50',6),
	 (1058,false,'formslog.formtype
yearlychild.servalue',true,true,false,'Wallet Type','Wallet Type','Wallet Type Formslog ~Wallet Type Yearly Child',5,'50~50',6),
	 (1059,false,'main.schoolent
yearly.school
main.schoolend',false,false,true,'School Name/Code','SCHOOL','School (Entry into Project)~School Year(Current Fiscal Year)~School (End Of Project)',0,'50~50~50',6),
	 (1060,false,'classes.semester
courses.semester
semester.semester',true,true,false,'Semester Type','SEMESTER','Semester~Semester~Semester',0,'50~50~50',6);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1061,false,'yearly.college
main.collegeent
main.gradcoll
main.gdoccoll',false,false,true,'College','COLLEGE','College~College - Entry~Graduate School First Attended~Doctorate College',0,'50~50~50~50',6),
	 (1062,false,'yearly.counsel
graduated.counsel',false,false,true,'Counselor','COUNSELOR','Counselor~Counselor',0,'50~50~50~50',6),
	 (1063,true,'main.gpascale
main.msgpascale
yearly.gpaendsc
yearly.gpastartsc',true,false,false,'GPA Scale','GPASCALE','GPA HS Scale (Entry into Project)~GPA MS Scale(Entry into Project)~GPA Scale (at end of Reporting Period)~GPA Scale (at start of Reporting Period)',0,'50~50~50~50',6),
	 (1064,false,'staff.stfcustom1
staff.stfcustom2
staff.stfcustom3
staff.stfcustom4',false,false,false,'Staff Custom Field','STAFF CUSTOM','Staff Custom 1~Staff Custom 2~ Staff Custom 3~Staff Custom 4',0,'50~50~50~50',6),
	 (1065,true,'main.state10rla
main.state10mat
yearly.state10rla
yearly.state10mat',true,false,false,'State Met 10th Grade Achievement Standard Options','STATE10MET','Met 10th Grade State Reading Language Art Standard~Met 10th Grade State Math Standard~Met HS State Acad. Achievement Standard at Proficient Level—Reading/language arts~Met HS State Acad. Achievement Standard at Proficient Level—Math',0,'50~50~50~50',6),
	 (1066,true,'main.city
mainchild.pcity
eddata.city
graduated.city
school.city
staff.stfcity',false,false,false,'City Pull description','CITY','City~City~City~City~City~City',0,'50~50~50~50~50~50',6),
	 (1067,false,'main.state
eddata.state
graduated.state
main.dlstate
mainchild.pstate
school.state
staff.stfstate
staffchild.stfstate',false,false,false,'State (Postal Address)','STATE','State (Postal Address)~State~State~State (Driving License)~State~State~State~State',0,'50~50~50~50~50~50~50~50',6),
	 (1068,false,'main.phn1ty
main.phn2ty
mainchild.pphn1ty
mainchild.pphn2ty
mainchild.pphn3ty
staff.stfphn1ty
staff.stfphn2ty
staff.stfphn3ty
staffchild.stfphn1ty
staffchild.stfphn2ty
staffchild.stfphn3ty',false,false,false,'Phone Type','PHONE TYPE','Phone Type 1~Phone Type 2~Phone Type 1~Phone Type 2~Phone Type 3~Phone Type 1~Phone Type 2~Phone Type 3~Phone Type 1~Phone Type 2~Phone Type 3',0,'50~50~50~50~50~50~50~50~50~50',6),
	 (1069,true,'main.gender',true,false,false,'APR 08 - Gender','GENDER',NULL,0,'10',7),
	 (1070,true,'main.ethnic',true,false,false,'APR 09 - 14 - Ethnicity /Race','ETHNIC',NULL,0,'10',7);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1071,true,'main.eligi1',true,false,false,'APR 15 - Eligibility-Low Income','ELIGI1',NULL,0,'10',7),
	 (1072,true,'main.eligi2',true,false,false,'APR 16 - Eligibility-First Generation','ELIGI2',NULL,0,'10',7),
	 (1073,true,'main.eligi3',true,false,false,'APR 17 - Eligibility-Underrepresented','ELIGI3',NULL,0,'10',7),
	 (1074,true,'main.commcoll',true,false,false,'APR 19 - Attended Community College','COMMCOLL',NULL,0,'10',7),
	 (1075,true,'main.enterlevel',true,false,false,'APR 21 - Entry Grade Level','ENTERLEVEL',NULL,0,'10',7),
	 (1076,true,'yearly.partstatus',true,false,false,'APR 22 - Participant Status','PARTSTATUS',NULL,0,'10',7),
	 (1077,true,'yearly.partlevel',true,false,false,'APR 24 - Participation Level','PARTLEVEL',NULL,0,'10',7),
	 (1078,true,'yearly.fundsource',true,false,false,'APR 25 - Funding Source','FUNDSOURCE',NULL,0,'10',7),
	 (1079,true,'main.mcstem',true,false,false,'APR 26 -STEM Major','MCSTEM',NULL,0,'10',7),
	 (1080,true,'main.bdegreeco',true,false,false,'APR 29 - Bachelor''s Degree Cohort Year','BDEGREECO',NULL,0,'10',7);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1081,true,'yearly.mcresearch',true,false,false,'APR 32 - Research','RESEARCH',NULL,0,'10',7),
	 (1082,true,'yearly.mcscholar',true,false,false,'APR 33 - Scholarly Activity','SCHOLAR',NULL,0,'10',7),
	 (1083,true,'yearly.mcintern',true,false,false,'APR 34 - Internship','INTERN',NULL,0,'10',7),
	 (1084,true,'main.gradadm',true,false,false,'APR 35 - Graduate School Admissions Test','GRADADM',NULL,0,'10',7),
	 (1085,true,'yearly.enrollobj',true,false,false,'APR 38 - Graduate Enrollment Status','ENROLLOBJ',NULL,0,'10',7),
	 (1086,true,'yearly.gpersist',true,false,false,'APR 39 - Graduation Persistence Status','GPERSIST',NULL,0,'10',7),
	 (1087,true,'yearly.gradstudyl',true,false,false,'APR 40 - Current year of Graduate Study','GRADSTUDYL',NULL,0,'10',7),
	 (1088,true,'yearly.gradassist',true,false,false,'APR 42 - Graduate Assistantships','GRADASSIST',NULL,0,'10',7),
	 (1089,true,'yearly.greason',true,false,false,'APR 43 - Reason left Graduate School','GREASON',NULL,0,'10',7),
	 (1090,true,'main.gdegree',true,false,false,'APR 44 - Highest Graduate Degree Earned','GDEGREE',NULL,0,'10',7);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1091,true,'main.docemploy',true,false,false,'APR 47 - Doctorate Employment Activity','DOCEMPLOY',NULL,0,'10',7),
	 (1092,false,'main.gradcoll
main.gdoccoll
yearly.college
main.collegeent',false,false,true,'APR 37 / 46 - College','COLLEGE','APR 37 - Graduate School First Attended~APR 46 - College where Doctorate was earned~College~College - Entry',0,'10~10~50~50',7),
	 (1093,true,'yearly.enroll
main.enterenrol',true,false,false,'APR 23 - College Enrollment Status','ENROLL','APR 23 - College Enrollment Status~Enrollment Status (in academic year first served)',0,'10~50',7),
	 (1094,true,'main.bdegree
yearly.bdegree',true,false,false,'APR 27 - Bachelor''s Degree','BDEGREE','APR 27 - Bachelor''s Degree~Bachelors Degree Attained ',0,'10~50',7),
	 (1095,true,'main.acadneed',true,false,false,'Academic Need','ACADNEED',NULL,0,'50',7),
	 (1096,true,'yearly.acadstand',true,false,false,'Academic Standing','ACADSTAND',NULL,0,'50',7),
	 (1097,true,'activity.actgid',true,false,true,'Activity Group','ACTIVITYGROUP',NULL,2,'50',7),
	 (1098,true,NULL,true,false,false,'Activity Group Type','ACTIVITYGROUPTYPE',NULL,0,'50',7),
	 (1099,true,'yearly.advancemat',true,false,false,'Advanced Math Course','ADVANCEMAT',NULL,0,'50',7),
	 (1100,true,'yearly.apcourse',true,false,false,'Advanced Placement Course','APCOURSE',NULL,0,'50',7);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1101,false,'yearly.advisor',false,false,false,'Advisor','ADVISOR',NULL,0,'50',7),
	 (1102,false,'asset.amake',false,false,false,'Asset Make','ASSET MAKE',NULL,0,'50',7),
	 (1103,false,'asset.amodel',false,false,false,'Asset Model','ASSET MODEL',NULL,0,'50',7),
	 (1104,false,'asset.astatus',true,false,false,'Asset Status','ASSETSTATUS',NULL,0,'50',7),
	 (1105,false,'asset.atype',false,false,false,'Asset Type','ASSET TYPE',NULL,0,'50',7),
	 (1106,true,'yearly.adegree',true,false,false,'Associate Degree','ADEGREE',NULL,0,'50',7),
	 (1107,true,'main.atralgebra',true,false,false,'At Risk Algebra','ATRALGEBRA',NULL,0,'50',7),
	 (1108,true,'main.atrlowgpa',true,false,false,'At Risk Low GPA','ATRLOWGPA',NULL,0,'50',7),
	 (1109,true,'main.atrschool',true,false,false,'At Risk Out of School','ATRSCHOOL',NULL,0,'50',7),
	 (1110,true,'main.atrstdtest',true,false,false,'At Risk Standard Test','ATRSTDTEST',NULL,0,'50',7);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1111,false,'main.birthplace',false,false,false,'Birth Place','BIRTH PLACE',NULL,0,'50',7),
	 (1112,false,'botform_submission.SUBMISSION_STATUS',true,false,false,'BOT Form Status','BOTFORMSTATUS',NULL,0,'50',7),
	 (1113,true,'yearly.certi',true,false,false,'Certificate/ Diploma Completed','CERTI',NULL,0,'50',7),
	 (1114,true,'main.vetschecir',true,false,false,'Circumstances of Recheduling','VETSCHECIR',NULL,0,'50',7),
	 (1115,false,'main.codes',false,false,false,'Codes','CODES',NULL,0,'50',7),
	 (1116,true,'main.cohortyear',true,false,false,'Cohort Year','COHORTYEAR',NULL,0,'50',7),
	 (1117,true,'main.enterexam',true,false,false,'College Entrance Exam','ENTEREXAM',NULL,0,'50',7),
	 (1118,true,'yearly.collgradel',true,false,false,'College Grade Level','COLLGRADE',NULL,0,'50',7),
	 (1119,true,'yearly.collready',true,false,false,'College Ready','COLLREADY',NULL,0,'50',7),
	 (1120,true,'yearly.collegety',true,false,false,'College Type','COLLEGETYPE',NULL,0,'50',7);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1121,true,NULL,true,false,false,'Compare Symbols','COMPARE',NULL,0,'50',7),
	 (1122,true,'yearly.completeyr',true,false,false,'Completion Year','COMPLETEYR',NULL,0,'50',7),
	 (1123,true,NULL,true,false,false,'Component Type','COMPONENT',NULL,0,'50',7),
	 (1124,true,NULL,true,false,false,'Component Type-APR','APRCOMPONENT',NULL,0,'50',7),
	 (1125,true,'contact.stftype',true,false,false,'Contact Staff Type','CONTACTSTAFFTYPE',NULL,0,'50',7),
	 (1126,false,'contact.conttype',true,false,false,'Contact Type','CONTACTTYPE',NULL,0,'50',7),
	 (1127,false,'courses.courseinst',false,false,false,'Course Instructor','COURSE INSTRUCTOR',NULL,0,'50',7),
	 (1128,false,'courses.coursename',false,false,false,'Course Name','COURSE NAME',NULL,0,'50',7),
	 (1129,false,'courses.coursenum',false,true,false,'Course Number','COURSE NUMBER',NULL,0,'50',7),
	 (1130,false,'main.custom1',false,false,false,'Custom Field 1','CUSTOM1',NULL,0,'50',7);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1131,false,'main.custom2',false,false,false,'Custom Field 2','CUSTOM2',NULL,0,'50',7),
	 (1132,false,'yearly.custom3',false,false,false,'Custom Field 3','CUSTOM3',NULL,0,'50',7),
	 (1133,false,'yearly.custom4',false,false,false,'Custom Field 4','CUSTOM4',NULL,0,'50',7),
	 (1134,false,'maincfields.customname',true,true,false,'Custom Field Names','CUSTOMFIELDNAME',NULL,0,'50',7),
	 (1135,true,NULL,true,true,true,'Custom Field Type','CUSTOMFIELDTYPE',NULL,0,'50',7),
	 (1136,false,'classes.days',false,false,false,'Days','DAYS',NULL,0,'50',7),
	 (1137,true,'yearly.deceased',true,false,false,'Deceased or Incapacitated','DECEASED',NULL,0,'50',7),
	 (1138,true,'main.disconnect',true,false,false,'Disconnected Youth','DISCONNECT',NULL,0,'50',7),
	 (1139,true,'yearly.dualenroll',true,false,false,'Dual Enrollment','DUALENROLL',NULL,0,'50',7),
	 (1140,true,'yearly.decredenti',true,false,false,'Dual Enrollment Credentials','DECREDENTI',NULL,0,'50',7);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1141,true,'main.eligibilit',true,false,false,'Eligibility','ELIGIBILITY',NULL,0,'50',7),
	 (1142,false,'main.eligtype',false,false,false,'Eligibility Type','ELIGIBILITY TYPE',NULL,0,'50',7),
	 (1143,true,'yearly.employ',true,false,false,'Employment','EMPLOY',NULL,0,'50',7),
	 (1144,true,'yearlychild.servalue',true,true,false,'End Status','ENDSTATUS',NULL,4,'50',7),
	 (1145,true,NULL,true,false,false,'English Instructions','ENGLISH',NULL,0,'50',7),
	 (1146,false,'main.ethnictype',false,false,false,'Ethnic Type (National Origin)','ETHNIC TYPE',NULL,0,'50',7),
	 (1147,true,'yearly.fafsa',true,false,false,'FAFSA completion','FAFSA',NULL,0,'50',7),
	 (1148,true,'main.finaidrecd',true,false,false,'Financial Aid','FINAIDRECD',NULL,0,'50',7),
	 (1149,false,'yearly.finaidname',false,false,false,'Financial Aid Name','FINANCIAL AID NAME',NULL,0,'50',7),
	 (1150,true,'yearly.finaidreas',true,false,false,'Financial Aid Un-met Reason','FINAIDREAS',NULL,0,'50',7);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1151,false,'yearly.finaidunme',false,false,false,'Financial Aid Unmet Name','FINANCIAL AID UNMET',NULL,0,'50',7),
	 (1152,true,NULL,true,false,false,'Foreign Language Instructions','FOREIGNLANGUAGE',NULL,0,'50',7),
	 (1153,true,'eddata.contfreq',true,false,false,'Frequency of contacts between participants','CONTFREQ',NULL,0,'50',7),
	 (1154,true,'yearly.gradelevel',true,false,false,'Grade Level (at end of reporting period)','GRADELEVEL',NULL,0,'50',7),
	 (1155,true,'yearly.gradestart',true,false,false,'Grade Level (at start of reporting period)','GRADESTART',NULL,0,'50',7),
	 (1156,true,'yearly.hsgradepro',true,false,false,'Grade Progression Over Year','GRADEPRO',NULL,0,'50',7),
	 (1157,false,'graduated.degreein',true,false,false,'Graduate Degree In','DEGREEIN',NULL,0,'50',7),
	 (1158,false,'graduated.gdedustat',true,false,false,'Graduate Educational Status','GRADUATEEDUCATIONALSTATUS',NULL,0,'50',7),
	 (1159,false,'graduated.employtype',true,false,false,'Graduate Employment Type','EMPLOYTYPE',NULL,0,'50',7),
	 (1160,true,'main.yearcogrd',true,false,false,'Graduation Cohort Year','YEARCOGRD',NULL,0,'50',7);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1161,false,'main.healthname',false,false,false,'Health Name','HEALTH NAME',NULL,0,'50',7),
	 (1162,true,'yearly.hsgradstat',true,false,false,'High School Graduation Status','GRADSTATUS',NULL,0,'50',7),
	 (1163,true,'yearly.vettest',true,false,false,'Improved Score on Standardized Test','VETTEST',NULL,0,'50',7),
	 (1164,false,'main.incomelev',false,false,false,'Income Level','INCOME LEVEL',NULL,0,'50',7),
	 (1165,false,'main.incomesou',false,false,false,'Income Source','INCOME SOURCE',NULL,0,'50',7),
	 (1166,true,'yearly.initiative',true,false,false,'Initiative','INITIATIVE',NULL,0,'50',7),
	 (1167,false,'labservice.labserid',true,false,true,'Lab Service','LABSERVICE',NULL,0,'50',7),
	 (1168,true,'yearly.partlength',true,false,false,'Length of Project Participation','PARTLENGTH',NULL,0,'50',7),
	 (1169,true,'yearly.mcnmajor',true,false,false,'Major of Graduate Study','MCNMAJOR',NULL,0,'50',7),
	 (1170,false,'main.marrstatus',true,false,false,'Marital Status','MARITALSTATUS',NULL,0,'50',7);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1171,true,NULL,true,false,false,'Mathematics Instructions/ Tutorials','MATH',NULL,0,'50',7),
	 (1172,false,'classes.meettime',false,false,false,'Meeting Time','MEETING TIME',NULL,0,'50',7),
	 (1173,false,'usermessages.msgstatus',true,false,false,'Message Priority Type','MSGSTATUS',NULL,0,'50',7),
	 (1174,false,'graduated.milirank',false,false,false,'Military Rank','MILITARY RANK',NULL,0,'50',7),
	 (1175,false,'graduated.militaryty',true,false,false,'Military Type','MILITARYTYPE',NULL,0,'50',7),
	 (1176,true,'yearlychild.servalue',true,true,false,'Old End Status-For TS and EOC (prior to 2006-07)','OLDENDSTATUS',NULL,7,'50',7),
	 (1177,false,'mainchild.ptitle',false,false,false,'Parent/ Guardian Relationship','PARENT RELATION',NULL,0,'50',7),
	 (1178,true,'yearly.projretain',true,false,false,'Participant Retention in Project','PROJRETAIN',NULL,0,'50',7),
	 (1179,true,'yearly.endstatus',true,false,false,'Participant Status (at end of Reporting Period)','PARTSTATUSEND',NULL,0,'50',7),
	 (1180,true,'yearly.persistend',true,false,false,'Persistence Graduation Status at end of year','PERSISTEND',NULL,0,'50',7);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1181,true,'yearly.persiststa',true,false,false,'Persistence Status at beginning at next year','PERSISTSTA',NULL,0,'50',7),
	 (1182,true,'yearly.pscomplete',true,false,false,'Postsecondary Completion Objective','PSCOMPLETE',NULL,0,'50',7),
	 (1183,true,'yearly.psenroll',true,false,false,'Postsecondary Enrollment Objective','PSENROLL',NULL,0,'50',7),
	 (1184,true,'yearly.pseterm',true,false,false,'Postsecondary Grading Period','PSETERM',NULL,0,'50',7),
	 (1185,true,'yearly.persistden',true,false,false,'Postsecondary Persistence Objective-Denominator','PERSISTDEN',NULL,0,'50',7),
	 (1186,true,'yearly.persistnum',true,false,false,'Postsecondary Persistence Objective-Numerator','PERSISTNUM',NULL,0,'50',7),
	 (1187,true,'yearly.psremediat',true,false,false,'Postsecondary Remediation','PSREMEDIAT',NULL,0,'50',7),
	 (1188,true,'yearly.stemdegree',true,false,false,'Postsecondary STEM Degree','STEMDEGREE',NULL,0,'50',7),
	 (1189,false,'lablog.visitreason',false,false,false,'Reason for Visit','VISIT REASON',NULL,0,'50',7),
	 (1190,true,'yearly.reasonleav',true,false,false,'Reason for Withdrawal/Leaving Project','REASON',NULL,0,'50',7);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1191,true,'yearly.noenreason',true,false,false,'Reason Not Enrolled','NOENREASON',NULL,0,'50',7),
	 (1192,true,'main.vetscherea',true,false,false,'Reason of Recheduling','VETSCHEREA',NULL,0,'50',7),
	 (1193,true,'yearly.recupdated',true,false,false,'Record Updated','RECUPDATED',NULL,0,'50',7),
	 (1194,true,'yearly.recruit',true,false,false,'Recruitment','RECRUIT',NULL,0,'50',7),
	 (1195,false,'main.referedby',false,false,false,'Referred By','REFERRED BY',NULL,0,'50',7),
	 (1196,true,'main.vetrevsche',true,false,false,'Revised Scheduled Completion Year','VETREVSCHE',NULL,0,'50',7),
	 (1197,true,'yearly.rigorous',true,false,false,'Rigorous Enrollment','RIGOROUS',NULL,0,'50',7),
	 (1198,false,'classes.room',false,false,false,'Room','ROOM',NULL,0,'50',7),
	 (1199,true,'main.vetsche',true,false,false,'Scheduled Completion Year','VETSCHE',NULL,0,'50',7),
	 (1200,true,NULL,true,false,false,'Science Instruction/Tutorials','SCIENCE',NULL,0,'50',7);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1201,true,'yearly.schpersist',true,false,false,'Secondary School Retention','SCHPERSIST',NULL,0,'50',7),
	 (1202,true,'yearly.selftran',true,false,false,'Source of Postsecondary Education Information','SELFTRAN',NULL,0,'50',7),
	 (1203,false,'staff.stfcodes',false,false,false,'Staff Codes','STAFF CODES',NULL,0,'50',7),
	 (1204,true,NULL,true,false,false,'Standing Group Type (APR Column)','STANDINGGROUPTYPE',NULL,0,'50',7),
	 (1205,true,'main.statetest',true,false,false,'State-Developed Test to Measure Academic Skills','STATETEST',NULL,0,'50',7),
	 (1206,true,'yearly.sumbridge',true,false,false,'Summer Bridge','SUMBRIDGE',NULL,0,'50',7),
	 (1207,false,NULL,false,false,true,'Teacher','TEACHER',NULL,0,'50',7),
	 (1208,true,'yearly.trackcomp',true,false,false,'Tracking Completed','TRACKCOMP',NULL,0,'50',7),
	 (1209,true,'main.track',true,false,false,'Tracking Graduate','TRACK',NULL,0,'50',7),
	 (1210,true,'yearly.transfers',true,false,false,'Transfers','TRANSFERS',NULL,0,'50',7);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1211,true,'yearly.othertrio',true,false,false,'Trio Programs','OTHERTRIO',NULL,0,'50',7),
	 (1212,false,'yearly.tutor',false,false,true,'Tutor','TUTOR',NULL,0,'50',7),
	 (1213,true,'yearly.testtype',true,false,false,'Type of Standarized Tests','TESTTYPE',NULL,0,'50',7),
	 (1214,true,'eddata.summerresi',true,false,false,'UB,UBMS,VUB Summer residential Program Type','SUMMERRESI',NULL,0,'50',7),
	 (1215,true,'eddata.regional',true,false,false,'UBMS Project type','REGIONAL',NULL,0,'50',7),
	 (1216,true,'yearly.vcalllen',true,false,false,'Veteran Call to Active Duty Length','VCALLLEN',NULL,0,'50',7),
	 (1217,true,'yearly.vcall',true,false,false,'Veteran Called to Active Duty Status','VCALL',NULL,0,'50',7),
	 (1218,true,'yearly.vgradelev',true,false,false,'Veteran Educational Status (at end)','VGRADELEVEL',NULL,0,'50',7),
	 (1219,true,'main.venterlev',true,false,false,'Veteran Educational Status (Entry into Project)','VENTERLEVEL',NULL,0,'50',7),
	 (1220,true,'main.venterjob',true,false,false,'Veteran Employment Status','VENTERJOB',NULL,0,'50',7);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1221,true,'main.vfinaidrec',true,false,false,'Veteran Financial Aid','VFINAIDREC',NULL,0,'50',7),
	 (1222,false,'formslog.formname',false,false,false,'Wallet Name','Wallet Name',NULL,0,'50',7),
	 (1223,true,NULL,true,false,false,'Yearly Child Service Heading','SERHEADING',NULL,0,'50',7),
	 (1224,true,NULL,true,false,false,'Yearly Child Service Type','SERTYPE',NULL,0,'50',7),
	 (1225,true,NULL,true,false,false,'Yes-No Options','YESNO',NULL,0,'50',7),
	 (1226,false,'contactchild.activityid
yearlychild.servalue',true,true,true,'Activity','ACTIVITY','Activity~Activity',1,'50~50',7),
	 (1227,true,'yearlychild.servalue
contact.aprsubject',true,true,false,'APR Subject Types','APR SUBJECT','APR Subject Types~APR Subject Types',6,'50~50',7),
	 (1228,false,'botform_submission.FORM_NAMEBOTFORM_MAINTENANCE.FORM_NAME',false,false,false,'BOT Form Name','BOT FORM NAME','BOT Form Name~BOT Form Name',0,'50~50',7),
	 (1229,true,'main.highdegree
yearly.degree',true,false,false,'Degree/Certificate Completed','HIGHDEGREE','Degree/Certificate Completed ~Degree/Certificate Undergraduate Completed',0,'50~50',7),
	 (1230,false,'exam.examname
examchild.examname',false,false,false,'Exam Name','EXAM NAME','Exam Name~Exam Name',0,'50~50',7);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1231,false,'yearly.standing
semester.standing',true,false,true,'Grade / Standing Type','STANDING','Standing~Standing',0,'50~50',7),
	 (1232,true,'main.lepentry
main.leplastser',true,false,false,'Limited English Proficiency Status','LIMITEDENGPRO','Limited English Proficiency (Date of First Participation)~Limited English Proficiency (Date of Last Service)',0,'50~50',7),
	 (1233,false,'yearly.major
graduated.major',false,false,false,'Major','MAJOR','Major~Major',0,'50~50',7),
	 (1234,false,'main.sitelocate
appusers.sitelocate',false,false,false,'Site Location','SITE LOCATION','Site Location~Site Location',0,'50~50',7),
	 (1235,false,'yearly.counsel
yearly.tutor',false,true,true,'Staff','STAFF','Staff~Tutor',0,'50~50',7),
	 (1236,true,'main.staterlagr
main.statemathg',true,false,false,'State Grade level in which student was Assessed','STATE10GRADE','Grade level when Assessed for State 10th Reading Standard~Grade level when Assessed for State 10th Math Standard',0,'50~50',7),
	 (1237,true,'main.state8rla
main.state8math',true,false,false,'State Met 8th Grade Achievement Standard Options','STATE8MET','Met 8th Grade State Reading Language Art Standard~Met 8th Grade State Math Standard',0,'50~50',7),
	 (1238,false,'contact.stfid
classes.stfid',true,true,true,'STFID - DO NOT USE','STFID','Stfid~Stfid',0,'50~50',7),
	 (1239,false,'classes.subject
contact.subject',false,false,false,'Subject ( Classes/ Contacts)','SUBJECT','Subject~Subject',0,'50~50',7),
	 (1240,false,'formslog.formtype
yearlychild.servalue',true,true,false,'Wallet Type','Wallet Type','Wallet Type Formslog ~Wallet Type Yearly Child',5,'50~50',7);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1241,false,'main.schoolent
yearly.school
main.schoolend',false,false,true,'School Name/Code','SCHOOL','School (Entry into Project)~School(Current Fiscal Year)~School (End of Project)',0,'50~50~50',7),
	 (1242,false,'classes.semester
courses.semester
semester.semester',true,true,false,'Semester Type','SEMESTER','Semester~Semester~Semester',0,'50~50~50',7),
	 (1243,false,'yearly.counsel
graduated.counsel',false,false,true,'Counselor','COUNSELOR','Counselor~Counselor',0,'50~50~50~50',7),
	 (1244,true,'main.gpascale
main.msgpascale
yearly.gpaendsc
yearly.gpastartsc',true,false,false,'GPA Scale','GPASCALE','GPA HS Scale (Entry into Project)~GPA MS Scale(Entry into Project)~GPA Scale (at end of Reporting Period)~GPA Scale (at start of Reporting Period)',0,'50~50~50~50',7),
	 (1245,false,'staff.stfcustom1
staff.stfcustom2
staff.stfcustom3
staff.stfcustom4',false,false,false,'Staff Custom Field','STAFF CUSTOM','Staff Custom 1~Staff Custom 2~ Staff Custom 3~Staff Custom 4',0,'50~50~50~50',7),
	 (1246,true,'main.state10rla
main.state10mat
yearly.state10rla
yearly.state10mat',true,false,false,'State Met 10th Grade Achievement Standard Options','STATE10MET','Met 10th Grade State Reading Language Art Standard~Met 10th Grade State Math Standard~Met HS State Acad. Achievement Standard at Proficient Level—Reading/language arts~Met HS State Acad. Achievement Standard at Proficient Level—Math',0,'50~50~50~50',7),
	 (1247,true,'main.city
mainchild.pcity
eddata.city
graduated.city
school.city
staff.stfcity',false,false,false,'City','CITY','City~City~City~City~City~City',0,'50~50~50~50~50~50',7),
	 (1248,false,'main.state
eddata.state
graduated.state
main.dlstate
mainchild.pstate
school.state
staff.stfstate
staffchild.stfstate',false,false,false,'State (Postal Address)','STATE','State (Postal Address)~State~State~State (Driving License)~State~State~State~State',0,'50~50~50~50~50~50~50~50',7)

,
	 (1249,false,'main.phn1ty
main.phn2ty
mainchild.pphn1ty
mainchild.pphn2ty
mainchild.pphn3ty
staff.stfphn1ty
staff.stfphn2ty
staff.stfphn3ty
staffchild.stfphn1ty
staffchild.stfphn2ty
staffchild.stfphn3ty',false,false,false,'Phone Type','PHONE TYPE','Phone Type 1~Phone Type 2~Phone Type 1~Phone Type 2~Phone Type 3~Phone Type 1~Phone Type 2~Phone Type 3~Phone Type 1~Phone Type 2~Phone Type 3',0,'50~50~50~50~50~50~50~50~50~50',7),
	 (1250,true,'main.acadneed',true,false,false,'PT8-Academic Need','ACADNEED',NULL,0,'50',8);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1251,true,'yearly.acadstand',true,false,false,'PT8-Academic Standing','ACADSTAND',NULL,0,'50',8),
	 (1252,true,'activity.actgid',true,false,true,'PT8-Activity Group','ACTIVITYGROUP',NULL,2,'50',8),
	 (1253,true,NULL,true,false,false,'PT8-Activity Group Type','ACTIVITYGROUPTYPE',NULL,0,'50',8),
	 (1254,true,'yearly.advancemat',true,false,false,'PT8-Advanced Math Course','ADVANCEMAT',NULL,0,'50',8),
	 (1255,true,'yearly.apcourse',true,false,false,'PT8-Advanced Placement Course','APCOURSE',NULL,0,'50',8),
	 (1256,false,'yearly.advisor',false,false,false,'PT8-Advisor','ADVISOR',NULL,0,'50',8),
	 (1257,false,'asset.amake',false,false,false,'PT8-Asset Make','ASSET MAKE',NULL,0,'50',8),
	 (1258,false,'asset.amodel',false,false,false,'PT8-Asset Model','ASSET MODEL',NULL,0,'50',8),
	 (1259,false,'asset.astatus',true,false,false,'PT8-Asset Status','ASSETSTATUS',NULL,0,'50',8),
	 (1260,false,'asset.atype',false,false,false,'PT8-Asset Type','ASSET TYPE',NULL,0,'50',8);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1261,true,'yearly.adegree',true,false,false,'PT8-Associate Degree','ADEGREE',NULL,0,'50',8),
	 (1262,true,'main.atralgebra',true,false,false,'PT8-At Risk Algebra','ATRALGEBRA',NULL,0,'50',8),
	 (1263,true,'main.atrlowgpa',true,false,false,'PT8-At Risk Low GPA','ATRLOWGPA',NULL,0,'50',8),
	 (1264,true,'main.atrschool',true,false,false,'PT8-At Risk Out of School','ATRSCHOOL',NULL,0,'50',8),
	 (1265,true,'main.atrstdtest',true,false,false,'PT8-At Risk Standard Test','ATRSTDTEST',NULL,0,'50',8),
	 (1266,true,'main.commcoll',true,false,false,'PT8-Attended Community College','COMMCOLL',NULL,0,'50',8),
	 (1267,false,'main.birthplace',false,false,false,'PT8-Birth Place','BIRTH PLACE',NULL,0,'50',8),
	 (1268,true,'yearly.certi',true,false,false,'PT8-Certificate/ Diploma Completed','CERTI',NULL,0,'50',8),
	 (1269,true,'main.vetschecir',true,false,false,'PT8-Circumstances of Recheduling','VETSCHECIR',NULL,0,'50',8),
	 (1270,false,'main.codes',false,false,false,'PT8-Codes','CODES',NULL,0,'50',8);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1271,true,'main.cohortyear',true,false,false,'PT8-Cohort Year','COHORTYEAR',NULL,0,'50',8),
	 (1272,true,'main.enterexam',true,false,false,'PT8-College Entrance Exam','ENTEREXAM',NULL,0,'50',8),
	 (1273,true,'yearly.collgradel',true,false,false,'PT8-College Grade Level','COLLGRADE',NULL,0,'50',8),
	 (1274,true,'yearly.collready',true,false,false,'PT8-College Ready','COLLREADY',NULL,0,'50',8),
	 (1275,true,'yearly.collegety',true,false,false,'PT8-College Type','COLLEGETYPE',NULL,0,'50',8),
	 (1276,true,NULL,true,false,false,'PT8-Compare Symbols','COMPARE',NULL,0,'50',8),
	 (1277,true,'yearly.completeyr',true,false,false,'PT8-Completion Year','COMPLETEYR',NULL,0,'50',8),
	 (1278,true,NULL,true,false,false,'PT8-Component Type','COMPONENT',NULL,0,'50',8),
	 (1279,true,NULL,true,false,false,'PT8-Component Type-APR','APRCOMPONENT',NULL,0,'50',8),
	 (1280,true,'contact.stftype',true,false,false,'PT8-Contact Staff Type','CONTACTSTAFFTYPE',NULL,0,'50',8);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1281,false,'contact.conttype',true,false,false,'PT8-Contact Type','CONTACTTYPE',NULL,0,'50',8),
	 (1282,false,'courses.courseinst',false,false,false,'PT8-Course Instructor','COURSE INSTRUCTOR',NULL,0,'50',8),
	 (1283,false,'courses.coursename',false,false,false,'PT8-Course Name','COURSE NAME',NULL,0,'50',8),
	 (1284,false,'courses.coursenum',false,true,false,'PT8-Course Number','COURSE NUMBER',NULL,0,'50',8),
	 (1285,false,'main.custom1',false,true,false,'PT8-Custom Field 1','CUSTOM1',NULL,0,'50',8),
	 (1286,false,'main.custom2',false,false,false,'PT8-Custom Field 2','CUSTOM2',NULL,0,'50',8),
	 (1287,false,'yearly.custom3',false,false,false,'PT8-Custom Field 3','CUSTOM3',NULL,0,'50',8),
	 (1288,false,'yearly.custom4',false,false,false,'PT8-Custom Field 4','CUSTOM4',NULL,0,'50',8),
	 (1289,false,'maincfields.customname',true,true,false,'PT8-Custom Field Names','CUSTOMFIELDNAME',NULL,0,'50',8),
	 (1290,true,NULL,true,true,true,'PT8-Custom Field Type','CUSTOMFIELDTYPE',NULL,0,'50',8);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1291,false,'classes.days',false,false,false,'PT8-Days','DAYS',NULL,0,'50',8),
	 (1292,true,'yearly.deceased',true,false,false,'PT8-Deceased or Incapacitated','DECEASED',NULL,0,'50',8),
	 (1293,true,'main.disconnect',true,false,false,'PT8-Disconnected Youth','DISCONNECT',NULL,0,'50',8),
	 (1294,true,'main.docemploy',true,false,false,'PT8-Doctorate Employment Activity','DOCEMPLOY',NULL,0,'50',8),
	 (1295,true,'yearly.dualenroll',true,false,false,'PT8-Dual Enrollment','DUALENROLL',NULL,0,'50',8),
	 (1296,true,'yearly.decredenti',true,false,false,'PT8-Dual Enrollment Credentials','DECREDENTI',NULL,0,'50',8),
	 (1297,true,'main.eligibilit',true,false,false,'PT8-Eligibility','ELIGIBILITY',NULL,0,'50',8),
	 (1298,false,'main.eligtype',false,false,false,'PT8-Eligibility Type','ELIGIBILITY TYPE',NULL,0,'50',8),
	 (1299,true,'yearly.employ',true,false,false,'PT8-Employment','EMPLOY',NULL,0,'50',8),
	 (1300,true,'yearlychild.servalue',true,true,false,'PT8-End Status','ENDSTATUS',NULL,4,'50',8);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1301,true,NULL,true,false,false,'PT8-English Instructions','ENGLISH',NULL,0,'50',8),
	 (1302,false,'main.ethnictype',false,false,false,'PT8-Ethnic Type (National Origin)','ETHNIC TYPE',NULL,0,'50',8),
	 (1303,true,'main.ethnic',true,false,false,'PT8-Ethnicity /Race','ETHNIC',NULL,0,'50',8),
	 (1304,true,'yearly.fafsa',true,false,false,'PT8-FAFSA completion','FAFSA',NULL,0,'50',8),
	 (1305,true,'main.finaidrecd',true,false,false,'PT8-Financial Aid','FINAIDRECD',NULL,0,'50',8),
	 (1306,false,'yearly.finaidname',false,false,false,'PT8-Financial Aid Name','FINANCIAL AID NAME',NULL,0,'50',8),
	 (1307,true,'yearly.finaidreas',true,false,false,'PT8-Financial Aid Un-met Reason','FINAIDREAS',NULL,0,'50',8),
	 (1308,false,'yearly.finaidunme',false,false,false,'PT8-Financial Aid Unmet Name','FINANCIAL AID UNMET',NULL,0,'50',8),
	 (1309,true,NULL,true,false,false,'PT8-Foreign Language Instructions','FOREIGNLANGUAGE',NULL,0,'50',8),
	 (1310,true,'eddata.contfreq',true,false,false,'PT8-Frequency of contacts between participants','CONTFREQ',NULL,0,'50',8);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1311,true,'yearly.fundsource',true,false,false,'PT8-Funding Source','FUNDSOURCE',NULL,0,'50',8),
	 (1312,true,'main.gender',true,false,false,'PT8-Gender','GENDER',NULL,0,'50',8),
	 (1313,true,'yearly.gradelevel',true,false,false,'PT8-Grade Level (at end of reporting period)','GRADELEVEL',NULL,0,'50',8),
	 (1314,true,'yearly.gradestart',true,false,false,'PT8-Grade Level (at start of reporting period)','GRADESTART',NULL,0,'50',8),
	 (1315,true,'main.enterlevel',true,false,false,'PT8-Grade Level (at time of first entry into project)','ENTERLEVEL',NULL,0,'50',8),
	 (1316,true,'yearly.hsgradepro',true,false,false,'PT8-Grade Progression Over Year','GRADEPRO',NULL,0,'50',8),
	 (1317,true,'yearly.gradassist',true,false,false,'PT8-Graduate Assistantships','GRADASSIST',NULL,0,'50',8),
	 (1318,true,'yearly.gradstudyl',true,false,false,'PT8-Graduate Current Year of Study','GRADSTUDYL',NULL,0,'50',8),
	 (1319,true,'main.gdegree',true,false,false,'PT8-Graduate Degree Earned','GDEGREE',NULL,0,'50',8),
	 (1320,false,'graduated.degreein',true,false,false,'PT8-Graduate Degree In','DEGREEIN',NULL,0,'50',8);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1321,false,'graduated.gdedustat',true,false,false,'PT8-Graduate Educational Status','GRADUATEEDUCATIONALSTATUS',NULL,0,'50',8),
	 (1322,false,'graduated.employtype',true,false,false,'PT8-Graduate Employment Type','EMPLOYTYPE',NULL,0,'50',8),
	 (1323,true,'main.gradadm',true,false,false,'PT8-Graduate School Admissions Test','GRADADM',NULL,0,'50',8),
	 (1324,true,'yearly.enrollobj',true,false,false,'PT8-Graduate School Enrollment Objective','ENROLLOBJ',NULL,0,'50',8),
	 (1325,true,'yearly.gpersist',true,false,false,'PT8-Graduate Student Persistence Status','GPERSIST',NULL,0,'50',8),
	 (1326,true,'main.bdegreeco',true,false,false,'PT8-Graduating Cohort Year of Bachelor''s Degree','BDEGREECO',NULL,0,'50',8),
	 (1327,true,'main.yearcogrd',true,false,false,'PT8-Graduation Cohort Year','YEARCOGRD',NULL,0,'50',8),
	 (1328,false,'main.healthname',false,false,false,'PT8-Health Name','HEALTH NAME',NULL,0,'50',8),
	 (1329,true,'yearly.hsgradstat',true,false,false,'PT8-High School Graduation Status','GRADSTATUS',NULL,0,'50',8),
	 (1330,true,'yearly.vettest',true,false,false,'PT8-Improved Score on Standardized Test','VETTEST',NULL,0,'50',8);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1331,false,'main.incomelev',false,false,false,'PT8-Income Level','INCOME LEVEL',NULL,0,'50',8),
	 (1332,false,'main.incomesou',false,false,false,'PT8-Income Source','INCOME SOURCE',NULL,0,'50',8),
	 (1333,true,'yearly.initiative',true,false,false,'PT8-Initiative','INITIATIVE',NULL,0,'50',8),
	 (1334,true,'yearly.mcintern',true,false,false,'PT8-Internship','INTERN',NULL,0,'50',8),
	 (1335,false,'labservice.labserid',true,false,true,'PT8-Lab Service','LABSERVICE',NULL,0,'50',8),
	 (1336,true,'yearly.partlength',true,false,false,'PT8-Length of Project Participation','PARTLENGTH',NULL,0,'50',8),
	 (1337,true,'yearly.mcnmajor',true,false,false,'PT8-Major of Graduate Study','MCNMAJOR',NULL,0,'50',8),
	 (1338,false,'main.marrstatus',true,false,false,'PT8-Marital Status','MARITALSTATUS',NULL,0,'50',8),
	 (1339,true,NULL,true,false,false,'PT8-Mathematics Instructions/ Tutorials','MATH',NULL,0,'50',8),
	 (1340,false,'classes.meettime',false,false,false,'PT8-Meeting Time','MEETING TIME',NULL,0,'50',8);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1341,false,'usermessages.msgstatus',true,false,false,'PT8-Message Priority Type','MSGSTATUS',NULL,0,'50',8),
	 (1342,false,'graduated.milirank',false,false,false,'PT8-Military Rank','MILITARY RANK',NULL,0,'50',8),
	 (1343,false,'graduated.militaryty',true,false,false,'PT8-Military Type','MILITARYTYPE',NULL,0,'50',8),
	 (1344,true,'yearlychild.servalue',true,true,false,'PT8-Old End Status-For TS and EOC (prior to 2006-07)','OLDENDSTATUS',NULL,7,'50',8),
	 (1345,false,'mainchild.ptitle',false,false,false,'PT8-Parent/ Guardian Relationship','PARENT RELATION',NULL,0,'50',8),
	 (1346,true,'yearly.projretain',true,false,false,'PT8-Participant Retention in Project','PROJRETAIN',NULL,0,'50',8),
	 (1347,true,'yearly.partstatus',true,false,false,'PT8-Participant Status','PARTSTATUS',NULL,0,'50',8),
	 (1348,true,'yearly.endstatus',true,false,false,'PT8-Participant Status (at end of Reporting Period)','PARTSTATUSEND',NULL,0,'50',8),
	 (1349,true,'yearly.partlevel',true,false,false,'PT8-Participation Level','PARTLEVEL',NULL,0,'50',8),
	 (1350,true,'yearly.persistend',true,false,false,'PT8-Persistence Graduation Status at end of year','PERSISTEND',NULL,0,'50',8);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1351,true,'yearly.persiststa',true,false,false,'PT8-Persistence Status at beginning at next year','PERSISTSTA',NULL,0,'50',8),
	 (1352,true,'yearly.pscomplete',true,false,false,'PT8-Postsecondary Completion Objective','PSCOMPLETE',NULL,0,'50',8),
	 (1353,true,'yearly.psenroll',true,false,false,'PT8-Postsecondary Enrollment Objective','PSENROLL',NULL,0,'50',8),
	 (1354,true,'yearly.pseterm',true,false,false,'PT8-Postsecondary Grading Period','PSETERM',NULL,0,'50',8),
	 (1355,true,'yearly.persistden',true,false,false,'PT8-Postsecondary Persistence Objective-Denominator','PERSISTDEN',NULL,0,'50',8),
	 (1356,true,'yearly.persistnum',true,false,false,'PT8-Postsecondary Persistence Objective-Numerator','PERSISTNUM',NULL,0,'50',8),
	 (1357,true,'yearly.psremediat',true,false,false,'PT8-Postsecondary Remediation','PSREMEDIAT',NULL,0,'50',8),
	 (1358,true,'yearly.stemdegree',true,false,false,'PT8-Postsecondary STEM Degree','STEMDEGREE',NULL,0,'50',8),
	 (1359,false,'lablog.visitreason',false,false,false,'PT8-Reason for Visit','VISIT REASON',NULL,0,'50',8),
	 (1360,true,'yearly.reasonleav',true,false,false,'PT8-Reason for Withdrawal/Leaving Project','REASON',NULL,0,'50',8);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1361,true,'yearly.greason',true,false,false,'PT8-Reason left Graduate School','GREASON',NULL,0,'50',8),
	 (1362,true,'yearly.noenreason',true,false,false,'PT8-Reason Not Enrolled','NOENREASON',NULL,0,'50',8),
	 (1363,true,'main.vetscherea',true,false,false,'PT8-Reason of Recheduling','VETSCHEREA',NULL,0,'50',8),
	 (1364,true,'yearly.recupdated',true,false,false,'PT8-Record Updated','RECUPDATED',NULL,0,'50',8),
	 (1365,true,'yearly.recruit',true,false,false,'PT8-Recruitment','RECRUIT',NULL,0,'50',8),
	 (1366,false,'main.referedby',false,false,false,'PT8-Referred By','REFERRED BY',NULL,0,'50',8),
	 (1367,true,'yearly.mcresearch
',true,false,false,'PT8-Research Activities','RESEARCH',NULL,0,'50',8),
	 (1368,true,'main.vetrevsche',true,false,false,'PT8-Revised Scheduled Completion Year','VETREVSCHE',NULL,0,'50',8),
	 (1369,true,'yearly.rigorous',true,false,false,'PT8-Rigorous Enrollment','RIGOROUS',NULL,0,'50',8),
	 (1370,false,'classes.room',false,false,false,'PT8-Room','ROOM',NULL,0,'50',8);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1371,true,'main.vetsche',true,false,false,'PT8-Scheduled Completion Year','VETSCHE',NULL,0,'50',8),
	 (1372,true,'yearly.mcscholar',true,false,false,'PT8-Scholarly Activity','SCHOLAR',NULL,0,'50',8),
	 (1373,true,NULL,true,false,false,'PT8-Science Instruction/Tutorials','SCIENCE',NULL,0,'50',8),
	 (1374,true,'yearly.schpersist',true,false,false,'PT8-Secondary School Retention','SCHPERSIST',NULL,0,'50',8),
	 (1375,true,'yearly.selftran',true,false,false,'PT8-Source of Postsecondary Education Information','SELFTRAN',NULL,0,'50',8),
	 (1376,false,'staff.stfcodes',false,false,false,'PT8-Staff Codes','STAFF CODES',NULL,0,'50',8),
	 (1377,true,NULL,true,false,false,'PT8-Standing Group Type (APR Column)','STANDINGGROUPTYPE',NULL,0,'50',8),
	 (1378,true,'main.statetest',true,false,false,'PT8-State-Developed Test to Measure Academic Skills','STATETEST',NULL,0,'50',8),
	 (1379,true,'main.mcstem',true,false,false,'PT8-STEM Major','MCSTEM',NULL,0,'50',8),
	 (1380,true,'yearly.sumbridge',true,false,false,'PT8-Summer Bridge','SUMBRIDGE',NULL,0,'50',8);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1381,false,NULL,false,false,true,'PT8-Teacher','TEACHER',NULL,0,'50',8),
	 (1382,true,'yearly.trackcomp',true,false,false,'PT8-Tracking Completed','TRACKCOMP',NULL,0,'50',8),
	 (1383,true,'main.track',true,false,false,'PT8-Tracking Graduate','TRACK',NULL,0,'50',8),
	 (1384,true,'yearly.transfers',true,false,false,'PT8-Transfers','TRANSFERS',NULL,0,'50',8),
	 (1385,true,'yearly.othertrio',true,false,false,'PT8-Trio Programs','OTHERTRIO',NULL,0,'50',8),
	 (1386,false,'yearly.tutor',false,false,true,'PT8-Tutor','TUTOR',NULL,0,'50',8),
	 (1387,true,'yearly.testtype',true,false,false,'PT8-Type of Standarized Tests','TESTTYPE',NULL,0,'50',8),
	 (1388,true,'eddata.summerresi',true,false,false,'PT8-UB,UBMS,VUB Summer residential Program Type','SUMMERRESI',NULL,0,'50',8),
	 (1389,true,'eddata.regional',true,false,false,'PT8-UBMS Project type','REGIONAL',NULL,0,'50',8),
	 (1390,true,'yearly.vcalllen',true,false,false,'PT8-Veteran Call to Active Duty Length','VCALLLEN',NULL,0,'50',8);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1391,true,'yearly.vcall',true,false,false,'PT8-Veteran Called to Active Duty Status','VCALL',NULL,0,'50',8),
	 (1392,true,'yearly.vgradelev',true,false,false,'PT8-Veteran Educational Status (at end)','VGRADELEVEL',NULL,0,'50',8),
	 (1393,true,'main.venterlev',true,false,false,'PT8-Veteran Educational Status (Entry into Project)','VENTERLEVEL',NULL,0,'50',8),
	 (1394,true,'main.venterjob',true,false,false,'PT8-Veteran Employment Status','VENTERJOB',NULL,0,'50',8),
	 (1395,true,'main.vfinaidrec',true,false,false,'PT8-Veteran Financial Aid','VFINAIDREC',NULL,0,'50',8),
	 (1396,false,'formslog.formname',false,false,false,'PT8-Wallet Name','Wallet Name',NULL,0,'50',8),
	 (1397,true,NULL,true,false,false,'PT8-Yearly Child Service Heading','SERHEADING',NULL,0,'50',8),
	 (1398,true,NULL,true,false,false,'PT8-Yearly Child Service Type','SERTYPE',NULL,0,'50',8),
	 (1399,true,NULL,true,false,false,'PT8-Yes-No Options','YESNO',NULL,0,'50',8),
	 (1400,false,'contactchild.activityid
yearlychild.servalue',true,true,true,'PT8-Activity','ACTIVITY','B PT8-Activity~APT8-Activity',1,'50~50',8);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1401,true,'yearlychild.servalue
contact.aprsubject',true,true,false,'PT8-APR Subject Types','APR SUBJECT','PT8-APR Subject Types~PT8-APR Subject Types',6,'50~50',8),
	 (1402,true,'main.bdegree
yearly.bdegree',true,false,false,'PT8-Bachelor''s Degree','BDEGREE','PT8-Bachelor''s Degree~PT8-Bachelor''s Degree Attained',0,'50~50',8),
	 (1403,true,'main.highdegree
yearly.degree',true,false,false,'PT8-Degree/Certificate Completed','HIGHDEGREE','PT8-Degree/Certificate Completed~PT8-Degree/Certificate Undergraduate Completed',0,'50~50',8),
	 (1404,true,'yearly.enroll
main.enterenrol',true,false,false,'PT8-Enrollment Status','ENROLL','PT8-Enrollment Status (at the end of the academic year)~PT8-Enrollment Status (in academic year first served)',0,'50~50',8),
	 (1405,false,'exam.examname
examchild.examname',false,false,false,'PT8-Exam Name','EXAM NAME','PT8-Exam Name~PT8-Exam Name',0,'50~50',8),
	 (1406,false,'yearly.standing
semester.standing',true,false,true,'PT8-Grade / Standing Type','STANDING','PT8-Standing~PT8-Standing',0,'50~50',8),
	 (1407,true,'main.lepentry
main.leplastser',true,false,false,'PT8-Limited English Proficiency Status','LIMITEDENGPRO','PT8-Limited English Proficiency (Date of First Participation)~PT8-Limited English Proficiency (Date of Last Service)',0,'50~50',8),
	 (1408,false,'yearly.major
graduated.major',false,false,false,'PT8-Major','MAJOR','PT8-Major~PT8-Major',0,'50~50',8),
	 (1409,false,'main.sitelocate
appusers.sitelocate',false,false,false,'PT8-Site Location','SITE LOCATION','PT8-Site Location~PT8-Site Location',0,'50~50',8),
	 (1410,false,'yearly.counsel
yearly.tutor',false,true,true,'PT8-Staff','STAFF','PT8-Staff~PT8-Tutor',0,'50~50',8);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1411,true,'main.staterlagr
main.statemathg',true,false,false,'PT8-State Grade level in which student was Assesse','STATE10GRADE','PT8-Grade level when Assessed for State 10th Reading Standard~PT8-Grade level when Assessed for State 10th Math Standard',0,'50~50',8),
	 (1412,true,'main.state8rla
main.state8math',true,false,false,'PT8-State Met 8th Grade Achievement Standard Options','STATE8MET','PT8-Met 8th Grade State Reading Language Art Standard~PT8-Met 8th Grade State Math Standard',0,'50~50',8),
	 (1413,false,'contact.stfid
classes.stfid',true,true,true,'PT8-STFID - DO NOT USE','STFID','PT8 - Stfid~PT8 - Stfid',0,'50~50',8),
	 (1414,false,'classes.subject
contact.subject',false,false,false,'PT8-Subject ( Classes/ Contacts)','SUBJECT','PT8-Subject~PT8-Subject',0,'50~50',8),
	 (1415,false,'formslog.formtype
yearlychild.servalue',false,false,false,'PT8-Wallet Type','Wallet Type','PT8 - Wallet Type Formslog ~PT8 - Wallet Type Yearly Child',5,'50~50',8),
	 (1416,false,'main.schoolent
yearly.school
main.schoolend',false,false,true,'PT8-School Name/Code','SCHOOL','PT8-School (Entry into Project)~PT8-School(Current Fiscal Year)~PT8-School (End of Project)',0,'50~50~50',8),
	 (1417,false,'classes.semester
courses.semester
semester.semester',true,true,false,'PT8-Semester Type','SEMESTER','PT8-Semester~PT8-Semester~PT8-Semester',0,'50~50~50',8),
	 (1418,false,'yearly.college
main.collegeent
main.gradcoll
main.gdoccoll',false,false,true,'PT8-College','COLLEGE','PT8-College~PT8 - Entry College~PT8-Graduate School First Attended~PT8-Doctorate College',0,'50~50~50~50',8),
	 (1419,false,'yearly.counsel
graduated.counsel',false,false,true,'PT8-Counselor','COUNSELOR','PT8-Counselor~PT8-Counselor',0,'50~50~50~50',8),
	 (1420,true,'main.gpascale
main.msgpascale
yearly.gpaendsc
yearly.gpastartsc',true,false,false,'PT8-GPA Scale','GPASCALE','PT8-GPA HS Scale (Entry into Project)~PT8-GPA MS Scale(Entry into Project)~PT8-GPA Scale (at end of Reporting Period)~PT8-GPA Scale (at start of Reporting Period)',0,'50~50~50~50',8);
INSERT INTO blumen2.pulltype (pull_type_id,apr,data_fields,is_numeric,is_primary,no_edit,pull_desc,pull_type,quick_edit_desc,ser_type,sort_order,proj_type) VALUES
	 (1421,false,'staff.stfcustom1
staff.stfcustom2
staff.stfcustom3
staff.stfcustom4',false,false,false,'PT8-Staff Custom Field','STAFF CUSTOM','PT8-Staff Custom 1~PT8-Staff Custom 2~ PT8-Staff Custom 3~PT8-Staff Custom 4',0,'50~50~50~50',8),
	 (1422,true,'main.state10rla
main.state10mat
yearly.state10rla
yearly.state10mat',true,false,false,'PT8-State Met 10th Grade Achievement Standard Option','STATE10MET','PT8-Met 10th Grade State Reading Language Art Standard~PT8-Met 10th Grade State Math Standard~PT8-Met HS State Acad. Achievement Standard at Proficient Level—Reading/language arts~PT8-Met HS State Acad. Achievement Standard at Proficient Level—Math',0,'50~50~50~50',8),
	 (1423,true,'main.city
mainchild.pcity
eddata.city
graduated.city
school.city
staff.stfcity',false,false,false,'PT8-City','CITY','PT8-City~PT8-City~PT8-City~PT8-City~PT8-City~PT8-City',0,'50~50~50~50~50~50',8),
	 (1424,false,'main.state
eddata.state
graduated.state
main.dlstate
mainchild.pstate
school.state
staff.stfstate
staffchild.stfstate',false,false,false,'PT8-State (Postal Address)','STATE','PT8-State Main~PT8-State Eddata~PT8-State Graduated~PT8-State Main DL~PT8-State Mainchild~PT8-State School~PT8-State Staff~PT8-State Staffchild',0,'50~50~50~50~50~50~50~50',8),
	 (1425,false,'main.phn1ty
main.phn2ty
mainchild.pphn1ty
mainchild.pphn2ty
mainchild.pphn3ty
staff.stfphn1ty
staff.stfphn2ty
staff.stfphn3ty
staffchild.stfphn1ty
staffchild.stfphn2ty
staffchild.stfphn3ty',false,false,false,'PT8-Phone Type','PHONE TYPE','PT8-Phone Type 1~PT8-Phone Type 2~PT8-Phone Type 1~PT8-Phone Type 2~PT8-Phone Type 3~PT8-Phone Type 1~PT8-Phone Type 2~PT8-Phone Type 3~PT8-Phone Type 1~PT8-Phone Type 2~PT8-Phone Type 3',0,'50~50~50~50~50~50~50~50~50~50',8);