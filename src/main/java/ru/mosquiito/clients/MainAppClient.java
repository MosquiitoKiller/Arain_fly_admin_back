package ru.mosquiito.clients;

import io.micronaut.http.annotation.*;
import io.micronaut.http.client.annotation.Client;
import ru.mosquiito.dto.AccountDto;
import ru.mosquiito.dto.LoginRequestDto;
import ru.mosquiito.dto.LoginResponseDto;

import java.util.List;

@Client("http://localhost:8080")
public interface MainAppClient {
    @Post("/login")
    LoginResponseDto login(@Body LoginRequestDto authenticationRequest);

    @Get("/admin/allUsers")
    List<AccountDto> getAllUsers(@Header(name = "Authorization") String authorization);

    @Delete("/admin/user/{id}")
    boolean blockUser(@Header(name = "Authorization") String authorization, @PathVariable Long id);
}
