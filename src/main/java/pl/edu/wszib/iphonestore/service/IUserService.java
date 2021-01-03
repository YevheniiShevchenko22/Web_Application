package pl.edu.wszib.iphonestore.service;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.wszib.iphonestore.model.User;
import pl.edu.wszib.iphonestore.model.view.RegisterModel;

/**
 * Created by Yevhenii Shevchenko at ${DATE}
 * Project name: ${PROJECT_NAME}
 **/

public interface IUserService {

    void authenticate(User user);

    void  logout();

    boolean register(RegisterModel registerModel);
}
