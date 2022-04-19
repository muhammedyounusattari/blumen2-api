insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('All',0,'Y',null,1) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Allow Easy Add to Pulldown List',0,'Y',0,2) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Add New Student',0,'Y',0,3) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Delete Student',0,'Y',0,4) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Show System Serial Number',0,'Y',null,5) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Project Summary',0,'Y',0,6) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Project Interactive Summary',0,'Y',0,7) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Manage Filter List',0,'Y',0,8) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('All Student Data',0,'Y',0,9) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Send Bulk E-mails',0,'Y',8,10) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Send Bulk Text Messaging',0,'Y',8,11) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Student Postsecondary Tracking',0,'Y',8,12) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Student Data Filter',0,'Y',8,13) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Student Data Entry',0,'Y',12,14) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Parent / Guardian Data Entry',0,'Y',13,15) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Text Message Data Filter',0,'Y',12,16) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Text Message Data Entry',0,'Y',15,17) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Yearly Data Filter',0,'Y',12,18) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Yearly Data Entry',0,'Y',17,19) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Semester Data Filter',0,'Y',12,20) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Semester Data Entry',0,'Y',19,21) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Courses Data Entry',0,'Y',20,22) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Graduated Data Filter',0,'Y',12,23) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Graduated Data Entry',0,'Y',22,24) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Tracking Data Entry',0,'Y',12,25) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Personalized Letters',0,'Y',12,26) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Demograhic Data',0,'Y',22,27) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Asset Filter',0,'Y',12,28) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Asset Data Entry',0,'Y',27,29) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Asset Check Out',0,'Y',28,30) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Asset Check In',0,'Y',28,31) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('All Logs',0,'Y',0,32) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Attendance Data Filter',0,'Y',31,33) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Attendance Data Entry',0,'Y',32,34) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Stipend Data Filter',0,'Y',31,35) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Stipend Data Entry',0,'Y',34,36) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Exam Filter',0,'Y',31,37) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Exam Data Entry',0,'Y',36,38) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Wallet Data Filter',0,'Y',31,39) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Wallet Data Entry',0,'Y',38,40) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Notes Data Filter',0,'Y',31,41) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Notes Data Entry',0,'Y',40,42) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('BOT Form Submission Log',0,'Y',31,43) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('BOT Form Submission Detail',0,'Y',42,44) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('All Contacts',0,'Y',0,45) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Counselor Contact Filter',0,'Y',44,46) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Counselor Contact Data',0,'Y',45,47) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Tutor Contact Filter',0,'Y',44,48) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Tutor Contact Data',0,'Y',47,49) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Teacher Contact Filter',0,'Y',44,50) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Teacher Contact Data',0,'Y',49,51) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Staff Contact Filter',0,'Y',44,52) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Staff Contact Data',0,'Y',51,53) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Lab Contact Filter',0,'Y',44,54) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Lab Contact Data',0,'Y',53,55) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Display Reminders',0,'Y',44,56) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('All Classes',0,'Y',0,57) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Counselor Classes Filter',0,'Y',56,58) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Counselor Classes Data',0,'Y',57,59) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Tutor Classes Filter',0,'Y',56,60) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Tutor Classes Data',0,'Y',59,61) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Teacher Classes Filter',0,'Y',56,62) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Teacher Classes Data',0,'Y',61,63) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Staff Classes Filter',0,'Y',56,64) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Staff Classes Data',0,'Y',63,65) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('All Schedules',0,'Y',0,66) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Counselor Schedule Filter',0,'Y',65,67) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Counselor Schedule Data',0,'Y',66,68) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Select Counselor Classes',0,'Y',67,69) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Tutor Schedule Filter',0,'Y',65,70) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Tutor Schedule Data',0,'Y',69,71) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Select Tutor Classes',0,'Y',70,72) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Teacher Schedule Filter',0,'Y',65,73) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Teacher Schedule Data',0,'Y',72,74) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Select Teacher Classes',0,'Y',73,75) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Staff Schedule Filter',0,'Y',65,76) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Staff Schedule Data',0,'Y',75,77) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Select Staff Classes',0,'Y',76,78) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('All Staff',0,'Y',0,79) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Counselor Data Filter/ Entry',0,'Y',78,80) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Counselor Data Filter/ Entry',0,'Y',78,81) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Teacher Data Filter/ Entry',0,'Y',78,82) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Staff Data Filter/ Entry',0,'Y',78,83) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('All Reports (Request Manager)',0,'Y',0,84) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('All Annual Performance Report',0,'Y',83,85) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('All APR Sections',0,'Y',84,86) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Annual Performance Report Section 1-Part II',0,'Y',85,87) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Annual Performance Report - Section I',0,'Y',85,88) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Annual Performance Report Section 1- Part 4',0,'Y',85,89) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Annual Performance Report - Section II',0,'Y',85,90) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Annual Performance Report - Section II (Quick Edit)',0,'Y',85,91) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Annual Performance Report Section 4-Part E',0,'Y',85,92) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Annual Performance Report - Section III',0,'Y',85,93) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Annual Performance Report - Section IV',0,'Y',85,94) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Goals / Objectives and Accomplishments',0,'Y',85,95) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Goals / Objectives and Accomplishments Data Entry',0,'Y',85,96) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Provision of Services',0,'Y',85,97) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('APR Objectives / PE Points',0,'Y',85,98) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Copy APR Data',0,'Y',85,99) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Update fields from Tracking Data',0,'Y',85,100) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Update All Profiles',0,'Y',84,101) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Update Student Profile from Counselor Contacts',0,'Y',100,102) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Update Student Profile from Tutor Contacts',0,'Y',100,103) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Update Student Profile from Teacher Contacts',0,'Y',100,104) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Update Student Profile from Staff Contacts',0,'Y',100,105) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Update Student Profile from Lab Contacts',0,'Y',100,106) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Update Student Profile from Wallet',0,'Y',100,107) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Utilities',0,'Y',0,108) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Change S.S.No.',0,'Y',107,109) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Quick Change',0,'Y',107,110) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('National Student Clearinghouse Data Interface',0,'Y',107,111) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('All Quick Edit',0,'Y',107,112) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Quick Edit Student Demographic Information',0,'Y',111,113) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Quick Edit Student Yearly and Financial Aid Inform',0,'Y',111,114) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Quick Edit Student Semester Information',0,'Y',111,115) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Quick Edit Student Courses Information',0,'Y',111,116) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('All Add Students to',0,'Y',107,117) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Add Students to Fiscal Year',0,'Y',116,118) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Add Students to Semester',0,'Y',116,119) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Add Students to Graduated List',0,'Y',116,120) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('All Generate Similar',0,'Y',107,121) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Generate Similar Attendance Log',0,'Y',120,122) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Generate Similar Exam',0,'Y',120,123) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Generate Similar Wallet',0,'Y',120,124) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Generate Similar Stipend',0,'Y',120,125) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Generate Similar Yearly APR Subjects',0,'Y',120,126) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Generate Similar Yearly Activity',0,'Y',120,127) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Generate Similar Yearly End Status',0,'Y',120,128) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Generate Similar Yearly Wallet',0,'Y',120,129) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Generate Similar Yearly Activity',0,'Y',120,130) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Generate Similar Yearly End Status',0,'Y',120,131) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Generate Similar Yearly Wallet',0,'Y',120,132) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Generate Similar Custom Field Values',0,'Y',120,133) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Generate Similar Notes Log',0,'Y',120,134) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Generate Similar Lab Logs',0,'Y',120,135) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('All Generate Contacts',0,'Y',107,136) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Generate Similar Counselor Contacts',0,'Y',135,137) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Generate Similar Counselor Contacts',0,'Y',135,138) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Generate Similar Teacher Contacts',0,'Y',135,139) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Generate Similar Staff Contacts',0,'Y',135,140) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('All Generate Schedule',0,'Y',107,141) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Generate Similar Counselor Schedule',0,'Y',140,142) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Generate Similar Tutor Schedule',0,'Y',140,143) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Generate Similar Teacher Schedule',0,'Y',140,144) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Generate Similar Staff Schedule',0,'Y',140,145) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Copy Counselor Classes',0,'Y',140,146) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Copy Staff Classes',0,'Y',140,147) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Copy Teacher Classes',0,'Y',140,148) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Copy Tutor Classes',0,'Y',140,149) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Administration',0,'Y',0,150) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Set System Preferences',0,'Y',149,151) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Config Settings',0,'Y',149,152) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('E-Mail Setup',0,'Y',149,153) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Roles',0,'Y',149,154) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('User Names and Password',0,'Y',149,155) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Customize',0,'Y',149,156) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Activity / Services Group List',0,'Y',155,157) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Activity / Services List',0,'Y',155,158) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('College Names',0,'Y',155,159) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Custom Fields Values',0,'Y',155,160) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Grade / Standing Group List',0,'Y',155,161) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Grade / Standing List',0,'Y',155,162) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Pulldown Lists',0,'Y',155,163) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('School Names',0,'Y',155,164) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('System Tools',0,'Y',149,165) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Staff Time Clock Manager',0,'Y',164,166) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Delete Students',0,'Y',164,167) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Recall Students',0,'Y',164,168) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Update GPA Wizard',0,'Y',164,169) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Update Year',0,'Y',164,170) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Update Age',0,'Y',164,171) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('BOT Form Management',0,'Y',149,172) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('BOT Form Detail',0,'Y',171,173) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('BOT Form Submission Detail',0,'Y',172,174) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Delete All',0,'Y',0,175) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Mobile App Access',0,'Y',0,176) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Trio Blumen Lab',0,'Y',0,177) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Lab Setting Preferences',0,'Y',176,178) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('Group checkout button',0,'Y',177,179) ON CONFLICT (privilege_id) DO NOTHING;
insert  into blumen2.privileges ( name,org_id, access_type,parent_code, code) values ('ImportWizard',0,'Y',0,180) ON CONFLICT (privilege_id) DO NOTHING;













































