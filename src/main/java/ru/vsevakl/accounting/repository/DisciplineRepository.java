package ru.vsevakl.accounting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsevakl.accounting.domain.Discipline;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
}