# Interview Misc

Java Exercises for technical interviews that I did over the years

#### Warning! Code may not be pretty but it does the job

select * from (select school.schooldescription, count(student.studentid), count(case when student.ethnicityid = 1 then 1 end) as 'White', count(case when student.ethnicityid = 2 then 1 end) as 'Asian', count(case when student.ethnicityid = 3 then 1 end) as 'Hispanic', count(case when student.ethnicityid = 4 then 1 end) as 'African American' from student inner join school on school.schoolid = student.schoolid right join ethnicity on ethnicity.ethnicityid = student.ethnicityid group by school.schoolid union all select 'Total', count(student.studentid), count(case when student.ethnicityid = 1 then 1 end) as 'White', count(case when student.ethnicityid = 2 then 1 end) as 'Asian', count(case when student.ethnicityid = 3 then 1 end) as 'Hispanic', count(case when student.ethnicityid = 4 then 1 end) as 'African American' from student inner join school on school.schoolid = student.schoolid right join ethnicity on ethnicity.ethnicityid = student.ethnicityid) temp order by temp.schooldescription

select student.studentname, case when sum(case when studentcollege.collegeid = 1 then studentcollege.admitted end) = 1 then 'YES' else 'NO' end as 'Admitted to CSU Fresno', case when sum(case when studentcollege.collegeid = 2 then studentcollege.admitted end) = 1 then 'YES' else 'NO'end as 'Admitted to Fresno City College' from student inner join studentcollege on studentcollege.studentid = student.studentid where student.studentid in (select studentcollege.studentid from studentcollege group by studentcollege.studentid having count(*) > 1) group by student.studentid

select student.StudentID, StudentName, case when admitted = 0 then 'NO' when admitted = 1 then 'YES' end as 'Admitted to CSU Fresno' from studentcollege inner join student on student.studentid = studentcollege.studentid where student.studentID in (select studentcollege.studentid from studentcollege group by studentcollege.studentid having count(*) = 1) and studentcollege.collegeid = (select college.collegeid from college where college.collegename = 'CSU Fresno')

SELECT Student.StudentID, StudentName FROM Student LEFT JOIN StudentCollege ON StudentCollege.StudentID = Student.StudentID WHERE StudentCollege.StudentID IS NULL AND Student.StudentID IS NOT NULL

SELECT Student.StudentID, StudentName FROM Student LEFT JOIN StudentCollege ON StudentCollege.StudentID = Student.StudentID WHERE StudentCollege.StudentID IS NULL AND Student.StudentID IS NOT NULL OR Student.StudentID in (select StudentID from StudentCollege group by StudentID having sum(admitted) = 0)

select school.schooldescription, count(student.studentid) as 'Total Number of Students', sum(sc.applied) as 'Number of Students Applied', count(student.studentid)-sum(sc.applied) as 'Number of Students NOT Applied', sum(sc.admitted) as 'Number of Students Admitted', count(student.studentid)-sum(sc.admitted) as 'Number of Students NOT admitted' from (select studentid, case when sum(applied) > 0 then 1 else sum(applied) end as "applied", case when sum(admitted) > 0 then 1 else sum(admitted) end as "admitted" from studentcollege group by studentid) sc right join student on student.studentid = sc.studentid inner join school on school.schoolid = student.schoolid group by student.schoolid union all select 'Total', count(student.studentid), sum(sc.applied), count(student.studentid)-sum(sc.applied), sum(sc.admitted), count(student.studentid)-sum(sc.admitted) from (select studentid, case when sum(applied) > 0 then 1 else sum(applied) end as "applied", case when sum(admitted) > 0 then 1 else sum(admitted) end as "admitted" from studentcollege group by studentid) sc right join student on student.studentid = sc.studentid

select StudentName, case when group_concat(College.CollegeName) is NULL then 'No Colleges' else group_concat(College.CollegeName) end as 'Applied College Name' from Student left join StudentCollege on StudentCollege.StudentID = Student.StudentID left join College on College.CollegeID = StudentCollege.CollegeID group by StudentName

select distinct studentenrollment.studentid, case when se2.NumberOfYears is null then 1 else se2.NumberOfYears end as 'Number of Years' from studentenrollment left join (SELECT studentenrollment.studentID, count(studentenrollment.StudentID)+1 as NumberOfYears FROM   Studentenrollment left JOIN studentenrollment e2 on studentenrollment.studentID = e2.studentID WHERE  e2.enrollmentyear = (studentenrollment.enrollmentyear + 1) group by studentenrollment.studentID) se2 on se2.studentid = studentenrollment.studentid
