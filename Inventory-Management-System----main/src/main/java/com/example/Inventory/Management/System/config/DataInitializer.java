package com.example.Inventory.Management.System.config;

import com.example.Inventory.Management.System.entity.Category;
import com.example.Inventory.Management.System.entity.Role;
import com.example.Inventory.Management.System.entity.User;
import com.example.Inventory.Management.System.repository.CategoryRepository;
import com.example.Inventory.Management.System.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        // Create default users with different roles
        if (userRepository.count() == 0) {
            User admin = User.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("admin123"))
                    .role(Role.ROLE_ADMIN)
                    .build();
            userRepository.save(admin);
            
            User manager = User.builder()
                    .username("manager")
                    .password(passwordEncoder.encode("manager123"))
                    .role(Role.ROLE_MANAGER)
                    .build();
            userRepository.save(manager);
            
            User staff = User.builder()
                    .username("staff")
                    .password(passwordEncoder.encode("staff123"))
                    .role(Role.ROLE_STAFF)
                    .build();
            userRepository.save(staff);
            
            System.out.println("✅ Default users created:");
            System.out.println("   - Admin: admin / admin123");
            System.out.println("   - Manager: manager / manager123");
            System.out.println("   - Staff: staff / staff123");   
            }
        if (!userRepository.existsByUsername("sales")) {
            User sales = User.builder()
                    .username("sales")
                    .password(passwordEncoder.encode("sales123"))
                    .role(Role.ROLE_SALES)
                    .build();

            userRepository.save(sales);
            
            System.out.println("   - Sales: sales / sales123");
        }
        if (!userRepository.existsByUsername("supervisor")) {

            User supervisor = User.builder()
                    .username("supervisor")
                    .password(passwordEncoder.encode("supervisor123"))
                    .role(Role.ROLE_MANAGER)
                    .build();

            userRepository.save(supervisor);

            System.out.println("   - Supervisor: supervisor / supervisor123");
        }


        // Create default categories
        if (categoryRepository.count() == 0) {
            String[] categoryNames = {
                "Electronics", "Furniture", "Clothing", "Food & Beverages", 
                "Books", "Toys", "Sports", "Office Supplies"
            };
            
            String[] descriptions = {
                "Electronic devices and accessories",
                "Home and office furniture",
                "Apparel and fashion items",
                "Food products and drinks",
                "Books and publications",
                "Toys and games",
                "Sports equipment and gear",
                "Office and stationery supplies"
            };

            for (int i = 0; i < categoryNames.length; i++) {
                Category category = Category.builder()
                        .name(categoryNames[i])
                        .description(descriptions[i])
                        .build();
                categoryRepository.save(category);
            }
            System.out.println("✅ Default categories created (" + categoryNames.length + " categories)");
        }
    }
}
