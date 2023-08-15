select t.NAME profesor,
	sig.NAME asignatura,
	(
	select avg(g.VALUE) promedio_curso
	from STUDENT s,
		STUDENT_SIGNATURE ss,
		GRADE g,
		SIGNATURE sig ,
		TEACHER t
	where s.ID = ss.STUDENT_ID
	and ss.SIGNATURE_ID = sig.ID
	and g.SIGNATURE_ID = sig.ID
	and g.STUDENT_ID =s.ID
	and t.ID = sig.TEACHER_ID
	and sig.ID =1
	) promedio,
	s.NAME estudiante,
	g.VALUE nota
from STUDENT s,
	STUDENT_SIGNATURE ss,
	GRADE g,
	SIGNATURE sig ,
	TEACHER t
where g.VALUE  = (
	 select max(g.VALUE) nota
		from STUDENT s,
			STUDENT_SIGNATURE ss,
			GRADE g,
			SIGNATURE sig ,
			TEACHER t
		where s.ID = ss.STUDENT_ID
		and ss.SIGNATURE_ID = sig.ID
		and g.SIGNATURE_ID = sig.ID
		and g.STUDENT_ID =s.ID
		and t.ID = sig.TEACHER_ID
		and sig.ID =1
)
and s.ID = ss.STUDENT_ID
and ss.SIGNATURE_ID = sig.ID
and g.SIGNATURE_ID = sig.ID
and g.STUDENT_ID =s.ID
and t.ID = sig.TEACHER_ID
and sig.ID =1
group by profesor, asignatura, estudiante, nota
order by nota desc

;