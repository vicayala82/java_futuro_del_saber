select t.NAME profesor, c.LEVEL_COURSE curso , sig.NAME asignatura,
(select avg(g.VALUE)
	from GRADE g
	join STUDENT s on s.ID =g.STUDENT_ID
	join SIGNATURE sig on sig.ID = g.SIGNATURE_ID
	join TEACHER t on T.ID = sig.TEACHER_ID
	join COURSE c on c.ID = s.COURSE_ID
	where g.STUDENT_ID = s.ID
	and c.ID = s.COURSE_ID
	and g.SIGNATURE_ID = sig.ID
	and t.ID = sig.TEACHER_ID) promedio_curso
, s.NAME estudiante, g.VALUE nota
from GRADE g
join STUDENT s on s.ID =g.STUDENT_ID
join SIGNATURE sig on sig.ID = g.SIGNATURE_ID
join TEACHER t on T.ID = sig.TEACHER_ID
join COURSE c on c.ID = s.COURSE_ID
where g.VALUE > (
	select avg(g.VALUE)
	from GRADE g
	join STUDENT s on s.ID =g.STUDENT_ID
	join SIGNATURE sig on sig.ID = g.SIGNATURE_ID
	join TEACHER t on T.ID = sig.TEACHER_ID
	join COURSE c on c.ID = s.COURSE_ID
	where g.STUDENT_ID = s.ID
	and c.ID = s.COURSE_ID
	and g.SIGNATURE_ID = sig.ID
	and t.ID = sig.TEACHER_ID
)
group by curso, asignatura, profesor, estudiante, nota
order by asignatura asc, g.VALUE asc
;

