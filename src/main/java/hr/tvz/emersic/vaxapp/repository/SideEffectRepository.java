package hr.tvz.emersic.vaxapp.repository;

import hr.tvz.emersic.vaxapp.model.SideEffect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SideEffectRepository extends JpaRepository<SideEffect, Long> {
    List<SideEffect> findAllByIgnoreCaseVaccine_ResearchName(String researchName);

    SideEffect findSideEffectByIgnoreCaseVaccine_ResearchName(String researchName);

    SideEffect findSideEffectByIgnoreCaseShortDescription(String shortDescription);
}
