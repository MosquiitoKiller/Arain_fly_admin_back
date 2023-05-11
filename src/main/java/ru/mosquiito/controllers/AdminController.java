package ru.mosquiito.controllers;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import jakarta.inject.Inject;
import ru.mosquiito.dto.AccountDto;
import ru.mosquiito.services.AdminService;

import java.util.List;

@Controller
public class AdminController {
    @Inject
    private AdminService adminService;

    @Get("/allUsers")
    public List<AccountDto> getAllUsers(){
        return adminService.getAllUsers();
    }

    @Delete("/blockUser/{id}")
    public boolean blockUser(@PathVariable Long id){
        return adminService.blockUser(id);
    }
}
