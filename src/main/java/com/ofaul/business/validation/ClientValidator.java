package com.ofaul.business.validation;

import org.springframework.stereotype.Component;

import com.ofaul.business.entity.Client;

import static com.ofaul.business.util.ConstMessagesEN.ValidationMessages.PESEL_LENGTH_INCORRECT;
import static com.ofaul.business.util.ConstMessagesEN.ValidationMessages.REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA;

import java.util.Optional;

@Component
public class ClientValidator extends ValidationSupport implements Validator<Client> {

    private static final int PESEL_LENGTH = 11;

    @Override
    public Optional<ValidationError> validate(Client client) {
        if (isNullOrEmptyString(client.getName()) ||
                isNullOrEmptyString(client.getSurname()) ||
                isNullOrEmptyString(client.getPesel()) ||
                isNullOrEmptyString(client.getPhoneNumber()) ||
                isNullOrEmptyString(client.getEmail())) {
            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA));
        }
        if (PESEL_LENGTH != client.getPesel().length()) {
            return Optional.of(new ValidationError(PESEL_LENGTH_INCORRECT));
        }
        return Optional.empty();
    }

}
