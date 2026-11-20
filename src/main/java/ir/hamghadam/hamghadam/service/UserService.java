package ir.hamghadam.hamghadam.service;

import ir.hamghadam.hamghadam.database.jpa.User;
import ir.hamghadam.hamghadam.database.repository.UserRepository;
import ir.hamghadam.hamghadam.dto.UserDto;
import ir.hamghadam.hamghadam.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDto create(UserDto dto) {
        User user = new User();
        UserMapper.mergeInto(dto, user);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        return UserMapper.toDto(userRepository.save(user));
    }

    @Transactional(readOnly = true)
    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDto)
                .toList();
    }

    @Transactional
    public UserDto findById(UUID id) {
        return UserMapper.toDto(userRepository.findById(id).orElse(null));
    }

    @Transactional
    public UserDto update(UUID id, UserDto dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "user.not.found"
                ));
        UserMapper.mergeInto(dto, user);
        return UserMapper.toDto(userRepository.save(user));
    }

    @Transactional
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }


}
