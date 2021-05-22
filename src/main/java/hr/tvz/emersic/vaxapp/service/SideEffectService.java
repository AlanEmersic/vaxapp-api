package hr.tvz.emersic.vaxapp.service;

import hr.tvz.emersic.vaxapp.DTO.SideEffectDTO;

import java.util.List;

public interface SideEffectService
{
    List<SideEffectDTO> findAll();

    List<SideEffectDTO> findAllByResearchName(String researchName);

    SideEffectDTO findSideEffectByResearchName(String researchName);

    SideEffectDTO findSideEffectByShortDescription(String shortDescription);
}
