package pl.edu.wszib.iphonestore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.wszib.iphonestore.model.User;

/**
 * Created by Yevhenii Shevchenko at ${DATE}
 * Project name: ${PROJECT_NAME}
 **/
public interface ICreateAdminAccount extends JpaRepository<User, Integer> {
}
