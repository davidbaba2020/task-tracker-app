package com.decadave.tasktrackerapp.services.serviceImpl;

import com.decadave.tasktrackerapp.exception.UserWithEmailExistAlready;
import com.decadave.tasktrackerapp.models.UserOfApp;
import com.decadave.tasktrackerapp.repository.UserOfAppRepository;
import com.decadave.tasktrackerapp.services.UserOfAppService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserOfAppServiceImpl implements UserOfAppService {

    private final UserOfAppRepository userOfAppRepository;

    @Override
    public String saveNewAppUser(UserOfApp userOfApp) {
        String msg;
        Optional<UserOfApp> checkUser = userOfAppRepository.findByEmail(userOfApp.getEmail());
        if(checkUser.isPresent()){
            throw new UserWithEmailExistAlready("User with this email already exist, log in or use another email");
        }else {
            userOfAppRepository.save(userOfApp);
            msg = "YOU HAVE SUCCESSFULLY REGISTERED";
        }
        return msg;
    }
}
