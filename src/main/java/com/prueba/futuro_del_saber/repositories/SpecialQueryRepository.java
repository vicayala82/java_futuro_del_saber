package com.prueba.futuro_del_saber.repositories;

import com.prueba.futuro_del_saber.vo.OverAverageStudentResponseVO;

import java.util.Set;

public interface SpecialQueryRepository {
    Set<OverAverageStudentResponseVO> overAverageStudents();
}
