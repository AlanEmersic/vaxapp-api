package hr.tvz.emersic.vaxapp.service;

import hr.tvz.emersic.vaxapp.DTO.SideEffectDTO;
import hr.tvz.emersic.vaxapp.model.SideEffect;
import hr.tvz.emersic.vaxapp.repository.SideEffectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SideEffectServiceImpl implements SideEffectService {
    private final SideEffectRepository sideEffectRepository;

    public SideEffectServiceImpl(SideEffectRepository sideEffectRepository) {
        this.sideEffectRepository = sideEffectRepository;
    }

    @Override
    public List<SideEffectDTO> findAll() {
        return sideEffectRepository.findAll().stream().map(this::mapSideEffectToDTO).collect(Collectors.toList());
    }

    @Override
    public List<SideEffectDTO> findAllByResearchName(String researchName) {
        return sideEffectRepository.findAllByIgnoreCaseVaccine_ResearchName(researchName.toLowerCase()).stream().
                map(this::mapSideEffectToDTO).collect(Collectors.toList());
    }

    @Override
    public SideEffectDTO findSideEffectByResearchName(String researchName) {
        return mapSideEffectToDTO(sideEffectRepository.findSideEffectByIgnoreCaseVaccine_ResearchName(researchName.toLowerCase()));
    }

    @Override
    public SideEffectDTO findSideEffectByShortDescription(String shortDescription) {
        return mapSideEffectToDTO(sideEffectRepository.findSideEffectByIgnoreCaseShortDescription(shortDescription.toLowerCase()));
    }

    private SideEffectDTO mapSideEffectToDTO(SideEffect sideEffect) {
        return new SideEffectDTO(sideEffect.getShortDescription(), sideEffect.getDescription(), sideEffect.getFrequency());
    }
}
