package hr.tvz.emersic.vaxapp.service;

import hr.tvz.emersic.vaxapp.DTO.UserDTO;

import java.util.Optional;

public interface UserService {
    Optional<UserDTO> findByUsername(String username);
}
