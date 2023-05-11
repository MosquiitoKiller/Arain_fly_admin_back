package ru.mosquiito.services;

import io.micronaut.context.annotation.Value;
import jakarta.inject.Inject;
import ru.mosquiito.clients.MainAppClient;
import ru.mosquiito.dto.AccountDto;
import ru.mosquiito.dto.LoginRequestDto;
import ru.mosquiito.dto.LoginResponseDto;

import java.util.List;

public class AdminService {

    private final String AUTHORIZATION_HEADER = "Bearer %s";

    @Value("${login.username}")
    private String username;

    @Value("${login.password}")
    private String password;

    @Inject
    private MainAppClient mainAppClient;

    public List<AccountDto> getAllUsers() {
        LoginResponseDto loginResponseDto = mainAppClient.login(new LoginRequestDto(username, password));
        return mainAppClient.getAllUsers(String.format(AUTHORIZATION_HEADER,loginResponseDto.getAccessToken()));
    }

    public boolean blockUser(Long id) {
        LoginResponseDto loginResponseDto = mainAppClient.login(new LoginRequestDto(username, password));
        return mainAppClient.blockUser(String.format(AUTHORIZATION_HEADER,loginResponseDto.getAccessToken()), id);
    }
}
