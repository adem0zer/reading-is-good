package com.adem.readingisgood.validation;

import com.adem.readingisgood.common.Utility;
import com.adem.readingisgood.dto.ErrorMessage;
import com.adem.readingisgood.dto.UserDto;
import com.adem.readingisgood.exception.BadRequest;
import com.adem.readingisgood.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CreateCustomerValidation implements BaseValidation {
    private final UserRepository userRepository;

    @Override
    public void valid(Object... valid) {
        UserDto userDto = (UserDto) valid[0];
        StringBuilder error = new StringBuilder();
        if (Objects.isNull(userDto)) {
            error.append("You cannot create a user\n");
        }
        if (Objects.nonNull(userDto.getId())) {
            error.append("You cannot update user\n");
        }
        boolean validate = Utility.validate(userDto.getEmail(), Utility.VALID_EMAIL_ADDRESS_REGEX);
        if (validate) {
            boolean isEmailExist = userRepository.existsByEmail(userDto.getEmail());
            if (isEmailExist) {
                error.append("This email already exist\n");
            }
        } else {
            error.append("Email is not valid\n");
        }

        if (Strings.isNotEmpty(error.toString()))
            throw new BadRequest(error.toString());

    }
}
